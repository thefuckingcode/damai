package com.taobao.aranger.core.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.constant.Constants;

/* compiled from: Taobao */
public class MethodWrapper extends BaseWrapper implements Parcelable {
    public static final Parcelable.Creator<MethodWrapper> CREATOR = new Parcelable.Creator<MethodWrapper>() {
        /* class com.taobao.aranger.core.wrapper.MethodWrapper.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MethodWrapper createFromParcel(Parcel parcel) {
            MethodWrapper obtain = MethodWrapper.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        @Override // android.os.Parcelable.Creator
        public MethodWrapper[] newArray(int i) {
            return new MethodWrapper[i];
        }
    };
    private String mReturnType;

    private MethodWrapper() {
    }

    public static MethodWrapper obtain() {
        return new MethodWrapper();
    }

    public int describeContents() {
        return 0;
    }

    public String getReturnType() {
        return this.mReturnType;
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        if ((parcel.readByte() | 0) == 0) {
            this.mReturnType = parcel.readString();
        }
    }

    public MethodWrapper setMethodName(String str) {
        setName(str);
        return this;
    }

    public MethodWrapper setReturnType(String str) {
        this.mReturnType = str;
        return this;
    }

    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        String str = this.mReturnType;
        if (str == null || Constants.VOID.equals(str)) {
            parcel.writeByte((byte) 1);
            return;
        }
        parcel.writeByte((byte) 0);
        parcel.writeString(this.mReturnType);
    }
}
