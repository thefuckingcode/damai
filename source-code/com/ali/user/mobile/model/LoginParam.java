package com.ali.user.mobile.model;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public class LoginParam implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public boolean alipayInstalled;
    public String bindProtocolUrl;
    public String biometricId;
    public boolean callRpc;
    public String codeLength;
    public String countryCode;
    public String deviceTokenKey;
    public boolean enableVoiceSMS = false;
    public String errorCode;
    public Map<String, String> externParams;
    public boolean goSMS = true;
    public String h5QueryString;
    public long havanaId;
    public String headImg;
    public String helpUrl;
    public boolean isFoundPassword;
    public boolean isFromAccount = false;
    public boolean isFromRegister;
    public String loginAccount;
    public String loginPassword;
    public int loginSite;
    public String loginSourcePage;
    public String loginSourceSpm;
    public String loginSourceType;
    public String loginType;
    public String nativeLoginType;
    public String phoneCode;
    public RegionInfo regionInfo;
    public String scene;
    public boolean sendLoginFailWhenWebviewCancel;
    public String smsCode;
    public String smsSid;
    public String snsToken;
    public String snsType;
    public String source;
    public String spm;
    public boolean supportOverseaMobile = true;
    public String token;
    public String tokenType = TokenType.LOGIN;
    public String traceId;

    @Override // java.lang.Object
    public LoginParam clone() {
        try {
            return (LoginParam) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
