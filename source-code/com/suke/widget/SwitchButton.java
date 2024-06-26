package com.suke.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* compiled from: Taobao */
public class SwitchButton extends View implements Checkable {
    private static final int DEFAULT_HEIGHT = dp2pxInt(36.0f);
    private static final int DEFAULT_WIDTH = dp2pxInt(58.0f);
    private final int ANIMATE_STATE_DRAGING = 2;
    private final int ANIMATE_STATE_NONE = 0;
    private final int ANIMATE_STATE_PENDING_DRAG = 1;
    private final int ANIMATE_STATE_PENDING_RESET = 3;
    private final int ANIMATE_STATE_PENDING_SETTLE = 4;
    private final int ANIMATE_STATE_SWITCH = 5;
    private c afterState;
    private int animateState = 0;
    private Animator.AnimatorListener animatorListener = new b();
    private ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new a();
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int background;
    private c beforeState;
    private int borderWidth;
    private float bottom;
    private float buttonMaxX;
    private float buttonMinX;
    private Paint buttonPaint;
    private float buttonRadius;
    private float centerX;
    private float centerY;
    private int checkLineColor;
    private float checkLineLength;
    private int checkLineWidth;
    private int checkedColor;
    private float checkedLineOffsetX;
    private float checkedLineOffsetY;
    private boolean enableEffect;
    private float height;
    private boolean isChecked;
    private boolean isEventBroadcast = false;
    private boolean isTouchingDown = false;
    private boolean isUiInited = false;
    private float left;
    private OnCheckedChangeListener onCheckedChangeListener;
    private Paint paint;
    private Runnable postPendingDrag = new Runnable() {
        /* class com.suke.widget.SwitchButton.AnonymousClass1 */

        public void run() {
            if (!SwitchButton.this.isInAnimating()) {
                SwitchButton.this.pendingDragState();
            }
        }
    };
    private RectF rect = new RectF();
    private float right;
    private int shadowColor;
    private boolean shadowEffect;
    private int shadowOffset;
    private int shadowRadius;
    private boolean showIndicator;
    private float top;
    private long touchDownTime;
    private int uncheckCircleColor;
    private float uncheckCircleOffsetX;
    private float uncheckCircleRadius;
    private int uncheckCircleWidth;
    private int uncheckColor;
    private ValueAnimator valueAnimator;
    private float viewRadius;
    private c viewState;
    private float width;

    /* compiled from: Taobao */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z);
    }

    /* compiled from: Taobao */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = SwitchButton.this.animateState;
            if (i == 1 || i == 3 || i == 4) {
                SwitchButton.this.viewState.c = ((Integer) SwitchButton.this.argbEvaluator.evaluate(floatValue, Integer.valueOf(SwitchButton.this.beforeState.c), Integer.valueOf(SwitchButton.this.afterState.c))).intValue();
                SwitchButton.this.viewState.d = SwitchButton.this.beforeState.d + ((SwitchButton.this.afterState.d - SwitchButton.this.beforeState.d) * floatValue);
                if (SwitchButton.this.animateState != 1) {
                    SwitchButton.this.viewState.a = SwitchButton.this.beforeState.a + ((SwitchButton.this.afterState.a - SwitchButton.this.beforeState.a) * floatValue);
                }
                SwitchButton.this.viewState.b = ((Integer) SwitchButton.this.argbEvaluator.evaluate(floatValue, Integer.valueOf(SwitchButton.this.beforeState.b), Integer.valueOf(SwitchButton.this.afterState.b))).intValue();
            } else if (i == 5) {
                SwitchButton.this.viewState.a = SwitchButton.this.beforeState.a + ((SwitchButton.this.afterState.a - SwitchButton.this.beforeState.a) * floatValue);
                float f = (SwitchButton.this.viewState.a - SwitchButton.this.buttonMinX) / (SwitchButton.this.buttonMaxX - SwitchButton.this.buttonMinX);
                SwitchButton.this.viewState.b = ((Integer) SwitchButton.this.argbEvaluator.evaluate(f, Integer.valueOf(SwitchButton.this.uncheckColor), Integer.valueOf(SwitchButton.this.checkedColor))).intValue();
                SwitchButton.this.viewState.d = SwitchButton.this.viewRadius * f;
                SwitchButton.this.viewState.c = ((Integer) SwitchButton.this.argbEvaluator.evaluate(f, 0, Integer.valueOf(SwitchButton.this.checkLineColor))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    }

    /* compiled from: Taobao */
    class b implements Animator.AnimatorListener {
        b() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int i = SwitchButton.this.animateState;
            if (i == 1) {
                SwitchButton.this.animateState = 2;
                SwitchButton.this.viewState.c = 0;
                SwitchButton.this.viewState.d = SwitchButton.this.viewRadius;
                SwitchButton.this.postInvalidate();
            } else if (i == 3) {
                SwitchButton.this.animateState = 0;
                SwitchButton.this.postInvalidate();
            } else if (i == 4) {
                SwitchButton.this.animateState = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.broadcastEvent();
            } else if (i == 5) {
                SwitchButton switchButton = SwitchButton.this;
                switchButton.isChecked = true ^ switchButton.isChecked;
                SwitchButton.this.animateState = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.broadcastEvent();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        float a;
        int b;
        int c;
        float d;

        c() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void b(c cVar) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.d = cVar.d;
        }
    }

    public SwitchButton(Context context) {
        super(context);
        init(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void broadcastEvent() {
        OnCheckedChangeListener onCheckedChangeListener2 = this.onCheckedChangeListener;
        if (onCheckedChangeListener2 != null) {
            this.isEventBroadcast = true;
            onCheckedChangeListener2.onCheckedChanged(this, isChecked());
        }
        this.isEventBroadcast = false;
    }

    private static float dp2px(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    private static int dp2pxInt(float f) {
        return (int) dp2px(f);
    }

    private void drawArc(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, Paint paint2) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawArc(f, f2, f3, f4, f5, f6, true, paint2);
            return;
        }
        this.rect.set(f, f2, f3, f4);
        canvas.drawArc(this.rect, f5, f6, true, paint2);
    }

    private void drawButton(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.buttonRadius, this.buttonPaint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(1.0f);
        this.paint.setColor(-2236963);
        canvas.drawCircle(f, f2, this.buttonRadius, this.paint);
    }

    private void drawRoundRect(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint2) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint2);
            return;
        }
        this.rect.set(f, f2, f3, f4);
        canvas.drawRoundRect(this.rect, f5, f5, paint2);
    }

    private void drawUncheckIndicator(Canvas canvas) {
        drawUncheckIndicator(canvas, this.uncheckCircleColor, (float) this.uncheckCircleWidth, this.right - this.uncheckCircleOffsetX, this.centerY, this.uncheckCircleRadius, this.paint);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton) : null;
        this.shadowEffect = optBoolean(obtainStyledAttributes, R$styleable.SwitchButton_sb_shadow_effect, true);
        this.uncheckCircleColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_uncheckcircle_color, -5592406);
        this.uncheckCircleWidth = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_uncheckcircle_width, dp2pxInt(1.5f));
        this.uncheckCircleOffsetX = dp2px(10.0f);
        this.uncheckCircleRadius = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_uncheckcircle_radius, dp2px(4.0f));
        this.checkedLineOffsetX = dp2px(4.0f);
        this.checkedLineOffsetY = dp2px(4.0f);
        this.shadowRadius = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_shadow_radius, dp2pxInt(2.5f));
        this.shadowOffset = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_shadow_offset, dp2pxInt(1.5f));
        this.shadowColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_shadow_color, 855638016);
        this.uncheckColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_uncheck_color, -2236963);
        this.checkedColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_checked_color, -11414681);
        this.borderWidth = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_border_width, dp2pxInt(1.0f));
        this.checkLineColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_checkline_color, -1);
        this.checkLineWidth = optPixelSize(obtainStyledAttributes, R$styleable.SwitchButton_sb_checkline_width, dp2pxInt(1.0f));
        this.checkLineLength = dp2px(6.0f);
        int optColor = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_button_color, -1);
        int optInt = optInt(obtainStyledAttributes, R$styleable.SwitchButton_sb_effect_duration, 300);
        this.isChecked = optBoolean(obtainStyledAttributes, R$styleable.SwitchButton_sb_checked, false);
        this.showIndicator = optBoolean(obtainStyledAttributes, R$styleable.SwitchButton_sb_show_indicator, true);
        this.background = optColor(obtainStyledAttributes, R$styleable.SwitchButton_sb_background, -1);
        this.enableEffect = optBoolean(obtainStyledAttributes, R$styleable.SwitchButton_sb_enable_effect, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.paint = new Paint(1);
        Paint paint2 = new Paint(1);
        this.buttonPaint = paint2;
        paint2.setColor(optColor);
        if (this.shadowEffect) {
            this.buttonPaint.setShadowLayer((float) this.shadowRadius, 0.0f, (float) this.shadowOffset, this.shadowColor);
        }
        this.viewState = new c();
        this.beforeState = new c();
        this.afterState = new c();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = ofFloat;
        ofFloat.setDuration((long) optInt);
        this.valueAnimator.setRepeatCount(0);
        this.valueAnimator.addUpdateListener(this.animatorUpdateListener);
        this.valueAnimator.addListener(this.animatorListener);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private boolean isDragState() {
        return this.animateState == 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isInAnimating() {
        return this.animateState != 0;
    }

    private boolean isPendingDragState() {
        int i = this.animateState;
        return i == 1 || i == 3;
    }

    private static boolean optBoolean(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    private static int optColor(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    private static int optInt(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    private static float optPixelSize(TypedArray typedArray, int i, float f) {
        return typedArray == null ? f : typedArray.getDimension(i, f);
    }

    private void pendingCancelDragState() {
        if (isDragState() || isPendingDragState()) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 3;
            this.beforeState.b(this.viewState);
            if (isChecked()) {
                setCheckedViewState(this.afterState);
            } else {
                setUncheckViewState(this.afterState);
            }
            this.valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pendingDragState() {
        if (!isInAnimating() && this.isTouchingDown) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 1;
            this.beforeState.b(this.viewState);
            this.afterState.b(this.viewState);
            if (isChecked()) {
                c cVar = this.afterState;
                int i = this.checkedColor;
                cVar.b = i;
                cVar.a = this.buttonMaxX;
                cVar.c = i;
            } else {
                c cVar2 = this.afterState;
                cVar2.b = this.uncheckColor;
                cVar2.a = this.buttonMinX;
                cVar2.d = this.viewRadius;
            }
            this.valueAnimator.start();
        }
    }

    private void pendingSettleState() {
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.cancel();
        }
        this.animateState = 4;
        this.beforeState.b(this.viewState);
        if (isChecked()) {
            setCheckedViewState(this.afterState);
        } else {
            setUncheckViewState(this.afterState);
        }
        this.valueAnimator.start();
    }

    private void setCheckedViewState(c cVar) {
        cVar.d = this.viewRadius;
        cVar.b = this.checkedColor;
        cVar.c = this.checkLineColor;
        cVar.a = this.buttonMaxX;
    }

    private void setUncheckViewState(c cVar) {
        cVar.d = 0.0f;
        cVar.b = this.uncheckColor;
        cVar.c = 0;
        cVar.a = this.buttonMinX;
    }

    /* access modifiers changed from: protected */
    public void drawCheckedIndicator(Canvas canvas) {
        int i = this.viewState.c;
        float f = (float) this.checkLineWidth;
        float f2 = this.left;
        float f3 = this.viewRadius;
        float f4 = (f2 + f3) - this.checkedLineOffsetX;
        float f5 = this.centerY;
        float f6 = this.checkLineLength;
        drawCheckedIndicator(canvas, i, f, f4, f5 - f6, (f2 + f3) - this.checkedLineOffsetY, f5 + f6, this.paint);
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStrokeWidth((float) this.borderWidth);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.background);
        drawRoundRect(canvas, this.left, this.top, this.right, this.bottom, this.viewRadius, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.uncheckColor);
        drawRoundRect(canvas, this.left, this.top, this.right, this.bottom, this.viewRadius, this.paint);
        if (this.showIndicator) {
            drawUncheckIndicator(canvas);
        }
        float f = this.viewState.d * 0.5f;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.viewState.b);
        this.paint.setStrokeWidth(((float) this.borderWidth) + (f * 2.0f));
        drawRoundRect(canvas, this.left + f, this.top + f, this.right - f, this.bottom - f, this.viewRadius, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(1.0f);
        float f2 = this.left;
        float f3 = this.top;
        float f4 = this.viewRadius;
        drawArc(canvas, f2, f3, f2 + (f4 * 2.0f), f3 + (f4 * 2.0f), 90.0f, 180.0f, this.paint);
        float f5 = this.left;
        float f6 = this.viewRadius;
        float f7 = this.top;
        canvas.drawRect(f5 + f6, f7, this.viewState.a, f7 + (f6 * 2.0f), this.paint);
        if (this.showIndicator) {
            drawCheckedIndicator(canvas);
        }
        drawButton(canvas, this.viewState.a, this.centerY);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(DEFAULT_WIDTH, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(DEFAULT_HEIGHT, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float max = (float) Math.max(this.shadowRadius + this.shadowOffset, this.borderWidth);
        float f = ((float) i2) - max;
        float f2 = f - max;
        this.height = f2;
        float f3 = ((float) i) - max;
        this.width = f3 - max;
        float f4 = f2 * 0.5f;
        this.viewRadius = f4;
        this.buttonRadius = f4 - ((float) this.borderWidth);
        this.left = max;
        this.top = max;
        this.right = f3;
        this.bottom = f;
        this.centerX = (max + f3) * 0.5f;
        this.centerY = (f + max) * 0.5f;
        this.buttonMinX = max + f4;
        this.buttonMaxX = f3 - f4;
        if (isChecked()) {
            setCheckedViewState(this.viewState);
        } else {
            setUncheckViewState(this.viewState);
        }
        this.isUiInited = true;
        postInvalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.isTouchingDown = true;
            this.touchDownTime = System.currentTimeMillis();
            removeCallbacks(this.postPendingDrag);
            postDelayed(this.postPendingDrag, 100);
        } else if (actionMasked == 1) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (System.currentTimeMillis() - this.touchDownTime <= 300) {
                toggle();
            } else if (isDragState()) {
                if (Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f) {
                    z = true;
                }
                if (z == isChecked()) {
                    pendingCancelDragState();
                } else {
                    this.isChecked = z;
                    pendingSettleState();
                }
            } else if (isPendingDragState()) {
                pendingCancelDragState();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (isPendingDragState()) {
                float max = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                c cVar = this.viewState;
                float f = this.buttonMinX;
                cVar.a = f + ((this.buttonMaxX - f) * max);
            } else if (isDragState()) {
                float max2 = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                c cVar2 = this.viewState;
                float f2 = this.buttonMinX;
                cVar2.a = f2 + ((this.buttonMaxX - f2) * max2);
                cVar2.b = ((Integer) this.argbEvaluator.evaluate(max2, Integer.valueOf(this.uncheckColor), Integer.valueOf(this.checkedColor))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (isPendingDragState() || isDragState()) {
                pendingCancelDragState();
            }
        }
        return true;
    }

    public void setChecked(boolean z) {
        if (z == isChecked()) {
            postInvalidate();
        } else {
            toggle(this.enableEffect, false);
        }
    }

    public void setEnableEffect(boolean z) {
        this.enableEffect = z;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setShadowEffect(boolean z) {
        if (this.shadowEffect != z) {
            this.shadowEffect = z;
            if (z) {
                this.buttonPaint.setShadowLayer((float) this.shadowRadius, 0.0f, (float) this.shadowOffset, this.shadowColor);
            } else {
                this.buttonPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void toggle() {
        toggle(true);
    }

    private static int optPixelSize(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* access modifiers changed from: protected */
    public void drawCheckedIndicator(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, Paint paint2) {
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(i);
        paint2.setStrokeWidth(f);
        canvas.drawLine(f2, f3, f4, f5, paint2);
    }

    /* access modifiers changed from: protected */
    public void drawUncheckIndicator(Canvas canvas, int i, float f, float f2, float f3, float f4, Paint paint2) {
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(i);
        paint2.setStrokeWidth(f);
        canvas.drawCircle(f2, f3, f4, paint2);
    }

    public void toggle(boolean z) {
        toggle(z, true);
    }

    private void toggle(boolean z, boolean z2) {
        if (isEnabled()) {
            if (this.isEventBroadcast) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.isUiInited) {
                this.isChecked = !this.isChecked;
                if (z2) {
                    broadcastEvent();
                }
            } else {
                if (this.valueAnimator.isRunning()) {
                    this.valueAnimator.cancel();
                }
                if (!this.enableEffect || !z) {
                    this.isChecked = !this.isChecked;
                    if (isChecked()) {
                        setCheckedViewState(this.viewState);
                    } else {
                        setUncheckViewState(this.viewState);
                    }
                    postInvalidate();
                    if (z2) {
                        broadcastEvent();
                        return;
                    }
                    return;
                }
                this.animateState = 5;
                this.beforeState.b(this.viewState);
                if (isChecked()) {
                    setUncheckViewState(this.afterState);
                } else {
                    setCheckedViewState(this.afterState);
                }
                this.valueAnimator.start();
            }
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }
}
