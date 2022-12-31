package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.PO.Rights;
import com.renkaen.cat_hospital.mapper.RightsMapper;
import com.renkaen.cat_hospital.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RightServiceImpl implements RightsService {
    @Autowired
    private RightsMapper rightsMapper;
    @Override
    public Rights getById(int rightId) {
        return rightsMapper.selectRightsById(rightId);
    }

    @Override
    public boolean updateRightsById(int id, Rights rights) {
        return rightsMapper.updateRightsById(id,rights);
    }

}
