package com.ut.mini;

import android.app.Activity;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UTPagePropertiesHelper {
    private static final int CACHE_BUFFER = 10;
    private static final int CACHE_MAX = 20;
    private static final String TAG = "UTPagePropertiesHelper";
    private static Map<Long, PageRule> mPvidPageRuleMap = new ConcurrentHashMap();
    private static Map<Long, Map<String, String>> mPvidPropertiesByRuleMap = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class PageRule {
        public ArrayList<Integer> eventIdList;
        public int pageHashCode = 0;
        public ArrayList<String> propertyKeyList;

        PageRule() {
        }
    }

    UTPagePropertiesHelper() {
    }

    private static synchronized void clear(long j) {
        synchronized (UTPagePropertiesHelper.class) {
            try {
                if (mPvidPageRuleMap.size() > 20) {
                    long j2 = j - 10;
                    Iterator<Map.Entry<Long, PageRule>> it = mPvidPageRuleMap.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getKey().longValue() < j2) {
                            it.remove();
                        }
                    }
                }
                if (mPvidPropertiesByRuleMap.size() > 20) {
                    long j3 = j - 10;
                    Iterator<Map.Entry<Long, Map<String, String>>> it2 = mPvidPropertiesByRuleMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getKey().longValue() < j3) {
                            it2.remove();
                        }
                    }
                }
            } catch (Exception e) {
                Logger.h(TAG, e, new Object[0]);
            }
        }
        return;
    }

    static synchronized void setPageSessionPropertiesRule(Activity activity, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        synchronized (UTPagePropertiesHelper.class) {
            if (activity != null) {
                try {
                    long utPvid = UTPvidHelper.getUtPvid();
                    PageRule pageRule = new PageRule();
                    pageRule.pageHashCode = activity.hashCode();
                    if (arrayList != null) {
                        pageRule.eventIdList = new ArrayList<>(arrayList);
                    } else {
                        pageRule.eventIdList = null;
                    }
                    if (arrayList2 != null) {
                        pageRule.propertyKeyList = new ArrayList<>(arrayList2);
                    } else {
                        pageRule.propertyKeyList = null;
                    }
                    mPvidPageRuleMap.put(Long.valueOf(utPvid), pageRule);
                    updatePageProperties(UTPageHitHelper.getInstance().getPageAllProperties(activity));
                    clear(utPvid);
                } catch (Exception e) {
                    Logger.h(TAG, e, new Object[0]);
                }
                return;
            }
            return;
        }
    }

    static synchronized void updateEventProperties(int i, Map<String, String> map) {
        ArrayList<Integer> arrayList;
        synchronized (UTPagePropertiesHelper.class) {
            try {
                long utPvid = UTPvidHelper.getUtPvid();
                PageRule pageRule = mPvidPageRuleMap.get(Long.valueOf(utPvid));
                if (!(pageRule == null || (arrayList = pageRule.eventIdList) == null || pageRule.propertyKeyList == null)) {
                    if (arrayList.contains(Integer.valueOf(i))) {
                        Map<String, String> map2 = mPvidPropertiesByRuleMap.get(Long.valueOf(utPvid));
                        if (map2 != null) {
                            for (Map.Entry<String, String> entry : map2.entrySet()) {
                                String key = entry.getKey();
                                if (!map.containsKey(key)) {
                                    map.put(key, entry.getValue());
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                return;
            } catch (Exception e) {
                Logger.h(TAG, e, new Object[0]);
            }
        }
    }

    static synchronized void updatePageProperties(Object obj) {
        String str;
        synchronized (UTPagePropertiesHelper.class) {
            try {
                long utPvid = UTPvidHelper.getUtPvid();
                PageRule pageRule = mPvidPageRuleMap.get(Long.valueOf(utPvid));
                if (!(pageRule == null || pageRule.eventIdList == null)) {
                    if (pageRule.propertyKeyList != null) {
                        Activity activity = null;
                        if (obj instanceof Activity) {
                            activity = (Activity) obj;
                        }
                        if (activity != null) {
                            if (pageRule.pageHashCode == activity.hashCode()) {
                                Map<String, String> pageAllProperties = UTPageHitHelper.getInstance().getPageAllProperties(activity);
                                if (pageAllProperties == null) {
                                    mPvidPropertiesByRuleMap.remove(Long.valueOf(utPvid));
                                    return;
                                }
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                Iterator<String> it = pageRule.propertyKeyList.iterator();
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (pageAllProperties.containsKey(next) && (str = pageAllProperties.get(next)) != null) {
                                        concurrentHashMap.put(next, str);
                                    }
                                }
                                mPvidPropertiesByRuleMap.put(Long.valueOf(utPvid), concurrentHashMap);
                                return;
                            }
                        }
                        return;
                    }
                }
                return;
            } catch (Exception e) {
                Logger.h(TAG, e, new Object[0]);
            }
        }
    }
}
