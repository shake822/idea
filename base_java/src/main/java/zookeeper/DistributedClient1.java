/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package zookeeper;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-11
 */
public class DistributedClient1 {
	// 超时时间
	private static final int SESSION_TIMEOUT = 5000;
	// zookeeper server列表
	private String groupNode = "locks";
	private String subNode = "sub";

	private ZooKeeper zk;
	// 当前client创建的子节点
	private volatile String thisPath;

	private CountDownLatch latch = new CountDownLatch(1);

	/**
	 * 连接zookeeper
	 */
	public void connectZookeeper() throws Exception {
		zk = new ZooKeeper(ZooKeeperHelper.SERVER_ADDRS, SESSION_TIMEOUT,
				new Watcher() {
					public void process(WatchedEvent event) {
						try {
							// 连接建立时, 打开latch, 唤醒wait在该latch上的线程
							if (event.getState() == KeeperState.SyncConnected) {
								latch.countDown();
							}

							// 子节点发生变化
							if (event.getType() == EventType.NodeChildrenChanged
									&& event.getPath().equals("/" + groupNode)) {
								// thisPath是否是列表中的最小节点
								List<String> childrenNodes = zk.getChildren("/"
										+ groupNode, true);
								String thisNode = thisPath.substring(("/"
										+ groupNode + "/").length());
								// 排序
								Collections.sort(childrenNodes);
								if (childrenNodes.indexOf(thisNode) == 0) {
									doSomething();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

		// 等待连接建立
		latch.await();

		// 创建子节点
		thisPath = zk.create("/" + groupNode + "/" + subNode, null,
				Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

		// wait一小会, 让结果更清晰一些
		Thread.sleep(10);

		// 监听子节点的变化
		List<String> childrenNodes = zk.getChildren("/" + groupNode, true);

		// 列表中只有一个子节点, 那肯定就是thisPath, 说明client获得锁
		if (childrenNodes.size() == 1) {
			doSomething();
		}
	}

	/**
	 * 共享资源的访问逻辑写在这个方法中
	 */
	private void doSomething() throws Exception {
		try {
			System.out.println("gain lock: " + thisPath);
			Thread.sleep(2000);
			// do something
		} finally {
			System.out.println("finished: " + thisPath);
			// 将thisPath删除, 监听thisPath的client将获得通知
			// 相当于释放锁
			zk.delete(this.thisPath, -1);
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						DistributedClient1 dl = new DistributedClient1();
						dl.connectZookeeper();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

		Thread.sleep(Long.MAX_VALUE);
	}

}
