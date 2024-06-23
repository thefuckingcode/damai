package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import java.util.Collections;
import tb.b61;
import tb.et0;
import tb.j5;
import tb.k5;
import tb.m5;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class m {
    private static final JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", UploadQueueMgr.MSGTYPE_REALTIME, "hd");
    private static final JsonReader.a b = JsonReader.a.a("p", "k");

    static et0 a(JsonReader jsonReader, a aVar) throws IOException {
        k5 k5Var = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        j5 j5Var = null;
        m5 m5Var = null;
        m5 m5Var2 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s == 0) {
                            i = jsonReader.m();
                        } else if (s != 1) {
                            jsonReader.t();
                            jsonReader.u();
                        } else {
                            j5Var = d.g(jsonReader, aVar, i);
                        }
                    }
                    jsonReader.g();
                    break;
                case 2:
                    k5Var = d.h(jsonReader, aVar);
                    break;
                case 3:
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    m5Var = d.i(jsonReader, aVar);
                    break;
                case 5:
                    m5Var2 = d.i(jsonReader, aVar);
                    break;
                case 6:
                    fillType = jsonReader.m() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        return new et0(str, gradientType, fillType, j5Var, k5Var == null ? new k5(Collections.singletonList(new b61(100))) : k5Var, m5Var, m5Var2, null, null, z);
    }
}
