package cn.itcast.service;

import cn.itcast.entity.DingdanReturnApplyEntity;
import cn.itcast.xianyu.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
public interface DingdanReturnApplyService extends IService<DingdanReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

