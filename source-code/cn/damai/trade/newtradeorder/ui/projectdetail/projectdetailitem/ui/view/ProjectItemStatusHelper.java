package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ln2;

/* compiled from: Taobao */
public class ProjectItemStatusHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BUY_TYPE_BUY_RIGHT_NOW = 300;
    public static final int BUY_TYPE_CHOOSE_SEAT = 200;
    public static final int BUY_TYPE_SCHEDULE_RIGHT_NOW = 500;
    public static final int ON_SALE_REGISTER = 600;
    public static final int OUT_OF_STORE_REGISTER = 601;
    private View a;
    private TextView b;
    private TextView c;
    private ProjectItemDataBean d;
    private String e;
    private boolean f;
    private OnBottomViewClickListener g;
    private OnBuyBtnUTListener h;
    private OnProjectNotExistsListener i;
    private boolean j = false;
    private boolean k = true;

    /* compiled from: Taobao */
    public interface OnBottomViewClickListener {
        void onBuyRightNow(int i);

        void onNeedPrivilege(int i);

        void onRegister(int i);

        void onSelectSeat();

        void onSoldOut();

        void onTimingCountDown();
    }

    /* compiled from: Taobao */
    public interface OnBuyBtnUTListener {
        void onReportBuyRightNow(boolean z, int i);

        void onReportFollowRemind();

        void onReportPrivilege(int i);

        void onReportRegisterRemind(int i);

        void onReportSelectSeat();
    }

    /* compiled from: Taobao */
    public interface OnProjectNotExistsListener {
        void onProjectNotExists();
    }

    /* compiled from: Taobao */
    public static class a implements OnBuyBtnUTListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private long a;

        private a(long j) {
            this.a = j;
        }

        public static OnBuyBtnUTListener a(long j) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1772466206")) {
                return new a(j);
            }
            return (OnBuyBtnUTListener) ipChange.ipc$dispatch("1772466206", new Object[]{Long.valueOf(j)});
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportBuyRightNow(boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591450016")) {
                ipChange.ipc$dispatch("-1591450016", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            } else if (i != 300) {
            } else {
                if (z) {
                    cn.damai.common.user.c.e().x(ln2.r().H0(this.a));
                } else {
                    cn.damai.common.user.c.e().x(ln2.r().g0(this.a));
                }
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportFollowRemind() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1815086365")) {
                ipChange.ipc$dispatch("-1815086365", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().J0(this.a));
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportPrivilege(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1385587549")) {
                ipChange.ipc$dispatch("-1385587549", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 300) {
                cn.damai.common.user.c.e().x(ln2.r().E0(this.a));
            } else if (i == 200) {
                cn.damai.common.user.c.e().x(ln2.r().G0(this.a));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportRegisterRemind(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1765023246")) {
                ipChange.ipc$dispatch("-1765023246", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 600) {
                cn.damai.common.user.c.e().x(ln2.r().w0(String.valueOf(this.a), "bottom", "onsale_checkin"));
            } else if (i == 601) {
                cn.damai.common.user.c.e().x(ln2.r().w0(String.valueOf(this.a), "bottom", "stock_checkin"));
            } else if (i == 500) {
                cn.damai.common.user.c.e().x(ln2.r().w0(String.valueOf(this.a), "bottom", "rightawayreserve"));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportSelectSeat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535540488")) {
                ipChange.ipc$dispatch("-1535540488", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().h(this.a));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public b(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1444917046")) {
                ipChange.ipc$dispatch("-1444917046", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportBuyRightNow(ProjectItemStatusHelper.this.k(), this.a);
                }
                ProjectItemStatusHelper.this.g.onBuyRightNow(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public c(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-995278910")) {
                ipChange.ipc$dispatch("-995278910", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportPrivilege(this.a);
                }
                ProjectItemStatusHelper.this.g.onNeedPrivilege(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public d(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677752043")) {
                ipChange.ipc$dispatch("-1677752043", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportRegisterRemind(this.a);
                }
                ProjectItemStatusHelper.this.g.onRegister(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1470717943")) {
                ipChange.ipc$dispatch("1470717943", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportSelectSeat();
                }
                ProjectItemStatusHelper.this.g.onSelectSeat();
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-282979179")) {
                ipChange.ipc$dispatch("-282979179", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                ProjectItemStatusHelper.this.g.onSoldOut();
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a;

        public g(boolean z) {
            this.a = z;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "251246059")) {
                ipChange.ipc$dispatch("251246059", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (this.a && ProjectItemStatusHelper.this.h != null) {
                    ProjectItemStatusHelper.this.h.onReportFollowRemind();
                }
                ProjectItemStatusHelper.this.g.onTimingCountDown();
            }
        }
    }

    public ProjectItemStatusHelper(Context context, ProjectItemDataBean projectItemDataBean, long j2, ViewGroup viewGroup) {
        this.d = projectItemDataBean;
        this.e = String.valueOf(j2);
        i(context, viewGroup);
        m();
    }

    private void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996102355")) {
            ipChange.ipc$dispatch("996102355", new Object[]{this, str});
            return;
        }
        q(str, false);
        String buyBtnTip = this.d.getBuyBtnTip();
        if (!TextUtils.isEmpty(buyBtnTip)) {
            this.c.setVisibility(0);
            this.c.setText(buyBtnTip);
            return;
        }
        this.c.setVisibility(8);
    }

    private void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972521202")) {
            ipChange.ipc$dispatch("1972521202", new Object[]{this, str});
            return;
        }
        q(str, true);
        String buyBtnTip = this.d.getBuyBtnTip();
        if (!TextUtils.isEmpty(buyBtnTip)) {
            this.c.setVisibility(0);
            this.c.setText(buyBtnTip);
            return;
        }
        this.c.setVisibility(8);
    }

    private int f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192669210")) {
            return ((Integer) ipChange.ipc$dispatch("1192669210", new Object[]{this, Boolean.valueOf(z)})).intValue();
        } else if (z) {
            return R$drawable.project_buy_btn_usable_bg_selector;
        } else {
            return R$drawable.project_buy_btn_unusable_bg;
        }
    }

    private String g(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-343410802")) {
            return TextUtils.isEmpty(str) ? str2 : str;
        }
        return (String) ipChange.ipc$dispatch("-343410802", new Object[]{this, str, str2});
    }

    private View i(Context context, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370156452")) {
            return (View) ipChange.ipc$dispatch("370156452", new Object[]{this, context, viewGroup});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.project_item_buy_btn_status_view, viewGroup, false);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R$id.tv_left_main_text);
        this.c = (TextView) this.a.findViewById(R$id.tv_left_sub_text);
        this.a.setVisibility(8);
        return this.a;
    }

    private void m() {
        String str;
        String str2;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636362060")) {
            ipChange.ipc$dispatch("1636362060", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.d;
        if (projectItemDataBean != null) {
            i2 = projectItemDataBean.getBuyBtnStatus();
            str2 = this.d.getBuyBtnText();
            str = this.d.getBuyBtnTip();
        } else {
            str2 = "";
            str = str2;
            i2 = 99;
        }
        this.a.setOnClickListener(null);
        if (i2 == 87) {
            d(g(str2, "选座购买"));
        } else if (i2 == 88) {
            d(g(str2, "立即购买"));
            ln2.r().k2(this.b, this.e);
        } else if (i2 == 99) {
            p(str2, "暂不可售", str, false, null);
        } else if (i2 == 100) {
            p(str2, "该渠道不支持购买", str, false, null);
        } else if (i2 == 106) {
            p(str2, "即将开售", str, true, new g(false));
        } else if (i2 == 204) {
            this.a.setOnClickListener(new b(300));
            q(g(str2, "立即购买"), true);
            ln2.r().D1(this.b, this.e);
        } else if (i2 == 206) {
            this.a.setOnClickListener(new e());
            q(g(str2, "选座购买"), true);
            ln2.r().d2(this.b, this.e);
        } else if (i2 == 401) {
            this.k = false;
            n();
        } else if (i2 == 216) {
            this.j = true;
            this.a.setOnClickListener(new b(300));
            e(g(str2, "立即购买"));
        } else if (i2 == 217) {
            this.j = true;
            this.a.setOnClickListener(new e());
            e(g(str2, "选座购买"));
        } else if (i2 == 223) {
            d(g(str2, "立即购买"));
        } else if (i2 == 224) {
            d(g(str2, "选座购买"));
        } else if (i2 == 230) {
            this.a.setOnClickListener(new c(300));
            e(g(str2, "立即购买"));
        } else if (i2 == 231) {
            this.a.setOnClickListener(new c(200));
            e(g(str2, "选座购买"));
        } else if (i2 == 303) {
            p(str2, "已下架", str, false, null);
        } else if (i2 != 304) {
            switch (i2) {
                case 90:
                    p(str2, "开售登记", str, true, new d(600));
                    ln2.r().H1(this.b, this.e);
                    return;
                case 91:
                    p(str2, "缺货登记", str, true, new d(601));
                    ln2.r().h2(this.b, this.e);
                    return;
                case 92:
                    p(str2, "售罄", str, false, new f());
                    return;
                default:
                    p(str2, "暂不可售", str, false, null);
                    return;
            }
        } else {
            p(str2, "已取消", str, false, null);
        }
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662873207")) {
            ipChange.ipc$dispatch("-1662873207", new Object[]{this});
            return;
        }
        OnProjectNotExistsListener onProjectNotExistsListener = this.i;
        if (onProjectNotExistsListener != null) {
            onProjectNotExistsListener.onProjectNotExists();
        }
    }

    private void p(String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "192090434")) {
            ipChange.ipc$dispatch("192090434", new Object[]{this, str, str2, str3, Boolean.valueOf(z), onClickListener});
            return;
        }
        this.a.setVisibility(0);
        this.a.setBackgroundResource(f(z));
        this.a.setOnClickListener(onClickListener);
        View view = this.a;
        if (onClickListener == null) {
            z2 = false;
        }
        view.setClickable(z2);
        this.b.setText(g(str, str2));
        if (!TextUtils.isEmpty(str3)) {
            this.c.setText(str3);
            this.c.setVisibility(0);
            return;
        }
        this.c.setText("");
        this.c.setVisibility(8);
    }

    private void q(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358674885")) {
            ipChange.ipc$dispatch("1358674885", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        this.b.setText(str);
        this.c.setVisibility(8);
        this.a.setVisibility(0);
        this.a.setBackgroundResource(f(z));
        this.a.setClickable(z);
    }

    public View h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1429941925")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("-1429941925", new Object[]{this});
    }

    public boolean j(ProjectItemDataBean projectItemDataBean) {
        int buyBtnStatus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343219194")) {
            return ((Boolean) ipChange.ipc$dispatch("-1343219194", new Object[]{this, projectItemDataBean})).booleanValue();
        }
        return (projectItemDataBean == null || (buyBtnStatus = projectItemDataBean.getBuyBtnStatus()) == 90 || buyBtnStatus == 91 || buyBtnStatus == 106 || buyBtnStatus == 204 || buyBtnStatus == 206 || buyBtnStatus == 216 || buyBtnStatus == 217 || buyBtnStatus == 230 || buyBtnStatus == 231) ? false : true;
    }

    public boolean k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "241895126")) {
            return this.j;
        }
        return ((Boolean) ipChange.ipc$dispatch("241895126", new Object[]{this})).booleanValue();
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2072398518")) {
            return this.k;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2072398518", new Object[]{this})).booleanValue();
    }

    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601618948")) {
            ipChange.ipc$dispatch("1601618948", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.f = z;
    }

    public void r(OnBottomViewClickListener onBottomViewClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613304666")) {
            ipChange.ipc$dispatch("1613304666", new Object[]{this, onBottomViewClickListener});
            return;
        }
        this.g = onBottomViewClickListener;
    }

    public void s(OnBuyBtnUTListener onBuyBtnUTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062279558")) {
            ipChange.ipc$dispatch("1062279558", new Object[]{this, onBuyBtnUTListener});
            return;
        }
        this.h = onBuyBtnUTListener;
    }

    public void t(OnProjectNotExistsListener onProjectNotExistsListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1438324228")) {
            ipChange.ipc$dispatch("1438324228", new Object[]{this, onProjectNotExistsListener});
            return;
        }
        this.i = onProjectNotExistsListener;
    }

    public void u(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783861310")) {
            ipChange.ipc$dispatch("783861310", new Object[]{this, projectItemDataBean});
            return;
        }
        this.j = false;
        this.k = true;
        this.d = projectItemDataBean;
        m();
    }
}
