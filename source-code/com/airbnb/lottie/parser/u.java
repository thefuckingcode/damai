package com.airbnb.lottie.parser;

import com.airbnb.lottie.a;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.k5;
import tb.o5;
import tb.o91;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class u {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (r1.equals("s") == false) goto L_0x0062;
     */
    static Mask a(JsonReader jsonReader, a aVar) throws IOException {
        char c;
        jsonReader.e();
        Mask.MaskMode maskMode = null;
        o5 o5Var = null;
        k5 k5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            String n = jsonReader.n();
            n.hashCode();
            char c2 = 3;
            switch (n.hashCode()) {
                case 111:
                    if (n.equals("o")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3588:
                    if (n.equals("pt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 104433:
                    if (n.equals("inv")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3357091:
                    if (n.equals("mode")) {
                        c = 3;
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
                    k5Var = d.h(jsonReader, aVar);
                    break;
                case 1:
                    o5Var = d.k(jsonReader, aVar);
                    break;
                case 2:
                    z = jsonReader.k();
                    break;
                case 3:
                    String o = jsonReader.o();
                    o.hashCode();
                    switch (o.hashCode()) {
                        case 97:
                            if (o.equals("a")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 105:
                            if (o.equals("i")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 110:
                            if (o.equals("n")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 115:
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                        case 1:
                            aVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            continue;
                        case 2:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            continue;
                        case 3:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            continue;
                        default:
                            o91.c("Unknown mask mode " + n + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                    }
                default:
                    jsonReader.u();
                    break;
            }
        }
        jsonReader.g();
        return new Mask(maskMode, o5Var, k5Var, z);
    }
}
