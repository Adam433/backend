package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.StaffJoinRightsDTO;
import com.renkaen.cat_hospital.bean.DO.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {
    //根据用户名和密码获取用户
    boolean selectUserByUP(String username,String password);

    //根据id查找用户
    Staff selectUserById(int id);
    List<Staff> selectAllUser();
    //根据username查找用户
    Staff selectStaffByName(String username);
    Staff selectStaffByPassword(String username,String password);
    //新增一个用户
    boolean insertUser(Staff staff);
    //查找所有的医生，这里为练习,使用了此不合理的方法
    List<Staff> selectUserByRole(int id_1, int id_2);

    //根据id更新用户
    boolean updateStaffById(int id, Staff staff);

    boolean deleteStaffById(int id);

    StaffJoinRightsDTO selectStaffByIdJoinRights(int id);

}
