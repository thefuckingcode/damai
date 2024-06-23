package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ae1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private View c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private DMIconFontTextView j;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "647963276")) {
                ipChange.ipc$dispatch("647963276", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str)) {
                cn.damai.common.user.c.e().x(yd1.x().g0("myordersfirst"));
                ae1.this.e(str);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535713651")) {
                ipChange.ipc$dispatch("-1535713651", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (tag != null) {
                ae1.this.c((String) tag);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(ae1 ae1) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220223168")) {
                ipChange.ipc$dispatch("220223168", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-908576683")) {
                ipChange.ipc$dispatch("-908576683", new Object[]{this, eVar});
            } else if (eVar != null && eVar.a != null) {
                ae1.this.d.setImageDrawable(eVar.a);
            }
        }
    }

    public ae1(Activity activity, View view) {
        this.a = activity;
        this.b = (View) view.getParent();
        g();
        i();
        h();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895059385")) {
            ipChange.ipc$dispatch("-895059385", new Object[]{this, str});
            return;
        }
        this.h.setVisibility(8);
        d20.T("closed_announcement", "true");
        d20.T("closed_notice_str", str);
        cn.damai.common.user.c.e().x(yd1.x().h0());
    }

    private UserCenterDataBean.TransitStepInfo d(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522756557")) {
            return (UserCenterDataBean.TransitStepInfo) ipChange.ipc$dispatch("-1522756557", new Object[]{this, logisticsInfo});
        } else if (logisticsInfo == null || logisticsInfo.getTransitStepInfos().isEmpty()) {
            return null;
        } else {
            return logisticsInfo.getTransitStepInfos().get(0);
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761087060")) {
            ipChange.ipc$dispatch("761087060", new Object[]{this});
            return;
        }
        View findViewById = this.b.findViewById(R$id.ll_mine_order_logistics);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.d = (ImageView) this.c.findViewById(R$id.iv_mine_logistics_image);
        this.e = (TextView) this.c.findViewById(R$id.tv_mine_logistics_status);
        this.f = (TextView) this.c.findViewById(R$id.tv_mine_logistics_action);
        this.g = (TextView) this.c.findViewById(R$id.tv_mine_logistics_status_time);
        this.c.setOnClickListener(new a());
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457053409")) {
            ipChange.ipc$dispatch("457053409", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R$id.rv_mine_announcement);
        this.h = linearLayout;
        linearLayout.setVisibility(8);
        this.i = (TextView) this.b.findViewById(R$id.tv_mine_announcement_content);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.b.findViewById(R$id.tv_mine_announcement_close);
        this.j = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new b());
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453489607")) {
            ipChange.ipc$dispatch("-1453489607", new Object[]{this});
        }
    }

    private void j(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734295118")) {
            ipChange.ipc$dispatch("1734295118", new Object[]{this, logisticsInfo});
        } else if (logisticsInfo != null && this.a != null) {
            DMImageCreator e2 = cn.damai.common.image.a.b().e(logisticsInfo.getPerformImageUrl());
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            e2.i(i2).c(i2).k(new DMRoundedCornersBitmapProcessor(n42.a(this.a, 6.0f), 0)).n(new d()).e(new c(this)).f();
        }
    }

    private void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124765722")) {
            ipChange.ipc$dispatch("-124765722", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.h.setVisibility(0);
            this.j.setTag(str);
            this.i.setText(str);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void e(String str) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033853221")) {
            ipChange.ipc$dispatch("-1033853221", new Object[]{this, str});
        } else if (!LoginManager.k().q()) {
            zd1.c(this.a);
        } else if (!TextUtils.isEmpty(str) && (activity = this.a) != null) {
            DMNav.from(activity).toUri(str);
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540752425")) {
            ipChange.ipc$dispatch("-1540752425", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setTag(null);
            this.c.setVisibility(8);
        }
    }

    public void l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338880166")) {
            ipChange.ipc$dispatch("-338880166", new Object[]{this, str});
            return;
        }
        String B = d20.B("closed_announcement");
        String B2 = d20.B("closed_notice_str");
        if (!"true".equals(B)) {
            k(str);
        } else if (TextUtils.isEmpty(str) || B2.equals(str)) {
            this.h.setVisibility(8);
        } else {
            d20.T("closed_announcement", "false");
            this.h.setVisibility(0);
            this.j.setTag(str);
            this.i.setText(str);
        }
    }

    public void m(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557991562")) {
            ipChange.ipc$dispatch("-1557991562", new Object[]{this, logisticsInfo});
        } else if (logisticsInfo == null) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setTag(logisticsInfo.getOrderDetailUrl());
            String waybillId = logisticsInfo.getWaybillId();
            String waybillName = logisticsInfo.getWaybillName();
            String status = logisticsInfo.getStatus();
            j(logisticsInfo);
            UserCenterDataBean.TransitStepInfo d2 = d(logisticsInfo);
            String str3 = "";
            if (d2 != null) {
                str2 = d2.getStatusTime();
                str = d2.getStatusDesc();
            } else {
                str = str3;
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(waybillName)) {
                    waybillName = str3;
                }
                sb.append(waybillName);
                sb.append(" ");
                if (TextUtils.isEmpty(waybillId)) {
                    waybillId = str3;
                }
                sb.append(waybillId);
                str = sb.toString();
            }
            TextView textView = this.e;
            if (TextUtils.isEmpty(status)) {
                status = str3;
            }
            textView.setText(status);
            TextView textView2 = this.f;
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            textView2.setText(str);
            TextView textView3 = this.g;
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            textView3.setText(str3);
        }
    }
}
