package com.renkaen.cat_hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VaccineMapper {
    boolean insertByCatId(int catId, List<Long> vaccineList);
    boolean deleteByCatId(int catId);
}
