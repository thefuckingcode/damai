package com.youku.arch.v3.token;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.DisplayUtil;
import com.youku.arch.v3.util.ResUtil;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;
import tb.o70;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/token/OpacityStrategyTokenManager;", "Lcom/youku/arch/v3/token/StrategyTokenManager;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "(Landroid/content/Context;Lcom/youku/arch/v3/token/StrategyTokenJavaBean;)Ljava/lang/Double;", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class OpacityStrategyTokenManager extends StrategyTokenManager<Double> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NOT_SUPPORT = -1;
    @NotNull
    private static final Lazy<OpacityStrategyTokenManager> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, OpacityStrategyTokenManager$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/token/OpacityStrategyTokenManager$Companion;", "", "Lcom/youku/arch/v3/token/OpacityStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/token/OpacityStrategyTokenManager;", "instance", "", "NOT_SUPPORT", "I", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final OpacityStrategyTokenManager getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1949233037")) {
                return (OpacityStrategyTokenManager) OpacityStrategyTokenManager.instance$delegate.getValue();
            }
            return (OpacityStrategyTokenManager) ipChange.ipc$dispatch("1949233037", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.token.StrategyTokenManager
    @NotNull
    public Double parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        HashMap<String, Object> hashMap;
        Object obj;
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1015140864")) {
            return (Double) ipChange.ipc$dispatch("-1015140864", new Object[]{this, context, strategyTokenJavaBean});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(strategyTokenJavaBean, "raw");
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        if (!(hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null || (obj = hashMap.get("value")) == null)) {
            String obj2 = obj.toString();
            if (StringsKt__StringsKt.Q(obj2, "$", false, 2, null)) {
                Resources resources = context.getResources();
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.String");
                String substring = obj2.substring(1);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                i = resources.getDimensionPixelOffset(ResUtil.getIdentifier(context, substring, TypedValues.Custom.S_INT));
            } else if (StringsKt__StringsKt.Q(obj2, o70.DINAMIC_PREFIX_AT, false, 2, null)) {
                i2 = -1;
            } else {
                i = DisplayUtil.px2dip(context, Integer.parseInt(obj2));
            }
            i2 = i;
        }
        return Double.valueOf(((double) i2) / 100.0d);
    }
}
