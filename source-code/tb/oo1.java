package tb;

import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;

/* compiled from: Taobao */
public class oo1 {
    private String a;
    private int b = 0;
    private v7<vm2> c = new v7<>();
    private v7<kh2> d = new v7<>();

    public oo1(String str) {
        this.a = str;
    }

    private final void b(int i) {
        while (this.d.i() > i) {
            a(this.d.f());
        }
    }

    public static vm2 g(String str) {
        try {
            return new oo1(str).f();
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("code " + str, e);
            }
            return new ec(null, 6);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(kh2 kh2) {
        String str = kh2.a;
        if (!jl1.BRACKET_START_STR.equals(str) && !jl1.BLOCK_START_STR.equals(kh2.a) && !jl1.ARRAY_START_STR.equals(kh2.a) && !"$".equals(kh2.a) && !jl1.BLOCK_START_STR.equals(kh2.a)) {
            int i = kh2.b;
            int max = Math.max(i - 1, 0);
            if (!this.d.d()) {
                max = Math.max(max, this.d.e().b);
            }
            hl1 hl1 = new hl1(str, 5);
            if (jl1.AND_NOT.equals(str)) {
                if (this.c.i() > i) {
                    hl1.c = this.c.h(i);
                    this.c.a(i, hl1);
                }
            } else if (this.c.i() > i) {
                hl1.e = this.c.h(i);
                if (this.c.i() > max) {
                    hl1.d = this.c.h(max);
                } else if (hl1.e == null) {
                    return;
                }
                this.c.a(max, hl1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.b < this.a.length();
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        while (c()) {
            if (this.a.charAt(this.b) != ' ') {
                return true;
            }
            this.b++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final char e() {
        char charAt = this.a.charAt(this.b);
        while (charAt == ' ') {
            this.b++;
            int length = this.a.length();
            int i = this.b;
            if (length <= i) {
                break;
            }
            charAt = this.a.charAt(i);
        }
        return charAt;
    }

    public final vm2 f() {
        while (d()) {
            l();
        }
        while (!this.d.d()) {
            a(this.d.f());
        }
        if (this.c.i() == 1) {
            return this.c.f();
        }
        return new ec(this.c.c(), 6);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    public final void h() {
        vm2 vm2;
        int i = this.c.i();
        int i2 = this.d.i();
        int i3 = this.b;
        int i4 = (i3 + -1 < 0 || !Character.isJavaIdentifierPart(this.a.charAt(i3 - 1))) ? 7 : 0;
        this.d.g(new kh2(jl1.ARRAY_START_STR, this.c.i()));
        this.b++;
        while (d() && l() != ']') {
            while (d()) {
                while (d()) {
                }
            }
        }
        if (this.c.i() <= i) {
            while (this.d.i() > i2) {
                this.d.f();
            }
            return;
        }
        while (this.d.i() > i2) {
            kh2 f = this.d.f();
            if (this.c.i() > i) {
                a(f);
            }
        }
        ArrayList arrayList = new ArrayList(4);
        for (int i5 = i; i5 < this.c.i(); i5++) {
            arrayList.add(this.c.b(i5));
        }
        while (this.c.i() > i) {
            this.c.f();
        }
        if (i4 == 7 || this.c.i() == 0) {
            this.c.g(new ec(arrayList, 7));
            return;
        }
        vm2 f2 = this.c.f();
        if (arrayList.size() == 1) {
            vm2 = (vm2) arrayList.get(0);
        } else {
            vm2 = new ec(arrayList, 6);
        }
        hl1 hl1 = new hl1(".", i4);
        hl1.d = f2;
        hl1.e = vm2;
        this.c.g(hl1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: tb.v7<tb.vm2> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0037  */
    public void i() {
        int i = this.c.i();
        int i2 = this.d.i();
        if (this.a.charAt(this.b) == '{') {
            this.d.g(new kh2(jl1.BLOCK_START_STR, this.c.i()));
            this.b++;
            while (d() && l() != '}') {
                while (d()) {
                    while (d()) {
                    }
                }
            }
        } else {
            this.d.g(new kh2(jl1.BRACKET_START_STR, this.c.i()));
            this.b++;
            while (d() && l() != ')') {
                while (d()) {
                    while (d()) {
                    }
                }
            }
        }
        if (this.c.i() <= i) {
            while (this.d.i() > i2) {
                this.d.f();
            }
            return;
        }
        while (this.d.i() > i2) {
            kh2 f = this.d.f();
            if (this.c.i() > i) {
                a(f);
            }
        }
        ArrayList arrayList = new ArrayList(4);
        for (int i3 = i; i3 < this.c.i(); i3++) {
            arrayList.add(this.c.b(i3));
        }
        while (this.c.i() > i) {
            this.c.f();
        }
        if (arrayList.size() == 1) {
            this.c.g(arrayList.get(0));
            return;
        }
        this.c.g(new ec(arrayList, 6));
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        int i = this.b;
        this.b = i + 1;
        while (c() && Character.isJavaIdentifierPart(this.a.charAt(this.b))) {
            this.b++;
        }
        String substring = this.a.substring(i, this.b);
        if (substring.startsWith("$")) {
            if (substring.length() != 1) {
                substring = substring.substring(1);
            } else {
                return;
            }
        }
        int i2 = 0;
        if (jl1.KEYWORDS.containsKey(substring) && (this.d.d() || !jl1.f(this.d.e().a))) {
            i2 = 4;
        }
        this.c.g(new vm2(substring, i2));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    public void k() {
        hl1 hl1 = new hl1("?", 5);
        int i = 0;
        b(0);
        if (this.d.i() > 0) {
            i = Math.max(this.d.e().b, 0);
        }
        if (this.c.i() > i) {
            hl1.c = this.c.f();
        }
        int i2 = this.c.i();
        int i3 = this.d.i();
        this.b++;
        while (d() && l() != ':') {
            while (d()) {
                while (d()) {
                }
            }
        }
        while (this.d.i() > i3) {
            a(this.d.f());
        }
        while (this.c.i() > i2) {
            hl1.d = this.c.f();
        }
        int i4 = this.d.i();
        while (d()) {
            l();
            if (d()) {
                l();
            }
            if (this.d.i() <= i4) {
                break;
            }
        }
        b(i4);
        while (this.c.i() > i2) {
            hl1.e = this.c.f();
        }
        this.c.g(hl1);
    }

    /* access modifiers changed from: package-private */
    public final char l() {
        char e = e();
        if (e == '$') {
            this.b++;
            return e;
        }
        if (Character.isJavaIdentifierStart(e)) {
            j();
        } else if (e == '(' || e == '{') {
            i();
        } else if (e == '[') {
            h();
        } else if (e == '\"' || e == '\'') {
            o();
        } else if ((e == '.' && Character.isDigit(this.a.charAt(this.b + 1))) || Character.isDigit(e)) {
            m();
        } else if (e == '?') {
            k();
        } else if (e == ':' || e == ')' || e == '}' || e == ' ' || e == ']') {
            this.b++;
            return e;
        } else {
            n();
        }
        return e;
    }

    /* access modifiers changed from: package-private */
    public final void m() {
        vm2 vm2;
        int i = this.b;
        boolean z = (this.a.charAt(i) == 'e' || this.a.charAt(this.b) == '.') ? false : true;
        this.b++;
        while (c()) {
            char charAt = this.a.charAt(this.b);
            if (!Character.isDigit(charAt) && charAt != '.' && charAt != 'e') {
                break;
            }
            if (charAt == 'e' || charAt == '.') {
                z = false;
            }
            this.b++;
        }
        String substring = this.a.substring(i, this.b);
        if (!".".equals(substring)) {
            if (z) {
                vm2 = new vm2(substring, 1);
            } else {
                vm2 = new vm2(substring, 2);
            }
            this.c.g(vm2);
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        int i = this.b;
        String substring = this.a.substring(this.b, Math.min(i + 3, this.a.length()));
        if (substring.length() >= 3 && !jl1.a.containsKey(substring)) {
            substring = substring.substring(0, 2);
        }
        if (substring.length() >= 2 && !jl1.a.containsKey(substring)) {
            substring = substring.substring(0, 1);
        }
        if (!jl1.a.containsKey(substring)) {
            int min = Math.min(i + 1, this.a.length());
            WXLogUtils.e("weex", new IllegalArgumentException(this.a.substring(0, min) + " illegal code operator" + substring));
            this.b = this.b + substring.length();
            return;
        }
        if (!this.d.d() && this.d.e() != null) {
            if (jl1.a.get(this.d.e().a).intValue() >= jl1.a.get(substring).intValue()) {
                a(this.d.f());
            }
        }
        if (!jl1.j(substring)) {
            this.d.g(new kh2(substring, this.c.i()));
        }
        this.b += substring.length();
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        int i = this.b;
        v7 v7Var = new v7();
        char charAt = this.a.charAt(i);
        v7Var.g(Character.valueOf(charAt));
        StringBuilder sb = new StringBuilder();
        while (true) {
            this.b = i + 1;
            if (this.b >= this.a.length()) {
                break;
            }
            char charAt2 = this.a.charAt(this.b);
            if (charAt2 != charAt) {
                sb.append(charAt2);
            } else if (this.a.charAt(this.b - 1) != '\\') {
                v7Var.f();
                if (v7Var.i() == 0) {
                    this.b++;
                    break;
                }
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(charAt2);
            }
            i = this.b;
        }
        this.c.g(new vm2(sb.toString(), 3));
    }
}
