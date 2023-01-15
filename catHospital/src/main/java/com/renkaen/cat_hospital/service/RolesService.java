package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Roles;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;

import java.util.List;


public interface RolesService {
    Roles getById(int id);

    List<Roles> getAll();

    List<RolesJoinRightsVO> getRolesJoinRights();

    RolesJoinRightsVO getRoleJoinRightsById(int roleId);

    boolean updateRoleJoinRightsById(int roleId,RolesJoinRightsVO rolesJoinRightsVO);
}
