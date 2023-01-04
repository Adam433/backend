package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Cats;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

@Data
@NoArgsConstructor
public class CatsVO {
    public CatsVO(Cats cats){
        id = cats.getId();
        nickname=cats.getNickname();
        catOwner=cats.getCatOwner();
        phoneNumber=cats.getPhoneNumber();
        birthday=cats.getBirthday();
        key=cats.getKeyTime();
        vaccine=JSONArray.fromObject(cats.getVaccine());
        vermifuge=JSONArray.fromObject(cats.getVermifuge());
        sex=cats.getSex();
        sterilize=cats.getSterilize();
    }
    private Integer id;
    private String nickname;
    private String catOwner;
    private String phoneNumber;
    private Long birthday;
    private Long key;
    private JSONArray vaccine;
    private JSONArray vermifuge;
    private Integer sex;
    private Integer sterilize;
}
