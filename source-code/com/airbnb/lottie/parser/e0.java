package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.huawei.hms.opendevice.c;
import java.io.IOException;
import java.util.Collections;
import tb.b61;
import tb.h5;
import tb.k5;
import tb.n92;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class e0 {
    private static final JsonReader.a a = JsonReader.a.a("nm", c.a, "o", "fillEnabled", UploadQueueMgr.MSGTYPE_REALTIME, "hd");

    static n92 a(JsonReader jsonReader, a aVar) throws IOException {
        k5 k5Var = null;
        String str = null;
        h5 h5Var = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                h5Var = d.c(jsonReader, aVar);
            } else if (s == 2) {
                k5Var = d.h(jsonReader, aVar);
            } else if (s == 3) {
                z = jsonReader.k();
            } else if (s == 4) {
                i = jsonReader.m();
            } else if (s != 5) {
                jsonReader.t();
                jsonReader.u();
            } else {
                z2 = jsonReader.k();
            }
        }
        return new n92(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, h5Var, k5Var == null ? new k5(Collections.singletonList(new b61(100))) : k5Var, z2);
    }
}
