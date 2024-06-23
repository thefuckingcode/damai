package com.alibaba.security.realidentity.business.biometrics.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* compiled from: Taobao */
public class RiskActionMaterial implements Serializable {
    @JSONField(name = "flActionLog")
    public String flActionLog;
    @JSONField(name = "sensorActionLog")
    public String sensorActionLog;
}
