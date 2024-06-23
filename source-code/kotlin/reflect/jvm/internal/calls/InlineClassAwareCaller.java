package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import com.lzy.okgo.cache.CacheEntity;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", CacheEntity.DATA, "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 1, 16})
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.reflect.jvm.internal.calls.Caller<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if ((r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0078;
     */
    public InlineClassAwareCaller(CallableMemberDescriptor callableMemberDescriptor, Caller<? extends M> caller2, boolean z) {
        BoxUnboxData boxUnboxData;
        Class<?> inlineClass;
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        Intrinsics.checkParameterIsNotNull(caller2, "caller");
        this.caller = caller2;
        this.isDefault = z;
        InlineClassAwareCaller<M> inlineClassAwareCaller = this;
        KotlinType returnType = callableMemberDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = InlineClassAwareCallerKt.toInlineClass(returnType);
        Method boxMethod = inlineClass2 != null ? InlineClassAwareCallerKt.getBoxMethod(inlineClass2, callableMemberDescriptor) : null;
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            boxUnboxData = new BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], boxMethod);
        } else {
            Caller<M> caller3 = inlineClassAwareCaller.caller;
            int i = -1;
            if (!(caller3 instanceof CallerImpl.Method.BoundStatic)) {
                if (!(callableMemberDescriptor instanceof ConstructorDescriptor)) {
                    if (callableMemberDescriptor.getDispatchReceiverParameter() != null && !(inlineClassAwareCaller.caller instanceof BoundCaller)) {
                        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
                        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "descriptor.containingDeclaration");
                        if (!InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                            i = 1;
                        }
                    }
                }
                i = 0;
            }
            int i2 = inlineClassAwareCaller.isDefault ? 2 : 0;
            ArrayList arrayList = new ArrayList();
            ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
            KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
                Intrinsics.checkExpressionValueIsNotNull(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    DeclarationDescriptor containingDeclaration2 = constructedClass.getContainingDeclaration();
                    if (containingDeclaration2 != null) {
                        arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                }
            } else {
                DeclarationDescriptor containingDeclaration3 = callableMemberDescriptor.getContainingDeclaration();
                Intrinsics.checkExpressionValueIsNotNull(containingDeclaration3, "descriptor.containingDeclaration");
                if (containingDeclaration3 instanceof ClassDescriptor) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration3;
                    if (classDescriptor.isInline()) {
                        arrayList.add(classDescriptor.getDefaultType());
                    }
                }
            }
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getType());
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size() + i + i2;
            InlineClassAwareCaller<M> inlineClassAwareCaller2 = inlineClassAwareCaller;
            if (CallerKt.getArity(inlineClassAwareCaller2) == size) {
                IntRange until = RangesKt.until(Math.max(i, 0), arrayList2.size() + i);
                Method[] methodArr = new Method[size];
                for (int i3 = 0; i3 < size; i3++) {
                    methodArr[i3] = (!until.contains(i3) || (inlineClass = InlineClassAwareCallerKt.toInlineClass((KotlinType) arrayList2.get(i3 - i))) == null) ? null : InlineClassAwareCallerKt.getUnboxMethod(inlineClass, callableMemberDescriptor);
                }
                boxUnboxData = new BoxUnboxData(until, methodArr, boxMethod);
            } else {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(inlineClassAwareCaller2) + " != " + size + '\n' + "Calling: " + callableMemberDescriptor + '\n' + "Parameter types: " + inlineClassAwareCaller.getParameterTypes() + ")\n" + "Default: " + inlineClassAwareCaller.isDefault);
            }
        }
        this.data = boxUnboxData;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public M getMember() {
        return this.caller.getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 1, 16})
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkParameterIsNotNull(intRange, "argumentRange");
            Intrinsics.checkParameterIsNotNull(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] objArr) {
        Object invoke;
        Intrinsics.checkParameterIsNotNull(objArr, "args");
        BoxUnboxData boxUnboxData = this.data;
        IntRange component1 = boxUnboxData.component1();
        Method[] component2 = boxUnboxData.component2();
        Method component3 = boxUnboxData.component3();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        if (copyOf != null) {
            int first = component1.getFirst();
            int last = component1.getLast();
            if (first <= last) {
                while (true) {
                    Method method = component2[first];
                    Object obj = objArr[first];
                    if (!(method == null || obj == null)) {
                        obj = method.invoke(obj, new Object[0]);
                    }
                    copyOf[first] = obj;
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            Object call = this.caller.call(copyOf);
            return (component3 == null || (invoke = component3.invoke(null, new Object[]{call})) == null) ? call : invoke;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
}
