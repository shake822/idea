/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-11
 */
public class BasicDemo {

	/**
	 * FIXME 方法注释信息
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException, KeeperException,
			InterruptedException {
		// TODO Auto-generated method stub
		ZooKeeper zk = new ZooKeeper(
				"10.10.50.188:2181,10.10.50.188:12181,10.10.50.188:22181",
				60000, new Watcher() {
					// 监控所有被触发的事件
					public void process(WatchedEvent event) {
						System.out.println("EVENT:" + event.getType());
					}
				});

		Thread.sleep(10000);
		// 查看根节点
		System.out.println("ls / => " + zk.getChildren("/", true));

		// 创建一个目录节点
		if (zk.exists("/node", true) == null) {
			zk.create("/node", "conan".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
			System.out.println("create /node conan");
			// 查看/node节点数据
			System.out.println("get /node => "
					+ new String(zk.getData("/node", false, null)));
			// 查看根节点
			System.out.println("ls / => " + zk.getChildren("/", true));
		}

		// 创建一个子目录节点
		if (zk.exists("/node/sub1", true) == null) {
			zk.create("/node/sub1", "sub1".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
			System.out.println("create /node/sub1 sub1");
			// 查看node节点
			System.out.println("ls /node => " + zk.getChildren("/node", true));
		}

		// 修改节点数据
		if (zk.exists("/node", true) != null) {
			zk.setData("/node", "changed".getBytes(), -1);
			// 查看/node节点数据
			System.out.println("get /node => "
					+ new String(zk.getData("/node", false, null)));
		}

		// 删除节点
		if (zk.exists("/node/sub1", true) != null) {
			zk.delete("/node/sub1", -1);
			zk.delete("/node", -1);
			// 查看根节点
			System.out.println("ls / => " + zk.getChildren("/", true));
		}

		// 关闭连接
		zk.close();
	}

}
