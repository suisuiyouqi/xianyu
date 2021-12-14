package cn.itcast.mapper;

import cn.itcast.entity.DingdanDetailsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Mapper
public interface DingdanDetailsDao extends BaseMapper<DingdanDetailsEntity> {
    /**
     * 查询所有订单详情表
     */
    List<DingdanDetailsEntity> queryAll();
    /**
     * 根据id查询订单详情表
     */
    List<DingdanDetailsEntity>queryAllId();

}
