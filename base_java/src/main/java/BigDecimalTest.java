import java.math.BigDecimal;

/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 ******************************************************************************/

/**
 * FIXME ��ע����Ϣ

 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-03-31 
 */
public class BigDecimalTest {

	/**
	 * FIXME ����ע����Ϣ
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
