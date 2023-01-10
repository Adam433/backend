package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Vaccine;

import java.util.List;

public interface VaccineService {
    boolean insertVaccineByCatId(int catId, List<Long> vaccineList);
}
