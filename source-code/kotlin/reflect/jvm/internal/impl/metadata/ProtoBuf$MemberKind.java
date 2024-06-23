package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* compiled from: Taobao */
public enum ProtoBuf$MemberKind implements Internal.EnumLite {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);
    
    private static Internal.EnumLiteMap<ProtoBuf$MemberKind> internalValueMap = new a();
    private final int value;

    /* compiled from: Taobao */
    static class a implements Internal.EnumLiteMap<ProtoBuf$MemberKind> {
        a() {
        }

        /* renamed from: a */
        public ProtoBuf$MemberKind findValueByNumber(int i) {
            return ProtoBuf$MemberKind.valueOf(i);
        }
    }

    private ProtoBuf$MemberKind(int i, int i2) {
        this.value = i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$MemberKind valueOf(int i) {
        if (i == 0) {
            return DECLARATION;
        }
        if (i == 1) {
            return FAKE_OVERRIDE;
        }
        if (i == 2) {
            return DELEGATION;
        }
        if (i != 3) {
            return null;
        }
        return SYNTHESIZED;
    }
}
