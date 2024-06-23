package tb;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ff;

/* compiled from: Taobao */
public final class w01<M extends Member> implements Caller<M> {
    private final a a;
    private final Caller<M> b;
    private final boolean c;

    /* compiled from: Taobao */
    private static final class a {
        @NotNull
        private final w11 a;
        @NotNull
        private final Method[] b;
        @Nullable
        private final Method c;

        public a(@NotNull w11 w11, @NotNull Method[] methodArr, @Nullable Method method) {
            k21.i(w11, "argumentRange");
            k21.i(methodArr, "unbox");
            this.a = w11;
            this.b = methodArr;
            this.c = method;
        }

        @NotNull
        public final w11 a() {
            return this.a;
        }

        @NotNull
        public final Method[] b() {
            return this.b;
        }

        @Nullable
        public final Method c() {
            return this.c;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.reflect.jvm.internal.calls.Caller<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        if ((r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x006d;
     */
    public w01(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Caller<? extends M> caller, boolean z) {
        a aVar;
        Class<?> i;
        k21.i(callableMemberDescriptor, "descriptor");
        k21.i(caller, "caller");
        this.b = caller;
        this.c = z;
        g61 returnType = callableMemberDescriptor.getReturnType();
        k21.f(returnType);
        k21.h(returnType, "descriptor.returnType!!");
        Class<?> i2 = x01.i(returnType);
        Method d = i2 != null ? x01.d(i2, callableMemberDescriptor) : null;
        if (z01.a(callableMemberDescriptor)) {
            aVar = new a(w11.Companion.a(), new Method[0], d);
        } else {
            int i3 = -1;
            int i4 = 1;
            if (!(caller instanceof ff.h.c)) {
                if (!(callableMemberDescriptor instanceof ConstructorDescriptor)) {
                    if (callableMemberDescriptor.getDispatchReceiverParameter() != null && !(caller instanceof BoundCaller)) {
                        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
                        k21.h(containingDeclaration, "descriptor.containingDeclaration");
                        if (!z01.b(containingDeclaration)) {
                            i3 = 1;
                        }
                    }
                }
                i3 = 0;
            }
            int i5 = (z ? 2 : 0) + ((!(callableMemberDescriptor instanceof FunctionDescriptor) || !((FunctionDescriptor) callableMemberDescriptor).isSuspend()) ? 0 : i4);
            ArrayList arrayList = new ArrayList();
            ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
            g61 type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
                k21.h(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    DeclarationDescriptor containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                }
            } else {
                DeclarationDescriptor containingDeclaration3 = callableMemberDescriptor.getContainingDeclaration();
                k21.h(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof ClassDescriptor) && z01.b(containingDeclaration3)) {
                    arrayList.add(((ClassDescriptor) containingDeclaration3).getDefaultType());
                }
            }
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            k21.h(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getType());
            }
            int size = arrayList.size() + i3 + i5;
            if (gf.a(this) == size) {
                w11 w11 = ww1.h(Math.max(i3, 0), arrayList.size() + i3);
                Method[] methodArr = new Method[size];
                for (int i6 = 0; i6 < size; i6++) {
                    methodArr[i6] = (!w11.f(i6) || (i = x01.i((g61) arrayList.get(i6 - i3))) == null) ? null : x01.f(i, callableMemberDescriptor);
                }
                aVar = new a(w11, methodArr, d);
            } else {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + gf.a(this) + " != " + size + '\n' + "Calling: " + callableMemberDescriptor + '\n' + "Parameter types: " + getParameterTypes() + ")\n" + "Default: " + this.c);
            }
        }
        this.a = aVar;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object invoke;
        k21.i(objArr, "args");
        a aVar = this.a;
        w11 a2 = aVar.a();
        Method[] b2 = aVar.b();
        Method c2 = aVar.c();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        k21.h(copyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int a3 = a2.a();
        int b3 = a2.b();
        if (a3 <= b3) {
            while (true) {
                Method method = b2[a3];
                Object obj = objArr[a3];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        k21.h(returnType, "method.returnType");
                        obj = wt2.e(returnType);
                    }
                }
                copyOf[a3] = obj;
                if (a3 == b3) {
                    break;
                }
                a3++;
            }
        }
        Object call = this.b.call(copyOf);
        return (c2 == null || (invoke = c2.invoke(null, new Object[]{call})) == null) ? call : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public M getMember() {
        return this.b.getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.b.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.b.getReturnType();
    }
}
