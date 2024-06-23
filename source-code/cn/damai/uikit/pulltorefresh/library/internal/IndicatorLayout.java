package cn.damai.uikit.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.damai.uikit.R$anim;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private ImageView mArrowImageView;
    private Animation mInAnim;
    private Animation mOutAnim;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
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

    public IndicatorLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);
        int i;
        int i2;
        this.mArrowImageView = new ImageView(context);
        Drawable drawable = getResources().getDrawable(R$drawable.default_ptr_flip);
        this.mArrowImageView.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.margin_4dp);
        this.mArrowImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.mArrowImageView);
        if (a.a[mode.ordinal()] != 1) {
            i = R$anim.slide_in_from_top;
            i2 = R$anim.slide_out_to_top;
            setBackgroundResource(R$drawable.indicator_bg_top);
        } else {
            i = R$anim.slide_in_from_bottom;
            int i3 = R$anim.slide_out_to_bottom;
            setBackgroundResource(R$drawable.indicator_bg_bottom);
            this.mArrowImageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, ((float) drawable.getIntrinsicWidth()) / 2.0f, ((float) drawable.getIntrinsicHeight()) / 2.0f);
            this.mArrowImageView.setImageMatrix(matrix);
            i2 = i3;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        this.mInAnim = loadAnimation;
        loadAnimation.setAnimationListener(this);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
        this.mOutAnim = loadAnimation2;
        loadAnimation2.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(150);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        rotateAnimation2.setDuration(150);
        rotateAnimation2.setFillAfter(true);
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179981682")) {
            ipChange.ipc$dispatch("179981682", new Object[]{this});
            return;
        }
        startAnimation(this.mOutAnim);
    }

    public final boolean isVisible() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376125810")) {
            return ((Boolean) ipChange.ipc$dispatch("1376125810", new Object[]{this})).booleanValue();
        }
        Animation animation = getAnimation();
        if (animation != null) {
            if (this.mInAnim == animation) {
                return true;
            }
            return false;
        } else if (getVisibility() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void onAnimationEnd(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633329538")) {
            ipChange.ipc$dispatch("-633329538", new Object[]{this, animation});
            return;
        }
        if (animation == this.mOutAnim) {
            this.mArrowImageView.clearAnimation();
            setVisibility(8);
        } else if (animation == this.mInAnim) {
            setVisibility(0);
        }
        clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241541578")) {
            ipChange.ipc$dispatch("-241541578", new Object[]{this, animation});
        }
    }

    public void onAnimationStart(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249129897")) {
            ipChange.ipc$dispatch("-249129897", new Object[]{this, animation});
            return;
        }
        setVisibility(0);
    }

    public void pullToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040764123")) {
            ipChange.ipc$dispatch("2040764123", new Object[]{this});
            return;
        }
        this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
    }

    public void releaseToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653525189")) {
            ipChange.ipc$dispatch("-1653525189", new Object[]{this});
            return;
        }
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334653399")) {
            ipChange.ipc$dispatch("1334653399", new Object[]{this});
            return;
        }
        this.mArrowImageView.clearAnimation();
        startAnimation(this.mInAnim);
    }
}
