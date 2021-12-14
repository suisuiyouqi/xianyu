package cn.itcast.service.impl;

import cn.itcast.entity.DingdanEntity;
import cn.itcast.mapper.DingdanDao;
import cn.itcast.service.DingdanService;
import cn.itcast.xianyu.utils.PageUtils;
import cn.itcast.xianyu.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("dingdanService")
public class DingdanServiceImpl extends ServiceImpl<DingdanDao, DingdanEntity> implements DingdanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DingdanEntity> page = this.page(
                new Query<DingdanEntity>().getPage(params),
                new QueryWrapper<DingdanEntity>()
        );

        return new PageUtils(page);
    }

}