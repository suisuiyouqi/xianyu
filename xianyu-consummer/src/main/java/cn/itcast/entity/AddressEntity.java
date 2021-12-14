package cn.itcast.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 09:41:21
 */
@Data
@TableName("address")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 外键用户id
	 */
	private Integer userId;
	/**
	 * 收件人姓名
	 */
	private String uName;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * id
	 */
	@TableId
	private Integer addressId;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区
	 */
	private String district;
	/**
	 * 详细地址
	 */
	private String detail;
	/**
	 * 收件人id
	 */
	private Integer uid;

}
