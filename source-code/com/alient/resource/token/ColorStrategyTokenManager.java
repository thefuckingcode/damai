package com.alient.resource.token;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.alient.resource.util.ColorUtil;
import com.alient.resource.util.ResUtil;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/alient/resource/token/ColorStrategyTokenManager;", "Lcom/alient/resource/token/StrategyTokenManager;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alient/resource/token/StrategyTokenJavaBean;", "raw", "parseTokenRaw", "(Landroid/content/Context;Lcom/alient/resource/token/StrategyTokenJavaBean;)Ljava/lang/Integer;", "<init>", "()V", "Companion", "oneresource_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ColorStrategyTokenManager extends StrategyTokenManager<Integer> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NOT_SUPPORT = -1;
    @NotNull
    private static final Lazy instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ColorStrategyTokenManager$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/alient/resource/token/ColorStrategyTokenManager$Companion;", "", "Lcom/alient/resource/token/ColorStrategyTokenManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/resource/token/ColorStrategyTokenManager;", "instance", "", "NOT_SUPPORT", "I", "<init>", "()V", "oneresource_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ColorStrategyTokenManager getInstance() {
            Lazy lazy = ColorStrategyTokenManager.instance$delegate;
            Companion companion = ColorStrategyTokenManager.Companion;
            return (ColorStrategyTokenManager) lazy.getValue();
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Override // com.alient.resource.token.StrategyTokenManager
    @NotNull
    public Integer parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        HashMap<String, Object> hashMap;
        int i;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(strategyTokenJavaBean, "raw");
        HashMap<String, HashMap<String, Object>> hashMap2 = strategyTokenJavaBean.value;
        int i2 = 0;
        if (!(hashMap2 == null || (hashMap = hashMap2.get(getDeviceType())) == null || hashMap.get("value") == null)) {
            String obj = toString();
            if (StringsKt__StringsKt.Q(obj, "$", false, 2, null)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring = obj.substring(1);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                i = ContextCompat.getColor(context, ResUtil.getIdentifier(context, substring, "color"));
            } else if (StringsKt__StringsKt.Q(obj, o70.DINAMIC_PREFIX_AT, false, 2, null)) {
                i2 = -1;
            } else {
                i = ColorUtil.parseColorSafely(obj);
            }
            i2 = i;
        }
        return Integer.valueOf(i2);
    }
}
