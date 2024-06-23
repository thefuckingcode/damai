package cn.damai.comment.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.holder.CommentEmptyViewHolder;
import cn.damai.comment.holder.CommentTitleViewHolder;
import cn.damai.comment.view.DMCommentTitleView;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.fk;
import tb.xf2;

/* compiled from: Taobao */
public class CommentDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<fk> a;
    private DamaiBaseActivity b;
    private EvaluateItemDataBinder c;

    public CommentDetailAdapter(DamaiBaseActivity damaiBaseActivity) {
        this.b = damaiBaseActivity;
        EvaluateItemDataBinder evaluateItemDataBinder = new EvaluateItemDataBinder(damaiBaseActivity);
        this.c = evaluateItemDataBinder;
        evaluateItemDataBinder.q(1);
    }

    private void b(CommentTitleViewHolder commentTitleViewHolder, fk fkVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104647247")) {
            ipChange.ipc$dispatch("1104647247", new Object[]{this, commentTitleViewHolder, fkVar});
            return;
        }
        String b2 = fkVar.b();
        View view = commentTitleViewHolder.itemView;
        if (view instanceof DMCommentTitleView) {
            ((DMCommentTitleView) view).setData(b2);
        }
    }

    public void a(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771404240")) {
            ipChange.ipc$dispatch("771404240", new Object[]{this, list});
            return;
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void c(List<fk> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055996049")) {
            ipChange.ipc$dispatch("2055996049", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public void d(EvaluateItemDataBinder.EvaluateItemUTReportListener evaluateItemUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638880428")) {
            ipChange.ipc$dispatch("638880428", new Object[]{this, evaluateItemUTReportListener});
            return;
        }
        this.c.r(evaluateItemUTReportListener);
    }

    public void e(EvaluateItemDataBinder.EvaluateItemOtherListener evaluateItemOtherListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950021597")) {
            ipChange.ipc$dispatch("950021597", new Object[]{this, evaluateItemOtherListener});
            return;
        }
        this.c.s(evaluateItemOtherListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-103621644")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-103621644", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "511229083")) {
            return this.a.get(i).j();
        }
        return ((Integer) ipChange.ipc$dispatch("511229083", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494059653")) {
            ipChange.ipc$dispatch("494059653", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        fk fkVar = this.a.get(i);
        if (fkVar != null) {
            int j = fkVar.j();
            if (j == 1) {
                b((CommentTitleViewHolder) viewHolder, fkVar);
            } else if (j == 2 || j == 3) {
                this.c.i((EvaluateItemViewHolder) viewHolder, fkVar, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206793489")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("206793489", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 1) {
            return new CommentTitleViewHolder(this.b);
        } else {
            if (i == 2 || i == 3) {
                return new EvaluateItemViewHolder(this.b);
            }
            if (i != 4) {
                return null;
            }
            return new CommentEmptyViewHolder(this.b);
        }
    }
}
