package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface ValueParser<V> {
    V parse(JsonReader jsonReader, float f) throws IOException;
}
