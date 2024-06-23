package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class MultiImageObject extends MediaObject {
    public static final Parcelable.Creator<MultiImageObject> CREATOR = new Parcelable.Creator<MultiImageObject>() {
        /* class com.sina.weibo.sdk.api.MultiImageObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final MultiImageObject createFromParcel(Parcel parcel) {
            return new MultiImageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MultiImageObject[] newArray(int i) {
            return new MultiImageObject[i];
        }
    };
    private static final long serialVersionUID = 4858450022450986236L;
    public ArrayList<Uri> imageList;

    public MultiImageObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public int describeContents() {
        return 0;
    }

    public ArrayList<Uri> getImageList() {
        return this.imageList;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.imageList);
    }

    protected MultiImageObject(Parcel parcel) {
        super(parcel);
        this.imageList = parcel.createTypedArrayList(Uri.CREATOR);
    }
}
