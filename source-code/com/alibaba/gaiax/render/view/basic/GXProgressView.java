package com.alibaba.gaiax.render.view.basic;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Keep;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cq0;
import tb.dq0;
import tb.k21;
import tb.ko0;
import tb.m40;
import tb.ur2;
import tb.uw1;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tJ(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\tR\u001c\u0010\u0017\u001a\u00020\u00168B@\u0002X\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXProgressView;", "Landroid/view/View;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Ltb/ur2;", "initView", "updateProgressPath", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "Ltb/cq0;", Constants.CONFIG, "setConfig", "", WXComponent.PROP_FS_WRAP_CONTENT, "h", "oldw", "oldh", "onSizeChanged", "Landroid/graphics/Canvas;", "canvas", "onDraw", "getConfig", "", "percent", UTConstant.Args.UT_SUCCESS_F, "getPercent", "()F", "currentProgressWidth", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "bgPath", "Landroid/graphics/Path;", "progressPath", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXProgressView extends View implements GXIViewBindData {
    @NotNull
    public static final a Companion = new a(null);
    private static final float PADDING = 1.0f;
    @NotNull
    private static final String PROGRESS_WIDTH_VALUE_HOLDER = "PROGRESS_WIDTH_VALUE_HOLDER";
    @Nullable
    private Animator animator;
    @NotNull
    private final Path bgPath = new Path();
    @Nullable
    private cq0 config;
    private float currentProgressWidth;
    @NotNull
    private final Paint mPaint = new Paint();
    private float percent;
    @NotNull
    private final Path progressPath = new Path();

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXProgressView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }

    private final float getPercent() {
        float f = this.percent;
        if (f < 0.0f) {
            return 0.0f;
        }
        return uw1.c(f, 1.0f);
    }

    private final void initView() {
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }

    private final void updateProgressPath() {
        float measuredWidth = (((float) getMeasuredWidth()) - 2.0f) * getPercent();
        cq0 cq0 = this.config;
        if (cq0 != null && !cq0.a()) {
            this.progressPath.reset();
            this.progressPath.moveTo(1.0f, 1.0f);
            float f = measuredWidth + 1.0f;
            this.progressPath.lineTo(f, 1.0f);
            this.progressPath.lineTo(f, ((float) getMeasuredHeight()) - 1.0f);
            this.progressPath.lineTo(1.0f, ((float) getMeasuredHeight()) - 1.0f);
            this.progressPath.close();
        } else {
            Animator animator2 = this.animator;
            if (animator2 != null) {
                animator2.cancel();
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setValues(PropertyValuesHolder.ofFloat(PROGRESS_WIDTH_VALUE_HOLDER, this.currentProgressWidth, measuredWidth));
            valueAnimator.setDuration(300L);
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.addUpdateListener(new dq0(this));
            valueAnimator.start();
            ur2 ur2 = ur2.INSTANCE;
            this.animator = valueAnimator;
        }
        this.currentProgressWidth = measuredWidth;
    }

    /* access modifiers changed from: private */
    /* renamed from: updateProgressPath$lambda-2$lambda-1  reason: not valid java name */
    public static final void m93updateProgressPath$lambda2$lambda1(GXProgressView gXProgressView, ValueAnimator valueAnimator) {
        k21.i(gXProgressView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue(PROGRESS_WIDTH_VALUE_HOLDER);
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        gXProgressView.progressPath.reset();
        gXProgressView.progressPath.moveTo(1.0f, 1.0f);
        float f = floatValue + 1.0f;
        gXProgressView.progressPath.lineTo(f, 1.0f);
        gXProgressView.progressPath.lineTo(f, ((float) gXProgressView.getMeasuredHeight()) - 1.0f);
        gXProgressView.progressPath.lineTo(1.0f, ((float) gXProgressView.getMeasuredHeight()) - 1.0f);
        gXProgressView.progressPath.close();
        gXProgressView.invalidate();
    }

    @Nullable
    public final cq0 getConfig() {
        return this.config;
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        Float f;
        if (jSONObject != null && (f = jSONObject.getFloat("value")) != null) {
            this.percent = f.floatValue();
            updateProgressPath();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@Nullable Canvas canvas) {
        ko0 c;
        ko0 d;
        super.onDraw(canvas);
        Paint paint = this.mPaint;
        cq0 cq0 = this.config;
        int i = -7829368;
        if (!(cq0 == null || (d = cq0.d()) == null)) {
            i = d.b(getContext());
        }
        paint.setColor(i);
        if (canvas != null) {
            canvas.drawPath(this.bgPath, this.mPaint);
        }
        if (getPercent() > 0.0f) {
            Paint paint2 = this.mPaint;
            cq0 cq02 = this.config;
            int i2 = -16776961;
            if (!(cq02 == null || (c = cq02.c()) == null)) {
                i2 = c.b(getContext());
            }
            paint2.setColor(i2);
            if (canvas != null) {
                canvas.drawPath(this.progressPath, this.mPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.mPaint.setPathEffect(new CornerPathEffect((f - 2.0f) / ((float) 2)));
        this.bgPath.reset();
        this.bgPath.moveTo(1.0f, 1.0f);
        float f2 = ((float) i) - 1.0f;
        this.bgPath.lineTo(f2, 1.0f);
        float f3 = f - 1.0f;
        this.bgPath.lineTo(f2, f3);
        this.bgPath.lineTo(1.0f, f3);
        this.bgPath.close();
        updateProgressPath();
    }

    public final void setConfig(@Nullable cq0 cq0) {
        this.config = cq0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }
}
