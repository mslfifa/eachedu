package com.eachedu.pay.model;

/**
 * 订单基本信息
 * @author wzg
 *
 */
public class OrderInfo {
	/**订单ID**/
	private Long orderId;
	/**订单标题**/
	private String orderTitle;
	/**订单号:唯一***/
	private String orderNum;
	/**订单备注**/
	private String orderRemark;
	/**订单类型：1:问题;2:课件**/
	private Integer orderType;
	

}
