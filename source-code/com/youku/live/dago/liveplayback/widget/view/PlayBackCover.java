package com.youku.live.dago.liveplayback.widget.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.livesdk.util.DebugHelp;

/* compiled from: Taobao */
public class PlayBackCover extends TUrlImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_COVER_BLEND_ANIMATION_INTERVAL = 200;
    private boolean mCoverHiding;
    private long mFirstDrawTime = -1;
    private boolean mHasFirstDraw;

    public PlayBackCover(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.taobao.uikit.feature.view.TImageView
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441737212")) {
            ipChange.ipc$dispatch("-441737212", new Object[]{this, canvas});
            return;
        }
        super.draw(canvas);
        if (!this.mHasFirstDraw && getDrawable() != null) {
            if (DebugHelp.isDebugBuild()) {
                Log.d("PlayBackCover", "draw drawable " + getDrawable());
            }
            this.mHasFirstDraw = true;
            this.mFirstDrawTime = System.currentTimeMillis();
        }
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189012419")) {
            ipChange.ipc$dispatch("1189012419", new Object[]{this});
        } else if (getVisibility() == 0) {
            if (!this.mHasFirstDraw) {
                if (DebugHelp.isDebugBuild()) {
                    Log.d("PlayBackCover", "hide");
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    setVisibility(4);
                } else {
                    post(new Runnable() {
                        /* class com.youku.live.dago.liveplayback.widget.view.PlayBackCover.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-2107163540")) {
                                ipChange.ipc$dispatch("-2107163540", new Object[]{this});
                                return;
                            }
                            PlayBackCover.this.setVisibility(4);
                        }
                    });
                }
            } else if (!this.mCoverHiding) {
                this.mCoverHiding = true;
                if (DebugHelp.isDebugBuild()) {
                    Log.d("PlayBackCover", "doAnimation");
                }
                animate().alpha(0.0f).setDuration(DEFAULT_COVER_BLEND_ANIMATION_INTERVAL).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
                    /* class com.youku.live.dago.liveplayback.widget.view.PlayBackCover.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-874347143")) {
                            ipChange.ipc$dispatch("-874347143", new Object[]{this, animator});
                            return;
                        }
                        super.onAnimationEnd(animator);
                        PlayBackCover.this.mCoverHiding = false;
                        if (DebugHelp.isDebugBuild()) {
                            Log.d("PlayBackCover", "onAnimationEnd");
                        }
                        PlayBackCover.this.setVisibility(4);
                    }
                }).start();
            }
        }
    }

    public PlayBackCover(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayBackCover(Context context) {
        super(context);
    }
}
