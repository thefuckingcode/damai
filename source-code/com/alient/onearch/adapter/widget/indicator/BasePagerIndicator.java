package com.alient.onearch.adapter.widget.indicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.alient.onearch.adapter.R;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class BasePagerIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 6;
    protected boolean autoSize;
    protected Animator mAnimatorIn;
    protected Animator mAnimatorOut;
    protected Animator mImmediateAnimatorIn;
    protected Animator mImmediateAnimatorOut;
    protected int mIndicatorBackgroundResId;
    @Nullable
    private IndicatorCreatedListener mIndicatorCreatedListener;
    protected int mIndicatorHeight = -1;
    protected int mIndicatorMargin = -1;
    protected ColorStateList mIndicatorTintColor;
    protected ColorStateList mIndicatorTintUnselectedColor;
    protected int mIndicatorUnselectedBackgroundResId;
    protected int mIndicatorWidth = -1;
    protected int mLastPosition = -1;

    /* compiled from: Taobao */
    public interface IndicatorCreatedListener {
        void onIndicatorCreated(View view, int i);
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static class ReverseInterpolator implements Interpolator {
        protected ReverseInterpolator() {
        }

        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public BasePagerIndicator(Context context) {
        super(context);
        init(context, null);
    }

    private void bindIndicatorBackground(View view, @DrawableRes int i, @Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), i).mutate());
            DrawableCompat.setTintList(wrap, colorStateList);
            ViewCompat.setBackground(view, wrap);
            return;
        }
        view.setBackgroundResource(i);
    }

    private Config handleTypedArray(Context context, AttributeSet attributeSet) {
        Config config = new Config();
        if (attributeSet == null) {
            return config;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BasePagerIndicator);
        config.width = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BasePagerIndicator_indicator_width, -1);
        config.height = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BasePagerIndicator_indicator_height, -1);
        config.margin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BasePagerIndicator_indicator_margin, -1);
        config.animatorResId = obtainStyledAttributes.getResourceId(R.styleable.BasePagerIndicator_indicator_animator, R.animator.indicator_scale);
        config.animatorReverseResId = obtainStyledAttributes.getResourceId(R.styleable.BasePagerIndicator_indicator_animator_reverse, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.BasePagerIndicator_indicator_drawable, R.drawable.indicator_white_dot);
        config.backgroundResId = resourceId;
        config.unselectedBackgroundId = obtainStyledAttributes.getResourceId(R.styleable.BasePagerIndicator_indicator_drawable_unselected, resourceId);
        config.orientation = obtainStyledAttributes.getInt(R.styleable.BasePagerIndicator_indicator_orientation, -1);
        config.gravity = obtainStyledAttributes.getInt(R.styleable.BasePagerIndicator_indicator_gravity, -1);
        config.autoSize = obtainStyledAttributes.getBoolean(R.styleable.BasePagerIndicator_indicator_auto_size, false);
        obtainStyledAttributes.recycle();
        return config;
    }

    private void init(Context context, AttributeSet attributeSet) {
        initialize(handleTypedArray(context, attributeSet));
        if (isInEditMode()) {
            createIndicators(3, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void addIndicator(int i) {
        View view = new View(getContext());
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = this.mIndicatorWidth;
        generateDefaultLayoutParams.height = this.mIndicatorHeight;
        if (i == 0) {
            int i2 = this.mIndicatorMargin;
            generateDefaultLayoutParams.leftMargin = i2;
            generateDefaultLayoutParams.rightMargin = i2;
        } else {
            int i3 = this.mIndicatorMargin;
            generateDefaultLayoutParams.topMargin = i3;
            generateDefaultLayoutParams.bottomMargin = i3;
        }
        addView(view, generateDefaultLayoutParams);
    }

    public void animatePageSelected(int i) {
        View childAt;
        if (this.mLastPosition != i) {
            if (this.mAnimatorIn.isRunning()) {
                this.mAnimatorIn.end();
                this.mAnimatorIn.cancel();
            }
            if (this.mAnimatorOut.isRunning()) {
                this.mAnimatorOut.end();
                this.mAnimatorOut.cancel();
            }
            int i2 = this.mLastPosition;
            if (i2 >= 0 && (childAt = getChildAt(i2)) != null) {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
                this.mAnimatorIn.setTarget(childAt);
                this.mAnimatorIn.start();
            }
            View childAt2 = getChildAt(i);
            if (childAt2 != null) {
                bindIndicatorBackground(childAt2, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
                this.mAnimatorOut.setTarget(childAt2);
                this.mAnimatorOut.start();
            }
            this.mLastPosition = i;
        }
    }

    /* access modifiers changed from: protected */
    public void changeIndicatorBackground() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (i == this.mLastPosition) {
                    bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
                } else {
                    bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
                }
            }
        }
    }

    public void changeIndicatorResource(@DrawableRes int i) {
        changeIndicatorResource(i, i);
    }

    /* access modifiers changed from: protected */
    public Animator createAnimatorIn(Config config) {
        if (config.animatorReverseResId != 0) {
            return AnimatorInflater.loadAnimator(getContext(), config.animatorReverseResId);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
        loadAnimator.setInterpolator(new ReverseInterpolator());
        return loadAnimator;
    }

    /* access modifiers changed from: protected */
    public Animator createAnimatorOut(Config config) {
        return AnimatorInflater.loadAnimator(getContext(), config.animatorResId);
    }

    public void createIndicators(int i, int i2) {
        if (this.mImmediateAnimatorOut.isRunning()) {
            this.mImmediateAnimatorOut.end();
            this.mImmediateAnimatorOut.cancel();
        }
        if (this.mImmediateAnimatorIn.isRunning()) {
            this.mImmediateAnimatorIn.end();
            this.mImmediateAnimatorIn.cancel();
        }
        int childCount = getChildCount();
        if (i < childCount) {
            removeViews(i, childCount - i);
        } else if (i > childCount) {
            int i3 = i - childCount;
            int orientation = getOrientation();
            for (int i4 = 0; i4 < i3; i4++) {
                addIndicator(orientation);
            }
        }
        for (int i5 = 0; i5 < i; i5++) {
            View childAt = getChildAt(i5);
            if (i2 == i5) {
                bindIndicatorBackground(childAt, this.mIndicatorBackgroundResId, this.mIndicatorTintColor);
                this.mImmediateAnimatorOut.setTarget(childAt);
                this.mImmediateAnimatorOut.start();
                this.mImmediateAnimatorOut.end();
            } else {
                bindIndicatorBackground(childAt, this.mIndicatorUnselectedBackgroundResId, this.mIndicatorTintUnselectedColor);
                this.mImmediateAnimatorIn.setTarget(childAt);
                this.mImmediateAnimatorIn.start();
                this.mImmediateAnimatorIn.end();
            }
            IndicatorCreatedListener indicatorCreatedListener = this.mIndicatorCreatedListener;
            if (indicatorCreatedListener != null) {
                indicatorCreatedListener.onIndicatorCreated(childAt, i5);
            }
        }
        this.mLastPosition = i2;
    }

    public void initialize(Config config) {
        int i = 1;
        int applyDimension = (int) (TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics()) + 0.5f);
        int i2 = config.width;
        if (i2 < 0) {
            i2 = applyDimension;
        }
        this.mIndicatorWidth = i2;
        int i3 = config.height;
        if (i3 < 0) {
            i3 = applyDimension;
        }
        this.mIndicatorHeight = i3;
        int i4 = config.margin;
        if (i4 >= 0) {
            applyDimension = i4;
        }
        this.mIndicatorMargin = applyDimension;
        this.mAnimatorOut = createAnimatorOut(config);
        Animator createAnimatorOut = createAnimatorOut(config);
        this.mImmediateAnimatorOut = createAnimatorOut;
        createAnimatorOut.setDuration(0);
        this.mAnimatorIn = createAnimatorIn(config);
        Animator createAnimatorIn = createAnimatorIn(config);
        this.mImmediateAnimatorIn = createAnimatorIn;
        createAnimatorIn.setDuration(0);
        int i5 = config.backgroundResId;
        this.mIndicatorBackgroundResId = i5 == 0 ? R.drawable.indicator_white_dot : i5;
        int i6 = config.unselectedBackgroundId;
        if (i6 != 0) {
            i5 = i6;
        }
        this.mIndicatorUnselectedBackgroundResId = i5;
        if (config.orientation != 1) {
            i = 0;
        }
        setOrientation(i);
        this.autoSize = config.autoSize;
        int i7 = config.gravity;
        if (i7 < 0) {
            i7 = 17;
        }
        setGravity(i7);
    }

    public void setIndicatorCreatedListener(@Nullable IndicatorCreatedListener indicatorCreatedListener) {
        this.mIndicatorCreatedListener = indicatorCreatedListener;
    }

    public void tintIndicator(@ColorInt int i) {
        tintIndicator(i, i);
    }

    public void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i2;
        changeIndicatorBackground();
    }

    public void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        this.mIndicatorTintColor = ColorStateList.valueOf(i);
        this.mIndicatorTintUnselectedColor = ColorStateList.valueOf(i2);
        changeIndicatorBackground();
    }

    public BasePagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BasePagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public BasePagerIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }
}
