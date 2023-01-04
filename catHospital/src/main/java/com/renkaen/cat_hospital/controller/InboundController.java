package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import com.renkaen.cat_hospital.bean.VO.InboundVO;
import com.renkaen.cat_hospital.service.impl.InBoundServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inbound")
public class InboundController {
    @Autowired
    private InBoundServiceImpl inBoundService;

    @GetMapping("/{inboundId}")
    public InboundVO getByInboundId(@PathVariable("inboundId") int inboundId){
        return inBoundService.getById(inboundId);
    };

    @PostMapping("/add")
    public Object addInbound(@RequestBody InboundVO inboundVO){
        if( (inboundVO.getAmount()!=null && inboundVO.getAmount()>0) &&
                (inboundVO.getKey()!=null && inboundVO.getKey()>0) &&
                (inboundVO.getInStockId()!=null && inboundVO.getInStockId()>0) &&
                (inboundVO.getPurchasePrice()!=null && inboundVO.getPurchasePrice()>=0)&&
                StringUtils.isNotBlank(inboundVO.getBatchNumber()) &&
                StringUtils.isNotBlank(inboundVO.getStaff()) ){
            return inBoundService.addInbound(voToDo(inboundVO))? inboundVO : "数据添加失败";
        }
        return "数据格式有误";
    }

    @DeleteMapping("/{inboundId}")
    public String deleteInboundById(@PathVariable("inboundId") int inboundId){
        return inBoundService.deleteInboundById(inboundId)?"成功删除":"不存在此id数据";
    }

    @PatchMapping("/{inboundId}")
    public Object updateInboundById(@PathVariable("inboundId")int inboundId,@RequestBody InboundVO inboundVO){
        if ( (inboundVO.getAmount()==null || inboundVO.getAmount()>0) &&
                (inboundVO.getKey()==null || inboundVO.getKey()>0) &&
                (inboundVO.getInStockId()==null || inboundVO.getInStockId()>0) &&
                (inboundVO.getPurchasePrice()==null || inboundVO.getPurchasePrice()>=0)&&
                ( inboundVO.getBatchNumber()==null || StringUtils.isNotBlank(inboundVO.getBatchNumber()) )&&
                ( inboundVO.getStaff() ==null || StringUtils.isNotBlank(inboundVO.getStaff()) ) ){
           return inBoundService.updateInboundById(inboundId,voToDo(inboundVO))?inboundVO:"更新失败";
        }
        return "数据格式错误";
    }

    private Inbound voToDo(InboundVO inboundVO){
        Inbound inbound = new Inbound();
        BeanUtils.copyProperties(inboundVO,inbound);
        inbound.setKeyTime(inboundVO.getKey());
        return inbound;
    }
}
