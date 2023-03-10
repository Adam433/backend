package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.InStocks;
import com.renkaen.cat_hospital.bean.VO.InStocksJoinInboundVO;
import com.renkaen.cat_hospital.bean.VO.InStocksVO;

import java.util.List;

public interface InStocksService {
    InStocksVO getById(int id);
    List<InStocksVO> getAll();
    List<InStocksJoinInboundVO> getAllInStocksJoinInbound(int type);

    InStocksVO updateInStocksById(int id, InStocks inStocks);
    InStocksVO addInStocks(InStocks inStocks);
    boolean deleteInStocksById(int id);
}
