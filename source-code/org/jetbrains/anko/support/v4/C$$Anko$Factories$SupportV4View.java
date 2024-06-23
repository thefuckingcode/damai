package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.legacy.widget.Space;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"org/jetbrains/anko/support/v4/$$Anko$Factories$SupportV4View", "", "()V", "CONTENT_LOADING_PROGRESS_BAR", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroidx/core/widget/ContentLoadingProgressBar;", "getCONTENT_LOADING_PROGRESS_BAR", "()Lkotlin/jvm/functions/Function1;", "PAGER_TAB_STRIP", "Landroidx/viewpager/widget/PagerTabStrip;", "getPAGER_TAB_STRIP", "PAGER_TITLE_STRIP", "Landroidx/viewpager/widget/PagerTitleStrip;", "getPAGER_TITLE_STRIP", "SPACE", "Landroidx/legacy/widget/Space;", "getSPACE", "SWIPE_REFRESH_LAYOUT", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSWIPE_REFRESH_LAYOUT", "anko-support-v4_release"}, k = 1, mv = {1, 1, 11})
/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4View  reason: invalid class name */
/* compiled from: Views.kt */
public final class C$$Anko$Factories$SupportV4View {
    private static final Function1<Context, ContentLoadingProgressBar> CONTENT_LOADING_PROGRESS_BAR = C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1.INSTANCE;
    public static final C$$Anko$Factories$SupportV4View INSTANCE = new C$$Anko$Factories$SupportV4View();
    private static final Function1<Context, PagerTabStrip> PAGER_TAB_STRIP = C$$Anko$Factories$SupportV4View$PAGER_TAB_STRIP$1.INSTANCE;
    private static final Function1<Context, PagerTitleStrip> PAGER_TITLE_STRIP = C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1.INSTANCE;
    private static final Function1<Context, Space> SPACE = C$$Anko$Factories$SupportV4View$SPACE$1.INSTANCE;
    private static final Function1<Context, SwipeRefreshLayout> SWIPE_REFRESH_LAYOUT = C$$Anko$Factories$SupportV4View$SWIPE_REFRESH_LAYOUT$1.INSTANCE;

    private C$$Anko$Factories$SupportV4View() {
    }

    public final Function1<Context, PagerTabStrip> getPAGER_TAB_STRIP() {
        return PAGER_TAB_STRIP;
    }

    public final Function1<Context, PagerTitleStrip> getPAGER_TITLE_STRIP() {
        return PAGER_TITLE_STRIP;
    }

    public final Function1<Context, ContentLoadingProgressBar> getCONTENT_LOADING_PROGRESS_BAR() {
        return CONTENT_LOADING_PROGRESS_BAR;
    }

    public final Function1<Context, Space> getSPACE() {
        return SPACE;
    }

    public final Function1<Context, SwipeRefreshLayout> getSWIPE_REFRESH_LAYOUT() {
        return SWIPE_REFRESH_LAYOUT;
    }
}
