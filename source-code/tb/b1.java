package tb;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class b1 implements ViewDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Class[] SUPPORTED_VIEW_CLASSES = {AbsListView.class};

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;

        static int a(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-528786507")) {
                return 2;
            }
            return ((Integer) ipChange.ipc$dispatch("-528786507", new Object[]{absListView})).intValue();
        }

        static boolean b(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-119696829")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-119696829", new Object[]{absListView})).booleanValue();
        }
    }

    @TargetApi(11)
    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;

        static int a(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "419529437")) {
                return absListView.getVerticalScrollbarPosition();
            }
            return ((Integer) ipChange.ipc$dispatch("419529437", new Object[]{absListView})).intValue();
        }

        static boolean b(AbsListView absListView) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-250282981")) {
                return absListView.isFastScrollAlwaysVisible();
            }
            return ((Boolean) ipChange.ipc$dispatch("-250282981", new Object[]{absListView})).booleanValue();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847193811")) {
            return ((Integer) ipChange.ipc$dispatch("-1847193811", new Object[]{this, absListView})).intValue();
        } else if (Build.VERSION.SDK_INT >= 11) {
            return b.a(absListView);
        } else {
            return a.a(absListView);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287934411")) {
            return ((Boolean) ipChange.ipc$dispatch("1287934411", new Object[]{this, absListView})).booleanValue();
        } else if (Build.VERSION.SDK_INT >= 11) {
            return b.b(absListView);
        } else {
            return a.b(absListView);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (r8 < ((float) (r7.getRight() - r7.getVerticalScrollbarWidth()))) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        if (r8 > ((float) r7.getVerticalScrollbarWidth())) goto L_0x007f;
     */
    @Override // cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate
    public boolean isReadyForPull(View view, float f, float f2) {
        boolean z;
        View childAt;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "889578035")) {
            return ((Boolean) ipChange.ipc$dispatch("889578035", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        AbsListView absListView = (AbsListView) view;
        if (absListView.getCount() != 0 && (absListView.getFirstVisiblePosition() != 0 || (childAt = absListView.getChildAt(0)) == null || childAt.getTop() < absListView.getPaddingTop())) {
            z = false;
        } else {
            z = true;
        }
        if (!z || !absListView.isFastScrollEnabled() || !b(absListView)) {
            return z;
        }
        int a2 = a(absListView);
        if (a2 != 1) {
            if (a2 != 2) {
                return z;
            }
        }
        z2 = false;
        return z2;
    }
}
