package com.youku.middlewareservice_impl.provider.kvdata;

import androidx.annotation.Keep;
import com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider;
import java.util.HashMap;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public class InMemoryDataProviderImpl implements InMemoryDataProvider {
    private static Map<String, Map<String, Object>> sGlobalData = new HashMap(100);

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized void clearGlobalData(String str) {
        sGlobalData.remove(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized boolean getGlobalBooleanData(String str, String str2, boolean z) {
        Object obj;
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str2);
        }
        if (!(obj instanceof Boolean)) {
            return z;
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized int getGlobalIntData(String str, String str2, int i) {
        Object obj;
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str2);
        }
        if (!(obj instanceof Integer)) {
            return i;
        }
        return ((Integer) obj).intValue();
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized long getGlobalLongData(String str, String str2, long j) {
        Object obj;
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str2);
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        } else if (!(obj instanceof Integer)) {
            return j;
        } else {
            return (long) ((Integer) obj).intValue();
        }
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized Object getGlobalObjectData(String str, String str2) {
        Object obj;
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str2);
        }
        return obj;
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized String getGlobalStringData(String str, String str2) {
        Object obj;
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(str2);
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized boolean hasGlobalData(String str, String str2) {
        Map<String, Object> map;
        map = sGlobalData.get(str);
        return map != null && map.containsKey(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized Object removeGlobalData(String str, String str2) {
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            return null;
        }
        return map.remove(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized void setGlobalData(String str, String str2, Object obj) {
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            if (obj != null) {
                map = new HashMap<>(100);
                sGlobalData.put(str, map);
            } else {
                return;
            }
        }
        if (obj == null) {
            map.remove(str2);
        } else {
            map.put(str2, obj);
        }
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized void setGlobalData(String str, String str2, long j) {
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            map = new HashMap<>(100);
            sGlobalData.put(str, map);
        }
        map.put(str2, Long.valueOf(j));
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized void setGlobalData(String str, String str2, int i) {
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            map = new HashMap<>(100);
            sGlobalData.put(str, map);
        }
        map.put(str2, Integer.valueOf(i));
    }

    @Override // com.youku.middlewareservice.provider.kvdata.InMemoryDataProvider
    public synchronized void setGlobalData(String str, String str2, boolean z) {
        Map<String, Object> map = sGlobalData.get(str);
        if (map == null) {
            map = new HashMap<>(100);
            sGlobalData.put(str, map);
        }
        map.put(str2, Boolean.valueOf(z));
    }
}
