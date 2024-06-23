package cn.damai.uikit.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ne2;

/* compiled from: Taobao */
public class NewSimpleTitleLayout extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private float curAlpha;
    private boolean isSetAlphaFirstTime;
    private boolean isWhiteBgNow;
    private Activity mActivity;
    private TextView mBackBtn;
    private View mDivider;
    private OnBtnClickListener mListener;
    private DMIconFontTextView mShareBtn;
    private View mSpaceView;
    private TextView mTitleTv;
    private boolean supportImmersive;

    /* compiled from: Taobao */
    public interface OnBtnClickListener {
        void onBackClick();

        void onShareClick();
    }

    public NewSimpleTitleLayout(@NonNull Context context) {
        this(context, null);
    }

    public void enableDivider(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833076167")) {
            ipChange.ipc$dispatch("833076167", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mDivider.setVisibility(0);
        } else {
            this.mDivider.setVisibility(4);
        }
    }

    public void enableImmersiveMode(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501841606")) {
            ipChange.ipc$dispatch("-1501841606", new Object[]{this, activity});
        } else if (activity != null) {
            this.mActivity = activity;
            this.supportImmersive = true;
            if (Build.VERSION.SDK_INT >= 23) {
                this.mSpaceView.getLayoutParams().height = ne2.a(activity);
                this.mSpaceView.setVisibility(0);
                ne2.f(activity, true, R$color.black);
                return;
            }
            ne2.f(activity, false, R$color.black);
            this.mSpaceView.setVisibility(8);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570461928")) {
            ipChange.ipc$dispatch("-1570461928", new Object[]{this, view});
        } else if (this.mListener != null) {
            int id = view.getId();
            if (id == this.mBackBtn.getId()) {
                this.mListener.onBackClick();
            } else if (id == this.mShareBtn.getId()) {
                this.mListener.onShareClick();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1880484255")) {
            ipChange.ipc$dispatch("-1880484255", new Object[]{this, canvas});
            return;
        }
        int i2 = (int) (this.curAlpha * 255.0f);
        if (i2 >= 0) {
            i = i2;
        }
        if (i > 255) {
            i = 255;
        }
        canvas.drawColor(Color.argb(i, 255, 255, 255));
    }

    public void setAlpha(float f) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1600799509")) {
            ipChange.ipc$dispatch("1600799509", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        boolean z2 = this.isSetAlphaFirstTime;
        if (z2 || this.curAlpha != f) {
            this.curAlpha = f;
            boolean z3 = ((double) f) > 0.5d;
            if (!z2 && this.isWhiteBgNow == z3) {
                z = false;
            }
            if (z2) {
                this.isSetAlphaFirstTime = false;
            }
            if (z) {
                switchMode(z3);
            }
            invalidate();
        }
    }

    public void setListener(OnBtnClickListener onBtnClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743004771")) {
            ipChange.ipc$dispatch("743004771", new Object[]{this, onBtnClickListener});
            return;
        }
        this.mListener = onBtnClickListener;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664052645")) {
            ipChange.ipc$dispatch("-1664052645", new Object[]{this, str});
            return;
        }
        this.mTitleTv.setText(str);
    }

    public void setTitleGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928781128")) {
            ipChange.ipc$dispatch("-928781128", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTitleTv.setGravity(i);
    }

    public void showShareBtn(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1897127463")) {
            ipChange.ipc$dispatch("1897127463", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DMIconFontTextView dMIconFontTextView = this.mShareBtn;
        if (!z) {
            i = 8;
        }
        dMIconFontTextView.setVisibility(i);
    }

    public void switchMode(boolean z) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732253188")) {
            ipChange.ipc$dispatch("1732253188", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isWhiteBgNow = z;
        if (z) {
            this.mBackBtn.setTextColor(Color.parseColor("#5F6672"));
            this.mShareBtn.setTextColor(Color.parseColor("#5F6672"));
            this.mDivider.setVisibility(0);
            this.mTitleTv.setVisibility(0);
        } else {
            this.mBackBtn.setTextColor(-1);
            this.mShareBtn.setTextColor(-1);
            this.mDivider.setVisibility(4);
            this.mTitleTv.setVisibility(4);
        }
        if (this.supportImmersive && (activity = this.mActivity) != null) {
            if (z) {
                ne2.f(activity, true, R$color.black);
                ne2.d(true, this.mActivity);
                return;
            }
            ne2.e(activity);
        }
    }

    public NewSimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewSimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.supportImmersive = false;
        this.isSetAlphaFirstTime = true;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_new_simple_title, (ViewGroup) this, false);
        addView(inflate, -1, -2);
        this.mSpaceView = inflate.findViewById(R$id.status_bar_space);
        this.mBackBtn = (TextView) inflate.findViewById(R$id.back_btn);
        this.mShareBtn = (DMIconFontTextView) inflate.findViewById(R$id.share_btn);
        this.mDivider = inflate.findViewById(R$id.divider);
        this.mTitleTv = (TextView) inflate.findViewById(R$id.title_tv);
        this.mBackBtn.setOnClickListener(this);
        this.mShareBtn.setOnClickListener(this);
        setWillNotDraw(false);
    }
}
