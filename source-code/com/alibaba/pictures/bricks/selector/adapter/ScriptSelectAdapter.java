package com.alibaba.pictures.bricks.selector.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.view.ScriptViewHolder;
import com.alibaba.pictures.bricks.selector.view.ShopViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j52;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    @Nullable
    private OnEventListener b;
    @NotNull
    private ArrayList<ScriptSelectMo> c = new ArrayList<>();
    @Nullable
    private String d;
    @Nullable
    private String e;
    @NotNull
    private a f = new a(this);

    /* compiled from: Taobao */
    public static final class a implements OnEventListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptSelectAdapter a;

        a(ScriptSelectAdapter scriptSelectAdapter) {
            this.a = scriptSelectAdapter;
        }

        @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
        public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
            String str2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-314131542")) {
                ipChange.ipc$dispatch("-314131542", new Object[]{this, str, view, obj});
                return;
            }
            k21.i(str, "eventId");
            if (k21.d(str, ScriptSelectFragment.EVENT_ID_ITEM_SELECT)) {
                if ((obj instanceof ScriptSelectMo ? (ScriptSelectMo) obj : null) != null) {
                    ScriptSelectAdapter scriptSelectAdapter = this.a;
                    ScriptSelectMo scriptSelectMo = (ScriptSelectMo) obj;
                    if (k21.d(scriptSelectAdapter.d(), scriptSelectMo.getTargetId())) {
                        str2 = null;
                    } else {
                        str2 = scriptSelectMo.getTargetId();
                    }
                    scriptSelectAdapter.g(str2);
                    scriptSelectAdapter.notifyDataSetChanged();
                    j52.INSTANCE.c(view, scriptSelectMo.getTargetId(), scriptSelectAdapter.c());
                }
                OnEventListener onEventListener = this.a.b;
                if (onEventListener != null) {
                    if (this.a.d() == null) {
                        obj = null;
                    }
                    onEventListener.onEvent(str, view, obj);
                }
            }
        }
    }

    public ScriptSelectAdapter(int i, @Nullable OnEventListener onEventListener) {
        this.a = i;
        this.b = onEventListener;
    }

    public final void b(@Nullable ArrayList<ScriptSelectMo> arrayList) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-863758822")) {
            ipChange.ipc$dispatch("-863758822", new Object[]{this, arrayList});
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.c.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Nullable
    public final String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-23632414")) {
            return this.e;
        }
        return (String) ipChange.ipc$dispatch("-23632414", new Object[]{this});
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-304778453")) {
            return this.d;
        }
        return (String) ipChange.ipc$dispatch("-304778453", new Object[]{this});
    }

    public final void e(@Nullable ArrayList<ScriptSelectMo> arrayList) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "576525787")) {
            ipChange.ipc$dispatch("576525787", new Object[]{this, arrayList});
            return;
        }
        this.c.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.c.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void f(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946108884")) {
            ipChange.ipc$dispatch("1946108884", new Object[]{this, str});
            return;
        }
        this.e = str;
    }

    public final void g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460316397")) {
            ipChange.ipc$dispatch("-460316397", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-837006018")) {
            return this.c.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-837006018", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "828864763")) {
            ipChange.ipc$dispatch("828864763", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        k21.i(viewHolder, "holder");
        ScriptSelectMo scriptSelectMo = this.c.get(i);
        k21.h(scriptSelectMo, "dataList[position]");
        ScriptSelectMo scriptSelectMo2 = scriptSelectMo;
        if (this.d == null || !k21.d(scriptSelectMo2.getTargetId(), this.d)) {
            z = false;
        }
        if (viewHolder instanceof ShopViewHolder) {
            ((ShopViewHolder) viewHolder).b(scriptSelectMo2, this.e, Boolean.valueOf(z));
        } else if (viewHolder instanceof ScriptViewHolder) {
            ScriptSelectMo scriptSelectMo3 = this.c.get(i);
            k21.h(scriptSelectMo3, "dataList[position]");
            ((ScriptViewHolder) viewHolder).b(scriptSelectMo3, this.e, Boolean.valueOf(z));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597373605")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1597373605", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        if (this.a == 0) {
            return ShopViewHolder.Companion.a(viewGroup, this.f);
        }
        return ScriptViewHolder.Companion.a(viewGroup, this.f);
    }
}
