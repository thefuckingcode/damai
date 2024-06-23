package com.youku.gaiax.js;

import android.content.Context;
import android.content.res.AssetManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.event.Subject;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.GaiaXEngine;
import com.youku.gaiax.js.core.GaiaXRuntime;
import com.youku.gaiax.js.support.GaiaXModuleManager;
import com.youku.gaiax.js.support.IModuleManager;
import com.youku.gaiax.js.support.module.GaiaXNativeMessageEventModule;
import com.youku.gaiax.js.support.module.GaiaXNativeUtilModule;
import com.youku.gaiax.js.utils.Aop;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.Log;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.dj;
import tb.ek2;
import tb.if1;
import tb.k21;
import tb.m40;
import tb.ph;
import tb.ur2;

public final class GaiaXJS {
    public static final Companion Companion = new Companion(null);
    private static final String GAIAX_JS_MODULES;
    private static final String MODULE_PREFIX;
    private static final String MODULE_SUFFIX;
    private static final Lazy<GaiaXJS> instance$delegate = b.b(GaiaXJS$Companion$instance$2.INSTANCE);
    public Context context;
    private GaiaXEngine defaultEngine;
    private final ConcurrentHashMap<Long, GaiaXEngine> engines = new ConcurrentHashMap<>();
    private Listener listener;
    private final IModuleManager moduleManager = new GaiaXModuleManager();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        public final GaiaXJS getInstance() {
            return (GaiaXJS) GaiaXJS.instance$delegate.getValue();
        }
    }

    public enum GaiaXJSType {
        QuickJS
    }

    public interface Listener {

        public static final class DefaultImpls {
            public static /* synthetic */ void monitor$default(Listener listener, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, Object obj) {
                if (obj == null) {
                    String str9 = "";
                    String str10 = (i & 2) != 0 ? str9 : str2;
                    String str11 = (i & 4) != 0 ? str9 : str3;
                    String str12 = (i & 8) != 0 ? str9 : str4;
                    String str13 = (i & 16) != 0 ? str9 : str5;
                    long j2 = (i & 32) != 0 ? -1 : j;
                    String str14 = (i & 64) != 0 ? str9 : str6;
                    String str15 = (i & 128) != 0 ? str9 : str7;
                    if ((i & 256) == 0) {
                        str9 = str8;
                    }
                    listener.monitor(str, str10, str11, str12, str13, j2, str14, str15, str9);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
            }
        }

        void errorLog(@NotNull JSONObject jSONObject);

        void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8);
    }

    private final String[] assetsModules(String str) {
        String[] list;
        AssetManager assets = getContext$GaiaX_Android_JS().getAssets();
        k21.h(assets, "context.assets");
        synchronized (assets) {
            list = getContext$GaiaX_Android_JS().getAssets().list(str);
        }
        return list;
    }

    private final InputStream assetsOpen(String str) {
        InputStream open;
        AssetManager assets = getContext$GaiaX_Android_JS().getAssets();
        k21.h(assets, "context.assets");
        synchronized (assets) {
            open = getContext$GaiaX_Android_JS().getAssets().open(str);
        }
        k21.h(open, "synchronized(context.ass…ntext.assets.open(file) }");
        return open;
    }

    private final void checkIdEngineExist(long j) {
        if (this.engines.containsKey(Long.valueOf(j))) {
            throw new IllegalArgumentException("Id Engine Exist");
        }
    }

    /* access modifiers changed from: public */
    private final GaiaXEngine createEngine(GaiaXJSType gaiaXJSType) {
        long genLongId = IdGenerator.INSTANCE.genLongId();
        checkIdEngineExist(genLongId);
        GaiaXEngine create = GaiaXEngine.Companion.create(genLongId, gaiaXJSType);
        this.engines.put(Long.valueOf(genLongId), create);
        create.initEngine$GaiaX_Android_JS();
        return create;
    }

    private final void destroyEngine(GaiaXEngine gaiaXEngine) {
        if (gaiaXEngine != null) {
            destroyEngine(gaiaXEngine.getId$GaiaX_Android_JS());
        }
    }

    /* access modifiers changed from: public */
    private final void initModules() {
        try {
            registerInnerModules();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            registerAssetsModules();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.youku.gaiax.js.GaiaXJS */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        tb.dj.a(r7, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        throw r6;
     */
    private final void registerAssetsModules() {
        JSONObject jSONObject = new JSONObject();
        String[] assetsModules = assetsModules(GAIAX_JS_MODULES);
        if (assetsModules != null) {
            for (String str : assetsModules) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d(k21.r("registerAssetsModules() called with: file = ", str));
                }
                if ((o.L(str, MODULE_PREFIX, false, 2, null)) && (o.v(str, MODULE_SUFFIX, false, 2, null))) {
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(assetsOpen(k21.r("gaiax_js_modules/", str)), ph.UTF_8);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        String c = ek2.c(bufferedReader);
                        dj.a(bufferedReader, null);
                        jSONObject.putAll(JSON.parseObject(c));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (Map.Entry entry : jSONObject.entrySet()) {
            Class<?> cls = Class.forName(entry.getValue().toString());
            if (k21.d(cls.getSuperclass(), GaiaXBaseModule.class)) {
                registerModule(cls);
            } else {
                throw new IllegalArgumentException("Register Module " + cls + " Illegal");
            }
        }
    }

    private final void registerInnerModules() {
        registerModule(GaiaXNativeUtilModule.class);
        registerModule(GaiaXNativeMessageEventModule.class);
    }

    private final void unregisterModule(Class<? extends GaiaXBaseModule> cls) {
        this.moduleManager.unregisterModule(cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        tb.dj.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        throw r1;
     */
    public final String buildBootstrapScript$GaiaX_Android_JS() {
        InputStream open = getContext$GaiaX_Android_JS().getResources().getAssets().open(GaiaXContext.BOOTSTRAP_JS);
        k21.h(open, "context.resources.assets…aiaXContext.BOOTSTRAP_JS)");
        InputStreamReader inputStreamReader = new InputStreamReader(open, ph.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        String c = ek2.c(bufferedReader);
        dj.a(bufferedReader, null);
        return c;
    }

    public final String buildModulesScript$GaiaX_Android_JS() {
        return this.moduleManager.buildModulesScript();
    }

    public final GaiaXContext context$GaiaX_Android_JS(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXEngine gaiaXEngine = this.engines.get(Long.valueOf(j));
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null) {
            return null;
        }
        return runtime$GaiaX_Android_JS.context();
    }

    public final void executeDelayTask(int i, long j, Function0<ur2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(function0, Subject.FUNCTION);
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.executeDelayTask(i, j, function0);
        }
    }

    public final void executeIntervalTask(int i, long j, Function0<ur2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(function0, "func");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.executeIntervalTask(i, j, function0);
        }
    }

    public final void executeTask(Function0<ur2> function0) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(function0, "func");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.executeTask(function0);
        }
    }

    public final Context getContext$GaiaX_Android_JS() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        k21.A(WPKFactory.INIT_KEY_CONTEXT);
        return null;
    }

    public final Listener getListener$GaiaX_Android_JS() {
        return this.listener;
    }

    public final GaiaXJS init(Context context2) {
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context2.getApplicationContext();
        k21.h(applicationContext, "context.applicationContext");
        setContext$GaiaX_Android_JS(applicationContext);
        Aop.INSTANCE.aopTaskTime(new GaiaXJS$init$1(this), GaiaXJS$init$2.INSTANCE);
        return this;
    }

    public final GaiaXJS initListener(Listener listener2) {
        k21.i(listener2, "listener");
        this.listener = listener2;
        return this;
    }

    public final void invokeAsyncMethod$GaiaX_Android_JS(long j, long j2, JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        this.moduleManager.invokeMethodAsync(j, j2, jSONArray);
    }

    public final void invokePromiseMethod$GaiaX_Android_JS(long j, long j2, JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        this.moduleManager.invokePromiseMethod(j, j2, jSONArray);
    }

    public final Object invokeSyncMethod$GaiaX_Android_JS(long j, long j2, JSONArray jSONArray) {
        k21.i(jSONArray, "args");
        return this.moduleManager.invokeMethodSync(j, j2, jSONArray);
    }

    public final void onDestroyComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onDestroyComponent(j);
        }
    }

    public final void onEventComponent(long j, String str, JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onEventComponent(j, str, jSONObject);
        }
    }

    public final void onHiddenComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onHiddenComponent(j);
        }
    }

    public final void onLoadMoreComponent(long j, JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onLoadMoreComponent(j, jSONObject);
        }
    }

    public final void onNativeEventComponent(long j, JSONObject jSONObject) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(jSONObject, "data");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onNativeEventComponent(j, jSONObject);
        }
    }

    public final void onReadyComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onReadyComponent(j);
        }
    }

    public final void onReuseComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onReuseComponent(j);
        }
    }

    public final void onShowComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.onShowComponent(j);
        }
    }

    public final long registerComponent(String str, String str2, String str3, String str4) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "templateVersion");
        k21.i(str4, "script");
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine == null || (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) == null || (context2 = runtime$GaiaX_Android_JS.context()) == null) {
            return -1;
        }
        return context2.registerComponent(str, str2, str3, str4);
    }

    public final GaiaXJS registerModule(Class<? extends GaiaXBaseModule> cls) {
        k21.i(cls, "moduleClazz");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("registerModule() called with: moduleClazz = ", cls));
        }
        this.moduleManager.registerModule(cls);
        return this;
    }

    public final void remoteDelayTask(int i) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.remoteDelayTask(i);
        }
    }

    public final void remoteIntervalTask(int i) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.remoteIntervalTask(i);
        }
    }

    public final void setContext$GaiaX_Android_JS(Context context2) {
        k21.i(context2, "<set-?>");
        this.context = context2;
    }

    public final void setListener$GaiaX_Android_JS(Listener listener2) {
        this.listener = listener2;
    }

    public final void startEngine(Function0<ur2> function0) {
        k21.i(function0, "complete");
        synchronized (GaiaXJS.class) {
            if (this.defaultEngine == null) {
                GaiaXEngine gaiaXEngine = (GaiaXEngine) Aop.INSTANCE.aopTaskTime(new GaiaXJS$startEngine$1$1(this), GaiaXJS$startEngine$1$2.INSTANCE);
                this.defaultEngine = gaiaXEngine;
                startEngine(gaiaXEngine, function0);
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final void stopEngine() {
        synchronized (GaiaXJS.class) {
            GaiaXEngine gaiaXEngine = this.defaultEngine;
            if (gaiaXEngine != null) {
                destroyEngine(gaiaXEngine);
                this.defaultEngine = null;
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final void unregisterComponent(long j) {
        GaiaXRuntime runtime$GaiaX_Android_JS;
        GaiaXContext context2;
        GaiaXEngine gaiaXEngine = this.defaultEngine;
        if (gaiaXEngine != null && (runtime$GaiaX_Android_JS = gaiaXEngine.runtime$GaiaX_Android_JS()) != null && (context2 = runtime$GaiaX_Android_JS.context()) != null) {
            context2.unregisterComponent(j);
        }
    }

    private final void destroyEngine(long j) {
        GaiaXEngine remove;
        if (this.engines.containsKey(Long.valueOf(j)) && (remove = this.engines.remove(Long.valueOf(j))) != null) {
            remove.destroyEngine$GaiaX_Android_JS();
        }
    }

    private final void startEngine(GaiaXEngine gaiaXEngine, Function0<ur2> function0) {
        if (gaiaXEngine != null) {
            startEngine(gaiaXEngine.getId$GaiaX_Android_JS(), function0);
        }
    }

    private final void startEngine(long j, Function0<ur2> function0) {
        GaiaXEngine gaiaXEngine;
        if (this.engines.containsKey(Long.valueOf(j)) && (gaiaXEngine = this.engines.get(Long.valueOf(j))) != null) {
            gaiaXEngine.startEngine$GaiaX_Android_JS(function0);
        }
    }
}
