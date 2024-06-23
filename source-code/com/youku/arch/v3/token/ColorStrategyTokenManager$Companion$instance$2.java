package com.youku.arch.v3.token;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/token/ColorStrategyTokenManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ColorStrategyTokenManager$Companion$instance$2 extends Lambda implements Function0<ColorStrategyTokenManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ColorStrategyTokenManager$Companion$instance$2 INSTANCE = new ColorStrategyTokenManager$Companion$instance$2();

    ColorStrategyTokenManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ColorStrategyTokenManager invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1579722879")) {
            return new ColorStrategyTokenManager();
        }
        return (ColorStrategyTokenManager) ipChange.ipc$dispatch("1579722879", new Object[]{this});
    }
}
