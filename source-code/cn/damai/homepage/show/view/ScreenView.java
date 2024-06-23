package cn.damai.homepage.show.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScreenView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private TextView g;
    private DMIconFontTextView h;
    private OnScreenClickListener i;
    private boolean j = false;

    /* compiled from: Taobao */
    public interface OnScreenClickListener {
        void onScreenClick(int i);

        void onTimeClick(boolean z);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1519382146")) {
                ipChange.ipc$dispatch("1519382146", new Object[]{this, view});
                return;
            }
            ScreenView.this.d(3);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-664294781")) {
                ipChange.ipc$dispatch("-664294781", new Object[]{this, view});
                return;
            }
            ScreenView.this.d(4);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1446995588")) {
                ipChange.ipc$dispatch("1446995588", new Object[]{this, view});
                return;
            }
            ScreenView.this.d(1);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-736681339")) {
                ipChange.ipc$dispatch("-736681339", new Object[]{this, view});
                return;
            }
            if (ScreenView.this.j) {
                ScreenView.this.f(false);
            } else {
                ScreenView.this.f(true);
            }
            if (ScreenView.this.i != null) {
                ScreenView.this.i.onTimeClick(ScreenView.this.j);
            }
        }
    }

    public ScreenView(View view, OnScreenClickListener onScreenClickListener) {
        this.a = view.getContext();
        this.b = view;
        this.i = onScreenClickListener;
        this.c = (TextView) view.findViewById(R$id.tv_order1);
        this.d = (TextView) view.findViewById(R$id.tv_order2);
        this.e = (TextView) view.findViewById(R$id.tv_order3);
        this.c.setOnClickListener(new a());
        this.d.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
        this.c.setTextColor(this.a.getResources().getColor(R$color.color_FF2869));
        TextView textView = this.d;
        Resources resources = this.a.getResources();
        int i2 = R$color.color_9c9ca5;
        textView.setTextColor(resources.getColor(i2));
        this.e.setTextColor(this.a.getResources().getColor(i2));
        this.f = view.findViewById(R$id.layout_time);
        this.g = (TextView) view.findViewById(R$id.tv_time);
        this.h = (DMIconFontTextView) view.findViewById(R$id.icon_time);
        f(false);
        this.f.setOnClickListener(new d());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816639334")) {
            ipChange.ipc$dispatch("-816639334", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        g(i2);
        OnScreenClickListener onScreenClickListener = this.i;
        if (onScreenClickListener != null) {
            onScreenClickListener.onScreenClick(i2);
        }
    }

    public void e(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1850860958")) {
            ipChange.ipc$dispatch("-1850860958", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        if (z) {
            TextView textView = this.g;
            Resources resources = this.a.getResources();
            int i2 = R$color.color_000000;
            textView.setTextColor(resources.getColor(i2));
            this.h.setTextColor(this.a.getResources().getColor(i2));
        } else {
            TextView textView2 = this.g;
            Resources resources2 = this.a.getResources();
            int i3 = R$color.color_9c9ca5;
            textView2.setTextColor(resources2.getColor(i3));
            this.h.setTextColor(this.a.getResources().getColor(i3));
        }
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(str);
        }
        f(false);
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47828476")) {
            ipChange.ipc$dispatch("47828476", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.j = z;
        if (z) {
            this.h.setText(this.a.getString(R$string.iconfont_shaixuanshang12));
        } else {
            this.h.setText(this.a.getString(R$string.iconfont_shaixuanxia12));
        }
    }

    public void g(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794992037")) {
            ipChange.ipc$dispatch("-794992037", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            TextView textView = this.c;
            Resources resources = this.a.getResources();
            int i3 = R$color.color_9c9ca5;
            textView.setTextColor(resources.getColor(i3));
            this.d.setTextColor(this.a.getResources().getColor(i3));
            this.e.setTextColor(this.a.getResources().getColor(R$color.color_FF2869));
        } else if (i2 == 3) {
            this.c.setTextColor(this.a.getResources().getColor(R$color.color_FF2869));
            TextView textView2 = this.d;
            Resources resources2 = this.a.getResources();
            int i4 = R$color.color_9c9ca5;
            textView2.setTextColor(resources2.getColor(i4));
            this.e.setTextColor(this.a.getResources().getColor(i4));
        } else if (i2 == 4) {
            TextView textView3 = this.c;
            Resources resources3 = this.a.getResources();
            int i5 = R$color.color_9c9ca5;
            textView3.setTextColor(resources3.getColor(i5));
            this.d.setTextColor(this.a.getResources().getColor(R$color.color_FF2869));
            this.e.setTextColor(this.a.getResources().getColor(i5));
        }
    }
}
