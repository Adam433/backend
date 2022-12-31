package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.PO.Rights;

public interface RightsService {
    Rights getById(int id);
    boolean updateRightsById(int id,Rights rights);
}
