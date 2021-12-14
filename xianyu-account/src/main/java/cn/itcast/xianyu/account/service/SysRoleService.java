package cn.itcast.xianyu.account.service;

import cn.itcast.xianyu.account.entity.SysRoleEntity;
import cn.itcast.xianyu.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-13 09:23:07
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void saveRole(SysRoleEntity role);

    void update(SysRoleEntity role);

    void deleteBatch(Long[] roleIds);


    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}

