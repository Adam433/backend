package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DO.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordsDTO {
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
