package com.alibaba.pictures.bricks.channel.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PageArgument implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PageArgument> CREATOR = new a();
    public String args;
    public String patternName;
    public String patternVersion;

    /* compiled from: Taobao */
    public class a implements Parcelable.Creator<PageArgument> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public PageArgument createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-896123207")) {
                return new PageArgument(parcel);
            }
            return (PageArgument) ipChange.ipc$dispatch("-896123207", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public PageArgument[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1199129392")) {
                return new PageArgument[i];
            }
            return (PageArgument[]) ipChange.ipc$dispatch("1199129392", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public PageArgument() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1064696720")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1064696720", new Object[]{this})).intValue();
    }

    public JSONObject parseArg2Json() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026917487")) {
            return (JSONObject) ipChange.ipc$dispatch("-2026917487", new Object[]{this});
        }
        try {
            return JSON.parseObject(this.args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720001733")) {
            ipChange.ipc$dispatch("-1720001733", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.patternName);
        parcel.writeString(this.patternVersion);
        parcel.writeString(this.args);
    }

    protected PageArgument(Parcel parcel) {
        this.patternName = parcel.readString();
        this.patternVersion = parcel.readString();
        this.args = parcel.readString();
    }
}
