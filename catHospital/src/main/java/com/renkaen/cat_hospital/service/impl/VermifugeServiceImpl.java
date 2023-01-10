package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Vermifuge;
import com.renkaen.cat_hospital.mapper.VermifugeMapper;
import com.renkaen.cat_hospital.service.VermifugeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VermifugeServiceImpl implements VermifugeService {
    @Autowired
    private VermifugeMapper vermifugeMapper;

    @Override
    public boolean insertVermifugeByCatId(int catId, List<Long> vermifugeList) {
        return false;
    }
}
