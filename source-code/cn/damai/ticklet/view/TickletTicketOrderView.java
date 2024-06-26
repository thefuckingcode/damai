package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gl2;
import tb.gr;
import tb.sl2;

/* compiled from: Taobao */
public class TickletTicketOrderView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private Context context;
    private ImageView orderIcon;
    private TextView orderNum;
    private View partent;
    private int postion;
    private UserTicketTable ticket;
    private String viewType;

    public TickletTicketOrderView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92763097")) {
            ipChange.ipc$dispatch("-92763097", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_order_num_layout, this);
        this.partent = inflate;
        this.orderNum = (TextView) inflate.findViewById(R$id.tv_coupon_order_num);
        this.orderIcon = (ImageView) this.partent.findViewById(R$id.iv_coupon_order_icon);
        if (gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.viewType)) {
            setOnClickListener(null);
            this.orderIcon.setVisibility(8);
            return;
        }
        setOnClickListener(this);
        this.orderIcon.setVisibility(0);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303195571")) {
            ipChange.ipc$dispatch("-303195571", new Object[]{this, view});
        } else if (this.context != null) {
            sl2 j = sl2.j();
            UserTicketTable userTicketTable = this.ticket;
            c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "center_" + this.postion, "checkorder", j.t(userTicketTable.tradeOrderId, userTicketTable.getPerformId()), Boolean.TRUE));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.ticket.tradeOrderId);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(gr.COUPON_ORDER_DETAIL));
        }
    }

    public void update(UserTicketTable userTicketTable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590128537")) {
            ipChange.ipc$dispatch("590128537", new Object[]{this, userTicketTable, Integer.valueOf(i)});
        } else if (userTicketTable != null) {
            this.ticket = userTicketTable;
            this.postion = i;
            TextView textView = this.orderNum;
            textView.setText("订单号：" + userTicketTable.tradeOrderId);
            c e = c.e();
            TextView textView2 = this.orderNum;
            e.G(textView2, "checkorder", "center_" + this.postion, sl2.TICKLET_LIST_PAGE, sl2.j().t(userTicketTable.tradeOrderId, userTicketTable.getPerformId()));
        }
    }

    public TickletTicketOrderView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketOrderView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context2;
        this.activity = (DamaiBaseActivity) context2;
        setGravity(17);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
