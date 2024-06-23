package cn.damai.uikit.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RotateLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int ROTATION_ANIMATION_DURATION = 1200;
    private final Matrix mHeaderImageMatrix;
    private final Animation mRotateAnimation;
    private final boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, false);
        this.mRotateDrawableWhilePulling = typedArray.getBoolean(R$styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.mHeaderImageMatrix = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.ANIMATION_INTERPOLATOR);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
    }

    private void resetImageRotation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737591460")) {
            ipChange.ipc$dispatch("-737591460", new Object[]{this});
            return;
        }
        Matrix matrix = this.mHeaderImageMatrix;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1937111077")) {
            return R$drawable.default_ptr_rotate;
        }
        return ((Integer) ipChange.ipc$dispatch("1937111077", new Object[]{this})).intValue();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9178557")) {
            ipChange.ipc$dispatch("-9178557", new Object[]{this, drawable});
        } else if (drawable != null) {
            this.mRotationPivotX = (float) Math.round(((float) drawable.getIntrinsicWidth()) / 2.0f);
            this.mRotationPivotY = (float) Math.round(((float) drawable.getIntrinsicHeight()) / 2.0f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onPullImpl(float f) {
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971503102")) {
            ipChange.ipc$dispatch("971503102", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (this.mRotateDrawableWhilePulling) {
            f2 = f * 90.0f;
        } else {
            f2 = Math.max(0.0f, Math.min(180.0f, (f * 360.0f) - 180.0f));
        }
        this.mHeaderImageMatrix.setRotate(f2, this.mRotationPivotX, this.mRotationPivotY);
        this.mHeaderImage.setImageMatrix(this.mHeaderImageMatrix);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890793097")) {
            ipChange.ipc$dispatch("1890793097", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126197183")) {
            ipChange.ipc$dispatch("2126197183", new Object[]{this});
            return;
        }
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295414707")) {
            ipChange.ipc$dispatch("-295414707", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170798891")) {
            ipChange.ipc$dispatch("-170798891", new Object[]{this});
            return;
        }
        this.mHeaderImage.clearAnimation();
        resetImageRotation();
    }
}
