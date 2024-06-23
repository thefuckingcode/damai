package tb;

import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.ability.middleware.IAbilityInvoker;
import com.alibaba.ability.middleware.IAbilityMiddleware;
import com.taobao.analysis.v3.FalcoSpanLayer;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.AbstractEditComponent;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class td1 implements IAbilityInvoker {
    @NotNull
    public static final a Companion = new a(null);
    private final IAbilityMiddleware a;
    private final IAbilityInvoker b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        @JvmStatic
        @NotNull
        public final IAbilityInvoker a(@NotNull List<? extends IAbilityMiddleware> list, @NotNull IAbilityInvoker iAbilityInvoker) {
            k21.i(list, "middlewares");
            k21.i(iAbilityInvoker, "final");
            for (IAbilityMiddleware iAbilityMiddleware : CollectionsKt___CollectionsKt.m0(list)) {
                iAbilityInvoker = new td1(iAbilityMiddleware, iAbilityInvoker);
            }
            return iAbilityInvoker;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public td1(@NotNull IAbilityMiddleware iAbilityMiddleware, @NotNull IAbilityInvoker iAbilityInvoker) {
        k21.i(iAbilityMiddleware, "middleware");
        k21.i(iAbilityInvoker, AbstractEditComponent.ReturnTypes.NEXT);
        this.a = iAbilityMiddleware;
        this.b = iAbilityInvoker;
    }

    @Override // com.alibaba.ability.middleware.IAbilityInvoker
    @Nullable
    public lf0 invoke(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
        k21.i(str, FalcoSpanLayer.ABILITY);
        k21.i(str2, "api");
        k21.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(map, "params");
        k21.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
        return this.a.invoke(str, str2, iAbilityContext, map, iOnCallbackListener, this.b);
    }
}
