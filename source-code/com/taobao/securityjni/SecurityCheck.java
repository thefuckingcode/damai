package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.taobao.securityjni.tools.DataContext;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.SecurityGuardParamContext;
import com.taobao.wireless.security.sdk.indiekit.IIndieKitComponent;
import java.util.HashMap;

@Deprecated
/* compiled from: Taobao */
public class SecurityCheck {
    private SecurityGuardManager manager;
    private IIndieKitComponent proxy;

    public SecurityCheck(ContextWrapper contextWrapper) {
        SecurityGuardManager instance = SecurityGuardManager.getInstance(contextWrapper);
        this.manager = instance;
        if (instance != null) {
            this.proxy = instance.getIndieKitComp();
        }
    }

    public String getCheckSignature(String str) {
        DataContext dataContext = new DataContext();
        dataContext.index = 0;
        return getCheckSignature(str, dataContext);
    }

    public String indieKitRequest(SecurityGuardParamContext securityGuardParamContext) {
        IIndieKitComponent iIndieKitComponent = this.proxy;
        if (iIndieKitComponent == null) {
            return null;
        }
        return iIndieKitComponent.indieKitRequest(securityGuardParamContext);
    }

    public int reportSusText(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public int validateFileSignature(String str, String str2, String str3) {
        return -1;
    }

    public String getCheckSignature(String str, DataContext dataContext) {
        if (!(this.proxy == null || str == null || dataContext == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 1;
            byte[] bArr = dataContext.extData;
            if (bArr == null || "".equals(bArr)) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else {
                securityGuardParamContext.appKey = new String(dataContext.extData);
            }
            return this.proxy.indieKitRequest(securityGuardParamContext);
        }
        return null;
    }
}
