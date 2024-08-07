package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public final class ControllerPositionEvent extends ControllerEvent {
    public static final Parcelable.Creator<ControllerPositionEvent> CREATOR = new a();
    public float x;
    public float y;
    public float z;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<ControllerPositionEvent> {
        a() {
        }

        /* renamed from: a */
        public ControllerPositionEvent createFromParcel(Parcel parcel) {
            return new ControllerPositionEvent(parcel);
        }

        /* renamed from: b */
        public ControllerPositionEvent[] newArray(int i) {
            return new ControllerPositionEvent[i];
        }
    }

    public ControllerPositionEvent() {
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerPositionEvent) {
            super.copyFrom(controllerEvent);
            ControllerPositionEvent controllerPositionEvent = (ControllerPositionEvent) controllerEvent;
            this.x = controllerPositionEvent.x;
            this.y = controllerPositionEvent.y;
            this.z = controllerPositionEvent.z;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerPositionEvent from non-ControllerPositionEvent instance.");
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

    public ControllerPositionEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
