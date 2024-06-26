package androidx.lifecycle;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tb.bh2;
import tb.f90;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"", "JOB_KEY", "Ljava/lang/String;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final CoroutineScope getViewModelScope(@NotNull ViewModel viewModel) {
        k21.i(viewModel, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(bh2.b(null, 1, null).plus(f90.c().a())));
        k21.h(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
