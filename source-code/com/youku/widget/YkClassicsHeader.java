package com.youku.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import tb.gd2;
import tb.ug2;

/* compiled from: Taobao */
public class YkClassicsHeader extends LinearLayout implements RefreshHeader {
    protected static final int ROTATE_ANIM_DURATION = 400;
    private AnimationDrawable anim;
    protected Context context;
    SpannableStringBuilder extraInfo;
    protected ImageView mArrowImageView;
    public int mArrowRotateHeight;
    protected TUrlImageView mBgImage;
    protected String mBgImageUrl;
    protected FrameLayout mContainer;
    protected TextView mHintView;
    public int mInitHeight;
    private LottieAnimationView mLoadingView;
    public int mMaxPullDownDistance;
    public int mRefreshingHeight;
    protected Animation mRotateCircleAnim;
    protected Animation mRotateDownAnim;
    protected Animation mRotateUpAnim;

    /* renamed from: com.youku.widget.YkClassicsHeader$3  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 3;
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public YkClassicsHeader(Context context2) {
        this(context2, null);
    }

    private void loading(boolean z) {
        if (this.mLoadingView == null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R$id.lottieView);
            this.mLoadingView = lottieAnimationView;
            if (lottieAnimationView == null) {
                return;
            }
        }
        if (z) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.playAnimation();
            return;
        }
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.pauseAnimation();
    }

    public ImageView getBgImageView() {
        return this.mBgImage;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public gd2 getSpinnerStyle() {
        return gd2.Translate;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    public int getVisibleHeight() {
        return ((LinearLayout.LayoutParams) this.mContainer.getLayoutParams()).height;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mInitHeight = 0;
        this.mMaxPullDownDistance = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        this.mArrowRotateHeight = getResources().getDimensionPixelOffset(R$dimen.homepage_arrow_rotate_distance) + this.mInitHeight;
        this.mRefreshingHeight = getResources().getDimensionPixelOffset(R$dimen.homepage_refreshing_height) + this.mInitHeight;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R$layout.listview_header, (ViewGroup) null);
        this.mContainer = frameLayout;
        this.mBgImage = (TUrlImageView) frameLayout.findViewById(R$id.bg_image);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, this.mInitHeight));
        setGravity(80);
        this.mHintView = (TextView) findViewById(R$id.listview_header_title);
        this.mArrowImageView = (ImageView) findViewById(R$id.listview_header_arrow);
        this.mLoadingView = (LottieAnimationView) findViewById(R$id.lottieView);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim = rotateAnimation;
        rotateAnimation.setDuration(400);
        this.mRotateUpAnim.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim = rotateAnimation2;
        rotateAnimation2.setDuration(400);
        this.mRotateDownAnim.setFillAfter(true);
        RotateAnimation rotateAnimation3 = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateCircleAnim = rotateAnimation3;
        rotateAnimation3.setDuration(400);
        this.mRotateCircleAnim.setRepeatCount(-1);
        this.mRotateCircleAnim.setRepeatMode(-1);
        this.mRotateCircleAnim.setInterpolator(new LinearInterpolator());
        measure(-2, this.mInitHeight);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        loading(false);
        this.mHintView.setVisibility(4);
        this.mArrowImageView.setVisibility(8);
        SpannableStringBuilder spannableStringBuilder = this.extraInfo;
        if (spannableStringBuilder == null) {
            return 500;
        }
        this.mHintView.setText(spannableStringBuilder);
        this.mHintView.setVisibility(0);
        return 500;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float f, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
    }

    public void onMove(float f) {
        if (getVisibleHeight() > this.mInitHeight || f > 0.0f) {
            setVisibleHeight(((int) f) + getVisibleHeight());
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        loading(true);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        int i = AnonymousClass3.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mArrowImageView.setImageResource(R$drawable.header_arrowdown);
            this.mArrowImageView.setVisibility(0);
            if (refreshState == RefreshState.ReleaseToRefresh) {
                this.mArrowImageView.startAnimation(this.mRotateDownAnim);
            }
        } else if (i == 3) {
            this.mArrowImageView.clearAnimation();
            loading(true);
            this.mArrowImageView.setVisibility(8);
            this.mHintView.setText("一大波你喜欢的视频正在赶来");
            this.mHintView.setVisibility(0);
        } else if (i == 4 && refreshState != RefreshState.ReleaseToRefresh) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        }
    }

    public void setArrowImageView(int i) {
        this.mArrowImageView.setImageResource(i);
    }

    public void setBgColor(String str) {
        int i;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = Integer.MIN_VALUE;
        }
        if (i != Integer.MIN_VALUE) {
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(i);
            this.mBgImage.setImageDrawable(colorDrawable);
        }
    }

    public void setBgImage(String str) {
        this.mBgImageUrl = str;
        setBgImage();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void setPrimaryColors(int... iArr) {
    }

    public void setVisibleHeight(int i) {
        int i2 = this.mInitHeight;
        if (i < i2) {
            i = i2;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        this.mContainer.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void smoothScrollTo(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.youku.widget.YkClassicsHeader.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                YkClassicsHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    public YkClassicsHeader(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet, 0);
        this.mInitHeight = -1;
        this.mBgImageUrl = "";
        this.context = context2;
        initView();
    }

    public void setBgImage() {
        if (this.mBgImage != null && !TextUtils.isEmpty(this.mBgImageUrl) && this.mBgImage.getContext() != null) {
            try {
                this.mBgImage.succListener(new IPhenixListener<ug2>() {
                    /* class com.youku.widget.YkClassicsHeader.AnonymousClass1 */

                    public boolean onHappen(ug2 ug2) {
                        if (ug2.f() == null || ug2.i()) {
                            return true;
                        }
                        BitmapDrawable f = ug2.f();
                        Matrix matrix = new Matrix();
                        int intrinsicWidth = f.getIntrinsicWidth();
                        int intrinsicHeight = f.getIntrinsicHeight();
                        float width = ((float) YkClassicsHeader.this.mBgImage.getWidth()) / ((float) intrinsicWidth);
                        matrix.setScale(width, width);
                        YkClassicsHeader.this.mBgImage.setScaleType(ImageView.ScaleType.MATRIX);
                        YkClassicsHeader.this.mBgImage.setImageMatrix(matrix);
                        ViewGroup.LayoutParams layoutParams = YkClassicsHeader.this.mBgImage.getLayoutParams();
                        layoutParams.height = (int) (((float) intrinsicHeight) * width);
                        YkClassicsHeader.this.mBgImage.setLayoutParams(layoutParams);
                        YkClassicsHeader.this.mContainer.setBackgroundColor(-1);
                        return true;
                    }
                });
                this.mBgImage.setImageUrl(this.mBgImageUrl);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
