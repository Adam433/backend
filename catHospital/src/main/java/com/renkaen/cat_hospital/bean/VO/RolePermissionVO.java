package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DTO.PermissionJoinPermissionColumnDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RolePermissionVO {
    private Integer id;
    private Integer rolesId;
    private String username;
    private String name;
    private List<PermissionJoinPermissionColumnDTO> rights;
}
