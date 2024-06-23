package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.lazyimg.ImgLoader;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import tb.ih0;
import tb.lk1;
import tb.m01;
import tb.n01;

/* compiled from: Taobao */
public class BigThemeViewHolder extends BaseViewHolder<ThemeBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private GifCareImageView a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    public ThemeBean j;
    public int k;
    private OnItemClickListener<ThemeBean> l;
    private ImgLoader m;
    private n01 n;

    /* compiled from: Taobao */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1998266680")) {
                ipChange.ipc$dispatch("-1998266680", new Object[]{this, view});
                return;
            }
            BigThemeViewHolder.this.m = m01.a(view);
            BigThemeViewHolder.this.f();
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-360394427")) {
                ipChange.ipc$dispatch("-360394427", new Object[]{this, view});
            }
        }
    }

    public BigThemeViewHolder(View view, OnItemClickListener<ThemeBean> onItemClickListener) {
        super(view);
        view.addOnAttachStateChangeListener(new a());
        this.l = onItemClickListener;
        this.a = (GifCareImageView) view.findViewById(R$id.theme_img);
        this.b = (TextView) view.findViewById(R$id.theme_title);
        this.c = (TextView) view.findViewById(R$id.theme_des);
        this.d = view.findViewById(R$id.theme_watch_info);
        this.f = (TextView) view.findViewById(R$id.theme_content_num);
        this.g = (TextView) view.findViewById(R$id.theme_content_tip);
        this.e = view.findViewById(R$id.watch_line);
        this.h = (TextView) view.findViewById(R$id.theme_ipvuv_num);
        this.i = (TextView) view.findViewById(R$id.theme_ipvuv_tip);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        n01 n01;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039683532")) {
            ipChange.ipc$dispatch("1039683532", new Object[]{this});
            return;
        }
        ImgLoader imgLoader = this.m;
        if (imgLoader != null && (n01 = this.n) != null) {
            imgLoader.a(n01);
            this.n = null;
        }
    }

    private void h(String str, String str2) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1760972658")) {
            ipChange.ipc$dispatch("1760972658", new Object[]{this, str, str2});
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.d.setVisibility(0);
            this.e.setVisibility((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? 8 : 0);
            this.f.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.i.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            TextView textView = this.h;
            if (TextUtils.isEmpty(str2)) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            String str3 = "";
            this.f.setText(TextUtils.isEmpty(str) ? str3 : g(str));
            TextView textView2 = this.h;
            if (!TextUtils.isEmpty(str2)) {
                str3 = g(str2);
            }
            textView2.setText(str3);
        } else {
            this.d.setVisibility(8);
        }
    }

    /* renamed from: e */
    public void a(ThemeBean themeBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118167389")) {
            ipChange.ipc$dispatch("-1118167389", new Object[]{this, themeBean, Integer.valueOf(i2)});
            return;
        }
        this.j = themeBean;
        this.k = i2;
        this.n = new ih0(this.a, themeBean.pic);
        f();
        this.b.setText(themeBean.name);
        this.c.setText(themeBean.desc);
        h(themeBean.contentCount, themeBean.ipvuv);
        this.itemView.setOnClickListener(this);
    }

    public String g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153248387")) {
            return (String) ipChange.ipc$dispatch("-1153248387", new Object[]{this, str});
        }
        float i2 = lk1.i(str, 0.0f);
        double doubleValue = new BigDecimal((double) (i2 / 10000.0f)).setScale(1, 4).doubleValue();
        if (i2 < 10000.0f) {
            return str;
        }
        return "" + doubleValue + "万";
    }

    public void onClick(View view) {
        ThemeBean themeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423023905")) {
            ipChange.ipc$dispatch("1423023905", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ThemeBean> onItemClickListener = this.l;
        if (onItemClickListener != null && (themeBean = this.j) != null) {
            onItemClickListener.onItemClick(themeBean, this.k);
        }
    }
}
