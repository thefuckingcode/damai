package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.widget.recycler.IDXRecyclerOnScrollToPos;
import com.taobao.android.dinamicx.widget.recycler.PrefetchRecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.ScrollListener;
import com.taobao.android.dinamicx.widget.recycler.WaterfallLayout;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import com.taobao.android.dinamicx.widget.recycler.view.DXRecyclerView;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import tb.at;
import tb.be;
import tb.c00;
import tb.dx;
import tb.dz;
import tb.ex;
import tb.ey;
import tb.fx;
import tb.g31;
import tb.k10;
import tb.lx;
import tb.lz;
import tb.nz;
import tb.pz;
import tb.qz;
import tb.ry;
import tb.rz;
import tb.sz;
import tb.ty;
import tb.tz;
import tb.uz;
import tb.vx;
import tb.wz;
import tb.yv1;

/* compiled from: Taobao */
public class DXRecyclerLayout extends DXAbsContainerBaseLayout {
    public static final String ABILITY_SPAN = "ability_span";
    private static final String DELIMITER = " .[]";
    public static final long DXRECYCLERLAYOUT_ADAPTERTYPE = 4719559293862423182L;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_COMMON = 0;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_DATACOPY = 1;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_TWODIMENSIONALARRAY = 2;
    public static final long DXRECYCLERLAYOUT_COLUMNCOUNT = 4480460401770252962L;
    public static final long DXRECYCLERLAYOUT_COLUMNGAP = 7523322875951878575L;
    public static final long DXRECYCLERLAYOUT_DATASOURCE = -5948810534719014123L;
    public static final long DXRECYCLERLAYOUT_DEFAULTLOADMORESTATUS = 4192478880209527953L;
    public static final long DXRECYCLERLAYOUT_DISABLEBOUNCES = -7721339152929171023L;
    public static final long DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN = 3569509988477778057L;
    public static final int DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME = 1118607339767866271L;
    public static final int DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ENDREACHEDTHRESHOLD = 5205069215281796771L;
    public static final long DXRECYCLERLAYOUT_EXPOSURESPACEFACTOR = -277183941220263719L;
    public static final long DXRECYCLERLAYOUT_EXPOSURETIMEFACTOR = -2576277436099050373L;
    public static final long DXRECYCLERLAYOUT_FIXVERTICALSCROLLCONFLICT = 8809657122981937979L;
    public static final long DXRECYCLERLAYOUT_ISOPENLOADMORE = 2380170249149374095L;
    public static final int DXRECYCLERLAYOUT_ISOPENLOADMORE_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH = 1110502637440832944L;
    public static final int DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_LEFTGAP = 5063678658862152906L;
    public static final long DXRECYCLERLAYOUT_LOADMOREFAILTEXT = 7321446999712924516L;
    public static final long DXRECYCLERLAYOUT_LOADMORELOADINGTEXT = -3963239569560963927L;
    public static final long DXRECYCLERLAYOUT_LOADMORENOMOREDATATEXT = -7969714938924101192L;
    public static final long DXRECYCLERLAYOUT_LOADMORETEXTCOLOR = 3416394884019274728L;
    public static final long DXRECYCLERLAYOUT_LOADMORETEXTSIZE = 8369659249760268163L;
    public static final long DXRECYCLERLAYOUT_NEEDITEMANIMATION = -3924891868525265444L;
    public static final int DXRECYCLERLAYOUT_NEEDITEMANIMATION_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_NEEDITEMANIMATION_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ONEXPOSURE = 6278152710403332930L;
    public static final long DXRECYCLERLAYOUT_ONSTARTREACHED = -1945209666977474139L;
    public static final long DXRECYCLERLAYOUT_ONSTAY = 9859236201376900L;
    public static final long DXRECYCLERLAYOUT_ONSTICKYCHANGE = 2228800223520853672L;
    public static final long DXRECYCLERLAYOUT_OPENPREFETCH = 149121233077571055L;
    public static final int DXRECYCLERLAYOUT_OPENPREFETCH_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_OPENPREFETCH_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ORIENTATION = -7199229155167727177L;
    public static final long DXRECYCLERLAYOUT_PREFETCHBATCHSIZE = 2756224129729260223L;
    public static final long DXRECYCLERLAYOUT_RECYCLERLAYOUT = -1365643441053437243L;
    public static final long DXRECYCLERLAYOUT_REFRESHLOADINGTEXT = 4423553470726895972L;
    public static final long DXRECYCLERLAYOUT_REFRESHPULLTEXT = 4728312954970318656L;
    public static final long DXRECYCLERLAYOUT_REFRESHRELEASETEXT = -5282950348472280217L;
    public static final long DXRECYCLERLAYOUT_RIGHTGAP = 6166552115852018494L;
    public static final long DXRECYCLERLAYOUT_STARTREACHEDTHRESHOLD = -6236604739320595556L;
    public static final long DXRECYCLERLAYOUT_VIDEOCONTROLCONFIG = -7801350391660369312L;
    protected static final String ITEM_DATA = "item_data";
    public static final String LOAD_MORE_EMPTY = "empty";
    public static final String LOAD_MORE_FAIL_STRING = "failed";
    public static final String LOAD_MORE_LOADING_STRING = "loading";
    public static final String LOAD_MORE_NO_DATA_STRING = "noMore";
    public static final String LOAD_MORE_STOPED = "stopped";
    public static final String MSG_METHOD_APPEND_ITEMS = "DXRecyclerLayout#appendItems";
    public static final String MSG_METHOD_DELETE_ITEMS = "DXRecyclerLayout#deleteItems";
    public static final String MSG_METHOD_INSERT_ITEMS = "DXRecyclerLayout#insertItems";
    public static final String MSG_METHOD_INSERT_ITEMS_BY_OFFSET = "DXRecyclerLayout#insertItemsByOffset";
    public static final String MSG_METHOD_LOAD_MORE = "DXRecyclerLayout#loadMore";
    public static final String MSG_METHOD_MODIFY_CURRENT_ITEM_DATA = "DXRecyclerLayout#modifyCurrentItemData";
    public static final String MSG_METHOD_PULL_TO_REFRESH = "DXRecyclerLayout#refresh";
    public static final String MSG_METHOD_REFRESH_DATA = "DXRecyclerLayout#refreshData";
    public static final String MSG_METHOD_UPDATE_ALL = "DXRecyclerLayout#updateAll";
    public static final String MSG_METHOD_UPDATE_CURRENT = "DXRecyclerLayout#updateCurrent";
    public static final String MSG_METHOD_UPDATE_ITEMS = "DXRecyclerLayout#updateItems";
    public static final String MSG_METHOD_UPDATE_STYLE = "DXRecyclerLayout#updateStyle";
    private static final String OPERATOR_ACTION_MERGE = "merge";
    private static final String OPERATOR_ACTION_MODIFY = "modify";
    private static final String OPERATOR_ACTION_REMOVE = "remove";
    protected static final String PATH_ACTIONS = "actions";
    private static final String PATH_KEY = "key";
    private static final String PATH_OPERATOR = "operator";
    private static final String PATH_VALUE = "value";
    private static final String REFRESH_TYPE = "refreshType";
    private static final String REFRESH_TYPE_ALL = "all";
    private static final String REFRESH_TYPE_PART = "part";
    public static final String TAG = "DXRecyclerLayout";
    private int adapterType;
    Map<String, Integer> cellUserId2PositionMap = new HashMap();
    protected int columnCount = 1;
    protected int columnGap;
    dx dataSourceManager;
    private int defaultLoadMoreStatus = 1;
    protected int disableBounces;
    nz dxRecyclerJsOperator;
    sz dxRecyclerOperator;
    private boolean enableLeftGapWhenSingleColumn = true;
    private boolean enableTrackStayTime = true;
    protected int endReachedThreshold;
    private JSONArray exportMethods;
    private double exposureSpaceFactor = 0.5d;
    private long exposureTimeFactor = 300;
    private boolean fixVerticalScrollConflict;
    private IDXRecyclerOnScrollToPos idxRecyclerOnScrollToPos;
    protected int isOpenLoadMore;
    protected int isOpenPullToRefresh;
    protected int leftGap;
    protected String loadMoreFailText;
    protected String loadMoreLoadingText;
    protected String loadMoreNoMoreDataText;
    private int loadMoreTextColor;
    private int loadMoreTextSize;
    private com.taobao.android.dinamicx.widget.recycler.expose.b mExposeHelper;
    private boolean mShouldScroll;
    private int mToPosition;
    private boolean needItemAnimation = false;
    private rz onTouchListener;
    private int openPrefetch;
    private int preFetchBatchSize;
    private yv1 pullRefreshListener;
    protected String refreshLoadingText = "加载中...";
    protected String refreshPullText = "下拉即可刷新...";
    protected String refreshReleaseText = "释放即可刷新...";
    protected int rightGap;
    private ScrollListener scrollListener;
    private int startReachedThreshold = -1;
    private Object videoControlConfig;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface LoadMoreStatus {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IExposeStayCallback {
        final /* synthetic */ RecyclerView a;

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback
        public void exposeStay(int i, long j) {
            List<Object> f;
            if (this.a != null && DXRecyclerLayout.this.mExposeHelper != null && (f = DXRecyclerLayout.this.mExposeHelper.f()) != null && i >= 0 && i < f.size()) {
                Object obj = f.get(i);
                if (obj instanceof JSONObject) {
                    DXRecyclerLayout.this.postEvent(new qz(i, (JSONObject) obj, j));
                } else if (DXRecyclerLayout.this.getDXRuntimeContext() != null && DXRecyclerLayout.this.getDXRuntimeContext().supportDataProxy() && (obj instanceof Object)) {
                    DXRecyclerLayout.this.postEvent(new qz(i, obj, j));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements IExposeFilterCallback {
        b() {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback
        public boolean filter(int i) {
            RecyclerView.Adapter adapter;
            if (DXRecyclerLayout.this.getRecyclerView() == null || (adapter = DXRecyclerLayout.this.getRecyclerView().getAdapter()) == null || adapter.getItemViewType(i) != -1) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements IExposeDistinctCallback {
        c(DXRecyclerLayout dXRecyclerLayout) {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback
        public String distinct(int i) {
            return i + "";
        }
    }

    /* compiled from: Taobao */
    public static class d implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXRecyclerLayout();
        }
    }

    public DXRecyclerLayout() {
        setOrientation(1);
    }

    private boolean appendItems(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        if (at.O0()) {
            return this.dxRecyclerOperator.a(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty()) {
            return false;
        }
        appendItemsWithData(jSONArray, this.originWidgetNodes, falcoSpan, jSONObject.getString(REFRESH_TYPE));
        return true;
    }

    private void appendItemsByRef(JSONArray jSONArray) {
        int i;
        if (at.O0()) {
            this.dxRecyclerJsOperator.r(this, jSONArray);
        } else if (jSONArray != null && jSONArray.size() > 0) {
            Object obj = jSONArray.get(0);
            if (obj instanceof JSONArray) {
                List<Object> list = this.dataSource;
                if (list != null) {
                    int size = list.size();
                    this.dataSource.addAll((JSONArray) obj);
                    i = size;
                } else {
                    i = 0;
                }
                List<Object> list2 = this.dataSource;
                ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(list2, this.originWidgetNodes, i, list2.size(), null);
                if (generateWidgetNodeByData != null && !generateWidgetNodeByData.isEmpty()) {
                    getItemWidgetNodes().addAll(generateWidgetNodeByData);
                    refresh();
                }
            }
        }
    }

    private void appendItemsWithData(JSONArray jSONArray, List<DXWidgetNode> list, FalcoSpan falcoSpan, String str) {
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArray.size(); i3++) {
            Object obj = jSONArray.get(i3);
            if (!(obj instanceof JSONObject)) {
                ry.g(TAG, "no setData for append!!!");
            } else if (itemWidgetNodes != null) {
                List<Object> list2 = this.dataSource;
                if (list2 != null) {
                    if (i < 0) {
                        i = list2.size();
                    }
                    this.dataSource.add(obj);
                    i2++;
                }
                itemWidgetNodes.add(generateItemWithData((JSONObject) obj, list, i + i3, falcoSpan));
            }
        }
        if (i >= 0 && i2 > 0) {
            if (at.u0()) {
                refresh(REFRESH_TYPE_PART, i, i2, MSG_METHOD_APPEND_ITEMS, false);
            } else {
                refresh(REFRESH_TYPE_PART, i, i2, MSG_METHOD_APPEND_ITEMS);
            }
        }
    }

    private void bindSpanCtx(DXWidgetNode dXWidgetNode) {
        if ((dXWidgetNode instanceof DXTemplateWidgetNode) && getDXRuntimeContext().getOpenTracerSpan() != null) {
            Map<String, String> i = dz.i(getDXRuntimeContext().getOpenTracerSpan());
            DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode;
            if (dXTemplateWidgetNode.getSpan() == null) {
                dXTemplateWidgetNode.setSpan(dz.e(i, "DX", TAG));
            }
        }
    }

    private boolean deleteItems(@NonNull JSONObject jSONObject) {
        List<DXWidgetNode> itemWidgetNodes;
        if (at.O0()) {
            return this.dxRecyclerOperator.b(this, jSONObject);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty() || (itemWidgetNodes = getItemWidgetNodes()) == null || itemWidgetNodes.isEmpty()) {
            return false;
        }
        return deleteItemsWithData(jSONArray, jSONObject.get("current"), jSONObject.getString(REFRESH_TYPE));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007a A[SYNTHETIC] */
    private boolean deleteItemsWithData(JSONArray jSONArray, Object obj, String str) {
        boolean z;
        int i;
        Exception e;
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            Object obj2 = jSONArray.get(i2);
            if (obj2 instanceof JSONObject) {
                try {
                    z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                    try {
                        i = ((JSONObject) obj2).getIntValue("offset");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    e.printStackTrace();
                    i = -1;
                    if (i == -1) {
                    }
                }
                if (i == -1) {
                    List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
                    if (z && (obj instanceof DXWidgetNode)) {
                        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode((DXWidgetNode) obj);
                        if (parentTemplateWidgetNode == null) {
                            trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_230003, "");
                            return false;
                        }
                        i += itemWidgetNodes.indexOf(parentTemplateWidgetNode);
                    }
                    if (i >= 0 && i < itemWidgetNodes.size()) {
                        itemWidgetNodes.remove(i);
                    }
                    if (i >= 0 && i < this.dataSource.size()) {
                        this.dataSource.remove(i);
                    }
                    if (REFRESH_TYPE_PART.equals(str)) {
                        refresh(REFRESH_TYPE_PART, i, 1, MSG_METHOD_DELETE_ITEMS);
                    }
                } else {
                    continue;
                }
            }
        }
        if (TextUtils.isEmpty(str) || "all".equals(str)) {
            refresh();
        }
        return true;
    }

    private com.taobao.android.dinamicx.widget.recycler.expose.b getExposeHelper() {
        if (this.mExposeHelper == null) {
            WaterfallLayout waterfallLayout = this.waterfallLayout;
            if (waterfallLayout == null || waterfallLayout.e() == null || !(this.waterfallLayout.e() instanceof DXRecyclerView)) {
                return null;
            }
            com.taobao.android.dinamicx.widget.recycler.expose.b exposeHelper = ((DXRecyclerView) this.waterfallLayout.e()).getExposeHelper();
            this.mExposeHelper = exposeHelper;
            if (exposeHelper == null) {
                initExpose(this.waterfallLayout.e());
            }
            com.taobao.android.dinamicx.widget.recycler.expose.b bVar = this.mExposeHelper;
            if (bVar != null && bVar.f() == null) {
                this.mExposeHelper.i(this.dataSource);
            }
        }
        return this.mExposeHelper;
    }

    private DXTemplateWidgetNode getParentTemplateWidgetNode(DXWidgetNode dXWidgetNode) {
        return uz.b(dXWidgetNode);
    }

    private int getRealCount() {
        if (!getDXRuntimeContext().getEngineContext().j()) {
            return getItemWidgetNodes().size();
        }
        dx dxVar = this.dataSourceManager;
        if (dxVar != null) {
            return dxVar.getRealCount();
        }
        return 0;
    }

    private int getRealIndex(boolean z, int i, int i2, Object obj) {
        if (!z) {
            return i2;
        }
        if (i > 0) {
            return i2 + i;
        }
        if (!(obj instanceof DXWidgetNode)) {
            return -1;
        }
        return i2 + getItemWidgetNodes().indexOf(getParentTemplateWidgetNode((DXWidgetNode) obj));
    }

    private int indexOfItem(DXWidgetNode dXWidgetNode) {
        if (!getDXRuntimeContext().getEngineContext().j()) {
            return getItemWidgetNodes().indexOf(dXWidgetNode);
        }
        dx dxVar = this.dataSourceManager;
        if (dxVar != null) {
            return dxVar.indexOfItem(dXWidgetNode);
        }
        return -1;
    }

    private void initDataSourceManager() {
        DXDataSourceLruManager dXDataSourceLruManager = getDXRuntimeContext().getEngineContext().j() ? new DXDataSourceLruManager(getDXRuntimeContext().getEngineContext().g()) : null;
        int i = this.adapterType;
        if (i == 0) {
            this.dataSourceManager = new ex(dXDataSourceLruManager);
        } else if (i == 1) {
            this.dataSourceManager = new fx(dXDataSourceLruManager);
        }
    }

    private void initExpose(final RecyclerView recyclerView) {
        if (getEventHandlersExprNode() == null) {
            return;
        }
        if (getEventHandlersExprNode().get(6278152710403332930L) != null || getEventHandlersExprNode().get(9859236201376900L) != null) {
            com.taobao.android.dinamicx.widget.recycler.expose.b a2 = new com.taobao.android.dinamicx.widget.recycler.expose.c(recyclerView, new IExposeCallback() {
                /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass9 */

                @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback
                public void expose(final int i) {
                    c00.m(new Runnable() {
                        /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass9.AnonymousClass1 */

                        public void run() {
                            int i;
                            AnonymousClass9 r0 = AnonymousClass9.this;
                            if (recyclerView != null && DXRecyclerLayout.this.mExposeHelper != null) {
                                List<Object> f = DXRecyclerLayout.this.mExposeHelper.f();
                                if (f == null || (i = i) < 0 || i >= f.size()) {
                                    DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("发送曝光条件异常 ds: ");
                                    sb.append(f == null ? "null" : Integer.valueOf(f.size()));
                                    sb.append(" pos ");
                                    sb.append(i);
                                    dXRecyclerLayout.trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_230006, sb.toString());
                                    return;
                                }
                                Object obj = f.get(i);
                                if (obj instanceof JSONObject) {
                                    DXRecyclerLayout.this.postEvent(new pz(i, (JSONObject) obj));
                                } else if (DXRecyclerLayout.this.getDXRuntimeContext() != null && DXRecyclerLayout.this.getDXRuntimeContext().supportDataProxy() && (obj instanceof Object)) {
                                    DXRecyclerLayout.this.postEvent(new pz(i, obj));
                                }
                            }
                        }
                    });
                }
            }).b(new c(this)).d(new b()).l(this.exposureTimeFactor).k((float) this.exposureSpaceFactor).c(getEventHandlersExprNode().get(9859236201376900L) != null && this.enableTrackStayTime ? new a(recyclerView) : null).a();
            this.mExposeHelper = a2;
            if (recyclerView instanceof DXRecyclerView) {
                ((DXRecyclerView) recyclerView).setExposeHelper(a2);
            }
        }
    }

    private void initOnTouchListener() {
        if (getEventHandlersExprNode() != null) {
            if (getEventHandlersExprNode().get(18903999933159L) != null || getEventHandlersExprNode().get(-6544685697300501093L) != null) {
                WaterfallLayout waterfallLayout = this.waterfallLayout;
                if (waterfallLayout == null || !(waterfallLayout.d() instanceof rz)) {
                    rz rzVar = new rz(this);
                    this.onTouchListener = rzVar;
                    this.waterfallLayout.m(rzVar);
                    return;
                }
                rz d2 = this.waterfallLayout.d();
                this.onTouchListener = d2;
                d2.b(this);
            }
        }
    }

    private void initScrollListener() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout == null || !(waterfallLayout.c() instanceof ScrollListener)) {
            getDXRuntimeContext().getEngineContext().b().c();
            ScrollListener scrollListener2 = new ScrollListener(this);
            this.scrollListener = scrollListener2;
            this.waterfallLayout.l(scrollListener2);
            return;
        }
        ScrollListener scrollListener3 = (ScrollListener) this.waterfallLayout.c();
        this.scrollListener = scrollListener3;
        scrollListener3.b();
    }

    private void initVideoPlayControl(RecyclerView recyclerView) {
        if (recyclerView != null) {
            try {
                DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
                k10 n = dXRuntimeContext.getEngineContext().e().n();
                if (n != null && isEnableVideoControl() && n.b()) {
                    String str = (TextUtils.isEmpty(dXRuntimeContext.getBizType()) ? "" : dXRuntimeContext.getBizType()) + JSMethod.NOT_SET + (TextUtils.isEmpty(this.userId) ? TAG : this.userId);
                    n.makeVideoControl(recyclerView, (DXVideoControlConfig) this.videoControlConfig, str);
                    n.start(recyclerView, str);
                }
            } catch (Exception e) {
                vx.b(e);
            }
        }
    }

    private boolean insertItems(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        if (at.O0()) {
            return this.dxRecyclerOperator.i(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty() || getItemWidgetNodes() == null) {
            return false;
        }
        return insertItemsWithData(jSONArray, jSONObject.get("current"), falcoSpan, (String) g31.b(REFRESH_TYPE, jSONObject, "all"));
    }

    private boolean insertItemsByOffset(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        JSONArray e;
        if (at.O0()) {
            return this.dxRecyclerOperator.j(this, jSONObject, falcoSpan);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || itemWidgetNodes.isEmpty() || (e = g31.e("data", jSONObject, null)) == null || e.isEmpty()) {
            return false;
        }
        return insertItemsWithDataByOffset(e, (DXWidgetNode) g31.b("current", jSONObject, null), g31.d("offset", jSONObject, -1), g31.c("isRelative", jSONObject, Boolean.FALSE).booleanValue(), falcoSpan);
    }

    private void insertItemsByRef(JSONArray jSONArray) {
        Object obj;
        if (at.O0()) {
            this.dxRecyclerJsOperator.s(this, jSONArray);
        } else if ((jSONArray != null || jSONArray.size() > 0) && (obj = jSONArray.get(0)) != null) {
            List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
            int size = itemWidgetNodes.size();
            if (jSONArray.size() > 1) {
                try {
                    Integer integer = jSONArray.getInteger(1);
                    if (integer != null) {
                        if (integer.intValue() > itemWidgetNodes.size()) {
                            integer = Integer.valueOf(itemWidgetNodes.size());
                        } else if (integer.intValue() < 0) {
                            integer = 0;
                        }
                        size = integer.intValue();
                    }
                } catch (Exception unused) {
                }
            }
            if (jSONArray.size() > 2) {
                try {
                    jSONArray.getBooleanValue(2);
                } catch (Exception unused2) {
                }
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (size >= 0 && size <= itemWidgetNodes.size()) {
                    List<Object> list = this.dataSource;
                    if (list != null && size >= 0 && size <= list.size()) {
                        this.dataSource.add(size, jSONObject);
                    }
                    itemWidgetNodes.add(size, generateItemWithData(jSONObject, this.originWidgetNodes, size, null));
                    refresh();
                }
            } else if ((obj instanceof JSONArray) && size >= 0 && size <= itemWidgetNodes.size()) {
                List<Object> list2 = this.dataSource;
                if (list2 != null && size >= 0 && size <= list2.size()) {
                    this.dataSource.addAll(size, (JSONArray) obj);
                }
                ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(this.dataSource, this.originWidgetNodes, size, size + ((JSONArray) obj).size(), null);
                if (generateWidgetNodeByData != null && !generateWidgetNodeByData.isEmpty()) {
                    itemWidgetNodes.addAll(size, generateWidgetNodeByData);
                    refresh();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0049 A[SYNTHETIC] */
    private boolean insertItemsWithData(JSONArray jSONArray, Object obj, FalcoSpan falcoSpan, String str) {
        int i;
        boolean z;
        int i2;
        Exception e;
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        for (int i3 = 0; i3 < jSONArray.size(); i3++) {
            Object obj2 = jSONArray.get(i3);
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = null;
                try {
                    z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                    try {
                        i = ((JSONObject) obj2).getIntValue("offset");
                        try {
                            jSONObject = ((JSONObject) obj2).getJSONObject("data");
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = -1;
                        e.printStackTrace();
                        if (jSONObject == null) {
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                    i = -1;
                    e.printStackTrace();
                    if (jSONObject == null) {
                    }
                }
                if (jSONObject == null) {
                    return false;
                }
                if (i != -1) {
                    if (!z || !(obj instanceof DXWidgetNode)) {
                        i2 = i;
                    } else {
                        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode((DXWidgetNode) obj);
                        if (parentTemplateWidgetNode == null) {
                            return false;
                        }
                        i2 = itemWidgetNodes.indexOf(parentTemplateWidgetNode) + i;
                    }
                    List<Object> list = this.dataSource;
                    if (list != null && i2 >= 0 && i2 <= list.size()) {
                        this.dataSource.add(i2, jSONObject);
                    }
                    DXWidgetNode generateItemWithData = generateItemWithData(jSONObject, this.originWidgetNodes, i2, falcoSpan);
                    if (i2 >= 0 && i2 <= itemWidgetNodes.size()) {
                        itemWidgetNodes.add(i2, generateItemWithData);
                    }
                    if (REFRESH_TYPE_PART.equals(str)) {
                        if (at.u0()) {
                            refresh(str, i2, 1, MSG_METHOD_INSERT_ITEMS, false);
                        } else {
                            refresh(str, i2, 1, MSG_METHOD_INSERT_ITEMS);
                        }
                    }
                }
            }
        }
        if ("all".equals(str)) {
            refresh();
        }
        return true;
    }

    private boolean insertItemsWithDataByOffset(JSONArray jSONArray, DXWidgetNode dXWidgetNode, int i, boolean z, FalcoSpan falcoSpan) {
        if (jSONArray == null || dXWidgetNode == null) {
            return false;
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            JSONObject jSONObject = (JSONObject) g31.a(i2, jSONArray, null);
            if (jSONObject != null) {
                int i3 = i + i2;
                if (z) {
                    DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
                    if (parentTemplateWidgetNode == null) {
                        return false;
                    }
                    i3 = itemWidgetNodes.indexOf(parentTemplateWidgetNode) + i;
                }
                List<Object> list = this.dataSource;
                if (list != null && i3 >= 0 && i3 < list.size()) {
                    this.dataSource.add(i3, jSONObject);
                }
                DXWidgetNode generateItemWithData = generateItemWithData(jSONObject, this.originWidgetNodes, i3, falcoSpan);
                if (i3 >= 0 && i3 < itemWidgetNodes.size()) {
                    itemWidgetNodes.add(i3, generateItemWithData);
                }
            }
        }
        refresh();
        return true;
    }

    private boolean isOpenPrefetch() {
        return this.openPrefetch == 1 && at.z0();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyData(RecyclerView.Adapter adapter, String str, int i, int i2, String str2) {
        if (adapter != null) {
            try {
                if (!TextUtils.isEmpty(str) && !"all".equals(str) && i >= 0) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (str.equals(REFRESH_TYPE_PART)) {
                            char c2 = 65535;
                            switch (str2.hashCode()) {
                                case -1472811200:
                                    if (str2.equals(MSG_METHOD_APPEND_ITEMS)) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case -708482225:
                                    if (str2.equals(MSG_METHOD_DELETE_ITEMS)) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case -232077206:
                                    if (str2.equals(MSG_METHOD_UPDATE_CURRENT)) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 310191873:
                                    if (str2.equals(MSG_METHOD_INSERT_ITEMS)) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                            }
                            if (c2 == 0) {
                                ((RecyclerAdapter) adapter).c();
                                adapter.notifyItemRangeRemoved(i, i2);
                                return;
                            } else if (c2 == 1) {
                                adapter.notifyItemRangeChanged(i, i2);
                                return;
                            } else if (c2 == 2) {
                                adapter.notifyItemRangeInserted(i, i2);
                                return;
                            } else if (c2 != 3) {
                                adapter.notifyDataSetChanged();
                                return;
                            } else {
                                adapter.notifyItemInserted(i);
                                return;
                            }
                        } else {
                            adapter.notifyDataSetChanged();
                            return;
                        }
                    }
                }
                ((RecyclerAdapter) adapter).c();
                adapter.notifyDataSetChanged();
            } catch (Throwable th) {
                vx.b(th);
            }
        }
    }

    private boolean onRefresh(@NonNull JSONObject jSONObject) {
        WaterfallLayout waterfallLayout;
        String string = jSONObject.getString("status");
        string.hashCode();
        if (string.equals(LOAD_MORE_STOPED)) {
            WaterfallLayout waterfallLayout2 = this.waterfallLayout;
            if (waterfallLayout2 == null) {
                return false;
            }
            waterfallLayout2.q();
            return true;
        } else if (!string.equals("triggered") || (waterfallLayout = this.waterfallLayout) == null) {
            return false;
        } else {
            waterfallLayout.p();
            return true;
        }
    }

    private void parseFieldNamePathQueue(String str, Queue<String> queue) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, DELIMITER, false);
        while (stringTokenizer.hasMoreTokens()) {
            queue.offer(stringTokenizer.nextToken());
        }
    }

    private void postOnLoadMoreEvent() {
        postEvent(new lx(DXAbsContainerBaseLayout.DXRECYCLERLAYOUT_ONENDREACHED));
    }

    private void reInitAdapter(RecyclerAdapter recyclerAdapter) {
        recyclerAdapter.setHasStableIds(true);
        setDataSource(recyclerAdapter, getItemWidgetNodes());
        recyclerAdapter.b();
        recyclerAdapter.z(this);
        recyclerAdapter.t(this.loadMoreFailText);
        recyclerAdapter.u(this.loadMoreLoadingText);
        recyclerAdapter.v(this.loadMoreNoMoreDataText);
        recyclerAdapter.w(this.loadMoreTextColor);
        recyclerAdapter.x(this.loadMoreTextSize);
        int i = this.defaultLoadMoreStatus;
        if (i != 1) {
            recyclerAdapter.A(i);
        }
        this.waterfallLayout.i(recyclerAdapter);
    }

    private void rebuildMapping(boolean z) {
        this.cellUserId2PositionMap.clear();
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes != null && itemWidgetNodes.size() > 0) {
            int size = itemWidgetNodes.size();
            for (int i = 0; i < size; i++) {
                DXWidgetNode dXWidgetNode = itemWidgetNodes.get(i);
                if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                    if (!TextUtils.isEmpty(dXWidgetNode.getUserId())) {
                        this.cellUserId2PositionMap.put(dXWidgetNode.getUserId(), Integer.valueOf(i));
                    }
                    if (z) {
                        ((DXTemplateWidgetNode) dXWidgetNode).dataIndex = i;
                    }
                }
            }
        }
    }

    private void refresh() {
        refresh(false, "all", -1, 0, null, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    private boolean refreshData(JSONObject jSONObject) {
        List<DXWidgetNode> itemWidgetNodes;
        String str;
        FalcoAbilitySpan abilitySpanFromParams = getAbilitySpanFromParams(jSONObject);
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray == null || jSONArray.size() <= 0) {
                dz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, " dataSize null or 0");
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                resetLoadMoreStatus();
                reloadRecycler(jSONArray, abilitySpanFromParams);
                itemWidgetNodes = getItemWidgetNodes();
                if (itemWidgetNodes != null) {
                    str = "null";
                } else {
                    str = " itemSize " + itemWidgetNodes.size() + "";
                }
                dz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, str);
                c00.n(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass1 */

                    public void run() {
                        DXRecyclerLayout.this.resumeStayTime();
                    }
                }, 300);
                return true;
            }
            if (getExposeHelper() != null) {
                this.mExposeHelper.i(jSONArray);
            }
            triggerStayTime();
            clearExposureCache();
            dz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, "dataSize:" + jSONArray.size());
            if (jSONArray == null) {
            }
            resetLoadMoreStatus();
            reloadRecycler(jSONArray, abilitySpanFromParams);
            itemWidgetNodes = getItemWidgetNodes();
            if (itemWidgetNodes != null) {
            }
            dz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, str);
            c00.n(new Runnable() {
                /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass1 */

                public void run() {
                    DXRecyclerLayout.this.resumeStayTime();
                }
            }, 300);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r1 = r0.getAdapter();
     */
    private void refreshWithRange(final boolean z) {
        RecyclerView e;
        final RecyclerView.Adapter adapter;
        try {
            WaterfallLayout waterfallLayout = this.waterfallLayout;
            if (waterfallLayout != null && (e = waterfallLayout.e()) != null && adapter != null) {
                if (adapter instanceof RecyclerAdapter) {
                    if (e.getScrollState() != 0 || e.isComputingLayout()) {
                        c00.m(new Runnable() {
                            /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass4 */

                            public void run() {
                                if (z) {
                                    DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                                    dXRecyclerLayout.setDataSource((RecyclerAdapter) adapter, dXRecyclerLayout.getItemWidgetNodes());
                                }
                            }
                        });
                    } else if (z) {
                        setDataSource((RecyclerAdapter) adapter, getItemWidgetNodes());
                    }
                }
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    private void reloadRecycler(JSONArray jSONArray, FalcoAbilitySpan falcoAbilitySpan) {
        initDataSourceManager();
        initOperator();
        this.dataSource = jSONArray;
        setItemWidgetNodes(generateWidgetNodeByData(jSONArray, this.originWidgetNodes, 0, jSONArray.size(), falcoAbilitySpan));
        if (at.u0()) {
            refresh(true, "all", -1, 0, null, false);
        } else {
            refresh(true, "all", -1, 0, null, true);
        }
    }

    private boolean removeItemByIndex(int i) {
        List<Object> list = this.dataSource;
        if (list != null && i >= 0 && i < list.size()) {
            this.dataSource.remove(i);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || i < 0 || i >= itemWidgetNodes.size()) {
            return false;
        }
        itemWidgetNodes.remove(i);
        return true;
    }

    private void removeItemsByRef(JSONArray jSONArray) {
        if (at.O0()) {
            this.dxRecyclerJsOperator.u(this, jSONArray);
        } else if (jSONArray != null) {
            boolean z = true;
            if (jSONArray.size() >= 1) {
                boolean z2 = false;
                Object obj = jSONArray.get(0);
                if (obj != null) {
                    if (obj instanceof JSONArray) {
                        Iterator<Object> it = ((JSONArray) obj).iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next != null && (next instanceof Integer) && removeItemByIndex(((Integer) next).intValue())) {
                                z2 = true;
                            }
                        }
                        z = z2;
                    } else if (!(obj instanceof Integer) || !removeItemByIndex(((Integer) obj).intValue())) {
                        z = false;
                    }
                    if (z) {
                        refresh();
                    }
                }
            }
        }
    }

    private void resetLoadMoreStatus() {
        updateLoadMoreStatus(4);
    }

    private void resetOperatorLayout(DXRecyclerLayout dXRecyclerLayout) {
        if (this.dxRecyclerJsOperator == null) {
            this.dxRecyclerJsOperator = new nz();
        }
        if (this.dxRecyclerOperator == null && this.adapterType == 0) {
            this.dxRecyclerOperator = new tz();
        }
    }

    private void scrollTo(JSONArray jSONArray) {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null && waterfallLayout.e() != null && jSONArray != null && jSONArray.size() > 0 && (jSONArray.get(0) instanceof Integer)) {
            int intValue = ((Integer) jSONArray.get(0)).intValue();
            boolean z = true;
            if (jSONArray.size() > 1 && (jSONArray.get(1) instanceof Boolean)) {
                z = jSONArray.getBooleanValue(1);
            }
            if (z) {
                smoothMoveToPosition(this.waterfallLayout.e(), intValue);
                return;
            }
            this.waterfallLayout.e().scrollToPosition(intValue);
            if (this.waterfallLayout.e().getLayoutManager() instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) this.waterfallLayout.e().getLayoutManager()).scrollToPositionWithOffset(intValue, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDataSource(RecyclerAdapter recyclerAdapter, List<DXWidgetNode> list) {
        if (getDXRuntimeContext().getEngineContext().j()) {
            recyclerAdapter.r(this.dataSourceManager);
        } else {
            recyclerAdapter.q(list);
        }
    }

    private void setItem(int i, DXWidgetNode dXWidgetNode) {
        if (getDXRuntimeContext().getEngineContext().j()) {
            dx dxVar = this.dataSourceManager;
            if (dxVar != null) {
                dxVar.setItem(i, dXWidgetNode);
                return;
            }
            return;
        }
        getItemWidgetNodes().set(i, dXWidgetNode);
    }

    private void smoothMoveToPosition(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
            int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
            if (i < childLayoutPosition) {
                recyclerView.smoothScrollToPosition(i);
            } else if (i <= childLayoutPosition2) {
                int i2 = i - childLayoutPosition;
                if (i2 >= 0 && i2 < recyclerView.getChildCount()) {
                    recyclerView.smoothScrollBy(0, recyclerView.getChildAt(i2).getTop());
                }
            } else {
                recyclerView.smoothScrollToPosition(i);
                this.mToPosition = i;
                this.mShouldScroll = true;
            }
        }
    }

    private boolean updateAll(JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<DXWidgetNode> itemWidgetNodes;
        if (at.O0()) {
            return this.dxRecyclerOperator.n(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray(PATH_ACTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray != null && !jSONArray.isEmpty() && (itemWidgetNodes = getItemWidgetNodes()) != null && !itemWidgetNodes.isEmpty()) {
            boolean z = false;
            for (int i = 0; i < this.dataSource.size(); i++) {
                if (updateWithActions(jSONArray, i, falcoSpan)) {
                    z = true;
                }
            }
            if (z) {
                refresh();
                return true;
            }
        }
        return false;
    }

    private boolean updateCurrent(JSONObject jSONObject, boolean z, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode parentTemplateWidgetNode;
        boolean z2 = false;
        if (at.O0()) {
            return this.dxRecyclerOperator.o(this, jSONObject, false, falcoSpan);
        }
        Object obj = jSONObject.get("current");
        if (obj == null) {
            return false;
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray(PATH_ACTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(ITEM_DATA);
        if (jSONArray == null || jSONArray.isEmpty()) {
            if (jSONObject2 != null && (obj instanceof DXWidgetNode)) {
                return updateCurrent((DXWidgetNode) obj, jSONObject2);
            }
        } else if (!(obj instanceof DXWidgetNode) || (parentTemplateWidgetNode = getParentTemplateWidgetNode((DXWidgetNode) obj)) == null) {
            return false;
        } else {
            int indexOf = getItemWidgetNodes().indexOf(parentTemplateWidgetNode);
            boolean updateWithActions = updateWithActions(jSONArray, indexOf, z, falcoSpan);
            if (z) {
                return updateWithActions;
            }
            if (updateWithActions) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("params");
                if (jSONObject3 != null) {
                    z2 = jSONObject3.getBooleanValue("refreshPart");
                }
                if (!z2) {
                    refresh();
                } else if (at.u0()) {
                    refresh(REFRESH_TYPE_PART, indexOf, 1, MSG_METHOD_UPDATE_CURRENT, false);
                } else {
                    refresh(REFRESH_TYPE_PART, indexOf, 1, MSG_METHOD_UPDATE_CURRENT);
                }
                return true;
            }
        }
        return false;
    }

    private void updateItemWithData(JSONObject jSONObject, int i) {
        updateItemWithData(jSONObject, i, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090 A[ADDED_TO_REGION] */
    private boolean updateItems(JSONObject jSONObject) {
        JSONArray jSONArray;
        boolean z;
        JSONArray jSONArray2;
        Integer num;
        JSONObject jSONObject2;
        Exception e;
        if (at.O0()) {
            return this.dxRecyclerOperator.q(this, jSONObject);
        }
        Object obj = jSONObject.get("current");
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            boolean z2 = false;
            for (int i = 0; i < jSONArray.size(); i++) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof JSONObject) {
                    try {
                        num = ((JSONObject) obj2).getInteger("offset");
                        try {
                            jSONArray2 = ((JSONObject) obj2).getJSONArray(PATH_ACTIONS);
                        } catch (Exception e3) {
                            e = e3;
                            jSONArray2 = null;
                            z = false;
                            e.printStackTrace();
                            jSONObject2 = null;
                            if (jSONObject2 != null) {
                            }
                            z2 = true;
                        }
                        try {
                            z = ((JSONObject) obj2).getBoolean("isRelative").booleanValue();
                            try {
                                jSONObject2 = ((JSONObject) obj2).getJSONObject(ITEM_DATA);
                            } catch (Exception e4) {
                                e = e4;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            z = false;
                            e.printStackTrace();
                            jSONObject2 = null;
                            if (jSONObject2 != null) {
                            }
                            z2 = true;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        num = null;
                        jSONArray2 = null;
                        z = false;
                        e.printStackTrace();
                        jSONObject2 = null;
                        if (jSONObject2 != null) {
                        }
                        z2 = true;
                    }
                    if (jSONObject2 != null) {
                        if (num != null) {
                            if (jSONArray2 != null) {
                                if (!jSONArray2.isEmpty()) {
                                    if (!updateWithActions(jSONArray2, getRealIndex(z, -1, num.intValue(), obj), null)) {
                                    }
                                }
                            }
                        }
                    } else if (num != null && !jSONObject2.isEmpty()) {
                        int realIndex = getRealIndex(z, -1, num.intValue(), obj);
                        updateItemWithData(jSONObject2, realIndex);
                        if (realIndex < 0) {
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                refresh();
                return true;
            }
        }
        return false;
    }

    private void updateItemsByRef(JSONArray jSONArray) {
        if (at.O0()) {
            this.dxRecyclerJsOperator.v(this, jSONArray);
        } else if (jSONArray != null && jSONArray.size() > 1) {
            Object obj = jSONArray.get(0);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    int i = -1;
                    try {
                        Integer integer = jSONArray.getInteger(1);
                        if (integer != null) {
                            i = integer.intValue();
                        }
                    } catch (Exception unused) {
                    }
                    updateItemWithData(jSONObject, i);
                } else if (obj instanceof JSONArray) {
                    Object obj2 = jSONArray.get(2);
                    if (obj2 instanceof JSONArray) {
                        for (int i2 = 0; i2 < ((JSONArray) obj2).size(); i2++) {
                            try {
                                updateItemWithData(((JSONArray) obj).getJSONObject(i2), ((JSONArray) obj2).getInteger(i2).intValue());
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
                refresh();
            }
        }
    }

    private boolean updateStyle(JSONObject jSONObject) {
        int d2 = g31.d(Constants.Name.LEFT_GAP, jSONObject, getLeftGap());
        int d3 = g31.d(Constants.Name.RIGHT_GAP, jSONObject, getRightGap());
        int d4 = g31.d(Constants.Name.COLUMN_GAP, jSONObject, getColumnGap());
        if (d2 == getLeftGap() && d3 == getRightGap() && d4 == getColumnGap()) {
            return false;
        }
        setNeedRender(getDXRuntimeContext().getContext());
        return true;
    }

    private boolean updateWithActions(JSONArray jSONArray, int i, FalcoSpan falcoSpan) {
        return updateWithActions(jSONArray, i, false, falcoSpan);
    }

    public void addVisibleStayTag() {
        if (getExposeHelper() != null) {
            getExposeHelper().a();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout != null) {
                currentChildRecyclerLayout.addVisibleStayTag();
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        super.bindRuntimeContext(dXRuntimeContext, z);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXRecyclerLayout();
    }

    public void clearExposureCache() {
        if (getExposeHelper() != null) {
            getExposeHelper().g();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout != null) {
                currentChildRecyclerLayout.clearExposureCache();
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() {
                /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass5 */

                {
                    add("insert");
                    add(DXRecyclerLayout.OPERATOR_ACTION_REMOVE);
                    add("append");
                    add("update");
                    add("reload");
                    add("stopLoading");
                    add("finishedLoading");
                    add("beginUpdates");
                    add("endUpdates");
                    add("scrollTo");
                }
            };
            this.exportMethods.addAll(super.exportMethods());
        }
        return this.exportMethods;
    }

    public DXWidgetNode generateItemWithData(@NonNull Object obj, List<DXWidgetNode> list, int i, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode dXTemplateWidgetNode = null;
        if (at.O0()) {
            dx dxVar = this.dataSourceManager;
            if (dxVar != null) {
                return dxVar.b(this, obj, this.dataSource, list, i, falcoSpan);
            }
            return null;
        }
        int i2 = 0;
        while (i2 < list.size() && (dXTemplateWidgetNode = deepCopyChildForTemplate(list.get(i2), obj, i, falcoSpan)) == null) {
            i2++;
        }
        if (dXTemplateWidgetNode != null) {
            return dXTemplateWidgetNode;
        }
        lz lzVar = new lz();
        lzVar.setDXRuntimeContext(getDXRuntimeContext().cloneWithWidgetNode(this));
        lzVar.setVisibility(2);
        return lzVar;
    }

    /* access modifiers changed from: package-private */
    public List<DXWidgetNode> generateSectionItemWithData(@NonNull JSONObject jSONObject, List<DXWidgetNode> list, int i, FalcoSpan falcoSpan) {
        dx dxVar = this.dataSourceManager;
        if (dxVar != null) {
            return dxVar.c(this, jSONObject, this.dataSource, list, 0, i, falcoSpan);
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public ArrayList<DXWidgetNode> generateWidgetNodeByData(List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        if (!at.O0()) {
            return super.generateWidgetNodeByData(list, list2, i, i2, falcoSpan);
        }
        dx dxVar = this.dataSourceManager;
        if (dxVar != null) {
            return dxVar.d(this, this.dataSource, list2, i, i2, falcoSpan);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public FalcoAbilitySpan getAbilitySpanFromParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Object obj = jSONObject.get(ABILITY_SPAN);
        if (obj instanceof FalcoAbilitySpan) {
            return (FalcoAbilitySpan) obj;
        }
        return null;
    }

    public int getCellIndexByTemplateUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.cellUserId2PositionMap.containsKey(str)) {
            return this.cellUserId2PositionMap.get(str).intValue();
        }
        return -2;
    }

    public Map<String, Integer> getCellUserId2PositionMap() {
        return this.cellUserId2PositionMap;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getColumnGap() {
        return this.columnGap;
    }

    public DXRecyclerLayout getCurrentChildRecyclerLayout() {
        DXRecyclerLayout dXRecyclerLayout;
        DXRecyclerView dXRecyclerView = (DXRecyclerView) getDXRuntimeContext().getRootView().getDxNestedScrollerView().getmChildList();
        if (dXRecyclerView == null || (dXRecyclerLayout = (DXRecyclerLayout) dXRecyclerView.getTag(DXWidgetNode.TAG_WIDGET_NODE)) == this) {
            return null;
        }
        return dXRecyclerLayout;
    }

    public int getDataIndex(DXWidgetNode dXWidgetNode) {
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null || parentTemplateWidgetNode.getDXRuntimeContext() == null) {
            return -1;
        }
        return parentTemplateWidgetNode.dataIndex;
    }

    public IDXDataSourceManager getDataSourceManager() {
        return this.dataSourceManager;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 4480460401770252962L || j == DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return super.getDefaultValueForStringAttr(j);
    }

    public int getEndReachedThreshold() {
        return this.endReachedThreshold;
    }

    public IDXRecyclerOnScrollToPos getIdxRecyclerOnScrollToPos() {
        return this.idxRecyclerOnScrollToPos;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public List<DXWidgetNode> getItemWidgetNodes() {
        if (!at.O0()) {
            return super.getItemWidgetNodes();
        }
        dx dxVar = this.dataSourceManager;
        if (dxVar != null) {
            return dxVar.f();
        }
        return null;
    }

    public int getLeftGap() {
        return this.leftGap;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginLeft() {
        return this.marginLeft;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginRight() {
        return this.marginRight;
    }

    public ArrayList<DXWidgetNode> getOriginWidgetNodes() {
        return this.originWidgetNodes;
    }

    public RecyclerView getRecyclerView() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null) {
            return waterfallLayout.e();
        }
        return null;
    }

    public int getRightGap() {
        return this.rightGap;
    }

    public ScrollListener getScrollListener() {
        return this.scrollListener;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public int getScrollPosition() {
        return this.scrollPosition;
    }

    public int getStartReachedThreshold() {
        return this.startReachedThreshold;
    }

    public WaterfallLayout getWaterfallLayout() {
        return this.waterfallLayout;
    }

    public void initOperator() {
        if (this.adapterType == 0) {
            this.dxRecyclerOperator = new tz();
        }
        this.dxRecyclerJsOperator = new nz();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1411068134:
                if (str.equals("append")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1067535254:
                if (str.equals("finishedLoading")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1042636831:
                if (str.equals("beginUpdates")) {
                    c2 = 3;
                    break;
                }
                break;
            case -948122918:
                if (str.equals("stopLoading")) {
                    c2 = 4;
                    break;
                }
                break;
            case -934641255:
                if (str.equals("reload")) {
                    c2 = 5;
                    break;
                }
                break;
            case -934610812:
                if (str.equals(OPERATOR_ACTION_REMOVE)) {
                    c2 = 6;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c2 = 7;
                    break;
                }
                break;
            case -402165208:
                if (str.equals("scrollTo")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -6925457:
                if (str.equals("endUpdates")) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (!at.O0()) {
                    appendItemsByRef(jSONArray);
                    break;
                } else {
                    this.dxRecyclerJsOperator.r(this, jSONArray);
                    break;
                }
            case 1:
                if (!at.O0()) {
                    insertItemsByRef(jSONArray);
                    break;
                } else {
                    this.dxRecyclerJsOperator.s(this, jSONArray);
                    break;
                }
            case 2:
                updateLoadMoreStatus(5);
                break;
            case 3:
            case '\t':
                break;
            case 4:
                updateLoadMoreStatus(4);
                WaterfallLayout waterfallLayout = this.waterfallLayout;
                if (waterfallLayout != null) {
                    waterfallLayout.q();
                    break;
                }
                break;
            case 5:
                if (jSONArray != null && jSONArray.size() > 0) {
                    Object obj = jSONArray.get(0);
                    if (obj != null) {
                        if (obj instanceof JSONArray) {
                            reloadRecycler((JSONArray) obj, null);
                            break;
                        }
                    } else {
                        reloadRecycler(null, null);
                        break;
                    }
                }
                break;
            case 6:
                if (!at.O0()) {
                    removeItemsByRef(jSONArray);
                    break;
                } else {
                    this.dxRecyclerJsOperator.u(this, jSONArray);
                    break;
                }
            case 7:
                if (!at.O0()) {
                    updateItemsByRef(jSONArray);
                    break;
                } else {
                    this.dxRecyclerJsOperator.v(this, jSONArray);
                    break;
                }
            case '\b':
                scrollTo(jSONArray);
                break;
            default:
                return super.invokeRefMethod(str, jSONArray);
        }
        return null;
    }

    public boolean isEnableLeftGapWhenSingleColumn() {
        return this.enableLeftGapWhenSingleColumn;
    }

    public boolean isEnableVideoControl() {
        return this.videoControlConfig instanceof DXVideoControlConfig;
    }

    public boolean isItemsNull() {
        if (getDXRuntimeContext().getEngineContext().j()) {
            dx dxVar = this.dataSourceManager;
            if (dxVar != null) {
                return dxVar.isItemsNull();
            }
            return true;
        } else if (getItemWidgetNodes() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isReachTop() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null) {
            return waterfallLayout.z;
        }
        return false;
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        Object obj;
        initDataSourceManager();
        initOperator();
        setOrientation(getOrientation());
        List<Object> list = this.dataSource;
        if (list == null || list.size() == 0) {
            wz.b("this.dataSource == null || this.dataSource.size() == 0");
        }
        super.onBeforeBindChildData();
        if (!at.u0()) {
            rebuildMapping(true);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || itemWidgetNodes.size() == 0) {
            List<Object> list2 = this.dataSource;
            if (list2 != null && list2.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("生成的子节点为空，或者数量为 0 。 dataSource: ");
                List<Object> list3 = this.dataSource;
                if (list3 == null) {
                    obj = " null ";
                } else {
                    obj = Integer.valueOf(list3.size());
                }
                sb.append(obj);
                trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BEFORE_DATA, sb.toString());
                return;
            }
            return;
        }
        for (DXWidgetNode dXWidgetNode : itemWidgetNodes) {
            bindSpanCtx(dXWidgetNode);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode instanceof DXRecyclerLayout) {
            super.onClone(dXWidgetNode, z);
            DXRecyclerLayout dXRecyclerLayout = (DXRecyclerLayout) dXWidgetNode;
            this.columnCount = dXRecyclerLayout.columnCount;
            this.columnGap = dXRecyclerLayout.columnGap;
            this.disableBounces = dXRecyclerLayout.disableBounces;
            this.isOpenLoadMore = dXRecyclerLayout.isOpenLoadMore;
            this.loadMoreFailText = dXRecyclerLayout.loadMoreFailText;
            this.loadMoreLoadingText = dXRecyclerLayout.loadMoreLoadingText;
            this.loadMoreNoMoreDataText = dXRecyclerLayout.loadMoreNoMoreDataText;
            this.dataSource = dXRecyclerLayout.dataSource;
            setItemWidgetNodes(dXRecyclerLayout.getItemWidgetNodes());
            this.appearWidgets = dXRecyclerLayout.appearWidgets;
            this.disableBounces = dXRecyclerLayout.disableBounces;
            this.endReachedThreshold = dXRecyclerLayout.endReachedThreshold;
            this.isOpenLoadMore = dXRecyclerLayout.isOpenLoadMore;
            this.isOpenPullToRefresh = dXRecyclerLayout.isOpenPullToRefresh;
            this.leftGap = dXRecyclerLayout.leftGap;
            this.loadMoreTextColor = dXRecyclerLayout.loadMoreTextColor;
            this.loadMoreTextSize = dXRecyclerLayout.loadMoreTextSize;
            this.refreshLoadingText = dXRecyclerLayout.refreshLoadingText;
            this.refreshPullText = dXRecyclerLayout.refreshPullText;
            this.refreshReleaseText = dXRecyclerLayout.refreshReleaseText;
            this.rightGap = dXRecyclerLayout.rightGap;
            this.scrollListener = dXRecyclerLayout.scrollListener;
            this.exposureTimeFactor = dXRecyclerLayout.exposureTimeFactor;
            this.exposureSpaceFactor = dXRecyclerLayout.exposureSpaceFactor;
            com.taobao.android.dinamicx.widget.recycler.expose.b bVar = dXRecyclerLayout.mExposeHelper;
            this.mExposeHelper = bVar;
            this.enableLeftGapWhenSingleColumn = dXRecyclerLayout.enableLeftGapWhenSingleColumn;
            this.defaultLoadMoreStatus = dXRecyclerLayout.defaultLoadMoreStatus;
            this.idxRecyclerOnScrollToPos = dXRecyclerLayout.idxRecyclerOnScrollToPos;
            this.enableTrackStayTime = dXRecyclerLayout.enableTrackStayTime;
            if (bVar != null) {
                bVar.i(this.dataSource);
            }
            this.openPrefetch = dXRecyclerLayout.openPrefetch;
            this.preFetchBatchSize = dXRecyclerLayout.preFetchBatchSize;
            this.startReachedThreshold = dXRecyclerLayout.startReachedThreshold;
            this.needItemAnimation = dXRecyclerLayout.needItemAnimation;
            this.fixVerticalScrollConflict = dXRecyclerLayout.fixVerticalScrollConflict;
            this.videoControlConfig = dXRecyclerLayout.videoControlConfig;
            this.adapterType = dXRecyclerLayout.adapterType;
            this.dataSourceManager = dXRecyclerLayout.dataSourceManager;
            sz szVar = dXRecyclerLayout.dxRecyclerOperator;
            if (szVar != null) {
                this.dxRecyclerOperator = szVar;
            }
            nz nzVar = dXRecyclerLayout.dxRecyclerJsOperator;
            if (nzVar != null) {
                this.dxRecyclerJsOperator = nzVar;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        postEvent(new lx(5288680013941347641L));
        getDXRuntimeContext().getEngineContext().b().c();
        WaterfallLayout.b bVar = new WaterfallLayout.b();
        DXNestedScrollerView dxNestedScrollerView = getDXRuntimeContext().getRootView().getDxNestedScrollerView();
        if (dxNestedScrollerView != null) {
            dxNestedScrollerView.setFixVerticalScrollConflict(this.fixVerticalScrollConflict);
        }
        WaterfallLayout a2 = bVar.b(this.columnCount).c(this.columnGap).i(this.marginLeft).j(this.marginRight).h(this.leftGap).m(this.rightGap).d(this.disableBounces == 1).g(this.isOpenPullToRefresh == 1).l(new String[]{this.refreshPullText, this.refreshReleaseText, this.refreshLoadingText, "刷新完成"}).n(null).e(dxNestedScrollerView).f(this.enableLeftGapWhenSingleColumn).k(this.needItemAnimation).o(getOrientation()).a();
        this.waterfallLayout = a2;
        View a3 = a2.a(context);
        a3.setTag(R$id.dx_recycler_layout_view_tag, this.waterfallLayout);
        this.pullRefreshListener = new yv1(this);
        this.scrollListener = new ScrollListener(this);
        this.waterfallLayout.k(this.pullRefreshListener);
        this.waterfallLayout.l(this.scrollListener);
        initExpose(this.waterfallLayout.e());
        initVideoPlayControl(this.waterfallLayout.e());
        return a3;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(lx lxVar) {
        if (lxVar instanceof ty) {
            ty tyVar = (ty) lxVar;
            if (tyVar.h().equalsIgnoreCase("General")) {
                String f = tyVar.f();
                JSONObject g = tyVar.g();
                boolean z = false;
                if (g == null) {
                    return false;
                }
                FalcoAbilitySpan abilitySpanFromParams = getAbilitySpanFromParams(g);
                dz.q(abilitySpanFromParams, MSG_METHOD_UPDATE_CURRENT, "start");
                f.hashCode();
                char c2 = 65535;
                switch (f.hashCode()) {
                    case -1675200021:
                        if (f.equals(MSG_METHOD_INSERT_ITEMS_BY_OFFSET)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1472811200:
                        if (f.equals(MSG_METHOD_APPEND_ITEMS)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -954124385:
                        if (f.equals(MSG_METHOD_REFRESH_DATA)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -724196078:
                        if (f.equals(MSG_METHOD_UPDATE_ALL)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -708482225:
                        if (f.equals(MSG_METHOD_DELETE_ITEMS)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -232077206:
                        if (f.equals(MSG_METHOD_UPDATE_CURRENT)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -160105743:
                        if (f.equals(MSG_METHOD_UPDATE_ITEMS)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -150851358:
                        if (f.equals(MSG_METHOD_UPDATE_STYLE)) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 310191873:
                        if (f.equals(MSG_METHOD_INSERT_ITEMS)) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1086719573:
                        if (f.equals(MSG_METHOD_PULL_TO_REFRESH)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1534853078:
                        if (f.equals(MSG_METHOD_MODIFY_CURRENT_ITEM_DATA)) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 1884917025:
                        if (f.equals(MSG_METHOD_LOAD_MORE)) {
                            c2 = 11;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (!at.O0()) {
                            z = insertItemsByOffset(g, abilitySpanFromParams);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.j(this, g, abilitySpanFromParams);
                            break;
                        }
                    case 1:
                        if (!at.O0()) {
                            z = appendItems(g, abilitySpanFromParams);
                            break;
                        } else {
                            this.dxRecyclerOperator.a(this, g, abilitySpanFromParams);
                            return true;
                        }
                    case 2:
                        z = refreshData(g);
                        break;
                    case 3:
                        if (!at.O0()) {
                            z = updateAll(g, abilitySpanFromParams);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.n(this, g, abilitySpanFromParams);
                            break;
                        }
                    case 4:
                        if (!at.O0()) {
                            z = deleteItems(g);
                            break;
                        } else {
                            this.dxRecyclerOperator.b(this, g);
                            return true;
                        }
                    case 5:
                        if (!at.O0()) {
                            z = updateCurrent(g, abilitySpanFromParams);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.o(this, g, false, abilitySpanFromParams);
                            break;
                        }
                    case 6:
                        if (!at.O0()) {
                            z = updateItems(g);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.q(this, g);
                            break;
                        }
                    case 7:
                        z = updateStyle(g);
                        break;
                    case '\b':
                        if (!at.O0()) {
                            z = insertItems(g, abilitySpanFromParams);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.i(this, g, abilitySpanFromParams);
                            break;
                        }
                    case '\t':
                        z = onRefresh(g);
                        break;
                    case '\n':
                        if (!at.O0()) {
                            z = updateCurrent(g, true, (FalcoSpan) abilitySpanFromParams);
                            break;
                        } else {
                            z = this.dxRecyclerOperator.o(this, g, true, abilitySpanFromParams);
                            break;
                        }
                    case 11:
                        z = onLoadMore(g);
                        break;
                }
                dz.q(abilitySpanFromParams, f, "end " + z);
                dz.l(abilitySpanFromParams);
                return z;
            }
        }
        return super.onEvent(lxVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener
    public void onLoadMore() {
        if (DinamicXEngine.x()) {
            float f = (float) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
            float freeMemory = (float) ((((double) Runtime.getRuntime().freeMemory()) * 1.0d) / 1048576.0d);
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            sb.append("内存优化");
            sb.append(getDXRuntimeContext().getEngineContext().j() ? "开" : "关");
            sb.append(" dataSource ");
            sb.append(this.dataSource.size());
            sb.append(" / totalMem ");
            sb.append(f);
            sb.append(" / freeMem ");
            sb.append(freeMemory);
            strArr[0] = sb.toString();
            ry.i("RLMemPerf", strArr);
        }
        updateLoadMoreStatus(2);
        postOnLoadMoreEvent();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        removeAllChild();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017b  */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        RecyclerView e;
        boolean z;
        RecyclerAdapter recyclerAdapter;
        PrefetchRecyclerAdapter prefetchRecyclerAdapter;
        PrefetchRecyclerAdapter prefetchRecyclerAdapter2;
        getDXRuntimeContext().getEngineContext().e().b();
        super.onRenderView(context, view);
        if (view != null) {
            if (getChildrenCount() > 0) {
                DXWidgetNode widgetNode = getDXRuntimeContext().getWidgetNode();
                if (widgetNode != null) {
                    widgetNode.removeAllChild();
                    removeAllChild();
                } else {
                    return;
                }
            }
            if (this.waterfallLayout == null) {
                Object tag = view.getTag(R$id.dx_recycler_layout_view_tag);
                if (tag instanceof WaterfallLayout) {
                    this.waterfallLayout = (WaterfallLayout) tag;
                }
            }
            if (this.scrollListener == null) {
                initScrollListener();
            }
            WaterfallLayout waterfallLayout = this.waterfallLayout;
            if (!(waterfallLayout == null || (e = waterfallLayout.e()) == null)) {
                RecyclerAdapter recyclerAdapter2 = (RecyclerAdapter) e.getAdapter();
                if (recyclerAdapter2 == null) {
                    if (isOpenPrefetch()) {
                        PrefetchRecyclerAdapter prefetchRecyclerAdapter3 = new PrefetchRecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                        prefetchRecyclerAdapter3.M(this.preFetchBatchSize);
                        prefetchRecyclerAdapter2 = prefetchRecyclerAdapter3;
                    } else {
                        prefetchRecyclerAdapter2 = new RecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                    }
                    reInitAdapter(prefetchRecyclerAdapter2);
                } else {
                    this.waterfallLayout.h(this.columnCount, -1, this.columnGap, this.leftGap, this.rightGap, this.paddingLeft, this.paddingRight, this.paddingTop, this.paddingBottom, this.marginLeft, this.marginRight, this.isOpenPullToRefresh == 1, false, new String[]{this.refreshPullText, this.refreshReleaseText, this.refreshLoadingText, "刷新完成"}, null, this.disableBounces == 1, this.enableLeftGapWhenSingleColumn);
                    if (!(recyclerAdapter2 instanceof PrefetchRecyclerAdapter)) {
                        if (isOpenPrefetch()) {
                            PrefetchRecyclerAdapter prefetchRecyclerAdapter4 = new PrefetchRecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                            prefetchRecyclerAdapter4.M(this.preFetchBatchSize);
                            prefetchRecyclerAdapter = prefetchRecyclerAdapter4;
                        }
                        z = true;
                        recyclerAdapter = recyclerAdapter2;
                        if (z) {
                        }
                    } else if (isOpenPrefetch()) {
                        ((PrefetchRecyclerAdapter) recyclerAdapter2).M(this.preFetchBatchSize);
                        z = true;
                        recyclerAdapter = recyclerAdapter2;
                        if (z) {
                            setDataSource(recyclerAdapter, getItemWidgetNodes());
                            recyclerAdapter.z(this);
                            recyclerAdapter.t(this.loadMoreFailText);
                            recyclerAdapter.u(this.loadMoreLoadingText);
                            recyclerAdapter.v(this.loadMoreNoMoreDataText);
                            recyclerAdapter.w(this.loadMoreTextColor);
                            recyclerAdapter.x(this.loadMoreTextSize);
                            boolean z2 = true;
                            if (this.isOpenLoadMore != 1) {
                                z2 = false;
                            }
                            recyclerAdapter.y(z2);
                            recyclerAdapter.notifyDataSetChanged();
                        } else {
                            this.waterfallLayout.g(e, context);
                            reInitAdapter(recyclerAdapter);
                        }
                    } else {
                        prefetchRecyclerAdapter = new RecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                    }
                    z = false;
                    recyclerAdapter = prefetchRecyclerAdapter;
                    if (z) {
                    }
                }
                e.setTag(DXWidgetNode.TAG_WIDGET_NODE, this);
            }
            if (getExposeHelper() != null) {
                this.mExposeHelper.i(this.dataSource);
            }
            ScrollListener scrollListener2 = this.scrollListener;
            if (scrollListener2 != null) {
                scrollListener2.b();
            }
            initOnTouchListener();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d2) {
        if (j == DXRECYCLERLAYOUT_EXPOSURESPACEFACTOR) {
            this.exposureSpaceFactor = d2;
        } else {
            super.onSetDoubleAttribute(j, d2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 4480460401770252962L) {
            this.columnCount = i;
        } else if (j == DXRECYCLERLAYOUT_COLUMNGAP) {
            this.columnGap = i;
        } else if (j == DXRECYCLERLAYOUT_DISABLEBOUNCES) {
            this.disableBounces = i;
        } else if (j == DXRECYCLERLAYOUT_ENDREACHEDTHRESHOLD) {
            this.endReachedThreshold = i;
        } else if (j == 2380170249149374095L) {
            this.isOpenLoadMore = i;
        } else if (j == DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH) {
            this.isOpenPullToRefresh = i;
        } else if (j == DXRECYCLERLAYOUT_LEFTGAP) {
            this.leftGap = i;
        } else if (j == DXRECYCLERLAYOUT_LOADMORETEXTCOLOR) {
            this.loadMoreTextColor = i;
        } else if (j == DXRECYCLERLAYOUT_LOADMORETEXTSIZE) {
            this.loadMoreTextSize = i;
        } else if (j == DXRECYCLERLAYOUT_RIGHTGAP) {
            this.rightGap = i;
        } else {
            boolean z = false;
            if (j == DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN) {
                if (i != 0) {
                    z = true;
                }
                this.enableLeftGapWhenSingleColumn = z;
            } else if (j == DXRECYCLERLAYOUT_DEFAULTLOADMORESTATUS) {
                this.defaultLoadMoreStatus = i;
            } else if (j == DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME) {
                if (i == 1) {
                    z = true;
                }
                this.enableTrackStayTime = z;
            } else if (j == DXRECYCLERLAYOUT_OPENPREFETCH) {
                this.openPrefetch = i;
            } else if (j == DXRECYCLERLAYOUT_PREFETCHBATCHSIZE) {
                this.preFetchBatchSize = i;
            } else if (j == DXRECYCLERLAYOUT_STARTREACHEDTHRESHOLD) {
                this.startReachedThreshold = i;
            } else if (j == DXRECYCLERLAYOUT_NEEDITEMANIMATION) {
                if (i == 1) {
                    z = true;
                }
                this.needItemAnimation = z;
            } else if (j == DXRECYCLERLAYOUT_FIXVERTICALSCROLLCONFLICT) {
                if (i == 1) {
                    z = true;
                }
                this.fixVerticalScrollConflict = z;
            } else if (j == DXRECYCLERLAYOUT_ADAPTERTYPE) {
                this.adapterType = i;
            } else {
                super.onSetIntAttribute(j, i);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -5948810534719014123L) {
            this.dataSource = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j, long j2) {
        if (j == DXRECYCLERLAYOUT_EXPOSURETIMEFACTOR) {
            this.exposureTimeFactor = j2;
        } else {
            super.onSetLongAttribute(j, j2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        if (j == -7801350391660369312L) {
            this.videoControlConfig = obj;
        } else {
            super.onSetObjAttribute(j, obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 7321446999712924516L) {
            this.loadMoreFailText = str;
        } else if (j == -3963239569560963927L) {
            this.loadMoreLoadingText = str;
        } else if (j == -7969714938924101192L) {
            this.loadMoreNoMoreDataText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHLOADINGTEXT) {
            this.refreshLoadingText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHPULLTEXT) {
            this.refreshPullText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHRELEASETEXT) {
            this.refreshReleaseText = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    public void postOnStartReachedEvent() {
        postEvent(new lx(DXRECYCLERLAYOUT_ONSTARTREACHED));
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByAutoId(int i) {
        return super.queryWTByAutoId(i);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByUserId(String str) {
        return super.queryWTByUserId(str);
    }

    public boolean refreshCurrentNode(DXWidgetNode dXWidgetNode) {
        if (!(dXWidgetNode instanceof DXTemplateWidgetNode) || dXWidgetNode.getDXRuntimeContext().getSubData() == null) {
            dXWidgetNode.getDXRuntimeContext().getData();
        } else {
            JSONObject jSONObject = (JSONObject) dXWidgetNode.getDXRuntimeContext().getSubData();
        }
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null) {
            return false;
        }
        int indexOfItem = indexOfItem(parentTemplateWidgetNode);
        if (indexOfItem < 0) {
            trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_230007, "index: " + indexOfItem);
            return false;
        }
        wz.e(" updateCurrent 获取到的index 为" + indexOfItem);
        refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT);
        return true;
    }

    public void resumeStayTime() {
        if (getExposeHelper() != null) {
            getExposeHelper().h();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout != null) {
                currentChildRecyclerLayout.resumeStayTime();
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    public void scrollToPosForAbility(boolean z, int i) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
            IDXRecyclerOnScrollToPos iDXRecyclerOnScrollToPos = this.idxRecyclerOnScrollToPos;
            if (iDXRecyclerOnScrollToPos != null) {
                iDXRecyclerOnScrollToPos.onScrollToPos(i);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(lx lxVar) {
        super.sendBroadcastEvent(lxVar);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (this.waterfallLayout == null && view != null) {
            Object tag = view.getTag(R$id.dx_recycler_layout_view_tag);
            if (tag instanceof WaterfallLayout) {
                this.waterfallLayout = (WaterfallLayout) tag;
            }
        }
        if (this.waterfallLayout != null) {
            if (hasCornerRadius()) {
                WaterfallLayout.c cVar = new WaterfallLayout.c();
                int i = this.cornerRadius;
                if (i > 0) {
                    cVar.j(view, (float) i);
                } else {
                    cVar.k(view, (float) this.cornerRadiusLeftTop, (float) this.cornerRadiusRightTop, (float) this.cornerRadiusLeftBottom, (float) this.cornerRadiusRightBottom);
                }
                this.waterfallLayout.j(cVar);
            } else {
                be b2 = this.waterfallLayout.b();
                if (b2 != null) {
                    b2.j(view, 0.0f);
                }
            }
        }
        super.setBackground(view);
    }

    public void setIdxRecyclerOnScrollToPos(IDXRecyclerOnScrollToPos iDXRecyclerOnScrollToPos) {
        this.idxRecyclerOnScrollToPos = iDXRecyclerOnScrollToPos;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public void setItemWidgetNodes(List<DXWidgetNode> list) {
        if (at.O0()) {
            dx dxVar = this.dataSourceManager;
            if (dxVar != null) {
                dxVar.i(list);
                this.dataSourceManager.h(this.dataSource);
                return;
            }
            return;
        }
        super.setItemWidgetNodes(list);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public void setScrollPosition(int i) {
        this.scrollPosition = i;
    }

    public void setStartReachedThreshold(int i) {
        this.startReachedThreshold = i;
    }

    public void trackError(int i, String str) {
        trackError(i, str + " rlId: " + getUserId(), "DX_RECYCLER", "DX_RECYCLER_ERROR");
    }

    public void triggerExposure() {
        if (getExposeHelper() != null) {
            getExposeHelper().d();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout == null) {
                return;
            }
            if (currentChildRecyclerLayout != this) {
                currentChildRecyclerLayout.triggerExposure();
            }
        } catch (Throwable th) {
            ry.d(TAG, "triggerExposure ", th);
            vx.b(th);
        }
    }

    public void triggerOnStickyChange(int i, boolean z) {
        lx lxVar = new lx(2228800223520853672L);
        HashMap hashMap = new HashMap();
        hashMap.put("index", ey.J((long) i));
        hashMap.put("sticky", ey.F(z));
        lxVar.d(hashMap);
        postEvent(lxVar);
    }

    public void triggerScrollToWhenScrollByFinish(RecyclerView recyclerView) {
        if (this.mShouldScroll) {
            this.mShouldScroll = false;
            smoothMoveToPosition(recyclerView, this.mToPosition);
        }
    }

    public void triggerStayTime() {
        if (getExposeHelper() != null) {
            getExposeHelper().e();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout != null) {
                currentChildRecyclerLayout.triggerStayTime();
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    public void updateItem(DXTemplateWidgetNode dXTemplateWidgetNode) {
        int indexOf;
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (dXTemplateWidgetNode != null && itemWidgetNodes != null && (indexOf = itemWidgetNodes.indexOf(dXTemplateWidgetNode)) >= 0 && dXTemplateWidgetNode.getDXRuntimeContext() != null && (dXTemplateWidgetNode.getDXRuntimeContext().getSubData() instanceof JSONObject)) {
            updateItemWithData((JSONObject) dXTemplateWidgetNode.getDXRuntimeContext().getSubData(), indexOf, null);
            refresh();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public boolean updateLoadMoreStatus(int i) {
        RecyclerView e;
        RecyclerAdapter recyclerAdapter;
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout == null || (e = waterfallLayout.e()) == null || (recyclerAdapter = (RecyclerAdapter) e.getAdapter()) == null) {
            return false;
        }
        recyclerAdapter.A(i);
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setRefreshType(i);
        }
        if (getItemWidgetNodes() != null) {
            for (DXWidgetNode dXWidgetNode : getItemWidgetNodes()) {
                dXWidgetNode.updateRefreshType(i);
            }
        }
    }

    private void refresh(String str, int i, int i2, String str2) {
        refresh(false, str, i, i2, str2, true);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean updateWithActions(JSONArray jSONArray, int i, boolean z, FalcoSpan falcoSpan) {
        char c2;
        char c3;
        if (i < 0 || i >= this.dataSource.size()) {
            trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_230004, "index: " + i + " dataSource.size() " + this.dataSource.size());
            return false;
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || itemWidgetNodes.isEmpty()) {
            return false;
        }
        Object obj = this.dataSource.get(i);
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!(next instanceof JSONObject)) {
                return false;
            }
            JSONObject jSONObject = (JSONObject) next;
            String string = jSONObject.getString(PATH_OPERATOR);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            String string2 = jSONObject.getString("key");
            if (TextUtils.isEmpty(string2)) {
                return false;
            }
            Object obj2 = jSONObject.get("value");
            ArrayDeque arrayDeque = new ArrayDeque();
            parseFieldNamePathQueue(string2, arrayDeque);
            Object obj3 = obj;
            while (true) {
                if (!arrayDeque.isEmpty()) {
                    String poll = arrayDeque.poll();
                    if (arrayDeque.isEmpty()) {
                        if (obj3 instanceof JSONObject) {
                            string.hashCode();
                            switch (string.hashCode()) {
                                case -1068795718:
                                    if (string.equals(OPERATOR_ACTION_MODIFY)) {
                                        c3 = 0;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case -934610812:
                                    if (string.equals(OPERATOR_ACTION_REMOVE)) {
                                        c3 = 1;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 103785528:
                                    if (string.equals(OPERATOR_ACTION_MERGE)) {
                                        c3 = 2;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                default:
                                    c3 = 65535;
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                    ((JSONObject) obj3).put(poll, obj2);
                                    if (z) {
                                        break;
                                    } else {
                                        updateItemWithData((JSONObject) obj, i, falcoSpan);
                                        break;
                                    }
                                case 1:
                                    ((JSONObject) obj3).remove(poll);
                                    if (z) {
                                        break;
                                    } else {
                                        updateItemWithData((JSONObject) obj, i, falcoSpan);
                                        break;
                                    }
                                case 2:
                                    Object obj4 = ((JSONObject) obj3).get(poll);
                                    if ((obj4 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                        ((JSONObject) obj4).putAll((JSONObject) obj2);
                                        if (z) {
                                            break;
                                        } else {
                                            updateItemWithData((JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    } else {
                                        return false;
                                    }
                                default:
                                    return false;
                            }
                        } else if (obj3 instanceof JSONArray) {
                            try {
                                int parseInt = Integer.parseInt(poll);
                                string.hashCode();
                                switch (string.hashCode()) {
                                    case -1068795718:
                                        if (string.equals(OPERATOR_ACTION_MODIFY)) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -934610812:
                                        if (string.equals(OPERATOR_ACTION_REMOVE)) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 103785528:
                                        if (string.equals(OPERATOR_ACTION_MERGE)) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        ((JSONArray) obj3).set(parseInt, obj2);
                                        if (!(obj instanceof JSONObject)) {
                                            break;
                                        } else {
                                            updateItemWithData((JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    case 1:
                                        ((JSONArray) obj3).remove(parseInt);
                                        if (!(obj instanceof JSONObject)) {
                                            break;
                                        } else {
                                            updateItemWithData((JSONObject) obj, i, falcoSpan);
                                            break;
                                        }
                                    case 2:
                                        Object obj5 = ((JSONArray) obj3).get(parseInt);
                                        if ((obj5 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                            ((JSONObject) obj5).putAll((JSONObject) obj2);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                updateItemWithData((JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        } else {
                                            return false;
                                        }
                                    default:
                                        return false;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } else if (!(obj3 instanceof JSONObject)) {
                        return false;
                    } else {
                        obj3 = ((JSONObject) obj3).get(poll);
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void resetLoadMoreStatus(int i) {
        updateLoadMoreStatus(i);
    }

    public void updateItemWithData(Object obj, int i, FalcoSpan falcoSpan) {
        DXWidgetNode generateItemWithData;
        List<Object> list = this.dataSource;
        if (list != null && i >= 0 && i < list.size()) {
            this.dataSource.set(i, obj);
        }
        if (!isItemsNull() && i >= 0 && i < getRealCount() && (generateItemWithData = generateItemWithData(obj, this.originWidgetNodes, i, falcoSpan)) != null) {
            setItem(i, generateItemWithData);
        }
    }

    private void refresh(String str, int i, int i2, String str2, boolean z) {
        refresh(false, str, i, i2, str2, z);
    }

    public void refresh(final boolean z, final String str, final int i, final int i2, final String str2, boolean z2) {
        try {
            if (this.waterfallLayout != null) {
                triggerExposure();
                this.waterfallLayout.n(false);
                RecyclerView e = this.waterfallLayout.e();
                if (e != null) {
                    final RecyclerView.Adapter adapter = e.getAdapter();
                    if (adapter instanceof RecyclerAdapter) {
                        if (e.getScrollState() != 0 || e.isComputingLayout()) {
                            c00.m(new Runnable() {
                                /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass2 */

                                public void run() {
                                    if (z) {
                                        DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                                        dXRecyclerLayout.setDataSource((RecyclerAdapter) adapter, dXRecyclerLayout.getItemWidgetNodes());
                                    }
                                    DXRecyclerLayout.this.notifyData(adapter, str, i, i2, str2);
                                }
                            });
                        } else {
                            if (z) {
                                setDataSource((RecyclerAdapter) adapter, getItemWidgetNodes());
                            }
                            notifyData(adapter, str, i, i2, str2);
                        }
                        c00.n(new Runnable() {
                            /* class com.taobao.android.dinamicx.widget.DXRecyclerLayout.AnonymousClass3 */

                            public void run() {
                                DXRecyclerLayout.this.addVisibleStayTag();
                            }
                        }, 100);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (getExposeHelper() != null) {
                this.mExposeHelper.i(this.dataSource);
            }
            if (z2) {
                rebuildMapping(true, i, i2);
            }
        } catch (Throwable th) {
            vx.b(th);
        }
    }

    private boolean onLoadMore(@NonNull JSONObject jSONObject) {
        String string = jSONObject.getString("status");
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case -1884319283:
                if (string.equals(LOAD_MORE_STOPED)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1281977283:
                if (string.equals("failed")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1040845642:
                if (string.equals(LOAD_MORE_NO_DATA_STRING)) {
                    c2 = 2;
                    break;
                }
                break;
            case 96634189:
                if (string.equals(LOAD_MORE_EMPTY)) {
                    c2 = 3;
                    break;
                }
                break;
            case 336650556:
                if (string.equals("loading")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return updateLoadMoreStatus(4);
            case 1:
                return updateLoadMoreStatus(3);
            case 2:
                return updateLoadMoreStatus(5);
            case 3:
                return updateLoadMoreStatus(6);
            case 4:
                return updateLoadMoreStatus(2);
            default:
                return false;
        }
    }

    private void rebuildMapping(boolean z, int i, int i2) {
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (i < 0) {
            rebuildMapping(z);
        } else if (itemWidgetNodes != null && itemWidgetNodes.size() > 0 && itemWidgetNodes.size() > i) {
            int size = itemWidgetNodes.size();
            while (i < size) {
                DXWidgetNode dXWidgetNode = itemWidgetNodes.get(i);
                if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                    if (!TextUtils.isEmpty(dXWidgetNode.getUserId())) {
                        this.cellUserId2PositionMap.put(dXWidgetNode.getUserId(), Integer.valueOf(i));
                    }
                    if (z) {
                        ((DXTemplateWidgetNode) dXWidgetNode).dataIndex = i;
                    }
                }
                i++;
            }
        } else {
            return;
        }
        this.cellUserId2PositionMap.clear();
        if (itemWidgetNodes != null && itemWidgetNodes.size() > 0) {
            int size2 = itemWidgetNodes.size();
            for (int i3 = 0; i3 < size2; i3++) {
                DXWidgetNode dXWidgetNode2 = itemWidgetNodes.get(i3);
                if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
                    if (!TextUtils.isEmpty(dXWidgetNode2.getUserId())) {
                        this.cellUserId2PositionMap.put(dXWidgetNode2.getUserId(), Integer.valueOf(i3));
                    }
                    if (z) {
                        ((DXTemplateWidgetNode) dXWidgetNode2).dataIndex = i3;
                    }
                }
            }
        }
    }

    private boolean updateCurrent(JSONObject jSONObject, FalcoSpan falcoSpan) {
        return updateCurrent(jSONObject, false, falcoSpan);
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode) {
        JSONObject jSONObject;
        if (!(dXWidgetNode instanceof DXTemplateWidgetNode) || dXWidgetNode.getDXRuntimeContext().getSubData() == null) {
            jSONObject = dXWidgetNode.getDXRuntimeContext().getData();
        } else {
            jSONObject = (JSONObject) dXWidgetNode.getDXRuntimeContext().getSubData();
        }
        return updateCurrent(dXWidgetNode, jSONObject);
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode, JSONObject jSONObject, boolean z) {
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null) {
            return false;
        }
        int indexOfItem = indexOfItem(parentTemplateWidgetNode);
        if (indexOfItem < 0) {
            trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_230005, "index: " + indexOfItem);
            return false;
        }
        wz.e(" updateCurrent 获取到的index 为" + indexOfItem);
        updateItemWithData(jSONObject, indexOfItem);
        if (z) {
            return true;
        }
        if (at.u0()) {
            refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT, false);
            return true;
        }
        refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT, true);
        return true;
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode, JSONObject jSONObject) {
        return updateCurrent(dXWidgetNode, jSONObject, false);
    }
}
