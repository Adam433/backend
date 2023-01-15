package com.renkaen.cat_hospital.controller;


import com.renkaen.cat_hospital.bean.VO.StaffJoinShowedVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.service.StaffService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    //    @PreAuthorize("hasAnyAuthority('test3')")
    @GetMapping("/{staffId}")
    public StaffJoinShowedVO getStaffById(@PathVariable("staffId") int id) {
        return staffService.getById(id);
    }

    @GetMapping("")
    public List<StaffJoinShowedVO> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("username/{username}")
    public StaffJoinShowedVO getStaffByUsername(@PathVariable("username") String username) {
        return staffService.getByUsername(username);
    }

    //获得所有医生信息
    @GetMapping("/{rolesId}/{rolesID}")
    public List<StaffJoinShowedVO> getUserByRole(@PathVariable("rolesId") int id_1, @PathVariable("rolesID") int id_2) {
        return staffService.getUserByRole(id_1, id_2);
    }

    @GetMapping("/rights/{staffId}")
    public StaffJoinRightsVO getStaffByIdJoinRights(@PathVariable("staffId") int staffId) {
        return staffService.getStaffByIdJoinRights(staffId);
    }

    //--------------------------------------------------------------update\delete\add
    @PostMapping("")
    public Object createUser(@RequestBody StaffJoinShowedVO staffJoinShowedVO) {
        if (
                StringUtils.isNotBlank(staffJoinShowedVO.getUsername()) &&
                        StringUtils.isNotBlank(staffJoinShowedVO.getPassword()) &&
                        StringUtils.isNotBlank(staffJoinShowedVO.getName()) &&
                        StringUtils.isNotBlank(String.valueOf(staffJoinShowedVO.getKey())) &&
                        !staffJoinShowedVO.getKatagaki().isEmpty() &&
                        (staffJoinShowedVO.getZaishoku() == 0 || staffJoinShowedVO.getZaishoku() == 1)
        ) {
            return staffService.createUser(staffJoinShowedVO) ? staffJoinShowedVO : "数据库写入失败";
        }
        return "数据格式异常";
    }

    @PatchMapping("/{staffId}")
    public Object updateStaffById(@PathVariable("staffId") int staffId, @RequestBody StaffJoinShowedVO staffJoinShowedVO) {
        if (
                (staffJoinShowedVO.getUsername() == null || StringUtils.isNotBlank(staffJoinShowedVO.getUsername())) &&
                        (staffJoinShowedVO.getPassword() == null || StringUtils.isNotBlank(staffJoinShowedVO.getPassword())) &&
                        (staffJoinShowedVO.getName() == null || StringUtils.isNotBlank(staffJoinShowedVO.getName())) &&
                        (staffJoinShowedVO.getKey() == null || staffJoinShowedVO.getKey() > 0) &&
                        (staffJoinShowedVO.getShowed() == null || StringUtils.isNotBlank(staffJoinShowedVO.getShowed().toString())) &&
                        (staffJoinShowedVO.getZaishoku() == null || staffJoinShowedVO.getZaishoku() == 0 || staffJoinShowedVO.getZaishoku() == 1)
        ) {
            return staffService.updateStaffById(staffId, staffJoinShowedVO) ? staffJoinShowedVO : "数据库更新失败";
        }
        return "数据格式异常";
    }

    @DeleteMapping("/{staffId}")
    public String deleteStaffById(@PathVariable("staffId") int staffId) {
        return staffService.deleteStaffById(staffId) ? "成功删除" : "无此id的数据";
    }

}
