package tb;

import java.util.List;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class zi extends GivenFunctionsMemberScope {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final og1 d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final og1 a() {
            return zi.d;
        }
    }

    static {
        og1 f = og1.f("clone");
        k21.h(f, "identifier(\"clone\")");
        d = f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zi(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        super(storageManager, classDescriptor);
        k21.i(storageManager, "storageManager");
        k21.i(classDescriptor, "containingClass");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    public List<FunctionDescriptor> b() {
        fb2 F = fb2.F(e(), Annotations.Companion.b(), Companion.a(), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        F.l(null, e().getThisAsReceiverParameter(), m.g(), m.g(), DescriptorUtilsKt.g(e()).i(), Modality.OPEN, g60.PROTECTED);
        return l.e(F);
    }
}
