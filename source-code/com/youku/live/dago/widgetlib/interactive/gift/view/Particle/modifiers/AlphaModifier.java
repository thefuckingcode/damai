package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;

/* compiled from: Taobao */
public class AlphaModifier implements ParticleModifier {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mDuration;
    private long mEndTime;
    private int mFinalValue;
    private int mInitialValue;
    private Interpolator mInterpolator;
    private long mStartTime;
    private float mValueIncrement;

    public AlphaModifier(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.mInitialValue = i;
        this.mFinalValue = i2;
        this.mStartTime = j;
        this.mEndTime = j2;
        this.mDuration = (float) (j2 - j);
        this.mValueIncrement = (float) (i2 - i);
        this.mInterpolator = interpolator;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.ParticleModifier
    public void apply(Particle particle, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807850462")) {
            ipChange.ipc$dispatch("1807850462", new Object[]{this, particle, Long.valueOf(j)});
            return;
        }
        long j2 = this.mStartTime;
        if (j < j2) {
            particle.mAlpha = this.mInitialValue;
        } else if (j > this.mEndTime) {
            particle.mAlpha = this.mFinalValue;
        } else {
            particle.mAlpha = (int) (((float) this.mInitialValue) + (this.mValueIncrement * this.mInterpolator.getInterpolation((((float) (j - j2)) * 1.0f) / this.mDuration)));
        }
    }

    public AlphaModifier(int i, int i2, long j, long j2) {
        this(i, i2, j, j2, new LinearInterpolator());
    }
}
