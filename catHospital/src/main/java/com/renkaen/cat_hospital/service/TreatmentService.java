package com.renkaen.cat_hospital.service;



import com.renkaen.cat_hospital.bean.DO.Treatment;

import java.util.List;

public interface TreatmentService {
    List<Treatment> getTreatmentByRecordId(int recordId);
}
