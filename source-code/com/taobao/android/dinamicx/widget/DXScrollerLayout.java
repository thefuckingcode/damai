package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXLinearLayoutManager;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import tb.at;
import tb.g00;
import tb.t10;
import tb.v21;

/* compiled from: Taobao */
public class DXScrollerLayout extends DXScrollLayoutBase {
    public static final long DXSCROLLERLAYOUT_ANDROIDFIXSCROLLVERTICALCONFLICT = 3042866685285795334L;
    public static final long DXSCROLLERLAYOUT_DISABLECONTENTOFFSETRESET = -7541569833091285454L;
    public static final long DXSCROLLERLAYOUT_IGNOREREPEATRENDER = -1510047720479239593L;
    public static final long DXSCROLLERLAYOUT_OPENSCROLLERANIMATION = -7123870390816445523L;
    public static final long DX_SCROLLER_LAYOUT = 5192418215958133202L;
    public static final long DX_SCROLLER_LAYOUT_CONTENT_OFFSET = 1750803361827314031L;
    public static final long DX_SCROLLER_LAYOUT_ITEM_PREFETCH = 3722067687195294700L;
    public static final int DX_TAG_HAS_SCROLL_LISTENER = R$id.dx_recycler_view_has_scroll_listener;
    private boolean androidFixScrollVerticalConflict = false;
    protected int contentOffset = -1;
    private boolean disableContentOffsetReset = false;
    private boolean ignoreRepeatRender = false;
    private boolean itemPrefetch = true;
    private boolean openScrollerAnimation = false;

    /* compiled from: Taobao */
    public static class ScrollListener extends RecyclerView.OnScrollListener {
        private DXScrollerLayout a;
        protected g00 b = new g00(5288751146867425108L);
        private g00 c = new g00(9144262755562405950L);
        private g00 d = new g00(2691126191158604142L);
        private v21 e = new v21();
        private v21 f = new v21();
        protected int g;
        protected int h;
        DXRootView i;
        private JSONObject j;
        private JSONObject k;
        private d l;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void e() {
            if (this.a.openScrollerAnimation) {
                JSONObject jSONObject = new JSONObject();
                this.j = jSONObject;
                jSONObject.put("type", (Object) "BNDX");
                JSONObject jSONObject2 = new JSONObject();
                this.k = jSONObject2;
                this.j.put("params", (Object) jSONObject2);
                this.k.put("widget", (Object) this.a);
                this.i = this.a.getDXRuntimeContext().getRootView();
                this.l = this.a.getDXRuntimeContext().getEngineContext();
            }
        }

        public void c(RecyclerView recyclerView) {
            if (recyclerView instanceof DXNativeRecyclerView) {
                DXNativeRecyclerView dXNativeRecyclerView = (DXNativeRecyclerView) recyclerView;
                h(dXNativeRecyclerView.getScrolledX());
                i(dXNativeRecyclerView.getScrolledY());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollListener.AnonymousClass1 */

                    public void run() {
                        ScrollListener scrollListener = ScrollListener.this;
                        scrollListener.b.k(scrollListener.g);
                        ScrollListener scrollListener2 = ScrollListener.this;
                        scrollListener2.b.l(scrollListener2.h);
                        if (ScrollListener.this.a.indicatorWidgetNode != null) {
                            ScrollListener.this.a.indicatorWidgetNode.postEvent(ScrollListener.this.b);
                        }
                        ScrollListener.this.a.postEvent(ScrollListener.this.b);
                    }
                });
            }
        }

        public DXScrollerLayout d() {
            return this.a;
        }

        /* access modifiers changed from: protected */
        public void f(String str) {
            if (this.a.openScrollerAnimation) {
                this.k.put("offsetX", (Object) Integer.valueOf(this.g));
                this.k.put("offsetY", (Object) Integer.valueOf(this.h));
                this.k.put("action", (Object) str);
                this.k.put("sourceId", (Object) this.a.getUserId());
                this.l.k(this.i, this.j);
            }
        }

        /* access modifiers changed from: protected */
        public void g(RecyclerView recyclerView, g00 g00) {
            g00.k(this.g);
            g00.l(this.h);
            if (this.a.getOrientation() == 0) {
                this.a.contentOffset = this.g;
            } else {
                this.a.contentOffset = this.h;
            }
            DXWidgetNode dXWidgetNode = this.a.indicatorWidgetNode;
            if (dXWidgetNode != null) {
                dXWidgetNode.postEvent(g00);
            }
            this.a.postEvent(g00);
        }

        public void h(int i2) {
            this.g = i2;
        }

        public void i(int i2) {
            this.h = i2;
        }

        public void j(DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
            this.a = dXScrollerLayout;
            if (dXScrollerLayout.getOrientation() == 0) {
                v21 v21 = this.f;
                v21.a = dXScrollerLayout.contentHorizontalLength;
                v21.b = dXScrollerLayout.getMeasuredHeight();
                this.b.j(this.f);
                this.c.j(this.f);
                this.d.j(this.f);
            } else {
                this.f.a = dXScrollerLayout.getMeasuredWidth();
                v21 v212 = this.f;
                v212.b = dXScrollerLayout.contentVerticalLength;
                this.b.j(v212);
                this.c.j(this.f);
                this.d.j(this.f);
            }
            this.e.a = dXScrollerLayout.getMeasuredWidth();
            this.e.b = dXScrollerLayout.getMeasuredHeight();
            this.b.n(this.e);
            this.c.n(this.e);
            this.d.n(this.e);
            this.b.m(recyclerView);
            this.c.m(recyclerView);
            this.d.m(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1) {
                g(recyclerView, this.c);
                f("scroll_beigin");
            } else if (i2 == 0) {
                g(recyclerView, this.d);
                f("scroll_end");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            this.g += i2;
            this.h += i3;
            g(recyclerView, this.b);
            f("scrolling");
        }
    }

    /* compiled from: Taobao */
    public static class ScrollerAdapter extends RecyclerView.Adapter {
        private k a;
        protected Context b;
        protected ArrayList<DXWidgetNode> c = new ArrayList<>();
        protected DXScrollerLayout d;
        private boolean e = true;
        private t10 f = new t10(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR);
        private t10 g = new t10(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR);

        /* compiled from: Taobao */
        public static class ItemViewHolder extends RecyclerView.ViewHolder {
            public DXWidgetNode a;

            public ItemViewHolder(View view) {
                super(view);
            }
        }

        public ScrollerAdapter(Context context, DXScrollerLayout dXScrollerLayout) {
            this.a = dXScrollerLayout.pipeline;
            this.b = context;
            this.d = dXScrollerLayout;
        }

        @NonNull
        private DXRuntimeContext a(DXWidgetNode dXWidgetNode) {
            DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
            e eVar = new e(cloneWithWidgetNode.getBizType());
            eVar.b = cloneWithWidgetNode.getDxTemplateItem();
            cloneWithWidgetNode.setDxError(eVar);
            return cloneWithWidgetNode;
        }

        private void e(int i, RecyclerView.LayoutParams layoutParams) {
            if (this.d.getOrientation() == 0) {
                if (i == 0) {
                    layoutParams.setMargins(this.d.getPaddingLeft(), this.d.getPaddingTop(), 0, this.d.getPaddingBottom());
                } else if (i == this.c.size() - 1) {
                    layoutParams.setMargins(0, this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
                } else {
                    layoutParams.setMargins(0, this.d.getPaddingTop(), 0, this.d.getPaddingBottom());
                }
            } else if (i == 0) {
                layoutParams.setMargins(this.d.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), 0);
            } else if (i == this.c.size() - 1) {
                layoutParams.setMargins(this.d.getPaddingLeft(), 0, this.d.getPaddingRight(), this.d.getPaddingBottom());
            } else {
                layoutParams.setMargins(this.d.getPaddingLeft(), 0, this.d.getPaddingRight(), 0);
            }
        }

        public DXWidgetNode b(int i) {
            return this.c.get(i);
        }

        public void c(ArrayList<DXWidgetNode> arrayList) {
            this.c = arrayList;
        }

        public void d(boolean z) {
            this.e = z;
        }

        public void f(DXScrollerLayout dXScrollerLayout) {
            this.d = dXScrollerLayout;
            this.a = dXScrollerLayout.pipeline;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<DXWidgetNode> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            DXWidgetNode b2 = b(i);
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            if (at.s0()) {
                this.d.removeAppearWidget(itemViewHolder.a);
            }
            if (this.e) {
                ViewGroup.LayoutParams layoutParams = itemViewHolder.itemView.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    e(i, (RecyclerView.LayoutParams) layoutParams);
                } else {
                    RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(this.d.getMeasuredWidth(), this.d.getMeasuredHeight());
                    itemViewHolder.itemView.setLayoutParams(layoutParams2);
                    e(i, layoutParams2);
                }
            }
            if (itemViewHolder.a != b2 || this.d.ignoreRepeatRender) {
                DXRuntimeContext a2 = a(b2);
                k kVar = this.a;
                View view = viewHolder.itemView;
                DXScrollerLayout dXScrollerLayout = this.d;
                kVar.g(b2, null, view, a2, 2, 8, dXScrollerLayout.oldWidthMeasureSpec, dXScrollerLayout.oldHeightMeasureSpec, i);
                if (a2.hasError()) {
                    DXAppMonitor.o(a2.getDxError(), true);
                }
                itemViewHolder.a = b2;
                this.f.f(i);
                if (b2.getBindingXExecutingMap() != null) {
                    b2.getBindingXExecutingMap().clear();
                }
                b2.sendBroadcastEvent(this.f);
                this.d.postEvent(this.f);
                this.d.addAppearWidget(b2);
                return;
            }
            this.f.f(i);
            if (b2.getBindingXExecutingMap() != null) {
                b2.getBindingXExecutingMap().clear();
            }
            b2.sendBroadcastEvent(this.f);
            this.d.postEvent(this.f);
            this.d.addAppearWidget(b2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            k kVar = this.a;
            if (kVar == null) {
                view = new DXNativeFrameLayout(this.b);
            } else {
                view = kVar.e(this.b);
            }
            return new ItemViewHolder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            this.g.f(viewHolder.getAdapterPosition());
            this.d.postEvent(this.g);
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            DXWidgetNode dXWidgetNode = itemViewHolder.a;
            if (dXWidgetNode != null) {
                dXWidgetNode.sendBroadcastEvent(this.g);
                this.d.removeAppearWidget(itemViewHolder.a);
            }
        }
    }

    /* compiled from: Taobao */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXScrollerLayout();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXScrollerLayout();
    }

    public void closeDefaultAnimator(RecyclerView recyclerView) {
        try {
            recyclerView.getItemAnimator().setAddDuration(0);
            recyclerView.getItemAnimator().setChangeDuration(0);
            recyclerView.getItemAnimator().setMoveDuration(0);
            recyclerView.getItemAnimator().setRemoveDuration(0);
            ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        } catch (Throwable unused) {
        }
    }

    public int getContentOffset() {
        return this.contentOffset;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public int getDefaultValueForIntAttr(long j) {
        if (j == DXSCROLLERLAYOUT_DISABLECONTENTOFFSETRESET || j == DXSCROLLERLAYOUT_ANDROIDFIXSCROLLVERTICALCONFLICT) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if (Constants.Name.CONTENT_OFFSET.equals(str)) {
            return Integer.valueOf(this.contentOffset);
        }
        return super.getNodePropByKey(str);
    }

    public boolean isItemPrefetch() {
        return this.itemPrefetch;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public DXLinearLayoutManager newLinearLayoutManager(Context context) {
        return new DXLinearLayoutManager(context);
    }

    /* access modifiers changed from: protected */
    public ScrollListener newScrollListener() {
        return new ScrollListener();
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXScrollerLayout) {
            DXScrollerLayout dXScrollerLayout = (DXScrollerLayout) dXWidgetNode;
            this.contentOffset = dXScrollerLayout.contentOffset;
            this.itemPrefetch = dXScrollerLayout.itemPrefetch;
            this.openScrollerAnimation = dXScrollerLayout.openScrollerAnimation;
            this.ignoreRepeatRender = dXScrollerLayout.ignoreRepeatRender;
            this.disableContentOffsetReset = dXScrollerLayout.disableContentOffsetReset;
            this.androidFixScrollVerticalConflict = dXScrollerLayout.androidFixScrollVerticalConflict;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        DXNativeRecyclerView dXNativeRecyclerView = new DXNativeRecyclerView(context);
        closeDefaultAnimator(dXNativeRecyclerView);
        return dXNativeRecyclerView;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onRenderView(Context context, View view) {
        DXScrollerLayout dXScrollerLayout;
        super.onRenderView(context, view);
        if ((view instanceof RecyclerView) && (dXScrollerLayout = (DXScrollerLayout) getDXRuntimeContext().getWidgetNode()) != null) {
            DXNativeRecyclerView dXNativeRecyclerView = (DXNativeRecyclerView) view;
            setLayoutManager(context, dXScrollerLayout, dXNativeRecyclerView);
            int i = dXScrollerLayout.contentOffset;
            if (i > -1) {
                if (getOrientation() == 1) {
                    dXNativeRecyclerView.needScrollAfterLayout(0, i, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength);
                } else {
                    dXNativeRecyclerView.needScrollAfterLayout(i, 0, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength);
                }
            }
            dXNativeRecyclerView.setNeedFixScrollConflict(this.androidFixScrollVerticalConflict ? 1 : 0);
            setAdapter(dXScrollerLayout, dXNativeRecyclerView, context);
            setScrollListener(dXScrollerLayout, dXNativeRecyclerView);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public void onSetIntAttribute(long j, int i) {
        if (j == DX_SCROLLER_LAYOUT_CONTENT_OFFSET) {
            this.contentOffset = i;
            return;
        }
        boolean z = false;
        if (j == DX_SCROLLER_LAYOUT_ITEM_PREFETCH) {
            if (i != 0) {
                z = true;
            }
            this.itemPrefetch = z;
        } else if (j == DXSCROLLERLAYOUT_OPENSCROLLERANIMATION) {
            if (i == 1) {
                z = true;
            }
            this.openScrollerAnimation = z;
        } else if (j == DXSCROLLERLAYOUT_IGNOREREPEATRENDER) {
            if (i != 0) {
                z = true;
            }
            this.ignoreRepeatRender = z;
        } else if (j == DXSCROLLERLAYOUT_DISABLECONTENTOFFSETRESET) {
            if (i == 1) {
                z = true;
            }
            this.disableContentOffsetReset = z;
        } else if (j == DXSCROLLERLAYOUT_ANDROIDFIXSCROLLVERTICALCONFLICT) {
            if (i == 1) {
                z = true;
            }
            this.androidFixScrollVerticalConflict = z;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    public void setAdapter(DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView, Context context) {
        ScrollerAdapter scrollerAdapter = (ScrollerAdapter) recyclerView.getAdapter();
        if (scrollerAdapter == null) {
            ScrollerAdapter scrollerAdapter2 = new ScrollerAdapter(context, dXScrollerLayout);
            scrollerAdapter2.setHasStableIds(true);
            scrollerAdapter2.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(scrollerAdapter2);
            return;
        }
        scrollerAdapter.c(dXScrollerLayout.itemWidgetNodes);
        scrollerAdapter.f(dXScrollerLayout);
        if (!this.disableContentOffsetReset && this.contentOffset <= -1) {
            ((DXNativeRecyclerView) recyclerView).needScrollAfterLayout(0, 0, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength);
        }
        scrollerAdapter.notifyDataSetChanged();
    }

    public void setContentOffset(int i) {
        this.contentOffset = i;
    }

    public void setItemPrefetch(boolean z) {
        this.itemPrefetch = z;
    }

    /* access modifiers changed from: protected */
    public void setLayoutManager(Context context, DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        DXLinearLayoutManager dXLinearLayoutManager = (DXLinearLayoutManager) recyclerView.getLayoutManager();
        if (dXLinearLayoutManager == null) {
            dXLinearLayoutManager = newLinearLayoutManager(context);
            recyclerView.setLayoutManager(dXLinearLayoutManager);
        }
        if (getOrientation() == 1) {
            dXLinearLayoutManager.setOrientation(1);
        } else {
            dXLinearLayoutManager.setOrientation(0);
        }
        dXLinearLayoutManager.setItemPrefetchEnabled(dXScrollerLayout.itemPrefetch);
        dXLinearLayoutManager.a(dXScrollerLayout.scrollEnabled);
    }

    /* access modifiers changed from: protected */
    public void setScrollListener(DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        int i = DX_TAG_HAS_SCROLL_LISTENER;
        ScrollListener scrollListener = (ScrollListener) recyclerView.getTag(i);
        if (scrollListener == null) {
            ScrollListener newScrollListener = newScrollListener();
            newScrollListener.j(dXScrollerLayout, recyclerView);
            recyclerView.addOnScrollListener(newScrollListener);
            recyclerView.setTag(i, newScrollListener);
            newScrollListener.c(recyclerView);
            newScrollListener.e();
            return;
        }
        scrollListener.j(dXScrollerLayout, recyclerView);
        scrollListener.c(recyclerView);
        scrollListener.e();
    }
}
