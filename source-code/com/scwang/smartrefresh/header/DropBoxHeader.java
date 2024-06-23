package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import tb.ap1;
import tb.gd2;

/* compiled from: Taobao */
public class DropBoxHeader extends InternalAbstract implements RefreshHeader {
    protected int mAccentColor;
    protected e mBoxBody;
    protected Drawable mDrawable1;
    protected Drawable mDrawable2;
    protected Drawable mDrawable3;
    protected ValueAnimator mDropOutAnimator;
    protected boolean mDropOutOverFlow;
    protected float mDropOutPercent;
    protected int mHeaderHeight;
    protected Paint mPaint;
    protected Path mPath;
    protected ValueAnimator mReboundAnimator;
    protected float mReboundPercent;
    protected RefreshState mState;

    /* compiled from: Taobao */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            dropBoxHeader.mReboundPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            dropBoxHeader.invalidate();
        }
    }

    /* compiled from: Taobao */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            if (dropBoxHeader.mState == RefreshState.Refreshing) {
                ValueAnimator valueAnimator = dropBoxHeader.mDropOutAnimator;
                if (valueAnimator != null) {
                    valueAnimator.start();
                    return;
                }
                return;
            }
            dropBoxHeader.mDropOutPercent = 0.0f;
        }
    }

    /* compiled from: Taobao */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropBoxHeader dropBoxHeader = DropBoxHeader.this;
            float f = dropBoxHeader.mDropOutPercent;
            if (f < 1.0f || f >= 3.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (f < 2.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
            } else if (f < 3.0f) {
                dropBoxHeader.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                DropBoxHeader dropBoxHeader2 = DropBoxHeader.this;
                if (dropBoxHeader2.mDropOutPercent == 3.0f) {
                    dropBoxHeader2.mDropOutOverFlow = true;
                }
            }
            DropBoxHeader.this.invalidate();
        }
    }

    /* compiled from: Taobao */
    class d extends AnimatorListenerAdapter {
        d() {
        }

        public void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator = DropBoxHeader.this.mReboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;

        private e() {
        }

        /* access modifiers changed from: package-private */
        public e a(int i2, int i3, int i4, int i5) {
            this.i = i4;
            int i6 = i2 / 2;
            this.a = i6;
            int i7 = i3 - i5;
            this.c = i7;
            this.d = i7 - (i4 * 2);
            int sin = i6 - ((int) (((double) i4) * Math.sin(1.0471975511965976d)));
            this.e = sin;
            int i8 = i4 / 2;
            this.f = this.d + i8;
            int i9 = this.c;
            this.g = i9 - i8;
            this.h = i2 - sin;
            this.b = i9 - i4;
            return this;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public DropBoxHeader(Context context) {
        this(context, null);
    }

    @NonNull
    private e generateBoxBody(int i, int i2, int i3) {
        return this.mBoxBody.a(i, i2, i3, i3 / 2);
    }

    @NonNull
    private Path generateBoxBodyPath(e eVar) {
        this.mPath.reset();
        this.mPath.moveTo((float) eVar.e, (float) eVar.g);
        this.mPath.lineTo((float) eVar.a, (float) eVar.c);
        this.mPath.lineTo((float) eVar.h, (float) eVar.g);
        Path path = this.mPath;
        int i = eVar.h;
        path.quadTo(((float) i) + (((float) (eVar.i / 2)) * this.mReboundPercent), (float) eVar.b, (float) i, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) eVar.d);
        this.mPath.lineTo((float) eVar.e, (float) eVar.f);
        Path path2 = this.mPath;
        int i2 = eVar.e;
        path2.quadTo(((float) i2) - (((float) (eVar.i / 2)) * this.mReboundPercent), (float) eVar.b, (float) i2, (float) eVar.g);
        this.mPath.close();
        return this.mPath;
    }

    @NonNull
    private Path generateBoxCoverPath(e eVar) {
        this.mPath.reset();
        double d2 = ((double) this.mReboundPercent) * 1.2566370614359172d;
        float f = (float) (((eVar.a - eVar.e) * 4) / 5);
        double d3 = 1.0471975511965976d - (d2 / 2.0d);
        float sin = ((float) Math.sin(d3)) * f;
        float cos = ((float) Math.cos(d3)) * f;
        this.mPath.moveTo((float) eVar.e, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) eVar.d);
        this.mPath.lineTo(((float) eVar.a) - sin, ((float) eVar.d) - cos);
        this.mPath.lineTo(((float) eVar.e) - sin, ((float) eVar.f) - cos);
        this.mPath.close();
        double d4 = d2 + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d4)) * f;
        float cos2 = ((float) Math.cos(d4)) * f;
        this.mPath.moveTo((float) eVar.e, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) ((eVar.c + eVar.d) / 2));
        this.mPath.lineTo(((float) eVar.a) - sin2, ((float) ((eVar.c + eVar.d) / 2)) + cos2);
        this.mPath.lineTo(((float) eVar.e) - sin2, ((float) eVar.f) + cos2);
        this.mPath.close();
        float sin3 = ((float) Math.sin(d3)) * f;
        float cos3 = ((float) Math.cos(d3)) * f;
        this.mPath.moveTo((float) eVar.h, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) eVar.d);
        this.mPath.lineTo(((float) eVar.a) + sin3, ((float) eVar.d) - cos3);
        this.mPath.lineTo(((float) eVar.h) + sin3, ((float) eVar.f) - cos3);
        this.mPath.close();
        float sin4 = ((float) Math.sin(d4)) * f;
        float cos4 = f * ((float) Math.cos(d4));
        this.mPath.moveTo((float) eVar.h, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) ((eVar.c + eVar.d) / 2));
        this.mPath.lineTo(((float) eVar.a) + sin4, ((float) ((eVar.c + eVar.d) / 2)) + cos4);
        this.mPath.lineTo(((float) eVar.h) + sin4, ((float) eVar.f) + cos4);
        this.mPath.close();
        return this.mPath;
    }

    @NonNull
    private Path generateClipPath(e eVar, int i) {
        this.mPath.reset();
        this.mPath.lineTo(0.0f, (float) eVar.f);
        this.mPath.lineTo((float) eVar.e, (float) eVar.f);
        this.mPath.lineTo((float) eVar.a, (float) eVar.b);
        this.mPath.lineTo((float) eVar.h, (float) eVar.f);
        float f = (float) i;
        this.mPath.lineTo(f, (float) eVar.f);
        this.mPath.lineTo(f, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    private int generateSideLength() {
        return this.mHeaderHeight / 5;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        e generateBoxBody = generateBoxBody(width, getHeight(), generateSideLength());
        this.mPaint.setColor(ColorUtils.setAlphaComponent(this.mAccentColor, 150));
        canvas.drawPath(generateBoxBodyPath(generateBoxBody), this.mPaint);
        this.mPaint.setColor(this.mAccentColor);
        canvas.drawPath(generateBoxCoverPath(generateBoxBody), this.mPaint);
        if (isInEditMode()) {
            this.mDropOutPercent = 2.5f;
        }
        if (this.mDropOutPercent > 0.0f) {
            canvas.clipPath(generateClipPath(generateBoxBody, width));
            float min = Math.min(this.mDropOutPercent, 1.0f);
            Rect bounds = this.mDrawable1.getBounds();
            int i = width / 2;
            bounds.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) / 2), ((int) (((float) ((generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) / 2)) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds))) * min)) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds));
            this.mDrawable1.draw(canvas);
            float min2 = Math.min(Math.max(this.mDropOutPercent - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.mDrawable2.getBounds();
            bounds2.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds2) / 2), ((int) (((float) ((generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds2) / 2)) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds2))) * min2)) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds2));
            this.mDrawable2.draw(canvas);
            float min3 = Math.min(Math.max(this.mDropOutPercent - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.mDrawable3.getBounds();
            bounds3.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds3) / 2), ((int) (((float) ((generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds3) / 2)) + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds3))) * min3)) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds3));
            this.mDrawable3.draw(canvas);
            if (this.mDropOutOverFlow) {
                bounds.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) / 2), generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) / 2));
                this.mDrawable1.draw(canvas);
                bounds2.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds2) / 2), generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds2) / 2));
                this.mDrawable2.draw(canvas);
                bounds3.offsetTo(i - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds3) / 2), generateBoxBody.b - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds3) / 2));
                this.mDrawable3.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.mReboundAnimator = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.mReboundAnimator.setDuration(300L);
        this.mReboundAnimator.addUpdateListener(new a());
        this.mReboundAnimator.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropOutAnimator = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.mDropOutAnimator.setDuration(300L);
        this.mDropOutAnimator.addUpdateListener(new c());
        this.mDropOutAnimator.addListener(new d());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mReboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mReboundAnimator.removeAllListeners();
            this.mReboundAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mDropOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.mDropOutAnimator.removeAllListeners();
            this.mDropOutAnimator = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mDropOutPercent = 0.0f;
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mHeaderHeight = i;
        int generateSideLength = generateSideLength();
        this.mDrawable1.setBounds(0, 0, generateSideLength, generateSideLength);
        this.mDrawable2.setBounds(0, 0, generateSideLength, generateSideLength);
        this.mDrawable3.setBounds(0, 0, generateSideLength, generateSideLength);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (!z || this.mState != RefreshState.Refreshing) {
            this.mReboundPercent = (((float) Math.max(0, i - i2)) * 1.0f) / ((float) i3);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        ValueAnimator valueAnimator = this.mDropOutAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        this.mState = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.mDropOutOverFlow = false;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.mAccentColor = iArr[1];
            }
        }
    }

    public DropBoxHeader(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropBoxHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mBoxBody = new e(null);
        this.mPaint.setAntiAlias(true);
        this.mAccentColor = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(DensityUtil.dp2px(150.0f));
        this.mSpinnerStyle = gd2.Scale;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DropBoxHeader);
        int i2 = R$styleable.DropBoxHeader_dhDrawable1;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mDrawable1 = obtainStyledAttributes.getDrawable(i2);
        } else {
            ap1 ap1 = new ap1();
            ap1.f("M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z");
            ap1.e(-1249039, -245496);
            this.mDrawable1 = ap1;
        }
        int i3 = R$styleable.DropBoxHeader_dhDrawable2;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.mDrawable2 = obtainStyledAttributes.getDrawable(i3);
        } else {
            ap1 ap12 = new ap1();
            ap12.f("M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z");
            ap12.e(-76695, -2773417);
            this.mDrawable2 = ap12;
        }
        int i4 = R$styleable.DropBoxHeader_dhDrawable3;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.mDrawable3 = obtainStyledAttributes.getDrawable(i4);
        } else {
            ap1 ap13 = new ap1();
            ap13.f("M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z");
            ap13.e(-6760607);
            this.mDrawable3 = ap13;
        }
        obtainStyledAttributes.recycle();
    }
}
