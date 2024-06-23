package com.loc;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.common.app.ShareperfenceConstants;

/* compiled from: Taobao */
public final class ei implements Parcelable {
    public static final Parcelable.Creator<ei> CREATOR = new a();
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private String e;
    private String f;
    private String g = ShareperfenceConstants.FIRST;
    private String h = "";
    private String i = "";
    private String j = null;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<ei> {
        a() {
        }

        private static ei a(Parcel parcel) {
            ei eiVar = new ei();
            eiVar.c(parcel.readString());
            eiVar.d(parcel.readString());
            eiVar.e(parcel.readString());
            eiVar.f(parcel.readString());
            eiVar.b(parcel.readString());
            eiVar.c(parcel.readLong());
            eiVar.d(parcel.readLong());
            eiVar.a(parcel.readLong());
            eiVar.b(parcel.readLong());
            eiVar.a(parcel.readString());
            return eiVar;
        }

        private static ei[] b(int i) {
            return new ei[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ei createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ei[] newArray(int i) {
            return b(i);
        }
    }

    public final long a() {
        long j2 = this.d;
        long j3 = this.c;
        if (j2 - j3 <= 0) {
            return 0;
        }
        return j2 - j3;
    }

    public final void a(long j2) {
        this.c = j2;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final String b() {
        return this.i;
    }

    public final void b(long j2) {
        this.d = j2;
    }

    public final void b(String str) {
        this.j = str;
    }

    public final String c() {
        return this.j;
    }

    public final void c(long j2) {
        this.a = j2;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final String d() {
        return this.e;
    }

    public final void d(long j2) {
        this.b = j2;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final String f() {
        return this.g;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final String g() {
        return this.h;
    }

    public final long h() {
        long j2 = this.b;
        long j3 = this.a;
        if (j2 <= j3) {
            return 0;
        }
        return j2 - j3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.j);
            parcel.writeLong(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
            parcel.writeLong(this.d);
            parcel.writeString(this.i);
        } catch (Throwable unused) {
        }
    }
}
