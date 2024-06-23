package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactButton extends AppCompatButton {
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
            if (AndroidInstantRuntime.support(ipChange, "-593103657")) {
                ipChange.ipc$dispatch("-593103657", new Object[]{this});
                return;
            }
            FactButton.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "234734487")) {
                ipChange.ipc$dispatch("234734487", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "-89077157")) {
                ipChange.ipc$dispatch("-89077157", new Object[]{this, view});
                return;
            }
            if (!FactButton.this.mIsSleep && FactButton.this.mOuterClickListener != null) {
                FactButton.this.mOuterClickListener.onClick(view);
            }
            FactButton.this.mIsSleep = true;
            FactButton.this.mClickTimer.cancel();
            FactButton.this.mClickTimer.start();
        }
    }

    public FactButton(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626637425")) {
            ipChange.ipc$dispatch("1626637425", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502490408")) {
            ipChange.ipc$dispatch("-1502490408", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
