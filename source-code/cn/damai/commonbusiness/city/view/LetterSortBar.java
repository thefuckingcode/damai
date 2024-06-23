package cn.damai.commonbusiness.city.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.MotionEventCompat;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class LetterSortBar extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isUpdate;
    private int mActivePointerId;
    private float mAnimStep;
    private int mChoose;
    private String[] mDefaultLetters;
    private final float mDensity;
    private float mHalfHeight;
    private float mHalfWidth;
    private float mInitialDownY;
    private boolean mIsBeingDragged;
    private RectF mIsDownRect;
    private float mLetterHeight;
    private List<String> mLetters;
    private OnTouchingLetterChangedListener mOnTouchingLetterChangedListener;
    private Paint mPaint;
    private boolean mStartEndAnim;
    private int mTextColor;
    private int mTouchSlop;
    private float mY;

    /* compiled from: Taobao */
    public interface OnTouchingLetterChangedListener {
        void onClickLetterChanged(String str, int i);

        void onDraggingLetterChanged(String str, int i);
    }

    public LetterSortBar(Context context) {
        this(context, null);
    }

    private int dip2px(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-550635320")) {
            return (int) ((((float) i) * this.mDensity) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("-550635320", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    private int getLettersSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-202196200")) {
            return getListSize(this.mLetters);
        }
        return ((Integer) ipChange.ipc$dispatch("-202196200", new Object[]{this})).intValue();
    }

    public static <T> int getListSize(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649835484")) {
            return ((Integer) ipChange.ipc$dispatch("1649835484", new Object[]{list})).intValue();
        } else if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496286052")) {
            return ((Float) ipChange.ipc$dispatch("-1496286052", new Object[]{this, motionEvent, Integer.valueOf(i)})).floatValue();
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1101086063")) {
            ipChange.ipc$dispatch("1101086063", new Object[]{this, motionEvent});
            return;
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            if (actionIndex != 0) {
                i = 0;
            }
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
        }
    }

    private void onSizeChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031960243")) {
            ipChange.ipc$dispatch("-1031960243", new Object[]{this});
        } else if (this.isUpdate) {
            int width = getWidth();
            int height = getHeight();
            this.mHalfWidth = (float) (width - dip2px(10));
            this.mHalfHeight = (float) ((height - getPaddingTop()) - getPaddingBottom());
            this.mLetterHeight = this.mHalfHeight / ((float) getLettersSize());
            this.mPaint.setTextSize((float) dip2px(12));
            this.mIsDownRect.set((float) (width - dip2px(40)), 0.0f, (float) width, (float) height);
            this.isUpdate = false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r8 <= 1.0f) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        if (r17.mIsBeingDragged == false) goto L_0x0082;
     */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549772203")) {
            ipChange.ipc$dispatch("1549772203", new Object[]{this, canvas});
            return;
        }
        onSizeChange();
        int i = 0;
        while (true) {
            int i2 = -1;
            float f3 = 0.0f;
            if (i >= getLettersSize()) {
                break;
            }
            if (!TextUtils.isEmpty(this.mLetters.get(i))) {
                float paddingTop = (this.mLetterHeight * ((float) (i + 1))) + ((float) getPaddingTop());
                if (this.mChoose != i || i == 0 || i == getLettersSize() - 1) {
                    float abs = Math.abs(((this.mY - paddingTop) / this.mHalfHeight) * 7.0f);
                    float max = Math.max(1.0f, 2.2f - abs);
                    if (this.mStartEndAnim && max != 1.0f) {
                        max -= this.mAnimStep;
                    }
                    max = 1.0f;
                    float f4 = 50.0f * abs;
                    if (paddingTop < this.mY) {
                        i2 = 1;
                    }
                    f3 = abs * 100.0f;
                    f = ((float) i2) * f4;
                    f2 = max;
                } else {
                    f2 = 2.16f;
                    f = 0.0f;
                }
                canvas.save();
                canvas.scale(f2, f2, (this.mHalfWidth * 1.2f) + f3, f + paddingTop);
                int i3 = 255;
                if (f2 == 1.0f) {
                    this.mPaint.setAlpha(255);
                    this.mPaint.setTypeface(Typeface.DEFAULT);
                } else {
                    int min = (int) ((1.0d - Math.min(0.9d, (double) (f2 - 1.0f))) * 255.0d);
                    if (this.mChoose != i) {
                        i3 = min;
                    }
                    this.mPaint.setAlpha(i3);
                    this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
                }
                canvas.drawText(this.mLetters.get(i), this.mHalfWidth, paddingTop, this.mPaint);
                canvas.restore();
            }
            i++;
        }
        if (this.mChoose == -1 && this.mStartEndAnim) {
            float f5 = this.mAnimStep;
            if (f5 <= 0.6f) {
                this.mAnimStep = f5 + 0.6f;
                postInvalidateDelayed(25);
                return;
            }
        }
        this.mAnimStep = 0.0f;
        this.mStartEndAnim = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979418148")) {
            return ((Boolean) ipChange.ipc$dispatch("-1979418148", new Object[]{this, motionEvent})).booleanValue();
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        return false;
                    }
                    float motionEventY = getMotionEventY(motionEvent, i);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    if (Math.abs(motionEventY - this.mInitialDownY) > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                        this.mIsBeingDragged = true;
                    }
                    if (this.mIsBeingDragged) {
                        this.mY = motionEventY;
                        int paddingTop = (int) ((((motionEventY - ((float) getPaddingTop())) - (this.mLetterHeight / 1.64f)) / this.mHalfHeight) * ((float) getLettersSize()));
                        if (this.mChoose != paddingTop && paddingTop >= 0 && paddingTop < getLettersSize()) {
                            this.mChoose = paddingTop;
                            if (this.mOnTouchingLetterChangedListener != null && paddingTop >= 0 && paddingTop < getLettersSize()) {
                                this.mOnTouchingLetterChangedListener.onDraggingLetterChanged(this.mLetters.get(paddingTop), paddingTop);
                            }
                        }
                        invalidate();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            if (this.mOnTouchingLetterChangedListener != null) {
                if (this.mIsBeingDragged) {
                    int i2 = this.mChoose;
                    if (i2 >= 0 && i2 < getLettersSize()) {
                        this.mOnTouchingLetterChangedListener.onDraggingLetterChanged(this.mLetters.get(this.mChoose), this.mChoose);
                    }
                } else {
                    int y = (int) (((motionEvent.getY() - ((float) getPaddingTop())) / this.mHalfHeight) * ((float) getLettersSize()));
                    if (y >= 0 && y < getLettersSize()) {
                        this.mOnTouchingLetterChangedListener.onClickLetterChanged(this.mLetters.get(y), y);
                    }
                }
            }
            this.mStartEndAnim = this.mIsBeingDragged;
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            this.mChoose = -1;
            this.mAnimStep = 0.0f;
            invalidate();
            return false;
        }
        int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mActivePointerId = pointerId;
        this.mIsBeingDragged = false;
        float motionEventY2 = getMotionEventY(motionEvent, pointerId);
        if (motionEventY2 == -1.0f || !this.mIsDownRect.contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        this.mInitialDownY = motionEventY2;
        return true;
    }

    public void setLetters(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83273315")) {
            ipChange.ipc$dispatch("83273315", new Object[]{this, list});
        } else if (getListSize(list) > 0) {
            this.mLetters = list;
            this.isUpdate = true;
            invalidate();
        }
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360826970")) {
            ipChange.ipc$dispatch("-1360826970", new Object[]{this, onTouchingLetterChangedListener});
            return;
        }
        this.mOnTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public LetterSortBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LetterSortBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String[] strArr = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, UTConstant.Args.UT_SUCCESS_F, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.mDefaultLetters = strArr;
        this.mLetters = Arrays.asList(strArr);
        this.mChoose = -1;
        this.mActivePointerId = -1;
        this.mIsDownRect = new RectF();
        this.mPaint = getPaint();
        this.mTextColor = Color.parseColor("#349CEC");
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mTextColor);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mDensity = getContext().getResources().getDisplayMetrics().density;
        setPadding(0, dip2px(20), 0, dip2px(20));
    }
}
