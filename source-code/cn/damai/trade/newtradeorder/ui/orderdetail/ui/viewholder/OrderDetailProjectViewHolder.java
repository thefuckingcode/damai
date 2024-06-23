package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailMecItemInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatPic;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSkuInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailStatusBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.PurchaseNotice;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import tb.am1;
import tb.bm1;
import tb.br;
import tb.d20;
import tb.f92;
import tb.g91;
import tb.gr;
import tb.hp1;
import tb.ln2;
import tb.lp1;
import tb.mm1;
import tb.pm1;
import tb.v50;
import tb.xf2;
import tb.xk2;

/* compiled from: Taobao */
public class OrderDetailProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private pm1 A;
    private bm1 B;
    private boolean C = false;
    private Context D;
    private DamaiBaseActivity E;
    private LayoutInflater F;
    private StringBuilder G = new StringBuilder();
    private String H;
    private String I;
    private boolean J;
    private j K;
    LinkedList<OrderDetailSeatBean> L = new LinkedList<>();
    HashMap<String, Integer> M = new HashMap<>();
    private View.OnClickListener N = new e();
    private View.OnClickListener O = new f(this);
    private View.OnClickListener P = new g();
    private CalendarsResolver.RemindMeListener Q = new h();
    private LinearLayout a;
    private RoundImageView b;
    private FrameLayout c;
    private TextView d;
    private View e;
    private TextView f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private DMIconFontTextView j;
    private View k;
    private TextView l;
    private ImageView m;
    private TextView n;
    private FlowLayout o;
    private TextView p;
    private DMIconFontTextView q;
    private TextView r;
    private LinearLayout s;
    private LinearLayout t;
    private TextView u;
    private RelativeLayout v;
    private TextView w;
    private TextView x;
    private TextView y;
    private OrderDetailRefundView z;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1252425281")) {
                ipChange.ipc$dispatch("1252425281", new Object[]{this, view});
                return;
            }
            OrderDetailMecItemInfo orderDetailMecItemInfo = (OrderDetailMecItemInfo) view.getTag();
            if (orderDetailMecItemInfo != null && OrderDetailProjectViewHolder.this.J) {
                mm1.g(OrderDetailProjectViewHolder.this.D, orderDetailMecItemInfo.itemId, orderDetailMecItemInfo.performImageUrl);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailMecItemInfo a;

        b(OrderDetailMecItemInfo orderDetailMecItemInfo) {
            this.a = orderDetailMecItemInfo;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-931251646")) {
                ipChange.ipc$dispatch("-931251646", new Object[]{this, view});
                return;
            }
            long j = this.a.showDateTime;
            DamaiBaseActivity damaiBaseActivity = OrderDetailProjectViewHolder.this.E;
            OrderDetailMecItemInfo orderDetailMecItemInfo = this.a;
            am1.e(damaiBaseActivity, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.itemId, j, OrderDetailProjectViewHolder.this.Q);
        }
    }

    /* compiled from: Taobao */
    public class c extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailMecItemInfo a;
        final /* synthetic */ OrderDetailSeatPic b;

        c(OrderDetailMecItemInfo orderDetailMecItemInfo, OrderDetailSeatPic orderDetailSeatPic) {
            this.a = orderDetailMecItemInfo;
            this.b = orderDetailSeatPic;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1180038723")) {
                ipChange.ipc$dispatch("1180038723", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ln2.r().t1(this.a.itemId, this.b.text));
            OrderDetailProjectViewHolder.this.y(this.b.url);
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1341015980")) {
                ipChange.ipc$dispatch("-1341015980", new Object[]{this, textPaint});
                return;
            }
            textPaint.setColor(OrderDetailProjectViewHolder.this.s(this.b.fontColor));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    public class d extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailMecItemInfo a;

        d(OrderDetailMecItemInfo orderDetailMecItemInfo) {
            this.a = orderDetailMecItemInfo;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1003638204")) {
                ipChange.ipc$dispatch("-1003638204", new Object[]{this, view});
            } else if (OrderDetailProjectViewHolder.this.J) {
                Context context = OrderDetailProjectViewHolder.this.D;
                OrderDetailMecItemInfo orderDetailMecItemInfo = this.a;
                mm1.g(context, orderDetailMecItemInfo.itemId, orderDetailMecItemInfo.performImageUrl);
            }
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1770604019")) {
                ipChange.ipc$dispatch("1770604019", new Object[]{this, textPaint});
                return;
            }
            textPaint.setColor(ContextCompat.getColor(OrderDetailProjectViewHolder.this.D, R$color.color_666666));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107652165")) {
                ipChange.ipc$dispatch("1107652165", new Object[]{this, view});
                return;
            }
            if (R$id.tv_order_seat_more == view.getId() && !OrderDetailProjectViewHolder.this.C) {
                OrderDetailProjectViewHolder.this.C = true;
                OrderDetailProjectViewHolder.this.D();
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f(OrderDetailProjectViewHolder orderDetailProjectViewHolder) {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1076024762")) {
                ipChange.ipc$dispatch("-1076024762", new Object[]{this, view});
                return;
            }
            br.c(mm1.NOTIFY_OPEN_NOTICE_POP, view.getTag());
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1035265607")) {
                ipChange.ipc$dispatch("1035265607", new Object[]{this, view});
                return;
            }
            try {
                mm1.c = false;
                mm1.h(OrderDetailProjectViewHolder.this.D, (PurchaseNotice) view.getTag());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1973777614")) {
                ipChange.ipc$dispatch("-1973777614", new Object[]{this});
                return;
            }
            OrderDetailProjectViewHolder.this.J(true);
            am1.f(OrderDetailProjectViewHolder.this.E, "观演提醒添加成功", "开演前24小时将收到手机日历提醒，可在系统日历中更改提醒时间");
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "691478856")) {
                ipChange.ipc$dispatch("691478856", new Object[]{this});
                return;
            }
            OrderDetailProjectViewHolder.this.J(false);
            ToastUtil.i("取消提醒成功");
        }
    }

    /* compiled from: Taobao */
    public class i implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "243980339")) {
                ipChange.ipc$dispatch("243980339", new Object[]{this});
                return;
            }
            OrderDetailProjectViewHolder.this.J(true);
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "436742311")) {
                ipChange.ipc$dispatch("436742311", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public static class j extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private WeakReference<DamaiBaseActivity> a;

        public j(DamaiBaseActivity damaiBaseActivity) {
            this.a = new WeakReference<>(damaiBaseActivity);
        }

        public void handleMessage(@NonNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1319029471")) {
                ipChange.ipc$dispatch("-1319029471", new Object[]{this, message});
            } else if (this.a.get() != null) {
                super.handleMessage(message);
            }
        }
    }

    public OrderDetailProjectViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_project_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.D = context;
        if (context instanceof DamaiBaseActivity) {
            this.E = (DamaiBaseActivity) context;
        }
        this.F = layoutInflater;
        v(this.itemView);
        x(this.itemView);
        u(this.itemView);
        w(this.itemView);
        this.z = new OrderDetailRefundView(context, this.itemView);
        this.A = new pm1(this.itemView);
        this.B = new bm1(this.itemView);
    }

    private void A(OrderDetailMecItemInfo orderDetailMecItemInfo, OrderDetailStatusBean orderDetailStatusBean, String str, String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862934864")) {
            ipChange.ipc$dispatch("862934864", new Object[]{this, orderDetailMecItemInfo, orderDetailStatusBean, str, str2});
        } else if (orderDetailMecItemInfo != null) {
            j jVar = this.K;
            if (jVar != null) {
                jVar.removeCallbacksAndMessages(null);
                this.K = null;
                q(false);
            }
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                linearLayout.setTag(orderDetailMecItemInfo);
            }
            this.I = orderDetailMecItemInfo.itemId;
            DMImageCreator c2 = cn.damai.common.image.a.b().c(orderDetailMecItemInfo.performImageUrl);
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            c2.i(i2).c(i2).g(this.b);
            this.d.setText(orderDetailMecItemInfo.projectName);
            this.f.setText(orderDetailMecItemInfo.showTimeStr);
            if (!f92.d(orderDetailMecItemInfo.subItemContentList())) {
                this.g.setVisibility(0);
                this.e.setTag(orderDetailMecItemInfo.subItemContentList());
                this.e.setClickable(true);
                HashMap hashMap = new HashMap();
                hashMap.put("item_id", this.I);
                cn.damai.common.user.c.e().G(this.e, "showchange", "show", ln2.ORDER_DETAL_PAGE, hashMap);
            } else {
                this.e.setClickable(false);
                this.g.setVisibility(8);
            }
            if (orderDetailStatusBean == null || !orderDetailStatusBean.isActiveAble() || !orderDetailMecItemInfo.isTimeValid() || f92.d(orderDetailMecItemInfo.subItemContentList())) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
            if (this.E == null || orderDetailStatusBean == null || !orderDetailMecItemInfo.isTimeValid()) {
                this.h.setVisibility(8);
                G(false);
            } else {
                try {
                    if (orderDetailStatusBean.isActiveAble()) {
                        this.h.setVisibility(0);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("item_id", orderDetailMecItemInfo.itemId);
                        cn.damai.common.user.c.e().G(this.h, "remindme", "top", ln2.ORDER_DETAL_PAGE, hashMap2);
                        H(orderDetailMecItemInfo, str);
                        this.h.setOnClickListener(new b(orderDetailMecItemInfo));
                        boolean d2 = am1.d(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.showDateTime);
                        String B2 = d20.B(str + am1.SHOW_CALENDER_POP_SUFFIX);
                        if (!mm1.c(str2) && !am1.SHOW_CALENDER_POP_TAG.equals(B2)) {
                            if (!d2) {
                                d20.T(str + am1.SHOW_CALENDER_POP_SUFFIX, am1.SHOW_CALENDER_POP_TAG);
                                G(true);
                            }
                        }
                        G(false);
                    } else {
                        if (orderDetailMecItemInfo.isChangeTime()) {
                            am1.b(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.oldShowDateTime, orderDetailMecItemInfo.itemId);
                        }
                        am1.b(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.showDateTime, orderDetailMecItemInfo.itemId);
                        this.h.setVisibility(8);
                        G(false);
                    }
                } catch (Exception e2) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("item_id", orderDetailMecItemInfo.itemId);
                    hashMap3.put("contentlabel", xk2.a(e2));
                    cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(ln2.ORDER_DETAL_PAGE, "top", "remindme_fail", hashMap3, Boolean.FALSE));
                    this.h.setVisibility(8);
                    G(false);
                }
            }
            StringBuilder sb = this.G;
            sb.delete(0, sb.length());
            this.H = "";
            if (!TextUtils.isEmpty(orderDetailMecItemInfo.projectCityName)) {
                this.G.append(orderDetailMecItemInfo.projectCityName);
                this.H = " | ";
            }
            if (!TextUtils.isEmpty(orderDetailMecItemInfo.venueName)) {
                StringBuilder sb2 = this.G;
                sb2.append(this.H);
                sb2.append(orderDetailMecItemInfo.venueName);
            }
            String sb3 = this.G.toString();
            int length = TextUtils.isEmpty(sb3) ? 0 : sb3.length();
            this.n.setTextColor(ContextCompat.getColor(this.D, R$color.color_666666));
            OrderDetailSeatPic orderDetailSeatPic = orderDetailMecItemInfo.venueSeatPic;
            if (orderDetailSeatPic != null && !TextUtils.isEmpty(orderDetailSeatPic.text)) {
                int length2 = orderDetailSeatPic.text.length();
                if (length > 0) {
                    str3 = sb3 + " " + orderDetailSeatPic.text;
                } else {
                    str3 = orderDetailSeatPic.text;
                }
                int length3 = str3.length();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                c cVar = new c(orderDetailMecItemInfo, orderDetailSeatPic);
                d dVar = new d(orderDetailMecItemInfo);
                int i3 = length3 - length2;
                spannableStringBuilder.setSpan(cVar, i3, length3, 18);
                spannableStringBuilder.setSpan(dVar, 0, i3, 17);
                this.n.setText(spannableStringBuilder);
                this.n.setMovementMethod(LinkMovementMethod.getInstance());
                this.n.setFocusable(false);
            } else if (length > 0) {
                this.n.setText(sb3);
            } else {
                this.n.setText("");
            }
        }
    }

    private void B(PurchaseNotice purchaseNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229094678")) {
            ipChange.ipc$dispatch("229094678", new Object[]{this, purchaseNotice});
        } else if (purchaseNotice == null || TextUtils.isEmpty(purchaseNotice.title)) {
            this.p.setTag(null);
            this.q.setTag(null);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            this.p.setText(purchaseNotice.title);
            this.p.setTag(purchaseNotice);
            this.q.setTag(purchaseNotice);
            this.p.setVisibility(0);
            this.q.setVisibility(0);
        }
    }

    private void C(OrderDetailSkuInfo orderDetailSkuInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788879473")) {
            ipChange.ipc$dispatch("788879473", new Object[]{this, orderDetailSkuInfo});
        } else if (orderDetailSkuInfo != null) {
            this.v.setVisibility(0);
            this.y.setText(orderDetailSkuInfo.totalPrice);
            this.w.setText(orderDetailSkuInfo.skuInfo);
            if (TextUtils.isEmpty(orderDetailSkuInfo.seatTypeDesc)) {
                this.x.setVisibility(8);
                return;
            }
            this.x.setText(orderDetailSkuInfo.seatTypeDesc);
            this.x.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019888734")) {
            ipChange.ipc$dispatch("-1019888734", new Object[]{this});
            return;
        }
        this.u.setVisibility(8);
        this.t.removeAllViews();
        this.M.clear();
        int e2 = xf2.e(this.L);
        for (int i2 = 0; i2 < e2; i2++) {
            z(this.L.get(i2), i2);
        }
    }

    private void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1029541728")) {
            ipChange.ipc$dispatch("1029541728", new Object[]{this});
            return;
        }
        this.t.removeAllViews();
        this.M.clear();
        int e2 = xf2.e(this.L);
        this.u.setVisibility(e2 > 6 ? 0 : 8);
        if (e2 > 6) {
            e2 = 6;
        }
        for (int i2 = 0; i2 < e2; i2++) {
            z(this.L.get(i2), i2);
        }
    }

    private void F(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648700662")) {
            ipChange.ipc$dispatch("-1648700662", new Object[]{this, list});
            return;
        }
        int e2 = xf2.e(list);
        if (e2 == 0) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        this.o.removeAllViews();
        for (int i2 = 0; i2 < e2; i2++) {
            View inflate = this.F.inflate(R$layout.order_detail_item_tag, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_tag)).setText(list.get(i2));
            this.o.addView(inflate);
        }
    }

    private void G(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820081593")) {
            ipChange.ipc$dispatch("-1820081593", new Object[]{this, Boolean.valueOf(z2)});
        } else if (z2) {
            this.l.setText("不错过演出，点击这里添加提醒");
            this.l.setVisibility(4);
            this.m.setVisibility(4);
            g91.b("showCalenderPop", "showPop start ");
            this.h.post(new Runnable("不错过演出，点击这里添加提醒") {
                /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailProjectViewHolder.AnonymousClass10 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1087974605")) {
                        ipChange.ipc$dispatch("1087974605", new Object[]{this});
                        return;
                    }
                    int[] iArr = new int[2];
                    OrderDetailProjectViewHolder.this.h.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    float f = (float) iArr[0];
                    g91.b("showCalenderPop", "showPop x = " + f);
                    int i2 = DisplayMetrics.getwidthPixels(v50.b(OrderDetailProjectViewHolder.this.D));
                    int a = v50.a(OrderDetailProjectViewHolder.this.D, 11.0f);
                    int a2 = v50.a(OrderDetailProjectViewHolder.this.D, 15.0f);
                    int measuredWidth = OrderDetailProjectViewHolder.this.c.getMeasuredWidth() + v50.a(OrderDetailProjectViewHolder.this.D, 11.0f) + a;
                    float measureText = OrderDetailProjectViewHolder.this.l.getPaint().measureText("不错过演出，点击这里添加提醒") + ((float) v50.a(OrderDetailProjectViewHolder.this.D, 18.0f));
                    int measuredWidth2 = OrderDetailProjectViewHolder.this.j.getMeasuredWidth();
                    int i3 = measuredWidth2 / 2;
                    ((RelativeLayout.LayoutParams) OrderDetailProjectViewHolder.this.m.getLayoutParams()).rightMargin = ((((int) ((float) OrderDetailProjectViewHolder.this.h.getMeasuredWidth())) - v50.a(OrderDetailProjectViewHolder.this.D, 4.0f)) - i3) - (OrderDetailProjectViewHolder.this.m.getMeasuredWidth() / 2);
                    float a3 = f + ((float) v50.a(OrderDetailProjectViewHolder.this.D, 4.0f)) + ((float) i3);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) OrderDetailProjectViewHolder.this.l.getLayoutParams();
                    float f2 = (((float) i2) - a3) - ((float) measuredWidth);
                    if (a3 >= ((float) (i2 / 2))) {
                        layoutParams.addRule(11);
                        layoutParams.removeRule(9);
                        float f3 = measureText / 2.0f;
                        float f4 = f2 - f3;
                        if (f4 > 0.0f && a3 > f3) {
                            layoutParams.rightMargin = (int) f4;
                            layoutParams.leftMargin = 0;
                        }
                    } else {
                        float f5 = measureText / 2.0f;
                        float f6 = (a3 - ((float) a2)) - f5;
                        layoutParams.addRule(9);
                        layoutParams.removeRule(11);
                        if (f6 > 0.0f && f2 > f5) {
                            layoutParams.leftMargin = (int) f6;
                            layoutParams.rightMargin = 0;
                        }
                    }
                    OrderDetailProjectViewHolder.this.l.setLayoutParams(layoutParams);
                    OrderDetailProjectViewHolder.this.q(true);
                }
            });
            j jVar = new j(this.E);
            this.K = jVar;
            jVar.postDelayed(new Runnable() {
                /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailProjectViewHolder.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "891461100")) {
                        ipChange.ipc$dispatch("891461100", new Object[]{this});
                        return;
                    }
                    OrderDetailProjectViewHolder.this.q(false);
                }
            }, 3000);
        } else {
            q(false);
        }
    }

    private void H(OrderDetailMecItemInfo orderDetailMecItemInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666882236")) {
            ipChange.ipc$dispatch("-666882236", new Object[]{this, orderDetailMecItemInfo, str});
        } else if (!hp1.i(lp1.CALENDAR)) {
            J(false);
        } else if (!orderDetailMecItemInfo.isChangeTime()) {
            J(am1.d(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.showDateTime));
        } else if (am1.d(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.oldShowDateTime)) {
            am1.b(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.oldShowDateTime, orderDetailMecItemInfo.itemId);
            r(orderDetailMecItemInfo, true);
        } else {
            r(orderDetailMecItemInfo, false);
        }
    }

    private void I(List<OrderDetailSeatBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244990727")) {
            ipChange.ipc$dispatch("-1244990727", new Object[]{this, list});
        } else if (xf2.e(list) > 0) {
            this.s.setVisibility(0);
            K(list);
            if (!this.C) {
                E();
            } else {
                D();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void J(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640494160")) {
            ipChange.ipc$dispatch("-1640494160", new Object[]{this, Boolean.valueOf(z2)});
        } else {
            this.i.setText(z2 ? "取消提醒" : "提醒我");
        }
    }

    private void K(List<OrderDetailSeatBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333314458")) {
            ipChange.ipc$dispatch("333314458", new Object[]{this, list});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.clear();
        this.L.clear();
        int e2 = xf2.e(list);
        for (int i2 = 0; i2 < e2; i2++) {
            OrderDetailSeatBean orderDetailSeatBean = list.get(i2);
            if (TextUtils.isEmpty(orderDetailSeatBean.combineTicketId)) {
                this.L.add(orderDetailSeatBean);
            } else if (!hashMap.containsKey(orderDetailSeatBean.combineTicketId)) {
                hashMap.put(list.get(i2).combineTicketId, Integer.valueOf(i2));
                this.L.add(orderDetailSeatBean);
            } else {
                int intValue = ((Integer) hashMap.get(orderDetailSeatBean.combineTicketId)).intValue() + 1;
                hashMap.put(orderDetailSeatBean.combineTicketId, Integer.valueOf(intValue));
                this.L.add(intValue, orderDetailSeatBean);
            }
        }
    }

    private void L(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133821465")) {
            ipChange.ipc$dispatch("1133821465", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.r.setVisibility(8);
        } else {
            this.r.setText(str);
            this.r.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385860898")) {
            ipChange.ipc$dispatch("385860898", new Object[]{this, Boolean.valueOf(z2)});
        } else if (z2) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    private void r(OrderDetailMecItemInfo orderDetailMecItemInfo, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692905416")) {
            ipChange.ipc$dispatch("1692905416", new Object[]{this, orderDetailMecItemInfo, Boolean.valueOf(z2)});
        } else if (am1.d(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.showDateTime)) {
            J(true);
        } else if (z2) {
            am1.a(this.E, orderDetailMecItemInfo.projectName, orderDetailMecItemInfo.showDateTime, new i());
        } else {
            J(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330121576")) {
            return ((Integer) ipChange.ipc$dispatch("-330121576", new Object[]{this, str})).intValue();
        }
        int color = ContextCompat.getColor(this.D, R$color.color_b3b3b3);
        try {
            if (!TextUtils.isEmpty(str)) {
                return Color.parseColor(str);
            }
            return color;
        } catch (Exception unused) {
            return ContextCompat.getColor(this.D, R$color.color_b3b3b3);
        }
    }

    private void u(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559236122")) {
            ipChange.ipc$dispatch("-559236122", new Object[]{this, view});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.ll_order_buy_container);
        this.v = relativeLayout;
        this.w = (TextView) relativeLayout.findViewById(R$id.tv_count);
        this.x = (TextView) this.v.findViewById(R$id.tv_sku_taopiao);
        this.y = (TextView) this.v.findViewById(R$id.tv_price);
    }

    private void v(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099271751")) {
            ipChange.ipc$dispatch("-2099271751", new Object[]{this, view});
            return;
        }
        this.a = (LinearLayout) view.findViewById(R$id.ll_project_content);
        this.c = (FrameLayout) view.findViewById(R$id.fr_project_image);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.iv_project_image);
        this.b = roundImageView;
        roundImageView.setBorderRadius(3);
        this.b.setType(1);
        this.d = (TextView) view.findViewById(R$id.tv_project_name);
        this.e = view.findViewById(R$id.rl_delay_remind);
        this.f = (TextView) view.findViewById(R$id.tv_project_time);
        TextView textView = (TextView) view.findViewById(R$id.tv_perform_changetip);
        this.g = (LinearLayout) view.findViewById(R$id.tv_project_time_change);
        this.h = (LinearLayout) view.findViewById(R$id.ll_project_calender);
        this.k = view.findViewById(R$id.tv_perform_sep_line);
        this.i = (TextView) view.findViewById(R$id.tv_perform_calender_tip);
        this.j = (DMIconFontTextView) view.findViewById(R$id.tv_perform_calender_icon);
        this.m = (ImageView) view.findViewById(R$id.trade_calender_pop_up_arrow);
        this.l = (TextView) view.findViewById(R$id.trade_calender_pop_tip_content);
        this.n = (TextView) view.findViewById(R$id.tv_project_city_venue);
        this.e.setOnClickListener(this.O);
        this.a.setOnClickListener(new a());
        this.o = (FlowLayout) view.findViewById(R$id.fl_mark);
        this.p = (TextView) view.findViewById(R$id.tv_ticket_notice);
        this.q = (DMIconFontTextView) view.findViewById(R$id.icon_ticket_notice);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.p.setOnClickListener(this.P);
        this.q.setOnClickListener(this.P);
    }

    private void w(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518003497")) {
            ipChange.ipc$dispatch("1518003497", new Object[]{this, view});
            return;
        }
        this.s = (LinearLayout) view.findViewById(R$id.ll_order_seat_container);
        this.t = (LinearLayout) view.findViewById(R$id.ll_order_seat);
        TextView textView = (TextView) view.findViewById(R$id.tv_order_seat_more);
        this.u = textView;
        textView.setOnClickListener(this.N);
    }

    private void x(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321039868")) {
            ipChange.ipc$dispatch("321039868", new Object[]{this, view});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_time_range_detail);
        this.r = textView;
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076142005")) {
            ipChange.ipc$dispatch("-1076142005", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            mm1.c = false;
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PicInfo picInfo = new PicInfo();
            picInfo.setPicUrl(str);
            arrayList.add(picInfo);
            Bundle bundle = new Bundle();
            bundle.putString("projectId", this.I);
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", 0);
            DMNav.from(this.D).withExtras(bundle).toUri(gr.e());
        }
    }

    private void z(OrderDetailSeatBean orderDetailSeatBean, int i2) {
        char c2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794225809")) {
            ipChange.ipc$dispatch("-794225809", new Object[]{this, orderDetailSeatBean, Integer.valueOf(i2)});
        } else if (orderDetailSeatBean != null) {
            View inflate = this.F.inflate(R$layout.order_detail_project_seat_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_order_seat_seat);
            TextView textView2 = (TextView) inflate.findViewById(R$id.tv_order_seat_no);
            TextView textView3 = (TextView) inflate.findViewById(R$id.tv_taopiao);
            TextView textView4 = (TextView) inflate.findViewById(R$id.tv_order_seat_price);
            if (TextUtils.isEmpty(orderDetailSeatBean.area)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(orderDetailSeatBean.area);
            }
            textView2.setText(orderDetailSeatBean.seatNo);
            if (TextUtils.isEmpty(orderDetailSeatBean.combineTicketId)) {
                c2 = 0;
            } else if (!this.M.containsKey(orderDetailSeatBean.combineTicketId)) {
                this.M.put(orderDetailSeatBean.combineTicketId, Integer.valueOf(i2));
                c2 = 1;
            } else {
                c2 = 2;
            }
            if (c2 == 0) {
                textView4.setText("¥" + orderDetailSeatBean.price);
                textView3.setVisibility(8);
            } else if (c2 == 1) {
                textView3.setVisibility(0);
                textView3.setText(TextUtils.isEmpty(orderDetailSeatBean.seatTypeDesc) ? "套票" : orderDetailSeatBean.seatTypeDesc);
                textView4.setText("¥" + orderDetailSeatBean.price);
            } else if (c2 == 2) {
                textView4.setText("");
                textView3.setVisibility(4);
            }
            this.t.addView(inflate);
        }
    }

    public void t(String str, OrderDetailMecItemInfo orderDetailMecItemInfo, PurchaseNotice purchaseNotice, OrderDetailStatusBean orderDetailStatusBean, boolean z2, String str2, String str3, String str4, boolean z3, boolean z4, String str5, boolean z5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891279737")) {
            ipChange.ipc$dispatch("891279737", new Object[]{this, str, orderDetailMecItemInfo, purchaseNotice, orderDetailStatusBean, Boolean.valueOf(z2), str2, str3, str4, Boolean.valueOf(z3), Boolean.valueOf(z4), str5, Boolean.valueOf(z5)});
        } else if (orderDetailMecItemInfo != null) {
            A(orderDetailMecItemInfo, orderDetailStatusBean, str, str4);
            this.J = z5;
            F(orderDetailMecItemInfo.itemFeatureTags);
            B(purchaseNotice);
            L(orderDetailMecItemInfo.showTimeRangeDetail);
            this.v.setVisibility(8);
            this.s.setVisibility(8);
            C(orderDetailMecItemInfo.skuInfo);
            I(orderDetailMecItemInfo.seatList);
            this.z.d(this.D, z2, str2, str4, str, str3, z3);
            this.A.a(this.D, str5, str);
            this.B.a(this.D, z4, str);
        }
    }
}
