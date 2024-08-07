package com.taobao.aranger.core.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class ServiceWrapper extends BaseWrapper implements Parcelable {
    public static final Parcelable.Creator<ServiceWrapper> CREATOR = new Parcelable.Creator<ServiceWrapper>() {
        /* class com.taobao.aranger.core.wrapper.ServiceWrapper.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ServiceWrapper createFromParcel(Parcel parcel) {
            ServiceWrapper serviceWrapper = new ServiceWrapper();
            serviceWrapper.readFromParcel(parcel);
            return serviceWrapper;
        }

        @Override // android.os.Parcelable.Creator
        public ServiceWrapper[] newArray(int i) {
            return new ServiceWrapper[i];
        }
    };
    private String mTimeStamp;
    private int mType;
    private Class serviceInterfaceClass;

    public static ServiceWrapper obtain() {
        return new ServiceWrapper();
    }

    public int describeContents() {
        return 0;
    }

    public Class getServiceInterfaceClass() {
        return this.serviceInterfaceClass;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public int getType() {
        return this.mType;
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mTimeStamp = parcel.readString();
        this.mType = parcel.readByte();
    }

    public ServiceWrapper setServiceInterfaceClass(Class<?> cls) {
        this.serviceInterfaceClass = cls;
        return this;
    }

    public ServiceWrapper setServiceName(String str) {
        super.setName(str);
        return this;
    }

    public ServiceWrapper setTimeStamp(String str) {
        this.mTimeStamp = str;
        return this;
    }

    public ServiceWrapper setType(int i) {
        this.mType = i;
        return this;
    }

    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTimeStamp);
        parcel.writeByte((byte) this.mType);
    }

    private ServiceWrapper() {
    }
}
