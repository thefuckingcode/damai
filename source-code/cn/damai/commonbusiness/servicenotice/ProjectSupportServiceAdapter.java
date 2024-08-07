package cn.damai.commonbusiness.servicenotice;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class ProjectSupportServiceAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<T> b;
    private ArrayList<IdCardTypes> c;

    public ProjectSupportServiceAdapter(Context context, List<T> list) {
        this.a = context;
        this.b = list;
    }

    public void a(ArrayList<IdCardTypes> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934548319")) {
            ipChange.ipc$dispatch("-1934548319", new Object[]{this, arrayList});
            return;
        }
        this.c = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1039561789")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("1039561789", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "524625564")) {
            ipChange.ipc$dispatch("524625564", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        T t = this.b.get(i);
        if (t instanceof ServiceNote) {
            ProjectSupportServiceViewHolder projectSupportServiceViewHolder = (ProjectSupportServiceViewHolder) viewHolder;
            T t2 = t;
            if (i == getItemCount() - 1) {
                z = true;
            }
            projectSupportServiceViewHolder.e(t2, z);
        } else if (t instanceof TicketNote) {
            ProjectSupportServiceViewHolder projectSupportServiceViewHolder2 = (ProjectSupportServiceViewHolder) viewHolder;
            T t3 = t;
            if (i == getItemCount() - 1) {
                z = true;
            }
            projectSupportServiceViewHolder2.f(t3, z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476462298")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("476462298", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        ProjectSupportServiceViewHolder projectSupportServiceViewHolder = new ProjectSupportServiceViewHolder(this.a, viewGroup);
        ArrayList<IdCardTypes> arrayList = this.c;
        if (arrayList != null) {
            projectSupportServiceViewHolder.k(arrayList);
        }
        return projectSupportServiceViewHolder;
    }
}
