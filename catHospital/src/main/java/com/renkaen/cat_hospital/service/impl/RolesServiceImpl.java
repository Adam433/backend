package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.RolesJoinRightsDTO;
import com.renkaen.cat_hospital.bean.PO.Roles;
import com.renkaen.cat_hospital.bean.VO.RightsVO;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;
import com.renkaen.cat_hospital.mapper.RolesMapper;
import com.renkaen.cat_hospital.service.RolesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;
    @Override
    public Roles getById(int roleId) {
        return rolesMapper.selectById(roleId);
    }

    @Override
    public List<Roles> getAll() {
        return rolesMapper.selectAll();
    }

    @Override
    public List<RolesJoinRightsVO> getRolesJoinRights() {
        List<RolesJoinRightsDTO> dtoList = rolesMapper.selectAllRolesJoinRights();
        List<RolesJoinRightsVO> voList = new ArrayList<>();
        for(RolesJoinRightsDTO rolesDTO : dtoList){
            RolesJoinRightsVO rolesVO = new RolesJoinRightsVO();
            BeanUtils.copyProperties(rolesDTO,rolesVO);
            rolesVO.setKey(rolesDTO.getKeyTime());
            rolesVO.setRights(new RightsVO(rolesDTO.getRights()));
            voList.add(rolesVO);
        }
        return voList;
    }
}
