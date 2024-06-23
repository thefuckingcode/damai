package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import tb.b61;
import tb.i5;
import tb.l5;
import tb.p5;
import tb.xt2;

/* compiled from: Taobao */
public class a {
    private static final JsonReader.a a = JsonReader.a.a("k", Constants.Name.X, Constants.Name.Y);

    public static l5 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.j()) {
                arrayList.add(w.a(jsonReader, aVar));
            }
            jsonReader.f();
            r.b(arrayList);
        } else {
            arrayList.add(new b61(p.e(jsonReader, xt2.e())));
        }
        return new l5(arrayList);
    }

    static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        jsonReader.e();
        l5 l5Var = null;
        i5 i5Var = null;
        i5 i5Var2 = null;
        boolean z = false;
        while (jsonReader.q() != JsonReader.Token.END_OBJECT) {
            int s = jsonReader.s(a);
            if (s != 0) {
                if (s != 1) {
                    if (s != 2) {
                        jsonReader.t();
                        jsonReader.u();
                    } else if (jsonReader.q() == JsonReader.Token.STRING) {
                        jsonReader.u();
                    } else {
                        i5Var2 = d.e(jsonReader, aVar);
                    }
                } else if (jsonReader.q() == JsonReader.Token.STRING) {
                    jsonReader.u();
                } else {
                    i5Var = d.e(jsonReader, aVar);
                }
                z = true;
            } else {
                l5Var = a(jsonReader, aVar);
            }
        }
        jsonReader.g();
        if (z) {
            aVar.a("Lottie doesn't support expressions.");
        }
        if (l5Var != null) {
            return l5Var;
        }
        return new p5(i5Var, i5Var2);
    }
}
