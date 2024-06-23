package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
public class o implements ValueParser<Integer> {
    public static final o INSTANCE = new o();

    private o() {
    }

    /* renamed from: a */
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f));
    }
}
