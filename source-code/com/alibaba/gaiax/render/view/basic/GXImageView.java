package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import tb.hq0;
import tb.k21;
import tb.m40;
import tb.no0;
import tb.tp0;
import tb.wq0;

public class GXImageView extends AppCompatImageView implements GXIRelease, GXIImageView {
    public static final a Companion = new a(null);
    public static final String LOCAL_PREFIX;
    public static final String NET_HTTPS_PREFIX;
    public static final String NET_HTTP_PREFIX;
    private hq0 delegate;
    private wq0 gxTemplateContext;
    private tp0 mode;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXImageView(Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final Drawable getDrawableByResId(ImageView imageView, int i) {
        Resources.Theme theme = imageView.getContext().getTheme();
        k21.h(theme, "imageView.context.theme");
        return ResourcesCompat.getDrawable(imageView.getResources(), i, theme);
    }

    private final String getLocalUri(String str) {
        return o.F(str, "local:", "", false, 4, null);
    }

    private final int getResIdByUri(ImageView imageView, String str) {
        try {
            Integer valueOf = Integer.valueOf(imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName()));
            boolean z = true;
            Integer num = null;
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(imageView.getResources().getIdentifier(str, "mipmap", imageView.getContext().getPackageName()));
            if (valueOf2.intValue() == 0) {
                z = false;
            }
            if (z) {
                num = valueOf2;
            }
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final boolean isLocalUri(String str) {
        return o.L(str, "local:", false, 2, null);
    }

    private final boolean isNetUri(String str) {
        return (o.L(str, "http:", false, 2, null)) || (o.L(str, "https:", false, 2, null));
    }

    private final void updateMatrix(ImageView imageView, Drawable drawable) {
        if (drawable != null && imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            int paddingLeft = (imageView.getLayoutParams().width - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int paddingTop = (imageView.getLayoutParams().height - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                tp0 tp0 = this.mode;
                imageView.setImageMatrix(tp0 == null ? null : tp0.j(paddingLeft, paddingTop, intrinsicWidth, intrinsicHeight));
            }
        }
    }

    public void bindDefault() {
        setImageDrawable(null);
    }

    public void bindDesc(JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.a(this, jSONObject);
    }

    public void bindNetUri(JSONObject jSONObject, String str, String str2) {
        k21.i(jSONObject, "data");
        k21.i(str, "uri");
    }

    public void bindRes(String str) {
        k21.i(str, "resUri");
        try {
            setImageDrawable(getDrawableByResId(this, getResIdByUri(this, str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bindUri(JSONObject jSONObject) {
        String string;
        String obj;
        String str = "";
        if (!(jSONObject == null || (string = jSONObject.getString("value")) == null || (obj = StringsKt__StringsKt.T0(string).toString()) == null)) {
            str = obj;
        }
        if (isNetUri(str)) {
            if (jSONObject != null) {
                bindNetUri(jSONObject, str, jSONObject.getString(Constants.Name.PLACEHOLDER));
            }
        } else if (isLocalUri(str)) {
            bindRes(getLocalUri(str));
        } else {
            bindDefault();
        }
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) getMeasuredWidth();
        float measuredHeight = (float) getMeasuredHeight();
        hq0 hq0 = this.delegate;
        boolean z = false;
        if (hq0 != null && hq0.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (z) {
            hq0 hq02 = this.delegate;
            if (hq02 != null) {
                hq02.a(canvas, measuredWidth, measuredHeight, new GXImageView$draw$1(this, canvas));
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    public final wq0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject jSONObject) {
        bindUri(jSONObject);
        bindDesc(jSONObject);
    }

    public void onDraw(Canvas canvas) {
        hq0 hq0;
        super.onDraw(canvas);
        float measuredWidth = (float) getMeasuredWidth();
        float measuredHeight = (float) getMeasuredHeight();
        hq0 hq02 = this.delegate;
        boolean z = false;
        if (hq02 != null && hq02.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (z && (hq0 = this.delegate) != null) {
            hq0.e(canvas, measuredWidth, measuredHeight);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        this.gxTemplateContext = null;
    }

    public boolean setFrame(int i, int i2, int i3, int i4) {
        updateMatrix(this, getDrawable());
        return super.setFrame(i, i2, i3, i4);
    }

    public final void setGxTemplateContext(wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView
    public void setImageStyle(wq0 wq0, no0 no0) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(no0, "gxCss");
        if (no0.b().t() != null) {
            this.mode = no0.b().t();
            setScaleType(no0.b().t().p());
        } else {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.gxTemplateContext = wq0;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new hq0();
        }
        hq0 hq0 = this.delegate;
        if (hq0 != null) {
            hq0.g(i, f, fArr);
        }
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new hq0();
        }
        hq0 hq0 = this.delegate;
        if (hq0 != null) {
            hq0.i(fArr);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public final void setRoundCornerBorder(int i, float f, float f2, float f3, float f4, float f5) {
        if (this.delegate == null) {
            this.delegate = new hq0();
        }
        hq0 hq0 = this.delegate;
        if (hq0 != null) {
            hq0.f(i, f, f2, f3, f4, f5);
        }
    }

    public final void setRoundCornerRadius(float f, float f2, float f3, float f4) {
        if (this.delegate == null) {
            this.delegate = new hq0();
        }
        hq0 hq0 = this.delegate;
        if (hq0 != null) {
            hq0.h(f, f2, f3, f4);
        }
    }
}
