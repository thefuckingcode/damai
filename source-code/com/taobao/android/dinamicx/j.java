package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.m00;

/* compiled from: Taobao */
public class j extends DXRenderPipelineFlow {
    protected m j = new m();
    protected g k = new g();
    protected m00 l = new m00();

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public DXWidgetNode h() {
        DXWidgetNode dXWidgetNode;
        if (this.e == null || (dXWidgetNode = this.f) == null || this.d == null) {
            return null;
        }
        return dXWidgetNode;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public DXWidgetNode i() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        boolean z = false;
        if (!(dXRuntimeContext.getEngineContext() == null || this.g.getEngineContext().b() == null)) {
            z = this.g.getEngineContext().b().m();
        }
        return this.k.b(this.e, this.g, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public DXWidgetNode j() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        this.k.c(dXWidgetNode, dXRuntimeContext);
        return this.e;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public DXWidgetNode l() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        this.k.d(dXWidgetNode, this.h, this.i, dXRuntimeContext);
        return this.e;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public DXWidgetNode m() {
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || this.g == null) {
            return dXWidgetNode;
        }
        if (this.b == 1) {
            this.j.d(dXWidgetNode);
        } else {
            this.j.f(dXWidgetNode);
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    public View n() {
        DXWidgetNode dXWidgetNode;
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode2 = this.e;
        if (dXWidgetNode2 == null || (dXWidgetNode = this.f) == null || (dXRuntimeContext = this.g) == null) {
            return null;
        }
        return this.l.d(dXWidgetNode2, dXWidgetNode, this.d, dXRuntimeContext, 1);
    }
}
