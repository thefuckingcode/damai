package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmMemberSignature.kt */
public abstract class JvmMemberSignature {
    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual(getName(), method.getName()) && Intrinsics.areEqual(getDesc(), method.getDesc());
        }

        public int hashCode() {
            String name2 = getName();
            int i = 0;
            int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
            String desc2 = getDesc();
            if (desc2 != null) {
                i = desc2.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Method(String str, String str2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual(getName(), field.getName()) && Intrinsics.areEqual(getDesc(), field.getDesc());
        }

        public int hashCode() {
            String name2 = getName();
            int i = 0;
            int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
            String desc2 = getDesc();
            if (desc2 != null) {
                i = desc2.hashCode();
            }
            return hashCode + i;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Field(String str, String str2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }
    }

    public final String toString() {
        return asString();
    }
}
