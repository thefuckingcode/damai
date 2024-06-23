package cn.damai.tetris.core.adapter;

import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.core.holder.BaseViewHolder;
import cn.damai.tetris.core.holder.IViewHolderFactory;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public abstract class AbsAdapter<A extends BaseViewHolder, T> extends RecyclerView.Adapter<A> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected w9 a;
    protected IViewHolderFactory b;

    public AbsAdapter(w9 w9Var, IViewHolderFactory iViewHolderFactory) {
        this.a = w9Var;
        this.b = iViewHolderFactory;
    }

    public abstract void a(T t);

    public abstract void b(T t);

    public abstract void c(RecyclerView.Adapter<A> adapter);
}
