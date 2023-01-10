package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Vaccine;
import com.renkaen.cat_hospital.mapper.VaccineMapper;
import com.renkaen.cat_hospital.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    private VaccineMapper vaccineMapper;

    @Override
    public boolean insertVaccineByCatId(int catId,List<Long> vaccineList) {
        return false;
    }
}
