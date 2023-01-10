package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.DO.Vaccine;
import com.renkaen.cat_hospital.bean.DTO.CatsDTO;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.mapper.CatsMapper;
import com.renkaen.cat_hospital.mapper.VaccineMapper;
import com.renkaen.cat_hospital.mapper.VermifugeMapper;
import com.renkaen.cat_hospital.service.CatsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatsServiceImpl implements CatsService {
    @Autowired
    private CatsMapper catsMapper;
    @Autowired
    private VaccineMapper vaccineMapper;
    @Autowired
    private VermifugeMapper vermifugeMapper;
    //--------------------------------------------------------------get
    @Override
    public CatsVO getById(int id) {
        CatsDTO catsDTO = catsMapper.selectById(id);
        if(catsDTO!=null){
        return new CatsVO(catsDTO);}
        return null;
    }
    @Override
    public  List<CatsVO> getByPhoneAndName(String phoneNumber,String nickname) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(CatsDTO catsDTO:catsMapper.selectCatByPhoneNick(phoneNumber,nickname)){
            catsVOList.add(new CatsVO(catsDTO));
        }
        return catsVOList;
    }
    @Override
    public  List<CatsVO> getByPhone(String phoneNumber) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(CatsDTO catsDTO:catsMapper.selectCatByPhone(phoneNumber)){
            catsVOList.add(new CatsVO(catsDTO));
        }
        return catsVOList;
    }
    @Override
    public List<CatsVO> getAllCats() {
        List<CatsDTO> catsList = catsMapper.selectAllCats();
        List<CatsVO> catsVOList = new ArrayList<>();
        for(CatsDTO catsDTO: catsList){
            catsVOList.add(new CatsVO(catsDTO));
        }
        return catsVOList;
    }
    //--------------------------------------------------------------add
    @Override
    public CatsVO addCats(CatsVO catsVO) {
        Cats cats = catsVOtoCAts(catsVO);
        catsMapper.insertCats(cats);
        int catId = cats.getCatId();
        if (catsVO.getVaccine()!=null){
            vaccineMapper.insertByCatId(catId,catsVO.getVaccine());
        }
        if(catsVO.getVermifuge()!=null){
            vermifugeMapper.insertByCatId(catId,catsVO.getVermifuge());
        }
        return catsVO;
    }
    //--------------------------------------------------------------update
    @Override
    public boolean updateCatsById(int id, CatsVO catsVO) {
        vaccineMapper.deleteByCatId(id);
        vermifugeMapper.deleteByCatId(id);
        boolean exist = catsMapper.updateCatsById(id,catsVOtoCAts(catsVO));
        if (catsVO.getVaccine()!=null&&exist){
            vaccineMapper.insertByCatId(id,catsVO.getVaccine());
        }
        if(catsVO.getVermifuge()!=null&&exist){
            vermifugeMapper.insertByCatId(id,catsVO.getVermifuge());
        }
        return exist;
    }
    //--------------------------------------------------------------delete
    @Override
    public boolean deleteCatsById(int id) {
        vaccineMapper.deleteByCatId(id);
        vermifugeMapper.deleteByCatId(id);
        return catsMapper.deleteCatsById(id);
    }

    //VO to DO
    private Cats catsVOtoCAts(CatsVO catsVO) {
        Cats cats = new Cats();
        BeanUtils.copyProperties(catsVO, cats);
        return cats;
    }
}
