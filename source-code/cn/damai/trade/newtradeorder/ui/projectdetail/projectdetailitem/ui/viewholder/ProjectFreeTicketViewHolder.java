package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectFreeTicketBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;

/* compiled from: Taobao */
public class ProjectFreeTicketViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView a;
    private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_title));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.tv_subtitle));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_goto_see));
    private Context e;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnRecommendItemClickListener a;

        a(ProjectFreeTicketViewHolder projectFreeTicketViewHolder, OnRecommendItemClickListener onRecommendItemClickListener) {
            this.a = onRecommendItemClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1460320883")) {
                ipChange.ipc$dispatch("1460320883", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            OnRecommendItemClickListener onRecommendItemClickListener = this.a;
            if (onRecommendItemClickListener != null) {
                onRecommendItemClickListener.onRecommendItemClick(intValue);
            }
        }
    }

    public ProjectFreeTicketViewHolder(Context context, ViewGroup viewGroup, OnRecommendItemClickListener onRecommendItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_free_ticket_layout, viewGroup, false));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.e = context;
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(R$id.image_item1);
        this.a = roundImageView;
        roundImageView.setBorderRadius(6);
        this.itemView.setOnClickListener(new a(this, onRecommendItemClickListener));
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640526950")) {
            ipChange.ipc$dispatch("-640526950", new Object[]{this, projectDataHolder});
            return;
        }
        ProjectFreeTicketBean recommendFreeTicketItem = projectDataHolder.getRecommendFreeTicketItem();
        if (recommendFreeTicketItem != null) {
            this.itemView.setTag(Integer.valueOf(projectDataHolder.getRecommendItemPosition()));
            cn.damai.common.image.a.b().f(recommendFreeTicketItem.cover, n42.a(this.e, 90.0f), n42.a(this.e, 120.0f)).c(R$drawable.uikit_default_image_bg_gradient).g(this.a);
            this.b.setText(recommendFreeTicketItem.title);
            this.c.setText(recommendFreeTicketItem.tip);
            this.d.setText(recommendFreeTicketItem.button);
        }
    }
}
