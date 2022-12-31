package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Rights;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSONObject;

@Data
@NoArgsConstructor
public class RightsVO {
    public RightsVO(Rights r){
        this.rights = JSONObject.fromObject(r.getRights());
    }
    private JSONObject rights;
}
