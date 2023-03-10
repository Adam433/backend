package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.DO.Treatment;
import lombok.Data;

import java.util.List;

@Data
public class RecordsJoinCatsDTO {
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
    private CatsDTO catsDTO;
}
