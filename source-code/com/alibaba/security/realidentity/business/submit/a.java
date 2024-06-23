package com.alibaba.security.realidentity.business.submit;

import android.content.Context;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: Taobao */
public final class a extends b {
    BiometricsBucketParams d;
    SubmitHttpParams e;

    public a(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void b(c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String c() {
        SubmitHttpParams submitHttpParams = this.e;
        return submitHttpParams == null ? "" : h.a(submitHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.C;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.D;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String g() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void h() {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final BusinessType i() {
        return BusinessType.SUBMIT;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String b() {
        SubmitHttpParams submitHttpParams = this.e;
        return submitHttpParams == null ? "" : h.a(submitHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, final b.a aVar) {
        this.d = cVar.d;
        a();
        if (this.d.isCalledFinishSuccessfully()) {
            if (this.e == null) {
                this.e = cVar.g;
            }
            aVar.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        SubmitHttpParams submitHttpParams = cVar.g;
        this.e = submitHttpParams;
        BusinessHttpWrapper rpcRequest = submitHttpParams.getRpcRequest();
        IHttpInvoker e2 = i.a.a.e();
        if (e2 != null) {
            e2.submit(rpcRequest, new com.alibaba.security.realidentity.business.base.chain.c(this.e) {
                /* class com.alibaba.security.realidentity.business.submit.a.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    aVar.e = (SubmitHttpParams) httpBucketParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(httpBucketParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    SubmitHttpParams submitHttpParams = (SubmitHttpParams) httpBucketParams;
                    aVar.e = submitHttpParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(submitHttpParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    b.a aVar = aVar;
                    if (aVar != null) {
                        a aVar2 = a.this;
                        aVar.a(aVar2.e, exc, !aVar2.d.isNeedBioResultPage);
                    }
                }
            });
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, final b.a aVar) {
        IHttpInvoker e2 = i.a.a.e();
        if (e2 != null) {
            e2.submit(businessHttpWrapper, new com.alibaba.security.realidentity.business.base.chain.c(this.e) {
                /* class com.alibaba.security.realidentity.business.submit.a.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    aVar.e = (SubmitHttpParams) httpBucketParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(httpBucketParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    SubmitHttpParams submitHttpParams = (SubmitHttpParams) httpBucketParams;
                    aVar.e = submitHttpParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(submitHttpParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    b.a aVar = aVar;
                    if (aVar != null) {
                        a aVar2 = a.this;
                        aVar.a(aVar2.e, exc, !aVar2.d.isNeedBioResultPage);
                    }
                }
            });
        }
    }
}
