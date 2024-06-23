package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.viewholder.ImgTicketWrap;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.girl.mvp.HWRatioLayout;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ax0;
import tb.gr;
import tb.if2;
import tb.l71;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class WaterFlowThemeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private HWRatioLayout a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private Context f;
    private View g;
    private View h;
    private View i;
    private String j;
    private View k;
    private StrokeLinearLayout l;
    public ThemeBean m;
    private int n;
    private int o;
    private int p;
    private View.OnClickListener q = new a();
    private int[] r = {Color.parseColor("#00000000"), Color.parseColor("#0a000000"), Color.parseColor("#1c000000"), Color.parseColor("#35000000"), Color.parseColor("#54000000"), Color.parseColor("#75000000"), Color.parseColor("#99000000"), Color.parseColor("#bc000000"), Color.parseColor("#dd000000"), Color.parseColor("#ff000000")};

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1002742287")) {
                ipChange.ipc$dispatch("-1002742287", new Object[]{this, view});
                return;
            }
            ThemeBean themeBean = (ThemeBean) view.getTag();
            if (themeBean != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", themeBean.id);
                DMNav.from(WaterFlowThemeViewHolder.this.f).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_THEME));
                ax0.I().Q(themeBean.id, themeBean.pos);
            }
        }
    }

    public WaterFlowThemeViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_theme, (ViewGroup) null));
        this.j = str;
        this.f = context;
        this.b = (ImageView) this.itemView.findViewById(R$id.theme_img);
        this.c = (TextView) this.itemView.findViewById(R$id.theme_title);
        this.d = (TextView) this.itemView.findViewById(R$id.theme_watch_info);
        this.a = (HWRatioLayout) this.itemView.findViewById(R$id.theme_img_hw_ratio_layout);
        this.e = this.itemView.findViewById(R$id.theme_price_tag);
        this.h = this.itemView.findViewById(R$id.bottom_end_layout);
        this.g = this.itemView.findViewById(R$id.bottom_top_shader);
        this.i = this.itemView.findViewById(R$id.bottom_bg_layout);
        this.k = this.itemView.findViewById(R$id.video_icon);
        this.l = (StrokeLinearLayout) this.itemView.findViewById(R$id.theme_img_hw_stroke_layout);
        this.p = n42.a(xs0.a(), 6.0f);
        this.n = n42.a(xs0.a(), 3.0f);
        this.o = n42.a(xs0.a(), 3.0f);
        this.itemView.setOnClickListener(this.q);
    }

    private Drawable c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319293863")) {
            return (Drawable) ipChange.ipc$dispatch("1319293863", new Object[]{this});
        }
        l71 l71 = new l71();
        l71.b(this.r, null);
        return l71;
    }

    public void b(WaterFlowRecommendItem waterFlowRecommendItem, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-627418773")) {
            ipChange.ipc$dispatch("-627418773", new Object[]{this, waterFlowRecommendItem, Integer.valueOf(i2)});
        } else if (waterFlowRecommendItem != null) {
            ThemeBean themeBean = waterFlowRecommendItem.themeCard;
            this.m = themeBean;
            themeBean.pos = i2;
            if (themeBean != null) {
                float f2 = themeBean.hwRatio;
                if (f2 > 0.0f) {
                    this.a.setHwRatio(f2);
                } else {
                    this.a.setHwRatio(1.0f);
                }
                this.itemView.setTag(this.m);
                if (this.m.highLight) {
                    this.g.setBackground(null);
                    this.i.setBackgroundResource(R$drawable.icon_theme_bg);
                    this.h.setBackgroundColor(0);
                    StrokeLinearLayout strokeLinearLayout = this.l;
                    int i4 = this.n;
                    strokeLinearLayout.setPadding(i4, i4, i4, i4);
                    this.l.setCornerAndStroke(this.p, this.o, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
                } else {
                    this.g.setBackground(c());
                    this.i.setBackground(null);
                    this.h.setBackgroundColor(-16777216);
                    this.l.setPadding(0, 0, 0, 0);
                    this.l.setCornerAndStroke(this.p, 1, Color.parseColor("#26000000"));
                }
                this.k.setVisibility(this.m.isShowVideoIcon() ? 0 : 8);
                ImgTicketWrap.c(this.b, this.m.pic, R$drawable.uikit_default_image_bg_gradient_v2, null);
                Context context = this.itemView.getContext();
                if (context == null) {
                    this.c.setText(this.m.name);
                } else {
                    this.c.setText(if2.b(context, R$drawable.icon_theme_title_prefix, this.m.name));
                }
                ThemeBean themeBean2 = this.m;
                String a2 = if2.a(themeBean2.contentCount, themeBean2.ipvuv);
                this.d.setTextColor(Color.parseColor("#99FFFFFF"));
                this.d.setText(a2);
                View view = this.e;
                if (!this.m.hasPrize()) {
                    i3 = 8;
                }
                view.setVisibility(i3);
                ax0 I = ax0.I();
                View view2 = this.itemView;
                String str = this.j;
                String str2 = waterFlowRecommendItem.projectId;
                ThemeBean themeBean3 = this.m;
                I.V(view2, str, str2, "", themeBean3.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", "", "", waterFlowRecommendItem.index, themeBean3.id, "theme");
            }
        }
    }
}
