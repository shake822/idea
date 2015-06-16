/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

/**
 * FIXME 类注释信息

 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-03-23 
 */
public class CloneTest {

	/**
	 * FIXME 方法注释信息
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BeanModel t = new BeanModel();
		t.setAge("13");
		t.setName("shake");
	
		System.out.println(t.getCount()<1);
		BeanModel t2 =t.clone();
		t.setName("ask");
		System.out.println(t2.getName());
		
	}

}
