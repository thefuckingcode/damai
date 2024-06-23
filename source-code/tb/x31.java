package tb;

import java.util.Collection;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

public final class x31 {
    public static final x31 INSTANCE = new x31();

    private x31() {
    }

    public static /* synthetic */ ClassDescriptor h(x31 x31, en0 en0, b bVar, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return x31.g(en0, bVar, num);
    }

    public final ClassDescriptor a(ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "mutable");
        en0 p = w31.INSTANCE.p(f60.m(classDescriptor));
        if (p != null) {
            ClassDescriptor o = DescriptorUtilsKt.g(classDescriptor).o(p);
            k21.h(o, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return o;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "mutable" + " collection");
    }

    public final ClassDescriptor b(ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "readOnly");
        en0 q = w31.INSTANCE.q(f60.m(classDescriptor));
        if (q != null) {
            ClassDescriptor o = DescriptorUtilsKt.g(classDescriptor).o(q);
            k21.h(o, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return o;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + "read-only" + " collection");
    }

    public final boolean c(ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "mutable");
        return w31.INSTANCE.l(f60.m(classDescriptor));
    }

    public final boolean d(g61 g61) {
        k21.i(g61, "type");
        ClassDescriptor f = bp2.f(g61);
        return f != null && c(f);
    }

    public final boolean e(ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "readOnly");
        return w31.INSTANCE.m(f60.m(classDescriptor));
    }

    public final boolean f(g61 g61) {
        k21.i(g61, "type");
        ClassDescriptor f = bp2.f(g61);
        return f != null && e(f);
    }

    public final ClassDescriptor g(en0 en0, b bVar, Integer num) {
        oi oiVar;
        k21.i(en0, "fqName");
        k21.i(bVar, "builtIns");
        if (num == null || !k21.d(en0, w31.INSTANCE.i())) {
            oiVar = w31.INSTANCE.n(en0);
        } else {
            c cVar = c.INSTANCE;
            oiVar = c.a(num.intValue());
        }
        if (oiVar != null) {
            return bVar.o(oiVar.b());
        }
        return null;
    }

    public final Collection<ClassDescriptor> i(en0 en0, b bVar) {
        k21.i(en0, "fqName");
        k21.i(bVar, "builtIns");
        ClassDescriptor h = h(this, en0, bVar, null, 4, null);
        if (h == null) {
            return e0.d();
        }
        en0 q = w31.INSTANCE.q(DescriptorUtilsKt.j(h));
        if (q == null) {
            return d0.c(h);
        }
        ClassDescriptor o = bVar.o(q);
        k21.h(o, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return m.j(h, o);
    }
}
