package com.alibaba.motu.tbrest.rest;

import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
public class RestKeyArraySorter {
    private static RestKeyArraySorter s_instance;
    private ResourcesASCComparator mASCComparator = new ResourcesASCComparator();
    private ResourcesDESCComparator mDESCComparator = new ResourcesDESCComparator();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ResourcesASCComparator implements Comparator<String> {
        private ResourcesASCComparator() {
        }

        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ResourcesDESCComparator implements Comparator<String> {
        private ResourcesDESCComparator() {
        }

        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * -1;
        }
    }

    private RestKeyArraySorter() {
    }

    public static synchronized RestKeyArraySorter getInstance() {
        RestKeyArraySorter restKeyArraySorter;
        synchronized (RestKeyArraySorter.class) {
            if (s_instance == null) {
                s_instance = new RestKeyArraySorter();
            }
            restKeyArraySorter = s_instance;
        }
        return restKeyArraySorter;
    }

    public String[] sortResourcesList(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.mASCComparator;
        } else {
            comparator = this.mDESCComparator;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
