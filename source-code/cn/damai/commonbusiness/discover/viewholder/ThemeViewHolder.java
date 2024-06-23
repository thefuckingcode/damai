package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.lazyimg.ImgLoader;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.girl.mvp.HWRatioLayout;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.if2;
import tb.ih0;
import tb.l71;
import tb.m01;
import tb.n01;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class ThemeViewHolder extends BaseViewHolder<ThemeBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private HWRatioLayout a;
    private GifCareImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private StrokeLinearLayout j;
    public ThemeBean k;
    public int l;
    private int m;
    private int n;
    private int o;
    private int[] p;
    private OnItemClickListener<ThemeBean> q;
    private ImgLoader r;
    private n01 s;

    /* compiled from: Taobao */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-624602718")) {
                ipChange.ipc$dispatch("-624602718", new Object[]{this, view});
                return;
            }
            ThemeViewHolder.this.r = m01.a(view);
            ThemeViewHolder.this.f();
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1175713183")) {
                ipChange.ipc$dispatch("1175713183", new Object[]{this, view});
            }
        }
    }

    public ThemeViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<ThemeBean> onItemClickListener) {
        this(BaseViewHolder.b(context, viewGroup, R$layout.item_discover_feed_theme), onItemClickListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        n01 n01;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45240922")) {
            ipChange.ipc$dispatch("-45240922", new Object[]{this});
            return;
        }
        ImgLoader imgLoader = this.r;
        if (imgLoader != null && (n01 = this.s) != null) {
            imgLoader.a(n01);
            this.s = null;
        }
    }

    private Drawable g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705611100")) {
            return (Drawable) ipChange.ipc$dispatch("-1705611100", new Object[]{this});
        }
        l71 l71 = new l71();
        l71.b(this.p, null);
        return l71;
    }

    /* renamed from: e */
    public void a(ThemeBean themeBean, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1033471223")) {
            ipChange.ipc$dispatch("-1033471223", new Object[]{this, themeBean, Integer.valueOf(i2)});
            return;
        }
        this.k = themeBean;
        this.l = i2;
        float f2 = themeBean.hwRatio;
        if (f2 > 0.0f) {
            this.a.setHwRatio(f2);
        } else {
            this.a.setHwRatio(1.0f);
        }
        if (themeBean.highLight) {
            this.f.setBackground(null);
            this.h.setBackgroundResource(R$drawable.icon_theme_bg);
            this.g.setBackgroundColor(0);
            StrokeLinearLayout strokeLinearLayout = this.j;
            int i4 = this.m;
            strokeLinearLayout.setPadding(i4, i4, i4, i4);
            this.j.setCornerAndStroke(this.o, this.n, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
        } else {
            this.f.setBackground(g());
            this.h.setBackground(null);
            this.g.setBackgroundColor(-16777216);
            this.j.setPadding(0, 0, 0, 0);
            this.j.setCornerAndStroke(this.o, 1, Color.parseColor("#26000000"));
        }
        this.i.setVisibility(themeBean.isShowVideoIcon() ? 0 : 8);
        this.s = new ih0(this.b, themeBean.pic);
        f();
        Context context = this.itemView.getContext();
        if (context == null) {
            this.c.setText(themeBean.name);
        } else {
            this.c.setText(if2.b(context, R$drawable.icon_theme_title_prefix, themeBean.name));
        }
        String a2 = if2.a(themeBean.contentCount, themeBean.ipvuv);
        this.d.setTextColor(Color.parseColor("#99FFFFFF"));
        this.d.setText(a2);
        View view = this.e;
        if (!themeBean.hasPrize()) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.itemView.setOnClickListener(this);
    }

    public void onClick(View view) {
        ThemeBean themeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884405511")) {
            ipChange.ipc$dispatch("884405511", new Object[]{this, view});
            return;
        }
        OnItemClickListener<ThemeBean> onItemClickListener = this.q;
        if (onItemClickListener != null && (themeBean = this.k) != null) {
            onItemClickListener.onItemClick(themeBean, this.l);
        }
    }

    public ThemeViewHolder(View view, OnItemClickListener<ThemeBean> onItemClickListener) {
        super(view);
        this.p = new int[]{Color.parseColor("#00000000"), Color.parseColor("#0a000000"), Color.parseColor("#1c000000"), Color.parseColor("#35000000"), Color.parseColor("#54000000"), Color.parseColor("#75000000"), Color.parseColor("#99000000"), Color.parseColor("#bc000000"), Color.parseColor("#dd000000"), Color.parseColor("#ff000000")};
        view.addOnAttachStateChangeListener(new a());
        this.q = onItemClickListener;
        this.b = (GifCareImageView) view.findViewById(R$id.theme_img);
        this.c = (TextView) view.findViewById(R$id.theme_title);
        this.d = (TextView) view.findViewById(R$id.theme_watch_info);
        this.a = (HWRatioLayout) view.findViewById(R$id.theme_img_hw_ratio_layout);
        this.e = view.findViewById(R$id.theme_price_tag);
        this.g = view.findViewById(R$id.bottom_end_layout);
        this.f = view.findViewById(R$id.bottom_top_shader);
        this.h = view.findViewById(R$id.bottom_bg_layout);
        this.i = view.findViewById(R$id.video_icon);
        this.j = (StrokeLinearLayout) view.findViewById(R$id.theme_img_hw_stroke_layout);
        this.o = n42.a(xs0.a(), 6.0f);
        this.m = n42.a(xs0.a(), 3.0f);
        this.n = n42.a(xs0.a(), 3.0f);
    }
}
