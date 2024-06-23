package com.uploader.implement;

import com.uploader.export.IUploaderStatistics;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class b {
    private static volatile IUploaderStatistics a;

    static final void a(IUploaderStatistics iUploaderStatistics) {
        a = iUploaderStatistics;
    }

    public static void b(String str, String str2, Map<String, Double> map, Map<String, String> map2) {
        IUploaderStatistics iUploaderStatistics = a;
        if (iUploaderStatistics != null) {
            iUploaderStatistics.onCommit(str, str2, map, map2);
        }
    }

    public static void c(String str, String str2, Set<String> set, Set<String> set2, boolean z) {
        IUploaderStatistics iUploaderStatistics = a;
        if (iUploaderStatistics != null) {
            iUploaderStatistics.onRegister(str, str2, set, set2, z);
        }
    }
}
