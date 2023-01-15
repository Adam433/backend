package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DTO.StaffJoinShowedDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StaffJoinShowedVO {
    public StaffJoinShowedVO(StaffJoinShowedDTO staffJoinShowedDTO){
        id= staffJoinShowedDTO.getStaffId();
        username = staffJoinShowedDTO.getUsername();
        password= staffJoinShowedDTO.getPassword();
        name= staffJoinShowedDTO.getRealName();
        key = staffJoinShowedDTO.getKey();
        intro=staffJoinShowedDTO.getIntro();
        zaishoku=staffJoinShowedDTO.getZaishoku();
        avatar=staffJoinShowedDTO.getAvatar();
        showed=staffJoinShowedDTO.getShowed();
        katagaki = staffJoinShowedDTO.getKatagaki();
    }
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Long key;
    private String intro;
    private Integer zaishoku;
    private String avatar;
    private List<String> showed;
    private List<String> katagaki;
}
