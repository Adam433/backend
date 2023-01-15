package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.DO.Roles;
import com.renkaen.cat_hospital.bean.DTO.RolesJoinPermissionDTO;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;
import com.renkaen.cat_hospital.mapper.PermissionMapper;
import com.renkaen.cat_hospital.mapper.RolesMapper;
import com.renkaen.cat_hospital.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private PermissionMapper permissionMapper;

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
        List<RolesJoinPermissionDTO> rolesJoinPermissionDTOS = rolesMapper.selectAllRolesJoinPermissions();
        List<RolesJoinRightsVO> rolesJoinRightsVOS = new ArrayList<>();
        List<Permission> permissionAll = permissionMapper.selectAllPermission();
        for (RolesJoinPermissionDTO rolesJoinPermissionDTO : rolesJoinPermissionDTOS) {
            rolesJoinRightsVOS.add(new RolesJoinRightsVO(rolesJoinPermissionDTO, permissionAll));
        }
        return rolesJoinRightsVOS;
    }

    public RolesJoinRightsVO getRoleJoinRightsById(int roleId) {
        RolesJoinPermissionDTO rolesJoinPermissionDTO = rolesMapper.selectRoleJoinPermissionsById(roleId);
        List<Permission> permissionAll = permissionMapper.selectAllPermission();

        return new RolesJoinRightsVO(rolesJoinPermissionDTO, permissionAll);
    }

    @Override
    public boolean updateRoleJoinRightsById(int roleId, RolesJoinRightsVO rolesJoinRightsVO) {
        List<Integer> permissionIdList = new ArrayList<>();
        if (rolesJoinRightsVO.getRights() != null) {
            rolesJoinRightsVO.getRights().forEach(item -> {
                if (item.getRight() == 1) {
                    permissionIdList.add(item.getId());
                }
                if(item.getChildren()!=null){
                    item.getChildren().forEach(child->{
                        if(child.getRight()==1){
                            permissionIdList.add(child.getId());
                        }
                    });
                }
            });
        }
        if(rolesMapper.deletePermissionByRoleId(roleId)){
            return rolesMapper.insertPermissionByRoleId(roleId,permissionIdList);
        }else{
            return false;
        }
    }
}
