package com.youku.live.dago.liveplayback.widget.plugins.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.dago.liveplayback.R;
import com.youku.media.arch.instruments.ConfigFetcher;
import tb.tp1;

/* compiled from: Taobao */
public class PickRotateTipsView extends PopupWindow implements View.OnClickListener, PopupWindow.OnDismissListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SP_LIVE_TIP = "alix_live_tip";
    private Runnable mCloseRunnable = new Runnable() {
        /* class com.youku.live.dago.liveplayback.widget.plugins.player.PickRotateTipsView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "465092283")) {
                ipChange.ipc$dispatch("465092283", new Object[]{this});
                return;
            }
            PickRotateTipsView.this.close();
        }
    };
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View mParentView = null;

    public PickRotateTipsView(Context context, View view) {
        this.mContext = context;
        this.mParentView = view;
        initUi(context);
    }

    private boolean canShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052756618")) {
            return ((Boolean) ipChange.ipc$dispatch("1052756618", new Object[]{this})).booleanValue();
        } else if (!enablePickModeRotate()) {
            return false;
        } else {
            return !this.mContext.getSharedPreferences("alix_live_tip", 0).getBoolean("is_pick_rotate_tip_closed", false);
        }
    }

    private boolean checkWindowTokenAvailable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1695181327")) {
            return this.mContext != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("1695181327", new Object[]{this})).booleanValue();
    }

    private static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-592822829")) {
            return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("-592822829", new Object[]{context, Float.valueOf(f)})).intValue();
    }

    public static boolean enablePickModeRotate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250766951")) {
            return ((Boolean) ipChange.ipc$dispatch("-1250766951", new Object[0])).booleanValue();
        }
        return "1".equals(ConfigFetcher.getInstance().getConfig("live_config_pick", "enable_pick_mode_rotate", "0"));
    }

    private void initUi(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760597205")) {
            ipChange.ipc$dispatch("760597205", new Object[]{this, context});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dago_pick_rotate_tips, (ViewGroup) null);
        inflate.measure(0, 0);
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(false);
        setTouchable(true);
        setOutsideTouchable(true);
        setOnDismissListener(this);
        inflate.setOnClickListener(this);
        tp1.o().s("https://gw.alicdn.com/imgextra/i4/O1CN01egPTdl1DQgDiVfpuy_!!6000000000211-2-tps-356-252.png").y((ImageView) inflate.findViewById(R.id.iv));
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846486757")) {
            ipChange.ipc$dispatch("-846486757", new Object[]{this});
            return;
        }
        dismiss();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069632632")) {
            ipChange.ipc$dispatch("-1069632632", new Object[]{this, view});
            return;
        }
        close();
    }

    public void onDismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "486247816")) {
            ipChange.ipc$dispatch("486247816", new Object[]{this});
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            context.getSharedPreferences("alix_live_tip", 0).edit().putBoolean("is_pick_rotate_tip_closed", true).apply();
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766267654")) {
            ipChange.ipc$dispatch("-766267654", new Object[]{this});
        } else if (canShow()) {
            this.mHandler.removeCallbacks(this.mCloseRunnable);
            if (checkWindowTokenAvailable()) {
                showAtLocation(this.mParentView, 51, 0, 0);
                this.mHandler.postDelayed(this.mCloseRunnable, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        }
    }
}
