package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class ControllerOrientationEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerOrientationEvent> CREATOR = new a();
    public float qw;
    public float qx;
    public float qy;
    public float qz;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<ControllerOrientationEvent> {
        a() {
        }

        /* renamed from: a */
        public ControllerOrientationEvent createFromParcel(Parcel parcel) {
            return new ControllerOrientationEvent(parcel);
        }

        /* renamed from: b */
        public ControllerOrientationEvent[] newArray(int i) {
            return new ControllerOrientationEvent[i];
        }
    }

    public ControllerOrientationEvent() {
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerOrientationEvent) {
            super.copyFrom(controllerEvent);
            ControllerOrientationEvent controllerOrientationEvent = (ControllerOrientationEvent) controllerEvent;
            this.qx = controllerOrientationEvent.qx;
            this.qy = controllerOrientationEvent.qy;
            this.qz = controllerOrientationEvent.qz;
            this.qw = controllerOrientationEvent.qw;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerOrientationEvent from non-ControllerOrientationEvent instance.");
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 16;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.qx = parcel.readFloat();
        this.qy = parcel.readFloat();
        this.qz = parcel.readFloat();
        this.qw = parcel.readFloat();
    }

    public final void set(ControllerOrientationEvent controllerOrientationEvent) {
        this.qx = controllerOrientationEvent.qx;
        this.qy = controllerOrientationEvent.qy;
        this.qz = controllerOrientationEvent.qz;
        this.qw = controllerOrientationEvent.qw;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.qx);
        parcel.writeFloat(this.qy);
        parcel.writeFloat(this.qz);
        parcel.writeFloat(this.qw);
    }

    public ControllerOrientationEvent(float f, float f2, float f3, float f4) {
        this.qx = f;
        this.qy = f2;
        this.qz = f3;
        this.qw = f4;
    }

    public ControllerOrientationEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
