package com.alibaba.pictures.bricks.coupon.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class NoticeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    private List<NoticeInfo> items;
    @Nullable
    private String title;

    /* compiled from: Taobao */
    public static final class CREATOR implements Parcelable.Creator<NoticeBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        private CREATOR() {
        }

        public /* synthetic */ CREATOR(m40 m40) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeBean createFromParcel(@NotNull Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "931158502")) {
                return (NoticeBean) ipChange.ipc$dispatch("931158502", new Object[]{this, parcel});
            }
            k21.i(parcel, "parcel");
            return new NoticeBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-976094801")) {
                return new NoticeBean[i];
            }
            return (NoticeBean[]) ipChange.ipc$dispatch("-976094801", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public NoticeBean(@Nullable String str, @Nullable List<NoticeInfo> list) {
        this.title = str;
        this.items = list;
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-724953499")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-724953499", new Object[]{this})).intValue();
    }

    @Nullable
    public final List<NoticeInfo> getItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "134382426")) {
            return this.items;
        }
        return (List) ipChange.ipc$dispatch("134382426", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "542485387")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("542485387", new Object[]{this});
    }

    public final void setItems(@Nullable List<NoticeInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099984566")) {
            ipChange.ipc$dispatch("-2099984566", new Object[]{this, list});
            return;
        }
        this.items = list;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128545355")) {
            ipChange.ipc$dispatch("2128545355", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889136390")) {
            ipChange.ipc$dispatch("889136390", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        k21.i(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeTypedList(this.items);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NoticeBean(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.createTypedArrayList(NoticeInfo.CREATOR));
        k21.i(parcel, "parcel");
    }
}
