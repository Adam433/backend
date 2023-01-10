package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsJoinCatsVO;

import java.util.List;

public interface RecordsService {
    RecordsVO getById(int id);
    //根据订单支付状态联表查询
    List<RecordsJoinCatsVO> getByBill(int bill);
    List<RecordsJoinCatsVO> getByAssistant();
    List<RecordsJoinCatsVO> getByStaffId(int staffId);
    List<RecordsJoinCatsVO> getRecordsByTime(long timeStart);

    List<RecordsVO> getByTimeAndStaffId(long timeStart,long timeEnd,int staffId);

    boolean createRecords(RecordsVO recordsVO);

    RecordsVO updateRecordsById (int id,RecordsVO recordsVO);
    boolean deleteRecordsById(int id);
}
