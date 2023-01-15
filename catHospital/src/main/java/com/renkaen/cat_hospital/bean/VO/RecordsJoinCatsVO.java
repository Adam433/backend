package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Treatment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecordsJoinCatsVO {
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
    private CatsVO cat;
}
