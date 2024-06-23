package cn.damai.ticklet.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.lw2;
import tb.sl2;

/* compiled from: Taobao */
public class TickletScreenCapture extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String CAPTURE_FROM_DETAIL = "perfromDetail";
    public static String CAPTURE_FROM_VOUCHER = "perfromVoucher";
    private LinearLayout captureLayout;
    private String from;
    private String imagePath;
    private String pageName;
    private String performId;
    private String productSystemId;
    private String projectId;
    private int souvenirState;
    private UserTicketTable ticket;
    private TickletDetailInterface tickletDetailInterface;
    private TextView tv_feedback;
    private TextView tv_souvenir;
    private TextView tv_transfer;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-736605849")) {
                ipChange.ipc$dispatch("-736605849", new Object[]{this, view});
                return;
            }
            TickletScreenCapture.this.dissDialog();
        }
    }

    private void actionControl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811543514")) {
            ipChange.ipc$dispatch("811543514", new Object[]{this});
            return;
        }
        UserTicketTable userTicketTable = this.ticket;
        if (userTicketTable != null) {
            String voucherType = userTicketTable.getVoucherType();
            voucherType.hashCode();
            char c = 65535;
            switch (voucherType.hashCode()) {
                case 49:
                    if (voucherType.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (voucherType.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (voucherType.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 52:
                    if (voucherType.equals("4")) {
                        c = 3;
                        break;
                    }
                    break;
                case 53:
                    if (voucherType.equals("5")) {
                        c = 4;
                        break;
                    }
                    break;
                case 54:
                    if (voucherType.equals("6")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1599:
                    if (voucherType.equals("21")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1630:
                    if (voucherType.equals("31")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 5:
                case 7:
                    actionShow(true);
                    return;
                case 3:
                case 6:
                    actionShow(false);
                    return;
                default:
                    return;
            }
        }
    }

    private void actionShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136622626")) {
            ipChange.ipc$dispatch("-2136622626", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            UserTicketTable userTicketTable = this.ticket;
            if (userTicketTable == null || !userTicketTable.isTransferStateEnable() || !"1".equals(this.ticket.getVoucherState())) {
                this.tv_transfer.setVisibility(8);
            } else {
                sb.append(getResources().getString(R$string.ticklet_ticket_capture_transfer));
                this.tv_transfer.setVisibility(0);
            }
            if (this.souvenirState == 1) {
                this.tv_souvenir.setVisibility(0);
                if (this.tv_transfer.getVisibility() == 0) {
                    this.tv_souvenir.setBackgroundResource(R$drawable.ticklet_ffe9f0_radius24_bg);
                    this.tv_souvenir.setTextColor(getResources().getColor(R$color.color_ff2d79));
                } else {
                    this.tv_souvenir.setBackgroundResource(R$drawable.submit_enable_btn_h44);
                    this.tv_souvenir.setTextColor(getResources().getColor(R$color.white));
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    sb.append("&");
                }
                sb.append(getResources().getString(R$string.ticklet_ticket_capture_souvenir));
            } else {
                this.tv_souvenir.setVisibility(8);
            }
        } else {
            this.tv_transfer.setVisibility(8);
            this.tv_souvenir.setVisibility(8);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.projectId);
        hashMap.put("screening_id", this.performId);
        hashMap.put("titlelabel", sb.toString());
        c.e().G(this.captureLayout, "alert", "screenshot", this.pageName, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dissDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983855228")) {
            ipChange.ipc$dispatch("983855228", new Object[]{this});
            return;
        }
        TickletDetailInterface tickletDetailInterface2 = this.tickletDetailInterface;
        if (tickletDetailInterface2 != null) {
            tickletDetailInterface2.hideTickletShowAllFragment();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "399737958")) {
            return R$layout.fragment_screen_capture;
        }
        return ((Integer) ipChange.ipc$dispatch("399737958", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164017310")) {
            ipChange.ipc$dispatch("-1164017310", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353937143")) {
            ipChange.ipc$dispatch("-353937143", new Object[]{this});
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        if (r7.equals("2") == false) goto L_0x011d;
     */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        String str;
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "1700490228")) {
            ipChange.ipc$dispatch("1700490228", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        TextView textView = (TextView) this.rootView.findViewById(R$id.tv_title_info);
        TextView textView2 = (TextView) this.rootView.findViewById(R$id.tv_title_des_info);
        this.captureLayout = (LinearLayout) this.rootView.findViewById(R$id.ticklet_capture_layout);
        this.tv_transfer = (TextView) this.rootView.findViewById(R$id.ticklet_capture_tv_transfer);
        this.tv_souvenir = (TextView) this.rootView.findViewById(R$id.ticklet_capture_tv_souvenir);
        this.tv_feedback = (TextView) this.rootView.findViewById(R$id.ticklet_capture_tv_feedback);
        this.tv_transfer.setOnClickListener(this);
        this.tv_souvenir.setOnClickListener(this);
        this.tv_feedback.setOnClickListener(this);
        ((TextView) this.rootView.findViewById(R$id.ticklet_capture_tv_cancle)).setOnClickListener(new a());
        String str2 = "1";
        if (arguments != null) {
            this.ticket = (UserTicketTable) arguments.getSerializable("data");
            this.projectId = arguments.getString("projectId");
            this.performId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = arguments.getString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
            this.imagePath = arguments.getString("imagePath");
            this.souvenirState = arguments.getInt("souvenirState");
            String string = arguments.getString("from");
            this.from = string;
            if (CAPTURE_FROM_DETAIL.equals(string)) {
                this.pageName = sl2.TICKLET_DETAIL_PAGE;
            } else {
                this.pageName = sl2.TICKLET_VOUCHER;
            }
            String string2 = getResources().getString(R$string.ticklet_ticket_capture_title);
            UserTicketTable userTicketTable = this.ticket;
            if (userTicketTable == null || !userTicketTable.isPaperTicket()) {
                UserTicketTable userTicketTable2 = this.ticket;
                if (userTicketTable2 == null || !userTicketTable2.isPdfTicket()) {
                    UserTicketTable userTicketTable3 = this.ticket;
                    if (userTicketTable3 == null || !userTicketTable3.isLiveTicket()) {
                        UserTicketTable userTicketTable4 = this.ticket;
                        if (userTicketTable4 != null && userTicketTable4.hasAvailableTicket()) {
                            String voucherType = this.ticket.getVoucherType();
                            voucherType.hashCode();
                            switch (voucherType.hashCode()) {
                                case 49:
                                    if (voucherType.equals(str2)) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 50:
                                    break;
                                case 51:
                                    if (voucherType.equals("3")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 53:
                                    if (voucherType.equals("5")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 54:
                                    if (voucherType.equals("6")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1661:
                                    if (voucherType.equals(UserTicketTable.COUPON_TICKET)) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    str = "二维码实时更新\n截屏无法核验入场";
                                    break;
                                case 1:
                                case 3:
                                case 4:
                                case 5:
                                    string2 = getResources().getString(R$string.ticklet_ticket_capture_title_danger);
                                    str = "请勿将截屏发送给陌生人\n以免被盗用造成损失";
                                    break;
                                case 2:
                                    str = "请凭有效证件换/验入场";
                                    break;
                            }
                        }
                        str = "";
                    } else {
                        str = "请点击进入直播间观看";
                    }
                } else {
                    str = "入场方式以邮件内容为准";
                }
            } else {
                str = "请凭纸质票核验入场";
            }
            textView.setText(string2);
            if (!TextUtils.isEmpty(str)) {
                textView2.setVisibility(0);
                textView2.setText(str);
            } else {
                textView2.setVisibility(8);
            }
            actionControl();
        }
        if (this.ticket != null) {
            c e = c.e();
            sl2 j = sl2.j();
            String voucherUniqueKey = this.ticket.getVoucherUniqueKey();
            if (!this.ticket.isTransferStateEnable()) {
                str2 = "0";
            }
            e.A(j.q(voucherUniqueKey, str2), sl2.TICKLET_SCROT4TICKETINFO, this.pageName);
            return;
        }
        c.e().A(sl2.j().q("", "0"), sl2.TICKLET_SCROT4TICKETINFO, this.pageName);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088880858")) {
            ipChange.ipc$dispatch("1088880858", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.ticklet_capture_tv_transfer) {
            TickletDetailInterface tickletDetailInterface2 = this.tickletDetailInterface;
            if (tickletDetailInterface2 != null) {
                tickletDetailInterface2.captureGoTransferManagePage();
            }
            c.e().x(sl2.j().M(this.performId, this.projectId, this.pageName, "transfer"));
        } else if (view.getId() == R$id.ticklet_capture_tv_souvenir) {
            if (getContext() != null) {
                lw2.f().l(getContext(), this.performId, this.productSystemId);
            }
            c.e().x(sl2.j().M(this.performId, this.projectId, this.pageName, "share_ticket"));
        } else if (view.getId() == R$id.ticklet_capture_tv_feedback) {
            TickletDetailInterface tickletDetailInterface3 = this.tickletDetailInterface;
            if (tickletDetailInterface3 != null) {
                tickletDetailInterface3.goFeedBackPage(this.imagePath);
            }
            c.e().x(sl2.j().M(this.performId, this.projectId, this.pageName, "help"));
        }
        dissDialog();
    }

    public void setTickletDetailInterface(TickletDetailInterface tickletDetailInterface2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452473422")) {
            ipChange.ipc$dispatch("-1452473422", new Object[]{this, tickletDetailInterface2});
            return;
        }
        this.tickletDetailInterface = tickletDetailInterface2;
    }
}
