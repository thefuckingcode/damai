package cn.damai.launcher.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.search.TimerView;
import cn.damai.homepage.R$id;
import cn.damai.launcher.splash.api.Coupon;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.v50;
import tb.zy2;

/* compiled from: Taobao */
public class CouponViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public ViewGroup a;
    private Context b;
    private TextView c;
    private TextView d = ((TextView) this.a.findViewById(R$id.common_card_top_info));
    private TextView e = ((TextView) this.a.findViewById(R$id.common_card_desc_info));
    private TextView f;
    private RelativeLayout g;
    private RelativeLayout h;
    private View i;
    private TimerView j;
    private View k;
    Coupon l;

    public CouponViewHolder(ViewGroup viewGroup, Context context) {
        this.a = viewGroup;
        this.b = context;
        this.c = (TextView) viewGroup.findViewById(R$id.common_card_top_value);
        TextView textView = (TextView) this.a.findViewById(R$id.common_card_desc_info2);
        this.f = textView;
        textView.setVisibility(0);
        this.g = (RelativeLayout) this.a.findViewById(R$id.rl_guide_left);
        this.h = (RelativeLayout) this.a.findViewById(R$id.rl_guide_right);
        this.i = this.a.findViewById(R$id.guide_coupon_gap);
        TimerView timerView = (TimerView) this.a.findViewById(R$id.common_card_desc_timer);
        this.j = timerView;
        timerView.setVisibility(8);
        View findViewById = this.a.findViewById(R$id.common_card_desc_timer_desc);
        this.k = findViewById;
        findViewById.setVisibility(8);
    }

    public void b(Coupon coupon) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872906892")) {
            ipChange.ipc$dispatch("872906892", new Object[]{this, coupon});
        } else if (coupon != null) {
            this.l = coupon;
            this.c.setText(coupon.decreaseMoneyNum);
            this.d.setText(coupon.overAmountText);
            this.e.setText(coupon.name);
            TextView textView = this.f;
            if (textView != null && (str = coupon.tag) != null) {
                textView.setText(str);
            }
        }
    }

    public void c(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686223874")) {
            ipChange.ipc$dispatch("686223874", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.a.findViewById(R$id.guide_coupon_gapleft).setVisibility(i2);
        this.i.setVisibility(i3);
    }

    public void d(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233357961")) {
            ipChange.ipc$dispatch("-1233357961", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.width = n42.a(this.b, (float) i2);
        layoutParams.height = -1;
        this.g.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
        layoutParams2.width = n42.a(this.b, (float) i3);
        layoutParams2.height = -1;
        this.h.setLayoutParams(layoutParams2);
    }

    public Coupon getCoupon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1619027736")) {
            return this.l;
        }
        return (Coupon) ipChange.ipc$dispatch("-1619027736", new Object[]{this});
    }

    public void setCouponTextLine(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604546390")) {
            ipChange.ipc$dispatch("-1604546390", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d.setMaxLines(i2);
        ViewGroup viewGroup = this.a;
        int i3 = R$id.common_card_top_vv;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.findViewById(i3).getLayoutParams();
        if (i2 == 2) {
            layoutParams.setMargins(0, v50.a(this.b, 5.0f), 0, 0);
        } else {
            layoutParams.setMargins(0, v50.a(this.b, 10.0f), 0, 0);
        }
        this.a.findViewById(i3).setLayoutParams(layoutParams);
    }

    public void setTimer(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210659871")) {
            ipChange.ipc$dispatch("210659871", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.f.setVisibility(8);
        Object tag = this.j.getTag();
        if (tag instanceof zy2) {
            ((zy2) tag).cancel();
            this.j.setTag(null);
        }
        if (j2 > 0) {
            long currentTimeMillis = j2 - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                zy2 zy2 = new zy2(currentTimeMillis, 1000, this.j);
                zy2.start();
                this.j.setTag(zy2);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
            } else {
                this.j.setTimeUp();
            }
        }
        this.j.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            /* class cn.damai.launcher.splash.CouponViewHolder.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onViewAttachedToWindow(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-581777008")) {
                    ipChange.ipc$dispatch("-581777008", new Object[]{this, view});
                }
            }

            public void onViewDetachedFromWindow(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-618452467")) {
                    ipChange.ipc$dispatch("-618452467", new Object[]{this, view});
                    return;
                }
                Object tag = CouponViewHolder.this.j.getTag();
                if (tag instanceof zy2) {
                    ((zy2) tag).cancel();
                    CouponViewHolder.this.j.setTag(null);
                }
            }
        });
    }
}
