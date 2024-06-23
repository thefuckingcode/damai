package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* compiled from: Taobao */
public class ControllerListenerOptions implements Parcelable {
    public static final Parcelable.Creator<ControllerListenerOptions> CREATOR = new a();
    public boolean enableAccel;
    public boolean enableGestures;
    public boolean enableGyro;
    public boolean enableOrientation;
    public boolean enableTouch;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<ControllerListenerOptions> {
        a() {
        }

        /* renamed from: a */
        public ControllerListenerOptions createFromParcel(Parcel parcel) {
            return new ControllerListenerOptions(parcel);
        }

        /* renamed from: b */
        public ControllerListenerOptions[] newArray(int i) {
            return new ControllerListenerOptions[i];
        }
    }

    public ControllerListenerOptions() {
        this.enableOrientation = true;
        this.enableTouch = true;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z = true;
        this.enableOrientation = parcel.readInt() != 0;
        this.enableGyro = parcel.readInt() != 0;
        this.enableAccel = parcel.readInt() != 0;
        this.enableTouch = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.enableGestures = z;
    }

    public String toString() {
        return String.format(Locale.US, "ori=%b, gyro=%b, accel=%b, touch=%b, gestures=%b", Boolean.valueOf(this.enableOrientation), Boolean.valueOf(this.enableGyro), Boolean.valueOf(this.enableAccel), Boolean.valueOf(this.enableTouch), Boolean.valueOf(this.enableGestures));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.enableOrientation ? 1 : 0);
        parcel.writeInt(this.enableGyro ? 1 : 0);
        parcel.writeInt(this.enableAccel ? 1 : 0);
        parcel.writeInt(this.enableTouch ? 1 : 0);
        parcel.writeInt(this.enableGestures ? 1 : 0);
    }

    protected ControllerListenerOptions(Parcel parcel) {
        readFromParcel(parcel);
    }
}
