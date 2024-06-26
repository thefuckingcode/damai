package com.ali.user.mobile.utils;

/* compiled from: Taobao */
public class Constants {
    public static final String AUTH_TYPE = "authType";
    public static final String FROM_REGIST_KEY = "from_register";
    public static final String RESET_LOGIN_STATUS = "NOTIFY_LOGIN_STATUS_RESET";

    /* compiled from: Taobao */
    public enum AuthType {
        BIND_AUTH("bindAuth"),
        SCAN_BIND_AUTH("scanBindAuth");
        
        private String authType;

        private AuthType(String str) {
            this.authType = str;
        }

        public String getAuthType() {
            return this.authType;
        }
    }
}
