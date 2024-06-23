package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.sdk.m.s.a;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.IOException;
import tb.o91;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class g {
    private static JsonReader.a a = JsonReader.a.a(a.s, "d");

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b6, code lost:
        if (r2.equals("gf") == false) goto L_0x0034;
     */
    @Nullable
    static ContentModel a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ContentModel contentModel;
        String str;
        jsonReader.e();
        char c = 2;
        int i = 2;
        while (true) {
            contentModel = null;
            if (!jsonReader.j()) {
                str = null;
                break;
            }
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
                break;
            } else if (s != 1) {
                jsonReader.t();
                jsonReader.u();
            } else {
                i = jsonReader.m();
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals(U4WPKAdapter.KEY_TM)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = '\f';
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
                contentModel = e.a(jsonReader, aVar, i);
                break;
            case 1:
                contentModel = e0.a(jsonReader, aVar);
                break;
            case 2:
                contentModel = m.a(jsonReader, aVar);
                break;
            case 3:
                contentModel = f0.a(jsonReader, aVar);
                break;
            case 4:
                contentModel = n.a(jsonReader, aVar);
                break;
            case 5:
                contentModel = v.a(jsonReader);
                aVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModel = a0.a(jsonReader, aVar);
                break;
            case 7:
                contentModel = b0.a(jsonReader, aVar);
                break;
            case '\b':
                contentModel = g0.a(jsonReader, aVar);
                break;
            case '\t':
                contentModel = z.a(jsonReader, aVar);
                break;
            case '\n':
                contentModel = h0.a(jsonReader, aVar);
                break;
            case 11:
                contentModel = i0.a(jsonReader, aVar);
                break;
            case '\f':
                contentModel = c.g(jsonReader, aVar);
                break;
            default:
                o91.c("Unknown shape type " + str);
                break;
        }
        while (jsonReader.j()) {
            jsonReader.u();
        }
        jsonReader.g();
        return contentModel;
    }
}
