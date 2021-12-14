package cn.itcast.controller;

import cn.itcast.entity.AddressEntity;
import cn.itcast.service.AddressService;
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
 * @date 2021-12-10 09:41:21
 */
@RestController
@RequestMapping("dingdan/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dingdan:address:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = addressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{addressId}")
    @RequiresPermissions("dingdan:address:info")
    public R info(@PathVariable("addressId") Integer addressId){
		AddressEntity address = addressService.getById(addressId);

        return R.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dingdan:address:save")
    public R save(@RequestBody AddressEntity address){
		addressService.save(address);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dingdan:address:update")
    public R update(@RequestBody AddressEntity address){
		addressService.updateById(address);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dingdan:address:delete")
    public R delete(@RequestBody Integer[] addressIds){
		addressService.removeByIds(Arrays.asList(addressIds));

        return R.ok();
    }

}
