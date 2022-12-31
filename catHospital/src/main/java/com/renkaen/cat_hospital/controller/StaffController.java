package com.renkaen.cat_hospital.controller;


import com.renkaen.cat_hospital.bean.PO.Staff;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.StaffVO;
import com.renkaen.cat_hospital.domain.ResponseResult;
import com.renkaen.cat_hospital.service.LogService;
import com.renkaen.cat_hospital.service.StaffService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private LogService logService;
    @PreAuthorize("hasAnyAuthority('test3')")
    @GetMapping("/{staffId}")
    public StaffVO getStaffById(@PathVariable("staffId") int id){
        return  staffService.getById(id);
    }
    @GetMapping("")
    public List<StaffVO> getAllStaff(){
        return staffService.getAllStaff();
    }

    @GetMapping("username/{username}")
    public StaffVO getStaffByUsername(@PathVariable("username")String username){
        return staffService.getByUsername(username);
    }
    //获得所有医生信息
    @GetMapping("/{rolesId}/{rolesID}")
    public List<StaffVO> getUserByRole(@PathVariable("rolesId")int id_1, @PathVariable("rolesID")int id_2){
        return staffService.getUserByRole(id_1,id_2);
    }
    @GetMapping("/rights/{staffId}")
    public StaffJoinRightsVO getStaffByIdJoinRights(@PathVariable("staffId")int staffId){
        return staffService.getStaffByIdJoinRights(staffId);
    }
    //登陆和登出
    @PostMapping("/login")
    public ResponseResult getStaffJoinRightsByPassword(@RequestBody Staff staff ){
        return logService.login(staff);
    }
    @RequestMapping("/logout")
    public ResponseResult logout(){
        return logService.logout();
    }
    //--------------------------------------------------------------update\delete\add
    @PostMapping("")
    public Object createUser(@RequestBody StaffVO staffVO) {
        if (
                StringUtils.isNotBlank(staffVO.getUsername()) &&
                StringUtils.isNotBlank(staffVO.getPassword()) &&
                StringUtils.isNotBlank(staffVO.getName()) &&
                StringUtils.isNotBlank(String.valueOf(staffVO.getKey())) &&
                staffVO.getRolesId()>0 &&
                StringUtils.isNotBlank(staffVO.getShowed().toString()) &&
                staffVO.getRightsId()>0 &&
                (staffVO.getZaishoku()==0||staffVO.getZaishoku()==1)
        ) {
            return staffService.createUser(staffVOtoDO(staffVO)) ? staffVO : "数据库写入失败";
        }
        return "数据格式异常";

    }
    @PatchMapping("/{staffId}")
    public Object updateStaffById(@PathVariable("staffId")int staffId,@RequestBody StaffVO staffVO){
        if (
                (staffVO.getUsername()==null || StringUtils.isNotBlank(staffVO.getUsername())) &&
                        (staffVO.getPassword()==null || StringUtils.isNotBlank(staffVO.getPassword())) &&
                        (staffVO.getName()==null || StringUtils.isNotBlank(staffVO.getName())) &&
                        (staffVO.getKey()==null ||staffVO.getKey()>0 ) &&
                        (staffVO.getRolesId()==null ||staffVO.getRolesId()>0) &&
                        (staffVO.getShowed()==null ||StringUtils.isNotBlank(staffVO.getShowed().toString())) &&
                        (staffVO.getRightsId()==null ||staffVO.getRightsId()>0) &&
                        (staffVO.getZaishoku()==null||staffVO.getZaishoku()==0||staffVO.getZaishoku()==1)
        ){
            return staffService.updateStaffById(staffId,staffVOtoDO(staffVO))?staffVO:"数据库更新失败";
        }
        return "数据格式异常";
    }

    @DeleteMapping("/{staffId}")
    public String deleteStaffById(@PathVariable("staffId")int staffId){
        return staffService.deleteStaffById(staffId)?"成功删除":"无此id的数据";
    }

    private Staff staffVOtoDO (StaffVO staffVO){
        Staff staff = new Staff() ;
        BeanUtils.copyProperties(staffVO,staff);
        staff.setKeyTime(staffVO.getKey());
        staff.setRealName(staffVO.getName());
        if(staffVO.getShowed()!=null){
        staff.setShowed(StringUtils.join(staffVO.getShowed(),","));}
        return staff;
    }
}
