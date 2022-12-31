package com.renkaen.cat_hospital.bean.PO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cats {
    private Integer id;
    private String nickname;
    private String catOwner;
    private String phoneNumber;
    private Long birthday;
    private Long keyTime;
    private String vaccine;
    private String vermifuge;
    private Integer sex;
    private Integer sterilize;
}
