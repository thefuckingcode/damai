package cn.damai.tetris.v2.helper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import tb.jl1;
import tb.s61;
import tb.sw1;

/* compiled from: Taobao */
public class StaggeredLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static BitSet m;
    private b[] a;
    private a b;
    private final Runnable c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private List<View> j;
    private WeakReference<VirtualLayoutManager> k;
    private int l;

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        int[] a;
        StaggeredLayoutHelper b;

        a(StaggeredLayoutHelper staggeredLayoutHelper) {
            this.b = staggeredLayoutHelper;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1464322644")) {
                ipChange.ipc$dispatch("-1464322644", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.a = iArr2;
                Arrays.fill(iArr2, Integer.MIN_VALUE);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[d(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1345934174")) {
                return ((Integer) ipChange.ipc$dispatch("-1345934174", new Object[]{this, Integer.valueOf(i)})).intValue();
            } else if (i - this.b.getRange().d().intValue() < this.b.d) {
                return i - this.b.getRange().d().intValue();
            } else {
                int[] iArr = this.a;
                if (iArr == null || i >= iArr.length || i < 0) {
                    return Integer.MIN_VALUE;
                }
                return iArr[i];
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i, b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2055108969")) {
                ipChange.ipc$dispatch("-2055108969", new Object[]{this, Integer.valueOf(i), bVar});
                return;
            }
            a(i);
            this.a[i] = bVar.a;
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "534145459")) {
                return ((Integer) ipChange.ipc$dispatch("534145459", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        final int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        private ArrayList<View> g;

        /* access modifiers changed from: package-private */
        public void b(View view, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1698218071")) {
                ipChange.ipc$dispatch("1698218071", new Object[]{this, view, cVar});
                return;
            }
            RecyclerView.LayoutParams l = l(view);
            this.g.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.g.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d += cVar.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z, int i, c cVar) {
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "848392924")) {
                ipChange.ipc$dispatch("848392924", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), cVar});
                return;
            }
            if (z) {
                i2 = k(cVar);
            } else {
                i2 = n(cVar);
            }
            f();
            if (i2 != Integer.MIN_VALUE) {
                if ((!z || i2 >= cVar.i()) && !z) {
                    cVar.k();
                }
                if (i != Integer.MIN_VALUE) {
                    i2 += i;
                }
                this.c = i2;
                this.b = i2;
                this.f = Integer.MIN_VALUE;
                this.e = Integer.MIN_VALUE;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1831737771")) {
                ipChange.ipc$dispatch("1831737771", new Object[]{this, cVar});
            } else if (this.g.size() == 0) {
                this.c = Integer.MIN_VALUE;
            } else {
                ArrayList<View> arrayList = this.g;
                this.c = cVar.d(arrayList.get(arrayList.size() - 1));
            }
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2024930702")) {
                ipChange.ipc$dispatch("-2024930702", new Object[]{this, cVar});
            } else if (this.g.size() == 0) {
                this.b = Integer.MIN_VALUE;
            } else {
                this.b = cVar.g(this.g.get(0));
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-356342251")) {
                ipChange.ipc$dispatch("-356342251", new Object[]{this});
                return;
            }
            this.g.clear();
            o();
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean g(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1924272074")) {
                return ((Boolean) ipChange.ipc$dispatch("-1924272074", new Object[]{this, view})).booleanValue();
            }
            int size = this.g.size();
            if (size <= 0 || this.g.get(size - 1) != view) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean h(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-987460099")) {
                return ((Boolean) ipChange.ipc$dispatch("-987460099", new Object[]{this, view})).booleanValue();
            } else if (this.g.size() <= 0 || this.g.get(0) != view) {
                return false;
            } else {
                return true;
            }
        }

        public int i() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-424737545")) {
                return this.d;
            }
            return ((Integer) ipChange.ipc$dispatch("-424737545", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int j(int i, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-222844833")) {
                return ((Integer) ipChange.ipc$dispatch("-222844833", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
            }
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i == Integer.MIN_VALUE || this.g.size() != 0) {
                d(cVar);
                return this.c;
            }
            int i3 = this.e;
            return i3 != Integer.MIN_VALUE ? i3 : i;
        }

        /* access modifiers changed from: package-private */
        public int k(c cVar) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1936974012")) {
                return j(Integer.MIN_VALUE, cVar);
            }
            return ((Integer) ipChange.ipc$dispatch("-1936974012", new Object[]{this, cVar})).intValue();
        }

        /* access modifiers changed from: package-private */
        public RecyclerView.LayoutParams l(View view) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-502020507")) {
                return (RecyclerView.LayoutParams) view.getLayoutParams();
            }
            return (RecyclerView.LayoutParams) ipChange.ipc$dispatch("-502020507", new Object[]{this, view});
        }

        /* access modifiers changed from: package-private */
        public int m(int i, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-949473160")) {
                return ((Integer) ipChange.ipc$dispatch("-949473160", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
            }
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i == Integer.MIN_VALUE || this.g.size() != 0) {
                e(cVar);
                return this.b;
            }
            int i3 = this.f;
            return i3 != Integer.MIN_VALUE ? i3 : i;
        }

        /* access modifiers changed from: package-private */
        public int n(c cVar) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "671985675")) {
                return m(Integer.MIN_VALUE, cVar);
            }
            return ((Integer) ipChange.ipc$dispatch("671985675", new Object[]{this, cVar})).intValue();
        }

        /* access modifiers changed from: package-private */
        public void o() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "612197083")) {
                ipChange.ipc$dispatch("612197083", new Object[]{this});
                return;
            }
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.e = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void p(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1414347277")) {
                ipChange.ipc$dispatch("1414347277", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int i2 = this.e;
            if (i2 != Integer.MIN_VALUE) {
                this.e = i2 + i;
            }
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                this.b = i3 + i;
            }
            int i4 = this.f;
            if (i4 != Integer.MIN_VALUE) {
                this.f = i4 + i;
            }
            int i5 = this.c;
            if (i5 != Integer.MIN_VALUE) {
                this.c = i5 + i;
            }
        }

        /* access modifiers changed from: package-private */
        public void q(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1863861474")) {
                ipChange.ipc$dispatch("1863861474", new Object[]{this, cVar});
                return;
            }
            int size = this.g.size();
            View remove = this.g.remove(size - 1);
            RecyclerView.LayoutParams l = l(remove);
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= cVar.e(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void r(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1218823191")) {
                ipChange.ipc$dispatch("-1218823191", new Object[]{this, cVar});
                return;
            }
            View remove = this.g.remove(0);
            RecyclerView.LayoutParams l = l(remove);
            if (this.g.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= cVar.e(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void s(View view, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1857818397")) {
                ipChange.ipc$dispatch("1857818397", new Object[]{this, view, cVar});
                return;
            }
            RecyclerView.LayoutParams l = l(view);
            this.g.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.g.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d += cVar.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void t(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1159404681")) {
                ipChange.ipc$dispatch("-1159404681", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.b = i;
            this.c = i;
            this.f = Integer.MIN_VALUE;
            this.e = Integer.MIN_VALUE;
        }

        private b(int i) {
            this.g = new ArrayList<>();
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.d = 0;
            this.e = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.a = i;
        }
    }

    public StaggeredLayoutHelper() {
        this(1, 0);
    }

    private boolean c(b bVar, VirtualLayoutManager virtualLayoutManager, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394853745")) {
            return ((Boolean) ipChange.ipc$dispatch("394853745", new Object[]{this, bVar, virtualLayoutManager, Integer.valueOf(i2)})).booleanValue();
        }
        c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
        if (virtualLayoutManager.getReverseLayout()) {
            if (bVar.k(mainOrientationHelper) < i2) {
                return true;
            }
            return false;
        } else if (bVar.n(mainOrientationHelper) > i2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkForGaps() {
        VirtualLayoutManager virtualLayoutManager;
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442886874")) {
            ipChange.ipc$dispatch("442886874", new Object[]{this});
            return;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.k;
        if (!(weakReference == null || (virtualLayoutManager = weakReference.get()) == null || virtualLayoutManager.getChildCount() == 0)) {
            sw1<Integer> range = getRange();
            if (virtualLayoutManager.getReverseLayout()) {
                virtualLayoutManager.findLastVisibleItemPosition();
                virtualLayoutManager.findFirstVisibleItemPosition();
                i2 = range.e().intValue() - 1;
            } else {
                virtualLayoutManager.findFirstVisibleItemPosition();
                virtualLayoutManager.findLastCompletelyVisibleItemPosition();
                i2 = range.d().intValue();
            }
            c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
            int childCount = virtualLayoutManager.getChildCount();
            if (virtualLayoutManager.getReverseLayout()) {
                int i5 = childCount - 1;
                for (int i6 = i5; i6 >= 0; i6--) {
                    View childAt = virtualLayoutManager.getChildAt(i6);
                    i3 = virtualLayoutManager.getPosition(childAt);
                    if (i3 == i2) {
                        if (i6 == i5) {
                            i4 = mainOrientationHelper.d(childAt);
                        } else {
                            View childAt2 = virtualLayoutManager.getChildAt(i6 + 1);
                            if (virtualLayoutManager.getPosition(childAt2) == i3 - 1) {
                                i4 = virtualLayoutManager.obtainExtraMargin(childAt, true) + (mainOrientationHelper.g(childAt2) - virtualLayoutManager.obtainExtraMargin(childAt2, false));
                            } else {
                                i4 = mainOrientationHelper.d(childAt);
                            }
                        }
                        if (!(i3 == Integer.MIN_VALUE || hasGapsToFix(virtualLayoutManager, i3, i4) == null)) {
                            for (b bVar : this.a) {
                                bVar.t(i4);
                            }
                            virtualLayoutManager.requestSimpleAnimationsInNextLayout();
                            virtualLayoutManager.requestLayout();
                            return;
                        }
                    }
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= childCount) {
                        break;
                    }
                    View childAt3 = virtualLayoutManager.getChildAt(i7);
                    i3 = virtualLayoutManager.getPosition(childAt3);
                    if (i3 != i2) {
                        i7++;
                    } else if (i7 == 0) {
                        i4 = mainOrientationHelper.g(childAt3);
                    } else {
                        View childAt4 = virtualLayoutManager.getChildAt(i7 - 1);
                        int d2 = (mainOrientationHelper.d(childAt4) + virtualLayoutManager.obtainExtraMargin(childAt4, true, false)) - virtualLayoutManager.obtainExtraMargin(childAt3, false, false);
                        if (d2 == mainOrientationHelper.g(childAt3)) {
                            i4 = d2;
                        } else {
                            int position = virtualLayoutManager.getPosition(childAt4);
                            int i8 = i2 - 1;
                            if (position != i8) {
                                com.alibaba.android.vlayout.a findLayoutHelperByPosition = virtualLayoutManager.findLayoutHelperByPosition(i8);
                                if (!(findLayoutHelperByPosition == null || !(findLayoutHelperByPosition instanceof StickyLayoutHelper) || findLayoutHelperByPosition.getFixedView() == null)) {
                                    d2 += findLayoutHelperByPosition.getFixedView().getMeasuredHeight();
                                }
                            } else {
                                virtualLayoutManager.findLayoutHelperByPosition(position).getRange();
                            }
                            i4 = d2;
                        }
                    }
                }
            }
            i4 = Integer.MIN_VALUE;
            i3 = Integer.MIN_VALUE;
            if (i3 == Integer.MIN_VALUE) {
            }
        }
    }

    private b d(int i2, View view, boolean z) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-281976766")) {
            return (b) ipChange.ipc$dispatch("-281976766", new Object[]{this, Integer.valueOf(i2), view, Boolean.valueOf(z)});
        }
        int b2 = this.b.b(i2);
        if (b2 >= 0) {
            b[] bVarArr = this.a;
            if (b2 < bVarArr.length) {
                b bVar = bVarArr[b2];
                if (z && bVar.h(view)) {
                    return bVar;
                }
                if (!z && bVar.g(view)) {
                    return bVar;
                }
            }
        }
        while (true) {
            b[] bVarArr2 = this.a;
            if (i3 >= bVarArr2.length) {
                return null;
            }
            if (i3 != b2) {
                b bVar2 = bVarArr2[i3];
                if (z && bVar2.h(view)) {
                    return bVar2;
                }
                if (!z && bVar2.g(view)) {
                    return bVar2;
                }
            }
            i3++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if ((r8.f() == -1) != r9.getReverseLayout()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (((r8.f() == -1) == r9.getReverseLayout()) == r9.isDoLayoutRTL()) goto L_0x003e;
     */
    private b e(int i2, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1537478329")) {
            return (b) ipChange.ipc$dispatch("-1537478329", new Object[]{this, Integer.valueOf(i2), dVar, layoutManagerHelper});
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        int i5 = -1;
        if (layoutManagerHelper.getOrientation() == 0) {
        }
        boolean z = true;
        if (z) {
            i4 = this.d - 1;
            i3 = -1;
        } else {
            i5 = this.d;
            i3 = 1;
        }
        b bVar = null;
        if (dVar.f() == 1) {
            int i6 = Integer.MAX_VALUE;
            while (i4 != i5) {
                b bVar2 = this.a[i4];
                int j2 = bVar2.j(i2, mainOrientationHelper);
                if (j2 < i6) {
                    bVar = bVar2;
                    i6 = j2;
                }
                i4 += i3;
            }
            return bVar;
        }
        int i7 = Integer.MIN_VALUE;
        while (i4 != i5) {
            b bVar3 = this.a[i4];
            int m2 = bVar3.m(i2, mainOrientationHelper);
            if (m2 > i7) {
                bVar = bVar3;
                i7 = m2;
            }
            i4 += i3;
        }
        return bVar;
    }

    private void ensureLanes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934795959")) {
            ipChange.ipc$dispatch("-934795959", new Object[]{this});
            return;
        }
        b[] bVarArr = this.a;
        if (bVarArr == null || bVarArr.length != this.d || m == null) {
            m = new BitSet(this.d);
            this.a = new b[this.d];
            for (int i2 = 0; i2 < this.d; i2++) {
                this.a[i2] = new b(i2);
            }
        }
    }

    private void f(RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, b bVar, int i2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931942851")) {
            ipChange.ipc$dispatch("-931942851", new Object[]{this, recycler, dVar, bVar, Integer.valueOf(i2), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (dVar.f() == -1) {
            recycleFromEnd(recycler, Math.max(i2, getMaxStart(bVar.n(mainOrientationHelper), mainOrientationHelper)) + (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        } else {
            recycleFromStart(recycler, Math.min(i2, getMinEnd(bVar.k(mainOrientationHelper), mainOrientationHelper)) - (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        }
    }

    private int getMaxEnd(int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695411243")) {
            return ((Integer) ipChange.ipc$dispatch("-695411243", new Object[]{this, Integer.valueOf(i2), cVar})).intValue();
        }
        int j2 = this.a[0].j(i2, cVar);
        for (int i3 = 1; i3 < this.d; i3++) {
            int j3 = this.a[i3].j(i2, cVar);
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private int getMaxStart(int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771544594")) {
            return ((Integer) ipChange.ipc$dispatch("-771544594", new Object[]{this, Integer.valueOf(i2), cVar})).intValue();
        }
        int m2 = this.a[0].m(i2, cVar);
        for (int i3 = 1; i3 < this.d; i3++) {
            int m3 = this.a[i3].m(i2, cVar);
            if (m3 > m2) {
                m2 = m3;
            }
        }
        return m2;
    }

    private int getMinEnd(int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970113853")) {
            return ((Integer) ipChange.ipc$dispatch("-970113853", new Object[]{this, Integer.valueOf(i2), cVar})).intValue();
        }
        int j2 = this.a[0].j(i2, cVar);
        for (int i3 = 1; i3 < this.d; i3++) {
            int j3 = this.a[i3].j(i2, cVar);
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private int getMinStart(int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527219548")) {
            return ((Integer) ipChange.ipc$dispatch("1527219548", new Object[]{this, Integer.valueOf(i2), cVar})).intValue();
        }
        int m2 = this.a[0].m(i2, cVar);
        for (int i3 = 1; i3 < this.d; i3++) {
            int m3 = this.a[i3].m(i2, cVar);
            if (m3 < m2) {
                m2 = m3;
            }
        }
        return m2;
    }

    private void h(b bVar, int i2, int i3, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199102168")) {
            ipChange.ipc$dispatch("-199102168", new Object[]{this, bVar, Integer.valueOf(i2), Integer.valueOf(i3), cVar});
            return;
        }
        int i4 = bVar.i();
        if (i2 == -1) {
            if (bVar.n(cVar) + i4 < i3) {
                m.set(bVar.a, false);
            }
        } else if (bVar.k(cVar) - i4 > i3) {
            m.set(bVar.a, false);
        }
    }

    private View hasGapsToFix(VirtualLayoutManager virtualLayoutManager, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324202782")) {
            return (View) ipChange.ipc$dispatch("324202782", new Object[]{this, virtualLayoutManager, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (virtualLayoutManager.findViewByPosition(i2) == null) {
            return null;
        } else {
            new BitSet(this.d).set(0, this.d, true);
            b[] bVarArr = this.a;
            for (b bVar : bVarArr) {
                if (bVar.g.size() != 0 && c(bVar, virtualLayoutManager, i3)) {
                    return (View) (virtualLayoutManager.getReverseLayout() ? bVar.g.get(bVar.g.size() - 1) : bVar.g.get(0));
                }
            }
            return null;
        }
    }

    private void recycleForPreLayout(RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91513592")) {
            ipChange.ipc$dispatch("91513592", new Object[]{this, recycler, dVar, layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int size = this.j.size() - 1; size >= 0; size--) {
            View view = this.j.get(size);
            if (view == null || mainOrientationHelper.g(view) <= mainOrientationHelper.i()) {
                b d2 = d(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), view, false);
                if (d2 != null) {
                    d2.q(mainOrientationHelper);
                    layoutManagerHelper.removeChildView(view);
                    recycler.recycleView(view);
                    return;
                }
                return;
            }
            b d3 = d(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), view, false);
            if (d3 != null) {
                d3.q(mainOrientationHelper);
                layoutManagerHelper.removeChildView(view);
                recycler.recycleView(view);
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333510067")) {
            ipChange.ipc$dispatch("-1333510067", new Object[]{this, recycler, Integer.valueOf(i2), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = layoutManagerHelper.getChildAt(childCount);
            if (childAt != null && mainOrientationHelper.g(childAt) > i2) {
                b d2 = d(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, false);
                if (d2 != null) {
                    d2.q(mainOrientationHelper);
                    layoutManagerHelper.removeChildView(childAt);
                    recycler.recycleView(childAt);
                }
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i2, LayoutManagerHelper layoutManagerHelper) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452396710")) {
            ipChange.ipc$dispatch("1452396710", new Object[]{this, recycler, Integer.valueOf(i2), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        boolean z = true;
        while (layoutManagerHelper.getChildCount() > 0 && z && (childAt = layoutManagerHelper.getChildAt(0)) != null && mainOrientationHelper.d(childAt) < i2) {
            b d2 = d(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, true);
            if (d2 != null) {
                d2.r(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            } else {
                z = false;
            }
        }
    }

    private void updateAllRemainingSpans(int i2, int i3, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704660665")) {
            ipChange.ipc$dispatch("704660665", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), cVar});
            return;
        }
        for (int i4 = 0; i4 < this.d; i4++) {
            if (!this.a[i4].g.isEmpty()) {
                h(this.a[i4], i2, i3, cVar);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3, int i4, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707002789")) {
            ipChange.ipc$dispatch("707002789", new Object[]{this, recycler, state, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutManagerHelper});
            return;
        }
        super.afterLayout(recycler, state, i2, i3, i4, layoutManagerHelper);
        if (i2 <= getRange().e().intValue() && i3 >= getRange().d().intValue() && !state.isPreLayout() && layoutManagerHelper.getChildCount() > 0) {
            ViewCompat.postOnAnimation(layoutManagerHelper.getChildAt(0), this.c);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226842309")) {
            ipChange.ipc$dispatch("-226842309", new Object[]{this, recycler, state, layoutManagerHelper});
            return;
        }
        super.beforeLayout(recycler, state, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            i3 = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
            i2 = this.l * 2;
        } else {
            i3 = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
            i2 = getVerticalPadding();
        }
        int i4 = i3 - i2;
        int i5 = this.e;
        int i6 = this.d;
        int i7 = (int) (((double) ((i4 - (i5 * (i6 - 1))) / i6)) + 0.5d);
        this.g = i7;
        int i8 = i4 - (i7 * i6);
        if (i6 <= 1) {
            this.i = 0;
            this.h = 0;
        } else if (i6 == 2) {
            this.h = i8;
            this.i = i8;
        } else {
            int i9 = layoutManagerHelper.getOrientation() == 1 ? this.e : this.f;
            this.i = i9;
            this.h = i9;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.k;
        if ((weakReference == null || weakReference.get() == null || this.k.get() != layoutManagerHelper) && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            this.k = new WeakReference<>(layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-386520158")) {
            ipChange.ipc$dispatch("-386520158", new Object[]{this, state, cVar, layoutManagerHelper});
            return;
        }
        super.checkAnchorInfo(state, cVar, layoutManagerHelper);
        ensureLanes();
        sw1<Integer> range = getRange();
        if (cVar.c) {
            if (cVar.a < (range.d().intValue() + this.d) - 1) {
                cVar.a = Math.min((range.d().intValue() + this.d) - 1, range.e().intValue());
            }
        } else if (cVar.a > range.e().intValue() - (this.d - 1)) {
            cVar.a = Math.max(range.d().intValue(), range.e().intValue() - (this.d - 1));
        }
        View findViewByPosition = layoutManagerHelper.findViewByPosition(cVar.a);
        int i2 = layoutManagerHelper.getOrientation() == 1 ? this.f : this.e;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (findViewByPosition != null) {
            int i3 = Integer.MIN_VALUE;
            int i4 = cVar.c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            b[] bVarArr = this.a;
            for (b bVar : bVarArr) {
                if (!bVar.g.isEmpty()) {
                    if (cVar.c) {
                        i4 = Math.max(i4, layoutManagerHelper.getPosition((View) bVar.g.get(bVar.g.size() - 1)));
                    } else {
                        i4 = Math.min(i4, layoutManagerHelper.getPosition((View) bVar.g.get(0)));
                    }
                }
            }
            if (!isOutOfRange(i4)) {
                if (i4 != range.d().intValue()) {
                    z = false;
                }
                View findViewByPosition2 = layoutManagerHelper.findViewByPosition(i4);
                if (findViewByPosition2 != null) {
                    if (cVar.c) {
                        cVar.a = i4;
                        int d2 = mainOrientationHelper.d(findViewByPosition);
                        int i5 = cVar.b;
                        if (d2 < i5) {
                            int i6 = i5 - d2;
                            if (z) {
                                i2 = 0;
                            }
                            i3 = i6 + i2;
                            cVar.b = mainOrientationHelper.d(findViewByPosition2) + i3;
                        } else {
                            if (z) {
                                i2 = 0;
                            }
                            cVar.b = mainOrientationHelper.d(findViewByPosition2) + i2;
                            i3 = i2;
                        }
                    } else {
                        cVar.a = i4;
                        int g2 = mainOrientationHelper.g(findViewByPosition);
                        int i7 = cVar.b;
                        if (g2 > i7) {
                            int i8 = i7 - g2;
                            if (z) {
                                i2 = 0;
                            }
                            i3 = i8 - i2;
                            cVar.b = mainOrientationHelper.g(findViewByPosition2) + i3;
                        } else {
                            if (z) {
                                i2 = 0;
                            }
                            i3 = -i2;
                            cVar.b = mainOrientationHelper.g(findViewByPosition2) + i3;
                        }
                    }
                }
            }
            for (b bVar2 : this.a) {
                bVar2.c(layoutManagerHelper.getReverseLayout() ^ cVar.c, i3, mainOrientationHelper);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i2, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1884075655")) {
            return ((Integer) ipChange.ipc$dispatch("1884075655", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
        }
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View findViewByPosition = layoutManagerHelper.findViewByPosition(getRange().d().intValue() + i2);
        if (findViewByPosition == null) {
            return 0;
        }
        ensureLanes();
        if (z3) {
            if (z) {
                if (i2 == getItemCount() - 1) {
                    return this.mMarginBottom + this.mPaddingBottom + (getMaxEnd(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition));
                }
                if (!z2) {
                    return getMinEnd(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition);
                }
            } else if (i2 == 0) {
                return ((-this.mMarginTop) - this.mPaddingTop) - (mainOrientationHelper.g(findViewByPosition) - getMinStart(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper));
            } else {
                if (!z2) {
                    return getMaxStart(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.g(findViewByPosition);
                }
            }
        }
        return 0;
    }

    public void g(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965513007")) {
            ipChange.ipc$dispatch("-965513007", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.l = i2;
    }

    @Override // com.alibaba.android.vlayout.a
    public boolean isRecyclable(int i2, int i3, int i4, LayoutManagerHelper layoutManagerHelper, boolean z) {
        View findViewByPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654731943")) {
            return ((Boolean) ipChange.ipc$dispatch("-654731943", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutManagerHelper, Boolean.valueOf(z)})).booleanValue();
        }
        boolean isRecyclable = super.isRecyclable(i2, i3, i4, layoutManagerHelper, z);
        if (isRecyclable && (findViewByPosition = layoutManagerHelper.findViewByPosition(i2)) != null) {
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            int viewPosition = ((RecyclerView.LayoutParams) findViewByPosition.getLayoutParams()).getViewPosition();
            if (layoutManagerHelper.getReverseLayout()) {
                if (z) {
                    b d2 = d(viewPosition, findViewByPosition, true);
                    if (d2 != null) {
                        d2.q(mainOrientationHelper);
                    }
                } else {
                    b d3 = d(viewPosition, findViewByPosition, false);
                    if (d3 != null) {
                        d3.r(mainOrientationHelper);
                    }
                }
            } else if (z) {
                b d4 = d(viewPosition, findViewByPosition, true);
                if (d4 != null) {
                    d4.r(mainOrientationHelper);
                }
            } else {
                b d5 = d(viewPosition, findViewByPosition, false);
                if (d5 != null) {
                    d5.q(mainOrientationHelper);
                }
            }
        }
        return isRecyclable;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        VirtualLayoutManager.d dVar2;
        int i4;
        int i5;
        int i6;
        int i7;
        View view;
        int i8;
        b bVar;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        int i14;
        int i15;
        c cVar;
        b bVar2;
        int i16;
        int i17;
        int i18;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.d dVar3 = dVar;
        s61 s612 = s61;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035021225")) {
            ipChange.ipc$dispatch("2035021225", new Object[]{this, recycler2, state2, dVar3, s612, layoutManagerHelper});
        } else if (!isOutOfRange(dVar.c())) {
            ensureLanes();
            boolean z4 = layoutManagerHelper.getOrientation() == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            c secondaryOrientationHelper = layoutManagerHelper.getSecondaryOrientationHelper();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            m.set(0, this.d, true);
            if (dVar.f() == 1) {
                i3 = dVar.g() + dVar.b();
                i2 = dVar.d() + i3 + mainOrientationHelper.j();
            } else {
                i3 = dVar.g() - dVar.b();
                i2 = (i3 - dVar.d()) - mainOrientationHelper.k();
            }
            int i19 = i2;
            updateAllRemainingSpans(dVar.f(), i19, mainOrientationHelper);
            int g2 = dVar.g();
            this.j.clear();
            while (dVar3.h(state2) && !m.isEmpty() && !isOutOfRange(dVar.c())) {
                try {
                    view = dVar3.l(recycler2);
                } catch (Exception e2) {
                    Log.e("Tetris.StaggeredLayoutHelper.layoutViews", e2.getMessage());
                    e2.printStackTrace();
                    view = null;
                }
                if (view == null) {
                    break;
                }
                VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
                int viewPosition = layoutParams.getViewPosition();
                int b2 = this.b.b(viewPosition);
                if (b2 == Integer.MIN_VALUE) {
                    bVar = e(g2, dVar3, layoutManagerHelper);
                    i8 = i19;
                    this.b.c(viewPosition, bVar);
                } else {
                    i8 = i19;
                    bVar = this.a[b2];
                }
                boolean z5 = viewPosition - getRange().d().intValue() < this.d;
                boolean z6 = getRange().e().intValue() - viewPosition < this.d;
                if (dVar.j()) {
                    this.j.add(view);
                }
                layoutManagerHelper.addChildView(dVar3, view);
                if (z4) {
                    int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(this.g, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    layoutManagerHelper.measureChildWithMargins(view, childMeasureSpec, layoutManagerHelper.getChildMeasureSpec(mainOrientationHelper.l(), Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : (int) ((((float) View.MeasureSpec.getSize(childMeasureSpec)) / layoutParams.a) + 0.5f), true));
                    z = true;
                } else {
                    int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(this.g, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    z = true;
                    layoutManagerHelper.measureChildWithMargins(view, layoutManagerHelper.getChildMeasureSpec(mainOrientationHelper.l(), Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : (int) ((((float) View.MeasureSpec.getSize(childMeasureSpec2)) * layoutParams.a) + 0.5f), true), childMeasureSpec2);
                }
                if (dVar.f() == z) {
                    int j2 = bVar.j(g2, mainOrientationHelper);
                    if (z5) {
                        i18 = computeStartSpace(layoutManagerHelper, z4, z, isEnableMarginOverLap);
                    } else {
                        i18 = z4 ? this.f : this.e;
                    }
                    int i20 = j2 + i18;
                    i9 = mainOrientationHelper.e(view) + i20;
                    i10 = i20;
                } else {
                    if (z6) {
                        i17 = bVar.m(g2, mainOrientationHelper);
                        i16 = (z4 ? this.mMarginBottom : this.mMarginRight) + this.mPaddingRight;
                    } else {
                        i17 = bVar.m(g2, mainOrientationHelper);
                        i16 = z4 ? this.f : this.e;
                    }
                    int i21 = i17 - i16;
                    i10 = i21 - mainOrientationHelper.e(view);
                    i9 = i21;
                }
                if (dVar.f() == 1) {
                    bVar.b(view, mainOrientationHelper);
                } else {
                    bVar.s(view, mainOrientationHelper);
                }
                int i22 = bVar.a;
                if (i22 == this.d - 1) {
                    int i23 = this.g;
                    int i24 = this.h;
                    i11 = ((i22 * (i23 + i24)) - i24) + this.i;
                } else {
                    i11 = i22 * (this.g + this.h);
                }
                int k2 = i11 + secondaryOrientationHelper.k();
                if (z4) {
                    i13 = this.mMarginLeft;
                    i12 = this.mPaddingLeft;
                } else {
                    i13 = this.mMarginTop;
                    i12 = this.mPaddingTop;
                }
                int i25 = k2 + i13 + i12;
                int f2 = i25 + mainOrientationHelper.f(view);
                if (z4) {
                    int i26 = this.l;
                    int i27 = i25 + i26;
                    int i28 = f2 + i26;
                    Log.d("layoutChildWithMargin", " position: " + viewPosition + " , spanIndex: " + b2 + " ,isStartLine : " + z5 + " , [ " + i27 + "," + i10 + "," + i28 + "," + i9 + jl1.ARRAY_END_STR);
                    i15 = g2;
                    i14 = i8;
                    z3 = isEnableMarginOverLap;
                    z2 = z4;
                    layoutChildWithMargin(view, i27, i10, i28, i9, layoutManagerHelper);
                    cVar = mainOrientationHelper;
                    bVar2 = bVar;
                } else {
                    i15 = g2;
                    z2 = z4;
                    i14 = i8;
                    z3 = isEnableMarginOverLap;
                    bVar2 = bVar;
                    cVar = mainOrientationHelper;
                    layoutChildWithMargin(view, i10, i25, i9, f2, layoutManagerHelper);
                }
                h(bVar2, dVar.f(), i14, cVar);
                f(recycler, dVar, bVar2, i3, layoutManagerHelper);
                handleStateOnResult(s61, view);
                recycler2 = recycler;
                dVar3 = dVar;
                s612 = s61;
                mainOrientationHelper = cVar;
                g2 = i15;
                i19 = i14;
                isEnableMarginOverLap = z3;
                z4 = z2;
                state2 = state;
            }
            if (isOutOfRange(dVar.c())) {
                if (dVar.f() == -1) {
                    b[] bVarArr = this.a;
                    for (b bVar3 : bVarArr) {
                        int i29 = bVar3.b;
                        if (i29 != Integer.MIN_VALUE) {
                            bVar3.e = i29;
                        }
                    }
                } else {
                    b[] bVarArr2 = this.a;
                    for (b bVar4 : bVarArr2) {
                        int i30 = bVar4.c;
                        if (i30 != Integer.MIN_VALUE) {
                            bVar4.f = i30;
                        }
                    }
                }
            }
            if (dVar.f() == -1) {
                if (!isOutOfRange(dVar.c())) {
                    dVar2 = dVar;
                    if (dVar2.h(state)) {
                        s612.a = dVar.g() - getMaxStart(mainOrientationHelper.k(), mainOrientationHelper);
                    }
                } else {
                    dVar2 = dVar;
                }
                int g3 = dVar.g() - getMinStart(mainOrientationHelper.i(), mainOrientationHelper);
                if (z4) {
                    i7 = this.mMarginTop;
                    i6 = this.mPaddingTop;
                } else {
                    i7 = this.mMarginLeft;
                    i6 = this.mPaddingLeft;
                }
                s612.a = g3 + i7 + i6;
            } else {
                dVar2 = dVar;
                if (isOutOfRange(dVar.c()) || !dVar2.h(state)) {
                    int maxEnd = getMaxEnd(mainOrientationHelper.i(), mainOrientationHelper) - dVar.g();
                    if (z4) {
                        i5 = this.mMarginBottom;
                        i4 = this.mPaddingBottom;
                    } else {
                        i5 = this.mMarginRight;
                        i4 = this.mPaddingRight;
                    }
                    s612.a = maxEnd + i5 + i4;
                } else {
                    s612.a = getMinEnd(mainOrientationHelper.i(), mainOrientationHelper) - dVar.g();
                }
            }
            recycleForPreLayout(recycler, dVar2, layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985033084")) {
            ipChange.ipc$dispatch("985033084", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.k = null;
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213291589")) {
            ipChange.ipc$dispatch("-213291589", new Object[]{this, layoutManagerHelper});
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onOffsetChildrenHorizontal(int i2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356701792")) {
            ipChange.ipc$dispatch("1356701792", new Object[]{this, Integer.valueOf(i2), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenHorizontal(i2, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 0) {
            for (b bVar : this.a) {
                bVar.p(i2);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onOffsetChildrenVertical(int i2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074704178")) {
            ipChange.ipc$dispatch("-1074704178", new Object[]{this, Integer.valueOf(i2), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenVertical(i2, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            for (b bVar : this.a) {
                bVar.p(i2);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRefreshLayout(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961031655")) {
            ipChange.ipc$dispatch("1961031655", new Object[]{this, state, cVar, layoutManagerHelper});
            return;
        }
        super.onRefreshLayout(state, cVar, layoutManagerHelper);
        ensureLanes();
        if (isOutOfRange(cVar.a)) {
            for (b bVar : this.a) {
                bVar.f();
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721024297")) {
            ipChange.ipc$dispatch("721024297", new Object[]{this, bundle});
            return;
        }
        super.onRestoreInstanceState(bundle);
        this.b.a = bundle.getIntArray("StaggeredLayoutHelper_LazySpanLookup");
    }

    @Override // com.alibaba.android.vlayout.a
    public void onSaveState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744058743")) {
            ipChange.ipc$dispatch("744058743", new Object[]{this, bundle});
            return;
        }
        super.onSaveState(bundle);
        bundle.putIntArray("StaggeredLayoutHelper_LazySpanLookup", this.b.a);
    }

    @Override // com.alibaba.android.vlayout.a
    public void onScrollStateChanged(int i2, int i3, int i4, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589483750")) {
            ipChange.ipc$dispatch("589483750", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutManagerHelper});
        } else if (i3 <= getRange().e().intValue() && i4 >= getRange().d().intValue() && i2 == 0) {
            checkForGaps();
        }
    }

    public void setGap(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487904415")) {
            ipChange.ipc$dispatch("1487904415", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        setHGap(i2);
        setVGap(i2);
    }

    public void setHGap(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340949695")) {
            ipChange.ipc$dispatch("-1340949695", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.e = i2;
    }

    public void setLane(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997363489")) {
            ipChange.ipc$dispatch("-997363489", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d = i2;
        ensureLanes();
    }

    public void setVGap(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583558515")) {
            ipChange.ipc$dispatch("1583558515", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.f = i2;
    }

    public StaggeredLayoutHelper(int i2) {
        this(i2, 0);
    }

    public StaggeredLayoutHelper(int i2, int i3) {
        this.b = new a(this);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new ArrayList();
        this.k = null;
        this.c = new Runnable() {
            /* class cn.damai.tetris.v2.helper.StaggeredLayoutHelper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1884570810")) {
                    ipChange.ipc$dispatch("1884570810", new Object[]{this});
                    return;
                }
                StaggeredLayoutHelper.this.checkForGaps();
            }
        };
        setLane(i2);
        setGap(i3);
    }
}
