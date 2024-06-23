package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: Taobao */
public class DDImageMessage extends BaseMediaObject {
    private static final int MAX_IMAGE_DATA_LENGTH = 10485760;
    private static final int MAX_IMAGE_THUMB_DATA_LENGTH = 32768;
    private static final int MAX_IMAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDImageMessage";
    public byte[] mImageData;
    public String mImagePath;
    public Uri mImageUri;
    public String mImageUrl;

    public DDImageMessage() {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void attachContext(Context context) {
        Uri uri;
        if (context != null && (uri = this.mImageUri) != null) {
            try {
                context.grantUriPermission(ShareConstant.DD_APP_PACKAGE, uri, 1);
                context.grantUriPermission(ShareConstant.ALI_DD_APP_PACKAGE, this.mImageUri, 1);
            } catch (Throwable th) {
                Log.e(TAG, "attachContext: ", th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062  */
    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public boolean checkArgs() {
        int i;
        String str;
        String str2;
        byte[] bArr = this.mImageData;
        if ((bArr == null || bArr.length == 0) && (((str = this.mImagePath) == null || str.length() == 0) && (((str2 = this.mImageUrl) == null || str2.length() == 0) && this.mImageUri == null))) {
            Log.e(TAG, "checkArgs fail, all arguments are null");
            return false;
        }
        byte[] bArr2 = this.mImageData;
        if (bArr2 == null || bArr2.length <= MAX_IMAGE_DATA_LENGTH) {
            String str3 = this.mImagePath;
            if (str3 == null || str3.length() <= 10240) {
                String str4 = this.mImagePath;
                if (str4 != null) {
                    if (str4.length() != 0) {
                        File file = new File(str4);
                        if (file.exists()) {
                            i = (int) file.length();
                            if (i > MAX_IMAGE_DATA_LENGTH) {
                                Log.e(TAG, "checkArgs fail, image content is too large");
                                return false;
                            }
                        }
                    }
                    i = 0;
                    if (i > MAX_IMAGE_DATA_LENGTH) {
                    }
                }
                String str5 = this.mImageUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                Log.e(TAG, "checkArgs fail, url is invalid");
                return false;
            }
            Log.e(TAG, "checkArgs fail, path is invalid");
            return false;
        }
        Log.e(TAG, "checkArgs fail, content is too large");
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle != null) {
            bundle.putByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.mImageData);
            bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.mImagePath);
            bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.mImageUrl);
            bundle.putParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI, this.mImageUri);
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle != null) {
            this.mImageData = bundle.getByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
            this.mImagePath = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
            this.mImageUrl = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
            this.mImageUri = (Uri) bundle.getParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI);
        }
    }

    public DDImageMessage(byte[] bArr) {
        this.mImageData = bArr;
    }

    public DDImageMessage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
            this.mImageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
