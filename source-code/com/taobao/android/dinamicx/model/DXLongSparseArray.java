package com.taobao.android.dinamicx.model;

import androidx.collection.LongSparseArray;

/* compiled from: Taobao */
public class DXLongSparseArray<E> extends LongSparseArray<E> {
    public DXLongSparseArray() {
    }

    public void putAll(DXLongSparseArray<E> dXLongSparseArray) {
        if (dXLongSparseArray != null) {
            for (int i = 0; i < dXLongSparseArray.size(); i++) {
                put(dXLongSparseArray.keyAt(i), dXLongSparseArray.valueAt(i));
            }
        }
    }

    public DXLongSparseArray(int i) {
        super(i);
    }

    public DXLongSparseArray(DXLongSparseArray<E> dXLongSparseArray) {
        putAll((DXLongSparseArray) dXLongSparseArray);
    }
}
