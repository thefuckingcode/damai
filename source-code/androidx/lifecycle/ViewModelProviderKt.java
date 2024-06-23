package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import tb.gl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider;", gl1.TYPE_OPEN_URL_METHOD_GET, "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        k21.i(viewModelProvider, "$this$get");
        k21.o(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        k21.h(vm, "get(VM::class.java)");
        return vm;
    }
}
