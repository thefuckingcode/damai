package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class Measure implements Parcelable {
    public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() {
        /* class com.alibaba.mtl.appmonitor.model.Measure.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Measure createFromParcel(Parcel parcel) {
            return Measure.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Measure[] newArray(int i) {
            return new Measure[i];
        }
    };
    private static List<Double> nullList;
    private List<Double> bounds;
    protected Double constantValue;
    public String name;

    static {
        ArrayList arrayList = new ArrayList(1);
        nullList = arrayList;
        arrayList.add(null);
    }

    Measure() {
        this.constantValue = Double.valueOf(0.0d);
    }

    static Measure readFromParcel(Parcel parcel) {
        try {
            return new Measure(parcel.readString(), !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null, parcel.readArrayList(Measure.class.getClassLoader()));
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.h("readFromParcel", th, new Object[0]);
            return null;
        }
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
        Measure measure = (Measure) obj;
        String str = this.name;
        if (str == null) {
            if (measure.name != null) {
                return false;
            }
        } else if (!str.equals(measure.name)) {
            return false;
        }
        return true;
    }

    public List<Double> getBounds() {
        return this.bounds;
    }

    public Double getConstantValue() {
        return this.constantValue;
    }

    public Double getMax() {
        List<Double> list = this.bounds;
        if (list == null || list.size() < 2) {
            return null;
        }
        List<Double> list2 = this.bounds;
        return list2.get(list2.size() - 1);
    }

    public Double getMin() {
        List<Double> list = this.bounds;
        if (list == null || list.size() < 1) {
            return null;
        }
        return this.bounds.get(0);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(Double d) {
        this.constantValue = d;
    }

    public void setRange(Double d, Double d2) {
        if (d == null || d2 == null) {
            Logger.v("min or max must not be null", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        this.bounds = arrayList;
        arrayList.add(d);
        this.bounds.add(d2);
    }

    public boolean valid(MeasureValue measureValue) {
        Double valueOf = Double.valueOf(measureValue.getValue());
        return valueOf != null && (getMin() == null || valueOf.doubleValue() >= getMin().doubleValue()) && (getMax() == null || valueOf.doubleValue() < getMax().doubleValue());
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeList(this.bounds);
            parcel.writeString(this.name);
            parcel.writeInt(this.constantValue == null ? 0 : 1);
            Double d = this.constantValue;
            if (d != null) {
                parcel.writeDouble(d.doubleValue());
            }
        } catch (Throwable th) {
            Logger.h("writeToParcel", th, new Object[0]);
        }
    }

    public Measure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    public Measure(String str, Double d, List<Double> list) {
        double d2 = 0.0d;
        this.constantValue = Double.valueOf(0.0d);
        if (list != null) {
            if (list.removeAll(nullList)) {
                Logger.v("bounds entity must not be null", new Object[0]);
            }
            Collections.sort(list);
            this.bounds = list;
        }
        this.name = str;
        this.constantValue = Double.valueOf(d != null ? d.doubleValue() : d2);
    }

    public Measure(String str, Double d) {
        this(str, d, null, null);
    }

    public Measure(String str, Double d, Double d2, Double d3) {
        this(str, d, null);
        if (d2 != null || d3 != null) {
            setRange(d2, d3);
        }
    }
}
