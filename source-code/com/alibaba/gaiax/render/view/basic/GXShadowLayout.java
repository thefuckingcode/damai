package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.go0;
import tb.ho0;
import tb.jo0;
import tb.jq0;
import tb.k21;
import tb.mq0;
import tb.nq0;
import tb.uq0;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bR\u0010VB#\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\u0012¢\u0006\u0004\bR\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J<\u0010\u0010\u001a\u00020\u0004*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\tJ\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ(\u0010)\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0007J\u0006\u0010/\u001a\u00020\tJ\u0006\u00100\u001a\u00020\tJ\u0006\u00101\u001a\u00020\tJ\u0006\u00102\u001a\u00020\tJ\u0010\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103R\"\u00106\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010=R\u0016\u0010A\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010=R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010=R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010=R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010=R\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010=R\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010=R\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010=¨\u0006Y"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXShadowLayout;", "Landroid/widget/AbsoluteLayout;", "Landroid/graphics/Canvas;", "canvas", "Ltb/ur2;", "clipRadius", "drawShadow", "resetShadowOffset", "Landroid/graphics/Path;", "", "tL", "tR", "bL", "bR", WXComponent.PROP_FS_WRAP_CONTENT, "h", "addRoundRect2", "draw", "", "oldw", "oldh", "onSizeChanged", "shadowVerticalOffset", "setShadowYOffset", "getShadowVerticalOffset", "shadowHorizontalOffset", "setShadowXOffset", "getShadowHorizontalOffset", "shadowColor", "setShadowColor", "getShadowColor", "shadowBlur", "setShadowBlur", "", "shadowInset", "setShadowInset", "isShadowInset", "shadowSpread", "setShadowSpread", "getShadowSpread", BQCCameraParam.FOCUS_AREA_RADIUS, "setBoxRadius", "getRadius", "topLeft", "topRight", "bottomLeft", "bottomRight", "getTopLeftRadius", "getTopRightRadius", "getBottomRightRadius", "getBottomLeftRadius", "Ltb/uq0;", "style", "setStyle", "mShadowColor", "I", "getMShadowColor", "()I", "setMShadowColor", "(I)V", "mShadowBlur", UTConstant.Args.UT_SUCCESS_F, "mShadowInset", "Z", "mShadowSpread", "mBoxRadius", "mTopLeftBoxRadius", "mTopRightBoxRadius", "mBottomLeftBoxRadius", "mBottomRightBoxRadius", "mShadowVerticalOffset", "mShadowHorizontalOffset", "clipPath", "Landroid/graphics/Path;", "Landroid/graphics/Paint;", "clipPaint", "Landroid/graphics/Paint;", "shadowPath", "shadowPathOffsetX", "shadowPathOffsetY", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GXShadowLayout extends AbsoluteLayout {
    @NotNull
    private final Paint clipPaint;
    @NotNull
    private final Path clipPath = new Path();
    private float mBottomLeftBoxRadius;
    private float mBottomRightBoxRadius;
    private float mBoxRadius;
    private float mShadowBlur;
    private int mShadowColor = -7829368;
    private float mShadowHorizontalOffset;
    private boolean mShadowInset;
    private float mShadowSpread;
    private float mShadowVerticalOffset;
    private float mTopLeftBoxRadius;
    private float mTopRightBoxRadius;
    @NotNull
    private final mq0 shadowDrawable;
    @NotNull
    private final Path shadowPath;
    private float shadowPathOffsetX;
    private float shadowPathOffsetY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXShadowLayout(@NotNull Context context) {
        super(context);
        mq0 mq0;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ur2 ur2 = ur2.INSTANCE;
        this.clipPaint = paint;
        Path path = new Path();
        this.shadowPath = path;
        if (Build.VERSION.SDK_INT >= 28) {
            mq0 = new ho0(path);
        } else {
            mq0 = new go0(path);
        }
        this.shadowDrawable = mq0;
        setWillNotDraw(false);
    }

    @RequiresApi(21)
    private final void addRoundRect2(Path path, float f, float f2, float f3, float f4, float f5, float f6) {
        path.addRoundRect(0.0f, 0.0f, f5, f6, new float[]{f, f, f2, f2, f4, f4, f3, f3}, Path.Direction.CW);
    }

    private final void clipRadius(Canvas canvas) {
        if (this.mBoxRadius > 0.0f || this.mTopLeftBoxRadius > 0.0f || this.mTopRightBoxRadius > 0.0f || this.mBottomLeftBoxRadius > 0.0f || this.mBottomRightBoxRadius > 0.0f) {
            canvas.drawPath(this.clipPath, this.clipPaint);
        }
    }

    private final void drawShadow(Canvas canvas) {
        this.shadowDrawable.draw(canvas);
    }

    private final void resetShadowOffset() {
        this.shadowPath.offset(-this.shadowPathOffsetX, -this.shadowPathOffsetY);
        float f = this.mShadowSpread;
        float f2 = (-f) + this.mShadowHorizontalOffset;
        this.shadowPathOffsetX = f2;
        float f3 = (-f) + this.mShadowVerticalOffset;
        this.shadowPathOffsetY = f3;
        this.shadowPath.offset(f2, f3);
        this.shadowDrawable.d();
    }

    public void draw(@NotNull Canvas canvas) {
        k21.i(canvas, "canvas");
        drawShadow(canvas);
        if (Build.VERSION.SDK_INT >= 21) {
            int saveLayer = canvas.saveLayer(null, null);
            try {
                super.draw(canvas);
                clipRadius(canvas);
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
    }

    public final float getBottomLeftRadius() {
        return this.mBottomLeftBoxRadius;
    }

    public final float getBottomRightRadius() {
        return this.mBottomRightBoxRadius;
    }

    public final int getMShadowColor() {
        return this.mShadowColor;
    }

    public final float getRadius() {
        return this.mBoxRadius;
    }

    public final int getShadowColor() {
        return this.mShadowColor;
    }

    public final float getShadowHorizontalOffset() {
        return this.mShadowHorizontalOffset;
    }

    public final float getShadowSpread() {
        return this.mShadowSpread;
    }

    public final float getShadowVerticalOffset() {
        return this.mShadowVerticalOffset;
    }

    public final float getTopLeftRadius() {
        return this.mTopLeftBoxRadius;
    }

    public final float getTopRightRadius() {
        return this.mTopRightBoxRadius;
    }

    public final boolean isShadowInset() {
        return this.mShadowInset;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.shadowDrawable.setBounds(0, 0, i, i2);
        if (Build.VERSION.SDK_INT >= 21) {
            setBoxRadius(this.mTopLeftBoxRadius, this.mTopRightBoxRadius, this.mBottomLeftBoxRadius, this.mBottomRightBoxRadius);
        }
    }

    public final void setBoxRadius(float f) {
        float abs = Math.abs(f);
        this.mBoxRadius = abs;
        if (Build.VERSION.SDK_INT >= 21) {
            setBoxRadius(abs, abs, abs, abs);
        }
    }

    public final void setMShadowColor(int i) {
        this.mShadowColor = i;
    }

    public final void setShadowBlur(float f) {
        this.mShadowBlur = f;
        this.shadowDrawable.f(f);
        invalidate();
    }

    public final void setShadowColor(int i) {
        this.mShadowColor = i;
        this.shadowDrawable.g(i);
        invalidate();
    }

    public final void setShadowInset(boolean z) {
        this.mShadowInset = z;
        this.shadowDrawable.h(z);
        invalidate();
    }

    public final void setShadowSpread(float f) {
        this.mShadowSpread = f;
        resetShadowOffset();
        invalidate();
    }

    public final void setShadowXOffset(float f) {
        this.mShadowHorizontalOffset = f;
        resetShadowOffset();
        invalidate();
    }

    public final void setShadowYOffset(float f) {
        this.mShadowVerticalOffset = f;
        resetShadowOffset();
        invalidate();
    }

    public final void setStyle(@Nullable uq0 uq0) {
        jq0 jq0 = null;
        jo0 g = uq0 == null ? null : uq0.g();
        if (g != null) {
            setShadowYOffset(g.e().c());
            setShadowXOffset(g.d().c());
            setShadowColor(g.b().b(getContext()));
            setShadowBlur(g.a().c());
            setShadowSpread(g.c().c());
        }
        if (uq0 != null) {
            jq0 = uq0.e();
        }
        if (jq0 != null) {
            nq0 c = jq0.c();
            float f = 0.0f;
            float c2 = c == null ? 0.0f : c.c();
            nq0 d = jq0.d();
            float c3 = d == null ? 0.0f : d.c();
            nq0 a = jq0.a();
            float c4 = a == null ? 0.0f : a.c();
            nq0 b = jq0.b();
            if (b != null) {
                f = b.c();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                setBoxRadius(c2, c3, c4, f);
            }
        }
    }

    @RequiresApi(21)
    public final void setBoxRadius(float f, float f2, float f3, float f4) {
        this.mTopLeftBoxRadius = Math.abs(f);
        this.mTopRightBoxRadius = Math.abs(f2);
        this.mBottomLeftBoxRadius = Math.abs(f3);
        this.mBottomRightBoxRadius = Math.abs(f4);
        this.clipPath.reset();
        this.clipPath.setFillType(Path.FillType.INVERSE_WINDING);
        addRoundRect2(this.clipPath, this.mTopLeftBoxRadius, this.mTopRightBoxRadius, this.mBottomLeftBoxRadius, this.mBottomRightBoxRadius, (float) getWidth(), (float) getHeight());
        this.shadowPath.reset();
        this.shadowPathOffsetX = 0.0f;
        this.shadowPathOffsetY = 0.0f;
        this.shadowPath.setFillType(Path.FillType.WINDING);
        float f5 = (float) 2;
        addRoundRect2(this.shadowPath, this.mTopLeftBoxRadius, this.mTopRightBoxRadius, this.mBottomLeftBoxRadius, this.mBottomRightBoxRadius, ((float) getWidth()) + (this.mShadowSpread * f5), ((float) getHeight()) + (this.mShadowSpread * f5));
        resetShadowOffset();
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        mq0 mq0;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ur2 ur2 = ur2.INSTANCE;
        this.clipPaint = paint;
        Path path = new Path();
        this.shadowPath = path;
        if (Build.VERSION.SDK_INT >= 28) {
            mq0 = new ho0(path);
        } else {
            mq0 = new go0(path);
        }
        this.shadowDrawable = mq0;
        setWillNotDraw(false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mq0 mq0;
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ur2 ur2 = ur2.INSTANCE;
        this.clipPaint = paint;
        Path path = new Path();
        this.shadowPath = path;
        if (Build.VERSION.SDK_INT >= 28) {
            mq0 = new ho0(path);
        } else {
            mq0 = new go0(path);
        }
        this.shadowDrawable = mq0;
        setWillNotDraw(false);
    }
}
