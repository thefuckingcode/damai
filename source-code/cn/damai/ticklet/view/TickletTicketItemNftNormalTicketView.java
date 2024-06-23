package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.member.R$color;
import cn.damai.member.R$dimen;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.uikit.view.HoleCardView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.g70;
import tb.lw2;

/* compiled from: Taobao */
public class TickletTicketItemNftNormalTicketView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTicketCallback callback;
    private TextView certCardName;
    Context context;
    private TickletExtraInfo extraInfo;
    LinearLayout ll_deatil_seat;
    private int mPosition;
    private UserTicketTable mTicketTable;
    private TextView mVoucherIdTv;
    TickletTicketMainView mainView;
    ImageView nftBorderBg;
    TickletTicketOrderView orderView;
    View partent;
    private FrameLayout rlGetModel;
    ConstraintLayout ticketArea;
    HoleCardView ticketAreaHoleView;
    TickletTicketTipView ticketTipView;
    private TextView tvGetModelDesc;

    public TickletTicketItemNftNormalTicketView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103794059")) {
            ipChange.ipc$dispatch("-1103794059", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_detail_nft_normal_ticket, this);
        this.partent = inflate;
        this.ticketTipView = (TickletTicketTipView) inflate.findViewById(R$id.ticklet_ticket_rl_tip_view);
        this.mainView = (TickletTicketMainView) this.partent.findViewById(R$id.ticklet_ticket_main_view);
        this.orderView = (TickletTicketOrderView) this.partent.findViewById(R$id.ticklet_ticket_order_view);
        this.ll_deatil_seat = (LinearLayout) this.partent.findViewById(R$id.ll_deatil_seat);
        this.mVoucherIdTv = (TextView) this.partent.findViewById(R$id.ticket_unique_no_tv);
        this.certCardName = (TextView) this.partent.findViewById(R$id.ticket_card_name_cert);
        this.rlGetModel = (FrameLayout) this.partent.findViewById(R$id.ticket_get_model_layout);
        this.tvGetModelDesc = (TextView) this.partent.findViewById(R$id.tv_get_model_desc);
        this.ticketAreaHoleView = (HoleCardView) this.partent.findViewById(R$id.ticklet_ticket_hv_container);
        this.nftBorderBg = (ImageView) this.partent.findViewById(R$id.iv_nft_ticket_back_rim);
        this.ticketArea = (ConstraintLayout) this.partent.findViewById(R$id.ticklet_ticket_layout);
        this.ticketAreaHoleView.setmScallopPositionPx(g70.d() - ((int) getResources().getDimension(R$dimen.ticklet_nft_hole_site)));
    }

    public TextView getTipTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-984655945")) {
            return this.ticketTipView.getTipTv();
        }
        return (TextView) ipChange.ipc$dispatch("-984655945", new Object[]{this});
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340631255")) {
            ipChange.ipc$dispatch("-1340631255", new Object[]{this, tickletTicketCallback});
            return;
        }
        this.callback = tickletTicketCallback;
    }

    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, TicketDeatilResult ticketDeatilResult, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824345428")) {
            ipChange.ipc$dispatch("824345428", new Object[]{this, userTicketTable, tickletExtraInfo, ticketDeatilResult, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable != null) {
            this.mPosition = i;
            this.mTicketTable = userTicketTable;
            this.extraInfo = tickletExtraInfo;
            this.ticketTipView.update(userTicketTable, tickletExtraInfo);
            this.mainView.setTicketCallback(this.callback);
            this.mainView.update(this, userTicketTable, tickletExtraInfo, i2, i);
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
            lw2.f().g(this.rlGetModel, this.tvGetModelDesc, userTicketTable.getExtAttr());
            if (userTicketTable.isNftTicket()) {
                lw2.F(this.nftBorderBg);
                if (tickletExtraInfo.isTMNormalMember()) {
                    this.nftBorderBg.setBackgroundResource(R$drawable.ticket_nft_back_rim_vip);
                } else {
                    this.nftBorderBg.setBackgroundResource(R$drawable.ticket_nft_back_rim);
                }
                this.ticketArea.setBackgroundResource(R$drawable.ticket_nft_bg);
                return;
            }
            lw2.v(this.nftBorderBg);
            this.ticketArea.setBackgroundResource(R$color.white);
        }
    }

    public TickletTicketItemNftNormalTicketView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketItemNftNormalTicketView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initView();
    }
}
