package cn.itcast.service.impl;

import cn.itcast.entity.DingdanDetailsEntity;
import cn.itcast.mapper.DingdanDetailsDao;
import cn.itcast.service.DingdanDetailsService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("dingdanDetailsService")
public class DingdanDetailsServiceImpl extends ServiceImpl<DingdanDetailsDao, DingdanDetailsEntity> implements DingdanDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DingdanDetailsEntity> page = this.page(
                new Query<DingdanDetailsEntity>().getPage(params),
                new QueryWrapper<DingdanDetailsEntity>()
        );

        return new PageUtils(page);
    }

}