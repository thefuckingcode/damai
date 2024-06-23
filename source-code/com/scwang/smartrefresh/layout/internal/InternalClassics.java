package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.R$id;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import tb.cc2;
import tb.gd2;
import tb.go1;

/* compiled from: Taobao */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract {
    public static final int ID_IMAGE_ARROW = R$id.srl_classics_arrow;
    public static final int ID_IMAGE_PROGRESS = R$id.srl_classics_progress;
    public static final int ID_TEXT_TITLE = R$id.srl_classics_title;
    protected go1 mArrowDrawable;
    protected ImageView mArrowView;
    protected int mBackgroundColor;
    protected int mFinishDuration = 500;
    protected int mMinHeightOfContent = 0;
    protected int mPaddingBottom = 20;
    protected int mPaddingTop = 20;
    protected go1 mProgressDrawable;
    protected ImageView mProgressView;
    protected RefreshKernel mRefreshKernel;
    protected boolean mSetAccentColor;
    protected boolean mSetPrimaryColor;
    protected TextView mTitleText;

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpinnerStyle = gd2.Translate;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.mArrowView;
            ImageView imageView2 = this.mProgressView;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Drawable drawable = this.mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        ImageView imageView = this.mProgressView;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0);
        }
        imageView.setVisibility(8);
        return this.mFinishDuration;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mMinHeightOfContent == 0) {
            this.mPaddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.mPaddingBottom = paddingBottom;
            if (this.mPaddingTop == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i3 = this.mPaddingTop;
                if (i3 == 0) {
                    i3 = cc2.dp2px(20.0f);
                }
                this.mPaddingTop = i3;
                int i4 = this.mPaddingBottom;
                if (i4 == 0) {
                    i4 = cc2.dp2px(20.0f);
                }
                this.mPaddingBottom = i4;
                setPadding(paddingLeft, this.mPaddingTop, paddingRight, i4);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i5 = this.mMinHeightOfContent;
            if (size < i5) {
                int i6 = (size - i5) / 2;
                setPadding(getPaddingLeft(), i6, getPaddingRight(), i6);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
        if (this.mMinHeightOfContent == 0) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                int measuredHeight = getChildAt(i7).getMeasuredHeight();
                if (this.mMinHeightOfContent < measuredHeight) {
                    this.mMinHeightOfContent = measuredHeight;
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        onStartAnimator(refreshLayout, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        ImageView imageView = this.mProgressView;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.mProgressView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public T self() {
        return this;
    }

    public T setAccentColor(@ColorInt int i) {
        this.mSetAccentColor = true;
        this.mTitleText.setTextColor(i);
        go1 go1 = this.mArrowDrawable;
        if (go1 != null) {
            go1.a(i);
            this.mArrowView.invalidateDrawable(this.mArrowDrawable);
        }
        go1 go12 = this.mProgressDrawable;
        if (go12 != null) {
            go12.a(i);
            this.mProgressView.invalidateDrawable(this.mProgressDrawable);
        }
        return self();
    }

    public T setAccentColorId(@ColorRes int i) {
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return self();
    }

    public T setArrowDrawable(Drawable drawable) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageDrawable(drawable);
        return self();
    }

    public T setArrowResource(@DrawableRes int i) {
        this.mArrowDrawable = null;
        this.mArrowView.setImageResource(i);
        return self();
    }

    public T setDrawableArrowSize(float f) {
        ImageView imageView = this.mArrowView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dp2px = cc2.dp2px(f);
        layoutParams.width = dp2px;
        layoutParams.height = dp2px;
        imageView.setLayoutParams(layoutParams);
        return self();
    }

    public T setDrawableMarginRight(float f) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int dp2px = cc2.dp2px(f);
        marginLayoutParams2.rightMargin = dp2px;
        marginLayoutParams.rightMargin = dp2px;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return self();
    }

    public T setDrawableProgressSize(float f) {
        ImageView imageView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dp2px = cc2.dp2px(f);
        layoutParams.width = dp2px;
        layoutParams.height = dp2px;
        imageView.setLayoutParams(layoutParams);
        return self();
    }

    public T setDrawableSize(float f) {
        ImageView imageView = this.mArrowView;
        ImageView imageView2 = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int dp2px = cc2.dp2px(f);
        layoutParams2.width = dp2px;
        layoutParams.width = dp2px;
        int dp2px2 = cc2.dp2px(f);
        layoutParams2.height = dp2px2;
        layoutParams.height = dp2px2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return self();
    }

    public T setFinishDuration(int i) {
        this.mFinishDuration = i;
        return self();
    }

    public T setPrimaryColor(@ColorInt int i) {
        this.mSetPrimaryColor = true;
        this.mBackgroundColor = i;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestDrawBackgroundFor(this, i);
        }
        return self();
    }

    public T setPrimaryColorId(@ColorRes int i) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return self();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.mSetPrimaryColor) {
                setPrimaryColor(iArr[0]);
                this.mSetPrimaryColor = false;
            }
            if (!this.mSetAccentColor) {
                if (iArr.length > 1) {
                    setAccentColor(iArr[1]);
                } else {
                    int i = -1;
                    if (iArr[0] == -1) {
                        i = -10066330;
                    }
                    setAccentColor(i);
                }
                this.mSetAccentColor = false;
            }
        }
    }

    public T setProgressDrawable(Drawable drawable) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageDrawable(drawable);
        return self();
    }

    public T setProgressResource(@DrawableRes int i) {
        this.mProgressDrawable = null;
        this.mProgressView.setImageResource(i);
        return self();
    }

    public T setSpinnerStyle(gd2 gd2) {
        this.mSpinnerStyle = gd2;
        return self();
    }

    public T setTextSizeTitle(float f) {
        this.mTitleText.setTextSize(f);
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestRemeasureHeightFor(this);
        }
        return self();
    }
}
