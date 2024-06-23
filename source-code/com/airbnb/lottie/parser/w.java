package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.animation.keyframe.f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.xt2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class w {
    static f a(JsonReader jsonReader, a aVar) throws IOException {
        return new f(aVar, q.c(jsonReader, aVar, xt2.e(), x.INSTANCE, jsonReader.q() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
