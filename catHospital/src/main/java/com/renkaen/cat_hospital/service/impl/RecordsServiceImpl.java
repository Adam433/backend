package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.RecordsJoinCatsDTO;
import com.renkaen.cat_hospital.bean.PO.Records;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsJoinCatsVO;
import com.renkaen.cat_hospital.mapper.RecordsMapper;
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
    @Override
    public RecordsVO getById(int id) {
        return new RecordsVO(recordsMapper.selectByid(id));
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
        for(Records records: recordsMapper.selectRecordByTimeAndStaffId(timeStart,timeEnd,staffId)){
            voList.add(new RecordsVO(records));
        }
        return voList;
    }

    @Override
    public boolean createRecords(Records records) {
        return recordsMapper.insertRecords(records);
    }

    @Override
    public RecordsVO updateRecordsById(int id,Records records) {
        recordsMapper.updateRecordsById(id,records);
        System.out.println(records);
        return new RecordsVO(records);
    }

    @Override
    public boolean deleteRecordsById(int id) {
        return recordsMapper.deleteRecordsById(id);
    }

//    DTO -->  VO
    private List<RecordsJoinCatsVO> dtoToVo (List<RecordsJoinCatsDTO> dtoList){
        List<RecordsJoinCatsVO> recordsJoinCatsVOList = new ArrayList<>();
        for(RecordsJoinCatsDTO recordsJoinCatsDTO :dtoList){
            RecordsJoinCatsVO recordsJoinCatsVO = new RecordsJoinCatsVO();
            BeanUtils.copyProperties(recordsJoinCatsDTO, recordsJoinCatsVO);
            recordsJoinCatsVO.setDate(recordsJoinCatsDTO.getKeyTime());
            recordsJoinCatsVO.setCat(new CatsVO(recordsJoinCatsDTO.getCats()));
            recordsJoinCatsVO.getCat().setId(recordsJoinCatsDTO.getCatId());
            if(recordsJoinCatsDTO.getBillList()!=null){
                recordsJoinCatsVO.setBillList(JSONArray.fromObject(recordsJoinCatsDTO.getBillList()));
            }
            if(recordsJoinCatsDTO.getTreatments()!=null){
                recordsJoinCatsVO.setTreatments(JSONArray.fromObject(recordsJoinCatsDTO.getTreatments()));
            }
            recordsJoinCatsVOList.add(recordsJoinCatsVO);
        }
        return recordsJoinCatsVOList;
    }
}
