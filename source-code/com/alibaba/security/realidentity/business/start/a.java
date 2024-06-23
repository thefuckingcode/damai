package com.alibaba.security.realidentity.business.start;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: Taobao */
public final class a extends b {
    protected StartHttpParams d;

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
    public final String b() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : h.a(startHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void b(c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String c() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : h.a(startHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.w;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.x;
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
        return BusinessType.START;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, final b.a aVar) {
        if (cVar != null) {
            this.d = cVar.c;
            SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() {
                /* class com.alibaba.security.realidentity.business.start.a.AnonymousClass1 */

                @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
                public final void onGetSensorValue(float f) {
                    a.this.d.setSensorInfo(new SensorInfo(f));
                    a.this.a();
                    a aVar = a.this;
                    a.a(aVar, aVar.d.getRpcRequest(), aVar);
                }
            });
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, final b.a aVar) {
        IHttpInvoker e = i.a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new com.alibaba.security.realidentity.business.base.chain.c(this.d) {
                /* class com.alibaba.security.realidentity.business.start.a.AnonymousClass2 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
                    a.this.d = startHttpParams;
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(startHttpParams, true);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
                    a.this.d = startHttpParams;
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b(startHttpParams, true);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(a.this.d, exc, true);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar, BusinessHttpWrapper businessHttpWrapper, final b.a aVar2) {
        IHttpInvoker e = i.a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new com.alibaba.security.realidentity.business.base.chain.c(aVar.d) {
                /* class com.alibaba.security.realidentity.business.start.a.AnonymousClass2 */

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void a(HttpBucketParams httpBucketParams) {
                    StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
                    a.this.d = startHttpParams;
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(startHttpParams, true);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c
                public final void b(HttpBucketParams httpBucketParams) {
                    StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
                    a.this.d = startHttpParams;
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b(startHttpParams, true);
                    }
                }

                @Override // com.alibaba.security.realidentity.business.base.chain.c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    b.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(a.this.d, exc, true);
                    }
                }
            });
        }
    }
}
