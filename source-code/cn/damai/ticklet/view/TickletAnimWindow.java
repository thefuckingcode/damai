package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$anim;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.common.utils.SystemBarTintManager;

/* compiled from: Taobao */
public class TickletAnimWindow extends PopupWindow {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private View contentView;
    private Context mContext;
    private View viewParent;

    /* compiled from: Taobao */
    public interface ICustomDialogEventListener {
        void dialogItemEvent(View view);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1327923132")) {
                ipChange.ipc$dispatch("1327923132", new Object[]{this, view});
                return;
            }
            TickletAnimWindow.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ICustomDialogEventListener a;

        b(ICustomDialogEventListener iCustomDialogEventListener) {
            this.a = iCustomDialogEventListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-855753795")) {
                ipChange.ipc$dispatch("-855753795", new Object[]{this, view});
                return;
            }
            ICustomDialogEventListener iCustomDialogEventListener = this.a;
            if (iCustomDialogEventListener != null) {
                iCustomDialogEventListener.dialogItemEvent(view);
            }
            TickletAnimWindow.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1317251881")) {
                ipChange.ipc$dispatch("-1317251881", new Object[]{this, animation});
                return;
            }
            TickletAnimWindow.this.callSuperDismiss();
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "352790333")) {
                ipChange.ipc$dispatch("352790333", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-368505232")) {
                ipChange.ipc$dispatch("-368505232", new Object[]{this, animation});
            }
        }
    }

    public TickletAnimWindow(Context context, View view, View view2, Activity activity2) {
        super(context);
        init(context, view, view2, activity2);
        this.contentView.setOnClickListener(new a());
    }

    private void init(Context context, View view, View view2, Activity activity2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420256148")) {
            ipChange.ipc$dispatch("-420256148", new Object[]{this, context, view, view2, activity2});
            return;
        }
        this.mContext = context;
        this.activity = (DamaiBaseActivity) activity2;
        this.viewParent = view;
        this.contentView = view2;
        setBackgroundDrawable(new ColorDrawable(SystemBarTintManager.DEFAULT_TINT_COLOR));
        setContentView(this.contentView);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setWidth(-1);
        setHeight(-1);
    }

    public void callSuperDismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419654511")) {
            ipChange.ipc$dispatch("-1419654511", new Object[]{this});
            return;
        }
        super.dismiss();
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182235714")) {
            ipChange.ipc$dispatch("1182235714", new Object[]{this});
        } else if (Build.VERSION.SDK_INT == 16) {
            callSuperDismiss();
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R$anim.push_top_out_500);
            loadAnimation.setAnimationListener(new c());
            this.contentView.startAnimation(loadAnimation);
        }
    }

    public void onDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994855689")) {
            ipChange.ipc$dispatch("-1994855689", new Object[]{this});
            return;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.activity != null) {
            this.activity = null;
        }
        if (this.contentView != null) {
            this.contentView = null;
        }
        if (this.viewParent != null) {
            this.viewParent = null;
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034527009")) {
            ipChange.ipc$dispatch("2034527009", new Object[]{this});
        } else if (this.activity.getWindow() != null) {
            showAtLocation(this.viewParent, 80, 0, 0);
            this.contentView.startAnimation(AnimationUtils.loadAnimation(this.mContext, R$anim.push_bottom_out_500));
        }
    }

    public TickletAnimWindow(Context context, View view, View view2, Activity activity2, ICustomDialogEventListener iCustomDialogEventListener) {
        super(context);
        init(context, view, view2, activity2);
        this.contentView.setOnClickListener(new b(iCustomDialogEventListener));
    }
}
