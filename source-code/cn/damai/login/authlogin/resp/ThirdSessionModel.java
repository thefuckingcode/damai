package cn.damai.login.authlogin.resp;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ThirdSessionModel implements Serializable {
    public String bizType;
    public ArrayList<CookieBean> cookies;
    public Extra extra;
    public boolean hasAllow;

    /* compiled from: Taobao */
    public static class Extra implements Serializable {
        public AuthInfoBean authorizePageInfo;
    }
}
