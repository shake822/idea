/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 ******************************************************************************/
package wftt;

import java.util.ArrayList;
import java.util.List;

/**
 * FIXME ��ע����Ϣ

 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-05 
 */
public class TestMain {

	/**
	 *
	 * @param args args
	 */
	public static void main(String[] args) {
		List<WFTrackTableBean> data = new ArrayList<WFTrackTableBean>();
		WFTrackTableBean d1= new WFTrackTableBean();
		d1.setApproveDate("2015-05-01");
		List<WFTrackTableNodeBean> d1_nodes = new ArrayList<WFTrackTableNodeBean>();
		WFTrackTableNodeBean d1_node1 = new WFTrackTableNodeBean();
		d1_node1.setApproveText("ͬ�⣬����Ҫע��ɹ����");
		d1_node1.setUserName("��ҫ��");
		d1_node1.setApproveTime("14:22");
		d1_node1.setNodeName("�����ϱ�");
		d1_node1.setUsedTime("1Сʱ4����");
		d1_node1.setNodeState("�����");
		d1_nodes.add(d1_node1);
		
		WFTrackTableNodeBean d1_node2 = new WFTrackTableNodeBean();
		d1_node2.setApproveText("ͬ�⣬��������Ӧ����ϵ�����Ƿ��л�");
		d1_node2.setUserName("�̺�");
		d1_node2.setApproveTime("17:30");
		d1_node2.setNodeName("��������������");
		d1_node2.setUsedTime("3Сʱ4����");
		d1_node2.setNodeState("�����");
		d1_nodes.add(d1_node2);
		
		d1.setNodes(d1_nodes);
		data.add(d1);
		
		
		
		WFTrackTableBean d2= new WFTrackTableBean();
		d2.setApproveDate("2015-05-03");
		List<WFTrackTableNodeBean> d2_nodes = new ArrayList<WFTrackTableNodeBean>();
		WFTrackTableNodeBean d2_node1 = new WFTrackTableNodeBean();
		d2_node1.setApproveText("��ͬ�⣬��ĵ���ʱ�䣬�Ѿ���������");
		d2_node1.setUserName("�����");
		d2_node1.setApproveTime("14:00");
		d2_node1.setNodeName("�ɹ�������������");
		d2_node1.setUsedTime("28Сʱ4����");
		d2_node1.setNodeState("�Ѿܾ�");
		d2_nodes.add(d2_node1);
		
		d2.setNodes(d2_nodes);
		data.add(d2);
		
//		System.out.println(JsonUtil.objectToJson(data));
	}

}
