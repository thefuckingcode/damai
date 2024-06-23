package com.real.android.nativehtml.common.io;

import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alibaba.poplayer.trigger.view.TrackingService;
import com.alipay.sdk.m.l.c;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: Taobao */
public class HtmlNormalizer {
    private static final String[] f = {"acute", "´", "apos", "'", "Auml", "Ä", "auml", "ä", "nbsp", " ", "Ouml", "Ö", "ouml", "ö", "szlig", "ß", "Uuml", "Ü", "uuml", "ü"};
    private static final b g = new b(false, new String[0]);
    private static final LinkedHashMap<String, b> h;
    private XmlPullParser a;
    private int b;
    private String c;
    private boolean d;
    private ArrayList<String> e = new ArrayList<>();

    /* compiled from: Taobao */
    public enum ElementProperty {
        SELF_CLOSING,
        TEXT,
        LOGICAL
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private final boolean a;
        private final String[] b;

        private b(boolean z, String... strArr) {
            this.a = z;
            this.b = strArr;
        }
    }

    static {
        LinkedHashMap<String, b> linkedHashMap = new LinkedHashMap<>();
        h = linkedHashMap;
        linkedHashMap.put(Constants.ACTION_PARAMS_AREA, new b(true, new String[0]));
        linkedHashMap.put("base", new b(true, new String[0]));
        linkedHashMap.put(BrightRemindSetting.BRIGHT_REMIND, new b(true, new String[0]));
        linkedHashMap.put("col", new b(true, new String[0]));
        linkedHashMap.put("command", new b(true, new String[0]));
        linkedHashMap.put(WXBasicComponentType.EMBED, new b(true, new String[0]));
        linkedHashMap.put("hr", new b(true, new String[0]));
        linkedHashMap.put("img", new b(true, new String[0]));
        linkedHashMap.put("input", new b(true, new String[0]));
        linkedHashMap.put("keygen", new b(true, new String[0]));
        linkedHashMap.put(AppIconSetting.LARGE_ICON_URL, new b(false, new String[]{AppIconSetting.LARGE_ICON_URL}));
        linkedHashMap.put(URIAdapter.LINK, new b(true, new String[0]));
        linkedHashMap.put("meta", new b(true, new String[0]));
        linkedHashMap.put("p", new b(false, new String[]{ILocatable.ADDRESS, "article", "aside", "blockquote", "dir", WXBasicComponentType.DIV, "dl", "fieldset", WXBasicComponentType.FOOTER, c.c, "h1", "h2", "h3", "h4", "h5", "h6", "header", "hr", "menu", "nav", "ol", "p", "pre", "section", "table", "ul"}));
        linkedHashMap.put("param", new b(true, new String[0]));
        linkedHashMap.put("source", new b(true, new String[0]));
        linkedHashMap.put(TimeDisplaySetting.TIME_DISPLAY, new b(false, new String[]{TimeDisplaySetting.TIME_DISPLAY, "th", "tr"}));
        linkedHashMap.put("th", new b(false, new String[]{TimeDisplaySetting.TIME_DISPLAY, "th", "tr"}));
        linkedHashMap.put("tr", new b(false, new String[]{"tr"}));
        linkedHashMap.put(TrackingService.OPER_TRACK, new b(true, new String[0]));
        linkedHashMap.put("wbr", new b(true, new String[0]));
    }

    public HtmlNormalizer() throws XmlPullParserException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.a = newPullParser;
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#relaxed", true);
    }

    private static b d(String str) {
        b bVar = h.get(str);
        return bVar == null ? g : bVar;
    }

    public int a() {
        return this.a.getAttributeCount();
    }

    public String b(int i) {
        return this.a.getAttributeName(i);
    }

    public String c(int i) {
        return this.a.getAttributeValue(i);
    }

    public int e() throws XmlPullParserException {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.a.getPositionDescription();
    }

    public String h() {
        return this.a.getText();
    }

    public int i() throws IOException, XmlPullParserException {
        if (this.b != 2 || !d(this.c).a) {
            if (this.d) {
                this.d = false;
                this.b = this.a.getEventType();
            } else {
                this.b = this.a.next();
            }
            while (this.b == 3 && d(this.a.getName()).a) {
                this.b = this.a.next();
            }
            if (this.b == 2 && this.e.size() > 0) {
                ArrayList<String> arrayList = this.e;
                if (Arrays.binarySearch(d(arrayList.get(arrayList.size() - 1)).b, this.a.getName()) >= 0) {
                    this.b = 3;
                    ArrayList<String> arrayList2 = this.e;
                    this.c = arrayList2.get(arrayList2.size() - 1);
                    ArrayList<String> arrayList3 = this.e;
                    arrayList3.remove(arrayList3.size() - 1);
                    this.d = true;
                    return this.b;
                }
            }
            int i = this.b;
            if (i == 2) {
                String name = this.a.getName();
                this.c = name;
                this.e.add(name);
            } else if (i == 3) {
                String name2 = this.a.getName();
                this.c = name2;
                int lastIndexOf = this.e.lastIndexOf(name2);
                if (lastIndexOf == -1) {
                    PrintStream printStream = System.err;
                    printStream.println("Ignoring </" + this.c + ">: opening tag not found in " + this.e + " at " + this.a.getPositionDescription());
                    return i();
                }
                if (lastIndexOf != this.e.size() - 1) {
                    this.d = true;
                    ArrayList<String> arrayList4 = this.e;
                    this.c = arrayList4.get(arrayList4.size() - 1);
                }
                ArrayList<String> arrayList5 = this.e;
                arrayList5.remove(arrayList5.size() - 1);
            } else if (i == 1 && this.e.size() > 0) {
                ArrayList<String> arrayList6 = this.e;
                this.c = arrayList6.get(arrayList6.size() - 1);
                this.b = 3;
                ArrayList<String> arrayList7 = this.e;
                arrayList7.remove(arrayList7.get(arrayList7.size() - 1));
                this.d = true;
            }
            return this.b;
        }
        this.b = 3;
        this.d = true;
        ArrayList<String> arrayList8 = this.e;
        arrayList8.remove(arrayList8.size() - 1);
        this.a.next();
        return this.b;
    }

    public void j(Reader reader) throws XmlPullParserException {
        this.a.setInput(reader);
        int i = 0;
        while (true) {
            String[] strArr = f;
            if (i < strArr.length) {
                this.a.defineEntityReplacementText(strArr[i], strArr[i + 1]);
                i += 2;
            } else {
                return;
            }
        }
    }
}
