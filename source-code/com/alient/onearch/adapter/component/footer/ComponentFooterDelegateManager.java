package com.alient.onearch.adapter.component.footer;

import android.util.SparseArray;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "", "", "pageName", "", "componentId", "Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegate;", "componentFooterDelegate", "Ltb/ur2;", "register", MiPushClient.COMMAND_UNREGISTER, "Landroid/util/SparseArray;", "getComponentFooterDelegates", "", "delegatesMap", "Ljava/util/Map;", "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ComponentFooterDelegateManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ComponentFooterDelegateManager$Companion$instance$2.INSTANCE);
    private final Map<String, SparseArray<ComponentFooterDelegate>> delegatesMap = new HashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager$Companion;", "", "Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/onearch/adapter/component/footer/ComponentFooterDelegateManager;", "instance", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ComponentFooterDelegateManager getInstance() {
            Lazy lazy = ComponentFooterDelegateManager.instance$delegate;
            Companion companion = ComponentFooterDelegateManager.Companion;
            return (ComponentFooterDelegateManager) lazy.getValue();
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Nullable
    public final SparseArray<ComponentFooterDelegate> getComponentFooterDelegates(@NotNull String str) {
        k21.i(str, "pageName");
        return this.delegatesMap.get(str);
    }

    public final void register(@NotNull String str, int i, @NotNull ComponentFooterDelegate componentFooterDelegate) {
        k21.i(str, "pageName");
        k21.i(componentFooterDelegate, "componentFooterDelegate");
        if (this.delegatesMap.containsKey(str)) {
            SparseArray<ComponentFooterDelegate> sparseArray = this.delegatesMap.get(str);
            if (sparseArray != null) {
                sparseArray.put(i, componentFooterDelegate);
                return;
            }
            return;
        }
        SparseArray<ComponentFooterDelegate> sparseArray2 = new SparseArray<>();
        sparseArray2.put(i, componentFooterDelegate);
        this.delegatesMap.put(str, sparseArray2);
    }

    public final void unregister(@NotNull String str) {
        k21.i(str, "pageName");
        this.delegatesMap.remove(str);
    }
}
