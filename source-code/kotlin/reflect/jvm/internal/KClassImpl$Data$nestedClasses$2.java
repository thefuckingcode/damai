package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import tb.f60;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$nestedClasses$2 extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$nestedClasses$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KClassImpl<? extends java.lang.Object>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KClassImpl<? extends Object>> invoke() {
        Collection a = ResolutionScope.a.a(this.this$0.n().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
        ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
        for (Object obj : a) {
            if (!f60.B((DeclarationDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : arrayList) {
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> n = wt2.n((ClassDescriptor) declarationDescriptor);
            KClassImpl kClassImpl = n != null ? new KClassImpl(n) : null;
            if (kClassImpl != null) {
                arrayList2.add(kClassImpl);
            }
        }
        return arrayList2;
    }
}
