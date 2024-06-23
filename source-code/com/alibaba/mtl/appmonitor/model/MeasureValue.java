package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class MeasureValue implements IMerge<MeasureValue>, Reusable, Parcelable {
    public static final Parcelable.Creator<MeasureValue> CREATOR = new Parcelable.Creator<MeasureValue>() {
        /* class com.alibaba.mtl.appmonitor.model.MeasureValue.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MeasureValue createFromParcel(Parcel parcel) {
            return MeasureValue.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MeasureValue[] newArray(int i) {
            return new MeasureValue[i];
        }
    };
    private List<Bucket> buckets;
    private boolean finish;
    private Double offset;
    private double value;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class Bucket {
        private long count = 0;
        private Double max;
        private Double min;

        public Bucket(Double d, Double d2) {
            this.min = d;
            this.max = d2;
        }

        public boolean in(Double d) {
            if (d == null) {
                return false;
            }
            Double d2 = this.min;
            Double d3 = this.max;
            if (d2 == null) {
                d2 = Double.valueOf(Double.MIN_VALUE);
            }
            if (d3 == null) {
                d3 = Double.valueOf(Double.MAX_VALUE);
            }
            if (d.doubleValue() < d2.doubleValue() || d.doubleValue() >= d3.doubleValue()) {
                return false;
            }
            return true;
        }

        public void increase() {
            this.count++;
        }
    }

    @Deprecated
    public MeasureValue() {
    }

    public static MeasureValue create() {
        return (MeasureValue) a.a().poll(MeasureValue.class, new Object[0]);
    }

    private Bucket getBucket(double d) {
        if (this.buckets == null) {
            return null;
        }
        for (int i = 0; i < this.buckets.size(); i++) {
            if (this.buckets.get(i).in(Double.valueOf(d))) {
                return this.buckets.get(i);
            }
        }
        return null;
    }

    static MeasureValue readFromParcel(Parcel parcel) {
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            MeasureValue create = create();
            create.finish = z;
            create.offset = valueOf;
            create.value = readDouble;
            return create;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public synchronized void clean() {
        this.value = 0.0d;
        this.offset = null;
        this.finish = false;
        this.buckets = null;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public synchronized void fill(Object... objArr) {
        if (objArr != null) {
            if (objArr.length > 0) {
                this.value = ((Double) objArr[0]).doubleValue();
            }
            if (objArr.length > 1) {
                this.offset = (Double) objArr[1];
                this.finish = false;
            }
        }
    }

    public synchronized Map<String, Double> getBuckets() {
        if (this.buckets == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Bucket bucket : this.buckets) {
            if (bucket.count > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(bucket.min == null ? "-∞" : bucket.min);
                sb.append(",");
                sb.append(bucket.max == null ? "∞" : bucket.max);
                hashMap.put(sb.toString(), Long.valueOf(bucket.count));
            }
        }
        return hashMap;
    }

    public Double getOffset() {
        return this.offset;
    }

    public double getValue() {
        return this.value;
    }

    public boolean isFinish() {
        return this.finish;
    }

    /* access modifiers changed from: protected */
    public synchronized void setBuckets(Measure measure) {
        List<Double> bounds = measure.getBounds();
        if (bounds != null) {
            if (bounds.size() >= 2) {
                if (this.buckets == null) {
                    this.buckets = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (i2 >= bounds.size()) {
                            break;
                        }
                        this.buckets.add(new Bucket(bounds.get(i), bounds.get(i2)));
                        i = i2;
                    }
                    Bucket bucket = getBucket(this.value);
                    if (bucket != null) {
                        bucket.increase();
                    }
                }
            }
        }
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public void setOffset(double d) {
        this.offset = Double.valueOf(d);
    }

    public void setValue(double d) {
        this.value = d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.finish ? 1 : 0);
            Double d = this.offset;
            parcel.writeDouble(d == null ? 0.0d : d.doubleValue());
            parcel.writeDouble(this.value);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public MeasureValue(double d) {
        this.value = d;
    }

    public static MeasureValue create(double d) {
        return (MeasureValue) a.a().poll(MeasureValue.class, Double.valueOf(d));
    }

    public synchronized void merge(MeasureValue measureValue) {
        if (measureValue != null) {
            try {
                this.value += measureValue.getValue();
                if (measureValue.getOffset() != null) {
                    if (this.offset == null) {
                        this.offset = Double.valueOf(0.0d);
                    }
                    this.offset = Double.valueOf(this.offset.doubleValue() + measureValue.getOffset().doubleValue());
                }
                Bucket bucket = getBucket(measureValue.getValue());
                if (bucket != null) {
                    bucket.increase();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static MeasureValue create(double d, double d2) {
        return (MeasureValue) a.a().poll(MeasureValue.class, Double.valueOf(d), Double.valueOf(d2));
    }

    @Deprecated
    public MeasureValue(double d, double d2) {
        this.offset = Double.valueOf(d2);
        this.value = d;
        this.finish = false;
    }
}
