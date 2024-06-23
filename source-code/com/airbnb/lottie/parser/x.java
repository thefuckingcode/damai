package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
public class x implements ValueParser<PointF> {
    public static final x INSTANCE = new x();

    private x() {
    }

    /* renamed from: a */
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return p.e(jsonReader, f);
    }
}
