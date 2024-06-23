package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g70;
import tb.ln2;
import tb.n42;
import tb.tb2;

/* compiled from: Taobao */
public class ProjectTourViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private int f;
    private int g;
    private Context h;
    private View.OnClickListener i = new a();
    private String j;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1053370765")) {
                ipChange.ipc$dispatch("-1053370765", new Object[]{this, view});
                return;
            }
            ProjectTour projectTour = (ProjectTour) view.getTag();
            if (projectTour != null && !projectTour.itemId.equals(ProjectTourViewHolder.this.j)) {
                c.e().x(ln2.r().N0(ProjectTourViewHolder.this.j, projectTour.index));
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, projectTour.itemId);
                tb2.a(ProjectTourViewHolder.this.h, projectTour.schema, bundle);
            }
        }
    }

    public ProjectTourViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.project_item_tour_child, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        this.h = context;
        d(this.itemView);
        this.g = n42.a(context, 98.0f);
        this.f = (g70.d() - n42.a(context, 39.0f)) / 2;
    }

    private void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923573806")) {
            ipChange.ipc$dispatch("-923573806", new Object[]{this, view});
            return;
        }
        this.a = (LinearLayout) view.findViewById(R$id.ll_tour);
        this.b = (TextView) view.findViewById(R$id.tv_tour_city);
        this.c = (TextView) view.findViewById(R$id.tv_tour_time);
        this.d = view.findViewById(R$id.v_left);
        this.e = view.findViewById(R$id.v_right);
        this.a.setOnClickListener(this.i);
    }

    public void c(String str, ProjectTour projectTour, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013177208")) {
            ipChange.ipc$dispatch("-1013177208", new Object[]{this, str, projectTour, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (projectTour != null) {
            projectTour.index = i3;
            this.j = str;
            this.a.setTag(projectTour);
            if (TextUtils.isEmpty(str) || !str.equals(projectTour.itemId)) {
                this.a.setBackgroundResource(R$drawable.bg_project_tour_grey);
                this.b.setTextColor(Color.parseColor("#111111"));
            } else {
                this.a.setBackgroundResource(R$drawable.bg_project_tour_red);
                this.b.setTextColor(Color.parseColor("#FF388F"));
            }
            this.b.setText(projectTour.cityName);
            this.c.setText(projectTour.showTime);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            if (i2 == 2) {
                layoutParams.width = this.f;
            } else {
                layoutParams.width = this.g;
            }
            if (i3 == 0) {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            } else if (i3 == i2 - 1) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            }
            this.a.setLayoutParams(layoutParams);
        }
    }
}
