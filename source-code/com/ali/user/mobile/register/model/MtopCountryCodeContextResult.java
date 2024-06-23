package com.ali.user.mobile.register.model;

import com.ali.user.mobile.rpc.login.model.GroupedCountryCode;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class MtopCountryCodeContextResult implements Serializable {
    public List<GroupedCountryCode> countrycodes;
    public String mobile;
    public String sessionId;
}
