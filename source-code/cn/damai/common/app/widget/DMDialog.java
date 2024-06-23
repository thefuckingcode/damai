package cn.damai.common.app.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ak2;
import tb.s50;

/* compiled from: Taobao */
public class DMDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout a;
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private ScrollView e;
    private FrameLayout f;
    private FrameLayout g;
    private FrameLayout h;
    private View i;
    private TextView j;
    private View k;
    private TextView l;
    private ImageView m;
    private int n;
    private boolean o;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        a(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1186568544")) {
                ipChange.ipc$dispatch("-1186568544", new Object[]{this, view});
                return;
            }
            if (DMDialog.this.o) {
                DMDialog.this.dismiss();
            }
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(DMDialog.this, -2);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        b(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "924721825")) {
                ipChange.ipc$dispatch("924721825", new Object[]{this, view});
                return;
            }
            if (DMDialog.this.o) {
                DMDialog.this.dismiss();
            }
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(DMDialog.this, -1);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1258955102")) {
                ipChange.ipc$dispatch("-1258955102", new Object[]{this, view});
                return;
            }
            DMDialog.this.dismiss();
        }
    }

    public DMDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317218899")) {
            ipChange.ipc$dispatch("-317218899", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.damai_dialog, (ViewGroup) null);
        this.a = (FrameLayout) inflate.findViewById(R$id.damai_root_layout);
        this.b = (TextView) inflate.findViewById(R$id.damai_dialog_title);
        this.d = (LinearLayout) inflate.findViewById(R$id.dialog_content_layout);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.dialog_content_container2);
        this.e = (ScrollView) inflate.findViewById(R$id.dialog_content_container);
        this.c = (TextView) inflate.findViewById(R$id.damai_dialog_tip_content);
        this.f = (FrameLayout) inflate.findViewById(R$id.dialog_expand_content_container);
        this.g = (FrameLayout) inflate.findViewById(R$id.dialog_expand_content_container3);
        this.h = (FrameLayout) inflate.findViewById(R$id.dialog_expand_content_container4);
        this.i = inflate.findViewById(R$id.damai_dialog_btn_top_line);
        this.j = (TextView) inflate.findViewById(R$id.damai_dialog_cancel_btn);
        this.k = inflate.findViewById(R$id.damai_dialog_btn_line);
        this.l = (TextView) inflate.findViewById(R$id.damai_dialog_confirm_btn);
        this.m = (ImageView) inflate.findViewById(R$id.damai_dialog_close_btn);
        inflate.findViewById(R$id.damai_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (((double) DisplayMetrics.getheightPixels(s50.b(getContext()))) * 0.05d)));
        setContentView(inflate);
    }

    public DMDialog A(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348346703")) {
            return (DMDialog) ipChange.ipc$dispatch("1348346703", new Object[]{this, view});
        }
        FrameLayout frameLayout = this.h;
        if (!(frameLayout == null || view == null)) {
            frameLayout.removeAllViews();
            this.h.addView(view);
            this.h.setVisibility(0);
        }
        return this;
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314510855")) {
            ipChange.ipc$dispatch("1314510855", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.o = z;
    }

    public FrameLayout c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1286400242")) {
            return this.a;
        }
        return (FrameLayout) ipChange.ipc$dispatch("-1286400242", new Object[]{this});
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250310946")) {
            ipChange.ipc$dispatch("-250310946", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    public DMDialog e(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032521243")) {
            return (DMDialog) ipChange.ipc$dispatch("-2032521243", new Object[]{this, Integer.valueOf(i2)});
        }
        ((LinearLayout.LayoutParams) this.i.getLayoutParams()).topMargin = i2;
        return this;
    }

    public DMDialog f(int i2, int i3, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257191679")) {
            return (DMDialog) ipChange.ipc$dispatch("1257191679", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), onClickListener});
        }
        return h(i2 == 0 ? "" : ak2.a(getContext(), i2), i3, onClickListener);
    }

    public DMDialog g(int i2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1067972656")) {
            return f(i2, 0, onClickListener);
        }
        return (DMDialog) ipChange.ipc$dispatch("1067972656", new Object[]{this, Integer.valueOf(i2), onClickListener});
    }

    public DMDialog h(CharSequence charSequence, int i2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343000108")) {
            return (DMDialog) ipChange.ipc$dispatch("-343000108", new Object[]{this, charSequence, Integer.valueOf(i2), onClickListener});
        }
        if (this.j != null && !TextUtils.isEmpty(charSequence)) {
            this.j.setText(charSequence);
            if (i2 != 0) {
                this.j.setTextColor(i2);
            }
            this.j.setVisibility(0);
            this.n++;
            TextView textView = this.j;
            if (textView != null) {
                textView.setOnClickListener(new a(onClickListener));
            }
        }
        return this;
    }

    public DMDialog i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986184891")) {
            return (DMDialog) ipChange.ipc$dispatch("1986184891", new Object[]{this, charSequence, onClickListener});
        }
        h(charSequence, 0, onClickListener);
        return this;
    }

    public DMDialog j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137214824")) {
            return (DMDialog) ipChange.ipc$dispatch("-2137214824", new Object[]{this, Boolean.valueOf(z)});
        }
        ImageView imageView = this.m;
        if (imageView == null) {
            return this;
        }
        if (z) {
            imageView.setVisibility(0);
            this.m.setOnClickListener(new c());
        } else {
            imageView.setVisibility(8);
        }
        return this;
    }

    public DMDialog k(int i2, int i3, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727274937")) {
            return (DMDialog) ipChange.ipc$dispatch("-727274937", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), onClickListener});
        }
        return m(i2 == 0 ? "" : ak2.a(getContext(), i2), i3, onClickListener);
    }

    public DMDialog l(int i2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1142504936")) {
            return k(i2, 0, onClickListener);
        }
        return (DMDialog) ipChange.ipc$dispatch("1142504936", new Object[]{this, Integer.valueOf(i2), onClickListener});
    }

    public DMDialog m(CharSequence charSequence, int i2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193472116")) {
            return (DMDialog) ipChange.ipc$dispatch("-193472116", new Object[]{this, charSequence, Integer.valueOf(i2), onClickListener});
        }
        if (this.l != null && !TextUtils.isEmpty(charSequence)) {
            this.l.setText(charSequence);
            if (i2 != 0) {
                this.l.setTextColor(i2);
            }
            this.l.setVisibility(0);
            this.n++;
            this.l.setOnClickListener(new b(onClickListener));
        }
        return this;
    }

    public DMDialog n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888316925")) {
            return (DMDialog) ipChange.ipc$dispatch("-1888316925", new Object[]{this, charSequence, onClickListener});
        }
        m(charSequence, 0, onClickListener);
        return this;
    }

    public DMDialog o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535730335")) {
            return (DMDialog) ipChange.ipc$dispatch("1535730335", new Object[]{this, Boolean.valueOf(z)});
        }
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996548461")) {
            ipChange.ipc$dispatch("996548461", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public DMDialog p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40000461")) {
            return (DMDialog) ipChange.ipc$dispatch("-40000461", new Object[]{this, Integer.valueOf(i2)});
        }
        return q(i2 == 0 ? "" : ak2.a(getContext(), i2));
    }

    public DMDialog q(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063623092")) {
            return (DMDialog) ipChange.ipc$dispatch("-1063623092", new Object[]{this, charSequence});
        }
        if (this.c != null && !TextUtils.isEmpty(charSequence)) {
            this.c.setText(charSequence);
            this.d.setVisibility(0);
        }
        return this;
    }

    public DMDialog r(CharSequence charSequence, int i2, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238290711")) {
            return (DMDialog) ipChange.ipc$dispatch("-238290711", new Object[]{this, charSequence, Integer.valueOf(i2), Float.valueOf(f2)});
        }
        if (this.c != null && !TextUtils.isEmpty(charSequence)) {
            this.c.setText(charSequence);
            this.c.setTextColor(i2);
            this.c.setTextSize(f2);
            this.d.setVisibility(0);
        }
        return this;
    }

    public DMDialog s(String str, int i2, int i3, ClickableSpan clickableSpan) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949515189")) {
            return (DMDialog) ipChange.ipc$dispatch("1949515189", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3), clickableSpan});
        }
        if (!(this.d == null || this.c == null || TextUtils.isEmpty(str))) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(clickableSpan, i2, i3, 18);
            this.c.setHighlightColor(0);
            this.c.setMovementMethod(LinkMovementMethod.getInstance());
            this.c.setText(spannableStringBuilder);
            this.d.setVisibility(0);
        }
        return this;
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1296712187")) {
            ipChange.ipc$dispatch("-1296712187", new Object[]{this});
        } else if (!isShowing()) {
            int i2 = this.n;
            if (i2 == 0) {
                this.k.setVisibility(8);
                this.i.setVisibility(8);
                o(true);
            } else if (i2 == 1) {
                this.k.setVisibility(8);
                this.i.setVisibility(0);
            } else if (i2 == 2) {
                this.k.setVisibility(0);
                this.i.setVisibility(0);
            }
            super.show();
        }
    }

    public DMDialog t(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845874959")) {
            return (DMDialog) ipChange.ipc$dispatch("845874959", new Object[]{this, Integer.valueOf(i2)});
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setGravity(i2);
        }
        return this;
    }

    public DMDialog u(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1621225593")) {
            return (DMDialog) ipChange.ipc$dispatch("-1621225593", new Object[]{this, view});
        }
        ScrollView scrollView = this.e;
        if (!(scrollView == null || view == null)) {
            scrollView.removeAllViews();
            this.e.addView(view);
            this.d.setVisibility(0);
        }
        return this;
    }

    public DMDialog v(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458778253")) {
            return (DMDialog) ipChange.ipc$dispatch("1458778253", new Object[]{this, charSequence});
        }
        if (this.b != null && !TextUtils.isEmpty(charSequence)) {
            this.b.setText(charSequence);
            this.b.setVisibility(0);
        }
        return this;
    }

    public DMDialog w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366120466")) {
            return (DMDialog) ipChange.ipc$dispatch("-366120466", new Object[]{this});
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setSingleLine(false);
        }
        return this;
    }

    public DMDialog x(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832811565")) {
            return (DMDialog) ipChange.ipc$dispatch("1832811565", new Object[]{this, Integer.valueOf(i2)});
        }
        if (this.b != null && i2 > 0) {
            w();
            this.b.setMaxLines(i2);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
        }
        return this;
    }

    public DMDialog y(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245384183")) {
            return (DMDialog) ipChange.ipc$dispatch("1245384183", new Object[]{this, view});
        }
        FrameLayout frameLayout = this.f;
        if (!(frameLayout == null || view == null)) {
            frameLayout.removeAllViews();
            this.f.addView(view);
            this.f.setVisibility(0);
        }
        return this;
    }

    public DMDialog z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067996814")) {
            return (DMDialog) ipChange.ipc$dispatch("1067996814", new Object[]{this, view});
        }
        FrameLayout frameLayout = this.g;
        if (!(frameLayout == null || view == null)) {
            frameLayout.removeAllViews();
            this.g.addView(view);
            this.g.setVisibility(0);
        }
        return this;
    }

    public DMDialog(@NonNull Context context, int i2) {
        super(context, i2);
        this.o = true;
        d();
    }
}
