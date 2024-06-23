package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class WebpageObject extends MediaObject {
    public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() {
        /* class com.sina.weibo.sdk.api.WebpageObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    };
    private static final long serialVersionUID = 7142128794153927442L;
    public String defaultText;

    public WebpageObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }
}
