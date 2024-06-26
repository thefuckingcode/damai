package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRContract;
import com.youku.live.dago.liveplayback.widget.view.CenterHoleFrameLayout;
import com.youku.motioncurvex.MotionCurveXStandardInterpolator;

/* compiled from: Taobao */
public class HBRPluginView extends LazyInflatedView implements HBRContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HBR_CHANGING_LOTTIE = "https://files.alicdn.com/tpsservice/b234d841c270b1ffd3657c3041993bdd.zip";
    private static final String TAG = "HBRPluginView";
    private AlphaAnimation mAlphaAnimate;
    private FrameLayout mAlphaMask;
    private FrameLayout mAnimLayout;
    private CenterHoleFrameLayout mCenterHoleMask;
    private LottieAnimationView mHBRChangingLottieView;
    private ImageView mHBRCloseImage;
    private TUrlImageView mHBRInfoBtn;
    private View mHBRInfoView;
    private TUrlImageView mHBRInstructionImage;
    private LottieAnimationView mHBRLogoChangedLottieView;
    private LottieAnimationView mHBRLogoChangingLottieView;
    private TextView mHbrText;
    private boolean mIsFilmPassFuncEnable = false;
    private boolean mIsFirstRepeatEnd = false;
    private boolean mIsHBRChanged = false;
    private boolean mIsHaveHBRRight = true;
    private boolean mIsLimitedTimeFree = false;
    private HBRContract.Presenter mPresenter;
    private String mSourceFrom;

    public HBRPluginView(AlixPlayerContext alixPlayerContext, ILMLayerManager iLMLayerManager, String str, int i, ViewPlaceholder viewPlaceholder) {
        super(alixPlayerContext, iLMLayerManager, str, i, viewPlaceholder);
    }

    private void initHBRChangedAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675306348")) {
            ipChange.ipc$dispatch("1675306348", new Object[]{this});
            return;
        }
        this.mHBRLogoChangedLottieView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-434771534")) {
                    ipChange.ipc$dispatch("-434771534", new Object[]{this, valueAnimator});
                    return;
                }
                Float f = (Float) valueAnimator.getAnimatedValue();
                if (f != null && f.floatValue() > 0.7f) {
                    HBRPluginView.this.mHbrText.setAlpha((1.0f - f.floatValue()) * 3.3f);
                    HBRPluginView.this.mAlphaMask.setAlpha(1.0f - f.floatValue());
                }
            }
        });
        this.mHBRLogoChangedLottieView.addAnimatorListener(new Animator.AnimatorListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "73783917")) {
                    ipChange.ipc$dispatch("73783917", new Object[]{this, animator});
                }
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2003419166")) {
                    ipChange.ipc$dispatch("-2003419166", new Object[]{this, animator});
                    return;
                }
                HBRPluginView.this.hide();
                HBRPluginView.this.mPresenter.showHBRChangedTips();
            }

            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1907607764")) {
                    ipChange.ipc$dispatch("-1907607764", new Object[]{this, animator});
                }
            }

            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1710095547")) {
                    ipChange.ipc$dispatch("1710095547", new Object[]{this, animator});
                }
            }
        });
    }

    private void initHBRChangingAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391185635")) {
            ipChange.ipc$dispatch("-391185635", new Object[]{this});
            return;
        }
        this.mHBRLogoChangingLottieView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1695688784")) {
                    ipChange.ipc$dispatch("-1695688784", new Object[]{this, valueAnimator});
                    return;
                }
                Float f = (Float) valueAnimator.getAnimatedValue();
                if (f != null) {
                    HBRPluginView.this.mHbrText.setAlpha(f.floatValue());
                }
            }
        });
        try {
            this.mHBRChangingLottieView.setAnimationFromUrl(HBR_CHANGING_LOTTIE, "hbr_changing_lottie");
        } catch (Exception unused) {
        }
        this.mHBRChangingLottieView.addAnimatorListener(new Animator.AnimatorListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1464556113")) {
                    ipChange.ipc$dispatch("-1464556113", new Object[]{this, animator});
                }
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1987900448")) {
                    ipChange.ipc$dispatch("-1987900448", new Object[]{this, animator});
                    return;
                }
                HBRPluginView.this.mIsFirstRepeatEnd = true;
                if (HBRPluginView.this.mIsHBRChanged) {
                    if (HBRPluginView.this.mHBRChangingLottieView != null) {
                        HBRPluginView.this.mHBRChangingLottieView.cancelAnimation();
                    }
                    HBRPluginView.this.switchToChanged();
                }
            }

            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "849019502")) {
                    ipChange.ipc$dispatch("849019502", new Object[]{this, animator});
                } else if (HBRPluginView.this.mIsHBRChanged) {
                    if (HBRPluginView.this.mHBRChangingLottieView != null) {
                        HBRPluginView.this.mHBRChangingLottieView.cancelAnimation();
                    }
                    HBRPluginView.this.switchToChanged();
                }
            }

            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-556285639")) {
                    ipChange.ipc$dispatch("-556285639", new Object[]{this, animator});
                }
            }
        });
    }

    private void initHBRIntroduction(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739866035")) {
            ipChange.ipc$dispatch("739866035", new Object[]{this, view});
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.hdr_introduction_view);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            this.mHBRInfoView = inflate;
            this.mHBRInstructionImage = (TUrlImageView) inflate.findViewById(R.id.hdr_instruction_image);
            this.mHBRCloseImage = (ImageView) this.mHBRInfoView.findViewById(R.id.hdr_info_close);
            TUrlImageView tUrlImageView = (TUrlImageView) this.mHBRInfoView.findViewById(R.id.hdr_info_btn);
            this.mHBRInfoBtn = tUrlImageView;
            tUrlImageView.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "42465319")) {
                        ipChange.ipc$dispatch("42465319", new Object[]{this, view});
                        return;
                    }
                    HBRPluginView.this.mHBRInfoView.setVisibility(8);
                    HBRPluginView.this.hide();
                    HBRPluginView.this.setOrientation(ApiConstants.EventType.ORIENTATION_ENABLE);
                    HBRPluginView.this.mPresenter.doClickHdrInstructionClose();
                    HBRPluginView.this.mPresenter.hideQualityView();
                    HBRPluginView.this.mPresenter.openHBR();
                }
            });
            this.mHBRCloseImage.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2141211608")) {
                        ipChange.ipc$dispatch("-2141211608", new Object[]{this, view});
                        return;
                    }
                    HBRPluginView.this.mHBRInfoView.setVisibility(8);
                    HBRPluginView.this.hide();
                    HBRPluginView.this.setOrientation(ApiConstants.EventType.ORIENTATION_ENABLE);
                    HBRPluginView.this.mPresenter.doClickHdrInstructionClose();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132679653")) {
            ipChange.ipc$dispatch("1132679653", new Object[]{this, str});
            return;
        }
        this.mPresenter.setOrientation(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void switchToChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "231455932")) {
            ipChange.ipc$dispatch("231455932", new Object[]{this});
            return;
        }
        this.mHbrText.setAlpha(1.0f);
        TextView textView = this.mHbrText;
        if (textView != null) {
            textView.setText("视觉盛宴，无时无刻，无所不在");
        }
        this.mHBRChangingLottieView.setVisibility(8);
        this.mHBRLogoChangingLottieView.setVisibility(8);
        this.mHBRLogoChangedLottieView.setVisibility(0);
        this.mHBRLogoChangedLottieView.playAnimation();
        FrameLayout frameLayout = this.mAlphaMask;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.mAlphaMask.setAlpha(0.3f);
        }
        CenterHoleFrameLayout centerHoleFrameLayout = this.mCenterHoleMask;
        if (centerHoleFrameLayout != null) {
            centerHoleFrameLayout.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
            this.mAlphaAnimate = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.mAlphaAnimate.setDuration(1000);
            this.mAlphaAnimate.setInterpolator(new MotionCurveXStandardInterpolator(0.4f, 0.0f, 0.2f, 1.0f) {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.motioncurvex.MotionCurveXStandardInterpolator
                public float getInterpolation(float f) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1610738466")) {
                        return ((Float) ipChange.ipc$dispatch("1610738466", new Object[]{this, Float.valueOf(f)})).floatValue();
                    }
                    float interpolation = super.getInterpolation(f);
                    HBRPluginView.this.mCenterHoleMask.updateCircleFac(interpolation);
                    return interpolation;
                }
            });
            this.mAlphaAnimate.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass8 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1196721479")) {
                        ipChange.ipc$dispatch("1196721479", new Object[]{this, animation});
                        return;
                    }
                    HBRPluginView.this.switchToEndAnimate();
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1506549555")) {
                        ipChange.ipc$dispatch("-1506549555", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1788273376")) {
                        ipChange.ipc$dispatch("1788273376", new Object[]{this, animation});
                    }
                }
            });
            this.mCenterHoleMask.startAnimation(this.mAlphaAnimate);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void switchToEndAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939375060")) {
            ipChange.ipc$dispatch("939375060", new Object[]{this});
            return;
        }
        CenterHoleFrameLayout centerHoleFrameLayout = this.mCenterHoleMask;
        if (centerHoleFrameLayout != null) {
            centerHoleFrameLayout.setVisibility(8);
            this.mCenterHoleMask.setAlpha(0.7f);
        }
        FrameLayout frameLayout = this.mAlphaMask;
        if (frameLayout != null) {
            frameLayout.setAlpha(0.3f);
            this.mAlphaMask.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void handleHBRCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278507657")) {
            ipChange.ipc$dispatch("-278507657", new Object[]{this});
            return;
        }
        this.mIsHBRChanged = false;
        hide();
    }

    /* access modifiers changed from: protected */
    public void handleHBRChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232404741")) {
            ipChange.ipc$dispatch("232404741", new Object[]{this});
            return;
        }
        this.mIsHBRChanged = true;
        if (this.mIsFirstRepeatEnd) {
            LottieAnimationView lottieAnimationView = this.mHBRChangingLottieView;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            switchToChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void handleHBRDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471028737")) {
            ipChange.ipc$dispatch("-471028737", new Object[]{this});
            return;
        }
        this.mIsHBRChanged = false;
        LottieAnimationView lottieAnimationView = this.mHBRChangingLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllAnimatorListeners();
        }
        LottieAnimationView lottieAnimationView2 = this.mHBRChangingLottieView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.removeAllAnimatorListeners();
        }
        LottieAnimationView lottieAnimationView3 = this.mHBRLogoChangedLottieView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.removeAllAnimatorListeners();
        }
    }

    /* access modifiers changed from: protected */
    public void handleStartHBRChanging() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913715710")) {
            ipChange.ipc$dispatch("1913715710", new Object[]{this});
            return;
        }
        View view = this.mHBRInfoView;
        if (view != null) {
            view.setVisibility(8);
        }
        this.mIsFirstRepeatEnd = false;
        this.mIsHBRChanged = false;
        TextView textView = this.mHbrText;
        if (textView != null) {
            textView.setAlpha(1.0f);
            this.mHbrText.setText("帧享影音");
        }
        FrameLayout frameLayout = this.mAlphaMask;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.mAlphaMask.setAlpha(0.3f);
        }
        CenterHoleFrameLayout centerHoleFrameLayout = this.mCenterHoleMask;
        if (centerHoleFrameLayout != null) {
            centerHoleFrameLayout.setVisibility(0);
            this.mCenterHoleMask.setAlpha(0.7f);
            this.mCenterHoleMask.reset();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
            this.mAlphaAnimate = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.mAlphaAnimate.setDuration(800);
            this.mAlphaAnimate.setInterpolator(new MotionCurveXStandardInterpolator(0.4f, 0.0f, 0.2f, 1.0f) {
                /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPluginView.AnonymousClass9 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.motioncurvex.MotionCurveXStandardInterpolator
                public float getInterpolation(float f) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1476724960")) {
                        return ((Float) ipChange.ipc$dispatch("1476724960", new Object[]{this, Float.valueOf(f)})).floatValue();
                    }
                    float interpolation = super.getInterpolation(f);
                    HBRPluginView.this.mCenterHoleMask.setAlpha(interpolation);
                    return interpolation;
                }
            });
            this.mCenterHoleMask.startAnimation(this.mAlphaAnimate);
        }
        LottieAnimationView lottieAnimationView = this.mHBRChangingLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            this.mHBRChangingLottieView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.mHBRLogoChangingLottieView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
            this.mHBRLogoChangingLottieView.playAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.mHBRLogoChangedLottieView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.cancelAnimation();
            this.mHBRLogoChangedLottieView.setVisibility(8);
        }
    }

    @Override // com.youku.alixplugin.view.BaseView, com.youku.alixplugin.view.LazyInflatedView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710029273")) {
            ipChange.ipc$dispatch("-710029273", new Object[]{this});
            return;
        }
        super.hide();
        FrameLayout frameLayout = this.mAnimLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView = this.mHBRChangingLottieView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.mHBRLogoChangingLottieView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.mHBRLogoChangedLottieView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.cancelAnimation();
        }
        CenterHoleFrameLayout centerHoleFrameLayout = this.mCenterHoleMask;
        if (centerHoleFrameLayout != null) {
            centerHoleFrameLayout.clearAnimation();
        }
        AlphaAnimation alphaAnimation = this.mAlphaAnimate;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        View view = this.mHBRInfoView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "933237145")) {
            ipChange.ipc$dispatch("933237145", new Object[]{this, view});
        } else if (view != null) {
            this.mAnimLayout = (FrameLayout) view.findViewById(R.id.anim_layout);
            this.mCenterHoleMask = (CenterHoleFrameLayout) view.findViewById(R.id.dago_center_hole_mask);
            this.mAlphaMask = (FrameLayout) view.findViewById(R.id.alpha_mask);
            this.mHBRChangingLottieView = (LottieAnimationView) view.findViewById(R.id.hbr_changing_lottie);
            this.mHBRLogoChangingLottieView = (LottieAnimationView) view.findViewById(R.id.hbr_logo_changing_lottie);
            this.mHBRLogoChangedLottieView = (LottieAnimationView) view.findViewById(R.id.hbr_logo_changed_lottie);
            this.mHbrText = (TextView) view.findViewById(R.id.hbr_text);
            initHBRChangingAnimate();
            initHBRChangedAnimate();
        }
    }

    @Override // com.youku.alixplugin.view.BaseView, com.youku.alixplugin.view.LazyInflatedView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444642444")) {
            ipChange.ipc$dispatch("444642444", new Object[]{this});
            return;
        }
        super.show();
        FrameLayout frameLayout = this.mAnimLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void showShowHBRIntroduction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472192201")) {
            ipChange.ipc$dispatch("1472192201", new Object[]{this});
            return;
        }
        showShowHBRIntroduction(true, false, false, "");
    }

    public void setPresenter(HBRContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268102196")) {
            ipChange.ipc$dispatch("1268102196", new Object[]{this, presenter});
            return;
        }
        this.mPresenter = presenter;
    }

    /* access modifiers changed from: protected */
    public void showShowHBRIntroduction(boolean z, boolean z2, boolean z3, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254051317")) {
            ipChange.ipc$dispatch("1254051317", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str});
            return;
        }
        super.show();
        this.mIsHaveHBRRight = z;
        this.mIsLimitedTimeFree = z2;
        this.mIsFilmPassFuncEnable = z3;
        this.mSourceFrom = str;
        if (!this.isInflated) {
            inflate();
        }
        if (this.mHBRInfoView == null) {
            initHBRIntroduction(getInflatedView());
        }
        this.mAnimLayout.setVisibility(8);
        View view = this.mHBRInfoView;
        if (view != null) {
            view.setVisibility(0);
            setOrientation(ApiConstants.EventType.ORIENTATION_DISABLE);
            this.mHBRInstructionImage.setImageUrl("https://gw.alicdn.com/tfs/TB1_CjCExv1gK0jSZFFXXb0sXXa-2001-1125.jpg?getAvatar=");
            this.mHBRInfoBtn.setImageUrl("https://gw.alicdn.com/tfs/TB1HrU8EhD1gK0jSZFyXXciOVXa-618-108.png");
        }
    }
}
