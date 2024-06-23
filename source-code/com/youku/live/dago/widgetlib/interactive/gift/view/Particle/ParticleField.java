package com.youku.live.dago.widgetlib.interactive.gift.view.Particle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ParticleField extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<Particle> mParticles;

    public ParticleField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856016039")) {
            ipChange.ipc$dispatch("1856016039", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        synchronized (this.mParticles) {
            for (int i = 0; i < this.mParticles.size(); i++) {
                this.mParticles.get(i).draw(canvas);
            }
        }
    }

    public void setParticles(ArrayList<Particle> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597921900")) {
            ipChange.ipc$dispatch("-1597921900", new Object[]{this, arrayList});
            return;
        }
        this.mParticles = arrayList;
    }

    public ParticleField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParticleField(Context context) {
        super(context);
    }
}
