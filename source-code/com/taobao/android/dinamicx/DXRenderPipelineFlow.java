package com.taobao.android.dinamicx;

import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.vx;

/* compiled from: Taobao */
public class DXRenderPipelineFlow {
    public static final int DX_PIPELINE_MODE_RENDER = 0;
    public static final int DX_PIPELINE_MODE_SIZE = 1;
    private RenderPipelineFlowListener a;
    protected int b;
    protected int c;
    protected View d;
    protected DXWidgetNode e;
    protected DXWidgetNode f;
    protected DXRuntimeContext g;
    protected int h;
    protected int i;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXPipelineMode {
    }

    /* compiled from: Taobao */
    public interface RenderPipelineFlowListener {
        void renderDidDiff();

        void renderDidFlatten();

        void renderDidLayout();

        void renderDidLoad();

        void renderDidMeasure();

        void renderDidParse();

        void renderDidRender();

        void renderWillDiff();

        void renderWillFlatten();

        void renderWillLayout();

        void renderWillLoad();

        void renderWillMeasure();

        void renderWillParse();

        void renderWillRender();
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode a() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillDiff();
        }
        this.f = h();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidDiff();
        }
        return this.f;
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode b() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillFlatten();
        }
        this.f = i();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidFlatten();
        }
        return this.f;
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode c() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillLayout();
        }
        this.e = j();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidLayout();
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode d() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillLoad();
        }
        this.e = k();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidLoad();
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode e() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillMeasure();
        }
        this.e = l();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidMeasure();
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final DXWidgetNode f() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillParse();
        }
        this.e = m();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidParse();
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final View g() {
        RenderPipelineFlowListener renderPipelineFlowListener = this.a;
        if (renderPipelineFlowListener != null) {
            renderPipelineFlowListener.renderWillRender();
        }
        this.d = n();
        RenderPipelineFlowListener renderPipelineFlowListener2 = this.a;
        if (renderPipelineFlowListener2 != null) {
            renderPipelineFlowListener2.renderDidRender();
        }
        return this.d;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode h() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode i() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode j() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode k() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode l() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public DXWidgetNode m() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public View n() {
        throw null;
    }

    public void o(int i2, int i3, @Nullable DXRenderOptions dXRenderOptions) {
        boolean z;
        if (i2 <= i3) {
            try {
                this.c = i2;
                while (this.c <= i3) {
                    if (dXRenderOptions != null) {
                        if (dXRenderOptions.e() != 1) {
                            if (dXRenderOptions.e() != 2) {
                                z = false;
                                if (z && dXRenderOptions.i()) {
                                    return;
                                }
                            }
                        }
                        z = true;
                        return;
                    }
                    switch (this.c) {
                        case 0:
                        case 1:
                            if (d() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 2:
                            if (f() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 3:
                            if (e() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 4:
                            if (c() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 5:
                            if (b() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 6:
                            if (a() != null) {
                                break;
                            } else {
                                return;
                            }
                        case 7:
                            if (g() != null) {
                                break;
                            } else {
                                return;
                            }
                    }
                    this.c++;
                }
            } catch (Throwable th) {
                e.a aVar = new e.a("Pipeline", "SIMPLE_PIPELINE_CRASH", e.DX_SIMPLE_PIPELINE_CRASH);
                aVar.e = vx.a(th);
                DXRuntimeContext dXRuntimeContext = this.g;
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && this.g.getDxError().c != null) {
                    this.g.getDxError().c.add(aVar);
                }
            }
        }
    }
}
