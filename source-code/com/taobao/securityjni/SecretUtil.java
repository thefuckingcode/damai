package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.alipay.sdk.m.n.a;
import com.taobao.securityjni.tools.DataContext;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.SecurityGuardParamContext;
import com.taobao.wireless.security.sdk.indiekit.IIndieKitComponent;
import com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent;
import com.taobao.wireless.security.sdk.securesignature.SecureSignatureDefine;
import com.uc.crashsdk.export.LogType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

@Deprecated
/* compiled from: Taobao */
public class SecretUtil {
    public static final String M_API = "API";
    public static final String M_DATA = "DATA";
    public static final String M_DEV = "DEV";
    public static final String M_ECODE = "ECODE";
    public static final String M_IMEI = "IMEI";
    public static final String M_IMSI = "IMSI";
    public static final String M_SSO = "SSO";
    public static final String M_TIME = "TIME";
    public static final String M_V = "V";
    private IIndieKitComponent indieKitProxy;
    private SecurityGuardManager manager;
    private ISecureSignatureComponent signProxy;

    public SecretUtil(ContextWrapper contextWrapper) {
        SecurityGuardManager instance = SecurityGuardManager.getInstance(contextWrapper);
        this.manager = instance;
        if (instance != null) {
            this.signProxy = instance.getSecureSignatureComp();
            this.indieKitProxy = this.manager.getIndieKitComp();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    public String getExternalSign(LinkedHashMap<String, String> linkedHashMap, DataContext dataContext) {
        int i;
        if (this.signProxy == null || linkedHashMap == null || linkedHashMap.isEmpty() || dataContext == null) {
            return null;
        }
        int i2 = dataContext.category;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4 && dataContext.type == 0) {
                            i = 14;
                            if (i != -1) {
                                return null;
                            }
                            StringBuilder sb = new StringBuilder((int) LogType.UNEXP_OTHER);
                            for (String str : linkedHashMap.keySet()) {
                                if (str != null) {
                                    String str2 = linkedHashMap.get(str);
                                    if (str2 != null) {
                                        sb.append(str);
                                        sb.append(a.h);
                                        sb.append(str2);
                                    } else {
                                        sb.append(str);
                                    }
                                    sb.append('&');
                                }
                            }
                            if (sb.length() < 1) {
                                return null;
                            }
                            HashMap hashMap = new HashMap();
                            int i3 = 0;
                            hashMap.put("INPUT", sb.substring(0, sb.length() - 1));
                            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                            securityGuardParamContext.paramMap = hashMap;
                            securityGuardParamContext.requestType = i;
                            byte[] bArr = dataContext.extData;
                            if (bArr == null) {
                                int i4 = dataContext.index;
                                if (i4 >= 0) {
                                    i3 = i4;
                                }
                                dataContext.index = i3;
                                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                                if (appKeyByIndex == null || "".equals(appKeyByIndex)) {
                                    return null;
                                }
                                securityGuardParamContext.appKey = appKeyByIndex;
                            } else if (bArr.length == 0) {
                                return null;
                            } else {
                                securityGuardParamContext.appKey = new String(bArr);
                            }
                            return this.signProxy.signRequest(securityGuardParamContext);
                        }
                    } else if (dataContext.type == 0) {
                        i = 8;
                        if (i != -1) {
                        }
                    }
                } else if (dataContext.type == 0) {
                    i = 12;
                    if (i != -1) {
                    }
                }
            } else if (dataContext.type == 0) {
                i = 11;
                if (i != -1) {
                }
            }
        } else if (dataContext.type == 0) {
            i = 10;
            if (i != -1) {
            }
        }
        i = -1;
        if (i != -1) {
        }
    }

    public String getLaiwangSign(String str, String str2, DataContext dataContext) {
        if (!(this.signProxy == null || dataContext == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_KEY, str2);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 7;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.signProxy.signRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getLoginTopToken(String str, String str2) {
        return getLoginTopToken(str, str2, new DataContext(0, null));
    }

    public String getMtopSign(HashMap<String, String> hashMap, DataContext dataContext) {
        if (!(this.signProxy == null || hashMap == null || dataContext == null)) {
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.signProxy.signRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getMtopV4RespSign(String str, DataContext dataContext) {
        if (!(this.signProxy == null || dataContext == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 5;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.signProxy.signRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getMtopV4Sign(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, DataContext dataContext) {
        if (!(this.signProxy == null || dataContext == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ECODE", str);
            hashMap.put("DATA", str2);
            hashMap.put("TIME", str3);
            hashMap.put("API", str4);
            hashMap.put("V", str5);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_SID, str6);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_TTID, str7);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_DEVICDEID, str8);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_LAT, str9);
            hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_LNG, str10);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 4;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.signProxy.signRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getQianNiuSign(byte[] bArr, byte[] bArr2) {
        if (this.signProxy == null || bArr == null || bArr2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = new String(bArr);
        String str2 = new String(bArr2);
        hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_STR1, str);
        hashMap.put(SecureSignatureDefine.SG_KEY_SIGN_STR2, str2);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 9;
        return this.signProxy.signRequest(securityGuardParamContext);
    }

    public String getSign(String str, String str2, String str3, String str4, String str5, String str6) {
        return getSign(str, str2, str3, str4, str5, null, str6);
    }

    public String getTopSign(TreeMap<String, String> treeMap) {
        return getTopSign(treeMap, new DataContext(0, null));
    }

    public String indieKitRequest(SecurityGuardParamContext securityGuardParamContext) {
        IIndieKitComponent iIndieKitComponent = this.indieKitProxy;
        if (iIndieKitComponent == null) {
            return null;
        }
        return iIndieKitComponent.indieKitRequest(securityGuardParamContext);
    }

    public int reportSusText(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public String signRequest(SecurityGuardParamContext securityGuardParamContext) {
        ISecureSignatureComponent iSecureSignatureComponent = this.signProxy;
        if (iSecureSignatureComponent == null) {
            return null;
        }
        return iSecureSignatureComponent.signRequest(securityGuardParamContext);
    }

    public int validateFileSignature(String str, String str2, String str3) {
        return -1;
    }

    public String getSign(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str == null || str2 == null || str3 == null || str4 == null || str7 == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("API", str);
        hashMap.put("V", str2);
        hashMap.put("IMEI", str3);
        hashMap.put("IMSI", str4);
        if (str5 != null) {
            hashMap.put("DATA", str5);
        }
        if (str6 != null) {
            hashMap.put("ECODE", str6);
        }
        hashMap.put("TIME", str7);
        return getSign(hashMap, new DataContext(0, null));
    }

    public String getLoginTopToken(String str, String str2, DataContext dataContext) {
        if (!(this.indieKitProxy == null || str == null || str2 == null || dataContext == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("username", str);
            hashMap.put("timestamp", str2);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            int i = 0;
            securityGuardParamContext.requestType = 0;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i2 = dataContext.index;
                if (i2 >= 0) {
                    i = i2;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.indieKitProxy.indieKitRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getTopSign(TreeMap<String, String> treeMap, DataContext dataContext) {
        if (!(this.signProxy == null || treeMap == null || treeMap.isEmpty())) {
            StringBuilder sb = new StringBuilder(512);
            for (String str : treeMap.keySet()) {
                String str2 = treeMap.get(str);
                if (str2 != null) {
                    sb.append(str);
                    sb.append(str2);
                } else {
                    sb.append(str);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", sb.toString());
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 2;
            byte[] bArr = dataContext.extData;
            if (bArr == null) {
                int i = dataContext.index;
                if (i < 0) {
                    i = 0;
                }
                dataContext.index = i;
                String appKeyByIndex = this.manager.getStaticDataStoreComp().getAppKeyByIndex(dataContext.index);
                if (appKeyByIndex != null && !"".equals(appKeyByIndex)) {
                    securityGuardParamContext.appKey = appKeyByIndex;
                }
            } else if (bArr.length == 0) {
                return null;
            } else {
                securityGuardParamContext.appKey = new String(bArr);
            }
            return this.signProxy.signRequest(securityGuardParamContext);
        }
        return null;
    }

    public String getSign(HashMap<String, String> hashMap, DataContext dataContext) {
        return getMtopSign(hashMap, dataContext);
    }
}
