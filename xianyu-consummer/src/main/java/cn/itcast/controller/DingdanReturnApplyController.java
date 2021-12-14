package cn.itcast.controller;

import cn.itcast.entity.DingdanReturnApplyEntity;
import cn.itcast.service.DingdanReturnApplyService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 订单退货申请
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@RestController
@RequestMapping("dingdan/dingdanreturnapply")
public class DingdanReturnApplyController {
    @Autowired
    private DingdanReturnApplyService dingdanReturnApplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dingdan:dingdanreturnapply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dingdanReturnApplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{returnId}")
    @RequiresPermissions("dingdan:dingdanreturnapply:info")
    public R info(@PathVariable("returnId") Long returnId){
		DingdanReturnApplyEntity dingdanReturnApply = dingdanReturnApplyService.getById(returnId);

        return R.ok().put("dingdanReturnApply", dingdanReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dingdan:dingdanreturnapply:save")
    public R save(@RequestBody DingdanReturnApplyEntity dingdanReturnApply){
		dingdanReturnApplyService.save(dingdanReturnApply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dingdan:dingdanreturnapply:update")
    public R update(@RequestBody DingdanReturnApplyEntity dingdanReturnApply){
		dingdanReturnApplyService.updateById(dingdanReturnApply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dingdan:dingdanreturnapply:delete")
    public R delete(@RequestBody Long[] returnIds){
		dingdanReturnApplyService.removeByIds(Arrays.asList(returnIds));

        return R.ok();
    }

}
