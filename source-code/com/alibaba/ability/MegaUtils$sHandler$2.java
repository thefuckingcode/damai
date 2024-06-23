package com.alibaba.ability;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/os/Handler;", "invoke", "()Landroid/os/Handler;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class MegaUtils$sHandler$2 extends Lambda implements Function0<Handler> {
    public static final MegaUtils$sHandler$2 INSTANCE = new MegaUtils$sHandler$2();

    MegaUtils$sHandler$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
