package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00060\u0006R\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001a\u0010\n\u001a\u00020\u0004*\u00060\u0006R\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0016\u0010\u000b\u001a\u00020\u0004*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u000b\u001a\u00020\u0004*\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001b\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0016\u0010\f\u001a\u00020\u0004*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\f\u001a\u00020\u0004*\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001b\u0010\f\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\r"}, d2 = {"attr", "Landroid/util/TypedValue;", "Landroid/app/Fragment;", "attribute", "", "Landroid/content/Context;", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "Landroid/view/View;", "Lorg/jetbrains/anko/AnkoContext;", "color", "colorAttr", "dimenAttr", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Theme.kt */
public final class ThemeKt {
    public static final TypedValue attr(Resources.Theme theme, int i) {
        Intrinsics.checkParameterIsNotNull(theme, "$receiver");
        TypedValue typedValue = new TypedValue();
        if (theme.resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        throw new IllegalArgumentException("Failed to resolve attribute: " + i);
    }

    public static final int color(Resources.Theme theme, int i) {
        Intrinsics.checkParameterIsNotNull(theme, "$receiver");
        TypedValue attr = attr(theme, i);
        if (attr.type >= 28 && attr.type <= 31) {
            return attr.data;
        }
        throw new IllegalArgumentException("Attribute value type is not color: " + i);
    }

    public static final TypedValue attr(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkExpressionValueIsNotNull(theme, "theme");
        return attr(theme, i);
    }

    public static final int dimenAttr(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        int i2 = attr(context, i).data;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return TypedValue.complexToDimensionPixelSize(i2, resources.getDisplayMetrics());
    }

    public static final int colorAttr(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Resources.Theme theme = context.getTheme();
        Intrinsics.checkExpressionValueIsNotNull(theme, "theme");
        return color(theme, i);
    }

    public static final int dimenAttr(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dimenAttr(ankoContext.getCtx(), i);
    }

    public static final int colorAttr(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return colorAttr(ankoContext.getCtx(), i);
    }

    public static final TypedValue attr(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return attr(ankoContext.getCtx(), i);
    }

    public static final int dimenAttr(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dimenAttr(context, i);
    }

    public static final int colorAttr(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return colorAttr(context, i);
    }

    public static final TypedValue attr(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return attr(context, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int dimenAttr(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dimenAttr(activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final int colorAttr(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return colorAttr(activity, i);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final TypedValue attr(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return attr(activity, i);
    }
}
