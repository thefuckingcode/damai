package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.home.widget.banner.sub.RoundRadiusImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.s50;
import tb.xs0;

/* compiled from: Taobao */
public class CircleCardViewHolder extends BaseViewHolderV2<CircleBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView c;
    private final TextView d;
    private LinearLayout e;
    private final RoundRadiusImageView f;
    private final ImageView g;
    private final int h = n42.a(xs0.a(), 35.0f);
    private OnItemBindListener<CircleBean> i;

    public CircleCardViewHolder(ViewGroup viewGroup, OnItemBindListener<CircleBean> onItemBindListener) {
        super(LayoutInflater.from(xs0.a()).inflate(R$layout.item_circle_card, viewGroup, false));
        n42.a(xs0.a(), 14.0f);
        this.i = onItemBindListener;
        this.e = (LinearLayout) this.itemView.findViewById(R$id.circle_card_layout);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_circle_title);
        this.d = (TextView) this.itemView.findViewById(R$id.tv_circle_sub);
        this.f = (RoundRadiusImageView) this.itemView.findViewById(R$id.iv_circle_pic);
        this.g = (ImageView) this.itemView.findViewById(R$id.iv_circle_action_icon);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void c(CircleBean circleBean, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2058045549")) {
            ipChange.ipc$dispatch("2058045549", new Object[]{this, circleBean, Integer.valueOf(i2)});
        } else if (circleBean != null) {
            int a = DisplayMetrics.getwidthPixels(s50.b(xs0.a())) - s50.a(xs0.a(), 36.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = a / 2;
            if (i2 == 0 || i2 == 1) {
                layoutParams.leftMargin = s50.a(xs0.a(), 12.0f);
            } else {
                layoutParams.leftMargin = s50.a(xs0.a(), 0.0f);
            }
            String str = "";
            this.c.setText(TextUtils.isEmpty(circleBean.name) ? str : circleBean.name);
            TextView textView = this.d;
            if (!TextUtils.isEmpty(circleBean.dynamicEffect)) {
                str = circleBean.dynamicEffect;
            }
            textView.setText(str);
            a b = a.b();
            String str2 = circleBean.headImage;
            int i4 = this.h;
            b.f(str2, i4, i4).g(this.f);
            ImageView imageView = this.g;
            if (!circleBean.hasActivity) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            this.itemView.setOnClickListener(this);
            this.i.exposeItem(this.itemView, circleBean, i2);
        }
    }

    public void onClick(View view) {
        OnItemBindListener<CircleBean> onItemBindListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035011704")) {
            ipChange.ipc$dispatch("1035011704", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t != null && (onItemBindListener = this.i) != null) {
            onItemBindListener.onItemClick(t, this.b);
        }
    }
}
