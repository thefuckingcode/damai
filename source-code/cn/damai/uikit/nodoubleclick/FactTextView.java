package cn.damai.uikit.nodoubleclick;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FactTextView extends AppCompatTextView {
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
            if (AndroidInstantRuntime.support(ipChange, "-840663337")) {
                ipChange.ipc$dispatch("-840663337", new Object[]{this});
                return;
            }
            FactTextView.this.mIsSleep = false;
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365296023")) {
                ipChange.ipc$dispatch("365296023", new Object[]{this, Long.valueOf(j)});
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
            if (AndroidInstantRuntime.support(ipChange, "824235099")) {
                ipChange.ipc$dispatch("824235099", new Object[]{this, view});
                return;
            }
            if (!FactTextView.this.mIsSleep && FactTextView.this.mOuterClickListener != null) {
                FactTextView.this.mOuterClickListener.onClick(view);
            }
            FactTextView.this.mIsSleep = true;
            FactTextView.this.mClickTimer.cancel();
            FactTextView.this.mClickTimer.start();
        }
    }

    public FactTextView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525772687")) {
            ipChange.ipc$dispatch("-1525772687", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsSleep = false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188810968")) {
            ipChange.ipc$dispatch("188810968", new Object[]{this, onClickListener});
            return;
        }
        super.setOnClickListener(this.mInternalClick);
        this.mOuterClickListener = onClickListener;
    }

    public FactTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FactTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
