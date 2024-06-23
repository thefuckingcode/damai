package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wy1 implements KotlinJvmBinaryClass {
    @NotNull
    public static final a Factory = new a(null);
    @NotNull
    private final Class<?> a;
    @NotNull
    private final KotlinClassHeader b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final wy1 a(@NotNull Class<?> cls) {
            k21.i(cls, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            xx1.INSTANCE.b(cls, aVar);
            KotlinClassHeader k = aVar.k();
            if (k == null) {
                return null;
            }
            return new wy1(cls, k, null);
        }
    }

    private wy1(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.a = cls;
        this.b = kotlinClassHeader;
    }

    public /* synthetic */ wy1(Class cls, KotlinClassHeader kotlinClassHeader, m40 m40) {
        this(cls, kotlinClassHeader);
    }

    @NotNull
    public final Class<?> a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof wy1) && k21.d(this.a, ((wy1) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public oi getClassId() {
        return ReflectClassUtilKt.b(this.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    @NotNull
    public String getLocation() {
        String name = this.a.getName();
        k21.h(name, "klass.name");
        return k21.r(o.E(name, '.', v00.DIR, false, 4, null), ".class");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, @Nullable byte[] bArr) {
        k21.i(annotationVisitor, "visitor");
        xx1.INSTANCE.b(this.a, annotationVisitor);
    }

    @NotNull
    public String toString() {
        return wy1.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor, @Nullable byte[] bArr) {
        k21.i(memberVisitor, "visitor");
        xx1.INSTANCE.i(this.a, memberVisitor);
    }
}
