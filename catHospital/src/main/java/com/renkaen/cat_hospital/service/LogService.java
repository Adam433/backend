package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.PO.Staff;
import com.renkaen.cat_hospital.domain.ResponseResult;

public interface LogService {
    ResponseResult login (Staff staff);

    ResponseResult logout ();
}
