package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.StaffJoinRightsDTO;
import com.renkaen.cat_hospital.bean.PO.Staff;
import com.renkaen.cat_hospital.bean.VO.RightsVO;
import com.renkaen.cat_hospital.bean.VO.RolePermissionVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.StaffVO;
import com.renkaen.cat_hospital.mapper.StaffMapper;
import com.renkaen.cat_hospital.service.StaffService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RolePermissionServiceImpl rolePermissionService;
    @Override
    public StaffVO getById(int id) {
        return new StaffVO(staffMapper.selectUserById(id));
    }

    @Override
    public List<StaffVO> getAllStaff() {
        List<StaffVO> staffVOList = new ArrayList<>();
        for(Staff staff: staffMapper.selectAllUser()){
            staffVOList.add(new StaffVO(staff));
        }
        return staffVOList;
    }

    public StaffVO getByUsername(String username){
        return new StaffVO(staffMapper.selectStaffByName(username));
    }

    @Override
    public RolePermissionVO getByPassword(String username, String password) {
        Staff staff = staffMapper.selectStaffByPassword(username, password);
        RolePermissionVO rolePermissionVO = rolePermissionService.getPermissionByRolesId(staff.getId());
        rolePermissionVO.setName(staff.getRealName());
        rolePermissionVO.setUsername(staff.getUsername());
        rolePermissionVO.setRolesId(staff.getRolesId());
        return rolePermissionVO;
    }

    @Override
    public boolean createUser(Staff staff) {
        return staffMapper.insertUser(staff);
    }

    @Override
    public List<StaffVO> getUserByRole(int id_1, int id_2) {
        List<Staff> listStaff = staffMapper.selectUserByRole(id_1, id_2);
        List<StaffVO> listStaffVO = new ArrayList<>();
        listStaff.forEach(staff -> listStaffVO.add(new StaffVO(staff)) );
        return listStaffVO;
    }

    @Override
    public boolean updateStaffById(int id, Staff staff) {
        return staffMapper.updateStaffById(id, staff);
    }

    @Override
    public boolean deleteStaffById(int id) {
        return staffMapper.deleteStaffById(id);
    }

    @Override
    public StaffJoinRightsVO getStaffByIdJoinRights(int id) {
        return DTOtoVO(staffMapper.selectStaffByIdJoinRights(id));
    }

    private StaffJoinRightsVO DTOtoVO(StaffJoinRightsDTO dto){
        StaffJoinRightsDTO staffJoinRightsDTO = dto;
        if(dto!=null){
        StaffJoinRightsVO staffJoinRightsVO = new StaffJoinRightsVO();
        BeanUtils.copyProperties(staffJoinRightsDTO,staffJoinRightsVO);
        staffJoinRightsVO.setKey(staffJoinRightsDTO.getKeyTime());
        staffJoinRightsVO.setName(staffJoinRightsDTO.getRealName());
        staffJoinRightsVO.setShowed(staffJoinRightsDTO.getShowed().split(","));
        staffJoinRightsVO.setRights(new RightsVO(staffJoinRightsDTO.getRights()));
        return staffJoinRightsVO;}
        return null;
    }
}
