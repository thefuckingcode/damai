package com.youku.usercenter.passport.result;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import tb.jl1;

/* compiled from: Taobao */
public class LoginRequestBase extends MemberRequestBase {
    public String deviceName = (Build.getBRAND() + jl1.BRACKET_START_STR + Build.getMODEL() + jl1.BRACKET_END_STR);
    public String deviceTokenKey;
    public String deviceTokenSign;
    public String hid;
    public String sid;
    public String snsToken;
    public long t;
    public boolean useAcitonType = true;
    public boolean useDeviceToken = true;
}
