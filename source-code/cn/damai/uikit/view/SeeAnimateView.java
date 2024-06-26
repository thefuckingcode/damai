package cn.damai.uikit.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$raw;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m42;

/* compiled from: Taobao */
public class SeeAnimateView extends LottieAnimationView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = SeeAnimateView.class.getSimpleName();
    private int mAnimateDp = 18;
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mCancellistener = new c();
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mClicklistener = new b();
    @SuppressLint({"NewApi"})
    public Animator.AnimatorListener mGuidelistener = new a();
    private int mImageDp = 14;

    /* compiled from: Taobao */
    public class a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "552125745")) {
                ipChange.ipc$dispatch("552125745", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1620776034")) {
                ipChange.ipc$dispatch("-1620776034", new Object[]{this, animator});
                return;
            }
            SeeAnimateView.this.setImageResource(R$drawable.see_unfollowed);
            SeeAnimateView seeAnimateView = SeeAnimateView.this;
            seeAnimateView.removeAnimatorListener(seeAnimateView.mGuidelistener);
            SeeAnimateView.this.setImageSize();
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1429265936")) {
                ipChange.ipc$dispatch("-1429265936", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "62957943")) {
                ipChange.ipc$dispatch("62957943", new Object[]{this, animator});
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
            if (AndroidInstantRuntime.support(ipChange, "1321295760")) {
                ipChange.ipc$dispatch("1321295760", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1628535393")) {
                ipChange.ipc$dispatch("-1628535393", new Object[]{this, animator});
                return;
            }
            SeeAnimateView.this.setImageResource(R$drawable.see_followed);
            SeeAnimateView seeAnimateView = SeeAnimateView.this;
            seeAnimateView.removeAnimatorListener(seeAnimateView.mClicklistener);
            SeeAnimateView.this.setImageSize();
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-660095921")) {
                ipChange.ipc$dispatch("-660095921", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1196148536")) {
                ipChange.ipc$dispatch("1196148536", new Object[]{this, animator});
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2090465775")) {
                ipChange.ipc$dispatch("2090465775", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1636294752")) {
                ipChange.ipc$dispatch("-1636294752", new Object[]{this, animator});
                return;
            }
            SeeAnimateView.this.setImageResource(R$drawable.see_unfollowed);
            SeeAnimateView seeAnimateView = SeeAnimateView.this;
            seeAnimateView.removeAnimatorListener(seeAnimateView.mCancellistener);
            SeeAnimateView.this.setImageSize();
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "109074094")) {
                ipChange.ipc$dispatch("109074094", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1965628167")) {
                ipChange.ipc$dispatch("-1965628167", new Object[]{this, animator});
            }
        }
    }

    public SeeAnimateView(Context context) {
        super(context);
    }

    private void setAnimationSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585459545")) {
            ipChange.ipc$dispatch("-585459545", new Object[]{this});
            return;
        }
        getLayoutParams().width = m42.a(getContext(), (float) this.mAnimateDp);
        getLayoutParams().height = m42.a(getContext(), (float) this.mAnimateDp);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setImageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035274128")) {
            ipChange.ipc$dispatch("-2035274128", new Object[]{this});
            return;
        }
        getLayoutParams().width = m42.a(getContext(), (float) this.mImageDp);
        getLayoutParams().height = m42.a(getContext(), (float) this.mImageDp);
    }

    public void cancelAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877367481")) {
            ipChange.ipc$dispatch("1877367481", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_favorite_cancel);
        playAnimation();
    }

    public void clickAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364480623")) {
            ipChange.ipc$dispatch("-364480623", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_favourite_click);
        playAnimation();
    }

    public void guideAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858412027")) {
            ipChange.ipc$dispatch("-858412027", new Object[]{this});
            return;
        }
        setAnimation(R$raw.lottie_favorite_guide);
        playAnimation();
    }

    @Deprecated
    public void playCancelAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953912179")) {
            ipChange.ipc$dispatch("-953912179", new Object[]{this});
            return;
        }
        setAnimationSize();
        setAnimation(R$raw.lottie_favorite_cancel);
        addAnimatorListener(this.mCancellistener);
        playAnimation();
    }

    @Deprecated
    public void playClickAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622397757")) {
            ipChange.ipc$dispatch("1622397757", new Object[]{this});
            return;
        }
        setAnimationSize();
        setAnimation(R$raw.lottie_favourite_click);
        addAnimatorListener(this.mClicklistener);
        playAnimation();
    }

    @Deprecated
    public void playGuideAnimate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128466353")) {
            ipChange.ipc$dispatch("1128466353", new Object[]{this});
            return;
        }
        setAnimationSize();
        setAnimation(R$raw.lottie_favorite_guide);
        addAnimatorListener(this.mGuidelistener);
        playAnimation();
    }

    public void removeAnimateAndUnfollow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257757158")) {
            ipChange.ipc$dispatch("257757158", new Object[]{this});
            return;
        }
        removeAllAnimatorListeners();
        setImageSize();
        setImageResource(R$drawable.see_unfollowed);
    }

    public void setCancelImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32431221")) {
            ipChange.ipc$dispatch("-32431221", new Object[]{this});
            return;
        }
        removeAllAnimatorListeners();
        setAnimation(R$raw.lottie_favourite_click);
        setFrame(0);
    }

    public void setFollowImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984938046")) {
            ipChange.ipc$dispatch("-984938046", new Object[]{this});
            return;
        }
        removeAllAnimatorListeners();
        setAnimation(R$raw.lottie_favorite_cancel);
        setFrame(0);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762388448")) {
            ipChange.ipc$dispatch("-1762388448", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        setImageSize();
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850004234")) {
            ipChange.ipc$dispatch("1850004234", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(onClickListener);
    }

    @Deprecated
    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128722403")) {
            ipChange.ipc$dispatch("-128722403", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mImageDp = i;
        this.mAnimateDp = i2;
    }

    public SeeAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeeAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
