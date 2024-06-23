package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.trade.R$id;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundPopWindowBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.br;
import tb.d20;
import tb.g91;
import tb.ln2;
import tb.mm1;
import tb.v20;
import tb.v50;

/* compiled from: Taobao */
public class OrderDetailRefundView {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private LinearLayout b;
    private Context c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        a(OrderDetailRefundView orderDetailRefundView, String str, boolean z, String str2, Context context) {
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = context;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1696086388")) {
                ipChange.ipc$dispatch("1696086388", new Object[]{this, view});
                return;
            }
            c.e().x(ln2.r().F(this.a));
            if (this.b) {
                br.c(mm1.REFUND_CHECK_SERVICE, this.c);
                return;
            }
            Context context = this.d;
            if (context != null) {
                mm1.k(context, this.c);
            }
        }
    }

    public OrderDetailRefundView(Context context, View view) {
        this.c = context;
        this.b = (LinearLayout) view.findViewById(R$id.ll_tv_refund);
        this.a = (TextView) view.findViewById(R$id.tv_refund);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.tv_refund_icon);
        this.b.setVisibility(8);
    }

    private void c(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211273098")) {
            ipChange.ipc$dispatch("211273098", new Object[]{this, str});
            return;
        }
        this.a.post(new Runnable() {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailRefundView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "197643739")) {
                    ipChange.ipc$dispatch("197643739", new Object[]{this});
                    return;
                }
                int[] iArr = new int[2];
                OrderDetailRefundView.this.b.getLocationOnScreen(iArr);
                float f = (float) iArr[1];
                int i = iArr[0];
                g91.b("OrderDetailRefundView", "showPop y = " + f);
                float a = f + ((float) v50.a(OrderDetailRefundView.this.c, 27.0f));
                OrderDetailRefundPopWindowBean orderDetailRefundPopWindowBean = new OrderDetailRefundPopWindowBean();
                orderDetailRefundPopWindowBean.content = str;
                orderDetailRefundPopWindowBean.parent = OrderDetailRefundView.this.b;
                orderDetailRefundPopWindowBean.xlocation = (int) ((float) (DisplayMetrics.getwidthPixels(v50.b(OrderDetailRefundView.this.c)) - v50.a(OrderDetailRefundView.this.c, 15.0f)));
                orderDetailRefundPopWindowBean.ylocation = (int) a;
                br.c(OrderDetailActivity.REFUND_POPWINDPW, orderDetailRefundPopWindowBean);
            }
        });
    }

    public void d(Context context, boolean z, String str, String str2, String str3, String str4, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422079339")) {
            ipChange.ipc$dispatch("-1422079339", new Object[]{this, context, Boolean.valueOf(z), str, str2, str3, str4, Boolean.valueOf(z2)});
        } else if (!z || TextUtils.isEmpty(str)) {
            this.b.setVisibility(8);
        } else {
            this.a.setText(str4);
            this.b.setVisibility(0);
            this.a.setOnClickListener(new a(this, str3, z2, str, context));
            if (mm1.c(str2)) {
                d20.T(OrderDetailActivity.REFUND_POPWINDPW, v20.a("yyyyMMdd"));
                c(str2);
            }
        }
    }
}
