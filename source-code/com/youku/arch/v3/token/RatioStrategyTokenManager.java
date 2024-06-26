package com.youku.arch.v3.token;

import android.content.Context;
import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/token/RatioStrategyTokenManager;", "Lcom/youku/arch/v3/token/StrategyTokenManager;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "(Landroid/content/Context;Lcom/youku/arch/v3/token/StrategyTokenJavaBean;)Ljava/lang/Float;", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class RatioStrategyTokenManager extends StrategyTokenManager<Float> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NOT_SUPPORT = -1;
    @NotNull
    private static final Lazy<RatioStrategyTokenManager> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, RatioStrategyTokenManager$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/token/RatioStrategyTokenManager$Companion;", "", "Lcom/youku/arch/v3/token/RatioStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/token/RatioStrategyTokenManager;", "instance", "", "NOT_SUPPORT", "I", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final RatioStrategyTokenManager getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-168955827")) {
                return (RatioStrategyTokenManager) RatioStrategyTokenManager.instance$delegate.getValue();
            }
            return (RatioStrategyTokenManager) ipChange.ipc$dispatch("-168955827", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.token.StrategyTokenManager
    @NotNull
    public Float parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        HashMap<String, Object> hashMap;
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-26854679")) {
            return (Float) ipChange.ipc$dispatch("-26854679", new Object[]{this, context, strategyTokenJavaBean});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(strategyTokenJavaBean, "raw");
        float f2 = 0.0f;
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        if (!(hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null || hashMap.get("value") == null)) {
            String obj = toString();
            if (StringsKt__StringsKt.Q(obj, "$", false, 2, null)) {
                Resources resources = context.getResources();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring = obj.substring(1);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                f = (float) resources.getDimensionPixelOffset(ResUtil.getIdentifier(context, substring, Constants.DIMEN));
            } else if (StringsKt__StringsKt.Q(obj, o70.DINAMIC_PREFIX_AT, false, 2, null)) {
                f2 = -1.0f;
            } else {
                f = Float.parseFloat(obj);
            }
            f2 = f;
        }
        return Float.valueOf(f2);
    }
}
