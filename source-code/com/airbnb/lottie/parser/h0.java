package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.opendevice.c;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.b61;
import tb.h5;
import tb.i5;
import tb.k5;
import tb.o70;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class h0 {
    private static JsonReader.a a = JsonReader.a.a("nm", c.a, WXComponent.PROP_FS_WRAP_CONTENT, "o", o70.LOWER_PREFIX, "lj", "ml", "hd", "d");
    private static final JsonReader.a b = JsonReader.a.a("n", "v");

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static ShapeStroke a(JsonReader jsonReader, a aVar) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        i5 i5Var = null;
        h5 h5Var = null;
        i5 i5Var2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        k5 k5Var = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    h5Var = d.c(jsonReader, aVar);
                    break;
                case 2:
                    i5Var2 = d.e(jsonReader, aVar);
                    break;
                case 3:
                    k5Var = d.h(jsonReader, aVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 6:
                    f = (float) jsonReader.l();
                    break;
                case 7:
                    z = jsonReader.k();
                    break;
                case 8:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        i5 i5Var3 = null;
                        while (jsonReader.j()) {
                            int s = jsonReader.s(b);
                            if (s == 0) {
                                str2 = jsonReader.o();
                            } else if (s != 1) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                i5Var3 = d.e(jsonReader, aVar);
                            }
                        }
                        jsonReader.g();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                                aVar.t(true);
                                arrayList.add(i5Var3);
                                break;
                            case 2:
                                i5Var = i5Var3;
                                break;
                        }
                    }
                    jsonReader.f();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.u();
                    break;
            }
        }
        if (k5Var == null) {
            k5Var = new k5(Collections.singletonList(new b61(100)));
        }
        return new ShapeStroke(str, i5Var, arrayList, h5Var, k5Var, i5Var2, lineCapType, lineJoinType, f, z);
    }
}
