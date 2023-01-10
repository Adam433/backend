package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Treatment;
import com.renkaen.cat_hospital.mapper.TreatmentMapper;
import com.renkaen.cat_hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreatmentServiceImpl implements TreatmentService {
    @Autowired
    private TreatmentMapper treatmentMapper;

    @Override
    public List<Treatment> getTreatmentByRecordId(int recordId) {
        return null;
    }
}
