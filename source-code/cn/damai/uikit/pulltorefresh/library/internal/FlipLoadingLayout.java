package cn.damai.uikit.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.AMapEngineUtils;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class FlipLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int FLIP_ANIMATION_DURATION = 150;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            a = iArr;
            iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
        }
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, false);
        float f = (float) (mode == PullToRefreshBase.Mode.PULL_FROM_START ? AMapEngineUtils.MIN_LONGITUDE_DEGREE : 180);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        Interpolator interpolator = LoadingLayout.ANIMATION_INTERPOLATOR;
        rotateAnimation.setInterpolator(interpolator);
        rotateAnimation.setDuration(150);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(interpolator);
        rotateAnimation2.setDuration(150);
        rotateAnimation2.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227557379")) {
            return ((Float) ipChange.ipc$dispatch("227557379", new Object[]{this})).floatValue();
        }
        int i = a.a[this.mMode.ordinal()];
        if (i == 1) {
            return this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL ? 90.0f : 180.0f;
        }
        if (i == 2 && this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) {
            return 270.0f;
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1041573943")) {
            return R$drawable.default_ptr_flip;
        }
        return ((Integer) ipChange.ipc$dispatch("1041573943", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051634063")) {
            ipChange.ipc$dispatch("-2051634063", new Object[]{this, drawable});
        } else if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(((float) (layoutParams.width - intrinsicWidth)) / 2.0f, ((float) (layoutParams.height - intrinsicHeight)) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), ((float) layoutParams.width) / 2.0f, ((float) layoutParams.height) / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onPullImpl(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649488144")) {
            ipChange.ipc$dispatch("1649488144", new Object[]{this, Float.valueOf(f)});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372300261")) {
            ipChange.ipc$dispatch("-1372300261", new Object[]{this});
        } else if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747390317")) {
            ipChange.ipc$dispatch("747390317", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
        this.mHeaderProgress.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180134779")) {
            ipChange.ipc$dispatch("1180134779", new Object[]{this});
            return;
        }
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796384871")) {
            ipChange.ipc$dispatch("1796384871", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }
}
