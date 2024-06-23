package com.alipay.share.sdk.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: Taobao */
public class APImageObject implements APMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public APImageObject() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061  */
    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public boolean checkArgs() {
        int i;
        String str;
        String str2;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && (((str = this.imagePath) == null || str.length() == 0) && ((str2 = this.imageUrl) == null || str2.length() == 0))) {
            Log.e("APSDK.ZFBImageObject", "checkArgs fail, all arguments are null");
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 == null || bArr2.length <= 10485760) {
            String str3 = this.imagePath;
            if (str3 == null || str3.length() <= 10240) {
                String str4 = this.imagePath;
                if (str4 != null) {
                    if (!(str4 == null || str4.length() == 0)) {
                        File file = new File(str4);
                        if (file.exists()) {
                            i = (int) file.length();
                            if (i > 10485760) {
                                Log.e("APSDK.ZFBImageObject", "checkArgs fail, image content is too large");
                                return false;
                            }
                        }
                    }
                    i = 0;
                    if (i > 10485760) {
                    }
                }
                String str5 = this.imageUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                Log.e("APSDK.ZFBImageObject", "checkArgs fail, url is invalid");
                return false;
            }
            Log.e("APSDK.ZFBImageObject", "checkArgs fail, path is invalid");
            return false;
        }
        Log.e("APSDK.ZFBImageObject", "checkArgs fail, content is too large");
        return false;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray(Constant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.imageData);
        bundle.putString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.imagePath);
        bundle.putString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.imageUrl);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 14;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray(Constant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
        this.imagePath = bundle.getString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
        this.imageUrl = bundle.getString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
    }

    public APImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    public APImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
