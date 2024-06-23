package com.youku.arch.v3.token;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "Lcom/youku/arch/v3/token/StrategyTokenManager;", "Lcom/youku/arch/v3/token/SizeTokenValue;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class SizeStrategyTokenManager extends StrategyTokenManager<SizeTokenValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<SizeStrategyTokenManager> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, SizeStrategyTokenManager$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/token/SizeStrategyTokenManager$Companion;", "", "Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/token/SizeStrategyTokenManager;", "instance", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final SizeStrategyTokenManager getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1565395325")) {
                return (SizeStrategyTokenManager) SizeStrategyTokenManager.instance$delegate.getValue();
            }
            return (SizeStrategyTokenManager) ipChange.ipc$dispatch("-1565395325", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.token.StrategyTokenManager
    @NotNull
    public SizeTokenValue parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        HashMap<String, Object> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241097245")) {
            return (SizeTokenValue) ipChange.ipc$dispatch("1241097245", new Object[]{this, context, strategyTokenJavaBean});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(strategyTokenJavaBean, "raw");
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        SizeTokenValue sizeTokenValue = null;
        Object obj = (hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null) ? null : hashMap.get("value");
        SizeTokenValue sizeTokenValue2 = obj instanceof SizeTokenValue ? (SizeTokenValue) obj : null;
        if (sizeTokenValue2 != null) {
            sizeTokenValue = sizeTokenValue2;
        }
        return sizeTokenValue == null ? new SizeTokenValue() : sizeTokenValue;
    }
}
