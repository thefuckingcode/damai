package com.google.vr.vrcore.logging.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.protobuf.nano.MessageNano;

/* compiled from: Taobao */
public class VREventParcelable implements Parcelable {
    public static final Parcelable.Creator<VREventParcelable> CREATOR = new a();
    private static final String TAG = VREventParcelable.class.getSimpleName();
    private Vr$VREvent event;
    private int eventCode;

    /* compiled from: Taobao */
    class a implements Parcelable.Creator<VREventParcelable> {
        a() {
        }

        /* renamed from: a */
        public VREventParcelable createFromParcel(Parcel parcel) {
            return new VREventParcelable(parcel, (a) null);
        }

        /* renamed from: b */
        public VREventParcelable[] newArray(int i) {
            return new VREventParcelable[i];
        }
    }

    /* synthetic */ VREventParcelable(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public Vr$VREvent getEvent() {
        return this.event;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.eventCode);
        Vr$VREvent vr$VREvent = this.event;
        if (vr$VREvent != null) {
            parcel.writeByteArray(Vr$VREvent.toByteArray(vr$VREvent));
        }
    }

    public VREventParcelable(int i, Vr$VREvent vr$VREvent) {
        this.eventCode = i;
        this.event = vr$VREvent;
    }

    private VREventParcelable(Parcel parcel) {
        this.eventCode = parcel.readInt();
        try {
            byte[] createByteArray = parcel.createByteArray();
            if (createByteArray.length > 0) {
                this.event = MessageNano.mergeFrom(new Vr$VREvent(), createByteArray);
            }
        } catch (Exception e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 35);
            sb.append("Logging with empty VREvent. Error: ");
            sb.append(valueOf);
            Log.i(str, sb.toString());
        }
    }
}
