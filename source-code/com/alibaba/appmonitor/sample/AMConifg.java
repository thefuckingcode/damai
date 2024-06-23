package com.alibaba.appmonitor.sample;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tb.xd0;

/* compiled from: Taobao */
public class AMConifg extends xd0 implements Cloneable {
    @Column("module")
    protected String module;
    @Column("mp")
    protected String monitorPoint;
    @Column("offline")
    protected String offline;
    @Ingore
    private HashMap<String, AMConifg> relationMap;
    @Column("cp")
    private int sampling;

    private boolean checkSelfOffline() {
        return "1".equalsIgnoreCase(this.offline);
    }

    private boolean sampling(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return checkSelfSampling(i);
        }
        String remove = arrayList.remove(0);
        if (isContains(remove)) {
            return this.relationMap.get(remove).sampling(i, arrayList);
        }
        return checkSelfSampling(i);
    }

    public synchronized void add(String str, AMConifg aMConifg) {
        HashMap<String, AMConifg> hashMap;
        HashMap<String, AMConifg> hashMap2;
        if (this.relationMap == null) {
            this.relationMap = new HashMap<>();
        }
        if (isContains(str)) {
            AMConifg aMConifg2 = this.relationMap.get(str);
            if (!(aMConifg2 == null || (hashMap = aMConifg2.relationMap) == null || (hashMap2 = aMConifg.relationMap) == null)) {
                hashMap2.putAll(hashMap);
            }
            Logger.v("config object order errror", "config:", aMConifg + "");
        }
        this.relationMap.put(str, aMConifg);
    }

    /* access modifiers changed from: protected */
    public boolean checkSelfSampling(int i) {
        Logger.r("AMConifg", "sampling module", this.module, "monitorPoint", this.monitorPoint, "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.sampling));
        if (i < this.sampling) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void enableOffline() {
        this.offline = "1";
    }

    public String getModule() {
        return this.module;
    }

    public synchronized AMConifg getNext(String str) {
        if (this.relationMap == null) {
            this.relationMap = new HashMap<>();
        }
        return this.relationMap.get(str);
    }

    public synchronized AMConifg getOrBulidNext(String str) {
        AMConifg next;
        AMConifg aMConifg;
        CloneNotSupportedException e;
        next = getNext(str);
        if (next == null) {
            try {
                aMConifg = (AMConifg) clone();
                try {
                    aMConifg.module = str;
                } catch (CloneNotSupportedException e2) {
                    e = e2;
                }
            } catch (CloneNotSupportedException e3) {
                aMConifg = next;
                e = e3;
                e.printStackTrace();
                next = aMConifg;
                this.relationMap.put(str, next);
                return next;
            }
            next = aMConifg;
        }
        this.relationMap.put(str, next);
        return next;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isContains(String str) {
        HashMap<String, AMConifg> hashMap = this.relationMap;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(str);
    }

    public boolean isOffline(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return isOffline(arrayList);
    }

    public boolean isSampled(int i, String str, String str2, Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return sampling(i, arrayList);
    }

    public void setSampling(int i) {
        this.sampling = i;
    }

    @Deprecated
    public void enableOffline(boolean z) {
        if (z) {
            this.offline = "1";
        } else {
            this.offline = null;
        }
    }

    private boolean isOffline(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return checkSelfOffline();
        }
        String remove = arrayList.remove(0);
        if (isContains(remove)) {
            return this.relationMap.get(remove).isOffline(arrayList);
        }
        return checkSelfOffline();
    }
}
