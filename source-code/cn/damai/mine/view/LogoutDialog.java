package cn.damai.mine.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LogoutDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogClickListener a;
    private TextView b;
    private TextView c;

    /* compiled from: Taobao */
    public interface OnDialogClickListener {
        void onDismiss();

        void onFirstSel();

        void onSecondSel();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "794517526")) {
                ipChange.ipc$dispatch("794517526", new Object[]{this, view});
                return;
            }
            LogoutDialog.this.a.onDismiss();
            LogoutDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389159401")) {
                ipChange.ipc$dispatch("-1389159401", new Object[]{this, view});
                return;
            }
            LogoutDialog.this.a.onFirstSel();
            LogoutDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "722130968")) {
                ipChange.ipc$dispatch("722130968", new Object[]{this, view});
                return;
            }
            LogoutDialog.this.a.onSecondSel();
            LogoutDialog.this.dismiss();
        }
    }

    public LogoutDialog(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831555323")) {
            ipChange.ipc$dispatch("-831555323", new Object[]{this, context});
            return;
        }
        Activity activity = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_logout_dialog, (ViewGroup) null);
        setContentView(inflate);
        this.b = (TextView) findViewById(R$id.tv_first);
        this.c = (TextView) findViewById(R$id.tv_second);
        c(inflate);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555597297")) {
            ipChange.ipc$dispatch("555597297", new Object[]{this, view});
            return;
        }
        view.findViewById(R$id.tv_cancel).setOnClickListener(new a());
        this.b.setOnClickListener(new b());
        this.c.setOnClickListener(new c());
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033622511")) {
            ipChange.ipc$dispatch("-2033622511", new Object[]{this});
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.windowAnimations = R$style.dialog_animation;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    public void e(OnDialogClickListener onDialogClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-912908784")) {
            ipChange.ipc$dispatch("-912908784", new Object[]{this, onDialogClickListener});
            return;
        }
        this.a = onDialogClickListener;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783359799")) {
            ipChange.ipc$dispatch("783359799", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        d();
    }

    public LogoutDialog(Context context, int i) {
        super(context, i);
        b(context);
    }
}
