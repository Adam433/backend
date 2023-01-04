package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import com.renkaen.cat_hospital.bean.VO.InboundVO;

public interface InboundService {
    InboundVO getById(int id);
    boolean addInbound(Inbound inbound);
    boolean deleteInboundById(int id);
    boolean updateInboundById(int id, Inbound inbound);
}
