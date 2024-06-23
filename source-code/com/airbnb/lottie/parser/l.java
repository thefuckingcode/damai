package com.airbnb.lottie.parser;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tb.bt0;
import tb.he1;

/* compiled from: Taobao */
public class l implements ValueParser<bt0> {
    private int a;

    public l(int i) {
        this.a = i;
    }

    private void a(bt0 bt0, List<Float> list) {
        int i = this.a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) list.get(i).floatValue();
                } else {
                    dArr2[i2] = (double) list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < bt0.c(); i3++) {
                int i4 = bt0.a()[i3];
                bt0.a()[i3] = Color.argb(b((double) bt0.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int b(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                d2 = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr[i2];
            double d4 = dArr[i];
            if (dArr[i] >= d) {
                d2 = he1.j(dArr2[i2], dArr2[i], he1.b((d - d3) / (d4 - d3), 0.0d, 1.0d));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }

    /* renamed from: c */
    public bt0 parse(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.q() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        while (jsonReader.j()) {
            arrayList.add(Float.valueOf((float) jsonReader.l()));
        }
        if (z) {
            jsonReader.f();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                if (i5 > 0) {
                    float f2 = (float) floatValue;
                    if (fArr[i5 - 1] >= f2) {
                        fArr[i5] = f2 + 0.01f;
                    }
                }
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        bt0 bt0 = new bt0(fArr, iArr);
        a(bt0, arrayList);
        return bt0;
    }
}
