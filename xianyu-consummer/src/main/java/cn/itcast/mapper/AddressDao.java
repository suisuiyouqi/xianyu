package cn.itcast.mapper;

import cn.itcast.entity.AddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-10 09:41:21
 */
@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {
    /**
     * 根据用户id查询所有订单地址
     */
    @Select("select * from address where user_id = {id} ")
    List<AddressEntity> queryAllId(Integer userId);
    /**
     * 查询所有订单地址
     */
    @Select("selec * from address")
    List<AddressEntity>queryAll();
    /**
     * 根据用户id修改订单地址
     */
    @Update("UPDATE `address` SET `user_id` = ?, `u_name` = ?, `phone` = ?, `address` = ?, `province` = ?, `city` = ?, `district` = ?, `detail` = ?, `uid` = ? WHERE `user_id` = {id}")
    int updAddressId(Integer userId);
}
