package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.o5;
import tb.p92;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class g0 {
    static JsonReader.a a = JsonReader.a.a("nm", "ind", "ks", "hd");

    static p92 a(JsonReader jsonReader, a aVar) throws IOException {
        int i = 0;
        String str = null;
        o5 o5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                i = jsonReader.m();
            } else if (s == 2) {
                o5Var = d.k(jsonReader, aVar);
            } else if (s != 3) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new p92(str, i, o5Var, z);
    }
}
