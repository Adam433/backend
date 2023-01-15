package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.InStocksJoinInboundDTO;
import com.renkaen.cat_hospital.bean.DO.InStocks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InStocksMapper {

    //根据id获取库存信息
    @Select("select * from inStocks_table where in_stock_id = #{id}")
    InStocks selectInStocksById(int id);

    //获得所有库存信息
    List<InStocks> selectInStocksAll();

    //获取所有带入库信息的药品（type）库存信息
    List<InStocksJoinInboundDTO> selectInStocksJoinInboundByType(int type);

    //根据id更新库存信息
    boolean updateInStocksById(int id, InStocks inStocks);

    boolean insertInStocks(InStocks inStocks);

    boolean deleteInStocksById(int id);

}
