package tb;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.trade.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class bm1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(bm1 bm1, String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1928548376")) {
                ipChange.ipc$dispatch("-1928548376", new Object[]{this, view});
                return;
            }
            c.e().x(ln2.r().p1(this.a));
            br.c(mm1.NOTIFY_CANCEL_SELL, "");
        }
    }

    public bm1(View view) {
        TextView textView = (TextView) view.findViewById(R$id.tv_cancel_sell);
        this.a = textView;
        textView.setVisibility(8);
    }

    public void a(Context context, boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585565093")) {
            ipChange.ipc$dispatch("-585565093", new Object[]{this, context, Boolean.valueOf(z), str});
        } else if (context == null || !z) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
            this.a.setOnClickListener(new a(this, str));
        }
    }
}
