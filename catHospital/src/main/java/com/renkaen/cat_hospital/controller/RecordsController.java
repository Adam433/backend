package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.Records;
import com.renkaen.cat_hospital.bean.VO.RecordsVO;
import com.renkaen.cat_hospital.bean.VO.RecordsJoinCatsVO;
import com.renkaen.cat_hospital.service.impl.RecordsServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("records")
public class RecordsController {
    @Autowired
    private RecordsServiceImpl recordsService;
    //--------------------------------------------------------------get
    @GetMapping("/{recordsId}")
    public RecordsVO getRecordsById(@PathVariable("recordsId") int recordsId){
        return recordsService.getById(recordsId);
    }
    //根据账单完成情况查询所有的病历
    @GetMapping("/bill/{bill}")
    public List<RecordsJoinCatsVO> getRecordByBill(@PathVariable("bill")int bill){
        return recordsService.getByBill(bill);
    }
    //获取助手应该处理的病历
    @GetMapping("/assistant")
    public List<RecordsJoinCatsVO> getRecordByAssistant(){
        return recordsService.getByAssistant();
    }
    //获得应该由某位医生处理的病历
    @GetMapping("/doctor/{staffId}")
    public List<RecordsJoinCatsVO> getRecordByStaffId(@PathVariable("staffId")int staffId){
        return recordsService.getByStaffId(staffId);
    }
    //获得某位医生应该处理的某个时间段内预约的病历
    @GetMapping("/{timeStart}/{timeEnd}/{staffId}")
    public  List<RecordsVO> getRecordByTimeAndStaffId(@PathVariable("timeStart")long timeStart,
                                                      @PathVariable("timeEnd")long timeEnd,
                                                      @PathVariable("staffId")int staffId){
        return recordsService.getByTimeAndStaffId(timeStart,timeEnd,staffId);
    }
    //获得从某个时间点开始，以后的所有的病历
    @GetMapping("timestart/{timeStart}")
    public List<RecordsJoinCatsVO> getRecordsByTime(@PathVariable("timeStart")long timeStart){
        return recordsService.getRecordsByTime(timeStart);
    }
    //--------------------------------------------------------------update\delete\add
    @PostMapping("")
    public Object addRecords(@RequestBody RecordsVO recordsVO){
        if (
                recordsVO.getCatId() >0 &&
                        recordsVO.getDate() >0 &&
                        recordsVO.getStaffId() >0 &&
                        recordsVO.getReserve() != null &&
                        recordsVO.getBill() != null &&
                        StringUtils.isNotBlank(recordsVO.getWeight())
        ){
            boolean inputType = recordsService.createRecords(recordsVO);
            return inputType? recordsVO:"数据库写入失败";
        }else {
            return "字段不齐";
        }
    };

    @PatchMapping("/{recordsId}")
    public Object updateRecordsById(@PathVariable("recordsId") int recordsId , @RequestBody RecordsVO recordsVO){
        if (
                ( recordsVO.getCatId()==null||recordsVO.getCatId() >0 ) &&
                        (recordsVO.getDate()==null || recordsVO.getDate() >0 ) &&
                        ( recordsVO.getStaffId()==null || recordsVO.getStaffId() >0 ) &&
                        (recordsVO.getReserve() == null|| recordsVO.getReserve() == 1||recordsVO.getReserve() == 0) &&
                        (recordsVO.getBill() == null || (recordsVO.getBill()>=0 && recordsVO.getBill()<=2 ) )
        ){
            RecordsVO updateSuccess = recordsService.updateRecordsById(recordsId, recordsVO);
            return  updateSuccess!=null?updateSuccess:"数据更新失败";
        }
        return "数据格式有误";
    };

    @DeleteMapping("/{recordsId}")
    public String deleteRecordsById(@PathVariable("recordsId") int recordsId){
        return recordsService.deleteRecordsById(recordsId)?"成功删除":"无此id数据";
    }
}
