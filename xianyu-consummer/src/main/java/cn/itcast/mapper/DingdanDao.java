package cn.itcast.mapper;

import cn.itcast.entity.DingdanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 08:59:01
 */
@Mapper
public interface DingdanDao extends BaseMapper<DingdanEntity> {
    /**
     * 根据订单id查询所有订单
     */
    @Select("select * from `dingdan` where `id` =  {id}")
    List<DingdanEntity> queryAllDingDanById(@Param("id") Integer dingdan);
    /**
     * 查询所有订单信息
     */
    @Select("select * from `dingdan`")
    List<DingdanEntity>queryAll();
    /**
     * 根据订单ID删除订单信息
     */
    @Delete("delete from `dingdan` where `id` = {id}")
    int delId(Integer dingdan);
    /**
     * 根据订单id修改订单信息
     */
    @Update("UPDATE `dingdan` SET `purchase_username` = ?, `sell_username` = ?, `receiver_name` = ?, `receiver_address` = ?, `receiver_phone` = ?, `receiver_email` = ?, `order_time` = ?, `cost` = ?, `status` = ?, `send` = ?, `pay_type` = ?, `delivery_sn` = ?, `delivery_company` = ?, `pay_amount` = ?, `freight_amount` = ? WHERE `id` = {id}")
    int updId(Integer dingdan);
	
}
