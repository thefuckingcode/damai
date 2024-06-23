package com.ali.user.open.cookies;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.Constants;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.FileUtils;
import com.ali.user.open.service.impl.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import java.util.ArrayList;

/* compiled from: Taobao */
public class CookieManagerWrapper {
    public static final CookieManagerWrapper INSTANCE = new CookieManagerWrapper();
    private static final String TAG = "CookieManagerWrapper";

    private CookieManagerWrapper() {
    }

    public static String generateCookie(String str, String str2, String str3, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";");
        sb.append("domain=");
        sb.append(str);
        sb.append(";");
        sb.append("path=/;");
        if (z) {
            sb.append("HttpOnly");
        }
        String sb2 = sb.toString();
        Log.e("Ucc.Passport", "PassportCookie: " + sb2);
        return sb2;
    }

    private String getDomainBySite(String str) {
        if (TextUtils.equals(str, "taobao")) {
            return ".taobao.com";
        }
        if (TextUtils.equals(str, "alipay")) {
            return ".alipay.com";
        }
        if (TextUtils.equals(str, "damai")) {
            return ".damai.cn";
        }
        if (TextUtils.equals(str, Site.ELEME)) {
            return ".ele.me";
        }
        if (TextUtils.equals(str, Site.ICBU)) {
            return ".alibaba.com";
        }
        return TextUtils.equals(str, Site.XIANYU) ? ".goofish.com" : "";
    }

    public void clearCookies(String str) {
        clearCookies(str, "");
    }

    public String getCoookieBackupFileNameBySite(String str) {
        return Constants.COOKIES + str + "_backup";
    }

    public String getCoookieFileNameBySite(String str) {
        return Constants.COOKIES + str;
    }

    public synchronized void injectCookie(String str, String[] strArr, String[] strArr2) {
        if (KernelContext.getApplicationContext() != null) {
            if (strArr != null) {
                SDKLogger.d(TAG, "injectCookie cookies != null");
                ArrayList<LoginCookie> arrayList = new ArrayList();
                String domainBySite = getDomainBySite(str);
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            LoginCookie parseCookie = LoginCookieUtils.parseCookie(str2);
                            String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                            String loginCookie = parseCookie.toString();
                            SDKLogger.d(TAG, "add cookie: " + loginCookie);
                            CookieManagerService.getWebViewProxy().setCookie(httpDomin, loginCookie);
                            if (TextUtils.equals(parseCookie.domain, domainBySite)) {
                                arrayList.add(parseCookie);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (strArr2 != null && strArr2.length > 0 && !arrayList.isEmpty()) {
                    for (LoginCookie loginCookie2 : arrayList) {
                        String str3 = loginCookie2.domain;
                        for (String str4 : strArr2) {
                            loginCookie2.domain = str4;
                            String httpDomin2 = LoginCookieUtils.getHttpDomin(loginCookie2);
                            String loginCookie3 = loginCookie2.toString();
                            SDKLogger.d(TAG, "add cookies to domain:" + str4 + ", cookie = " + loginCookie3);
                            CookieManagerService.getWebViewProxy().setCookie(httpDomin2, loginCookie3);
                        }
                        loginCookie2.domain = str3;
                    }
                }
                CookieManagerService.getWebViewProxy().flush();
                if (strArr.length > 0) {
                    FileUtils.writeFileData(KernelContext.getApplicationContext(), getCoookieFileNameBySite(str), TextUtils.join(Constants.COOKIE_SPLIT, strArr));
                    FileUtils.writeFileData(KernelContext.getApplicationContext(), getCoookieBackupFileNameBySite(str), TextUtils.join(Constants.COOKIE_SPLIT, strArr));
                }
            } else {
                clearCookies(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034 A[SYNTHETIC] */
    public synchronized void refreshCookie(String str) {
        String[] strArr;
        try {
            String readFileData = FileUtils.readFileData(KernelContext.getApplicationContext(), getCoookieFileNameBySite(str));
            if (!TextUtils.isEmpty(readFileData)) {
                SDKLogger.d(TAG, "get cookie from storage:" + readFileData);
                strArr = TextUtils.split(readFileData, Constants.COOKIE_SPLIT);
                if (strArr != null) {
                    injectCookie(str, strArr, null);
                }
            }
        } catch (Throwable unused) {
        }
        strArr = null;
        if (strArr != null) {
        }
    }

    public void clearCookies(String str, String str2) {
        String[] strArr;
        Object obj;
        SDKLogger.e("clearCookies", "into clearCookies ");
        CookieSyncManager.createInstance(KernelContext.getApplicationContext());
        SDKLogger.e("clearCookies", "into clearCookies removeSessionCookie finish");
        if (TextUtils.isEmpty(str2)) {
            str2 = FileUtils.readFileData(KernelContext.getApplicationContext(), getCoookieFileNameBySite(str));
        }
        String[] strArr2 = null;
        if (!TextUtils.isEmpty(str2)) {
            SDKLogger.d(TAG, "get cookie from storage:" + str2);
            strArr = TextUtils.split(str2, Constants.COOKIE_SPLIT);
        } else {
            strArr = null;
        }
        SDKLogger.e("clearCookies", "into clearCookies readFileData finish");
        if (strArr != null) {
            ArrayList<LoginCookie> arrayList = new ArrayList();
            String domainBySite = getDomainBySite(str);
            for (String str3 : strArr) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        LoginCookie parseCookie = LoginCookieUtils.parseCookie(str3);
                        if (!"munb".equals(parseCookie.name)) {
                            String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                            LoginCookieUtils.expiresCookies(parseCookie);
                            CookieManagerService.getWebViewProxy().setCookie(httpDomin, parseCookie.toString());
                            if (TextUtils.equals(parseCookie.domain, domainBySite)) {
                                arrayList.add(parseCookie);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                SessionManager sessionManager = SessionManager.INSTANCE;
                if (!(sessionManager.getInternalSession(str) == null || sessionManager.getInternalSession(str).otherInfo == null || (obj = sessionManager.getInternalSession(str).otherInfo.get(SessionConstants.SSO_DOMAIN_LIST)) == null || !(obj instanceof ArrayList))) {
                    strArr2 = (String[]) ((ArrayList) obj).toArray(new String[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (strArr2 != null && strArr2.length > 0 && !arrayList.isEmpty()) {
                for (LoginCookie loginCookie : arrayList) {
                    String str4 = loginCookie.domain;
                    for (String str5 : strArr2) {
                        loginCookie.domain = str5;
                        String httpDomin2 = LoginCookieUtils.getHttpDomin(loginCookie);
                        LoginCookieUtils.expiresCookies(loginCookie);
                        CookieManagerService.getWebViewProxy().setCookie(httpDomin2, loginCookie.toString());
                    }
                    loginCookie.domain = str4;
                }
            }
            SDKLogger.d(TAG, "injectCookie cookies is null");
            FileUtils.writeFileData(KernelContext.getApplicationContext(), getCoookieFileNameBySite(str), "");
        }
        SDKLogger.e("clearCookies", "into clearCookies reset cookie finish");
        CookieManagerService.getWebViewProxy().removeExpiredCookie();
        SDKLogger.e("clearCookies", "into clearCookies removeExpiredCookie finish");
        CookieManagerService.getWebViewProxy().flush();
        SDKLogger.e("clearCookies", "into clearCookies  finish");
    }
}
