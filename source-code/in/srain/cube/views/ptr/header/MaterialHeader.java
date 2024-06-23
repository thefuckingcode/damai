package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.PtrUIHandlerHook;
import tb.rv1;

/* compiled from: Taobao */
public class MaterialHeader extends View implements PtrUIHandler {
    private MaterialProgressDrawable mDrawable;
    private PtrFrameLayout mPtrFrameLayout;
    private float mScale = 1.0f;
    private Animation mScaleAnimation = new Animation() {
        /* class in.srain.cube.views.ptr.header.MaterialHeader.AnonymousClass1 */

        public void applyTransformation(float f, Transformation transformation) {
            MaterialHeader.this.mScale = 1.0f - f;
            MaterialHeader.this.mDrawable.setAlpha((int) (MaterialHeader.this.mScale * 255.0f));
            MaterialHeader.this.invalidate();
        }
    };

    /* compiled from: Taobao */
    class a implements Animation.AnimationListener {
        final /* synthetic */ PtrUIHandlerHook a;

        a(MaterialHeader materialHeader, PtrUIHandlerHook ptrUIHandlerHook) {
            this.a = ptrUIHandlerHook;
        }

        public void onAnimationEnd(Animation animation) {
            this.a.resume();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public MaterialHeader(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        this.mDrawable = materialProgressDrawable;
        materialProgressDrawable.h(-1);
        this.mDrawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = this.mDrawable.getBounds();
        canvas.translate((float) (getPaddingLeft() + ((getMeasuredWidth() - this.mDrawable.getIntrinsicWidth()) / 2)), (float) getPaddingTop());
        float f = this.mScale;
        canvas.scale(f, f, bounds.exactCenterX(), bounds.exactCenterY());
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        this.mDrawable.setBounds(0, 0, intrinsicHeight, intrinsicHeight);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mDrawable.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1) {
        float min = Math.min(1.0f, rv1.c());
        if (b == 2) {
            this.mDrawable.setAlpha((int) (255.0f * min));
            this.mDrawable.p(true);
            this.mDrawable.m(0.0f, Math.min(0.8f, min * 0.8f));
            this.mDrawable.g(Math.min(1.0f, min));
            this.mDrawable.j((((0.4f * min) - 16.0f) + (min * 2.0f)) * 0.5f);
            invalidate();
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        this.mDrawable.setAlpha(255);
        this.mDrawable.start();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        this.mDrawable.stop();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        this.mScale = 1.0f;
        this.mDrawable.stop();
    }

    public void setColorSchemeColors(int[] iArr) {
        this.mDrawable.i(iArr);
        invalidate();
    }

    public void setPtrFrameLayout(PtrFrameLayout ptrFrameLayout) {
        AnonymousClass2 r0 = new PtrUIHandlerHook() {
            /* class in.srain.cube.views.ptr.header.MaterialHeader.AnonymousClass2 */

            public void run() {
                MaterialHeader materialHeader = MaterialHeader.this;
                materialHeader.startAnimation(materialHeader.mScaleAnimation);
            }
        };
        this.mScaleAnimation.setDuration(200);
        this.mScaleAnimation.setAnimationListener(new a(this, r0));
        this.mPtrFrameLayout = ptrFrameLayout;
        ptrFrameLayout.setRefreshCompleteHook(r0);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
