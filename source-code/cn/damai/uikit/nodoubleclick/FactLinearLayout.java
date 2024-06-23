package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactLinearLayout extends LinearLayout {
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
            if (AndroidInstantRuntime.support(ipChange, "-204145260")) {
                ipChange.ipc$dispatch("-204145260", new Object[]{this});
                return;
            }
            FactLinearLayout.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1969475782")) {
                ipChange.ipc$dispatch("-1969475782", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "1844968920")) {
                ipChange.ipc$dispatch("1844968920", new Object[]{this, view});
                return;
            }
            if (!FactLinearLayout.this.mIsSleep && FactLinearLayout.this.mOuterClickListener != null) {
                FactLinearLayout.this.mOuterClickListener.onClick(view);
            }
            FactLinearLayout.this.mIsSleep = true;
            FactLinearLayout.this.mClickTimer.cancel();
            FactLinearLayout.this.mClickTimer.start();
        }
    }

    public FactLinearLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680767762")) {
            ipChange.ipc$dispatch("-1680767762", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742943749")) {
            ipChange.ipc$dispatch("-742943749", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
