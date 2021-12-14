package cn.itcast.controller;

import cn.itcast.entity.DingdanEntity;
import cn.itcast.service.DingdanService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@RestController
@RequestMapping("dingdan/dingdan")
public class DingdanController {
    @Autowired
    private DingdanService dingdanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dingdan:dingdan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dingdanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dingdan:dingdan:info")
    public R info(@PathVariable("id") Integer id){
		DingdanEntity dingdan = dingdanService.getById(id);

        return R.ok().put("dingdan", dingdan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dingdan:dingdan:save")
    public R save(@RequestBody DingdanEntity dingdan){
		dingdanService.save(dingdan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dingdan:dingdan:update")
    public R update(@RequestBody DingdanEntity dingdan){
		dingdanService.updateById(dingdan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dingdan:dingdan:delete")
    public R delete(@RequestBody Integer[] ids){
		dingdanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
