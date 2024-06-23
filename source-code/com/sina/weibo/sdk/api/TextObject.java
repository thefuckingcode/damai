package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class TextObject extends MediaObject {
    public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() {
        /* class com.sina.weibo.sdk.api.TextObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    private static final long serialVersionUID = -5610314414793811821L;
    public String text;

    public TextObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    protected TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }
}
