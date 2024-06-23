package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gl2;
import tb.xf2;

/* compiled from: Taobao */
public class TickletTicketTipView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private View partent;
    private UserTicketTable ticket;
    private TextView tv_second_tips;
    private TextView tv_tips;
    private String viewType;

    public TickletTicketTipView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393917388")) {
            ipChange.ipc$dispatch("-393917388", new Object[]{this});
            return;
        }
        if (gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_tip_layout, this);
        } else {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_tip_layout, this);
        }
        this.tv_tips = (TextView) this.partent.findViewById(R$id.tv_tips);
        this.tv_second_tips = (TextView) this.partent.findViewById(R$id.tv_second_tips);
    }

    public TextView getTipTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1534613898")) {
            return this.tv_tips;
        }
        return (TextView) ipChange.ipc$dispatch("-1534613898", new Object[]{this});
    }

    public String getViewType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-731837196")) {
            return this.viewType;
        }
        return (String) ipChange.ipc$dispatch("-731837196", new Object[]{this});
    }

    public void setViewType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094444438")) {
            ipChange.ipc$dispatch("-1094444438", new Object[]{this, str});
            return;
        }
        this.viewType = str;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        if (r0.equals("3") == false) goto L_0x0036;
     */
    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo) {
        IpChange ipChange = $ipChange;
        char c = 2;
        if (AndroidInstantRuntime.support(ipChange, "-2035612551")) {
            ipChange.ipc$dispatch("-2035612551", new Object[]{this, userTicketTable, tickletExtraInfo});
        } else if (userTicketTable != null) {
            this.ticket = userTicketTable;
            StringBuilder sb = new StringBuilder();
            String voucherType = userTicketTable.getVoucherType();
            voucherType.hashCode();
            switch (voucherType.hashCode()) {
                case 49:
                    if (voucherType.equals("1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (voucherType.equals("2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    break;
                case 52:
                    if (voucherType.equals("4")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 53:
                    if (voucherType.equals("5")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 54:
                    if (voucherType.equals("6")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1599:
                    if (voucherType.equals("21")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1630:
                    if (voucherType.equals("31")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1661:
                    if (voucherType.equals(UserTicketTable.COUPON_TICKET)) {
                        c = '\b';
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
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                    if (xf2.i(userTicketTable.getTips())) {
                        sb.append(userTicketTable.getTips());
                        break;
                    }
                    break;
                default:
                    sb.append(this.context.getResources().getString(R$string.ticklet_detail_ticket_other_head_tip));
                    break;
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                this.tv_tips.setVisibility(0);
                this.tv_tips.setText(sb.toString());
            } else {
                this.tv_tips.setVisibility(8);
            }
            if (!TextUtils.isEmpty(userTicketTable.getUseTips())) {
                this.tv_second_tips.setVisibility(0);
                this.tv_second_tips.setText(userTicketTable.getUseTips());
                return;
            }
            this.tv_second_tips.setVisibility(4);
        }
    }

    public TickletTicketTipView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketTipView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.viewType = "DEFAULT";
        this.context = context2;
        setGravity(16);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
