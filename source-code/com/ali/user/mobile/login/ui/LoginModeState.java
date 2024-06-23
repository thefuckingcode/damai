package com.ali.user.mobile.login.ui;

import com.ali.user.mobile.ui.R;

/* JADX WARN: Init of enum SCAN_FACE can be incorrect */
/* JADX WARN: Init of enum BIOMETRIC can be incorrect */
/* compiled from: Taobao */
public enum LoginModeState {
    LOCATION(8, 0, 8, 8, R.string.aliuser_common_ok, 8),
    SMS_LOGIN(0, R.string.aliuser_login_sms_login, 8, 8, R.string.aliuser_signup_verification_getCode, 8),
    PASSWORD(8, R.string.aliuser_login_pwd_login, 0, 0, R.string.aliuser_sign_in_title, 8),
    SCAN_FACE(8, r17, 8, 8, r17, 8),
    SIM_LOGIN(0, 0, 8, 8, R.string.aliuser_agree_and_onekey_login, 0),
    BIOMETRIC(8, r17, 8, 8, r17, 8);
    
    public final int loginBtnText;
    public final int loginModeName;
    public final int passwordVisibility;
    public final int protocolVisibility;
    public final int regionTVVisibility;
    public final int rightFuncTVVisibility;

    static {
        int i = R.string.aliuser_scan_login_text;
        int i2 = R.string.aliuser_finger_button_text;
    }

    private LoginModeState(int i, int i2, int i3, int i4, int i5, int i6) {
        this.regionTVVisibility = i;
        this.loginModeName = i2;
        this.rightFuncTVVisibility = i3;
        this.passwordVisibility = i4;
        this.loginBtnText = i5;
        this.protocolVisibility = i6;
    }
}
