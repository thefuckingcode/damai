package com.alibaba.android.ultron.vfw.adapter;

import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;

/* compiled from: Taobao */
public interface IAdapter {
    List<IDMComponent> getData();

    void notifyDataSetChanged();

    void setData(List<IDMComponent> list);
}
