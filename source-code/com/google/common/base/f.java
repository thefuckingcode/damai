package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
final class f {
    private static final PatternCompiler a = c();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b implements PatternCompiler {
        private b() {
        }

        @Override // com.google.common.base.PatternCompiler
        public b compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }
    }

    static {
        Logger.getLogger(f.class.getName());
    }

    private f() {
    }

    static b a(String str) {
        ds1.p(str);
        return a.compile(str);
    }

    static String b(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    private static PatternCompiler c() {
        return new b();
    }

    static boolean d() {
        return a.isPcreLike();
    }

    static boolean e(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static long f() {
        return System.nanoTime();
    }
}
