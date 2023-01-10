package com.renkaen.cat_hospital.controller;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.VO.CatsVO;
import com.renkaen.cat_hospital.service.CatsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatsController {
    @Autowired
    private CatsService catsService;

    @GetMapping("/{catId}")
    public CatsVO getCatsById(@PathVariable("catId") int catId) {
        return catsService.getById(catId);
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<CatsVO> getCatsByPhone(@PathVariable("phoneNumber") String phoneNumber) {
        return catsService.getByPhone(phoneNumber);
    }

    @GetMapping("/phonename/{phoneNumber}/{nickname}")
    public List<CatsVO> getCatsByPhoneAndName(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("nickname") String nickname) {
        return catsService.getByPhoneAndName(phoneNumber, nickname);
    }

    @GetMapping("")
    public List<CatsVO> getAllCats() {
        return catsService.getAllCats();
    }

    @PostMapping("")
    public Object addCats(@RequestBody CatsVO catsVO) {
        if (
                StringUtils.isNotBlank(catsVO.getCatOwner()) &&
                        StringUtils.isNotBlank(catsVO.getNickname()) &&
                        StringUtils.isNotBlank(catsVO.getPhoneNumber()) &&
                        (catsVO.getBirthday() != null && catsVO.getBirthday() > 0) &&
                        (catsVO.getKey() != null && catsVO.getKey() > 0) &&
                        (catsVO.getSex() != null && catsVO.getSex() == 0 || catsVO.getSex() == 1) &&
                        (catsVO.getSterilize() != null && catsVO.getSterilize() == 0 || catsVO.getSterilize() == 1)
        ) {
            CatsVO cats = catsService.addCats(catsVO);
            catsVO.setId(cats.getId());
            return catsVO;
        }
        return "数据格式错误";
    }

    @PatchMapping("/{catId}")
    public Object updateCats(@PathVariable("catId") int catId, @RequestBody CatsVO catsVO) {
        if (
                (catsVO.getCatOwner() == null || StringUtils.isNotBlank(catsVO.getCatOwner())) &&
                        (catsVO.getNickname() == null || StringUtils.isNotBlank(catsVO.getNickname())) &&
                        (catsVO.getPhoneNumber() == null || StringUtils.isNotBlank(catsVO.getPhoneNumber())) &&
                        (catsVO.getBirthday() == null || catsVO.getBirthday() > 0) &&
                        (catsVO.getKey() == null || catsVO.getKey() > 0) &&
                        (catsVO.getSex() == null || catsVO.getSex() == 0 || catsVO.getSex() == 1) &&
                        (catsVO.getSterilize() == null || catsVO.getSterilize() == 0 || catsVO.getSterilize() == 1)
        ) {
            boolean updateCat = catsService.updateCatsById(catId, catsVO);
            return updateCat ? catsVO : "数据库更新失败";
        }
        return "数据格式错误";
    }

    @DeleteMapping("/{catId}")
    public String deleteCatsById(@PathVariable("catId") int catId) {
        return catsService.deleteCatsById(catId) ? "成功删除" : "此id数据不存在";
    }

}
