package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.InStocks;
import com.renkaen.cat_hospital.bean.VO.InStocksJoinInboundVO;
import com.renkaen.cat_hospital.bean.VO.InStocksVO;
import com.renkaen.cat_hospital.service.impl.InStocksServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inStocks")
public class InStocksController {
    @Autowired
    private InStocksServiceImpl inStocksService;
    //--------------------------------------------------------------get
    @GetMapping("/{inStocksId}")
    @PreAuthorize("hasAnyRole('admin','assistant','doctor')")
    public InStocksVO getByInStocksId(@PathVariable("inStocksId") int inStocksId){
        return inStocksService.getById(inStocksId);
    }
    @GetMapping("")
    @PreAuthorize("hasAnyRole('admin','assistant','doctor')")
    public List<InStocksVO> getAll(){
        return inStocksService.getAll();
    }
    @GetMapping("/type/{type}")
    @PreAuthorize("hasAnyRole('admin','assistant','doctor')")
    public List<InStocksJoinInboundVO> getAllinStockJoinInbound(@PathVariable("type")int type){
        return inStocksService.getAllInStocksJoinInbound(type);
    }
    //--------------------------------------------------------------update\delete\add
    @PatchMapping("/{inStocksId}")
    @PreAuthorize("hasAnyRole('admin','assistant','doctor')")
    public Object updateInStocksById (@PathVariable("inStocksId") int inStocksId, @RequestBody InStocksVO inStocksVO ){
        if((inStocksVO.getType()==null||inStocksVO.getType()==1||inStocksVO.getType()==0)&&
                (inStocksVO.getConsumed()==null||inStocksVO.getConsumed()>=0)&&
                (inStocksVO.getKey()==null||inStocksVO.getKey()>=0)&&
                (inStocksVO.getSellPrice()==null||inStocksVO.getSellPrice()>=0)&&
                (inStocksVO.getName()==null || StringUtils.isNotBlank(inStocksVO.getName()))
        ){
            return inStocksService.updateInStocksById(inStocksId,voToDo(inStocksVO));
        };
        return "??????????????????";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('admin','assistant')")
    public Object addInStocks (@RequestBody InStocksVO inStocksVO){
        if(
                (inStocksVO.getType()!=null&&inStocksVO.getType()==1||inStocksVO.getType()==0)&&
                        (inStocksVO.getConsumed()!=null&&inStocksVO.getConsumed()>=0)&&
                        (inStocksVO.getKey()!=null&&inStocksVO.getKey()>=0)&&
                        (inStocksVO.getSellPrice()!=null&&inStocksVO.getSellPrice()>=0)&&
                        StringUtils.isNotBlank(inStocksVO.getName())
        ){
            return inStocksService.addInStocks(voToDo(inStocksVO));
        }
        return "??????????????????";
    }

    @DeleteMapping("/{inStocksId}")
    @PreAuthorize("hasAnyRole('admin','assistant')")
    public String deleteInStocksById(@PathVariable("inStocksId")int inStocksId){
        return inStocksService.deleteInStocksById(inStocksId)?"????????????":"??????id??????";
    }

    private InStocks voToDo(InStocksVO inStocksVO){
        InStocks inStocks = new InStocks();
        BeanUtils.copyProperties(inStocksVO,inStocks);
        inStocks.setInStockId(inStocksVO.getId());
        return inStocks;
    }
}
