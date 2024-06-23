package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import org.jetbrains.annotations.NotNull;
import tb.ne0;

/* compiled from: Taobao */
public final class z5 {
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final NotFoundClasses b;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf$Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf$Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf$Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public z5(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses) {
        k21.i(moduleDescriptor, "module");
        k21.i(notFoundClasses, "notFoundClasses");
        this.a = moduleDescriptor;
        this.b = notFoundClasses;
    }

    private final boolean b(om<?> omVar, g61 g61, ProtoBuf$Annotation.Argument.Value value) {
        ProtoBuf$Annotation.Argument.Value.Type type = value.getType();
        int i = type == null ? -1 : a.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 10) {
            ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor == null || b.q0(classDescriptor)) {
                return true;
            }
            return false;
        } else if (i != 13) {
            return k21.d(omVar.a(this.a), g61);
        } else {
            if ((omVar instanceof w7) && ((List) ((w7) omVar).b()).size() == value.getArrayElementList().size()) {
                g61 k = c().k(g61);
                k21.h(k, "builtIns.getArrayElementType(expectedType)");
                w7 w7Var = (w7) omVar;
                w11 w11 = m.h((Collection) w7Var.b());
                if (!(w11 instanceof Collection) || !((Collection) w11).isEmpty()) {
                    Iterator it = w11.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((r11) it).nextInt();
                        ProtoBuf$Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                        k21.h(arrayElement, "value.getArrayElement(i)");
                        if (!b((om) ((List) w7Var.b()).get(nextInt), k, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(k21.r("Deserialized ArrayValue should have the same number of elements as the original array value: ", omVar).toString());
            }
        }
        return true;
    }

    private final b c() {
        return this.a.getBuiltIns();
    }

    private final Pair<og1, om<?>> d(ProtoBuf$Annotation.Argument argument, Map<og1, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) map.get(qg1.b(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        og1 b2 = qg1.b(nameResolver, argument.getNameId());
        g61 type = valueParameterDescriptor.getType();
        k21.h(type, "parameter.type");
        ProtoBuf$Annotation.Argument.Value value = argument.getValue();
        k21.h(value, "proto.value");
        return new Pair<>(b2, g(type, value, nameResolver));
    }

    private final ClassDescriptor e(oi oiVar) {
        return FindClassInModuleKt.c(this.a, oiVar, this.b);
    }

    private final om<?> g(g61 g61, ProtoBuf$Annotation.Argument.Value value, NameResolver nameResolver) {
        om<?> f = f(g61, value, nameResolver);
        if (!b(f, g61, value)) {
            f = null;
        }
        if (f != null) {
            return f;
        }
        ne0.a aVar = ne0.Companion;
        return aVar.a("Unexpected argument value: actual type " + value.getType() + " != expected type " + g61);
    }

    @NotNull
    public final AnnotationDescriptor a(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver) {
        k21.i(protoBuf$Annotation, "proto");
        k21.i(nameResolver, "nameResolver");
        ClassDescriptor e = e(qg1.a(nameResolver, protoBuf$Annotation.getId()));
        Map map = x.i();
        if (protoBuf$Annotation.getArgumentCount() != 0 && !me0.r(e) && f60.t(e)) {
            Collection<ClassConstructorDescriptor> constructors = e.getConstructors();
            k21.h(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) k.p0(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                k21.h(valueParameters, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(valueParameters, 10)), 16));
                for (T t : valueParameters) {
                    linkedHashMap.put(t.getName(), t);
                }
                List<ProtoBuf$Annotation.Argument> argumentList = protoBuf$Annotation.getArgumentList();
                k21.h(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (T t2 : argumentList) {
                    k21.h(t2, AdvanceSetting.NETWORK_TYPE);
                    Pair<og1, om<?>> d = d(t2, linkedHashMap, nameResolver);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
                map = x.r(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.a(e.getDefaultType(), map, SourceElement.NO_SOURCE);
    }

    @NotNull
    public final om<?> f(@NotNull g61 g61, @NotNull ProtoBuf$Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        om<?> zdVar;
        k21.i(g61, "expectedType");
        k21.i(value, "value");
        k21.i(nameResolver, "nameResolver");
        Boolean g = bj0.IS_UNSIGNED.d(value.getFlags());
        k21.h(g, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = g.booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : a.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) ((int) value.getIntValue());
                if (booleanValue) {
                    zdVar = new kp2(intValue);
                    break;
                } else {
                    zdVar = new zd(intValue);
                    break;
                }
            case 2:
                return new nh((char) ((int) value.getIntValue()));
            case 3:
                short intValue2 = (short) ((int) value.getIntValue());
                if (booleanValue) {
                    zdVar = new fq2(intValue2);
                    break;
                } else {
                    zdVar = new qa2(intValue2);
                    break;
                }
            case 4:
                int intValue3 = (int) value.getIntValue();
                return booleanValue ? new xp2(intValue3) : new z11(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new aq2(intValue4) : new ka1(intValue4);
            case 6:
                return new nj0(value.getFloatValue());
            case 7:
                return new pb0(value.getDoubleValue());
            case 8:
                return new mc(value.getIntValue() != 0);
            case 9:
                return new bg2(nameResolver.getString(value.getStringValue()));
            case 10:
                return new n51(qg1.a(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new ae0(qg1.a(nameResolver, value.getClassId()), qg1.b(nameResolver, value.getEnumValueId()));
            case 12:
                ProtoBuf$Annotation annotation = value.getAnnotation();
                k21.h(annotation, "value.annotation");
                return new c6(a(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<ProtoBuf$Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                k21.h(arrayElementList, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(n.q(arrayElementList, 10));
                for (T t : arrayElementList) {
                    ib2 i = c().i();
                    k21.h(i, "builtIns.anyType");
                    k21.h(t, AdvanceSetting.NETWORK_TYPE);
                    arrayList.add(f(i, t, nameResolver));
                }
                return constantValueFactory.b(arrayList, g61);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + g61 + ')').toString());
        }
        return zdVar;
    }
}
