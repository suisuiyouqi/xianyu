package cn.itcast.xianyu.account.mapper;

import cn.itcast.xianyu.account.entity.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-13 09:23:07
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
	
}
