package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.opendevice.c;
import java.io.IOException;
import tb.i5;
import tb.s5;
import tb.vz1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b0 {
    private static JsonReader.a a = JsonReader.a.a("nm", c.a, "o", "tr", "hd");

    static vz1 a(JsonReader jsonReader, a aVar) throws IOException {
        String str = null;
        i5 i5Var = null;
        i5 i5Var2 = null;
        s5 s5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                i5Var = d.f(jsonReader, aVar, false);
            } else if (s == 2) {
                i5Var2 = d.f(jsonReader, aVar, false);
            } else if (s == 3) {
                s5Var = c.g(jsonReader, aVar);
            } else if (s != 4) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new vz1(str, i5Var, i5Var2, s5Var, z);
    }
}
