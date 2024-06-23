package com.alient.resource.token;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/alient/resource/token/RatioStrategyTokenManager;", "invoke", "()Lcom/alient/resource/token/RatioStrategyTokenManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class RatioStrategyTokenManager$Companion$instance$2 extends Lambda implements Function0<RatioStrategyTokenManager> {
    public static final RatioStrategyTokenManager$Companion$instance$2 INSTANCE = new RatioStrategyTokenManager$Companion$instance$2();

    RatioStrategyTokenManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final RatioStrategyTokenManager invoke() {
        return new RatioStrategyTokenManager();
    }
}
