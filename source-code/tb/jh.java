package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class jh implements Predicate<Character> {

    /* compiled from: Taobao */
    static abstract class a extends jh {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return jh.super.b(ch);
        }
    }

    /* compiled from: Taobao */
    private static final class b extends a {
        private final char a;
        private final char b;

        b(char c, char c2) {
            ds1.d(c2 >= c);
            this.a = c;
            this.b = c2;
        }

        @Override // tb.jh
        public boolean f(char c) {
            return this.a <= c && c <= this.b;
        }

        public String toString() {
            return "CharMatcher.inRange('" + jh.g(this.a) + "', '" + jh.g(this.b) + "')";
        }
    }

    /* compiled from: Taobao */
    private static final class c extends a {
        private final char a;

        c(char c) {
            this.a = c;
        }

        @Override // tb.jh
        public boolean f(char c) {
            return c == this.a;
        }

        public String toString() {
            return "CharMatcher.is('" + jh.g(this.a) + "')";
        }
    }

    protected jh() {
    }

    public static jh c(char c2, char c3) {
        return new b(c2, c3);
    }

    public static jh e(char c2) {
        return new c(c2);
    }

    /* access modifiers changed from: private */
    public static String g(char c2) {
        char[] cArr = {d80.TokenESC, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return f(ch.charValue());
    }

    public int d(CharSequence charSequence, int i) {
        int length = charSequence.length();
        ds1.t(i, length);
        while (i < length) {
            if (f(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean f(char c2);
}
