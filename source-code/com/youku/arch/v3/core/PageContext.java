package com.youku.arch.v3.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.EventBus;
import com.youku.kubus.EventBusBuilder;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bh2;
import tb.f90;
import tb.j41;
import tb.k21;
import tb.m40;
import tb.ur2;
import tb.wn;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 2\u00020\u00012\u00020\u0002:\u0001B\t\b\u0016¢\u0006\u0004\b}\u0010~B\u0013\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b}\u0010.J\u001c\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8V@\u0016X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR2\u0010T\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010R8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u0004\u0018\u00010Z8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010b\u001a\u0004\u0018\u00010a8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010i\u001a\u0004\u0018\u00010h8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u0004\u0018\u00010o8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010{¨\u0006\u0001"}, d2 = {"Lcom/youku/arch/v3/core/PageContext;", "Lcom/youku/arch/v3/core/ContextWrapper;", "Lcom/youku/arch/v3/core/IContext;", "T", "Lkotlin/Function0;", "action", "Ltb/ur2;", "runOnUIThreadLocked", "runOnUIThread", "runOnLoaderThreadLocked", "runOnLoaderThread", "release", "Landroid/app/Application;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "Lcom/youku/arch/v3/page/GenericFragment;", Subject.FRAGMENT, "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "Lcom/youku/arch/v3/IContainer;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "baseContext", "Lcom/youku/arch/v3/core/IContext;", "getBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "componentCreatorManager", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "viewTypeSupport", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Ljava/util/concurrent/ConcurrentMap;", "", "concurrentMap", "Ljava/util/concurrent/ConcurrentMap;", "getConcurrentMap", "()Ljava/util/concurrent/ConcurrentMap;", "setConcurrentMap", "(Ljava/util/concurrent/ConcurrentMap;)V", "Lcom/youku/kubus/EventBus;", "eventBus", "Lcom/youku/kubus/EventBus;", "getEventBus", "()Lcom/youku/kubus/EventBus;", "setEventBus", "(Lcom/youku/kubus/EventBus;)V", "Lcom/youku/arch/v3/core/EventDispatcher;", "eventDispatcher", "Lcom/youku/arch/v3/core/EventDispatcher;", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "Lcom/youku/arch/v3/core/ActivityValue;", "activityValue", "Lcom/youku/arch/v3/core/ActivityValue;", "getActivityValue", "()Lcom/youku/arch/v3/core/ActivityValue;", "setActivityValue", "(Lcom/youku/arch/v3/core/ActivityValue;)V", "Lcom/youku/arch/v3/style/StyleManager;", "styleManager", "Lcom/youku/arch/v3/style/StyleManager;", "getStyleManager", "()Lcom/youku/arch/v3/style/StyleManager;", "setStyleManager", "(Lcom/youku/arch/v3/style/StyleManager;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "loaderCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "renderCoroutineScope", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContext extends ContextWrapper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.PageContext";
    @Nullable
    private Activity activity;
    @Nullable
    private ActivityValue activityValue;
    @Nullable
    private Application application;
    @Nullable
    private IContext baseContext;
    @Nullable
    private Bundle bundle;
    @Nullable
    private ComponentCreatorManager componentCreatorManager;
    @Nullable
    private ConcurrentMap<String, Object> concurrentMap;
    @Nullable
    private ConfigManager configManager;
    @NotNull
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    @Nullable
    private EventBus eventBus;
    @Nullable
    private EventDispatcher eventDispatcher;
    @Nullable
    private GenericFragment fragment;
    @NotNull
    private final CoroutineScope loaderCoroutineScope;
    @Nullable
    private IContainer<ModelValue> pageContainer;
    @Nullable
    private String pageName;
    @NotNull
    private final CoroutineScope renderCoroutineScope;
    @Nullable
    private StyleManager styleManager;
    @Nullable
    private ViewTypeSupport viewTypeSupport;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/PageContext$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public PageContext() {
        this(null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1117284555")) {
            return this.activity;
        }
        return (Activity) ipChange.ipc$dispatch("-1117284555", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ActivityValue getActivityValue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1550738560")) {
            return this.activityValue;
        }
        return (ActivityValue) ipChange.ipc$dispatch("1550738560", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763067271")) {
            return this.application;
        }
        return (Application) ipChange.ipc$dispatch("1763067271", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public IContext getBaseContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1160520398")) {
            return this.baseContext;
        }
        return (IContext) ipChange.ipc$dispatch("-1160520398", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public Bundle getBundle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1850963196")) {
            return this.bundle;
        }
        return (Bundle) ipChange.ipc$dispatch("-1850963196", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ComponentCreatorManager getComponentCreatorManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "898338765")) {
            return this.componentCreatorManager;
        }
        return (ComponentCreatorManager) ipChange.ipc$dispatch("898338765", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ConcurrentMap<String, Object> getConcurrentMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1062003371")) {
            return this.concurrentMap;
        }
        return (ConcurrentMap) ipChange.ipc$dispatch("-1062003371", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "64279712")) {
            return this.configManager;
        }
        return (ConfigManager) ipChange.ipc$dispatch("64279712", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public EventBus getEventBus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396757462")) {
            return this.eventBus;
        }
        return (EventBus) ipChange.ipc$dispatch("1396757462", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public EventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1102020448")) {
            return this.eventDispatcher;
        }
        return (EventDispatcher) ipChange.ipc$dispatch("-1102020448", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public GenericFragment getFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-787058113")) {
            return this.fragment;
        }
        return (GenericFragment) ipChange.ipc$dispatch("-787058113", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1267122646")) {
            return this.pageContainer;
        }
        return (IContainer) ipChange.ipc$dispatch("-1267122646", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1024752344")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("1024752344", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public StyleManager getStyleManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1385862520")) {
            return this.styleManager;
        }
        return (StyleManager) ipChange.ipc$dispatch("1385862520", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ViewTypeSupport getViewTypeSupport() {
        ConfigManager configManager2;
        String pathConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145033370")) {
            return (ViewTypeSupport) ipChange.ipc$dispatch("-2145033370", new Object[]{this});
        }
        if (!(this.viewTypeSupport != null || (configManager2 = getConfigManager()) == null || (pathConfig = configManager2.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null)) {
            this.viewTypeSupport = ViewTypeSupport.Companion.getInstance(pathConfig);
        }
        return this.viewTypeSupport;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982360047")) {
            ipChange.ipc$dispatch("-982360047", new Object[]{this});
            return;
        }
        String str = null;
        wn.c(this.loaderCoroutineScope, null, 1, null);
        wn.c(this.renderCoroutineScope, null, 1, null);
        if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("page context [");
            EventBus eventBus2 = getEventBus();
            if (eventBus2 != null) {
                str = eventBus2.getChannelId();
            }
            sb.append((Object) str);
            sb.append("] released");
            objArr[0] = sb.toString();
            LogUtil.v(TAG, objArr);
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746113320")) {
            ipChange.ipc$dispatch("-746113320", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        Job unused = f.b(this.loaderCoroutineScope, null, null, new PageContext$runOnLoaderThread$1(function0, null), 3, null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322415506")) {
            ipChange.ipc$dispatch("-1322415506", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            runOnLoaderThread(function0);
        } else {
            function0.invoke();
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnUIThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745230825")) {
            ipChange.ipc$dispatch("-745230825", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        if (j41.i(this.renderCoroutineScope.getCoroutineContext())) {
            Job unused = f.b(this.renderCoroutineScope, null, null, new PageContext$runOnUIThread$1(function0, null), 3, null);
            return;
        }
        EventDispatcher eventDispatcher2 = getEventDispatcher();
        if (eventDispatcher2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", "coroutineContext not active");
            ur2 ur2 = ur2.INSTANCE;
            eventDispatcher2.dispatchEvent(ArchExceptionEvent.COROUTINE_RUN_FAILED, hashMap);
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1112648083")) {
            ipChange.ipc$dispatch("-1112648083", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else if (j41.i(this.renderCoroutineScope.getCoroutineContext())) {
            d.c(this.renderCoroutineScope.getCoroutineContext(), new PageContext$runOnUIThreadLocked$1(function0, null));
        } else {
            EventDispatcher eventDispatcher2 = getEventDispatcher();
            if (eventDispatcher2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("errorMsg", "coroutineContext not active");
                ur2 ur2 = ur2.INSTANCE;
                eventDispatcher2.dispatchEvent(ArchExceptionEvent.COROUTINE_RUN_FAILED, hashMap);
            }
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setActivity(@Nullable Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578561753")) {
            ipChange.ipc$dispatch("1578561753", new Object[]{this, activity2});
            return;
        }
        this.activity = activity2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setActivityValue(@Nullable ActivityValue activityValue2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871375426")) {
            ipChange.ipc$dispatch("871375426", new Object[]{this, activityValue2});
            return;
        }
        this.activityValue = activityValue2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setApplication(@Nullable Application application2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561938331")) {
            ipChange.ipc$dispatch("1561938331", new Object[]{this, application2});
            return;
        }
        this.application = application2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83995746")) {
            ipChange.ipc$dispatch("83995746", new Object[]{this, iContext});
            return;
        }
        this.baseContext = iContext;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setBundle(@Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023202400")) {
            ipChange.ipc$dispatch("-2023202400", new Object[]{this, bundle2});
            return;
        }
        this.bundle = bundle2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43977283")) {
            ipChange.ipc$dispatch("-43977283", new Object[]{this, componentCreatorManager2});
            return;
        }
        this.componentCreatorManager = componentCreatorManager2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setConcurrentMap(@Nullable ConcurrentMap<String, Object> concurrentMap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284730289")) {
            ipChange.ipc$dispatch("284730289", new Object[]{this, concurrentMap2});
            return;
        }
        this.concurrentMap = concurrentMap2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setConfigManager(@Nullable ConfigManager configManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630307600")) {
            ipChange.ipc$dispatch("-1630307600", new Object[]{this, configManager2});
            return;
        }
        this.configManager = configManager2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setEventBus(@Nullable EventBus eventBus2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706712172")) {
            ipChange.ipc$dispatch("706712172", new Object[]{this, eventBus2});
            return;
        }
        this.eventBus = eventBus2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367087804")) {
            ipChange.ipc$dispatch("-367087804", new Object[]{this, eventDispatcher2});
            return;
        }
        this.eventDispatcher = eventDispatcher2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485767681")) {
            ipChange.ipc$dispatch("485767681", new Object[]{this, genericFragment});
            return;
        }
        this.fragment = genericFragment;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setPageContainer(@Nullable IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446075316")) {
            ipChange.ipc$dispatch("-446075316", new Object[]{this, iContainer});
            return;
        }
        this.pageContainer = iContainer;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820223750")) {
            ipChange.ipc$dispatch("1820223750", new Object[]{this, str});
            return;
        }
        this.pageName = str;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setStyleManager(@Nullable StyleManager styleManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385736418")) {
            ipChange.ipc$dispatch("1385736418", new Object[]{this, styleManager2});
            return;
        }
        this.styleManager = styleManager2;
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719244038")) {
            ipChange.ipc$dispatch("-719244038", new Object[]{this, viewTypeSupport2});
            return;
        }
        this.viewTypeSupport = viewTypeSupport2;
    }

    public PageContext(@Nullable IContext iContext) {
        super(iContext);
        PageContext$special$$inlined$CoroutineExceptionHandler$1 pageContext$special$$inlined$CoroutineExceptionHandler$1 = new PageContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        this.coroutineExceptionHandler = pageContext$special$$inlined$CoroutineExceptionHandler$1;
        String str = null;
        this.loaderCoroutineScope = wn.a(f90.a().plus(bh2.b(null, 1, null)).plus(pageContext$special$$inlined$CoroutineExceptionHandler$1));
        this.renderCoroutineScope = wn.a(f90.c().plus(bh2.b(null, 1, null)).plus(pageContext$special$$inlined$CoroutineExceptionHandler$1));
        setEventBus(new EventBusBuilder().logNoSubscriberMessages(false).sendNoSubscriberEvent(false).loggable(false).name("page").build());
        setBundle(new Bundle());
        setConcurrentMap(new ConcurrentHashMap());
        setEventDispatcher(new EventDispatcher(this));
        setComponentCreatorManager(new ComponentCreatorManager());
        if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("page context [");
            EventBus eventBus2 = getEventBus();
            sb.append((Object) (eventBus2 != null ? eventBus2.getChannelId() : str));
            sb.append("] created");
            objArr[0] = sb.toString();
            LogUtil.v(TAG, objArr);
        }
    }
}
