/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package wftt;

import java.util.List;

/**
 * FIXME 类注释信息
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
