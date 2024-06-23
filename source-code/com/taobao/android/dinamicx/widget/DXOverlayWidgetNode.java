package com.taobao.android.dinamicx.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.data.Constants;
import tb.d10;
import tb.h;
import tb.l;
import tb.lx;
import tb.q0;
import tb.r;
import tb.ry;
import tb.v;
import tb.w;

/* compiled from: Taobao */
public class DXOverlayWidgetNode extends f {
    public static final long DXOVERLAY_ANIMATION = -60331626368423735L;
    public static final long DXOVERLAY_ANIMATIONTYPE = -7121038128194277777L;
    public static final long DXOVERLAY_EXITANIMATION = -5767894532178812313L;
    public static final long DXOVERLAY_MASK = 36153551024L;
    public static final long DXOVERLAY_MASKANIMATION = 5065226854897227865L;
    public static final long DXOVERLAY_MASKCOLOR = -2639343862509521740L;
    public static final long DXOVERLAY_NODEREF = 5139463086743887818L;
    public static final long DXOVERLAY_ONCLOSE = 5176469550471315930L;
    public static final long DXOVERLAY_OVERLAY = 3988216987803710313L;
    public static final long DXOVERLAY_POSITION = 5584520067254839933L;
    public static final long DXOVERLAY_SHOW = 37892802069L;
    public static final long DXOVERLAY_TYPE = 38200462374L;
    public static final long DXOVERLAY_ZINDEX = 10650399930384760L;
    private boolean a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private String g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    h l;
    private JSONArray m;
    private DXTemplateWidgetNode n;
    private boolean o = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements AKIAbilityCallback {
        a() {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
            if ("onClose".equals(str)) {
                DXOverlayWidgetNode.this.c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements AKIAbilityCallback {
        b(DXOverlayWidgetNode dXOverlayWidgetNode) {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
            ry.s("dismiss pop " + str);
        }
    }

    /* compiled from: Taobao */
    public static class c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXOverlayWidgetNode();
        }
    }

    private void b() {
        if (this.l == null) {
            if (!(getDXRuntimeContext() == null || getDXRuntimeContext().getEngineContext() == null || getDXRuntimeContext().getEngineContext().b() == null)) {
                this.l = getDXRuntimeContext().getEngineContext().b().a();
            }
            if (this.l == null) {
                this.l = new h();
            }
        }
        DXTemplateWidgetNode dXTemplateWidgetNode = this.n;
        if (dXTemplateWidgetNode != null) {
            String str = "";
            String name = dXTemplateWidgetNode.getName() != null ? this.n.getName() : str;
            if (this.n.getVersion() != null) {
                str = this.n.getVersion();
            }
            String str2 = name + JSMethod.NOT_SET + str;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "dismissDxPop");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(w.KEY_POP_ID, (Object) str2);
            jSONObject.put("params", (Object) jSONObject2);
            r rVar = new r(jSONObject);
            d10 d10 = new d10();
            d10.d(this.l);
            d10.i(getDXRuntimeContext().getRootView());
            d10.e(getDXRuntimeContext().getContext());
            d10.g(((Activity) getDXRuntimeContext().getContext()).getWindow().getDecorView());
            this.l.b(rVar, d10, new b(this));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        postEvent(new lx(DXOVERLAY_ONCLOSE));
        this.o = false;
        if (getChildAt(0) != null && getChildAt(0).getDXRuntimeContext() != null && getDXRuntimeContext() != null && getDXRuntimeContext().getEngineContext() != null && getDXRuntimeContext().getEngineContext().e() != null && getDXRuntimeContext().getEngineContext().e().j() != null) {
            getDXRuntimeContext().getEngineContext().e().j().destroy(getChildAt(0).getDXRuntimeContext().getInstanceId());
        }
    }

    private void d() {
        if (this.l == null) {
            if (!(getDXRuntimeContext() == null || getDXRuntimeContext().getEngineContext() == null || getDXRuntimeContext().getEngineContext().b() == null)) {
                this.l = getDXRuntimeContext().getEngineContext().b().a();
            }
            if (this.l == null) {
                this.l = new h();
                this.l.h(new q0(getDXRuntimeContext().getBizType(), "DX"));
            }
        }
        DXTemplateWidgetNode dXTemplateWidgetNode = this.n;
        if (dXTemplateWidgetNode != null && !this.o) {
            String str = "";
            String name = dXTemplateWidgetNode.getName() != null ? this.n.getName() : str;
            if (this.n.getVersion() != null) {
                str = this.n.getVersion();
            }
            Object obj = name + JSMethod.NOT_SET + str;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "showDxPop");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(w.KEY_POP_ID, obj);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(v.TAK_ABILITY_SHOW_POP_ANIMATION, (Object) "bottomInOut");
            jSONObject3.put(v.TAK_ABILITY_SHOW_POP_BACKGROUND_MODE, (Object) Integer.valueOf(this.f));
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("name", (Object) name);
            jSONObject5.put("version", (Object) str);
            jSONObject5.put("url", (Object) this.n.getUrl());
            jSONObject4.put(Constants.TEMPLATE, (Object) jSONObject5);
            jSONObject4.put("data", (Object) getDXRuntimeContext().getData());
            jSONObject4.put(w.KEY_POP_ID, obj);
            jSONObject2.put("popConfig", (Object) jSONObject3);
            jSONObject2.put(v.TAK_ABILITY_SHOW_POP_ANIMATION, "bottomInOut");
            jSONObject2.put("content", (Object) jSONObject4);
            jSONObject2.put("gravity", getLayoutGravity() == 4 ? "center" : "bottom");
            jSONObject.put("params", (Object) jSONObject2);
            r rVar = new r(jSONObject);
            d10 d10 = new d10();
            d10.d(this.l);
            d10.i(getDXRuntimeContext().getRootView());
            d10.e(getDXRuntimeContext().getContext());
            d10.g(((Activity) getDXRuntimeContext().getContext()).getWindow().getDecorView());
            this.l.b(rVar, d10, new a());
            this.o = true;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXOverlayWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.m == null) {
            this.m = new JSONArray() {
                /* class com.taobao.android.dinamicx.widget.DXOverlayWidgetNode.AnonymousClass3 */

                {
                    add("dismiss");
                }
            };
            this.m.addAll(super.exportMethods());
        }
        return this.m;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        str.hashCode();
        if (!str.equals("dismiss")) {
            return super.invokeRefMethod(str, jSONArray);
        }
        b();
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (getChildrenCount() > 0 && (getChildAt(0) instanceof DXTemplateWidgetNode)) {
            this.n = (DXTemplateWidgetNode) getChildAt(0);
        }
        super.onBeforeBindChildData();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j2) {
        super.onBindEvent(context, view, j2);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof DXOverlayWidgetNode)) {
            super.onClone(dXWidgetNode, z);
            DXOverlayWidgetNode dXOverlayWidgetNode = (DXOverlayWidgetNode) dXWidgetNode;
            this.a = dXOverlayWidgetNode.a;
            this.b = dXOverlayWidgetNode.b;
            this.c = dXOverlayWidgetNode.c;
            this.d = dXOverlayWidgetNode.d;
            this.e = dXOverlayWidgetNode.e;
            this.f = dXOverlayWidgetNode.f;
            this.g = dXOverlayWidgetNode.g;
            this.h = dXOverlayWidgetNode.h;
            this.i = dXOverlayWidgetNode.i;
            this.j = dXOverlayWidgetNode.j;
            this.k = dXOverlayWidgetNode.k;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        this.layoutHeight = 0;
        this.layoutWidth = 0;
        return super.onCreateView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (this.i) {
            d();
        }
        super.onRenderView(context, view);
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        boolean z = true;
        if (j2 == DXOVERLAY_ANIMATION) {
            if (i2 == 0) {
                z = false;
            }
            this.a = z;
        } else if (j2 == DXOVERLAY_ANIMATIONTYPE) {
            this.b = i2;
        } else if (j2 == DXOVERLAY_EXITANIMATION) {
            if (i2 == 0) {
                z = false;
            }
            this.c = z;
        } else if (j2 == DXOVERLAY_MASK) {
            if (i2 == 0) {
                z = false;
            }
            this.d = z;
        } else if (j2 == DXOVERLAY_MASKANIMATION) {
            if (i2 == 0) {
                z = false;
            }
            this.e = z;
        } else if (j2 == DXOVERLAY_MASKCOLOR) {
            this.f = i2;
        } else if (j2 == DXOVERLAY_POSITION) {
            this.h = i2;
        } else if (j2 == DXOVERLAY_SHOW) {
            if (i2 == 0) {
                z = false;
            }
            this.i = z;
        } else if (j2 == 38200462374L) {
            this.j = i2;
        } else if (j2 == DXOVERLAY_ZINDEX) {
            this.k = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (j2 == DXOVERLAY_NODEREF) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
