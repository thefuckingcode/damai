package com.youku.gaiax.impl.utils;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0005\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/impl/utils/GaiaXUtils;", "", "", "isAppPublishVersion$delegate", "Lkotlin/Lazy;", "isAppPublishVersion", "()Z", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXUtils {
    @NotNull
    public static final GaiaXUtils INSTANCE = new GaiaXUtils();
    @NotNull
    private static final Lazy isAppPublishVersion$delegate = b.b(GaiaXUtils$isAppPublishVersion$2.INSTANCE);

    private GaiaXUtils() {
    }

    public final boolean isAppPublishVersion() {
        return ((Boolean) isAppPublishVersion$delegate.getValue()).booleanValue();
    }
}
