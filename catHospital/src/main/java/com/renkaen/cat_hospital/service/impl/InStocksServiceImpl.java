package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.InStocksJoinInboundDTO;
import com.renkaen.cat_hospital.bean.DO.InStocks;
import com.renkaen.cat_hospital.bean.DO.Inbound;
import com.renkaen.cat_hospital.bean.VO.InStocksJoinInboundVO;
import com.renkaen.cat_hospital.bean.VO.InStocksVO;
import com.renkaen.cat_hospital.bean.VO.InboundVO;
import com.renkaen.cat_hospital.mapper.InStocksMapper;
import com.renkaen.cat_hospital.service.InStocksService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InStocksServiceImpl implements InStocksService {
    @Autowired
    private InStocksMapper inStocksMapper;
    @Override
    public InStocksVO getById(int id) {
        return doToVo(inStocksMapper.selectInStocksById(id));
    }

    @Override
    public List<InStocksVO> getAll() {
        List<InStocksVO> inStocksVOList = new ArrayList<>();
        for(InStocks inStocks:inStocksMapper.selectInStocksAll()){
            inStocksVOList.add(doToVo(inStocks));
        }
        return inStocksVOList;
    }

    @Override
    public List<InStocksJoinInboundVO> getAllInStocksJoinInbound(int type) {
        List<InStocksJoinInboundVO> inStocksJoinInboundVOList = new ArrayList<>();
        for (InStocksJoinInboundDTO inStocksJoinInboundDTO:inStocksMapper.selectInStocksJoinInboundByType(type)){
            InStocksJoinInboundVO inStocksJoinInboundVO = new InStocksJoinInboundVO();
            BeanUtils.copyProperties(inStocksJoinInboundDTO,inStocksJoinInboundVO);
            inStocksJoinInboundVO.setKey(inStocksJoinInboundDTO.getKeyTime());
            inStocksJoinInboundVO.setName(inStocksJoinInboundDTO.getNamae());
            List<InboundVO> inboundVOList = new ArrayList<>();
            for(Inbound inbound:inStocksJoinInboundDTO.getInbound()){
                inboundVOList.add(new InboundVO(inbound));
            }
            inStocksJoinInboundVO.setInbound(inboundVOList);
            inStocksJoinInboundVOList.add(inStocksJoinInboundVO);
        }
        return inStocksJoinInboundVOList;
    }

    @Override
    public boolean updateInStocksById(int id, InStocks inStocks) {
        return inStocksMapper.updateInStocksById(id,inStocks);
    }

    @Override
    public boolean addInStocks(InStocks inStocks) {
        return inStocksMapper.insertInStocks(inStocks);
    }

    @Override
    public boolean deleteInStocksById(int id) {
        return inStocksMapper.deleteInStocksById(id);
    }

    private InStocksVO doToVo(InStocks inStocks){
        InStocksVO inStocksVO = new InStocksVO();
        BeanUtils.copyProperties(inStocks,inStocksVO);
        inStocksVO.setKey(inStocks.getKeyTime());
        inStocksVO.setName(inStocks.getNamae());
        return inStocksVO;
    }
}
