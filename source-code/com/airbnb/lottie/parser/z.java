package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.i5;
import tb.o70;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class z {
    private static final JsonReader.a a = JsonReader.a.a("nm", "sy", "pt", "p", UploadQueueMgr.MSGTYPE_REALTIME, o70.OR_PREFIX, "os", "ir", "is", "hd");

    static PolystarShape a(JsonReader jsonReader, a aVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        i5 i5Var = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        i5 i5Var2 = null;
        i5 i5Var3 = null;
        i5 i5Var4 = null;
        i5 i5Var5 = null;
        i5 i5Var6 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.m());
                    break;
                case 2:
                    i5Var = d.f(jsonReader, aVar, false);
                    break;
                case 3:
                    animatableValue = a.b(jsonReader, aVar);
                    break;
                case 4:
                    i5Var2 = d.f(jsonReader, aVar, false);
                    break;
                case 5:
                    i5Var4 = d.e(jsonReader, aVar);
                    break;
                case 6:
                    i5Var6 = d.f(jsonReader, aVar, false);
                    break;
                case 7:
                    i5Var3 = d.e(jsonReader, aVar);
                    break;
                case 8:
                    i5Var5 = d.f(jsonReader, aVar, false);
                    break;
                case 9:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        return new PolystarShape(str, type, i5Var, animatableValue, i5Var2, i5Var3, i5Var4, i5Var5, i5Var6, z);
    }
}
