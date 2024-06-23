package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.z41;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/Lazy;", "", "isInitialized", "cached", "Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "viewModelClass", "Lkotlin/reflect/KClass;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Lkotlin/jvm/functions/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "getValue", "()Landroidx/lifecycle/ViewModel;", "value", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelStore> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelProvider$Factory> */
    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull KClass<VM> kClass, @NotNull Function0<? extends ViewModelStore> function0, @NotNull Function0<? extends ViewModelProvider.Factory> function02) {
        k21.i(kClass, "viewModelClass");
        k21.i(function0, "storeProducer");
        k21.i(function02, "factoryProducer");
        this.viewModelClass = kClass;
        this.storeProducer = function0;
        this.factoryProducer = function02;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.Lazy
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(z41.b(this.viewModelClass));
        this.cached = vm2;
        k21.h(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}
