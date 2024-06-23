package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.weex.ui.component.WXComponent;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.b61;
import tb.i5;
import tb.q5;
import tb.r5;
import tb.s5;
import tb.xt2;

/* compiled from: Taobao */
public class s {
    private static final JsonReader.a a = JsonReader.a.a("nm", "ind", "refId", com.alipay.sdk.m.s.a.s, "parent", "sw", "sh", IRequestConst.SC, "ks", PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, "masksProperties", "shapes", "t", "ef", "sr", "st", WXComponent.PROP_FS_WRAP_CONTENT, "h", TbAuthConstants.IP, "op", U4WPKAdapter.KEY_TM, "cl", "hd");
    private static final JsonReader.a b = JsonReader.a.a("d", "a");
    private static final JsonReader.a c = JsonReader.a.a("nm");

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
        }
    }

    public static Layer a(com.airbnb.lottie.a aVar) {
        Rect b2 = aVar.b();
        return new Layer(Collections.emptyList(), aVar, "__container", -1, Layer.LayerType.PRE_COMP, -1, null, Collections.emptyList(), new s5(), 0, 0, 0, 0.0f, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(b2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(b2), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer b(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.e();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        s5 s5Var = null;
        q5 q5Var = null;
        r5 r5Var = null;
        i5 i5Var = null;
        long j = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j2 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str3 = jsonReader.o();
                    break;
                case 1:
                    j2 = (long) jsonReader.m();
                    break;
                case 2:
                    str = jsonReader.o();
                    break;
                case 3:
                    int m = jsonReader.m();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (m >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[m];
                        break;
                    }
                case 4:
                    j = (long) jsonReader.m();
                    break;
                case 5:
                    i = (int) (((float) jsonReader.m()) * xt2.e());
                    break;
                case 6:
                    i2 = (int) (((float) jsonReader.m()) * xt2.e());
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.o());
                    break;
                case 8:
                    s5Var = c.g(jsonReader, aVar);
                    break;
                case 9:
                    int m2 = jsonReader.m();
                    if (m2 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[m2];
                        int i6 = a.a[matteType2.ordinal()];
                        if (i6 == 1) {
                            aVar.a("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            aVar.a("Unsupported matte type: Luma Inverted");
                        }
                        aVar.q(1);
                        break;
                    } else {
                        aVar.a("Unsupported matte type: " + m2);
                        break;
                    }
                case 10:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        arrayList3.add(u.a(jsonReader, aVar));
                    }
                    aVar.q(arrayList3.size());
                    jsonReader.f();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        ContentModel a2 = g.a(jsonReader, aVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.f();
                    break;
                case 12:
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s == 0) {
                            q5Var = d.d(jsonReader, aVar);
                        } else if (s != 1) {
                            jsonReader.t();
                            jsonReader.u();
                        } else {
                            jsonReader.c();
                            if (jsonReader.j()) {
                                r5Var = b.a(jsonReader, aVar);
                            }
                            while (jsonReader.j()) {
                                jsonReader.u();
                            }
                            jsonReader.f();
                        }
                    }
                    jsonReader.g();
                    break;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        while (jsonReader.j()) {
                            if (jsonReader.s(c) != 0) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                arrayList5.add(jsonReader.o());
                            }
                        }
                        jsonReader.g();
                    }
                    jsonReader.f();
                    aVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) jsonReader.l();
                    break;
                case 15:
                    f4 = (float) jsonReader.l();
                    break;
                case 16:
                    i4 = (int) (((float) jsonReader.m()) * xt2.e());
                    break;
                case 17:
                    i5 = (int) (((float) jsonReader.m()) * xt2.e());
                    break;
                case 18:
                    f = (float) jsonReader.l();
                    break;
                case 19:
                    f2 = (float) jsonReader.l();
                    break;
                case 20:
                    i5Var = d.f(jsonReader, aVar, false);
                    break;
                case 21:
                    str2 = jsonReader.o();
                    break;
                case 22:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        jsonReader.g();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f5 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new b61(aVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f5)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f6 <= 0.0f) {
            f6 = aVar.f();
        }
        arrayList2.add(new b61(aVar, valueOf, valueOf, null, f5, Float.valueOf(f6)));
        arrayList2.add(new b61(aVar, valueOf2, valueOf2, null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || BQCCameraParam.FOCUS_TYPE_AI.equals(str2)) {
            aVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, aVar, str3, j2, layerType, j, str, arrayList, s5Var, i, i2, i3, f3, f4, i4, i5, q5Var, r5Var, arrayList2, matteType2, i5Var, z);
    }
}
