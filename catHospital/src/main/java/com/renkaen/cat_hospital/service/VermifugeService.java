package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Vermifuge;

import java.util.List;

public interface VermifugeService {
    boolean insertVermifugeByCatId(int catId,List<Long> vermifugeList);
}
