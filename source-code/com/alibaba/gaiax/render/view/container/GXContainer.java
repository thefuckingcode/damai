package com.alibaba.gaiax.render.view.container;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iq0;
import tb.k21;
import tb.wq0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u001eJ\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXContainer;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alibaba/gaiax/render/view/GXIContainer;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/ur2;", "onBindData", "Ltb/wq0;", "gxContext", "setTemplateContext", "getTemplateContext", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GXContainer extends RecyclerView implements GXIContainer, GXIRootView, GXIRoundCorner, GXIViewBindData {
    @Nullable
    private wq0 gxTemplateContext;

    /* compiled from: Taobao */
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ GXContainer a;
        final /* synthetic */ float b;

        a(GXContainer gXContainer, float f) {
            this.a = gXContainer;
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
    public GXContainer(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public wq0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            iq0 iq0 = new iq0();
            iq0.setShape(0);
            iq0.setCornerRadii(fArr);
            iq0.setStroke((int) f, i);
            if (Build.VERSION.SDK_INT >= 23) {
                setForeground(iq0);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            boolean z = false;
            float f = fArr[0];
            float f2 = fArr[2];
            float f3 = fArr[4];
            float f4 = fArr[6];
            if (f == f2) {
                if (f2 == f3) {
                    if (f3 == f4) {
                        z = true;
                    }
                    if (z && f > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        setClipToOutline(true);
                        setOutlineProvider(new a(this, f));
                    }
                }
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(@Nullable wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
