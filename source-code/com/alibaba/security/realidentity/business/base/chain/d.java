package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.b;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.c;

/* compiled from: Taobao */
public final class d {
    private static final String d = "BusinessNode";
    int a;
    d b;
    d c;
    private b e;
    private final com.alibaba.security.realidentity.business.base.b f;

    public d(com.alibaba.security.realidentity.business.base.b bVar) {
        this.f = bVar;
    }

    private void b(d dVar) {
        this.b = dVar;
    }

    private void b(c cVar, BucketParams bucketParams, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.a(cVar);
        }
        a(cVar, bucketParams, z);
    }

    public d(com.alibaba.security.realidentity.business.base.b bVar, b bVar2) {
        this.f = bVar;
        this.e = bVar2;
    }

    private void a(int i) {
        this.a = i;
    }

    private int a() {
        return this.a;
    }

    private void b(BusinessType businessType, c cVar, BucketParams bucketParams, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.a(cVar, bucketParams);
        }
        a(businessType, cVar, bucketParams, z);
    }

    private void a(d dVar) {
        this.c = dVar;
    }

    public final void a(final c cVar) {
        this.f.a(cVar, new a() {
            /* class com.alibaba.security.realidentity.business.base.chain.d.AnonymousClass1 */

            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BucketParams bucketParams, boolean z) {
                d dVar = d.this;
                if (dVar.c == null) {
                    dVar.a(cVar, bucketParams, z);
                } else if (cVar.a()) {
                    d.this.c.a(cVar);
                }
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BusinessType businessType, BucketParams bucketParams, boolean z) {
                d.this.a(businessType, cVar, bucketParams, z);
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BusinessType businessType, BucketParams bucketParams, String str, boolean z) {
                d.this.a(businessType, cVar, bucketParams, str, z);
            }
        });
    }

    private void b(BusinessType businessType, c cVar, BucketParams bucketParams, String str, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.b(cVar, bucketParams);
        }
        a(businessType, cVar, bucketParams, str, z);
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar, BucketParams bucketParams, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(cVar, bucketParams, z);
            return;
        }
        b bVar = this.e;
        if (bVar != null && z) {
            bVar.a(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(BusinessType businessType, c cVar, BucketParams bucketParams, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(businessType, cVar, bucketParams, z);
            return;
        }
        b bVar = this.e;
        if (bVar != null && z) {
            bVar.a(businessType, cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(BusinessType businessType, c cVar, BucketParams bucketParams, String str, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(businessType, cVar, bucketParams, str, z);
            return;
        }
        b bVar = this.e;
        if (bVar != null && z) {
            bVar.a(cVar, str);
        }
    }
}
