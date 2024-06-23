package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\b¨\u0006\u000b"}, d2 = {"dimen", "", "Landroidx/fragment/app/Fragment;", "resource", "dip", "value", "", "px2dip", "px", "px2sp", "sp", "supportV4-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SupportDimensions.kt */
public final class SupportDimensionsKt {
    public static final int dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dip((Context) requireActivity, i);
    }

    public static final int dip(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dip(requireActivity, f);
    }

    public static final int sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.sp((Context) requireActivity, i);
    }

    public static final int sp(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.sp(requireActivity, f);
    }

    public static final float px2dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.px2dip(requireActivity, i);
    }

    public static final float px2sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.px2sp(requireActivity, i);
    }

    public static final int dimen(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return DimensionsKt.dimen(requireActivity, i);
    }
}
