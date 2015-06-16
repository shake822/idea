import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
 * @createDate 2015-03-17
 */
public class CalendarTest {
	/**
	 * 
	 * FIXME ����ע����Ϣ
	 * 
	 * @param args
	 *            SD
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date(2015, 3, 1));
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.SECOND,0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(cal.getTime()));
		
		
		Date date = new Date(60000*60*8+4000); 
		System.out.println(date.getTimezoneOffset());
		System.out.println(date.getHours());
		SimpleDateFormat aFormat = new SimpleDateFormat(":mm:ss"); 
		System.out.println(aFormat.format(date)); 
		
		int hours = date.getHours()-8;
		if(hours<0){
			hours = hours+24;
		}
//		int i=0;
		System.out.println(hours+aFormat.format(date)); 
	}
 
}
