package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.youku.arch.v3.data.Constants;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import tb.ap2;
import tb.en0;
import tb.fv2;
import tb.j60;
import tb.jn1;
import tb.k21;
import tb.l60;
import tb.li;
import tb.m40;
import tb.nb;
import tb.og1;
import tb.oi;
import tb.p60;

public final class ClassDeserializer {
    public static final b Companion = new b(null);
    private static final Set<oi> c = d0.c(oi.m(c.a.cloneable.l()));
    private final j60 a;
    private final Function1<a, ClassDescriptor> b;

    public static final class a {
        private final oi a;
        private final li b;

        public a(oi oiVar, li liVar) {
            k21.i(oiVar, "classId");
            this.a = oiVar;
            this.b = liVar;
        }

        public final li a() {
            return this.b;
        }

        public final oi b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && k21.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        public final Set<oi> a() {
            return ClassDeserializer.c;
        }
    }

    public ClassDeserializer(j60 j60) {
        k21.i(j60, Constants.COMPONENT);
        this.a = j60;
        this.b = j60.u().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bd A[EDGE_INSN: B:45:0x00bd->B:37:0x00bd ?: BREAK  , SYNTHETIC] */
    private final ClassDescriptor c(a aVar) {
        l60 l60;
        T t;
        boolean z;
        oi b2 = aVar.b();
        for (ClassDescriptorFactory classDescriptorFactory : this.a.k()) {
            ClassDescriptor createClass = classDescriptorFactory.createClass(b2);
            if (createClass != null) {
                return createClass;
            }
        }
        if (Companion.a().contains(b2)) {
            return null;
        }
        li a2 = aVar.a();
        if (a2 == null && (a2 = this.a.e().findClassData(b2)) == null) {
            return null;
        }
        NameResolver a3 = a2.a();
        ProtoBuf$Class b3 = a2.b();
        nb c2 = a2.c();
        SourceElement d = a2.d();
        oi g = b2.g();
        if (g != null) {
            ClassDescriptor e = e(this, g, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = e instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e : null;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            og1 j = b2.j();
            k21.h(j, "classId.shortClassName");
            if (!deserializedClassDescriptor.w(j)) {
                return null;
            }
            l60 = deserializedClassDescriptor.q();
        } else {
            PackageFragmentProvider r = this.a.r();
            en0 h = b2.h();
            k21.h(h, "classId.packageFqName");
            Iterator<T> it = jn1.b(r, h).iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                T t2 = t;
                if (t2 instanceof p60) {
                    og1 j2 = b2.j();
                    k21.h(j2, "classId.shortClassName");
                    if (!t2.e(j2)) {
                        z = false;
                        continue;
                        if (z) {
                            break;
                        }
                    }
                }
                z = true;
                continue;
                if (z) {
                }
            }
            T t3 = t;
            if (t3 == null) {
                return null;
            }
            j60 j60 = this.a;
            ProtoBuf$TypeTable typeTable = b3.getTypeTable();
            k21.h(typeTable, "classProto.typeTable");
            ap2 ap2 = new ap2(typeTable);
            fv2.a aVar2 = fv2.Companion;
            ProtoBuf$VersionRequirementTable versionRequirementTable = b3.getVersionRequirementTable();
            k21.h(versionRequirementTable, "classProto.versionRequirementTable");
            l60 = j60.a(t3, a3, ap2, aVar2.a(versionRequirementTable), c2, null);
        }
        return new DeserializedClassDescriptor(l60, b3, a3, c2, d);
    }

    public static /* synthetic */ ClassDescriptor e(ClassDeserializer classDeserializer, oi oiVar, li liVar, int i, Object obj) {
        if ((i & 2) != 0) {
            liVar = null;
        }
        return classDeserializer.d(oiVar, liVar);
    }

    public final ClassDescriptor d(oi oiVar, li liVar) {
        k21.i(oiVar, "classId");
        return this.b.invoke(new a(oiVar, liVar));
    }
}
