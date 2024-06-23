package kotlin.reflect.jvm.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.hz1;
import tb.jl1;
import tb.k21;
import tb.og1;
import tb.wt2;

/* compiled from: Taobao */
public final class ReflectionObjectRenderer {
    @NotNull
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    private static final DescriptorRenderer a = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    private ReflectionObjectRenderer() {
    }

    private final void a(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            g61 type = receiverParameterDescriptor.getType();
            k21.h(type, "receiver.type");
            sb.append(h(type));
            sb.append(".");
        }
    }

    private final void b(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor g = wt2.g(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        a(sb, g);
        boolean z = (g == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append(jl1.BRACKET_START_STR);
        }
        a(sb, extensionReceiverParameter);
        if (z) {
            sb.append(jl1.BRACKET_END_STR);
        }
    }

    private final String c(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyDescriptor) {
            return g((PropertyDescriptor) callableDescriptor);
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return d((FunctionDescriptor) callableDescriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + callableDescriptor).toString());
    }

    @NotNull
    public final String d(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        og1 name = functionDescriptor.getName();
        k21.h(name, "descriptor.name");
        sb.append(descriptorRenderer.f(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        k21.h(valueParameters, "descriptor.valueParameters");
        Appendable unused = CollectionsKt___CollectionsKt.X(valueParameters, sb, AVFSCacheConstants.COMMA_SEP, jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48, null);
        sb.append(": ");
        g61 returnType = functionDescriptor.getReturnType();
        k21.f(returnType);
        k21.h(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.h(returnType));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String e(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        k21.h(valueParameters, "invoke.valueParameters");
        Appendable unused = CollectionsKt___CollectionsKt.X(valueParameters, sb, AVFSCacheConstants.COMMA_SEP, jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48, null);
        sb.append(" -> ");
        g61 returnType = functionDescriptor.getReturnType();
        k21.f(returnType);
        k21.h(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.h(returnType));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String f(@NotNull KParameterImpl kParameterImpl) {
        k21.i(kParameterImpl, "parameter");
        StringBuilder sb = new StringBuilder();
        int i = hz1.$EnumSwitchMapping$0[kParameterImpl.getKind().ordinal()];
        if (i == 1) {
            sb.append("extension receiver parameter");
        } else if (i == 2) {
            sb.append("instance parameter");
        } else if (i == 3) {
            sb.append("parameter #" + kParameterImpl.getIndex() + ' ' + kParameterImpl.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.c(kParameterImpl.b().i()));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String g(@NotNull PropertyDescriptor propertyDescriptor) {
        k21.i(propertyDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(propertyDescriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, propertyDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        og1 name = propertyDescriptor.getName();
        k21.h(name, "descriptor.name");
        sb.append(descriptorRenderer.f(name, true));
        sb.append(": ");
        g61 type = propertyDescriptor.getType();
        k21.h(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.h(type));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String h(@NotNull g61 g61) {
        k21.i(g61, "type");
        return a.g(g61);
    }
}
