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
 * @date 2021-12-08 15:08:32
 */
@Data
@TableName("goods")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品编号
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 人气
	 */
	private Integer pop;
	/**
	 * 商品简介
	 */
	private String intro;
	/**
	 * 图片
	 */
	private String picture;
	/**
	 * 类型id
	 */
	private Integer smallsortid;
	/**
	 * 二手
	 */
	private BigDecimal secprice;
	/**
	 * 新旧程度
	 */
	private String oldandnew;
	/**
	 * 卖家名称(外键)
	 */
	private String sellName;

}
