package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Cats;
import com.renkaen.cat_hospital.bean.DO.Vaccine;
import com.renkaen.cat_hospital.bean.DO.Vermifuge;
import com.renkaen.cat_hospital.bean.DTO.CatsDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CatsVO {
    public CatsVO(CatsDTO cats){
        List<Long> vaccineList = new ArrayList<>();
        List<Long> vermifugeList = new ArrayList<>();
        for (Vaccine vaccine1 : cats.getVaccine()) {
            vaccineList.add(vaccine1.getDate());
        }
        for (Vermifuge vermifuge1 : cats.getVermifuge()) {
            vermifugeList.add(vermifuge1.getDate());
        }
        id = cats.getCatId();
        nickname=cats.getNickname();
        catOwner=cats.getCatOwner();
        phoneNumber=cats.getPhoneNumber();
        birthday=cats.getBirthday();
        key=cats.getKey();
        vaccine=vaccineList;
        vermifuge=vermifugeList;
        sex=cats.getSex();
        sterilize=cats.getSterilize();
    }
    private Integer id;
    private String nickname;
    private String catOwner;
    private String phoneNumber;
    private Long birthday;
    private Long key;
    private List<Long> vaccine;
    private List<Long> vermifuge;
    private Integer sex;
    private Integer sterilize;
}
