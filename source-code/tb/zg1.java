package tb;

import android.util.Pair;
import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class zg1 implements IViewHolderProvider {
    private wv2 a;
    private int b = 0;
    private Map<String, Pair<IViewHolderCreator, Integer>> c = new HashMap();
    private Map<Integer, String> d = new HashMap();

    public zg1(wv2 wv2) {
        this.a = wv2;
    }

    private RecyclerViewHolder a(ViewGroup viewGroup, String str) {
        if (str == null) {
            return new RecyclerViewHolder(jw2.a(this.a.l()), null);
        }
        h1 create = ((IViewHolderCreator) this.c.get(str).first).create(this.a);
        create.b(viewGroup);
        return new RecyclerViewHolder(create.c(), create);
    }

    public void b(String str, IViewHolderCreator iViewHolderCreator) {
        int i;
        if (!this.c.containsKey(str)) {
            i = this.b;
            this.b = i + 1;
            this.c.put(str, new Pair<>(iViewHolderCreator, Integer.valueOf(i)));
        } else {
            i = ((Integer) this.c.get(str).second).intValue();
        }
        this.d.put(Integer.valueOf(i), str);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void bindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        h1 c2 = recyclerViewHolder.c();
        if (c2 != null) {
            c2.a(iDMComponent);
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public RecyclerViewHolder createViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, this.d.get(Integer.valueOf(i)));
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        if (this.c.containsKey(iDMComponent.getType())) {
            return ((Integer) this.c.get(iDMComponent.getType()).second).intValue();
        }
        return -1;
    }
}
