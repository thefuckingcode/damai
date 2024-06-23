package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "t", "Ltb/ur2;", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer<T> {
    final /* synthetic */ Function1 $onChanged;

    public LiveDataKt$observe$wrappedObserver$1(Function1 function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
