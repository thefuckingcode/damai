package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.b61;
import tb.i5;
import tb.j5;
import tb.k5;
import tb.m5;
import tb.o70;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class n {
    private static JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", WXComponent.PROP_FS_WRAP_CONTENT, o70.LOWER_PREFIX, "lj", "ml", "hd", "d");
    private static final JsonReader.a b = JsonReader.a.a("p", "k");
    private static final JsonReader.a c = JsonReader.a.a("n", "v");

    static a a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        j5 j5Var;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        j5 j5Var2 = null;
        m5 m5Var = null;
        m5 m5Var2 = null;
        i5 i5Var = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        i5 i5Var2 = null;
        boolean z = false;
        k5 k5Var = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s != 0) {
                            j5Var = j5Var2;
                            if (s != 1) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                j5Var2 = d.g(jsonReader, aVar, i);
                            }
                        } else {
                            j5Var = j5Var2;
                            i = jsonReader.m();
                        }
                        j5Var2 = j5Var;
                    }
                    jsonReader.g();
                    break;
                case 2:
                    k5Var = d.h(jsonReader, aVar);
                    break;
                case 3:
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    m5Var = d.i(jsonReader, aVar);
                    break;
                case 5:
                    m5Var2 = d.i(jsonReader, aVar);
                    break;
                case 6:
                    i5Var = d.e(jsonReader, aVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 9:
                    f = (float) jsonReader.l();
                    break;
                case 10:
                    z = jsonReader.k();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        i5 i5Var3 = null;
                        while (jsonReader.j()) {
                            int s2 = jsonReader.s(c);
                            if (s2 != 0) {
                                if (s2 != 1) {
                                    jsonReader.t();
                                    jsonReader.u();
                                } else {
                                    i5Var3 = d.e(jsonReader, aVar);
                                }
                                i5Var2 = i5Var2;
                            } else {
                                str2 = jsonReader.o();
                            }
                        }
                        jsonReader.g();
                        if (str2.equals("o")) {
                            i5Var2 = i5Var3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                aVar.t(true);
                                arrayList.add(i5Var3);
                            }
                            i5Var2 = i5Var2;
                        }
                    }
                    jsonReader.f();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    i5Var2 = i5Var2;
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        if (k5Var == null) {
            k5Var = new k5(Collections.singletonList(new b61(100)));
        }
        return new a(str, gradientType, j5Var2, k5Var, m5Var, m5Var2, i5Var, lineCapType, lineJoinType, f, arrayList, i5Var2, z);
    }
}
