package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.um0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class k {
    private static final JsonReader.a a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    static um0 a(JsonReader jsonReader) throws IOException {
        jsonReader.e();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                str2 = jsonReader.o();
            } else if (s == 2) {
                str3 = jsonReader.o();
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                f = (float) jsonReader.l();
            }
        }
        jsonReader.g();
        return new um0(str, str2, str3, f);
    }
}
