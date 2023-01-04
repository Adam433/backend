package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.RecordsJoinCatsDTO;
import com.renkaen.cat_hospital.bean.DO.Records;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordsMapper {
    @Select("select * from records_table where id = #{id}")
    Records selectByid(int id);

    boolean insertRecords(Records records);

    boolean updateRecordsById(int id,Records records);
    boolean deleteRecordsById(int id);
    List<RecordsJoinCatsDTO> selectRecordJoinCat (int bill);
    List<RecordsJoinCatsDTO> selectRecordJoinCatByAssistant();
    List<RecordsJoinCatsDTO> selectRecordJoinCatByStaffId(int staffId);
    List<RecordsJoinCatsDTO> selectRecordsByTime(long timeStart);
    List<Records> selectRecordByTimeAndStaffId(long timeStart,long timeEnd,int staffId);
}
