package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class b {
    b() {
    }

    public static b compile(String str) {
        return f.a(str);
    }

    public static boolean isPcreLike() {
        return f.d();
    }

    public abstract int flags();

    public abstract a matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
