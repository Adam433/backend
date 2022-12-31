package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.PO.Roles;
import com.renkaen.cat_hospital.bean.VO.RolesJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.RolesVO;
import com.renkaen.cat_hospital.service.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesServiceImpl rolesService;
    //拿到所有role join rights
    @GetMapping("/rights")
    public List<RolesJoinRightsVO> getRolesJoinRights(){
        return rolesService.getRolesJoinRights();
    }
    @GetMapping("/{roleId}")
    public RolesVO getRolesById(@PathVariable("roleId") int roleId){
        return new RolesVO(rolesService.getById(roleId));
    }
    @GetMapping("")
    public List<RolesVO> getAllRoles(){
        List<RolesVO> rolesVOList = new ArrayList<>();
        for(Roles roles:rolesService.getAll()){
            rolesVOList.add(new RolesVO(roles));
        }
        return rolesVOList;
    }

}
