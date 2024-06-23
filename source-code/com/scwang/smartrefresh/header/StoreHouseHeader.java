package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.header.storehouse.StoreHouseBarItem;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.List;
import tb.xe2;

/* compiled from: Taobao */
public class StoreHouseHeader extends InternalAbstract implements RefreshHeader {
    protected static final float mBarDarkAlpha = 0.4f;
    protected static final float mFromAlpha = 1.0f;
    protected static final float mInternalAnimationFactor = 0.7f;
    protected static final int mLoadingAniItemDuration = 400;
    protected static final float mToAlpha = 0.4f;
    protected AniController mAniController;
    protected int mBackgroundColor;
    protected int mDrawZoneHeight;
    protected int mDrawZoneWidth;
    protected int mDropHeight;
    protected boolean mEnableFadeAnimation;
    protected int mHorizontalRandomness;
    protected boolean mIsInLoading;
    public List<StoreHouseBarItem> mItemList;
    protected int mLineWidth;
    protected int mLoadingAniDuration;
    protected int mLoadingAniSegDuration;
    protected Matrix mMatrix;
    protected int mOffsetX;
    protected int mOffsetY;
    protected float mProgress;
    protected RefreshKernel mRefreshKernel;
    protected float mScale;
    protected int mTextColor;
    protected Transformation mTransformation;

    /* compiled from: Taobao */
    private class AniController implements Runnable {
        int mCountPerSeg;
        int mInterval;
        boolean mRunning;
        int mSegCount;
        int mTick;

        private AniController() {
            this.mTick = 0;
            this.mCountPerSeg = 0;
            this.mSegCount = 0;
            this.mInterval = 0;
            this.mRunning = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void start() {
            this.mRunning = true;
            this.mTick = 0;
            StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
            int size = storeHouseHeader.mLoadingAniDuration / storeHouseHeader.mItemList.size();
            this.mInterval = size;
            StoreHouseHeader storeHouseHeader2 = StoreHouseHeader.this;
            this.mCountPerSeg = storeHouseHeader2.mLoadingAniSegDuration / size;
            this.mSegCount = (storeHouseHeader2.mItemList.size() / this.mCountPerSeg) + 1;
            run();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void stop() {
            this.mRunning = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        public void run() {
            RefreshKernel refreshKernel;
            int i = this.mTick % this.mCountPerSeg;
            for (int i2 = 0; i2 < this.mSegCount; i2++) {
                int i3 = (this.mCountPerSeg * i2) + i;
                if (i3 <= this.mTick) {
                    StoreHouseBarItem storeHouseBarItem = StoreHouseHeader.this.mItemList.get(i3 % StoreHouseHeader.this.mItemList.size());
                    storeHouseBarItem.setFillAfter(false);
                    storeHouseBarItem.setFillEnabled(true);
                    storeHouseBarItem.setFillBefore(false);
                    storeHouseBarItem.setDuration(400);
                    storeHouseBarItem.start(1.0f, 0.4f);
                }
            }
            this.mTick++;
            if (this.mRunning && (refreshKernel = StoreHouseHeader.this.mRefreshKernel) != null) {
                refreshKernel.getRefreshLayout().getLayout().postDelayed(this, (long) this.mInterval);
            }
        }
    }

    public StoreHouseHeader(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        int size = this.mItemList.size();
        float f = isInEditMode() ? 1.0f : this.mProgress;
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem storeHouseBarItem = this.mItemList.get(i);
            PointF pointF = storeHouseBarItem.midPoint;
            float f2 = ((float) this.mOffsetX) + pointF.x;
            float f3 = ((float) this.mOffsetY) + pointF.y;
            if (this.mIsInLoading) {
                storeHouseBarItem.getTransformation(getDrawingTime(), this.mTransformation);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
                } else {
                    float f5 = (((float) i) * 0.3f) / ((float) size);
                    float f6 = 0.3f - f5;
                    if (f == 1.0f || f >= 1.0f - f6) {
                        canvas.translate(f2, f3);
                        storeHouseBarItem.setAlpha(0.4f);
                    } else {
                        if (f > f5) {
                            f4 = Math.min(1.0f, (f - f5) / 0.7f);
                        }
                        float f7 = 1.0f - f4;
                        float f8 = f2 + (storeHouseBarItem.translationX * f7);
                        float f9 = f3 + (((float) (-this.mDropHeight)) * f7);
                        this.mMatrix.reset();
                        this.mMatrix.postRotate(360.0f * f4);
                        this.mMatrix.postScale(f4, f4);
                        this.mMatrix.postTranslate(f8, f9);
                        storeHouseBarItem.setAlpha(f4 * 0.4f);
                        canvas.concat(this.mMatrix);
                    }
                }
            }
            storeHouseBarItem.draw(canvas);
            canvas.restore();
        }
        if (this.mIsInLoading) {
            invalidate();
        }
        canvas.restoreToCount(save);
        super.dispatchDraw(canvas);
    }

    public StoreHouseHeader initWithPointList(List<float[]> list) {
        boolean z = this.mItemList.size() > 0;
        this.mItemList.clear();
        DensityUtil densityUtil = new DensityUtil();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            float[] fArr = list.get(i);
            PointF pointF = new PointF(((float) densityUtil.dip2px(fArr[0])) * this.mScale, ((float) densityUtil.dip2px(fArr[1])) * this.mScale);
            PointF pointF2 = new PointF(((float) densityUtil.dip2px(fArr[2])) * this.mScale, ((float) densityUtil.dip2px(fArr[3])) * this.mScale);
            f = Math.max(Math.max(f, pointF.x), pointF2.x);
            f2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem storeHouseBarItem = new StoreHouseBarItem(i, pointF, pointF2, this.mTextColor, this.mLineWidth);
            storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
            this.mItemList.add(storeHouseBarItem);
        }
        this.mDrawZoneWidth = (int) Math.ceil((double) f);
        this.mDrawZoneHeight = (int) Math.ceil((double) f2);
        if (z) {
            requestLayout();
        }
        return this;
    }

    public StoreHouseHeader initWithString(String str) {
        initWithString(str, 25);
        return this;
    }

    public StoreHouseHeader initWithStringArray(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            arrayList.add(fArr);
        }
        initWithPointList(arrayList);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mIsInLoading = false;
        this.mAniController.stop();
        if (!z || !this.mEnableFadeAnimation) {
            for (int i = 0; i < this.mItemList.size(); i++) {
                this.mItemList.get(i).resetPosition(this.mHorizontalRandomness);
            }
            return 0;
        }
        startAnimation(new Animation() {
            /* class com.scwang.smartrefresh.header.StoreHouseHeader.AnonymousClass1 */

            {
                super.setDuration(250);
                super.setInterpolator(new AccelerateInterpolator());
            }

            /* access modifiers changed from: protected */
            public void applyTransformation(float f, Transformation transformation) {
                StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
                storeHouseHeader.mProgress = 1.0f - f;
                storeHouseHeader.invalidate();
                if (f == 1.0f) {
                    for (int i = 0; i < StoreHouseHeader.this.mItemList.size(); i++) {
                        StoreHouseHeader.this.mItemList.get(i).resetPosition(StoreHouseHeader.this.mHorizontalRandomness);
                    }
                }
            }
        });
        return 250;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(super.getSuggestedMinimumHeight(), i2));
        this.mOffsetX = (getMeasuredWidth() - this.mDrawZoneWidth) / 2;
        this.mOffsetY = (getMeasuredHeight() - this.mDrawZoneHeight) / 2;
        this.mDropHeight = getMeasuredHeight() / 2;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mProgress = f * 0.8f;
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mIsInLoading = true;
        this.mAniController.start();
        invalidate();
    }

    public StoreHouseHeader setDropHeight(int i) {
        this.mDropHeight = i;
        return this;
    }

    public StoreHouseHeader setLineWidth(int i) {
        this.mLineWidth = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setLineWidth(i);
        }
        return this;
    }

    public StoreHouseHeader setLoadingAniDuration(int i) {
        this.mLoadingAniDuration = i;
        this.mLoadingAniSegDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            int i = iArr[0];
            this.mBackgroundColor = i;
            RefreshKernel refreshKernel = this.mRefreshKernel;
            if (refreshKernel != null) {
                refreshKernel.requestDrawBackgroundFor(this, i);
            }
            if (iArr.length > 1) {
                setTextColor(iArr[1]);
            }
        }
    }

    public StoreHouseHeader setScale(float f) {
        this.mScale = f;
        return this;
    }

    public StoreHouseHeader setTextColor(@ColorInt int i) {
        this.mTextColor = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setColor(i);
        }
        return this;
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreHouseHeader initWithString(String str, int i) {
        initWithPointList(xe2.a(str, ((float) i) * 0.01f, 14));
        return this;
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemList = new ArrayList();
        this.mLineWidth = -1;
        this.mScale = 1.0f;
        this.mDropHeight = -1;
        this.mHorizontalRandomness = -1;
        this.mProgress = 0.0f;
        this.mDrawZoneWidth = 0;
        this.mDrawZoneHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mLoadingAniDuration = 1000;
        this.mLoadingAniSegDuration = 1000;
        this.mTextColor = -1;
        this.mBackgroundColor = 0;
        this.mIsInLoading = false;
        this.mEnableFadeAnimation = false;
        this.mMatrix = new Matrix();
        this.mAniController = new AniController();
        this.mTransformation = new Transformation();
        DensityUtil densityUtil = new DensityUtil();
        this.mLineWidth = densityUtil.dip2px(1.0f);
        this.mDropHeight = densityUtil.dip2px(40.0f);
        this.mHorizontalRandomness = DisplayMetrics.getwidthPixels(Resources.getSystem().getDisplayMetrics()) / 2;
        this.mBackgroundColor = -13421773;
        setTextColor(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StoreHouseHeader);
        this.mLineWidth = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.StoreHouseHeader_shhLineWidth, this.mLineWidth);
        this.mDropHeight = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.StoreHouseHeader_shhDropHeight, this.mDropHeight);
        this.mEnableFadeAnimation = obtainStyledAttributes.getBoolean(R$styleable.StoreHouseHeader_shhEnableFadeAnimation, this.mEnableFadeAnimation);
        int i2 = R$styleable.StoreHouseHeader_shhText;
        if (obtainStyledAttributes.hasValue(i2)) {
            initWithString(obtainStyledAttributes.getString(i2));
        } else {
            initWithString("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.mDrawZoneHeight + DensityUtil.dp2px(40.0f));
    }
}
