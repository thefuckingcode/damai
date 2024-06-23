package org.jetbrains.anko;

import android.content.SharedPreferences;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\b\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\b¨\u0006\b"}, d2 = {"apply", "", "Landroid/content/SharedPreferences;", "modifier", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "commit", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SharedPreferences.kt */
public final class SharedPreferencesKt {
    @Deprecated(message = "Use the Android KTX version", replaceWith = @ReplaceWith(expression = "edit(modifier)", imports = {"androidx.core.content.edit"}))
    public static final void apply(SharedPreferences sharedPreferences, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "modifier");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        function1.invoke(edit);
        edit.apply();
    }

    @Deprecated(message = "Use the Android KTX version", replaceWith = @ReplaceWith(expression = "edit(true, modifier)", imports = {"androidx.core.content.edit"}))
    public static final void commit(SharedPreferences sharedPreferences, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "modifier");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        function1.invoke(edit);
        edit.commit();
    }
}
