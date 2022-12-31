package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Rights;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolesJoinRightsVO {
    private Integer id;
    private String katagaki;
    private Integer key;
    private Integer rightsId;
    private RightsVO rights;
}
