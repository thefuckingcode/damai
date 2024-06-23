package cn.damai.uikit.wheel.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
public interface WheelViewAdapter {
    View getEmptyItem(View view, ViewGroup viewGroup);

    View getItem(int i, View view, ViewGroup viewGroup);

    int getItemsCount();

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
