/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 ******************************************************************************/
package wftt;

import java.util.List;

/**
 * FIXME ��ע����Ϣ
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-05-05
 */
public class WFTrackTableBean {
	/**
	 * 
	 */
	private String approveDate;

	/**
	 * 
	 */
	private List<WFTrackTableNodeBean> nodes;

	/**
	 * @return the approveDate
	 */
	public String getApproveDate() {
		return approveDate;
	}

	/**
	 * @param approveDate the approveDate to set
	 */
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * @return the nodes
	 */
	public List<WFTrackTableNodeBean> getNodes() {
		return nodes;
	}

	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<WFTrackTableNodeBean> nodes) {
		this.nodes = nodes;
	}
	
	
}
