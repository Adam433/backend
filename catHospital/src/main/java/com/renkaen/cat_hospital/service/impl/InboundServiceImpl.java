package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import com.renkaen.cat_hospital.bean.VO.InboundVO;
import com.renkaen.cat_hospital.mapper.InboundMapper;
import com.renkaen.cat_hospital.service.InboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundServiceImpl implements InboundService {
    @Autowired
    private InboundMapper inboundMapper;

    @Override
    public InboundVO getById(int id) {
        return new InboundVO(inboundMapper.selectById(id));
    }

    @Override
    public InboundVO addInbound(Inbound inbound) {
        inboundMapper.insertInbound(inbound);
        return new InboundVO(inbound);
    }

    @Override
    public boolean deleteInboundById(int id) {
        return inboundMapper.deleteInboundById(id);
    }

    @Override
    public Inbound updateInboundById(int id, Inbound inbound) {
        if (inboundMapper.updateInboundById(id,inbound)){
            return inboundMapper.selectById(id);
        }
        return null;
    }
}
