package tb;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d51;

/* compiled from: Taobao */
public abstract class h51 {

    /* compiled from: Taobao */
    public static final class a extends h51 {
        @NotNull
        private final Field a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull Field field) {
            super(null);
            k21.i(field, "field");
            this.a = field;
        }

        @Override // tb.h51
        @NotNull
        public String a() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            k21.h(name, "field.name");
            sb.append(t41.a(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            k21.h(type, "field.type");
            sb.append(ReflectClassUtilKt.c(type));
            return sb.toString();
        }

        @NotNull
        public final Field b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends h51 {
        @NotNull
        private final Method a;
        @Nullable
        private final Method b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method method, @Nullable Method method2) {
            super(null);
            k21.i(method, "getterMethod");
            this.a = method;
            this.b = method2;
        }

        @Override // tb.h51
        @NotNull
        public String a() {
            return RuntimeTypeMapperKt.b(this.a);
        }

        @NotNull
        public final Method b() {
            return this.a;
        }

        @Nullable
        public final Method c() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends h51 {
        private final String a;
        @NotNull
        private final PropertyDescriptor b;
        @NotNull
        private final ProtoBuf$Property c;
        @NotNull
        private final JvmProtoBuf.JvmPropertySignature d;
        @NotNull
        private final NameResolver e;
        @NotNull
        private final ap2 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull PropertyDescriptor propertyDescriptor, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull JvmProtoBuf.JvmPropertySignature jvmPropertySignature, @NotNull NameResolver nameResolver, @NotNull ap2 ap2) {
            super(null);
            String str;
            k21.i(propertyDescriptor, "descriptor");
            k21.i(protoBuf$Property, "proto");
            k21.i(jvmPropertySignature, SocialOperation.GAME_SIGNATURE);
            k21.i(nameResolver, "nameResolver");
            k21.i(ap2, "typeTable");
            this.b = propertyDescriptor;
            this.c = protoBuf$Property;
            this.d = jvmPropertySignature;
            this.e = nameResolver;
            this.f = ap2;
            if (jvmPropertySignature.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                k21.h(getter, "signature.getter");
                sb.append(nameResolver.getString(getter.getName()));
                JvmProtoBuf.JvmMethodSignature getter2 = jvmPropertySignature.getGetter();
                k21.h(getter2, "signature.getter");
                sb.append(nameResolver.getString(getter2.getDesc()));
                str = sb.toString();
            } else {
                d51.a d2 = i51.d(i51.INSTANCE, protoBuf$Property, nameResolver, ap2, false, 8, null);
                if (d2 != null) {
                    String d3 = d2.d();
                    str = t41.a(d3) + c() + "()" + d2.e();
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + propertyDescriptor);
                }
            }
            this.a = str;
        }

        private final String c() {
            String str;
            DeclarationDescriptor containingDeclaration = this.b.getContainingDeclaration();
            k21.h(containingDeclaration, "descriptor.containingDeclaration");
            if (k21.d(this.b.getVisibility(), g60.INTERNAL) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                ProtoBuf$Class r = ((DeserializedClassDescriptor) containingDeclaration).r();
                GeneratedMessageLite.c<ProtoBuf$Class, Integer> cVar = JvmProtoBuf.classModuleName;
                k21.h(cVar, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) fv1.a(r, cVar);
                if (num == null || (str = this.e.getString(num.intValue())) == null) {
                    str = js2.MAIN;
                }
                return "$" + rg1.a(str);
            } else if (!k21.d(this.b.getVisibility(), g60.PRIVATE) || !(containingDeclaration instanceof PackageFragmentDescriptor)) {
                return "";
            } else {
                PropertyDescriptor propertyDescriptor = this.b;
                Objects.requireNonNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                DeserializedContainerSource containerSource = ((r60) propertyDescriptor).getContainerSource();
                if (!(containerSource instanceof g51)) {
                    return "";
                }
                g51 g51 = (g51) containerSource;
                if (g51.b() == null) {
                    return "";
                }
                return "$" + g51.d().b();
            }
        }

        @Override // tb.h51
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final PropertyDescriptor b() {
            return this.b;
        }

        @NotNull
        public final NameResolver d() {
            return this.e;
        }

        @NotNull
        public final ProtoBuf$Property e() {
            return this.c;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature f() {
            return this.d;
        }

        @NotNull
        public final ap2 g() {
            return this.f;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends h51 {
        @NotNull
        private final JvmFunctionSignature.c a;
        @Nullable
        private final JvmFunctionSignature.c b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(@NotNull JvmFunctionSignature.c cVar, @Nullable JvmFunctionSignature.c cVar2) {
            super(null);
            k21.i(cVar, "getterSignature");
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // tb.h51
        @NotNull
        public String a() {
            return this.a.a();
        }

        @NotNull
        public final JvmFunctionSignature.c b() {
            return this.a;
        }

        @Nullable
        public final JvmFunctionSignature.c c() {
            return this.b;
        }
    }

    private h51() {
    }

    @NotNull
    public abstract String a();

    public /* synthetic */ h51(m40 m40) {
        this();
    }
}
