package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class a extends DXWidgetNode {
    public static final long DX_WIDGET_ANIMATEDVIEW = -2149351516928899638L;
    private double a = 1.0d;
    private String b;
    private int c;

    /* renamed from: com.taobao.android.dinamicx.widget.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0210a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new a();
        }
    }

    /* access modifiers changed from: protected */
    public void a(ImageView imageView, int i) {
        if (i == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new a();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public double getDefaultValueForDoubleAttr(long j) {
        if (j == 7594222789952419722L) {
            return 1.0d;
        }
        return super.getDefaultValueForDoubleAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof a) {
            a aVar = (a) dXWidgetNode;
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        if (f == null) {
            return new ImageView(context);
        }
        return f.buildView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        boolean z = true;
        int i6 = 0;
        boolean z2 = a2 != 1073741824;
        if (a3 == 1073741824) {
            z = false;
        }
        if (z2 || z) {
            double d = this.a;
            if (d <= 0.0d) {
                if (DinamicXEngine.x()) {
                    Log.w("DXAnimatedViewWidgetNode", "DXAnimatedViewWidgetNode", new IllegalArgumentException("非定高顶宽场景下需要设置aspectRatio"));
                }
                wz.b("DXAnimatedViewWidgetNode" + vx.a(new IllegalArgumentException("aspectRatio 非定高顶宽场景下需要设置aspectRatio")));
            }
            if (!z2 || z) {
                if (!z2 && z) {
                    int size = View.MeasureSpec.getSize(i);
                    if (d > 0.0d) {
                        i6 = size;
                        i5 = (int) (((double) size) / d);
                    } else {
                        i6 = size;
                    }
                }
                i5 = 0;
            } else {
                i5 = View.MeasureSpec.getSize(i2);
                if (d > 0.0d) {
                    i6 = (int) (((double) i5) * d);
                }
            }
            int max = Math.max(i6, getSuggestedMinimumWidth());
            i3 = Math.max(i5, getSuggestedMinimumHeight());
            i4 = max;
        } else {
            i4 = DXWidgetNode.DXMeasureSpec.b(i);
            i3 = DXWidgetNode.DXMeasureSpec.b(i2);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i4, i), DXWidgetNode.resolveSize(i3, i2));
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        ImageView imageView = (ImageView) view;
        DXImageWidgetNode.c cVar = new DXImageWidgetNode.c();
        cVar.h = true;
        a(imageView, this.c);
        if (TextUtils.isEmpty(this.b)) {
            imageView.setImageDrawable(null);
        }
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        if (f != null) {
            f.setImage(imageView, this.b, cVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        if (j == 7594222789952419722L) {
            this.a = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 1015096712691932083L) {
            this.c = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 9274838684923695L) {
            this.b = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
