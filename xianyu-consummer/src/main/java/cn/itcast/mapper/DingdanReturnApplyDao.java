package cn.itcast.mapper;

import cn.itcast.entity.DingdanReturnApplyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单退货申请
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Mapper
public interface DingdanReturnApplyDao extends BaseMapper<DingdanReturnApplyEntity> {
    /**
     * 根据id查询退款信息
     */
    List<DingdanReturnApplyEntity>queryAllId(Long returnId);
    /**
     * 查询所有退款信息
     */
    List<DingdanReturnApplyEntity>queryAll();

}
