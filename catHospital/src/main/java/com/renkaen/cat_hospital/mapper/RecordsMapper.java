package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.RecordsDTO;
import com.renkaen.cat_hospital.bean.DTO.RecordsJoinCatsDTO;
import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordsMapper {

    RecordsDTO selectById(int recordId);

    boolean insertRecords(RecordsDTO records);

    boolean updateRecordsById(int id, RecordsDTO recordsDTO);

    boolean deleteRecordsById(int id);

    List<RecordsJoinCatsDTO> selectRecordJoinCat(int billStatus);

    List<RecordsJoinCatsDTO> selectRecordJoinCatByAssistant();

    List<RecordsJoinCatsDTO> selectRecordJoinCatByStaffId(int staffId);

    List<RecordsJoinCatsDTO> selectRecordsByTime(long timeStart);

    List<RecordsDTO> selectRecordByTimeAndStaffId(long timeStart, long timeEnd, int staffId);
}
