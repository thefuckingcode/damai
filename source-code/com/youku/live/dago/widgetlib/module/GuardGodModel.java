package com.youku.live.dago.widgetlib.module;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class GuardGodModel implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<GuardGodModel> CREATOR = new Parcelable.Creator<GuardGodModel>() {
        /* class com.youku.live.dago.widgetlib.module.GuardGodModel.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public GuardGodModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-687126453")) {
                return new GuardGodModel(parcel);
            }
            return (GuardGodModel) ipChange.ipc$dispatch("-687126453", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public GuardGodModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "924600318")) {
                return new GuardGodModel[i];
            }
            return (GuardGodModel[]) ipChange.ipc$dispatch("924600318", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String f;
    public boolean i;

    /* renamed from: io  reason: collision with root package name */
    public boolean f1069io;
    public boolean isEmpty = false;
    public boolean isSelfGuard = false;
    public long l;
    public long ld;
    public long lh;
    public long lm;
    public String n;
    public String u;

    public GuardGodModel() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-861536741")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-861536741", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247144432")) {
            ipChange.ipc$dispatch("-247144432", new Object[]{this, parcel, Integer.valueOf(i2)});
            return;
        }
        parcel.writeString(this.u);
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeLong(this.l);
        parcel.writeString(this.f);
        parcel.writeByte(this.f1069io ? (byte) 1 : 0);
        parcel.writeLong(this.ld);
        parcel.writeLong(this.lh);
        parcel.writeLong(this.lm);
        parcel.writeString(this.n);
        parcel.writeByte(this.isEmpty ? (byte) 1 : 0);
        parcel.writeByte(this.isSelfGuard ? (byte) 1 : 0);
    }

    protected GuardGodModel(Parcel parcel) {
        boolean z = false;
        this.u = parcel.readString();
        this.i = parcel.readByte() != 0;
        this.l = parcel.readLong();
        this.f = parcel.readString();
        this.f1069io = parcel.readByte() != 0;
        this.ld = parcel.readLong();
        this.lh = parcel.readLong();
        this.lm = parcel.readLong();
        this.n = parcel.readString();
        this.isEmpty = parcel.readByte() != 0;
        this.isSelfGuard = parcel.readByte() != 0 ? true : z;
    }
}
