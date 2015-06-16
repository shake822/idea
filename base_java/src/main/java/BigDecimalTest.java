import java.math.BigDecimal;

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
 * @createDate 2015-03-31 
 */
public class BigDecimalTest {

	/**
	 * FIXME 方法注释信息
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal s = new BigDecimal(3);
		s = s.add(new BigDecimal(2));
		System.out.println(s.intValue());
		BigDecimal te = new BigDecimal(2.3655454);
		te= te.setScale(2, BigDecimal.ROUND_DOWN);
		System.out.println(te.toString());
	}

}
