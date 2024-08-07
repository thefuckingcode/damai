package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class VideoSourceObject extends MediaObject {
    public static final Parcelable.Creator<VideoSourceObject> CREATOR = new Parcelable.Creator<VideoSourceObject>() {
        /* class com.sina.weibo.sdk.api.VideoSourceObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final VideoSourceObject createFromParcel(Parcel parcel) {
            return new VideoSourceObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VideoSourceObject[] newArray(int i) {
            return new VideoSourceObject[i];
        }
    };
    private static final long serialVersionUID = 2745594466460840583L;
    public Uri coverPath;
    public long during;
    public Uri videoPath;

    public VideoSourceObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coverPath, i);
        parcel.writeParcelable(this.videoPath, i);
        parcel.writeLong(this.during);
    }

    protected VideoSourceObject(Parcel parcel) {
        super(parcel);
        this.coverPath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoPath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.during = parcel.readLong();
    }
}
