package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.Stack;

/* compiled from: Taobao */
public class d {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = 0;
    private Reader b;
    private int c;
    private int d;
    private char[] e;
    private int f;
    private char[] g;
    private char h = 65535;
    private char i = 65535;
    private ParserCallback j;
    private Stack<c> k = new Stack<>();

    private boolean a(int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007891872")) {
            return ((Boolean) ipChange.ipc$dispatch("-2007891872", new Object[]{this, Integer.valueOf(i2), str})).booleanValue();
        }
        int length = str.length();
        while (true) {
            int i3 = length - 1;
            if (length == 0 || i2 >= str.length()) {
                return true;
            }
            if (this.g[i2] != str.charAt(i2)) {
                return false;
            }
            i2++;
            length = i3;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:255:0x02be A[RETURN] */
    private int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237444236")) {
            return ((Integer) ipChange.ipc$dispatch("237444236", new Object[]{this})).intValue();
        }
        int i2 = this.f;
        if (i2 != 10) {
            switch (i2) {
                case 1:
                    char c2 = this.g[0];
                    if (c2 == 'a') {
                        return 14;
                    }
                    if (c2 == 'b') {
                        return 11;
                    }
                    if (c2 == 'i') {
                        return 3;
                    }
                    if (c2 == 's') {
                        return 21;
                    }
                    if (c2 == 'u') {
                        return 6;
                    }
                    if (c2 == 'p') {
                        return 54;
                    }
                    if (c2 != 'q') {
                        return -1;
                    }
                    return 24;
                case 2:
                    char[] cArr = this.g;
                    char c3 = cArr[0];
                    if (c3 != 'b') {
                        if (c3 != 'e') {
                            if (c3 != 'h') {
                                if (c3 != 'l') {
                                    if (c3 != 'o') {
                                        if (c3 != 't') {
                                            if (c3 == 'u' && cArr[1] == 'l') {
                                                return 55;
                                            }
                                        } else if (cArr[1] == 'd') {
                                            return 88;
                                        } else {
                                            if (cArr[1] == 'h') {
                                                return 87;
                                            }
                                            if (cArr[1] == 'r') {
                                                return 86;
                                            }
                                            if (cArr[1] == 't') {
                                                return 2;
                                            }
                                        }
                                    } else if (cArr[1] == 'l') {
                                        return 56;
                                    }
                                } else if (cArr[1] == 'i') {
                                    return 57;
                                }
                            } else if ('1' <= cArr[1] && cArr[1] <= '6') {
                                return (cArr[1] - '1') + 61;
                            } else {
                                if (cArr[1] == 'r') {
                                    return 72;
                                }
                            }
                        } else if (cArr[1] == 'r') {
                            return 9;
                        }
                    } else if (cArr[1] == 'r') {
                        return 16;
                    }
                    break;
                case 3:
                    char[] cArr2 = this.g;
                    char c4 = cArr2[0];
                    if (c4 != 'b') {
                        if (c4 != 'd') {
                            if (c4 != 'i') {
                                if (c4 != 'k') {
                                    if (c4 != 'p') {
                                        if (c4 == 's' && cArr2[1] == 'u') {
                                            if (cArr2[2] == 'b') {
                                                return 17;
                                            }
                                            if (cArr2[2] == 'p') {
                                                return 18;
                                            }
                                        }
                                    } else if (cArr2[1] == 'r' && cArr2[2] == 'e') {
                                        return 70;
                                    }
                                } else if (cArr2[1] == 'b' && cArr2[2] == 'd') {
                                    return 12;
                                }
                            } else if (cArr2[1] == 'm' && cArr2[2] == 'g') {
                                return 15;
                            } else {
                                if (cArr2[1] == 'n' && cArr2[2] == 's') {
                                    return 19;
                                }
                            }
                        } else if (cArr2[1] == 'e' && cArr2[2] == 'l') {
                            return 20;
                        } else {
                            if (cArr2[1] == 'f' && cArr2[2] == 'n') {
                                return 5;
                            }
                            if (cArr2[1] == 'i' && cArr2[2] == 'v') {
                                return 53;
                            }
                        }
                    } else if (cArr2[1] == 'i' && cArr2[2] == 'g') {
                        return 7;
                    }
                    break;
                case 4:
                    char[] cArr3 = this.g;
                    char c5 = cArr3[0];
                    if (c5 != 'c') {
                        if (c5 != 'f') {
                            if (c5 != 'm') {
                                if (c5 == 's' && cArr3[1] == 'p' && cArr3[2] == 'a' && cArr3[3] == 'n') {
                                    return 23;
                                }
                            } else if (cArr3[1] == 'a' && cArr3[2] == 'r' && cArr3[3] == 'k') {
                                return 13;
                            }
                        } else if (cArr3[1] == 'o' && cArr3[2] == 'n' && cArr3[3] == 't') {
                            return 1;
                        }
                    } else if (cArr3[1] == 'i' && cArr3[2] == 't' && cArr3[3] == 'e') {
                        return 4;
                    } else {
                        if (cArr3[1] == 'o' && cArr3[2] == 'd' && cArr3[3] == 'e') {
                            return 25;
                        }
                    }
                    break;
                case 5:
                    if (a(2, "dio")) {
                        char[] cArr4 = this.g;
                        if (cArr4[0] == 'a' && cArr4[1] == 'u') {
                            return 92;
                        }
                        if (cArr4[0] == 'v' && cArr4[1] == 'e') {
                            return 91;
                        }
                    } else {
                        char c6 = this.g[0];
                        if (c6 != 's') {
                            if (c6 != 't') {
                                return -1;
                            }
                            if (a(1, "able")) {
                                return 81;
                            }
                            if (a(1, "body")) {
                                return 85;
                            }
                            if (a(1, "head")) {
                                return 83;
                            }
                            if (a(1, "foot")) {
                                return 84;
                            }
                        } else if (a(1, "mall")) {
                            return 8;
                        }
                    }
                    break;
                case 6:
                    if (a(0, "str")) {
                        char[] cArr5 = this.g;
                        if (cArr5[3] == 'o' && cArr5[4] == 'n' && cArr5[5] == 'g') {
                            return 10;
                        }
                        if (cArr5[3] == 'i' && cArr5[4] == 'k' && cArr5[5] == 'e') {
                            return 22;
                        }
                    } else {
                        char[] cArr6 = this.g;
                        if (cArr6[4] == 'e' && cArr6[5] == 'f') {
                            if (cArr6[0] == 'h' && cArr6[1] == 'e' && cArr6[2] == 'a' && cArr6[3] == 'd') {
                                return 50;
                            }
                            if (cArr6[0] == 'f' && cArr6[1] == 'o' && cArr6[2] == 'o' && cArr6[3] == 't') {
                                return 51;
                            }
                        }
                    }
                    break;
                case 7:
                    if (a(0, "caption")) {
                        return 82;
                    }
                    break;
                default:
                    return -1;
            }
        } else if (a(0, "blockquote")) {
            return 71;
        }
        return -1;
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153793395")) {
            ipChange.ipc$dispatch("-153793395", new Object[]{this});
            return;
        }
        while (!this.k.isEmpty()) {
            c pop = this.k.pop();
            this.j.endElement(pop.a, pop.b);
        }
        this.h = 65535;
        this.j.endDocument();
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293142784")) {
            ipChange.ipc$dispatch("-293142784", new Object[]{this});
            return;
        }
        ParserCallback parserCallback = this.j;
        if (parserCallback != null) {
            parserCallback.startDocument(this.e.length);
            n();
            while (true) {
                char c2 = this.h;
                if (c2 == 65535) {
                    return;
                }
                if (c2 == '<') {
                    n();
                    char c3 = this.h;
                    if (c3 == '!') {
                        n();
                        if (this.h != '-') {
                            q();
                        } else if (n() == '-') {
                            f();
                        } else if (this.h != '>') {
                            q();
                        }
                    } else if (c3 == '/') {
                        h();
                    } else if (c3 != '?') {
                        i();
                    } else {
                        q();
                    }
                } else if (c2 == '>') {
                    n();
                    j();
                } else if (c2 != 65535) {
                    char c4 = this.i;
                    if (c4 == 65535 || c4 == '>') {
                        j();
                    } else {
                        n();
                    }
                } else {
                    c();
                }
            }
        }
    }

    private void e() {
        char c2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247337521")) {
            ipChange.ipc$dispatch("-247337521", new Object[]{this});
            return;
        }
        this.f = 0;
        do {
            char[] cArr = this.g;
            int i2 = this.f;
            this.f = i2 + 1;
            cArr[i2] = this.h;
            n();
            c2 = this.h;
            if (c2 == 65535 || c2 == '>') {
                char[] cArr2 = this.g;
                int i3 = this.f;
            }
        } while (this.f < 384);
        char[] cArr22 = this.g;
        int i32 = this.f;
        if (cArr22[i32 - 1] == '/') {
            this.f = i32 - 1;
        }
        if (c2 != '>') {
            q();
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155151637")) {
            ipChange.ipc$dispatch("-155151637", new Object[]{this});
            return;
        }
        while (this.h != 65535) {
            n();
            n();
            if (this.h == '-' && this.i == '-') {
                n();
                if (this.h == '>') {
                    return;
                }
            }
        }
    }

    private void h() {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200413569")) {
            ipChange.ipc$dispatch("200413569", new Object[]{this});
            return;
        }
        this.f = 0;
        while (this.h != 65535) {
            char o = o();
            this.h = o;
            if (o == '>' || (i3 = this.f) >= 16) {
                break;
            }
            char[] cArr = this.g;
            this.f = i3 + 1;
            cArr[i3] = o;
        }
        String str = new String(this.g, 0, this.f);
        int b2 = b();
        this.f = 0;
        if (b2 == 70 && (i2 = this.a) > 0) {
            this.a = i2 - 1;
        }
        k(b2, str);
        this.j.endElement(b2, str);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177394424")) {
            ipChange.ipc$dispatch("-177394424", new Object[]{this});
            return;
        }
        char c2 = this.h;
        if ((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z')) {
            this.f = 0;
            while (true) {
                char c3 = this.h;
                if (c3 >= 'A' && c3 <= 'Z') {
                    this.h = (char) ((c3 + 'a') - 65);
                }
                char[] cArr = this.g;
                int i2 = this.f;
                this.f = i2 + 1;
                cArr[i2] = this.h;
                n();
                char c4 = this.h;
                if (c4 == 65535 || this.f >= 16 || ((c4 < 'a' || c4 > 'z') && ((c4 < 'A' || c4 > 'Z') && (c4 < '0' || c4 > '9')))) {
                    String str = new String(this.g, 0, this.f);
                    int b2 = b();
                    this.f = 0;
                }
            }
            String str2 = new String(this.g, 0, this.f);
            int b22 = b();
            this.f = 0;
            if (this.h == '/') {
                n();
            }
            char c5 = this.h;
            if (c5 != '>') {
                if (c5 == ' ' || c5 == '\n' || c5 == '\r') {
                    o();
                }
                if (this.h == '/') {
                    n();
                }
                if (this.h != '>') {
                    e();
                }
            }
            if (this.j != null) {
                if (b22 == 70) {
                    this.a++;
                }
                c.a aVar = null;
                int i3 = this.f;
                if (i3 >= 5) {
                    aVar = a.m(b22, this.g, i3);
                }
                c cVar = new c(b22, str2, aVar);
                l(cVar);
                this.j.startElement(cVar);
            }
        }
    }

    private void j() {
        ParserCallback parserCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990320365")) {
            ipChange.ipc$dispatch("-990320365", new Object[]{this});
            return;
        }
        this.f = 0;
        while (true) {
            char c2 = this.h;
            if (c2 == 65535 || c2 == '<' || c2 == '>') {
                int i2 = this.f;
            } else {
                if (this.a <= 0 || this.f <= 0) {
                    if (c2 == '&') {
                        n();
                        char c3 = this.h;
                        if (c3 != 65535 && c3 == 'n') {
                            n();
                            char c4 = this.h;
                            if (c4 == 65535 || c4 != 'b') {
                                m(38);
                                m(110);
                            } else {
                                n();
                                char c5 = this.h;
                                if (c5 == 65535 || c5 != 's') {
                                    m(38);
                                    m(110);
                                    m(98);
                                } else {
                                    n();
                                    char c6 = this.h;
                                    if (c6 == 65535 || c6 != 'p') {
                                        m(38);
                                        m(110);
                                        m(98);
                                        m(115);
                                    } else {
                                        n();
                                        char c7 = this.h;
                                        if (c7 == 65535 || c7 != ';') {
                                            m(38);
                                            m(110);
                                            m(98);
                                            m(115);
                                            m(112);
                                        } else {
                                            m(32);
                                            n();
                                        }
                                    }
                                }
                            }
                        } else if (c3 != 65535 && c3 == 'a') {
                            n();
                            char c8 = this.h;
                            if (c8 != 65535 && c8 == 'm') {
                                n();
                                char c9 = this.h;
                                if (c9 == 65535 || c9 != 'p') {
                                    m(38);
                                    m(97);
                                    m(109);
                                } else {
                                    n();
                                    char c10 = this.h;
                                    if (c10 == 65535 || c10 != ';') {
                                        m(38);
                                        m(97);
                                        m(109);
                                        m(112);
                                    } else {
                                        m(38);
                                        n();
                                    }
                                }
                            } else if (c8 == 65535 || c8 != 'p') {
                                m(38);
                                m(97);
                            } else {
                                n();
                                char c11 = this.h;
                                if (c11 == 65535 || c11 != 'o') {
                                    m(38);
                                    m(97);
                                    m(112);
                                } else {
                                    n();
                                    char c12 = this.h;
                                    if (c12 == 65535 || c12 != 's') {
                                        m(38);
                                        m(97);
                                        m(112);
                                        m(111);
                                    } else {
                                        n();
                                        char c13 = this.h;
                                        if (c13 == 65535 || c13 != ';') {
                                            m(38);
                                            m(97);
                                            m(112);
                                            m(111);
                                            m(115);
                                        } else {
                                            m(39);
                                            n();
                                        }
                                    }
                                }
                            }
                        } else if (c3 != 65535 && c3 == 'g') {
                            n();
                            char c14 = this.h;
                            if (c14 == 65535 || c14 != 't') {
                                m(38);
                                m(103);
                            } else {
                                n();
                                char c15 = this.h;
                                if (c15 == 65535 || c15 != ';') {
                                    m(38);
                                    m(103);
                                    m(116);
                                } else {
                                    m(62);
                                    n();
                                }
                            }
                        } else if (c3 != 65535 && c3 == 'l') {
                            n();
                            char c16 = this.h;
                            if (c16 == 65535 || c16 != 't') {
                                m(38);
                                m(108);
                            } else {
                                n();
                                char c17 = this.h;
                                if (c17 == 65535 || c17 != ';') {
                                    m(38);
                                    m(108);
                                    m(116);
                                } else {
                                    m(60);
                                    n();
                                }
                            }
                        } else if (c3 == 65535 || c3 != 'q') {
                            m(38);
                        } else {
                            n();
                            char c18 = this.h;
                            if (c18 == 65535 || c18 != 'u') {
                                m(38);
                                m(113);
                            } else {
                                n();
                                char c19 = this.h;
                                if (c19 == 65535 || c19 != 'o') {
                                    m(38);
                                    m(113);
                                    m(117);
                                } else {
                                    n();
                                    char c20 = this.h;
                                    if (c20 == 65535 || c20 != 't') {
                                        m(38);
                                        m(113);
                                        m(117);
                                        m(111);
                                    } else {
                                        n();
                                        char c21 = this.h;
                                        if (c21 == 65535 || c21 != ';') {
                                            m(38);
                                            m(113);
                                            m(117);
                                            m(111);
                                            m(116);
                                        } else {
                                            m(34);
                                            n();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    char c22 = this.h;
                    if (c22 == ' ' || c22 == '\n') {
                        int i3 = this.f;
                        if (!(i3 == 0 || this.g[i3 - 1] == ' ')) {
                            this.h = ' ';
                            m(32);
                        }
                    } else {
                        m(c22);
                    }
                } else {
                    m(c2);
                }
                n();
            }
        }
        int i22 = this.f;
        if (i22 > 0 && (parserCallback = this.j) != null) {
            parserCallback.characters(this.g, 0, i22);
        }
    }

    private void k(int i2, String str) {
        c peek;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421143603")) {
            ipChange.ipc$dispatch("-421143603", new Object[]{this, Integer.valueOf(i2), str});
        } else if (i2 != 15 && i2 != 16 && i2 != 72 && !this.k.isEmpty() && (peek = this.k.peek()) != null) {
            if (i2 != peek.a || !str.equals(peek.b)) {
                int size = this.k.size() - 1;
                while (size > 0 && (i2 != this.k.get(size).a || !str.equals(this.k.get(size).b))) {
                    size--;
                }
                if (size > 0) {
                    for (int size2 = this.k.size() - 1; size2 != size - 1; size2--) {
                        this.k.pop();
                    }
                    return;
                }
                return;
            }
            this.k.pop();
        }
    }

    private void l(c cVar) {
        c.a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987059433")) {
            ipChange.ipc$dispatch("987059433", new Object[]{this, cVar});
            return;
        }
        int i2 = cVar.a;
        if (i2 != 15 && i2 != 16 && i2 != 72) {
            if (!this.k.isEmpty() && (aVar = this.k.peek().d) != null) {
                c.a aVar2 = cVar.d;
                if (aVar2 == null) {
                    cVar.d = aVar;
                } else {
                    if (aVar2.c == 1) {
                        aVar2.c = aVar.c;
                    }
                    if (aVar2.e == -1) {
                        aVar2.e = aVar.e;
                    }
                    if (aVar2.g == -1) {
                        aVar2.g = aVar.g;
                    }
                    if (aVar2.f == 0) {
                        aVar2.f = aVar.f;
                    }
                }
            }
            this.k.push(cVar);
        }
    }

    private void m(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181276621")) {
            ipChange.ipc$dispatch("-1181276621", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        int i3 = this.f;
        char[] cArr = this.g;
        if (i3 == cArr.length) {
            char[] cArr2 = new char[(((i3 * 4) / 3) + 4)];
            System.arraycopy(cArr, 0, cArr2, 0, i3);
            this.g = cArr2;
        }
        char[] cArr3 = this.g;
        int i4 = this.f;
        this.f = i4 + 1;
        cArr3[i4] = (char) i2;
    }

    private char n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448220462")) {
            return ((Character) ipChange.ipc$dispatch("1448220462", new Object[]{this})).charValue();
        }
        this.i = this.h;
        int i2 = this.c;
        if (i2 < this.d) {
            char[] cArr = this.e;
            this.c = i2 + 1;
            this.h = cArr[i2];
        } else {
            Reader reader = this.b;
            if (reader == null) {
                this.h = 65535;
            } else {
                try {
                    char[] cArr2 = this.e;
                    this.d = reader.read(cArr2, 0, cArr2.length);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    this.h = 65535;
                }
                if (this.d <= 0) {
                    this.h = 65535;
                } else {
                    this.h = this.e[0];
                }
                this.c = 1;
            }
        }
        char c2 = this.h;
        if (c2 == '\r') {
            n();
        } else if (c2 == 65535) {
            c();
        }
        return this.h;
    }

    private char o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276918465")) {
            return ((Character) ipChange.ipc$dispatch("1276918465", new Object[]{this})).charValue();
        }
        while (this.h != 65535) {
            n();
            char c2 = this.h;
            if (c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != ' ') {
                return c2;
            }
        }
        return 65535;
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779722568")) {
            ipChange.ipc$dispatch("-1779722568", new Object[]{this});
            return;
        }
        while (true) {
            char c2 = this.h;
            if (c2 != 65535 && c2 != '>') {
                n();
            } else {
                return;
            }
        }
    }

    public void g(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539466213")) {
            ipChange.ipc$dispatch("-539466213", new Object[]{this, str});
            return;
        }
        Objects.requireNonNull(str, "input cant be null");
        char[] charArray = str.toCharArray();
        this.e = charArray;
        this.c = 0;
        this.d = charArray.length;
        int length = charArray.length;
        this.k.clear();
        this.g = new char[length];
        d();
    }

    public void p(ParserCallback parserCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338562402")) {
            ipChange.ipc$dispatch("-1338562402", new Object[]{this, parserCallback});
            return;
        }
        this.j = parserCallback;
    }
}
