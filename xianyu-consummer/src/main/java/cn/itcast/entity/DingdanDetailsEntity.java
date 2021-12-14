package cn.itcast.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Data
@TableName("dingdan_details")
public class DingdanDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 详情编号
	 */
	@TableId
	private Integer contentId;
	/**
	 * 订单编号(外键)
	 */
	private Integer id;
	/**
	 * 商品编号(外键)
	 */
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品单价
	 */
	private BigDecimal goodsPrice;
	/**
	 * 商品总价
	 */
	private BigDecimal goodsNum;

}
