package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.ac2;
import tb.b60;
import tb.d2;
import tb.g61;
import tb.j42;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.sg;

/* compiled from: Taobao */
public final class TypeIntersectionScope extends d2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final MemberScope a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MemberScope a(@NotNull String str, @NotNull Collection<? extends g61> collection) {
            k21.i(str, "message");
            k21.i(collection, "types");
            ArrayList arrayList = new ArrayList(n.q(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMemberScope());
            }
            ac2<MemberScope> b = j42.b(arrayList);
            MemberScope b2 = sg.Companion.b(str, b);
            if (b.size() <= 1) {
                return b2;
            }
            return new TypeIntersectionScope(str, b2, null);
        }
    }

    private TypeIntersectionScope(String str, MemberScope memberScope) {
        this.a = memberScope;
    }

    public /* synthetic */ TypeIntersectionScope(String str, MemberScope memberScope, m40 m40) {
        this(str, memberScope);
    }

    @JvmStatic
    @NotNull
    public static final MemberScope c(@NotNull String str, @NotNull Collection<? extends g61> collection) {
        return Companion.a(str, collection);
    }

    /* access modifiers changed from: protected */
    @Override // tb.d2
    @NotNull
    public MemberScope b() {
        return this.a;
    }

    @Override // tb.d2, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(b60, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : contributedDescriptors) {
            if (t instanceof CallableDescriptor) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return CollectionsKt___CollectionsKt.k0(OverridingUtilsKt.a((List) pair.component1(), TypeIntersectionScope$getContributedDescriptors$2.INSTANCE), (List) pair.component2());
    }

    @Override // tb.d2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return OverridingUtilsKt.a(super.getContributedFunctions(og1, lookupLocation), TypeIntersectionScope$getContributedFunctions$1.INSTANCE);
    }

    @Override // tb.d2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return OverridingUtilsKt.a(super.getContributedVariables(og1, lookupLocation), TypeIntersectionScope$getContributedVariables$1.INSTANCE);
    }
}
