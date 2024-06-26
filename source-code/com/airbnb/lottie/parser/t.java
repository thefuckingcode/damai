package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.a;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.ui.component.WXComponent;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.kb1;
import tb.na1;
import tb.o91;
import tb.um0;
import tb.xt2;
import tb.zm0;

/* compiled from: Taobao */
public class t {
    private static final JsonReader.a a = JsonReader.a.a(WXComponent.PROP_FS_WRAP_CONTENT, "h", TbAuthConstants.IP, "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    static JsonReader.a b = JsonReader.a.a("id", "layers", WXComponent.PROP_FS_WRAP_CONTENT, "h", "p", IRequestConst.U);
    private static final JsonReader.a c = JsonReader.a.a("list");
    private static final JsonReader.a d = JsonReader.a.a("cm", U4WPKAdapter.KEY_TM, "dr");

    public static a a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float e = xt2.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<zm0> sparseArrayCompat = new SparseArrayCompat<>();
        a aVar = new a();
        jsonReader.e();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.j()) {
            switch (jsonReader2.s(a)) {
                case 0:
                    i = jsonReader.m();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i2 = jsonReader.m();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f = (float) jsonReader.l();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.l()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.l();
                    break;
                case 5:
                    String[] split = jsonReader.o().split("\\.");
                    if (!xt2.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        aVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(jsonReader2, aVar, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(jsonReader2, aVar, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(jsonReader2, aVar, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(jsonReader2, aVar, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        aVar.r(new Rect(0, 0, (int) (((float) i) * e), (int) (((float) i2) * e)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return aVar;
    }

    private static void b(JsonReader jsonReader, a aVar, Map<String, List<Layer>> map, Map<String, na1> map2) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.e();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.j()) {
                int s = jsonReader.s(b);
                if (s == 0) {
                    str = jsonReader.o();
                } else if (s == 1) {
                    jsonReader.c();
                    while (jsonReader.j()) {
                        Layer b2 = s.b(jsonReader, aVar);
                        longSparseArray.put(b2.b(), b2);
                        arrayList.add(b2);
                    }
                    jsonReader.f();
                } else if (s == 2) {
                    i = jsonReader.m();
                } else if (s == 3) {
                    i2 = jsonReader.m();
                } else if (s == 4) {
                    str2 = jsonReader.o();
                } else if (s != 5) {
                    jsonReader.t();
                    jsonReader.u();
                } else {
                    str3 = jsonReader.o();
                }
            }
            jsonReader.g();
            if (str2 != null) {
                na1 na1 = new na1(i, i2, str, str2, str3);
                map2.put(na1.d(), na1);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.f();
    }

    private static void c(JsonReader jsonReader, a aVar, SparseArrayCompat<zm0> sparseArrayCompat) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            zm0 a2 = j.a(jsonReader, aVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.f();
    }

    private static void d(JsonReader jsonReader, Map<String, um0> map) throws IOException {
        jsonReader.e();
        while (jsonReader.j()) {
            if (jsonReader.s(c) != 0) {
                jsonReader.t();
                jsonReader.u();
            } else {
                jsonReader.c();
                while (jsonReader.j()) {
                    um0 a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.f();
            }
        }
        jsonReader.g();
    }

    private static void e(JsonReader jsonReader, a aVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.c();
        int i = 0;
        while (jsonReader.j()) {
            Layer b2 = s.b(jsonReader, aVar);
            if (b2.d() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(b2);
            longSparseArray.put(b2.b(), b2);
            if (i > 4) {
                o91.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.f();
    }

    private static void f(JsonReader jsonReader, a aVar, List<kb1> list) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            String str = null;
            jsonReader.e();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.j()) {
                int s = jsonReader.s(d);
                if (s == 0) {
                    str = jsonReader.o();
                } else if (s == 1) {
                    f = (float) jsonReader.l();
                } else if (s != 2) {
                    jsonReader.t();
                    jsonReader.u();
                } else {
                    f2 = (float) jsonReader.l();
                }
            }
            jsonReader.g();
            list.add(new kb1(str, f, f2));
        }
        jsonReader.f();
    }
}
