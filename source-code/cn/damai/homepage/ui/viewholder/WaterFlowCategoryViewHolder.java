package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.resource.widget.YKActionSheet;
import java.util.List;
import tb.ax0;
import tb.gr;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class WaterFlowCategoryViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private Context b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private LinearLayout g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private LinearLayout k;
    private TextView l;
    private View.OnClickListener m = new a();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "963977734")) {
                ipChange.ipc$dispatch("963977734", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            int id = view.getId();
            if (id == R$id.homepage_waterflow_category_first_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(0);
            } else if (id == R$id.homepage_waterflow_category_second_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(1);
            } else if (id == R$id.homepage_waterflow_category_third_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(2);
            } else {
                str = id == R$id.homepage_waterflow_category_fourth_keyword_layout ? waterFlowRecommendItem.hotwords.get(3) : "";
            }
            c.e().x(ax0.I().N(WaterFlowCategoryViewHolder.this.a, str, "", waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", "", "", waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, "", ""));
            Bundle bundle = new Bundle();
            bundle.putString("autowords", str);
            bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
            bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
            bundle.putString("keyType", "home_feed");
            DMNav.from(WaterFlowCategoryViewHolder.this.b).withExtras(bundle).toUri(NavUri.b(gr.o));
        }
    }

    public WaterFlowCategoryViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_category, (ViewGroup) null));
        this.b = context;
        this.a = str;
        this.c = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_title);
        this.d = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_subtitle);
        this.e = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_first_keyword_layout);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_first_keyword);
        this.g = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_second_keyword_layout);
        this.h = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_second_keyword);
        this.i = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_third_keyword_layout);
        this.j = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_third_keyword);
        this.k = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_fourth_keyword_layout);
        this.l = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_fourth_keyword);
        this.e.setOnClickListener(this.m);
        this.g.setOnClickListener(this.m);
        this.i.setOnClickListener(this.m);
        this.k.setOnClickListener(this.m);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, ((int) (((double) (((float) ((((DisplayMetrics.getwidthPixels(v50.b(context)) - v50.a(context, 30.0f)) / 2) - v50.a(context, 12.0f)) * 233)) * 1.0f)) / 160.5d)) + v50.a(context, 20.0f)));
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674738851")) {
            ipChange.ipc$dispatch("1674738851", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            this.c.setText(waterFlowRecommendItem.title);
            this.d.setText(waterFlowRecommendItem.subTitle);
            List<String> list = waterFlowRecommendItem.hotwords;
            int e2 = xf2.e(list);
            for (int i2 = 0; i2 < e2; i2++) {
                if (TextUtils.isEmpty(list.get(0))) {
                    list.remove(i2);
                }
            }
            String str = "";
            int e3 = xf2.e(list);
            if (e3 >= 1) {
                this.e.setVisibility(0);
                this.f.setText(list.get(0));
                this.e.setTag(waterFlowRecommendItem);
                str = str + list.get(0);
            }
            if (e3 >= 2) {
                this.g.setVisibility(0);
                this.h.setText(list.get(1));
                this.g.setTag(waterFlowRecommendItem);
                str = (str + "&") + list.get(1);
            }
            if (e3 >= 3) {
                this.i.setVisibility(0);
                this.j.setText(list.get(2));
                this.i.setTag(waterFlowRecommendItem);
                str = (str + "&") + list.get(2);
            } else {
                this.i.setVisibility(8);
            }
            if (e3 >= 4) {
                this.k.setVisibility(0);
                this.l.setText(list.get(3));
                this.k.setTag(waterFlowRecommendItem);
                str = (str + "&") + list.get(3);
            } else {
                this.k.setVisibility(8);
            }
            ax0.I().V(this.itemView, this.a, str, "", waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", "", "", waterFlowRecommendItem.index, "", "");
        }
    }
}
