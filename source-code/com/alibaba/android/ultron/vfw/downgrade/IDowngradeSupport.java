package com.alibaba.android.ultron.vfw.downgrade;

import android.view.ViewGroup;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import tb.mc0;

/* compiled from: Taobao */
public interface IDowngradeSupport {
    public static final String KEY_DOWNGRADE_STATE = "downgrade_state";

    RecyclerViewHolder downgradeViewHolder(ViewGroup viewGroup, mc0 mc0);
}
