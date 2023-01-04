package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Rights;
import lombok.Data;

@Data
public class RolesJoinRightsDTO {
    private Integer id;
    private String katagaki;
    private Integer keyTime;
    private Integer rightsId;
    private Rights rights;
}
