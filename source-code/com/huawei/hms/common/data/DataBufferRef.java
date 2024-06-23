package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* compiled from: Taobao */
public class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int windowIndex;

    public DataBufferRef(DataHolder dataHolder, int i) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i);
    }

    /* access modifiers changed from: protected */
    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.windowIndex, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataBufferRef)) {
            return false;
        }
        DataBufferRef dataBufferRef = (DataBufferRef) obj;
        if (dataBufferRef.mDataRow == this.mDataRow && dataBufferRef.windowIndex == this.windowIndex && dataBufferRef.mDataHolder == this.mDataHolder) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getDataRow() {
        return this.mDataRow;
    }

    /* access modifiers changed from: protected */
    public double getDouble(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((Double) value).doubleValue();
        }
        return -1.0d;
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((Float) value).floatValue();
        }
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_INT);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_LONG);
        if (value != null) {
            return ((Long) value).longValue();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
        return value != null ? (String) value : "";
    }

    /* access modifiers changed from: protected */
    public final void getWindowIndex(int i) {
        Preconditions.checkArgument(i >= 0 && i < this.mDataHolder.getCount(), "rowNum is out of index");
        this.mDataRow = i;
        this.windowIndex = this.mDataHolder.getWindowIndex(i);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    /* access modifiers changed from: protected */
    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.windowIndex);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.windowIndex), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    /* access modifiers changed from: protected */
    public Uri parseUri(String str) {
        String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
