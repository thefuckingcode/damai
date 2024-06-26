package cn.damai.commonbusiness.rank;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m42;
import tb.v50;

/* compiled from: Taobao */
public class CommonRankHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMPosterView a = ((DMPosterView) this.itemView.findViewById(R$id.poster));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_title));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.tv_subtitle));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_see_people_num));
    private TextView e = ((TextView) this.itemView.findViewById(R$id.tv_project_num));
    private TextView f = ((TextView) this.itemView.findViewById(R$id.btn_go));
    private Context g;

    public CommonRankHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.common_rank_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = layoutInflater.getContext();
    }

    public void a(RankItemBean rankItemBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199180105")) {
            ipChange.ipc$dispatch("-199180105", new Object[]{this, rankItemBean});
        } else if (rankItemBean != null) {
            this.a.setImageUrl(rankItemBean.pic);
            int i = rankItemBean.type;
            if (i == 1) {
                this.a.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
                this.a.getLabelView().setLabelName("1");
                this.a.getLabelView().setCornerRadii((float) m42.a(this.g, 16.0f), (float) m42.a(this.g, 16.0f), (float) m42.a(this.g, 16.0f), (float) m42.a(this.g, 2.0f));
                this.a.getLabelView().setLabelHeight(m42.a(this.g, 32.0f));
                this.a.getLabelView().setLabelWidth(m42.a(this.g, 32.0f));
                this.a.getLabelView().setLabelTextSize(24.0f);
                this.a.getLabelView().setBgColor("#FF5A5A", "#FF42B0");
                this.a.setCategoryTagName("榜单");
            } else if (i == 2) {
                this.a.setLabelType(null);
                this.a.setCategoryTagName("麦单");
            }
            this.b.setText(rankItemBean.shortName);
            this.c.setText(rankItemBean.shortDesc);
            this.d.setText(rankItemBean.followDesc);
            if (TextUtils.isEmpty(rankItemBean.count)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                if (TextUtils.isEmpty(rankItemBean.followDesc)) {
                    str = rankItemBean.count;
                } else {
                    str = " | " + rankItemBean.count;
                }
                this.e.setText(str);
            }
            if (TextUtils.isEmpty(rankItemBean.statusName)) {
                this.f.setText("去看看");
                this.f.setBackgroundResource(R$drawable.common_rank_btn_bg);
                this.f.setTextColor(Color.parseColor("#ffffff"));
                return;
            }
            this.f.setText(rankItemBean.statusName);
            if (rankItemBean.statusName.contains("失效") || rankItemBean.statusName.contains("下架")) {
                this.f.setBackgroundResource(R$drawable.common_rank_grey_bg);
                this.f.setTextColor(Color.parseColor("#666666"));
                return;
            }
            this.f.setBackgroundResource(R$drawable.common_rank_btn_bg);
            this.f.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479893609")) {
            ipChange.ipc$dispatch("-479893609", new Object[]{this});
            return;
        }
        this.itemView.findViewById(R$id.innear_bg_ll).setBackgroundResource(R$drawable.common_rank_bg_channel);
        View view = this.itemView;
        int i = R$id.innear_bg_parent;
        view.findViewById(i).setBackgroundColor(Color.parseColor("#F5F6F7"));
        int a2 = v50.a(this.g, 9.0f);
        this.itemView.findViewById(i).setPadding(a2, a2, a2, 0);
    }

    public CommonRankHolder(View view) {
        super(view);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = view.getContext();
    }
}
