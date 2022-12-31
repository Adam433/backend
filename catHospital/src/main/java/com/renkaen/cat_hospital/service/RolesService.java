package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DTO.RolesJoinRightsDTO;
import com.renkaen.cat_hospital.bean.PO.Roles;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;

import java.util.List;


public interface RolesService {
    Roles getById(int id);

    List<Roles> getAll();

    List<RolesJoinRightsVO> getRolesJoinRights();
}
