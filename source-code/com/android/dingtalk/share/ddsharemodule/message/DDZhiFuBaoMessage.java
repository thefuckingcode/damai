package com.android.dingtalk.share.ddsharemodule.message;

import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
public class DDZhiFuBaoMessage extends BaseMediaObject {
    private static final int MAX_WEBPAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDZhiFuBaoMessage";
    public String mUrl;

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.mUrl;
        if (str != null && str.length() != 0 && this.mUrl.length() <= 10240) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, url is invalid");
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ShareConstant.EXTRA_ZHIFUBAO_OBJECT_URL, this.mUrl);
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 0;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(ShareConstant.EXTRA_ZHIFUBAO_OBJECT_URL);
        }
    }
}
