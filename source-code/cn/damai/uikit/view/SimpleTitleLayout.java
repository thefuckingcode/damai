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
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ne2;

/* compiled from: Taobao */
public class SimpleTitleLayout extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private float curAlpha;
    private boolean isSetAlphaFirstTime;
    private boolean isWhiteBgNow;
    private Activity mActivity;
    private TextView mBackBtn;
    private ViewGroup mBackBtnRightContainer;
    private View mDivider;
    private LeftActionView mLeftActionView;
    private OnBtnClickListener mListener;
    private TextView mShareBtn;
    private TextView mShareBtnV2;
    private View mSpaceView;
    private TextView mTitleTv;
    private boolean supportImmersive;

    /* compiled from: Taobao */
    public interface LeftActionView {
        View getLeftView();

        void switchMode(boolean z);
    }

    /* compiled from: Taobao */
    public interface OnBtnClickListener {
        void onBackClick();

        void onShareClick();
    }

    public SimpleTitleLayout(@NonNull Context context) {
        this(context, null);
    }

    public void addLeftActionView(LeftActionView leftActionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466418061")) {
            ipChange.ipc$dispatch("-466418061", new Object[]{this, leftActionView});
            return;
        }
        this.mLeftActionView = leftActionView;
        this.mBackBtnRightContainer.removeAllViews();
        this.mBackBtnRightContainer.addView(leftActionView.getLeftView());
    }

    public void enableDivider(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099402965")) {
            ipChange.ipc$dispatch("-1099402965", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mDivider.setVisibility(0);
        } else {
            this.mDivider.setVisibility(4);
        }
    }

    public void enableImmersiveMode(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1938342742")) {
            ipChange.ipc$dispatch("1938342742", new Object[]{this, activity});
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
        if (AndroidInstantRuntime.support(ipChange, "1174169212")) {
            ipChange.ipc$dispatch("1174169212", new Object[]{this, view});
        } else if (this.mListener != null) {
            int id = view.getId();
            if (id == this.mBackBtn.getId()) {
                this.mListener.onBackClick();
            } else if (id == this.mShareBtn.getId() || id == this.mShareBtnV2.getId()) {
                this.mListener.onShareClick();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "720786813")) {
            ipChange.ipc$dispatch("720786813", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "2043592497")) {
            ipChange.ipc$dispatch("2043592497", new Object[]{this, Float.valueOf(f)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1726334877")) {
            ipChange.ipc$dispatch("-1726334877", new Object[]{this, onBtnClickListener});
            return;
        }
        this.mListener = onBtnClickListener;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080578495")) {
            ipChange.ipc$dispatch("1080578495", new Object[]{this, str});
            return;
        }
        this.mTitleTv.setText(str);
    }

    public void setTitleGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679612188")) {
            ipChange.ipc$dispatch("1679612188", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void showShareBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905988541")) {
            ipChange.ipc$dispatch("-1905988541", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        showShareBtn(z, 0);
    }

    public void switchMode(boolean z) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054552352")) {
            ipChange.ipc$dispatch("2054552352", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isWhiteBgNow = z;
        if (z) {
            this.mBackBtn.setTextColor(-16777216);
            this.mShareBtn.setBackgroundResource(R$drawable.bg_share_pink_1);
            this.mShareBtn.setTextColor(Color.parseColor("#FF2869"));
            this.mShareBtnV2.setTextColor(Color.parseColor("#5f6672"));
            this.mDivider.setVisibility(0);
            this.mTitleTv.setVisibility(0);
        } else {
            this.mBackBtn.setTextColor(-1);
            this.mShareBtn.setBackgroundResource(R$drawable.bg_share_white_1);
            this.mShareBtn.setTextColor(-1);
            this.mShareBtnV2.setTextColor(-1);
            this.mDivider.setVisibility(4);
            this.mTitleTv.setVisibility(4);
        }
        LeftActionView leftActionView = this.mLeftActionView;
        if (leftActionView != null) {
            leftActionView.switchMode(z);
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

    public SimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void showShareBtn(boolean z, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1043926816")) {
            ipChange.ipc$dispatch("1043926816", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (i == 0) {
            TextView textView = this.mShareBtn;
            if (!z) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            this.mShareBtnV2.setVisibility(8);
        } else {
            TextView textView2 = this.mShareBtnV2;
            if (!z) {
                i2 = 8;
            }
            textView2.setVisibility(i2);
            this.mShareBtn.setVisibility(8);
        }
    }

    public SimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.supportImmersive = false;
        this.isSetAlphaFirstTime = true;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_simple_title, (ViewGroup) this, false);
        addView(inflate, -1, -2);
        this.mSpaceView = inflate.findViewById(R$id.status_bar_space);
        this.mBackBtn = (TextView) inflate.findViewById(R$id.back_btn);
        this.mShareBtn = (TextView) inflate.findViewById(R$id.share_btn);
        this.mShareBtnV2 = (TextView) inflate.findViewById(R$id.share_btn_v2);
        this.mDivider = inflate.findViewById(R$id.divider);
        this.mTitleTv = (TextView) inflate.findViewById(R$id.title_tv);
        this.mBackBtnRightContainer = (ViewGroup) inflate.findViewById(R$id.back_btn_right_container);
        this.mBackBtn.setOnClickListener(this);
        this.mShareBtn.setOnClickListener(this);
        this.mShareBtnV2.setOnClickListener(this);
        setWillNotDraw(false);
    }
}
