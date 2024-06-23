package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.lw2;

/* compiled from: Taobao */
public class TickletTicketItemFloatLayerView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTicketCallback callback;
    private TextView certCardName;
    Context context;
    LinearLayout ll_deatil_seat;
    private TextView mVoucherIdTv;
    TickletTicketMainView mainView;
    TickletTicketOrderView orderView;
    View partent;
    TickletTicketHeadView ticketHeadView;
    TickletTicketTipView ticketTipView;
    LinearLayout ticklet_ticket_item_layout;

    public TickletTicketItemFloatLayerView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105919265")) {
            ipChange.ipc$dispatch("2105919265", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_float_layer_item, this);
        this.partent = inflate;
        this.ticklet_ticket_item_layout = (LinearLayout) inflate.findViewById(R$id.ticklet_ticket_item_layout);
        this.ticketHeadView = (TickletTicketHeadView) this.partent.findViewById(R$id.ticklet_ticket_rl_header_view);
        this.ticketTipView = (TickletTicketTipView) this.partent.findViewById(R$id.ticklet_ticket_rl_tip_view);
        this.mainView = (TickletTicketMainView) this.partent.findViewById(R$id.ticklet_ticket_main_view);
        this.ll_deatil_seat = (LinearLayout) this.partent.findViewById(R$id.ll_deatil_seat);
        this.mVoucherIdTv = (TextView) this.partent.findViewById(R$id.ticket_unique_no_tv);
        this.certCardName = (TextView) this.partent.findViewById(R$id.ticket_card_name_cert);
        this.orderView = (TickletTicketOrderView) this.partent.findViewById(R$id.ticklet_ticket_order_view);
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41430997")) {
            ipChange.ipc$dispatch("41430997", new Object[]{this, tickletTicketCallback});
            return;
        }
        this.callback = tickletTicketCallback;
    }

    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873742324")) {
            ipChange.ipc$dispatch("-873742324", new Object[]{this, userTicketTable, tickletExtraInfo, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable != null) {
            this.ticketHeadView.update(userTicketTable, i2, i);
            this.mainView.setTicketCallback(this.callback);
            this.mainView.update(this, userTicketTable, tickletExtraInfo, i2, i);
            this.ticketTipView.update(userTicketTable, tickletExtraInfo);
            if (userTicketTable.isCertCardTicket() && userTicketTable.isCertShowMode()) {
                lw2.D(this.certCardName, false);
            } else if (!TextUtils.isEmpty(userTicketTable.getVoucherCertName()) || !TextUtils.isEmpty(userTicketTable.getVoucherCertNo())) {
                lw2.D(this.certCardName, true);
                String str = "";
                String voucherCertName = !TextUtils.isEmpty(userTicketTable.getVoucherCertName()) ? userTicketTable.getVoucherCertName() : str;
                if (!TextUtils.isEmpty(userTicketTable.getVoucherCertNo())) {
                    str = userTicketTable.getVoucherCertNo();
                }
                TextView textView = this.certCardName;
                textView.setText(voucherCertName + AltriaXLaunchTime.SPACE + str);
            } else {
                lw2.D(this.certCardName, false);
            }
            if (!userTicketTable.isCouponTicket() || TextUtils.isEmpty(userTicketTable.tradeOrderId)) {
                lw2.f();
                lw2.v(this.orderView);
            } else {
                this.orderView.update(userTicketTable, i);
                lw2.f();
                lw2.F(this.orderView);
            }
            this.ll_deatil_seat.removeAllViews();
            lw2.x(this.context, userTicketTable, this.ll_deatil_seat);
            lw2.E(this.mVoucherIdTv, userTicketTable.getProductSystemVoucherIdWithPre());
        }
    }

    public TickletTicketItemFloatLayerView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketItemFloatLayerView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initView();
    }
}
