package cn.damai.homepage.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SafeLottieAnimationView extends LottieAnimationView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int failCount = 0;
    private OnLottieDrawFailListener mListener;

    /* compiled from: Taobao */
    public interface OnLottieDrawFailListener {
        void onDrawLottieFail(Throwable th, int i);
    }

    public SafeLottieAnimationView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85210461")) {
            ipChange.ipc$dispatch("-85210461", new Object[]{this, canvas});
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            this.failCount++;
            if (this.mListener != null) {
                this.mListener.onDrawLottieFail(e, this.failCount);
            }
        }
    }

    public void setListener(OnLottieDrawFailListener onLottieDrawFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530184818")) {
            ipChange.ipc$dispatch("-1530184818", new Object[]{this, onLottieDrawFailListener});
            return;
        }
        this.mListener = onLottieDrawFailListener;
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
