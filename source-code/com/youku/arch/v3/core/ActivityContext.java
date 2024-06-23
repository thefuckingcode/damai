package com.youku.arch.v3.core;

import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ContextImpl;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.event.Subject;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.kubus.EventBus;
import com.youku.kubus.EventBusBuilder;
import io.flutter.wpkbridge.WPKFactory;
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
import tb.k21;
import tb.wn;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b7\u00108B\u0011\b\u0016\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b7\u0010;J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001c\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R4\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0014\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%8V@VX\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+8V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001018V@VX\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/youku/arch/v3/core/ActivityContext;", "Lcom/youku/arch/v3/core/ContextWrapper;", "T", "Lkotlin/Function0;", "action", "Ltb/ur2;", "runOnUIThreadLocked", "runOnUIThread", "runOnLoaderThreadLocked", "runOnLoaderThread", "release", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "loaderCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "renderCoroutineScope", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", Subject.FRAGMENT, "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "pageContainer", "Lcom/youku/arch/v3/page/GenericFragment;", "getFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "componentCreatorManager", "getComponentCreatorManager", "()Lcom/youku/arch/v3/creator/ComponentCreatorManager;", "setComponentCreatorManager", "(Lcom/youku/arch/v3/creator/ComponentCreatorManager;)V", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "viewTypeSupport", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "setViewTypeSupport", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "Lcom/youku/arch/v3/core/EventDispatcher;", "eventDispatcher", "getEventDispatcher", "()Lcom/youku/arch/v3/core/EventDispatcher;", "setEventDispatcher", "(Lcom/youku/arch/v3/core/EventDispatcher;)V", "<init>", "()V", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "(Lcom/youku/arch/v3/core/IContext;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ActivityContext extends ContextWrapper {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    @NotNull
    private final CoroutineScope loaderCoroutineScope;
    @NotNull
    private final CoroutineScope renderCoroutineScope;

    /* JADX WARNING: Illegal instructions before constructor call */
    public ActivityContext() {
        super(r0.createContainerContext(r1));
        ContextImpl.Companion companion = ContextImpl.Companion;
        EventBus build = new EventBusBuilder().logNoSubscriberMessages(false).sendNoSubscriberEvent(false).loggable(false).name("activity").build();
        k21.h(build, "EventBusBuilder()\n      …\n                .build()");
        ActivityContext$special$$inlined$CoroutineExceptionHandler$1 activityContext$special$$inlined$CoroutineExceptionHandler$1 = new ActivityContext$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        this.coroutineExceptionHandler = activityContext$special$$inlined$CoroutineExceptionHandler$1;
        this.loaderCoroutineScope = wn.a(f90.a().plus(bh2.b(null, 1, null)).plus(activityContext$special$$inlined$CoroutineExceptionHandler$1));
        this.renderCoroutineScope = wn.a(f90.c().plus(bh2.b(null, 1, null)).plus(activityContext$special$$inlined$CoroutineExceptionHandler$1));
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ComponentCreatorManager getComponentCreatorManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-929877299")) {
            return super.getComponentCreatorManager();
        }
        return (ComponentCreatorManager) ipChange.ipc$dispatch("-929877299", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1911067040")) {
            return super.getConfigManager();
        }
        return (ConfigManager) ipChange.ipc$dispatch("1911067040", new Object[]{this});
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public EventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379777952")) {
            return (EventDispatcher) ipChange.ipc$dispatch("1379777952", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public GenericFragment getFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625543999")) {
            return (GenericFragment) ipChange.ipc$dispatch("1625543999", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130759382")) {
            return (IContainer) ipChange.ipc$dispatch("-1130759382", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    @Nullable
    public ViewTypeSupport getViewTypeSupport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-455932314")) {
            return (ViewTypeSupport) ipChange.ipc$dispatch("-455932314", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901649169")) {
            ipChange.ipc$dispatch("1901649169", new Object[]{this});
            return;
        }
        super.release();
        wn.c(this.loaderCoroutineScope, null, 1, null);
        wn.c(this.renderCoroutineScope, null, 1, null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThread(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855733208")) {
            ipChange.ipc$dispatch("855733208", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        Job unused = f.b(this.loaderCoroutineScope, null, null, new ActivityContext$runOnLoaderThread$1(function0, null), 3, null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnLoaderThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-381286546")) {
            ipChange.ipc$dispatch("-381286546", new Object[]{this, function0});
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
        if (AndroidInstantRuntime.support(ipChange, "-608867561")) {
            ipChange.ipc$dispatch("-608867561", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        Job unused = f.b(this.renderCoroutineScope, null, null, new ActivityContext$runOnUIThread$1(function0, null), 3, null);
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public <T> void runOnUIThreadLocked(@NotNull Function0<? extends T> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663573357")) {
            ipChange.ipc$dispatch("663573357", new Object[]{this, function0});
            return;
        }
        k21.i(function0, "action");
        if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            d.c(this.renderCoroutineScope.getCoroutineContext(), new ActivityContext$runOnUIThreadLocked$1(function0, null));
        }
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setComponentCreatorManager(@Nullable ComponentCreatorManager componentCreatorManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884100419")) {
            ipChange.ipc$dispatch("-884100419", new Object[]{this, componentCreatorManager});
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setConfigManager(@Nullable ConfigManager configManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214475280")) {
            ipChange.ipc$dispatch("-214475280", new Object[]{this, configManager});
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740748732")) {
            ipChange.ipc$dispatch("-740748732", new Object[]{this, eventDispatcher});
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setFragment(@Nullable GenericFragment genericFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032978175")) {
            ipChange.ipc$dispatch("-2032978175", new Object[]{this, genericFragment});
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setPageContainer(@Nullable IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513781428")) {
            ipChange.ipc$dispatch("-513781428", new Object[]{this, iContainer});
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.core.ContextWrapper, com.youku.arch.v3.core.IContext
    public void setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103281146")) {
            ipChange.ipc$dispatch("103281146", new Object[]{this, viewTypeSupport});
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityContext(@NotNull IContext iContext) {
        super(iContext);
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        ActivityContext$special$$inlined$CoroutineExceptionHandler$2 activityContext$special$$inlined$CoroutineExceptionHandler$2 = new ActivityContext$special$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.Key);
        this.coroutineExceptionHandler = activityContext$special$$inlined$CoroutineExceptionHandler$2;
        this.loaderCoroutineScope = wn.a(f90.a().plus(bh2.b(null, 1, null)).plus(activityContext$special$$inlined$CoroutineExceptionHandler$2));
        this.renderCoroutineScope = wn.a(f90.c().plus(bh2.b(null, 1, null)).plus(activityContext$special$$inlined$CoroutineExceptionHandler$2));
    }
}
