package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;

/* compiled from: Taobao */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = new a();

    /* compiled from: Taobao */
    static class a implements SignaturePropagator {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i == 5 || i == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        public void reportSignatureErrors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list) {
            if (callableMemberDescriptor == null) {
                a(5);
            }
            if (list == null) {
                a(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        @NotNull
        public b resolvePropagatedSignature(@NotNull JavaMethod javaMethod, @NotNull ClassDescriptor classDescriptor, @NotNull g61 g61, @Nullable g61 g612, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
            if (javaMethod == null) {
                a(0);
            }
            if (classDescriptor == null) {
                a(1);
            }
            if (g61 == null) {
                a(2);
            }
            if (list == null) {
                a(3);
            }
            if (list2 == null) {
                a(4);
            }
            return new b(g61, g612, list, list2, Collections.emptyList(), false);
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private final g61 a;
        private final g61 b;
        private final List<ValueParameterDescriptor> c;
        private final List<TypeParameterDescriptor> d;
        private final List<String> e;
        private final boolean f;

        public b(@NotNull g61 g61, @Nullable g61 g612, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2, @NotNull List<String> list3, boolean z) {
            if (g61 == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.a = g61;
            this.b = g612;
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = z;
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i == 4) {
                objArr[1] = "getReturnType";
            } else if (i == 5) {
                objArr[1] = "getValueParameters";
            } else if (i == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (!(i == 4 || i == 5 || i == 6 || i == 7)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 4 || i == 5 || i == 6 || i == 7) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @NotNull
        public List<String> b() {
            List<String> list = this.e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        @Nullable
        public g61 c() {
            return this.b;
        }

        @NotNull
        public g61 d() {
            g61 g61 = this.a;
            if (g61 == null) {
                a(4);
            }
            return g61;
        }

        @NotNull
        public List<TypeParameterDescriptor> e() {
            List<TypeParameterDescriptor> list = this.d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        @NotNull
        public List<ValueParameterDescriptor> f() {
            List<ValueParameterDescriptor> list = this.c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f;
        }
    }

    void reportSignatureErrors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list);

    @NotNull
    b resolvePropagatedSignature(@NotNull JavaMethod javaMethod, @NotNull ClassDescriptor classDescriptor, @NotNull g61 g61, @Nullable g61 g612, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2);
}
