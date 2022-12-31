package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.PO.Cats;
import lombok.Data;

@Data
public class RecordsJoinCatsDTO {
    private Integer id;
    private Integer catId;
    private Long keyTime;
    private Integer staffId;
    private String weight;
    private String treatments;
    private String diagnosis;
    private Integer reserve;
    private Integer bill;
    private String billList;
    private Cats cats;
}
