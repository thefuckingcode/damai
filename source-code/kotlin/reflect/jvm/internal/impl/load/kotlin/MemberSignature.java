package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* compiled from: MemberSignature.kt */
public final class MemberSignature {
    public static final Companion Companion = new Companion(null);
    private final String signature;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MemberSignature) && Intrinsics.areEqual(this.signature, ((MemberSignature) obj).signature);
        }
        return true;
    }

    public int hashCode() {
        String str = this.signature;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ")";
    }

    /* compiled from: MemberSignature.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(jvmMethodSignature, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(jvmMethodSignature.getName()), nameResolver.getString(jvmMethodSignature.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            return new MemberSignature(str + str2, null);
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "desc");
            return new MemberSignature(str + '#' + str2, null);
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
            Intrinsics.checkParameterIsNotNull(jvmMemberSignature, "signature");
            if (jvmMemberSignature instanceof JvmMemberSignature.Method) {
                return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            if (jvmMemberSignature instanceof JvmMemberSignature.Field) {
                return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature memberSignature, int i) {
            Intrinsics.checkParameterIsNotNull(memberSignature, "signature");
            return new MemberSignature(memberSignature.getSignature$descriptors_jvm() + '@' + i, null);
        }
    }

    private MemberSignature(String str) {
        this.signature = str;
    }

    public /* synthetic */ MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getSignature$descriptors_jvm() {
        return this.signature;
    }
}
