package com.youku.live.dago.liveplayback.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
public class PlayerSeekBar extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_THUMB_SIZE_DP = 16;
    public static final int DEFAULT_THUMB_SIZE_ON_DRAGGING_DP = 28;
    private final int INVALID_COLOR;
    private float dx;
    private boolean isDown;
    private boolean isRtl;
    private boolean isShowThumbText;
    private boolean isThumbOnDragging;
    private boolean isTouchToSeek;
    private boolean isTouchToSeekAnimEnd;
    private float mBackButtonHeight;
    private float mBackButtonWidth;
    private Bitmap mBackToLive;
    private int mBackgroundColor;
    private float mDelta;
    private boolean mIsLiveMode;
    private float mLeft;
    private float mMax;
    private float mMin;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private Paint mPaint;
    private Paint mPlayerBarPaint;
    private float mProgress;
    private Rect mRectText;
    private float mRight;
    private int mSecondTrackColor;
    private float mSecondTrackSize;
    private float mSecondXRight;
    private float mSecondaryProgress;
    private int mStarTrackColor;
    private Rect mTempRect;
    private float mTextSpace;
    private float mThumbCenterX;
    private int mThumbColor;
    private Bitmap mThumbImage;
    private float mThumbSize;
    private float mThumbSizeOnDragging;
    private int mThumbTextColor;
    private float mThumbTextSize;
    private int mTrackColor;
    private int mTrackEndColor;
    private float mTrackLength;
    private float mTrackPadding;
    private float mTrackSize;

    /* compiled from: Taobao */
    public interface OnSeekBarChangeListener {
        void onBackClicked(long j, long j2);

        void onProgressChanged(PlayerSeekBar playerSeekBar, long j, boolean z);

        void onStartTrackingTouch(PlayerSeekBar playerSeekBar);

        void onStopTrackingTouch(PlayerSeekBar playerSeekBar, long j, boolean z, boolean z2, long j2);

        void onTrackingPressDown(PlayerSeekBar playerSeekBar);
    }

    public PlayerSeekBar(Context context) {
        this(context, null);
    }

    private float calculateProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293230628")) {
            return ((Float) ipChange.ipc$dispatch("293230628", new Object[]{this})).floatValue();
        } else if (this.isRtl) {
            return (((this.mRight - this.mThumbCenterX) * this.mDelta) / this.mTrackLength) + this.mMin;
        } else {
            return (((this.mThumbCenterX - this.mLeft) * this.mDelta) / this.mTrackLength) + this.mMin;
        }
    }

    private float dp2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1607897975")) {
            return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
        }
        return ((Float) ipChange.ipc$dispatch("1607897975", new Object[]{this, Float.valueOf(f)})).floatValue();
    }

    private boolean drawStarSegmentsLine(float f, float f2, float f3, float f4, Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "341844976")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("341844976", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), canvas})).booleanValue();
    }

    private void drawTrack(float f, float f2, float f3, float f4, Canvas canvas) {
        int i;
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198365083")) {
            ipChange.ipc$dispatch("-1198365083", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), canvas});
            return;
        }
        this.mPaint.setShader(null);
        if (!drawStarSegmentsLine(f, f2, f3, f4, canvas)) {
            int i4 = this.mTrackColor;
            if (i4 == -1 || (i3 = this.mTrackEndColor) == -1) {
                i2 = -15885313;
                i = -16722945;
            } else {
                i2 = i4;
                i = i3;
            }
            this.mPaint.setShader(new LinearGradient(f, 0.0f, f3, 0.0f, i2, i, Shader.TileMode.CLAMP));
            canvas.drawLine(f, f2, f3, f4, this.mPaint);
        }
    }

    private void initSomeValues() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605600573")) {
            ipChange.ipc$dispatch("1605600573", new Object[]{this});
            return;
        }
        if (this.mMin == this.mMax) {
            this.mMin = 0.0f;
            this.mMax = 100.0f;
        }
        float f = this.mMin;
        float f2 = this.mMax;
        if (f > f2) {
            this.mMax = f;
            this.mMin = f2;
        }
        float f3 = this.mProgress;
        float f4 = this.mMin;
        if (f3 < f4) {
            this.mProgress = f4;
        }
        float f5 = this.mProgress;
        float f6 = this.mMax;
        if (f5 > f6) {
            this.mProgress = f6;
        }
        float f7 = this.mSecondTrackSize;
        float f8 = this.mTrackSize;
        if (f7 < f8) {
            this.mSecondTrackSize = f8 + dp2px(2.0f);
        }
        this.mDelta = this.mMax - this.mMin;
    }

    private boolean isThumbTouched(MotionEvent motionEvent) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126831946")) {
            return ((Boolean) ipChange.ipc$dispatch("2126831946", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled()) {
            return false;
        } else {
            if (this.mIsLiveMode) {
                i = (getMeasuredHeight() / 2) + (((int) this.mBackButtonHeight) / 2);
            } else {
                i = getMeasuredHeight() / 2;
            }
            if (motionEvent.getX() <= this.mThumbCenterX - 40.0f || motionEvent.getX() >= this.mThumbCenterX + 40.0f || motionEvent.getY() <= ((float) (i - 40)) || motionEvent.getY() >= ((float) (i + 40))) {
                return false;
            }
            return true;
        }
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361318975")) {
            return ((Boolean) ipChange.ipc$dispatch("361318975", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled() || motionEvent.getX() < 0.0f || motionEvent.getX() > ((float) getMeasuredWidth()) || motionEvent.getY() < 0.0f || motionEvent.getY() > ((float) getMeasuredHeight())) {
            return false;
        } else {
            return true;
        }
    }

    private float sp2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "265884806")) {
            return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
        }
        return ((Float) ipChange.ipc$dispatch("265884806", new Object[]{this, Float.valueOf(f)})).floatValue();
    }

    public boolean getLiveMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1473310214")) {
            return this.mIsLiveMode;
        }
        return ((Boolean) ipChange.ipc$dispatch("1473310214", new Object[]{this})).booleanValue();
    }

    public synchronized int getMax() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209218664")) {
            return ((Integer) ipChange.ipc$dispatch("209218664", new Object[]{this})).intValue();
        }
        return Math.round(this.mMax);
    }

    public float getMin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "216308919")) {
            return this.mMin;
        }
        return ((Float) ipChange.ipc$dispatch("216308919", new Object[]{this})).floatValue();
    }

    public int getProgress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1729373257")) {
            return Math.round(this.mProgress);
        }
        return ((Integer) ipChange.ipc$dispatch("-1729373257", new Object[]{this})).intValue();
    }

    public Bitmap getThumbImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1371926102")) {
            return this.mThumbImage;
        }
        return (Bitmap) ipChange.ipc$dispatch("-1371926102", new Object[]{this});
    }

    public PointF getThumbPoint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1033145938")) {
            return new PointF(this.mThumbCenterX + this.mLeft, (float) (getMeasuredHeight() / 2));
        }
        return (PointF) ipChange.ipc$dispatch("-1033145938", new Object[]{this});
    }

    public float getTrackLength() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-143450472")) {
            return this.mTrackLength;
        }
        return ((Float) ipChange.ipc$dispatch("-143450472", new Object[]{this})).floatValue();
    }

    public float getTrackPadding() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1221450501")) {
            return this.mTrackPadding;
        }
        return ((Float) ipChange.ipc$dispatch("-1221450501", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        Bitmap bitmap;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397594789")) {
            ipChange.ipc$dispatch("1397594789", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        float f3 = 0.0f;
        float measuredWidth = (float) getMeasuredWidth();
        if (this.mIsLiveMode) {
            f = (((float) (getMeasuredHeight() / 2)) - this.mSecondTrackSize) + (this.mBackButtonHeight / 2.0f);
        } else {
            f = ((float) (getMeasuredHeight() / 2)) - this.mSecondTrackSize;
        }
        boolean z = this.isShowThumbText;
        if (z) {
            f3 = this.mLeft;
            measuredWidth = this.mRight;
        }
        if (!z) {
            if (this.mIsLiveMode) {
                f2 = this.mTrackPadding;
            } else {
                f2 = this.mTrackPadding;
            }
            f3 += f2;
            measuredWidth -= f2;
        }
        boolean z2 = this.isThumbOnDragging;
        if (!z2) {
            if (this.isRtl) {
                this.mThumbCenterX = measuredWidth - ((float) ((int) (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mProgress - this.mMin))));
            } else {
                this.mThumbCenterX = ((float) ((int) (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mProgress - this.mMin)))) + f3;
            }
        }
        if (z && !z2 && this.isTouchToSeekAnimEnd) {
            this.mPaint.setColor(this.mThumbTextColor);
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mPaint.getTextBounds("0123456789", 0, 10, this.mRectText);
            canvas.drawText(String.valueOf(getProgress()), this.mThumbCenterX, ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mRectText)) + f + this.mThumbSizeOnDragging + this.mTextSpace, this.mPaint);
        }
        if (this.mIsLiveMode) {
            this.mBackgroundColor = Color.parseColor("#59d2d2d2");
        } else {
            this.mBackgroundColor = Color.parseColor("#59d2d2d2");
        }
        this.mPaint.setColor(this.mBackgroundColor);
        this.mPaint.setStrokeWidth(this.mSecondTrackSize);
        canvas.drawLine(f3, f, measuredWidth, f, this.mPaint);
        this.mSecondXRight = (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mSecondaryProgress - this.mMin)) + f3;
        this.mPaint.setColor(this.mSecondTrackColor);
        this.mPaint.setStrokeWidth(this.mSecondTrackSize);
        canvas.drawLine(f3, f, f3 + (((this.mTrackLength * 1.0f) / this.mDelta) * (this.mSecondaryProgress - this.mMin)), f, this.mPaint);
        drawTrack(f3, f, this.mThumbCenterX, f, canvas);
        if (this.isThumbOnDragging) {
            this.mPaint.setColor(this.mThumbColor);
            float f4 = this.mThumbCenterX;
            float f5 = this.mThumbSizeOnDragging;
            int i = this.mThumbColor;
            this.mPaint.setShader(new RadialGradient(f4, f, f5, new int[]{-1711276033 & i, 16777215 & i}, (float[]) null, Shader.TileMode.CLAMP));
            canvas.drawCircle(this.mThumbCenterX, f, this.mThumbSizeOnDragging, this.mPaint);
        }
        this.mPaint.setShader(null);
        float f6 = this.mThumbSize;
        float f7 = this.mThumbCenterX - (f6 / 2.0f);
        float f8 = f - (f6 / 2.0f);
        if (this.mThumbImage == null) {
            if (this.mPlayerBarPaint == null) {
                Paint paint = new Paint();
                this.mPlayerBarPaint = paint;
                paint.setAntiAlias(true);
            }
            this.mPlayerBarPaint.setColor(-2147429377);
            float f9 = (float) ((int) f7);
            float f10 = this.mThumbSize;
            float f11 = (float) ((int) f8);
            canvas.drawCircle((f10 / 2.0f) + f9, (f10 / 2.0f) + f11, f10 / 2.0f, this.mPlayerBarPaint);
            this.mPlayerBarPaint.setColor(-16722945);
            float f12 = this.mThumbSize;
            canvas.drawCircle(f9 + (f12 / 2.0f), f11 + (f12 / 2.0f), (float) ((((int) this.mThumbSize) * 9) / 32), this.mPlayerBarPaint);
        } else {
            this.mTempRect.set((int) f7, (int) f8, (int) (f7 + f6), (int) (f6 + f8));
            canvas.drawBitmap(this.mThumbImage, (Rect) null, this.mTempRect, (Paint) null);
        }
        if (this.mIsLiveMode && this.mProgress < this.mSecondaryProgress && (bitmap = this.mBackToLive) != null) {
            float f13 = this.mSecondXRight;
            float f14 = this.mBackButtonWidth;
            int i2 = (int) f8;
            canvas.drawBitmap(bitmap, (Rect) null, new Rect((int) (f13 - (f14 / 2.0f)), i2 - ((int) this.mBackButtonHeight), (int) (f13 + (f14 / 2.0f)), i2), (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680129976")) {
            ipChange.ipc$dispatch("-680129976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        float f = this.mThumbSizeOnDragging * 2.0f;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            f += (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mRectText);
        }
        float f2 = f + (this.mTextSpace * 2.0f);
        if (this.mIsLiveMode) {
            f2 += this.mBackButtonHeight;
        }
        setMeasuredDimension(View.resolveSize((int) dp2px(180.0f), i), (int) f2);
        this.mLeft = this.mTrackPadding;
        this.mRight = ((float) getMeasuredWidth()) - this.mTrackPadding;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize(this.mThumbTextSize);
            this.mLeft = Math.max(this.mThumbSizeOnDragging, (float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectText) / 2)) + ((float) ((int) this.mTextSpace));
            this.mRight = (((float) getMeasuredWidth()) - Math.max(this.mThumbSizeOnDragging, (float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectText) / 2))) - ((float) ((int) this.mTextSpace));
        }
        this.mTrackLength = this.mRight - this.mLeft;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "316813405")) {
            ipChange.ipc$dispatch("316813405", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mProgress = bundle.getFloat("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            setProgress(this.mProgress);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938895446")) {
            return (Parcelable) ipChange.ipc$dispatch("-1938895446", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.mProgress);
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x013b;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864488866")) {
            return ((Boolean) ipChange.ipc$dispatch("1864488866", new Object[]{this, motionEvent})).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.isThumbOnDragging) {
                        float x = (float) ((int) (motionEvent.getX() + this.dx));
                        this.mThumbCenterX = x;
                        float f = this.mLeft;
                        if (x < f) {
                            this.mThumbCenterX = f;
                        }
                        float f2 = this.mThumbCenterX;
                        float f3 = this.mRight;
                        if (f2 > f3) {
                            this.mThumbCenterX = f3;
                        }
                        this.mProgress = calculateProgress();
                        invalidate();
                        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
                        if (onSeekBarChangeListener != null) {
                            onSeekBarChangeListener.onProgressChanged(this, (long) getProgress(), true);
                        }
                    }
                }
            }
            this.isDown = false;
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.isThumbOnDragging) {
                animate().setDuration(100).setStartDelay((this.isThumbOnDragging || !this.isTouchToSeek) ? 0 : 150).setListener(new AnimatorListenerAdapter() {
                    /* class com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationCancel(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1410841064")) {
                            ipChange.ipc$dispatch("-1410841064", new Object[]{this, animator});
                            return;
                        }
                        PlayerSeekBar.this.invalidate();
                    }

                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1116967913")) {
                            ipChange.ipc$dispatch("-1116967913", new Object[]{this, animator});
                            return;
                        }
                        PlayerSeekBar.this.invalidate();
                    }
                }).start();
                this.isThumbOnDragging = false;
                OnSeekBarChangeListener onSeekBarChangeListener2 = this.mOnSeekBarChangeListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStopTrackingTouch(this, (long) getProgress(), true, this.mIsLiveMode, (long) this.mSecondaryProgress);
                }
            }
        } else {
            this.isDown = true;
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            OnSeekBarChangeListener onSeekBarChangeListener3 = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener3 != null) {
                onSeekBarChangeListener3.onTrackingPressDown(this);
            }
            boolean isThumbTouched = isThumbTouched(motionEvent);
            this.isThumbOnDragging = isThumbTouched;
            if (isThumbTouched) {
                invalidate();
                OnSeekBarChangeListener onSeekBarChangeListener4 = this.mOnSeekBarChangeListener;
                if (onSeekBarChangeListener4 != null) {
                    onSeekBarChangeListener4.onStartTrackingTouch(this);
                }
            } else if (this.isTouchToSeek && isTrackTouched(motionEvent)) {
                int x2 = (int) motionEvent.getX();
                motionEvent.getY();
                if (this.mIsLiveMode) {
                    float f4 = (float) x2;
                    float f5 = this.mSecondXRight;
                    float f6 = this.mBackButtonWidth;
                    if (f4 > f5 - (f6 / 2.0f) && f4 < f5 + (f6 / 2.0f)) {
                        OnSeekBarChangeListener onSeekBarChangeListener5 = this.mOnSeekBarChangeListener;
                        if (onSeekBarChangeListener5 != null) {
                            float f7 = this.mSecondaryProgress;
                            onSeekBarChangeListener5.onBackClicked((long) f7, (long) f7);
                        }
                    }
                }
                this.isThumbOnDragging = true;
                float x3 = (float) ((int) motionEvent.getX());
                this.mThumbCenterX = x3;
                float f8 = this.mLeft;
                if (x3 < f8) {
                    this.mThumbCenterX = f8;
                }
                float f9 = this.mThumbCenterX;
                float f10 = this.mRight;
                if (f9 > f10) {
                    this.mThumbCenterX = f10;
                }
                this.mProgress = calculateProgress();
                invalidate();
            }
            this.dx = this.mThumbCenterX - motionEvent.getX();
        }
        if (this.isThumbOnDragging || this.isTouchToSeek || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setIsDragging(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100580088")) {
            ipChange.ipc$dispatch("-1100580088", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isThumbOnDragging = z;
    }

    public void setLiveMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661225442")) {
            ipChange.ipc$dispatch("-661225442", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsLiveMode = z;
    }

    public synchronized void setMax(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167319965")) {
            ipChange.ipc$dispatch("-167319965", new Object[]{this, Long.valueOf(j)});
            return;
        }
        if (j < 0) {
            j = 0;
        }
        float f = (float) j;
        if (f != this.mMax) {
            this.mMax = f;
            this.mDelta = f - this.mMin;
            postInvalidate();
        }
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192956874")) {
            ipChange.ipc$dispatch("1192956874", new Object[]{this, onSeekBarChangeListener});
            return;
        }
        this.mOnSeekBarChangeListener = onSeekBarChangeListener;
    }

    public void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160183928")) {
            ipChange.ipc$dispatch("-1160183928", new Object[]{this, Float.valueOf(f)});
        } else if (!this.isDown) {
            this.mProgress = f;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, (long) getProgress(), false);
            }
            postInvalidate();
        }
    }

    public void setSecondTrackColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792189834")) {
            ipChange.ipc$dispatch("1792189834", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mSecondTrackColor != i) {
            this.mSecondTrackColor = i;
            invalidate();
        }
    }

    public void setSecondaryProgress(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "445420096")) {
            ipChange.ipc$dispatch("445420096", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSecondaryProgress = (float) j;
        postInvalidate();
    }

    public void setThumbColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098149941")) {
            ipChange.ipc$dispatch("-1098149941", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mThumbColor != i) {
            this.mThumbColor = i;
            invalidate();
        }
    }

    public void setThumbImage(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958824722")) {
            ipChange.ipc$dispatch("-1958824722", new Object[]{this, bitmap});
            return;
        }
        this.mThumbImage = bitmap;
    }

    public void setThumbSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331867790")) {
            ipChange.ipc$dispatch("-1331867790", new Object[]{this, Float.valueOf(f)});
        } else if (this.mThumbSize != f) {
            this.mThumbSize = f;
            invalidate();
        }
    }

    public void setThumbSizeOnDragging(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849198624")) {
            ipChange.ipc$dispatch("1849198624", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mThumbSizeOnDragging = f;
    }

    public void setTrackColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997123062")) {
            ipChange.ipc$dispatch("997123062", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mTrackColor != i) {
            this.mTrackColor = i;
            this.mTrackEndColor = i;
            this.mStarTrackColor = i;
            invalidate();
        }
    }

    public void setTrackLineColor(@ColorInt int i, @ColorInt int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941398369")) {
            ipChange.ipc$dispatch("1941398369", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mTrackColor != i || this.mTrackEndColor != i2) {
            this.mTrackColor = i;
            this.mTrackEndColor = i2;
            this.mStarTrackColor = i;
            invalidate();
        }
    }

    public void setTrackPadding(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753960671")) {
            ipChange.ipc$dispatch("-753960671", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mTrackPadding = f;
    }

    public PlayerSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00c7, code lost:
        if (r9 == null) goto L_0x00cc;
     */
    public PlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTrackSize = dp2px(2.0f);
        this.mSecondTrackSize = dp2px(2.0f);
        this.mBackgroundColor = Color.parseColor("#59d2d2d2");
        this.INVALID_COLOR = -1;
        this.mTrackColor = -1;
        this.mTrackEndColor = -1;
        this.isShowThumbText = false;
        this.mThumbTextSize = sp2px(14.0f);
        this.mThumbColor = Color.parseColor("#FF00D3FF");
        this.mTrackPadding = getResources().getDimension(R.dimen.seek_bar_padding);
        this.mTempRect = new Rect();
        this.mThumbImage = null;
        this.mThumbSizeOnDragging = dp2px(28.0f);
        this.mThumbSize = dp2px(16.0f);
        this.isTouchToSeekAnimEnd = true;
        this.isRtl = false;
        this.dx = 0.0f;
        this.isDown = false;
        this.mBackToLive = BitmapFactory.decodeResource(getResources(), R.drawable.dago_back_to_live);
        this.mBackButtonHeight = dp2px(26.0f);
        this.mBackButtonWidth = dp2px(74.0f);
        this.mOnSeekBarChangeListener = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LivePlayerSeekBar, i, 0);
        try {
            this.mMin = obtainStyledAttributes.getFloat(R.styleable.LivePlayerSeekBar_min, 0.0f);
            int i2 = R.styleable.LivePlayerSeekBar_track_color;
            this.mTrackColor = obtainStyledAttributes.getColor(i2, -1);
            this.mStarTrackColor = obtainStyledAttributes.getColor(i2, -15885313);
            int color = obtainStyledAttributes.getColor(R.styleable.LivePlayerSeekBar_second_track_color, Color.parseColor("#CCCCCC"));
            this.mSecondTrackColor = color;
            this.mThumbTextColor = obtainStyledAttributes.getColor(R.styleable.LivePlayerSeekBar_thumb_text_color, color);
            this.isTouchToSeek = obtainStyledAttributes.getBoolean(R.styleable.LivePlayerSeekBar_touch_to_seek, true);
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            throw th;
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mRectText = new Rect();
        this.mTextSpace = dp2px(2.0f);
        initSomeValues();
    }
}
