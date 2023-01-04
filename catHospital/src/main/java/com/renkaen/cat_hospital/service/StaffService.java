package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Staff;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.StaffVO;

import java.util.List;

public interface StaffService {
    StaffVO getById(int id);
    List<StaffVO> getAllStaff();
    StaffVO getByUsername(String username);
    boolean createUser(Staff staff);

    List<StaffVO> getUserByRole(int id_1, int id_2);

    boolean updateStaffById(int id, Staff staff);
    boolean deleteStaffById(int id);

    StaffJoinRightsVO getStaffByIdJoinRights(int id);
}
