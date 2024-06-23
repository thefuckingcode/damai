package com.ut.mini.core.sign;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SecuritySDK {
    private static final String TAG = "SecuritySDK";
    private boolean isInitSecurityCheck = false;
    private String mAppkey = null;
    private String mAuthcode = "";
    private int s_secureIndex = 3;
    private Object s_secureSignatureCompObj = null;
    private Object s_securityGuardManagerObj = null;
    private Class s_securityGuardParamContextClz = null;
    private Field s_securityGuardParamContext_appKey = null;
    private Field s_securityGuardParamContext_paramMap = null;
    private Field s_securityGuardParamContext_requestType = null;
    private Method s_signRequestMethod = null;

    public SecuritySDK(String str, String str2) {
        this.mAppkey = str;
        this.mAuthcode = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    private synchronized void initSecurityCheck() {
        Object th;
        if (!this.isInitSecurityCheck) {
            Class<SecurityGuardManager> cls = SecurityGuardManager.class;
            try {
                int i = SecurityGuardManager.i;
                try {
                    this.s_securityGuardManagerObj = cls.getMethod("getInstance", Context.class).invoke(null, Variables.n().j());
                    this.s_secureSignatureCompObj = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.s_securityGuardManagerObj, new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                cls = null;
                th = th3;
                Logger.v(TAG, "initSecurityCheck", th);
                if (cls != null) {
                }
                this.isInitSecurityCheck = true;
            }
            if (cls != null) {
                try {
                    this.s_securityGuardParamContextClz = SecurityGuardParamContext.class;
                    this.s_securityGuardParamContext_appKey = SecurityGuardParamContext.class.getDeclaredField("appKey");
                    this.s_securityGuardParamContext_paramMap = this.s_securityGuardParamContextClz.getDeclaredField("paramMap");
                    this.s_securityGuardParamContext_requestType = this.s_securityGuardParamContextClz.getDeclaredField("requestType");
                    this.s_signRequestMethod = ISecureSignatureComponent.class.getMethod("signRequest", this.s_securityGuardParamContextClz, String.class);
                } catch (Throwable th4) {
                    Logger.v(TAG, "initSecurityCheck", th4);
                }
            }
            this.isInitSecurityCheck = true;
        }
    }

    public String getSign(String str) {
        Class cls;
        Logger.f(TAG, "toBeSignedStr", str);
        if (!this.isInitSecurityCheck) {
            initSecurityCheck();
        }
        String str2 = null;
        if (this.mAppkey == null) {
            Logger.f(TAG, "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            Object obj = this.s_securityGuardManagerObj;
            if (obj == null || (cls = this.s_securityGuardParamContextClz) == null || this.s_securityGuardParamContext_appKey == null || this.s_securityGuardParamContext_paramMap == null || this.s_securityGuardParamContext_requestType == null || this.s_signRequestMethod == null || this.s_secureSignatureCompObj == null) {
                Logger.v(TAG, "UTSecurityThridRequestAuthentication.getSign s_securityGuardManagerObj", obj, "s_securityGuardParamContextClz", this.s_securityGuardParamContextClz, "s_securityGuardParamContext_appKey", this.s_securityGuardParamContext_appKey, "s_securityGuardParamContext_paramMap", this.s_securityGuardParamContext_paramMap, "s_securityGuardParamContext_requestType", this.s_securityGuardParamContext_requestType, "s_signRequestMethod", this.s_signRequestMethod);
            } else {
                try {
                    Object newInstance = cls.newInstance();
                    this.s_securityGuardParamContext_appKey.set(newInstance, this.mAppkey);
                    ((Map) this.s_securityGuardParamContext_paramMap.get(newInstance)).put("INPUT", str);
                    this.s_securityGuardParamContext_requestType.set(newInstance, Integer.valueOf(this.s_secureIndex));
                    str2 = (String) this.s_signRequestMethod.invoke(this.s_secureSignatureCompObj, newInstance, this.mAuthcode);
                } catch (Exception e) {
                    Logger.h(TAG, e, new Object[0]);
                }
            }
            Logger.f(TAG, "lSignedStr", str2);
            return str2;
        }
    }
}
