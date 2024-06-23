package com.youku.gaiax.impl.js;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.utils.GaiaXWorkerExecutor;
import com.youku.gaiax.provider.module.js.JSDelegate;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/youku/gaiax/impl/js/GaiaXJSDelegate;", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "Ltb/ur2;", "initJSDelegate", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "registerComponentTask", "unregisterComponentTask", "onReadyComponentTask", "onReuseComponentTask", "onShowComponentTask", "onHiddenComponentTask", "onDestroyComponentTask", "Landroid/content/Context;", "Lkotlin/Function0;", WXBridgeManager.METHOD_CALLBACK, "startEngine", "registerComponent", "unregisterComponent", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "Lcom/alibaba/fastjson/JSONObject;", "data", "onLoadMoreComponent", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "dispatcherEvent", "dispatcherNativeMessageEvent", "", "isEngineStarted", "Z", "isEngineStarting", "instance", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "isInitDelegate", "", "Lcom/youku/gaiax/impl/js/GaiaXJSDelegate$PendingTask;", "pendingTask", "Ljava/util/List;", "<init>", "()V", "PendingTask", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJSDelegate implements IJSDelegate {
    @NotNull
    public static final GaiaXJSDelegate INSTANCE = new GaiaXJSDelegate();
    @Nullable
    private static IJSDelegate instance;
    private static boolean isEngineStarted;
    private static boolean isEngineStarting;
    private static boolean isInitDelegate;
    @NotNull
    private static final List<PendingTask> pendingTask = new CopyOnWriteArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/impl/js/GaiaXJSDelegate$PendingTask;", "", "", "component1", "Lkotlin/Function0;", "Ltb/ur2;", "component2", "name", "task", by0.ARG_COPY, "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function0;", "getTask", "()Lkotlin/jvm/functions/Function0;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class PendingTask {
        @NotNull
        private final String name;
        @NotNull
        private final Function0<ur2> task;

        public PendingTask(@NotNull String str, @NotNull Function0<ur2> function0) {
            k21.i(str, "name");
            k21.i(function0, "task");
            this.name = str;
            this.task = function0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.youku.gaiax.impl.js.GaiaXJSDelegate$PendingTask */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingTask copy$default(PendingTask pendingTask, String str, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingTask.name;
            }
            if ((i & 2) != 0) {
                function0 = pendingTask.task;
            }
            return pendingTask.copy(str, function0);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final Function0<ur2> component2() {
            return this.task;
        }

        @NotNull
        public final PendingTask copy(@NotNull String str, @NotNull Function0<ur2> function0) {
            k21.i(str, "name");
            k21.i(function0, "task");
            return new PendingTask(str, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PendingTask)) {
                return false;
            }
            PendingTask pendingTask = (PendingTask) obj;
            return k21.d(this.name, pendingTask.name) && k21.d(this.task, pendingTask.task);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Function0<ur2> getTask() {
            return this.task;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.task.hashCode();
        }

        @NotNull
        public String toString() {
            return "PendingTask(name=" + this.name + ", task=" + this.task + ')';
        }
    }

    private GaiaXJSDelegate() {
    }

    private final void initJSDelegate() {
        if (!isInitDelegate && instance == null) {
            IJSDelegate iJSDelegate = null;
            try {
                JSDelegate.Companion companion = JSDelegate.Companion;
                Method declaredMethod = JSDelegate.class.getDeclaredMethod("getJSDelegate", new Class[0]);
                isInitDelegate = true;
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof IJSDelegate) {
                    iJSDelegate = (IJSDelegate) invoke;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            instance = iJSDelegate;
        }
    }

    /* access modifiers changed from: private */
    public final void onDestroyComponentTask(GaiaXContext gaiaXContext) {
        gaiaXContext.setJsStatus(6);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.onDestroyComponent(gaiaXContext);
        }
    }

    /* access modifiers changed from: private */
    public final void onHiddenComponentTask(GaiaXContext gaiaXContext) {
        gaiaXContext.setJsStatus(5);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.onHiddenComponent(gaiaXContext);
        }
    }

    /* access modifiers changed from: private */
    public final void onReadyComponentTask(GaiaXContext gaiaXContext) {
        gaiaXContext.setJsStatus(2);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.onReadyComponent(gaiaXContext);
        }
    }

    /* access modifiers changed from: private */
    public final void onReuseComponentTask(GaiaXContext gaiaXContext) {
        if (gaiaXContext.isIgnoreJSReuse()) {
            gaiaXContext.setIgnoreJSReuse(false);
            return;
        }
        gaiaXContext.setJsStatus(4);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.onReuseComponent(gaiaXContext);
        }
    }

    /* access modifiers changed from: private */
    public final void onShowComponentTask(GaiaXContext gaiaXContext) {
        if (gaiaXContext.getJsStatus() != 2) {
            gaiaXContext.setJsStatus(3);
            IJSDelegate iJSDelegate = instance;
            if (iJSDelegate != null) {
                iJSDelegate.onShowComponent(gaiaXContext);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void registerComponentTask(GaiaXContext gaiaXContext) {
        gaiaXContext.setJsStatus(1);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.registerComponent(gaiaXContext);
        }
    }

    /* access modifiers changed from: private */
    public final void unregisterComponentTask(GaiaXContext gaiaXContext) {
        gaiaXContext.setJsStatus(7);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.unregisterComponent(gaiaXContext);
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void dispatcherEvent(@NotNull EventParams eventParams) {
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.dispatcherEvent(eventParams);
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void dispatcherNativeMessageEvent(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.dispatcherNativeMessageEvent(jSONObject);
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onDestroyComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("onDestroyComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$onDestroyComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                onDestroyComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onHiddenComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("onHiddenComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$onHiddenComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                onHiddenComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onLoadMoreComponent(@NotNull GaiaXContext gaiaXContext, @NotNull JSONObject jSONObject) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(jSONObject, "data");
        IJSDelegate iJSDelegate = instance;
        if (iJSDelegate != null) {
            iJSDelegate.onLoadMoreComponent(gaiaXContext, jSONObject);
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReadyComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("onReadyComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$onReadyComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                onReadyComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReuseComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("onReuseComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$onReuseComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                onReuseComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onShowComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("onShowComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$onShowComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                onShowComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void registerComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("registerComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$registerComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                registerComponentTask(gaiaXContext);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void startEngine(@NotNull Context context, @NotNull Function0<ur2> function0) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(function0, WXBridgeManager.METHOD_CALLBACK);
        initJSDelegate();
        if (!isEngineStarted && !isEngineStarting) {
            IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
            Context applicationContext = app2 == null ? null : app2.applicationContext();
            if (applicationContext != null) {
                isEngineStarting = true;
                GaiaXWorkerExecutor.INSTANCE.action(new GaiaXJSDelegate$startEngine$1(applicationContext));
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void unregisterComponent(@NotNull GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        if (gaiaXContext.isJsExist()) {
            if (isEngineStarting) {
                pendingTask.add(new PendingTask(k21.r("unregisterComponent", Integer.valueOf(gaiaXContext.hashCode())), new GaiaXJSDelegate$unregisterComponent$1(gaiaXContext)));
            } else if (isEngineStarted) {
                unregisterComponentTask(gaiaXContext);
            }
        }
    }
}
