package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.i5;
import tb.m5;
import tb.rx1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "p", "s", UploadQueueMgr.MSGTYPE_REALTIME, "hd");

    static rx1 a(JsonReader jsonReader, a aVar) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        m5 m5Var = null;
        i5 i5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                animatableValue = a.b(jsonReader, aVar);
            } else if (s == 2) {
                m5Var = d.i(jsonReader, aVar);
            } else if (s == 3) {
                i5Var = d.e(jsonReader, aVar);
            } else if (s != 4) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new rx1(str, animatableValue, m5Var, i5Var, z);
    }
}
