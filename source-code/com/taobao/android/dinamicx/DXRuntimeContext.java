package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.d00;
import tb.ey;
import tb.ft;
import tb.fz0;
import tb.g10;
import tb.hz;
import tb.qx;

/* compiled from: Taobao */
public class DXRuntimeContext implements Cloneable {
    public static final int REFRESH_ALL = 0;
    public static final int REFRESH_PART = 1;
    protected String bizType;
    protected String cacheIdentify;
    protected DXEngineConfig config;
    protected WeakReference<Context> contextWeakReference;
    public float countTime = 0.0f;
    public int createCount = 0;
    public String createViewInfo = "";
    private JSONObject data;
    private WeakReference<JSONObject> dataWRef;
    private int defaultAutoId = 0;
    private int defaultAutoIdInterval = 100000000;
    protected WeakReference<ft> dxControlEventCenterWeakReference;
    protected e dxError;
    protected WeakReference<DXNotificationCenter> dxNotificationCenterWeakReference;
    private hz dxPerformInfo;
    private Map<String, String> dxPerformTrackerData;
    protected WeakReference<DXRenderPipeline> dxRenderPipelineWeakReference;
    protected DXTemplateItem dxTemplateItem;
    @Deprecated
    protected Object dxUserContext;
    protected d engineContext;
    private Map<String, ey> env;
    private qx eventChainExpressionSourceContext;
    protected WeakReference<DXLongSparseArray<IDXEventHandler>> eventHandlerMapWeakReference;
    int instanceId;
    public boolean isHitCache = false;
    boolean needChildThread = true;
    private FalcoContainerSpan openTracerSpan;
    private int parentDirectionSpec = 0;
    protected DXLongSparseArray<IDXDataParser> parserMap;
    protected String pipelineIdentifier;
    public float reCountTime = 0.0f;
    int refreshType;
    int renderType;
    public String renderViewInfo = "";
    public int reuseCount = 0;
    public float reuseCountTime = 0.0f;
    int rootHeightSpec;
    protected WeakReference<DXRootView> rootViewWeakReference;
    int rootWidthSpec;
    protected Object subData;
    protected int subdataIndex;
    protected g10 userContext;
    protected DXWidgetNode widgetNode;
    protected DXLongSparseArray<IDXBuilderWidgetNode> widgetNodeMap;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXRefreshType {
    }

    public DXRuntimeContext(@NonNull d dVar) {
        this.engineContext = dVar;
        DXEngineConfig dXEngineConfig = dVar.a;
        this.config = dXEngineConfig;
        this.bizType = dXEngineConfig.a;
    }

    private DXWidgetNode getFlatten() {
        DXWidgetNode dXWidgetNode = this.widgetNode;
        if (dXWidgetNode == null) {
            return null;
        }
        if (dXWidgetNode.isFlatten()) {
            return this.widgetNode;
        }
        return this.widgetNode.getReferenceNode();
    }

    public DXRuntimeContext cloneWithWidgetNode(DXWidgetNode dXWidgetNode) {
        DXRuntimeContext dXRuntimeContext = new DXRuntimeContext(this.engineContext);
        dXRuntimeContext.dxUserContext = this.dxUserContext;
        dXRuntimeContext.dxTemplateItem = this.dxTemplateItem;
        dXRuntimeContext.widgetNode = dXWidgetNode;
        dXRuntimeContext.dataWRef = this.dataWRef;
        dXRuntimeContext.contextWeakReference = this.contextWeakReference;
        dXRuntimeContext.subData = this.subData;
        dXRuntimeContext.subdataIndex = this.subdataIndex;
        dXRuntimeContext.widgetNodeMap = this.widgetNodeMap;
        dXRuntimeContext.eventHandlerMapWeakReference = this.eventHandlerMapWeakReference;
        dXRuntimeContext.parserMap = this.parserMap;
        dXRuntimeContext.dxControlEventCenterWeakReference = this.dxControlEventCenterWeakReference;
        dXRuntimeContext.dxRenderPipelineWeakReference = this.dxRenderPipelineWeakReference;
        dXRuntimeContext.dxNotificationCenterWeakReference = this.dxNotificationCenterWeakReference;
        dXRuntimeContext.rootViewWeakReference = this.rootViewWeakReference;
        dXRuntimeContext.dxError = this.dxError;
        dXRuntimeContext.setParentDirectionSpec(this.parentDirectionSpec);
        dXRuntimeContext.renderType = this.renderType;
        dXRuntimeContext.pipelineIdentifier = this.pipelineIdentifier;
        dXRuntimeContext.rootWidthSpec = this.rootWidthSpec;
        dXRuntimeContext.rootHeightSpec = this.rootHeightSpec;
        dXRuntimeContext.refreshType = this.refreshType;
        dXRuntimeContext.instanceId = this.instanceId;
        dXRuntimeContext.env = this.env;
        dXRuntimeContext.needChildThread = this.needChildThread;
        dXRuntimeContext.openTracerSpan = this.openTracerSpan;
        dXRuntimeContext.dxPerformTrackerData = this.dxPerformTrackerData;
        dXRuntimeContext.defaultAutoId = this.defaultAutoId;
        dXRuntimeContext.data = this.data;
        return dXRuntimeContext;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getCacheIdentify() {
        if (!(!TextUtils.isEmpty(this.cacheIdentify) || this.dxTemplateItem == null || getData() == null)) {
            this.cacheIdentify = this.dxTemplateItem.name + JSMethod.NOT_SET + this.dxTemplateItem.version + JSMethod.NOT_SET + System.identityHashCode(getData()) + "w:" + getRootWidthSpec() + "h:" + getRootHeightSpec();
        }
        return this.cacheIdentify;
    }

    public String getCacheIdentifyWithSubData() {
        if (!(!TextUtils.isEmpty(this.cacheIdentify) || this.dxTemplateItem == null || getData() == null)) {
            this.cacheIdentify = this.dxTemplateItem.name + JSMethod.NOT_SET + this.dxTemplateItem.version + JSMethod.NOT_SET + System.identityHashCode(getSubData()) + "w:" + getRootWidthSpec() + "h:" + getRootHeightSpec();
        }
        return this.cacheIdentify;
    }

    public DXEngineConfig getConfig() {
        return this.config;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return DinamicXEngine.i();
        }
        return this.contextWeakReference.get();
    }

    public JSONObject getData() {
        WeakReference<JSONObject> weakReference = this.dataWRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public fz0 getDataProxy() {
        if (getEngineContext() == null) {
            return null;
        }
        return getEngineContext().f();
    }

    public ft getDxControlEventCenter() {
        WeakReference<ft> weakReference = this.dxControlEventCenterWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public e getDxError() {
        return this.dxError;
    }

    public DXNotificationCenter getDxNotificationCenter() {
        WeakReference<DXNotificationCenter> weakReference = this.dxNotificationCenterWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public hz getDxPerformInfo() {
        if (this.dxPerformInfo == null) {
            this.dxPerformInfo = new hz();
        }
        return this.dxPerformInfo;
    }

    public Map<String, String> getDxPerformTrackerData() {
        return this.dxPerformTrackerData;
    }

    public DXRenderPipeline getDxRenderPipeline() {
        WeakReference<DXRenderPipeline> weakReference = this.dxRenderPipelineWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public DXTemplateItem getDxTemplateItem() {
        return this.dxTemplateItem;
    }

    public Object getDxUserContext() {
        return this.dxUserContext;
    }

    public d getEngineContext() {
        return this.engineContext;
    }

    public Map<String, ey> getEnv() {
        return this.env;
    }

    public qx getEventChainExpressionSourceContext() {
        return this.eventChainExpressionSourceContext;
    }

    public DXLongSparseArray<IDXEventHandler> getEventHandlerMap() {
        WeakReference<DXLongSparseArray<IDXEventHandler>> weakReference = this.eventHandlerMapWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public IDXEventHandler getEventHandlerWithId(long j) {
        WeakReference<DXLongSparseArray<IDXEventHandler>> weakReference = this.eventHandlerMapWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.eventHandlerMapWeakReference.get().get(j);
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public View getNativeView() {
        DXWidgetNode flatten = getFlatten();
        if (flatten == null || flatten.getWRView() == null) {
            return null;
        }
        return flatten.getWRView().get();
    }

    public FalcoContainerSpan getOpenTracerSpan() {
        return this.openTracerSpan;
    }

    public int getParentDirectionSpec() {
        return this.parentDirectionSpec;
    }

    public DXLongSparseArray<IDXDataParser> getParserMap() {
        return this.parserMap;
    }

    public String getPipelineIdentifier() {
        return this.pipelineIdentifier;
    }

    public DXWidgetNode getRealRootExpandWidget() {
        if (getRootView() == null) {
            return null;
        }
        return getRootView().getExpandWidgetNode();
    }

    public int getRefreshType() {
        return this.refreshType;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public int getRootHeightSpec() {
        int i = this.rootHeightSpec;
        return i == 0 ? d00.e() : i;
    }

    public DXRootView getRootView() {
        WeakReference<DXRootView> weakReference = this.rootViewWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int getRootWidthSpec() {
        int i = this.rootWidthSpec;
        return i == 0 ? d00.f() : i;
    }

    public Object getSubData() {
        return this.subData;
    }

    public int getSubdataIndex() {
        return this.subdataIndex;
    }

    public String getTemplateId() {
        DXTemplateItem dXTemplateItem = this.dxTemplateItem;
        if (dXTemplateItem == null) {
            return "tplNUll";
        }
        return dXTemplateItem.getIdentifier();
    }

    public g10 getUserContext() {
        return this.userContext;
    }

    public DXWidgetNode getWidgetNode() {
        DXWidgetNode dXWidgetNode = this.widgetNode;
        if (dXWidgetNode == null) {
            return null;
        }
        if (!dXWidgetNode.isFlatten()) {
            return this.widgetNode;
        }
        return this.widgetNode.getReferenceNode();
    }

    public DXLongSparseArray<IDXBuilderWidgetNode> getWidgetNodeMap() {
        return this.widgetNodeMap;
    }

    public boolean hasError() {
        List<e.a> list;
        e eVar = this.dxError;
        return (eVar == null || (list = eVar.c) == null || list.size() <= 0) ? false : true;
    }

    public boolean isNeedChildThread() {
        return this.needChildThread;
    }

    public boolean isOpenNewFastReturnLogic() {
        if (getEngineContext() != null && getEngineContext().b() != null && getEngineContext().b().r()) {
            return true;
        }
        if (getWidgetNode() == null || !getWidgetNode().isOpenNewFastReturnLogic()) {
            return false;
        }
        return true;
    }

    public boolean isRefreshPart() {
        return this.refreshType == 1;
    }

    public DXRuntimeContext putPerformTrackerData(String str, String str2) {
        if (this.dxPerformTrackerData == null) {
            this.dxPerformTrackerData = new ConcurrentHashMap();
        }
        this.dxPerformTrackerData.put(str, str2);
        return this;
    }

    public void setData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dataWRef = new WeakReference<>(jSONObject);
        }
    }

    public void setDxError(e eVar) {
        this.dxError = eVar;
    }

    /* access modifiers changed from: protected */
    public void setDxRenderPipeline(WeakReference<DXRenderPipeline> weakReference) {
        this.dxRenderPipelineWeakReference = weakReference;
    }

    public void setDxTemplateItem(DXTemplateItem dXTemplateItem) {
        this.dxTemplateItem = dXTemplateItem;
    }

    public void setEnv(Map<String, ey> map) {
        this.env = map;
    }

    public void setEventChainExpressionSourceContext(qx qxVar) {
        this.eventChainExpressionSourceContext = qxVar;
    }

    public void setInstanceId(int i) {
        this.instanceId = i;
    }

    public void setNeedChildThread(boolean z) {
        this.needChildThread = z;
    }

    public void setOpenTracerSpan(FalcoContainerSpan falcoContainerSpan) {
        this.openTracerSpan = falcoContainerSpan;
    }

    public void setParentDirectionSpec(int i) {
        this.parentDirectionSpec = i;
    }

    public void setPipelineIdentifier(String str) {
        this.pipelineIdentifier = str;
    }

    public void setRefreshType(int i) {
        this.refreshType = i;
    }

    public void setSubData(Object obj) {
        this.subData = obj;
    }

    public void setSubdataIndex(int i) {
        this.subdataIndex = i;
    }

    public void setWidgetNode(DXWidgetNode dXWidgetNode) {
        this.widgetNode = dXWidgetNode;
    }

    public boolean supportDataProxy() {
        getDataProxy();
        return false;
    }

    public void updateRootHeightSpec(int i) {
        this.rootHeightSpec = i;
    }
}
