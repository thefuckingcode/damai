package com.youku.gaiax.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.impl.utils.GaiaXWorkerExecutor;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Set;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.mr0;
import tb.nr0;
import tb.or0;
import tb.ur2;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 u2\u00020\u0001:\u0001uB\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\bs\u0010tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\u0010H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00104\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R*\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b[\u0010&\u001a\u0004\b[\u0010'\"\u0004\b\\\u0010)R\u001e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010_R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010_R\"\u0010`\u001a\u0002088\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u0002088\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bf\u0010a\u001a\u0004\bg\u0010c\"\u0004\bh\u0010eR\"\u0010i\u001a\u0002088\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bi\u0010a\u001a\u0004\bj\u0010c\"\u0004\bk\u0010eR\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bl\u0010&\u001a\u0004\bl\u0010'\"\u0004\bm\u0010)R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXContext;", "", "Ltb/ur2;", "releaseTask", "releaseSync", "removeOldTask", "Lcom/youku/gaiax/GaiaX$Params;", "params", "updateContext", "", "isJsExist", "Lkotlin/Function0;", "task", "workerTask", "uiTask", "releaseCanAsync", "", "getTemplateId", "Ltb/wq0;", "gxTemplateContext", "setGXTemplateContext", "isInvalidGXRootView", "isInvalidContainer", "isInvalidStatus", "toString", "Lcom/youku/gaiax/GaiaX$Params;", "getParams", "()Lcom/youku/gaiax/GaiaX$Params;", "setParams", "(Lcom/youku/gaiax/GaiaX$Params;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isReleased", "Z", "()Z", "setReleased", "(Z)V", "", "typeStatus", "I", "getTypeStatus", "()I", "setTypeStatus", "(I)V", "lifeStatus", "getLifeStatus", "setLifeStatus", "jsStatus", "getJsStatus", "setJsStatus", "", "", "jsComponentIds", "Ljava/util/Set;", "getJsComponentIds", "()Ljava/util/Set;", "setJsComponentIds", "(Ljava/util/Set;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "gxTrackListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "getGxTrackListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "setGxTrackListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "gxEventListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "getGxEventListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "setGxEventListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "gxDataListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "getGxDataListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "setGxDataListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;)V", "Landroid/view/View;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "isChanged", "setChanged", "Ljava/util/concurrent/FutureTask;", "workTask", "Ljava/util/concurrent/FutureTask;", "createTime", "J", "getCreateTime$GaiaX_Android", "()J", "setCreateTime$GaiaX_Android", "(J)V", "refreshTime", "getRefreshTime$GaiaX_Android", "setRefreshTime$GaiaX_Android", "stepTime", "getStepTime$GaiaX_Android", "setStepTime$GaiaX_Android", "isIgnoreJSReuse", "setIgnoreJSReuse", "Ltb/wq0;", "getGxTemplateContext", "()Ltb/wq0;", "setGxTemplateContext", "(Ltb/wq0;)V", "<init>", "(Lcom/youku/gaiax/GaiaX$Params;Landroid/content/Context;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContext {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int TEMPLATE_ASYNC_NORMAL = 1;
    public static final int TEMPLATE_ASYNC_NORMAL_SUPER_MERGE = 2;
    public static final int TEMPLATE_JS_LIFE_ON_DESTROY = 6;
    public static final int TEMPLATE_JS_LIFE_ON_HIDDEN = 5;
    public static final int TEMPLATE_JS_LIFE_ON_LOAD_MORE = 11;
    public static final int TEMPLATE_JS_LIFE_ON_NEED_RELOAD = 10;
    public static final int TEMPLATE_JS_LIFE_ON_NONE = 0;
    public static final int TEMPLATE_JS_LIFE_ON_READY = 2;
    public static final int TEMPLATE_JS_LIFE_ON_REGISTER = 1;
    public static final int TEMPLATE_JS_LIFE_ON_REUSE = 4;
    public static final int TEMPLATE_JS_LIFE_ON_SHOW = 3;
    public static final int TEMPLATE_JS_LIFE_ON_UNREGISTER = 7;
    public static final int TEMPLATE_LIFE_ON_CREATED = 4;
    public static final int TEMPLATE_LIFE_ON_DESTROY = 3;
    public static final int TEMPLATE_LIFE_ON_INVISIBLE = 2;
    public static final int TEMPLATE_LIFE_ON_NONE = 0;
    public static final int TEMPLATE_LIFE_ON_VISIBLE = 1;
    public static final int TEMPLATE_SYNC_NORMAL = 0;
    public static final int TEMPLATE_TYPE_CREATED = 2;
    public static final int TEMPLATE_TYPE_CREATING = 1;
    public static final int TEMPLATE_TYPE_NEED_RELOAD = 5;
    public static final int TEMPLATE_TYPE_NONE = 0;
    public static final int TEMPLATE_TYPE_REFRESHED = 4;
    public static final int TEMPLATE_TYPE_REFRESHING = 3;
    @NotNull
    private Context context;
    private long createTime;
    @Nullable
    private GXTemplateEngine.GXIDataListener gxDataListener;
    @Nullable
    private GXTemplateEngine.GXIEventListener gxEventListener;
    @Nullable
    private wq0 gxTemplateContext;
    @Nullable
    private GXTemplateEngine.GXITrackListener gxTrackListener;
    private boolean isChanged;
    private boolean isIgnoreJSReuse;
    private volatile boolean isReleased;
    @Nullable
    private Set<Long> jsComponentIds;
    private int jsStatus;
    private int lifeStatus;
    @NotNull
    private GaiaX.Params params;
    private long refreshTime;
    @Nullable
    private FutureTask<ur2> releaseTask;
    @Nullable
    private View rootView;
    private long stepTime;
    private int typeStatus;
    @Nullable
    private FutureTask<ur2> uiTask;
    @Nullable
    private FutureTask<ur2> workTask;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0016\u0010\u0018\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0016\u0010\u001f\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0016\u0010 \u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u000eR\u0016\u0010!\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u000eR\u0016\u0010\"\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u000eR\u0016\u0010#\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u000eR\u0016\u0010$\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u000eR\u0016\u0010%\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u000e¨\u0006("}, d2 = {"Lcom/youku/gaiax/impl/GaiaXContext$Companion;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Lcom/youku/gaiax/impl/GaiaXContext;", "createContext", "forceInitContext", "initContext", "getContainerContext", WPKFactory.INIT_KEY_CONTEXT, "Ltb/ur2;", "setContextToContainer", "", "TEMPLATE_ASYNC_NORMAL", "I", "TEMPLATE_ASYNC_NORMAL_SUPER_MERGE", "TEMPLATE_JS_LIFE_ON_DESTROY", "TEMPLATE_JS_LIFE_ON_HIDDEN", "TEMPLATE_JS_LIFE_ON_LOAD_MORE", "TEMPLATE_JS_LIFE_ON_NEED_RELOAD", "TEMPLATE_JS_LIFE_ON_NONE", "TEMPLATE_JS_LIFE_ON_READY", "TEMPLATE_JS_LIFE_ON_REGISTER", "TEMPLATE_JS_LIFE_ON_REUSE", "TEMPLATE_JS_LIFE_ON_SHOW", "TEMPLATE_JS_LIFE_ON_UNREGISTER", "TEMPLATE_LIFE_ON_CREATED", "TEMPLATE_LIFE_ON_DESTROY", "TEMPLATE_LIFE_ON_INVISIBLE", "TEMPLATE_LIFE_ON_NONE", "TEMPLATE_LIFE_ON_VISIBLE", "TEMPLATE_SYNC_NORMAL", "TEMPLATE_TYPE_CREATED", "TEMPLATE_TYPE_CREATING", "TEMPLATE_TYPE_NEED_RELOAD", "TEMPLATE_TYPE_NONE", "TEMPLATE_TYPE_REFRESHED", "TEMPLATE_TYPE_REFRESHING", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        private final GaiaXContext createContext(GaiaX.Params params) {
            Context context = params.getContext();
            if (context != null) {
                return new GaiaXContext(params, context);
            }
            throw new IllegalArgumentException("GaiaX.Params must be have an android context");
        }

        @NotNull
        public final GaiaXContext forceInitContext(@NotNull GaiaX.Params params) {
            k21.i(params, "params");
            GaiaXContext createContext = createContext(params);
            createContext.updateContext(params);
            setContextToContainer(params, createContext);
            return createContext;
        }

        @Nullable
        public final GaiaXContext getContainerContext(@NotNull GaiaX.Params params) {
            k21.i(params, "params");
            View container = params.getContainer();
            if (container == null) {
                return null;
            }
            Object tag = container.getTag();
            if (tag instanceof GaiaXContext) {
                return (GaiaXContext) tag;
            }
            return null;
        }

        @NotNull
        public final GaiaXContext initContext(@NotNull GaiaX.Params params) {
            k21.i(params, "params");
            GaiaXContext containerContext = getContainerContext(params);
            if (containerContext == null) {
                GaiaXContext createContext = createContext(params);
                createContext.updateContext(params);
                setContextToContainer(params, createContext);
                return createContext;
            }
            containerContext.updateContext(params);
            return containerContext;
        }

        public final void setContextToContainer(@NotNull GaiaX.Params params, @Nullable GaiaXContext gaiaXContext) {
            k21.i(params, "params");
            View container = params.getContainer();
            if (container != null) {
                container.setTag(gaiaXContext);
            }
        }
    }

    public GaiaXContext(@NotNull GaiaX.Params params2, @NotNull Context context2) {
        k21.i(params2, "params");
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.params = params2;
        this.context = context2;
    }

    private final void releaseSync() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", k21.r("releaseSync() called, context = ", this));
        }
        synchronized (this) {
            setReleased(true);
            Companion.setContextToContainer(getParams(), null);
            wq0 gxTemplateContext2 = getGxTemplateContext();
            if (gxTemplateContext2 != null) {
                gxTemplateContext2.s();
            }
            setGxTemplateContext(null);
            setRootView(null);
            setGxEventListener(null);
            setGxTrackListener(null);
            setTypeStatus(0);
            setLifeStatus(3);
            setLifeStatus(0);
            setJsStatus(0);
            this.workTask = null;
            this.releaseTask = null;
            this.uiTask = null;
            setChanged(false);
            setJsComponentIds(null);
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    private final void releaseTask() {
        FutureTask<ur2> futureTask = new FutureTask<>(new mr0(this));
        this.releaseTask = futureTask;
        GaiaXWorkerExecutor.INSTANCE.action(futureTask);
    }

    /* access modifiers changed from: private */
    /* renamed from: releaseTask$lambda-3  reason: not valid java name */
    public static final ur2 m890releaseTask$lambda3(GaiaXContext gaiaXContext) {
        k21.i(gaiaXContext, "this$0");
        gaiaXContext.releaseSync();
        gaiaXContext.releaseTask = null;
        return ur2.INSTANCE;
    }

    private final void removeOldTask() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeOldTask() called uiTask=");
            sb.append(this.uiTask);
            sb.append(" uiTask.isDone=");
            FutureTask<ur2> futureTask = this.uiTask;
            sb.append(futureTask == null ? null : Boolean.valueOf(futureTask.isDone()));
            sb.append(" uiTask.isCancelled=");
            FutureTask<ur2> futureTask2 = this.uiTask;
            sb.append(futureTask2 == null ? null : Boolean.valueOf(futureTask2.isCancelled()));
            sb.append(" releaseTask=");
            sb.append(this.releaseTask);
            sb.append(" releaseTask.isDone=");
            FutureTask<ur2> futureTask3 = this.releaseTask;
            sb.append(futureTask3 == null ? null : Boolean.valueOf(futureTask3.isDone()));
            sb.append(" releaseTask.isCancelled=");
            FutureTask<ur2> futureTask4 = this.releaseTask;
            sb.append(futureTask4 == null ? null : Boolean.valueOf(futureTask4.isCancelled()));
            sb.append(" workTask=");
            sb.append(this.workTask);
            sb.append(" workTask.isDone=");
            FutureTask<ur2> futureTask5 = this.workTask;
            sb.append(futureTask5 == null ? null : Boolean.valueOf(futureTask5.isDone()));
            sb.append(" workTask.isCancelled=");
            FutureTask<ur2> futureTask6 = this.workTask;
            sb.append(futureTask6 == null ? null : Boolean.valueOf(futureTask6.isCancelled()));
            sb.append(' ');
            log.d("[GaiaX]", sb.toString());
        }
        FutureTask<ur2> futureTask7 = this.workTask;
        if (futureTask7 != null) {
            GaiaXWorkerExecutor.INSTANCE.removeAction(futureTask7);
            futureTask7.cancel(true);
            this.workTask = null;
        }
        FutureTask<ur2> futureTask8 = this.uiTask;
        if (futureTask8 != null) {
            GaiaXUiExecutor.INSTANCE.removeAction(futureTask8);
            futureTask8.cancel(true);
            this.uiTask = null;
        }
        FutureTask<ur2> futureTask9 = this.releaseTask;
        if (futureTask9 != null) {
            GaiaXWorkerExecutor.INSTANCE.removeAction(futureTask9);
            futureTask9.cancel(true);
            this.releaseTask = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: uiTask$lambda-6  reason: not valid java name */
    public static final ur2 m891uiTask$lambda6(GaiaXContext gaiaXContext, Function0 function0) {
        ur2 ur2;
        k21.i(gaiaXContext, "this$0");
        k21.i(function0, "$task");
        synchronized (gaiaXContext) {
            if (gaiaXContext.isReleased()) {
                ExceptionUtils.INSTANCE.throwUiAlarm(gaiaXContext);
            } else {
                try {
                    function0.invoke();
                } catch (Exception e) {
                    ExceptionUtils.INSTANCE.throwExceptionOrAlarm(gaiaXContext, e);
                }
            }
            ur2 = ur2.INSTANCE;
        }
        gaiaXContext.uiTask = null;
        return ur2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void updateContext(GaiaX.Params params2) {
        GaiaX.Params params3 = this.params;
        this.params = params2;
        boolean z = true;
        if (!params2.getDataPipelines5().isEmpty()) {
            this.gxDataListener = new GXDataListener(this);
        }
        if (!(this.params.getEventDelegate() == null && this.params.getRouterDelegate2() == null)) {
            this.gxEventListener = new GXEventListener(this);
        }
        if (this.params.getTrackDelegate3() != null) {
            setGxTrackListener(new GXTrackListener(this));
        }
        if (params2.getForceCreate()) {
            GXExtensionTemplateInfoSource.Companion.getInstance().clear();
        }
        boolean forceCreate = params2.getForceCreate();
        boolean z2 = !k21.d(params2.getTemplateId(), params3.getTemplateId());
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "updateContext() called forceCreate=" + forceCreate + " isSameTemplateId=" + z2);
        }
        if (!forceCreate && !z2) {
            z = false;
        }
        this.isChanged = z;
        if (!k21.d(params3, params2)) {
            if (log.isLog()) {
                StringBuilder sb = new StringBuilder();
                sb.append("updateContext() called with: oldParams.data = ");
                JSONObject data = params3.getData();
                sb.append(data != null ? data.hashCode() : 0);
                sb.append(" params.data = ");
                JSONObject data2 = params2.getData();
                sb.append(data2 != null ? data2.hashCode() : 0);
                log.d("[GaiaX]", sb.toString());
            }
            params3.release();
        }
        this.isReleased = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: workerTask$lambda-1  reason: not valid java name */
    public static final ur2 m892workerTask$lambda1(GaiaXContext gaiaXContext, Function0 function0) {
        ur2 ur2;
        k21.i(gaiaXContext, "this$0");
        k21.i(function0, "$task");
        synchronized (gaiaXContext) {
            if (gaiaXContext.isReleased()) {
                ExceptionUtils.INSTANCE.throwWorkerAlarm(gaiaXContext);
            } else {
                try {
                    function0.invoke();
                } catch (Exception e) {
                    ExceptionUtils.INSTANCE.throwExceptionOrAlarm(gaiaXContext, e);
                }
            }
            ur2 = ur2.INSTANCE;
        }
        gaiaXContext.workTask = null;
        return ur2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final long getCreateTime$GaiaX_Android() {
        return this.createTime;
    }

    @Nullable
    public final GXTemplateEngine.GXIDataListener getGxDataListener() {
        return this.gxDataListener;
    }

    @Nullable
    public final GXTemplateEngine.GXIEventListener getGxEventListener() {
        return this.gxEventListener;
    }

    @Nullable
    public final wq0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    @Nullable
    public final GXTemplateEngine.GXITrackListener getGxTrackListener() {
        return this.gxTrackListener;
    }

    @Nullable
    public final Set<Long> getJsComponentIds() {
        return this.jsComponentIds;
    }

    public final int getJsStatus() {
        return this.jsStatus;
    }

    public final int getLifeStatus() {
        return this.lifeStatus;
    }

    @NotNull
    public final GaiaX.Params getParams() {
        return this.params;
    }

    public final long getRefreshTime$GaiaX_Android() {
        return this.refreshTime;
    }

    @Nullable
    public final View getRootView() {
        return this.rootView;
    }

    public final long getStepTime$GaiaX_Android() {
        return this.stepTime;
    }

    @NotNull
    public final String getTemplateId() {
        return this.params.getTemplateId();
    }

    public final int getTypeStatus() {
        return this.typeStatus;
    }

    public final boolean isChanged() {
        return this.isChanged;
    }

    public final boolean isIgnoreJSReuse() {
        return this.isIgnoreJSReuse;
    }

    public final boolean isInvalidContainer() {
        View container = this.params.getContainer();
        ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
        if ((viewGroup == null ? 0 : viewGroup.getChildCount()) != 0) {
            return false;
        }
        int i = this.typeStatus;
        if (i == 2 || i == 4) {
            return true;
        }
        return false;
    }

    public final boolean isInvalidGXRootView() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View view = this.rootView;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if ((viewGroup == null ? 0 : viewGroup.getChildCount()) != 0) {
            return false;
        }
        View view2 = this.rootView;
        if (!((view2 == null || (layoutParams2 = view2.getLayoutParams()) == null || layoutParams2.width != 0) ? false : true)) {
            return false;
        }
        View view3 = this.rootView;
        if ((view3 == null || (layoutParams = view3.getLayoutParams()) == null || layoutParams.height != 0) ? false : true) {
            return true;
        }
        return false;
    }

    public final boolean isInvalidStatus() {
        return this.typeStatus == 5;
    }

    public final boolean isJsExist() {
        GXTemplateInfo k;
        wq0 wq0 = this.gxTemplateContext;
        return (wq0 == null || (k = wq0.k()) == null || !k.s()) ? false : true;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public final void releaseCanAsync() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "releaseCanAsync() called");
        }
        if (this.params.getMode() == LoadType.ASYNC_NORMAL || this.params.getMode() == LoadType.ASYNC_NORMAL_SUPER_MERGE) {
            removeOldTask();
            releaseTask();
            return;
        }
        releaseSync();
    }

    public final void setChanged(boolean z) {
        this.isChanged = z;
    }

    public final void setContext(@NotNull Context context2) {
        k21.i(context2, "<set-?>");
        this.context = context2;
    }

    public final void setCreateTime$GaiaX_Android(long j) {
        this.createTime = j;
    }

    public final void setGXTemplateContext(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        this.gxTemplateContext = wq0;
    }

    public final void setGxDataListener(@Nullable GXTemplateEngine.GXIDataListener gXIDataListener) {
        this.gxDataListener = gXIDataListener;
    }

    public final void setGxEventListener(@Nullable GXTemplateEngine.GXIEventListener gXIEventListener) {
        this.gxEventListener = gXIEventListener;
    }

    public final void setGxTemplateContext(@Nullable wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    public final void setGxTrackListener(@Nullable GXTemplateEngine.GXITrackListener gXITrackListener) {
        this.gxTrackListener = gXITrackListener;
    }

    public final void setIgnoreJSReuse(boolean z) {
        this.isIgnoreJSReuse = z;
    }

    public final void setJsComponentIds(@Nullable Set<Long> set) {
        this.jsComponentIds = set;
    }

    public final void setJsStatus(int i) {
        this.jsStatus = i;
    }

    public final void setLifeStatus(int i) {
        this.lifeStatus = i;
    }

    public final void setParams(@NotNull GaiaX.Params params2) {
        k21.i(params2, "<set-?>");
        this.params = params2;
    }

    public final void setRefreshTime$GaiaX_Android(long j) {
        this.refreshTime = j;
    }

    public final void setReleased(boolean z) {
        this.isReleased = z;
    }

    public final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    public final void setStepTime$GaiaX_Android(long j) {
        this.stepTime = j;
    }

    public final void setTypeStatus(int i) {
        this.typeStatus = i;
    }

    @NotNull
    public String toString() {
        return "GaiaXContext(this = " + hashCode() + ", params=" + this.params + ", context=" + this.context + ", gxTemplateContext=" + this.gxTemplateContext + ", typeStatus=" + this.typeStatus + ", lifeStatus=" + this.lifeStatus + ", jsStatus=" + this.jsStatus + ", rootView=" + this.rootView + ", isChanged=" + this.isChanged + ')';
    }

    public final void uiTask(@NotNull Function0<ur2> function0) {
        k21.i(function0, "task");
        FutureTask<ur2> futureTask = new FutureTask<>(new or0(this, function0));
        this.uiTask = futureTask;
        GaiaXUiExecutor.INSTANCE.action(futureTask);
    }

    public final void workerTask(@NotNull Function0<ur2> function0) {
        k21.i(function0, "task");
        FutureTask<ur2> futureTask = new FutureTask<>(new nr0(this, function0));
        this.workTask = futureTask;
        GaiaXWorkerExecutor.INSTANCE.action(futureTask);
    }
}
