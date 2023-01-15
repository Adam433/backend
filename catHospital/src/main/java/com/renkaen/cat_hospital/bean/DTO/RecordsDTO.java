package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DO.Treatment;
import com.renkaen.cat_hospital.bean.VO.BillVO;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordsDTO {
    public RecordsDTO(RecordsVO recordsVO) {
        List<Bill> bills = new ArrayList<>();
        if (recordsVO.getBillList() != null) {
            for (BillVO billVO : recordsVO.getBillList()) {
                bills.add(new Bill(billVO));
            }
        }
        recordId = recordsVO.getId();
        catId = recordsVO.getCatId();
        key = recordsVO.getDate();
        staffId = recordsVO.getStaffId();
        weight = recordsVO.getWeight();
        diagnosis = recordsVO.getDiagnosis();
        reserve = recordsVO.getReserve();
        billList = bills;
        treatments = recordsVO.getTreatments();
        billStatus = recordsVO.getBill();
    }

    private Integer recordId;
    private Integer catId;
    private Long key;
    private Integer staffId;
    private String weight;
    private String diagnosis;
    private Integer reserve;
    private Integer billStatus;
    private List<Bill> billList;
    private List<Treatment> treatments;
}
