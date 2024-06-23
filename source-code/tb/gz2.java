package tb;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.ultron.vfw.web.c;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class gz2 implements IViewHolderProvider {
    private wv2 a;
    private int b = 0;
    private HashMap<String, Integer> c = new HashMap<>();
    private HashMap<Integer, String> d = new HashMap<>();
    private List<WeakReference<c>> e = new ArrayList();

    public gz2(wv2 wv2) {
        this.a = wv2;
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
        c cVar = new c(this.a, this.d.get(Integer.valueOf(i)));
        cVar.b(viewGroup);
        this.e.add(new WeakReference<>(cVar));
        return new RecyclerViewHolder(cVar.c(), cVar);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
        List<WeakReference<c>> list = this.e;
        if (!(list == null || list.isEmpty())) {
            for (WeakReference<c> weakReference : this.e) {
                if (!(weakReference == null || weakReference.get() == null)) {
                    weakReference.get().g();
                }
            }
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        if (iDMComponent == null || iDMComponent.getContainerInfo() == null) {
            return -1;
        }
        String string = iDMComponent.getContainerInfo().getString("url");
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        if (this.c.containsKey(string)) {
            return this.c.get(string).intValue();
        }
        int i = this.b + 1;
        this.b = i;
        this.c.put(string, Integer.valueOf(i));
        this.d.put(Integer.valueOf(this.b), string);
        return this.b;
    }
}
