package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DTO.RecordsDTO;
import com.renkaen.cat_hospital.bean.DTO.RecordsJoinCatsDTO;
import com.renkaen.cat_hospital.bean.VO.BillVO;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsJoinCatsVO;
import com.renkaen.cat_hospital.mapper.BillMapper;
import com.renkaen.cat_hospital.mapper.RecordsMapper;
import com.renkaen.cat_hospital.mapper.TreatmentMapper;
import com.renkaen.cat_hospital.service.RecordsService;
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
    private BillMapper billMapper;
    @Autowired
    private TreatmentMapper treatmentMapper;

    @Override
    public RecordsVO getById(int id) {
        return new RecordsVO(recordsMapper.selectById(id));
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
        for (RecordsDTO recordsDTO : recordsMapper.selectRecordByTimeAndStaffId(timeStart, timeEnd, staffId)) {
            voList.add(new RecordsVO(recordsDTO));
        }
        return voList;
    }

    @Override
    public boolean createRecords(RecordsVO recordsVO) {
        RecordsDTO recordsDTO = new RecordsDTO(recordsVO);
        boolean created = recordsMapper.insertRecords(recordsDTO);
        if (!recordsDTO.getBillList().isEmpty() && created) {
            billMapper.insertBatch(recordsDTO.getRecordId(), recordsDTO.getBillList());
        }
        if (!recordsDTO.getTreatments().isEmpty() && created) {
            treatmentMapper.batchInsertByRecordId(recordsDTO.getRecordId(), recordsDTO.getTreatments());
        }
        return created;
    }

    @Override
    public RecordsVO updateRecordsById(int id, RecordsVO recordsVO) {
        RecordsDTO recordsDTO = new RecordsDTO(recordsVO);
        boolean exist = recordsMapper.updateRecordsById(id, recordsDTO);
        if (recordsDTO.getTreatments() != null && exist) {
            treatmentMapper.deleteByRecordId(id);
            if (!recordsDTO.getTreatments().isEmpty()) {
                treatmentMapper.batchInsertByRecordId(id, recordsDTO.getTreatments());
            }
        }
        if (recordsDTO.getBillList() != null && exist) {
            billMapper.deleteByRecordId(id);
            if (!recordsDTO.getBillList().isEmpty()) {
                billMapper.insertBatch(id, recordsDTO.getBillList());
            }
        }
        return exist ? recordsVO : null;
    }

    @Override
    public boolean deleteRecordsById(int id) {
        boolean deleted = recordsMapper.deleteRecordsById(id);
        if (deleted) {
            billMapper.deleteByRecordId(id);
            treatmentMapper.deleteByRecordId(id);
        }
        return deleted;
    }

    //    DTO -->  VO
    private List<RecordsJoinCatsVO> dtoToVo(List<RecordsJoinCatsDTO> dtoList) {
        List<RecordsJoinCatsVO> recordsJoinCatsVOList = new ArrayList<>();
        for (RecordsJoinCatsDTO recordsJoinCatsDTO : dtoList) {
            RecordsJoinCatsVO recordsJoinCatsVO = new RecordsJoinCatsVO();
            BeanUtils.copyProperties(recordsJoinCatsDTO, recordsJoinCatsVO);
            recordsJoinCatsVO.setDate(recordsJoinCatsDTO.getKey());
            recordsJoinCatsVO.setId(recordsJoinCatsDTO.getRecordId());
            recordsJoinCatsVO.setBill(recordsJoinCatsDTO.getBillStatus());
            recordsJoinCatsVO.setCat(new CatsVO(recordsJoinCatsDTO.getCatsDTO()));
            recordsJoinCatsVO.getCat().setId(recordsJoinCatsDTO.getCatId());
            List<BillVO> billVOList = new ArrayList<>();
            for (Bill bill : recordsJoinCatsDTO.getBillList()) {
                billVOList.add(new BillVO(bill));
            }
            recordsJoinCatsVO.setBillList(billVOList);
            recordsJoinCatsVOList.add(recordsJoinCatsVO);
        }
        return recordsJoinCatsVOList;
    }

}
