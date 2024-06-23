package com.youku.gaiax.impl.register;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.pp0;
import tb.qp0;
import tb.rp0;
import tb.sp0;
import tb.up0;
import tb.wq0;
import tb.xo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ6\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/youku/gaiax/impl/register/GXMixNodeEvent;", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "gestureParams", "Ltb/ur2;", "initViewEventListener", "initViewClickEventDispatcher", "initViewLongClickEventDispatcher", "dispatcherClick", "dispatcherLongClick", "", "componentId", "", "eventType", "removeJSEvent", "Ltb/wq0;", "gxTemplateContext", "Ltb/up0;", "gxNode", "", "optionCover", "", "optionLevel", "addJSEvent", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "addDataBindingEvent", "Landroid/view/View$OnClickListener;", "onClickListener", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "clickEventByDataBinding", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "clickEventByJS", "Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "longClickEventByDataBinding", "longClickEventByJS", "<init>", "()V", "GXJSGesture", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXMixNodeEvent implements GXINodeEvent {
    @Nullable
    private GXTemplateEngine.d clickEventByDataBinding;
    @Nullable
    private GXJSGesture clickEventByJS;
    @Nullable
    private wq0 gxTemplateContext;
    @Nullable
    private GXTemplateEngine.d longClickEventByDataBinding;
    @Nullable
    private GXJSGesture longClickEventByJS;
    @Nullable
    private View.OnClickListener onClickListener;
    @Nullable
    private View.OnLongClickListener onLongClickListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "", "jsOptionLevel", "I", "getJsOptionLevel", "()I", "setJsOptionLevel", "(I)V", "", "jsOptionCover", "Z", "getJsOptionCover", "()Z", "setJsOptionCover", "(Z)V", "", "jsComponentId", "J", "getJsComponentId", "()J", "setJsComponentId", "(J)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GXJSGesture extends GXTemplateEngine.d {
        private long jsComponentId = -1;
        private boolean jsOptionCover;
        private int jsOptionLevel;

        public final long getJsComponentId() {
            return this.jsComponentId;
        }

        public final boolean getJsOptionCover() {
            return this.jsOptionCover;
        }

        public final int getJsOptionLevel() {
            return this.jsOptionLevel;
        }

        public final void setJsComponentId(long j) {
            this.jsComponentId = j;
        }

        public final void setJsOptionCover(boolean z) {
            this.jsOptionCover = z;
        }

        public final void setJsOptionLevel(int i) {
            this.jsOptionLevel = i;
        }
    }

    private final void dispatcherClick() {
        wq0 wq0;
        GXTemplateEngine.g j;
        GXTemplateEngine.GXIEventListener c;
        wq0 wq02;
        GXTemplateEngine.g j2;
        GXTemplateEngine.GXIEventListener c2;
        wq0 wq03;
        GXTemplateEngine.g j3;
        GXTemplateEngine.GXIEventListener c3;
        GXJSGesture gXJSGesture = this.clickEventByJS;
        GXTemplateEngine.d dVar = this.clickEventByDataBinding;
        if (gXJSGesture != null) {
            if (gXJSGesture.getJsOptionCover()) {
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            } else if (gXJSGesture.getJsOptionLevel() == 0) {
                if (!(dVar == null || (wq03 = this.gxTemplateContext) == null || (j3 = wq03.j()) == null || (c3 = j3.c()) == null)) {
                    c3.onGestureEvent(dVar);
                }
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            } else {
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
                if (dVar != null && (wq02 = this.gxTemplateContext) != null && (j2 = wq02.j()) != null && (c2 = j2.c()) != null) {
                    c2.onGestureEvent(dVar);
                }
            }
        } else if (dVar != null && (wq0 = this.gxTemplateContext) != null && (j = wq0.j()) != null && (c = j.c()) != null) {
            c.onGestureEvent(dVar);
        }
    }

    private final void dispatcherLongClick() {
        wq0 wq0;
        GXTemplateEngine.g j;
        GXTemplateEngine.GXIEventListener c;
        wq0 wq02;
        GXTemplateEngine.g j2;
        GXTemplateEngine.GXIEventListener c2;
        wq0 wq03;
        GXTemplateEngine.g j3;
        GXTemplateEngine.GXIEventListener c3;
        GXJSGesture gXJSGesture = this.longClickEventByJS;
        GXTemplateEngine.d dVar = this.longClickEventByDataBinding;
        if (gXJSGesture != null) {
            if (gXJSGesture.getJsOptionCover()) {
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            } else if (gXJSGesture.getJsOptionLevel() == 0) {
                if (!(dVar == null || (wq03 = this.gxTemplateContext) == null || (j3 = wq03.j()) == null || (c3 = j3.c()) == null)) {
                    c3.onGestureEvent(dVar);
                }
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            } else {
                GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
                if (dVar != null && (wq02 = this.gxTemplateContext) != null && (j2 = wq02.j()) != null && (c2 = j2.c()) != null) {
                    c2.onGestureEvent(dVar);
                }
            }
        } else if (dVar != null && (wq0 = this.gxTemplateContext) != null && (j = wq0.j()) != null && (c = j.c()) != null) {
            c.onGestureEvent(dVar);
        }
    }

    private final void initViewClickEventDispatcher(GXTemplateEngine.d dVar) {
        if (this.onClickListener == null) {
            this.onClickListener = new pp0(this);
        }
        if (GaiaXUiExecutor.INSTANCE.isMainThread()) {
            View view = dVar.getView();
            if (view != null) {
                view.setOnClickListener(this.onClickListener);
                return;
            }
            return;
        }
        View view2 = dVar.getView();
        if (view2 != null) {
            view2.post(new rp0(dVar, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewClickEventDispatcher$lambda-2  reason: not valid java name */
    public static final void m893initViewClickEventDispatcher$lambda2(GXMixNodeEvent gXMixNodeEvent, View view) {
        k21.i(gXMixNodeEvent, "this$0");
        gXMixNodeEvent.dispatcherClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewClickEventDispatcher$lambda-3  reason: not valid java name */
    public static final void m894initViewClickEventDispatcher$lambda3(GXTemplateEngine.d dVar, GXMixNodeEvent gXMixNodeEvent) {
        k21.i(dVar, "$gestureParams");
        k21.i(gXMixNodeEvent, "this$0");
        View view = dVar.getView();
        if (view != null) {
            view.setOnClickListener(gXMixNodeEvent.onClickListener);
        }
    }

    private final void initViewEventListener(GXTemplateEngine.d dVar) {
        String gestureType = dVar.getGestureType();
        int hashCode = gestureType.hashCode();
        if (hashCode != 114595) {
            if (hashCode != 94750088) {
                if (hashCode == 143756103 && gestureType.equals("longpress")) {
                    initViewLongClickEventDispatcher(dVar);
                    return;
                }
                return;
            } else if (!gestureType.equals("click")) {
                return;
            }
        } else if (!gestureType.equals(EventParams.CLICK_TYPE_TAP)) {
            return;
        }
        initViewClickEventDispatcher(dVar);
    }

    private final void initViewLongClickEventDispatcher(GXTemplateEngine.d dVar) {
        if (this.onLongClickListener == null) {
            this.onLongClickListener = new qp0(this);
        }
        if (GaiaXUiExecutor.INSTANCE.isMainThread()) {
            View view = dVar.getView();
            if (view != null) {
                view.setOnLongClickListener(this.onLongClickListener);
                return;
            }
            return;
        }
        View view2 = dVar.getView();
        if (view2 != null) {
            view2.post(new sp0(dVar, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewLongClickEventDispatcher$lambda-4  reason: not valid java name */
    public static final boolean m895initViewLongClickEventDispatcher$lambda4(GXMixNodeEvent gXMixNodeEvent, View view) {
        k21.i(gXMixNodeEvent, "this$0");
        gXMixNodeEvent.dispatcherLongClick();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewLongClickEventDispatcher$lambda-5  reason: not valid java name */
    public static final void m896initViewLongClickEventDispatcher$lambda5(GXTemplateEngine.d dVar, GXMixNodeEvent gXMixNodeEvent) {
        k21.i(dVar, "$gestureParams");
        k21.i(gXMixNodeEvent, "this$0");
        View view = dVar.getView();
        if (view != null) {
            view.setOnLongClickListener(gXMixNodeEvent.onLongClickListener);
        }
    }

    @Override // com.alibaba.gaiax.render.node.GXINodeEvent
    public void addDataBindingEvent(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        String str;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "templateData");
        this.gxTemplateContext = wq0;
        xo0 g = up0.n().g();
        if (g != null) {
            Object value = g.a().value(jSONObject);
            JSONObject jSONObject2 = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (!jSONObject2.containsKey("type") || !jSONObject2.containsKey("event") || (str = jSONObject2.getString("type")) == null) {
                str = EventParams.CLICK_TYPE_TAP;
            }
            GXTemplateEngine.d dVar = new GXTemplateEngine.d();
            dVar.setGestureType(str);
            dVar.setView(up0.p());
            dVar.setEventParams(jSONObject2);
            dVar.setNodeId(up0.n().n().d());
            dVar.setTemplateItem(wq0.l());
            dVar.setIndex(-1);
            if (k21.d(str, EventParams.CLICK_TYPE_TAP)) {
                this.clickEventByDataBinding = dVar;
            } else if (k21.d(str, "longpress")) {
                this.longClickEventByDataBinding = dVar;
            }
            initViewEventListener(dVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0071, code lost:
        if (r7.equals("click") == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007a, code lost:
        if (r7.equals(com.youku.gaiax.api.data.EventParams.CLICK_TYPE_TAP) == false) goto L_0x007f;
     */
    public final void addJSEvent(@NotNull wq0 wq0, @NotNull up0 up0, long j, @NotNull String str, boolean z, int i) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(str, "eventType");
        this.gxTemplateContext = wq0;
        GXJSGesture gXJSGesture = new GXJSGesture();
        gXJSGesture.setGestureType(str);
        gXJSGesture.setView(up0.p());
        gXJSGesture.setEventParams(null);
        gXJSGesture.setNodeId(up0.n().n().d());
        gXJSGesture.setTemplateItem(wq0.l());
        gXJSGesture.setIndex(-1);
        gXJSGesture.setJsComponentId(j);
        gXJSGesture.setJsOptionCover(z);
        gXJSGesture.setJsOptionLevel(i);
        int hashCode = str.hashCode();
        if (hashCode != 114595) {
            if (hashCode != 94750088) {
                if (hashCode == 143756103 && str.equals("longpress")) {
                    this.longClickEventByJS = gXJSGesture;
                }
            }
            initViewEventListener(gXJSGesture);
        }
        this.clickEventByJS = gXJSGesture;
        initViewEventListener(gXJSGesture);
    }

    public final void removeJSEvent(long j, @NotNull String str) {
        k21.i(str, "eventType");
        if (k21.d(str, EventParams.CLICK_TYPE_TAP)) {
            this.clickEventByJS = null;
        } else if (k21.d(str, "longpress")) {
            this.longClickEventByJS = null;
        }
    }
}
