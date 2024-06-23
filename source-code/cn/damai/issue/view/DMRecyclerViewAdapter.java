package cn.damai.issue.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.issue.listener.DMOnItemChildCheckedChangeListener;
import cn.damai.issue.listener.DMOnItemChildClickListener;
import cn.damai.issue.listener.DMOnItemChildLongClickListener;
import cn.damai.issue.listener.DMOnRVItemClickListener;
import cn.damai.issue.listener.DMOnRVItemLongClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public abstract class DMRecyclerViewAdapter<M> extends RecyclerView.Adapter<DMRecyclerViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final int a;
    protected Context b;
    protected ArrayList<M> c = new ArrayList<>();
    protected DMOnItemChildClickListener d;
    protected DMOnItemChildLongClickListener e;
    protected DMOnItemChildCheckedChangeListener f;
    protected DMOnRVItemClickListener g;
    protected DMOnRVItemLongClickListener h;
    protected RecyclerView i;

    public DMRecyclerViewAdapter(RecyclerView recyclerView, int i2) {
        this.i = recyclerView;
        this.b = recyclerView.getContext();
        this.a = i2;
    }

    public void a(M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905887904")) {
            ipChange.ipc$dispatch("905887904", new Object[]{this, m});
            return;
        }
        b(0, m);
    }

    public void b(int i2, M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217845999")) {
            ipChange.ipc$dispatch("217845999", new Object[]{this, Integer.valueOf(i2), m});
            return;
        }
        this.c.add(i2, m);
        notifyItemInserted(i2);
    }

    /* access modifiers changed from: protected */
    public abstract void c(DMViewHolderHelper dMViewHolderHelper, int i2, M m);

    public ArrayList<M> d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1971558722")) {
            return this.c;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1971558722", new Object[]{this});
    }

    public void e(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918181726")) {
            ipChange.ipc$dispatch("-1918181726", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        ArrayList<M> arrayList = this.c;
        arrayList.add(i3, arrayList.remove(i2));
        notifyItemMoved(i2, i3);
    }

    /* renamed from: f */
    public void onBindViewHolder(DMRecyclerViewHolder dMRecyclerViewHolder, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558210157")) {
            ipChange.ipc$dispatch("1558210157", new Object[]{this, dMRecyclerViewHolder, Integer.valueOf(i2)});
            return;
        }
        c(dMRecyclerViewHolder.a(), i2, getItem(i2));
    }

    /* renamed from: g */
    public void onBindViewHolder(DMRecyclerViewHolder dMRecyclerViewHolder, int i2, List<Object> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318484318")) {
            ipChange.ipc$dispatch("1318484318", new Object[]{this, dMRecyclerViewHolder, Integer.valueOf(i2), list});
        } else if (list.isEmpty()) {
            onBindViewHolder(dMRecyclerViewHolder, i2);
        } else {
            n(dMRecyclerViewHolder.a(), i2, getItem(i2), list);
        }
    }

    public M getItem(int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1689684310")) {
            return this.c.get(i2);
        }
        return (M) ipChange.ipc$dispatch("-1689684310", new Object[]{this, Integer.valueOf(i2)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1855209075")) {
            return this.c.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1855209075", new Object[]{this})).intValue();
    }

    /* renamed from: h */
    public DMRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377846871")) {
            return (DMRecyclerViewHolder) ipChange.ipc$dispatch("-1377846871", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        DMRecyclerViewHolder dMRecyclerViewHolder = new DMRecyclerViewHolder(this.i, LayoutInflater.from(this.b).inflate(this.a, viewGroup, false), this.g, this.h);
        dMRecyclerViewHolder.a().setOnItemChildClickListener(this.d);
        dMRecyclerViewHolder.a().setOnItemChildLongClickListener(this.e);
        dMRecyclerViewHolder.a().setOnItemChildCheckedChangeListener(this.f);
        k(dMRecyclerViewHolder.a());
        return dMRecyclerViewHolder;
    }

    public void i(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943189900")) {
            ipChange.ipc$dispatch("-1943189900", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.c.remove(i2);
        notifyItemRemoved(i2);
    }

    public void j(ArrayList<M> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384510382")) {
            ipChange.ipc$dispatch("-384510382", new Object[]{this, arrayList});
            return;
        }
        if (arrayList != null) {
            this.c = arrayList;
        } else {
            this.c.clear();
        }
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void k(DMViewHolderHelper dMViewHolderHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811386119")) {
            ipChange.ipc$dispatch("-1811386119", new Object[]{this, dMViewHolderHelper});
        }
    }

    public void l(DMOnItemChildClickListener dMOnItemChildClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053916026")) {
            ipChange.ipc$dispatch("2053916026", new Object[]{this, dMOnItemChildClickListener});
            return;
        }
        this.d = dMOnItemChildClickListener;
    }

    public void m(DMOnRVItemClickListener dMOnRVItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075740716")) {
            ipChange.ipc$dispatch("1075740716", new Object[]{this, dMOnRVItemClickListener});
            return;
        }
        this.g = dMOnRVItemClickListener;
    }

    /* access modifiers changed from: protected */
    public abstract void n(DMViewHolderHelper dMViewHolderHelper, int i2, M m, List<Object> list);
}
