package com.taobao.android.dinamic.parser;

import com.taobao.android.dinamic.a;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import org.xmlpull.v1.XmlPullParser;
import tb.d8;
import tb.ew2;
import tb.l02;
import tb.m22;
import tb.ph0;

/* compiled from: Taobao */
public class DinamicParser {
    private static l02 a = new l02();
    private static ph0 b = new ph0();
    private static m22 c = new m22();
    private static d8 d = new d8();

    public static XmlPullParser a(String str, DinamicTemplate dinamicTemplate, ew2 ew2) {
        XmlPullParser openXmlResourceParser = (!b.e() || !c.c(dinamicTemplate)) ? null : c.openXmlResourceParser(str, dinamicTemplate, ew2);
        long nanoTime = System.nanoTime();
        boolean z = true;
        if (!dinamicTemplate.isPreset()) {
            XmlPullParser openXmlResourceParser2 = b.openXmlResourceParser(str, dinamicTemplate, ew2);
            if (openXmlResourceParser2 == null) {
                z = false;
            }
            b(str, dinamicTemplate, z, System.nanoTime() - nanoTime);
            return openXmlResourceParser2;
        }
        if (openXmlResourceParser == null) {
            openXmlResourceParser = a.openXmlResourceParser(str, dinamicTemplate, ew2);
        }
        if (openXmlResourceParser == null) {
            openXmlResourceParser = d.openXmlResourceParser(str, dinamicTemplate, ew2);
        }
        if (openXmlResourceParser == null) {
            z = false;
        }
        b(str, dinamicTemplate, z, System.nanoTime() - nanoTime);
        return openXmlResourceParser;
    }

    private static void b(String str, DinamicTemplate dinamicTemplate, boolean z, long j) {
        a.h().d();
    }
}
