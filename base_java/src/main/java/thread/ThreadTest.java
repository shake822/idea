/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-28
 */
public class ThreadTest {

	/**
	 * FIXME 方法注释信息
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0L,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize()
					+ "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

}
