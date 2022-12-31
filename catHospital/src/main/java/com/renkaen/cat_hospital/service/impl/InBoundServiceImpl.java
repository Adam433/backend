package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.PO.Inbound;
import com.renkaen.cat_hospital.bean.VO.InboundVO;
import com.renkaen.cat_hospital.mapper.InboundMapper;
import com.renkaen.cat_hospital.service.InboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InBoundServiceImpl implements InboundService {
    @Autowired
    private InboundMapper inboundMapper;

    @Override
    public InboundVO getById(int id) {
        return new InboundVO(inboundMapper.selectById(id));
    }

    @Override
    public boolean addInbound(Inbound inbound) {
        return inboundMapper.insertInbound(inbound);
    }

    @Override
    public boolean deleteInboundById(int id) {
        return inboundMapper.deleteInboundById(id);
    }

    @Override
    public boolean updateInboundById(int id, Inbound inbound) {
        return inboundMapper.updateInboundById(id,inbound);
    }
}
