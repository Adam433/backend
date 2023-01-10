package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getByRecordId(int recordId);
    boolean delByRecordId(int recordId);
    boolean addBatch(int recordId, List<Bill> billList);
}
