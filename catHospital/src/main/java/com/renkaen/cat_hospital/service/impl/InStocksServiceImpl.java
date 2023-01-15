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
            inStocksJoinInboundVO.setId(inStocksJoinInboundDTO.getInStocksId());
            List<InboundVO> inboundVOList = new ArrayList<>();
            if(inStocksJoinInboundDTO.getInbound()!=null){
                for(Inbound inbound:inStocksJoinInboundDTO.getInbound()){
                    inboundVOList.add(new InboundVO(inbound));
                }
            }
            inStocksJoinInboundVO.setInbound(inboundVOList);
            inStocksJoinInboundVOList.add(inStocksJoinInboundVO);
        }
        return inStocksJoinInboundVOList;
    }

    @Override
    public InStocksVO updateInStocksById(int id, InStocks inStocks) {
        if(inStocksMapper.updateInStocksById(id,inStocks)){
            return doToVo(inStocksMapper.selectInStocksById(id));
        };
        return null;
    }

    @Override
    public InStocksVO addInStocks(InStocks inStocks) {
        inStocksMapper.insertInStocks(inStocks);
        return doToVo(inStocks);
    }

    @Override
    public boolean deleteInStocksById(int id) {
        return inStocksMapper.deleteInStocksById(id);
    }

    private InStocksVO doToVo(InStocks inStocks){
        InStocksVO inStocksVO = new InStocksVO();
        BeanUtils.copyProperties(inStocks,inStocksVO);
        inStocksVO.setId(inStocks.getInStockId());
        return inStocksVO;
    }
}
