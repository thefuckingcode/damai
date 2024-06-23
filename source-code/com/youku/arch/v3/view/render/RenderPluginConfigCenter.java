package com.youku.arch.v3.view.render;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.vivo.push.PushClientConstants;
import com.youku.arch.v3.core.IContext;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/youku/arch/v3/view/render/RenderPluginConfigCenter;", "", "", "pageName", "type", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "renderPluginFactory", "Ltb/ur2;", "setSupportRenderPlugin", PushClientConstants.TAG_CLASS_NAME, "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "", "isSupportRenderPlugin", "getRenderPluginFactory", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class RenderPluginConfigCenter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<RenderPluginConfigCenter> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, RenderPluginConfigCenter$Companion$instance$2.INSTANCE);
    private static HashMap<String, RenderPluginConfig> renderPluginConfigMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R6\u0010\f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/view/render/RenderPluginConfigCenter$Companion;", "", "Lcom/youku/arch/v3/view/render/RenderPluginConfigCenter;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/view/render/RenderPluginConfigCenter;", "instance", "Ljava/util/HashMap;", "", "Lcom/youku/arch/v3/view/render/RenderPluginConfig;", "Lkotlin/collections/HashMap;", "renderPluginConfigMap", "Ljava/util/HashMap;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final RenderPluginConfigCenter getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-787622109")) {
                return (RenderPluginConfigCenter) RenderPluginConfigCenter.instance$delegate.getValue();
            }
            return (RenderPluginConfigCenter) ipChange.ipc$dispatch("-787622109", new Object[]{this});
        }
    }

    public RenderPluginConfigCenter() {
        renderPluginConfigMap = new HashMap<>();
    }

    @Nullable
    public final RenderPluginFactory getRenderPluginFactory(@Nullable String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-126455226")) {
            return (RenderPluginFactory) ipChange.ipc$dispatch("-126455226", new Object[]{this, str, str2});
        }
        k21.i(str2, "type");
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            str = RenderConstant.GLOBAL;
        }
        HashMap<String, RenderPluginConfig> hashMap = renderPluginConfigMap;
        if (hashMap == null) {
            k21.A("renderPluginConfigMap");
            hashMap = null;
        }
        RenderPluginConfig renderPluginConfig = hashMap.get(str);
        if (renderPluginConfig == null) {
            return null;
        }
        return renderPluginConfig.getRenderPluginFactory(str2);
    }

    public final boolean isSupportRenderPlugin(@NotNull IContext iContext, @Nullable String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1086000443")) {
            return ((Boolean) ipChange.ipc$dispatch("-1086000443", new Object[]{this, iContext, str, str2})).booleanValue();
        }
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str2, "type");
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            str = RenderConstant.GLOBAL;
        }
        HashMap<String, RenderPluginConfig> hashMap = renderPluginConfigMap;
        HashMap<String, RenderPluginConfig> hashMap2 = null;
        if (hashMap == null) {
            k21.A("renderPluginConfigMap");
            hashMap = null;
        }
        if (!hashMap.containsKey(str)) {
            return false;
        }
        HashMap<String, RenderPluginConfig> hashMap3 = renderPluginConfigMap;
        if (hashMap3 == null) {
            k21.A("renderPluginConfigMap");
        } else {
            hashMap2 = hashMap3;
        }
        RenderPluginConfig renderPluginConfig = hashMap2.get(str);
        if (renderPluginConfig == null) {
            return false;
        }
        return renderPluginConfig.isSupportRenderPlugin(iContext, str2);
    }

    public final void setSupportRenderPlugin(@Nullable String str, @NotNull String str2, @NotNull RenderPluginFactory renderPluginFactory) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "154647053")) {
            ipChange.ipc$dispatch("154647053", new Object[]{this, str, str2, renderPluginFactory});
            return;
        }
        k21.i(str2, "type");
        k21.i(renderPluginFactory, "renderPluginFactory");
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            str = RenderConstant.GLOBAL;
        }
        HashMap<String, RenderPluginConfig> hashMap = renderPluginConfigMap;
        HashMap<String, RenderPluginConfig> hashMap2 = null;
        if (hashMap == null) {
            k21.A("renderPluginConfigMap");
            hashMap = null;
        }
        if (!hashMap.containsKey(str)) {
            HashMap<String, RenderPluginConfig> hashMap3 = renderPluginConfigMap;
            if (hashMap3 == null) {
                k21.A("renderPluginConfigMap");
                hashMap3 = null;
            }
            hashMap3.put(str, new RenderPluginConfig());
        }
        HashMap<String, RenderPluginConfig> hashMap4 = renderPluginConfigMap;
        if (hashMap4 == null) {
            k21.A("renderPluginConfigMap");
        } else {
            hashMap2 = hashMap4;
        }
        RenderPluginConfig renderPluginConfig = hashMap2.get(str);
        if (renderPluginConfig != null) {
            renderPluginConfig.setSupportRenderPlugin(str2, renderPluginFactory);
        }
    }

    @Nullable
    public final RenderPluginFactory getRenderPluginFactory(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049064188")) {
            return (RenderPluginFactory) ipChange.ipc$dispatch("1049064188", new Object[]{this, str});
        }
        k21.i(str, "type");
        return getRenderPluginFactory(RenderConstant.GLOBAL, str);
    }

    public final boolean isSupportRenderPlugin(@NotNull IContext iContext, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281222843")) {
            return ((Boolean) ipChange.ipc$dispatch("1281222843", new Object[]{this, iContext, str})).booleanValue();
        }
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "type");
        return isSupportRenderPlugin(iContext, RenderConstant.GLOBAL, str);
    }

    public final void setSupportRenderPlugin(@NotNull String str, @NotNull RenderPluginFactory renderPluginFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220324137")) {
            ipChange.ipc$dispatch("-1220324137", new Object[]{this, str, renderPluginFactory});
            return;
        }
        k21.i(str, "type");
        k21.i(renderPluginFactory, "renderPluginFactory");
        setSupportRenderPlugin(RenderConstant.GLOBAL, str, renderPluginFactory);
    }

    public final void setSupportRenderPlugin(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1691042969")) {
            ipChange.ipc$dispatch("1691042969", new Object[]{this, str, str2, str3});
            return;
        }
        k21.i(str2, "type");
        k21.i(str3, PushClientConstants.TAG_CLASS_NAME);
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            str = RenderConstant.GLOBAL;
        }
        HashMap<String, RenderPluginConfig> hashMap = renderPluginConfigMap;
        HashMap<String, RenderPluginConfig> hashMap2 = null;
        if (hashMap == null) {
            k21.A("renderPluginConfigMap");
            hashMap = null;
        }
        if (!hashMap.containsKey(str)) {
            HashMap<String, RenderPluginConfig> hashMap3 = renderPluginConfigMap;
            if (hashMap3 == null) {
                k21.A("renderPluginConfigMap");
                hashMap3 = null;
            }
            hashMap3.put(str, new RenderPluginConfig());
        }
        HashMap<String, RenderPluginConfig> hashMap4 = renderPluginConfigMap;
        if (hashMap4 == null) {
            k21.A("renderPluginConfigMap");
        } else {
            hashMap2 = hashMap4;
        }
        RenderPluginConfig renderPluginConfig = hashMap2.get(str);
        if (renderPluginConfig != null) {
            renderPluginConfig.setSupportRenderPlugin(str2, str3);
        }
    }

    public final void setSupportRenderPlugin(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885423985")) {
            ipChange.ipc$dispatch("-885423985", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "type");
        k21.i(str2, PushClientConstants.TAG_CLASS_NAME);
        setSupportRenderPlugin(RenderConstant.GLOBAL, str, str2);
    }
}
