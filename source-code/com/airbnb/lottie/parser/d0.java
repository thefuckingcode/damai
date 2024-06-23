package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.opendevice.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.he1;
import tb.m92;
import tb.mp;

/* compiled from: Taobao */
public class d0 implements ValueParser<m92> {
    public static final d0 INSTANCE = new d0();
    private static final JsonReader.a a = JsonReader.a.a(c.a, "v", "i", "o");

    private d0() {
    }

    /* renamed from: a */
    public m92 parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.e();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                z = jsonReader.k();
            } else if (s == 1) {
                list = p.f(jsonReader, f);
            } else if (s == 2) {
                list2 = p.f(jsonReader, f);
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                list3 = p.f(jsonReader, f);
            }
        }
        jsonReader.g();
        if (jsonReader.q() == JsonReader.Token.END_ARRAY) {
            jsonReader.f();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new m92(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new mp(he1.a(list.get(i2), list3.get(i2)), he1.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new mp(he1.a(list.get(i3), list3.get(i3)), he1.a(pointF3, list2.get(0)), pointF3));
            }
            return new m92(pointF, z, arrayList);
        }
    }
}
