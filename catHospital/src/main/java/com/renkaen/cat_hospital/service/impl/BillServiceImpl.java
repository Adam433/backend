package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.mapper.BillMapper;
import com.renkaen.cat_hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> getByRecordId(int recordId) {
        return billMapper.selectByRecordId(recordId);
    }

    @Override
    public boolean delByRecordId(int recordId) {
        return billMapper.deleteByRecordId(recordId);
    }

    @Override
    public boolean addBatch(int recordId, List<Bill> billList) {
        return billMapper.insertBatch(recordId,billList);
    }
}
