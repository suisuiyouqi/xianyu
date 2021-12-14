package cn.itcast.xianyu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Data
@TableName("dingdan")
public class DingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单编号
	 */
	@TableId
	private Integer id;
	/**
	 * 买家名称
	 */
	private String purchaseUsername;
	/**
	 * 卖家名称
	 */
	private String sellUsername;
	/**
	 * 收货人名称
	 */
	private String receiverName;
	/**
	 * 收货地址
	 */
	private String receiverAddress;
	/**
	 * 收货电话
	 */
	private String receiverPhone;
	/**
	 * 邮箱
	 */
	private String receiverEmail;
	/**
	 * 订单生成时间
	 */
	private Date orderTime;
	/**
	 * 订单总价
	 */
	private BigDecimal cost;
	/**
	 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	 */
	private String status;
	/**
	 * 配送方式
	 */
	private String send;
	/**
	 * 支付方式支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
	 */
	private Integer payType;
	/**
	 * 物流单号
	 */
	private String deliverySn;
	/**
	 * 物流公司
	 */
	private String deliveryCompany;
	/**
	 * 应付金额
	 */
	private BigDecimal payAmount;
	/**
	 * 运费金额
	 */
	private BigDecimal freightAmount;

}
