package com.taobao.android.dinamicx.widget.richtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.node.a;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import tb.at;
import tb.lx;
import tb.ry;
import tb.yz;
import tb.zz;

/* compiled from: Taobao */
public class DXImageSpanWidgetNode extends DXImageWidgetNode {
    public static final long DXIMAGESPAN_IMAGESPAN = 7700670379007126142L;
    public static final long DXIMAGESPAN_LINK = 35873943762L;
    public static final long DXIMAGESPAN_ONLINK = 9859228430928305L;
    public static final long DXIMAGESPAN_ONPRESS = 5176476879387311985L;
    public static final long DXIMAGESPAN_PRESS = 19050239308914L;
    private String v;
    private String w;
    private com.taobao.android.dinamicx.view.richtext.node.a x;

    /* compiled from: Taobao */
    public interface ImageLoadCallback {
        void onLoaded(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    class a implements RichTextNode.OnLinkTapListener {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLinkTapListener
        public void onLinkTap(String str) {
            yz yzVar = new yz(this.a);
            yzVar.f(str);
            DXImageSpanWidgetNode.this.postEvent(yzVar);
        }
    }

    /* compiled from: Taobao */
    class b implements RichTextNode.OnLongPressListener {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongPressListener
        public boolean onLongPress(String str) {
            zz zzVar = new zz(this.a);
            zzVar.f(str);
            DXImageSpanWidgetNode.this.postEvent(zzVar);
            return true;
        }
    }

    /* compiled from: Taobao */
    class c implements RichTextNode.OnTapListener {
        c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnTapListener
        public void onTap() {
            DXImageSpanWidgetNode.this.postEvent(new lx(18903999933159L));
        }
    }

    /* compiled from: Taobao */
    class d implements RichTextNode.OnLongTapListener {
        d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongTapListener
        public void onLongTap() {
            DXImageSpanWidgetNode.this.postEvent(new lx(-6544685697300501093L));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements ImageLoadCallback {
        final /* synthetic */ com.taobao.android.dinamicx.view.richtext.node.a a;

        e(com.taobao.android.dinamicx.view.richtext.node.a aVar) {
            this.a = aVar;
        }

        @Override // com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode.ImageLoadCallback
        public void onLoaded(Bitmap bitmap) {
            View view;
            this.a.v(bitmap);
            DXWidgetNode parentWidget = DXImageSpanWidgetNode.this.getParentWidget();
            if (parentWidget.getWRView() != null) {
                view = parentWidget.getWRView().get();
            } else {
                view = (parentWidget.getReferenceNode() == null || parentWidget.getReferenceNode().getWRView() == null) ? null : parentWidget.getReferenceNode().getWRView().get();
            }
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXImageSpanWidgetNode();
    }

    public com.taobao.android.dinamicx.view.richtext.node.a k(boolean z, boolean z2) {
        if (getLayoutWidth() <= 0 && getLayoutHeight() <= 0) {
            return null;
        }
        a.i iVar = new a.i();
        iVar.f(getLayoutWidth()).b(getLayoutHeight()).c(this.v).d(this.w).e(c());
        com.taobao.android.dinamicx.view.richtext.node.a a2 = iVar.a();
        if (z) {
            l(a2, z2);
        }
        this.x = a2;
        return a2;
    }

    public void l(com.taobao.android.dinamicx.view.richtext.node.a aVar, boolean z) {
        IDXRichTextImageInterface d2;
        IDXWebImageUrlInterface g;
        if (aVar != null && (d2 = DXGlobalCenter.d(getDXRuntimeContext())) != null && getDXRuntimeContext() != null && getDXRuntimeContext().getContext() != null) {
            String e2 = e();
            if (!z && !TextUtils.isEmpty(e2) && (g = DXGlobalCenter.g()) != null) {
                String decideUrl = g.decideUrl(e2, aVar.r(), aVar.q(), a());
                if (!TextUtils.isEmpty(decideUrl)) {
                    e2 = decideUrl;
                }
            }
            ry.g("DXImageSpanRequest", e2);
            d2.downloadImage(getDXRuntimeContext().getContext(), e2, new e(aVar));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (this.x == null) {
            if (!at.j0(this)) {
                super.onBindEvent(context, view, j);
            }
        } else if (j == 9859228430928305L && !TextUtils.isEmpty(this.v)) {
            this.x.w(new a(j));
        } else if (j == 5176476879387311985L && !TextUtils.isEmpty(this.w)) {
            this.x.x(new b(j));
        } else if (j == 18903999933159L) {
            this.x.z(new c());
        } else if (j == -6544685697300501093L) {
            this.x.y(new d());
        } else if (!at.j0(this)) {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && (dXWidgetNode instanceof DXImageSpanWidgetNode)) {
            super.onClone(dXWidgetNode, z);
            DXImageSpanWidgetNode dXImageSpanWidgetNode = (DXImageSpanWidgetNode) dXWidgetNode;
            this.v = dXImageSpanWidgetNode.v;
            this.w = dXImageSpanWidgetNode.w;
            this.x = dXImageSpanWidgetNode.x;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (at.j0(this)) {
            return null;
        }
        return super.onCreateView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.PrefetchListener
    public void onPrefetchSuccess() {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 35873943762L) {
            this.v = str;
        } else if (j == 19050239308914L) {
            this.w = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
