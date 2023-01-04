package com.renkaen.cat_hospital;


import com.renkaen.cat_hospital.controller.StaffController;
import com.renkaen.cat_hospital.service.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class CatHospitalApplicationTests {
    @Autowired
    private RightServiceImpl rightService;
    @Autowired
    private CatsServiceImpl catsService;
    @Autowired
    private RolesServiceImpl rolesService;
    @Autowired
    private StaffServiceImpl staffService;
    @Autowired
    private InStocksServiceImpl inStocksService;
    @Autowired
    private RecordsServiceImpl recordsService;
    @Autowired
    private InBoundServiceImpl inBoundService;
    @Autowired
    private StaffController staffController;
    @Autowired
    private PermissionServiceImpl rolePermissionService;
    @Test
    void testPassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("Qwer4321"));
    }

    @Test
    void controller() {
        System.out.println(staffController.getStaffById(1));
    }
    @Test
    void rightServiceById() {
        System.out.println(rightService.getById(1));
    }
    @Test
    void rolesServiceById() {
        System.out.println(rolesService.getById(1));
    }
    @Test
    void staffServiceById() {
        System.out.println(staffService.getById(1));
    }

    @Test
    void catServiceById() {
        System.out.println(catsService.getById(1));
    }
    @Test
    void inStockServiceById() {
        System.out.println(inStocksService.getById(1));
    }
    @Test
    void recordsServiceById() {
        System.out.println(recordsService.getById(1));
    }
    @Test
    void inboundServiceById() {
        System.out.println(inBoundService.getById(1));
    }

}
