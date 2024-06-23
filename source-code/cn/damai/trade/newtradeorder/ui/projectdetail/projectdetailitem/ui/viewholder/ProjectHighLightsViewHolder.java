package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectHighLightsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.high_lights_content_tv));

    public ProjectHighLightsViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_high_lights_layout, viewGroup, false));
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499623521")) {
            ipChange.ipc$dispatch("499623521", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.a.setText(projectDataHolder.getHighLightContent());
        }
    }
}
