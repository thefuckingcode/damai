package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
public class HBRAudioView extends LazyInflatedView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HBRAudioView";
    private LottieAnimationView mLottieAudioChangedView;
    private HBRAudioPlugin mPresenter;

    public HBRAudioView(Context context, ILMLayerManager iLMLayerManager, String str) {
        super(context, iLMLayerManager, str, R.layout.dago_hbr_audio_view);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1393606612")) {
            ipChange.ipc$dispatch("-1393606612", new Object[]{this, view});
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.dago_hbr_audio);
        this.mLottieAudioChangedView = lottieAnimationView;
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-940637921")) {
                    ipChange.ipc$dispatch("-940637921", new Object[]{this, animator});
                }
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1503913584")) {
                    ipChange.ipc$dispatch("1503913584", new Object[]{this, animator});
                    return;
                }
                HBRAudioView.this.hide();
            }

            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1372937694")) {
                    ipChange.ipc$dispatch("1372937694", new Object[]{this, animator});
                }
            }

            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "707540937")) {
                    ipChange.ipc$dispatch("707540937", new Object[]{this, animator});
                }
            }
        });
    }

    public void setPresenter(HBRAudioPlugin hBRAudioPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624593872")) {
            ipChange.ipc$dispatch("-1624593872", new Object[]{this, hBRAudioPlugin});
            return;
        }
        this.mPresenter = hBRAudioPlugin;
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295471585")) {
            ipChange.ipc$dispatch("-1295471585", new Object[]{this});
            return;
        }
        super.show();
        this.mLottieAudioChangedView.playAnimation();
    }
}
