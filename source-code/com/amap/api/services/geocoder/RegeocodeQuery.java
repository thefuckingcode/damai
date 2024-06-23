package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class RegeocodeQuery {
    private LatLonPoint a;
    private float b = 1000.0f;
    private String c = GeocodeSearch.AMAP;
    private String d = "";
    private String e = "distance";
    private String f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f2, String str) {
        this.a = latLonPoint;
        this.b = f2;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.c;
        if (str == null) {
            if (regeocodeQuery.c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.a;
        if (latLonPoint == null) {
            if (regeocodeQuery.a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.a)) {
            return false;
        }
        if (Float.floatToIntBits(this.b) != Float.floatToIntBits(regeocodeQuery.b) || !this.e.equals(regeocodeQuery.e)) {
            return false;
        }
        String str2 = this.f;
        if (str2 == null) {
            if (regeocodeQuery.f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f)) {
            return false;
        }
        return true;
    }

    public String getExtensions() {
        return this.f;
    }

    public String getLatLonType() {
        return this.c;
    }

    public String getMode() {
        return this.e;
    }

    public String getPoiType() {
        return this.d;
    }

    public LatLonPoint getPoint() {
        return this.a;
    }

    public float getRadius() {
        return this.b;
    }

    public int hashCode() {
        int i;
        String str = this.c;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i + 31) * 31;
        LatLonPoint latLonPoint = this.a;
        if (latLonPoint != null) {
            i2 = latLonPoint.hashCode();
        }
        return ((i3 + i2) * 31) + Float.floatToIntBits(this.b);
    }

    public void setExtensions(String str) {
        this.f = str;
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
            this.c = str;
        }
    }

    public void setMode(String str) {
        this.e = str;
    }

    public void setPoiType(String str) {
        this.d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setRadius(float f2) {
        this.b = f2;
    }
}
