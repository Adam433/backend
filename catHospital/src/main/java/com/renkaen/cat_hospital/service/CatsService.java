package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.VO.CatsVO;

import java.util.List;

public interface CatsService {
    CatsVO getById(int id);
    List<CatsVO> getByPhoneAndName(String phoneNumber,String nickname);
    List<CatsVO> getByPhone(String phoneNumber);
    List<CatsVO> getAllCats();
    CatsVO addCats(CatsVO catsVO);
    boolean updateCatsById(int id,CatsVO catsVO);
    boolean deleteCatsById(int id);
}
