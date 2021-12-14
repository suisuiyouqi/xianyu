package cn.itcast.xianyu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单退货申请
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Data
@TableName("dingdan_return_apply")
public class DingdanReturnApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 退款id
	 */
	@TableId
	private Long returnId;
	/**
	 * order_id
	 */
	private Long id;
	/**
	 * 退货商品id
	 */
	private Long goodsId;
	/**
	 * 订单编号
	 */
	private String orderSn;
	/**
	 * 申请时间
	 */
	private Date createTime;
	/**
	 * 退款金额
	 */
	private BigDecimal returnAmount;
	/**
	 * 退货人姓名
	 */
	private String returnName;
	/**
	 * 退货人电话
	 */
	private String returnPhone;
	/**
	 * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
	 */
	private Integer status;
	/**
	 * 处理时间
	 */
	private Date handleTime;
	/**
	 * 商品单价
	 */
	private BigDecimal price;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 凭证图片，以逗号隔开
	 */
	private String descPics;
	/**
	 * 处理备注
	 */
	private String handleNote;
	/**
	 * 处理人员
	 */
	private String handleMan;
	/**
	 * 收货人
	 */
	private String receiveMan;
	/**
	 * 收货时间
	 */
	private Date receiveTime;
	/**
	 * 收货备注
	 */
	private String receiveNote;
	/**
	 * 收货电话
	 */
	private String receivePhone;
	/**
	 * 公司收货地址
	 */
	private String companyAddress;

}
