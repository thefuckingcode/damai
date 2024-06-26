package cn.damai.commonbusiness.photoselect.imageselected.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PhotoCustomDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogClickListener a;

    /* compiled from: Taobao */
    public interface OnDialogClickListener {
        void onCancle();

        void onDelete();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986922025")) {
                ipChange.ipc$dispatch("-986922025", new Object[]{this, view});
                return;
            }
            PhotoCustomDialog.this.a.onDelete();
            PhotoCustomDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1124368344")) {
                ipChange.ipc$dispatch("1124368344", new Object[]{this, view});
                return;
            }
            PhotoCustomDialog.this.a.onCancle();
            PhotoCustomDialog.this.dismiss();
        }
    }

    public PhotoCustomDialog(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1817920996")) {
            ipChange.ipc$dispatch("1817920996", new Object[]{this, context});
            return;
        }
        Activity activity = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.custom_dialog_layout, (ViewGroup) null);
        setContentView(inflate);
        c(inflate);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213266672")) {
            ipChange.ipc$dispatch("-213266672", new Object[]{this, view});
            return;
        }
        view.findViewById(R$id.tv_delete).setOnClickListener(new a());
        view.findViewById(R$id.tv_cancle).setOnClickListener(new b());
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346132784")) {
            ipChange.ipc$dispatch("346132784", new Object[]{this});
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.windowAnimations = R$style.dialog_animation;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382484650")) {
            ipChange.ipc$dispatch("-382484650", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        d();
    }
}
