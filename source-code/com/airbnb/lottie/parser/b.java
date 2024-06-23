package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.h5;
import tb.i5;
import tb.r5;

/* compiled from: Taobao */
public class b {
    private static JsonReader.a a = JsonReader.a.a("a");
    private static JsonReader.a b = JsonReader.a.a("fc", IRequestConst.SC, "sw", "t");

    public static r5 a(JsonReader jsonReader, a aVar) throws IOException {
        jsonReader.e();
        r5 r5Var = null;
        while (jsonReader.j()) {
            if (jsonReader.s(a) != 0) {
                jsonReader.t();
                jsonReader.u();
            } else {
                r5Var = b(jsonReader, aVar);
            }
        }
        jsonReader.g();
        return r5Var == null ? new r5(null, null, null, null) : r5Var;
    }

    private static r5 b(JsonReader jsonReader, a aVar) throws IOException {
        jsonReader.e();
        h5 h5Var = null;
        h5 h5Var2 = null;
        i5 i5Var = null;
        i5 i5Var2 = null;
        while (jsonReader.j()) {
            int s = jsonReader.s(b);
            if (s == 0) {
                h5Var = d.c(jsonReader, aVar);
            } else if (s == 1) {
                h5Var2 = d.c(jsonReader, aVar);
            } else if (s == 2) {
                i5Var = d.e(jsonReader, aVar);
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                i5Var2 = d.e(jsonReader, aVar);
            }
        }
        jsonReader.g();
        return new r5(h5Var, h5Var2, i5Var, i5Var2);
    }
}
