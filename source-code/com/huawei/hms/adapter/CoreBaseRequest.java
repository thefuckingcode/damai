package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class CoreBaseRequest implements IMessageEntity {
    @Packed
    private String jsonHeader;
    @Packed
    private String jsonObject;
    @Packed
    private Parcelable parcelable;

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setJsonHeader(String str) {
        this.jsonHeader = str;
    }

    public void setJsonObject(String str) {
        this.jsonObject = str;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }
}
