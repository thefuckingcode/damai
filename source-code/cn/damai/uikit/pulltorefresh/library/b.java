package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

@TargetApi(9)
/* compiled from: Taobao */
public final class b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr;
            iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
        }
    }

    static boolean a(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-893550827")) {
            return view.getOverScrollMode() != 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("-893550827", new Object[]{view})).booleanValue();
    }

    public static void b(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        int i7;
        int i8;
        int i9;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738039765")) {
            ipChange.ipc$dispatch("-738039765", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        if (a.a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            i9 = pullToRefreshBase.getScrollY();
            i8 = i3;
            i7 = i4;
        } else {
            i9 = pullToRefreshBase.getScrollX();
            i8 = i;
            i7 = i2;
        }
        if (pullToRefreshBase.isPullToRefreshOverScrollEnabled() && !pullToRefreshBase.isRefreshing()) {
            PullToRefreshBase.Mode mode = pullToRefreshBase.getMode();
            if (mode.permitsPullToRefresh() && !z && i8 != 0) {
                int i10 = i8 + i7;
                Log.d("OverscrollHelper", "OverScroll. DeltaX: " + i + ", ScrollX: " + i2 + ", DeltaY: " + i3 + ", ScrollY: " + i4 + ", NewY: " + i10 + ", ScrollRange: " + i5 + ", CurrentScroll: " + i9);
                if (i10 < 0 - i6) {
                    if (mode.showHeaderLoadingLayout()) {
                        if (i9 == 0) {
                            pullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (f * ((float) (i9 + i10))));
                    }
                } else if (i10 > i5 + i6) {
                    if (mode.showFooterLoadingLayout()) {
                        if (i9 == 0) {
                            pullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (f * ((float) ((i9 + i10) - i5))));
                    }
                } else if (Math.abs(i10) <= i6 || Math.abs(i10 - i5) <= i6) {
                    pullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
                }
            } else if (z && PullToRefreshBase.State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        }
    }

    public static void c(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2074493272")) {
            ipChange.ipc$dispatch("-2074493272", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)});
            return;
        }
        b(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
    }

    public static void d(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590924931")) {
            ipChange.ipc$dispatch("-1590924931", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)});
            return;
        }
        c(pullToRefreshBase, i, i2, i3, i4, 0, z);
    }
}
