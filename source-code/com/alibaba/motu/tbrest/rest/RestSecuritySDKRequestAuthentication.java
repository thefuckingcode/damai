package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.utils.LogUtil;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.SecurityGuardParamContext;
import com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent;
import com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
public class RestSecuritySDKRequestAuthentication {
    private String mAppkey = null;
    private boolean mBInitSecurityCheck = false;
    private Context mContext;
    private int s_secureIndex = 1;
    private Object s_secureSignatureCompObj = null;
    private Object s_securityGuardManagerObj = null;
    private Class s_securityGuardParamContextClz = null;
    private Field s_securityGuardParamContext_appKey = null;
    private Field s_securityGuardParamContext_paramMap = null;
    private Field s_securityGuardParamContext_requestType = null;
    private Method s_signRequestMethod = null;

    public RestSecuritySDKRequestAuthentication(Context context, String str) {
        this.mContext = context;
        this.mAppkey = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    private synchronized void _initSecurityCheck() {
        Method method;
        boolean z;
        if (!this.mBInitSecurityCheck) {
            Class<SecurityGuardManager> cls = SecurityGuardManager.class;
            try {
                int i = SecurityGuardManager.e;
                try {
                    this.s_securityGuardManagerObj = cls.getMethod("getInstance", Context.class).invoke(null, this.mContext);
                    this.s_secureSignatureCompObj = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.s_securityGuardManagerObj, new Object[0]);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                cls = null;
                LogUtil.i("initSecurityCheck failure, It's ok ");
                if (cls != null) {
                }
                this.mBInitSecurityCheck = true;
            }
            if (cls != null) {
                try {
                    this.s_securityGuardParamContextClz = SecurityGuardParamContext.class;
                    this.s_securityGuardParamContext_appKey = SecurityGuardParamContext.class.getDeclaredField("appKey");
                    this.s_securityGuardParamContext_paramMap = this.s_securityGuardParamContextClz.getDeclaredField("paramMap");
                    this.s_securityGuardParamContext_requestType = this.s_securityGuardParamContextClz.getDeclaredField("requestType");
                    try {
                        method = cls.getMethod("isOpen", new Class[0]);
                    } catch (Throwable unused3) {
                        LogUtil.i("initSecurityCheck failure, It's ok");
                        method = null;
                    }
                    if (method != null) {
                        z = ((Boolean) method.invoke(this.s_securityGuardManagerObj, new Object[0])).booleanValue();
                    } else {
                        z = ISecurityBodyComponent.class == 0;
                    }
                    this.s_secureIndex = z ? 1 : 12;
                    this.s_signRequestMethod = ISecureSignatureComponent.class.getMethod("signRequest", this.s_securityGuardParamContextClz);
                } catch (Throwable unused4) {
                    LogUtil.i("initSecurityCheck failure, It's ok");
                }
            }
            this.mBInitSecurityCheck = true;
        }
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public String getSign(String str) {
        Class cls;
        if (!this.mBInitSecurityCheck) {
            _initSecurityCheck();
        }
        if (this.mAppkey == null) {
            LogUtil.e("RestSecuritySDKRequestAuthentication:getSign There is no appkey,please check it!");
            return null;
        } else if (str == null || this.s_securityGuardManagerObj == null || (cls = this.s_securityGuardParamContextClz) == null || this.s_securityGuardParamContext_appKey == null || this.s_securityGuardParamContext_paramMap == null || this.s_securityGuardParamContext_requestType == null || this.s_signRequestMethod == null || this.s_secureSignatureCompObj == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.s_securityGuardParamContext_appKey.set(newInstance, this.mAppkey);
                ((Map) this.s_securityGuardParamContext_paramMap.get(newInstance)).put("INPUT", str);
                this.s_securityGuardParamContext_requestType.set(newInstance, Integer.valueOf(this.s_secureIndex));
                return (String) this.s_signRequestMethod.invoke(this.s_secureSignatureCompObj, newInstance);
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }
}
