package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

/* compiled from: Taobao */
public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
    public SingleRefDBInnerIter(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Override // java.util.Iterator, com.huawei.hms.common.data.DBInnerIter
    public T next() {
        if (!hasNext()) {
            return null;
        }
        int i = this.index + 1;
        this.index = i;
        if (i == 0) {
            Preconditions.checkState(this.dataBuffer.get(0) instanceof DataBufferRef, "DataBuffer reference of type " + this.dataBuffer.get(0).getClass() + " is not movable");
            this.dataBuffer.get(0).getWindowIndex(this.index);
        }
        return this.dataBuffer.get(0);
    }
}
