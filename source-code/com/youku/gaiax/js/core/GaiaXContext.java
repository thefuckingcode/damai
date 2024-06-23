package com.youku.gaiax.js.core;

import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.log.TLogConstant;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.api.ICallBridgeListener;
import com.youku.gaiax.js.core.api.IComponent;
import com.youku.gaiax.js.core.api.IContext;
import com.youku.gaiax.js.core.api.IRuntime;
import com.youku.gaiax.js.impl.qjs.QuickJSContext;
import com.youku.gaiax.js.utils.GaiaXJSTaskQueue;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001HB!\b\u0002\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010'\u001a\u000204¢\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\u0012\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J&\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bJ\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$J\u001e\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$J\u0016\u0010)\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u0010'\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b'\u00105\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u0002088\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXContext;", "", "Lcom/youku/gaiax/js/core/api/IContext;", "createContext", "Ltb/ur2;", "initContext", "Lkotlin/Function0;", "complete", "startContext", "", TLogConstant.PERSIST_TASK_ID, "", Constants.Name.INTERVAL, "func", "executeIntervalTask", "remoteIntervalTask", "delay", "executeDelayTask", "executeTask", "remoteDelayTask", "destroyContext", "", "script", "evaluateJS", "evaluateJSWithoutTask", if1.DIMEN_BIZ, "templateId", "templateVersion", "registerComponent", "id", "unregisterComponent", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "Lcom/alibaba/fastjson/JSONObject;", "data", "onLoadMoreComponent", "type", "onEventComponent", "onNativeEventComponent", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "host", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "getHost", "()Lcom/youku/gaiax/js/core/GaiaXRuntime;", "Lcom/youku/gaiax/js/core/api/IRuntime;", "runtime", "Lcom/youku/gaiax/js/core/api/IRuntime;", "getRuntime", "()Lcom/youku/gaiax/js/core/api/IRuntime;", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "getType", "()Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "Lcom/youku/gaiax/js/core/api/ICallBridgeListener;", "bridge", "Lcom/youku/gaiax/js/core/api/ICallBridgeListener;", "getBridge$GaiaX_Android_JS", "()Lcom/youku/gaiax/js/core/api/ICallBridgeListener;", "Lcom/youku/gaiax/js/utils/GaiaXJSTaskQueue;", "taskQueue", "Lcom/youku/gaiax/js/utils/GaiaXJSTaskQueue;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/js/core/api/IContext;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/youku/gaiax/js/core/api/IComponent;", com.youku.arch.v3.data.Constants.COMPONENT, "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXRuntime;Lcom/youku/gaiax/js/core/api/IRuntime;Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContext {
    @NotNull
    public static final String BOOTSTRAP_JS = "bootstrap.js";
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int EVAL_TYPE_GLOBAL = 0;
    public static final int EVAL_TYPE_MODULE = 1;
    @NotNull
    public static final String MODULE_GAIAX_BRIDGE = "GaiaXBridge";
    @NotNull
    public static final String MODULE_OS = "os";
    @NotNull
    public static final String MODULE_STD = "std";
    @NotNull
    public static final String MODULE_TIMER = "timer";
    @NotNull
    private final ICallBridgeListener bridge;
    @NotNull
    private final ConcurrentHashMap<Long, IComponent> components;
    @Nullable
    private IContext context;
    @NotNull
    private final GaiaXRuntime host;
    @NotNull
    private final IRuntime runtime;
    @Nullable
    private GaiaXJSTaskQueue taskQueue;
    @NotNull
    private final GaiaXJS.GaiaXJSType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0016\u0010\u0012\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXContext$Companion;", "", "Lcom/youku/gaiax/js/core/GaiaXRuntime;", "host", "Lcom/youku/gaiax/js/core/api/IRuntime;", "runtime", "Lcom/youku/gaiax/js/GaiaXJS$GaiaXJSType;", "type", "Lcom/youku/gaiax/js/core/GaiaXContext;", "create", "", "BOOTSTRAP_JS", "Ljava/lang/String;", "", "EVAL_TYPE_GLOBAL", "I", "EVAL_TYPE_MODULE", "MODULE_GAIAX_BRIDGE", "MODULE_OS", "MODULE_STD", "MODULE_TIMER", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GaiaXContext create(@NotNull GaiaXRuntime gaiaXRuntime, @NotNull IRuntime iRuntime, @NotNull GaiaXJS.GaiaXJSType gaiaXJSType) {
            k21.i(gaiaXRuntime, "host");
            k21.i(iRuntime, "runtime");
            k21.i(gaiaXJSType, "type");
            return new GaiaXContext(gaiaXRuntime, iRuntime, gaiaXJSType, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GaiaXJS.GaiaXJSType.values().length];
            iArr[GaiaXJS.GaiaXJSType.QuickJS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GaiaXContext(GaiaXRuntime gaiaXRuntime, IRuntime iRuntime, GaiaXJS.GaiaXJSType gaiaXJSType) {
        this.host = gaiaXRuntime;
        this.runtime = iRuntime;
        this.type = gaiaXJSType;
        this.bridge = new GaiaXContext$bridge$1();
        this.components = new ConcurrentHashMap<>();
    }

    public /* synthetic */ GaiaXContext(GaiaXRuntime gaiaXRuntime, IRuntime iRuntime, GaiaXJS.GaiaXJSType gaiaXJSType, m40 m40) {
        this(gaiaXRuntime, iRuntime, gaiaXJSType);
    }

    private final IContext createContext() {
        if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] == 1) {
            return QuickJSContext.Companion.create(this, this.host.getEngine(), this.runtime);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void destroyContext() {
        IContext iContext = this.context;
        if (iContext != null) {
            iContext.destroyPendingJob();
        }
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.destroyTaskQueue();
        }
        this.taskQueue = null;
        IContext iContext2 = this.context;
        if (iContext2 != null) {
            iContext2.destroyContext();
        }
        this.context = null;
    }

    public final void evaluateJS(@NotNull String str) {
        k21.i(str, "script");
        executeTask(new GaiaXContext$evaluateJS$1(this, str));
    }

    public final void evaluateJSWithoutTask(@NotNull String str) {
        k21.i(str, "script");
        IContext iContext = this.context;
        if (iContext != null) {
            iContext.evaluateJS(str);
        }
    }

    public final void executeDelayTask(int i, long j, @NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.executeDelayTask(i, j, function0);
        }
    }

    public final void executeIntervalTask(int i, long j, @NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.executeIntervalTask(i, j, function0);
        }
    }

    public final void executeTask(@NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.executeTask(function0);
        }
    }

    @NotNull
    public final ICallBridgeListener getBridge$GaiaX_Android_JS() {
        return this.bridge;
    }

    @NotNull
    public final GaiaXRuntime getHost() {
        return this.host;
    }

    @NotNull
    public final IRuntime getRuntime() {
        return this.runtime;
    }

    @NotNull
    public final GaiaXJS.GaiaXJSType getType() {
        return this.type;
    }

    public final void initContext() {
        if (this.context == null) {
            this.context = createContext();
        }
        if (this.taskQueue == null) {
            this.taskQueue = GaiaXJSTaskQueue.Companion.create(this.host.getHost().getEngineId());
        }
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.initTaskQueue();
        }
        IContext iContext = this.context;
        if (iContext != null) {
            iContext.initContext();
        }
        IContext iContext2 = this.context;
        if (iContext2 != null) {
            iContext2.initModule("timer");
        }
        IContext iContext3 = this.context;
        if (iContext3 != null) {
            iContext3.initModule(MODULE_GAIAX_BRIDGE);
        }
        IContext iContext4 = this.context;
        if (iContext4 != null) {
            iContext4.initPendingJob();
        }
    }

    public final void onDestroyComponent(long j) {
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onDestroy();
        }
    }

    public final void onEventComponent(long j, @NotNull String str, @NotNull JSONObject jSONObject) {
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onEvent(str, jSONObject);
        }
    }

    public final void onHiddenComponent(long j) {
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onHide();
        }
    }

    public final void onLoadMoreComponent(long j, @NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onLoadMore(jSONObject);
        }
    }

    public final void onNativeEventComponent(long j, @NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onNativeEvent(jSONObject);
        }
    }

    public final void onReadyComponent(long j) {
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onReady();
        }
    }

    public final void onReuseComponent(long j) {
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onReuse();
        }
    }

    public final void onShowComponent(long j) {
        IComponent iComponent = this.components.get(Long.valueOf(j));
        if (iComponent != null) {
            iComponent.onShow();
        }
    }

    public final long registerComponent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "templateVersion");
        k21.i(str4, "script");
        GaiaXComponent create = GaiaXComponent.Companion.create(this, str, str2, str3, str4);
        this.components.put(Long.valueOf(create.getId()), create);
        create.initComponent();
        return create.getId();
    }

    public final void remoteDelayTask(int i) {
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.remoteDelayTask(i);
        }
    }

    public final void remoteIntervalTask(int i) {
        GaiaXJSTaskQueue gaiaXJSTaskQueue = this.taskQueue;
        if (gaiaXJSTaskQueue != null) {
            gaiaXJSTaskQueue.remoteIntervalTask(i);
        }
    }

    public final void startContext(@NotNull Function0<ur2> function0) {
        k21.i(function0, "complete");
        executeTask(new GaiaXContext$startContext$1(this, function0));
    }

    public final void unregisterComponent(long j) {
        IComponent remove = this.components.remove(Long.valueOf(j));
        if (remove != null) {
            remove.destroyComponent();
        }
    }
}
