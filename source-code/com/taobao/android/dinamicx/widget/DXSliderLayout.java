package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXLinearLayoutManager;
import com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.android.dinamicx.view.DXScrollLinearLayoutManager;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import tb.c00;
import tb.fz;
import tb.k00;
import tb.lx;
import tb.v00;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class DXSliderLayout extends DXScrollerLayout {
    public static final long DXSLIDERLAYOUT_AVOIDINCESSANTSCROLL = 6175561478597347134L;
    public static final long DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID = 4501425988663277281L;
    public static final long DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER = -5411074322938787347L;
    public static final long DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT = -3458159313298372122L;
    public static final int DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT_NONE = 0;
    public static final long DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID = 3230619470895835019L;
    public static final long DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH = -4985343460365605412L;
    public static final long DXSLIDERLAYOUT_OVERRIDECANSCROLLHORIZONTALLY = 2622876492584549901L;
    public static final long DXSLIDERLAYOUT_SCROLLWITHPOSTMSG = -7857363928666175735L;
    public static final long DX_SLIDER_LAYOUT = 7645421793448373229L;
    public static final long DX_SLIDER_LAYOUT_AUTO_SCROLL = 2618773720063865426L;
    public static final long DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL = 5501313022839937951L;
    public static final long DX_SLIDER_LAYOUT_IS_INFINITE = -3537170322378136036L;
    public static final long DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED = -7107533083539416402L;
    public static final long DX_SLIDER_LAYOUT_ON_PAGE_CHANGE = -8975195222378757716L;
    public static final long DX_SLIDER_LAYOUT_ON_SET_PAGE_INDEX = -3492248032330035060L;
    public static final long DX_SLIDER_LAYOUT_PAGE_INDEX = 7816489696776271262L;
    private static final String TAG = "DXSliderLayout";
    private boolean autoScroll;
    private int autoScrollInterval = 1000;
    private boolean avoidIncessantScroll = false;
    private boolean avoidIndexDeltaToLarge_Android = false;
    private boolean disablePageSelectAndstartTimeOnPreRender = false;
    private int interceptTouchEvent = 0;
    private boolean isCorrectionSlideOffset_Android = false;
    private boolean isInfinite;
    private boolean isInterceptMultipointTouch = true;
    private boolean manualSwitchEnabled = true;
    private boolean overrideCanScrollHorizontal = false;
    private int pageIndex;
    private boolean scrollWithPostMsg = false;

    /* compiled from: Taobao */
    public static class AutoLoopScrollerAdapter extends DXScrollerLayout.ScrollerAdapter {
        public AutoLoopScrollerAdapter(Context context, DXScrollerLayout dXScrollerLayout) {
            super(context, dXScrollerLayout);
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter
        public DXWidgetNode b(int i) {
            return super.b(i % this.c.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter, com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter
        public int getItemCount() {
            ArrayList<DXWidgetNode> arrayList = this.c;
            return (arrayList == null || arrayList.size() == 0) ? 0 : Integer.MAX_VALUE;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            ArrayList<DXWidgetNode> arrayList = this.c;
            return arrayList.get(i % arrayList.size()).getAutoId();
        }
    }

    /* compiled from: Taobao */
    public static class SliderScrollListener extends DXScrollerLayout.ScrollListener {
        private final boolean m;
        private boolean n;

        public SliderScrollListener(boolean z, boolean z2) {
            this.m = z2;
            this.n = z;
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int size;
            super.onScrollStateChanged(recyclerView, i);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            final int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) recyclerView;
            if (i == 0) {
                if (dXNativeAutoLoopRecyclerView.getCurrentIndex() != findFirstVisibleItemPosition && findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    wz.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "onScrollStateChanged state idle。 currentIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";firstVisiblePosition = " + findFirstVisibleItemPosition + ";delta = " + (findFirstVisibleItemPosition - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
                    dXNativeAutoLoopRecyclerView.setCurrentIndex(findFirstVisibleItemPosition);
                    if (this.m && !c00.e(new Runnable() {
                        /* class com.taobao.android.dinamicx.widget.DXSliderLayout.SliderScrollListener.AnonymousClass1 */

                        public void run() {
                            dXNativeAutoLoopRecyclerView.scrollToPosition(findFirstVisibleItemPosition);
                        }
                    })) {
                        wz.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "onScrollStateChanged state idle scrollToPosition failed, position =  " + findFirstVisibleItemPosition);
                        e eVar = new e(v00.DB_NAME);
                        e.a aVar = new e.a("Render", "RENDER_ERROR", e.DX_ERROR_CODE_SLIDER_LAYOUT_IDLE_SCROLL_TO_FAILED);
                        aVar.e = "onScrollStateChanged state idle scrollToPosition failed, position =  " + findFirstVisibleItemPosition;
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                    }
                    if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                        dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(findFirstVisibleItemPosition);
                    }
                    if (d().getOrientation() == 0) {
                        DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                        int measuredWidth = d().getMeasuredWidth();
                        if (measuredWidth != 0 && scrollListener.g % measuredWidth != 0) {
                            if (scrollListener.d() != null && scrollListener.d().itemWidgetNodes != null && this.n && (size = scrollListener.d().itemWidgetNodes.size()) > 0 && findFirstVisibleItemPosition > 100) {
                                findFirstVisibleItemPosition %= size;
                            }
                            int measuredWidth2 = findFirstVisibleItemPosition * d().getMeasuredWidth();
                            dXNativeAutoLoopRecyclerView.setScrolledX(measuredWidth2);
                            dXNativeAutoLoopRecyclerView.setScrolledY(0);
                            scrollListener.h(measuredWidth2);
                            scrollListener.i(0);
                            g(recyclerView, this.b);
                            f("scroll_end");
                        }
                    }
                } else if (this.n) {
                    int measuredWidth3 = d().getMeasuredWidth();
                    DXScrollerLayout.ScrollListener scrollListener2 = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                    int i2 = scrollListener2.g;
                    if ((i2 % measuredWidth3 != 0 && findFirstVisibleItemPosition == findLastVisibleItemPosition) || ((i2 / measuredWidth3) % 4 != dXNativeAutoLoopRecyclerView.getCurrentIndex() % 4 && findFirstVisibleItemPosition == findLastVisibleItemPosition)) {
                        int currentIndex = (dXNativeAutoLoopRecyclerView.getCurrentIndex() % 4) * d().getMeasuredWidth();
                        dXNativeAutoLoopRecyclerView.setScrolledX(currentIndex);
                        dXNativeAutoLoopRecyclerView.setScrolledY(0);
                        scrollListener2.h(currentIndex);
                        scrollListener2.i(0);
                        g(recyclerView, this.b);
                        f("scroll_end");
                    }
                }
            } else if (findFirstVisibleItemPosition == 0 && findLastVisibleItemPosition == 1 && i == 1) {
                wz.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "first = 0 && last = 1 protect index。set current index = " + findFirstVisibleItemPosition);
                dXNativeAutoLoopRecyclerView.setCurrentIndex(findFirstVisibleItemPosition);
                if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                    dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(findFirstVisibleItemPosition);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXSliderLayout();
        }
    }

    /* compiled from: Taobao */
    public static class b implements DXNativeAutoLoopRecyclerView.OnPageChangeListener {
        private DXSliderLayout a;
        private int b;
        private fz c = new fz(-8975195222378757716L);

        public b(DXSliderLayout dXSliderLayout, int i) {
            this.a = dXSliderLayout;
            this.b = i;
        }

        @Override // com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.b == 0) {
                DXRuntimeContext dXRuntimeContext = this.a.getDXRuntimeContext();
                e eVar = new e(dXRuntimeContext.getBizType());
                eVar.b = dXRuntimeContext.getDxTemplateItem();
                e.a aVar = new e.a("Engine", "Engine_Render", e.DX_ERROR_CODE_SLIDER_LAYOUT_ITEM_COUNT_0);
                aVar.e = "position=" + i;
                eVar.c.add(aVar);
                return;
            }
            DXRuntimeContext dXRuntimeContext2 = this.a.getDXRuntimeContext();
            if (dXRuntimeContext2 != null) {
                DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) dXRuntimeContext2.getNativeView();
                WeakReference<View> weakReference = null;
                if (dXNativeAutoLoopRecyclerView == null) {
                    e eVar2 = new e(dXRuntimeContext2.getBizType());
                    eVar2.b = dXRuntimeContext2.getDxTemplateItem();
                    e.a aVar2 = new e.a("Engine", "Engine_Render", e.DX_ERROR_CODE_SLIDER_LAYOUT_RECYCLER_VIEW_NULL);
                    DXWidgetNode referenceNode = this.a.getReferenceNode();
                    if (referenceNode != null) {
                        weakReference = referenceNode.getWRView();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("flattenWidgetNode is");
                    String str = "null";
                    sb.append(referenceNode == null ? str : "notNull");
                    sb.append("weakReferenceView is");
                    if (weakReference != null) {
                        str = "notNull";
                    }
                    sb.append(str);
                    aVar2.e = sb.toString();
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("thread info:");
                        sb2.append(Thread.currentThread().getName());
                        DXWidgetNode widgetNode = dXRuntimeContext2.getWidgetNode();
                        if (widgetNode != null) {
                            sb2.append("expandedWT != null\n ");
                            if (widgetNode.getReferenceNode() == null) {
                                sb2.append("flatten == null");
                            }
                        } else {
                            sb2.append("expandedWT == null\n ");
                        }
                        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                        if (stackTrace != null) {
                            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                                sb2.append(stackTrace[i2].getClassName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + stackTrace[i2].getMethodName() + " #" + stackTrace[i2].getLineNumber() + StringUtils.LF);
                            }
                        }
                        wz.b(sb2.toString());
                        aVar2.e += sb2.toString();
                    } catch (Throwable th) {
                        eVar2.c.add(aVar2);
                        DXAppMonitor.n(eVar2);
                        throw th;
                    }
                    eVar2.c.add(aVar2);
                    DXAppMonitor.n(eVar2);
                    return;
                }
                dXNativeAutoLoopRecyclerView.setSaveInstanceState(null);
                if (this.a.isInfinite) {
                    this.c.f(i % this.b);
                } else {
                    this.c.f(i);
                }
                DXWidgetNode dXWidgetNode = this.a.indicatorWidgetNode;
                if (dXWidgetNode != null) {
                    dXWidgetNode.postEvent(this.c);
                }
                this.a.setPageIndex(this.c.d);
                this.a.postEvent(this.c);
            }
        }
    }

    private int calculateTargetIndex(DXSliderLayout dXSliderLayout, int i) {
        ArrayList<DXWidgetNode> arrayList = dXSliderLayout.itemWidgetNodes;
        int i2 = 0;
        int size = arrayList != null ? arrayList.size() : 0;
        if (!dXSliderLayout.isInfinite) {
            i2 = i;
        } else if (size != 0) {
            i2 = ((536870911 / size) * size) + i;
        }
        wz.d(TAG, TAG, "calculateTargetIndex = " + i2 + ";pageIndex = " + i + ";itemCount = " + size);
        return i2;
    }

    private void scrollToIndexOnIsNotInfinite(final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView, DXSliderLayout dXSliderLayout, final int i) {
        if (i <= 0) {
            return;
        }
        if (getOrientation() == 0) {
            final DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
            dXNativeAutoLoopRecyclerView.needScrollAfterLayout(i * getMeasuredWidth(), 0, dXSliderLayout.contentHorizontalLength, dXSliderLayout.contentVerticalLength);
            scrollListener.g(dXNativeAutoLoopRecyclerView, new k00(DX_SLIDER_LAYOUT_ON_SET_PAGE_INDEX));
            c00.e(new Runnable() {
                /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass6 */

                public void run() {
                    scrollListener.f("scrolling");
                }
            });
            return;
        }
        c00.e(new Runnable() {
            /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass7 */

            public void run() {
                dXNativeAutoLoopRecyclerView.scrollToPosition(i);
            }
        });
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXSliderLayout();
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public int getDefaultValueForIntAttr(long j) {
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL) {
            return 0;
        }
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL) {
            return 1000;
        }
        if (j == -3537170322378136036L) {
            return 0;
        }
        if (j == DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED) {
            return 1;
        }
        if (j == DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER || j == DX_SLIDER_LAYOUT_PAGE_INDEX) {
            return 0;
        }
        if (j == DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH) {
            return 1;
        }
        if (j == DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID || j == DXSLIDERLAYOUT_SCROLLWITHPOSTMSG || j == DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if ("pageIndex".equals(str)) {
            return Integer.valueOf(this.pageIndex);
        }
        return super.getNodePropByKey(str);
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public int measureSpecForChild(int i, int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    @NonNull
    public DXLinearLayoutManager newLinearLayoutManager(Context context) {
        return new DXScrollLinearLayoutManager(context, getOrientation(), false);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public DXScrollerLayout.ScrollListener newScrollListener() {
        return new SliderScrollListener(this.isCorrectionSlideOffset_Android, this.avoidIndexDeltaToLarge_Android);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXSliderLayout) {
            DXSliderLayout dXSliderLayout = (DXSliderLayout) dXWidgetNode;
            this.isInfinite = dXSliderLayout.isInfinite;
            this.pageIndex = dXSliderLayout.pageIndex;
            this.autoScrollInterval = dXSliderLayout.autoScrollInterval;
            this.autoScroll = dXSliderLayout.autoScroll;
            this.manualSwitchEnabled = dXSliderLayout.manualSwitchEnabled;
            this.disablePageSelectAndstartTimeOnPreRender = dXSliderLayout.disablePageSelectAndstartTimeOnPreRender;
            this.interceptTouchEvent = dXSliderLayout.interceptTouchEvent;
            this.avoidIncessantScroll = dXSliderLayout.avoidIncessantScroll;
            this.isInterceptMultipointTouch = dXSliderLayout.isInterceptMultipointTouch;
            this.avoidIndexDeltaToLarge_Android = dXSliderLayout.avoidIndexDeltaToLarge_Android;
            this.scrollWithPostMsg = dXSliderLayout.scrollWithPostMsg;
            this.overrideCanScrollHorizontal = dXSliderLayout.overrideCanScrollHorizontal;
            this.isCorrectionSlideOffset_Android = dXSliderLayout.isCorrectionSlideOffset_Android;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeAutoLoopRecyclerView(context);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r0 = (com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
     */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(lx lxVar) {
        DXRootView rootView;
        final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView;
        int measuredWidth;
        int scrolledX;
        if (super.onEvent(lxVar) || (rootView = getDXRuntimeContext().getRootView()) == null) {
            return true;
        }
        if (!rootView.hasDXRootViewLifeCycle() || dXNativeAutoLoopRecyclerView == null) {
            return false;
        }
        dXNativeAutoLoopRecyclerView.setNeedProcessViewLifeCycle(false);
        long b2 = lxVar.b();
        if (5288671110273408574L == b2) {
            dXNativeAutoLoopRecyclerView.startTimer();
            if (!dXNativeAutoLoopRecyclerView.isAutoPlay() && getOrientation() == 0 && !dXNativeAutoLoopRecyclerView.isNeedScrollAfterLayout() && (measuredWidth = getMeasuredWidth()) != 0 && (scrolledX = dXNativeAutoLoopRecyclerView.getScrolledX() % measuredWidth) != 0) {
                int measuredWidth2 = getMeasuredWidth() / 2;
                final int scrolledX2 = dXNativeAutoLoopRecyclerView.getScrolledX() / measuredWidth;
                if (scrolledX > measuredWidth2) {
                    dXNativeAutoLoopRecyclerView.scrollBy(measuredWidth - scrolledX, 0);
                    scrolledX2++;
                } else {
                    dXNativeAutoLoopRecyclerView.scrollBy(-scrolledX, 0);
                }
                wz.d(TAG, TAG, "onAppear correct index。  oldIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";newIndex = " + scrolledX2 + ";delta = " + (scrolledX2 - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
                dXNativeAutoLoopRecyclerView.setCurrentIndex(scrolledX2);
                if (this.avoidIndexDeltaToLarge_Android && !c00.e(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass2 */

                    public void run() {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(scrolledX2);
                    }
                })) {
                    wz.d(TAG, TAG, "onAppear correct index scrollToPosition failed, position =  " + scrolledX2);
                    e eVar = new e(v00.DB_NAME);
                    e.a aVar = new e.a("Render", "RENDER_ERROR", e.DX_ERROR_CODE_SLIDER_LAYOUT_APPEAR_SCROLL_TO_FAILED);
                    aVar.e = "onAppear correct index scrollToPosition failed, position =  " + scrolledX2;
                    eVar.c.add(aVar);
                    DXAppMonitor.n(eVar);
                }
                if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                    dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(scrolledX2);
                }
                final DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                c00.e(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass3 */

                    public void run() {
                        if (scrolledX2 == 0) {
                            scrollListener.h(1);
                            scrollListener.f("scrolling");
                            scrollListener.h(0);
                        }
                        scrollListener.f("scrolling");
                    }
                });
            }
            return true;
        }
        if (5388973340095122049L == b2) {
            try {
                dXNativeAutoLoopRecyclerView.stopTimer();
                dXNativeAutoLoopRecyclerView.setSaveInstanceState(dXNativeAutoLoopRecyclerView.getLayoutManager().onSaveInstanceState());
                return true;
            } catch (Throwable th) {
                vx.b(th);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onRenderView(Context context, View view) {
        DXSliderLayout dXSliderLayout;
        int i;
        int size;
        super.onRenderView(context, view);
        if ((view instanceof DXNativeAutoLoopRecyclerView) && (dXSliderLayout = (DXSliderLayout) getDXRuntimeContext().getWidgetNode()) != null) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) view;
            dXNativeAutoLoopRecyclerView.setOverrideCanScrollHorizontal(this.overrideCanScrollHorizontal);
            dXNativeAutoLoopRecyclerView.setDinamicXEngine(getDXRuntimeContext().getEngineContext().e());
            dXNativeAutoLoopRecyclerView.setNestedType(this.interceptTouchEvent);
            dXNativeAutoLoopRecyclerView.setInterceptMultipointTouch(this.isInterceptMultipointTouch);
            final int calculateTargetIndex = calculateTargetIndex(dXSliderLayout, dXSliderLayout.pageIndex);
            if (dXSliderLayout.getMeasuredWidth() != 0 && getOrientation() == 0 && this.isCorrectionSlideOffset_Android) {
                DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                int measuredWidth = ((scrollListener == null || scrollListener.d() == null || scrollListener.d().itemWidgetNodes == null || (size = scrollListener.d().itemWidgetNodes.size()) <= 0 || calculateTargetIndex <= 100) ? calculateTargetIndex : calculateTargetIndex % size) * dXSliderLayout.getMeasuredWidth();
                dXNativeAutoLoopRecyclerView.setScrolledX(measuredWidth);
                dXNativeAutoLoopRecyclerView.setScrolledY(0);
                scrollListener.h(measuredWidth);
                scrollListener.i(0);
            }
            DXRootView rootView = getDXRuntimeContext().getRootView();
            if (rootView != null) {
                dXNativeAutoLoopRecyclerView.setNeedProcessViewLifeCycle(!rootView.hasDXRootViewLifeCycle());
                wz.d(TAG, TAG, "onRenderView oldIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";newIndex = " + calculateTargetIndex + ";delta = " + (calculateTargetIndex - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
                dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
                if (dXSliderLayout.isInfinite) {
                    boolean e = c00.e(new Runnable() {
                        /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass1 */

                        public void run() {
                            dXNativeAutoLoopRecyclerView.scrollToPosition(calculateTargetIndex);
                        }
                    });
                    if (this.avoidIndexDeltaToLarge_Android && !e) {
                        wz.d(TAG, TAG, "onRenderView scrollToPosition failed, targetIndex = " + calculateTargetIndex);
                        e eVar = new e(v00.DB_NAME);
                        e.a aVar = new e.a("Render", "RENDER_ERROR", e.DX_ERROR_CODE_SLIDER_LAYOUT_RENDER_SCROLL_TO_FAILED);
                        aVar.e = "onRenderView scrollToPosition failed, targetIndex = " + calculateTargetIndex;
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                    }
                } else {
                    scrollToIndexOnIsNotInfinite(dXNativeAutoLoopRecyclerView, dXSliderLayout, calculateTargetIndex);
                }
                ArrayList<DXWidgetNode> arrayList = dXSliderLayout.itemWidgetNodes;
                b bVar = new b(dXSliderLayout, arrayList != null ? arrayList.size() : 0);
                dXNativeAutoLoopRecyclerView.setOnPageChangeListener(bVar);
                if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                    bVar.onPageSelected(calculateTargetIndex);
                }
                dXNativeAutoLoopRecyclerView.setManualSwitchEnabled(this.manualSwitchEnabled);
                dXNativeAutoLoopRecyclerView.setAvoidIncessantScroll(this.avoidIncessantScroll);
                if (!dXSliderLayout.isInfinite || (i = dXSliderLayout.autoScrollInterval) <= 0 || !dXSliderLayout.autoScroll || !dXSliderLayout.scrollEnabled) {
                    dXNativeAutoLoopRecyclerView.stopTimer();
                    dXNativeAutoLoopRecyclerView.setAutoPlay(false);
                    return;
                }
                dXNativeAutoLoopRecyclerView.setInterval(i);
                dXNativeAutoLoopRecyclerView.setAutoPlay(true);
                if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                    dXNativeAutoLoopRecyclerView.startTimer();
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onSetIntAttribute(long j, int i) {
        boolean z = true;
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL) {
            if (i == 0) {
                z = false;
            }
            this.autoScroll = z;
        } else if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL) {
            this.autoScrollInterval = Math.max(0, i);
        } else if (j == DX_SLIDER_LAYOUT_PAGE_INDEX) {
            this.pageIndex = Math.max(0, i);
        } else if (j == -3537170322378136036L) {
            if (i == 0) {
                z = false;
            }
            this.isInfinite = z;
        } else if (j == DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED) {
            if (i == 0) {
                z = false;
            }
            this.manualSwitchEnabled = z;
        } else if (j == DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER) {
            if (i == 0) {
                z = false;
            }
            this.disablePageSelectAndstartTimeOnPreRender = z;
        } else if (j == DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT) {
            this.interceptTouchEvent = i;
        } else if (j == DXSLIDERLAYOUT_AVOIDINCESSANTSCROLL) {
            if (i == 0) {
                z = false;
            }
            this.avoidIncessantScroll = z;
        } else if (j == DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID) {
            if (i == 0) {
                z = false;
            }
            this.avoidIndexDeltaToLarge_Android = z;
        } else if (j == DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH) {
            if (i == 0) {
                z = false;
            }
            this.isInterceptMultipointTouch = z;
        } else if (j == DXSLIDERLAYOUT_SCROLLWITHPOSTMSG) {
            if (i == 0) {
                z = false;
            }
            this.scrollWithPostMsg = z;
        } else if (j == DXSLIDERLAYOUT_OVERRIDECANSCROLLHORIZONTALLY) {
            if (i == 0) {
                z = false;
            }
            this.overrideCanScrollHorizontal = z;
        } else if (j == DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID) {
            if (i == 0) {
                z = false;
            }
            this.isCorrectionSlideOffset_Android = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    public void scrollToPageIndex(int i) {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            DXSliderLayout dXSliderLayout = (DXSliderLayout) getDXRuntimeContext().getWidgetNode();
            final int calculateTargetIndex = calculateTargetIndex(dXSliderLayout, i);
            if (dXSliderLayout.isInfinite) {
                c00.e(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass4 */

                    public void run() {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(calculateTargetIndex);
                        dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
                    }
                });
            } else {
                scrollToIndexOnIsNotInfinite(dXNativeAutoLoopRecyclerView, dXSliderLayout, calculateTargetIndex);
            }
            DXNativeAutoLoopRecyclerView.OnPageChangeListener onPageChangeListener = dXNativeAutoLoopRecyclerView.getOnPageChangeListener();
            if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                onPageChangeListener.onPageSelected(calculateTargetIndex);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public void setAdapter(DXScrollerLayout dXScrollerLayout, @NonNull RecyclerView recyclerView, Context context) {
        DXSliderLayout dXSliderLayout = (DXSliderLayout) dXScrollerLayout;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!dXSliderLayout.isInfinite) {
            if (adapter instanceof AutoLoopScrollerAdapter) {
                recyclerView.setAdapter(null);
                DXScrollerLayout.ScrollerAdapter scrollerAdapter = new DXScrollerLayout.ScrollerAdapter(context, dXScrollerLayout);
                scrollerAdapter.setHasStableIds(true);
                scrollerAdapter.c(dXScrollerLayout.itemWidgetNodes);
                recyclerView.setAdapter(scrollerAdapter);
            } else if (adapter == null) {
                DXScrollerLayout.ScrollerAdapter scrollerAdapter2 = new DXScrollerLayout.ScrollerAdapter(context, dXScrollerLayout);
                scrollerAdapter2.setHasStableIds(true);
                scrollerAdapter2.c(dXScrollerLayout.itemWidgetNodes);
                recyclerView.setAdapter(scrollerAdapter2);
            } else {
                DXScrollerLayout.ScrollerAdapter scrollerAdapter3 = (DXScrollerLayout.ScrollerAdapter) recyclerView.getAdapter();
                scrollerAdapter3.c(dXScrollerLayout.itemWidgetNodes);
                scrollerAdapter3.f(dXScrollerLayout);
                if (this.pageIndex == 0) {
                    ((DXNativeRecyclerView) recyclerView).needScrollAfterLayout(0, 0, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength, this.scrollWithPostMsg);
                }
                Parcelable saveInstanceState = ((DXNativeAutoLoopRecyclerView) recyclerView).getSaveInstanceState();
                if (saveInstanceState != null) {
                    recyclerView.getLayoutManager().onRestoreInstanceState(saveInstanceState);
                }
                adapter.notifyDataSetChanged();
            }
            ((DXScrollerLayout.ScrollerAdapter) recyclerView.getAdapter()).d(false);
        } else if (adapter instanceof AutoLoopScrollerAdapter) {
            AutoLoopScrollerAdapter autoLoopScrollerAdapter = (AutoLoopScrollerAdapter) adapter;
            autoLoopScrollerAdapter.c(dXScrollerLayout.itemWidgetNodes);
            autoLoopScrollerAdapter.f(dXSliderLayout);
            autoLoopScrollerAdapter.notifyDataSetChanged();
        } else {
            AutoLoopScrollerAdapter autoLoopScrollerAdapter2 = new AutoLoopScrollerAdapter(context, dXScrollerLayout);
            autoLoopScrollerAdapter2.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(autoLoopScrollerAdapter2);
        }
    }

    public void setInterceptMultipointTouch(boolean z) {
        this.isInterceptMultipointTouch = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public void setLayoutManager(Context context, DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        super.setLayoutManager(context, dXScrollerLayout, recyclerView);
        DXScrollLinearLayoutManager dXScrollLinearLayoutManager = (DXScrollLinearLayoutManager) recyclerView.getLayoutManager();
        if (getOrientation() == 1) {
            dXScrollLinearLayoutManager.c(getHeight());
        } else {
            dXScrollLinearLayoutManager.c(getWidth());
        }
    }

    public void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public void smoothScrollToPosition(int i) {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            final int calculateTargetIndex = calculateTargetIndex((DXSliderLayout) getDXRuntimeContext().getWidgetNode(), i);
            c00.e(new Runnable() {
                /* class com.taobao.android.dinamicx.widget.DXSliderLayout.AnonymousClass5 */

                public void run() {
                    dXNativeAutoLoopRecyclerView.smoothScrollToPosition(calculateTargetIndex);
                    dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
                }
            });
            DXNativeAutoLoopRecyclerView.OnPageChangeListener onPageChangeListener = dXNativeAutoLoopRecyclerView.getOnPageChangeListener();
            if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                onPageChangeListener.onPageSelected(calculateTargetIndex);
            }
        }
    }

    public void startTimer() {
        DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView;
        int i;
        if ((getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) && (dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView()) != null && this.isInfinite && (i = this.autoScrollInterval) > 0 && this.autoScroll && this.scrollEnabled) {
            dXNativeAutoLoopRecyclerView.setInterval(i);
            dXNativeAutoLoopRecyclerView.setAutoPlay(true);
            if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                dXNativeAutoLoopRecyclerView.startTimer();
            }
        }
    }

    public void stopTimer() {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            dXNativeAutoLoopRecyclerView.stopTimer();
            dXNativeAutoLoopRecyclerView.setAutoPlay(false);
        }
    }
}
