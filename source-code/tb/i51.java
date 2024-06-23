package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.c;
import tb.bj0;
import tb.d51;

public final class i51 {
    public static final i51 INSTANCE = new i51();
    private static final c a;

    static {
        c d = c.d();
        JvmProtoBuf.a(d);
        k21.h(d, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        a = d;
    }

    private i51() {
    }

    public static /* synthetic */ d51.a d(i51 i51, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, ap2 ap2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return i51.c(protoBuf$Property, nameResolver, ap2, z);
    }

    public static final boolean f(ProtoBuf$Property protoBuf$Property) {
        k21.i(protoBuf$Property, "proto");
        bj0.b a2 = c51.INSTANCE.a();
        Object extension = protoBuf$Property.getExtension(JvmProtoBuf.flags);
        k21.h(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean g = a2.d(((Number) extension).intValue());
        k21.h(g, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return g.booleanValue();
    }

    private final String g(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        if (!protoBuf$Type.hasClassName()) {
            return null;
        }
        qi qiVar = qi.INSTANCE;
        return qi.b(nameResolver.getQualifiedClassName(protoBuf$Type.getClassName()));
    }

    public static final Pair<f51, ProtoBuf$Class> h(byte[] bArr, String[] strArr) {
        k21.i(bArr, "bytes");
        k21.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr), ProtoBuf$Class.parseFrom(byteArrayInputStream, a));
    }

    public static final Pair<f51, ProtoBuf$Class> i(String[] strArr, String[] strArr2) {
        k21.i(strArr, "data");
        k21.i(strArr2, "strings");
        byte[] e = ub.e(strArr);
        k21.h(e, "decodeBytes(data)");
        return h(e, strArr2);
    }

    public static final Pair<f51, ProtoBuf$Function> j(String[] strArr, String[] strArr2) {
        k21.i(strArr, "data");
        k21.i(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ub.e(strArr));
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr2), ProtoBuf$Function.parseFrom(byteArrayInputStream, a));
    }

    private final f51 k(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, a);
        k21.h(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f51(parseDelimitedFrom, strArr);
    }

    public static final Pair<f51, ProtoBuf$Package> l(byte[] bArr, String[] strArr) {
        k21.i(bArr, "bytes");
        k21.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr), ProtoBuf$Package.parseFrom(byteArrayInputStream, a));
    }

    public static final Pair<f51, ProtoBuf$Package> m(String[] strArr, String[] strArr2) {
        k21.i(strArr, "data");
        k21.i(strArr2, "strings");
        byte[] e = ub.e(strArr);
        k21.h(e, "decodeBytes(data)");
        return l(e, strArr2);
    }

    public final c a() {
        return a;
    }

    public final d51.b b(ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver, ap2 ap2) {
        String str;
        k21.i(protoBuf$Constructor, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Constructor, JvmProtoBuf.JvmMethodSignature> cVar = JvmProtoBuf.constructorSignature;
        k21.h(cVar, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) fv1.a(protoBuf$Constructor, cVar);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
            k21.h(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(n.q(valueParameterList, 10));
            for (T t : valueParameterList) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                String g = g(jv1.m(t, ap2), nameResolver);
                if (g == null) {
                    return null;
                }
                arrayList.add(g);
            }
            str = CollectionsKt___CollectionsKt.Z(arrayList, "", jl1.BRACKET_START_STR, ")V", 0, null, null, 56, null);
        } else {
            str = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new d51.b(string, str);
    }

    public final d51.a c(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, ap2 ap2, boolean z) {
        String str;
        k21.i(protoBuf$Property, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
        k21.h(cVar, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fv1.a(protoBuf$Property, cVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? protoBuf$Property.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            str = g(jv1.j(protoBuf$Property, ap2), nameResolver);
            if (str == null) {
                return null;
            }
        } else {
            str = nameResolver.getString(field.getDesc());
        }
        return new d51.a(nameResolver.getString(name), str);
    }

    public final d51.b e(ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, ap2 ap2) {
        String str;
        k21.i(protoBuf$Function, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Function, JvmProtoBuf.JvmMethodSignature> cVar = JvmProtoBuf.methodSignature;
        k21.h(cVar, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) fv1.a(protoBuf$Function, cVar);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? protoBuf$Function.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List list = m.k(jv1.g(protoBuf$Function, ap2));
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
            k21.h(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(n.q(valueParameterList, 10));
            for (T t : valueParameterList) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                arrayList.add(jv1.m(t, ap2));
            }
            List<ProtoBuf$Type> list2 = CollectionsKt___CollectionsKt.k0(list, arrayList);
            ArrayList arrayList2 = new ArrayList(n.q(list2, 10));
            for (ProtoBuf$Type protoBuf$Type : list2) {
                String g = g(protoBuf$Type, nameResolver);
                if (g == null) {
                    return null;
                }
                arrayList2.add(g);
            }
            String g2 = g(jv1.i(protoBuf$Function, ap2), nameResolver);
            if (g2 == null) {
                return null;
            }
            str = k21.r(CollectionsKt___CollectionsKt.Z(arrayList2, "", jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, null, 56, null), g2);
        } else {
            str = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new d51.b(nameResolver.getString(name), str);
    }
}
