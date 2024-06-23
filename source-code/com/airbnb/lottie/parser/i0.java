package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import tb.i5;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class i0 {
    private static JsonReader.a a = JsonReader.a.a("s", "e", "o", "nm", WXComponent.PROP_FS_MATCH_PARENT, "hd");

    static ShapeTrimPath a(JsonReader jsonReader, a aVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        i5 i5Var = null;
        i5 i5Var2 = null;
        i5 i5Var3 = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                i5Var = d.f(jsonReader, aVar, false);
            } else if (s == 1) {
                i5Var2 = d.f(jsonReader, aVar, false);
            } else if (s == 2) {
                i5Var3 = d.f(jsonReader, aVar, false);
            } else if (s == 3) {
                str = jsonReader.o();
            } else if (s == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.m());
            } else if (s != 5) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new ShapeTrimPath(str, type, i5Var, i5Var2, i5Var3, z);
    }
}
