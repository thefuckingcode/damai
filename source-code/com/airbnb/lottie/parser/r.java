package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.animation.keyframe.f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tb.b61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class r {
    static JsonReader.a a = JsonReader.a.a("k");

    static <T> List<b61<T>> a(JsonReader jsonReader, a aVar, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.q() == JsonReader.Token.STRING) {
            aVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.e();
        while (jsonReader.j()) {
            if (jsonReader.s(a) != 0) {
                jsonReader.u();
            } else if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.q() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.c(jsonReader, aVar, f, valueParser, false, z));
                } else {
                    while (jsonReader.j()) {
                        arrayList.add(q.c(jsonReader, aVar, f, valueParser, true, z));
                    }
                }
                jsonReader.f();
            } else {
                arrayList.add(q.c(jsonReader, aVar, f, valueParser, false, z));
            }
        }
        jsonReader.g();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends b61<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            b61 b61 = (b61) list.get(i2);
            i2++;
            b61 b612 = (b61) list.get(i2);
            b61.h = Float.valueOf(b612.g);
            if (b61.c == null && (t = b612.b) != null) {
                b61.c = t;
                if (b61 instanceof f) {
                    ((f) b61).i();
                }
            }
        }
        b61 b613 = (b61) list.get(i);
        if ((b613.b == null || b613.c == null) && list.size() > 1) {
            list.remove(b613);
        }
    }
}
