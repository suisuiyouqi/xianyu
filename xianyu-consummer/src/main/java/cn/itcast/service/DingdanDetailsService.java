package cn.itcast.service;

import cn.itcast.entity.DingdanDetailsEntity;
import cn.itcast.xianyu.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
public interface DingdanDetailsService extends IService<DingdanDetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

