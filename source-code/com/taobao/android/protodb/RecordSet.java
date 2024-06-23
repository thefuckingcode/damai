package com.taobao.android.protodb;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class RecordSet extends NativeBridgedObject {
    public RecordSet(long j) {
        super(j);
    }

    @Keep
    private native long nativeGetRecord();

    @Keep
    private native boolean nativeNext();

    public Record getRecord() {
        long nativeGetRecord = nativeGetRecord();
        if (nativeGetRecord > 0) {
            return new Record(nativeGetRecord);
        }
        return null;
    }

    public boolean next() {
        return nativeNext();
    }
}
