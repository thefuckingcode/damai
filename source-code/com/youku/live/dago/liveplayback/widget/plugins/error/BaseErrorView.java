package com.youku.live.dago.liveplayback.widget.plugins.error;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
public class BaseErrorView implements View.OnClickListener, View.OnLayoutChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView mBtnFinish;
    private View mContent;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View mHolderView;
    private BaseErrorPlugin mPlugin;
    private Button mRefresh;
    private TextView mTextErrorCode = ((TextView) this.mHolderView.findViewById(R.id.code));
    private TextView mTextErrorMsg = ((TextView) this.mHolderView.findViewById(R.id.f1067tv));
    private TextView mTextErrorPIP = ((TextView) this.mHolderView.findViewById(R.id.tv_pip));

    public BaseErrorView(Context context, BaseErrorPlugin baseErrorPlugin) {
        this.mContext = context;
        this.mPlugin = baseErrorPlugin;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dago_player_template1, (ViewGroup) null);
        this.mHolderView = inflate;
        this.mContent = inflate.findViewById(R.id.content);
        this.mHolderView.setVisibility(8);
        ImageView imageView = (ImageView) this.mHolderView.findViewById(R.id.btn_back);
        this.mBtnFinish = imageView;
        imageView.setVisibility(8);
        this.mBtnFinish.setOnClickListener(this);
        Button button = (Button) this.mHolderView.findViewById(R.id.btn);
        this.mRefresh = button;
        button.setText("刷新");
        this.mRefresh.setVisibility(8);
        this.mRefresh.setOnClickListener(this);
        this.mHolderView.addOnLayoutChangeListener(this);
    }

    public View getHolderView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2019041536")) {
            return this.mHolderView;
        }
        return (View) ipChange.ipc$dispatch("-2019041536", new Object[]{this});
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037266333")) {
            ipChange.ipc$dispatch("-1037266333", new Object[]{this});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1696125675")) {
                    ipChange.ipc$dispatch("1696125675", new Object[]{this});
                    return;
                }
                BaseErrorView.this.mHolderView.setVisibility(8);
                BaseErrorView.this.mTextErrorMsg.setText("");
            }
        });
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800106794")) {
            ipChange.ipc$dispatch("-1800106794", new Object[]{this, view});
        } else if (view == this.mRefresh) {
            this.mPlugin.onRefresh();
        } else if (view == this.mBtnFinish) {
            this.mPlugin.onFinish();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179888762")) {
            ipChange.ipc$dispatch("-1179888762", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
        } else if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                if (width > height) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.mContent.setLayoutParams(layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 1;
                    layoutParams2.topMargin = (int) (((float) height) * 0.3f);
                    this.mContent.setLayoutParams(layoutParams2);
                }
                if (width <= height || !this.mPlugin.isFullScreen()) {
                    this.mBtnFinish.setVisibility(8);
                } else {
                    this.mBtnFinish.setVisibility(0);
                }
            }
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "642567114")) {
            ipChange.ipc$dispatch("642567114", new Object[]{this, Boolean.valueOf(z), configuration});
        } else if (z) {
            this.mContent.setVisibility(8);
            this.mTextErrorPIP.setVisibility(0);
        } else {
            this.mContent.setVisibility(0);
            this.mTextErrorPIP.setVisibility(8);
        }
    }

    public void setText(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "96330560")) {
            ipChange.ipc$dispatch("96330560", new Object[]{this, str});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorView.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1499612170")) {
                    ipChange.ipc$dispatch("1499612170", new Object[]{this});
                    return;
                }
                BaseErrorView.this.mTextErrorMsg.setText(str);
            }
        });
    }

    public void show(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641054574")) {
            ipChange.ipc$dispatch("-1641054574", new Object[]{this, str});
            return;
        }
        show(str, true);
    }

    public void showPiP(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885650539")) {
            ipChange.ipc$dispatch("-885650539", new Object[]{this, str});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1892639180")) {
                    ipChange.ipc$dispatch("1892639180", new Object[]{this});
                    return;
                }
                BaseErrorView.this.mTextErrorPIP.setText(str);
            }
        });
    }

    public void show(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666961538")) {
            ipChange.ipc$dispatch("666961538", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        show(str, null, z);
    }

    public void show(final String str, final String str2, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793014152")) {
            ipChange.ipc$dispatch("-1793014152", new Object[]{this, str, str2, Boolean.valueOf(z)});
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.youku.live.dago.liveplayback.widget.plugins.error.BaseErrorView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2089152685")) {
                    ipChange.ipc$dispatch("2089152685", new Object[]{this});
                    return;
                }
                BaseErrorView.this.mHolderView.setVisibility(0);
                BaseErrorView.this.mRefresh.setVisibility(z ? 0 : 8);
                BaseErrorView.this.mTextErrorMsg.setText(str);
                String str = null;
                if (!TextUtils.isEmpty(str2)) {
                    str = "错误代码 [ " + str2 + " ]";
                    BaseErrorView.this.mTextErrorCode.setVisibility(0);
                } else {
                    BaseErrorView.this.mTextErrorCode.setVisibility(8);
                }
                BaseErrorView.this.mTextErrorCode.setText(str);
            }
        });
    }
}
