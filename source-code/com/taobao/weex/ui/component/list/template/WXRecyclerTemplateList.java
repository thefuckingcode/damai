package com.taobao.weex.ui.component.list.template;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.ICheckBindingScroller;
import com.taobao.weex.common.OnWXScrollListener;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.AppearanceHelper;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXBaseRefresh;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXRefresh;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.binding.Layouts;
import com.taobao.weex.ui.component.binding.Statements;
import com.taobao.weex.ui.component.helper.ScrollStartEndHelper;
import com.taobao.weex.ui.component.list.RecyclerTransform;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener;
import com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;
import com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.o70;
import tb.v7;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXRecyclerTemplateList extends WXVContainer<BounceRecyclerView> implements IRecyclerAdapterListener<TemplateViewHolder>, IOnLoadMoreListener, Scrollable {
    private static final long APPEAR_CHANGE_RUNNABLE_DELAY = 50;
    private static final String EMPTY_HOLDER_TEMPLATE_KEY = "";
    public static final boolean ENABLE_TRACE_LOG = false;
    private static final String NAME_HAS_FIXED_SIZE = "hasFixedSize";
    private static final String NAME_ITEM_VIEW_CACHE_SIZE = "itemViewCacheSize";
    private static final String NAME_TEMPLATE_CACHE_SIZE = "templateCacheSize";
    public static final String TAG = "WXRecyclerTemplateList";
    private CellDataManager cellDataManager;
    private CellRenderContext cellRenderContext = new CellRenderContext();
    private WXCell defaultTemplateCell;
    private String defaultTemplateKey = "@default_template_cell";
    private boolean hasAppendTreeDone = false;
    private boolean hasLayoutDone = false;
    private boolean isScrollable = true;
    private String listDataIndexKey = null;
    private String listDataItemKey = null;
    private String listDataKey = Constants.Name.Recycler.LIST_DATA;
    private String listDataTemplateKey = Constants.Name.Recycler.SLOT_TEMPLATE_CASE;
    private Runnable listUpdateRunnable;
    private Runnable mAppearChangeRunnable = null;
    private ArrayMap<Integer, List<AppearanceHelper>> mAppearHelpers = new ArrayMap<>();
    protected int mColumnCount = 1;
    protected float mColumnGap = 0.0f;
    protected float mColumnWidth = 0.0f;
    private ArrayMap<Integer, Map<String, Map<Integer, List<Object>>>> mDisAppearWatchList = new ArrayMap<>();
    private boolean mForceLoadmoreNextTime = false;
    private boolean mHasAddScrollEvent = false;
    private RecyclerView.ItemAnimator mItemAnimator;
    private Point mLastReport = new Point(-1, -1);
    protected int mLayoutType = 1;
    private int mListCellCount = 0;
    private int mOffsetAccuracy = 10;
    private float mPaddingLeft;
    private float mPaddingRight;
    private ScrollStartEndHelper mScrollStartEndHelper;
    private TemplateStickyHelper mStickyHelper;
    private Map<String, WXCell> mTemplateSources;
    private ArrayMap<String, Integer> mTemplateViewTypes;
    private ConcurrentHashMap<String, TemplateCache> mTemplatesCache;
    private WXRecyclerViewOnScrollListener mViewOnScrollListener = new WXRecyclerViewOnScrollListener(this);
    private int orientation = 1;
    private int templateCacheSize = 2;

    public WXRecyclerTemplateList(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        initRecyclerTemplateList(wXSDKInstance, basicComponentData, wXVContainer);
    }

    private int calcContentSize() {
        if (this.cellDataManager.listData == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.cellDataManager.listData.size(); i2++) {
            WXCell sourceTemplate = getSourceTemplate(i2);
            if (sourceTemplate != null) {
                i = (int) (((float) i) + sourceTemplate.getLayoutHeight());
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkAppendDone(boolean z) {
        if (this.mTemplateSources.size() != 0) {
            for (Map.Entry<String, WXCell> entry : this.mTemplateSources.entrySet()) {
                if (!entry.getValue().isAppendTreeDone()) {
                    return;
                }
            }
            this.hasAppendTreeDone = true;
            if (this.hasLayoutDone) {
                notifyUpdateList();
            }
        }
    }

    public static void doCreateCellViewBindData(WXCell wXCell, String str, boolean z) {
        if (wXCell.isLazy() || wXCell.getHostView() == null) {
            System.currentTimeMillis();
            Statements.initLazyComponent(wXCell, null);
            WXEnvironment.isOpenDebugLog();
        }
    }

    private List<WXComponent> doRenderTemplate(WXCell wXCell, int i) {
        this.cellRenderContext.clear();
        Object obj = this.cellDataManager.listData.get(i);
        CellRenderState renderState = this.cellDataManager.getRenderState(i);
        CellRenderContext cellRenderContext2 = this.cellRenderContext;
        cellRenderContext2.renderState = renderState;
        cellRenderContext2.templateList = this;
        cellRenderContext2.position = i;
        v7 v7Var = cellRenderContext2.stack;
        Map map = cellRenderContext2.map;
        if (this.cellDataManager.listData != null) {
            v7Var.g(map);
            map.put(this.listDataKey, this.cellDataManager.listData);
            if (!TextUtils.isEmpty(this.listDataIndexKey)) {
                map.put(this.listDataIndexKey, new PositionRef(renderState));
            }
            if (!TextUtils.isEmpty(this.listDataItemKey)) {
                map.put(this.listDataItemKey, obj);
            } else {
                v7Var.g(obj);
            }
        }
        if (renderState.itemId <= 0) {
            getItemId(i);
        }
        List<WXComponent> doRender = Statements.doRender(wXCell, this.cellRenderContext);
        if (renderState.isDirty()) {
            renderState.resetDirty();
        }
        return doRender;
    }

    @Nullable
    private WXCell findCell(WXComponent wXComponent) {
        WXVContainer parent;
        if (wXComponent instanceof WXCell) {
            return (WXCell) wXComponent;
        }
        if (wXComponent == null || (parent = wXComponent.getParent()) == null) {
            return null;
        }
        return findCell(parent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireScrollEvent(RecyclerView recyclerView, int i, int i2) {
        fireEvent("scroll", getScrollEvent(recyclerView, i, i2));
    }

    private WXCell getCellTemplateFromCache(String str) {
        ConcurrentLinkedQueue<WXCell> concurrentLinkedQueue;
        TemplateCache templateCache = this.mTemplatesCache.get(str);
        WXCell poll = (templateCache == null || (concurrentLinkedQueue = templateCache.cells) == null || concurrentLinkedQueue.size() <= 0) ? null : templateCache.cells.poll();
        if (templateCache == null || !templateCache.isLoadIng) {
            if (templateCache == null) {
                templateCache = new TemplateCache();
                this.mTemplatesCache.put(str, templateCache);
            }
            templateCache.isLoadIng = true;
            WXCell wXCell = this.mTemplateSources.get(str);
            if (wXCell != null && WXUtils.getBoolean(wXCell.getAttrs().get("preload"), Boolean.TRUE).booleanValue()) {
                new AsyncCellLoadTask(str, wXCell, this).startTask();
            }
        }
        return poll;
    }

    private int getCellTemplateItemType(WXCell wXCell) {
        if (wXCell == null) {
            return -1;
        }
        if (wXCell.getAttrs() == null) {
            return 0;
        }
        String string = WXUtils.getString(wXCell.getAttrs().get(Constants.Name.Recycler.SLOT_TEMPLATE_CASE), null);
        if (wXCell == this.defaultTemplateCell) {
            string = this.defaultTemplateKey;
        }
        int indexOfKey = this.mTemplateViewTypes.indexOfKey(string);
        if (indexOfKey < 0) {
            return -1;
        }
        return indexOfKey;
    }

    private void initRecyclerTemplateList(WXSDKInstance wXSDKInstance, BasicComponentData basicComponentData, WXVContainer wXVContainer) {
        updateRecyclerAttr();
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        this.mTemplateViewTypes = arrayMap;
        arrayMap.put("", 0);
        this.mTemplateSources = new HashMap();
        this.mTemplatesCache = new ConcurrentHashMap<>();
        this.mStickyHelper = new TemplateStickyHelper(this);
        this.orientation = basicComponentData.getAttrs().getOrientation();
        this.listDataTemplateKey = WXUtils.getString(getAttrs().get("switch"), Constants.Name.Recycler.SLOT_TEMPLATE_CASE);
        this.listDataItemKey = WXUtils.getString(getAttrs().get("alias"), this.listDataItemKey);
        this.listDataIndexKey = WXUtils.getString(getAttrs().get("index"), this.listDataIndexKey);
        CellDataManager cellDataManager2 = new CellDataManager(this);
        this.cellDataManager = cellDataManager2;
        cellDataManager2.listData = parseListDataToJSONArray(getAttrs().get(Constants.Name.Recycler.LIST_DATA));
    }

    private JSONArray parseListDataToJSONArray(Object obj) {
        try {
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            if (obj instanceof String) {
                return JSON.parseArray(getAttrs().get(Constants.Name.Recycler.LIST_DATA).toString());
            }
            return new JSONArray();
        } catch (Exception e) {
            WXLogUtils.e(TAG, "parseListDataException" + e.getMessage());
        }
    }

    private void removeFooterOrHeader(WXComponent wXComponent) {
        if (wXComponent instanceof WXLoading) {
            ((BounceRecyclerView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof WXRefresh) {
            ((BounceRecyclerView) getHostView()).removeHeaderView(wXComponent);
        }
    }

    private synchronized void renderTemplateCellWithData(WXCell wXCell) {
        JSONArray jSONArray;
        if (wXCell.getRenderData() == null && (jSONArray = this.cellDataManager.listData) != null && jSONArray.size() > 0) {
            synchronized (this) {
                if (wXCell.getRenderData() == null) {
                    Statements.parseStatementsToken(wXCell);
                    int i = 0;
                    while (true) {
                        if (i >= this.cellDataManager.listData.size()) {
                            break;
                        } else if (wXCell == getSourceTemplate(i)) {
                            Object obj = this.cellDataManager.listData.get(i);
                            doRenderTemplate(wXCell, i);
                            Layouts.doLayoutSync(wXCell, getLayoutWidth(), getLayoutHeight());
                            wXCell.setRenderData(obj);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
    }

    private Object safeGetListData(int i) {
        try {
            return this.cellDataManager.listData.get(i);
        } catch (Exception unused) {
            return JSON.parseObject("{}");
        }
    }

    private void setAppearanceWatch(WXComponent wXComponent, int i, boolean z) {
        int cellTemplateItemType;
        if (this.cellDataManager.listData != null && this.mAppearHelpers != null && !TextUtils.isEmpty(wXComponent.getRef()) && (cellTemplateItemType = getCellTemplateItemType(findCell(wXComponent))) >= 0) {
            List<AppearanceHelper> list = this.mAppearHelpers.get(Integer.valueOf(cellTemplateItemType));
            if (list == null) {
                list = new ArrayList<>();
                this.mAppearHelpers.put(Integer.valueOf(cellTemplateItemType), list);
            }
            AppearanceHelper appearanceHelper = null;
            Iterator<AppearanceHelper> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AppearanceHelper next = it.next();
                if (wXComponent.getRef().equals(next.getAwareChild().getRef())) {
                    appearanceHelper = next;
                    break;
                }
            }
            if (appearanceHelper != null) {
                appearanceHelper.setWatchEvent(i, z);
                return;
            }
            AppearanceHelper appearanceHelper2 = new AppearanceHelper(wXComponent, cellTemplateItemType);
            appearanceHelper2.setWatchEvent(i, z);
            list.add(appearanceHelper2);
        }
    }

    private boolean setRefreshOrLoading(final WXComponent wXComponent) {
        if ((wXComponent instanceof WXRefresh) && getHostView() != null) {
            ((BounceRecyclerView) getHostView()).setOnRefreshListener((WXRefresh) wXComponent);
            ((BounceRecyclerView) getHostView()).postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass8 */

                public void run() {
                    ((BounceRecyclerView) WXRecyclerTemplateList.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100);
            return true;
        } else if (!(wXComponent instanceof WXLoading) || getHostView() == null) {
            return false;
        } else {
            ((BounceRecyclerView) getHostView()).setOnLoadingListener((WXLoading) wXComponent);
            ((BounceRecyclerView) getHostView()).postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass9 */

                public void run() {
                    ((BounceRecyclerView) WXRecyclerTemplateList.this.getHostView()).setFooterView(wXComponent);
                }
            }), 100);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldReport(int i, int i2) {
        Point point = this.mLastReport;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        if (xVar == -1 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) == -1) {
            point.x = i;
            point.y = i2;
            return true;
        }
        int abs = Math.abs(xVar - i);
        int abs2 = Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.mLastReport) - i2);
        int i3 = this.mOffsetAccuracy;
        if (abs < i3 && abs2 < i3) {
            return false;
        }
        Point point2 = this.mLastReport;
        point2.x = i;
        point2.y = i2;
        return true;
    }

    private void updateRecyclerAttr() {
        this.mLayoutType = getAttrs().getLayoutType();
        int columnCount = getAttrs().getColumnCount();
        this.mColumnCount = columnCount;
        if (columnCount <= 0 && this.mLayoutType != 1) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, getComponentType());
            arrayMap.put("attribute", getAttrs().toString());
            arrayMap.put("stackTrace", Arrays.toString(Thread.currentThread().getStackTrace()));
            WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), WXErrorCode.WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT, Constants.Name.COLUMN_COUNT, String.format(Locale.ENGLISH, "You are trying to set the list/recycler/vlist/waterfall's column to %d, which is illegal. The column count should be a positive integer", Integer.valueOf(this.mColumnCount)), arrayMap);
            this.mColumnCount = 1;
        }
        this.mColumnGap = getAttrs().getColumnGap();
        this.mColumnWidth = getAttrs().getColumnWidth();
        this.mPaddingLeft = getPadding().get(CSSShorthand.EDGE.LEFT);
        this.mPaddingRight = getPadding().get(CSSShorthand.EDGE.RIGHT);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (ScrollStartEndHelper.isScrollEvent(str) && getHostView() != null && ((BounceRecyclerView) getHostView()).getInnerView() != null && !this.mHasAddScrollEvent) {
            this.mHasAddScrollEvent = true;
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass7 */
                private boolean mFirstEvent = true;
                private int offsetXCorrection;
                private int offsetYCorrection;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    int i3;
                    int i4;
                    super.onScrolled(recyclerView, i, i2);
                    if (recyclerView.getLayoutManager().canScrollVertically()) {
                        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                        if (i == 0 && i2 == 0) {
                            this.offsetXCorrection = computeHorizontalScrollOffset;
                            this.offsetYCorrection = computeVerticalScrollOffset;
                            i4 = 0;
                            i3 = 0;
                        } else {
                            i4 = computeHorizontalScrollOffset - this.offsetXCorrection;
                            i3 = computeVerticalScrollOffset - this.offsetYCorrection;
                        }
                        WXRecyclerTemplateList.this.getScrollStartEndHelper().onScrolled(i4, i3);
                        if (WXRecyclerTemplateList.this.getEvents().contains("scroll")) {
                            if (this.mFirstEvent) {
                                this.mFirstEvent = false;
                            } else if (WXRecyclerTemplateList.this.shouldReport(i4, i3)) {
                                WXRecyclerTemplateList.this.fireScrollEvent(recyclerView, i4, i3);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, int i) {
    }

    @JSMethod
    public void appendData(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.size() != 0) {
            CellDataManager cellDataManager2 = this.cellDataManager;
            if (cellDataManager2.listData == null) {
                cellDataManager2.listData = new JSONArray();
            }
            int size = this.cellDataManager.listData.size();
            if (size < 0) {
                size = 0;
            }
            this.cellDataManager.listData.addAll(jSONArray);
            ((BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemRangeInserted(size, jSONArray.size());
        }
    }

    @JSMethod
    public void appendRange(int i, JSONArray jSONArray) {
        insertRange(i, jSONArray);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new Runnable() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass4 */

                public void run() {
                    if (WXRecyclerTemplateList.this.mAppearChangeRunnable != null) {
                        WXRecyclerTemplateList.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != null) {
            ((BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            ((BounceRecyclerView) getHostView()).postDelayed(this.mAppearChangeRunnable, 50);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new Runnable() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass5 */

                public void run() {
                    if (WXRecyclerTemplateList.this.mAppearChangeRunnable != null) {
                        WXRecyclerTemplateList.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != null) {
            ((BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            ((BounceRecyclerView) getHostView()).postDelayed(this.mAppearChangeRunnable, 50);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(WXComponent wXComponent) {
        TemplateStickyHelper templateStickyHelper;
        WXComponent findParentType = findParentType(wXComponent, WXCell.class);
        if (findParentType != null && (templateStickyHelper = this.mStickyHelper) != null && !templateStickyHelper.getStickyTypes().contains(findParentType.getRef())) {
            this.mStickyHelper.getStickyTypes().add(findParentType.getRef());
            notifyUpdateList();
        }
    }

    public int calcContentOffset(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i = 0;
        if (layoutManager instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            int i2 = 0;
            while (i < findFirstVisibleItemPosition) {
                WXCell sourceTemplate = getSourceTemplate(i);
                if (sourceTemplate != null) {
                    i2 = (int) (((float) i2) - sourceTemplate.getLayoutHeight());
                }
                i++;
            }
            if (layoutManager instanceof GridLayoutManager) {
                i2 /= ((GridLayoutManager) layoutManager).getSpanCount();
            }
            View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
            return findViewByPosition != null ? i2 + findViewByPosition.getTop() : i2;
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return -1;
        } else {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            int i3 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            int i4 = 0;
            while (i < i3) {
                WXCell sourceTemplate2 = getSourceTemplate(i);
                if (sourceTemplate2 != null) {
                    i4 = (int) (((float) i4) - sourceTemplate2.getLayoutHeight());
                }
                i++;
            }
            int i5 = i4 / spanCount;
            View findViewByPosition2 = layoutManager.findViewByPosition(i3);
            return findViewByPosition2 != null ? i5 + findViewByPosition2.getTop() : i5;
        }
    }

    @JSMethod(uiThread = true)
    public void closest(String str, String str2, JSCallback jSCallback) {
        try {
            String[] split = str.split(o70.DINAMIC_PREFIX_AT);
            String str3 = split[0];
            int parseInt = Integer.parseInt(split[1]);
            WXComponent findVirtualComponentByVRef = TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (findVirtualComponentByVRef != null && getHostView() != null) {
                if (((BounceRecyclerView) getHostView()).getInnerView() != null) {
                    ArrayList arrayList = new ArrayList(4);
                    Selector.closest(findVirtualComponentByVRef, str2, arrayList);
                    if (arrayList.size() > 0) {
                        jSCallback.invoke(TemplateDom.toMap(str3, parseInt, (WXComponent) arrayList.get(0)));
                    } else {
                        jSCallback.invoke(new HashMap(4));
                    }
                }
            }
        } catch (Exception e) {
            jSCallback.invoke(new HashMap(4));
            WXLogUtils.e(TAG, e);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        RecyclerView recyclerView = (RecyclerView) ((BounceRecyclerView) getHostView()).getInnerView();
        pointF.set((float) recyclerView.computeHorizontalScrollOffset(), (float) recyclerView.computeVerticalScrollOffset());
    }

    public WXComponent copyComponentFromSourceCell(WXCell wXCell) {
        renderTemplateCellWithData(wXCell);
        return (WXCell) Statements.copyComponentTree(wXCell);
    }

    public v7 copyStack(CellRenderContext cellRenderContext2, v7 v7Var) {
        v7 v7Var2 = new v7();
        for (int i = 0; i < v7Var.i(); i++) {
            Object b = v7Var.b(i);
            if (b instanceof Map) {
                b = new HashMap((Map) b);
            }
            v7Var2.g(b);
        }
        return v7Var2;
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void createChildViewAt(int i) {
        if (i >= 0 || childCount() - 1 >= 0) {
            WXComponent child = getChild(i);
            if (child instanceof WXBaseRefresh) {
                child.createView();
                setRefreshOrLoading(child);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        synchronized (this) {
            if (getHostView() != null) {
                if (this.mAppearChangeRunnable != null) {
                    ((BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
                    this.mAppearChangeRunnable = null;
                }
                ((BounceRecyclerView) getHostView()).removeCallbacks(this.listUpdateRunnable);
                if (((BounceRecyclerView) getHostView()).getInnerView() != null) {
                    ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).setAdapter(null);
                }
            }
            CellDataManager cellDataManager2 = this.cellDataManager;
            if (cellDataManager2.listData != null) {
                cellDataManager2.setListData(null);
            }
            if (this.mStickyHelper != null) {
                this.mStickyHelper = null;
            }
            ArrayMap<String, Integer> arrayMap = this.mTemplateViewTypes;
            if (arrayMap != null) {
                arrayMap.clear();
            }
            Map<String, WXCell> map = this.mTemplateSources;
            if (map != null) {
                map.clear();
            }
            ArrayMap<Integer, List<AppearanceHelper>> arrayMap2 = this.mAppearHelpers;
            if (arrayMap2 != null) {
                arrayMap2.clear();
            }
            ArrayMap<Integer, Map<String, Map<Integer, List<Object>>>> arrayMap3 = this.mDisAppearWatchList;
            if (arrayMap3 != null) {
                arrayMap3.clear();
            }
            super.destroy();
        }
    }

    public WXComponent findChildByAttrsRef(WXComponent wXComponent, String str) {
        if (wXComponent.getAttrs() != null && str.equals(wXComponent.getAttrs().get("ref"))) {
            return wXComponent;
        }
        if (!(wXComponent instanceof WXVContainer)) {
            return null;
        }
        WXVContainer wXVContainer = (WXVContainer) wXComponent;
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            WXComponent findChildByAttrsRef = findChildByAttrsRef(wXVContainer.getChild(i), str);
            if (findChildByAttrsRef != null) {
                return findChildByAttrsRef;
            }
        }
        return null;
    }

    public WXComponent findChildByRef(WXComponent wXComponent, String str) {
        if (str.equals(wXComponent.getRef())) {
            return wXComponent;
        }
        if (!(wXComponent instanceof WXVContainer)) {
            return null;
        }
        WXVContainer wXVContainer = (WXVContainer) wXComponent;
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            WXComponent findChildByRef = findChildByRef(wXVContainer.getChild(i), str);
            if (findChildByRef != null) {
                return findChildByRef;
            }
        }
        return null;
    }

    public List<WXComponent> findChildListByRef(WXComponent wXComponent, String str) {
        WXComponent findChildByRef = findChildByRef(wXComponent, str);
        if (findChildByRef == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        WXVContainer parent = findChildByRef.getParent();
        if (parent == null || (parent instanceof WXRecyclerTemplateList)) {
            arrayList.add(findChildByRef);
        } else {
            for (int i = 0; i < parent.getChildCount(); i++) {
                WXComponent child = parent.getChild(i);
                if (str.equals(child.getRef())) {
                    arrayList.add(child);
                }
            }
        }
        return arrayList;
    }

    public WXComponent findParentType(WXComponent wXComponent, Class cls) {
        if (cls.isAssignableFrom(wXComponent.getClass())) {
            return wXComponent;
        }
        if (wXComponent.getParent() == null) {
            return null;
        }
        findTypeParent(wXComponent.getParent(), cls);
        return null;
    }

    public CellDataManager getCellDataManager() {
        return this.cellDataManager;
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public ViewGroup.LayoutParams getChildLayoutParams(WXComponent wXComponent, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if ((wXComponent instanceof WXBaseRefresh) && marginLayoutParams == null) {
            return new LinearLayout.LayoutParams(i, i2);
        }
        if (marginLayoutParams == null) {
            return new RecyclerView.LayoutParams(i, i2);
        }
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setMarginsSupportRTL(marginLayoutParams, i3, 0, i4, 0);
        return marginLayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXVContainer
    public int getChildrenLayoutTopOffset() {
        return 0;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemCount() {
        ArrayMap<String, Integer> arrayMap;
        Map<String, WXCell> map;
        if (!this.hasLayoutDone || !this.hasAppendTreeDone || this.cellDataManager.listData == null || (arrayMap = this.mTemplateViewTypes) == null || arrayMap.size() <= 1 || (map = this.mTemplateSources) == null || map.size() == 0) {
            return 0;
        }
        return this.cellDataManager.listData.size();
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public long getItemId(int i) {
        CellRenderState renderState = this.cellDataManager.getRenderState(i);
        if (renderState.itemId <= 0) {
            if (TextUtils.isEmpty(getTemplateKey(i))) {
                return -1;
            }
            Object safeGetListData = safeGetListData(i);
            if (safeGetListData instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) safeGetListData;
                if (jSONObject.containsKey("keyItemId")) {
                    renderState.itemId = jSONObject.getLongValue("keyItemId");
                }
            }
            renderState.itemId = (((long) Math.abs(safeGetListData.hashCode())) << 24) + ((long) i);
        }
        return renderState.itemId;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemViewType(int i) {
        int indexOfKey = this.mTemplateViewTypes.indexOfKey(getTemplateKey(i));
        return indexOfKey < 0 ? this.mTemplateViewTypes.indexOfKey("") : indexOfKey;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return this.orientation;
    }

    public Map<String, Object> getScrollEvent(RecyclerView recyclerView, int i, int i2) {
        int measuredWidth = recyclerView.getMeasuredWidth() + recyclerView.computeHorizontalScrollRange();
        int calcContentSize = calcContentSize();
        HashMap hashMap = new HashMap(3);
        HashMap hashMap2 = new HashMap(3);
        HashMap hashMap3 = new HashMap(3);
        hashMap2.put("width", Float.valueOf(WXViewUtils.getWebPxByWidth((float) measuredWidth, getInstance().getInstanceViewPortWidth())));
        hashMap2.put("height", Float.valueOf(WXViewUtils.getWebPxByWidth((float) calcContentSize, getInstance().getInstanceViewPortWidth())));
        hashMap3.put(Constants.Name.X, Float.valueOf(-WXViewUtils.getWebPxByWidth((float) i, getInstance().getInstanceViewPortWidth())));
        hashMap3.put(Constants.Name.Y, Float.valueOf(-WXViewUtils.getWebPxByWidth((float) (-calcContentOffset(recyclerView)), getInstance().getInstanceViewPortWidth())));
        hashMap.put(Constants.Name.CONTENT_SIZE, hashMap2);
        hashMap.put(Constants.Name.CONTENT_OFFSET, hashMap3);
        boolean z = true;
        if (recyclerView.getScrollState() != 1) {
            z = false;
        }
        hashMap.put(Constants.Name.ISDRAGGING, Boolean.valueOf(z));
        return hashMap;
    }

    public ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return 0;
        }
        return ((WXRecyclerView) bounceRecyclerView.getInnerView()).getScrollX();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) getHostView();
        if (bounceRecyclerView == null) {
            return 0;
        }
        return ((WXRecyclerView) bounceRecyclerView.getInnerView()).getScrollY();
    }

    public WXCell getSourceTemplate(int i) {
        return this.mTemplateSources.get(getTemplateKey(i));
    }

    public int getTemplateCacheSize() {
        return this.templateCacheSize;
    }

    public String getTemplateKey(int i) {
        return getTemplateKey(safeGetListData(i));
    }

    public ConcurrentHashMap<String, TemplateCache> getTemplatesCache() {
        if (this.mTemplatesCache == null) {
            this.mTemplatesCache = new ConcurrentHashMap<>();
        }
        return this.mTemplatesCache;
    }

    @JSMethod
    public void insertData(int i, Object obj) {
        JSONArray jSONArray;
        if (obj != null && (jSONArray = this.cellDataManager.listData) != null && i <= jSONArray.size()) {
            if (this.cellDataManager.insertData(i, obj)) {
                notifyUpdateList();
            } else {
                ((BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemInserted(i);
            }
        }
    }

    @JSMethod
    public void insertRange(int i, JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray != null && jSONArray.size() != 0 && (jSONArray2 = this.cellDataManager.listData) != null && i <= jSONArray2.size()) {
            if (this.cellDataManager.insertRange(i, jSONArray)) {
                notifyUpdateList();
            } else {
                ((BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemRangeInserted(i, jSONArray.size());
            }
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXComponent.MeasureOutput measure(int i, int i2) {
        int screenHeight = WXViewUtils.getScreenHeight(WXEnvironment.sApplication);
        int weexHeight = WXViewUtils.getWeexHeight(getInstanceId());
        if (weexHeight < screenHeight) {
            screenHeight = weexHeight;
        }
        if (i2 > screenHeight) {
            i2 = weexHeight - getAbsoluteY();
        }
        return super.measure(i, i2);
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void notifyAppearStateChange(int i, int i2, int i3, int i4) {
        int i5;
        Map<Integer, List<Object>> value;
        List<WXComponent> findChildListByRef;
        ArrayMap<Integer, List<AppearanceHelper>> arrayMap = this.mAppearHelpers;
        if (arrayMap != null && arrayMap.size() > 0) {
            if (this.mAppearChangeRunnable != null) {
                ((BounceRecyclerView) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
                this.mAppearChangeRunnable = null;
            }
            String str = i4 > 0 ? "up" : i4 < 0 ? "down" : null;
            if (getOrientation() == 0 && i3 != 0) {
                str = i3 > 0 ? "left" : "right";
            }
            RecyclerView recyclerView = (RecyclerView) ((BounceRecyclerView) getHostView()).getInnerView();
            int i6 = i;
            while (true) {
                i5 = 0;
                if (i6 > i2) {
                    break;
                }
                List<AppearanceHelper> list = this.mAppearHelpers.get(Integer.valueOf(getItemViewType(i6)));
                if (list != null) {
                    for (AppearanceHelper appearanceHelper : list) {
                        if (appearanceHelper.isWatch()) {
                            TemplateViewHolder templateViewHolder = (TemplateViewHolder) recyclerView.findViewHolderForAdapterPosition(i6);
                            if (templateViewHolder == null || templateViewHolder.getComponent() == null || (findChildListByRef = findChildListByRef(templateViewHolder.getComponent(), appearanceHelper.getAwareChild().getRef())) == null || findChildListByRef.size() == 0) {
                                break;
                            }
                            Map<String, Map<Integer, List<Object>>> map = this.mDisAppearWatchList.get(Integer.valueOf(i6));
                            if (map == null) {
                                map = new ArrayMap<>();
                                this.mDisAppearWatchList.put(Integer.valueOf(i6), map);
                            }
                            Map<Integer, List<Object>> map2 = map.get(appearanceHelper.getAwareChild().getRef());
                            if (map2 == null) {
                                map2 = new ArrayMap<>();
                                map.put(appearanceHelper.getAwareChild().getRef(), map2);
                            }
                            for (int i7 = 0; i7 < findChildListByRef.size(); i7++) {
                                WXComponent wXComponent = findChildListByRef.get(i7);
                                if (wXComponent.getHostView() != null) {
                                    boolean isViewVisible = appearanceHelper.isViewVisible(wXComponent.getHostView());
                                    int hashCode = wXComponent.getHostView().hashCode();
                                    if (isViewVisible) {
                                        if (!map2.containsKey(Integer.valueOf(hashCode))) {
                                            wXComponent.notifyAppearStateChange(Constants.Event.APPEAR, str);
                                            map2.put(Integer.valueOf(hashCode), (wXComponent.getEvents() == null || wXComponent.getEvents().getEventBindingArgsValues() == null || wXComponent.getEvents().getEventBindingArgsValues().get(Constants.Event.DISAPPEAR) == null) ? null : wXComponent.getEvents().getEventBindingArgsValues().get(Constants.Event.DISAPPEAR));
                                        }
                                    } else if (map2.containsKey(Integer.valueOf(hashCode))) {
                                        wXComponent.notifyAppearStateChange(Constants.Event.DISAPPEAR, str);
                                        map2.remove(Integer.valueOf(hashCode));
                                    }
                                }
                            }
                        }
                    }
                }
                i6++;
            }
            int itemCount = getItemCount();
            while (i5 < itemCount) {
                if (i5 < i || i5 > i2) {
                    Map<String, Map<Integer, List<Object>>> map3 = this.mDisAppearWatchList.get(Integer.valueOf(i5));
                    if (map3 != null) {
                        WXCell wXCell = this.mTemplateSources.get(getTemplateKey(i5));
                        if (wXCell != null) {
                            for (Map.Entry<String, Map<Integer, List<Object>>> entry : map3.entrySet()) {
                                WXComponent findChildByRef = findChildByRef(wXCell, entry.getKey());
                                if (!(findChildByRef == null || (value = entry.getValue()) == null || value.size() == 0)) {
                                    WXEvent events = findChildByRef.getEvents();
                                    for (Map.Entry<Integer, List<Object>> entry2 : value.entrySet()) {
                                        events.putEventBindingArgsValue(Constants.Event.DISAPPEAR, entry2.getValue());
                                        findChildByRef.notifyAppearStateChange(Constants.Event.DISAPPEAR, str);
                                    }
                                    value.clear();
                                }
                            }
                            this.mDisAppearWatchList.remove(Integer.valueOf(i5));
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i5 = i2 + 1;
                }
                i5++;
            }
        }
    }

    public void notifyUpdateList() {
        if (getHostView() != null && ((BounceRecyclerView) getHostView()).getInnerView() != null && this.listUpdateRunnable != null) {
            if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
                ((BounceRecyclerView) getHostView()).removeCallbacks(this.listUpdateRunnable);
                ((BounceRecyclerView) getHostView()).post(this.listUpdateRunnable);
                return;
            }
            this.listUpdateRunnable.run();
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onBeforeScroll(int i, int i2) {
        TemplateStickyHelper templateStickyHelper = this.mStickyHelper;
        if (templateStickyHelper != null) {
            templateStickyHelper.onBeforeScroll(i, i2);
        }
    }

    public boolean onFailedToRecycleView(TemplateViewHolder templateViewHolder) {
        return false;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onLoadMore(int i) {
        JSONArray jSONArray;
        try {
            String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (TextUtils.isEmpty(loadMoreOffset)) {
                loadMoreOffset = "0";
            }
            if (((float) i) <= WXViewUtils.getRealPxByWidth((float) Integer.parseInt(loadMoreOffset), getInstance().getInstanceViewPortWidth()) && (jSONArray = this.cellDataManager.listData) != null) {
                if (this.mListCellCount != jSONArray.size() || this.mForceLoadmoreNextTime) {
                    fireEvent(Constants.Event.LOADMORE);
                    this.mListCellCount = this.cellDataManager.listData.size();
                    this.mForceLoadmoreNextTime = false;
                }
            }
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("WXRecyclerTemplateList onLoadMore : ", e);
            }
        }
    }

    public void onViewRecycled(TemplateViewHolder templateViewHolder) {
    }

    @JSMethod(uiThread = true)
    public void queryElement(String str, String str2, JSCallback jSCallback) {
        try {
            String[] split = str.split(o70.DINAMIC_PREFIX_AT);
            String str3 = split[0];
            int parseInt = Integer.parseInt(split[1]);
            WXComponent findVirtualComponentByVRef = TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (findVirtualComponentByVRef != null && getHostView() != null) {
                if (((BounceRecyclerView) getHostView()).getInnerView() != null) {
                    ArrayList arrayList = new ArrayList(4);
                    Selector.queryElementAll(findVirtualComponentByVRef, str2, arrayList);
                    if (arrayList.size() > 0) {
                        jSCallback.invoke(TemplateDom.toMap(str3, parseInt, (WXComponent) arrayList.get(0)));
                    } else {
                        jSCallback.invoke(new HashMap(4));
                    }
                }
            }
        } catch (Exception e) {
            jSCallback.invoke(new HashMap(4));
            WXLogUtils.e(TAG, e);
        }
    }

    @JSMethod(uiThread = true)
    public void queryElementAll(String str, String str2, JSCallback jSCallback) {
        ArrayList arrayList = new ArrayList();
        try {
            String[] split = str.split(o70.DINAMIC_PREFIX_AT);
            String str3 = split[0];
            int parseInt = Integer.parseInt(split[1]);
            WXComponent findVirtualComponentByVRef = TemplateDom.findVirtualComponentByVRef(getInstanceId(), str);
            if (!(findVirtualComponentByVRef == null || getHostView() == null)) {
                if (((BounceRecyclerView) getHostView()).getInnerView() != null) {
                    ArrayList<WXComponent> arrayList2 = new ArrayList(4);
                    Selector.queryElementAll(findVirtualComponentByVRef, str2, arrayList2);
                    for (WXComponent wXComponent : arrayList2) {
                        arrayList.add(TemplateDom.toMap(str3, parseInt, wXComponent));
                    }
                    jSCallback.invoke(arrayList);
                }
            }
        } catch (Exception e) {
            jSCallback.invoke(arrayList);
            WXLogUtils.e(TAG, e);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        removeFooterOrHeader(wXComponent);
        super.remove(wXComponent, z);
    }

    @JSMethod
    public void removeData(int i, int i2) {
        JSONArray jSONArray = this.cellDataManager.listData;
        if (jSONArray != null && i < jSONArray.size()) {
            if (i2 <= 0) {
                i2 = 1;
            }
            int i3 = 0;
            while (i2 > 0 && i < this.cellDataManager.listData.size()) {
                this.cellDataManager.removeData(Integer.valueOf(i));
                i2--;
                i3++;
            }
            if (i3 > 0) {
                notifyUpdateList();
            }
        }
    }

    @JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
        this.mListCellCount = 0;
    }

    @JSMethod(uiThread = true)
    public void scrollTo(String str, Map<String, Object> map) {
        int i;
        try {
            if (str.indexOf(64) > 0) {
                i = Integer.parseInt(str.split(o70.DINAMIC_PREFIX_AT)[0]);
            } else {
                i = (int) Float.parseFloat(str);
            }
            if (i >= 0) {
                boolean z = true;
                float f = 0.0f;
                if (map != null) {
                    Object obj = map.get(Constants.Name.ANIMATED);
                    Boolean bool = Boolean.TRUE;
                    WXUtils.getBoolean(obj, bool).booleanValue();
                    String obj2 = map.get("offset") == null ? "0" : map.get("offset").toString();
                    z = WXUtils.getBoolean(map.get(Constants.Name.ANIMATED), bool).booleanValue();
                    if (obj2 != null) {
                        try {
                            f = WXViewUtils.getRealPxByWidth(Float.parseFloat(obj2), getInstance().getInstanceViewPortWidth());
                        } catch (Exception e) {
                            WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                        }
                    }
                }
                int i2 = (int) f;
                BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) getHostView();
                if (bounceRecyclerView != null) {
                    ((WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo(z, i, i2, getOrientation());
                }
            }
        } catch (Exception e2) {
            WXLogUtils.e(TAG, e2);
        }
    }

    @JSMethod(uiThread = true)
    public void scrollToElement(String str, Map<String, Object> map) {
        scrollTo(str, map);
    }

    @WXComponentProp(name = Constants.Name.COLUMN_COUNT)
    public void setColumnCount(int i) {
        if (getAttrs().getColumnCount() != this.mColumnCount) {
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @WXComponentProp(name = Constants.Name.COLUMN_GAP)
    public void setColumnGap(float f) throws InterruptedException {
        if (getAttrs().getColumnGap() != this.mColumnGap) {
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @WXComponentProp(name = Constants.Name.COLUMN_WIDTH)
    public void setColumnWidth(int i) {
        if (getAttrs().getColumnWidth() != this.mColumnWidth) {
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @JSMethod
    public void setListData(Object obj) {
        JSONArray parseListDataToJSONArray = parseListDataToJSONArray(obj);
        CellDataManager cellDataManager2 = this.cellDataManager;
        boolean z = cellDataManager2.listData != parseListDataToJSONArray;
        if ((parseListDataToJSONArray instanceof JSONArray) && z) {
            cellDataManager2.setListData(parseListDataToJSONArray);
            notifyUpdateList();
        }
    }

    @WXComponentProp(name = Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) WXViewUtils.getRealPxByWidth((float) i, getInstance().getInstanceViewPortWidth());
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -889473228:
                if (str.equals("switch")) {
                    c = 0;
                    break;
                }
                break;
            case -713683669:
                if (str.equals(NAME_ITEM_VIEW_CACHE_SIZE)) {
                    c = 1;
                    break;
                }
                break;
            case -338674661:
                if (str.equals("hasFixedSize")) {
                    c = 2;
                    break;
                }
                break;
            case -223520855:
                if (str.equals(Constants.Name.SHOW_SCROLLBAR)) {
                    c = 3;
                    break;
                }
                break;
            case -112563826:
                if (str.equals("loadmoreoffset")) {
                    c = 4;
                    break;
                }
                break;
            case -5620052:
                if (str.equals(Constants.Name.OFFSET_ACCURACY)) {
                    c = 5;
                    break;
                }
                break;
            case 3046192:
                if (str.equals(Constants.Name.Recycler.SLOT_TEMPLATE_CASE)) {
                    c = 6;
                    break;
                }
                break;
            case 66669991:
                if (str.equals(Constants.Name.SCROLLABLE)) {
                    c = 7;
                    break;
                }
                break;
            case 92902992:
                if (str.equals("alias")) {
                    c = '\b';
                    break;
                }
                break;
            case 100346066:
                if (str.equals("index")) {
                    c = '\t';
                    break;
                }
                break;
            case 1345164648:
                if (str.equals(Constants.Name.Recycler.LIST_DATA)) {
                    c = '\n';
                    break;
                }
                break;
            case 1614714674:
                if (str.equals(Constants.Name.SCROLL_DIRECTION)) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
                this.listDataTemplateKey = WXUtils.getString(obj, Constants.Name.Recycler.SLOT_TEMPLATE_CASE);
                return true;
            case 1:
            case 2:
                return true;
            case 3:
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                }
                return true;
            case 4:
                return true;
            case 5:
                setOffsetAccuracy(WXUtils.getInteger(obj, 10).intValue());
                return true;
            case 7:
                setScrollable(WXUtils.getBoolean(obj, Boolean.TRUE).booleanValue());
                return true;
            case '\b':
                this.listDataItemKey = WXUtils.getString(obj, this.listDataItemKey);
                return true;
            case '\t':
                this.listDataIndexKey = WXUtils.getString(obj, this.listDataIndexKey);
                return true;
            case '\n':
                setListData(obj);
                return true;
            case 11:
                if (obj != null) {
                    setScrollDirection(obj.toString());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = Constants.Name.SCROLL_DIRECTION)
    public void setScrollDirection(String str) {
        if (this.orientation != getAttrs().getOrientation()) {
            this.orientation = getAttrs().getOrientation();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @WXComponentProp(name = Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).setScrollable(z);
    }

    @WXComponentProp(name = Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getHostView() != null && ((BounceRecyclerView) getHostView()).getInnerView() != null) {
            if (getOrientation() == 1) {
                ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).setVerticalScrollBarEnabled(z);
            } else {
                ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).setHorizontalScrollBarEnabled(z);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(WXComponent wXComponent) {
        TemplateStickyHelper templateStickyHelper;
        WXComponent findParentType = findParentType(wXComponent, WXCell.class);
        if (findParentType != null && (templateStickyHelper = this.mStickyHelper) != null && templateStickyHelper.getStickyTypes().contains(findParentType.getRef())) {
            this.mStickyHelper.getStickyTypes().remove(findParentType.getRef());
            notifyUpdateList();
        }
    }

    @JSMethod
    public void updateData(int i, Object obj) {
        JSONArray jSONArray;
        if (obj != null && (jSONArray = this.cellDataManager.listData) != null && i < jSONArray.size()) {
            if (this.cellDataManager.updateData(obj, i)) {
                ((BounceRecyclerView) getHostView()).getRecyclerViewBaseAdapter().notifyItemChanged(i, obj);
            } else {
                notifyUpdateList();
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (!map.containsKey(Constants.Name.PADDING) && !map.containsKey("paddingLeft") && !map.containsKey("paddingRight")) {
            return;
        }
        if (this.mPaddingLeft != getPadding().get(CSSShorthand.EDGE.LEFT) || this.mPaddingRight != getPadding().get(CSSShorthand.EDGE.RIGHT)) {
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent, int i) {
        boolean z = wXComponent instanceof WXCell;
        if (!z) {
            super.addChild(wXComponent, i);
        }
        if (!(wXComponent instanceof WXBaseRefresh) && z) {
            if (wXComponent.getAttrs() != null) {
                String string = WXUtils.getString(wXComponent.getAttrs().get(Constants.Name.Recycler.SLOT_TEMPLATE_CASE), null);
                if (getAttrs().containsKey("switch")) {
                    if (this.defaultTemplateCell == null) {
                        this.defaultTemplateCell = (WXCell) wXComponent;
                        if (!TextUtils.isEmpty(string)) {
                            this.defaultTemplateKey = string;
                        } else {
                            string = this.defaultTemplateKey;
                            wXComponent.getAttrs().put(Constants.Name.Recycler.SLOT_TEMPLATE_CASE, (Object) string);
                        }
                    }
                } else if (this.defaultTemplateCell == null || wXComponent.getAttrs().containsKey("default")) {
                    this.defaultTemplateCell = (WXCell) wXComponent;
                    if (!TextUtils.isEmpty(string)) {
                        this.defaultTemplateKey = string;
                    } else {
                        string = this.defaultTemplateKey;
                        wXComponent.getAttrs().put(Constants.Name.Recycler.SLOT_TEMPLATE_CASE, (Object) string);
                    }
                }
                if (string != null) {
                    this.mTemplateSources.put(string, (WXCell) wXComponent);
                    if (this.mTemplateViewTypes.get(string) == null) {
                        ArrayMap<String, Integer> arrayMap = this.mTemplateViewTypes;
                        arrayMap.put(string, Integer.valueOf(arrayMap.size()));
                    }
                }
            }
            ((WXCell) wXComponent).setCellAppendTreeListener(new WXCell.CellAppendTreeListener() {
                /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass6 */

                @Override // com.taobao.weex.ui.component.list.WXCell.CellAppendTreeListener
                public void onAppendTreeDone() {
                    WXRecyclerTemplateList.this.checkAppendDone(false);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public BounceRecyclerView initComponentHostView(@NonNull Context context) {
        BounceRecyclerView bounceRecyclerView = new BounceRecyclerView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        WXAttr attrs = getAttrs();
        String str = (String) attrs.get("transform");
        if (str != null) {
            ((WXRecyclerView) bounceRecyclerView.getInnerView()).addItemDecoration(RecyclerTransform.parseTransforms(getOrientation(), str));
        }
        this.mItemAnimator = ((WXRecyclerView) bounceRecyclerView.getInnerView()).getItemAnimator();
        if (attrs.get(NAME_TEMPLATE_CACHE_SIZE) != null) {
            this.templateCacheSize = WXUtils.getInteger(attrs.get(NAME_TEMPLATE_CACHE_SIZE), Integer.valueOf(this.templateCacheSize)).intValue();
        }
        boolean z = false;
        int numberInt = attrs.get(NAME_ITEM_VIEW_CACHE_SIZE) != null ? WXUtils.getNumberInt(getAttrs().get(NAME_ITEM_VIEW_CACHE_SIZE), 2) : 2;
        if (attrs.get("hasFixedSize") != null) {
            z = WXUtils.getBoolean(attrs.get("hasFixedSize"), Boolean.FALSE).booleanValue();
        }
        RecyclerViewBaseAdapter recyclerViewBaseAdapter = new RecyclerViewBaseAdapter(this);
        recyclerViewBaseAdapter.setHasStableIds(true);
        ((WXRecyclerView) bounceRecyclerView.getInnerView()).setItemAnimator(null);
        if (numberInt != 2) {
            ((WXRecyclerView) bounceRecyclerView.getInnerView()).setItemViewCacheSize(numberInt);
        }
        if (bounceRecyclerView.getSwipeLayout() != null && WXUtils.getBoolean(getAttrs().get(Constants.Name.NEST_SCROLLING_ENABLED), Boolean.FALSE).booleanValue()) {
            bounceRecyclerView.getSwipeLayout().setNestedScrollingEnabled(true);
        }
        ((WXRecyclerView) bounceRecyclerView.getInnerView()).setHasFixedSize(z);
        bounceRecyclerView.setRecyclerViewBaseAdapter(recyclerViewBaseAdapter);
        bounceRecyclerView.setOverScrollMode(2);
        ((WXRecyclerView) bounceRecyclerView.getInnerView()).clearOnScrollListeners();
        ((WXRecyclerView) bounceRecyclerView.getInnerView()).addOnScrollListener(this.mViewOnScrollListener);
        ((WXRecyclerView) bounceRecyclerView.getInnerView()).addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                View childAt;
                super.onScrollStateChanged(recyclerView, i);
                WXRecyclerTemplateList.this.getScrollStartEndHelper().onScrollStateChanged(i);
                List<OnWXScrollListener> wXScrollListeners = WXRecyclerTemplateList.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners != null && wXScrollListeners.size() > 0) {
                    for (OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                        if (!(onWXScrollListener == null || (childAt = recyclerView.getChildAt(0)) == null)) {
                            onWXScrollListener.onScrollStateChanged(recyclerView, 0, childAt.getTop(), i);
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                List<OnWXScrollListener> wXScrollListeners = WXRecyclerTemplateList.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners != null && wXScrollListeners.size() > 0) {
                    try {
                        for (OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                            if (onWXScrollListener != null) {
                                if (!(onWXScrollListener instanceof ICheckBindingScroller)) {
                                    onWXScrollListener.onScrolled(recyclerView, i, i2);
                                } else if (((ICheckBindingScroller) onWXScrollListener).isNeedScroller(WXRecyclerTemplateList.this.getRef(), null)) {
                                    onWXScrollListener.onScrolled(recyclerView, i, i2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bounceRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass2 */

            @TargetApi(16)
            public void onGlobalLayout() {
                BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) WXRecyclerTemplateList.this.getHostView();
                if (bounceRecyclerView != null) {
                    WXRecyclerTemplateList.this.mViewOnScrollListener.onScrolled((RecyclerView) bounceRecyclerView.getInnerView(), 0, 0);
                    if (Build.VERSION.SDK_INT >= 16) {
                        bounceRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        bounceRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
        this.listUpdateRunnable = new Runnable() {
            /* class com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.AnonymousClass3 */

            public void run() {
                if (WXRecyclerTemplateList.this.mStickyHelper != null && WXRecyclerTemplateList.this.mStickyHelper.getStickyTypes().size() > 0) {
                    WXRecyclerTemplateList.this.mStickyHelper.getStickyPositions().clear();
                    if (WXRecyclerTemplateList.this.cellDataManager.listData != null) {
                        for (int i = 0; i < WXRecyclerTemplateList.this.cellDataManager.listData.size(); i++) {
                            WXCell sourceTemplate = WXRecyclerTemplateList.this.getSourceTemplate(i);
                            if (sourceTemplate != null && sourceTemplate.isSticky()) {
                                WXRecyclerTemplateList.this.mStickyHelper.getStickyPositions().add(Integer.valueOf(i));
                            }
                        }
                    }
                }
                if (!(WXRecyclerTemplateList.this.getHostView() == null || ((BounceRecyclerView) WXRecyclerTemplateList.this.getHostView()).getRecyclerViewBaseAdapter() == null)) {
                    ((BounceRecyclerView) WXRecyclerTemplateList.this.getHostView()).getRecyclerViewBaseAdapter().notifyDataSetChanged();
                }
                WXEnvironment.isOpenDebugLog();
            }
        };
        return bounceRecyclerView;
    }

    public void onBindViewHolder(TemplateViewHolder templateViewHolder, int i) {
        WXCell template;
        if (templateViewHolder != null && (template = templateViewHolder.getTemplate()) != null) {
            if (templateViewHolder.getHolderPosition() >= 0) {
                fireEvent(TemplateDom.DETACH_CELL_SLOT, TemplateDom.findAllComponentRefs(getRef(), i, template));
            }
            System.currentTimeMillis();
            templateViewHolder.setHolderPosition(i);
            Object obj = this.cellDataManager.listData.get(i);
            CellRenderState renderState = this.cellDataManager.getRenderState(i);
            if (template.getRenderData() != obj || (renderState != null && renderState.isDirty())) {
                Statements.doInitCompontent(doRenderTemplate(template, i));
                template.setRenderData(obj);
                Layouts.doLayoutAsync(templateViewHolder, true);
                WXEnvironment.isOpenDebugLog();
                return;
            }
            WXEnvironment.isOpenDebugLog();
            fireEvent(TemplateDom.ATTACH_CELL_SLOT, TemplateDom.findAllComponentRefs(getRef(), i, template));
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public TemplateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        String keyAt = this.mTemplateViewTypes.keyAt(i);
        WXCell wXCell = this.mTemplateSources.get(keyAt);
        if (wXCell == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            return new TemplateViewHolder(this, frameLayout, i);
        }
        WXCell cellTemplateFromCache = getCellTemplateFromCache(keyAt);
        if (cellTemplateFromCache == null && !wXCell.isSourceUsed()) {
            wXCell.setSourceUsed(true);
            renderTemplateCellWithData(wXCell);
            WXEnvironment.isOpenDebugLog();
            cellTemplateFromCache = wXCell;
        }
        if (cellTemplateFromCache == null) {
            System.currentTimeMillis();
            cellTemplateFromCache = (WXCell) copyComponentFromSourceCell(wXCell);
            WXEnvironment.isOpenDebugLog();
        }
        if (cellTemplateFromCache.isLazy() || cellTemplateFromCache.getHostView() == null) {
            doCreateCellViewBindData(cellTemplateFromCache, keyAt, false);
            WXEnvironment.isOpenDebugLog();
        } else {
            WXEnvironment.isOpenDebugLog();
        }
        return new TemplateViewHolder(this, cellTemplateFromCache, i);
    }

    /* access modifiers changed from: protected */
    public void onHostViewInitialized(BounceRecyclerView bounceRecyclerView) {
        super.onHostViewInitialized((View) bounceRecyclerView);
        WXRecyclerView wXRecyclerView = (WXRecyclerView) bounceRecyclerView.getInnerView();
        if (wXRecyclerView == null || wXRecyclerView.getAdapter() == null) {
            WXLogUtils.e(TAG, "RecyclerView is not found or Adapter is not bound");
        }
    }

    /* access modifiers changed from: protected */
    public void setHostLayoutParams(BounceRecyclerView bounceRecyclerView, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams((View) bounceRecyclerView, i, i2, i3, i4, i5, i6);
        if (!this.hasLayoutDone) {
            this.hasLayoutDone = true;
            this.hasAppendTreeDone = true;
            notifyUpdateList();
        }
    }

    public String getTemplateKey(Object obj) {
        String string = obj instanceof JSONObject ? ((JSONObject) obj).getString(this.listDataTemplateKey) : null;
        if (TextUtils.isEmpty(string)) {
            return this.defaultTemplateCell != null ? this.defaultTemplateKey : "";
        }
        return string;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void scrollTo(WXComponent wXComponent, Map<String, Object> map) {
        boolean z;
        int i;
        int i2 = -1;
        float f = 0.0f;
        if (map != null) {
            String obj = map.get("offset") == null ? "0" : map.get("offset").toString();
            z = WXUtils.getBoolean(map.get(Constants.Name.ANIMATED), Boolean.TRUE).booleanValue();
            if (obj != null) {
                try {
                    f = WXViewUtils.getRealPxByWidth(Float.parseFloat(obj), getInstance().getInstanceViewPortWidth());
                } catch (Exception e) {
                    WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
            i = WXUtils.getNumberInt(map.get(Constants.Name.Recycler.CELL_INDEX), -1);
            i2 = WXUtils.getNumberInt(map.get(Constants.Name.Recycler.TYPE_INDEX), -1);
        } else {
            i = -1;
            z = true;
        }
        WXCell findCell = findCell(wXComponent);
        if (!(i2 < 0 || this.cellDataManager.listData == null || wXComponent.getRef() == null)) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= this.cellDataManager.listData.size()) {
                    break;
                }
                WXCell sourceTemplate = getSourceTemplate(i3);
                if (sourceTemplate != null) {
                    if (findCell.getRef().equals(sourceTemplate.getRef())) {
                        i4++;
                    }
                    if (i4 > i2) {
                        i = i3;
                        break;
                    }
                }
                i3++;
            }
            if (i < 0) {
                i = this.cellDataManager.listData.size() - 1;
            }
        }
        int i5 = (int) f;
        BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) getHostView();
        if (bounceRecyclerView != null && i >= 0) {
            ((WXRecyclerView) bounceRecyclerView.getInnerView()).scrollTo(z, i, i5, getOrientation());
        }
    }
}
