package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.RolesJoinRightsDTO;
import com.renkaen.cat_hospital.bean.PO.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesMapper {

    Roles selectById(int id);

    List<Roles> selectAll();

    List<RolesJoinRightsDTO> selectAllRolesJoinRights();

}
