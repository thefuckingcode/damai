package com.alibaba.security.realidentity.business.uploadresult;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class a extends b {
    BiometricsBucketParams d;
    UploadResultParams e;

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
        UploadResultParams uploadResultParams = this.e;
        return uploadResultParams == null ? "" : h.a(uploadResultParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.A;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.B;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String g() {
        ALBiometricsResult aLBiometricsResult;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        UploadResultParams uploadResultParams = this.e;
        if (!(uploadResultParams == null || (aLBiometricsResult = uploadResultParams.biometricsResult) == null)) {
            if (!TextUtils.isEmpty(aLBiometricsResult.getCollectedData())) {
                arrayList.add("sensorActionLog");
            }
            if (!TextUtils.isEmpty(this.e.biometricsResult.getBh())) {
                arrayList.add("flActionLog");
            }
        }
        hashMap.put("useLiteVM", Integer.valueOf(GetCacheDataManager.getInstance().isUseLiteVm() ? 1 : 0));
        hashMap.put("actionLogKeys", arrayList);
        return h.a((Map) hashMap);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void h() {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final BusinessType i() {
        return BusinessType.UPLOADRESULT;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String b() {
        UploadResultParams uploadResultParams = this.e;
        return uploadResultParams == null ? "" : h.a(uploadResultParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, final b.a aVar) {
        this.d = cVar.d;
        this.e = cVar.f;
        a();
        if (this.d.isCalledFinishSuccessfully()) {
            aVar.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        BusinessHttpWrapper rpcRequest = this.e.getRpcRequest();
        IHttpInvoker e2 = i.a.a.e();
        if (e2 != null) {
            e2.upload(rpcRequest, new com.alibaba.security.realidentity.business.base.chain.c(this.e) {
                /* class com.alibaba.security.realidentity.business.uploadresult.a.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    aVar.e = (UploadResultParams) httpBucketParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(httpBucketParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    UploadResultParams uploadResultParams = (UploadResultParams) httpBucketParams;
                    aVar.e = uploadResultParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(uploadResultParams, !aVar.d.isNeedBioResultPage);
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
            e2.upload(businessHttpWrapper, new com.alibaba.security.realidentity.business.base.chain.c(this.e) {
                /* class com.alibaba.security.realidentity.business.uploadresult.a.AnonymousClass1 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    aVar.e = (UploadResultParams) httpBucketParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(httpBucketParams, !aVar.d.isNeedBioResultPage);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    a aVar = a.this;
                    UploadResultParams uploadResultParams = (UploadResultParams) httpBucketParams;
                    aVar.e = uploadResultParams;
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(uploadResultParams, !aVar.d.isNeedBioResultPage);
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
