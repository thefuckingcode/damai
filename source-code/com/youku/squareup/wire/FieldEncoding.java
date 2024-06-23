package com.youku.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: Taobao */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    final int value;

    /* renamed from: com.youku.squareup.wire.FieldEncoding$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$squareup$wire$FieldEncoding;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[FieldEncoding.values().length];
            $SwitchMap$com$youku$squareup$wire$FieldEncoding = iArr;
            iArr[FieldEncoding.VARINT.ordinal()] = 1;
            $SwitchMap$com$youku$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;
            $SwitchMap$com$youku$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;
            try {
                $SwitchMap$com$youku$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private FieldEncoding(int i) {
        this.value = i;
    }

    static FieldEncoding get(int i) throws IOException {
        if (i == 0) {
            return VARINT;
        }
        if (i == 1) {
            return FIXED64;
        }
        if (i == 2) {
            return LENGTH_DELIMITED;
        }
        if (i == 5) {
            return FIXED32;
        }
        throw new ProtocolException("Unexpected FieldEncoding: " + i);
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i = AnonymousClass1.$SwitchMap$com$youku$squareup$wire$FieldEncoding[ordinal()];
        if (i == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new AssertionError();
    }
}
