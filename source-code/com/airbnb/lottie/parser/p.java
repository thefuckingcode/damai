package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class p {
    private static final JsonReader.a a = JsonReader.a.a(Constants.Name.X, Constants.Name.Y);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            a = iArr;
            iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            try {
                a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f) throws IOException {
        jsonReader.c();
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.q() != JsonReader.Token.END_ARRAY) {
            jsonReader.u();
        }
        jsonReader.f();
        return new PointF(l * f, l2 * f);
    }

    private static PointF b(JsonReader jsonReader, float f) throws IOException {
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.u();
        }
        return new PointF(l * f, l2 * f);
    }

    private static PointF c(JsonReader jsonReader, float f) throws IOException {
        jsonReader.e();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                f2 = g(jsonReader);
            } else if (s != 1) {
                jsonReader.t();
                jsonReader.u();
            } else {
                f3 = g(jsonReader);
            }
        }
        jsonReader.g();
        return new PointF(f2 * f, f3 * f);
    }

    @ColorInt
    static int d(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        int l = (int) (jsonReader.l() * 255.0d);
        int l2 = (int) (jsonReader.l() * 255.0d);
        int l3 = (int) (jsonReader.l() * 255.0d);
        while (jsonReader.j()) {
            jsonReader.u();
        }
        jsonReader.f();
        return Color.argb(255, l, l2, l3);
    }

    static PointF e(JsonReader jsonReader, float f) throws IOException {
        int i = a.a[jsonReader.q().ordinal()];
        if (i == 1) {
            return b(jsonReader, f);
        }
        if (i == 2) {
            return a(jsonReader, f);
        }
        if (i == 3) {
            return c(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.q());
    }

    static List<PointF> f(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f));
            jsonReader.f();
        }
        jsonReader.f();
        return arrayList;
    }

    static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token q = jsonReader.q();
        int i = a.a[q.ordinal()];
        if (i == 1) {
            return (float) jsonReader.l();
        }
        if (i == 2) {
            jsonReader.c();
            float l = (float) jsonReader.l();
            while (jsonReader.j()) {
                jsonReader.u();
            }
            jsonReader.f();
            return l;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + q);
    }
}
