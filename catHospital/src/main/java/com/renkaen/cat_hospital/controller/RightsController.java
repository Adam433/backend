package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.Rights;
import com.renkaen.cat_hospital.bean.VO.RightsVO;
import com.renkaen.cat_hospital.service.impl.RightServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rights")
public class RightsController {
    @Autowired
    private RightServiceImpl rightServiceImpl;

    @GetMapping("/{rightId}")
    public RightsVO getRightsById(@PathVariable("rightId") int rightId){
        return new RightsVO(rightServiceImpl.getById(rightId));
    }

    @PatchMapping("/{rightId}")
    public Object updateRightsById(@PathVariable("rightId") int rightId,@RequestBody RightsVO rightsVO){
        if(rightsVO.getRights()!=null&& StringUtils.isNotBlank(rightsVO.getRights().toString()) ){
            Rights r = new Rights();
            r.setRights(rightsVO.getRights().toString());
            return rightServiceImpl.updateRightsById(rightId,r)?rightsVO:"更新失败";
        }
        return "数据格式异常";
    }
}
