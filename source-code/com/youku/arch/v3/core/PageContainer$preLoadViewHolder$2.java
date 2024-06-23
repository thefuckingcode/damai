package com.youku.arch.v3.core;

import android.taobao.windvane.connect.api.ApiResponse;
import android.util.Log;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.recyclerview.GenericRecycledViewPool;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageContainer$preLoadViewHolder$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ GenericRecycledViewPool $oneRecycledViewPool;
    final /* synthetic */ SparseArray<List<RecyclerView.ViewHolder>> $stashHoldersMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageContainer$preLoadViewHolder$2(SparseArray<List<RecyclerView.ViewHolder>> sparseArray, GenericRecycledViewPool genericRecycledViewPool) {
        super(0);
        this.$stashHoldersMap = sparseArray;
        this.$oneRecycledViewPool = genericRecycledViewPool;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "978836624")) {
            ipChange.ipc$dispatch("978836624", new Object[]{this});
            return;
        }
        int size = this.$stashHoldersMap.size();
        if (size > 0) {
            while (true) {
                int i2 = i + 1;
                int keyAt = this.$stashHoldersMap.keyAt(i);
                for (RecyclerView.ViewHolder viewHolder : this.$stashHoldersMap.get(keyAt)) {
                    this.$oneRecycledViewPool.putRecycledView(viewHolder);
                }
                if (AppInfoProviderProxy.isDebuggable()) {
                    Log.e("preLoadMVP", "==putRecycledView===type===" + keyAt + "==count==" + this.$stashHoldersMap.get(keyAt).size() + "==getRecycledViewCount==" + this.$oneRecycledViewPool.getRecycledViewCount(keyAt) + "==getMaxSize===" + this.$oneRecycledViewPool.getViewHolderMaxSize(keyAt));
                }
                if (i2 < size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
