package cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeat;
import cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeatButton;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListBean;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListSelfPreBean;
import cn.damai.trade.newtradeorder.ui.orderlist.helper.OrderPayChooseImpl;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import tb.br;
import tb.d20;
import tb.ln2;
import tb.um1;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class OrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<OrderListBean> b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private OrderPayChooseImpl e;
    private int f;
    private View.OnClickListener g = new a();

    /* compiled from: Taobao */
    public class OrderListViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private LinearLayout A;
        private TextView B;
        private LinearLayout C;
        private TextView D;
        private TextView E;
        private TextView F;
        private LinearLayout G;
        private TextView H;
        private TextView I;
        private View.OnClickListener J = new a();
        private View a;
        private LinearLayout b;
        private TextView c;
        private RoundImageView d;
        private TextView e;
        private RelativeLayout f;
        private TextView g;
        private DMIconFontTextView h;
        private TextView i;
        private LinearLayout j;
        private LinearLayout k;
        private TextView l;
        private TextView m;
        private TextView n;
        private TextView o;
        private TextView p;
        private RelativeLayout q;
        private Button r;
        private RelativeLayout s;
        private TextView t;
        private LinearLayout u;
        private TextView v;
        private TextView w;
        private TextView x;
        private TextView y;
        private View z;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1078924961")) {
                    ipChange.ipc$dispatch("-1078924961", new Object[]{this, view});
                    return;
                }
                int id = view.getId();
                if (R$id.order_item_refund == id) {
                    OrderListAdapter.this.c.onClick(view);
                } else if (R$id.ll_order_content == id) {
                    OrderListAdapter.this.d.onClick(view);
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
                if (AndroidInstantRuntime.support(ipChange, "1032365408")) {
                    ipChange.ipc$dispatch("1032365408", new Object[]{this, view});
                    return;
                }
                view.setClickable(false);
                OrderListAdapter.this.e.onRemindClick(view);
            }
        }

        /* compiled from: Taobao */
        public class c implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            c() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1151311519")) {
                    ipChange.ipc$dispatch("-1151311519", new Object[]{this, view});
                } else if (OrderListAdapter.this.e != null) {
                    OrderListAdapter.this.e.onChooseSeatClick(view);
                }
            }
        }

        public OrderListViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.order_list_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            f(this.itemView);
        }

        private void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1030145265")) {
                ipChange.ipc$dispatch("1030145265", new Object[]{this, view});
                return;
            }
            this.q = (RelativeLayout) view.findViewById(R$id.rl_isWorkflowOrder_view);
            Button button = (Button) view.findViewById(R$id.order_item_refund);
            this.r = button;
            button.setOnClickListener(this.J);
            this.b.setOnClickListener(this.J);
        }

        private void c(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-66299466")) {
                ipChange.ipc$dispatch("-66299466", new Object[]{this, view});
                return;
            }
            this.s = (RelativeLayout) view.findViewById(R$id.rl_time_status_view);
            this.u = (LinearLayout) view.findViewById(R$id.time_view);
            this.t = (TextView) view.findViewById(R$id.tv_self_desc);
            this.v = (TextView) view.findViewById(R$id.tv_self_day);
            this.w = (TextView) view.findViewById(R$id.tv_self_hour);
            this.x = (TextView) view.findViewById(R$id.tv_self_min);
            this.y = (TextView) view.findViewById(R$id.tv_self_sec);
        }

        private void d(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-226086260")) {
                ipChange.ipc$dispatch("-226086260", new Object[]{this, view});
                return;
            }
            this.z = view.findViewById(R$id.pay_after_line);
            this.A = (LinearLayout) view.findViewById(R$id.ll_pay_after_view);
            this.B = (TextView) view.findViewById(R$id.tv_pay_after_desc);
            this.C = (LinearLayout) view.findViewById(R$id.ll_pay_after_time);
            this.D = (TextView) view.findViewById(R$id.tv_pay_after_hour);
            this.E = (TextView) view.findViewById(R$id.tv_pay_after_min);
            this.F = (TextView) view.findViewById(R$id.tv_pay_after_sec);
            this.G = (LinearLayout) view.findViewById(R$id.ll_pay_after_remind);
            this.H = (TextView) view.findViewById(R$id.btn_pay_after_remind);
            this.I = (TextView) view.findViewById(R$id.btn_pay_after_seat);
            this.A.setVisibility(8);
            this.z.setVisibility(8);
        }

        private void e(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-165100457")) {
                ipChange.ipc$dispatch("-165100457", new Object[]{this, view});
                return;
            }
            this.j = (LinearLayout) view.findViewById(R$id.ll_project_content);
            RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.iv_project_image);
            this.d = roundImageView;
            roundImageView.setType(1);
            this.d.setBorderRadius(3);
            this.e = (TextView) view.findViewById(R$id.tv_project_name);
            this.f = (RelativeLayout) view.findViewById(R$id.rl_delay_remind);
            this.g = (TextView) view.findViewById(R$id.tv_project_time);
            this.h = (DMIconFontTextView) view.findViewById(R$id.tv_delay_remind);
            this.i = (TextView) view.findViewById(R$id.tv_project_city_venue);
            TextView textView = (TextView) view.findViewById(R$id.tv_sale_item_label);
            this.p = textView;
            textView.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_price);
            this.k = linearLayout;
            this.l = (TextView) linearLayout.findViewById(R$id.tv_project_count);
            this.m = (TextView) this.k.findViewById(R$id.tv_project_price_mark);
            this.n = (TextView) this.k.findViewById(R$id.tv_project_price);
            this.o = (TextView) this.k.findViewById(R$id.tv_project_price_desc);
        }

        private void f(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "45433190")) {
                ipChange.ipc$dispatch("45433190", new Object[]{this, view});
                return;
            }
            View findViewById = view.findViewById(R$id.top_line);
            this.a = findViewById;
            findViewById.setVisibility(8);
            this.b = (LinearLayout) view.findViewById(R$id.ll_order_content);
            TextView textView = (TextView) view.findViewById(R$id.tv_order_status);
            this.c = textView;
            textView.setVisibility(0);
            e(view);
            c(view);
            d(view);
            b(view);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00fe  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0162  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x01df  */
        private void g(OrderListBean orderListBean) {
            boolean z2;
            OrderFirstPayChooseSeatButton orderFirstPayChooseSeatButton;
            int i2;
            IpChange ipChange = $ipChange;
            boolean z3 = true;
            if (AndroidInstantRuntime.support(ipChange, "1647673395")) {
                ipChange.ipc$dispatch("1647673395", new Object[]{this, orderListBean});
                return;
            }
            OrderFirstPayChooseSeat orderFirstPayChooseSeat = orderListBean != null ? orderListBean.firstPayChooseSeat : null;
            if (orderFirstPayChooseSeat != null) {
                orderFirstPayChooseSeat.orderId = String.valueOf(orderListBean.orderId);
                if (!TextUtils.isEmpty(orderFirstPayChooseSeat.reservedDesc)) {
                    this.B.setText(orderFirstPayChooseSeat.reservedDesc);
                } else if (!TextUtils.isEmpty(orderFirstPayChooseSeat.chooseSeatDesc)) {
                    this.B.setText(orderFirstPayChooseSeat.chooseSeatDesc);
                } else {
                    this.B.setText("");
                    z2 = false;
                    if (z2) {
                        if (orderListBean.orderClose()) {
                            this.B.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_999999));
                        } else {
                            this.B.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_000000));
                        }
                    }
                    this.G.setVisibility(8);
                    this.I.setVisibility(8);
                    if (xf2.e(orderFirstPayChooseSeat.button) > 0 && (orderFirstPayChooseSeatButton = orderFirstPayChooseSeat.button.get(0)) != null) {
                        i2 = orderFirstPayChooseSeatButton.type;
                        if (i2 != 1) {
                            this.I.setVisibility(8);
                            this.G.setVisibility(0);
                            this.H.setVisibility(0);
                            this.H.setText(orderFirstPayChooseSeatButton.name);
                            this.G.setTag(orderListBean);
                            if (OrderListAdapter.this.e != null) {
                                this.G.setOnClickListener(new b());
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("usercode", d20.E());
                            hashMap.put("orderid", orderFirstPayChooseSeat.orderId);
                            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
                            LinearLayout linearLayout = this.G;
                            e2.G(linearLayout, "remind_" + orderListBean.index, "order_info", ln2.ORDER_LIST_PAGE, hashMap);
                        } else if (i2 == 2) {
                            this.G.setVisibility(8);
                            this.I.setVisibility(0);
                            this.I.setText(orderFirstPayChooseSeatButton.name);
                            this.I.setTag(orderListBean);
                            this.I.setOnClickListener(new c());
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("usercode", d20.E());
                            hashMap2.put("orderid", orderFirstPayChooseSeat.orderId);
                            cn.damai.common.user.c e3 = cn.damai.common.user.c.e();
                            TextView textView = this.I;
                            e3.G(textView, "gotoseatselect_" + orderListBean.index, "order_info", ln2.ORDER_LIST_PAGE, hashMap2);
                        }
                        if (z3) {
                            this.A.setVisibility(0);
                            this.z.setVisibility(0);
                            long j2 = orderFirstPayChooseSeat.chooseSeatTime;
                            if (j2 <= 0) {
                                this.C.setVisibility(8);
                                return;
                            }
                            long elapsedRealtime = j2 - (um1.a[OrderListAdapter.this.f] + SystemClock.elapsedRealtime());
                            if (elapsedRealtime >= 86400000) {
                                this.C.setVisibility(8);
                                return;
                            } else if (elapsedRealtime > 0) {
                                OrderListAdapter.this.k(null, this.D, this.E, this.F, elapsedRealtime);
                                this.C.setVisibility(0);
                                br.c(um1.NOTIFY_ORDER_LIST_SELF, "");
                                return;
                            } else if (orderFirstPayChooseSeat.chooseSeatTime > um1.b) {
                                OrderListAdapter.this.k(null, this.D, this.E, this.F, elapsedRealtime);
                                br.c(um1.NOTIFY_ORDER_LIST_REFRESH, "");
                                return;
                            } else {
                                this.C.setVisibility(8);
                                return;
                            }
                        } else {
                            this.A.setVisibility(8);
                            this.z.setVisibility(8);
                            return;
                        }
                    }
                    z3 = z2;
                    if (z3) {
                    }
                }
                z2 = true;
                if (z2) {
                }
                this.G.setVisibility(8);
                this.I.setVisibility(8);
                i2 = orderFirstPayChooseSeatButton.type;
                if (i2 != 1) {
                }
                if (z3) {
                }
            }
        }

        private void h(int i2) {
            IpChange ipChange = $ipChange;
            boolean z2 = true;
            int i3 = 0;
            if (AndroidInstantRuntime.support(ipChange, "1655730420")) {
                ipChange.ipc$dispatch("1655730420", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            if (i2 == 1) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
                z2 = false;
            }
            RelativeLayout relativeLayout = this.q;
            if (!z2) {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }

        private void i(OrderListSelfPreBean orderListSelfPreBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1407596629")) {
                ipChange.ipc$dispatch("1407596629", new Object[]{this, orderListSelfPreBean});
            } else if (orderListSelfPreBean != null) {
                if (!TextUtils.isEmpty(orderListSelfPreBean.chooseSeatDesc)) {
                    this.t.setText(orderListSelfPreBean.chooseSeatDesc);
                    this.s.setVisibility(0);
                } else {
                    this.s.setVisibility(8);
                }
                long j2 = orderListSelfPreBean.startChooseTime;
                if (j2 <= 0) {
                    this.u.setVisibility(8);
                    return;
                }
                long elapsedRealtime = j2 - (um1.a[OrderListAdapter.this.f] + SystemClock.elapsedRealtime());
                if (elapsedRealtime > 0) {
                    OrderListAdapter.this.k(this.v, this.w, this.x, this.y, elapsedRealtime);
                    this.u.setVisibility(0);
                    br.c(um1.NOTIFY_ORDER_LIST_SELF, "");
                } else if (orderListSelfPreBean.startChooseTime > um1.b) {
                    OrderListAdapter.this.k(this.v, this.w, this.x, this.y, elapsedRealtime);
                    br.c(um1.NOTIFY_ORDER_LIST_REFRESH, "");
                } else {
                    this.u.setVisibility(8);
                }
            }
        }

        private void j(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-607400660")) {
                ipChange.ipc$dispatch("-607400660", new Object[]{this, str});
            } else if (TextUtils.isEmpty(str)) {
                this.p.setVisibility(8);
                k(false);
            } else {
                this.p.setText(str);
                this.p.setVisibility(0);
                k(true);
            }
        }

        private void k(boolean z2) {
            LinearLayout.LayoutParams layoutParams;
            LinearLayout.LayoutParams layoutParams2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2110682037")) {
                ipChange.ipc$dispatch("2110682037", new Object[]{this, Boolean.valueOf(z2)});
                return;
            }
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 48;
                layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams2.height = -2;
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 80;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams3.height = -1;
                layoutParams2 = layoutParams3;
            }
            this.k.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
        }

        public void a(OrderListBean orderListBean, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1137433706")) {
                ipChange.ipc$dispatch("1137433706", new Object[]{this, orderListBean, Integer.valueOf(i2)});
            } else if (orderListBean != null) {
                orderListBean.index = i2;
                this.a.setVisibility(i2 == 0 ? 0 : 8);
                this.c.setText(orderListBean.orderStatus);
                if (this.d.getTag() instanceof zq) {
                    ((zq) this.d.getTag()).cancel();
                }
                DMImageCreator c2 = cn.damai.common.image.a.b().c(orderListBean.projectPicUrl);
                int i3 = R$drawable.uikit_default_image_bg_gradient;
                this.d.setTag(c2.i(i3).c(i3).g(this.d));
                this.e.setText(orderListBean.projectName);
                if (TextUtils.isEmpty(orderListBean.venueName)) {
                    orderListBean.venueName = "场馆待定";
                }
                this.g.setText(orderListBean.playTime);
                if (TextUtils.isEmpty(orderListBean.projectCity)) {
                    this.i.setText(orderListBean.venueName);
                } else {
                    TextView textView = this.i;
                    textView.setText(orderListBean.projectCity + " | " + orderListBean.venueName);
                }
                j(orderListBean.orderFeatureDesc);
                TextView textView2 = this.l;
                textView2.setText("/ 共" + orderListBean.quantity + "张");
                this.n.setText(orderListBean.totalAmount);
                if (!TextUtils.isEmpty(orderListBean.amountDesc)) {
                    this.o.setVisibility(0);
                    this.o.setText(orderListBean.amountDesc);
                } else {
                    this.o.setVisibility(8);
                }
                if (!TextUtils.isEmpty(orderListBean.changePlayTimeReason)) {
                    this.h.setVisibility(0);
                    this.g.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_FF2D79));
                    this.f.setTag(orderListBean.changePlayTimeReason);
                    this.f.setOnClickListener(OrderListAdapter.this.g);
                } else {
                    this.h.setVisibility(8);
                    this.g.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_666666));
                    this.f.setTag(orderListBean);
                    this.f.setOnClickListener(OrderListAdapter.this.d);
                }
                if (orderListBean.orderClose()) {
                    int color = ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_999999);
                    this.c.setTextColor(color);
                    this.e.setTextColor(color);
                    this.g.setTextColor(color);
                    this.i.setTextColor(color);
                    this.m.setTextColor(color);
                    this.n.setTextColor(color);
                    this.l.setTextColor(color);
                    this.o.setTextColor(color);
                } else {
                    TextView textView3 = this.c;
                    Context context = OrderListAdapter.this.a;
                    int i4 = R$color.color_000000;
                    textView3.setTextColor(ContextCompat.getColor(context, i4));
                    this.e.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, i4));
                    if (!TextUtils.isEmpty(orderListBean.changePlayTimeReason)) {
                        this.g.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_FF2D79));
                    } else {
                        this.g.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_666666));
                    }
                    TextView textView4 = this.i;
                    Context context2 = OrderListAdapter.this.a;
                    int i5 = R$color.color_666666;
                    textView4.setTextColor(ContextCompat.getColor(context2, i5));
                    this.m.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, i4));
                    this.n.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, i4));
                    this.l.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, i5));
                    this.o.setTextColor(ContextCompat.getColor(OrderListAdapter.this.a, R$color.color_777777));
                }
                this.A.setVisibility(8);
                this.z.setVisibility(8);
                this.s.setVisibility(8);
                if (orderListBean.isHNOrder()) {
                    g(orderListBean);
                } else {
                    i(orderListBean.selfPre);
                }
                h(orderListBean.showRefundDetailBtn);
                this.r.setTag(orderListBean);
                this.b.setTag(orderListBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1347166470")) {
                ipChange.ipc$dispatch("1347166470", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (!xf2.j(str)) {
                DMDialog dMDialog = new DMDialog(OrderListAdapter.this.a);
                dMDialog.v("变更通知");
                dMDialog.q(str);
                dMDialog.n("知道了", null);
                dMDialog.show();
            }
        }
    }

    public OrderListAdapter(Context context, List<OrderListBean> list, int i) {
        this.a = context;
        this.b = list;
        this.f = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(TextView textView, TextView textView2, TextView textView3, TextView textView4, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506452046")) {
            ipChange.ipc$dispatch("-506452046", new Object[]{this, textView, textView2, textView3, textView4, Long.valueOf(j)});
            return;
        }
        long j2 = j / 86400000;
        if (textView != null) {
            if (j2 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(String.valueOf(j2) + "天");
            }
        }
        Long.signum(j2);
        long j3 = j - (j2 * 86400000);
        long j4 = j3 / DateUtils.MILLIS_PER_HOUR;
        if (j4 < 10) {
            textView2.setText("0" + j4);
        } else {
            textView2.setText(j4 + "");
        }
        long j5 = j3 - (j4 * DateUtils.MILLIS_PER_HOUR);
        long j6 = j5 / DateUtils.MILLIS_PER_MINUTE;
        if (j6 < 10) {
            textView3.setText("0" + j6);
        } else {
            textView3.setText(j6 + "");
        }
        long j7 = (j5 - (j6 * DateUtils.MILLIS_PER_MINUTE)) / 1000;
        if (j7 < 10) {
            textView4.setText("0" + j7);
            return;
        }
        textView4.setText(j7 + "");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1547653451")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1547653451", new Object[]{this})).intValue();
    }

    public void h(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060179454")) {
            ipChange.ipc$dispatch("-1060179454", new Object[]{this, onClickListener});
            return;
        }
        this.d = onClickListener;
    }

    public void i(OrderPayChooseImpl orderPayChooseImpl) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1405368345")) {
            ipChange.ipc$dispatch("-1405368345", new Object[]{this, orderPayChooseImpl});
            return;
        }
        this.e = orderPayChooseImpl;
    }

    public void j(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "946116741")) {
            ipChange.ipc$dispatch("946116741", new Object[]{this, onClickListener});
            return;
        }
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055522524")) {
            ipChange.ipc$dispatch("-1055522524", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ((OrderListViewHolder) viewHolder).a(this.b.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "819120978")) {
            return new OrderListViewHolder(this.a);
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("819120978", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
