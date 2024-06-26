package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.uikit.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class f4 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private final a b;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        public CharSequence a;
        public boolean b;
        public Context c;
        public CharSequence d;
        public int e = 17;
        public CharSequence f;
        public DialogInterface.OnClickListener g;
        public View.OnClickListener h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public boolean k;
        public CharSequence l;
        public DialogInterface.OnKeyListener m;
        public DialogInterface.OnCancelListener n;
        public DialogInterface.OnDismissListener o;

        a(f4 f4Var) {
        }
    }

    public f4(Context context) {
        this(context, 0);
    }

    private void a(DMDialog dMDialog) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891769168")) {
            ipChange.ipc$dispatch("-1891769168", new Object[]{this, dMDialog});
            return;
        }
        dMDialog.v(this.b.a);
        dMDialog.q(this.b.d);
        dMDialog.t(this.b.e);
        if (!TextUtils.isEmpty(this.b.l)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout = new LinearLayout(this.b.c);
            linearLayout.setPadding(0, s50.a(this.b.c, 24.0f), 0, 0);
            linearLayout.setGravity(1);
            linearLayout.setLayoutParams(layoutParams);
            TextView textView = new TextView(this.b.c);
            textView.setText(this.b.l);
            textView.setTextSize(1, 14.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(this.b.c.getResources().getColor(R$color.color_666666));
            linearLayout.addView(textView);
            View.OnClickListener onClickListener = this.b.h;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            dMDialog.y(linearLayout);
        }
        if (!TextUtils.isEmpty(this.b.i)) {
            a aVar = this.b;
            dMDialog.i(aVar.i, aVar.j);
        }
        if (!TextUtils.isEmpty(this.b.f)) {
            a aVar2 = this.b;
            dMDialog.n(aVar2.f, aVar2.g);
        }
    }

    public DMDialog b() {
        DMDialog dMDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635280192")) {
            return (DMDialog) ipChange.ipc$dispatch("-1635280192", new Object[]{this});
        }
        if (this.a != 0) {
            dMDialog = new DMDialog(this.b.c, this.a);
        } else {
            dMDialog = new DMDialog(this.b.c);
        }
        dMDialog.o(this.b.k);
        DialogInterface.OnCancelListener onCancelListener = this.b.n;
        if (onCancelListener != null) {
            dMDialog.setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = this.b.o;
        if (onDismissListener != null) {
            dMDialog.setOnDismissListener(onDismissListener);
        }
        DialogInterface.OnKeyListener onKeyListener = this.b.m;
        if (onKeyListener != null) {
            dMDialog.setOnKeyListener(onKeyListener);
        }
        return dMDialog;
    }

    public f4 c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039495808")) {
            return (f4) ipChange.ipc$dispatch("2039495808", new Object[]{this, Boolean.valueOf(z)});
        }
        this.b.b = z;
        return this;
    }

    public f4 d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138944530")) {
            return (f4) ipChange.ipc$dispatch("-1138944530", new Object[]{this, Boolean.valueOf(z)});
        }
        this.b.k = z;
        return this;
    }

    public f4 e(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043384307")) {
            return (f4) ipChange.ipc$dispatch("-1043384307", new Object[]{this, charSequence});
        }
        this.b.d = charSequence;
        return this;
    }

    public f4 f(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365058230")) {
            return (f4) ipChange.ipc$dispatch("365058230", new Object[]{this, charSequence, onClickListener});
        }
        a aVar = this.b;
        aVar.i = charSequence;
        aVar.j = onClickListener;
        return this;
    }

    public f4 g(CharSequence charSequence, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367033778")) {
            return (f4) ipChange.ipc$dispatch("1367033778", new Object[]{this, charSequence, onClickListener});
        }
        a aVar = this.b;
        aVar.l = charSequence;
        aVar.h = onClickListener;
        return this;
    }

    public f4 h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793356922")) {
            return (f4) ipChange.ipc$dispatch("793356922", new Object[]{this, charSequence, onClickListener});
        }
        a aVar = this.b;
        aVar.f = charSequence;
        aVar.g = onClickListener;
        return this;
    }

    public f4 i(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827091684")) {
            return (f4) ipChange.ipc$dispatch("-1827091684", new Object[]{this, charSequence});
        }
        this.b.a = charSequence;
        return this;
    }

    public DMDialog j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811805089")) {
            return (DMDialog) ipChange.ipc$dispatch("-1811805089", new Object[]{this});
        }
        DMDialog b2 = b();
        try {
            a(b2);
            b2.show();
        } catch (Throwable th) {
            Log.w("StackTrace", th);
        }
        return b2;
    }

    public f4(Context context, int i) {
        this.a = i;
        a aVar = new a(this);
        this.b = aVar;
        aVar.c = context;
    }
}
