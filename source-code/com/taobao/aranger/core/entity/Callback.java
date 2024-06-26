package com.taobao.aranger.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.utils.b;

/* compiled from: Taobao */
public class Callback implements Parcelable {
    public static final Parcelable.Creator<Callback> CREATOR = new Parcelable.Creator<Callback>() {
        /* class com.taobao.aranger.core.entity.Callback.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Callback createFromParcel(Parcel parcel) {
            Callback obtain = Callback.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        @Override // android.os.Parcelable.Creator
        public Callback[] newArray(int i) {
            return new Callback[i];
        }
    };
    private boolean isOneWay;
    private boolean isVoid;
    private long mDataSize;
    private String mKey;
    private MethodWrapper mMethodWrapper;
    private ParameterWrapper[] mParameterWrappers;

    private Callback() {
    }

    public static Callback obtain() {
        return new Callback();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void readFromParcel(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mMethodWrapper = MethodWrapper.CREATOR.createFromParcel(parcel);
        this.mParameterWrappers = (ParameterWrapper[]) b.e(getClass().getClassLoader(), parcel);
    }

    public int describeContents() {
        return 0;
    }

    public long getDataSize() {
        return this.mDataSize;
    }

    public String getKey() {
        return this.mKey;
    }

    public MethodWrapper getMethodWrapper() {
        return this.mMethodWrapper;
    }

    public ParameterWrapper[] getParameterWrappers() {
        return this.mParameterWrappers;
    }

    public boolean isOneWay() {
        return this.isOneWay;
    }

    public boolean isVoid() {
        return this.isVoid;
    }

    public Callback setKey(String str) {
        this.mKey = str;
        return this;
    }

    public Callback setMethodWrapper(MethodWrapper methodWrapper) {
        this.mMethodWrapper = methodWrapper;
        return this;
    }

    public Callback setOneWay(boolean z) {
        this.isOneWay = z;
        return this;
    }

    public Callback setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.mParameterWrappers = parameterWrapperArr;
        return this;
    }

    public Callback setVoid(boolean z) {
        this.isVoid = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        this.mMethodWrapper.writeToParcel(parcel, i);
        this.mDataSize = b.g(parcel, this.mParameterWrappers, i, true);
    }
}
