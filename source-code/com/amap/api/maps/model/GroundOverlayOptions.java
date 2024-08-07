package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* compiled from: Taobao */
public final class GroundOverlayOptions extends BaseOptions implements Parcelable {
    private static final String CLASSNAME = "GroundOverlayOptions";
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final double NF_PI;
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private String bitmapSymbol;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private final String type;
    private float width;
    private float zIndex;

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng2, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.type = CLASSNAME;
        this.mVersionCode = i;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng2;
        this.width = f;
        this.height = f2;
        this.latlngBounds = latLngBounds;
        this.bearing = f3;
        this.zIndex = f4;
        this.isVisible = z;
        this.transparency = f5;
        this.anchorU = f6;
        this.anchorV = f7;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
    }

    private GroundOverlayOptions a(LatLng latLng2, float f, float f2) {
        this.latLng = latLng2;
        this.width = f;
        this.height = f2;
        b();
        return this;
    }

    private void b() {
        LatLng latLng2 = this.latLng;
        if (latLng2 != null) {
            double cos = ((double) this.width) / ((Math.cos(latLng2.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
            double d = ((double) this.height) / 111194.94043265979d;
            try {
                LatLng latLng3 = this.latLng;
                LatLng latLng4 = new LatLng(latLng3.latitude - (((double) (1.0f - this.anchorV)) * d), latLng3.longitude - (((double) this.anchorU) * cos));
                LatLng latLng5 = this.latLng;
                LatLngBounds latLngBounds = new LatLngBounds(latLng4, new LatLng(latLng5.latitude + (((double) this.anchorV) * d), latLng5.longitude + (((double) (1.0f - this.anchorU)) * cos)));
                this.latlngBounds = latLngBounds;
                this.southwest = latLngBounds.southwest;
                this.northeast = latLngBounds.northeast;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        if (this.latlngBounds != null) {
            a();
        } else if (this.latLng != null) {
            b();
        }
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.bearing = f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public float getBearing() {
        return this.bearing;
    }

    public LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public float getHeight() {
        return this.height;
    }

    public BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public LatLng getLocation() {
        return this.latLng;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public float getWidth() {
        return this.width;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        if (bitmapDescriptor2 != null) {
            this.bitmapSymbol = bitmapDescriptor2.getId();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public GroundOverlayOptions position(LatLng latLng2, float f) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng2 == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f) {
            Log.w(CLASSNAME, "Width must be non-negative");
        }
        return a(latLng2, f, f);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        a();
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f < 0.0f) {
            Log.w(CLASSNAME, "Transparency must be in the range [0..1]");
            f = 0.0f;
        }
        this.transparency = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i);
        parcel.writeParcelable(this.latLng, i);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    private void a() {
        if (this.southwest != null && this.northeast != null) {
            LatLng latLng2 = this.southwest;
            double d = latLng2.latitude;
            LatLng latLng3 = this.northeast;
            double d2 = d + (((double) (1.0f - this.anchorV)) * (latLng3.latitude - d));
            double d3 = latLng2.longitude;
            LatLng latLng4 = new LatLng(d2, d3 + (((double) this.anchorU) * (latLng3.longitude - d3)));
            this.latLng = latLng4;
            LatLng latLng5 = this.northeast;
            double d4 = latLng5.longitude;
            LatLng latLng6 = this.southwest;
            this.width = (float) (Math.cos(latLng4.latitude * 0.01745329251994329d) * 6371000.79d * (d4 - latLng6.longitude) * 0.01745329251994329d);
            this.height = (float) ((latLng5.latitude - latLng6.latitude) * 6371000.79d * 0.01745329251994329d);
        }
    }

    public GroundOverlayOptions position(LatLng latLng2, float f, float f2) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng2 == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w(CLASSNAME, "Width and Height must be non-negative");
        }
        return a(latLng2, f, f2);
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.type = CLASSNAME;
        this.mVersionCode = 1;
    }
}
