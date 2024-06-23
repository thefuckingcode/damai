package cn.damai.common.askpermission;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PermissionPop extends PopupWindow {

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-213003571")) {
                ipChange.ipc$dispatch("-213003571", new Object[]{this, view});
                return;
            }
            PermissionPop.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1898286798")) {
                ipChange.ipc$dispatch("1898286798", new Object[]{this, view});
                return;
            }
            PermissionPop.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnKeyListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(PermissionPop permissionPop) {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1450118979")) {
                return i == 4;
            }
            return ((Boolean) ipChange.ipc$dispatch("1450118979", new Object[]{this, view, Integer.valueOf(i), keyEvent})).booleanValue();
        }
    }

    public PermissionPop(Context context, CharSequence charSequence, boolean z, View.OnClickListener onClickListener) {
        super(context);
        setWidth(-1);
        setHeight(-1);
        View inflate = LayoutInflater.from(context).inflate(R$layout.pop, (ViewGroup) null);
        setContentView(inflate);
        ((TextView) inflate.findViewById(R$id.pop_tv)).setText(charSequence);
        View findViewById = inflate.findViewById(R$id.close);
        View findViewById2 = inflate.findViewById(R$id.confirm);
        findViewById.setVisibility(z ? 0 : 8);
        findViewById.setOnClickListener(new a());
        findViewById2.setOnClickListener(new b(onClickListener));
        inflate.setOnKeyListener(new c(this));
        setBackgroundDrawable(new ColorDrawable(1426063360));
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(-1);
    }
}
