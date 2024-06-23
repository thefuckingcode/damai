package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.bean.LoginBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.request.LoginCheckRequest;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DashedLine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.util.ErrorConstant;
import tb.el2;
import tb.hp1;
import tb.hu1;
import tb.ln2;
import tb.lp1;
import tb.n42;
import tb.qt1;

/* compiled from: Taobao */
public class TicketGuidePreLineViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView a;
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private DMIconFontTextView e;
    private TextView f;
    private DashedLine g;
    private DashedLine h;
    private Activity i;
    private int j;
    private int k;
    private int l;
    private int m;
    private CalendarsResolver.RemindMeListener n = new d();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(TicketGuidePreLineViewHolder ticketGuidePreLineViewHolder, String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746161327")) {
                ipChange.ipc$dispatch("-1746161327", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().C2(this.a));
            UpdateUtil.d();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365129042")) {
                ipChange.ipc$dispatch("365129042", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().A2(this.a));
            LoginManager.k().w(TicketGuidePreLineViewHolder.this.i, new Intent());
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectTickGuidePreBean a;

        c(ProjectTickGuidePreBean projectTickGuidePreBean) {
            this.a = projectTickGuidePreBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "292742484")) {
                ipChange.ipc$dispatch("292742484", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().B2(this.a.projectId));
            Activity activity = TicketGuidePreLineViewHolder.this.i;
            ProjectTickGuidePreBean projectTickGuidePreBean = this.a;
            qt1.e(activity, projectTickGuidePreBean.calendarRemindTitle, projectTickGuidePreBean.sellStartTime, TicketGuidePreLineViewHolder.this.n);
        }
    }

    /* compiled from: Taobao */
    public class d implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1631918273")) {
                ipChange.ipc$dispatch("-1631918273", new Object[]{this});
                return;
            }
            TicketGuidePreLineViewHolder.this.f.setText("取消设置");
            qt1.f(TicketGuidePreLineViewHolder.this.i, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1655647771")) {
                ipChange.ipc$dispatch("1655647771", new Object[]{this});
                return;
            }
            TicketGuidePreLineViewHolder.this.f.setText("设置");
            ToastUtil.i("取消提醒成功");
        }
    }

    public TicketGuidePreLineViewHolder(Activity activity) {
        super(LayoutInflater.from(activity).inflate(R$layout.layout_ticket_guide_pre_line, (ViewGroup) null, false));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.i = activity;
        this.a = (DMIconFontTextView) this.itemView.findViewById(R$id.icon_guide);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_guide_name);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_guide_desc);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.ll_button);
        this.e = (DMIconFontTextView) this.itemView.findViewById(R$id.icon_button_text);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_button_text);
        DashedLine dashedLine = (DashedLine) this.itemView.findViewById(R$id.dash_vertical_view);
        this.g = dashedLine;
        dashedLine.setVisibility(0);
        this.h = (DashedLine) this.itemView.findViewById(R$id.top_dash_line);
        this.j = n42.a(activity, 21.0f);
        e();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438578492")) {
            ipChange.ipc$dispatch("-1438578492", new Object[]{this});
            return;
        }
        this.k = ContextCompat.getColor(this.i, R$color.color_00BD67);
        this.l = ContextCompat.getColor(this.i, R$color.color_666666);
        this.m = ContextCompat.getColor(this.i, R$color.color_cccccc);
    }

    private void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135403880")) {
            ipChange.ipc$dispatch("1135403880", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 % 2 == 1) {
            this.g.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.leftMargin = this.j;
            layoutParams.rightMargin = 0;
            this.h.setLayoutParams(layoutParams);
        } else {
            this.g.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = this.j;
            this.h.setLayoutParams(layoutParams2);
        }
    }

    private void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613422913")) {
            ipChange.ipc$dispatch("613422913", new Object[]{this, str});
            return;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundResource(R$drawable.bg_ticket_guide_btn);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#ffffff"));
        this.f.setText(str);
    }

    private void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239860530")) {
            ipChange.ipc$dispatch("-1239860530", new Object[]{this, str});
            return;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundColor(Color.parseColor("#ffffff"));
        this.d.setOnClickListener(null);
        this.f.setTextColor(this.k);
        this.e.setTextColor(this.k);
        this.e.setText(this.i.getString(R$string.iconfont_duihaomian_));
        this.e.setVisibility(0);
        this.f.setText(str);
    }

    private void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83017188")) {
            ipChange.ipc$dispatch("83017188", new Object[]{this, str});
            return;
        }
        String a2 = hu1.a();
        if (a2 == null) {
            h("最新版");
        } else if ("true".equals(a2)) {
            g("升级");
            this.d.setOnClickListener(new a(this, str));
        } else {
            h("最新版");
        }
    }

    private void j(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506751949")) {
            ipChange.ipc$dispatch("-1506751949", new Object[]{this, str});
        } else if (!LoginManager.k().q()) {
            g("登录");
            this.d.setOnClickListener(new b(str));
        } else {
            g("去检查");
            this.d.setOnClickListener(new View.OnClickListener(this) {
                /* class cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1818547885")) {
                        ipChange.ipc$dispatch("-1818547885", new Object[]{this, view});
                        return;
                    }
                    cn.damai.common.user.c.e().x(ln2.r().A2(str));
                    new LoginCheckRequest().request(new DMMtopRequestListener<LoginBean>(LoginBean.class) {
                        /* class cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder.AnonymousClass3.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(String str, String str2) {
                            IpChange ipChange = $ipChange;
                            boolean z = true;
                            if (AndroidInstantRuntime.support(ipChange, "-422905850")) {
                                ipChange.ipc$dispatch("-422905850", new Object[]{this, str, str2});
                                return;
                            }
                            boolean isSessionInvalid = ErrorConstant.isSessionInvalid(str);
                            if (TextUtils.isEmpty(str) || !ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL.equals(str)) {
                                z = isSessionInvalid;
                            }
                            if (!z && !TextUtils.isEmpty(str2)) {
                                ToastUtil.i(str2);
                            }
                        }

                        public void onSuccess(LoginBean loginBean) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1155589740")) {
                                ipChange.ipc$dispatch("1155589740", new Object[]{this, loginBean});
                                return;
                            }
                            ToastUtil.i("已登录");
                        }
                    });
                }
            });
        }
    }

    private void k() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100940430")) {
            ipChange.ipc$dispatch("-2100940430", new Object[]{this});
            return;
        }
        if (hu1.b()) {
            this.f.setTextColor(this.k);
            this.e.setTextColor(this.k);
            this.e.setText(this.i.getString(R$string.iconfont_duihaomian_));
            str = "Wi-Fi/4G";
        } else {
            this.f.setTextColor(this.l);
            this.e.setTextColor(this.m);
            this.e.setText(this.i.getString(R$string.iconfont_tixing24));
            str = "较差";
        }
        this.f.setText(str);
        this.e.setVisibility(0);
        this.d.setBackgroundColor(Color.parseColor("#ffffff"));
        this.d.setOnClickListener(null);
    }

    private void l(ProjectTickGuidePreBean projectTickGuidePreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109589087")) {
            ipChange.ipc$dispatch("1109589087", new Object[]{this, projectTickGuidePreBean});
        } else if (!el2.b().g()) {
            this.d.setVisibility(4);
            this.d.setOnClickListener(null);
        } else {
            if (!hp1.i(lp1.CALENDAR)) {
                g("设置");
            } else if (qt1.d(this.i, projectTickGuidePreBean.calendarRemindTitle, projectTickGuidePreBean.sellStartTime)) {
                g("取消设置");
            } else {
                g("设置");
            }
            this.d.setOnClickListener(new c(projectTickGuidePreBean));
        }
    }

    public void d(ProjectTickGuidePreBean projectTickGuidePreBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102520573")) {
            ipChange.ipc$dispatch("-102520573", new Object[]{this, projectTickGuidePreBean, Integer.valueOf(i2)});
        } else if (projectTickGuidePreBean != null) {
            this.a.setText(el2.b().d(projectTickGuidePreBean.name));
            this.b.setText(projectTickGuidePreBean.title);
            this.c.setText(projectTickGuidePreBean.desc);
            int c2 = el2.b().c(projectTickGuidePreBean.name);
            if (1 == c2) {
                i(projectTickGuidePreBean.projectId);
            } else if (2 == c2) {
                j(projectTickGuidePreBean.projectId);
            } else if (3 == c2) {
                k();
            } else if (4 == c2) {
                l(projectTickGuidePreBean);
            }
            f(i2);
        }
    }
}
