package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u0001\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u001b\u0010\t\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0012\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0012\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0015\u0010\u0012\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0012\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0014\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0015\u0010\u0014\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0019\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"HDPI", "", "LDPI", "MAXDPI", "MDPI", "TVDPI", "XHDPI", "XXHDPI", "XXXHDPI", "dimen", "Landroid/app/Fragment;", "resource", "Landroid/content/Context;", "Landroid/view/View;", "Lorg/jetbrains/anko/AnkoContext;", "dip", "value", "", "px2dip", "px", "px2sp", "sp", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Dimensions.kt */
public final class DimensionsKt {
    public static final int HDPI = 240;
    public static final int LDPI = 120;
    public static final int MAXDPI = 65534;
    public static final int MDPI = 160;
    public static final int TVDPI = 213;
    public static final int XHDPI = 320;
    public static final int XXHDPI = 480;
    public static final int XXXHDPI = 640;

    public static final int dip(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (((float) i) * resources.getDisplayMetrics().density);
    }

    public static final int dip(Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().density);
    }

    public static final int sp(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (((float) i) * resources.getDisplayMetrics().scaledDensity);
    }

    public static final int sp(Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().scaledDensity);
    }

    public static final float px2dip(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return ((float) i) / resources.getDisplayMetrics().density;
    }

    public static final float px2sp(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return ((float) i) / resources.getDisplayMetrics().scaledDensity;
    }

    public static final int dimen(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final int dip(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dip(ankoContext.getCtx(), i);
    }

    public static final int dip(AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dip(ankoContext.getCtx(), f);
    }

    public static final int sp(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return sp(ankoContext.getCtx(), i);
    }

    public static final int sp(AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return sp(ankoContext.getCtx(), f);
    }

    public static final float px2dip(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return px2dip(ankoContext.getCtx(), i);
    }

    public static final float px2sp(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return px2sp(ankoContext.getCtx(), i);
    }

    public static final int dimen(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dimen(ankoContext.getCtx(), i);
    }

    public static final int dip(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, i);
    }

    public static final int dip(View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, f);
    }

    public static final int sp(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, i);
    }

    public static final int sp(View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, f);
    }

    public static final float px2dip(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2dip(context, i);
    }

    public static final float px2sp(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2sp(context, i);
    }

    public static final int dimen(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dimen(context, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dip((Context) activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int dip(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dip(activity, f);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sp((Context) activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int sp(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sp(activity, f);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final float px2dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return px2dip(activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final float px2sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return px2sp(activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int dimen(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dimen(activity, i);
    }
}
