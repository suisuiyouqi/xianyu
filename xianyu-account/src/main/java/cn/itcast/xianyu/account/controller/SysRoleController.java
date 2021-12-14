package cn.itcast.xianyu.account.controller;

import cn.itcast.xianyu.account.entity.SysRoleEntity;
import cn.itcast.xianyu.account.service.SysRoleService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 角色
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-13 09:23:07
 */
@RestController
@RequestMapping("sys/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:sysrole:info")
    public R info(@PathVariable("roleId") Long roleId){
		SysRoleEntity sysRole = sysRoleService.getById(roleId);

        return R.ok().put("sysRole", sysRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysrole:save")
    public R save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysrole:update")
    public R update(@RequestBody SysRoleEntity sysRole){
		sysRoleService.updateById(sysRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysrole:delete")
    public R delete(@RequestBody Long[] roleIds){
		sysRoleService.removeByIds(Arrays.asList(roleIds));

        return R.ok();
    }

}
