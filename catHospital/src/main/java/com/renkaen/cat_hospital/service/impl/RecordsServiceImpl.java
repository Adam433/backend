package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.RecordsJoinCatsDTO;
import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsJoinCatsVO;
import com.renkaen.cat_hospital.mapper.BillMapper;
import com.renkaen.cat_hospital.mapper.RecordsMapper;
import com.renkaen.cat_hospital.mapper.TreatmentMapper;
import com.renkaen.cat_hospital.service.RecordsService;
import net.sf.json.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsMapper recordsMapper;
    @Autowired
    private     BillMapper billMapper;
    @Autowired
    private TreatmentMapper treatmentMapper;
    @Override
    public RecordsVO getById(int id) {
        return new RecordsVO(recordsMapper.selectByid(id), treatmentMapper.selectTreatmentByRecordId(id), billMapper.selectByRecordId(id));
    }

    @Override
    public List<RecordsJoinCatsVO> getByBill(int bill) {
        return dtoToVo(recordsMapper.selectRecordJoinCat(bill));
    }

    @Override
    public List<RecordsJoinCatsVO> getByAssistant() {
        return dtoToVo(recordsMapper.selectRecordJoinCatByAssistant());
    }

    @Override
    public List<RecordsJoinCatsVO> getByStaffId(int staffId) {
        return dtoToVo(recordsMapper.selectRecordJoinCatByStaffId(staffId));
    }

    @Override
    public List<RecordsJoinCatsVO> getRecordsByTime(long timeStart) {
        return dtoToVo(recordsMapper.selectRecordsByTime(timeStart));
    }

    @Override
    public List<RecordsVO> getByTimeAndStaffId(long timeStart, long timeEnd, int staffId) {
        List<RecordsVO> voList = new ArrayList<>();
        //TODO
//for(Records records: recordsMapper.selectRecordByTimeAndStaffId(timeStart,timeEnd,staffId)){
//            voList.add(new RecordsVO(records));
//        }
        return voList;
    }

    @Override
    public boolean createRecords(RecordsVO recordsVO) {
        return recordsMapper.insertRecords(recordsVOToRecord(recordsVO));
    }

    @Override
    public RecordsVO updateRecordsById(int id,RecordsVO recordsVO) {
        recordsMapper.updateRecordsById(id,recordsVO);
//        System.out.println(records);
        //TODO
//        return new RecordsVO(records);
        return null;
    }

    @Override
    public boolean deleteRecordsById(int id) {
        return recordsMapper.deleteRecordsById(id);
    }

//    DTO -->  VO
    private List<RecordsJoinCatsVO> dtoToVo (List<RecordsJoinCatsDTO> dtoList){
        System.out.println(dtoList);
        //TODO 数据格式转换
        List<RecordsJoinCatsVO> recordsJoinCatsVOList = new ArrayList<>();
        for(RecordsJoinCatsDTO recordsJoinCatsDTO :dtoList){
            RecordsJoinCatsVO recordsJoinCatsVO = new RecordsJoinCatsVO();
            BeanUtils.copyProperties(recordsJoinCatsDTO, recordsJoinCatsVO);
            recordsJoinCatsVO.setDate(recordsJoinCatsDTO.getKey());
            recordsJoinCatsVO.setId(recordsJoinCatsDTO.getRecordId());

            recordsJoinCatsVO.setCat(new CatsVO(recordsJoinCatsDTO.getCatsDTO()));
            recordsJoinCatsVO.getCat().setId(recordsJoinCatsDTO.getCatId());
//            if(recordsJoinCatsDTO.getBillList()!=null){
//                recordsJoinCatsVO.setBillList(JSONArray.fromObject(recordsJoinCatsDTO.getBillList()));
//            }
//            if(recordsJoinCatsDTO.getTreatments()!=null){
//                recordsJoinCatsVO.setTreatments(JSONArray.fromObject(recordsJoinCatsDTO.getTreatments()));
//            }
            recordsJoinCatsVOList.add(recordsJoinCatsVO);
        }
        System.out.println(recordsJoinCatsVOList);
        return recordsJoinCatsVOList;
    }
    //VO 转 DO
    private Records recordsVOToRecord(RecordsVO recordsVO){
        Records records = new Records();
        BeanUtils.copyProperties(recordsVO,records);
        records.setRecordId(recordsVO.getId());
//        if(recordsVO.getBillList() != null){
//            records.setBillList(recordsVO.getBillList().toString());
//        }
//        if (recordsVO.getTreatments() != null){
//            records.setTreatments(recordsVO.getTreatments().toString());
//        }
        return records;
    }
}
