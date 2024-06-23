package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ta;
import tb.v50;

/* compiled from: Taobao */
public class ProjectRecommendViewHolder extends ProjectItemViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context E;
    private OnRecommendItemClickListener F;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public a(int i, ProjectItemBean projectItemBean) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282839114")) {
                ipChange.ipc$dispatch("1282839114", new Object[]{this, view});
            } else if (ProjectRecommendViewHolder.this.F != null) {
                ProjectRecommendViewHolder.this.F.onRecommendItemClick(this.a);
            }
        }
    }

    public ProjectRecommendViewHolder(Context context, OnRecommendItemClickListener onRecommendItemClickListener, ViewGroup viewGroup) {
        super(context, LayoutInflater.from(context));
        this.E = context;
        this.F = onRecommendItemClickListener;
    }

    private void E(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974655297")) {
            ipChange.ipc$dispatch("-974655297", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", projectItemBean.id);
        hashMap.put("titlelabel", projectItemBean.name);
        hashMap.put("alg", projectItemBean.alg);
        c e = c.e();
        View view = this.itemView;
        e.G(view, "item_" + i, "rec", ta.PROJECT_PAGE, hashMap);
    }

    private void F(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965550231")) {
            ipChange.ipc$dispatch("965550231", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i == 0) {
            j().setVisibility(8);
        } else {
            j().setVisibility(0);
        }
        if (i == i2 - 1) {
            View view = this.itemView;
            view.setPadding(view.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), v50.a(this.E, 32.0f));
            return;
        }
        View view2 = this.itemView;
        view2.setPadding(view2.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), v50.a(this.E, 18.0f));
    }

    public void D(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982289320")) {
            ipChange.ipc$dispatch("-982289320", new Object[]{this, projectDataHolder});
            return;
        }
        ProjectItemBean recommendItem = projectDataHolder.getRecommendItem();
        int recommendItemPosition = projectDataHolder.getRecommendItemPosition();
        if (recommendItem != null) {
            this.itemView.setTag(recommendItem);
            this.itemView.setOnClickListener(new a(recommendItemPosition, recommendItem));
            E(recommendItem, recommendItemPosition);
            k(recommendItem);
            F(recommendItemPosition, projectDataHolder.getRecommendListSize());
        }
    }
}
