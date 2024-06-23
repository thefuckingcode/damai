package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXScrollLayoutBase;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.loadmore.DXAbsOnLoadMoreView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tb.at;
import tb.dx;
import tb.dz;
import tb.i00;
import tb.ry;
import tb.t10;
import tb.vx;

/* compiled from: Taobao */
public class RecyclerAdapter extends BaseStickyAdapter {
    public static final String LOADMORE_TITLE = "load_more_title";
    public static final String TAG = "RecyclerAdapter";
    public static final int TYPE_FOOTER_VIEW = -1;
    protected k c;
    protected Context d;
    protected ArrayList<DXWidgetNode> e = new ArrayList<>();
    protected dx f;
    protected DXRecyclerLayout g;
    protected t10 h = new t10(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR);
    private t10 i = new t10(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR);
    private boolean j;
    private TextView k;
    View l;
    DXAbsOnLoadMoreView m;
    private ProgressBar n;
    private String o = "太火爆啦，点我再尝试下吧";
    private String p = "";
    private String q = "亲，已经到底了哦";
    private int r = 0;
    private int s = 0;
    private Map<String, Integer> t;
    private Map<Integer, String> u;
    private int v = 1;
    protected boolean w;

    /* compiled from: Taobao */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public DXWidgetNode a;

        public ItemViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            RecyclerAdapter.this.o(view);
        }
    }

    public RecyclerAdapter(Context context, boolean z, boolean z2) {
        this.d = context;
        this.j = z;
        this.t = new HashMap();
        this.u = new HashMap();
        View a2 = i00.a(context, R$layout.dx_scrollable_load_more_bottom);
        this.l = a2;
        this.k = (TextView) a2.findViewById(R$id.scrollable_loadmore_tv);
        this.n = (ProgressBar) this.l.findViewById(R$id.scrollable_loadmore_progressbar);
        this.w = z2;
    }

    private int g() {
        return (!this.j || l()) ? 0 : 1;
    }

    private int k() {
        DXRecyclerLayout dXRecyclerLayout = this.g;
        if (dXRecyclerLayout == null || dXRecyclerLayout.getDXRuntimeContext() == null || this.g.getDXRuntimeContext().getRootView() == null || this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView() == null || this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView().getmChildList() == null) {
            return 0;
        }
        return this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView().getStickyHeight();
    }

    private boolean l() {
        if (this.w) {
            dx dxVar = this.f;
            if (dxVar == null || dxVar.getRealCount() <= 0) {
                return true;
            }
            return false;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean m(int i2) {
        return this.j && i2 >= getItemCount() - g();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(View view) {
        if (3 == this.v) {
            n(-1);
        }
    }

    public void A(int i2) {
        if (this.v != i2) {
            this.v = i2;
            int i3 = this.r;
            if (i3 != 0) {
                this.k.setTextColor(i3);
            }
            int i4 = this.s;
            if (i4 != 0) {
                this.k.setTextSize(0, (float) i4);
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 == 6) {
                                this.n.setVisibility(8);
                                this.k.setText("");
                            }
                        } else if (this.m != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(LOADMORE_TITLE, (Object) this.q);
                            this.m.onLoadMoreStatusUpdate(i2, jSONObject);
                        } else {
                            this.n.setVisibility(8);
                            this.k.setVisibility(0);
                            this.k.setText(this.q);
                        }
                    } else if (this.m != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(LOADMORE_TITLE, (Object) "");
                        this.m.onLoadMoreStatusUpdate(i2, jSONObject2);
                    } else {
                        this.n.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setText("");
                    }
                } else if (this.m != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(LOADMORE_TITLE, (Object) this.o);
                    this.m.onLoadMoreStatusUpdate(i2, jSONObject3);
                } else {
                    this.n.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(this.o);
                }
            } else if (this.m != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(LOADMORE_TITLE, (Object) this.p);
                this.m.onLoadMoreStatusUpdate(i2, jSONObject4);
            } else {
                this.n.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(this.p);
            }
            DXRecyclerLayout dXRecyclerLayout = this.g;
            if (dXRecyclerLayout != null && at.y0(dXRecyclerLayout.getDXRuntimeContext().getBizType()) && this.l != null) {
                ry.g("RLLoadMore", "HitRLLoadMoreGone");
                if (i2 == 6 || i2 == 4 || (i2 == 5 && TextUtils.isEmpty(this.q))) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.BaseStickyAdapter
    public void a(RecyclerView.ViewHolder viewHolder, int i2) {
        Throwable th;
        boolean z;
        FalcoContainerSpan falcoContainerSpan;
        String str;
        DXWidgetNode childAt;
        DXWidgetNode childAt2;
        if (getItemViewType(i2) != -1) {
            FalcoContainerSpan falcoContainerSpan2 = null;
            try {
                DXWidgetNode i3 = i(i2, true);
                if (i3 instanceof DXTemplateWidgetNode) {
                    boolean isFullSpan = ((DXTemplateWidgetNode) i3).isFullSpan();
                    FalcoContainerSpan span = ((DXTemplateWidgetNode) i3).getSpan();
                    str = ((DXTemplateWidgetNode) i3).getTemplateInfo();
                    falcoContainerSpan = span;
                    z = isFullSpan;
                } else {
                    str = "";
                    falcoContainerSpan = null;
                    z = false;
                }
                if (i3 != null) {
                    try {
                        if (this.c != null) {
                            dz.q(falcoContainerSpan, "onBindStart-cellInfo", "  pos  " + i2 + "  itemInfo  " + str + "  rlId  " + this.g.getUserId());
                            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                            DXRuntimeContext e2 = e(i3);
                            DXWidgetNode dXWidgetNode = itemViewHolder.a;
                            if (!(!(dXWidgetNode instanceof DXTemplateWidgetNode) || (childAt = dXWidgetNode.getChildAt(0)) == null || childAt.getDXRuntimeContext() == null || childAt.getDXRuntimeContext().getInstanceId() <= 0 || !(i3 instanceof DXTemplateWidgetNode) || (childAt2 = i3.getChildAt(0)) == null || childAt2.getDXRuntimeContext() == null)) {
                                childAt2.getDXRuntimeContext().setInstanceId(childAt.getDXRuntimeContext().getInstanceId());
                            }
                            int measuredWidth = this.g.getMeasuredWidth();
                            if (!z) {
                                measuredWidth = (((measuredWidth - ((this.g.getColumnCount() - 1) * this.g.getColumnGap())) - this.g.getLeftGap()) - this.g.getRightGap()) / this.g.getColumnCount();
                            } else if (this.g.isEnableLeftGapWhenSingleColumn()) {
                                measuredWidth = (measuredWidth - this.g.getLeftGap()) - this.g.getRightGap();
                            }
                            int c2 = DXWidgetNode.DXMeasureSpec.c(measuredWidth, 1073741824);
                            int c3 = DXWidgetNode.DXMeasureSpec.c(8388607, 0);
                            i3.setLayoutWidth(-1);
                            i3.setLayoutHeight(-2);
                            if (at.A0() && i3.getDXRuntimeContext().isRefreshPart() && viewHolder != null && i3 != ((ItemViewHolder) viewHolder).a) {
                                i3.updateRefreshType(0);
                                e2.setRefreshType(0);
                            }
                            try {
                                this.c.g(i3, null, viewHolder.itemView, e2, 2, 8, c2, c3, i2);
                                if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
                                    if (z) {
                                        ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
                                    } else {
                                        ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(false);
                                    }
                                }
                                if (e2.hasError()) {
                                    DXAppMonitor.o(e2.getDxError(), true);
                                }
                                itemViewHolder.a = i3;
                                this.h.f(i2);
                                if (i3.getBindingXExecutingMap() != null) {
                                    i3.getBindingXExecutingMap().clear();
                                }
                                i3.sendBroadcastEvent(this.h);
                                this.g.postEvent(this.h);
                                this.g.addAppearWidget(i3);
                                View view = viewHolder.itemView;
                                if (view != null) {
                                    if ((view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0) {
                                        falcoContainerSpan2 = falcoContainerSpan;
                                        dz.p(falcoContainerSpan2, "onBindEnd", System.currentTimeMillis());
                                        if (at.A0() && i3.getDXRuntimeContext().isRefreshPart()) {
                                            i3.updateRefreshType(0);
                                        }
                                        dz.l(falcoContainerSpan2);
                                    }
                                }
                                this.g.trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BINDHOLDER, "onbindViewholder返回的view是空");
                                falcoContainerSpan2 = falcoContainerSpan;
                                dz.o(falcoContainerSpan2, "onbindViewholder返回的view是空: " + i2);
                                dz.p(falcoContainerSpan2, "onBindEnd", System.currentTimeMillis());
                                i3.updateRefreshType(0);
                            } catch (Throwable th2) {
                                th = th2;
                                falcoContainerSpan2 = falcoContainerSpan;
                                try {
                                    e eVar = new e(WXBasicComponentType.RECYCLER);
                                    e.a aVar = new e.a("DX_RECYCLER", "DX_RECYCLER_BIND", e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BIND);
                                    aVar.e = vx.a(th);
                                    eVar.c.add(aVar);
                                    DXAppMonitor.n(eVar);
                                    vx.b(th);
                                    dz.o(falcoContainerSpan2, "onbindViewholder 发生 exception" + i2);
                                    dz.l(falcoContainerSpan2);
                                    n(i2);
                                } catch (Throwable th3) {
                                    dz.l(falcoContainerSpan2);
                                    throw th3;
                                }
                            }
                            dz.l(falcoContainerSpan2);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        falcoContainerSpan2 = falcoContainerSpan;
                        e eVar2 = new e(WXBasicComponentType.RECYCLER);
                        e.a aVar2 = new e.a("DX_RECYCLER", "DX_RECYCLER_BIND", e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BIND);
                        aVar2.e = vx.a(th);
                        eVar2.c.add(aVar2);
                        DXAppMonitor.n(eVar2);
                        vx.b(th);
                        dz.o(falcoContainerSpan2, "onbindViewholder 发生 exception" + i2);
                        dz.l(falcoContainerSpan2);
                        n(i2);
                    }
                }
                ry.g(TAG, "get item null!");
                dz.o(falcoContainerSpan, "get item null!");
                dz.l(falcoContainerSpan);
                return;
            } catch (Throwable th5) {
                th = th5;
                e eVar22 = new e(WXBasicComponentType.RECYCLER);
                e.a aVar22 = new e.a("DX_RECYCLER", "DX_RECYCLER_BIND", e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BIND);
                aVar22.e = vx.a(th);
                eVar22.c.add(aVar22);
                DXAppMonitor.n(eVar22);
                vx.b(th);
                dz.o(falcoContainerSpan2, "onbindViewholder 发生 exception" + i2);
                dz.l(falcoContainerSpan2);
                n(i2);
            }
        }
        n(i2);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public DXRuntimeContext e(DXWidgetNode dXWidgetNode) {
        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
        e eVar = new e(cloneWithWidgetNode.getBizType());
        eVar.b = cloneWithWidgetNode.getDxTemplateItem();
        cloneWithWidgetNode.setDxError(eVar);
        return cloneWithWidgetNode;
    }

    /* access modifiers changed from: protected */
    public int f() {
        if (this.w) {
            dx dxVar = this.f;
            if (dxVar == null) {
                return 0;
            }
            return dxVar.getRealCount();
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size;
        int g2;
        if (this.w) {
            dx dxVar = this.f;
            if (dxVar == null || (size = dxVar.getRealCount()) <= 0) {
                return 0;
            }
            g2 = g();
        } else {
            ArrayList<DXWidgetNode> arrayList = this.e;
            if (arrayList == null || arrayList.isEmpty()) {
                return 0;
            }
            size = this.e.size();
            g2 = g();
        }
        return size + g2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        if (m(i2)) {
            return 2147483647L;
        }
        return (long) i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter, com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public int getItemViewType(int i2) {
        String str;
        if (m(i2)) {
            return -1;
        }
        DXWidgetNode i3 = i(i2, true);
        if (i3 instanceof DXTemplateWidgetNode) {
            DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) i3;
            if (!TextUtils.isEmpty(dXTemplateWidgetNode.getReuseIdentifier())) {
                str = dXTemplateWidgetNode.getReuseIdentifier();
            } else {
                str = dXTemplateWidgetNode.getTemplateInfo();
            }
            if (this.t.containsKey(str)) {
                return this.t.get(str).intValue();
            }
            int size = this.t.size();
            this.t.put(str, Integer.valueOf(size));
            this.u.put(Integer.valueOf(size), str);
            return size;
        } else if (this.t.containsKey("default")) {
            return this.t.get("default").intValue();
        } else {
            int size2 = this.t.size();
            this.t.put("default", Integer.valueOf(size2));
            this.u.put(Integer.valueOf(size2), "default");
            return size2;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public int getStickyOffset(int i2) {
        int stickyPosition;
        if (isSticky(i2)) {
            DXWidgetNode h2 = h(i2);
            if (h2 instanceof DXTemplateWidgetNode) {
                return ((DXTemplateWidgetNode) h2).getStickyOffset();
            }
            return 0;
        } else if (!hasPreSticky(i2) || (stickyPosition = getStickyPosition(i2)) < 0) {
            return 0;
        } else {
            DXWidgetNode h3 = h(stickyPosition);
            if (h3 instanceof DXTemplateWidgetNode) {
                return ((DXTemplateWidgetNode) h3).getStickyOffset();
            }
            return 0;
        }
    }

    public DXWidgetNode h(int i2) {
        return i(i2, false);
    }

    public DXWidgetNode i(int i2, boolean z) {
        if (this.w) {
            dx dxVar = this.f;
            if (dxVar == null) {
                return null;
            }
            DXWidgetNode item = dxVar.getItem(i2);
            if (item == null && z && this.g != null && this.f.e() != null) {
                if (i2 < 0 || i2 >= this.f.e().size()) {
                    return null;
                }
                Object obj = this.f.e().get(i2);
                dx dxVar2 = this.f;
                item = dxVar2.b(this.g, obj, dxVar2.e(), this.g.getOriginWidgetNodes(), i2, null);
            }
            if (item != null) {
                this.f.addItem(i2, item);
            }
            return item;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.e.get(i2);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public boolean isSticky(int i2) {
        DXWidgetNode h2 = h(i2);
        if (h2 instanceof DXTemplateWidgetNode) {
            return ((DXTemplateWidgetNode) h2).isSticky();
        }
        return false;
    }

    public DXRecyclerLayout j() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public void n(int i2) {
        int i3;
        int i4;
        if (this.j && (i3 = this.v) != 2 && i3 != 5 && !l() && this.g != null && (i4 = this.v) != 6 && i4 != 2) {
            if (i2 < 0) {
                A(2);
                this.g.onLoadMore();
            } else if (i2 > 0 && getItemCount() - (i2 + 1) <= this.g.getEndReachedThreshold()) {
                A(2);
                this.g.onLoadMore();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter, com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        k kVar;
        if (i2 == -1) {
            RelativeLayout relativeLayout = new RelativeLayout(this.d);
            DXAbsOnLoadMoreView dXAbsOnLoadMoreView = this.m;
            if (dXAbsOnLoadMoreView != null) {
                relativeLayout.addView(dXAbsOnLoadMoreView, new ViewGroup.LayoutParams(-1, -2));
            } else {
                View view2 = this.l;
                if (view2 != null) {
                    relativeLayout.addView(view2, new ViewGroup.LayoutParams(-1, -2));
                }
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = k();
            layoutParams.setFullSpan(true);
            relativeLayout.setLayoutParams(layoutParams);
            ItemViewHolder itemViewHolder = new ItemViewHolder(relativeLayout);
            relativeLayout.setOnClickListener(new a());
            return itemViewHolder;
        }
        if (!this.g.isEnableVideoControl() || (kVar = this.c) == null) {
            view = new DXNativeFrameLayout(this.d);
        } else {
            view = kVar.e(this.d);
        }
        view.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
        return new ItemViewHolder(view);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public void onStickyChange(int i2, boolean z) {
        DXWidgetNode h2 = h(i2);
        if (h2 instanceof DXTemplateWidgetNode) {
            ((DXTemplateWidgetNode) h2).triggerOnStickyChange(i2, z);
        }
        this.g.triggerOnStickyChange(i2, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.i.f(viewHolder.getAdapterPosition());
        this.g.postEvent(this.i);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        DXWidgetNode dXWidgetNode = itemViewHolder.a;
        if (dXWidgetNode != null) {
            dXWidgetNode.sendBroadcastEvent(this.i);
            this.g.removeAppearWidget(itemViewHolder.a);
            if (itemViewHolder.a.getDXRuntimeContext() != null && itemViewHolder.a.getDXRuntimeContext().getEngineContext() != null && itemViewHolder.a.getDXRuntimeContext().getEngineContext().e() != null && itemViewHolder.a.getDXRuntimeContext().getEngineContext().e().j() != null) {
                itemViewHolder.a.getDXRuntimeContext().getEngineContext().e().j().destroy(itemViewHolder.a.getDXRuntimeContext().getInstanceId());
            }
        }
    }

    public void p(ArrayList<DXWidgetNode> arrayList) {
        this.e = arrayList;
        c();
    }

    public void q(List<DXWidgetNode> list) {
        p((ArrayList) list);
    }

    public void r(dx dxVar) {
        this.f = dxVar;
        c();
    }

    /* access modifiers changed from: protected */
    public void s(int i2, DXWidgetNode dXWidgetNode) {
        if (this.w) {
            dx dxVar = this.f;
            if (dxVar != null) {
                dxVar.setItem(i2, dXWidgetNode);
                return;
            }
            return;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList != null && i2 >= 0 && i2 < arrayList.size()) {
            this.e.set(i2, dXWidgetNode);
        }
    }

    public void t(String str) {
        this.o = str;
    }

    public void u(String str) {
        this.p = str;
    }

    public void v(String str) {
        this.q = str;
    }

    public void w(int i2) {
        this.r = i2;
    }

    public void x(int i2) {
        this.s = i2;
    }

    public void y(boolean z) {
        this.j = z;
    }

    public void z(DXRecyclerLayout dXRecyclerLayout) {
        this.g = dXRecyclerLayout;
        if (dXRecyclerLayout != null && this.c == null) {
            this.c = new k(dXRecyclerLayout.getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString(), dXRecyclerLayout.isEnableVideoControl());
            if (dXRecyclerLayout.getDXRuntimeContext().getEngineContext().b() != null) {
                dXRecyclerLayout.getDXRuntimeContext().getEngineContext().b().c();
            }
        }
    }
}
