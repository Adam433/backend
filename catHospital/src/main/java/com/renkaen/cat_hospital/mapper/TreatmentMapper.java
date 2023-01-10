package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Treatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TreatmentMapper {
    List<Treatment> selectTreatmentByRecordId(int recordId);
}
