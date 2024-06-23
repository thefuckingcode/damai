package com.alibaba.security.realidentity.a;

import android.content.Context;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.jsbridge.a;

/* compiled from: Taobao */
public interface d {
    c a(Context context);

    AbsHttpInvoker a();

    Class<? extends a>[] b();

    Class<? extends BucketParams>[] c();

    b d();
}
