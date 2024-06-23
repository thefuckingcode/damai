package org.jetbrains.anko;

import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0017\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\r\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0017\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\b¨\u0006 "}, d2 = {"above", "", "Landroid/widget/RelativeLayout$LayoutParams;", "view", "Landroid/view/View;", "id", "", "alignEnd", "alignParentBottom", "alignParentEnd", "alignParentLeft", "alignParentRight", "alignParentStart", "alignParentTop", "alignStart", "baselineOf", "below", "bottomOf", "centerHorizontally", "centerInParent", "centerVertically", "endOf", "leftOf", "rightOf", "sameBottom", "sameEnd", "sameLeft", "sameRight", "sameStart", "sameTop", "startOf", "topOf", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: RelativeLayoutLayoutParamsHelpers.kt */
public final class RelativeLayoutLayoutParamsHelpersKt {
    public static final void topOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(2, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void above(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(2, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void bottomOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(3, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void below(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(3, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void leftOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(0, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void startOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(16, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void rightOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(1, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void endOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(17, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameLeft(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(5, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameStart(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(18, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameTop(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(6, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameRight(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(7, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameEnd(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(19, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void sameBottom(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(8, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void topOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(2, i);
    }

    public static final void above(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(2, i);
    }

    public static final void below(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(3, i);
    }

    public static final void bottomOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(3, i);
    }

    public static final void leftOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(0, i);
    }

    public static final void startOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(16, i);
    }

    public static final void rightOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(1, i);
    }

    public static final void endOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(17, i);
    }

    public static final void sameLeft(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(5, i);
    }

    public static final void sameStart(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(18, i);
    }

    public static final void sameTop(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(6, i);
    }

    public static final void sameRight(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(7, i);
    }

    public static final void sameEnd(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(19, i);
    }

    public static final void sameBottom(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(8, i);
    }

    public static final void alignStart(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(18, i);
    }

    public static final void alignEnd(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(19, i);
    }

    public static final void alignParentTop(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(10);
    }

    public static final void alignParentRight(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(11);
    }

    public static final void alignParentBottom(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(12);
    }

    public static final void alignParentLeft(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(9);
    }

    public static final void centerHorizontally(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(14);
    }

    public static final void centerVertically(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(15);
    }

    public static final void centerInParent(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(13);
    }

    public static final void alignParentStart(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(20);
    }

    public static final void alignParentEnd(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(21);
    }

    public static final void baselineOf(RelativeLayout.LayoutParams layoutParams, View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(4, id);
            return;
        }
        throw new AnkoException("Id is not set for " + view);
    }

    public static final void baselineOf(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "$receiver");
        layoutParams.addRule(4, i);
    }
}
