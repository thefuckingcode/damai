package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.Nullable;
import tb.d51;
import tb.h51;
import tb.i22;
import tb.i51;
import tb.i60;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"V", "Ljava/lang/reflect/Field;", "invoke", "()Ljava/lang/reflect/Field;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KPropertyImpl$_javaField$1 extends Lambda implements Function0<Field> {
    final /* synthetic */ KPropertyImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImpl$_javaField$1(KPropertyImpl kPropertyImpl) {
        super(0);
        this.this$0 = kPropertyImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Field invoke() {
        Class<?> cls;
        h51 f = i22.INSTANCE.f(this.this$0.i());
        if (f instanceof h51.c) {
            h51.c cVar = (h51.c) f;
            PropertyDescriptor b = cVar.b();
            d51.a d = i51.d(i51.INSTANCE, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
            if (d == null) {
                return null;
            }
            if (i60.e(b) || i51.f(cVar.e())) {
                cls = this.this$0.g().getJClass().getEnclosingClass();
            } else {
                DeclarationDescriptor containingDeclaration = b.getContainingDeclaration();
                if (containingDeclaration instanceof ClassDescriptor) {
                    cls = wt2.n((ClassDescriptor) containingDeclaration);
                } else {
                    cls = this.this$0.g().getJClass();
                }
            }
            if (cls == null) {
                return null;
            }
            try {
                return cls.getDeclaredField(d.c());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        } else if (f instanceof h51.a) {
            return ((h51.a) f).b();
        } else {
            if ((f instanceof h51.b) || (f instanceof h51.d)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
