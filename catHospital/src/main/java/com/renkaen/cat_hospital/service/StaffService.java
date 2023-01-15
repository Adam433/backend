package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinShowedVO;

import java.util.List;

public interface StaffService {
    StaffJoinShowedVO getById(int id);

    List<StaffJoinShowedVO> getAllStaff();

    StaffJoinShowedVO getByUsername(String username);

    boolean createUser(StaffJoinShowedVO staffJoinShowedVO);

    List<StaffJoinShowedVO> getUserByRole(int id_1, int id_2);

    boolean updateStaffById(int id, StaffJoinShowedVO staffJoinShowedVO);

    boolean deleteStaffById(int id);

    StaffJoinRightsVO getStaffByIdJoinRights(int id);
}
