package org.jetbrains.anko.support.v4;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\r*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"act", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/Fragment;", "act$annotations", "(Landroid/support/v4/app/Fragment;)V", "getAct", "(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentActivity;", "ctx", "Landroid/content/Context;", "ctx$annotations", "getCtx", "(Landroid/support/v4/app/Fragment;)Landroid/content/Context;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "(Landroid/support/v4/app/Fragment;)Landroid/content/SharedPreferences;", "supportV4-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SupportContextUtils.kt */
public final class SupportContextUtilsKt {
    @Deprecated(message = "Use either activity or requireActivity", replaceWith = @ReplaceWith(expression = "activity", imports = {}))
    public static /* synthetic */ void act$annotations(Fragment fragment) {
    }

    @Deprecated(message = "Use either context or requireContext", replaceWith = @ReplaceWith(expression = "context", imports = {}))
    public static /* synthetic */ void ctx$annotations(Fragment fragment) {
    }

    public static final SharedPreferences getDefaultSharedPreferences(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(fragment.getActivity());
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…aredPreferences(activity)");
        return defaultSharedPreferences;
    }

    public static final FragmentActivity getAct(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return requireActivity;
    }

    public static final Context getCtx(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return requireActivity;
    }
}
