package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.InStocks;
import com.renkaen.cat_hospital.bean.VO.InStocksJoinInboundVO;
import com.renkaen.cat_hospital.bean.VO.InStocksVO;
import com.renkaen.cat_hospital.service.impl.InStocksServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inStocks")
public class InStocksController {
    @Autowired
    private InStocksServiceImpl inStocksService;
    //--------------------------------------------------------------get
    @GetMapping("/{inStocksId}")
    public InStocksVO getByInStocksId(@PathVariable("inStocksId") int inStocksId){
        return inStocksService.getById(inStocksId);
    }
    @GetMapping("")
    public List<InStocksVO> getAll(){
        return inStocksService.getAll();
    }
    @GetMapping("/type/{type}")
    public List<InStocksJoinInboundVO> getAllinStockJoinInbound(@PathVariable("type")int type){
        return inStocksService.getAllInStocksJoinInbound(type);
    }
    //--------------------------------------------------------------update\delete\add
    @PatchMapping("/{inStocksId}")
    public Object updateInStocksById (@PathVariable("inStocksId") int inStocksId, @RequestBody InStocksVO inStocksVO ){
        if((inStocksVO.getType()==null||inStocksVO.getType()==1||inStocksVO.getType()==0)&&
                (inStocksVO.getConsumed()==null||inStocksVO.getConsumed()>=0)&&
                (inStocksVO.getKey()==null||inStocksVO.getKey()>=0)&&
                (inStocksVO.getSellPrice()==null||inStocksVO.getSellPrice()>=0)&&
                (inStocksVO.getName()==null || StringUtils.isNotBlank(inStocksVO.getName()))
        ){
            boolean react = inStocksService.updateInStocksById(inStocksId,voToDo(inStocksVO));
            return react? inStocksVO:"数据库更新失败";
        };
        return "数据格式不符";
    }

    @PostMapping("/add")
    public Object addInStocks (@RequestBody InStocksVO inStocksVO){
        if(
                (inStocksVO.getType()!=null&&inStocksVO.getType()==1||inStocksVO.getType()==0)&&
                        (inStocksVO.getConsumed()!=null&&inStocksVO.getConsumed()>=0)&&
                        (inStocksVO.getKey()!=null&&inStocksVO.getKey()>=0)&&
                        (inStocksVO.getSellPrice()!=null&&inStocksVO.getSellPrice()>=0)&&
                        StringUtils.isNotBlank(inStocksVO.getName())
        ){
            return inStocksService.addInStocks(voToDo(inStocksVO))?inStocksVO:"数据库添加失败";
        }
        return "数据格式不符";
    }

    @DeleteMapping("/{inStocksId}")
    public String deleteInStocksById(@PathVariable("inStocksId")int inStocksId){
        return inStocksService.deleteInStocksById(inStocksId)?"成功删除":"无此id数据";
    }

    private InStocks voToDo(InStocksVO inStocksVO){
        InStocks inStocks = new InStocks();
        BeanUtils.copyProperties(inStocksVO,inStocks);
        inStocks.setNamae(inStocksVO.getName());
        inStocks.setKeyTime(inStocksVO.getKey());
        return inStocks;
    }
}
