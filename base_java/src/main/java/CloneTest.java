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
 * @createDate 2015-03-23 
 */
public class CloneTest {

	/**
	 * FIXME ����ע����Ϣ
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
