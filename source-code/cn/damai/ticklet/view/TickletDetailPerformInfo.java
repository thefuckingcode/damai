package cn.damai.ticklet.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailFragment;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketDeatilResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import tb.f4;
import tb.g91;
import tb.gl2;
import tb.gr;
import tb.lw2;
import tb.qg0;
import tb.sl2;
import tb.ug2;
import tb.wk;
import tb.xf2;

/* compiled from: Taobao */
public class TickletDetailPerformInfo extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    ImageView imageViewShadow;
    View partent;
    LinearLayout passTicket;
    TextView passTicketTip;
    TextView tv_perform_name;
    TextView tv_perform_time;
    TextView tv_perform_venue;
    TUrlImageView tv_project_image;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketDeatilResult a;

        a(TicketDeatilResult ticketDeatilResult) {
            this.a = ticketDeatilResult;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "594195089")) {
                ipChange.ipc$dispatch("594195089", new Object[]{this, view});
                return;
            }
            TicketDeatilResult ticketDeatilResult = this.a;
            if (ticketDeatilResult != null && !TextUtils.isEmpty(ticketDeatilResult.getShowTimeRangeDetail())) {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "iteminfo", "useexplain", sl2.j().s(this.a.getProjectId(), this.a.getPerformId()), Boolean.FALSE));
                TickletDetailPerformInfo.this.passDialogTip(this.a.getShowTimeRangeDetail());
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketDeatilResult a;

        b(TicketDeatilResult ticketDeatilResult) {
            this.a = ticketDeatilResult;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589481838")) {
                ipChange.ipc$dispatch("-1589481838", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "iteminfo", "itemimage", sl2.j().s(this.a.getProjectId(), this.a.getPerformId()), Boolean.TRUE));
            if (this.a.isLivePerform() && !TextUtils.isEmpty(this.a.getLiveH5Url())) {
                lw2.f().n(TickletDetailPerformInfo.this.context, this.a.getLiveH5Url());
            } else if (this.a.getUserPerformVO().isCouponPerform()) {
                TickletDetailPerformInfo.this.gotoCouponDetail(this.a.getItemId());
            } else if (!TextUtils.isEmpty(this.a.getItemId())) {
                TickletDetailPerformInfo.this.gotoProjectDetail(this.a.getItemId(), this.a.getProjectName(), this.a.getProjectImage());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements IPhenixListener<ug2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        c(TickletDetailPerformInfo tickletDetailPerformInfo, ImageView imageView) {
            this.a = imageView;
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1759149139")) {
                return ((Boolean) ipChange.ipc$dispatch("-1759149139", new Object[]{this, ug2})).booleanValue();
            }
            this.a.setVisibility(0);
            g91.c("ratioTime", "success ");
            return true;
        }
    }

    /* compiled from: Taobao */
    public class d implements IPhenixListener<qg0> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        d(TickletDetailPerformInfo tickletDetailPerformInfo, ImageView imageView) {
            this.a = imageView;
        }

        /* renamed from: a */
        public boolean onHappen(qg0 qg0) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2064597002")) {
                return ((Boolean) ipChange.ipc$dispatch("2064597002", new Object[]{this, qg0})).booleanValue();
            }
            this.a.setVisibility(8);
            g91.c("ratioTime", "fail ");
            return true;
        }
    }

    public TickletDetailPerformInfo(Context context2) {
        this(context2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoCouponDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175280061")) {
            ipChange.ipc$dispatch("-1175280061", new Object[]{this, str});
        } else if (this.context != null && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(CouponDetailFragment.COUPON_ID, str);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(gr.SCRIPT_COUPON_DETAIL));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoProjectDetail(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480875246")) {
            ipChange.ipc$dispatch("480875246", new Object[]{this, str, str2, str3});
        } else if (this.context != null) {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str);
            bundle.putString("projectName", str2);
            bundle.putString("projectImage", str3);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410684958")) {
            ipChange.ipc$dispatch("410684958", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_deatil_perform_info, this);
        this.partent = inflate;
        this.tv_perform_name = (TextView) inflate.findViewById(R$id.tv_perform_name);
        this.tv_perform_time = (TextView) this.partent.findViewById(R$id.tv_perform_time);
        this.tv_perform_venue = (TextView) this.partent.findViewById(R$id.tv_perform_venue);
        this.tv_project_image = (TUrlImageView) this.partent.findViewById(R$id.tv_project_image);
        this.imageViewShadow = (ImageView) this.partent.findViewById(R$id.tv_project_image_shadow);
        this.passTicket = (LinearLayout) this.partent.findViewById(R$id.ticklet_ll_perform_pass_ticket);
        this.passTicketTip = (TextView) this.partent.findViewById(R$id.tv_perform_pass_ticket_tip);
    }

    private void loadPerformImage(TUrlImageView tUrlImageView, ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512418691")) {
            ipChange.ipc$dispatch("-1512418691", new Object[]{this, tUrlImageView, imageView, str});
            return;
        }
        tUrlImageView.setImageUrl(str);
        tUrlImageView.succListener(new c(this, imageView));
        tUrlImageView.failListener(new d(this, imageView));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void passDialogTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626448831")) {
            ipChange.ipc$dispatch("626448831", new Object[]{this, str});
            return;
        }
        Context context2 = this.context;
        if (context2 != null) {
            new f4(context2).i(getResources().getString(R$string.ticklet_ticket_pass_dialog_title)).c(false).e(str).h(getResources().getString(R$string.ticklet_know), null).j();
        }
    }

    public void update(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024914490")) {
            ipChange.ipc$dispatch("-1024914490", new Object[]{this, ticketDeatilResult});
        } else if (ticketDeatilResult == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            lw2.E(this.tv_perform_name, ticketDeatilResult.getProjectName());
            if (!TextUtils.isEmpty(ticketDeatilResult.getTimeTitle()) || ticketDeatilResult.getBeginTime().longValue() != 0) {
                this.tv_perform_time.setVisibility(0);
                lw2.C(this.context, this.tv_perform_time, ticketDeatilResult.getTimeTitle(), ticketDeatilResult.getBeginTime().longValue(), ticketDeatilResult.getChangeDateState(), ticketDeatilResult.getChangeDateReason(), ticketDeatilResult.getPerformStatus());
            } else {
                this.tv_perform_time.setVisibility(8);
            }
            if (ticketDeatilResult.getLocaleName() != null) {
                this.tv_perform_venue.setVisibility(0);
                this.tv_perform_venue.setText(ticketDeatilResult.getLocaleName());
            } else {
                this.tv_perform_venue.setVisibility(8);
            }
            if (TextUtils.isEmpty(ticketDeatilResult.getLongtermProject()) || !"1".equals(ticketDeatilResult.getLongtermProject())) {
                this.passTicket.setVisibility(8);
            } else {
                this.passTicket.setVisibility(0);
                this.passTicket.setOnClickListener(new a(ticketDeatilResult));
            }
            if (xf2.j(ticketDeatilResult.getProjectImage())) {
                ticketDeatilResult.setProjectImage(gl2.PROJECT_DEFAULT_IMAGE);
            }
            loadPerformImage(this.tv_project_image, this.imageViewShadow, ticketDeatilResult.getProjectImage());
            this.tv_project_image.setOnClickListener(new b(ticketDeatilResult));
        }
    }

    public TickletDetailPerformInfo(Context context2, @Nullable AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletDetailPerformInfo(Context context2, @Nullable AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initView();
    }
}
