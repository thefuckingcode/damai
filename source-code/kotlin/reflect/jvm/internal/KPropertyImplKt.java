package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import tb.f60;
import tb.ff;
import tb.g21;
import tb.g60;
import tb.h51;
import tb.i22;
import tb.i51;
import tb.k21;
import tb.r60;
import tb.x01;
import tb.yk2;
import tb.z01;

public final class KPropertyImplKt {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    public static final Caller<?> c(KPropertyImpl.a<?, ?> aVar, boolean z) {
        Caller caller;
        JvmFunctionSignature.c cVar;
        Method method;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature;
        Method g;
        Method f;
        if (KDeclarationContainerImpl.Companion.a().matches(aVar.m().r())) {
            return yk2.INSTANCE;
        }
        KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1 = new KPropertyImplKt$computeCallerForAccessor$1(aVar);
        KPropertyImplKt$computeCallerForAccessor$3 kPropertyImplKt$computeCallerForAccessor$3 = new KPropertyImplKt$computeCallerForAccessor$3(aVar, z, new KPropertyImplKt$computeCallerForAccessor$2(aVar), kPropertyImplKt$computeCallerForAccessor$1);
        h51 f2 = i22.INSTANCE.f(aVar.m().i());
        if (f2 instanceof h51.c) {
            h51.c cVar2 = (h51.c) f2;
            JvmProtoBuf.JvmPropertySignature f3 = cVar2.f();
            if (z) {
                if (f3.hasGetter()) {
                    jvmMethodSignature = f3.getGetter();
                    g = jvmMethodSignature != null ? aVar.m().g().g(cVar2.d().getString(jvmMethodSignature.getName()), cVar2.d().getString(jvmMethodSignature.getDesc())) : null;
                    if (g == null) {
                        if (!z01.d(aVar.m().i()) || !k21.d(aVar.m().i().getVisibility(), g60.INTERNAL)) {
                            Field q = aVar.m().q();
                            if (q != null) {
                                caller = kPropertyImplKt$computeCallerForAccessor$3.invoke(q);
                            } else {
                                throw new KotlinReflectionInternalError("No accessors or field is found for property " + aVar.m());
                            }
                        } else {
                            Class<?> h = x01.h(aVar.m().i().getContainingDeclaration());
                            if (h == null || (f = x01.f(h, aVar.m().i())) == null) {
                                throw new KotlinReflectionInternalError("Underlying property of inline class " + aVar.m() + " should have a field");
                            } else if (aVar.k()) {
                                caller = new g21.a(f, d(aVar));
                            } else {
                                caller = new g21.b(f);
                            }
                        }
                    } else if (!Modifier.isStatic(g.getModifiers())) {
                        if (aVar.k()) {
                            caller = new ff.h.a(g, d(aVar));
                        } else {
                            caller = new ff.h.d(g);
                        }
                    } else if (kPropertyImplKt$computeCallerForAccessor$1.invoke()) {
                        if (aVar.k()) {
                            caller = new ff.h.b(g);
                        } else {
                            caller = new ff.h.e(g);
                        }
                    } else if (aVar.k()) {
                        caller = new ff.h.c(g, d(aVar));
                    } else {
                        caller = new ff.h.f(g);
                    }
                }
            } else if (f3.hasSetter()) {
                jvmMethodSignature = f3.getSetter();
                if (jvmMethodSignature != null) {
                }
                if (g == null) {
                }
            }
            jvmMethodSignature = null;
            if (jvmMethodSignature != null) {
            }
            if (g == null) {
            }
        } else if (f2 instanceof h51.a) {
            caller = kPropertyImplKt$computeCallerForAccessor$3.invoke(((h51.a) f2).b());
        } else if (f2 instanceof h51.b) {
            if (z) {
                method = ((h51.b) f2).b();
            } else {
                h51.b bVar = (h51.b) f2;
                method = bVar.c();
                if (method == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + bVar.b());
                }
            }
            if (aVar.k()) {
                caller = new ff.h.a(method, d(aVar));
            } else {
                caller = new ff.h.d(method);
            }
        } else if (f2 instanceof h51.d) {
            if (z) {
                cVar = ((h51.d) f2).b();
            } else {
                cVar = ((h51.d) f2).c();
                if (cVar == null) {
                    throw new KotlinReflectionInternalError("No setter found for property " + aVar.m());
                }
            }
            Method g2 = aVar.m().g().g(cVar.c(), cVar.b());
            if (g2 != null) {
                Modifier.isStatic(g2.getModifiers());
                if (aVar.k()) {
                    return new ff.h.a(g2, d(aVar));
                }
                return new ff.h.d(g2);
            }
            throw new KotlinReflectionInternalError("No accessor found for property " + aVar.m());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return x01.c(caller, aVar.l(), false, 2, null);
    }

    public static final Object d(KPropertyImpl.a<?, ?> aVar) {
        k21.i(aVar, "$this$boundReceiver");
        return aVar.m().m();
    }

    public static final boolean e(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration, "containingDeclaration");
        if (!f60.x(containingDeclaration)) {
            return false;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if ((f60.C(containingDeclaration2) || f60.t(containingDeclaration2)) && (!(propertyDescriptor instanceof r60) || !i51.f(((r60) propertyDescriptor).getProto()))) {
            return false;
        }
        return true;
    }
}
