package cn.damai.homepage.ui.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.a;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;
import tb.ad;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class ContentPopTipPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private View b;
    private TabExtraBean c;
    private View.OnClickListener d;
    private Runnable e;

    public ContentPopTipPanel(Activity activity, View.OnClickListener onClickListener) {
        this.d = onClickListener;
        View findViewById = activity.findViewById(R$id.homepage_pop_content_tip_layout);
        this.b = findViewById;
        this.a = (TextView) findViewById.findViewById(R$id.homepage_pop_content_tip_tv);
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setBackground(new ad(n42.a(xs0.a(), 4.0f), Color.parseColor("#FF3DAE"), Color.parseColor("#FF7F60"), 0));
        }
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176493588")) {
            ipChange.ipc$dispatch("-1176493588", new Object[]{this});
            return;
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
        this.b.setVisibility(8);
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1505749659")) {
            return this.b.getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1505749659", new Object[]{this})).booleanValue();
    }

    public void d(TabExtraBean tabExtraBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "240121265")) {
            ipChange.ipc$dispatch("240121265", new Object[]{this, tabExtraBean});
            return;
        }
        try {
            this.c = tabExtraBean;
            if (tabExtraBean == null) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setOnClickListener(this);
            this.b.setVisibility(0);
            this.a.setText(tabExtraBean.msg);
            List<TabItem> e2 = a.e();
            DisplayMetrics b2 = n42.b(xs0.a());
            this.b.measure(View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b2), Integer.MIN_VALUE));
            int measuredWidth = this.b.getMeasuredWidth();
            int size = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2) / e2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= e2.size()) {
                    i2 = 0;
                    break;
                } else if (TextUtils.equals("2", e2.get(i2).type)) {
                    break;
                } else {
                    i2++;
                }
            }
            int i3 = ((size / 2) + (i2 * size)) - (measuredWidth / 2);
            if (i3 >= 0) {
                i = i3;
            }
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i;
            }
            this.b.requestLayout();
            AnonymousClass1 r8 = new Runnable() {
                /* class cn.damai.homepage.ui.view.ContentPopTipPanel.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "495824839")) {
                        ipChange.ipc$dispatch("495824839", new Object[]{this});
                        return;
                    }
                    ContentPopTipPanel.this.b.setVisibility(8);
                }
            };
            this.e = r8;
            this.b.postDelayed(r8, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501162492")) {
            ipChange.ipc$dispatch("501162492", new Object[]{this, view});
        } else if (this.c != null && this.d != null) {
            b();
            this.d.onClick(view);
        }
    }
}
