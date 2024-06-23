package com.taobao.tao.remotebusiness.auth;

import mtopsdk.common.util.StringUtils;

/* compiled from: Taobao */
public class AuthParam {
    public String apiInfo;
    public String bizParam;
    public String failInfo;
    public String openAppKey = "DEFAULT_AUTH";
    public boolean showAuthUI;

    public AuthParam(String str, String str2, boolean z) {
        if (StringUtils.isNotBlank(str)) {
            this.openAppKey = str;
        }
        this.bizParam = str2;
        this.showAuthUI = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("AuthParam{ openAppKey=");
        sb.append(this.openAppKey);
        sb.append(", bizParam=");
        sb.append(this.bizParam);
        sb.append(", showAuthUI=");
        sb.append(this.showAuthUI);
        sb.append(", apiInfo=");
        sb.append(this.apiInfo);
        sb.append(", failInfo=");
        sb.append(this.failInfo);
        sb.append("}");
        return sb.toString();
    }
}
