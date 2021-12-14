package cn.itcast.xianyu.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-13 09:23:07
 */
@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	@TableField(exist=false)
	private List<Long> menuIdList;
	/**
	 * 创建时间
	 */
	@DateTimeFormat( pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}
