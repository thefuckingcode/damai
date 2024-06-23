package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* compiled from: Taobao */
public enum ProtoBuf$Modality implements Internal.EnumLite {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);
    
    private static Internal.EnumLiteMap<ProtoBuf$Modality> internalValueMap = new a();
    private final int value;

    /* compiled from: Taobao */
    static class a implements Internal.EnumLiteMap<ProtoBuf$Modality> {
        a() {
        }

        /* renamed from: a */
        public ProtoBuf$Modality findValueByNumber(int i) {
            return ProtoBuf$Modality.valueOf(i);
        }
    }

    private ProtoBuf$Modality(int i, int i2) {
        this.value = i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int i) {
        if (i == 0) {
            return FINAL;
        }
        if (i == 1) {
            return OPEN;
        }
        if (i == 2) {
            return ABSTRACT;
        }
        if (i != 3) {
            return null;
        }
        return SEALED;
    }
}
