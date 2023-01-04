package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.mapper.CatsMapper;
import com.renkaen.cat_hospital.service.CatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatsServiceImpl implements CatsService {
    @Autowired
    private CatsMapper catsMapper;
    //--------------------------------------------------------------get
    @Override
    public CatsVO getById(int id) {
        Cats cats = catsMapper.selectById(id);
        if(cats!=null){
        return new CatsVO(cats);}
        return null;
    }
    @Override
    public  List<CatsVO> getByPhoneAndName(String phoneNumber,String nickname) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats:catsMapper.selectCatByPhoneNick(phoneNumber,nickname)){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    @Override
    public  List<CatsVO> getByPhone(String phoneNumber) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats:catsMapper.selectCatByPhone(phoneNumber)){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    @Override
    public List<CatsVO> getAllCats() {
        List<Cats> catsList = catsMapper.selectAllCats();
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats: catsList){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    //--------------------------------------------------------------add
    @Override
    public Cats addCats(Cats cats) {
        catsMapper.insertCats(cats);

        return cats;

    }
    //--------------------------------------------------------------update
    @Override
    public boolean updateCatsById(int id, Cats cats) {
        return catsMapper.updateCatsById(id,cats);
    }
    //--------------------------------------------------------------delete
    @Override
    public boolean deleteCatsById(int id) {
        return catsMapper.deleteCatsById(id);
    }
}
