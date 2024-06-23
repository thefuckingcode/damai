package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.viewpager.tab.DXTabItemWidgetNode;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabItem;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.DXTabLayout;
import com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tb.bz;
import tb.cz;
import tb.h10;
import tb.lx;
import tb.qy;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class DXTabHeaderLayoutWidgetNode extends DXLinearLayoutWidgetNode {
    public static final long DXTABHEADERLAYOUT_DATASOURCE = -5948810534719014123L;
    public static final long DXTABHEADERLAYOUT_ENABLESCROLL = -8426770838617723422L;
    public static final long DXTABHEADERLAYOUT_INDICATORBOTTOMGAP = 1170909693104794716L;
    public static final long DXTABHEADERLAYOUT_INDICATORCOLOR = -5151416374116397110L;
    public static final long DXTABHEADERLAYOUT_INDICATORCOLORMAP = -9087820153495724821L;
    public static final long DXTABHEADERLAYOUT_INDICATORHEIGHT = -3761529437537503451L;
    public static final long DXTABHEADERLAYOUT_INDICATORIMAGEURL = 5400402516109499876L;
    public static final long DXTABHEADERLAYOUT_INDICATORRADIUS = -3394712782565958860L;
    public static final long DXTABHEADERLAYOUT_INDICATORWIDTH = -5149988469975039285L;
    public static final long DXTABHEADERLAYOUT_INDICATORZINDEX = -3104225124614969570L;
    public static final long DXTABHEADERLAYOUT_ITEMWIDTH = -5480582194049152328L;
    public static final long DXTABHEADERLAYOUT_ONCHANGE = 5288679823228297259L;
    public static final long DXTABHEADERLAYOUT_ONTABCLICK = 5327268914103406564L;
    public static final long DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED = 1821589090930999503L;
    public static final long DXTABHEADERLAYOUT_RELATEDCOMPONENTID = -4472384284971071661L;
    public static final long DXTABHEADERLAYOUT_SELECTEDINDEX = 4437946449641611086L;
    public static final long DXTABHEADERLAYOUT_SHOWINDICATOR = -3765027987112450965L;
    public static final int DXTABHEADERLAYOUT_SHOWINDICATOR_FALSE = 1;
    public static final int DXTABHEADERLAYOUT_SHOWINDICATOR_TRUE = 0;
    public static final long DXTABHEADERLAYOUT_TABHEADERLAYOUT = 5297988424120091629L;
    private static final String TAG = "DXTabHeaderLayoutWidgetNode";
    private int currentIndex;
    private List<View> dxSelectedView;
    private DXViewPager dxViewPager;
    private boolean enableScroll = false;
    private Map<Integer, Boolean> hasSelectedMap = new HashMap();
    private int indicatorBottomGap;
    private int indicatorColor;
    private JSONObject indicatorColorMap;
    private JSONObject indicatorColorMapOrigin;
    private int indicatorHeight;
    private String indicatorImageUrl;
    private int indicatorRadius;
    private int indicatorWidth;
    private int indicatorZIndex = 1;
    private ArrayList<DXWidgetNode> itemNodes;
    private int itemWidth;
    private TabLayout.OnTabClickListener onTabClickListener;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private boolean relatedComponentAnimated = false;
    private String relatedComponentId;
    private int selectedIndex;
    private boolean showIndicator;
    private k simpleRenderPipeline;
    private List<DXTabItem> tabItemList;
    private List<View> unSelectedView;

    /* compiled from: Taobao */
    class a implements TabLayout.OnTabSelectedListener {
        final /* synthetic */ DXTabLayout a;

        a(DXTabLayout dXTabLayout) {
            this.a = dXTabLayout;
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.d dVar) {
            int d = dVar.d();
            if (dVar.b() != null && DXTabHeaderLayoutWidgetNode.this.dxViewPager != null) {
                DXTabHeaderLayoutWidgetNode.this.dxViewPager.setCurrentItem(d, false);
            }
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.d dVar) {
            int i = DXTabHeaderLayoutWidgetNode.this.currentIndex;
            int d = dVar.d();
            if (dVar.b() != null) {
                ((DXTabItem) dVar.b()).setSelected(true);
                DXTabHeaderLayoutWidgetNode.this.currentIndex = d;
                if (DXTabHeaderLayoutWidgetNode.this.indicatorColorMap != null) {
                    DXTabHeaderLayoutWidgetNode.this.renderIndicatorColor(this.a);
                }
                DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = DXTabHeaderLayoutWidgetNode.this;
                if (dXTabHeaderLayoutWidgetNode != null) {
                    JSONArray listData = dXTabHeaderLayoutWidgetNode.getListData();
                    boolean z = false;
                    if (DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.containsKey(Integer.valueOf(d))) {
                        z = ((Boolean) DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.get(Integer.valueOf(d))).booleanValue();
                    }
                    if (!z) {
                        DXTabHeaderLayoutWidgetNode.this.hasSelectedMap.put(Integer.valueOf(d), Boolean.valueOf(!z));
                    }
                    dXTabHeaderLayoutWidgetNode.postEvent(new bz(d, i, (listData == null || listData.size() <= d) ? null : listData.getJSONObject(d), !z, dVar.g()));
                }
            }
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.d dVar) {
            if (dVar.b() != null) {
                ((DXTabItem) dVar.b()).setSelected(false);
            }
        }
    }

    /* compiled from: Taobao */
    class b implements TabLayout.OnTabClickListener {
        b() {
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabClickListener
        public void onTabClick(TabLayout.d dVar) {
            int d = dVar.d();
            DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = DXTabHeaderLayoutWidgetNode.this;
            if (dXTabHeaderLayoutWidgetNode != null) {
                JSONArray listData = dXTabHeaderLayoutWidgetNode.getListData();
                dXTabHeaderLayoutWidgetNode.postEvent(new cz(d, DXTabHeaderLayoutWidgetNode.this.currentIndex, listData == null ? null : listData.getJSONObject(d)));
            }
        }
    }

    /* compiled from: Taobao */
    public static class c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXTabHeaderLayoutWidgetNode();
        }
    }

    private DXTabItemWidgetNode getFirstSelectedTabItem() {
        if (this.itemNodes == null) {
            return null;
        }
        for (int i = 0; i < this.itemNodes.size(); i++) {
            DXTabItemWidgetNode dXTabItemWidgetNode = (DXTabItemWidgetNode) this.itemNodes.get(i);
            if (dXTabItemWidgetNode.isSelected()) {
                return dXTabItemWidgetNode;
            }
        }
        return null;
    }

    private void parserIndicatorColorMap() {
        if (!(this.indicatorColorMapOrigin == null || this.itemNodes == null)) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : this.indicatorColorMapOrigin.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        int i = 0;
                        while (true) {
                            if (i >= this.itemNodes.size()) {
                                break;
                            } else if (key.equals(this.itemNodes.get(i).getUserId())) {
                                jSONObject.put(String.valueOf(i / 2), (Object) Integer.valueOf(Color.parseColor(String.valueOf(entry.getValue()))));
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                } catch (Exception e) {
                    vx.b(e);
                }
            }
            this.indicatorColorMap = jSONObject;
        }
    }

    private void renderIndicator(DXTabLayout dXTabLayout) {
        parserIndicatorColorMap();
        if (this.showIndicator) {
            renderIndicatorColor(dXTabLayout);
            dXTabLayout.setSelectedTabIndicatorHeight(this.indicatorHeight);
            dXTabLayout.setSelectedTabIndicatorWidth(this.indicatorWidth);
            dXTabLayout.setSelectedTabIndicatorRadius(this.indicatorRadius);
            dXTabLayout.setSelectedTabIndicatorBottomGap(this.indicatorBottomGap);
            dXTabLayout.setSelectedTabIndicatorZIndex(this.indicatorZIndex);
            return;
        }
        renderIndicatorColor(dXTabLayout);
        dXTabLayout.setSelectedTabIndicatorHeight(this.indicatorHeight);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void renderIndicatorColor(DXTabLayout dXTabLayout) {
        if (!this.showIndicator) {
            dXTabLayout.setSelectedTabIndicatorColor(0);
        } else if (this.indicatorColorMap == null) {
            dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColor);
        } else {
            String valueOf = String.valueOf(this.currentIndex);
            if (this.indicatorColorMap.containsKey(valueOf)) {
                dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColorMap.getInteger(valueOf).intValue());
            } else {
                dXTabLayout.setSelectedTabIndicatorColor(this.indicatorColor);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016a  */
    private void renderTabItems(DXTabLayout dXTabLayout) {
        boolean z;
        int i;
        int i2;
        TabLayout.d tabAt;
        FrameLayout.LayoutParams layoutParams;
        ry.b(TAG, "重新调用 renderTabItems  ");
        this.dxSelectedView = new ArrayList();
        this.unSelectedView = new ArrayList();
        this.tabItemList = new ArrayList();
        if (dXTabLayout != null) {
            dXTabLayout.removeAllTabs();
        }
        int size = this.itemNodes.size();
        if (size > 0) {
            int i3 = this.itemWidth;
            if (i3 <= 0) {
                i3 = getMeasuredWidth() / this.listData.size();
            }
            if (isEnableScroll() && dXTabLayout != null) {
                DXTabItemWidgetNode firstSelectedTabItem = getFirstSelectedTabItem();
                if (this.itemWidth > 0 || (firstSelectedTabItem != null && (firstSelectedTabItem.getLayoutWidth() == -2 || firstSelectedTabItem.getLayoutWidth() > 0))) {
                    dXTabLayout.setTabMode(0);
                    z = true;
                    for (i = 0; i < size; i++) {
                        DXTabItemWidgetNode dXTabItemWidgetNode = (DXTabItemWidgetNode) this.itemNodes.get(i);
                        int c2 = DXWidgetNode.DXMeasureSpec.c(i3, z ? this.itemWidth > 0 ? 1073741824 : 0 : Integer.MIN_VALUE);
                        int c3 = DXWidgetNode.DXMeasureSpec.c(getMeasuredHeight(), Integer.MIN_VALUE);
                        if (z) {
                            if (this.itemWidth > 0) {
                                dXTabItemWidgetNode.setLayoutWidth(-1);
                            } else if (dXTabItemWidgetNode.getLayoutWidth() < 0) {
                                dXTabItemWidgetNode.setLayoutWidth(-2);
                            }
                        }
                        View g = this.simpleRenderPipeline.g(dXTabItemWidgetNode, null, null, dXTabItemWidgetNode.getDXRuntimeContext(), 2, 8, c2, c3, -1);
                        if (z && this.itemWidth < 0) {
                            ViewGroup.LayoutParams layoutParams2 = g.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams = new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                            } else {
                                layoutParams = new FrameLayout.LayoutParams(dXTabItemWidgetNode.getMeasuredWidth(), dXTabItemWidgetNode.getMeasuredHeight());
                            }
                            layoutParams.gravity = h10.a(DXWidgetNode.getAbsoluteGravity(dXTabItemWidgetNode.getLayoutGravity(), dXTabItemWidgetNode.getDirection()));
                            g.setLayoutParams(layoutParams);
                        }
                        if (!dXTabItemWidgetNode.isSelected()) {
                            this.unSelectedView.add(g);
                        } else if (dXTabItemWidgetNode.isSelected()) {
                            this.dxSelectedView.add(g);
                        }
                    }
                    for (i2 = 0; i2 < this.listData.size(); i2++) {
                        DXTabItem dXTabItem = new DXTabItem(getDXRuntimeContext().getContext());
                        if (i2 < this.dxSelectedView.size()) {
                            dXTabItem.setSelectView(this.dxSelectedView.get(i2));
                        }
                        if (i2 < this.unSelectedView.size()) {
                            dXTabItem.setUnSelectView(this.unSelectedView.get(i2));
                        }
                        if (i2 == this.currentIndex) {
                            dXTabItem.setSelected(true);
                        } else {
                            dXTabItem.setSelected(false);
                        }
                        this.tabItemList.add(dXTabItem);
                        dXTabLayout.addTab(dXTabLayout.newTab().m(dXTabItem));
                    }
                    tabAt = dXTabLayout.getTabAt(this.currentIndex);
                    if (tabAt != null) {
                        tabAt.p(false);
                    }
                    dXTabLayout.selectTab(tabAt);
                }
            }
            z = false;
            while (i < size) {
            }
            while (i2 < this.listData.size()) {
            }
            tabAt = dXTabLayout.getTabAt(this.currentIndex);
            if (tabAt != null) {
            }
            dXTabLayout.selectTab(tabAt);
        }
    }

    public void bindViewPager(DXViewPager dXViewPager) {
        DXTabLayout dXTabLayout = (DXTabLayout) getDXRuntimeContext().getNativeView();
        if (dXViewPager instanceof DXViewPager) {
            dXTabLayout.setupWithViewPager((ViewPager) dXViewPager.getDXRuntimeContext().getNativeView());
        }
        if (dXViewPager != null && dXViewPager.getItemWidgetNodes() != null) {
            int size = dXViewPager.getItemWidgetNodes().size();
            for (int i = 0; i < size; i++) {
                TabLayout.d tabAt = dXTabLayout.getTabAt(i);
                if (i == this.currentIndex) {
                    if (i >= this.tabItemList.size()) {
                        break;
                    }
                    DXTabItem dXTabItem = this.tabItemList.get(i);
                    dXTabItem.setSelected(true);
                    tabAt.m(dXTabItem);
                } else if (i >= this.tabItemList.size()) {
                    break;
                } else {
                    DXTabItem dXTabItem2 = this.tabItemList.get(i);
                    dXTabItem2.setSelected(false);
                    tabAt.m(dXTabItem2);
                }
                ry.b(TAG, "bindViewPager set " + i + " view " + tabAt.b());
            }
            int i2 = this.currentIndex;
            if (i2 != 0) {
                this.dxViewPager.setCurrentItem(i2, false);
            } else {
                this.hasSelectedMap.put(0, Boolean.TRUE);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXTabHeaderLayoutWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DXTABHEADERLAYOUT_ENABLESCROLL) {
            return 0;
        }
        if (j == DXTABHEADERLAYOUT_INDICATORZINDEX) {
            return 1;
        }
        if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if (WXTabbar.SELECT_INDEX.equals(str)) {
            return Integer.valueOf(this.currentIndex);
        }
        return super.getNodePropByKey(str);
    }

    public boolean isEnableScroll() {
        return this.enableScroll;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.util.ArrayList<com.taobao.android.dinamicx.widget.DXWidgetNode> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (getChildren() != null && this.originItems == null) {
            ArrayList arrayList = new ArrayList();
            this.originItems = arrayList;
            arrayList.addAll(getChildren());
        }
        if ((this.propertyInitFlag & 2) != 0) {
            JSONArray jSONArray = this.listData;
            if (jSONArray == null || jSONArray.isEmpty() || getChildren() == null) {
                removeAllChild();
                return;
            }
            new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.originItems.size(); i++) {
                arrayList2.add(this.originItems.get(i).deepClone(getDXRuntimeContext()));
            }
            ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(0, getListData(), arrayList2);
            this.itemNodes = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.itemNodes.add(arrayList2.get(i2));
            }
            for (int i3 = 0; i3 < generateWidgetNodeByData.size(); i3++) {
                this.itemNodes.add(generateWidgetNodeByData.get(i3));
            }
            removeAllChild();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof DXTabHeaderLayoutWidgetNode)) {
            super.onClone(dXWidgetNode, z);
            DXTabHeaderLayoutWidgetNode dXTabHeaderLayoutWidgetNode = (DXTabHeaderLayoutWidgetNode) dXWidgetNode;
            this.indicatorBottomGap = dXTabHeaderLayoutWidgetNode.indicatorBottomGap;
            this.indicatorColor = dXTabHeaderLayoutWidgetNode.indicatorColor;
            this.indicatorHeight = dXTabHeaderLayoutWidgetNode.indicatorHeight;
            this.indicatorImageUrl = dXTabHeaderLayoutWidgetNode.indicatorImageUrl;
            this.indicatorRadius = dXTabHeaderLayoutWidgetNode.indicatorRadius;
            this.indicatorWidth = dXTabHeaderLayoutWidgetNode.indicatorWidth;
            this.indicatorZIndex = dXTabHeaderLayoutWidgetNode.indicatorZIndex;
            this.itemWidth = dXTabHeaderLayoutWidgetNode.itemWidth;
            this.relatedComponentId = dXTabHeaderLayoutWidgetNode.relatedComponentId;
            this.relatedComponentAnimated = dXTabHeaderLayoutWidgetNode.relatedComponentAnimated;
            this.selectedIndex = dXTabHeaderLayoutWidgetNode.selectedIndex;
            this.showIndicator = dXTabHeaderLayoutWidgetNode.showIndicator;
            this.simpleRenderPipeline = dXTabHeaderLayoutWidgetNode.simpleRenderPipeline;
            this.dxSelectedView = dXTabHeaderLayoutWidgetNode.dxSelectedView;
            this.unSelectedView = dXTabHeaderLayoutWidgetNode.unSelectedView;
            this.tabItemList = dXTabHeaderLayoutWidgetNode.tabItemList;
            this.currentIndex = dXTabHeaderLayoutWidgetNode.currentIndex;
            this.hasSelectedMap = dXTabHeaderLayoutWidgetNode.hasSelectedMap;
            this.itemNodes = dXTabHeaderLayoutWidgetNode.itemNodes;
            this.onTabClickListener = dXTabHeaderLayoutWidgetNode.onTabClickListener;
            this.onTabSelectedListener = dXTabHeaderLayoutWidgetNode.onTabSelectedListener;
            this.dxViewPager = dXTabHeaderLayoutWidgetNode.dxViewPager;
            this.indicatorColorMap = dXTabHeaderLayoutWidgetNode.indicatorColorMap;
            this.indicatorColorMapOrigin = dXTabHeaderLayoutWidgetNode.indicatorColorMapOrigin;
            this.enableScroll = dXTabHeaderLayoutWidgetNode.enableScroll;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXTabLayout(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        super.onEndParser();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.simpleRenderPipeline == null) {
            this.simpleRenderPipeline = new k(getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString());
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        DXWidgetNode realRootExpandWidget;
        super.onRenderView(context, view);
        if ((view instanceof DXTabLayout) && (realRootExpandWidget = getDXRuntimeContext().getRealRootExpandWidget()) != null) {
            DXTabLayout dXTabLayout = (DXTabLayout) view;
            dXTabLayout.clearOnTabClickListeners();
            dXTabLayout.clearOnTabSelectedListeners();
            dXTabLayout.setViewPagerSmoothScroll(this.relatedComponentAnimated);
            renderTabItems(dXTabLayout);
            renderIndicator(dXTabLayout);
            a aVar = new a(dXTabLayout);
            this.onTabSelectedListener = aVar;
            dXTabLayout.addOnTabSelectedListener(aVar);
            TabLayout.OnTabClickListener onTabClickListener2 = this.onTabClickListener;
            if (onTabClickListener2 != null) {
                dXTabLayout.removeOnTabClickListener(onTabClickListener2);
            }
            b bVar = new b();
            this.onTabClickListener = bVar;
            dXTabLayout.addOnTabClickListener(bVar);
            DXViewPager dXViewPager = (DXViewPager) realRootExpandWidget.queryWidgetNodeByUserId(this.relatedComponentId);
            this.dxViewPager = dXViewPager;
            if (dXViewPager != null) {
                dXViewPager.setTabLayoutWidget(this);
                if (this.dxViewPager.getDXRuntimeContext().getNativeView() != null) {
                    ry.b(TAG, "触发重新绑定");
                    bindViewPager(this.dxViewPager);
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        boolean z = false;
        if (j == DXTABHEADERLAYOUT_INDICATORBOTTOMGAP) {
            if (i <= 0) {
                this.indicatorBottomGap = 0;
            } else {
                this.indicatorBottomGap = i;
            }
        } else if (j == -5151416374116397110L) {
            this.indicatorColor = i;
        } else if (j == DXTABHEADERLAYOUT_INDICATORHEIGHT) {
            if (i <= 0) {
                this.indicatorHeight = 0;
            } else {
                this.indicatorHeight = i;
            }
        } else if (j == DXTABHEADERLAYOUT_INDICATORRADIUS) {
            if (i <= 0) {
                this.indicatorRadius = 0;
            } else {
                this.indicatorRadius = i;
            }
        } else if (j == DXTABHEADERLAYOUT_INDICATORWIDTH) {
            if (i <= 0) {
                this.indicatorWidth = 0;
            } else {
                this.indicatorWidth = i;
            }
        } else if (j == -5480582194049152328L) {
            if (i <= 0) {
                this.itemWidth = 0;
            } else {
                this.itemWidth = i;
            }
        } else if (j == DXTABHEADERLAYOUT_SELECTEDINDEX) {
            if (i <= 0) {
                this.selectedIndex = 0;
            } else {
                this.selectedIndex = i;
            }
            this.currentIndex = this.selectedIndex;
        } else if (j == -3765027987112450965L) {
            if (i == 1) {
                z = true;
            }
            this.showIndicator = z;
        } else if (j == DXTABHEADERLAYOUT_ENABLESCROLL) {
            if (i != 0) {
                z = true;
            }
            this.enableScroll = z;
        } else if (j == DXTABHEADERLAYOUT_INDICATORZINDEX) {
            this.indicatorZIndex = i;
        } else if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTANIMATED) {
            if (i != 0) {
                z = true;
            }
            this.relatedComponentAnimated = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (qy.DX_PARSER_LISTDATA == j) {
            setListData(jSONArray);
            setStatFlag(2);
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
        if (j != DXTABHEADERLAYOUT_INDICATORCOLORMAP) {
            super.onSetMapAttribute(j, jSONObject);
        } else if (jSONObject != null) {
            this.indicatorColorMapOrigin = jSONObject;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXTABHEADERLAYOUT_INDICATORIMAGEURL) {
            this.indicatorImageUrl = str;
        } else if (j == DXTABHEADERLAYOUT_RELATEDCOMPONENTID) {
            this.relatedComponentId = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    public void resetHasSelectedMap() {
        Map<Integer, Boolean> map = this.hasSelectedMap;
        if (map == null) {
            this.hasSelectedMap = new HashMap();
            return;
        }
        map.clear();
        this.hasSelectedMap.put(Integer.valueOf(this.currentIndex), Boolean.TRUE);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(lx lxVar) {
        if (lxVar != null) {
            if (getReferenceNode() != null && isSelfResponseEvent()) {
                postEvent(lxVar);
            }
            ArrayList<DXWidgetNode> arrayList = this.itemNodes;
            if (arrayList != null) {
                Iterator<DXWidgetNode> it = arrayList.iterator();
                while (it.hasNext()) {
                    DXWidgetNode next = it.next();
                    if (isChildResponseEvent()) {
                        next.sendBroadcastEvent(lxVar);
                    }
                }
            }
        }
    }

    public void setSelectTab(int i) {
        DXTabLayout dXTabLayout = (DXTabLayout) getDXRuntimeContext().getNativeView();
        if (dXTabLayout != null) {
            dXTabLayout.setScrollPosition(i, 0.0f, true);
        }
    }
}
