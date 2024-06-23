package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactView extends View {
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
            if (AndroidInstantRuntime.support(ipChange, "960050826")) {
                ipChange.ipc$dispatch("960050826", new Object[]{this});
                return;
            }
            FactView.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-269353084")) {
                ipChange.ipc$dispatch("-269353084", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "-1988614834")) {
                ipChange.ipc$dispatch("-1988614834", new Object[]{this, view});
                return;
            }
            if (!FactView.this.mIsSleep && FactView.this.mOuterClickListener != null) {
                FactView.this.mOuterClickListener.onClick(view);
            }
            FactView.this.mIsSleep = true;
            FactView.this.mClickTimer.cancel();
            FactView.this.mClickTimer.start();
        }
    }

    public FactView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894546844")) {
            ipChange.ipc$dispatch("-1894546844", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643274939")) {
            ipChange.ipc$dispatch("-1643274939", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
