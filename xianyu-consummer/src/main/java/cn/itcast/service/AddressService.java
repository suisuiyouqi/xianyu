package cn.itcast.service;

import cn.itcast.entity.AddressEntity;
import cn.itcast.xianyu.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 09:41:21
 */

public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

