package tb;

import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/* compiled from: Taobao */
public abstract class qv1 implements PtrHandler {
    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean b(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return !a(view);
    }

    @Override // in.srain.cube.views.ptr.PtrHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return b(ptrFrameLayout, view, view2);
    }
}
