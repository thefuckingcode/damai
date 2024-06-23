package kotlin.reflect.jvm.internal.impl.types;

import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bc2;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public abstract class AbstractTypeCheckerContext implements TypeSystemContext {
    private int a;
    private boolean b;
    @Nullable
    private ArrayDeque<SimpleTypeMarker> c;
    @Nullable
    private Set<SimpleTypeMarker> d;

    /* compiled from: Taobao */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* compiled from: Taobao */
    public static abstract class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static abstract class AbstractC0286a extends a {
            public AbstractC0286a() {
                super(null);
            }
        }

        /* compiled from: Taobao */
        public static final class b extends a {
            @NotNull
            public static final b INSTANCE = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                k21.i(kotlinTypeMarker, "type");
                return abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker);
            }
        }

        /* compiled from: Taobao */
        public static final class c extends a {
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            public /* bridge */ /* synthetic */ SimpleTypeMarker a(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                return (SimpleTypeMarker) b(abstractTypeCheckerContext, kotlinTypeMarker);
            }

            @NotNull
            public Void b(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                k21.i(kotlinTypeMarker, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: Taobao */
        public static final class d extends a {
            @NotNull
            public static final d INSTANCE = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                k21.i(kotlinTypeMarker, "type");
                return abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker);
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public abstract SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker);
    }

    public static /* synthetic */ Boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z = false;
            }
            return abstractTypeCheckerContext.c(kotlinTypeMarker, kotlinTypeMarker2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    @Nullable
    public Boolean c(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        k21.i(kotlinTypeMarker, "subType");
        k21.i(kotlinTypeMarker2, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.c;
        k21.f(arrayDeque);
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.d;
        k21.f(set);
        set.clear();
        this.b = false;
    }

    public boolean f(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        k21.i(kotlinTypeMarker, "subType");
        k21.i(kotlinTypeMarker2, "superType");
        return true;
    }

    @Nullable
    public List<SimpleTypeMarker> g(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        return TypeSystemContext.a.a(this, simpleTypeMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
        return TypeSystemContext.a.b(this, typeArgumentListMarker, i);
    }

    @Nullable
    public TypeArgumentMarker h(@NotNull SimpleTypeMarker simpleTypeMarker, int i) {
        return TypeSystemContext.a.c(this, simpleTypeMarker, i);
    }

    @NotNull
    public LowerCapturedTypePolicy i(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CapturedTypeMarker capturedTypeMarker) {
        k21.i(simpleTypeMarker, "subType");
        k21.i(capturedTypeMarker, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.i(this, kotlinTypeMarker);
    }

    @Nullable
    public final ArrayDeque<SimpleTypeMarker> j() {
        return this.c;
    }

    @Nullable
    public final Set<SimpleTypeMarker> k() {
        return this.d;
    }

    public boolean l(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.d(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.k(this, kotlinTypeMarker);
    }

    public final void m() {
        this.b = true;
        if (this.c == null) {
            this.c = new ArrayDeque<>(4);
        }
        if (this.d == null) {
            this.d = bc2.Companion.a();
        }
    }

    public abstract boolean n(@NotNull KotlinTypeMarker kotlinTypeMarker);

    public boolean o(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return TypeSystemContext.a.e(this, simpleTypeMarker);
    }

    public boolean p(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.f(this, kotlinTypeMarker);
    }

    public boolean q(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.g(this, kotlinTypeMarker);
    }

    public abstract boolean r();

    public boolean s(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return TypeSystemContext.a.h(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(@NotNull TypeArgumentListMarker typeArgumentListMarker) {
        return TypeSystemContext.a.l(this, typeArgumentListMarker);
    }

    public boolean t(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.j(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.m(this, kotlinTypeMarker);
    }

    public abstract boolean u();

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.a.n(this, kotlinTypeMarker);
    }

    @NotNull
    public abstract KotlinTypeMarker v(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract KotlinTypeMarker w(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    public abstract a x(@NotNull SimpleTypeMarker simpleTypeMarker);
}
