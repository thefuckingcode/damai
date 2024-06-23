package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.b61;
import tb.i5;
import tb.k5;
import tb.l5;
import tb.n5;
import tb.p5;
import tb.s5;

/* compiled from: Taobao */
public class c {
    private static final JsonReader.a a = JsonReader.a.a("a", "p", "s", "rz", UploadQueueMgr.MSGTYPE_REALTIME, "o", "so", "eo", "sk", "sa");
    private static final JsonReader.a b = JsonReader.a.a("k");

    private static boolean a(l5 l5Var) {
        return l5Var == null || (l5Var.isStatic() && l5Var.getKeyframes().get(0).b.equals(0.0f, 0.0f));
    }

    private static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue == null || (!(animatableValue instanceof p5) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).b.equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean c(i5 i5Var) {
        return i5Var == null || (i5Var.isStatic() && ((b61) i5Var.getKeyframes().get(0)).b.floatValue() == 0.0f);
    }

    private static boolean d(n5 n5Var) {
        return n5Var == null || (n5Var.isStatic() && ((b61) n5Var.getKeyframes().get(0)).b.a(1.0f, 1.0f));
    }

    private static boolean e(i5 i5Var) {
        return i5Var == null || (i5Var.isStatic() && ((b61) i5Var.getKeyframes().get(0)).b.floatValue() == 0.0f);
    }

    private static boolean f(i5 i5Var) {
        return i5Var == null || (i5Var.isStatic() && ((b61) i5Var.getKeyframes().get(0)).b.floatValue() == 0.0f);
    }

    public static s5 g(JsonReader jsonReader, a aVar) throws IOException {
        boolean z = false;
        boolean z2 = jsonReader.q() == JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.e();
        }
        i5 i5Var = null;
        l5 l5Var = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        n5 n5Var = null;
        i5 i5Var2 = null;
        i5 i5Var3 = null;
        k5 k5Var = null;
        i5 i5Var4 = null;
        i5 i5Var5 = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    jsonReader.e();
                    while (jsonReader.j()) {
                        if (jsonReader.s(b) != 0) {
                            jsonReader.t();
                            jsonReader.u();
                        } else {
                            l5Var = a.a(jsonReader, aVar);
                        }
                    }
                    jsonReader.g();
                    break;
                case 1:
                    animatableValue = a.b(jsonReader, aVar);
                    break;
                case 2:
                    n5Var = d.j(jsonReader, aVar);
                    break;
                case 3:
                    aVar.a("Lottie doesn't support 3D layers.");
                case 4:
                    i5 f = d.f(jsonReader, aVar, z);
                    if (!f.getKeyframes().isEmpty()) {
                        if (((b61) f.getKeyframes().get(0)).b == null) {
                            f.getKeyframes().set(0, new b61(aVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(aVar.f())));
                            i5Var = f;
                            break;
                        }
                    } else {
                        f.getKeyframes().add(new b61(aVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(aVar.f())));
                    }
                    i5Var = f;
                case 5:
                    k5Var = d.h(jsonReader, aVar);
                    continue;
                case 6:
                    i5Var4 = d.f(jsonReader, aVar, z);
                    continue;
                case 7:
                    i5Var5 = d.f(jsonReader, aVar, z);
                    continue;
                case 8:
                    i5Var2 = d.f(jsonReader, aVar, z);
                    continue;
                case 9:
                    i5Var3 = d.f(jsonReader, aVar, z);
                    continue;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
            z = false;
        }
        if (z2) {
            jsonReader.g();
        }
        l5 l5Var2 = a(l5Var) ? null : l5Var;
        AnimatableValue<PointF, PointF> animatableValue2 = b(animatableValue) ? null : animatableValue;
        i5 i5Var6 = c(i5Var) ? null : i5Var;
        if (d(n5Var)) {
            n5Var = null;
        }
        return new s5(l5Var2, animatableValue2, n5Var, i5Var6, k5Var, i5Var4, i5Var5, f(i5Var2) ? null : i5Var2, e(i5Var3) ? null : i5Var3);
    }
}
