package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Cats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatsMapper {
    @Select("select * from cats_table where id = #{id}")
    Cats selectById(int id);
    List<Cats> selectCatByPhoneNick(String phoneNumber,String nickname);
    List<Cats> selectCatByPhone(String phoneNumber);
    List<Cats> selectAllCats();
    boolean insertCats(Cats cats);
    boolean updateCatsById(int id, Cats cats);
    boolean deleteCatsById(int id);


}
