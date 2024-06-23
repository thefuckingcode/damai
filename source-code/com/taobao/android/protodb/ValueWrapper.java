package com.taobao.android.protodb;

import java.io.Serializable;

/* compiled from: Taobao */
public class ValueWrapper implements Serializable {
    public static final short VALUE_TYPE_BINARY = 6;
    public static final short VALUE_TYPE_DOUBLE = 4;
    public static final short VALUE_TYPE_FLOAT = 3;
    public static final short VALUE_TYPE_INT = 1;
    public static final short VALUE_TYPE_LONG = 2;
    public static final short VALUE_TYPE_STRING = 5;
    public byte[] binaryValue;
    public double doubleValue;
    public float floatValue;
    public int intValue;
    public long longValue;
    public String stringValue;
    private short type;

    static ValueWrapper doubleValue(double d) {
        ValueWrapper valueWrapper = new ValueWrapper();
        valueWrapper.doubleValue = d;
        valueWrapper.type = 4;
        return valueWrapper;
    }

    static ValueWrapper floatValue(float f) {
        ValueWrapper valueWrapper = new ValueWrapper();
        valueWrapper.floatValue = f;
        valueWrapper.type = 3;
        return valueWrapper;
    }

    static ValueWrapper intValue(int i) {
        ValueWrapper valueWrapper = new ValueWrapper();
        valueWrapper.intValue = i;
        valueWrapper.type = 1;
        return valueWrapper;
    }

    static ValueWrapper longValue(long j) {
        ValueWrapper valueWrapper = new ValueWrapper();
        valueWrapper.longValue = j;
        valueWrapper.type = 2;
        return valueWrapper;
    }

    static ValueWrapper stringValue(String str) {
        ValueWrapper valueWrapper = new ValueWrapper();
        valueWrapper.stringValue = str;
        valueWrapper.type = 5;
        return valueWrapper;
    }
}
