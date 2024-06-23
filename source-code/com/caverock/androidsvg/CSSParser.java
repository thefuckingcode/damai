package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.d80;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class CSSParser {
    private MediaType a;
    private Source b;
    private boolean c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface PseudoClass {
        boolean matches(l lVar, SVG.a0 a0Var);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            PseudoClassIdents[] values = values();
            for (PseudoClassIdents pseudoClassIdents : values) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            if (pseudoClassIdents != null) {
                return pseudoClassIdents;
            }
            return UNSUPPORTED;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum Source {
        Document,
        RenderOptions
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|(3:59|60|62)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x013b */
        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            b = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            b[PseudoClassIdents.only_child.ordinal()] = 3;
            b[PseudoClassIdents.first_of_type.ordinal()] = 4;
            b[PseudoClassIdents.last_of_type.ordinal()] = 5;
            b[PseudoClassIdents.only_of_type.ordinal()] = 6;
            b[PseudoClassIdents.root.ordinal()] = 7;
            b[PseudoClassIdents.empty.ordinal()] = 8;
            b[PseudoClassIdents.nth_child.ordinal()] = 9;
            b[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            b[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            b[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            b[PseudoClassIdents.not.ordinal()] = 13;
            b[PseudoClassIdents.target.ordinal()] = 14;
            b[PseudoClassIdents.lang.ordinal()] = 15;
            b[PseudoClassIdents.link.ordinal()] = 16;
            b[PseudoClassIdents.visited.ordinal()] = 17;
            b[PseudoClassIdents.hover.ordinal()] = 18;
            b[PseudoClassIdents.active.ordinal()] = 19;
            b[PseudoClassIdents.focus.ordinal()] = 20;
            b[PseudoClassIdents.enabled.ordinal()] = 21;
            b[PseudoClassIdents.disabled.ordinal()] = 22;
            b[PseudoClassIdents.checked.ordinal()] = 23;
            try {
                b[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            a = iArr2;
            iArr2[AttribOp.EQUALS.ordinal()] = 1;
            a[AttribOp.INCLUDES.ordinal()] = 2;
            try {
                a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        public final String a;
        final AttribOp b;
        public final String c;

        b(String str, AttribOp attribOp, String str2) {
            this.a = str;
            this.b = attribOp;
            this.c = str2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends SVGParser.g {

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class a {
            public int a;
            public int b;

            a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }
        }

        c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int D(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            int i2 = 65;
            if (i < 65 || i > 70) {
                i2 = 97;
                if (i < 97 || i > 102) {
                    return -1;
                }
            }
            return (i - i2) + 10;
        }

        private a E() throws CSSParseException {
            a aVar;
            b bVar;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            int i2 = 1;
            if (g("odd")) {
                aVar = new a(2, 1);
            } else {
                int i3 = 0;
                if (g("even")) {
                    aVar = new a(2, 0);
                } else {
                    int i4 = (!f('+') && f('-')) ? -1 : 1;
                    b c = b.c(this.a, this.b, this.c, false);
                    if (c != null) {
                        this.b = c.a();
                    }
                    if (f('n') || f('N')) {
                        if (c == null) {
                            c = new b(1, this.b);
                        }
                        A();
                        boolean f = f('+');
                        if (!f && (f = f('-'))) {
                            i2 = -1;
                        }
                        if (f) {
                            A();
                            bVar = b.c(this.a, this.b, this.c, false);
                            if (bVar != null) {
                                this.b = bVar.a();
                            } else {
                                this.b = i;
                                return null;
                            }
                        } else {
                            bVar = null;
                        }
                        i2 = i4;
                        i4 = i2;
                    } else {
                        bVar = c;
                        c = null;
                    }
                    int d = c == null ? 0 : i2 * c.d();
                    if (bVar != null) {
                        i3 = i4 * bVar.d();
                    }
                    aVar = new a(d, i3);
                }
            }
            A();
            if (f(')')) {
                return aVar;
            }
            this.b = i;
            return null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String F() {
            if (h()) {
                return null;
            }
            String q = q();
            if (q != null) {
                return q;
            }
            return I();
        }

        private List<String> H() throws CSSParseException {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String I = I();
                if (I == null) {
                    this.b = i;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(I);
                A();
            } while (z());
            if (f(')')) {
                return arrayList;
            }
            this.b = i;
            return null;
        }

        private List<n> L() throws CSSParseException {
            List<o> list;
            List<PseudoClass> list2;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            List<n> M = M();
            if (M == null) {
                this.b = i;
                return null;
            } else if (!f(')')) {
                this.b = i;
                return null;
            } else {
                Iterator<n> it = M.iterator();
                while (it.hasNext() && (list = it.next().a) != null) {
                    Iterator<o> it2 = list.iterator();
                    while (it2.hasNext() && (list2 = it2.next().d) != null) {
                        Iterator<PseudoClass> it3 = list2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (it3.next() instanceof f) {
                                    return null;
                                }
                            }
                        }
                    }
                }
                return M;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private List<n> M() throws CSSParseException {
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            n nVar = new n(null);
            while (!h() && N(nVar)) {
                if (z()) {
                    arrayList.add(nVar);
                    nVar = new n(null);
                }
            }
            if (!nVar.f()) {
                arrayList.add(nVar);
            }
            return arrayList;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.caverock.androidsvg.CSSParser$f */
        /* JADX WARN: Multi-variable type inference failed */
        private void P(n nVar, o oVar) throws CSSParseException {
            PseudoClass pseudoClass;
            d dVar;
            String I = I();
            if (I != null) {
                PseudoClassIdents fromString = PseudoClassIdents.fromString(I);
                switch (a.b[fromString.ordinal()]) {
                    case 1:
                        pseudoClass = new d(0, 1, true, false, null);
                        nVar.b();
                        break;
                    case 2:
                        pseudoClass = new d(0, 1, false, false, null);
                        nVar.b();
                        break;
                    case 3:
                        pseudoClass = new h(false, null);
                        nVar.b();
                        break;
                    case 4:
                        pseudoClass = new d(0, 1, true, true, oVar.b);
                        nVar.b();
                        break;
                    case 5:
                        pseudoClass = new d(0, 1, false, true, oVar.b);
                        nVar.b();
                        break;
                    case 6:
                        pseudoClass = new h(true, oVar.b);
                        nVar.b();
                        break;
                    case 7:
                        pseudoClass = new i(null);
                        nVar.b();
                        break;
                    case 8:
                        pseudoClass = new e(null);
                        nVar.b();
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        boolean z = fromString == PseudoClassIdents.nth_child || fromString == PseudoClassIdents.nth_of_type;
                        boolean z2 = fromString == PseudoClassIdents.nth_of_type || fromString == PseudoClassIdents.nth_last_of_type;
                        a E = E();
                        if (E != null) {
                            d dVar2 = new d(E.a, E.b, z, z2, oVar.b);
                            nVar.b();
                            dVar = dVar2;
                            pseudoClass = dVar;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + I);
                        }
                        break;
                    case 13:
                        List<n> L = L();
                        if (L != null) {
                            f fVar = new f(L);
                            nVar.b = fVar.a();
                            dVar = fVar;
                            pseudoClass = dVar;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + I);
                        }
                    case 14:
                        pseudoClass = new j(null);
                        nVar.b();
                        break;
                    case 15:
                        H();
                        pseudoClass = new g(I);
                        nVar.b();
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        pseudoClass = new g(I);
                        nVar.b();
                        break;
                    default:
                        throw new CSSParseException("Unsupported pseudo class: " + I);
                }
                oVar.b(pseudoClass);
                return;
            }
            throw new CSSParseException("Invalid pseudo class");
        }

        private int Q() {
            int i;
            if (h()) {
                return this.b;
            }
            int i2 = this.b;
            int charAt = this.a.charAt(i2);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i = i2;
            } else {
                int a2 = a();
                while (true) {
                    if ((a2 < 65 || a2 > 90) && ((a2 < 97 || a2 > 122) && !((a2 >= 48 && a2 <= 57) || a2 == 45 || a2 == 95))) {
                        break;
                    }
                    a2 = a();
                }
                i = this.b;
            }
            this.b = i2;
            return i;
        }

        /* access modifiers changed from: package-private */
        public String G() {
            int D;
            if (h()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if (!(charAt == '\'' || charAt == '\"')) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.b++;
            int intValue = l().intValue();
            while (intValue != -1 && intValue != charAt) {
                if (intValue == 92) {
                    intValue = l().intValue();
                    if (intValue != -1) {
                        if (intValue == 10 || intValue == 13 || intValue == 12) {
                            intValue = l().intValue();
                        } else {
                            int D2 = D(intValue);
                            if (D2 != -1) {
                                for (int i = 1; i <= 5 && (D = D((intValue = l().intValue()))) != -1; i++) {
                                    D2 = (D2 * 16) + D;
                                }
                                sb.append((char) D2);
                            }
                        }
                    }
                }
                sb.append((char) intValue);
                intValue = l().intValue();
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public String I() {
            int Q = Q();
            int i = this.b;
            if (Q == i) {
                return null;
            }
            String substring = this.a.substring(i, Q);
            this.b = Q;
            return substring;
        }

        /* access modifiers changed from: package-private */
        public String J() {
            char charAt;
            int D;
            StringBuilder sb = new StringBuilder();
            while (!h() && (charAt = this.a.charAt(this.b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl((int) charAt)) {
                this.b++;
                if (charAt == '\\') {
                    if (!h()) {
                        String str = this.a;
                        int i = this.b;
                        this.b = i + 1;
                        charAt = str.charAt(i);
                        if (!(charAt == '\n' || charAt == '\r' || charAt == '\f')) {
                            int D2 = D(charAt);
                            if (D2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !h() && (D = D(this.a.charAt(this.b))) != -1; i2++) {
                                    this.b++;
                                    D2 = (D2 * 16) + D;
                                }
                                sb.append((char) D2);
                            }
                        }
                    }
                }
                sb.append((char) charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public String K() {
            if (h()) {
                return null;
            }
            int i = this.b;
            int charAt = this.a.charAt(i);
            int i2 = i;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                if (!k(charAt)) {
                    i2 = this.b + 1;
                }
                charAt = a();
            }
            if (this.b > i) {
                return this.a.substring(i, i2);
            }
            this.b = i;
            return null;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x012e  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0133  */
        public boolean N(n nVar) throws CSSParseException {
            Combinator combinator;
            o oVar;
            AttribOp attribOp;
            String str;
            if (h()) {
                return false;
            }
            int i = this.b;
            if (!nVar.f()) {
                if (f('>')) {
                    combinator = Combinator.CHILD;
                    A();
                } else if (f('+')) {
                    combinator = Combinator.FOLLOWS;
                    A();
                }
                if (!f('*')) {
                    oVar = new o(combinator, null);
                } else {
                    String I = I();
                    if (I != null) {
                        o oVar2 = new o(combinator, I);
                        nVar.c();
                        oVar = oVar2;
                    } else {
                        oVar = null;
                    }
                }
                while (!h()) {
                    if (!f('.')) {
                        if (!f('#')) {
                            if (!f(jl1.ARRAY_START)) {
                                if (!f(jl1.CONDITION_IF_MIDDLE)) {
                                    break;
                                }
                                if (oVar == null) {
                                    oVar = new o(combinator, null);
                                }
                                P(nVar, oVar);
                            } else {
                                if (oVar == null) {
                                    oVar = new o(combinator, null);
                                }
                                A();
                                String I2 = I();
                                if (I2 != null) {
                                    A();
                                    if (f(com.alipay.sdk.m.n.a.h)) {
                                        attribOp = AttribOp.EQUALS;
                                    } else if (g("~=")) {
                                        attribOp = AttribOp.INCLUDES;
                                    } else {
                                        attribOp = g("|=") ? AttribOp.DASHMATCH : null;
                                    }
                                    if (attribOp != null) {
                                        A();
                                        str = F();
                                        if (str != null) {
                                            A();
                                        } else {
                                            throw new CSSParseException("Invalid attribute simpleSelectors");
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (f(jl1.ARRAY_END)) {
                                        if (attribOp == null) {
                                            attribOp = AttribOp.EXISTS;
                                        }
                                        oVar.a(I2, attribOp, str);
                                        nVar.b();
                                    } else {
                                        throw new CSSParseException("Invalid attribute simpleSelectors");
                                    }
                                } else {
                                    throw new CSSParseException("Invalid attribute simpleSelectors");
                                }
                            }
                        } else {
                            if (oVar == null) {
                                oVar = new o(combinator, null);
                            }
                            String I3 = I();
                            if (I3 != null) {
                                oVar.a("id", AttribOp.EQUALS, I3);
                                nVar.d();
                            } else {
                                throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                            }
                        }
                    } else {
                        if (oVar == null) {
                            oVar = new o(combinator, null);
                        }
                        String I4 = I();
                        if (I4 != null) {
                            oVar.a("class", AttribOp.EQUALS, I4);
                            nVar.b();
                        } else {
                            throw new CSSParseException("Invalid \".class\" simpleSelectors");
                        }
                    }
                }
                if (oVar == null) {
                    nVar.a(oVar);
                    return true;
                }
                this.b = i;
                return false;
            }
            combinator = null;
            if (!f('*')) {
            }
            while (!h()) {
            }
            if (oVar == null) {
            }
        }

        /* access modifiers changed from: package-private */
        public String O() {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!g("url(")) {
                return null;
            }
            A();
            String G = G();
            if (G == null) {
                G = J();
            }
            if (G == null) {
                this.b = i;
                return null;
            }
            A();
            if (h() || g(jl1.BRACKET_END_STR)) {
                return G;
            }
            this.b = i;
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d implements PseudoClass {
        private int a;
        private int b;
        private boolean c;
        private boolean d;
        private String e;

        d(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            int i;
            int i2;
            String a2 = (!this.d || this.e != null) ? this.e : a0Var.a();
            SVG.SvgContainer svgContainer = a0Var.b;
            if (svgContainer != null) {
                Iterator<SVG.c0> it = svgContainer.getChildren().iterator();
                i2 = 0;
                i = 0;
                while (it.hasNext()) {
                    SVG.a0 a0Var2 = (SVG.a0) it.next();
                    if (a0Var2 == a0Var) {
                        i2 = i;
                    }
                    if (a2 == null || a0Var2.a().equals(a2)) {
                        i++;
                    }
                }
            } else {
                i2 = 0;
                i = 1;
            }
            int i3 = this.c ? i2 + 1 : i - i2;
            int i4 = this.a;
            if (i4 != 0) {
                int i5 = this.b;
                if ((i3 - i5) % i4 != 0) {
                    return false;
                }
                if (Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.a)) {
                    return true;
                }
                return false;
            } else if (i3 == this.b) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            String str = this.c ? "" : "last-";
            if (this.d) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e);
            }
            return String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e implements PseudoClass {
        private e() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            if (!(a0Var instanceof SVG.SvgContainer) || ((SVG.SvgContainer) a0Var).getChildren().size() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return DXRecyclerLayout.LOAD_MORE_EMPTY;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class f implements PseudoClass {
        private List<n> a;

        f(List<n> list) {
            this.a = list;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            int i = Integer.MIN_VALUE;
            for (n nVar : this.a) {
                int i2 = nVar.b;
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            for (n nVar : this.a) {
                if (CSSParser.l(lVar, nVar, a0Var)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return "not(" + this.a + jl1.BRACKET_END_STR;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class g implements PseudoClass {
        private String a;

        g(String str) {
            this.a = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            return false;
        }

        public String toString() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class h implements PseudoClass {
        private boolean a;
        private String b;

        public h(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            int i;
            String a2 = (!this.a || this.b != null) ? this.b : a0Var.a();
            SVG.SvgContainer svgContainer = a0Var.b;
            if (svgContainer != null) {
                Iterator<SVG.c0> it = svgContainer.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.a0 a0Var2 = (SVG.a0) it.next();
                    if (a2 == null || a0Var2.a().equals(a2)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            if (i == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (!this.a) {
                return String.format("only-child", new Object[0]);
            }
            return String.format("only-of-type <%s>", this.b);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class i implements PseudoClass {
        private i() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            return a0Var.b == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class j implements PseudoClass {
        private j() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(l lVar, SVG.a0 a0Var) {
            return lVar != null && a0Var == lVar.a;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class k {
        n a = null;
        SVG.Style b = null;
        Source c;

        k(n nVar, SVG.Style style, Source source) {
            this.a = nVar;
            this.b = style;
            this.c = source;
        }

        public String toString() {
            return String.valueOf(this.a) + " {...} (src=" + this.c + jl1.BRACKET_END_STR;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class l {
        SVG.a0 a;

        l() {
        }

        public String toString() {
            SVG.a0 a0Var = this.a;
            if (a0Var == null) {
                return "";
            }
            return String.format("<%s id=\"%s\">", a0Var.a(), this.a.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class m {
        private List<k> a = null;

        m() {
        }

        /* access modifiers changed from: package-private */
        public void a(k kVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).a.b > kVar.a.b) {
                    this.a.add(i, kVar);
                    return;
                }
            }
            this.a.add(kVar);
        }

        /* access modifiers changed from: package-private */
        public void b(m mVar) {
            if (mVar.a != null) {
                if (this.a == null) {
                    this.a = new ArrayList(mVar.a.size());
                }
                for (k kVar : mVar.a) {
                    a(kVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public List<k> c() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            List<k> list = this.a;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void e(Source source) {
            List<k> list = this.a;
            if (list != null) {
                Iterator<k> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().c == source) {
                        it.remove();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int f() {
            List<k> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (k kVar : this.a) {
                sb.append(kVar.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class o {
        Combinator a = null;
        String b = null;
        List<b> c = null;
        List<PseudoClass> d = null;

        o(Combinator combinator, String str) {
            this.a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.b = str;
        }

        /* access modifiers changed from: package-private */
        public void a(String str, AttribOp attribOp, String str2) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(new b(str, attribOp, str2));
        }

        /* access modifiers changed from: package-private */
        public void b(PseudoClass pseudoClass) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.a;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.b;
            if (str == null) {
                str = jl1.MUL;
            }
            sb.append(str);
            List<b> list = this.c;
            if (list != null) {
                for (b bVar : list) {
                    sb.append(jl1.ARRAY_START);
                    sb.append(bVar.a);
                    int i = a.a[bVar.b.ordinal()];
                    if (i == 1) {
                        sb.append(com.alipay.sdk.m.n.a.h);
                        sb.append(bVar.c);
                    } else if (i == 2) {
                        sb.append("~=");
                        sb.append(bVar.c);
                    } else if (i == 3) {
                        sb.append("|=");
                        sb.append(bVar.c);
                    }
                    sb.append(jl1.ARRAY_END);
                }
            }
            List<PseudoClass> list2 = this.d;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(jl1.CONDITION_IF_MIDDLE);
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    private static int a(List<SVG.SvgContainer> list, int i2, SVG.a0 a0Var) {
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        SVG.SvgContainer svgContainer = list.get(i2);
        SVG.SvgContainer svgContainer2 = a0Var.b;
        if (svgContainer != svgContainer2) {
            return -1;
        }
        for (SVG.c0 c0Var : svgContainer2.getChildren()) {
            if (c0Var == a0Var) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    static boolean b(String str, MediaType mediaType) {
        c cVar = new c(str);
        cVar.A();
        return c(h(cVar), mediaType);
    }

    private static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all) {
                return true;
            }
            if (mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private void e(m mVar, c cVar) throws CSSParseException {
        String I = cVar.I();
        cVar.A();
        if (I != null) {
            if (!this.c && I.equals(SVGParser.XML_STYLESHEET_ATTR_MEDIA)) {
                List<MediaType> h2 = h(cVar);
                if (cVar.f('{')) {
                    cVar.A();
                    if (c(h2, this.a)) {
                        this.c = true;
                        mVar.b(j(cVar));
                        this.c = false;
                    } else {
                        j(cVar);
                    }
                    if (!cVar.h() && !cVar.f('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (this.c || !I.equals("import")) {
                p("Ignoring @%s rule", I);
                o(cVar);
            } else {
                String O = cVar.O();
                if (O == null) {
                    O = cVar.G();
                }
                if (O != null) {
                    cVar.A();
                    h(cVar);
                    if (cVar.h() || cVar.f(d80.TokenSEM)) {
                        SVG.g();
                    } else {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            }
            cVar.A();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    public static List<String> f(String str) {
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.h()) {
            String r = cVar.r();
            if (r != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r);
                cVar.A();
            }
        }
        return arrayList;
    }

    private SVG.Style g(c cVar) throws CSSParseException {
        SVG.Style style = new SVG.Style();
        do {
            String I = cVar.I();
            cVar.A();
            if (cVar.f(jl1.CONDITION_IF_MIDDLE)) {
                cVar.A();
                String K = cVar.K();
                if (K != null) {
                    cVar.A();
                    if (cVar.f('!')) {
                        cVar.A();
                        if ("important".equalsIgnoreCase(cVar.F())) {
                            style.important = true;
                        }
                        cVar.A();
                    }
                    cVar.f(d80.TokenSEM);
                    SVGParser.S0(style, I, K);
                    cVar.A();
                    if (cVar.h()) {
                        break;
                    }
                } else {
                    throw new CSSParseException("Expected property value");
                }
            } else {
                throw new CSSParseException("Expected ':'");
            }
        } while (!cVar.f('}'));
        return style;
    }

    private static List<MediaType> h(c cVar) {
        String w;
        ArrayList arrayList = new ArrayList();
        while (!cVar.h() && (w = cVar.w()) != null) {
            try {
                arrayList.add(MediaType.valueOf(w));
            } catch (IllegalArgumentException unused) {
            }
            if (!cVar.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(m mVar, c cVar) throws CSSParseException {
        List<n> M = cVar.M();
        if (M == null || M.isEmpty()) {
            return false;
        }
        if (cVar.f('{')) {
            cVar.A();
            SVG.Style g2 = g(cVar);
            cVar.A();
            for (n nVar : M) {
                mVar.a(new k(nVar, g2, this.b));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    private m j(c cVar) {
        m mVar = new m();
        while (!cVar.h()) {
            try {
                if (!cVar.g("<!--")) {
                    if (!cVar.g("-->")) {
                        if (!cVar.f('@')) {
                            if (!i(mVar, cVar)) {
                                break;
                            }
                        } else {
                            e(mVar, cVar);
                        }
                    }
                }
            } catch (CSSParseException e2) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e2.getMessage());
            }
        }
        return mVar;
    }

    private static boolean k(l lVar, n nVar, int i2, List<SVG.SvgContainer> list, int i3, SVG.a0 a0Var) {
        o e2 = nVar.e(i2);
        if (!n(lVar, e2, list, i3, a0Var)) {
            return false;
        }
        Combinator combinator = e2.a;
        if (combinator == Combinator.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 >= 0) {
                if (m(lVar, nVar, i2 - 1, list, i3)) {
                    return true;
                }
                i3--;
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(lVar, nVar, i2 - 1, list, i3);
        } else {
            int a2 = a(list, i3, a0Var);
            if (a2 <= 0) {
                return false;
            }
            return k(lVar, nVar, i2 - 1, list, i3, (SVG.a0) a0Var.b.getChildren().get(a2 - 1));
        }
    }

    static boolean l(l lVar, n nVar, SVG.a0 a0Var) {
        if (nVar.g() == 1) {
            return n(lVar, nVar.e(0), null, -1, a0Var);
        }
        ArrayList arrayList = new ArrayList();
        for (SVG.SvgContainer svgContainer = a0Var.b; svgContainer != null; svgContainer = ((SVG.c0) svgContainer).b) {
            arrayList.add(0, svgContainer);
        }
        return k(lVar, nVar, nVar.g() - 1, arrayList, arrayList.size() - 1, a0Var);
    }

    private static boolean m(l lVar, n nVar, int i2, List<SVG.SvgContainer> list, int i3) {
        o e2 = nVar.e(i2);
        SVG.a0 a0Var = (SVG.a0) list.get(i3);
        if (!n(lVar, e2, list, i3, a0Var)) {
            return false;
        }
        Combinator combinator = e2.a;
        if (combinator == Combinator.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 > 0) {
                i3--;
                if (m(lVar, nVar, i2 - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(lVar, nVar, i2 - 1, list, i3 - 1);
        } else {
            int a2 = a(list, i3, a0Var);
            if (a2 <= 0) {
                return false;
            }
            return k(lVar, nVar, i2 - 1, list, i3, (SVG.a0) a0Var.b.getChildren().get(a2 - 1));
        }
    }

    private static boolean n(l lVar, o oVar, List<SVG.SvgContainer> list, int i2, SVG.a0 a0Var) {
        List<String> list2;
        String str = oVar.b;
        if (!(str == null || str.equals(a0Var.a().toLowerCase(Locale.US)))) {
            return false;
        }
        List<b> list3 = oVar.c;
        if (list3 != null) {
            int size = list3.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = oVar.c.get(i3);
                String str2 = bVar.a;
                str2.hashCode();
                if (!str2.equals("id")) {
                    if (!(str2.equals("class") && (list2 = a0Var.g) != null && list2.contains(bVar.c))) {
                        return false;
                    }
                } else if (!bVar.c.equals(a0Var.c)) {
                    return false;
                }
            }
        }
        List<PseudoClass> list4 = oVar.d;
        if (list4 == null) {
            return true;
        }
        int size2 = list4.size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (!oVar.d.get(i4).matches(lVar, a0Var)) {
                return false;
            }
        }
        return true;
    }

    private void o(c cVar) {
        int i2 = 0;
        while (!cVar.h()) {
            int intValue = cVar.l().intValue();
            if (intValue != 59 || i2 != 0) {
                if (intValue == 123) {
                    i2++;
                } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    /* access modifiers changed from: package-private */
    public m d(String str) {
        c cVar = new c(str);
        cVar.A();
        return j(cVar);
    }

    CSSParser(MediaType mediaType, Source source) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = mediaType;
        this.b = source;
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class n {
        List<o> a;
        int b;

        private n() {
            this.a = null;
            this.b = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(oVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.b += 1000;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.b++;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.b += 1000000;
        }

        /* access modifiers changed from: package-private */
        public o e(int i) {
            return this.a.get(i);
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            List<o> list = this.a;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public int g() {
            List<o> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (o oVar : this.a) {
                sb.append(oVar);
                sb.append(' ');
            }
            sb.append(jl1.ARRAY_START);
            sb.append(this.b);
            sb.append(jl1.ARRAY_END);
            return sb.toString();
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }
}
