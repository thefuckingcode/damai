package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.uikit.tag.DMCertInfoTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ln2;
import tb.n42;
import tb.ne2;
import tb.s50;
import tb.xs0;

/* compiled from: Taobao */
public class ProjectTitleBarPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private TextView c;
    private TextView d;
    private RelativeLayout e;
    private TextView f;
    private ImageView g;
    private DMCertInfoTagView h;
    private View i;
    private View j;
    private View k;
    private OnUiClickListener l;
    private long m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = true;

    /* compiled from: Taobao */
    public interface OnUiClickListener {
        void onActivityShareClick();

        void onBackClick();

        void onCertInfoClick();

        void onTitleBarClick();
    }

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363889140")) {
                ipChange.ipc$dispatch("1363889140", new Object[]{this, dVar});
                return;
            }
            ProjectTitleBarPanel.this.g.setVisibility(8);
            ProjectTitleBarPanel.this.f.setVisibility(0);
            ln2.r().U1(ProjectTitleBarPanel.this.f, String.valueOf(ProjectTitleBarPanel.this.m));
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-604277111")) {
                ipChange.ipc$dispatch("-604277111", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int a2 = n42.a(xs0.a(), 25.0f);
                int i = intrinsicHeight > 0 ? (int) (((float) (intrinsicWidth * a2)) / ((float) intrinsicHeight)) : 0;
                ViewGroup.LayoutParams layoutParams = ProjectTitleBarPanel.this.g.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = a2;
                    layoutParams.width = i;
                }
                ProjectTitleBarPanel.this.f.setVisibility(8);
                ProjectTitleBarPanel.this.g.setVisibility(0);
                ProjectTitleBarPanel.this.g.setImageDrawable(eVar.a);
                ln2.r().U1(ProjectTitleBarPanel.this.g, String.valueOf(ProjectTitleBarPanel.this.m));
            }
        }
    }

    public ProjectTitleBarPanel(Activity activity, View view, OnUiClickListener onUiClickListener) {
        this.a = activity;
        this.b = view;
        this.l = onUiClickListener;
        this.c = (TextView) view.findViewById(R$id.back_btn);
        this.d = (TextView) this.b.findViewById(R$id.title_tv);
        this.i = this.b.findViewById(R$id.status_bar_space);
        this.j = this.b.findViewById(R$id.divider_line);
        this.k = this.b.findViewById(R$id.title_bar_ui);
        this.e = (RelativeLayout) this.b.findViewById(R$id.share_layout);
        this.f = (TextView) this.b.findViewById(R$id.share_btn);
        this.g = (ImageView) this.b.findViewById(R$id.share_activity);
        this.h = (DMCertInfoTagView) this.b.findViewById(R$id.cert_btn);
        h();
        d(false);
        this.c.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    private void f(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792648665")) {
            ipChange.ipc$dispatch("-792648665", new Object[]{this, str});
            return;
        }
        cn.damai.common.image.a.b().c(str).n(new b()).e(new a()).f();
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312181630")) {
            ipChange.ipc$dispatch("312181630", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (this.i != null) {
                this.i.getLayoutParams().height = ne2.a(this.a);
                this.i.setVisibility(0);
                n42.a(this.a, 44.0f);
            }
            ne2.f(this.a, true, R$color.black);
            ne2.d(true, this.a);
        } else {
            ne2.f(this.a, false, R$color.black);
            View view = this.i;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "92369771")) {
            ipChange.ipc$dispatch("92369771", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.o) {
            this.p = z;
            if (z) {
                ne2.f(this.a, true, -16777216);
                ne2.d(true, this.a);
                return;
            }
            ne2.e(this.a);
        } else if (!this.p) {
            ne2.f(this.a, true, -16777216);
            ne2.d(true, this.a);
        }
    }

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011522302")) {
            ipChange.ipc$dispatch("2011522302", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.b.setBackgroundColor(-1);
            this.c.setTextColor(-16777216);
            this.d.setVisibility(0);
            this.j.setVisibility(0);
            this.f.setTextColor(Color.parseColor("#FE3F79"));
            this.f.setBackgroundResource(R$drawable.bg_border_corner_fee9f0);
            this.h.setWhiteMode(false);
            n(true);
        } else {
            this.b.setBackgroundColor(0);
            this.c.setTextColor(-1);
            this.d.setVisibility(4);
            this.j.setVisibility(4);
            this.f.setTextColor(-1);
            this.f.setBackgroundResource(R$drawable.bg_border_corner_26ffffff);
            this.h.setWhiteMode(true);
            n(false);
        }
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1359548513")) {
            return this.b.getHeight();
        }
        return ((Integer) ipChange.ipc$dispatch("1359548513", new Object[]{this})).intValue();
    }

    public void g(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549342673")) {
            ipChange.ipc$dispatch("549342673", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.o = z;
    }

    public void i(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894875291")) {
            ipChange.ipc$dispatch("1894875291", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null && this.h != null && this.a != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (z) {
                layoutParams.rightMargin = s50.a(this.a, 43.0f);
                this.h.setVisibility(0);
                ln2.r().P1(this.h, String.valueOf(this.m));
            } else {
                layoutParams.rightMargin = s50.a(this.a, 21.0f);
                this.h.setVisibility(8);
            }
            this.e.setLayoutParams(layoutParams);
        }
    }

    public void j(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754758190")) {
            ipChange.ipc$dispatch("-754758190", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.m = j2;
    }

    public void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644584136")) {
            ipChange.ipc$dispatch("-1644584136", new Object[]{this, str});
            return;
        }
        this.d.setText(str);
    }

    public void l(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979794786")) {
            ipChange.ipc$dispatch("-1979794786", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.n = z;
    }

    public void m(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323845769")) {
            ipChange.ipc$dispatch("323845769", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
            this.f.setVisibility(0);
            ln2.r().U1(this.f, String.valueOf(this.m));
        } else {
            this.g.setVisibility(8);
            this.f.setVisibility(8);
            f(str);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550993419")) {
            ipChange.ipc$dispatch("-1550993419", new Object[]{this, view});
        } else if (this.l != null) {
            int id = view.getId();
            if (id == this.c.getId()) {
                this.l.onBackClick();
            }
            if (!this.n) {
                return;
            }
            if (id == this.k.getId()) {
                this.l.onTitleBarClick();
            } else if (id == this.g.getId() || id == this.f.getId()) {
                this.l.onActivityShareClick();
            } else if (id == this.h.getId()) {
                this.l.onCertInfoClick();
            }
        }
    }
}
