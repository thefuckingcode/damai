package com.ali.user.open.session;

import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class InternalSession {
    public String autoLoginToken;
    public String avatarUrl;
    public String bindToken;
    public String deviceTokenKey;
    public String deviceTokenSalt;
    public String email;
    public long expireIn;
    public String[] externalCookies;
    public String loginId;
    public long loginTime;
    public String mobile;
    public String nick;
    public String openId;
    public String openSid;
    public Map<String, Object> otherInfo;
    public String sid;
    public String site;
    public String topAccessToken;
    public String topAuthCode;
    public String topExpireTime;
    public String userId;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InternalSession [sid=");
        sb.append(this.sid);
        sb.append(", expireIn=");
        sb.append(this.expireIn);
        sb.append(", loginTime=");
        sb.append(this.loginTime);
        sb.append(", autoLoginToken=");
        sb.append(this.autoLoginToken);
        sb.append(",topAccessToken=");
        sb.append(this.topAccessToken);
        sb.append(",topAuthCode");
        sb.append(this.topAuthCode);
        sb.append(",topExpireTime");
        sb.append(this.topExpireTime);
        sb.append(", otherInfo=");
        sb.append(this.otherInfo);
        sb.append(", cookies=");
        String[] strArr = this.externalCookies;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
            }
        } else {
            sb.append("null");
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }
}
