package com.efs.sdk.base.a.b;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.e.b;
import java.io.File;
import tb.g23;
import tb.w23;

/* compiled from: Taobao */
public final class g implements f {
    @Override // com.efs.sdk.base.a.b.f
    public final boolean a(File file) {
        g23 h = w23.h(file.getName());
        if (h != null) {
            return !Constants.LOG_TYPE_WA.equals(h.a.a) && !b.b().e(h.a.a, file.length());
        }
        a unused = a.b.a;
        a.d(file);
        return true;
    }
}
