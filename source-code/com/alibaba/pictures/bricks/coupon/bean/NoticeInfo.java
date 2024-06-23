package com.alibaba.pictures.bricks.coupon.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class NoticeInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    private String ruleDesc;
    @Nullable
    private String ruleName;

    /* compiled from: Taobao */
    public static final class CREATOR implements Parcelable.Creator<NoticeInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        private CREATOR() {
        }

        public /* synthetic */ CREATOR(m40 m40) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeInfo createFromParcel(@NotNull Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-80256346")) {
                return (NoticeInfo) ipChange.ipc$dispatch("-80256346", new Object[]{this, parcel});
            }
            k21.i(parcel, "parcel");
            return new NoticeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "528645299")) {
                return new NoticeInfo[i];
            }
            return (NoticeInfo[]) ipChange.ipc$dispatch("528645299", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public NoticeInfo(@Nullable String str, @Nullable String str2) {
        this.ruleName = str;
        this.ruleDesc = str2;
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1113099037")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1113099037", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getRuleDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1236235762")) {
            return this.ruleDesc;
        }
        return (String) ipChange.ipc$dispatch("-1236235762", new Object[]{this});
    }

    @Nullable
    public final String getRuleName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1470711048")) {
            return this.ruleName;
        }
        return (String) ipChange.ipc$dispatch("1470711048", new Object[]{this});
    }

    public final void setRuleDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449069200")) {
            ipChange.ipc$dispatch("449069200", new Object[]{this, str});
            return;
        }
        this.ruleDesc = str;
    }

    public final void setRuleName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534925610")) {
            ipChange.ipc$dispatch("-1534925610", new Object[]{this, str});
            return;
        }
        this.ruleName = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761867704")) {
            ipChange.ipc$dispatch("-761867704", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        k21.i(parcel, "parcel");
        parcel.writeString(this.ruleName);
        parcel.writeString(this.ruleDesc);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NoticeInfo(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        k21.i(parcel, "parcel");
    }
}
