package com.taobao.orange.sync;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.impl.HurlNetConnection;
import com.taobao.orange.impl.TBNetConnection;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.MD5Util;
import com.taobao.orange.util.OLog;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
public abstract class BaseCdnRequest<T> extends BaseRequest<T> {
    private static final String TAG = "CdnRequest";
    private String mMD5;
    private String mUrl;

    public BaseCdnRequest(String str, String str2) {
        this.mUrl = str;
        this.mMD5 = str2;
    }

    /* access modifiers changed from: protected */
    public abstract T parseResContent(String str);

    @Override // com.taobao.orange.sync.BaseRequest
    public T syncRequest() {
        String str;
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "syncRequest start", "cdn url", this.mUrl);
        }
        try {
            INetConnection iNetConnection = (INetConnection) GlobalOrange.netConnection.newInstance();
            int i = iNetConnection instanceof HurlNetConnection ? GlobalOrange.reqRetryNum : 1;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    str = null;
                    break;
                }
                try {
                    iNetConnection.openConnection(this.mUrl);
                    iNetConnection.setMethod("GET");
                    if (iNetConnection instanceof TBNetConnection) {
                        iNetConnection.addHeader(HttpHeaderConstant.F_REFER, "orange");
                    }
                    iNetConnection.connect();
                    int responseCode = iNetConnection.getResponseCode();
                    this.code = responseCode;
                    if (responseCode == 200) {
                        str = iNetConnection.getResponse();
                        iNetConnection.disconnect();
                        break;
                    }
                    iNetConnection.disconnect();
                    i2++;
                } catch (Throwable th) {
                    iNetConnection.disconnect();
                    throw th;
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.code = -2;
                this.message = "content is empty";
                OLog.e(TAG, "syncRequest fail", "code", -2, "msg", this.message);
                return null;
            } else if (TextUtils.isEmpty(this.mMD5) || this.mMD5.equals(MD5Util.md5(str))) {
                try {
                    return parseResContent(str);
                } catch (Throwable th2) {
                    this.code = -4;
                    this.message = th2.getMessage();
                    OLog.e(TAG, "syncRequest fail", th2, new Object[0]);
                    return null;
                }
            } else {
                this.code = -3;
                this.message = "content is broken";
                OLog.e(TAG, "syncRequest fail", "code", -3, "msg", this.message);
                return null;
            }
        } catch (Throwable th3) {
            OLog.e(TAG, "syncRequest", th3, new Object[0]);
            this.message = th3.getMessage();
            return null;
        }
    }
}
