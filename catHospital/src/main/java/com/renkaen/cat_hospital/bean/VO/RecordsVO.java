package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.DO.Treatment;
import com.renkaen.cat_hospital.bean.DTO.RecordsDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RecordsVO {
    public RecordsVO(RecordsDTO recordsDTO){
        List<BillVO> billVOList = new ArrayList<>();
        for (Bill item : recordsDTO.getBillList()) {
            billVOList.add(new BillVO(item));
        }
        id = recordsDTO.getRecordId();
        catId = recordsDTO.getCatId();
        bill = recordsDTO.getBillStatus();
        date = recordsDTO.getKey();
        staffId = recordsDTO.getStaffId();
        weight = recordsDTO.getWeight();
        treatments =recordsDTO.getTreatments();
        diagnosis = recordsDTO.getDiagnosis();
        reserve = recordsDTO.getReserve();
        billList = billVOList;
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
    private List<BillVO> billList;
}
