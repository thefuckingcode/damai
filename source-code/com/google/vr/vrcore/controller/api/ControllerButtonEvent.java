package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import tb.jl1;

/* compiled from: Taobao */
public final class ControllerButtonEvent extends ControllerEvent {
    public static final int BUTTON_APP = 3;
    public static final int BUTTON_CLICK = 1;
    public static final int BUTTON_COUNT = 7;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_VOLUME_DOWN = 6;
    public static final int BUTTON_VOLUME_UP = 5;
    public static final Parcelable.Creator<ControllerButtonEvent> CREATOR = new a();
    public int button;
    public boolean down;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<ControllerButtonEvent> {
        a() {
        }

        /* renamed from: a */
        public ControllerButtonEvent createFromParcel(Parcel parcel) {
            return new ControllerButtonEvent(parcel);
        }

        /* renamed from: b */
        public ControllerButtonEvent[] newArray(int i) {
            return new ControllerButtonEvent[i];
        }
    }

    public ControllerButtonEvent() {
    }

    public static String buttonToString(int i) {
        if (i == 0) {
            return "BUTTON_NONE";
        }
        if (i == 1) {
            return "BUTTON_CLICK";
        }
        if (i == 2) {
            return "BUTTON_HOME";
        }
        if (i == 3) {
            return "BUTTON_APP";
        }
        if (i == 5) {
            return "BUTTON_VOLUME_UP";
        }
        if (i == 6) {
            return "BUTTON_VOLUME_DOWN";
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Unknown button: ");
        sb.append(i);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void copyFrom(ControllerEvent controllerEvent) {
        if (controllerEvent instanceof ControllerButtonEvent) {
            super.copyFrom(controllerEvent);
            ControllerButtonEvent controllerButtonEvent = (ControllerButtonEvent) controllerEvent;
            this.button = controllerButtonEvent.button;
            this.down = controllerButtonEvent.down;
            return;
        }
        throw new IllegalStateException("Cannot copy ControllerButtonEvent from non-ControllerButtonEvent instance.");
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final int getByteSize() {
        return super.getByteSize() + 8;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.button = parcel.readInt();
        this.down = parcel.readInt() != 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.button);
        parcel.writeInt(this.down ? 1 : 0);
    }

    public ControllerButtonEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
