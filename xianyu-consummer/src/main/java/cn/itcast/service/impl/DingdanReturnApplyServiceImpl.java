package cn.itcast.service.impl;

import cn.itcast.entity.DingdanReturnApplyEntity;
import cn.itcast.mapper.DingdanReturnApplyDao;
import cn.itcast.service.DingdanReturnApplyService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("dingdanReturnApplyService")
public class DingdanReturnApplyServiceImpl extends ServiceImpl<DingdanReturnApplyDao, DingdanReturnApplyEntity> implements DingdanReturnApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DingdanReturnApplyEntity> page = this.page(
                new Query<DingdanReturnApplyEntity>().getPage(params),
                new QueryWrapper<DingdanReturnApplyEntity>()
        );

        return new PageUtils(page);
    }

}