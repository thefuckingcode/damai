package com.alibaba.android.ultron.vfw.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;
import tb.am2;
import tb.jw2;
import tb.wv2;
import tb.yv2;

/* compiled from: Taobao */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> implements IAdapter {
    private wv2 a;
    private List<IDMComponent> b = new ArrayList();
    private yv2 c;

    public RecyclerViewAdapter(wv2 wv2) {
        this.a = wv2;
        this.c = (yv2) wv2.getService(yv2.class);
    }

    /* renamed from: a */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        String str;
        am2.e("RecyclerViewBindView", "onBind start");
        IDMComponent iDMComponent = this.b.get(i);
        this.c.b(recyclerViewHolder, iDMComponent);
        if (iDMComponent != null) {
            JSONObject containerInfo = iDMComponent.getContainerInfo();
            String simpleName = recyclerViewHolder.c() != null ? recyclerViewHolder.c().getClass().getSimpleName() : "null";
            if (containerInfo != null) {
                str = containerInfo.getString("name");
            } else {
                str = "native-" + simpleName;
            }
        } else {
            str = "";
        }
        am2.a("RecyclerViewBindView", "onBind end, " + str);
    }

    /* renamed from: b */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (-1 == i) {
            return new RecyclerViewHolder(jw2.a(this.a.l()));
        }
        am2.e("RecyclerViewCreateView", "createView start");
        RecyclerViewHolder c2 = this.c.c(viewGroup, i);
        am2.a("RecyclerViewCreateView", "createView end, viewtype: " + i);
        return c2;
    }

    @Override // com.alibaba.android.ultron.vfw.adapter.IAdapter
    public List<IDMComponent> getData() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<IDMComponent> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.f(this.b.get(i));
    }

    @Override // com.alibaba.android.ultron.vfw.adapter.IAdapter
    public void setData(List<IDMComponent> list) {
        if (list != null) {
            this.b.clear();
            this.b.addAll(list);
        }
    }
}
