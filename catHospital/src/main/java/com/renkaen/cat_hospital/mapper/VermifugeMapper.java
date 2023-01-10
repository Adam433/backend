package com.renkaen.cat_hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VermifugeMapper {
    boolean insertByCatId(int catId, List<Long> vermifugeList);
    boolean deleteByCatId(int catId);
}
