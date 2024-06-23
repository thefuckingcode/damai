package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.model.DXPools$DXPoolItem;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.kz;
import tb.os;
import tb.r10;
import tb.s10;
import tb.ty;
import tb.v00;
import tb.vx;

/* compiled from: Taobao */
public class DXRootView extends DXNativeFrameLayout implements DXPools$DXPoolItem {
    List<DXWidgetNode> animationWidgets;
    WeakReference<os> bindingXManagerWeakReference;
    JSONObject data;
    DXNestedScrollerView dxNestedScrollerView;
    DXTemplateItem dxTemplateItem;
    int parentHeightSpec;
    int parentWidthSpec;
    private int position;
    a rootViewLifeCycle;

    /* compiled from: Taobao */
    public static abstract class a {
        public void a(int i) {
        }

        public void b(DXRootView dXRootView, int i) {
            a(i);
        }

        /* access modifiers changed from: protected */
        public abstract void c(DXRootView dXRootView);

        /* access modifiers changed from: protected */
        public abstract void d(DXRootView dXRootView);

        /* access modifiers changed from: protected */
        public void e() {
        }

        /* access modifiers changed from: protected */
        public void f(DXRootView dXRootView) {
            e();
        }

        /* access modifiers changed from: protected */
        public void g() {
        }

        /* access modifiers changed from: protected */
        public void h(DXRootView dXRootView) {
            g();
        }

        /* access modifiers changed from: protected */
        public abstract void i(@NonNull View view, int i);

        /* access modifiers changed from: protected */
        public abstract void j(DXRootView dXRootView, int i);
    }

    DXRootView(@NonNull Context context) {
        super(context);
    }

    private void trackError(int i, Throwable th) {
        vx.b(th);
        String str = getBindingXManager() != null ? getBindingXManager().b : null;
        if (TextUtils.isEmpty(str)) {
            str = v00.DB_NAME;
        }
        DXAppMonitor.q(str, getDxTemplateItem(), "native", "native_crash", i, vx.a(th));
    }

    public void _addAnimationWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            if (this.animationWidgets == null) {
                this.animationWidgets = new ArrayList();
            }
            if (!this.animationWidgets.contains(dXWidgetNode)) {
                this.animationWidgets.add(dXWidgetNode);
            }
        }
    }

    public void _clearAnimationWidgets() {
        this.animationWidgets = new ArrayList();
    }

    public boolean _containAnimationWidget(DXWidgetNode dXWidgetNode) {
        List<DXWidgetNode> list;
        if (dXWidgetNode == null || (list = this.animationWidgets) == null || list.size() == 0) {
            return false;
        }
        return this.animationWidgets.contains(dXWidgetNode);
    }

    public List<DXWidgetNode> _getAnimationWidgets() {
        return this.animationWidgets;
    }

    public void _removeAnimationWidget(DXWidgetNode dXWidgetNode) {
        List<DXWidgetNode> list = this.animationWidgets;
        if (list != null) {
            list.remove(dXWidgetNode);
        }
    }

    public void dispatchWindowVisibilityChanged(int i) {
        try {
            super.dispatchWindowVisibilityChanged(i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.b(this, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_7, th);
        }
    }

    public os getBindingXManager() {
        WeakReference<os> weakReference = this.bindingXManagerWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public JSONObject getData() {
        return this.data;
    }

    public DXNestedScrollerView getDxNestedScrollerView() {
        if (this.dxNestedScrollerView == null) {
            this.dxNestedScrollerView = new DXNestedScrollerView(getContext());
        }
        return this.dxNestedScrollerView;
    }

    public DXTemplateItem getDxTemplateItem() {
        return this.dxTemplateItem;
    }

    public DXWidgetNode getExpandWidgetNode() {
        return (DXWidgetNode) getTag(kz.a);
    }

    public DXWidgetNode getFlattenWidgetNode() {
        return (DXWidgetNode) getTag(DXWidgetNode.TAG_WIDGET_NODE);
    }

    @Override // com.taobao.android.dinamicx.model.DXPools$DXPoolItem
    public Object getKey() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasDXRootViewLifeCycle() {
        return this.rootViewLifeCycle != null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_11, th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.d(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_10, th);
        }
    }

    public void onFinishTemporaryDetach() {
        try {
            super.onFinishTemporaryDetach();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.f(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_13, th);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRootViewAppear(int i) {
        r10 r10 = new r10(5288671110273408574L);
        r10.f(i);
        DXWidgetNode expandWidgetNode = getExpandWidgetNode();
        if (expandWidgetNode != null) {
            expandWidgetNode.sendBroadcastEvent(r10);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRootViewDisappear(int i) {
        s10 s10 = new s10(5388973340095122049L);
        s10.f(i);
        DXWidgetNode expandWidgetNode = getExpandWidgetNode();
        if (expandWidgetNode != null) {
            expandWidgetNode.sendBroadcastEvent(s10);
        }
    }

    public void onStartTemporaryDetach() {
        try {
            super.onStartTemporaryDetach();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.h(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_12, th);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        try {
            super.onVisibilityChanged(view, i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.i(view, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_9, th);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.j(this, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_8, th);
        }
    }

    public void postMessage(Object obj) {
        JSONObject jSONObject;
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                String string = jSONObject2.getString("type");
                if (!"BNDX".equalsIgnoreCase(string) || getBindingXManager() == null) {
                    DXWidgetNode expandWidgetNode = getExpandWidgetNode();
                    if (expandWidgetNode != null && (jSONObject = jSONObject2.getJSONObject("params")) != null) {
                        String string2 = jSONObject.getString("targetId");
                        ty tyVar = new ty(-1747756056147111305L);
                        tyVar.j(jSONObject);
                        tyVar.k(string2);
                        tyVar.l(string);
                        DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId(string2);
                        if (queryWidgetNodeByUserId == null || queryWidgetNodeByUserId.getReferenceNode() == null) {
                            expandWidgetNode.sendBroadcastEvent(tyVar);
                        } else {
                            queryWidgetNodeByUserId.postEvent(tyVar);
                        }
                    }
                } else {
                    getBindingXManager().m(this, jSONObject2);
                }
            }
        } catch (Throwable th) {
            vx.b(th);
            String str = null;
            if (getBindingXManager() != null) {
                str = getBindingXManager().b;
            }
            if (TextUtils.isEmpty(str)) {
                str = v00.DB_NAME;
            }
            DXAppMonitor.q(str, null, "DX_BindingX", "DX_BindingX_Crash", e.BINDINGX_POST_MSG_CRASH, vx.a(th));
        }
    }

    /* access modifiers changed from: package-private */
    public void registerDXRootViewLifeCycle(a aVar) {
        this.rootViewLifeCycle = aVar;
    }

    public void setBindingXManagerWeakReference(os osVar) {
        this.bindingXManagerWeakReference = new WeakReference<>(osVar);
    }

    /* access modifiers changed from: package-private */
    public void setExpandWidgetNode(DXWidgetNode dXWidgetNode) {
        setTag(kz.a, dXWidgetNode);
    }

    /* access modifiers changed from: package-private */
    public void setFlattenWidgetNode(DXWidgetNode dXWidgetNode) {
        setTag(DXWidgetNode.TAG_WIDGET_NODE, dXWidgetNode);
    }

    public void setMeasureDimension(int i, int i2) {
        setMeasuredDimension(i, i2);
    }

    public void setPosition(int i) {
        this.position = i;
    }

    DXRootView(@NonNull Context context, DXWidgetNode dXWidgetNode) {
        super(context);
        setExpandWidgetNode(dXWidgetNode);
    }
}
