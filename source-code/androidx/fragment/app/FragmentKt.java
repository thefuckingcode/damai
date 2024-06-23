package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001aJ\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\b\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "requestKey", "Landroid/os/Bundle;", "result", "Ltb/ur2;", "setFragmentResult", "clearFragmentResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "listener", "setFragmentResultListener", "clearFragmentResultListener", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class FragmentKt {
    public static final void clearFragmentResult(@NotNull Fragment fragment, @NotNull String str) {
        k21.i(fragment, "$this$clearFragmentResult");
        k21.i(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(@NotNull Fragment fragment, @NotNull String str) {
        k21.i(fragment, "$this$clearFragmentResultListener");
        k21.i(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(@NotNull Fragment fragment, @NotNull String str, @NotNull Bundle bundle) {
        k21.i(fragment, "$this$setFragmentResult");
        k21.i(str, "requestKey");
        k21.i(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(@NotNull Fragment fragment, @NotNull String str, @NotNull Function2<? super String, ? super Bundle, ur2> function2) {
        k21.i(fragment, "$this$setFragmentResultListener");
        k21.i(str, "requestKey");
        k21.i(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(function2));
    }
}
