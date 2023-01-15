package com.renkaen.cat_hospital;


import com.renkaen.cat_hospital.bean.DO.Bill;
import com.renkaen.cat_hospital.controller.StaffController;
import com.renkaen.cat_hospital.service.BillService;
import com.renkaen.cat_hospital.service.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class CatHospitalApplicationTests {

    @Autowired
    private BillService billService;
    @Test
    void testInsertBatch(){
        List<Bill> bills = new ArrayList<>();
        Bill bill = new Bill();
        bill.setName("testNamae1");bill.setSellPrice(123.0);bill.setUsage(1);
        Bill bill1 = new Bill();
        bill1.setName("testNamae2");bill1.setSellPrice(124.0);bill1.setUsage(2);
        bills.add(bill);bills.add(bill1);
        System.out.println(bills);
        billService.addBatch( 1,bills);
    }


}
