package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.youku.motioncurvex.MotionCurveXOvershootInterpolator;
import com.youku.motioncurvex.MotionCurveXStandardInterpolator;
import com.youku.resource.R;

/* compiled from: Taobao */
public class PlayerHorizontalGuideTipsView extends FrameLayout {
    private final int ANIM_DURATION_ALPHA = PlayerGuideTipsView.ANIM_DURATION_ALPHA;
    private final int ANIM_DURATION_SCALE = 465;
    private final float ANIM_TRANSLATE_INIT_VALUE = 0.1f;
    private ViewGroup mTipsHolder;
    private TextView mTipsView;
    private HorizontalGuideTipsType mType = HorizontalGuideTipsType.RIGHT;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.resource.widget.PlayerHorizontalGuideTipsView$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[HorizontalGuideTipsType.values().length];
            $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType = iArr;
            iArr[HorizontalGuideTipsType.RIGHT.ordinal()] = 1;
            $SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[HorizontalGuideTipsType.LEFT.ordinal()] = 2;
        }
    }

    /* compiled from: Taobao */
    public enum HorizontalGuideTipsType {
        RIGHT,
        LEFT
    }

    public PlayerHorizontalGuideTipsView(Context context) {
        super(context);
        initView();
    }

    public static int dp2px(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView() {
        this.mTipsHolder = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.resource_yk_horizontal_guide_tips_layout, this);
        this.mTipsView = (TextView) findViewById(R.id.tv_tips);
        setTipsType(HorizontalGuideTipsType.RIGHT);
    }

    public void hide() {
        if (getVisibility() != 8) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.yk_amin_guide_tips_alpha_hide);
            loadAnimation.setFillAfter(false);
            setVisibility(8);
            startAnimation(loadAnimation);
        }
    }

    public void setTipsText(String str) {
        this.mTipsView.setText(str);
    }

    public void setTipsType(HorizontalGuideTipsType horizontalGuideTipsType) {
        this.mType = horizontalGuideTipsType;
        int i = AnonymousClass1.$SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[horizontalGuideTipsType.ordinal()];
        if (i == 1) {
            this.mTipsHolder.setBackgroundResource(R.drawable.yk_guide_tips_left);
        } else if (i == 2) {
            this.mTipsHolder.setBackgroundResource(R.drawable.yk_guide_tips_right);
        }
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
            int i = AnonymousClass1.$SwitchMap$com$youku$resource$widget$PlayerHorizontalGuideTipsView$HorizontalGuideTipsType[this.mType.ordinal()];
            if (i == 1) {
                AnimationSet animationSet = new AnimationSet(false);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.1f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(465);
                translateAnimation.setInterpolator(new MotionCurveXOvershootInterpolator());
                animationSet.addAnimation(translateAnimation);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(230);
                alphaAnimation.setInterpolator(new MotionCurveXStandardInterpolator());
                animationSet.addAnimation(alphaAnimation);
                startAnimation(animationSet);
            } else if (i == 2) {
                AnimationSet animationSet2 = new AnimationSet(false);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.1f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation2.setDuration(465);
                translateAnimation2.setInterpolator(new MotionCurveXOvershootInterpolator());
                animationSet2.addAnimation(translateAnimation2);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(230);
                alphaAnimation2.setInterpolator(new MotionCurveXStandardInterpolator());
                animationSet2.addAnimation(alphaAnimation2);
                startAnimation(animationSet2);
            }
        }
    }

    public PlayerHorizontalGuideTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public PlayerHorizontalGuideTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
