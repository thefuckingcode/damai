package cn.damai.uikit.switchbutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import cn.damai.uikit.R$attr;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yj;

/* compiled from: Taobao */
public class SwitchButton extends CompoundButton {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int[] CHECKED_PRESSED_STATE = {16842912, 16842910, 16842919};
    public static final int DEFAULT_ANIMATION_DURATION = 250;
    public static final int DEFAULT_THUMB_MARGIN_DP = 2;
    public static final float DEFAULT_THUMB_RANGE_RATIO = 1.8f;
    public static final int DEFAULT_THUMB_SIZE_DP = 20;
    public static final int DEFAULT_TINT_COLOR = 3309506;
    private static int[] UNCHECKED_PRESSED_STATE = {-16842912, 16842910, 16842919};
    private long mAnimationDuration;
    private ColorStateList mBackColor;
    private Drawable mBackDrawable;
    private int mBackHeight;
    private float mBackRadius;
    private RectF mBackRectF;
    private int mBackWidth;
    private boolean mCatch = false;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private int mClickTimeout;
    private int mCurrBackColor;
    private int mCurrThumbColor;
    private Drawable mCurrentBackDrawable;
    private boolean mDrawDebugRect = false;
    private boolean mFadeBack;
    private boolean mIsBackUseDrawable;
    private boolean mIsThumbUseDrawable;
    private float mLastX;
    private int mNextBackColor;
    private Drawable mNextBackDrawable;
    private Layout mOffLayout;
    private int mOffTextColor;
    private Layout mOnLayout;
    private int mOnTextColor;
    private Paint mPaint;
    private RectF mPresentThumbRectF;
    private float mProgress;
    private ObjectAnimator mProgressAnimator;
    private boolean mReady = false;
    private Paint mRectPaint;
    private boolean mRestoring = false;
    private RectF mSafeRectF;
    private float mStartX;
    private float mStartY;
    private int mTextAdjust;
    private int mTextExtra;
    private float mTextHeight;
    private CharSequence mTextOff;
    private RectF mTextOffRectF;
    private CharSequence mTextOn;
    private RectF mTextOnRectF;
    private TextPaint mTextPaint;
    private int mTextThumbInset;
    private float mTextWidth;
    private ColorStateList mThumbColor;
    private Drawable mThumbDrawable;
    private int mThumbHeight;
    private RectF mThumbMargin;
    private float mThumbRadius;
    private float mThumbRangeRatio;
    private RectF mThumbRectF;
    private int mThumbWidth;
    private int mTintColor;
    private int mTouchSlop;

    /* compiled from: Taobao */
    public static class SavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence offText;
        CharSequence onText;

        /* compiled from: Taobao */
        public static final class a implements Parcelable.Creator<SavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-906444235")) {
                    return new SavedState(parcel);
                }
                return (SavedState) ipChange.ipc$dispatch("-906444235", new Object[]{this, parcel});
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-266198800")) {
                    return new SavedState[i];
                }
                return (SavedState[]) ipChange.ipc$dispatch("-266198800", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1912314631")) {
                ipChange.ipc$dispatch("-1912314631", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.onText, parcel, i);
            TextUtils.writeToParcel(this.offText, parcel, i);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.onText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.offText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void catchView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362057038")) {
            ipChange.ipc$dispatch("362057038", new Object[]{this});
            return;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.mCatch = true;
    }

    private int ceil(double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-513589190")) {
            return (int) Math.ceil(d);
        }
        return ((Integer) ipChange.ipc$dispatch("-513589190", new Object[]{this, Double.valueOf(d)})).intValue();
    }

    private float getProgress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "37158011")) {
            return this.mProgress;
        }
        return ((Float) ipChange.ipc$dispatch("37158011", new Object[]{this})).floatValue();
    }

    private boolean getStatusBasedOnPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-767969080")) {
            return getProgress() > 0.5f;
        }
        return ((Boolean) ipChange.ipc$dispatch("-767969080", new Object[]{this})).booleanValue();
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArray;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i;
        boolean z;
        Drawable drawable;
        float f6;
        float f7;
        Drawable drawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        float f8;
        float f9;
        String str2;
        float f10;
        TypedArray typedArray2;
        ColorStateList colorStateList3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334381662")) {
            ipChange.ipc$dispatch("-334381662", new Object[]{this, attributeSet});
            return;
        }
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mRectPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.mTextPaint = getPaint();
        this.mThumbRectF = new RectF();
        this.mBackRectF = new RectF();
        this.mSafeRectF = new RectF();
        this.mThumbMargin = new RectF();
        this.mTextOnRectF = new RectF();
        this.mTextOffRectF = new RectF();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.mProgressAnimator = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mPresentThumbRectF = new RectF();
        float f11 = getResources().getDisplayMetrics().density * 2.0f;
        if (attributeSet == null) {
            typedArray = null;
        } else {
            typedArray = getContext().obtainStyledAttributes(attributeSet, R$styleable.SwitchButton);
        }
        if (typedArray != null) {
            drawable2 = typedArray.getDrawable(R$styleable.SwitchButton_kswThumbDrawable);
            ColorStateList colorStateList4 = typedArray.getColorStateList(R$styleable.SwitchButton_kswThumbColor);
            float dimension = typedArray.getDimension(R$styleable.SwitchButton_kswThumbMargin, f11);
            float dimension2 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbMarginLeft, dimension);
            float dimension3 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbMarginRight, dimension);
            float dimension4 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbMarginTop, dimension);
            float dimension5 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbMarginBottom, dimension);
            float dimension6 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbWidth, 0.0f);
            float dimension7 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbHeight, 0.0f);
            float dimension8 = typedArray.getDimension(R$styleable.SwitchButton_kswThumbRadius, -1.0f);
            float dimension9 = typedArray.getDimension(R$styleable.SwitchButton_kswBackRadius, -1.0f);
            Drawable drawable3 = typedArray.getDrawable(R$styleable.SwitchButton_kswBackDrawable);
            ColorStateList colorStateList5 = typedArray.getColorStateList(R$styleable.SwitchButton_kswBackColor);
            float f12 = typedArray.getFloat(R$styleable.SwitchButton_kswThumbRangeRatio, 1.8f);
            int integer = typedArray.getInteger(R$styleable.SwitchButton_kswAnimationDuration, 250);
            boolean z2 = typedArray.getBoolean(R$styleable.SwitchButton_kswFadeBack, true);
            int color = typedArray.getColor(R$styleable.SwitchButton_kswTintColor, 0);
            String string = typedArray.getString(R$styleable.SwitchButton_kswTextOn);
            String string2 = typedArray.getString(R$styleable.SwitchButton_kswTextOff);
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.SwitchButton_kswTextThumbInset, 0);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R$styleable.SwitchButton_kswTextExtra, 0);
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R$styleable.SwitchButton_kswTextAdjust, 0);
            typedArray.recycle();
            f = dimension9;
            colorStateList2 = colorStateList4;
            f9 = dimension3;
            i2 = color;
            f7 = dimension6;
            drawable = drawable3;
            f3 = dimension5;
            str = string;
            i4 = dimensionPixelSize2;
            i = integer;
            z = z2;
            f4 = f12;
            f5 = dimension8;
            colorStateList = colorStateList5;
            f8 = dimension4;
            i3 = dimensionPixelSize3;
            str2 = string2;
            f2 = dimension2;
            f6 = dimension7;
            i5 = dimensionPixelSize;
        } else {
            str2 = null;
            f9 = 0.0f;
            f8 = 0.0f;
            str = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            colorStateList2 = null;
            colorStateList = null;
            drawable2 = null;
            f7 = 0.0f;
            f6 = 0.0f;
            drawable = null;
            z = true;
            i = 250;
            f5 = -1.0f;
            f4 = 1.8f;
            f3 = 0.0f;
            f2 = 0.0f;
            f = -1.0f;
        }
        if (attributeSet == null) {
            f10 = f8;
            typedArray2 = null;
        } else {
            f10 = f8;
            typedArray2 = getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
        }
        if (typedArray2 != null) {
            colorStateList3 = colorStateList;
            boolean z3 = typedArray2.getBoolean(0, true);
            boolean z4 = typedArray2.getBoolean(1, z3);
            setFocusable(z3);
            setClickable(z4);
            typedArray2.recycle();
        } else {
            colorStateList3 = colorStateList;
            setFocusable(true);
            setClickable(true);
        }
        this.mTextOn = str;
        this.mTextOff = str2;
        this.mTextThumbInset = i5;
        this.mTextExtra = i4;
        this.mTextAdjust = i3;
        this.mThumbDrawable = drawable2;
        this.mThumbColor = colorStateList2;
        this.mIsThumbUseDrawable = drawable2 != null;
        this.mTintColor = i2;
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R$attr.colorAccent, typedValue, true)) {
                this.mTintColor = typedValue.data;
            } else {
                this.mTintColor = DEFAULT_TINT_COLOR;
            }
        }
        if (!this.mIsThumbUseDrawable && this.mThumbColor == null) {
            ColorStateList b = yj.b(this.mTintColor);
            this.mThumbColor = b;
            this.mCurrThumbColor = b.getDefaultColor();
        }
        this.mThumbWidth = ceil((double) f7);
        this.mThumbHeight = ceil((double) f6);
        this.mBackDrawable = drawable;
        this.mBackColor = colorStateList3;
        boolean z5 = drawable != null;
        this.mIsBackUseDrawable = z5;
        if (!z5 && colorStateList3 == null) {
            ColorStateList a2 = yj.a(this.mTintColor);
            this.mBackColor = a2;
            int defaultColor = a2.getDefaultColor();
            this.mCurrBackColor = defaultColor;
            this.mNextBackColor = this.mBackColor.getColorForState(CHECKED_PRESSED_STATE, defaultColor);
        }
        this.mThumbMargin.set(f2, f10, f9, f3);
        this.mThumbRangeRatio = this.mThumbMargin.width() >= 0.0f ? Math.max(f4, 1.0f) : f4;
        this.mThumbRadius = f5;
        this.mBackRadius = f;
        long j = (long) i;
        this.mAnimationDuration = j;
        this.mFadeBack = z;
        this.mProgressAnimator.setDuration(j);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private Layout makeLayout(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239694963")) {
            return (Layout) ipChange.ipc$dispatch("-239694963", new Object[]{this, charSequence});
        }
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    private int measureHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666209165")) {
            return ((Integer) ipChange.ipc$dispatch("1666209165", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.mThumbHeight == 0 && this.mIsThumbUseDrawable) {
            this.mThumbHeight = this.mThumbDrawable.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            int i2 = this.mThumbHeight;
            if (i2 != 0) {
                RectF rectF = this.mThumbMargin;
                int ceil = ceil((double) (((float) i2) + rectF.top + rectF.bottom));
                this.mBackHeight = ceil;
                int ceil2 = ceil((double) Math.max((float) ceil, this.mTextHeight));
                this.mBackHeight = ceil2;
                if ((((float) ((ceil2 + getPaddingTop()) + getPaddingBottom())) - Math.min(0.0f, this.mThumbMargin.top)) - Math.min(0.0f, this.mThumbMargin.bottom) > ((float) size)) {
                    this.mThumbHeight = 0;
                }
            }
            if (this.mThumbHeight == 0) {
                int ceil3 = ceil((double) (((float) ((size - getPaddingTop()) - getPaddingBottom())) + Math.min(0.0f, this.mThumbMargin.top) + Math.min(0.0f, this.mThumbMargin.bottom)));
                this.mBackHeight = ceil3;
                if (ceil3 < 0) {
                    this.mBackHeight = 0;
                    this.mThumbHeight = 0;
                    return size;
                }
                RectF rectF2 = this.mThumbMargin;
                this.mThumbHeight = ceil((double) ((((float) ceil3) - rectF2.top) - rectF2.bottom));
            }
            if (this.mThumbHeight >= 0) {
                return size;
            }
            this.mBackHeight = 0;
            this.mThumbHeight = 0;
            return size;
        }
        if (this.mThumbHeight == 0) {
            this.mThumbHeight = ceil((double) (getResources().getDisplayMetrics().density * 20.0f));
        }
        RectF rectF3 = this.mThumbMargin;
        int ceil4 = ceil((double) (((float) this.mThumbHeight) + rectF3.top + rectF3.bottom));
        this.mBackHeight = ceil4;
        if (ceil4 < 0) {
            this.mBackHeight = 0;
            this.mThumbHeight = 0;
            return size;
        }
        int ceil5 = ceil((double) (this.mTextHeight - ((float) ceil4)));
        if (ceil5 > 0) {
            this.mBackHeight += ceil5;
            this.mThumbHeight += ceil5;
        }
        int max = Math.max(this.mThumbHeight, this.mBackHeight);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int measureWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199762050")) {
            return ((Integer) ipChange.ipc$dispatch("1199762050", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.mThumbWidth == 0 && this.mIsThumbUseDrawable) {
            this.mThumbWidth = this.mThumbDrawable.getIntrinsicWidth();
        }
        int ceil = ceil((double) this.mTextWidth);
        if (this.mThumbRangeRatio == 0.0f) {
            this.mThumbRangeRatio = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i2 = this.mThumbWidth;
            if (i2 != 0) {
                int ceil2 = ceil((double) (((float) i2) * this.mThumbRangeRatio));
                RectF rectF = this.mThumbMargin;
                int ceil3 = (this.mTextExtra + ceil) - ((ceil2 - this.mThumbWidth) + ceil((double) Math.max(rectF.left, rectF.right)));
                float f = (float) ceil2;
                RectF rectF2 = this.mThumbMargin;
                int ceil4 = ceil((double) (rectF2.left + f + rectF2.right + ((float) Math.max(ceil3, 0))));
                this.mBackWidth = ceil4;
                if (ceil4 < 0) {
                    this.mThumbWidth = 0;
                }
                if (f + Math.max(this.mThumbMargin.left, 0.0f) + Math.max(this.mThumbMargin.right, 0.0f) + ((float) Math.max(ceil3, 0)) > ((float) paddingLeft)) {
                    this.mThumbWidth = 0;
                }
            }
            if (this.mThumbWidth != 0) {
                return size;
            }
            int ceil5 = ceil((double) ((((float) ((size - getPaddingLeft()) - getPaddingRight())) - Math.max(this.mThumbMargin.left, 0.0f)) - Math.max(this.mThumbMargin.right, 0.0f)));
            if (ceil5 < 0) {
                this.mThumbWidth = 0;
                this.mBackWidth = 0;
                return size;
            }
            float f2 = (float) ceil5;
            this.mThumbWidth = ceil((double) (f2 / this.mThumbRangeRatio));
            RectF rectF3 = this.mThumbMargin;
            int ceil6 = ceil((double) (f2 + rectF3.left + rectF3.right));
            this.mBackWidth = ceil6;
            if (ceil6 < 0) {
                this.mThumbWidth = 0;
                this.mBackWidth = 0;
                return size;
            }
            int i3 = ceil + this.mTextExtra;
            int i4 = ceil5 - this.mThumbWidth;
            RectF rectF4 = this.mThumbMargin;
            int ceil7 = i3 - (i4 + ceil((double) Math.max(rectF4.left, rectF4.right)));
            if (ceil7 > 0) {
                this.mThumbWidth -= ceil7;
            }
            if (this.mThumbWidth >= 0) {
                return size;
            }
            this.mThumbWidth = 0;
            this.mBackWidth = 0;
            return size;
        }
        if (this.mThumbWidth == 0) {
            this.mThumbWidth = ceil((double) (getResources().getDisplayMetrics().density * 20.0f));
        }
        if (this.mThumbRangeRatio == 0.0f) {
            this.mThumbRangeRatio = 1.8f;
        }
        int ceil8 = ceil((double) (((float) this.mThumbWidth) * this.mThumbRangeRatio));
        RectF rectF5 = this.mThumbMargin;
        int ceil9 = ceil((double) (((float) (ceil + this.mTextExtra)) - ((((float) (ceil8 - this.mThumbWidth)) + Math.max(rectF5.left, rectF5.right)) + ((float) this.mTextThumbInset))));
        float f3 = (float) ceil8;
        RectF rectF6 = this.mThumbMargin;
        int ceil10 = ceil((double) (rectF6.left + f3 + rectF6.right + ((float) Math.max(0, ceil9))));
        this.mBackWidth = ceil10;
        if (ceil10 < 0) {
            this.mThumbWidth = 0;
            this.mBackWidth = 0;
            return size;
        }
        int ceil11 = ceil((double) (f3 + Math.max(0.0f, this.mThumbMargin.left) + Math.max(0.0f, this.mThumbMargin.right) + ((float) Math.max(0, ceil9))));
        return Math.max(ceil11, getPaddingLeft() + ceil11 + getPaddingRight());
    }

    private void setDrawableState(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562351663")) {
            ipChange.ipc$dispatch("562351663", new Object[]{this, drawable});
        } else if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    private void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062677921")) {
            ipChange.ipc$dispatch("2062677921", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mProgress = f;
        invalidate();
    }

    private void setup() {
        int i;
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926922801")) {
            ipChange.ipc$dispatch("1926922801", new Object[]{this});
            return;
        }
        int i2 = this.mThumbWidth;
        if (i2 != 0 && (i = this.mThumbHeight) != 0 && this.mBackWidth != 0 && this.mBackHeight != 0) {
            if (this.mThumbRadius == -1.0f) {
                this.mThumbRadius = (float) (Math.min(i2, i) / 2);
            }
            if (this.mBackRadius == -1.0f) {
                this.mBackRadius = (float) (Math.min(this.mBackWidth, this.mBackHeight) / 2);
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int ceil = ceil((double) ((((float) this.mBackWidth) - Math.min(0.0f, this.mThumbMargin.left)) - Math.min(0.0f, this.mThumbMargin.right)));
            int ceil2 = ceil((double) ((((float) this.mBackHeight) - Math.min(0.0f, this.mThumbMargin.top)) - Math.min(0.0f, this.mThumbMargin.bottom)));
            if (measuredHeight <= ceil2) {
                f = ((float) getPaddingTop()) + Math.max(0.0f, this.mThumbMargin.top);
            } else {
                f = ((float) (((measuredHeight - ceil2) + 1) / 2)) + ((float) getPaddingTop()) + Math.max(0.0f, this.mThumbMargin.top);
            }
            if (measuredWidth <= this.mBackWidth) {
                f2 = ((float) getPaddingLeft()) + Math.max(0.0f, this.mThumbMargin.left);
            } else {
                f2 = ((float) (((measuredWidth - ceil) + 1) / 2)) + ((float) getPaddingLeft()) + Math.max(0.0f, this.mThumbMargin.left);
            }
            this.mThumbRectF.set(f2, f, ((float) this.mThumbWidth) + f2, ((float) this.mThumbHeight) + f);
            RectF rectF = this.mThumbRectF;
            float f3 = rectF.left;
            RectF rectF2 = this.mThumbMargin;
            float f4 = f3 - rectF2.left;
            RectF rectF3 = this.mBackRectF;
            float f5 = rectF.top;
            float f6 = rectF2.top;
            rectF3.set(f4, f5 - f6, ((float) this.mBackWidth) + f4, (f5 - f6) + ((float) this.mBackHeight));
            RectF rectF4 = this.mSafeRectF;
            RectF rectF5 = this.mThumbRectF;
            rectF4.set(rectF5.left, 0.0f, (this.mBackRectF.right - this.mThumbMargin.right) - rectF5.width(), 0.0f);
            this.mBackRadius = Math.min(Math.min(this.mBackRectF.width(), this.mBackRectF.height()) / 2.0f, this.mBackRadius);
            Drawable drawable = this.mBackDrawable;
            if (drawable != null) {
                RectF rectF6 = this.mBackRectF;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, ceil((double) rectF6.right), ceil((double) this.mBackRectF.bottom));
            }
            if (this.mOnLayout != null) {
                RectF rectF7 = this.mBackRectF;
                float width = (rectF7.left + (((((rectF7.width() + ((float) this.mTextThumbInset)) - ((float) this.mThumbWidth)) - this.mThumbMargin.right) - ((float) this.mOnLayout.getWidth())) / 2.0f)) - ((float) this.mTextAdjust);
                RectF rectF8 = this.mBackRectF;
                float height = rectF8.top + ((rectF8.height() - ((float) this.mOnLayout.getHeight())) / 2.0f);
                this.mTextOnRectF.set(width, height, ((float) this.mOnLayout.getWidth()) + width, ((float) this.mOnLayout.getHeight()) + height);
            }
            if (this.mOffLayout != null) {
                RectF rectF9 = this.mBackRectF;
                float width2 = ((rectF9.right - (((((rectF9.width() + ((float) this.mTextThumbInset)) - ((float) this.mThumbWidth)) - this.mThumbMargin.left) - ((float) this.mOffLayout.getWidth())) / 2.0f)) - ((float) this.mOffLayout.getWidth())) + ((float) this.mTextAdjust);
                RectF rectF10 = this.mBackRectF;
                float height2 = rectF10.top + ((rectF10.height() - ((float) this.mOffLayout.getHeight())) / 2.0f);
                this.mTextOffRectF.set(width2, height2, ((float) this.mOffLayout.getWidth()) + width2, ((float) this.mOffLayout.getHeight()) + height2);
            }
            this.mReady = true;
        }
    }

    /* access modifiers changed from: protected */
    public void animateToState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847560013")) {
            ipChange.ipc$dispatch("1847560013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ObjectAnimator objectAnimator = this.mProgressAnimator;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.mProgressAnimator.cancel();
            }
            this.mProgressAnimator.setDuration(this.mAnimationDuration);
            if (z) {
                this.mProgressAnimator.setFloatValues(this.mProgress, 1.0f);
            } else {
                this.mProgressAnimator.setFloatValues(this.mProgress, 0.0f);
            }
            this.mProgressAnimator.start();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239242821")) {
            ipChange.ipc$dispatch("-1239242821", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        if (this.mIsThumbUseDrawable || (colorStateList2 = this.mThumbColor) == null) {
            setDrawableState(this.mThumbDrawable);
        } else {
            this.mCurrThumbColor = colorStateList2.getColorForState(getDrawableState(), this.mCurrThumbColor);
        }
        int[] iArr = isChecked() ? UNCHECKED_PRESSED_STATE : CHECKED_PRESSED_STATE;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.mOnTextColor = textColors.getColorForState(CHECKED_PRESSED_STATE, defaultColor);
            this.mOffTextColor = textColors.getColorForState(UNCHECKED_PRESSED_STATE, defaultColor);
        }
        if (this.mIsBackUseDrawable || (colorStateList = this.mBackColor) == null) {
            Drawable drawable = this.mBackDrawable;
            if (!(drawable instanceof StateListDrawable) || !this.mFadeBack) {
                this.mNextBackDrawable = null;
            } else {
                drawable.setState(iArr);
                this.mNextBackDrawable = this.mBackDrawable.getCurrent().mutate();
            }
            setDrawableState(this.mBackDrawable);
            Drawable drawable2 = this.mBackDrawable;
            if (drawable2 != null) {
                this.mCurrentBackDrawable = drawable2.getCurrent().mutate();
                return;
            }
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), this.mCurrBackColor);
        this.mCurrBackColor = colorForState;
        this.mNextBackColor = this.mBackColor.getColorForState(iArr, colorForState);
    }

    public long getAnimationDuration() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1110050770")) {
            return this.mAnimationDuration;
        }
        return ((Long) ipChange.ipc$dispatch("-1110050770", new Object[]{this})).longValue();
    }

    public ColorStateList getBackColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "986483358")) {
            return this.mBackColor;
        }
        return (ColorStateList) ipChange.ipc$dispatch("986483358", new Object[]{this});
    }

    public Drawable getBackDrawable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1754650951")) {
            return this.mBackDrawable;
        }
        return (Drawable) ipChange.ipc$dispatch("1754650951", new Object[]{this});
    }

    public float getBackRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1251909135")) {
            return this.mBackRadius;
        }
        return ((Float) ipChange.ipc$dispatch("1251909135", new Object[]{this})).floatValue();
    }

    public PointF getBackSizeF() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1625591083")) {
            return new PointF(this.mBackRectF.width(), this.mBackRectF.height());
        }
        return (PointF) ipChange.ipc$dispatch("1625591083", new Object[]{this});
    }

    public CharSequence getTextOff() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1425977014")) {
            return this.mTextOff;
        }
        return (CharSequence) ipChange.ipc$dispatch("-1425977014", new Object[]{this});
    }

    public CharSequence getTextOn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "850452238")) {
            return this.mTextOn;
        }
        return (CharSequence) ipChange.ipc$dispatch("850452238", new Object[]{this});
    }

    public ColorStateList getThumbColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1327142679")) {
            return this.mThumbColor;
        }
        return (ColorStateList) ipChange.ipc$dispatch("-1327142679", new Object[]{this});
    }

    public Drawable getThumbDrawable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2138418404")) {
            return this.mThumbDrawable;
        }
        return (Drawable) ipChange.ipc$dispatch("-2138418404", new Object[]{this});
    }

    public float getThumbHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1041667685")) {
            return (float) this.mThumbHeight;
        }
        return ((Float) ipChange.ipc$dispatch("1041667685", new Object[]{this})).floatValue();
    }

    public RectF getThumbMargin() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1581442791")) {
            return this.mThumbMargin;
        }
        return (RectF) ipChange.ipc$dispatch("-1581442791", new Object[]{this});
    }

    public float getThumbRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1692368666")) {
            return this.mThumbRadius;
        }
        return ((Float) ipChange.ipc$dispatch("1692368666", new Object[]{this})).floatValue();
    }

    public float getThumbRangeRatio() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1709421022")) {
            return this.mThumbRangeRatio;
        }
        return ((Float) ipChange.ipc$dispatch("1709421022", new Object[]{this})).floatValue();
    }

    public float getThumbWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-608759432")) {
            return (float) this.mThumbWidth;
        }
        return ((Float) ipChange.ipc$dispatch("-608759432", new Object[]{this})).floatValue();
    }

    public int getTintColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1389136067")) {
            return this.mTintColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-1389136067", new Object[]{this})).intValue();
    }

    public boolean isDrawDebugRect() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-840777463")) {
            return this.mDrawDebugRect;
        }
        return ((Boolean) ipChange.ipc$dispatch("-840777463", new Object[]{this})).booleanValue();
    }

    public boolean isFadeBack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1021315885")) {
            return this.mFadeBack;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1021315885", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0148  */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float progress;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313496044")) {
            ipChange.ipc$dispatch("313496044", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!this.mReady) {
            setup();
        }
        if (this.mReady) {
            if (this.mIsBackUseDrawable) {
                if (!this.mFadeBack || this.mCurrentBackDrawable == null || this.mNextBackDrawable == null) {
                    this.mBackDrawable.setAlpha(255);
                    this.mBackDrawable.draw(canvas);
                } else {
                    Drawable drawable = isChecked() ? this.mCurrentBackDrawable : this.mNextBackDrawable;
                    Drawable drawable2 = isChecked() ? this.mNextBackDrawable : this.mCurrentBackDrawable;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                }
            } else if (this.mFadeBack) {
                int i = isChecked() ? this.mCurrBackColor : this.mNextBackColor;
                int i2 = isChecked() ? this.mNextBackColor : this.mCurrBackColor;
                int progress3 = (int) (getProgress() * 255.0f);
                this.mPaint.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.mBackRectF;
                float f3 = this.mBackRadius;
                canvas.drawRoundRect(rectF, f3, f3, this.mPaint);
                this.mPaint.setARGB((Color.alpha(i2) * (255 - progress3)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.mBackRectF;
                float f4 = this.mBackRadius;
                canvas.drawRoundRect(rectF2, f4, f4, this.mPaint);
                this.mPaint.setAlpha(255);
            } else {
                this.mPaint.setColor(this.mCurrBackColor);
                RectF rectF3 = this.mBackRectF;
                float f5 = this.mBackRadius;
                canvas.drawRoundRect(rectF3, f5, f5, this.mPaint);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.mOnLayout : this.mOffLayout;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.mTextOnRectF : this.mTextOffRectF;
            if (!(layout == null || rectF4 == null)) {
                int i3 = (((double) getProgress()) > 0.75d ? 1 : (((double) getProgress()) == 0.75d ? 0 : -1));
                float progress4 = getProgress();
                if (i3 >= 0) {
                    f2 = progress4 * 4.0f;
                    progress = 3.0f;
                } else if (((double) progress4) < 0.25d) {
                    f2 = 1.0f;
                    progress = getProgress() * 4.0f;
                } else {
                    f = 0.0f;
                    int i4 = (int) (f * 255.0f);
                    int i5 = ((double) getProgress()) <= 0.5d ? this.mOnTextColor : this.mOffTextColor;
                    layout.getPaint().setARGB((Color.alpha(i5) * i4) / 255, Color.red(i5), Color.green(i5), Color.blue(i5));
                    canvas.save();
                    canvas.translate(rectF4.left, rectF4.top);
                    layout.draw(canvas);
                    canvas.restore();
                }
                f = f2 - progress;
                int i42 = (int) (f * 255.0f);
                if (((double) getProgress()) <= 0.5d) {
                }
                layout.getPaint().setARGB((Color.alpha(i5) * i42) / 255, Color.red(i5), Color.green(i5), Color.blue(i5));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.mPresentThumbRectF.set(this.mThumbRectF);
            this.mPresentThumbRectF.offset(this.mProgress * this.mSafeRectF.width(), 0.0f);
            if (this.mIsThumbUseDrawable) {
                Drawable drawable3 = this.mThumbDrawable;
                RectF rectF5 = this.mPresentThumbRectF;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, ceil((double) rectF5.right), ceil((double) this.mPresentThumbRectF.bottom));
                this.mThumbDrawable.draw(canvas);
            } else {
                this.mPaint.setColor(this.mCurrThumbColor);
                RectF rectF6 = this.mPresentThumbRectF;
                float f6 = this.mThumbRadius;
                canvas.drawRoundRect(rectF6, f6, f6, this.mPaint);
            }
            if (this.mDrawDebugRect) {
                this.mRectPaint.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.mBackRectF, this.mRectPaint);
                this.mRectPaint.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.mPresentThumbRectF, this.mRectPaint);
                this.mRectPaint.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.mSafeRectF;
                float f7 = rectF7.left;
                float f8 = this.mThumbRectF.top;
                canvas.drawLine(f7, f8, rectF7.right, f8, this.mRectPaint);
                this.mRectPaint.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.mTextOnRectF : this.mTextOffRectF, this.mRectPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086401295")) {
            ipChange.ipc$dispatch("1086401295", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mOnLayout == null && !TextUtils.isEmpty(this.mTextOn)) {
            this.mOnLayout = makeLayout(this.mTextOn);
        }
        if (this.mOffLayout == null && !TextUtils.isEmpty(this.mTextOff)) {
            this.mOffLayout = makeLayout(this.mTextOff);
        }
        Layout layout = this.mOnLayout;
        float width = layout != null ? (float) layout.getWidth() : 0.0f;
        Layout layout2 = this.mOffLayout;
        float width2 = layout2 != null ? (float) layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.mTextWidth = 0.0f;
        } else {
            this.mTextWidth = Math.max(width, width2);
        }
        Layout layout3 = this.mOnLayout;
        float height = layout3 != null ? (float) layout3.getHeight() : 0.0f;
        Layout layout4 = this.mOffLayout;
        float height2 = layout4 != null ? (float) layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.mTextHeight = 0.0f;
        } else {
            this.mTextHeight = Math.max(height, height2);
        }
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944215396")) {
            ipChange.ipc$dispatch("1944215396", new Object[]{this, parcelable});
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        setText(savedState.onText, savedState.offText);
        this.mRestoring = true;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mRestoring = false;
    }

    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980785201")) {
            return (Parcelable) ipChange.ipc$dispatch("980785201", new Object[]{this});
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.onText = this.mTextOn;
        savedState.offText = this.mTextOff;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636989958")) {
            ipChange.ipc$dispatch("-1636989958", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            setup();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (r0 != 3) goto L_0x0103;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497061253")) {
            return ((Boolean) ipChange.ipc$dispatch("-497061253", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled() || !isClickable() || !isFocusable() || !this.mReady) {
            return false;
        } else {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.mStartX;
            float y = motionEvent.getY() - this.mStartY;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x2 = motionEvent.getX();
                        setProgress(getProgress() + ((x2 - this.mLastX) / this.mSafeRectF.width()));
                        if (!this.mCatch && (Math.abs(x) > ((float) (this.mTouchSlop / 2)) || Math.abs(y) > ((float) (this.mTouchSlop / 2)))) {
                            if (y == 0.0f || Math.abs(x) > Math.abs(y)) {
                                catchView();
                            } else if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        }
                        this.mLastX = x2;
                    }
                }
                this.mCatch = false;
                setPressed(false);
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (Math.abs(x) >= ((float) this.mTouchSlop) || Math.abs(y) >= ((float) this.mTouchSlop) || eventTime >= ((float) this.mClickTimeout)) {
                    boolean statusBasedOnPos = getStatusBasedOnPos();
                    if (statusBasedOnPos != isChecked()) {
                        playSoundEffect(0);
                        setChecked(statusBasedOnPos);
                    } else {
                        animateToState(statusBasedOnPos);
                    }
                } else {
                    performClick();
                }
            } else {
                this.mStartX = motionEvent.getX();
                this.mStartY = motionEvent.getY();
                this.mLastX = this.mStartX;
                setPressed(true);
            }
            return true;
        }
    }

    public boolean performClick() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "528953081")) {
            return super.performClick();
        }
        return ((Boolean) ipChange.ipc$dispatch("528953081", new Object[]{this})).booleanValue();
    }

    public void setAnimationDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855885762")) {
            ipChange.ipc$dispatch("-855885762", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mAnimationDuration = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799630272")) {
            ipChange.ipc$dispatch("1799630272", new Object[]{this, colorStateList});
            return;
        }
        this.mBackColor = colorStateList;
        if (colorStateList != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682175227")) {
            ipChange.ipc$dispatch("1682175227", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setBackColor(ContextCompat.getColorStateList(getContext(), i));
    }

    public void setBackDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "264721579")) {
            ipChange.ipc$dispatch("264721579", new Object[]{this, drawable});
            return;
        }
        this.mBackDrawable = drawable;
        if (drawable == null) {
            z = false;
        }
        this.mIsBackUseDrawable = z;
        refreshDrawableState();
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608746176")) {
            ipChange.ipc$dispatch("-1608746176", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setBackDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public void setBackRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785648243")) {
            ipChange.ipc$dispatch("-785648243", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mBackRadius = f;
        if (!this.mIsBackUseDrawable) {
            invalidate();
        }
    }

    public void setChecked(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599108099")) {
            ipChange.ipc$dispatch("-1599108099", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (isChecked() != z) {
            animateToState(z);
        }
        if (this.mRestoring) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611706081")) {
            ipChange.ipc$dispatch("-611706081", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.mProgressAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mProgressAnimator.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104225688")) {
            ipChange.ipc$dispatch("1104225688", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mChildOnCheckedChangeListener == null) {
            setCheckedImmediately(z);
        } else {
            super.setOnCheckedChangeListener(null);
            setCheckedImmediately(z);
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setCheckedNoEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235757830")) {
            ipChange.ipc$dispatch("-235757830", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mChildOnCheckedChangeListener == null) {
            setChecked(z);
        } else {
            super.setOnCheckedChangeListener(null);
            setChecked(z);
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setDrawDebugRect(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221895415")) {
            ipChange.ipc$dispatch("-1221895415", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mDrawDebugRect = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965842699")) {
            ipChange.ipc$dispatch("965842699", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mFadeBack = z;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105027617")) {
            ipChange.ipc$dispatch("-105027617", new Object[]{this, onCheckedChangeListener});
            return;
        }
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mChildOnCheckedChangeListener = onCheckedChangeListener;
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858713145")) {
            ipChange.ipc$dispatch("-858713145", new Object[]{this, charSequence, charSequence2});
            return;
        }
        this.mTextOn = charSequence;
        this.mTextOff = charSequence2;
        this.mOnLayout = null;
        this.mOffLayout = null;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextAdjust(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257232877")) {
            ipChange.ipc$dispatch("-1257232877", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextAdjust = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190201432")) {
            ipChange.ipc$dispatch("-1190201432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextExtra = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303190635")) {
            ipChange.ipc$dispatch("1303190635", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextThumbInset = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276579779")) {
            ipChange.ipc$dispatch("-1276579779", new Object[]{this, colorStateList});
            return;
        }
        this.mThumbColor = colorStateList;
        if (colorStateList != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075188872")) {
            ipChange.ipc$dispatch("-1075188872", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setThumbColor(ContextCompat.getColorStateList(getContext(), i));
    }

    public void setThumbDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1391713010")) {
            ipChange.ipc$dispatch("-1391713010", new Object[]{this, drawable});
            return;
        }
        this.mThumbDrawable = drawable;
        if (drawable == null) {
            z = false;
        }
        this.mIsThumbUseDrawable = z;
        refreshDrawableState();
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698116189")) {
            ipChange.ipc$dispatch("-698116189", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setThumbDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public void setThumbMargin(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281241173")) {
            ipChange.ipc$dispatch("-281241173", new Object[]{this, rectF});
        } else if (rectF == null) {
            setThumbMargin(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            setThumbMargin(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843881802")) {
            ipChange.ipc$dispatch("1843881802", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mThumbRadius = f;
        if (!this.mIsThumbUseDrawable) {
            invalidate();
        }
    }

    public void setThumbRangeRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529367802")) {
            ipChange.ipc$dispatch("-1529367802", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mThumbRangeRatio = f;
        this.mReady = false;
        requestLayout();
    }

    public void setThumbSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134260537")) {
            ipChange.ipc$dispatch("-2134260537", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mThumbWidth = i;
        this.mThumbHeight = i2;
        this.mReady = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944958099")) {
            ipChange.ipc$dispatch("-1944958099", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTintColor = i;
        this.mThumbColor = yj.b(i);
        this.mBackColor = yj.a(this.mTintColor);
        this.mIsBackUseDrawable = false;
        this.mIsThumbUseDrawable = false;
        refreshDrawableState();
        invalidate();
    }

    public void toggleImmediately() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927681276")) {
            ipChange.ipc$dispatch("-1927681276", new Object[]{this});
            return;
        }
        setCheckedImmediately(!isChecked());
    }

    public void toggleImmediatelyNoEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065577683")) {
            ipChange.ipc$dispatch("-2065577683", new Object[]{this});
        } else if (this.mChildOnCheckedChangeListener == null) {
            toggleImmediately();
        } else {
            super.setOnCheckedChangeListener(null);
            toggleImmediately();
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void toggleNoEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880389961")) {
            ipChange.ipc$dispatch("880389961", new Object[]{this});
        } else if (this.mChildOnCheckedChangeListener == null) {
            toggle();
        } else {
            super.setOnCheckedChangeListener(null);
            toggle();
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setThumbMargin(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040448410")) {
            ipChange.ipc$dispatch("1040448410", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        this.mThumbMargin.set(f, f2, f3, f4);
        this.mReady = false;
        requestLayout();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        init(null);
    }
}
