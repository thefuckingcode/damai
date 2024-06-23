package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.a;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class DimensionValueSet implements Parcelable, Reusable {
    public static final Parcelable.Creator<DimensionValueSet> CREATOR = new Parcelable.Creator<DimensionValueSet>() {
        /* class com.alibaba.mtl.appmonitor.model.DimensionValueSet.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DimensionValueSet createFromParcel(Parcel parcel) {
            return DimensionValueSet.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DimensionValueSet[] newArray(int i) {
            return new DimensionValueSet[i];
        }
    };
    protected Map<String, String> map;

    @Deprecated
    public DimensionValueSet() {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public static DimensionValueSet create() {
        return (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
    }

    public static DimensionValueSet fromStringMap(Map<String, String> map2) {
        DimensionValueSet dimensionValueSet = (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            dimensionValueSet.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
        return dimensionValueSet;
    }

    static DimensionValueSet readFromParcel(Parcel parcel) {
        DimensionValueSet dimensionValueSet;
        Throwable th;
        try {
            dimensionValueSet = create();
            try {
                dimensionValueSet.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            dimensionValueSet = null;
            th.printStackTrace();
            return dimensionValueSet;
        }
        return dimensionValueSet;
    }

    public DimensionValueSet addValues(DimensionValueSet dimensionValueSet) {
        Map<String, String> map2;
        if (!(dimensionValueSet == null || (map2 = dimensionValueSet.getMap()) == null)) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
        Map<String, String> map2 = this.map;
        if (map2 == null) {
            if (dimensionValueSet.map != null) {
                return false;
            }
        } else if (!map2.equals(dimensionValueSet.map)) {
            return false;
        }
        return true;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    public String getValue(String str) {
        return this.map.get(str);
    }

    public int hashCode() {
        Map<String, String> map2 = this.map;
        return 31 + (map2 == null ? 0 : map2.hashCode());
    }

    public void setMap(Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
    }

    public DimensionValueSet setValue(String str, String str2) {
        Map<String, String> map2 = this.map;
        if (str2 == null) {
            str2 = "null";
        }
        map2.put(str, str2);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static DimensionValueSet create(int i) {
        return (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
    }
}
