package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iq0;
import tb.k21;
import tb.lo0;
import tb.no0;
import tb.nq0;
import tb.rb1;
import tb.uq0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010$J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0016¨\u0006%"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Landroid/widget/TextView;", "textView", "", "content", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/ur2;", "bindDesc", "", "getContent", "onBindData", "bindText", "Ltb/no0;", "css", "setTextStyle", "", "radiusArray", "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerBorder", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GXText extends AppCompatTextView implements GXIRoundCorner, GXIViewBindData {

    /* compiled from: Taobao */
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ GXText a;
        final /* synthetic */ float b;

        a(GXText gXText, float f) {
            this.a = gXText;
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
    public GXText(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final void bindDesc(TextView textView, CharSequence charSequence, JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.b(textView, jSONObject, charSequence);
    }

    private final CharSequence getContent(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (CharSequence) obj;
        }
        if (obj instanceof JSONObject) {
            return getContent(((JSONObject) obj).get("value"));
        }
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public void bindText(@NotNull TextView textView, @NotNull CharSequence charSequence) {
        k21.i(textView, "textView");
        k21.i(charSequence, "content");
        textView.setText(charSequence);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        CharSequence content = getContent(jSONObject);
        bindText(this, content);
        bindDesc(this, content, jSONObject);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (getBackground() instanceof lo0) {
            Drawable background = getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.drawable.GXColorGradientDrawable");
            ((lo0) background).setStroke(rb1.a((double) f), i);
            return;
        }
        iq0 iq0 = new iq0();
        iq0.setShape(0);
        iq0.setCornerRadii(fArr);
        iq0.setStroke(rb1.a((double) f), i);
        setBackground(iq0);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        k21.i(fArr, "radiusArray");
        if (fArr[0] == fArr[2]) {
            if (fArr[2] == fArr[4]) {
                if (fArr[4] == fArr[6]) {
                    float f = fArr[0];
                    if (f > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        setOutlineProvider(new a(this, f));
                    }
                }
            }
        }
    }

    public final void setTextStyle(@NotNull no0 no0) {
        k21.i(no0, "css");
        uq0 b = no0.b();
        no0.a();
        GXViewExtKt.j(this, b.w());
        nq0 n = b.n();
        GXViewExtKt.k(this, n == null ? null : Float.valueOf(n.c()));
        GXViewExtKt.h(this, b);
        GXViewExtKt.g(this, b);
        GXViewExtKt.f(this, b.c());
        GXViewExtKt.i(this, b.m());
        GXViewExtKt.o(this, b);
        GXViewExtKt.l(this, b);
        GXViewExtKt.n(this, b);
        GXViewExtKt.m(this, b.p());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
