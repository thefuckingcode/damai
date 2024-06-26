package com.alibaba.poplayer.trigger;

import android.os.Parcel;
import android.os.Parcelable;
import tb.cr1;

/* compiled from: Taobao */
public class Event implements Parcelable {
    public static final Parcelable.Creator<Event> CREATOR = new a();
    public final String attachActivityKeyCode;
    public final int domain;
    public String originUri;
    public final String param;
    public final int source;
    public final String uri;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<Event> {
        a() {
        }

        /* renamed from: a */
        public Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* renamed from: b */
        public Event[] newArray(int i) {
            return new Event[i];
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public static final int ActiveCall = 3;
        public static final int Broadcast = 1;
        public static final int PageSwitch = 2;

        public static String a(int i) {
            if (i == 1) {
                return "Broadcast";
            }
            if (i == 2) {
                return "PageSwitch";
            }
            if (i != 3) {
                return null;
            }
            return "ActiveCall";
        }
    }

    public Event(int i, String str, String str2, String str3, int i2) {
        this.domain = i;
        this.uri = str;
        this.originUri = str;
        this.param = str2;
        this.attachActivityKeyCode = str3;
        this.source = i2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        try {
            return String.format("{domain:%s,uri:%s,param:%s,key:%s,source:%s}", Integer.valueOf(this.domain), this.uri, this.param, this.attachActivityKeyCode, b.a(this.source));
        } catch (Throwable th) {
            cr1.c("Event.toString.error", th);
            return "_event:" + this.uri;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.domain);
        parcel.writeString(this.uri);
        parcel.writeString(this.param);
        parcel.writeString(this.attachActivityKeyCode);
        parcel.writeInt(this.source);
        parcel.writeString(this.originUri);
    }

    protected Event(Parcel parcel) {
        this.domain = parcel.readInt();
        this.uri = parcel.readString();
        this.param = parcel.readString();
        this.attachActivityKeyCode = parcel.readString();
        this.source = parcel.readInt();
        this.originUri = parcel.readString();
    }
}
