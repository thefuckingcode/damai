package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;
import tb.b61;
import tb.h5;
import tb.i5;
import tb.j5;
import tb.k5;
import tb.m5;
import tb.n5;
import tb.o5;
import tb.q5;
import tb.xt2;

/* compiled from: Taobao */
public class d {
    private static <T> List<b61<T>> a(JsonReader jsonReader, float f, a aVar, ValueParser<T> valueParser) throws IOException {
        return r.a(jsonReader, aVar, f, valueParser, false);
    }

    private static <T> List<b61<T>> b(JsonReader jsonReader, a aVar, ValueParser<T> valueParser) throws IOException {
        return r.a(jsonReader, aVar, 1.0f, valueParser, false);
    }

    static h5 c(JsonReader jsonReader, a aVar) throws IOException {
        return new h5(b(jsonReader, aVar, f.INSTANCE));
    }

    static q5 d(JsonReader jsonReader, a aVar) throws IOException {
        return new q5(b(jsonReader, aVar, h.INSTANCE));
    }

    public static i5 e(JsonReader jsonReader, a aVar) throws IOException {
        return f(jsonReader, aVar, true);
    }

    public static i5 f(JsonReader jsonReader, a aVar, boolean z) throws IOException {
        return new i5(a(jsonReader, z ? xt2.e() : 1.0f, aVar, i.INSTANCE));
    }

    static j5 g(JsonReader jsonReader, a aVar, int i) throws IOException {
        return new j5(b(jsonReader, aVar, new l(i)));
    }

    static k5 h(JsonReader jsonReader, a aVar) throws IOException {
        return new k5(b(jsonReader, aVar, o.INSTANCE));
    }

    static m5 i(JsonReader jsonReader, a aVar) throws IOException {
        return new m5(r.a(jsonReader, aVar, xt2.e(), y.INSTANCE, true));
    }

    static n5 j(JsonReader jsonReader, a aVar) throws IOException {
        return new n5(b(jsonReader, aVar, c0.INSTANCE));
    }

    static o5 k(JsonReader jsonReader, a aVar) throws IOException {
        return new o5(a(jsonReader, xt2.e(), aVar, d0.INSTANCE));
    }
}
