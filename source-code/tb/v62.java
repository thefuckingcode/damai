package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.util.ToastUtil;
import cn.damai.seat.R$id;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class v62 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b = ((TextView) this.a.findViewById(R$id.seat_confirm_order));
    private View c;
    private View d = this.a.findViewById(R$id.empty_seat_layout);
    private View e = this.a.findViewById(R$id.layout_seat_total_price);
    private TextView f = ((TextView) this.a.findViewById(R$id.order_promotion_tv));
    private DMIconFontTextView g = ((DMIconFontTextView) this.a.findViewById(R$id.choose_arrow_ift));
    private TextView h = ((TextView) this.a.findViewById(R$id.total_price));
    private ViewGroup i = ((ViewGroup) this.a.findViewById(R$id.layout_seat_num));
    private TextView j = ((TextView) this.a.findViewById(R$id.tv_select_seat_num));

    public v62(Activity activity, View view) {
        this.a = view;
        this.c = view.findViewById(R$id.layout_seat_price_and_num);
        this.a.setOnClickListener(this);
    }

    @Deprecated
    public void a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597834356")) {
            ipChange.ipc$dispatch("-597834356", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public abstract void b();

    public abstract void c();

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156410288")) {
            ipChange.ipc$dispatch("-156410288", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g.setText(!z ? R$string.iconfont_shaixuanxia12 : R$string.iconfont_shaixuanshang12);
        }
    }

    public void e(PriceBarInfo priceBarInfo) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-800233135")) {
            ipChange.ipc$dispatch("-800233135", new Object[]{this, priceBarInfo});
        } else if (priceBarInfo != null) {
            if (!TextUtils.isEmpty(priceBarInfo.toastMsg)) {
                ToastUtil.i(priceBarInfo.toastMsg);
            }
            v62 v62 = null;
            float f2 = 1.0f;
            if (priceBarInfo.isPayFirstV2) {
                this.c.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setText(priceBarInfo.tipSpanV2);
                TextView textView = this.b;
                if (!priceBarInfo.clickableV2) {
                    f2 = 0.6f;
                }
                textView.setAlpha(f2);
                TextView textView2 = this.b;
                if (priceBarInfo.clickableV2) {
                    v62 = this;
                }
                textView2.setOnClickListener(v62);
                return;
            }
            this.c.setVisibility(0);
            this.i.setVisibility(8);
            boolean z = priceBarInfo.clickableV2;
            this.d.setVisibility(z ? 8 : 0);
            View view = this.e;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
            if (z) {
                s72.g(this.f, priceBarInfo.tipMsgV2);
                String str = priceBarInfo.totalPriceTextV2;
                if (!TextUtils.isEmpty(str)) {
                    str = str.replaceAll("¥", "");
                }
                this.h.setText(str);
            }
            TextView textView3 = this.b;
            if (!z) {
                f2 = 0.5f;
            }
            textView3.setAlpha(f2);
            TextView textView4 = this.b;
            if (z) {
                v62 = this;
            }
            textView4.setOnClickListener(v62);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344174680")) {
            ipChange.ipc$dispatch("-344174680", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (!s72.c()) {
            if (id == R$id.seat_confirm_order) {
                b();
            } else if (id == R$id.seat_jpg_bottom_bar) {
                c();
            }
        }
    }
}
