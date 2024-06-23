package cn.damai.tetris.v2.adpater;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.componentplugin.SectionSensitive;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.p3;

/* compiled from: Taobao */
public abstract class VBaseAdapter<T extends ISection, VH extends VBaseViewHolder> extends DelegateAdapter.Adapter<VH> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final Context a;
    protected IContext b;
    protected a c;
    protected List<T> d;
    protected int e;
    protected SectionSensitive f;
    private Map<String, Pair<IModel, ISection>> g = new HashMap();

    public VBaseAdapter(Context context) {
        this.a = context;
    }

    public VBaseAdapter<T, VH> a(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872168320")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-872168320", new Object[]{this, list});
        }
        this.d.addAll(list);
        this.g.clear();
        g(getItemCount() + list.size());
        return this;
    }

    public VBaseAdapter<T, VH> b(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034659072")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1034659072", new Object[]{this, list});
        }
        this.d.addAll(0, list);
        this.g.clear();
        g(getItemCount() + list.size());
        return this;
    }

    public IContext c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "27634571")) {
            return this.b;
        }
        return (IContext) ipChange.ipc$dispatch("27634571", new Object[]{this});
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull VBaseViewHolder vBaseViewHolder, int i) {
        IModel e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905100800")) {
            ipChange.ipc$dispatch("-1905100800", new Object[]{this, vBaseViewHolder, Integer.valueOf(i)});
        } else if (vBaseViewHolder != null) {
            T t = this.d.get(i);
            SectionSensitive sectionSensitive = this.f;
            if (sectionSensitive != null) {
                sectionSensitive.sectionBindViewHolder(t, vBaseViewHolder);
            }
            Map<String, Pair<IModel, ISection>> map = this.g;
            Pair<IModel, ISection> pair = map.get("" + i);
            if (vBaseViewHolder.rebindAble() && vBaseViewHolder.a() != null && pair != null && pair.second == vBaseViewHolder.a()) {
                vBaseViewHolder.c(t);
                vBaseViewHolder.d((IModel) pair.first);
            } else if (this.d != null && (e2 = vBaseViewHolder.e(t)) != null && vBaseViewHolder.rebindAble()) {
                Map<String, Pair<IModel, ISection>> map2 = this.g;
                map2.put("" + i, new Pair<>(e2, t));
            }
        }
    }

    /* renamed from: e */
    public void onViewRecycled(@NonNull VH vh) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1791472645")) {
            ipChange.ipc$dispatch("-1791472645", new Object[]{this, vh});
            return;
        }
        super.onViewRecycled(vh);
        vh.onRecycled();
    }

    public VBaseAdapter<T, VH> f(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999309983")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1999309983", new Object[]{this, list});
        }
        this.d = list;
        this.g.clear();
        return this;
    }

    public VBaseAdapter g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887922419")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1887922419", new Object[]{this, Integer.valueOf(i)});
        }
        this.e = i;
        return this;
    }

    public List<T> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2120136572")) {
            return this.d;
        }
        return (List) ipChange.ipc$dispatch("2120136572", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        String sectionId;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906349360")) {
            return ((Long) ipChange.ipc$dispatch("-1906349360", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        List<T> list = this.d;
        if (list == null || list.size() < i + 1 || (sectionId = this.d.get(i).getSectionId()) == null) {
            return super.getItemId(i);
        }
        return (long) p3.a().b(sectionId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1859753203")) {
            return getData().get(i).getType();
        }
        return ((Integer) ipChange.ipc$dispatch("1859753203", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    public VBaseAdapter h(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247201127")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1247201127", new Object[]{this, aVar});
        }
        this.c = aVar;
        return this;
    }

    public void i(IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321926725")) {
            ipChange.ipc$dispatch("321926725", new Object[]{this, iContext});
            return;
        }
        this.b = iContext;
    }

    public void j(SectionSensitive sectionSensitive) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387800031")) {
            ipChange.ipc$dispatch("-387800031", new Object[]{this, sectionSensitive});
            return;
        }
        this.f = sectionSensitive;
    }

    @Override // com.alibaba.android.vlayout.DelegateAdapter.Adapter
    public a onCreateLayoutHelper() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1822655665")) {
            return this.c;
        }
        return (a) ipChange.ipc$dispatch("1822655665", new Object[]{this});
    }
}
