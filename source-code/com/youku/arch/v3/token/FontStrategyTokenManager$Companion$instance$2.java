package com.youku.arch.v3.token;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/token/FontStrategyTokenManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class FontStrategyTokenManager$Companion$instance$2 extends Lambda implements Function0<FontStrategyTokenManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final FontStrategyTokenManager$Companion$instance$2 INSTANCE = new FontStrategyTokenManager$Companion$instance$2();

    FontStrategyTokenManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final FontStrategyTokenManager invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1335031135")) {
            return new FontStrategyTokenManager();
        }
        return (FontStrategyTokenManager) ipChange.ipc$dispatch("-1335031135", new Object[]{this});
    }
}
