package tb;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import org.apache.commons.lang3.CharUtils;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class hl1 extends vm2 {
    public vm2 c;
    public vm2 d;
    public vm2 e;

    public hl1(String str, int i) {
        super(str, i);
    }

    @Override // tb.vm2
    public Object a(Object obj) {
        String b = b();
        b.hashCode();
        boolean z = false;
        char c2 = 65535;
        switch (b.hashCode()) {
            case 33:
                if (b.equals(jl1.AND_NOT)) {
                    c2 = 0;
                    break;
                }
                break;
            case 37:
                if (b.equals("%")) {
                    c2 = 1;
                    break;
                }
                break;
            case 42:
                if (b.equals(jl1.MUL)) {
                    c2 = 2;
                    break;
                }
                break;
            case 43:
                if (b.equals(jl1.PLUS)) {
                    c2 = 3;
                    break;
                }
                break;
            case 45:
                if (b.equals("-")) {
                    c2 = 4;
                    break;
                }
                break;
            case 46:
                if (b.equals(".")) {
                    c2 = 5;
                    break;
                }
                break;
            case 47:
                if (b.equals("/")) {
                    c2 = 6;
                    break;
                }
                break;
            case 60:
                if (b.equals(jl1.L)) {
                    c2 = 7;
                    break;
                }
                break;
            case 62:
                if (b.equals(jl1.G)) {
                    c2 = '\b';
                    break;
                }
                break;
            case 63:
                if (b.equals("?")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 91:
                if (b.equals(jl1.ARRAY_START_STR)) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1084:
                if (b.equals(jl1.NOT_EQUAL2)) {
                    c2 = 11;
                    break;
                }
                break;
            case INoCaptchaComponent.SG_NC_VERI_WUA_INCORRECT_DATA_FILE:
                if (b.equals(jl1.AND)) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1921:
                if (b.equals(jl1.LE)) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 1952:
                if (b.equals(jl1.EQUAL2)) {
                    c2 = 14;
                    break;
                }
                break;
            case 1983:
                if (b.equals(jl1.GE)) {
                    c2 = 15;
                    break;
                }
                break;
            case 3968:
                if (b.equals(jl1.OR)) {
                    c2 = 16;
                    break;
                }
                break;
            case 33665:
                if (b.equals(jl1.NOT_EQUAL)) {
                    c2 = 17;
                    break;
                }
                break;
            case 60573:
                if (b.equals(jl1.EQUAL)) {
                    c2 = 18;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Boolean.valueOf(!jl1.r(this.c, obj));
            case 1:
                return jl1.l(this.d, this.e, obj);
            case 2:
                return jl1.m(this.d, this.e, obj);
            case 3:
                return jl1.n(this.d, this.e, obj);
            case 4:
                return jl1.p(this.d, this.e, obj);
            case 5:
            case '\n':
                return jl1.c(this.d, this.e, obj);
            case 6:
                return jl1.b(this.d, this.e, obj);
            case 7:
                if (jl1.q(this.d, obj) < jl1.q(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case '\b':
                if (jl1.q(this.d, obj) > jl1.q(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case '\t':
                return jl1.a(this.c, this.d, this.e, obj);
            case 11:
            case 17:
                return Boolean.valueOf(!jl1.h(this.d, this.e, obj));
            case '\f':
                if (jl1.r(this.d, obj) && jl1.r(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case '\r':
                if (jl1.q(this.d, obj) <= jl1.q(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 14:
            case 18:
                return Boolean.valueOf(jl1.h(this.d, this.e, obj));
            case 15:
                if (jl1.q(this.d, obj) >= jl1.q(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 16:
                if (jl1.r(this.d, obj) || jl1.r(this.e, obj)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            default:
                throw new IllegalArgumentException(b + " operator is not supported");
        }
    }

    @Override // tb.vm2
    public String toString() {
        if (jl1.AND_NOT.equals(b())) {
            return "{!" + this.c + "}";
        } else if (this.c == null) {
            return jl1.BLOCK_START_STR + this.d + b() + this.e + "}";
        } else {
            return jl1.BLOCK_START_STR + this.c + b() + this.d + ":" + this.e + "}";
        }
    }
}
