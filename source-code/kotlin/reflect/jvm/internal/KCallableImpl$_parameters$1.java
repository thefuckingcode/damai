package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.q;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.bl;
import tb.k21;
import tb.wt2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KCallableImpl$_parameters$1 extends Lambda implements Function0<ArrayList<KParameter>> {
    final /* synthetic */ KCallableImpl this$0;

    /* compiled from: Taobao */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return bl.a(t.getName(), t2.getName());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$_parameters$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ArrayList<KParameter> invoke() {
        int i;
        final CallableMemberDescriptor i2 = this.this$0.i();
        ArrayList<KParameter> arrayList = new ArrayList<>();
        final int i3 = 0;
        if (!this.this$0.k()) {
            final ReceiverParameterDescriptor g = wt2.g(i2);
            if (g != null) {
                arrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, new Function0<ParameterDescriptor>() {
                    /* class kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.AnonymousClass1 */

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final ParameterDescriptor invoke() {
                        return g;
                    }
                }));
                i = 1;
            } else {
                i = 0;
            }
            final ReceiverParameterDescriptor extensionReceiverParameter = i2.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ParameterDescriptor>() {
                    /* class kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.AnonymousClass2 */

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final ParameterDescriptor invoke() {
                        return extensionReceiverParameter;
                    }
                }));
                i++;
            }
        } else {
            i = 0;
        }
        List<ValueParameterDescriptor> valueParameters = i2.getValueParameters();
        k21.h(valueParameters, "descriptor.valueParameters");
        int size = valueParameters.size();
        while (i3 < size) {
            arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.VALUE, new Function0<ParameterDescriptor>() {
                /* class kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.AnonymousClass3 */

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ParameterDescriptor invoke() {
                    ValueParameterDescriptor valueParameterDescriptor = i2.getValueParameters().get(i3);
                    k21.h(valueParameterDescriptor, "descriptor.valueParameters[i]");
                    return valueParameterDescriptor;
                }
            }));
            i3++;
            i++;
        }
        if (this.this$0.j() && (i2 instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
            q.u(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
