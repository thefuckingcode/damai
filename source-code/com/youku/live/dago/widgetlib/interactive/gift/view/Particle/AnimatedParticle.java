package com.youku.live.dago.widgetlib.interactive.gift.view.Particle;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AnimatedParticle extends Particle {
    private static transient /* synthetic */ IpChange $ipChange;
    private AnimationDrawable mAnimationDrawable;
    private int mTotalTime = 0;

    public AnimatedParticle(AnimationDrawable animationDrawable) {
        this.mAnimationDrawable = animationDrawable;
        this.mImage = ((BitmapDrawable) animationDrawable.getFrame(0)).getBitmap();
        for (int i = 0; i < this.mAnimationDrawable.getNumberOfFrames(); i++) {
            this.mTotalTime += this.mAnimationDrawable.getDuration(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle
    public boolean update(long j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-668366077")) {
            return ((Boolean) ipChange.ipc$dispatch("-668366077", new Object[]{this, Long.valueOf(j)})).booleanValue();
        }
        boolean update = super.update(j);
        if (update) {
            long j2 = 0;
            long j3 = j - this.mStartingMilisecond;
            if (j3 > ((long) this.mTotalTime)) {
                if (this.mAnimationDrawable.isOneShot()) {
                    return false;
                }
                j3 %= (long) this.mTotalTime;
            }
            while (true) {
                if (i >= this.mAnimationDrawable.getNumberOfFrames()) {
                    break;
                }
                j2 += (long) this.mAnimationDrawable.getDuration(i);
                if (j2 > j3) {
                    this.mImage = ((BitmapDrawable) this.mAnimationDrawable.getFrame(i)).getBitmap();
                    break;
                }
                i++;
            }
        }
        return update;
    }
}
