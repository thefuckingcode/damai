package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import tb.dg2;
import tb.ft1;
import tb.gd2;

/* compiled from: Taobao */
public class WaterDropHeader extends InternalAbstract implements RefreshHeader {
    protected static final float MAX_PROGRESS_ANGLE = 0.8f;
    protected ImageView mImageView;
    protected MaterialProgressDrawable mProgress;
    protected ft1 mProgressDrawable;
    protected RefreshState mState;
    protected WaterDropView mWaterDropView;

    /* compiled from: Taobao */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(WaterDropHeader waterDropHeader, View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.a.setAlpha(1.0f);
        }
    }

    /* compiled from: Taobao */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            a[RefreshState.PullDownCanceled.ordinal()] = 3;
            a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            a[RefreshState.Refreshing.ordinal()] = 5;
            try {
                a[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public WaterDropHeader(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        WaterDropView waterDropView = this.mWaterDropView;
        ft1 ft1 = this.mProgressDrawable;
        if (this.mState == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((float) ((getWidth() / 2) - (Rect.width(ft1.getBounds()) / 2)), (float) ((this.mWaterDropView.getMaxCircleRadius() + waterDropView.getPaddingTop()) - (Rect.height(ft1.getBounds()) / 2)));
            ft1.draw(canvas);
            canvas.restore();
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mProgressDrawable.stop();
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = waterDropView.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        waterDropView.layout(i7, 0, i7 + measuredWidth2, waterDropView.getMeasuredHeight() + 0);
        int measuredWidth3 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > waterDropView.getBottom() - i11) {
            i10 = (waterDropView.getBottom() - i11) - measuredHeight;
        }
        imageView.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ImageView imageView = this.mImageView;
        WaterDropView waterDropView = this.mWaterDropView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        waterDropView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        super.setMeasuredDimension(View.resolveSize(Math.max(imageView.getMeasuredWidth(), waterDropView.getMeasuredWidth()), i), View.resolveSize(Math.max(imageView.getMeasuredHeight(), waterDropView.getMeasuredHeight()), i2));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshState refreshState;
        if (z || !((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased)) {
            WaterDropView waterDropView = this.mWaterDropView;
            waterDropView.updateCompleteState(Math.max(i, 0), i3 + i2);
            waterDropView.postInvalidate();
        }
        if (z) {
            float f2 = (float) i2;
            float max = (((float) Math.max(((double) Math.min(1.0f, Math.abs((((float) i) * 1.0f) / f2))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i) - i2), f2 * 2.0f) / f2) / 4.0f);
            this.mProgress.l(true);
            this.mProgress.j(0.0f, Math.min(0.8f, max * 0.8f));
            this.mProgress.d(Math.min(1.0f, max));
            this.mProgress.g((((0.4f * max) - 16.0f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        WaterDropView waterDropView = this.mWaterDropView;
        this.mProgressDrawable.start();
        this.mWaterDropView.createAnimator().start();
        waterDropView.animate().setDuration(150).alpha(0.0f).setListener(new a(this, waterDropView));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        WaterDropView waterDropView = this.mWaterDropView;
        this.mState = refreshState2;
        int i = b.a[refreshState2.ordinal()];
        if (i == 1) {
            waterDropView.setVisibility(0);
        } else if (i == 2) {
            waterDropView.setVisibility(0);
        } else if (i == 4) {
            waterDropView.setVisibility(0);
        } else if (i == 6) {
            waterDropView.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.layout.internal.InternalAbstract
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.mWaterDropView.setIndicatorColor(iArr[0]);
        }
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DensityUtil densityUtil = new DensityUtil();
        this.mSpinnerStyle = gd2.Scale;
        WaterDropView waterDropView = new WaterDropView(context);
        this.mWaterDropView = waterDropView;
        waterDropView.updateCompleteState(0);
        addView(this.mWaterDropView, -1, -1);
        ft1 ft1 = new ft1();
        this.mProgressDrawable = ft1;
        ft1.setCallback(this);
        ft1.setBounds(0, 0, densityUtil.dip2px(20.0f), densityUtil.dip2px(20.0f));
        this.mImageView = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(this.mImageView);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.e(-1);
        this.mProgress.setAlpha(255);
        this.mProgress.f(-1, -16737844, dg2.holoRedLight, -10053376, -5609780, -30720);
        this.mImageView.setImageDrawable(this.mProgress);
        addView(this.mImageView, densityUtil.dip2px(30.0f), densityUtil.dip2px(30.0f));
    }
}
