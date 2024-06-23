package com.ut.mini.mtop;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.x.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.gj2;
import tb.ot0;
import tb.u9;

/* compiled from: Taobao */
class UTMtopConfigMgr {
    private static Map<String, Map<String, UTPageConfigValue>> mPageMap = new ConcurrentHashMap();
    private static Map<String, String> mPageUtparamMap = new ConcurrentHashMap();

    UTMtopConfigMgr() {
    }

    static void activateMtopConfig(final String str) {
        gj2.c().f(new Runnable() {
            /* class com.ut.mini.mtop.UTMtopConfigMgr.AnonymousClass1 */

            public void run() {
                UTMtopConfigMgr.parseConfigData(str);
            }
        });
    }

    private static Map<String, String> getMapForPage(String str) {
        Map<String, UTPageConfigValue> map = mPageMap.get(str);
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, UTPageConfigValue> entry : map.entrySet()) {
            String key = entry.getKey();
            String valuesForKey = getValuesForKey(entry.getValue());
            if (!isEmpty(key) && !isEmpty(valuesForKey)) {
                hashMap.put(key, valuesForKey);
            }
        }
        return hashMap;
    }

    static String getUtparamCnt(String str) {
        if (isEmpty(str)) {
            return null;
        }
        try {
            return mPageUtparamMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getValuesForKey(UTPageConfigValue uTPageConfigValue) {
        if (uTPageConfigValue == null) {
            return null;
        }
        List<String> list = uTPageConfigValue.valueList;
        if (isEmpty(list)) {
            return null;
        }
        String str = uTPageConfigValue.separator;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (z) {
                sb.append(str2);
                z = false;
            } else {
                sb.append(str);
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    static void parseConfig(String str) {
        if (!isEmpty(str)) {
            try {
                Map map = (Map) JSON.parseObject(str, Map.class);
                if (!isEmpty(map)) {
                    Object obj = map.get(c.c);
                    if (obj instanceof List) {
                        List<JSONObject> list = (List) obj;
                        synchronized (UTMtopConfigMgr.class) {
                            for (JSONObject jSONObject : list) {
                                UTMtopConfig uTMtopConfig = (UTMtopConfig) JSON.toJavaObject(jSONObject, UTMtopConfig.class);
                                List<UTMtopPageValue> list2 = uTMtopConfig.pageValueList;
                                if (!isEmpty(list2)) {
                                    String str2 = uTMtopConfig.key;
                                    String str3 = uTMtopConfig.separator;
                                    for (UTMtopPageValue uTMtopPageValue : list2) {
                                        String str4 = uTMtopPageValue.page;
                                        List<String> list3 = uTMtopPageValue.valueList;
                                        if (!isEmpty(str4)) {
                                            if (!isEmpty(list3)) {
                                                UTPageConfigValue uTPageConfigValue = null;
                                                Map<String, UTPageConfigValue> map2 = mPageMap.containsKey(str4) ? mPageMap.get(str4) : null;
                                                if (map2 == null) {
                                                    map2 = new ConcurrentHashMap<>();
                                                    mPageMap.put(str4, map2);
                                                }
                                                if (map2.containsKey(str2)) {
                                                    uTPageConfigValue = map2.get(str2);
                                                }
                                                if (uTPageConfigValue == null) {
                                                    uTPageConfigValue = new UTPageConfigValue();
                                                    uTPageConfigValue.separator = str3;
                                                    map2.put(str2, uTPageConfigValue);
                                                }
                                                boolean z = false;
                                                for (String str5 : list3) {
                                                    if (setValue(uTPageConfigValue, str5)) {
                                                        z = true;
                                                    }
                                                }
                                                if (z) {
                                                    Map<String, String> mapForPage = getMapForPage(str4);
                                                    if (!isEmpty(mapForPage)) {
                                                        String jSONString = JSON.toJSONString(mapForPage);
                                                        if (!isEmpty(str4)) {
                                                            mPageUtparamMap.put(str4, jSONString);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void parseConfigData(String str) {
        byte[] b;
        try {
            Logger.f("UTMtopConfigMgr", "parseConfigData", str);
            byte[] a = u9.a(str.getBytes("UTF-8"), 2);
            if (a != null && (b = ot0.b(a)) != null) {
                parseConfig(new String(b, 0, b.length));
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean setValue(UTPageConfigValue uTPageConfigValue, String str) {
        if (uTPageConfigValue.valueList.contains(str)) {
            return false;
        }
        uTPageConfigValue.valueList.add(str);
        return true;
    }

    private static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    private static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }
}
