package com.youku.live.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.android.utils.OPRUtils;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.toast.IToast;
import com.youku.live.widgets.config.WidgetEngineRenderConfig;
import com.youku.live.widgets.connector.EngineInstanceConnector;
import com.youku.live.widgets.connector.EngineListenerConnector;
import com.youku.live.widgets.constants.AppearState;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseDataCenter;
import com.youku.live.widgets.impl.BaseEventDispatcher;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.impl.BasePluginData;
import com.youku.live.widgets.impl.BaseProps;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.impl.BaseWidgetData;
import com.youku.live.widgets.model.template.PluginModel;
import com.youku.live.widgets.model.template.TemplateModel;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.model.template.WidgetModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import com.youku.live.widgets.protocol.IDataBridgeHandler;
import com.youku.live.widgets.protocol.IDataCenterController;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IEngineInstanceOnly;
import com.youku.live.widgets.protocol.IEngineInstanceVisibleListener;
import com.youku.live.widgets.protocol.IEngineRenderListener;
import com.youku.live.widgets.protocol.IEventHandler;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.ITemplateBuilder;
import com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityKeyDownListener;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener;
import com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.render.RenderWidget;
import com.youku.live.widgets.widgets.orientation.OrientationHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class WidgetInstance implements IEngineInstance, IEngineInstanceOnly, ITemplateBuilder, IActivityKeyDownListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String RENDER_STATUS_IDLE = "renderStatusIdle";
    public static final String RENDER_STATUS_RENDERED = "renderStatusRendered";
    public static final String RENDER_STATUS_RENDERING = "renderStatusRendering";
    public static final String TAG = "WidgetInstance";
    public static final String TAG_APPEAR_POINT = "WidgetInstance.render.appear";
    public static final String TAG_RENDER = "WidgetInstance.render";
    public static final String TAG_RENDER_CLEAR = "WidgetInstance.render.clear";
    public static final String TAG_RENDER_IMP = "WidgetInstance.render.renderImp";
    public static final String TAG_RENDER_POINT = "WidgetInstance.render.point";
    public static final String TAG_RENDER_RENDER = "WidgetInstance.render.renderM";
    private static AtomicLong mLayerIdMaker;
    private static HandlerThread sHandlerThread;
    private final String PLUGIN_LAIFENG_AUDIO_CONTROLLER;
    private boolean enableCSSLayoutConfigChanged;
    private CopyOnWriteArrayList<CSSLayout> mCSSLayouts;
    private Map<String, Object> mConfig;
    private Context mContext;
    private boolean mCreateIsDynamic;
    private Orientation mCurrentOrientation;
    private BaseDataCenter mDataCenter;
    private LinkedList<String> mDialogList;
    private WidgetEngineContext mEngineContext;
    private EngineListenerConnector mEngineListenerConnector;
    private Map<String, Object> mEnvironments;
    private BaseEventDispatcher mEventDispatcher;
    private Handler mHandler;
    private EngineInstanceConnector mInstanceConnector;
    private IProps mOptions;
    private IPerfMonitor mPerfMonitor;
    private Map<String, IPlugin> mPlugins;
    private IEngineRenderListener mRenderListener;
    private volatile String mRenderPluginStatus;
    private volatile String mRenderStatus;
    private volatile int mRenderViewCount;
    private volatile String mRenderViewStatus;
    private RenderWidget mRenderWidget;
    private volatile int mRenderWidgetCount;
    private volatile String mRenderWidgetStatus;
    private String mRoomId;
    public ActivityLifecycleState mState;
    @Deprecated
    private volatile boolean mStatusActive;
    @Deprecated
    private volatile boolean mStatusAppear;
    private boolean mSyncRenderMode;
    private TemplateModel mTemplateModel;
    private ITemplateWidgetBuildCallback mTemplateWidgetBuildCallback;
    private IProps mTheme;
    private Handler mThreadHandler;
    private List<IEngineInstanceVisibleListener> mVisibleListeners;
    private Map<String, IWidget> mWidgets;
    private boolean skipDumplicateInitHostViewWidgets;
    private boolean supportRecycleCache;

    public WidgetInstance() {
        this.mCSSLayouts = null;
        this.enableCSSLayoutConfigChanged = true;
        this.skipDumplicateInitHostViewWidgets = false;
        this.mRenderStatus = RENDER_STATUS_IDLE;
        this.mRenderPluginStatus = RENDER_STATUS_IDLE;
        this.mRenderWidgetStatus = RENDER_STATUS_IDLE;
        this.mRenderViewStatus = RENDER_STATUS_IDLE;
        this.mRenderWidgetCount = 0;
        this.mRenderViewCount = 0;
        this.mSyncRenderMode = true;
        this.PLUGIN_LAIFENG_AUDIO_CONTROLLER = "LaifengAudioCtrl";
        this.mState = ActivityLifecycleState.CREATED;
        this.mStatusActive = false;
        this.mStatusAppear = false;
        this.supportRecycleCache = true;
        this.mCurrentOrientation = Orientation.ORIENTATION_PORTAIT;
        this.mCreateIsDynamic = false;
        this.mThreadHandler = null;
        this.mCSSLayouts = new CopyOnWriteArrayList<>();
    }

    private void clearDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872822009")) {
            ipChange.ipc$dispatch("872822009", new Object[]{this});
            return;
        }
        BaseDataCenter dataCenter = getDataCenter();
        if (dataCenter instanceof IDataCenterController) {
            dataCenter.destroy();
        }
    }

    private void clearDataCenterDataCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692082791")) {
            ipChange.ipc$dispatch("-1692082791", new Object[]{this});
            return;
        }
        BaseDataCenter dataCenter = getDataCenter();
        if (dataCenter instanceof IDataCenterController) {
            dataCenter.clearDataCache();
        }
    }

    private void clearDataCenterHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033686535")) {
            ipChange.ipc$dispatch("1033686535", new Object[]{this});
            return;
        }
        BaseDataCenter dataCenter = getDataCenter();
        if (dataCenter instanceof IDataCenterController) {
            dataCenter.clearDataHandler();
        }
    }

    private void clearImp(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189236218")) {
            ipChange.ipc$dispatch("-189236218", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.clearBegin");
        clearWidgets();
        IPerfMonitor perfMonitor2 = getPerfMonitor();
        perfMonitor2.point(TAG_RENDER_CLEAR, "{roomid:" + this.mRoomId + "}.widgets");
        clearPlugins();
        IPerfMonitor perfMonitor3 = getPerfMonitor();
        perfMonitor3.point(TAG_RENDER_CLEAR, "{roomid:" + this.mRoomId + "}.plugins");
        clearSystemEventListener();
        IPerfMonitor perfMonitor4 = getPerfMonitor();
        perfMonitor4.point(TAG_RENDER_CLEAR, "{roomid:" + this.mRoomId + "}.systemEventListener");
        clearDataCenterHandler();
        if (z2) {
            clearDataCenterDataCache();
        }
        IPerfMonitor perfMonitor5 = getPerfMonitor();
        perfMonitor5.point(TAG_RENDER_CLEAR, "{roomid:" + this.mRoomId + "}.dataCenter");
        if (z) {
            clearInstanceConnector();
            IPerfMonitor perfMonitor6 = getPerfMonitor();
            perfMonitor6.point(TAG_RENDER_CLEAR, "{roomid:" + this.mRoomId + "}.instanceConnector");
        }
        IPerfMonitor perfMonitor7 = getPerfMonitor();
        perfMonitor7.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.clearEnd");
    }

    private void clearInstanceConnector() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886552742")) {
            ipChange.ipc$dispatch("-1886552742", new Object[]{this});
            return;
        }
        EngineInstanceConnector engineInstanceConnector = this.mInstanceConnector;
        this.mInstanceConnector = null;
        if (engineInstanceConnector != null) {
            engineInstanceConnector.clear();
        }
    }

    private void clearPlugins() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383175630")) {
            ipChange.ipc$dispatch("-383175630", new Object[]{this});
            return;
        }
        for (Map.Entry<String, IPlugin> entry : getPlugins().entrySet()) {
            IPlugin value = entry.getValue();
            entry.getKey();
            value.willUnmount();
            value.didUnmount();
            if (value instanceof BasePlugin) {
                ((BasePlugin) value).destroyImp();
            }
        }
        getPlugins().clear();
    }

    private void clearSystemEventListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910121587")) {
            ipChange.ipc$dispatch("1910121587", new Object[]{this});
            return;
        }
        getEngineListenerConnector().clear();
    }

    private void clearWidgets() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303354173")) {
            ipChange.ipc$dispatch("-303354173", new Object[]{this});
            return;
        }
        CopyOnWriteArrayList<CSSLayout> copyOnWriteArrayList = this.mCSSLayouts;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        RenderWidget renderWidget = this.mRenderWidget;
        if (renderWidget != null) {
            renderWidget.destroyImp();
            this.mRenderWidget.destroy();
            this.mRenderWidget = null;
        }
        for (Map.Entry<String, IWidget> entry : getWidgets().entrySet()) {
            IWidget value = entry.getValue();
            if (value instanceof BaseWidget) {
                WidgetEngineContext engineContext = getEngineContext();
                if (engineContext != null) {
                    BaseWidget baseWidget = (BaseWidget) value;
                    boolean z = this.supportRecycleCache;
                    baseWidget.mRecycled = z;
                    if (z && engineContext.getWidgetMananger().releaseInstance(value)) {
                        baseWidget.mRecycled = this.supportRecycleCache;
                    }
                } else {
                    BaseWidget baseWidget2 = (BaseWidget) value;
                    WidgetSDKManager.getInstance().releaseWidget(baseWidget2.name, value);
                    baseWidget2.mRecycled = this.supportRecycleCache;
                }
                ((BaseWidget) value).destroyImp();
            }
        }
        getWidgets().clear();
    }

    private void dispatchActiveStatus(boolean z) {
        AppearState appearState;
        AppearState appearState2;
        AppearState appearState3;
        AppearState appearState4;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-900774655")) {
            ipChange.ipc$dispatch("-900774655", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_APPEAR_POINT, "{roomid:" + this.mRoomId + "}; dispatchActiveStatusStart('" + z + "');");
        if (this.mStatusActive != z) {
            this.mStatusActive = z;
            IPerfMonitor perfMonitor2 = getPerfMonitor();
            perfMonitor2.point(TAG_APPEAR_POINT, "{roomid:" + this.mRoomId + "}; dispatchActiveStatusEnd('" + z + "');");
            if (getConfig("CONFIG_ACTIVE_SKIP_APPEAR_LEVEL") == null) {
                z2 = false;
            }
            if (z) {
                for (Map.Entry<String, IWidget> entry : getWidgets().entrySet()) {
                    IWidget value = entry.getValue();
                    if (value.isAppearLevel() && !z2 && value.getAppearState() != (appearState4 = AppearState.DID_APPEAR)) {
                        value.setAppearState(appearState4);
                        value.didAppear();
                    }
                }
                for (Map.Entry<String, IPlugin> entry2 : getPlugins().entrySet()) {
                    IPlugin value2 = entry2.getValue();
                    if (value2.isAppearLevel() && !z2 && value2.getAppearState() != (appearState3 = AppearState.DID_APPEAR)) {
                        value2.setAppearState(appearState3);
                        value2.didAppear();
                    }
                }
                for (Map.Entry<String, IWidget> entry3 : getWidgets().entrySet()) {
                    IWidget value3 = entry3.getValue();
                    if (!value3.isAppearLevel() && value3.getAppearState() != (appearState2 = AppearState.DID_APPEAR)) {
                        value3.setAppearState(appearState2);
                        value3.willAppear();
                        value3.didAppear();
                    }
                }
                for (Map.Entry<String, IPlugin> entry4 : getPlugins().entrySet()) {
                    IPlugin value4 = entry4.getValue();
                    if (!value4.isAppearLevel() && value4.getAppearState() != (appearState = AppearState.DID_APPEAR)) {
                        value4.setAppearState(appearState);
                        value4.willAppear();
                        value4.didAppear();
                    }
                }
            } else {
                for (Map.Entry<String, IWidget> entry5 : getWidgets().entrySet()) {
                    IWidget value5 = entry5.getValue();
                    AppearState appearState5 = value5.getAppearState();
                    AppearState appearState6 = AppearState.DID_DISAPPEAR;
                    if (appearState5 != appearState6 && (!value5.isAppearLevel() || !z2)) {
                        value5.setAppearState(appearState6);
                        value5.willDisappear();
                        value5.didDisappear();
                    }
                }
                for (Map.Entry<String, IPlugin> entry6 : getPlugins().entrySet()) {
                    IPlugin value6 = entry6.getValue();
                    AppearState appearState7 = value6.getAppearState();
                    AppearState appearState8 = AppearState.DID_DISAPPEAR;
                    if (appearState7 != appearState8 && (!value6.isAppearLevel() || !z2)) {
                        value6.setAppearState(appearState8);
                        value6.willDisappear();
                        value6.didDisappear();
                    }
                }
            }
            if (RENDER_STATUS_RENDERING.equals(this.mRenderStatus)) {
                IPerfMonitor perfMonitor3 = getPerfMonitor();
                perfMonitor3.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.dispatchActiveStatus(" + z + ").rendering.error");
                return;
            }
            IPerfMonitor perfMonitor4 = getPerfMonitor();
            perfMonitor4.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.dispatchActiveStatus(" + z + jl1.BRACKET_END_STR);
        }
    }

    private void dispatchAppearStatus(boolean z) {
        AppearState appearState;
        AppearState appearState2;
        AppearState appearState3;
        AppearState appearState4;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "117107920")) {
            ipChange.ipc$dispatch("117107920", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_APPEAR_POINT, "{roomid:" + this.mRoomId + "}; dispatchAppearStatusStart('" + z + "');");
        if (this.mStatusAppear != z) {
            this.mStatusAppear = z;
            IPerfMonitor perfMonitor2 = getPerfMonitor();
            perfMonitor2.point(TAG_APPEAR_POINT, "{roomid:" + this.mRoomId + "}; dispatchAppearStatusEnd('" + z + "');");
            if (getConfig("CONFIG_ACTIVE_SKIP_APPEAR_LEVEL") == null) {
                z2 = false;
            }
            if (z) {
                for (Map.Entry<String, IWidget> entry : getWidgets().entrySet()) {
                    IWidget value = entry.getValue();
                    if (value.isAppearLevel() && !z2 && value.getAppearState() != (appearState4 = AppearState.WILL_APPEAR) && value.getAppearState() != AppearState.DID_APPEAR) {
                        value.setAppearState(appearState4);
                        value.willAppear();
                    }
                }
                for (Map.Entry<String, IPlugin> entry2 : getPlugins().entrySet()) {
                    IPlugin value2 = entry2.getValue();
                    if (value2.isAppearLevel() && !z2 && value2.getAppearState() != (appearState3 = AppearState.WILL_APPEAR) && value2.getAppearState() != AppearState.DID_APPEAR) {
                        value2.setAppearState(appearState3);
                        value2.willAppear();
                    }
                }
                return;
            }
            for (Map.Entry<String, IWidget> entry3 : getWidgets().entrySet()) {
                IWidget value3 = entry3.getValue();
                if (value3.isAppearLevel() && !z2 && value3.getAppearState() != (appearState2 = AppearState.DID_DISAPPEAR)) {
                    value3.setAppearState(appearState2);
                    value3.willDisappear();
                    value3.didDisappear();
                }
            }
            for (Map.Entry<String, IPlugin> entry4 : getPlugins().entrySet()) {
                IPlugin value4 = entry4.getValue();
                if (value4.isAppearLevel() && !z2 && value4.getAppearState() != (appearState = AppearState.DID_DISAPPEAR)) {
                    value4.setAppearState(appearState);
                    value4.willDisappear();
                    value4.didDisappear();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String generateLayerId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180793720")) {
            return (String) ipChange.ipc$dispatch("-1180793720", new Object[]{str});
        }
        if (mLayerIdMaker == null) {
            synchronized (WidgetInstance.class) {
                if (mLayerIdMaker == null) {
                    mLayerIdMaker = new AtomicLong(0);
                }
            }
        }
        long andIncrement = mLayerIdMaker.getAndIncrement();
        return str + "$" + andIncrement;
    }

    private Map<String, Object> getConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947719806")) {
            return (Map) ipChange.ipc$dispatch("-947719806", new Object[]{this});
        }
        if (this.mConfig == null) {
            synchronized (this) {
                if (this.mConfig == null) {
                    this.mConfig = new HashMap();
                }
            }
        }
        return this.mConfig;
    }

    private BaseDataCenter getDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832072677")) {
            return (BaseDataCenter) ipChange.ipc$dispatch("832072677", new Object[]{this});
        }
        if (this.mDataCenter == null) {
            synchronized (this) {
                if (this.mDataCenter == null) {
                    this.mDataCenter = new BaseDataCenter();
                }
            }
        }
        return this.mDataCenter;
    }

    private LinkedList<String> getDialogList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128033797")) {
            return (LinkedList) ipChange.ipc$dispatch("2128033797", new Object[]{this});
        }
        if (this.mDialogList == null) {
            synchronized (this) {
                if (this.mDialogList == null) {
                    this.mDialogList = new LinkedList<>();
                }
            }
        }
        return this.mDialogList;
    }

    private WidgetEngineContext getEngineContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "734853437")) {
            return this.mEngineContext;
        }
        return (WidgetEngineContext) ipChange.ipc$dispatch("734853437", new Object[]{this});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private EngineInstanceConnector getEngineInstanceConnector() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060352197")) {
            return (EngineInstanceConnector) ipChange.ipc$dispatch("-1060352197", new Object[]{this});
        }
        if (this.mInstanceConnector == null) {
            synchronized (this) {
                if (this.mInstanceConnector == null) {
                    this.mInstanceConnector = new EngineInstanceConnector(this);
                }
            }
        }
        return this.mInstanceConnector;
    }

    private EngineListenerConnector getEngineListenerConnector() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529246171")) {
            return (EngineListenerConnector) ipChange.ipc$dispatch("529246171", new Object[]{this});
        }
        if (this.mEngineListenerConnector == null) {
            synchronized (this) {
                this.mEngineListenerConnector = new EngineListenerConnector();
            }
        }
        return this.mEngineListenerConnector;
    }

    private BaseEventDispatcher getEventDispatcher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639957307")) {
            return (BaseEventDispatcher) ipChange.ipc$dispatch("639957307", new Object[]{this});
        }
        if (this.mEventDispatcher == null) {
            synchronized (this) {
                if (this.mEventDispatcher == null) {
                    this.mEventDispatcher = new BaseEventDispatcher();
                }
            }
        }
        return this.mEventDispatcher;
    }

    private Handler getHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355942123")) {
            return (Handler) ipChange.ipc$dispatch("-355942123", new Object[]{this});
        }
        if (this.mHandler == null) {
            synchronized (this) {
                if (this.mHandler == null) {
                    this.mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.mHandler;
    }

    public static HandlerThread getHandlerThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60931285")) {
            return (HandlerThread) ipChange.ipc$dispatch("60931285", new Object[0]);
        }
        if (sHandlerThread == null) {
            synchronized (WidgetInstance.class) {
                if (sHandlerThread == null) {
                    HandlerThread handlerThread = new HandlerThread("widget-instance");
                    sHandlerThread = handlerThread;
                    handlerThread.start();
                }
            }
        }
        return sHandlerThread;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, IPlugin> getPlugins() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955291376")) {
            return (Map) ipChange.ipc$dispatch("1955291376", new Object[]{this});
        }
        if (this.mPlugins == null) {
            synchronized (this) {
                if (this.mPlugins == null) {
                    this.mPlugins = new HashMap();
                }
            }
        }
        return this.mPlugins;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ITemplateBuilder getTemplateBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-816513493")) {
            return this;
        }
        return (ITemplateBuilder) ipChange.ipc$dispatch("-816513493", new Object[]{this});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ITemplateWidgetBuildCallback getTemplateWidgetBuildCallback() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37617621")) {
            return (ITemplateWidgetBuildCallback) ipChange.ipc$dispatch("-37617621", new Object[]{this});
        }
        if (this.mTemplateWidgetBuildCallback == null) {
            synchronized (WidgetInstance.class) {
                if (this.mTemplateWidgetBuildCallback == null) {
                    this.mTemplateWidgetBuildCallback = new ITemplateWidgetBuildCallback() {
                        /* class com.youku.live.widgets.WidgetInstance.AnonymousClass5 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback
                        public void onBuildPlugin(PluginModel pluginModel, IPlugin iPlugin) {
                            String str;
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1510944852")) {
                                ipChange.ipc$dispatch("1510944852", new Object[]{this, pluginModel, iPlugin});
                                return;
                            }
                            if (!(iPlugin == null || pluginModel == null || (str = pluginModel.name) == null)) {
                                if (iPlugin instanceof BasePlugin) {
                                    BasePlugin basePlugin = (BasePlugin) iPlugin;
                                    if (basePlugin.name == null) {
                                        basePlugin.name = str;
                                    }
                                    if (basePlugin.id == null) {
                                        basePlugin.id = WidgetInstance.generateLayerId(str);
                                    }
                                    basePlugin.isDynamic = WidgetInstance.this.mCreateIsDynamic;
                                }
                                WidgetInstance.this.getPlugins().put(pluginModel.name, iPlugin);
                            }
                            WidgetInstance.this.processListenerAttach(iPlugin);
                        }

                        @Override // com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback
                        public void onBuildWidget(WidgetModel widgetModel, IWidget iWidget) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "2049415041")) {
                                ipChange.ipc$dispatch("2049415041", new Object[]{this, widgetModel, iWidget});
                                return;
                            }
                            WidgetInstance.this.processListenerAttach(iWidget);
                        }

                        @Override // com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback
                        public IPlugin onPreBuildPlugin(PluginModel pluginModel) {
                            IpChange ipChange = $ipChange;
                            if (!AndroidInstantRuntime.support(ipChange, "6962415")) {
                                return (IPlugin) WidgetInstance.this.getPlugins().get(pluginModel.name);
                            }
                            return (IPlugin) ipChange.ipc$dispatch("6962415", new Object[]{this, pluginModel});
                        }

                        @Override // com.youku.live.widgets.protocol.ITemplateWidgetBuildCallback
                        public void onPreBuildWidget(WidgetModel widgetModel, IWidget iWidget) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1039465720")) {
                                ipChange.ipc$dispatch("-1039465720", new Object[]{this, widgetModel, iWidget});
                            } else if (widgetModel != null) {
                                if (widgetModel.id == null) {
                                    widgetModel.id = WidgetInstance.generateLayerId(widgetModel.name);
                                }
                                if (iWidget instanceof BaseWidget) {
                                    BaseWidget baseWidget = (BaseWidget) iWidget;
                                    baseWidget.name = widgetModel.name;
                                    baseWidget.id = widgetModel.id;
                                    baseWidget.isDynamic = WidgetInstance.this.mCreateIsDynamic;
                                }
                                WidgetInstance.this.getWidgets().put(widgetModel.id, iWidget);
                            }
                        }
                    };
                }
            }
        }
        return this.mTemplateWidgetBuildCallback;
    }

    private List<IEngineInstanceVisibleListener> getVisibleListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278221051")) {
            return (List) ipChange.ipc$dispatch("-278221051", new Object[]{this});
        }
        if (this.mVisibleListeners == null) {
            synchronized (this) {
                if (this.mVisibleListeners == null) {
                    this.mVisibleListeners = new ArrayList();
                }
            }
        }
        return this.mVisibleListeners;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<String, IWidget> getWidgets() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097397823")) {
            return (Map) ipChange.ipc$dispatch("-1097397823", new Object[]{this});
        }
        if (this.mWidgets == null) {
            synchronized (this) {
                if (this.mWidgets == null) {
                    this.mWidgets = new HashMap();
                }
            }
        }
        return this.mWidgets;
    }

    private void initConfigMananger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16450618")) {
            ipChange.ipc$dispatch("-16450618", new Object[]{this});
            return;
        }
        WidgetEngineContext engineContext = getEngineContext();
        if (engineContext != null) {
            this.skipDumplicateInitHostViewWidgets = engineContext.getConfigMananger().getBoolean("live_widget_kit", "skipDumplicateInitHostViewWidgets", this.skipDumplicateInitHostViewWidgets);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRenderSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1586576023")) {
            ipChange.ipc$dispatch("1586576023", new Object[]{this});
        } else if (RENDER_STATUS_RENDERED.equals(this.mRenderPluginStatus) && RENDER_STATUS_RENDERED.equals(this.mRenderWidgetStatus) && RENDER_STATUS_RENDERED.equals(this.mRenderViewStatus)) {
            AnonymousClass4 r0 = new Runnable() {
                /* class com.youku.live.widgets.WidgetInstance.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1910734518")) {
                        ipChange.ipc$dispatch("-1910734518", new Object[]{this});
                        return;
                    }
                    IPerfMonitor perfMonitor = WidgetInstance.this.getPerfMonitor();
                    perfMonitor.point(WidgetInstance.TAG_RENDER_POINT, "{roomid:" + WidgetInstance.this.mRoomId + "}.finish.begin");
                    if (WidgetInstance.this.mRenderListener != null) {
                        WidgetInstance.this.mRenderListener.onRenderSuccess(WidgetInstance.this);
                    }
                    WidgetInstance.this.setElementCreateByDynamic(true);
                    WidgetInstance.this.mRenderStatus = WidgetInstance.RENDER_STATUS_RENDERED;
                    IPerfMonitor perfMonitor2 = WidgetInstance.this.getPerfMonitor();
                    perfMonitor2.point(WidgetInstance.TAG_RENDER_POINT, "{roomid:" + WidgetInstance.this.mRoomId + "}.finish.end; mStatusActive:" + WidgetInstance.this.mStatusActive + "; Success: render finished !!!!!!!!!");
                }
            };
            if (this.mSyncRenderMode) {
                r0.run();
            } else {
                WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(r0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onViewRenderSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567510492")) {
            ipChange.ipc$dispatch("1567510492", new Object[]{this});
            return;
        }
        this.mRenderViewCount++;
        if (RENDER_STATUS_RENDERED.equals(this.mRenderWidgetStatus) && this.mRenderWidgetCount == this.mRenderViewCount) {
            this.mRenderViewStatus = RENDER_STATUS_RENDERED;
            getPerfMonitor().point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.viewAttachFinished");
            onRenderSuccess();
        }
    }

    private void onWidgetRenderSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "635992507")) {
            ipChange.ipc$dispatch("635992507", new Object[]{this});
            return;
        }
        this.mRenderWidgetStatus = RENDER_STATUS_RENDERED;
        if (this.mRenderWidgetCount == this.mRenderViewCount) {
            this.mRenderViewStatus = RENDER_STATUS_RENDERED;
            onRenderSuccess();
        }
    }

    private void patch(TemplateModel templateModel, IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809337397")) {
            ipChange.ipc$dispatch("1809337397", new Object[]{this, templateModel, iProps});
            return;
        }
        patchForLaifeng(templateModel, iProps);
    }

    private void patchForLaifeng(TemplateModel templateModel, IProps iProps) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-753994856")) {
            ipChange.ipc$dispatch("-753994856", new Object[]{this, templateModel, iProps});
            return;
        }
        if (templateModel != null) {
            String str = templateModel._raw;
            if (str != null && str.contains("LaifengAudioCtrl")) {
                z = true;
            }
            List<PluginModel> list = templateModel.plugins;
            if (list != null) {
                Iterator<PluginModel> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        PluginModel next = it.next();
                        if (next != null && "LaifengAudioCtrl".equals(next.name)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (z) {
            createPluginIfNotExists("Gift");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processListenerAttach(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570621561")) {
            ipChange.ipc$dispatch("1570621561", new Object[]{this, obj});
            return;
        }
        if (obj instanceof IActivityBackPressedListener) {
            getEngineListenerConnector().getActivityBackPressedListeners().add((IActivityBackPressedListener) obj);
        }
        if (obj instanceof IActivityConfigurationChangedListener) {
            getEngineListenerConnector().getActivityConfigurationChangedListeners().add((IActivityConfigurationChangedListener) obj);
        }
        if (obj instanceof IActivityConfigurationOrientationChangedListener) {
            getEngineListenerConnector().getActivityConfigurationOrientationChangedListeners().add((IActivityConfigurationOrientationChangedListener) obj);
        }
        if (obj instanceof IActivityLowMemoryListener) {
            getEngineListenerConnector().getActivityLowMemoryListeners().add((IActivityLowMemoryListener) obj);
        }
        if (obj instanceof IActivityRequestPermissionsResultListener) {
            getEngineListenerConnector().getActivityRequestPermissionsResultListeners().add((IActivityRequestPermissionsResultListener) obj);
        }
        if (obj instanceof IActivityResultListener) {
            getEngineListenerConnector().getActivityResultListeners().add((IActivityResultListener) obj);
        }
        if (obj instanceof IActivityLifecycleStateChangedListener) {
            getEngineListenerConnector().getActivityLifecycleStateChangedListeners().add((IActivityLifecycleStateChangedListener) obj);
        }
        if (obj instanceof IActivityKeyDownListener) {
            getEngineListenerConnector().getActivityKeyDownListeners().add((IActivityKeyDownListener) obj);
        }
    }

    private void releaseWidgetsPlugins() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414033299")) {
            ipChange.ipc$dispatch("-414033299", new Object[]{this});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r3v40, types: [android.view.ViewGroup] */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x04cf  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0352  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void renderImp(IEngineInstance iEngineInstance, IWidget iWidget, CSSLayout cSSLayout, final WidgetModel widgetModel, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, boolean z, IProps iProps, boolean z2, boolean z3, int i) {
        boolean z4;
        CSSLayout cSSLayout2;
        CSSLayout cSSLayout3;
        final CSSLayout cSSLayout4;
        final CSSLayout cSSLayout5;
        final View view;
        boolean z5;
        IWidget iWidget2;
        IWidget iWidget3;
        boolean z6;
        final CSSLayout.LayoutParams layoutParams;
        boolean z7;
        boolean z8;
        View view2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979686798")) {
            ipChange.ipc$dispatch("979686798", new Object[]{this, iEngineInstance, iWidget, cSSLayout, widgetModel, Float.valueOf(f), iTemplateWidgetBuildCallback, Boolean.valueOf(z), iProps, Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)});
        } else if (widgetModel != null) {
            getPerfMonitor().perfPointBegin(widgetModel.name);
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.begin");
            List<WidgetModel> list = widgetModel.children;
            boolean z9 = list != null && list.size() > 0;
            WidgetEngineContext engineContext = getEngineContext();
            final IWidget createWidget = engineContext != null ? engineContext.getWidgetMananger().createWidget(widgetModel.name) : null;
            if (createWidget == null) {
                createWidget = WidgetSDKManager.getInstance().createWidget(widgetModel.name);
            }
            if (createWidget instanceof BaseWidget) {
                BaseWidget baseWidget = (BaseWidget) createWidget;
                z4 = baseWidget.mRecycled;
                baseWidget.mAppearState = AppearState.DID_DISAPPEAR;
                baseWidget.mEngineInstance = iEngineInstance;
                baseWidget.mIsAppearLevel = WidgetEngineRenderConfig.getInstance().isAppearLevelWidget(widgetModel.name);
            } else {
                z4 = false;
            }
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.createWidget." + widgetModel.name + "::" + createWidget);
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onPreBuildWidget(widgetModel, createWidget);
            }
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.preBuildWidget." + widgetModel.name + "::" + createWidget);
            WidgetAttributesModel widgetAttributesModel = widgetModel.atts;
            if (widgetAttributesModel == null) {
                widgetAttributesModel = null;
            }
            BaseWidgetData options = new BaseWidgetData(widgetAttributesModel).setOptions(iProps);
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.currentWidgetData." + widgetModel.name + "::" + createWidget);
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onBuildWidget(widgetModel, createWidget);
            }
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.onBuildWidget." + widgetModel.name + "::" + createWidget);
            createWidget.willMount();
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.willMount." + widgetModel.name + "::" + createWidget);
            if (cSSLayout != null) {
                cSSLayout2 = cSSLayout;
            } else {
                cSSLayout2 = (ViewGroup) iWidget.getHostView();
            }
            if (z9) {
                if (!(cSSLayout2 instanceof CSSLayout)) {
                    CSSLayout cSSLayout6 = new CSSLayout(iEngineInstance.getContext());
                    CopyOnWriteArrayList<CSSLayout> copyOnWriteArrayList = this.mCSSLayouts;
                    if (copyOnWriteArrayList != null) {
                        copyOnWriteArrayList.clear();
                        this.mCSSLayouts.add(cSSLayout6);
                    }
                    cSSLayout6.enableNotifyConfigChanged(this.enableCSSLayoutConfigChanged);
                    cSSLayout3 = cSSLayout6;
                    getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.parentContainerView." + widgetModel.name + "::" + createWidget);
                    if (!z4) {
                        View hostView = createWidget.getHostView();
                        getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.getHostView." + widgetModel.name + "::" + createWidget);
                        view = hostView;
                        cSSLayout4 = cSSLayout2;
                        cSSLayout5 = cSSLayout3;
                    } else {
                        Throwable th = new Throwable();
                        boolean z10 = createWidget instanceof BaseWidget;
                        if (z10) {
                            BaseWidget baseWidget2 = (BaseWidget) createWidget;
                            if (baseWidget2.mIsInitHostView) {
                                Throwable th2 = baseWidget2.mInitHostViewThrowable;
                                IPerfMonitor perfMonitor = getPerfMonitor();
                                cSSLayout4 = cSSLayout2;
                                StringBuilder sb = new StringBuilder();
                                sb.append("{roomid:");
                                sb.append(this.mRoomId);
                                sb.append("}.initHostView.matchCrashDanger.");
                                sb.append(widgetModel.name);
                                sb.append("::");
                                sb.append(createWidget);
                                sb.append("; skipDumplicateInitHostViewWidgets:");
                                sb.append(this.skipDumplicateInitHostViewWidgets);
                                sb.append("\n===\n");
                                cSSLayout5 = cSSLayout3;
                                sb.append(th.getMessage());
                                sb.append("\n===\n");
                                sb.append(th2 != null ? th2.getMessage() : "NO PREV !!!");
                                sb.append("\n===\n");
                                perfMonitor.point(TAG_RENDER_IMP, sb.toString());
                                z8 = true;
                                if (z8 || !this.skipDumplicateInitHostViewWidgets) {
                                    view2 = createWidget.initHostView(iEngineInstance.getContext());
                                } else {
                                    view2 = createWidget.getHostView();
                                    if (view2 == null) {
                                        view2 = new FrameLayout(getContext());
                                    }
                                }
                                if (z10) {
                                    BaseWidget baseWidget3 = (BaseWidget) createWidget;
                                    baseWidget3.mInitHostViewThrowable = th;
                                    baseWidget3.mIsInitHostView = true;
                                }
                                getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.initHostView." + widgetModel.name + "::" + createWidget);
                                view = view2;
                            }
                        }
                        cSSLayout4 = cSSLayout2;
                        cSSLayout5 = cSSLayout3;
                        z8 = false;
                        if (z8) {
                        }
                        view2 = createWidget.initHostView(iEngineInstance.getContext());
                        if (z10) {
                        }
                        getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.initHostView." + widgetModel.name + "::" + createWidget);
                        view = view2;
                    }
                    createWidget.initWithData(iEngineInstance, iWidget, options);
                    getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.initWithData." + widgetModel.name + "::" + createWidget);
                    z5 = createWidget instanceof BaseWidget;
                    if (!z5) {
                        BaseWidget baseWidget4 = (BaseWidget) createWidget;
                        baseWidget4.mHostView = view;
                        if (cSSLayout5 instanceof CSSLayout) {
                            WidgetAttributesModel widgetAttributesModel2 = widgetModel.atts;
                            WidgetAttributesModel.OrientationModel orientationModel = widgetAttributesModel2.portrait;
                            WidgetAttributesModel.OrientationModel orientationModel2 = widgetAttributesModel2.landscape;
                            if (orientationModel2 == null) {
                                orientationModel2 = orientationModel;
                            } else if (orientationModel2.visible != null) {
                                getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.initWithData." + widgetModel.name + "::" + createWidget + "::Visible:" + orientationModel2.visible);
                            }
                            ViewGroup.LayoutParams layoutParams2 = createWidget.getLayoutParams();
                            if (layoutParams2 instanceof CSSLayout.LayoutParams) {
                                CSSLayout.LayoutParams layoutParams3 = (CSSLayout.LayoutParams) layoutParams2;
                                layoutParams3.useCSSLayout = true;
                                layoutParams3.aspectRatio = f;
                                if (layoutParams3.portraitModel == null) {
                                    layoutParams3.portraitModel = orientationModel;
                                }
                                WidgetAttributesModel.OrientationModel orientationModel3 = layoutParams3.landscapeModel;
                                if (orientationModel3 == null) {
                                    layoutParams3.landscapeModel = orientationModel2;
                                } else if (!(orientationModel3 == null || orientationModel2 == null)) {
                                    orientationModel3.visible = orientationModel2.visible;
                                }
                                layoutParams = layoutParams3;
                            } else {
                                CSSLayout.LayoutParams layoutParams4 = new CSSLayout.LayoutParams(-1, -1);
                                layoutParams4.setOrientationModel(orientationModel, orientationModel2, f);
                                WidgetAttributesModel.OrientationModel orientationModel4 = layoutParams4.portraitModel;
                                if (orientationModel4 == null || !Boolean.TRUE.equals(orientationModel4.safeArea) || z2) {
                                    layoutParams = layoutParams4;
                                } else {
                                    WidgetAttributesModel.OrientationModel orientationModel5 = layoutParams4.portraitModel;
                                    if (orientationModel5.margin == null) {
                                        orientationModel5.margin = new WidgetAttributesModel.MarginModel();
                                    }
                                    WidgetAttributesModel.MarginModel marginModel = layoutParams4.portraitModel.margin;
                                    Integer num = marginModel.t;
                                    if (num == null) {
                                        if (marginModel.b == null) {
                                            marginModel.hasAppendSafeArea = true;
                                            marginModel.t = Integer.valueOf(i);
                                        }
                                    } else if (!marginModel.hasAppendSafeArea) {
                                        marginModel.hasAppendSafeArea = true;
                                        marginModel.t = Integer.valueOf(num.intValue() + i);
                                    }
                                    layoutParams = layoutParams4;
                                    z7 = true;
                                    if (z5) {
                                        baseWidget4.setCSSLayoutParams(layoutParams, layoutParams);
                                    }
                                    z6 = z7;
                                }
                            }
                            z7 = z2;
                            if (z5) {
                            }
                            z6 = z7;
                        } else {
                            z6 = z2;
                            layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        }
                        getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.viewGroupLayoutParams." + widgetModel.name + "::" + createWidget);
                        AnonymousClass3 r10 = new Runnable() {
                            /* class com.youku.live.widgets.WidgetInstance.AnonymousClass3 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1714221013")) {
                                    ipChange.ipc$dispatch("-1714221013", new Object[]{this});
                                    return;
                                }
                                IPerfMonitor perfMonitor = WidgetInstance.this.getPerfMonitor();
                                perfMonitor.point(WidgetInstance.TAG_RENDER_IMP, "{roomid:" + WidgetInstance.this.mRoomId + "}.addView.begin" + widgetModel.name + "::" + createWidget);
                                if (!cSSLayout5.equals(cSSLayout4)) {
                                    cSSLayout4.addView(cSSLayout5, new ViewGroup.LayoutParams(-1, -1));
                                }
                                createWidget.willAttachView();
                                cSSLayout5.addView(view, layoutParams);
                                IPerfMonitor perfMonitor2 = WidgetInstance.this.getPerfMonitor();
                                perfMonitor2.point(WidgetInstance.TAG_RENDER_IMP, "{roomid:" + WidgetInstance.this.mRoomId + "}.addView.end" + widgetModel.name + "::" + createWidget);
                                createWidget.didAttachView();
                                createWidget.didViewAttach();
                                WidgetInstance.this.onViewRenderSuccess();
                            }
                        };
                        if (this.mSyncRenderMode) {
                            r10.run();
                        } else {
                            WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(r10);
                        }
                        getPerfMonitor().perfPointEnd(widgetModel.name, "");
                        if (z9) {
                            for (WidgetModel widgetModel2 : list) {
                                if (widgetModel2 != null) {
                                    renderImp(iEngineInstance, createWidget, view instanceof CSSLayout ? (CSSLayout) view : null, widgetModel2, f, iTemplateWidgetBuildCallback, false, iProps, z6, z3, i);
                                } else {
                                    WidgetAttributesModel widgetAttributesModel3 = widgetModel2.atts;
                                }
                            }
                        }
                        iWidget3 = iWidget;
                        iWidget2 = createWidget;
                    } else {
                        iWidget3 = iWidget;
                        iWidget2 = createWidget;
                    }
                    iWidget3.addChild(iWidget2);
                    iWidget2.didMount();
                    this.mRenderWidgetCount++;
                    if (!z) {
                        onWidgetRenderSuccess();
                        return;
                    }
                    return;
                }
            } else if (cSSLayout2 instanceof CSSLayout) {
                CopyOnWriteArrayList<CSSLayout> copyOnWriteArrayList2 = this.mCSSLayouts;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(cSSLayout2);
                }
                cSSLayout2.enableNotifyConfigChanged(this.enableCSSLayoutConfigChanged);
            }
            cSSLayout3 = cSSLayout2;
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.parentContainerView." + widgetModel.name + "::" + createWidget);
            if (!z4) {
            }
            createWidget.initWithData(iEngineInstance, iWidget, options);
            getPerfMonitor().point(TAG_RENDER_IMP, "{roomid:" + this.mRoomId + "}.initWithData." + widgetModel.name + "::" + createWidget);
            z5 = createWidget instanceof BaseWidget;
            if (!z5) {
            }
            iWidget3.addChild(iWidget2);
            iWidget2.didMount();
            this.mRenderWidgetCount++;
            if (!z) {
            }
        }
    }

    private void renderInternalImp(final TemplateModel templateModel, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825557466")) {
            ipChange.ipc$dispatch("-1825557466", new Object[]{this, templateModel, map, map2});
        } else if (templateModel != null) {
            if (!(map == null && map2 == null)) {
                final BaseProps putValues = new BaseProps().putValues(map);
                BaseProps putValuesString = new BaseProps().putValuesString(templateModel.theme);
                this.mSyncRenderMode = putValues.getBoolean("syncRenderMode", true);
                this.mRoomId = putValues.getString("liveId", null);
                try {
                    i = Integer.valueOf(putValues.getString("safeAreaTopPx", "0")).intValue();
                } catch (Throwable unused) {
                    i = 0;
                }
                getPerfMonitor().perfPointBegin("renderInternalImp");
                if (RENDER_STATUS_IDLE.equals(this.mRenderStatus)) {
                    this.mRenderStatus = RENDER_STATUS_RENDERING;
                    IPerfMonitor perfMonitor = getPerfMonitor();
                    perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.begin, Success: use idle widgetInstance to render");
                } else if (RENDER_STATUS_RENDERING.equals(this.mRenderStatus)) {
                    getPerfMonitor().perfPointEnd("renderInternalImp", "").perfEnable("renderInternalImp", false);
                    IPerfMonitor perfMonitor2 = getPerfMonitor();
                    perfMonitor2.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.begin, Failure: use rendering widgetInstance to render");
                    return;
                } else if (RENDER_STATUS_RENDERED.equals(this.mRenderStatus)) {
                    this.mRenderStatus = RENDER_STATUS_RENDERING;
                    IPerfMonitor perfMonitor3 = getPerfMonitor();
                    perfMonitor3.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.begin, Success: use rendered widgetInstance to render");
                    clearImp(true, true);
                }
                getPerfMonitor().perfPointBegin("createHostViewCreated");
                this.mRenderPluginStatus = RENDER_STATUS_RENDERING;
                this.mRenderWidgetStatus = RENDER_STATUS_RENDERING;
                this.mRenderViewStatus = RENDER_STATUS_RENDERING;
                this.mRenderWidgetCount = 0;
                this.mRenderViewCount = 0;
                if (map2 != null) {
                    for (Map.Entry<String, Object> entry : map2.entrySet()) {
                        putDataOnly(entry.getKey(), entry.getValue());
                    }
                }
                patch(templateModel, putValues);
                IPerfMonitor perfMonitor4 = getPerfMonitor();
                perfMonitor4.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.start");
                setElementCreateByDynamic(false);
                IPerfMonitor perfMonitor5 = getPerfMonitor();
                perfMonitor5.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.deserialize");
                this.mTemplateModel = templateModel;
                this.mOptions = putValues;
                this.mTheme = putValuesString;
                final RenderWidget renderWidget = new RenderWidget();
                this.mRenderWidget = renderWidget;
                IPerfMonitor perfMonitor6 = getPerfMonitor();
                perfMonitor6.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.RenderWidget");
                final EngineInstanceConnector engineInstanceConnector = getEngineInstanceConnector();
                renderWidget.mEngineInstance = engineInstanceConnector;
                renderWidget.mHostView = renderWidget.initHostView(this.mContext);
                IPerfMonitor perfMonitor7 = getPerfMonitor();
                perfMonitor7.point("WidgetInstance.render.", "{roomid:" + this.mRoomId + "}.initHostView");
                renderWidget.initWithData(engineInstanceConnector, null, null);
                IPerfMonitor perfMonitor8 = getPerfMonitor();
                perfMonitor8.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.initWithData");
                final float screenWidth = ((float) ViewUtils.getScreenWidth(this.mContext)) / ((float) getStandardWidth());
                final int i2 = (int) ((((float) i) / screenWidth) + 0.5f);
                IPerfMonitor perfMonitor9 = getPerfMonitor();
                perfMonitor9.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.getScreenSize");
                renderWidget.willMount();
                IPerfMonitor perfMonitor10 = getPerfMonitor();
                perfMonitor10.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.willMount");
                IEngineRenderListener iEngineRenderListener = this.mRenderListener;
                if (iEngineRenderListener != null) {
                    iEngineRenderListener.onHostViewCreated(this, renderWidget.getHostView());
                    IPerfMonitor perfMonitor11 = getPerfMonitor();
                    perfMonitor11.point(TAG_RENDER_RENDER, "{roomid:" + this.mRoomId + "}.onHostViewCreated");
                }
                getPerfMonitor().perfPointEnd("createHostViewCreated", "");
                AnonymousClass1 r6 = new Runnable() {
                    /* class com.youku.live.widgets.WidgetInstance.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1321194003")) {
                            ipChange.ipc$dispatch("-1321194003", new Object[]{this});
                            return;
                        }
                        WidgetInstance.this.getPerfMonitor().perfPointBegin("renderWidgets");
                        WidgetInstance widgetInstance = WidgetInstance.this;
                        widgetInstance.renderImp(engineInstanceConnector, renderWidget, null, templateModel.widget, screenWidth, widgetInstance.getTemplateWidgetBuildCallback(), true, putValues, false, false, i2);
                        WidgetInstance.this.getPerfMonitor().perfPointEnd("renderWidgets", "");
                        IPerfMonitor perfMonitor = WidgetInstance.this.getPerfMonitor();
                        perfMonitor.point(WidgetInstance.TAG_RENDER_RENDER, "{roomid:" + WidgetInstance.this.mRoomId + "}.widgetRenderFinished");
                    }
                };
                AnonymousClass2 r0 = new Runnable() {
                    /* class com.youku.live.widgets.WidgetInstance.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1517707508")) {
                            ipChange.ipc$dispatch("-1517707508", new Object[]{this});
                            return;
                        }
                        WidgetInstance.this.getPerfMonitor().perfPointBegin("renderPlugins");
                        WidgetInstance.this.getTemplateBuilder().buildPluginsWithTemplate(WidgetInstance.this.getEngineInstanceConnector(), templateModel.plugins, screenWidth, WidgetInstance.this.getTemplateWidgetBuildCallback(), putValues);
                        WidgetInstance.this.getPerfMonitor().perfPointEnd("renderPlugins", "");
                        IPerfMonitor perfMonitor = WidgetInstance.this.getPerfMonitor();
                        perfMonitor.point(WidgetInstance.TAG_RENDER_RENDER, "{roomid:" + WidgetInstance.this.mRoomId + "}.pluginRenderFinished");
                        WidgetInstance.this.mRenderPluginStatus = WidgetInstance.RENDER_STATUS_RENDERED;
                        WidgetInstance.this.onRenderSuccess();
                    }
                };
                if (this.mSyncRenderMode) {
                    r6.run();
                    r0.run();
                } else {
                    WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(r6);
                    WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(r0);
                }
                getPerfMonitor().perfPointEnd("renderInternalImp", "").perfEnable("renderInternalImp", false);
                IPerfMonitor perfMonitor12 = getPerfMonitor();
                perfMonitor12.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.render.end");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setElementCreateByDynamic(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926954527")) {
            ipChange.ipc$dispatch("-1926954527", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCreateIsDynamic = z;
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(String str, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910104352")) {
            ipChange.ipc$dispatch("-1910104352", new Object[]{this, str, iDataHandler});
            return;
        }
        getDataCenter().addDataHandler(str, iDataHandler);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(String[] strArr, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578472994")) {
            ipChange.ipc$dispatch("-578472994", new Object[]{this, strArr, iDataHandler});
            return;
        }
        getDataCenter().addDataHandlers(strArr, iDataHandler);
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public boolean addEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1873413322")) {
            return getEventDispatcher().addEventHandler(str, iEventHandler);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1873413322", new Object[]{this, str, iEventHandler})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String addLayer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538001793")) {
            return (String) ipChange.ipc$dispatch("538001793", new Object[]{this, str});
        }
        WidgetModel widgetModel = (WidgetModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, WidgetModel.class);
        if (widgetModel.id == null) {
            widgetModel.id = generateLayerId(widgetModel.name);
        }
        int screenWidth = ViewUtils.getScreenWidth(this.mContext);
        TemplateModel templateModel = this.mTemplateModel;
        float f = ((float) screenWidth) / ((float) (templateModel != null ? templateModel.standardWidth : FeatureFactory.PRIORITY_ABOVE_NORMAL));
        IWidget findWidgetById = findWidgetById("live-weex");
        if (findWidgetById != null) {
            findWidgetById = findWidgetById.getParent();
        }
        if (findWidgetById == null) {
            findWidgetById = this.mRenderWidget;
        }
        getTemplateBuilder().buildWidgetsWithTemplate(getEngineInstanceConnector(), findWidgetById, null, widgetModel, f, getTemplateWidgetBuildCallback(), getOptions());
        return widgetModel.id;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void addVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804927457")) {
            ipChange.ipc$dispatch("804927457", new Object[]{this, iEngineInstanceVisibleListener});
            return;
        }
        getVisibleListeners().add(iEngineInstanceVisibleListener);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761836434")) {
            ipChange.ipc$dispatch("-1761836434", new Object[]{this, str, obj});
            return;
        }
        getDataCenter().asyncPutData(str, obj);
    }

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public IPlugin buildPluginWithName(IEngineInstance iEngineInstance, PluginModel pluginModel, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876351565")) {
            return (IPlugin) ipChange.ipc$dispatch("1876351565", new Object[]{this, iEngineInstance, pluginModel, iTemplateWidgetBuildCallback, iProps});
        }
        getPerfMonitor().perfPointBegin(pluginModel.name);
        IPlugin iPlugin = null;
        if (iTemplateWidgetBuildCallback != null) {
            iPlugin = iTemplateWidgetBuildCallback.onPreBuildPlugin(pluginModel);
        }
        if (iPlugin == null) {
            iPlugin = WidgetSDKManager.getInstance().createPlugin(pluginModel.name);
            if (iPlugin instanceof BasePlugin) {
                BasePlugin basePlugin = (BasePlugin) iPlugin;
                basePlugin.mAppearState = AppearState.UNKNOWN;
                basePlugin.bindEngineInstance(iEngineInstance);
            }
        }
        if (iPlugin != null) {
            BasePluginData basePluginData = new BasePluginData(pluginModel);
            basePluginData.setOptions(iProps);
            if (iPlugin instanceof BasePlugin) {
                ((BasePlugin) iPlugin).mIsAppearLevel = WidgetEngineRenderConfig.getInstance().isAppearLevelPlugin(pluginModel.name);
            }
            iPlugin.initWithData(iEngineInstance, basePluginData);
            iPlugin.willMount();
            iPlugin.didMount();
        }
        if (iTemplateWidgetBuildCallback != null) {
            iTemplateWidgetBuildCallback.onBuildPlugin(pluginModel, iPlugin);
        }
        getPerfMonitor().perfPointEnd(pluginModel.name, "");
        return iPlugin;
    }

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public void buildPluginsWithTemplate(IEngineInstance iEngineInstance, List<PluginModel> list, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782371948")) {
            ipChange.ipc$dispatch("-782371948", new Object[]{this, iEngineInstance, list, Float.valueOf(f), iTemplateWidgetBuildCallback, iProps});
        } else if (list != null) {
            for (PluginModel pluginModel : list) {
                if (!(pluginModel == null || pluginModel.name == null)) {
                    buildPluginWithName(iEngineInstance, pluginModel, iTemplateWidgetBuildCallback, iProps);
                }
            }
        }
    }

    @Override // com.youku.live.widgets.protocol.ITemplateBuilder
    public void buildWidgetsWithTemplate(IEngineInstance iEngineInstance, IWidget iWidget, CSSLayout cSSLayout, WidgetModel widgetModel, float f, ITemplateWidgetBuildCallback iTemplateWidgetBuildCallback, IProps iProps) {
        ViewGroup viewGroup;
        View view;
        CSSLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1588929556")) {
            ipChange.ipc$dispatch("1588929556", new Object[]{this, iEngineInstance, iWidget, cSSLayout, widgetModel, Float.valueOf(f), iTemplateWidgetBuildCallback, iProps});
        } else if (widgetModel != null) {
            List<WidgetModel> list = widgetModel.children;
            boolean z2 = list != null && list.size() > 0;
            WidgetEngineContext engineContext = getEngineContext();
            IWidget createWidget = engineContext != null ? engineContext.getWidgetMananger().createWidget(widgetModel.name) : null;
            if (createWidget == null) {
                createWidget = WidgetSDKManager.getInstance().createWidget(widgetModel.name);
            }
            if (createWidget instanceof BaseWidget) {
                BaseWidget baseWidget = (BaseWidget) createWidget;
                z = baseWidget.mRecycled;
                baseWidget.mAppearState = AppearState.UNKNOWN;
                baseWidget.mEngineInstance = iEngineInstance;
                baseWidget.mIsAppearLevel = WidgetEngineRenderConfig.getInstance().isAppearLevelWidget(widgetModel.name);
            }
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onPreBuildWidget(widgetModel, createWidget);
            }
            WidgetAttributesModel widgetAttributesModel = widgetModel.atts;
            if (widgetAttributesModel == null) {
                widgetAttributesModel = null;
            }
            BaseWidgetData baseWidgetData = new BaseWidgetData(widgetAttributesModel);
            if (iTemplateWidgetBuildCallback != null) {
                iTemplateWidgetBuildCallback.onBuildWidget(widgetModel, createWidget);
            }
            createWidget.initWithData(iEngineInstance, iWidget, baseWidgetData);
            createWidget.willMount();
            if (cSSLayout != null) {
                viewGroup = cSSLayout;
            } else {
                viewGroup = (ViewGroup) iWidget.getHostView();
            }
            if (cSSLayout == null) {
                ViewGroup viewGroup2 = (ViewGroup) iWidget.getRealView();
            }
            if (z2 && !(viewGroup instanceof CSSLayout)) {
                ViewGroup cSSLayout2 = new CSSLayout(iEngineInstance.getContext());
                viewGroup.addView(cSSLayout2, new ViewGroup.LayoutParams(-1, -1));
                viewGroup = cSSLayout2;
            }
            if (z) {
                view = createWidget.getHostView();
            } else {
                view = createWidget.initHostView(iEngineInstance.getContext());
            }
            if (createWidget instanceof BaseWidget) {
                ((BaseWidget) createWidget).mHostView = view;
            }
            if (viewGroup instanceof CSSLayout) {
                WidgetAttributesModel widgetAttributesModel2 = widgetModel.atts;
                WidgetAttributesModel.OrientationModel orientationModel = widgetAttributesModel2.portrait;
                WidgetAttributesModel.OrientationModel orientationModel2 = widgetAttributesModel2.landscape;
                if (orientationModel2 == null) {
                    orientationModel2 = orientationModel;
                }
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 instanceof CSSLayout.LayoutParams) {
                    layoutParams = (CSSLayout.LayoutParams) layoutParams2;
                    layoutParams.useCSSLayout = true;
                    layoutParams.aspectRatio = f;
                    if (layoutParams.portraitModel == null) {
                        layoutParams.portraitModel = orientationModel;
                    }
                    if (layoutParams.landscapeModel == null) {
                        layoutParams.landscapeModel = orientationModel2;
                    }
                } else {
                    layoutParams = new CSSLayout.LayoutParams(-1, -1);
                    layoutParams.setOrientationModel(orientationModel, orientationModel2, f);
                }
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
            if (z2) {
                if (view instanceof CSSLayout) {
                    viewGroup = (CSSLayout) view;
                }
                for (WidgetModel widgetModel2 : list) {
                    if (widgetModel2 != null) {
                        buildWidgetsWithTemplate(iEngineInstance, createWidget, viewGroup instanceof CSSLayout ? (CSSLayout) viewGroup : null, widgetModel2, f, iTemplateWidgetBuildCallback, iProps);
                    } else {
                        WidgetAttributesModel widgetAttributesModel3 = widgetModel2.atts;
                    }
                }
            }
            iWidget.addChild(createWidget);
            createWidget.didMount();
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String closeDialog(String str) {
        IWidget findWidgetById;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "459954193")) {
            return (String) ipChange.ipc$dispatch("459954193", new Object[]{this, str});
        }
        if (str == null) {
            str = getDialogList().peek();
        }
        if (!(str == null || !getDialogList().remove(str) || (findWidgetById = findWidgetById(str)) == null)) {
            z = findWidgetById.closeSelf();
        }
        if (!z) {
            return null;
        }
        getWidgets().remove(str);
        return str;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstanceOnly
    public IPlugin createPluginIfNotExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669579639")) {
            return (IPlugin) ipChange.ipc$dispatch("-1669579639", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            Map<String, IPlugin> plugins = getPlugins();
            if (plugins.containsKey(str)) {
                return plugins.get(str);
            }
            PluginModel pluginModel = new PluginModel();
            pluginModel.name = str;
            return getTemplateBuilder().buildPluginWithName(getEngineInstanceConnector(), pluginModel, getTemplateWidgetBuildCallback(), getOptions());
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void delayRunOnMainThread(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064607306")) {
            ipChange.ipc$dispatch("2064607306", new Object[]{this, runnable, Integer.valueOf(i)});
            return;
        }
        getHandler().postDelayed(runnable, (long) i);
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void deleteEventHandler(String str, IEventHandler iEventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721308708")) {
            ipChange.ipc$dispatch("-1721308708", new Object[]{this, str, iEventHandler});
            return;
        }
        getEventDispatcher().deleteEventHandler(str, iEventHandler);
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079491317")) {
            ipChange.ipc$dispatch("-1079491317", new Object[]{this});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.destroy.begin");
        this.mRenderStatus = RENDER_STATUS_IDLE;
        clearWidgets();
        clearPlugins();
        clearSystemEventListener();
        clearDataCenter();
        clearInstanceConnector();
        getVisibleListeners().clear();
        IPerfMonitor perfMonitor2 = getPerfMonitor();
        perfMonitor2.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.destroy.end");
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void didActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877395776")) {
            ipChange.ipc$dispatch("-877395776", new Object[]{this});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.didActive");
        dispatchActiveStatus(true);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915731409")) {
            ipChange.ipc$dispatch("915731409", new Object[]{this});
            return;
        }
        dispatchAppearStatus(true);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void didDeactive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029439713")) {
            ipChange.ipc$dispatch("-2029439713", new Object[]{this});
            return;
        }
        IPerfMonitor perfMonitor = getPerfMonitor();
        perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.didDeactive");
        dispatchActiveStatus(false);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744770369")) {
            ipChange.ipc$dispatch("1744770369", new Object[]{this});
            return;
        }
        dispatchAppearStatus(false);
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void enableCSSLayoutNotifyConfigChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841644690")) {
            ipChange.ipc$dispatch("-841644690", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.enableCSSLayoutConfigChanged = z;
        CopyOnWriteArrayList<CSSLayout> copyOnWriteArrayList = this.mCSSLayouts;
        if (copyOnWriteArrayList != null) {
            Iterator<CSSLayout> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CSSLayout next = it.next();
                if (next != null) {
                    next.enableNotifyConfigChanged(this.enableCSSLayoutConfigChanged);
                }
            }
        }
    }

    public void enableRecycleCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532261215")) {
            ipChange.ipc$dispatch("-532261215", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.supportRecycleCache = z;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IPlugin findPluginByName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2098234238")) {
            return getPlugins().get(str);
        }
        return (IPlugin) ipChange.ipc$dispatch("2098234238", new Object[]{this, str});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IWidget findWidgetById(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1308772276")) {
            return getWidgets().get(str);
        }
        return (IWidget) ipChange.ipc$dispatch("-1308772276", new Object[]{this, str});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public List<IWidget> findWidgetsByName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342804592")) {
            return (List) ipChange.ipc$dispatch("1342804592", new Object[]{this, str});
        }
        LinkedList linkedList = new LinkedList();
        if (str != null) {
            for (Map.Entry<String, IWidget> entry : getWidgets().entrySet()) {
                IWidget value = entry.getValue();
                if ((value instanceof BaseWidget) && str.equals(((BaseWidget) value).name)) {
                    linkedList.add(value);
                }
            }
        }
        return linkedList;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public ActivityLifecycleState getActivityLifecycleState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1646940603")) {
            return this.mState;
        }
        return (ActivityLifecycleState) ipChange.ipc$dispatch("-1646940603", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
    public int getActivityOrientation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-245422675")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-245422675", new Object[]{this})).intValue();
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Context getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1781354364")) {
            return this.mContext;
        }
        return (Context) ipChange.ipc$dispatch("-1781354364", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public Object getData(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1307307363")) {
            return getDataCenter().getData(str);
        }
        return ipChange.ipc$dispatch("1307307363", new Object[]{this, str});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Map<String, Object> getEnvironments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217166916")) {
            return (Map) ipChange.ipc$dispatch("217166916", new Object[]{this});
        }
        if (this.mEnvironments == null) {
            synchronized (this) {
                if (this.mEnvironments == null) {
                    this.mEnvironments = new HashMap();
                }
            }
        }
        return this.mEnvironments;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public String getInstTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "129118681")) {
            return toString();
        }
        return (String) ipChange.ipc$dispatch("129118681", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IProps getOptions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362977337")) {
            return (IProps) ipChange.ipc$dispatch("362977337", new Object[]{this});
        }
        if (this.mOptions == null) {
            synchronized (this) {
                if (this.mOptions == null) {
                    this.mOptions = new BaseProps();
                }
            }
        }
        return this.mOptions;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Orientation getOrientation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1795205772")) {
            return this.mCurrentOrientation;
        }
        return (Orientation) ipChange.ipc$dispatch("-1795205772", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IPerfMonitor getPerfMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822097041")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-822097041", new Object[]{this});
        }
        if (this.mPerfMonitor == null) {
            synchronized (this) {
                if (this.mPerfMonitor == null) {
                    this.mPerfMonitor = PerfMonitorImp.createInstance(TAG, this);
                }
            }
        }
        return this.mPerfMonitor;
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public ViewGroup getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030723341")) {
            return (ViewGroup) ipChange.ipc$dispatch("1030723341", new Object[]{this});
        }
        RenderWidget renderWidget = this.mRenderWidget;
        if (renderWidget == null) {
            return null;
        }
        View view = renderWidget.mHostView;
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public int getStandardWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459699045")) {
            return ((Integer) ipChange.ipc$dispatch("459699045", new Object[]{this})).intValue();
        }
        TemplateModel templateModel = this.mTemplateModel;
        return templateModel != null ? templateModel.standardWidth : FeatureFactory.PRIORITY_ABOVE_NORMAL;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public IProps getTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253976612")) {
            return (IProps) ipChange.ipc$dispatch("253976612", new Object[]{this});
        }
        if (this.mTheme == null) {
            synchronized (this) {
                if (this.mTheme == null) {
                    this.mTheme = new BaseProps();
                }
            }
        }
        return this.mTheme;
    }

    public Handler getThreadHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232088661")) {
            return (Handler) ipChange.ipc$dispatch("-232088661", new Object[]{this});
        }
        if (this.mThreadHandler == null) {
            synchronized (this) {
                if (this.mThreadHandler == null) {
                    this.mThreadHandler = new Handler(getHandlerThread().getLooper());
                }
            }
        }
        return this.mThreadHandler;
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean isPageable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106461930")) {
            return ((Boolean) ipChange.ipc$dispatch("-106461930", new Object[]{this})).booleanValue();
        }
        Log.e(TAG, "WidgetInstance.recycleView:" + this + AVFSCacheConstants.COMMA_SEP + this.mEngineContext);
        WidgetEngineContext widgetEngineContext = this.mEngineContext;
        if (widgetEngineContext != null) {
            return widgetEngineContext.getPageableController().isPageable();
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean lockPageable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719424001")) {
            return ((Boolean) ipChange.ipc$dispatch("-719424001", new Object[]{this, str})).booleanValue();
        }
        WidgetEngineContext widgetEngineContext = this.mEngineContext;
        if (widgetEngineContext != null) {
            return widgetEngineContext.getPageableController().lockPageable(str);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-847881764")) {
            return getEngineListenerConnector().onActivityBackPressed();
        }
        return ((Boolean) ipChange.ipc$dispatch("-847881764", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        Orientation orientation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448686903")) {
            ipChange.ipc$dispatch("1448686903", new Object[]{this, configuration});
            return;
        }
        if (configuration.orientation == 2) {
            orientation = Orientation.ORIENTATION_LANDSCAPE;
        } else {
            orientation = Orientation.ORIENTATION_PORTAIT;
        }
        this.mCurrentOrientation = orientation;
        WidgetSDKEngine.setOrientation(orientation);
        getEngineListenerConnector().onActivityConfigurationChanged(configuration);
        OrientationHelper.setScreenType(getEngineInstanceConnector(), configuration);
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029178951")) {
            ipChange.ipc$dispatch("-1029178951", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.DESTROYED;
        getEngineListenerConnector().onActivityLifecycleStateChanged(this.mState);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityKeyDownListener
    public boolean onActivityKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1139782385")) {
            return getEngineListenerConnector().onActivityKeyDown(i, keyEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1139782385", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152368350")) {
            ipChange.ipc$dispatch("1152368350", new Object[]{this});
            return;
        }
        getEngineListenerConnector().onActivityLowMemory();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1258559043")) {
            ipChange.ipc$dispatch("-1258559043", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.PAUSED;
        getEngineListenerConnector().onActivityLifecycleStateChanged(this.mState);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18898417")) {
            ipChange.ipc$dispatch("-18898417", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        getEngineListenerConnector().onActivityRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1755109993")) {
            ipChange.ipc$dispatch("-1755109993", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        getEngineListenerConnector().onActivityResult(i, i2, intent);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287161834")) {
            ipChange.ipc$dispatch("1287161834", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.RESUMED;
        getEngineListenerConnector().onActivityLifecycleStateChanged(this.mState);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215454255")) {
            ipChange.ipc$dispatch("-1215454255", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.STARTED;
        getEngineListenerConnector().onActivityLifecycleStateChanged(this.mState);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636156533")) {
            ipChange.ipc$dispatch("1636156533", new Object[]{this});
            return;
        }
        this.mState = ActivityLifecycleState.STOPPED;
        getEngineListenerConnector().onActivityLifecycleStateChanged(this.mState);
    }

    public void onAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551099601")) {
            ipChange.ipc$dispatch("551099601", new Object[]{this});
        } else if (RENDER_STATUS_RENDERED.equals(this.mRenderStatus)) {
            IPerfMonitor perfMonitor = getPerfMonitor();
            perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.onAppear.begin");
            for (IEngineInstanceVisibleListener iEngineInstanceVisibleListener : getVisibleListeners()) {
                iEngineInstanceVisibleListener.onAppear();
            }
            IPerfMonitor perfMonitor2 = getPerfMonitor();
            perfMonitor2.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.onAppear.end");
        }
    }

    public void onDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "970869825")) {
            ipChange.ipc$dispatch("970869825", new Object[]{this});
        } else if (RENDER_STATUS_RENDERED.equals(this.mRenderStatus)) {
            IPerfMonitor perfMonitor = getPerfMonitor();
            perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.onDisappear.begin");
            for (IEngineInstanceVisibleListener iEngineInstanceVisibleListener : getVisibleListeners()) {
                iEngineInstanceVisibleListener.onDisappear();
            }
            IPerfMonitor perfMonitor2 = getPerfMonitor();
            perfMonitor2.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.onDisappear.end");
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public Object pollRecycleView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335397092")) {
            return ipChange.ipc$dispatch("-1335397092", new Object[]{this, str});
        }
        Log.e(TAG, "WidgetInstance.pollRecycleView:" + this + AVFSCacheConstants.COMMA_SEP + this.mEngineContext);
        WidgetEngineContext widgetEngineContext = this.mEngineContext;
        if (widgetEngineContext != null) {
            return widgetEngineContext.pollRecycleView(str);
        }
        return null;
    }

    @Override // com.youku.live.widgets.protocol.IEventDispatcher
    public void postEvent(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045031491")) {
            ipChange.ipc$dispatch("1045031491", new Object[]{this, Integer.valueOf(i), str, map});
            return;
        }
        getEventDispatcher().postEvent(i, str, map);
    }

    public void putConfig(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35731558")) {
            ipChange.ipc$dispatch("-35731558", new Object[]{this, str, obj});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (obj == null) {
                getConfig().remove(str);
            } else {
                getConfig().put(str, obj);
            }
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537868402")) {
            ipChange.ipc$dispatch("1537868402", new Object[]{this, str, obj});
            return;
        }
        getDataCenter().putData(str, obj);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446038618")) {
            ipChange.ipc$dispatch("-446038618", new Object[]{this, str, obj});
            return;
        }
        getDataCenter().putDataOnly(str, obj);
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public boolean recycleView(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899597545")) {
            return ((Boolean) ipChange.ipc$dispatch("-1899597545", new Object[]{this, str, obj})).booleanValue();
        }
        Log.e(TAG, "WidgetInstance.recycleView:" + this + AVFSCacheConstants.COMMA_SEP + this.mEngineContext);
        WidgetEngineContext widgetEngineContext = this.mEngineContext;
        if (widgetEngineContext != null) {
            return widgetEngineContext.recycleView(str, obj);
        }
        return false;
    }

    public WidgetInstance refreshWith(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1551703318")) {
            return this;
        }
        return (WidgetInstance) ipChange.ipc$dispatch("-1551703318", new Object[]{this, map});
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeAllFromMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937200965")) {
            ipChange.ipc$dispatch("-937200965", new Object[]{this});
            return;
        }
        getHandler().removeCallbacksAndMessages(null);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627364513")) {
            ipChange.ipc$dispatch("627364513", new Object[]{this, str});
            return;
        }
        getDataCenter().removeData(str);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeDataHandler(String str, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811821859")) {
            ipChange.ipc$dispatch("811821859", new Object[]{this, str, iDataHandler});
            return;
        }
        getDataCenter().removeDataHandler(str, iDataHandler);
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeFromMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430595186")) {
            ipChange.ipc$dispatch("1430595186", new Object[]{this, runnable});
            return;
        }
        getHandler().removeCallbacks(runnable);
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public boolean removeLayer(String str) {
        IWidget parent;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1920169786")) {
            return ((Boolean) ipChange.ipc$dispatch("-1920169786", new Object[]{this, str})).booleanValue();
        }
        IWidget findWidgetById = findWidgetById(str);
        if (findWidgetById == null || (parent = findWidgetById.getParent()) == null) {
            z = false;
        } else {
            parent.deleteChild(findWidgetById);
        }
        if (z) {
            getWidgets().remove(str);
        }
        return z;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void removeVisibleListener(IEngineInstanceVisibleListener iEngineInstanceVisibleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637766492")) {
            ipChange.ipc$dispatch("-1637766492", new Object[]{this, iEngineInstanceVisibleListener});
            return;
        }
        getVisibleListeners().remove(iEngineInstanceVisibleListener);
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstanceOnly
    public void render(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094353396")) {
            ipChange.ipc$dispatch("-1094353396", new Object[]{this, str, map});
            return;
        }
        render(str, map, (Map<String, Object>) null);
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstance
    public void runOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366981098")) {
            ipChange.ipc$dispatch("-366981098", new Object[]{this, runnable});
            return;
        }
        getHandler().post(runnable);
    }

    public void setActivityLifecycleState(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601938511")) {
            ipChange.ipc$dispatch("1601938511", new Object[]{this, activityLifecycleState});
            return;
        }
        this.mState = activityLifecycleState;
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstanceOnly
    public void setContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361874224")) {
            ipChange.ipc$dispatch("361874224", new Object[]{this, context});
            return;
        }
        this.mContext = context;
    }

    public void setEngineContext(WidgetEngineContext widgetEngineContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1433803249")) {
            ipChange.ipc$dispatch("-1433803249", new Object[]{this, widgetEngineContext});
            return;
        }
        this.mEngineContext = widgetEngineContext;
        Log.e(TAG, "WidgetInstance.setEngineContext:" + this + AVFSCacheConstants.COMMA_SEP + widgetEngineContext);
        initConfigMananger();
    }

    @Override // com.youku.live.widgets.protocol.IEngineInstanceOnly
    public void setRenderListener(IEngineRenderListener iEngineRenderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440414427")) {
            ipChange.ipc$dispatch("1440414427", new Object[]{this, iEngineRenderListener});
            return;
        }
        this.mRenderListener = iEngineRenderListener;
    }

    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047686338")) {
            ipChange.ipc$dispatch("1047686338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String showDialog(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1402800330")) {
            return showDialog((WidgetModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, WidgetModel.class));
        }
        return (String) ipChange.ipc$dispatch("-1402800330", new Object[]{this, str});
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public boolean systemEventFilter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1433941862")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1433941862", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.IPageableController
    public boolean unlockPageable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863282042")) {
            return ((Boolean) ipChange.ipc$dispatch("-1863282042", new Object[]{this, str})).booleanValue();
        }
        WidgetEngineContext widgetEngineContext = this.mEngineContext;
        if (widgetEngineContext != null) {
            return widgetEngineContext.getPageableController().unlockPageable(str);
        }
        return false;
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void willActive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1481163475")) {
            ipChange.ipc$dispatch("-1481163475", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311963710")) {
            ipChange.ipc$dispatch("311963710", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IActiveStateChangedListener
    public void willDeactive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865353804")) {
            ipChange.ipc$dispatch("1865353804", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070682188")) {
            ipChange.ipc$dispatch("-2070682188", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(String str, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858208823")) {
            ipChange.ipc$dispatch("-858208823", new Object[]{this, str, iDataBridgeHandler});
            return;
        }
        getDataCenter().addDataHandler(str, iDataBridgeHandler);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(List<String> list, IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39393522")) {
            ipChange.ipc$dispatch("39393522", new Object[]{this, list, iDataHandler});
            return;
        }
        getDataCenter().addDataHandlers(list, iDataHandler);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780085450")) {
            ipChange.ipc$dispatch("1780085450", new Object[]{this, str, obj, obj2});
            return;
        }
        getDataCenter().asyncPutData(str, obj, obj2);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void getData(String str, IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325661204")) {
            ipChange.ipc$dispatch("1325661204", new Object[]{this, str, iResult});
            return;
        }
        getDataCenter().getData(str, iResult);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525614130")) {
            ipChange.ipc$dispatch("-1525614130", new Object[]{this, str, obj, obj2});
            return;
        }
        getDataCenter().putData(str, obj, obj2);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316745214")) {
            ipChange.ipc$dispatch("-1316745214", new Object[]{this, str, obj, obj2});
            return;
        }
        getDataCenter().putDataOnly(str, obj, obj2);
    }

    public void render(String str, Map<String, Object> map, Map<String, Object> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722009095")) {
            ipChange.ipc$dispatch("-722009095", new Object[]{this, str, map, map2});
            return;
        }
        TemplateModel templateModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, TemplateModel.class);
        if (templateModel == null || templateModel.widget == null) {
            IEngineRenderListener iEngineRenderListener = this.mRenderListener;
            if (iEngineRenderListener != null) {
                iEngineRenderListener.onException(this, "1001", str);
            }
            Context context = getContext();
            ((IToast) Dsl.getService(IToast.class)).showCenterToast(context, "暂不支持直播间\"" + map.get("liveId") + "\", 布局描述有误！");
        }
        render(templateModel, map, map2);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(String[] strArr, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376232519")) {
            ipChange.ipc$dispatch("1376232519", new Object[]{this, strArr, iDataBridgeHandler});
            return;
        }
        getDataCenter().addDataHandlers(strArr, iDataBridgeHandler);
    }

    @Override // com.youku.live.widgets.protocol.ILayerMananger
    public String showDialog(WidgetModel widgetModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231228700")) {
            return (String) ipChange.ipc$dispatch("-1231228700", new Object[]{this, widgetModel});
        }
        if (widgetModel.id == null) {
            widgetModel.id = generateLayerId(widgetModel.name);
        }
        int screenWidth = ViewUtils.getScreenWidth(this.mContext);
        TemplateModel templateModel = this.mTemplateModel;
        int i = templateModel != null ? templateModel.standardWidth : FeatureFactory.PRIORITY_ABOVE_NORMAL;
        getTemplateBuilder().buildWidgetsWithTemplate(getEngineInstanceConnector(), this.mRenderWidget, null, widgetModel, ((float) screenWidth) / ((float) i), getTemplateWidgetBuildCallback(), getOptions());
        getDialogList().push(widgetModel.id);
        return widgetModel.id;
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(List<String> list, IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637378651")) {
            ipChange.ipc$dispatch("1637378651", new Object[]{this, list, iDataBridgeHandler});
            return;
        }
        getDataCenter().addDataHandlers(list, iDataBridgeHandler);
    }

    public Object getConfig(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1923030395")) {
            return getConfig().get(str);
        }
        return ipChange.ipc$dispatch("1923030395", new Object[]{this, str});
    }

    public void render(TemplateModel templateModel, Map<String, Object> map, Map<String, Object> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372310851")) {
            ipChange.ipc$dispatch("372310851", new Object[]{this, templateModel, map, map2});
            return;
        }
        try {
            renderInternalImp(templateModel, map, map2);
        } catch (Throwable th) {
            if (this.mRenderListener != null) {
                this.mRenderListener.onException(this, OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, th.getMessage());
            }
            IPerfMonitor perfMonitor = getPerfMonitor();
            perfMonitor.point(TAG_RENDER_POINT, "{roomid:" + this.mRoomId + "}.renderException\n" + th + StringUtils.LF);
        }
    }
}
