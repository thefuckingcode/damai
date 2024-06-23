package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactRelativeLayout extends RelativeLayout {
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
            if (AndroidInstantRuntime.support(ipChange, "2068704699")) {
                ipChange.ipc$dispatch("2068704699", new Object[]{this});
                return;
            }
            FactRelativeLayout.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1480516045")) {
                ipChange.ipc$dispatch("-1480516045", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "403296831")) {
                ipChange.ipc$dispatch("403296831", new Object[]{this, view});
                return;
            }
            if (!FactRelativeLayout.this.mIsSleep && FactRelativeLayout.this.mOuterClickListener != null) {
                FactRelativeLayout.this.mOuterClickListener.onClick(view);
            }
            FactRelativeLayout.this.mIsSleep = true;
            FactRelativeLayout.this.mClickTimer.cancel();
            FactRelativeLayout.this.mClickTimer.start();
        }
    }

    public FactRelativeLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135980629")) {
            ipChange.ipc$dispatch("1135980629", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509117580")) {
            ipChange.ipc$dispatch("-1509117580", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
