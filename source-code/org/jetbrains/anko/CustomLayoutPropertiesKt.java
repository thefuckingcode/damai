package org.jetbrains.anko;

import android.view.ViewGroup;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"(\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"(\u0010\r\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f\"(\u0010\u0010\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"matchParent", "", "getMatchParent", "()I", "wrapContent", "getWrapContent", "v", "horizontalMargin", "Landroid/view/ViewGroup$MarginLayoutParams;", "getHorizontalMargin", "(Landroid/view/ViewGroup$MarginLayoutParams;)I", "setHorizontalMargin", "(Landroid/view/ViewGroup$MarginLayoutParams;I)V", "margin", "getMargin", "setMargin", "verticalMargin", "getVerticalMargin", "setVerticalMargin", "platform-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: CustomLayoutProperties.kt */
public final class CustomLayoutPropertiesKt {
    private static final int matchParent = -1;
    private static final int wrapContent = -2;

    public static final int getMatchParent() {
        return matchParent;
    }

    public static final int getWrapContent() {
        return wrapContent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getVerticalMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setVerticalMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getHorizontalMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setHorizontalMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$receiver");
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i;
    }
}
