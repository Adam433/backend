package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InboundMapper {
    @Select("select * from inbound_table where id = #{id}")
    Inbound selectById(int id);
    boolean insertInbound(Inbound inbound);
    boolean deleteInboundById(int id);
    boolean updateInboundById(int id, Inbound inbound);
}
