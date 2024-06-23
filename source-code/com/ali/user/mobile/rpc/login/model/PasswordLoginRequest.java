package com.ali.user.mobile.rpc.login.model;

/* compiled from: Taobao */
public class PasswordLoginRequest extends LoginRequestBase {
    public String hid;
    public String loginId;
    public String loginType = "taobao";
    public String password;
    public boolean pwdEncrypted = false;
}
