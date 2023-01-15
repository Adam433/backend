package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {
    List<Bill> selectByRecordId(int recordId);

    boolean deleteByRecordId(int recordId);

    boolean insertBatch(int recordId, List<Bill> billList);
}
