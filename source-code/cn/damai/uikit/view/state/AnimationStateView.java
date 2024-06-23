package cn.damai.uikit.view.state;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.op1;
import tb.pp1;
import tb.qp1;
import tb.rp1;
import tb.sp1;

/* compiled from: Taobao */
public class AnimationStateView extends View implements ValueAnimator.AnimatorUpdateListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isAttachedToWindow;
    private ValueAnimator mAnimator;
    private int mBgColor;
    private final List<PhaseDrawable> mDrawableList;
    private int mLastAnimateValue;
    private float scale;

    /* compiled from: Taobao */
    public interface PhaseDrawable {
        void draw(Canvas canvas, AnimationStateView animationStateView);

        void setPhase(int i);
    }

    public AnimationStateView(Context context) {
        this(context, null);
    }

    private boolean isAllowAnimation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2100160934")) {
            return this.isAttachedToWindow && getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("2100160934", new Object[]{this})).booleanValue();
    }

    public void cancelAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450418297")) {
            ipChange.ipc$dispatch("1450418297", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370455105")) {
            ipChange.ipc$dispatch("-1370455105", new Object[]{this, valueAnimator});
        } else if (!isAllowAnimation()) {
            cancelAnimation();
        } else if (this.mDrawableList.size() > 0 && this.mLastAnimateValue != (intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue())) {
            this.mLastAnimateValue = intValue;
            float f = 1.5f;
            float f2 = 1.0f;
            float f3 = intValue > 50 ? 1.5f - ((((float) (intValue - 50)) * 0.5f) / 50.0f) : ((((float) intValue) * 0.5f) / 50.0f) + 1.0f;
            if (f3 >= 1.0f) {
                f2 = f3;
            }
            if (f2 <= 1.5f) {
                f = f2;
            }
            this.scale = f;
            for (PhaseDrawable phaseDrawable : this.mDrawableList) {
                phaseDrawable.setPhase(intValue);
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589692807")) {
            ipChange.ipc$dispatch("-1589692807", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        if (isAllowAnimation()) {
            playAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404018012")) {
            ipChange.ipc$dispatch("404018012", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        cancelAnimation();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692370879")) {
            ipChange.ipc$dispatch("-1692370879", new Object[]{this, canvas});
            return;
        }
        canvas.save();
        float f = this.scale;
        canvas.scale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        canvas.drawColor(-1);
        for (PhaseDrawable phaseDrawable : this.mDrawableList) {
            phaseDrawable.draw(canvas, this);
        }
        canvas.restore();
    }

    public void pauseAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223184729")) {
            ipChange.ipc$dispatch("1223184729", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            cancelAnimation();
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.mAnimator.pause();
        }
    }

    public void playAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731508659")) {
            ipChange.ipc$dispatch("1731508659", new Object[]{this});
            return;
        }
        cancelAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.mAnimator = ofInt;
        ofInt.setDuration(DanmakuFactory.MIN_DANMAKU_DURATION);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setRepeatMode(2);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(this);
        this.mAnimator.start();
        this.mAnimator.start();
    }

    public void resumeAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615283628")) {
            ipChange.ipc$dispatch("1615283628", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null && valueAnimator.isPaused()) {
                this.mAnimator.resume();
            }
        } else {
            playAnimation();
        }
    }

    public void setAnimation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "337917135")) {
            ipChange.ipc$dispatch("337917135", new Object[]{this, str});
        }
    }

    public void setImageAssetsFolder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "730709639")) {
            ipChange.ipc$dispatch("730709639", new Object[]{this, str});
        }
    }

    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751153684")) {
            ipChange.ipc$dispatch("1751153684", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            playAnimation();
        } else {
            cancelAnimation();
        }
    }

    public AnimationStateView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationStateView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ArrayList arrayList = new ArrayList();
        this.mDrawableList = arrayList;
        this.scale = 1.0f;
        this.isAttachedToWindow = false;
        this.mBgColor = Color.parseColor("#D4C8FF");
        arrayList.add(new op1(context));
        arrayList.add(new pp1(context));
        arrayList.add(new qp1(context));
        arrayList.add(new rp1(context));
        arrayList.add(new sp1(context));
        Collections.reverse(arrayList);
    }
}
