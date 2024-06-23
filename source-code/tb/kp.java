package tb;

import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.l.c;
import com.caverock.androidsvg.SVGParser;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
public class kp {
    private static final float[] i = {2.0f, 1.5f, 1.17f, 1.12f, 0.83f, 0.67f};
    public HashMap<String, kp> a;
    private HashMap<String, kp> b;
    private ArrayList<String> c;
    private StringBuilder d;
    private ArrayList<HashMap<String, kp>> e;
    private kp f;
    private kp g;
    private ArrayList<jp> h;

    /* compiled from: Taobao */
    public static class a {
        a(URI uri, int[] iArr) {
        }
    }

    private static void b(Element element, URI uri, jp jpVar, List<kp> list, List<kp> list2) {
        jp jpVar2 = new jp();
        if (jpVar != null) {
            jpVar2.j(jpVar);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).c(element, arrayList, arrayList2, arrayList3);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            kp kpVar = list2.get(i3);
            arrayList3.add(kpVar);
            kpVar.c(element, arrayList, arrayList2, arrayList3);
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            jpVar2.r((jp) arrayList.get(i4));
        }
        jpVar2.r(element.getStyle());
        element.setComputedStyle(jpVar2);
        HtmlCollection children = element.getChildren();
        for (int i5 = 0; i5 < children.getLength(); i5++) {
            b(children.item(i5), uri, jpVar2, arrayList2, arrayList3);
        }
    }

    private static void d(Element element, Map<String, kp> map, String str, List<jp> list, List<kp> list2, List<kp> list3) {
        kp kpVar;
        if (str != null && map != null && (kpVar = map.get(str)) != null) {
            kpVar.c(element, list, list2, list3);
        }
    }

    private kp e(char c2, String str, String str2) {
        int i2;
        if (this.d == null) {
            this.d = new StringBuilder();
            this.c = new ArrayList<>();
            this.e = new ArrayList<>();
            i2 = -1;
        } else {
            i2 = -1;
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                if (this.d.charAt(i3) == c2 && this.c.get(i3).equals(str)) {
                    i2 = i3;
                }
            }
        }
        if (i2 == -1) {
            i2 = this.d.length();
            this.d.append(c2);
            this.c.add(str);
            this.e.add(new HashMap<>());
        }
        return g(this.e.get(i2), str2);
    }

    public static kp f(int i2) {
        kp kpVar = new kp();
        int i3 = (i2 * 3) / 4;
        int i4 = (i2 * 4) / 2;
        int i5 = i2 / 2;
        if (i3 != 12) {
            kpVar.h(jl1.MUL).n(CssProperty.FONT_SIZE, (float) i3, CssUnit.PT);
        }
        jp n = kpVar.h(":link").n(CssProperty.COLOR, -1.6776961E7f, CssUnit.ARGB);
        CssProperty cssProperty = CssProperty.TEXT_DECORATION;
        n.q(cssProperty, CssEnum.UNDERLINE);
        jp h2 = kpVar.h(ILocatable.ADDRESS);
        CssProperty cssProperty2 = CssProperty.DISPLAY;
        CssEnum cssEnum = CssEnum.BLOCK;
        h2.q(cssProperty2, cssEnum);
        kpVar.h("b").n(CssProperty.FONT_WEIGHT, 700.0f, CssUnit.NUMBER);
        kpVar.h(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP).d = "monospace";
        kpVar.h("big").n(CssProperty.FONT_SIZE, (float) ((i3 * 4) / 3), CssUnit.PT);
        jp q = kpVar.h("blockquote").q(cssProperty2, cssEnum);
        CssProperty cssProperty3 = CssProperty.MARGIN_TOP;
        float f2 = (float) i5;
        CssUnit cssUnit = CssUnit.PX;
        float f3 = (float) i4;
        jp n2 = q.n(cssProperty3, f2, cssUnit).n(CssProperty.MARGIN_RIGHT, f3, cssUnit);
        CssProperty cssProperty4 = CssProperty.MARGIN_BOTTOM;
        jp n3 = n2.n(cssProperty4, f2, cssUnit);
        CssProperty cssProperty5 = CssProperty.MARGIN_LEFT;
        n3.n(cssProperty5, f3, cssUnit);
        jp q2 = kpVar.h("body").q(cssProperty2, cssEnum);
        CssProperty cssProperty6 = CssProperty.PADDING;
        q2.o(cssProperty6, (float) (i5 / 2), cssUnit, 0);
        kpVar.h(BaseCellItem.TYPE_BUTTON).q(cssProperty2, CssEnum.INLINE_BLOCK).n(cssProperty6, 30.0f, cssUnit);
        kpVar.h("center").q(cssProperty2, cssEnum).n(cssProperty3, f2, cssUnit).n(cssProperty4, f2, cssUnit).q(CssProperty.TEXT_ALIGN, CssEnum.CENTER);
        kpVar.h("dd").q(cssProperty2, cssEnum).n(cssProperty5, f3, cssUnit);
        kpVar.h("del").q(cssProperty, CssEnum.LINE_THROUGH);
        kpVar.h("dir").q(cssProperty2, cssEnum).n(cssProperty3, f2, cssUnit).n(cssProperty4, f2, cssUnit).n(cssProperty5, f3, cssUnit).q(CssProperty.LIST_STYLE_TYPE, CssEnum.SQUARE);
        kpVar.h(WXBasicComponentType.DIV).q(cssProperty2, cssEnum);
        kpVar.h("dl").q(cssProperty2, cssEnum);
        kpVar.h("dt").q(cssProperty2, cssEnum);
        kpVar.h(c.c).q(cssProperty2, cssEnum);
        for (int i6 = 1; i6 <= 6; i6++) {
            jp n4 = kpVar.h("h" + i6).q(CssProperty.DISPLAY, CssEnum.BLOCK).n(CssProperty.FONT_WEIGHT, 700.0f, CssUnit.NUMBER);
            CssProperty cssProperty7 = CssProperty.MARGIN_TOP;
            CssUnit cssUnit2 = CssUnit.PX;
            n4.n(cssProperty7, f2, cssUnit2).n(CssProperty.MARGIN_BOTTOM, f2, cssUnit2).n(CssProperty.FONT_SIZE, (float) Math.round(i[i6 + -1] * ((float) i3)), CssUnit.PT);
        }
        jp h3 = kpVar.h("hr");
        CssProperty cssProperty8 = CssProperty.DISPLAY;
        CssEnum cssEnum2 = CssEnum.BLOCK;
        jp q3 = h3.q(cssProperty8, cssEnum2);
        CssProperty cssProperty9 = CssProperty.BORDER_TOP_STYLE;
        CssEnum cssEnum3 = CssEnum.SOLID;
        jp n5 = q3.q(cssProperty9, cssEnum3).n(CssProperty.BORDER_TOP_COLOR, -7829368.0f, CssUnit.ARGB);
        CssProperty cssProperty10 = CssProperty.MARGIN_TOP;
        CssUnit cssUnit3 = CssUnit.PX;
        jp n6 = n5.n(cssProperty10, f2, cssUnit3);
        CssProperty cssProperty11 = CssProperty.MARGIN_BOTTOM;
        n6.n(cssProperty11, f2, cssUnit3);
        jp jpVar = new jp();
        CssProperty cssProperty12 = CssProperty.FONT_STYLE;
        CssEnum cssEnum4 = CssEnum.ITALIC;
        jpVar.q(cssProperty12, cssEnum4);
        kpVar.h("i").q(cssProperty12, cssEnum4);
        kpVar.h("em").q(cssProperty12, cssEnum4);
        jp h4 = kpVar.h("img");
        CssEnum cssEnum5 = CssEnum.INLINE_BLOCK;
        h4.q(cssProperty8, cssEnum5);
        kpVar.h("input").q(cssProperty8, cssEnum5);
        jp h5 = kpVar.h("ins");
        CssProperty cssProperty13 = CssProperty.TEXT_DECORATION;
        CssEnum cssEnum6 = CssEnum.UNDERLINE;
        h5.q(cssProperty13, cssEnum6);
        kpVar.h(AppIconSetting.LARGE_ICON_URL).q(cssProperty8, CssEnum.LIST_ITEM).n(cssProperty10, f2, cssUnit3).n(cssProperty11, f2, cssUnit3);
        kpVar.h("marquee").q(cssProperty8, cssEnum2);
        jp n7 = kpVar.h("menu").q(cssProperty8, cssEnum2).n(cssProperty10, f2, cssUnit3).n(cssProperty11, f2, cssUnit3);
        CssProperty cssProperty14 = CssProperty.MARGIN_LEFT;
        jp n8 = n7.n(cssProperty14, f3, cssUnit3);
        CssProperty cssProperty15 = CssProperty.LIST_STYLE_TYPE;
        CssEnum cssEnum7 = CssEnum.SQUARE;
        n8.q(cssProperty15, cssEnum7);
        kpVar.h("ol").q(cssProperty8, cssEnum2).n(cssProperty14, f3, cssUnit3).q(cssProperty15, CssEnum.DECIMAL);
        kpVar.h("p").q(cssProperty8, cssEnum2).n(cssProperty10, f2, cssUnit3).n(cssProperty11, f2, cssUnit3);
        new jp().q(cssProperty8, cssEnum2).q(CssProperty.WHITE_SPACE, CssEnum.PRE).n(cssProperty10, f2, cssUnit3).n(cssProperty11, f2, cssUnit3);
        kpVar.h("pre").d = "monospace";
        jp h6 = kpVar.h("script");
        CssEnum cssEnum8 = CssEnum.NONE;
        h6.q(cssProperty8, cssEnum8);
        jp h7 = kpVar.h("small");
        CssProperty cssProperty16 = CssProperty.FONT_SIZE;
        float f4 = (float) ((i3 * 3) / 4);
        CssUnit cssUnit4 = CssUnit.PT;
        h7.n(cssProperty16, f4, cssUnit4);
        kpVar.h("strike").q(cssProperty13, CssEnum.LINE_THROUGH);
        jp h8 = kpVar.h("strong");
        CssProperty cssProperty17 = CssProperty.FONT_WEIGHT;
        CssUnit cssUnit5 = CssUnit.NUMBER;
        h8.n(cssProperty17, 700.0f, cssUnit5);
        kpVar.h("style").q(cssProperty8, cssEnum8);
        jp n9 = kpVar.h("sup").n(cssProperty16, f4, cssUnit4);
        CssProperty cssProperty18 = CssProperty.VERTICAL_ALIGN;
        n9.q(cssProperty18, CssEnum.SUPER);
        kpVar.h("sub").n(cssProperty16, f4, cssUnit4).q(cssProperty18, CssEnum.SUB);
        kpVar.h("table").n(CssProperty.BORDER_SPACING, 2.0f, cssUnit3).q(cssProperty8, CssEnum.TABLE).q(CssProperty.CLEAR, CssEnum.BOTH);
        jp h9 = kpVar.h(TimeDisplaySetting.TIME_DISPLAY);
        CssEnum cssEnum9 = CssEnum.TABLE_CELL;
        jp q4 = h9.q(cssProperty8, cssEnum9);
        CssProperty cssProperty19 = CssProperty.PADDING;
        jp n10 = q4.n(cssProperty19, 10.0f, cssUnit3);
        CssProperty cssProperty20 = CssProperty.BORDER_STYLE;
        jp q5 = n10.q(cssProperty20, cssEnum3);
        CssProperty cssProperty21 = CssProperty.TEXT_ALIGN;
        q5.q(cssProperty21, CssEnum.LEFT);
        kpVar.h("th").q(cssProperty8, cssEnum9).n(cssProperty17, 700.0f, cssUnit5).n(cssProperty19, 10.0f, cssUnit3).q(cssProperty20, cssEnum3).q(cssProperty21, CssEnum.CENTER);
        kpVar.h("tr").q(cssProperty8, CssEnum.TABLE_ROW);
        kpVar.h(IRequestConst.U).q(cssProperty13, cssEnum6);
        kpVar.h("ul").q(cssProperty8, cssEnum2).n(cssProperty14, f3, cssUnit3).q(cssProperty15, cssEnum7);
        kpVar.h("ul ul").q(cssProperty15, CssEnum.CIRCLE);
        kpVar.h("ul ul ul").q(cssProperty15, CssEnum.DISC);
        return kpVar;
    }

    private static kp g(Map<String, kp> map, String str) {
        kp kpVar = map.get(str);
        if (kpVar != null) {
            return kpVar;
        }
        kp kpVar2 = new kp();
        map.put(str, kpVar2);
        return kpVar2;
    }

    public static boolean i(String str, String[] strArr) {
        if (str == null) {
            return true;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (lowerCase.length() == 0 || lowerCase.equals("all") || ip.c(strArr, lowerCase) != -1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        r3 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0052 A[EDGE_INSN: B:87:0x0052->B:25:0x0052 ?: BREAK  , SYNTHETIC] */
    private jp j(lp lpVar) {
        int i2;
        String str;
        char c2;
        int i3 = 0;
        boolean z = false;
        kp kpVar = this;
        while (true) {
            int i4 = lpVar.a;
            if (i4 == -14) {
                lpVar.c(false);
                int i5 = lpVar.a;
                if (i5 == 123 || i5 == 44 || i5 == -1) {
                    break;
                } else if (i5 == 62) {
                    if (kpVar.f == null) {
                        kpVar.f = new kp();
                    }
                    kpVar = kpVar.f;
                    lpVar.c(false);
                } else {
                    if (kpVar.g == null) {
                        kpVar.g = new kp();
                    }
                    kpVar = kpVar.g;
                }
            } else {
                char c3 = '\b';
                if (i4 == -6) {
                    kpVar = kpVar.e('\b', "id", lpVar.b);
                    i3 += 10000;
                    lpVar.c(true);
                } else if (i4 == -2) {
                    if (kpVar.a == null) {
                        kpVar.a = new HashMap<>();
                    }
                    kpVar = g(kpVar.a, ip.b(lpVar.b));
                    i3++;
                    lpVar.c(true);
                } else if (i4 == 42) {
                    lpVar.c(true);
                } else if (i4 == 46) {
                    lpVar.c(false);
                    z = lpVar.a != -2;
                    kpVar = kpVar.e('\t', "class", lpVar.b);
                    i3 += 100;
                    lpVar.c(true);
                } else if (i4 == 58) {
                    lpVar.c(false);
                    z = lpVar.a != -2;
                    if (kpVar.b == null) {
                        kpVar.b = new HashMap<>();
                    }
                    kpVar = g(kpVar.b, lpVar.b);
                    i3 += 100;
                    lpVar.c(true);
                } else if (i4 == 62) {
                    if (kpVar.f == null) {
                        kpVar.f = new kp();
                    }
                    kpVar = kpVar.f;
                    lpVar.c(false);
                } else if (i4 != 91) {
                    break;
                } else {
                    lpVar.c(false);
                    String b2 = ip.b(lpVar.b);
                    lpVar.c(false);
                    int i6 = lpVar.a;
                    if (i6 == 93) {
                        c2 = 7;
                        str = "";
                    } else if (i6 != -18) {
                        if (i6 != -17) {
                            if (i6 != 61) {
                                break;
                            }
                        } else {
                            c3 = '\t';
                        }
                        lpVar.c(false);
                        if (lpVar.a == -4) {
                            break;
                        }
                        str = lpVar.b;
                        lpVar.c(false);
                        lpVar.a(93);
                        i3 += 100;
                        c2 = c3;
                    } else {
                        c3 = '\n';
                        lpVar.c(false);
                        if (lpVar.a == -4) {
                        }
                    }
                    kpVar = kpVar.e(c2, b2, str);
                    lpVar.c(true);
                }
            }
        }
        if (z || !((i2 = lpVar.a) == 44 || i2 == 123)) {
            lpVar.b("Unrecognized selector");
            while (true) {
                int i7 = lpVar.a;
                if (i7 == 44 || i7 == -1 || i7 == 123) {
                    return null;
                }
                lpVar.c(false);
            }
        } else {
            jp jpVar = new jp();
            jpVar.e = i3;
            if (kpVar.h == null) {
                kpVar.h = new ArrayList<>();
            }
            kpVar.h.add(jpVar);
            return jpVar;
        }
    }

    public void a(Element element, URI uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        b(element, uri, null, new ArrayList(), arrayList);
    }

    public void c(Element element, List<jp> list, List<kp> list2, List<kp> list3) {
        String[] d2;
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                jp jpVar = this.h.get(i2);
                int size = list.size();
                while (true) {
                    if (size <= 0) {
                        break;
                    }
                    jp jpVar2 = list.get(size - 1);
                    if (jpVar2.a(jpVar) < 0) {
                        break;
                    } else if (jpVar2 == jpVar) {
                        size = -1;
                        break;
                    } else {
                        size--;
                    }
                }
                if (size != -1) {
                    list.add(size, jpVar);
                }
            }
        }
        if (this.d != null) {
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                char charAt = this.d.charAt(i3);
                String attribute = element.getAttribute(this.c.get(i3));
                if (attribute != null) {
                    HashMap<String, kp> hashMap = this.e.get(i3);
                    if (charAt == 7) {
                        d(element, hashMap, "", list, list2, list3);
                    } else if (charAt == '\b') {
                        d(element, hashMap, attribute, list, list2, list3);
                    } else {
                        for (String str : ip.d(attribute, charAt == '\t' ? ' ' : ',')) {
                            d(element, hashMap, str, list, list2, list3);
                        }
                    }
                }
            }
        }
        HashMap<String, kp> hashMap2 = this.a;
        if (hashMap2 != null) {
            d(element, hashMap2, element.getLocalName(), list, list2, list3);
        }
        kp kpVar = this.f;
        if (kpVar != null) {
            list2.add(kpVar);
        }
        kp kpVar2 = this.g;
        if (kpVar2 != null) {
            list3.add(kpVar2);
        }
    }

    public jp h(String str) {
        jp j = j(new lp(null, str + jl1.BLOCK_START_STR));
        int i2 = j.e;
        if (i2 >= 0) {
            j.e = i2 - 1000000;
        }
        return j;
    }

    public kp k(String str, URI uri, int[] iArr, String[] strArr, List<a> list) {
        int i2;
        lp lpVar = new lp(uri, str);
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = lpVar.a;
            if (i4 == -1) {
                return this;
            }
            if (i4 == -3) {
                int i5 = 1;
                if (SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(lpVar.b)) {
                    lpVar.c(false);
                    z = false;
                    do {
                        if (lpVar.a != 44) {
                            z |= i(lpVar.b, strArr);
                        }
                        lpVar.c(false);
                        i2 = lpVar.a;
                        if (i2 == 123) {
                            break;
                        }
                    } while (i2 != -1);
                    lpVar.c(false);
                    if (!z) {
                        do {
                            int i6 = lpVar.a;
                            if (i6 == -1) {
                                return this;
                            }
                            if (i6 == 123) {
                                i5++;
                            } else if (i6 == 125) {
                                i5--;
                            }
                            lpVar.c(false);
                        } while (i5 > 0);
                    } else {
                        continue;
                    }
                } else if ("import".equals(lpVar.b)) {
                    lpVar.c(false);
                    String str2 = lpVar.b;
                    lpVar.c(false);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i7 = lpVar.a;
                        if (i7 != 59 && i7 != -1) {
                            sb.append(lpVar.b);
                            lpVar.c(false);
                        } else if (list != null && i(sb.toString(), strArr)) {
                            int[] iArr2 = new int[(iArr.length + 1)];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i3;
                            list.add(new a(uri.resolve(str2), iArr2));
                        }
                    }
                    int[] iArr22 = new int[(iArr.length + 1)];
                    System.arraycopy(iArr, 0, iArr22, 0, iArr.length);
                    iArr22[iArr.length] = i3;
                    list.add(new a(uri.resolve(str2), iArr22));
                    lpVar.c(false);
                } else {
                    lpVar.b("unsupported @" + lpVar.b);
                    lpVar.c(false);
                }
            } else if (i4 == 125) {
                if (!z) {
                    lpVar.b("unexpected }");
                }
                lpVar.c(false);
                z = false;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(j(lpVar));
                while (lpVar.a == 44) {
                    lpVar.c(false);
                    arrayList.add(j(lpVar));
                }
                jp jpVar = new jp();
                if (lpVar.a == 123) {
                    lpVar.c(false);
                    jpVar.m(lpVar);
                    lpVar.a(125);
                } else {
                    lpVar.b("{ expected");
                }
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    jp jpVar2 = (jp) arrayList.get(i8);
                    if (jpVar2 != null) {
                        jpVar2.f = i3;
                        jpVar2.g = iArr;
                        jpVar2.r(jpVar);
                    }
                }
                lpVar.c(false);
            }
            i3++;
        }
    }

    public void l(String str, StringBuilder sb) {
        if (this.h != null) {
            sb.append(str.length() == 0 ? jl1.MUL : str);
            sb.append(" {");
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                this.h.get(i2).s("", sb);
            }
            sb.append("}\n");
        }
        HashMap<String, kp> hashMap = this.a;
        if (hashMap != null) {
            for (Map.Entry<String, kp> entry : hashMap.entrySet()) {
                entry.getValue().l(entry.getKey() + str, sb);
            }
        }
        if (this.d != null) {
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                char charAt = this.d.charAt(i3);
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(jl1.ARRAY_START);
                sb2.append(this.c.get(i3));
                if (charAt == 7) {
                    sb2.append(jl1.ARRAY_END);
                    this.e.get(i3).get("").l(sb2.toString(), sb);
                } else {
                    switch (charAt) {
                        case '\b':
                            sb2.append(com.alipay.sdk.m.n.a.h);
                            break;
                        case '\t':
                            sb2.append("~=");
                            break;
                        case '\n':
                            sb2.append("|=");
                            break;
                    }
                    for (Map.Entry<String, kp> entry2 : this.e.get(i3).entrySet()) {
                        entry2.getValue().l(sb2.toString() + jl1.QUOTE + entry2.getKey() + "\"]", sb);
                    }
                }
            }
        }
        kp kpVar = this.g;
        if (kpVar != null) {
            kpVar.l(str + " ", sb);
        }
        kp kpVar2 = this.f;
        if (kpVar2 != null) {
            kpVar2.l(str + " > ", sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        l("", sb);
        return sb.toString();
    }
}
