package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.eq;
import tb.jl1;

/* compiled from: Taobao */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    /* compiled from: Taobao */
    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        private boolean a(double d) {
            double d2 = this.mWest;
            double d3 = this.mEast;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d = this.mWest;
            double d2 = this.mEast;
            if (d > d2) {
                this.mWest = d2;
                this.mEast = d;
            }
            double d3 = this.mSouth;
            double d4 = this.mNorth;
            if (d3 > d4) {
                this.mSouth = d4;
                this.mNorth = d3;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d;
                this.mEast = d;
            } else if (!a(d)) {
                if (LatLngBounds.c(this.mWest, d) < LatLngBounds.d(this.mEast, d)) {
                    this.mWest = d;
                } else {
                    this.mEast = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        boolean z;
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        } else if (latLng2 != null) {
            try {
                if (latLng2.latitude >= latLng.latitude) {
                    z = true;
                    this.mVersionCode = !z ? 0 : i;
                    this.southwest = !z ? null : latLng;
                    this.northeast = !z ? null : latLng2;
                    return;
                }
                throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + jl1.BRACKET_END_STR);
            } catch (Throwable th) {
                Log.e(CLASSNAME, "the structure parameters are illegal!");
                th.printStackTrace();
                z = false;
            }
        } else {
            throw new RuntimeRemoteException("null northeast");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.northeast == null || this.southwest == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        } else if (!a(latLng.latitude) || !b(latLng.longitude)) {
            return false;
        } else {
            return true;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return eq.a(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d;
        if (latLng == null) {
            return this;
        }
        if (this.northeast == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double min = Math.min(latLng2.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (!b(d4)) {
            if (c(d3, d4) < d(d2, d4)) {
                d3 = d4;
            } else {
                d = d4;
                return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
            }
        }
        d = d2;
        try {
            return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast == null || this.southwest == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        } else if (a(latLngBounds) || latLngBounds.a(this)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return eq.a(eq.a("southwest", this.southwest), eq.a("northeast", this.northeast));
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.a(this, parcel, i);
    }

    private boolean b(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.mVersionCode;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d = latLng.longitude;
        LatLng latLng3 = this.northeast;
        double d2 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d3 = latLng4.longitude;
        double d4 = ((latLng2.longitude + d) - d2) - d3;
        double d5 = ((d2 - d3) + d) - d3;
        double d6 = latLng.latitude;
        double d7 = latLng2.latitude;
        double d8 = latLng3.latitude;
        double d9 = latLng4.latitude;
        return Math.abs(d4) < d5 && Math.abs(((d6 + d7) - d8) - d9) < ((d8 - d9) + d6) - d7;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
