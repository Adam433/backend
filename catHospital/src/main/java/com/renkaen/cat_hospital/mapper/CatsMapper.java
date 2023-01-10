package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.DTO.CatsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatsMapper {
    CatsDTO selectById(int catId);
    List<CatsDTO> selectCatByPhoneNick(String phoneNumber,String nickname);
    List<CatsDTO> selectCatByPhone(String phoneNumber);
    List<CatsDTO> selectAllCats();
    boolean insertCats(Cats cats);
    boolean updateCatsById(int id, Cats cats);
    boolean deleteCatsById(int id);


}
