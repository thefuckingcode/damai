package com.youku.live.dago.widgetlib.view.bottombar;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
public abstract class BaseBottomBarBtn extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ICON = UIUtil.dip2px(24);
    public static final int MARGIN = UIUtil.dip2px(9);
    public static final int PADDING = UIUtil.dip2px(12);
    public static final int SIZE = UIUtil.dip2px(36);
    private static final String TAG = "BottomBarBtn";
    private int mType;
    private OnBtnClickListener onBtnClickListener;

    /* compiled from: Taobao */
    public interface OnBtnClickListener {
        void onClick(BaseBottomBarBtn baseBottomBarBtn);
    }

    public BaseBottomBarBtn(@NonNull Context context, int i, OnBtnClickListener onBtnClickListener2) {
        super(context);
        this.mType = i;
        this.onBtnClickListener = onBtnClickListener2;
        setBackgroundResource(R.drawable.dago_pgc_bg_bottom_btn);
        setLayoutParams(getBtnLayoutParams());
        addView(getContentView());
        setOnClickListener(new CustomClickListener() {
            /* class com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* access modifiers changed from: protected */
            @Override // com.youku.live.dago.widgetlib.view.bottombar.CustomClickListener
            public void onFastClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1526318630")) {
                    ipChange.ipc$dispatch("1526318630", new Object[]{this});
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.youku.live.dago.widgetlib.view.bottombar.CustomClickListener
            public void onSingleClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1013549778")) {
                    ipChange.ipc$dispatch("1013549778", new Object[]{this});
                } else if (BaseBottomBarBtn.this.onBtnClickListener != null) {
                    BaseBottomBarBtn.this.onBtnClickListener.onClick(BaseBottomBarBtn.this);
                }
            }
        });
    }

    public abstract LinearLayout.LayoutParams getBtnLayoutParams();

    public abstract ViewGroup getContentView();

    public abstract Bitmap getIcon();

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "858288419")) {
            return this.mType;
        }
        return ((Integer) ipChange.ipc$dispatch("858288419", new Object[]{this})).intValue();
    }
}
