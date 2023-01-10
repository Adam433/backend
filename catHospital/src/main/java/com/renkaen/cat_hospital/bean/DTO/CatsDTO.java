package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Vaccine;
import com.renkaen.cat_hospital.bean.DO.Vermifuge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatsDTO {
    private Integer catId;
    private String nickname;
    private String catOwner;
    private String phoneNumber;
    private Long birthday;
    private Long key;
    private Integer sex;
    private Integer sterilize;
    private List<Vaccine> vaccine;
    private List<Vermifuge> vermifuge;
}
