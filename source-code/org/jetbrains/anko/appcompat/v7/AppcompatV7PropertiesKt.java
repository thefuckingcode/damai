package org.jetbrains.anko.appcompat.v7;

import androidx.appcompat.widget.Toolbar;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\"(\u0010\u000b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007\"(\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\"(\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007\"(\u0010\u0014\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"v", "", "logoDescriptionResource", "Landroidx/appcompat/widget/Toolbar;", "getLogoDescriptionResource", "(Landroid/support/v7/widget/Toolbar;)I", "setLogoDescriptionResource", "(Landroid/support/v7/widget/Toolbar;I)V", "logoResource", "getLogoResource", "setLogoResource", "navigationContentDescriptionResource", "getNavigationContentDescriptionResource", "setNavigationContentDescriptionResource", "navigationIconResource", "getNavigationIconResource", "setNavigationIconResource", "subtitleResource", "getSubtitleResource", "setSubtitleResource", "titleResource", "getTitleResource", "setTitleResource", "anko-appcompat-v7_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Properties.kt */
public final class AppcompatV7PropertiesKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getLogoResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setLogoResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setLogo(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getLogoDescriptionResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setLogoDescriptionResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setLogoDescription(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getNavigationContentDescriptionResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setNavigationContentDescriptionResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setNavigationContentDescription(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getNavigationIconResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setNavigationIconResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setNavigationIcon(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getSubtitleResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setSubtitleResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setSubtitle(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = AnkoInternals.NO_GETTER)
    public static final int getTitleResource(Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTitleResource(Toolbar toolbar, int i) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        toolbar.setTitle(i);
    }
}
