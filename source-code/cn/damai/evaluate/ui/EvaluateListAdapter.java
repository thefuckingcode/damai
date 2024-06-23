package cn.damai.evaluate.ui;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.item.EvaluateBottomViewHolder;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.fk;

/* compiled from: Taobao */
public class EvaluateListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMENT_TYPE_COMMENT_BOTTOM = 2;
    public static final int COMMENT_TYPE_COMMENT_ITEM = 0;
    public static final int COMMENT_TYPE_COMMENT_TITLE = 1;
    private DamaiBaseActivity a;
    private List<fk> b = new ArrayList();
    private EvaluateItemDataBinder c;
    private EvaluateListCallBack d;

    public EvaluateListAdapter(DamaiBaseActivity damaiBaseActivity, String str, int i) {
        this.a = damaiBaseActivity;
        EvaluateItemDataBinder evaluateItemDataBinder = new EvaluateItemDataBinder(damaiBaseActivity, str, i);
        this.c = evaluateItemDataBinder;
        evaluateItemDataBinder.u(true);
    }

    public void a(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783262051")) {
            ipChange.ipc$dispatch("1783262051", new Object[]{this, list});
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void b(EvaluateListCallBack evaluateListCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964805617")) {
            ipChange.ipc$dispatch("-1964805617", new Object[]{this, evaluateListCallBack});
            return;
        }
        this.d = evaluateListCallBack;
    }

    public void c(EvaluateItemDataBinder.EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187988242")) {
            ipChange.ipc$dispatch("187988242", new Object[]{this, evaluateItemUTReportListener});
            return;
        }
        this.c.r(evaluateItemUTReportListener);
    }

    public void d(EvaluateItemDataBinder.SimpleItemClickListener simpleItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440175678")) {
            ipChange.ipc$dispatch("-440175678", new Object[]{this, simpleItemClickListener});
            return;
        }
        EvaluateItemDataBinder evaluateItemDataBinder = this.c;
        if (evaluateItemDataBinder != null) {
            evaluateItemDataBinder.f = simpleItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1032327386")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1032327386", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763511937")) {
            return this.b.get(i).j();
        }
        return ((Integer) ipChange.ipc$dispatch("1763511937", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246037537")) {
            ipChange.ipc$dispatch("-246037537", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        fk fkVar = this.b.get(i);
        if (fkVar != null && fkVar.j() == 0) {
            this.c.i((EvaluateItemViewHolder) viewHolder, fkVar, i);
            if (this.d != null && fkVar.a() != null) {
                this.d.setItemExposure(viewHolder.itemView, i, fkVar.a().getCommentId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144272137")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-2144272137", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 0) {
            return new EvaluateItemViewHolder(this.a);
        } else {
            if (i != 2) {
                return new EvaluateItemViewHolder(this.a);
            }
            return new EvaluateBottomViewHolder(this.a);
        }
    }

    public void setData(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-807698814")) {
            ipChange.ipc$dispatch("-807698814", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
