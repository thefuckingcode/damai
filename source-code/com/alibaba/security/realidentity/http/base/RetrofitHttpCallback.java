package com.alibaba.security.realidentity.http.base;

import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alibaba.security.realidentity.http.RpHttpResponse;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
public abstract class RetrofitHttpCallback implements IHttpCallback {
    private static final String TAG = "RetrofitHttpCallback";
    private Class<? extends HttpResponse> httpResponse = HttpResponse.class;

    private HttpResponse analyzeResponse(String str, Class<? extends HttpResponse> cls) {
        try {
            return (HttpResponse) h.a(str, cls, false);
        } catch (Throwable unused) {
            a.c(TAG, "analyzeResponse fail ,jsonResponse is ".concat(String.valueOf(str)));
            return new HttpResponse() {
                /* class com.alibaba.security.realidentity.http.base.RetrofitHttpCallback.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.http.model.HttpResponse
                public boolean isSuccessful() {
                    return false;
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onFailure(HttpResponse httpResponse2);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onFailure(Exception exc) {
        onNetError(exc);
    }

    /* access modifiers changed from: protected */
    public abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.IHttpCallback
    public void onResponse(RpHttpResponse rpHttpResponse) {
        HttpResponse analyzeResponse = analyzeResponse(rpHttpResponse.getResponseBody(), this.httpResponse);
        if (analyzeResponse == null || !analyzeResponse.isSuccessful()) {
            onFailure(analyzeResponse);
        } else {
            onSuccess(analyzeResponse);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onSuccess(HttpResponse httpResponse2);

    public void setResponse(Class<? extends HttpResponse> cls) {
        this.httpResponse = cls;
    }
}
