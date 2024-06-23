package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private CountDownTimer mClickTimer = new a(500, 500);
    private View.OnClickListener mInternalClick = new b();
    private boolean mIsSleep = false;
    private View.OnClickListener mOuterClickListener = null;

    /* compiled from: Taobao */
    public class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        a(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-166130694")) {
                ipChange.ipc$dispatch("-166130694", new Object[]{this});
                return;
            }
            FactFrameLayout.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-167134188")) {
                ipChange.ipc$dispatch("-167134188", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "712474302")) {
                ipChange.ipc$dispatch("712474302", new Object[]{this, view});
                return;
            }
            if (!FactFrameLayout.this.mIsSleep && FactFrameLayout.this.mOuterClickListener != null) {
                FactFrameLayout.this.mOuterClickListener.onClick(view);
            }
            FactFrameLayout.this.mIsSleep = true;
            FactFrameLayout.this.mClickTimer.cancel();
            FactFrameLayout.this.mClickTimer.start();
        }
    }

    public FactFrameLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845185492")) {
            ipChange.ipc$dispatch("1845185492", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652788181")) {
            ipChange.ipc$dispatch("652788181", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
