package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class ControllerGyroEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerGyroEvent> CREATOR = new a();
    public float x;
    public float y;
    public float z;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<ControllerGyroEvent> {
        a() {
        }

        /* renamed from: a */
        public ControllerGyroEvent createFromParcel(Parcel parcel) {
            return new ControllerGyroEvent(parcel);
        }

        /* renamed from: b */
        public ControllerGyroEvent[] newArray(int i) {
            return new ControllerGyroEvent[i];
        }
    }

    public ControllerGyroEvent() {
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerGyroEvent) {
            super.copyFrom(controllerEvent);
            ControllerGyroEvent controllerGyroEvent = (ControllerGyroEvent) controllerEvent;
            this.x = controllerGyroEvent.x;
            this.y = controllerGyroEvent.y;
            this.z = controllerGyroEvent.z;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerGyroEvent from non-ControllerGyroEvent instance.");
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 12;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.z = parcel.readFloat();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.z);
    }

    public ControllerGyroEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
