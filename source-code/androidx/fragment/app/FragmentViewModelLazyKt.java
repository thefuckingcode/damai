package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\bø\u0001\u0000\u001a4\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\bø\u0001\u0000\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownerProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/Lazy;", "viewModels", "activityViewModels", "Lkotlin/reflect/KClass;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "createViewModelLazy", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        k21.i(fragment, "$this$activityViewModels");
        k21.o(4, "VM");
        KClass b = dz1.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        k21.i(fragment, "$this$activityViewModels");
        k21.o(4, "VM");
        KClass b = dz1.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(@NotNull Fragment fragment, @NotNull KClass<VM> kClass, @NotNull Function0<? extends ViewModelStore> function0, @Nullable Function0<? extends ViewModelProvider.Factory> function02) {
        k21.i(fragment, "$this$createViewModelLazy");
        k21.i(kClass, "viewModelClass");
        k21.i(function0, "storeProducer");
        if (function02 == null) {
            function02 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(kClass, function0, function02);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function02);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        k21.i(fragment, "$this$viewModels");
        k21.i(function0, "ownerProducer");
        k21.o(4, "VM");
        return createViewModelLazy(fragment, dz1.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function02);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        k21.i(fragment, "$this$viewModels");
        k21.i(function0, "ownerProducer");
        k21.o(4, "VM");
        return createViewModelLazy(fragment, dz1.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function02);
    }
}
