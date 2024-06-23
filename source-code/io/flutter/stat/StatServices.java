package io.flutter.stat;

import io.flutter.stat.ICoreStat;
import java.util.HashMap;

/* compiled from: Taobao */
public class StatServices {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CATEGORY = "core";
    public static final String EVENTCATEGORY = "flutter";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class InnerClass {
        private static final StatServices SINGLETON = new StatServices();

        private InnerClass() {
        }
    }

    public static void WaStat(String str, HashMap<String, String> hashMap) {
        WaStat(CATEGORY, EVENTCATEGORY, str, hashMap);
    }

    public static StatServices getInstance() {
        return InnerClass.SINGLETON;
    }

    public static int getNumberLength(long j) {
        if (j < 100000) {
            if (j < 100) {
                return j < 10 ? 1 : 2;
            }
            if (j < 1000) {
                return 3;
            }
            return j < 10000 ? 4 : 5;
        } else if (j < 10000000) {
            return j < 1000000 ? 6 : 7;
        } else {
            if (j < 100000000) {
                return 8;
            }
            return j < 1000000000 ? 9 : 10;
        }
    }

    public static void WaStat(String str, String str2, String str3, HashMap<String, String> hashMap) {
        ICoreStat.CustomStat instance = ICoreStat.CustomStat.getInstance();
        if (instance != null && hashMap.size() > 0) {
            instance.WaStat(new ICoreStat.WaData(str, str2, str3, hashMap, null));
        }
    }
}
