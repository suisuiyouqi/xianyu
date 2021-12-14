package cn.itcast.controller;


import cn.itcast.entity.DingdanDetailsEntity;
import cn.itcast.service.DingdanDetailsService;
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
@RequestMapping("dingdan/dingdandetails")
public class DingdanDetailsController {
    @Autowired
    private DingdanDetailsService dingdanDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dingdan:dingdandetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dingdanDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{contentId}")
    @RequiresPermissions("dingdan:dingdandetails:info")
    public R info(@PathVariable("contentId") Integer contentId){
		DingdanDetailsEntity dingdanDetails = dingdanDetailsService.getById(contentId);

        return R.ok().put("dingdanDetails", dingdanDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dingdan:dingdandetails:save")
    public R save(@RequestBody DingdanDetailsEntity dingdanDetails){
		dingdanDetailsService.save(dingdanDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dingdan:dingdandetails:update")
    public R update(@RequestBody DingdanDetailsEntity dingdanDetails){
		dingdanDetailsService.updateById(dingdanDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dingdan:dingdandetails:delete")
    public R delete(@RequestBody Integer[] contentIds){
		dingdanDetailsService.removeByIds(Arrays.asList(contentIds));

        return R.ok();
    }

}
