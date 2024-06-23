package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectLineViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a = this.itemView.findViewById(R$id.line);

    public ProjectLineViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_line_layout, viewGroup, false));
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "177754934")) {
            ipChange.ipc$dispatch("177754934", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            boolean isShowLine = projectDataHolder.isShowLine();
            View view = this.a;
            if (!isShowLine) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }
}
