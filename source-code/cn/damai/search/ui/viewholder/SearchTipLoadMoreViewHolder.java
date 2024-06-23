package cn.damai.search.ui.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchTipLoadMoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View.OnClickListener a;

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "419452350")) {
            ipChange.ipc$dispatch("419452350", new Object[]{this, view});
            return;
        }
        View.OnClickListener onClickListener = this.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
