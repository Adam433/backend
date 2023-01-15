package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.StaffJoinPermissionDTO;
import com.renkaen.cat_hospital.bean.DTO.StaffJoinShowedDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {
    //根据用户id查password;
    String selectPasswordById(int staffId);
    //根据id查找用户并Join显示
    StaffJoinShowedDTO selectUserById(int id);

    //根据id查询用户并Join权限
    StaffJoinPermissionDTO selectStaffByIdJoinRights(int StaffId);

    List<StaffJoinShowedDTO> selectAllUser();

    //根据username查找用户
    StaffJoinShowedDTO selectStaffByName(String username);

    StaffJoinPermissionDTO selectStaffByNameJoinPermission(String username);


    //新增一个用户
    boolean insertUser(StaffJoinShowedDTO StaffJoinShowedDTO);

    //查找所有的医生，这里为练习,使用了此不合理的方法
    List<StaffJoinShowedDTO> selectUserByRole(int id_1, int id_2);

    //根据id更新用户
    boolean updateStaffById(int id, StaffJoinShowedDTO staffJoinShowedDTO);

    boolean deleteStaffById(int id);

    //更新用户自定义显示
    boolean deleteShowed(int staffId);

    boolean insertShowed(int staffId, List<Integer> showedList);

    boolean deleteRoles(int staffId);
    boolean insertRoles(int staffId, List<Integer> roleList);

    List<String> selectShowedByStaffId(int staff_id);//这里不要改成staffId

}
