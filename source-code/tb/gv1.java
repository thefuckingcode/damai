package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class gv1 {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final ap2 b;
    @Nullable
    private final SourceElement c;

    /* compiled from: Taobao */
    public static final class a extends gv1 {
        @NotNull
        private final ProtoBuf$Class d;
        @Nullable
        private final a e;
        @NotNull
        private final oi f;
        @NotNull
        private final ProtoBuf$Class.Kind g;
        private final boolean h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull ProtoBuf$Class protoBuf$Class, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @Nullable SourceElement sourceElement, @Nullable a aVar) {
            super(nameResolver, ap2, sourceElement, null);
            k21.i(protoBuf$Class, "classProto");
            k21.i(nameResolver, "nameResolver");
            k21.i(ap2, "typeTable");
            this.d = protoBuf$Class;
            this.e = aVar;
            this.f = qg1.a(nameResolver, protoBuf$Class.getFqName());
            ProtoBuf$Class.Kind d2 = bj0.CLASS_KIND.d(protoBuf$Class.getFlags());
            this.g = d2 == null ? ProtoBuf$Class.Kind.CLASS : d2;
            Boolean g2 = bj0.IS_INNER.d(protoBuf$Class.getFlags());
            k21.h(g2, "IS_INNER.get(classProto.flags)");
            this.h = g2.booleanValue();
        }

        @Override // tb.gv1
        @NotNull
        public en0 a() {
            en0 b = this.f.b();
            k21.h(b, "classId.asSingleFqName()");
            return b;
        }

        @NotNull
        public final oi e() {
            return this.f;
        }

        @NotNull
        public final ProtoBuf$Class f() {
            return this.d;
        }

        @NotNull
        public final ProtoBuf$Class.Kind g() {
            return this.g;
        }

        @Nullable
        public final a h() {
            return this.e;
        }

        public final boolean i() {
            return this.h;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends gv1 {
        @NotNull
        private final en0 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull en0 en0, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @Nullable SourceElement sourceElement) {
            super(nameResolver, ap2, sourceElement, null);
            k21.i(en0, "fqName");
            k21.i(nameResolver, "nameResolver");
            k21.i(ap2, "typeTable");
            this.d = en0;
        }

        @Override // tb.gv1
        @NotNull
        public en0 a() {
            return this.d;
        }
    }

    private gv1(NameResolver nameResolver, ap2 ap2, SourceElement sourceElement) {
        this.a = nameResolver;
        this.b = ap2;
        this.c = sourceElement;
    }

    public /* synthetic */ gv1(NameResolver nameResolver, ap2 ap2, SourceElement sourceElement, m40 m40) {
        this(nameResolver, ap2, sourceElement);
    }

    @NotNull
    public abstract en0 a();

    @NotNull
    public final NameResolver b() {
        return this.a;
    }

    @Nullable
    public final SourceElement c() {
        return this.c;
    }

    @NotNull
    public final ap2 d() {
        return this.b;
    }

    @NotNull
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
