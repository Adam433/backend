package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.PO.Cats;
import com.renkaen.cat_hospital.bean.VO.CatsVO;

import java.util.List;

public interface CatsService {
    CatsVO getById(int id);
    List<CatsVO> getByPhoneAndName(String phoneNumber,String nickname);
    List<CatsVO> getByPhone(String phoneNumber);
    List<CatsVO> getAllCats();
    Cats addCats(Cats cats);
    boolean updateCatsById(int id, Cats cats);
    boolean deleteCatsById(int id);
}
