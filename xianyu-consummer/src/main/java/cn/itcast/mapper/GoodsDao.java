package cn.itcast.mapper;

import cn.itcast.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 
 * 
 * @author Kaddd
 * @email Kaddd@gmail.com
 * @date 2021-12-08 15:08:32
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    /**
     * 根据id查询商品信息
     */
    @Select("select * from goods where goods_id = {id}")
    List<GoodsEntity> queryAllGoodsById(@Param("id") int goodsId);
    /**
     * 查询所有商品信息
     */
    @Select("select * from goods")
    List<GoodsEntity> queryAll();
    /**
     * 根据id删除商品
     */
    @Delete("delete from goods where goods_id = {id}")
    int delById(@Param("id") int goodsId);
    /**
     * 根据id新增商品
     */
    @Insert("INSERT INTO `goods`(`goods_id`, `goods_name`, `pop`, `intro`, `picture`, `smallsortid`, `secprice`, `oldandnew`, `sell_name`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
    int addGoosById(@Param("id") int goodsId);
    /**
     * 根据id修改商品信息
     */
    @Update("UPDATE goods` SET `goods_name` = '?', `pop` = ?, `intro` = ?, `picture` = ?, `smallsortid` = ?, `secprice` = ?, `oldandnew` = ?, `sell_name` = ? WHERE `goods_id` = {id}")
    int updGoodsById(@Param("id") int goodsId);
}
