package com.google.vr.vrcore.performance.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class TimestampedTemperature implements Parcelable {
    public static final Parcelable.Creator<TimestampedTemperature> CREATOR = new a();
    private static final int PARCEL_SIZE = 16;
    public float temperature;
    public long timestamp;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<TimestampedTemperature> {
        a() {
        }

        /* renamed from: a */
        public TimestampedTemperature createFromParcel(Parcel parcel) {
            return new TimestampedTemperature(parcel);
        }

        /* renamed from: b */
        public TimestampedTemperature[] newArray(int i) {
            return new TimestampedTemperature[i];
        }
    }

    public TimestampedTemperature() {
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.temperature = parcel.readFloat();
        parcel.setDataPosition(dataPosition + readInt);
    }

    public void set(long j, float f) {
        this.timestamp = j;
        this.temperature = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(16);
        parcel.writeLong(this.timestamp);
        parcel.writeFloat(this.temperature);
        if (parcel.dataPosition() - dataPosition != 16) {
            throw new IllegalStateException("Parcelable implemented incorrectly, PARCEL_SIZE must include the size of each parcelled field.");
        }
    }

    public TimestampedTemperature(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void set(TimestampedTemperature timestampedTemperature) {
        set(timestampedTemperature.timestamp, timestampedTemperature.temperature);
    }
}
