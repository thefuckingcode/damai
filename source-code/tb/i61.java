package tb;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class i61 {

    /* compiled from: Taobao */
    public static final class a extends i61 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // tb.i61
        @Nullable
        public ClassDescriptor a(@NotNull oi oiVar) {
            k21.i(oiVar, "classId");
            return null;
        }

        @Override // tb.i61
        @NotNull
        public <S extends MemberScope> S b(@NotNull ClassDescriptor classDescriptor, @NotNull Function0<? extends S> function0) {
            k21.i(classDescriptor, "classDescriptor");
            k21.i(function0, "compute");
            return (S) ((MemberScope) function0.invoke());
        }

        @Override // tb.i61
        public boolean c(@NotNull ModuleDescriptor moduleDescriptor) {
            k21.i(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // tb.i61
        public boolean d(@NotNull TypeConstructor typeConstructor) {
            k21.i(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // tb.i61
        @NotNull
        public Collection<g61> f(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "classDescriptor");
            Collection<g61> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            k21.h(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // tb.i61
        @NotNull
        public g61 g(@NotNull g61 g61) {
            k21.i(g61, "type");
            return g61;
        }

        @Nullable
        /* renamed from: h */
        public ClassDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor) {
            k21.i(declarationDescriptor, "descriptor");
            return null;
        }
    }

    @Nullable
    public abstract ClassDescriptor a(@NotNull oi oiVar);

    @NotNull
    public abstract <S extends MemberScope> S b(@NotNull ClassDescriptor classDescriptor, @NotNull Function0<? extends S> function0);

    public abstract boolean c(@NotNull ModuleDescriptor moduleDescriptor);

    public abstract boolean d(@NotNull TypeConstructor typeConstructor);

    @Nullable
    public abstract ClassifierDescriptor e(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract Collection<g61> f(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    public abstract g61 g(@NotNull g61 g61);
}
