package com.youku.skinmanager.http;

import com.youku.mtop.common.SystemInfo;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* compiled from: Taobao */
public class MtopSkinLoadRequest implements IMTOPDataObject {
    public String API_NAME;
    public String VERSION;
    public String skinId;
    public String system_info;

    public MtopSkinLoadRequest() {
        this.API_NAME = "mtop.youku.haidai.themeskin.getskininfo";
        this.VERSION = "1.0";
        this.system_info = null;
        this.system_info = new SystemInfo().toString();
    }

    public Map<String, Object> buildRequestParams() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("skinid", this.skinId);
        hashMap.put("system_info", this.system_info);
        return hashMap;
    }
}
