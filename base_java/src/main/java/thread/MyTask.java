/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package thread;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-28
 */
public class MyTask implements Runnable {

	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	public void run() {
		System.out.println("正在执行task " + taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}

}
