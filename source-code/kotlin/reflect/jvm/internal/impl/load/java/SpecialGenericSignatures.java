package kotlin.reflect.jvm.internal.impl.load.java;

import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.do2;
import tb.gl1;
import tb.k21;
import tb.m40;
import tb.og1;

/* compiled from: Taobao */
public class SpecialGenericSignatures {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final List<a.C0271a> a;
    @NotNull
    private static final List<String> b;
    @NotNull
    private static final Map<a.C0271a, TypeSafeBarrierDescription> c;
    @NotNull
    private static final Map<String, TypeSafeBarrierDescription> d;
    @NotNull
    private static final Set<og1> e;
    @NotNull
    private static final Set<String> f;
    @NotNull
    private static final a.C0271a g;
    @NotNull
    private static final Map<a.C0271a, og1> h;
    @NotNull
    private static final Map<String, og1> i;
    @NotNull
    private static final List<og1> j;
    @NotNull
    private static final Map<og1, List<og1>> k;

    /* compiled from: Taobao */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        @Nullable
        private final String valueParametersSignature;

        private SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Taobao */
    public static final class TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        public static final TypeSafeBarrierDescription FALSE;
        public static final TypeSafeBarrierDescription INDEX;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        public static final TypeSafeBarrierDescription NULL;
        @Nullable
        private final Object defaultValue;

        /* compiled from: Taobao */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            TypeSafeBarrierDescription typeSafeBarrierDescription = new TypeSafeBarrierDescription("NULL", 0, null);
            NULL = typeSafeBarrierDescription;
            TypeSafeBarrierDescription typeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, -1);
            INDEX = typeSafeBarrierDescription2;
            TypeSafeBarrierDescription typeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            FALSE = typeSafeBarrierDescription3;
            MAP_GET_OR_DEFAULT map_get_or_default = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = map_get_or_default;
            $VALUES = new TypeSafeBarrierDescription[]{typeSafeBarrierDescription, typeSafeBarrierDescription2, typeSafeBarrierDescription3, map_get_or_default};
        }

        private TypeSafeBarrierDescription(String str, int i, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, m40 m40) {
            this(str, i, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            k21.i(str, "value");
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr = $VALUES;
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr2 = new TypeSafeBarrierDescription[typeSafeBarrierDescriptionArr.length];
            System.arraycopy(typeSafeBarrierDescriptionArr, 0, typeSafeBarrierDescriptionArr2, 0, typeSafeBarrierDescriptionArr.length);
            return typeSafeBarrierDescriptionArr2;
        }
    }

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0271a {
            @NotNull
            private final og1 a;
            @NotNull
            private final String b;

            public C0271a(@NotNull og1 og1, @NotNull String str) {
                k21.i(og1, "name");
                k21.i(str, SocialOperation.GAME_SIGNATURE);
                this.a = og1;
                this.b = str;
            }

            @NotNull
            public final og1 a() {
                return this.a;
            }

            @NotNull
            public final String b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0271a)) {
                    return false;
                }
                C0271a aVar = (C0271a) obj;
                return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final C0271a k(String str, String str2, String str3, String str4) {
            og1 f = og1.f(str2);
            k21.h(f, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new C0271a(f, signatureBuildingComponents.k(str, str2 + '(' + str3 + ')' + str4));
        }

        @NotNull
        public final List<String> b() {
            return SpecialGenericSignatures.b;
        }

        @NotNull
        public final Set<og1> c() {
            return SpecialGenericSignatures.e;
        }

        @NotNull
        public final Set<String> d() {
            return SpecialGenericSignatures.f;
        }

        @NotNull
        public final Map<og1, List<og1>> e() {
            return SpecialGenericSignatures.k;
        }

        @NotNull
        public final List<og1> f() {
            return SpecialGenericSignatures.j;
        }

        @NotNull
        public final C0271a g() {
            return SpecialGenericSignatures.g;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> h() {
            return SpecialGenericSignatures.d;
        }

        @NotNull
        public final Map<String, og1> i() {
            return SpecialGenericSignatures.i;
        }

        @NotNull
        public final SpecialSignatureInfo j(@NotNull String str) {
            k21.i(str, "builtinSignature");
            if (b().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) u.j(h(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    static {
        Set<String> set = e0.g("containsAll", "removeAll", "retainAll");
        ArrayList<a.C0271a> arrayList = new ArrayList(n.q(set, 10));
        for (String str : set) {
            a aVar = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            k21.h(desc, "BOOLEAN.desc");
            arrayList.add(aVar.k("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        a = arrayList;
        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
        for (a.C0271a aVar2 : arrayList) {
            arrayList2.add(aVar2.b());
        }
        b = arrayList2;
        List<a.C0271a> list = a;
        ArrayList arrayList3 = new ArrayList(n.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().a().b());
        }
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        a aVar3 = Companion;
        String i2 = signatureBuildingComponents.i("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        k21.h(desc2, "BOOLEAN.desc");
        a.C0271a k2 = aVar3.k(i2, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String i3 = signatureBuildingComponents.i("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        k21.h(desc3, "BOOLEAN.desc");
        String i4 = signatureBuildingComponents.i("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        k21.h(desc4, "BOOLEAN.desc");
        String i5 = signatureBuildingComponents.i("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        k21.h(desc5, "BOOLEAN.desc");
        String i6 = signatureBuildingComponents.i("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        k21.h(desc6, "BOOLEAN.desc");
        a.C0271a k3 = aVar3.k(signatureBuildingComponents.i("Map"), gl1.TYPE_OPEN_URL_METHOD_GET, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String i7 = signatureBuildingComponents.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        k21.h(desc7, "INT.desc");
        a.C0271a k4 = aVar3.k(i7, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String i8 = signatureBuildingComponents.i("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        k21.h(desc8, "INT.desc");
        Map<a.C0271a, TypeSafeBarrierDescription> map = x.l(do2.a(k2, typeSafeBarrierDescription), do2.a(aVar3.k(i3, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), do2.a(aVar3.k(i4, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), do2.a(aVar3.k(i5, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), do2.a(aVar3.k(i6, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), do2.a(aVar3.k(signatureBuildingComponents.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), do2.a(k3, typeSafeBarrierDescription2), do2.a(aVar3.k(signatureBuildingComponents.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), do2.a(k4, typeSafeBarrierDescription3), do2.a(aVar3.k(i8, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        c = map;
        LinkedHashMap linkedHashMap = new LinkedHashMap(w.e(map.size()));
        for (T t : map.entrySet()) {
            linkedHashMap.put(((a.C0271a) t.getKey()).b(), t.getValue());
        }
        d = linkedHashMap;
        Set<a.C0271a> set2 = f0.i(c.keySet(), a);
        ArrayList arrayList4 = new ArrayList(n.q(set2, 10));
        for (a.C0271a aVar4 : set2) {
            arrayList4.add(aVar4.a());
        }
        e = CollectionsKt___CollectionsKt.C0(arrayList4);
        ArrayList arrayList5 = new ArrayList(n.q(set2, 10));
        for (a.C0271a aVar5 : set2) {
            arrayList5.add(aVar5.b());
        }
        f = CollectionsKt___CollectionsKt.C0(arrayList5);
        a aVar6 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        k21.h(desc9, "INT.desc");
        g = aVar6.k("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String h2 = signatureBuildingComponents2.h("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        k21.h(desc10, "BYTE.desc");
        String h3 = signatureBuildingComponents2.h("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        k21.h(desc11, "SHORT.desc");
        String h4 = signatureBuildingComponents2.h("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        k21.h(desc12, "INT.desc");
        String h5 = signatureBuildingComponents2.h("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        k21.h(desc13, "LONG.desc");
        String h6 = signatureBuildingComponents2.h("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        k21.h(desc14, "FLOAT.desc");
        String h7 = signatureBuildingComponents2.h("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        k21.h(desc15, "DOUBLE.desc");
        String h8 = signatureBuildingComponents2.h("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        k21.h(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        k21.h(desc17, "CHAR.desc");
        Map<a.C0271a, og1> map2 = x.l(do2.a(aVar6.k(h2, "toByte", "", desc10), og1.f("byteValue")), do2.a(aVar6.k(h3, "toShort", "", desc11), og1.f("shortValue")), do2.a(aVar6.k(h4, "toInt", "", desc12), og1.f("intValue")), do2.a(aVar6.k(h5, "toLong", "", desc13), og1.f("longValue")), do2.a(aVar6.k(h6, "toFloat", "", desc14), og1.f("floatValue")), do2.a(aVar6.k(h7, "toDouble", "", desc15), og1.f("doubleValue")), do2.a(aVar6.g(), og1.f("remove")), do2.a(aVar6.k(h8, gl1.TYPE_OPEN_URL_METHOD_GET, desc16, desc17), og1.f("charAt")));
        h = map2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(w.e(map2.size()));
        for (T t2 : map2.entrySet()) {
            linkedHashMap2.put(((a.C0271a) t2.getKey()).b(), t2.getValue());
        }
        i = linkedHashMap2;
        Set<a.C0271a> keySet = h.keySet();
        ArrayList arrayList6 = new ArrayList(n.q(keySet, 10));
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            arrayList6.add(it2.next().a());
        }
        j = arrayList6;
        Set<Map.Entry<a.C0271a, og1>> entrySet = h.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(n.q(entrySet, 10));
        for (T t3 : entrySet) {
            arrayList7.add(new Pair(((a.C0271a) t3.getKey()).a(), t3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            og1 og1 = (og1) pair.getSecond();
            Object obj = linkedHashMap3.get(og1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(og1, obj);
            }
            ((List) obj).add((og1) pair.getFirst());
        }
        k = linkedHashMap3;
    }
}
