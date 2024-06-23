package com.xiaomi.push;

import com.youku.resource.widget.YKActionSheet;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import tb.lf1;

/* compiled from: Taobao */
public class fq {
    private XmlPullParser a;

    fq() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public gn a(byte[] bArr, fw fwVar) {
        String str;
        String str2;
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return gv.a(this.a);
        }
        if (name.equals("iq")) {
            return gv.a(this.a, fwVar);
        }
        if (name.equals("presence")) {
            return gv.m531a(this.a);
        }
        if (this.a.getName().equals(lf1.RESOURCE_STREAM)) {
            return null;
        }
        if (!this.a.getName().equals("error")) {
            if (this.a.getName().equals(YKActionSheet.ACTION_STYLE_WARNING)) {
                this.a.next();
                str2 = this.a.getName();
                str = "multi-login";
            } else {
                str2 = this.a.getName();
                str = "bind";
            }
            str2.equals(str);
            return null;
        }
        throw new gh(gv.m532a(this.a));
    }
}
