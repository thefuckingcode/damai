package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;
import tb.ww1;

/* compiled from: Taobao */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    @NotNull
    private final JavaClass a;
    @NotNull
    private final Function1<JavaMember, Boolean> b;
    @NotNull
    private final Function1<JavaMethod, Boolean> c;
    @NotNull
    private final Map<og1, List<JavaMethod>> d;
    @NotNull
    private final Map<og1, JavaField> e;
    @NotNull
    private final Map<og1, JavaRecordComponent> f;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(@NotNull JavaClass javaClass, @NotNull Function1<? super JavaMember, Boolean> function1) {
        k21.i(javaClass, "jClass");
        k21.i(function1, "memberFilter");
        this.a = javaClass;
        this.b = function1;
        ClassDeclaredMemberIndex$methodFilter$1 classDeclaredMemberIndex$methodFilter$1 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.c = classDeclaredMemberIndex$methodFilter$1;
        Sequence sequence = SequencesKt___SequencesKt.o(CollectionsKt___CollectionsKt.I(javaClass.getMethods()), classDeclaredMemberIndex$methodFilter$1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequence) {
            og1 name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.d = linkedHashMap;
        Sequence sequence2 = SequencesKt___SequencesKt.o(CollectionsKt___CollectionsKt.I(this.a.getFields()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : sequence2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.e = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.a.getRecordComponents();
        Function1<JavaMember, Boolean> function12 = this.b;
        ArrayList arrayList = new ArrayList();
        for (T t : recordComponents) {
            if (function12.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(ww1.a(w.e(n.q(arrayList, 10)), 16));
        for (Object obj4 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj4).getName(), obj4);
        }
        this.f = linkedHashMap3;
    }

    public static final /* synthetic */ Function1 a(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        return classDeclaredMemberIndex.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaField findFieldByName(@NotNull og1 og1) {
        k21.i(og1, "name");
        return this.e.get(og1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull og1 og1) {
        k21.i(og1, "name");
        List<JavaMethod> list = this.d.get(og1);
        return list == null ? m.g() : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull og1 og1) {
        k21.i(og1, "name");
        return this.f.get(og1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<og1> getFieldNames() {
        Sequence<JavaNamedElement> sequence = SequencesKt___SequencesKt.o(CollectionsKt___CollectionsKt.I(this.a.getFields()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : sequence) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<og1> getMethodNames() {
        Sequence<JavaNamedElement> sequence = SequencesKt___SequencesKt.o(CollectionsKt___CollectionsKt.I(this.a.getMethods()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : sequence) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<og1> getRecordComponentNames() {
        return this.f.keySet();
    }
}
