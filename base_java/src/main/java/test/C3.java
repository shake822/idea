/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package test;

/**
 * FIXME 类注释信息
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-06-03
 */
public class C3 extends C2 {
	public C3() {
		System.out.print(3);
	}

	public static void main(String[] args) {
		C1 c = new C3();
		c.getClass();
		if (new Object() instanceof C1) {

		}
	}
}
