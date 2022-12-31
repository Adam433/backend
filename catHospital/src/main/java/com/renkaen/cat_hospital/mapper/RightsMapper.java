package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.PO.Rights;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RightsMapper {
//    根据id获取权限信息
    Rights selectRightsById(int id);
    boolean updateRightsById(int id, Rights r);
}
