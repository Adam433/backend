package com.renkaen.cat_hospital.bean.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;
@Data
@NoArgsConstructor
public class RecordsJoinCatsVO {
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
    private CatsVO cat;
}
