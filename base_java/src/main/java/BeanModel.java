import java.io.Serializable;

/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 ******************************************************************************/

/**
 * FIXME ��ע����Ϣ
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-03-23
 */
public class BeanModel implements Serializable, Cloneable {

	private String name;
	private String age;

	private Integer count;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	public BeanModel clone() {
		BeanModel o = null;
		try {
			o = (BeanModel) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}
 