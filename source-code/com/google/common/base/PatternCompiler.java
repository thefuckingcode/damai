package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public interface PatternCompiler {
    b compile(String str);

    boolean isPcreLike();
}
