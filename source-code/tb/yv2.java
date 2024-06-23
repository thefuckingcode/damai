package tb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import com.alibaba.android.ultron.vfw.R$id;
import com.alibaba.android.ultron.vfw.downgrade.IDowngradeSupport;
import com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class yv2 {
    public static final int EMPTY_VIEW_TYPE = -1;
    private HashMap<String, IViewHolderProvider> a = new HashMap<>();
    private Map<IViewHolderProvider, Set<Integer>> b = new HashMap();
    private Map<IViewHolderProvider, Integer> c = new HashMap();
    private zg1 d;
    private wv2 e;
    private Set<Integer> f = new HashSet();
    private ComponentLifecycleCallback g;

    public yv2(wv2 wv2) {
        this.e = wv2;
        h();
    }

    private Boolean e(IDMComponent iDMComponent) {
        ArrayMap<String, Object> extMap = iDMComponent.getExtMap();
        if (extMap == null) {
            return Boolean.FALSE;
        }
        Object obj = extMap.get(IDowngradeSupport.KEY_DOWNGRADE_STATE);
        if (obj == null || !(obj instanceof Boolean)) {
            return Boolean.FALSE;
        }
        return (Boolean) obj;
    }

    private IViewHolderProvider g(int i) {
        for (IViewHolderProvider iViewHolderProvider : this.b.keySet()) {
            if (this.b.get(iViewHolderProvider).contains(Integer.valueOf(i))) {
                return iViewHolderProvider;
            }
        }
        return null;
    }

    private void h() {
        a(v00.DB_NAME, new p80(this.e));
        zg1 zg1 = new zg1(this.e);
        this.d = zg1;
        a("native", zg1);
        IViewHolderProvider gz2 = new gz2(this.e);
        a("weex", gz2);
        a("h5", gz2);
    }

    private void j(IViewHolderProvider iViewHolderProvider, int i) {
        Set<Integer> set = this.b.get(iViewHolderProvider);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(i));
            this.b.put(iViewHolderProvider, hashSet);
            return;
        }
        set.add(Integer.valueOf(i));
    }

    public void a(String str, IViewHolderProvider iViewHolderProvider) {
        this.a.put(str, iViewHolderProvider);
        Map<IViewHolderProvider, Integer> map = this.c;
        map.put(iViewHolderProvider, Integer.valueOf(map.size() * 1000));
    }

    public void b(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        if (iDMComponent != null) {
            if (iDMComponent.getStatus() == 0) {
                recyclerViewHolder.itemView.setVisibility(8);
                View view = recyclerViewHolder.itemView;
                int i = R$id.view_holder_origin_height;
                if (view.getTag(i) == null) {
                    if (recyclerViewHolder.itemView.getLayoutParams() != null) {
                        View view2 = recyclerViewHolder.itemView;
                        view2.setTag(i, Integer.valueOf(view2.getLayoutParams().height));
                    } else {
                        recyclerViewHolder.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                        recyclerViewHolder.itemView.setTag(i, -2);
                    }
                }
                recyclerViewHolder.itemView.getLayoutParams().height = 0;
                return;
            }
            recyclerViewHolder.itemView.setVisibility(0);
            Object tag = recyclerViewHolder.itemView.getTag(R$id.view_holder_origin_height);
            if (recyclerViewHolder.itemView.getLayoutParams() != null && (tag instanceof Integer)) {
                recyclerViewHolder.itemView.getLayoutParams().height = ((Integer) tag).intValue();
            }
            if (e(iDMComponent).booleanValue()) {
                this.d.bindData(recyclerViewHolder, iDMComponent);
            } else {
                IViewHolderProvider iViewHolderProvider = this.a.get(iDMComponent.getContainerType());
                if (iViewHolderProvider != null) {
                    iViewHolderProvider.bindData(recyclerViewHolder, iDMComponent);
                }
            }
            ComponentLifecycleCallback componentLifecycleCallback = this.g;
            if (componentLifecycleCallback != null) {
                componentLifecycleCallback.onBindData(recyclerViewHolder, iDMComponent, null);
            }
        }
    }

    public RecyclerViewHolder c(ViewGroup viewGroup, int i) {
        DXTemplateItem f2;
        DXTemplateItem f3;
        IDowngradeSupport iDowngradeSupport = (IDowngradeSupport) this.e.getService(IDowngradeSupport.class);
        IViewHolderProvider g2 = g(i);
        int intValue = i - this.c.get(g2).intValue();
        if (g2 == null) {
            View a2 = jw2.a(this.e.l());
            ComponentLifecycleCallback componentLifecycleCallback = this.g;
            if (componentLifecycleCallback != null) {
                componentLifecycleCallback.onCreateViewHolder(viewGroup, i, null);
            }
            return new RecyclerViewHolder(a2);
        } else if (this.f.contains(Integer.valueOf(i)) && iDowngradeSupport != null && (f3 = ((p80) g2).f(intValue)) != null) {
            return iDowngradeSupport.downgradeViewHolder(viewGroup, sj2.b(f3));
        } else {
            RecyclerViewHolder createViewHolder = g2.createViewHolder(viewGroup, intValue);
            if (createViewHolder.b()) {
                this.f.add(Integer.valueOf(i));
                if (!(iDowngradeSupport == null || (f2 = ((p80) g2).f(intValue)) == null)) {
                    return iDowngradeSupport.downgradeViewHolder(viewGroup, sj2.b(f2));
                }
            }
            return createViewHolder;
        }
    }

    public void d() {
        HashMap<String, IViewHolderProvider> hashMap = this.a;
        if (hashMap != null) {
            for (IViewHolderProvider iViewHolderProvider : hashMap.values()) {
                if (iViewHolderProvider != null) {
                    iViewHolderProvider.destroy();
                }
            }
        }
    }

    public int f(IDMComponent iDMComponent) {
        IViewHolderProvider iViewHolderProvider;
        if (iDMComponent == null || TextUtils.isEmpty(iDMComponent.getType()) || TextUtils.isEmpty(iDMComponent.getContainerType()) || (iViewHolderProvider = this.a.get(iDMComponent.getContainerType())) == null) {
            return -1;
        }
        int itemViewType = iViewHolderProvider.getItemViewType(iDMComponent) + this.c.get(iViewHolderProvider).intValue();
        j(iViewHolderProvider, itemViewType);
        return itemViewType;
    }

    public void i(String str, IViewHolderCreator iViewHolderCreator) {
        this.d.b(str, iViewHolderCreator);
    }

    public void k(ComponentLifecycleCallback componentLifecycleCallback) {
        this.g = componentLifecycleCallback;
    }
}
