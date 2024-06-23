package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.youku.live.livesdk.wkit.component.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Ltb/ur2;", "Lkotlin/ExtensionFunctionType;", "action", Constants.TAG_FOR_EDIT, "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences sharedPreferences, boolean z, @NotNull Function1<? super SharedPreferences.Editor, ur2> function1) {
        k21.i(sharedPreferences, "$this$edit");
        k21.i(function1, "action");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        k21.h(edit, "editor");
        function1.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        k21.i(sharedPreferences, "$this$edit");
        k21.i(function1, "action");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        k21.h(edit, "editor");
        function1.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
