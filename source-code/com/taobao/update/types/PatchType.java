package com.taobao.update.types;

import tb.js2;

/* compiled from: Taobao */
public enum PatchType {
    SOPATCH(0, js2.SOPATCH),
    INSTANTPATCH(1, js2.HOTPATCH),
    DEXPATCH(2, js2.DEXPATCH),
    MAIN(3, js2.MAIN),
    DYNAMIC(4, js2.DYNAMIC),
    TESTURL(5, js2.TEST_URL),
    BUNDLES(6, "bundle");
    
    private String key;
    private int priority;

    private PatchType(int i, String str) {
        this.priority = i;
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public int getPriority() {
        return this.priority;
    }
}
