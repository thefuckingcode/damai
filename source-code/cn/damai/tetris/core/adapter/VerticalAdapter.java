package cn.damai.tetris.core.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.holder.AbsViewHolder;
import cn.damai.tetris.core.holder.BaseViewHolder;
import cn.damai.tetris.core.holder.IViewHolderFactory;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.n91;
import tb.w9;
import tb.wl;

/* compiled from: Taobao */
public class VerticalAdapter extends AbsAdapter<BaseViewHolder, List<BaseLayer>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "VerticalAdapter";
    private List<BaseLayer> c;
    private RecyclerView.Adapter<BaseViewHolder> d;

    public VerticalAdapter(w9 w9Var, IViewHolderFactory iViewHolderFactory) {
        super(w9Var, iViewHolderFactory);
    }

    @Override // cn.damai.tetris.core.adapter.AbsAdapter
    public void c(RecyclerView.Adapter<BaseViewHolder> adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141334086")) {
            ipChange.ipc$dispatch("2141334086", new Object[]{this, adapter});
            return;
        }
        n91.a(TAG, "setExtendAdapter ");
        this.d = adapter;
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public void a(List<BaseLayer> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706146327")) {
            ipChange.ipc$dispatch("1706146327", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            List<BaseLayer> list2 = this.c;
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.c = list;
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: e */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-405722952")) {
            ipChange.ipc$dispatch("-405722952", new Object[]{this, baseViewHolder, Integer.valueOf(i)});
            return;
        }
        n91.a(TAG, "onBindViewHolder : position " + i);
        if (i >= getRealCount() || !(baseViewHolder instanceof AbsViewHolder)) {
            int realCount = i - getRealCount();
            this.d.onBindViewHolder(baseViewHolder, realCount);
            n91.a(TAG, "onBindViewHolder : extendAdapter.onBindViewHolder, realPos: " + realCount);
            return;
        }
        AbsViewHolder absViewHolder = (AbsViewHolder) baseViewHolder;
        BaseLayer baseLayer = this.c.get(i);
        BaseSection firstSection = baseLayer.getFirstSection();
        if (absViewHolder.b() == null || firstSection == null) {
            absViewHolder.c(baseLayer);
            return;
        }
        n91.a(TAG, "onBindViewHolder : absViewHolder.getPreseneter() " + absViewHolder.b());
        absViewHolder.c(baseLayer);
        firstSection.setOffset(i);
        absViewHolder.b().createModel(firstSection);
        absViewHolder.b().init();
    }

    @NonNull
    /* renamed from: f */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403038018")) {
            return (BaseViewHolder) ipChange.ipc$dispatch("-403038018", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        n91.a(TAG, "onCreateViewHolder : viewType " + i);
        if (i < 50000) {
            return this.b.createHolder(i, viewGroup, this.a);
        }
        return this.d.onCreateViewHolder(viewGroup, i - VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1058990758")) {
            return ((Integer) ipChange.ipc$dispatch("1058990758", new Object[]{this})).intValue();
        }
        RecyclerView.Adapter<BaseViewHolder> adapter = this.d;
        if (adapter != null) {
            i = adapter.getItemCount();
        }
        int realCount = getRealCount() + i;
        n91.a(TAG, "getItemCount : total " + realCount);
        return realCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394990515")) {
            return ((Integer) ipChange.ipc$dispatch("-1394990515", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        n91.a(TAG, "getItemViewType : " + i);
        if (i < getRealCount()) {
            BaseLayer baseLayer = this.c.get(i);
            if (baseLayer == null) {
                return super.getItemViewType(i);
            }
            if (baseLayer.getFirstSection() == null) {
                return 1;
            }
            int d2 = wl.c(this.a.getActivity()).d(baseLayer.getFirstSection().getComponentId());
            n91.a(TAG, "getItemViewType : " + i + ", return : " + d2);
            return d2;
        } else if (i - getRealCount() < this.d.getItemCount()) {
            int itemViewType = this.d.getItemViewType(i) + VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
            n91.a(TAG, "getItemViewType : " + i + ", extendAdapter return : " + itemViewType);
            return itemViewType;
        } else {
            n91.a(TAG, "getItemViewType : " + i + ", return 0 ;");
            return 0;
        }
    }

    public int getRealCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703743025")) {
            return ((Integer) ipChange.ipc$dispatch("1703743025", new Object[]{this})).intValue();
        }
        List<BaseLayer> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: setData */
    public void b(List<BaseLayer> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884814538")) {
            ipChange.ipc$dispatch("-884814538", new Object[]{this, list});
            return;
        }
        n91.a(TAG, "setData ");
        this.c = list;
        notifyDataSetChanged();
    }
}
