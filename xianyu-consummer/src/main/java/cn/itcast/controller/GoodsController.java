package cn.itcast.controller;

import cn.itcast.entity.GoodsEntity;
import cn.itcast.service.GoodsService;
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
 * @date 2021-12-08 15:08:32
 */
@RestController
@RequestMapping("goodsgoods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goods:goods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsId}")
    @RequiresPermissions("goods:goods:info")
    public R info(@PathVariable("goodsId") Integer goodsId){
		GoodsEntity goods = goodsService.getById(goodsId);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goods:goods:save")
    public R save(@RequestBody GoodsEntity goods){
		goodsService.save(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goods:goods:update")
    public R update(@RequestBody GoodsEntity goods){
		goodsService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goods:delete")
    public R delete(@RequestBody Integer[] goodsIds){
		goodsService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
