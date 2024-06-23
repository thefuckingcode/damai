package cn.damai.category.grab.ui.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GrabTitleHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_title));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_subtitle));

    public GrabTitleHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.grab_project_title, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.itemView.getContext();
    }

    public void a(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939205672")) {
            ipChange.ipc$dispatch("-939205672", new Object[]{this, itemBean});
        } else if (itemBean != null) {
            this.a.setText(itemBean.groupTitle);
            if (itemBean.group == 1) {
                this.a.setTextSize(1, 24.0f);
            } else {
                this.a.setTextSize(1, 20.0f);
            }
            this.b.setText(itemBean.groupTip);
        }
    }
}
