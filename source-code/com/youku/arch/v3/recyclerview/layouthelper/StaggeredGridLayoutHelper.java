package com.youku.arch.v3.recyclerview.layouthelper;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.a;
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
import tb.s61;
import tb.sw1;

/* compiled from: Taobao */
public class StaggeredGridLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int INVALID_LINE = Integer.MIN_VALUE;
    private static final int INVALID_SPAN_ID = Integer.MIN_VALUE;
    private static final String LOOKUP_BUNDLE_KEY = "StaggeredGridLayoutHelper_LazySpanLookup";
    private static final String TAG = "GridLayoutHelper";
    private int anchorPosition;
    private final Runnable checkForGapsRunnable;
    private int mColLength;
    private int mEachGap;
    private int mHGap;
    private int mLastGap;
    private WeakReference<VirtualLayoutManager> mLayoutManager;
    private boolean mLayoutWithAnchor;
    private final LazySpanLookup mLazySpanLookup;
    private int mNumLanes;
    private int mRawLane;
    private BitSet mRemainingSpans;
    private Span[] mSpans;
    private int mVGap;
    private final List<View> preLayoutViewList;

    /* compiled from: Taobao */
    public static class LazySpanLookup {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final int MIN_SIZE = 10;
        int[] mData;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2032997469")) {
                ipChange.ipc$dispatch("2032997469", new Object[]{this});
                return;
            }
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void ensureSize(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "674249378")) {
                ipChange.ipc$dispatch("674249378", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.mData = iArr2;
                Arrays.fill(iArr2, Integer.MIN_VALUE);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public int getSpan(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "124238700")) {
                return ((Integer) ipChange.ipc$dispatch("124238700", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length || i < 0) {
                return Integer.MIN_VALUE;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public int invalidateAfter(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1934252429")) {
                return ((Integer) ipChange.ipc$dispatch("1934252429", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            Arrays.fill(iArr, i, iArr.length, Integer.MIN_VALUE);
            return this.mData.length;
        }

        /* access modifiers changed from: package-private */
        public void offsetForAddition(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-741146856")) {
                ipChange.ipc$dispatch("-741146856", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.mData, i, i3, Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetForRemoval(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1037559882")) {
                ipChange.ipc$dispatch("1037559882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                ensureSize(i3);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSpan(int i, Span span) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1329931991")) {
                ipChange.ipc$dispatch("1329931991", new Object[]{this, Integer.valueOf(i), span});
                return;
            }
            ensureSize(i);
            this.mData[i] = span.mIndex;
        }

        /* access modifiers changed from: package-private */
        public int sizeForPosition(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "42536573")) {
                return ((Integer) ipChange.ipc$dispatch("42536573", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* compiled from: Taobao */
    public static class Span {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int INVALID_OFFSET = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        int mLastEdgeEnd;
        int mLastEdgeStart;
        private ArrayList<View> mViews;

        /* access modifiers changed from: package-private */
        public void appendToSpan(View view, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315722847")) {
                ipChange.ipc$dispatch("-1315722847", new Object[]{this, view, cVar});
                return;
            }
            RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += cVar.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void cacheReferenceLineAndClear(boolean z, int i, c cVar) {
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1450057170")) {
                ipChange.ipc$dispatch("1450057170", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), cVar});
                return;
            }
            if (z) {
                i2 = getEndLine(cVar);
            } else {
                i2 = getStartLine(cVar);
            }
            clear();
            if (i2 != Integer.MIN_VALUE) {
                if ((!z || i2 >= cVar.i()) && !z) {
                    cVar.k();
                }
                if (i != Integer.MIN_VALUE) {
                    i2 += i;
                }
                this.mCachedEnd = i2;
                this.mCachedStart = i2;
                this.mLastEdgeEnd = Integer.MIN_VALUE;
                this.mLastEdgeStart = Integer.MIN_VALUE;
            }
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedEnd(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1721753633")) {
                ipChange.ipc$dispatch("1721753633", new Object[]{this, cVar});
            } else if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            } else {
                ArrayList<View> arrayList = this.mViews;
                this.mCachedEnd = cVar.d(arrayList.get(arrayList.size() - 1));
            }
        }

        /* access modifiers changed from: package-private */
        public void calculateCachedStart(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-345504920")) {
                ipChange.ipc$dispatch("-345504920", new Object[]{this, cVar});
            } else if (this.mViews.size() == 0) {
                this.mCachedStart = Integer.MIN_VALUE;
            } else {
                this.mCachedStart = cVar.g(this.mViews.get(0));
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-698394869")) {
                ipChange.ipc$dispatch("-698394869", new Object[]{this});
                return;
            }
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean findEnd(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1879086336")) {
                return ((Boolean) ipChange.ipc$dispatch("1879086336", new Object[]{this, view})).booleanValue();
            }
            int size = this.mViews.size();
            if (size <= 0 || this.mViews.get(size - 1) != view) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean findStart(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-977196985")) {
                return ((Boolean) ipChange.ipc$dispatch("-977196985", new Object[]{this, view})).booleanValue();
            } else if (this.mViews.size() <= 0 || this.mViews.get(0) != view) {
                return false;
            } else {
                return true;
            }
        }

        public int getDeletedSize() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2031417151")) {
                return this.mDeletedSize;
            }
            return ((Integer) ipChange.ipc$dispatch("-2031417151", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int getEndLine(c cVar) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-590431302")) {
                return getEndLine(Integer.MIN_VALUE, cVar);
            }
            return ((Integer) ipChange.ipc$dispatch("-590431302", new Object[]{this, cVar})).intValue();
        }

        /* access modifiers changed from: package-private */
        public RecyclerView.LayoutParams getLayoutParams(View view) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1344909403")) {
                return (RecyclerView.LayoutParams) view.getLayoutParams();
            }
            return (RecyclerView.LayoutParams) ipChange.ipc$dispatch("1344909403", new Object[]{this, view});
        }

        /* access modifiers changed from: package-private */
        public int getNormalizedOffset(int i, int i2, int i3, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2125043240")) {
                return ((Integer) ipChange.ipc$dispatch("2125043240", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), cVar})).intValue();
            } else if (this.mViews.size() == 0) {
                return 0;
            } else {
                if (i < 0) {
                    int endLine = getEndLine(0, cVar) - i3;
                    if (endLine <= 0) {
                        return 0;
                    }
                    return (-i) > endLine ? -endLine : i;
                }
                int startLine = i2 - getStartLine(0, cVar);
                if (startLine <= 0) {
                    return 0;
                }
                return startLine < i ? startLine : i;
            }
        }

        /* access modifiers changed from: package-private */
        public int getStartLine(c cVar) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1914373889")) {
                return getStartLine(Integer.MIN_VALUE, cVar);
            }
            return ((Integer) ipChange.ipc$dispatch("1914373889", new Object[]{this, cVar})).intValue();
        }

        /* access modifiers changed from: package-private */
        public void invalidateCache() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1950230447")) {
                ipChange.ipc$dispatch("-1950230447", new Object[]{this});
                return;
            }
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty(int i, int i2, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-740656113")) {
                return ((Boolean) ipChange.ipc$dispatch("-740656113", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), cVar})).booleanValue();
            }
            int size = this.mViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.mViews.get(i3);
                if (cVar.g(view) < i2 && cVar.d(view) > i) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void onOffset(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-811827197")) {
                ipChange.ipc$dispatch("-811827197", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int i2 = this.mLastEdgeStart;
            if (i2 != Integer.MIN_VALUE) {
                this.mLastEdgeStart = i2 + i;
            }
            int i3 = this.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                this.mCachedStart = i3 + i;
            }
            int i4 = this.mLastEdgeEnd;
            if (i4 != Integer.MIN_VALUE) {
                this.mLastEdgeEnd = i4 + i;
            }
            int i5 = this.mCachedEnd;
            if (i5 != Integer.MIN_VALUE) {
                this.mCachedEnd = i5 + i;
            }
        }

        /* access modifiers changed from: package-private */
        public void popEnd(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1205308504")) {
                ipChange.ipc$dispatch("1205308504", new Object[]{this, cVar});
                return;
            }
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            RecyclerView.LayoutParams layoutParams = getLayoutParams(remove);
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= cVar.e(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void popStart(c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1566932447")) {
                ipChange.ipc$dispatch("1566932447", new Object[]{this, cVar});
                return;
            }
            View remove = this.mViews.remove(0);
            RecyclerView.LayoutParams layoutParams = getLayoutParams(remove);
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= cVar.e(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void prependToSpan(View view, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1380036845")) {
                ipChange.ipc$dispatch("-1380036845", new Object[]{this, view, cVar});
                return;
            }
            RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += cVar.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void setLine(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "708445889")) {
                ipChange.ipc$dispatch("708445889", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.mCachedStart = i;
            this.mCachedEnd = i;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        private Span(int i) {
            this.mViews = new ArrayList<>();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mLastEdgeStart = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mIndex = i;
        }

        /* access modifiers changed from: package-private */
        public int getEndLine(int i, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1429693783")) {
                return ((Integer) ipChange.ipc$dispatch("-1429693783", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
            }
            int i2 = this.mCachedEnd;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i == Integer.MIN_VALUE || this.mViews.size() != 0) {
                calculateCachedEnd(cVar);
                return this.mCachedEnd;
            }
            int i3 = this.mLastEdgeStart;
            return i3 != Integer.MIN_VALUE ? i3 : i;
        }

        /* access modifiers changed from: package-private */
        public int getStartLine(int i, c cVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1090144190")) {
                return ((Integer) ipChange.ipc$dispatch("-1090144190", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
            }
            int i2 = this.mCachedStart;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i == Integer.MIN_VALUE || this.mViews.size() != 0) {
                calculateCachedStart(cVar);
                return this.mCachedStart;
            }
            int i3 = this.mLastEdgeEnd;
            return i3 != Integer.MIN_VALUE ? i3 : i;
        }
    }

    public StaggeredGridLayoutHelper() {
        this(1, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0102 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010e A[LOOP:2: B:56:0x010c->B:57:0x010e, LOOP_END] */
    private void checkForGaps() {
        VirtualLayoutManager virtualLayoutManager;
        int i;
        int i2;
        int i3;
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852164528")) {
            ipChange.ipc$dispatch("-1852164528", new Object[]{this});
            return;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.mLayoutManager;
        if (weakReference != null && (virtualLayoutManager = weakReference.get()) != null && virtualLayoutManager.getChildCount() != 0) {
            sw1<Integer> range = getRange();
            if (virtualLayoutManager.getReverseLayout()) {
                virtualLayoutManager.findLastVisibleItemPosition();
                virtualLayoutManager.findFirstVisibleItemPosition();
                i = range.e().intValue() - 1;
            } else {
                virtualLayoutManager.findFirstVisibleItemPosition();
                virtualLayoutManager.findLastCompletelyVisibleItemPosition();
                i = range.d().intValue();
            }
            c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
            int childCount = virtualLayoutManager.getChildCount();
            if (virtualLayoutManager.getReverseLayout()) {
                int i4 = childCount - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View childAt = virtualLayoutManager.getChildAt(i5);
                    i2 = virtualLayoutManager.getPosition(childAt);
                    if (i2 == i) {
                        if (i5 == i4) {
                            i3 = mainOrientationHelper.d(childAt);
                        } else {
                            View childAt2 = virtualLayoutManager.getChildAt(i5 + 1);
                            if (virtualLayoutManager.getPosition(childAt2) == i2 - 1) {
                                i3 = (mainOrientationHelper.g(childAt2) - virtualLayoutManager.obtainExtraMargin(childAt2, false)) + virtualLayoutManager.obtainExtraMargin(childAt, true);
                            } else {
                                i3 = mainOrientationHelper.d(childAt);
                            }
                        }
                        if (i2 == Integer.MIN_VALUE && hasGapsToFix(virtualLayoutManager, i2, i3) != null) {
                            length = this.mSpans.length;
                            for (int i6 = 0; i6 < length; i6++) {
                                this.mSpans[i6].setLine(i3);
                            }
                            virtualLayoutManager.requestLayout();
                            return;
                        }
                        return;
                    }
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= childCount) {
                        break;
                    }
                    View childAt3 = virtualLayoutManager.getChildAt(i7);
                    i2 = virtualLayoutManager.getPosition(childAt3);
                    if (i2 != i) {
                        i7++;
                    } else if (i7 == 0) {
                        i3 = mainOrientationHelper.g(childAt3);
                    } else {
                        View childAt4 = virtualLayoutManager.getChildAt(i7 - 1);
                        int d = (mainOrientationHelper.d(childAt4) + virtualLayoutManager.obtainExtraMargin(childAt4, true, false)) - virtualLayoutManager.obtainExtraMargin(childAt3, false, false);
                        if (d == mainOrientationHelper.g(childAt3)) {
                            i3 = d;
                        } else {
                            int position = virtualLayoutManager.getPosition(childAt4);
                            int i8 = i - 1;
                            if (position != i8) {
                                a findLayoutHelperByPosition = virtualLayoutManager.findLayoutHelperByPosition(i8);
                                if (!(findLayoutHelperByPosition == null || !(findLayoutHelperByPosition instanceof StickyLayoutHelper) || findLayoutHelperByPosition.getFixedView() == null)) {
                                    d += findLayoutHelperByPosition.getFixedView().getMeasuredHeight();
                                }
                            } else {
                                virtualLayoutManager.findLayoutHelperByPosition(position).getRange();
                            }
                            i3 = d;
                        }
                    }
                }
                if (i2 == Integer.MIN_VALUE) {
                    length = this.mSpans.length;
                    while (i6 < length) {
                    }
                    virtualLayoutManager.requestLayout();
                    return;
                }
                return;
            }
            i3 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if (i2 == Integer.MIN_VALUE) {
            }
        }
    }

    private boolean checkSpanForGap(Span span, VirtualLayoutManager virtualLayoutManager, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135465265")) {
            return ((Boolean) ipChange.ipc$dispatch("2135465265", new Object[]{this, span, virtualLayoutManager, Integer.valueOf(i)})).booleanValue();
        }
        c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
        if (virtualLayoutManager.getReverseLayout()) {
            if (span.getEndLine(mainOrientationHelper) != i) {
                return true;
            }
        } else if (span.getStartLine(mainOrientationHelper) != i) {
            return true;
        }
        return false;
    }

    private void ensureLanes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346474771")) {
            ipChange.ipc$dispatch("1346474771", new Object[]{this});
            return;
        }
        Span[] spanArr = this.mSpans;
        if (spanArr == null || spanArr.length != this.mNumLanes || this.mRemainingSpans == null) {
            this.mRemainingSpans = new BitSet(this.mNumLanes);
            this.mSpans = new Span[this.mNumLanes];
            for (int i = 0; i < this.mNumLanes; i++) {
                this.mSpans[i] = new Span(i);
            }
        }
    }

    private Span findSpan(int i, View view, boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1782450862")) {
            return (Span) ipChange.ipc$dispatch("1782450862", new Object[]{this, Integer.valueOf(i), view, Boolean.valueOf(z)});
        }
        int span = this.mLazySpanLookup.getSpan(i);
        if (span >= 0) {
            Span[] spanArr = this.mSpans;
            if (span < spanArr.length) {
                Span span2 = spanArr[span];
                if (z && span2.findStart(view)) {
                    return span2;
                }
                if (!z && span2.findEnd(view)) {
                    return span2;
                }
            }
        }
        while (true) {
            Span[] spanArr2 = this.mSpans;
            if (i2 >= spanArr2.length) {
                return null;
            }
            if (i2 != span) {
                Span span3 = spanArr2[i2];
                if (z && span3.findStart(view)) {
                    return span3;
                }
                if (!z && span3.findEnd(view)) {
                    return span3;
                }
            }
            i2++;
        }
    }

    private int getMaxEnd(int i, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638649759")) {
            return ((Integer) ipChange.ipc$dispatch("1638649759", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
        }
        int endLine = this.mSpans[0].getEndLine(i, cVar);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i, cVar);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288149816")) {
            return ((Integer) ipChange.ipc$dispatch("288149816", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
        }
        int startLine = this.mSpans[0].getStartLine(i, cVar);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i, cVar);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363947149")) {
            return ((Integer) ipChange.ipc$dispatch("1363947149", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
        }
        int endLine = this.mSpans[0].getEndLine(i, cVar);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i, cVar);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708053338")) {
            return ((Integer) ipChange.ipc$dispatch("-1708053338", new Object[]{this, Integer.valueOf(i), cVar})).intValue();
        }
        int startLine = this.mSpans[0].getStartLine(i, cVar);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i, cVar);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
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
    private Span getNextSpan(int i, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "259694279")) {
            return (Span) ipChange.ipc$dispatch("259694279", new Object[]{this, Integer.valueOf(i), dVar, layoutManagerHelper});
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        int i4 = -1;
        if (layoutManagerHelper.getOrientation() == 0) {
        }
        boolean z = true;
        if (z) {
            i3 = this.mNumLanes - 1;
            i2 = -1;
        } else {
            i4 = this.mNumLanes;
            i2 = 1;
        }
        Span span = null;
        if (dVar.f() == 1) {
            int i5 = Integer.MAX_VALUE;
            while (i3 != i4) {
                Span span2 = this.mSpans[i3];
                int endLine = span2.getEndLine(i, mainOrientationHelper);
                if (endLine < i5) {
                    span = span2;
                    i5 = endLine;
                }
                i3 += i2;
            }
            return span;
        }
        int i6 = Integer.MIN_VALUE;
        while (i3 != i4) {
            Span span3 = this.mSpans[i3];
            int startLine = span3.getStartLine(i, mainOrientationHelper);
            if (startLine > i6) {
                span = span3;
                i6 = startLine;
            }
            i3 += i2;
        }
        return span;
    }

    private View hasGapsToFix(VirtualLayoutManager virtualLayoutManager, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925867028")) {
            return (View) ipChange.ipc$dispatch("925867028", new Object[]{this, virtualLayoutManager, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (!(virtualLayoutManager.findViewByPosition(i) == null || this.mSpans == null)) {
            new BitSet(this.mNumLanes).set(0, this.mNumLanes, true);
            int length = this.mSpans.length;
            for (int i3 = 0; i3 < length; i3++) {
                Span span = this.mSpans[i3];
                if (span.mViews.size() != 0 && checkSpanForGap(span, virtualLayoutManager, i2)) {
                    return (View) (virtualLayoutManager.getReverseLayout() ? span.mViews.get(span.mViews.size() - 1) : span.mViews.get(0));
                }
            }
        }
        return null;
    }

    private void recycle(RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, Span span, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516962409")) {
            ipChange.ipc$dispatch("1516962409", new Object[]{this, recycler, dVar, span, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (dVar.f() == -1) {
            recycleFromEnd(recycler, Math.max(i, getMaxStart(span.getStartLine(mainOrientationHelper), mainOrientationHelper)) + (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        } else {
            recycleFromStart(recycler, Math.min(i, getMinEnd(span.getEndLine(mainOrientationHelper), mainOrientationHelper)) - (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        }
    }

    private void recycleForPreLayout(RecyclerView.Recycler recycler, VirtualLayoutManager.d dVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408906306")) {
            ipChange.ipc$dispatch("408906306", new Object[]{this, recycler, dVar, layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int size = this.preLayoutViewList.size() - 1; size >= 0; size--) {
            View view = this.preLayoutViewList.get(size);
            if (view == null || mainOrientationHelper.g(view) <= mainOrientationHelper.i()) {
                Span findSpan = findSpan(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition(), view, false);
                if (findSpan != null) {
                    findSpan.popEnd(mainOrientationHelper);
                }
                layoutManagerHelper.removeChildView(view);
                recycler.recycleView(view);
                return;
            }
            Span findSpan2 = findSpan(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition(), view, false);
            if (findSpan2 != null) {
                findSpan2.popEnd(mainOrientationHelper);
            }
            layoutManagerHelper.removeChildView(view);
            recycler.recycleView(view);
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593922109")) {
            ipChange.ipc$dispatch("-1593922109", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = layoutManagerHelper.getChildAt(childCount);
            if (childAt != null && mainOrientationHelper.g(childAt) > i) {
                Span findSpan = findSpan(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, false);
                if (findSpan != null) {
                    findSpan.popEnd(mainOrientationHelper);
                    layoutManagerHelper.removeChildView(childAt);
                    recycler.recycleView(childAt);
                }
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304527516")) {
            ipChange.ipc$dispatch("304527516", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        boolean z = true;
        while (layoutManagerHelper.getChildCount() > 0 && z && (childAt = layoutManagerHelper.getChildAt(0)) != null && mainOrientationHelper.d(childAt) < i) {
            Span findSpan = findSpan(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, true);
            if (findSpan != null) {
                findSpan.popStart(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            } else {
                z = false;
            }
        }
    }

    private void updateAllRemainingSpans(int i, int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910880849")) {
            ipChange.ipc$dispatch("-1910880849", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), cVar});
            return;
        }
        for (int i3 = 0; i3 < this.mNumLanes; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2, cVar);
            }
        }
    }

    private void updateRemainingSpans(Span span, int i, int i2, c cVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997038972")) {
            ipChange.ipc$dispatch("997038972", new Object[]{this, span, Integer.valueOf(i), Integer.valueOf(i2), cVar});
            return;
        }
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.getStartLine(cVar) + deletedSize < i2) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine(cVar) - deletedSize > i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560108773")) {
            ipChange.ipc$dispatch("-560108773", new Object[]{this, recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
            return;
        }
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        this.mLayoutWithAnchor = false;
        if (i <= getRange().e().intValue() && i2 >= getRange().d().intValue() && !state.isPreLayout() && layoutManagerHelper.getChildCount() > 0) {
            ViewCompat.postOnAnimation(layoutManagerHelper.getChildAt(0), this.checkForGapsRunnable);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175189553")) {
            ipChange.ipc$dispatch("1175189553", new Object[]{this, recycler, state, layoutManagerHelper});
            return;
        }
        super.beforeLayout(recycler, state, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            i2 = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin();
            i = getHorizontalPadding();
        } else {
            i2 = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
            i = getVerticalPadding();
        }
        int i3 = i2 - i;
        int i4 = this.mHGap;
        int i5 = this.mNumLanes;
        int i6 = (int) (((double) ((i3 - (i4 * (i5 - 1))) / i5)) + 0.5d);
        this.mColLength = i6;
        int i7 = i3 - (i6 * i5);
        if (i5 <= 1) {
            this.mLastGap = 0;
            this.mEachGap = 0;
        } else if (i5 == 2) {
            this.mEachGap = i7;
            this.mLastGap = i7;
        } else {
            int i8 = layoutManagerHelper.getOrientation() == 1 ? this.mHGap : this.mVGap;
            this.mLastGap = i8;
            this.mEachGap = i8;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.mLayoutManager;
        if ((weakReference == null || weakReference.get() == null || this.mLayoutManager.get() != layoutManagerHelper) && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            this.mLayoutManager = new WeakReference<>((VirtualLayoutManager) layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "110763244")) {
            ipChange.ipc$dispatch("110763244", new Object[]{this, state, cVar, layoutManagerHelper});
            return;
        }
        super.checkAnchorInfo(state, cVar, layoutManagerHelper);
        ensureLanes();
        sw1<Integer> range = getRange();
        if (cVar.c) {
            if (cVar.a < (range.d().intValue() + this.mNumLanes) - 1) {
                cVar.a = Math.min((range.d().intValue() + this.mNumLanes) - 1, range.e().intValue());
            }
        } else if (cVar.a > range.e().intValue() - (this.mNumLanes - 1)) {
            cVar.a = Math.max(range.d().intValue(), range.e().intValue() - (this.mNumLanes - 1));
        }
        View findViewByPosition = layoutManagerHelper.findViewByPosition(cVar.a);
        int i3 = layoutManagerHelper.getOrientation() == 1 ? this.mVGap : this.mHGap;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (findViewByPosition == null) {
            int length = this.mSpans.length;
            while (i2 < length) {
                Span span = this.mSpans[i2];
                span.clear();
                span.setLine(cVar.b);
                i2++;
            }
            return;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = cVar.c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int length2 = this.mSpans.length;
        for (int i6 = 0; i6 < length2; i6++) {
            Span span2 = this.mSpans[i6];
            if (!span2.mViews.isEmpty()) {
                if (cVar.c) {
                    i5 = Math.max(i5, layoutManagerHelper.getPosition((View) span2.mViews.get(span2.mViews.size() - 1)));
                } else {
                    i5 = Math.min(i5, layoutManagerHelper.getPosition((View) span2.mViews.get(0)));
                }
            }
        }
        if (!isOutOfRange(i5)) {
            if (i5 != range.d().intValue()) {
                z = false;
            }
            View findViewByPosition2 = layoutManagerHelper.findViewByPosition(i5);
            if (findViewByPosition2 != null) {
                if (cVar.c) {
                    cVar.a = i5;
                    int d = mainOrientationHelper.d(findViewByPosition);
                    int i7 = cVar.b;
                    if (d < i7) {
                        int i8 = i7 - d;
                        if (z) {
                            i3 = 0;
                        }
                        i = i8 + i3;
                        cVar.b = mainOrientationHelper.d(findViewByPosition2) + i;
                    } else {
                        if (z) {
                            i3 = 0;
                        }
                        cVar.b = mainOrientationHelper.d(findViewByPosition2) + i3;
                        i = i3;
                    }
                } else {
                    cVar.a = i5;
                    int g = mainOrientationHelper.g(findViewByPosition);
                    int i9 = cVar.b;
                    if (g > i9) {
                        int i10 = i9 - g;
                        if (z) {
                            i3 = 0;
                        }
                        i = i10 - i3;
                        cVar.b = mainOrientationHelper.g(findViewByPosition2) + i;
                    } else {
                        if (z) {
                            i3 = 0;
                        }
                        int i11 = -i3;
                        cVar.b = mainOrientationHelper.g(findViewByPosition2) + i11;
                        i4 = i11;
                    }
                }
                i4 = i;
            }
        } else {
            this.anchorPosition = cVar.a;
            this.mLayoutWithAnchor = true;
        }
        int length3 = this.mSpans.length;
        while (i2 < length3) {
            this.mSpans[i2].cacheReferenceLineAndClear(layoutManagerHelper.getReverseLayout() ^ cVar.c, i4, mainOrientationHelper);
            i2++;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253465475")) {
            return ((Integer) ipChange.ipc$dispatch("-1253465475", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
        }
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View findViewByPosition = layoutManagerHelper.findViewByPosition(getRange().d().intValue() + i);
        if (findViewByPosition == null) {
            return 0;
        }
        ensureLanes();
        if (z3) {
            if (z) {
                if (i == getItemCount() - 1) {
                    return this.mMarginBottom + this.mPaddingBottom + (getMaxEnd(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition));
                }
                if (!z2) {
                    return getMinEnd(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition);
                }
            } else if (i == 0) {
                return ((-this.mMarginTop) - this.mPaddingTop) - (mainOrientationHelper.g(findViewByPosition) - getMinStart(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper));
            } else {
                if (!z2) {
                    return getMaxStart(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.g(findViewByPosition);
                }
            }
        }
        return 0;
    }

    public int getColLength() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2065289681")) {
            return this.mColLength;
        }
        return ((Integer) ipChange.ipc$dispatch("2065289681", new Object[]{this})).intValue();
    }

    public int getHGap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1051675979")) {
            return this.mHGap;
        }
        return ((Integer) ipChange.ipc$dispatch("1051675979", new Object[]{this})).intValue();
    }

    public int getLane() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1062759405")) {
            return this.mNumLanes;
        }
        return ((Integer) ipChange.ipc$dispatch("1062759405", new Object[]{this})).intValue();
    }

    public int getRawLane() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "771541283")) {
            return this.mRawLane;
        }
        return ((Integer) ipChange.ipc$dispatch("771541283", new Object[]{this})).intValue();
    }

    public int getVGap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "591825625")) {
            return this.mVGap;
        }
        return ((Integer) ipChange.ipc$dispatch("591825625", new Object[]{this})).intValue();
    }

    @Override // com.alibaba.android.vlayout.a
    public boolean isRecyclable(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper, boolean z) {
        View findViewByPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861580893")) {
            return ((Boolean) ipChange.ipc$dispatch("-1861580893", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper, Boolean.valueOf(z)})).booleanValue();
        }
        boolean isRecyclable = super.isRecyclable(i, i2, i3, layoutManagerHelper, z);
        if (isRecyclable && (findViewByPosition = layoutManagerHelper.findViewByPosition(i)) != null) {
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            int viewPosition = ((RecyclerView.LayoutParams) findViewByPosition.getLayoutParams()).getViewPosition();
            if (layoutManagerHelper.getReverseLayout()) {
                if (z) {
                    Span findSpan = findSpan(viewPosition, findViewByPosition, true);
                    if (findSpan != null) {
                        findSpan.popEnd(mainOrientationHelper);
                    }
                } else {
                    Span findSpan2 = findSpan(viewPosition, findViewByPosition, false);
                    if (findSpan2 != null) {
                        findSpan2.popStart(mainOrientationHelper);
                    }
                }
            } else if (z) {
                Span findSpan3 = findSpan(viewPosition, findViewByPosition, true);
                if (findSpan3 != null) {
                    findSpan3.popStart(mainOrientationHelper);
                }
            } else {
                Span findSpan4 = findSpan(viewPosition, findViewByPosition, false);
                if (findSpan4 != null) {
                    findSpan4.popEnd(mainOrientationHelper);
                }
            }
        }
        return isRecyclable;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        int i;
        int i2;
        VirtualLayoutManager.d dVar2;
        int i3;
        int i4;
        int i5;
        int i6;
        Span span;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        View view;
        c cVar;
        int i13;
        Span span2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.d dVar3 = dVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318493983")) {
            ipChange.ipc$dispatch("318493983", new Object[]{this, recycler2, state2, dVar3, s61, layoutManagerHelper});
        } else if (!isOutOfRange(dVar.c())) {
            ensureLanes();
            boolean z3 = layoutManagerHelper.getOrientation() == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            c secondaryOrientationHelper = layoutManagerHelper.getSecondaryOrientationHelper();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            this.mRemainingSpans.set(0, this.mNumLanes, true);
            if (dVar.f() == 1) {
                i2 = dVar.g() + dVar.b();
                i = dVar.d() + i2 + mainOrientationHelper.j();
            } else {
                i2 = dVar.g() - dVar.b();
                i = (i2 - dVar.d()) - mainOrientationHelper.k();
            }
            int i19 = i;
            updateAllRemainingSpans(dVar.f(), i19, mainOrientationHelper);
            int g = dVar.g();
            this.preLayoutViewList.clear();
            while (dVar3.h(state2) && !this.mRemainingSpans.isEmpty() && !isOutOfRange(dVar.c())) {
                int c = dVar.c();
                View l = dVar3.l(recycler2);
                if (l == null) {
                    break;
                }
                VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) l.getLayoutParams();
                int viewPosition = layoutParams.getViewPosition();
                int span3 = this.mLazySpanLookup.getSpan(viewPosition);
                if (span3 == Integer.MIN_VALUE) {
                    span = getNextSpan(g, dVar3, layoutManagerHelper);
                    this.mLazySpanLookup.setSpan(viewPosition, span);
                } else {
                    span = this.mSpans[span3];
                }
                boolean z4 = viewPosition - getRange().d().intValue() < this.mNumLanes;
                boolean z5 = getRange().e().intValue() - viewPosition < this.mNumLanes;
                if (dVar.j()) {
                    this.preLayoutViewList.add(l);
                }
                layoutManagerHelper.addChildView(dVar3, l);
                if (z3) {
                    int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    int l2 = mainOrientationHelper.l();
                    if (Float.isNaN(layoutParams.a)) {
                        i18 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    } else {
                        i18 = (int) ((((float) View.MeasureSpec.getSize(childMeasureSpec)) / layoutParams.a) + 0.5f);
                    }
                    layoutManagerHelper.measureChildWithMargins(l, childMeasureSpec, layoutManagerHelper.getChildMeasureSpec(l2, i18, true));
                    z = true;
                } else {
                    int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    int l3 = mainOrientationHelper.l();
                    if (Float.isNaN(layoutParams.a)) {
                        i17 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    } else {
                        i17 = (int) ((((float) View.MeasureSpec.getSize(childMeasureSpec2)) * layoutParams.a) + 0.5f);
                    }
                    z = true;
                    layoutManagerHelper.measureChildWithMargins(l, layoutManagerHelper.getChildMeasureSpec(l3, i17, true), childMeasureSpec2);
                }
                if (dVar.f() == z) {
                    i8 = span.getEndLine(g, mainOrientationHelper);
                    if (z4) {
                        i16 = computeStartSpace(layoutManagerHelper, z3, z, isEnableMarginOverLap);
                    } else if (this.mLayoutWithAnchor) {
                        if (Math.abs(c - this.anchorPosition) >= this.mNumLanes) {
                            i16 = z3 ? this.mVGap : this.mHGap;
                        }
                        i7 = mainOrientationHelper.e(l) + i8;
                    } else {
                        i16 = z3 ? this.mVGap : this.mHGap;
                    }
                    i8 += i16;
                    i7 = mainOrientationHelper.e(l) + i8;
                } else {
                    if (z5) {
                        i15 = span.getStartLine(g, mainOrientationHelper);
                        i14 = (z3 ? this.mMarginBottom : this.mMarginRight) + this.mPaddingRight;
                    } else {
                        i15 = span.getStartLine(g, mainOrientationHelper);
                        i14 = z3 ? this.mVGap : this.mHGap;
                    }
                    int i20 = i15 - i14;
                    i7 = i20;
                    i8 = i20 - mainOrientationHelper.e(l);
                }
                if (dVar.f() == 1) {
                    span.appendToSpan(l, mainOrientationHelper);
                } else {
                    span.prependToSpan(l, mainOrientationHelper);
                }
                int i21 = span.mIndex;
                if (i21 == this.mNumLanes - 1) {
                    int i22 = this.mColLength;
                    int i23 = this.mEachGap;
                    i9 = ((i21 * (i22 + i23)) - i23) + this.mLastGap;
                } else {
                    i9 = i21 * (this.mColLength + this.mEachGap);
                }
                int k = i9 + secondaryOrientationHelper.k();
                if (z3) {
                    i11 = this.mMarginLeft;
                    i10 = this.mPaddingLeft;
                } else {
                    i11 = this.mMarginTop;
                    i10 = this.mPaddingTop;
                }
                int i24 = k + i11 + i10;
                int f = i24 + mainOrientationHelper.f(l);
                if (z3) {
                    view = l;
                    i12 = g;
                    z2 = isEnableMarginOverLap;
                    layoutChildWithMargin(l, i24, i8, f, i7, layoutManagerHelper);
                    i13 = i19;
                    span2 = span;
                    cVar = mainOrientationHelper;
                } else {
                    view = l;
                    i12 = g;
                    z2 = isEnableMarginOverLap;
                    span2 = span;
                    i13 = i19;
                    cVar = mainOrientationHelper;
                    layoutChildWithMargin(view, i8, i24, i7, f, layoutManagerHelper);
                }
                updateRemainingSpans(span2, dVar.f(), i13, cVar);
                recycle(recycler, dVar, span2, i2, layoutManagerHelper);
                handleStateOnResult(s61, view);
                recycler2 = recycler;
                dVar3 = dVar;
                i19 = i13;
                mainOrientationHelper = cVar;
                isEnableMarginOverLap = z2;
                g = i12;
                state2 = state;
            }
            if (isOutOfRange(dVar.c())) {
                if (dVar.f() == -1) {
                    int length = this.mSpans.length;
                    for (int i25 = 0; i25 < length; i25++) {
                        Span span4 = this.mSpans[i25];
                        int i26 = span4.mCachedStart;
                        if (i26 != Integer.MIN_VALUE) {
                            span4.mLastEdgeStart = i26;
                        }
                    }
                } else {
                    int length2 = this.mSpans.length;
                    for (int i27 = 0; i27 < length2; i27++) {
                        Span span5 = this.mSpans[i27];
                        int i28 = span5.mCachedEnd;
                        if (i28 != Integer.MIN_VALUE) {
                            span5.mLastEdgeEnd = i28;
                        }
                    }
                }
            }
            if (dVar.f() == -1) {
                if (!isOutOfRange(dVar.c())) {
                    dVar2 = dVar;
                    if (dVar2.h(state)) {
                        s61.a = dVar.g() - getMaxStart(mainOrientationHelper.k(), mainOrientationHelper);
                    }
                } else {
                    dVar2 = dVar;
                }
                int g2 = dVar.g() - getMinStart(mainOrientationHelper.i(), mainOrientationHelper);
                if (z3) {
                    i6 = this.mMarginTop;
                    i5 = this.mPaddingTop;
                } else {
                    i6 = this.mMarginLeft;
                    i5 = this.mPaddingLeft;
                }
                s61.a = g2 + i6 + i5;
            } else {
                dVar2 = dVar;
                if (isOutOfRange(dVar.c()) || !dVar2.h(state)) {
                    int maxEnd = getMaxEnd(mainOrientationHelper.i(), mainOrientationHelper) - dVar.g();
                    if (z3) {
                        i4 = this.mMarginBottom;
                        i3 = this.mPaddingBottom;
                    } else {
                        i4 = this.mMarginRight;
                        i3 = this.mPaddingRight;
                    }
                    s61.a = maxEnd + i4 + i3;
                } else {
                    s61.a = getMinEnd(mainOrientationHelper.i(), mainOrientationHelper) - dVar.g();
                }
            }
            recycleForPreLayout(recycler, dVar2, layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318757874")) {
            ipChange.ipc$dispatch("318757874", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.mLazySpanLookup.clear();
        this.mSpans = null;
        this.mLayoutManager = null;
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245787269")) {
            ipChange.ipc$dispatch("245787269", new Object[]{this, layoutManagerHelper});
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onOffsetChildrenHorizontal(int i, LayoutManagerHelper layoutManagerHelper) {
        Span[] spanArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377174998")) {
            ipChange.ipc$dispatch("377174998", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenHorizontal(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 0 && (spanArr = this.mSpans) != null) {
            int length = spanArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mSpans[i2].onOffset(i);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onOffsetChildrenVertical(int i, LayoutManagerHelper layoutManagerHelper) {
        Span[] spanArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604721604")) {
            ipChange.ipc$dispatch("604721604", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenVertical(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1 && (spanArr = this.mSpans) != null) {
            int length = spanArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mSpans[i2].onOffset(i);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRefreshLayout(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836652239")) {
            ipChange.ipc$dispatch("-1836652239", new Object[]{this, state, cVar, layoutManagerHelper});
            return;
        }
        super.onRefreshLayout(state, cVar, layoutManagerHelper);
        ensureLanes();
        if (isOutOfRange(cVar.a)) {
            int length = this.mSpans.length;
            for (int i = 0; i < length; i++) {
                this.mSpans[i].clear();
            }
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702241421")) {
            ipChange.ipc$dispatch("-702241421", new Object[]{this, bundle});
            return;
        }
        super.onRestoreInstanceState(bundle);
        this.mLazySpanLookup.mData = bundle.getIntArray(LOOKUP_BUNDLE_KEY);
    }

    @Override // com.alibaba.android.vlayout.a
    public void onSaveState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975126381")) {
            ipChange.ipc$dispatch("1975126381", new Object[]{this, bundle});
            return;
        }
        super.onSaveState(bundle);
        bundle.putIntArray(LOOKUP_BUNDLE_KEY, this.mLazySpanLookup.mData);
    }

    @Override // com.alibaba.android.vlayout.a
    public void onScrollStateChanged(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479499612")) {
            ipChange.ipc$dispatch("479499612", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
        } else if (i2 <= getRange().e().intValue() && i3 >= getRange().d().intValue() && i == 0) {
            checkForGaps();
        }
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437892247")) {
            ipChange.ipc$dispatch("-1437892247", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setHGap(i);
        setVGap(i);
    }

    public void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846333001")) {
            ipChange.ipc$dispatch("-1846333001", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mHGap = i;
    }

    public void setLane(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502746795")) {
            ipChange.ipc$dispatch("-1502746795", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mNumLanes = i;
        ensureLanes();
    }

    public void setRawLane(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671236935")) {
            ipChange.ipc$dispatch("671236935", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRawLane = i;
        setLane(i);
    }

    public void setVGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1078175209")) {
            ipChange.ipc$dispatch("1078175209", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mVGap = i;
    }

    public StaggeredGridLayoutHelper(int i) {
        this(i, 0);
    }

    public StaggeredGridLayoutHelper(int i, int i2) {
        this.mNumLanes = 0;
        this.mHGap = 0;
        this.mVGap = 0;
        this.mColLength = 0;
        this.mEachGap = 0;
        this.mLastGap = 0;
        this.mRemainingSpans = null;
        this.mLazySpanLookup = new LazySpanLookup();
        this.preLayoutViewList = new ArrayList();
        this.mLayoutManager = null;
        this.checkForGapsRunnable = new Runnable() {
            /* class com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "339628548")) {
                    ipChange.ipc$dispatch("339628548", new Object[]{this});
                    return;
                }
                StaggeredGridLayoutHelper.this.checkForGaps();
            }
        };
        setRawLane(i);
        setGap(i2);
    }
}
