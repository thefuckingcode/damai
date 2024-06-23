package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.ac2;
import tb.b60;
import tb.dz1;
import tb.fj1;
import tb.g61;
import tb.k21;
import tb.oc1;
import tb.og1;
import tb.qj;
import tb.te2;

public abstract class GivenFunctionsMemberScope extends oc1 {
    static final /* synthetic */ KProperty<Object>[] c = {dz1.i(new PropertyReference1Impl(dz1.b(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final ClassDescriptor a;
    private final NotNullLazyValue b;

    public static final class a extends fj1 {
        final /* synthetic */ ArrayList<DeclarationDescriptor> a;
        final /* synthetic */ GivenFunctionsMemberScope b;

        a(ArrayList<DeclarationDescriptor> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
            this.a = arrayList;
            this.b = givenFunctionsMemberScope;
        }

        @Override // tb.gn1
        public void a(CallableMemberDescriptor callableMemberDescriptor) {
            k21.i(callableMemberDescriptor, "fakeOverride");
            OverridingUtil.N(callableMemberDescriptor, null);
            this.a.add(callableMemberDescriptor);
        }

        @Override // tb.fj1
        public void e(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
            k21.i(callableMemberDescriptor, "fromSuper");
            k21.i(callableMemberDescriptor2, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.b.e() + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
        }
    }

    public GivenFunctionsMemberScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        k21.i(storageManager, "storageManager");
        k21.i(classDescriptor, "containingClass");
        this.a = classDescriptor;
        this.b = storageManager.createLazyValue(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    /* access modifiers changed from: public */
    private final List<DeclarationDescriptor> c(List<? extends FunctionDescriptor> list) {
        Collection<? extends CallableMemberDescriptor> collection;
        ArrayList arrayList = new ArrayList(3);
        Collection<g61> supertypes = this.a.getTypeConstructor().getSupertypes();
        k21.h(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            boolean unused = r.v(arrayList2, ResolutionScope.a.a(it.next().getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            og1 name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            og1 og1 = (og1) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof FunctionDescriptor);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list2 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.DEFAULT;
                if (booleanValue) {
                    collection = new ArrayList<>();
                    for (T t : list) {
                        if (k21.d(t.getName(), og1)) {
                            collection.add(t);
                        }
                    }
                } else {
                    collection = m.g();
                }
                overridingUtil.y(og1, list2, collection, this.a, new a(arrayList, this));
            }
        }
        return qj.c(arrayList);
    }

    private final List<DeclarationDescriptor> d() {
        return (List) te2.a(this.b, this, c[0]);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract List<FunctionDescriptor> b();

    public final ClassDescriptor e() {
        return this.a;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(b60 b60, Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        if (!b60.a(b60.CALLABLES.o())) {
            return m.g();
        }
        return d();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        List<DeclarationDescriptor> d = d();
        ac2 ac2 = new ac2();
        for (T t : d) {
            if ((t instanceof SimpleFunctionDescriptor) && k21.d(t.getName(), og1)) {
                ac2.add(t);
            }
        }
        return ac2;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(og1 og1, LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        List<DeclarationDescriptor> d = d();
        ac2 ac2 = new ac2();
        for (T t : d) {
            if ((t instanceof PropertyDescriptor) && k21.d(t.getName(), og1)) {
                ac2.add(t);
            }
        }
        return ac2;
    }
}
