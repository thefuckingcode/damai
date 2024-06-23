package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;
import tb.i22;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "", "invoke", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1 extends Lambda implements Function1<PropertyDescriptor, CharSequence> {
    public static final KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1 INSTANCE = new KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1();

    KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull PropertyDescriptor propertyDescriptor) {
        k21.i(propertyDescriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.a(propertyDescriptor) + " | " + i22.INSTANCE.f(propertyDescriptor).a();
    }
}
