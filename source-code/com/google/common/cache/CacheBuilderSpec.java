package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
/* compiled from: Taobao */
public final class CacheBuilderSpec {

    /* compiled from: Taobao */
    private interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2);
    }
}
