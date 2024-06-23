package com.taobao.slide.control;

import android.text.TextUtils;
import com.taobao.slide.compare.ICompare;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.j81;
import tb.jl1;
import tb.uk;

/* compiled from: Taobao */
public class UnitParse {
    private static final Pattern d;
    private static final Map<String, OPERATOR> e = new HashMap();
    public String a;
    private String b;
    private OPERATOR c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum OPERATOR {
        EQUALS("="),
        GREATER_EQUALS(jl1.GE),
        LESS_EQUALS(jl1.LE),
        GREATER(jl1.G),
        LESS(jl1.L),
        NOT_EQUALS(jl1.NOT_EQUAL2),
        FUZZY("~="),
        NOT_FUZZY("!~"),
        IN("⊂"),
        NOT_IN("⊄");
        
        private String symbol;

        private OPERATOR(String str) {
            this.symbol = str;
        }

        public String getSymbol() {
            return this.symbol;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[OPERATOR.values().length];
            a = iArr;
            iArr[OPERATOR.EQUALS.ordinal()] = 1;
            a[OPERATOR.NOT_EQUALS.ordinal()] = 2;
            a[OPERATOR.GREATER.ordinal()] = 3;
            a[OPERATOR.GREATER_EQUALS.ordinal()] = 4;
            a[OPERATOR.LESS.ordinal()] = 5;
            a[OPERATOR.LESS_EQUALS.ordinal()] = 6;
            a[OPERATOR.FUZZY.ordinal()] = 7;
            a[OPERATOR.NOT_FUZZY.ordinal()] = 8;
            a[OPERATOR.IN.ordinal()] = 9;
            try {
                a[OPERATOR.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        OPERATOR[] values = OPERATOR.values();
        for (OPERATOR operator : values) {
            e.put(operator.getSymbol(), operator);
            arrayList.add(operator.getSymbol());
        }
        d = Pattern.compile(String.format("^\\s*(\\w+)\\s*(%s)\\s*(.+)\\s*$", uk.c(arrayList)));
    }

    private UnitParse(String str) {
        if ("ANY".equals(str) || "NONE".equals(str)) {
            this.a = str;
            return;
        }
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            this.a = matcher.group(1);
            this.c = e.get(matcher.group(2));
            this.b = matcher.group(3);
            if (this.a.equals("did_hash") && this.c != OPERATOR.EQUALS) {
                throw new IllegalArgumentException(String.format("invalid hash exp:%s", str));
            }
            return;
        }
        throw new IllegalArgumentException(String.format("fail parse exp:%s", str));
    }

    static UnitParse a(String str) {
        return new UnitParse(str);
    }

    /* access modifiers changed from: package-private */
    public boolean b(j81 j81) {
        if (this.a.equals("ANY")) {
            return true;
        }
        if (this.a.equals("NONE") || j81 == null || j81.a() == null) {
            return false;
        }
        ICompare a2 = j81.a();
        String c2 = j81.c();
        switch (a.a[this.c.ordinal()]) {
            case 1:
                return a2.equals(c2, this.b);
            case 2:
                return a2.equalsNot(c2, this.b);
            case 3:
                return a2.greater(c2, this.b);
            case 4:
                return a2.greaterEquals(c2, this.b);
            case 5:
                return a2.less(c2, this.b);
            case 6:
                return a2.lessEquals(c2, this.b);
            case 7:
                return a2.fuzzy(c2, this.b);
            case 8:
                return a2.fuzzyNot(c2, this.b);
            case 9:
                return a2.in(c2, this.b);
            case 10:
                return a2.notIn(c2, this.b);
            default:
                return false;
        }
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.a;
        OPERATOR operator = this.c;
        String str = "";
        objArr[1] = operator == null ? str : operator.getSymbol();
        if (!TextUtils.isEmpty(this.b)) {
            str = this.b;
        }
        objArr[2] = str;
        return String.format("%s%s%s", objArr);
    }
}
