package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.AbsoluteLayout;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ao0;
import tb.eo0;
import tb.iq0;
import tb.k21;
import tb.rb1;
import tb.wq0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0011¢\u0006\u0004\b-\u00103J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\bH\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXView;", "Landroid/widget/AbsoluteLayout;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/gaiax/render/view/GXIRelease;", "Ltb/wq0;", "gxContext", "Ltb/ur2;", "setTemplateContext", "getTemplateContext", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "gxTemplateContext", "Ltb/ao0;", "gxBackdropFilter", "setBackdropFilter", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "draw", "dispatchDraw", "release", "Ltb/ao0;", "getGxBackdropFilter", "()Ltb/ao0;", "setGxBackdropFilter", "(Ltb/ao0;)V", "Ltb/wq0;", "getGxTemplateContext", "()Ltb/wq0;", "setGxTemplateContext", "(Ltb/wq0;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GXView extends AbsoluteLayout implements GXIRelease, GXIRootView, GXIRoundCorner, GXIViewBindData {
    @Nullable
    private ao0 gxBackdropFilter;
    @Nullable
    private eo0 gxBlurHelper;
    @Nullable
    private wq0 gxTemplateContext;

    /* compiled from: Taobao */
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ GXView a;
        final /* synthetic */ float b;

        a(GXView gXView, float f) {
            this.a = gXView;
            this.b = f;
        }

        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            k21.i(view, "view");
            k21.i(outline, com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE);
            if (this.a.getAlpha() >= 0.0f) {
                outline.setAlpha(this.a.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NotNull Canvas canvas) {
        eo0 eo0;
        k21.i(canvas, "canvas");
        if (this.gxBackdropFilter == null) {
            super.dispatchDraw(canvas);
        } else if (Build.VERSION.SDK_INT >= 17 && (eo0 = this.gxBlurHelper) != null) {
            eo0.b(canvas, new GXView$dispatchDraw$1$1(this, canvas));
        }
    }

    public void draw(@NotNull Canvas canvas) {
        eo0 eo0;
        k21.i(canvas, "canvas");
        if (this.gxBackdropFilter == null) {
            super.draw(canvas);
        } else if (Build.VERSION.SDK_INT >= 17 && (eo0 = this.gxBlurHelper) != null) {
            eo0.c(canvas, new GXView$draw$1$1(this, canvas));
        }
    }

    @Nullable
    public final ao0 getGxBackdropFilter() {
        return this.gxBackdropFilter;
    }

    @Nullable
    public final wq0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public wq0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        eo0 eo0;
        super.onAttachedToWindow();
        if (this.gxBackdropFilter != null && Build.VERSION.SDK_INT >= 17 && (eo0 = this.gxBlurHelper) != null) {
            eo0.j();
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.c(this, jSONObject);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        eo0 eo0;
        if (!(this.gxBackdropFilter == null || Build.VERSION.SDK_INT < 17 || (eo0 = this.gxBlurHelper) == null)) {
            eo0.k();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        if (Build.VERSION.SDK_INT >= 17) {
            eo0 eo0 = this.gxBlurHelper;
            if (eo0 != null) {
                eo0.i();
            }
            this.gxBlurHelper = null;
        }
        this.gxTemplateContext = null;
    }

    public final void setBackdropFilter(@NotNull wq0 wq0, @Nullable ao0 ao0) {
        k21.i(wq0, "gxTemplateContext");
        this.gxTemplateContext = wq0;
        if (ao0 instanceof ao0.a) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (this.gxBlurHelper == null) {
                    this.gxBlurHelper = new eo0(this);
                }
                eo0 eo0 = this.gxBlurHelper;
                if (eo0 != null) {
                    eo0.p(25.0f);
                }
                eo0 eo02 = this.gxBlurHelper;
                if (eo02 != null) {
                    eo02.s(12);
                }
            }
            this.gxBackdropFilter = ao0;
        } else if (ao0 instanceof ao0.c) {
            if (Build.VERSION.SDK_INT >= 17) {
                eo0 eo03 = this.gxBlurHelper;
                if (eo03 != null) {
                    eo03.i();
                }
                this.gxBlurHelper = null;
            }
            setBackground(null);
            this.gxBackdropFilter = null;
        }
    }

    public final void setGxBackdropFilter(@Nullable ao0 ao0) {
        this.gxBackdropFilter = ao0;
    }

    public final void setGxTemplateContext(@Nullable wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        Drawable background = getBackground();
        if (background == null) {
            iq0 iq0 = new iq0();
            iq0.setShape(0);
            iq0.setCornerRadii(fArr);
            iq0.setStroke(rb1.a((double) f), i);
            setBackground(iq0);
        } else if (background instanceof GradientDrawable) {
            Drawable background2 = getBackground();
            Objects.requireNonNull(background2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background2).setStroke(rb1.a((double) f), i);
        } else {
            Log.e("[GaiaX]", "setRoundCornerBorder: not support current case");
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            float f = fArr[0];
            float f2 = fArr[2];
            float f3 = fArr[4];
            float f4 = fArr[6];
            if (Build.VERSION.SDK_INT >= 21) {
                if (f == f2) {
                    if (f2 == f3) {
                        if ((f3 == f4) && f > 0.0f) {
                            setClipToOutline(true);
                            setOutlineProvider(new a(this, f));
                            return;
                        }
                    }
                }
                setClipToOutline(false);
                setOutlineProvider(null);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(@Nullable wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
