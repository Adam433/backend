package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.Roles;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.RolesVO;
import com.renkaen.cat_hospital.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    //拿到所有role join rights
    @GetMapping("/rights")
    @PreAuthorize("hasAnyRole('admin')")
    public List<RolesJoinRightsVO> getRolesJoinRights() {
        return rolesService.getRolesJoinRights();
    }

    //拿到某个id的role Join rights
    @GetMapping("/rights/{roleId}")
    @PreAuthorize("hasAnyRole('admin')")
    public RolesJoinRightsVO getRoleJoinRightsById(@PathVariable("roleId") int roleId) {
        return rolesService.getRoleJoinRightsById(roleId);
    }

    @GetMapping("/{roleId}")
    @PreAuthorize("hasAnyRole('admin')")
    public RolesVO getRolesById(@PathVariable("roleId") int roleId) {
        return new RolesVO(rolesService.getById(roleId));
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('admin')")
    public List<RolesVO> getAllRoles() {
        List<RolesVO> rolesVOList = new ArrayList<>();
        for (Roles roles : rolesService.getAll()) {
            rolesVOList.add(new RolesVO(roles));
        }
        return rolesVOList;
    }
    @PatchMapping("rights/{roleId}")
    @PreAuthorize("hasAnyRole('admin')")
    public Object updateRoleJoinRightById(@PathVariable("roleId") int roleId,@RequestBody RolesJoinRightsVO rolesJoinRightsVO){
        return rolesService.updateRoleJoinRightsById(roleId,rolesJoinRightsVO)?rolesJoinRightsVO:"更新失敗";
    }

}
