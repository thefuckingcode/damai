package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.oc1;
import tb.og1;

/* compiled from: Taobao */
public interface MemberScope extends ResolutionScope {
    @NotNull
    public static final Companion Companion = Companion.a;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();
        @NotNull
        private static final Function1<og1, Boolean> b = MemberScope$Companion$ALL_NAME_FILTER$1.INSTANCE;

        private Companion() {
        }

        @NotNull
        public final Function1<og1, Boolean> a() {
            return b;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        public static void a(@NotNull MemberScope memberScope, @NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            ResolutionScope.a.b(memberScope, og1, lookupLocation);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends oc1 {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getClassifierNames() {
            return e0.d();
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getFunctionNames() {
            return e0.d();
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getVariableNames() {
            return e0.d();
        }
    }

    @Nullable
    Set<og1> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<og1> getFunctionNames();

    @NotNull
    Set<og1> getVariableNames();
}
