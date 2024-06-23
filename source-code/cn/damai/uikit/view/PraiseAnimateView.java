package cn.damai.uikit.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$raw;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PraiseAnimateView extends LottieAnimationView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = PraiseAnimateView.class.getSimpleName();
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mCancellistener = new b();
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mClicklistener = new a();

    /* compiled from: Taobao */
    public class a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "306185654")) {
                ipChange.ipc$dispatch("306185654", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1845494073")) {
                ipChange.ipc$dispatch("1845494073", new Object[]{this, animator});
                return;
            }
            PraiseAnimateView praiseAnimateView = PraiseAnimateView.this;
            praiseAnimateView.removeAnimatorListener(praiseAnimateView.mClicklistener);
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1675206027")) {
                ipChange.ipc$dispatch("-1675206027", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746090926")) {
                ipChange.ipc$dispatch("-1746090926", new Object[]{this, animator});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1075355669")) {
                ipChange.ipc$dispatch("1075355669", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1837734714")) {
                ipChange.ipc$dispatch("1837734714", new Object[]{this, animator});
                return;
            }
            PraiseAnimateView praiseAnimateView = PraiseAnimateView.this;
            praiseAnimateView.removeAnimatorListener(praiseAnimateView.mCancellistener);
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-906036012")) {
                ipChange.ipc$dispatch("-906036012", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-612900333")) {
                ipChange.ipc$dispatch("-612900333", new Object[]{this, animator});
            }
        }
    }

    public PraiseAnimateView(Context context) {
        super(context);
    }

    public void playCancelAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865862702")) {
            ipChange.ipc$dispatch("-865862702", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_dian_zan_dismiss);
        addAnimatorListener(this.mCancellistener);
        playAnimation();
    }

    public void playClickAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284255912")) {
            ipChange.ipc$dispatch("-1284255912", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_dian_zan);
        addAnimatorListener(this.mClicklistener);
        playAnimation();
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859251761")) {
            ipChange.ipc$dispatch("-859251761", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(onClickListener);
    }

    public PraiseAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PraiseAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
