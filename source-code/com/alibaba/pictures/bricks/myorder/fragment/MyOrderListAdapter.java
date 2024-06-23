package com.alibaba.pictures.bricks.myorder.fragment;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.tm1;

/* compiled from: Taobao */
public final class MyOrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private ArrayList<JSONObject> b = new ArrayList<>();
    @Nullable
    private JSONObject c;

    public MyOrderListAdapter(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
    }

    public final void a(@Nullable List<? extends JSONObject> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-860740138")) {
            ipChange.ipc$dispatch("-860740138", new Object[]{this, list});
            return;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final void b(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314857026")) {
            ipChange.ipc$dispatch("1314857026", new Object[]{this, jSONObject});
            return;
        }
        this.c = jSONObject;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1320394681")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1320394681", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1172185234")) {
            return super.getItemViewType(i);
        }
        return ((Integer) ipChange.ipc$dispatch("-1172185234", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "242330706")) {
            ipChange.ipc$dispatch("242330706", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(viewHolder, "holder");
        JSONObject jSONObject = this.b.get(i);
        k21.h(jSONObject, "dataList[position]");
        JSONObject jSONObject2 = jSONObject;
        if (viewHolder instanceof NativeGaiaXViewHolder) {
            ((NativeGaiaXViewHolder) viewHolder).d("damai", tm1.TEMPLATE_ID, "", (float) DeviceInfoProviderProxy.getWindowWidth(), i, jSONObject2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888849948")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1888849948", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        return new NativeGaiaXViewHolder(this.a, new tm1(this.a, this.c));
    }

    public final void setData(@Nullable List<? extends JSONObject> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "843266293")) {
            ipChange.ipc$dispatch("843266293", new Object[]{this, list});
            return;
        }
        this.b.clear();
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.b.addAll(list);
        }
        notifyDataSetChanged();
    }
}
