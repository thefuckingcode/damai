package kotlin.reflect.jvm.internal.impl.protobuf;

/* compiled from: Taobao */
public final class WireFormat {

    /* JADX WARN: Init of enum INT64 can be incorrect */
    /* JADX WARN: Init of enum UINT64 can be incorrect */
    /* JADX WARN: Init of enum INT32 can be incorrect */
    /* JADX WARN: Init of enum FIXED64 can be incorrect */
    /* JADX WARN: Init of enum FIXED32 can be incorrect */
    /* JADX WARN: Init of enum GROUP can be incorrect */
    /* JADX WARN: Init of enum MESSAGE can be incorrect */
    /* JADX WARN: Init of enum UINT32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED64 can be incorrect */
    /* JADX WARN: Init of enum SINT32 can be incorrect */
    /* JADX WARN: Init of enum SINT64 can be incorrect */
    /* compiled from: Taobao */
    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        private final JavaType javaType;
        private final int wireType;

        static {
            JavaType javaType2 = JavaType.LONG;
            JavaType javaType3 = JavaType.INT;
            JavaType javaType4 = JavaType.MESSAGE;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(JavaType javaType2, int i) {
            this.javaType = javaType2;
            this.wireType = i;
        }
    }

    /* compiled from: Taobao */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }
    }

    static {
        c(1, 3);
        c(1, 4);
        c(2, 0);
        c(3, 2);
    }

    public static int a(int i) {
        return i >>> 3;
    }

    static int b(int i) {
        return i & 7;
    }

    static int c(int i, int i2) {
        return (i << 3) | i2;
    }
}
