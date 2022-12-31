package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Records;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

@Data
@NoArgsConstructor
public class RecordsVO {
    public RecordsVO(Records records){
        id = records.getId();
        catId = records.getCatId();
        bill = records.getBill();
        date = records.getKeyTime();
        staffId = records.getStaffId();
        weight = records.getWeight();
        if(records.getTreatments()!=null){
        treatments = JSONArray.fromObject(records.getTreatments());}
        diagnosis = records.getDiagnosis();
        reserve = records.getReserve();
        if(records.getBillList()!=null){
        billList = JSONArray.fromObject(records.getBillList());}
    }
    private Integer id;
    private Integer catId;
    private Long date;
    private Integer staffId;
    private String weight;
    private JSONArray treatments;
    private String diagnosis;
    private Integer reserve;
    private Integer bill;
    private JSONArray billList;
}
