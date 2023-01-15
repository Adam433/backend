package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.DO.Roles;
import com.renkaen.cat_hospital.bean.DTO.StaffJoinPermissionDTO;
import com.renkaen.cat_hospital.bean.DTO.StaffJoinShowedDTO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinShowedVO;
import com.renkaen.cat_hospital.mapper.PermissionMapper;
import com.renkaen.cat_hospital.mapper.RolesMapper;
import com.renkaen.cat_hospital.mapper.StaffMapper;
import com.renkaen.cat_hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public StaffJoinShowedVO getById(int id) {
        StaffJoinShowedDTO staffJoinShowedDTO = staffMapper.selectUserById(id);
        if (staffJoinShowedDTO != null) {
            return new StaffJoinShowedVO(staffJoinShowedDTO);
        }
        return null;
    }

    @Override
    public List<StaffJoinShowedVO> getAllStaff() {
        List<StaffJoinShowedVO> staffJoinShowedVOS = new ArrayList<>();
        for (StaffJoinShowedDTO staffJoinShowedDTO : staffMapper.selectAllUser()) {
            staffJoinShowedVOS.add(new StaffJoinShowedVO(staffJoinShowedDTO));
        }
        return staffJoinShowedVOS;
    }

    public StaffJoinShowedVO getByUsername(String username) {
        StaffJoinShowedDTO staffJoinShowedDTO = staffMapper.selectStaffByName(username);
        if (staffJoinShowedDTO != null) {
            return new StaffJoinShowedVO(staffJoinShowedDTO);
        }
        return null;
    }

    @Override
    public List<StaffJoinShowedVO> getUserByRole(int id_1, int id_2) {
        List<StaffJoinShowedDTO> staffJoinShowedDTOS = staffMapper.selectUserByRole(id_1, id_2);
        List<StaffJoinShowedVO> staffJoinShowedVOS = new ArrayList<>();
        staffJoinShowedDTOS.forEach(staff -> staffJoinShowedVOS.add(new StaffJoinShowedVO(staff)));
        return staffJoinShowedVOS;
    }

    @Override
    public boolean createUser(StaffJoinShowedVO staffJoinShowedVO) {
        StaffJoinShowedDTO staffJoinShowedDTO = new StaffJoinShowedDTO(staffJoinShowedVO);
        staffJoinShowedDTO.setPassword(passwordEncoder.encode(staffJoinShowedDTO.getPassword()));
        if (staffMapper.insertUser(staffJoinShowedDTO)) {
            //处理showed_staff
            List<Integer> allPermissionId = permissionMapper.selectAllPermissionId();
            staffMapper.insertShowed(staffJoinShowedDTO.getStaffId(), allPermissionId);
            //处理 staff_role
            List<Integer> rolesId = getRoleIdList(staffJoinShowedDTO);
            staffMapper.insertRoles(staffJoinShowedDTO.getStaffId(), rolesId);
        }
        return false;
    }

    @Override
    public boolean updateStaffById(int id, StaffJoinShowedVO staffJoinShowedVO) {
        StaffJoinShowedDTO staffJoinShowedDTO = new StaffJoinShowedDTO(staffJoinShowedVO);
        if (staffJoinShowedDTO.getPassword() != null) {
            if (staffJoinShowedDTO.getPassword().equals(staffMapper.selectPasswordById(id))) {
                staffJoinShowedDTO.setPassword(null);
            } else {
                staffJoinShowedDTO.setPassword(passwordEncoder.encode(staffJoinShowedDTO.getPassword()));
            }
        }
        //更新staff table
        boolean update = staffMapper.updateStaffById(id, staffJoinShowedDTO);
        //更新showed_staff table
        if (update) {
            if (staffJoinShowedDTO.getShowed() != null) {
                List<Permission> permissionList = permissionMapper.selectAllPermission();
                List<String> showedListUpdate = staffJoinShowedDTO.getShowed();
                List<Integer> showedList = new ArrayList<>();
                for (Permission permission : permissionList) {
                    if (showedListUpdate.contains(permission.getUrl())) {
                        showedList.add(permission.getPermissionId());
                    }
                }
                staffMapper.deleteShowed(id);
                staffMapper.insertShowed(id, showedList);
            }

            if (staffJoinShowedDTO.getKatagaki() != null) {
                List<Integer> rolesId = getRoleIdList(staffJoinShowedDTO);
                staffMapper.deleteRoles(id);
                staffMapper.insertRoles(id, rolesId);
            }
            return update;
        }
        return false;
    }

    private List<Integer> getRoleIdList(StaffJoinShowedDTO staffJoinShowedDTO) {
        List<String> roles = staffJoinShowedDTO.getKatagaki();
        List<Roles> allRoles = rolesMapper.selectAll();
        List<Integer> rolesId = new ArrayList<>();
        allRoles.forEach(eachRole -> {
            if (roles.contains(eachRole.getKatagaki())) {
                rolesId.add(eachRole.getRoleId());
            }
        });
        return rolesId;
    }

    @Override
    public boolean deleteStaffById(int id) {
        return staffMapper.deleteStaffById(id);
    }

    @Override
    public StaffJoinRightsVO getStaffByIdJoinRights(int id) {
        return new StaffJoinRightsVO(staffMapper.selectStaffByIdJoinRights(id), permissionMapper.selectAllPermission());
    }


}
