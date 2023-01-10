package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cats {
    private Integer catId;
    private String nickname;
    private String catOwner;
    private String phoneNumber;
    private Long birthday;
    private Long key;
    private Integer sex;
    private Integer sterilize;
}
