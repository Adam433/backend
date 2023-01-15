package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.VO.StaffJoinShowedVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StaffJoinShowedDTO {
    public StaffJoinShowedDTO(StaffJoinShowedVO staffJoinShowedVO) {
        staffId = staffJoinShowedVO.getId();
        username = staffJoinShowedVO.getUsername();
        password = staffJoinShowedVO.getPassword();
        realName = staffJoinShowedVO.getName();
        key = staffJoinShowedVO.getKey();
        intro = staffJoinShowedVO.getIntro();
        zaishoku = staffJoinShowedVO.getZaishoku();
        avatar = staffJoinShowedVO.getAvatar();
        showed = staffJoinShowedVO.getShowed();
        katagaki = staffJoinShowedVO.getKatagaki();
    }

    private Integer staffId;
    private String username;
    private String password;
    private String realName;
    private Long key;
    private String intro;
    private Integer zaishoku;
    private String avatar;
    private List<String> showed;
    private List<String> katagaki;
}
