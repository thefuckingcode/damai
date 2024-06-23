package kotlin.jvm.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.r51;
import tb.z41;

public final class TypeReference implements KType {
    public static final a Companion = new a(null);
    public static final int IS_MARKED_NULLABLE;
    public static final int IS_MUTABLE_COLLECTION_TYPE;
    public static final int IS_NOTHING_TYPE;
    private final KClassifier a;
    private final List<r51> b;
    private final KType c;
    private final int d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: public */
    private final String b(r51 r51) {
        String str;
        if (r51.d() == null) {
            return jl1.MUL;
        }
        KType c2 = r51.c();
        TypeReference typeReference = c2 instanceof TypeReference ? (TypeReference) c2 : null;
        if (typeReference == null || (str = typeReference.c(true)) == null) {
            str = String.valueOf(r51.c());
        }
        int i = b.$EnumSwitchMapping$0[r51.d().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "in " + str;
        } else if (i == 3) {
            return "out " + str;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final String c(boolean z) {
        String str;
        String str2;
        KClassifier classifier = getClassifier();
        Class<?> cls = null;
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass != null) {
            cls = z41.b(kClass);
        }
        if (cls == null) {
            str = getClassifier().toString();
        } else if ((this.d & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            str = d(cls);
        } else if (!z || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            KClassifier classifier2 = getClassifier();
            k21.g(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            str = z41.c((KClass) classifier2).getName();
        }
        String str3 = "";
        if (getArguments().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt___CollectionsKt.Z(getArguments(), AVFSCacheConstants.COMMA_SEP, jl1.L, jl1.G, 0, null, new TypeReference$asString$args$1(this), 24, null);
        }
        if (isMarkedNullable()) {
            str3 = "?";
        }
        String str4 = str + str2 + str3;
        KType kType = this.c;
        if (!(kType instanceof TypeReference)) {
            return str4;
        }
        String c2 = ((TypeReference) kType).c(true);
        if (k21.d(c2, str4)) {
            return str4;
        }
        if (k21.d(c2, str4 + jl1.CONDITION_IF)) {
            return str4 + '!';
        }
        return '(' + str4 + ".." + c2 + ')';
    }

    private final String d(Class<?> cls) {
        if (k21.d(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (k21.d(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (k21.d(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (k21.d(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (k21.d(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (k21.d(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (k21.d(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return k21.d(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            return k21.d(getClassifier(), typeReference.getClassifier()) && k21.d(getArguments(), typeReference.getArguments()) && k21.d(this.c, typeReference.c) && this.d == typeReference.d;
        }
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return m.g();
    }

    @Override // kotlin.reflect.KType
    public List<r51> getArguments() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.a;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.valueOf(this.d).hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.d & 1) != 0;
    }

    public String toString() {
        return c(false) + " (Kotlin reflection is not available)";
    }
}
