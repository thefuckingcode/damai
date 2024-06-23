package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tb.dz1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/Lazy;", "viewModels", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ActivityViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        k21.i(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        k21.o(4, "VM");
        return new ViewModelLazy(dz1.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        k21.i(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        k21.o(4, "VM");
        return new ViewModelLazy(dz1.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), function0);
    }
}
