package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
public class i implements ValueParser<Float> {
    public static final i INSTANCE = new i();

    private i() {
    }

    /* renamed from: a */
    public Float parse(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(p.g(jsonReader) * f);
    }
}
