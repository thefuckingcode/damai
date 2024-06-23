package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0 implements FragmentResultListener {
    private final /* synthetic */ Function2 function;

    FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(Function2 function2) {
        this.function = function2;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final /* synthetic */ void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        k21.i(str, "p0");
        k21.i(bundle, "p1");
        k21.h(this.function.invoke(str, bundle), "invoke(...)");
    }
}
