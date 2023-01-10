package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.DO.Treatment;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

import java.util.List;

@Data
@NoArgsConstructor
public class RecordsVO {
    public RecordsVO(Records records, List<Treatment> treatmentList, List<Bill> bills){
        id = records.getRecordId();
        catId = records.getCatId();
        bill = records.getBillStatus();
        date = records.getKey();
        staffId = records.getStaffId();
        weight = records.getWeight();
        treatments =treatmentList;
        diagnosis = records.getDiagnosis();
        reserve = records.getReserve();
        billList = bills;
    }
    private Integer id;
    private Integer catId;
    private Long date;
    private Integer staffId;
    private String weight;
    private List<Treatment> treatments;
    private String diagnosis;
    private Integer reserve;
    private Integer bill;
    private List<Bill> billList;
}
