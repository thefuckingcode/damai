package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: Taobao */
public class ImageObject extends MediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 1048576;
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() {
        /* class com.sina.weibo.sdk.api.ImageObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int PATH_LENGTH_LIMIT = 512;
    private static final String TAG = "ImageObject";
    private static final long serialVersionUID = 8760548583231081050L;
    public byte[] imageData;
    public String imagePath;

    public ImageObject() {
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return (int) file.length();
    }

    public boolean checkArgs() {
        String str;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            c.b(TAG, "checkArgs fail, all arguments are null");
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 == null || bArr2.length <= 1048576) {
            String str2 = this.imagePath;
            if (str2 == null || str2.length() <= 512) {
                String str3 = this.imagePath;
                if (str3 == null || getFileSize(str3) <= 1048576) {
                    return true;
                }
                c.b(TAG, "checkArgs fail, image content is too large");
                return false;
            }
            c.b(TAG, "checkArgs fail, path is invalid");
            return false;
        }
        c.b(TAG, "checkArgs fail, content is too large");
        return false;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public int describeContents() {
        return 0;
    }

    public void setImageData(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            c.b(TAG, "ImageObject :" + e.getMessage());
        }
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    protected ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }
}
