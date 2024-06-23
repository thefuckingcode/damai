package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: methodSignatureMapping.kt */
public abstract class JvmType {
    private JvmType() {
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends JvmType {
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType2) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType2;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Object extends JvmType {
        private final String internalName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Object(String str) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "internalName");
            this.internalName = str;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Array extends JvmType {
        private final JvmType elementType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Array(JvmType jvmType) {
            super(null);
            Intrinsics.checkParameterIsNotNull(jvmType, "elementType");
            this.elementType = jvmType;
        }

        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }
}
