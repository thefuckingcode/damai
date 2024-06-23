package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
public abstract class c extends RetrofitHttpCallback {
    private HttpBucketParams a;

    public c(HttpBucketParams httpBucketParams) {
        this.a = httpBucketParams;
    }

    /* access modifiers changed from: protected */
    public abstract void a(HttpBucketParams httpBucketParams);

    /* access modifiers changed from: protected */
    public abstract void b(HttpBucketParams httpBucketParams);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onFailure(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        b(this.a);
    }

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onSuccess(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        a(this.a);
    }
}
