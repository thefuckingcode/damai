package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.c62;
import tb.gr;

/* compiled from: Taobao */
public class BrandOptimizationViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] a = {R$id.mine_brand_project_1, R$id.mine_brand_project_2, R$id.mine_brand_project_3};
    private Context b;
    private String c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-774918511")) {
                ipChange.ipc$dispatch("-774918511", new Object[]{this, view});
            } else if (view.getTag() instanceof BrandOptimizationDO) {
                BrandOptimizationDO brandOptimizationDO = (BrandOptimizationDO) view.getTag();
                c.e().x(c62.C().o(BrandOptimizationViewHolder.this.c, "", brandOptimizationDO.id, brandOptimizationDO.type, this.a));
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, brandOptimizationDO.id);
                DMNav.from(BrandOptimizationViewHolder.this.b).withExtras(bundle).toUri(gr.a());
            }
        }
    }

    public BrandOptimizationViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_brand_list, (ViewGroup) null));
        this.b = context;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        for (int i = 0; i < 3; i++) {
            View findViewById = this.itemView.findViewById(this.a[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(new a(i));
            }
        }
    }

    private void e(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965722109")) {
            ipChange.ipc$dispatch("-965722109", new Object[]{this, view, Integer.valueOf(i), str});
            return;
        }
        ((TextView) view.findViewById(i)).setText(str);
    }

    public void c(View view, BrandOptimizationDO brandOptimizationDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41289792")) {
            ipChange.ipc$dispatch("-41289792", new Object[]{this, view, brandOptimizationDO});
        } else if (brandOptimizationDO != null) {
            e(view, R$id.brand_you_proj_memo, brandOptimizationDO.lable);
            e(view, R$id.brand_you_proj_title, brandOptimizationDO.itemName);
            brandOptimizationDO.updatePosterView((DMPosterView) view.findViewById(R$id.poster));
        }
    }

    public void d(List<BrandOptimizationDO> list, String str) {
        BrandOptimizationDO brandOptimizationDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126418559")) {
            ipChange.ipc$dispatch("-126418559", new Object[]{this, list, str});
            return;
        }
        this.c = str;
        for (int i = 0; i < 3; i++) {
            View findViewById = this.itemView.findViewById(this.a[i]);
            if (!(findViewById == null || list.get(i) == null || (brandOptimizationDO = list.get(i)) == null)) {
                findViewById.setTag(brandOptimizationDO);
                c(findViewById, brandOptimizationDO);
            }
        }
    }
}
