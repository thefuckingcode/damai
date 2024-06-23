package com.alibaba.android.vlayout;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx;
import com.alibaba.android.vlayout.extend.LayoutManagerCanScrollListener;
import com.alibaba.android.vlayout.extend.PerformanceMonitor;
import com.alibaba.android.vlayout.extend.ViewLifeCycleHelper;
import com.alibaba.android.vlayout.extend.ViewLifeCycleListener;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.o70;
import tb.s61;
import tb.sw1;
import tb.z40;
import tb.zi0;

/* compiled from: Taobao */
public class VirtualLayoutManager extends ExposeLinearLayoutManagerEx implements LayoutManagerHelper {
    private static a DEFAULT_LAYOUT_HELPER = new z40();
    public static final int HORIZONTAL = 0;
    private static final int MAX_NO_SCROLLING_SIZE = 134217727;
    private static final String PHASE_LAYOUT = "layout";
    private static final String PHASE_MEASURE = "measure";
    protected static final String TAG = "VirtualLayoutManager";
    private static final String TRACE_LAYOUT = "VLM onLayoutChildren";
    private static final String TRACE_SCROLL = "VLM scroll";
    public static final int VERTICAL = 1;
    public static boolean sDebuggable;
    private LayoutManagerCanScrollListener layoutManagerCanScrollListener;
    private boolean mCanScrollHorizontally;
    private boolean mCanScrollVertically;
    private Rect mDecorInsets;
    private a mDefaultLayoutHelper;
    private boolean mEnableMarginOverlapping;
    private zi0 mFixAreaAdjustor;
    private b mHelperFinder;
    private BaseLayoutHelper.LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewFactory mLayoutViewFatory;
    private int mMaxMeasureSize;
    private int mMeasuredFullSpace;
    private int mNested;
    private boolean mNestedScrolling;
    private boolean mNoScrolling;
    protected c mOrientationHelper;
    private PerformanceMonitor mPerformanceMonitor;
    private Comparator<Pair<sw1<Integer>, Integer>> mRangeComparator;
    private List<Pair<sw1<Integer>, Integer>> mRangeLengths;
    private RecyclerView mRecyclerView;
    protected c mSecondaryOrientationHelper;
    private boolean mSpaceMeasured;
    private boolean mSpaceMeasuring;
    private c mTempAnchorInfoWrapper;
    private d mTempLayoutStateWrapper;
    private ViewLifeCycleHelper mViewLifeCycleHelper;
    private HashMap<Integer, a> newHelpersSet;
    private HashMap<Integer, a> oldHelpersSet;

    /* compiled from: Taobao */
    public interface CacheViewHolder {
        boolean needCached();
    }

    /* compiled from: Taobao */
    public static class InflateLayoutParams extends LayoutParams {
        public InflateLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: Taobao */
    class a implements Comparator<Pair<sw1<Integer>, Integer>> {
        a(VirtualLayoutManager virtualLayoutManager) {
        }

        /* renamed from: a */
        public int compare(Pair<sw1<Integer>, Integer> pair, Pair<sw1<Integer>, Integer> pair2) {
            if (pair == null && pair2 == null) {
                return 0;
            }
            if (pair == null) {
                return -1;
            }
            if (pair2 == null) {
                return 1;
            }
            return ((Integer) ((sw1) pair.first).d()).intValue() - ((Integer) ((sw1) pair2.first).d()).intValue();
        }
    }

    /* compiled from: Taobao */
    class b implements LayoutViewFactory {
        b(VirtualLayoutManager virtualLayoutManager) {
        }

        @Override // com.alibaba.android.vlayout.LayoutViewFactory
        public View generateLayoutView(@NonNull Context context) {
            return new LayoutView(context);
        }
    }

    /* compiled from: Taobao */
    public static class c {
        public int a;
        public int b;
        public boolean c;

        c() {
        }
    }

    /* compiled from: Taobao */
    public static class d {
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        private ExposeLinearLayoutManagerEx.c a;

        d() {
        }

        public int b() {
            return this.a.mAvailable;
        }

        public int c() {
            return this.a.mCurrentPosition;
        }

        public int d() {
            return this.a.mExtra;
        }

        public int e() {
            return this.a.mItemDirection;
        }

        public int f() {
            return this.a.mLayoutDirection;
        }

        public int g() {
            return this.a.mOffset;
        }

        public boolean h(RecyclerView.State state) {
            return this.a.hasMore(state);
        }

        public boolean i() {
            return this.a.mScrapList != null;
        }

        public boolean j() {
            return this.a.mIsPreLayout;
        }

        public boolean k() {
            return this.a.mOnRefresLayout;
        }

        public View l(RecyclerView.Recycler recycler) {
            return this.a.next(recycler);
        }

        public View m(RecyclerView.Recycler recycler, int i) {
            ExposeLinearLayoutManagerEx.c cVar = this.a;
            int i2 = cVar.mCurrentPosition;
            cVar.mCurrentPosition = i;
            View l = l(recycler);
            this.a.mCurrentPosition = i2;
            return l;
        }

        public void n() {
            ExposeLinearLayoutManagerEx.c cVar = this.a;
            cVar.mCurrentPosition += cVar.mItemDirection;
        }
    }

    /* compiled from: Taobao */
    private static class e extends RecyclerView.ViewHolder {
        public e(View view) {
            super(view);
        }
    }

    public VirtualLayoutManager(@NonNull Context context) {
        this(context, 1);
    }

    public static void enableDebugging(boolean z) {
        sDebuggable = z;
    }

    @Nullable
    private int findRangeLength(@NonNull sw1<Integer> sw1) {
        Pair<sw1<Integer>, Integer> pair;
        Pair<sw1<Integer>, Integer> pair2;
        int size = this.mRangeLengths.size();
        if (size == 0) {
            return -1;
        }
        int i = 0;
        int i2 = size - 1;
        int i3 = -1;
        while (true) {
            pair = null;
            if (i > i2) {
                break;
            }
            i3 = (i + i2) / 2;
            pair2 = this.mRangeLengths.get(i3);
            sw1<Integer> sw12 = (sw1) pair2.first;
            if (sw12 == null) {
                break;
            } else if (sw12.a(sw1.d()) || sw12.a(sw1.e()) || sw1.b(sw12)) {
                pair = pair2;
            } else if (sw12.d().intValue() > sw1.e().intValue()) {
                i2 = i3 - 1;
            } else if (sw12.e().intValue() < sw1.d().intValue()) {
                i = i3 + 1;
            }
        }
        pair = pair2;
        if (pair == null) {
            return -1;
        }
        return i3;
    }

    private void measureChildWithDecorations(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        Rect rect = this.mDecorInsets;
        int updateSpecWithExtra = updateSpecWithExtra(i, rect.left, rect.right);
        Rect rect2 = this.mDecorInsets;
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, rect2.top, rect2.bottom);
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart(PHASE_MEASURE, view);
        }
        view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd(PHASE_MEASURE, view);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (getOrientation() == 1) {
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            Rect rect = this.mDecorInsets;
            i = updateSpecWithExtra(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        }
        if (getOrientation() == 0) {
            Rect rect2 = this.mDecorInsets;
            i2 = updateSpecWithExtra(i2, rect2.top, rect2.bottom);
        }
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart(PHASE_MEASURE, view);
        }
        view.measure(i, i2);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd(PHASE_MEASURE, view);
        }
    }

    private void runPostLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        int i2 = this.mNested - 1;
        this.mNested = i2;
        if (i2 <= 0) {
            this.mNested = 0;
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = findLastVisibleItemPosition();
            for (a aVar : this.mHelperFinder.b()) {
                try {
                    aVar.afterLayout(recycler, state, findFirstVisibleItemPosition, findLastVisibleItemPosition, i, this);
                } catch (Exception e2) {
                    if (sDebuggable) {
                        throw e2;
                    }
                }
            }
            ViewLifeCycleHelper viewLifeCycleHelper = this.mViewLifeCycleHelper;
            if (viewLifeCycleHelper != null) {
                viewLifeCycleHelper.a();
            }
        }
    }

    private void runPreLayout(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mNested == 0) {
            for (a aVar : this.mHelperFinder.c()) {
                aVar.beforeLayout(recycler, state, this);
            }
        }
        this.mNested++;
    }

    private void setDefaultLayoutHelper(@NonNull a aVar) {
        if (aVar != null) {
            this.mDefaultLayoutHelper = aVar;
            return;
        }
        throw new IllegalArgumentException("layoutHelper should not be null");
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i;
        }
        if ((View.MeasureSpec.getSize(i) - i2) - i3 < 0) {
            return View.MeasureSpec.makeMeasureSpec(0, mode);
        }
        return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addBackgroundView(View view, boolean z) {
        showView(view);
        addView(view, z ? 0 : -1);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(View view, int i) {
        super.addView(view, i);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addFixedView(View view) {
        addOffFlowView(view, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addOffFlowView(View view, boolean z) {
        showView(view);
        addHiddenView(view, z);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ void assertNotInLayoutOrScroll(String str) {
        super.assertNotInLayoutOrScroll(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollHorizontally() {
        LayoutManagerCanScrollListener layoutManagerCanScrollListener2 = this.layoutManagerCanScrollListener;
        boolean z = layoutManagerCanScrollListener2 == null || layoutManagerCanScrollListener2.canScrollHorizontally();
        if (!this.mCanScrollHorizontally || this.mNoScrolling || !z) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollVertically() {
        LayoutManagerCanScrollListener layoutManagerCanScrollListener2 = this.layoutManagerCanScrollListener;
        boolean z = layoutManagerCanScrollListener2 == null || layoutManagerCanScrollListener2.canScrollVertically();
        if (!this.mCanScrollVertically || this.mNoScrolling || !z) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int computeAlignOffset(View view, boolean z, boolean z2) {
        return computeAlignOffset(getPosition(view), z, z2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ PointF computeScrollVectorForPosition(int i) {
        return super.computeScrollVectorForPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapAttachedViews(RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAt(childCount));
            if ((childViewHolder instanceof CacheViewHolder) && ((CacheViewHolder) childViewHolder).needCached()) {
                ExposeLinearLayoutManagerEx.d.e(childViewHolder, 0, 6);
            }
        }
        super.detachAndScrapAttachedViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapView(View view, RecyclerView.Recycler recycler) {
        super.detachAndScrapView(view, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapViewAt(int i, RecyclerView.Recycler recycler) {
        RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAt(i));
        if ((childViewHolder instanceof CacheViewHolder) && ((CacheViewHolder) childViewHolder).needCached()) {
            ExposeLinearLayoutManagerEx.d.e(childViewHolder, 0, 4);
        }
        super.detachAndScrapViewAt(i, recycler);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public /* bridge */ /* synthetic */ void ensureLayoutStateExpose() {
        super.ensureLayoutStateExpose();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findFirstVisibleItemPosition() {
        return super.findFirstVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findLastVisibleItemPosition() {
        return super.findLastVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public a findLayoutHelperByPosition(int i) {
        return this.mHelperFinder.a(i);
    }

    public a findNeighbourNonfixLayoutHelper(a aVar, boolean z) {
        List<a> b2;
        int indexOf;
        a aVar2;
        if (aVar == null || (indexOf = (b2 = this.mHelperFinder.b()).indexOf(aVar)) == -1) {
            return null;
        }
        int i = z ? indexOf - 1 : indexOf + 1;
        if (i < 0 || i >= b2.size() || (aVar2 = b2.get(i)) == null || aVar2.isFixLayout()) {
            return null;
        }
        return aVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper, androidx.recyclerview.widget.LinearLayoutManager
    public View findViewByPosition(int i) {
        View findViewByPosition = super.findViewByPosition(i);
        if (findViewByPosition != null && getPosition(findViewByPosition) == i) {
            return findViewByPosition;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && getPosition(childAt) == i) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) ((LayoutParams) layoutParams));
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public final View generateLayoutView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        View generateLayoutView = this.mLayoutViewFatory.generateLayoutView(recyclerView.getContext());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ExposeLinearLayoutManagerEx.attachViewHolder(layoutParams, new e(generateLayoutView));
        generateLayoutView.setLayoutParams(layoutParams);
        return generateLayoutView;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getChildMeasureSpec(int i, int i2, boolean z) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(i, 0, i2, z);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView.ViewHolder getChildViewHolder(View view) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getChildViewHolder(view);
        }
        return null;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentHeight() {
        return super.getHeight();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentWidth() {
        return super.getWidth();
    }

    public List<View> getFixedViews() {
        if (this.mRecyclerView == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (a aVar : this.mHelperFinder.b()) {
            View fixedView = aVar.getFixedView();
            if (fixedView != null) {
                linkedList.add(fixedView);
            }
        }
        return linkedList;
    }

    @NonNull
    public List<a> getLayoutHelpers() {
        return this.mHelperFinder.b();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public c getMainOrientationHelper() {
        return this.mOrientationHelper;
    }

    public int getOffsetToStart() {
        int i = -1;
        if (getChildCount() == 0) {
            return -1;
        }
        View childAt = getChildAt(0);
        if (childAt == null) {
            return -1;
        }
        int position = getPosition(childAt);
        int findRangeLength = findRangeLength(sw1.c(Integer.valueOf(position), Integer.valueOf(position)));
        if (findRangeLength >= 0 && findRangeLength < this.mRangeLengths.size()) {
            i = -this.mOrientationHelper.g(childAt);
            for (int i2 = 0; i2 < findRangeLength; i2++) {
                Pair<sw1<Integer>, Integer> pair = this.mRangeLengths.get(i2);
                if (pair != null) {
                    i += ((Integer) pair.second).intValue();
                }
            }
        }
        return i;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper, androidx.recyclerview.widget.LinearLayoutManager
    public int getOrientation() {
        return super.getOrientation();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public c getSecondaryOrientationHelper() {
        return this.mSecondaryOrientationHelper;
    }

    public int getVirtualLayoutDirection() {
        return ((ExposeLinearLayoutManagerEx) this).mLayoutState.mLayoutDirection;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void hideView(View view) {
        super.hideView(view);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isDoLayoutRTL() {
        return isLayoutRTL();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isEnableMarginOverLap() {
        return this.mEnableMarginOverlapping;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isViewHolderUpdated(View view) {
        RecyclerView.ViewHolder childViewHolder = getChildViewHolder(view);
        return childViewHolder == null || ExposeLinearLayoutManagerEx.isViewHolderUpdated(childViewHolder);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChild(View view, int i, int i2, int i3, int i4) {
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart("layout", view);
        }
        layoutDecorated(view, i, i2, i3, i4);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd("layout", view);
        }
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart("layout", view);
        }
        layoutDecorated(view, i + marginLayoutParams.leftMargin, i2 + marginLayoutParams.topMargin, i3 - marginLayoutParams.rightMargin, i4 - marginLayoutParams.bottomMargin);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd("layout", view);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, ExposeLinearLayoutManagerEx.c cVar, s61 s61) {
        int i = cVar.mCurrentPosition;
        this.mTempLayoutStateWrapper.a = cVar;
        b bVar = this.mHelperFinder;
        a a2 = bVar == null ? null : bVar.a(i);
        if (a2 == null) {
            a2 = this.mDefaultLayoutHelper;
        }
        a2.doLayout(recycler, state, this.mTempLayoutStateWrapper, s61, this);
        this.mTempLayoutStateWrapper.a = null;
        int i2 = cVar.mCurrentPosition;
        if (i2 == i) {
            if (sDebuggable) {
                Log.w(TAG, "layoutHelper[" + a2.getClass().getSimpleName() + o70.DINAMIC_PREFIX_AT + a2.toString() + "] consumes no item!");
            }
            s61.b = true;
            return;
        }
        int i3 = i2 - cVar.mItemDirection;
        int i4 = s61.c ? 0 : s61.a;
        sw1<Integer> sw1 = new sw1<>(Integer.valueOf(Math.min(i, i3)), Integer.valueOf(Math.max(i, i3)));
        int findRangeLength = findRangeLength(sw1);
        if (findRangeLength >= 0) {
            Pair<sw1<Integer>, Integer> pair = this.mRangeLengths.get(findRangeLength);
            if (pair == null || !((sw1) pair.first).equals(sw1) || ((Integer) pair.second).intValue() != i4) {
                this.mRangeLengths.remove(findRangeLength);
            } else {
                return;
            }
        }
        this.mRangeLengths.add(Pair.create(sw1, Integer.valueOf(i4)));
        Collections.sort(this.mRangeLengths, this.mRangeComparator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChild(View view, int i, int i2) {
        measureChildWithDecorations(view, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChildWithMargins(View view, int i, int i2) {
        measureChildWithDecorationsAndMargin(view, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void moveView(int i, int i2) {
        super.moveView(i, i2);
    }

    public int obtainExtraMargin(View view, boolean z) {
        return obtainExtraMargin(view, z, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (a aVar : this.mHelperFinder.b()) {
            aVar.onOffsetChildrenHorizontal(i, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (a aVar : this.mHelperFinder.b()) {
            aVar.onOffsetChildrenVertical(i, this);
        }
        ViewLifeCycleHelper viewLifeCycleHelper = this.mViewLifeCycleHelper;
        if (viewLifeCycleHelper != null) {
            viewLifeCycleHelper.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        super.onAdapterChanged(adapter, adapter2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void onAnchorReady(RecyclerView.State state, ExposeLinearLayoutManagerEx.a aVar) {
        super.onAnchorReady(state, aVar);
        boolean z = true;
        while (z) {
            c cVar = this.mTempAnchorInfoWrapper;
            int i = aVar.a;
            cVar.a = i;
            cVar.b = aVar.b;
            cVar.c = aVar.c;
            a a2 = this.mHelperFinder.a(i);
            if (a2 != null) {
                a2.checkAnchorInfo(state, this.mTempAnchorInfoWrapper, this);
            }
            c cVar2 = this.mTempAnchorInfoWrapper;
            int i2 = cVar2.a;
            if (i2 == aVar.a) {
                z = false;
            } else {
                aVar.a = i2;
            }
            aVar.b = cVar2.b;
            cVar2.a = -1;
        }
        c cVar3 = this.mTempAnchorInfoWrapper;
        cVar3.a = aVar.a;
        cVar3.b = aVar.b;
        for (a aVar2 : this.mHelperFinder.b()) {
            aVar2.onRefreshLayout(state, this.mTempAnchorInfoWrapper, this);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        for (a aVar : this.mHelperFinder.b()) {
            aVar.clear(this);
        }
        this.mRecyclerView = null;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.onFocusSearchFailed(view, i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        for (a aVar : this.mHelperFinder.b()) {
            aVar.onItemsChanged(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            Trace.beginSection(TRACE_LAYOUT);
        }
        if (this.mNoScrolling && state.didStructureChange()) {
            this.mSpaceMeasured = false;
            this.mSpaceMeasuring = true;
        }
        runPreLayout(recycler, state);
        try {
            super.onLayoutChildren(recycler, state);
            runPostLayout(recycler, state, Integer.MAX_VALUE);
            if ((this.mNestedScrolling || this.mNoScrolling) && this.mSpaceMeasuring) {
                this.mSpaceMeasured = true;
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null) {
                    this.mMeasuredFullSpace = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin + computeAlignOffset(childAt, true, false);
                    RecyclerView recyclerView = this.mRecyclerView;
                    if (recyclerView != null && this.mNestedScrolling) {
                        ViewParent parent = recyclerView.getParent();
                        if (parent instanceof View) {
                            this.mMeasuredFullSpace = Math.min(this.mMeasuredFullSpace, ((View) parent).getMeasuredHeight());
                        }
                    }
                } else {
                    this.mSpaceMeasuring = false;
                }
                this.mSpaceMeasuring = false;
                if (this.mRecyclerView != null && getItemCount() > 0) {
                    this.mRecyclerView.post(new Runnable() {
                        /* class com.alibaba.android.vlayout.VirtualLayoutManager.AnonymousClass2 */

                        public void run() {
                            if (VirtualLayoutManager.this.mRecyclerView != null) {
                                VirtualLayoutManager.this.mRecyclerView.requestLayout();
                            }
                        }
                    });
                }
            }
            if (i >= 18) {
                Trace.endSection();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        } catch (Throwable th) {
            runPostLayout(recycler, state, Integer.MAX_VALUE);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int i3;
        boolean z;
        if (this.mNoScrolling || this.mNestedScrolling) {
            RecyclerView recyclerView = this.mRecyclerView;
            int i4 = MAX_NO_SCROLLING_SIZE;
            if (recyclerView != null && this.mNestedScrolling) {
                i3 = this.mMaxMeasureSize;
                if (i3 <= 0) {
                    ViewParent parent = recyclerView.getParent();
                    if (parent instanceof View) {
                        i3 = ((View) parent).getMeasuredHeight();
                    }
                }
                z = this.mSpaceMeasured;
                if (z) {
                    i3 = this.mMeasuredFullSpace;
                }
                if (this.mNoScrolling) {
                    this.mSpaceMeasuring = !z;
                    if (getChildCount() > 0 || getChildCount() != getItemCount()) {
                        View childAt = getChildAt(getChildCount() - 1);
                        int i5 = this.mMeasuredFullSpace;
                        if (childAt != null) {
                            i5 = computeAlignOffset(childAt, true, false) + getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                        }
                        if (getChildCount() == getItemCount() && (childAt == null || i5 == this.mMeasuredFullSpace)) {
                            i4 = i3;
                        } else {
                            this.mSpaceMeasured = false;
                            this.mSpaceMeasuring = true;
                        }
                        i3 = i4;
                    } else if (getItemCount() == 0) {
                        this.mSpaceMeasured = true;
                        this.mSpaceMeasuring = false;
                        i3 = 0;
                    }
                }
                if (getOrientation() != 1) {
                    super.onMeasure(recycler, state, i, View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
                    return;
                } else {
                    super.onMeasure(recycler, state, View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i2);
                    return;
                }
            }
            i3 = MAX_NO_SCROLLING_SIZE;
            z = this.mSpaceMeasured;
            if (z) {
            }
            if (this.mNoScrolling) {
            }
            if (getOrientation() != 1) {
            }
        } else {
            super.onMeasure(recycler, state, i, i2);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        for (a aVar : this.mHelperFinder.b()) {
            aVar.onScrollStateChanged(i, findFirstVisibleItemPosition, findLastVisibleItemPosition, this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (sDebuggable) {
                Log.d(TAG, "Recycling " + Math.abs(i - i2) + " items");
            }
            if (i2 > i) {
                View childAt = getChildAt(i2 - 1);
                int position = getPosition(getChildAt(i));
                int position2 = getPosition(childAt);
                int i3 = i;
                while (i < i2) {
                    int position3 = getPosition(getChildAt(i3));
                    if (position3 != -1) {
                        a a2 = this.mHelperFinder.a(position3);
                        if (a2 == null || a2.isRecyclable(position3, position, position2, this, true)) {
                            removeAndRecycleViewAt(i3, recycler);
                        } else {
                            i3++;
                        }
                    } else {
                        removeAndRecycleViewAt(i3, recycler);
                    }
                    i++;
                }
                return;
            }
            View childAt2 = getChildAt(i);
            int position4 = getPosition(getChildAt(i2 + 1));
            int position5 = getPosition(childAt2);
            while (i > i2) {
                int position6 = getPosition(getChildAt(i));
                if (position6 != -1) {
                    a a3 = this.mHelperFinder.a(position6);
                    if (a3 == null || a3.isRecyclable(position6, position4, position5, this, false)) {
                        removeAndRecycleViewAt(i, recycler);
                    }
                } else {
                    removeAndRecycleViewAt(i, recycler);
                }
                i--;
            }
        }
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void recycleView(View view) {
        ViewParent parent;
        RecyclerView recyclerView;
        if (this.mRecyclerView != null && (parent = view.getParent()) != null && parent == (recyclerView = this.mRecyclerView)) {
            this.mRecyclerView.getRecycledViewPool().putRecycledView(recyclerView.getChildViewHolder(view));
        }
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void removeChildView(View view) {
        removeView(view);
    }

    public void runAdjustLayout() {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        a a2 = this.mHelperFinder.a(findFirstVisibleItemPosition);
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        a a3 = this.mHelperFinder.a(findLastVisibleItemPosition);
        List<a> b2 = this.mHelperFinder.b();
        int indexOf = b2.indexOf(a3);
        for (int indexOf2 = b2.indexOf(a2); indexOf2 <= indexOf; indexOf2++) {
            try {
                b2.get(indexOf2).adjustLayout(findFirstVisibleItemPosition, findLastVisibleItemPosition, this);
            } catch (Exception e2) {
                if (sDebuggable) {
                    throw e2;
                }
            }
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int scrollInternalBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(TRACE_SCROLL);
        }
        runPreLayout(recycler, state);
        int i2 = 0;
        try {
            if (!this.mNoScrolling) {
                i = super.scrollInternalBy(i, recycler, state);
            } else {
                if (getChildCount() != 0) {
                    if (i != 0) {
                        ((ExposeLinearLayoutManagerEx) this).mLayoutState.mRecycle = true;
                        ensureLayoutStateExpose();
                        int i3 = i > 0 ? 1 : -1;
                        int abs = Math.abs(i);
                        updateLayoutStateExpose(i3, abs, true, state);
                        ExposeLinearLayoutManagerEx.c cVar = ((ExposeLinearLayoutManagerEx) this).mLayoutState;
                        int fill = cVar.mScrollingOffset + fill(recycler, cVar, state, false);
                        if (fill < 0) {
                            runPostLayout(recycler, state, 0);
                            return 0;
                        } else if (abs > fill) {
                            i = i3 * fill;
                        }
                    }
                }
                runPostLayout(recycler, state, 0);
                return 0;
            }
            i2 = i;
        } catch (Exception e2) {
            Log.w(TAG, Log.getStackTraceString(e2), e2);
            if (sDebuggable) {
                throw e2;
            }
        } catch (Throwable th) {
            runPostLayout(recycler, state, 0);
            throw th;
        }
        runPostLayout(recycler, state, i2);
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
        return i2;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPosition(int i) {
        super.scrollToPosition(i);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i, int i2) {
        super.scrollToPositionWithOffset(i, i2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setCanScrollHorizontally(boolean z) {
        this.mCanScrollHorizontally = z;
    }

    public void setCanScrollVertically(boolean z) {
        this.mCanScrollVertically = z;
    }

    public void setEnableMarginOverlapping(boolean z) {
        this.mEnableMarginOverlapping = z;
    }

    public void setFixOffset(int i, int i2, int i3, int i4) {
        this.mFixAreaAdjustor = new zi0(i, i2, i3, i4);
    }

    public void setHelperFinder(@NonNull b bVar) {
        if (bVar != null) {
            LinkedList linkedList = new LinkedList();
            b bVar2 = this.mHelperFinder;
            if (bVar2 != null) {
                for (a aVar : bVar2.b()) {
                    linkedList.add(aVar);
                }
            }
            this.mHelperFinder = bVar;
            if (linkedList.size() > 0) {
                this.mHelperFinder.d(linkedList);
            }
            this.mSpaceMeasured = false;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("finder is null");
    }

    public void setLayoutHelpers(@Nullable List<a> list) {
        BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener;
        for (a aVar : this.mHelperFinder.b()) {
            this.oldHelpersSet.put(Integer.valueOf(System.identityHashCode(aVar)), aVar);
        }
        if (list != null) {
            int i = 0;
            for (a aVar2 : list) {
                if (aVar2 instanceof FixAreaLayoutHelper) {
                    ((FixAreaLayoutHelper) aVar2).a(this.mFixAreaAdjustor);
                }
                if ((aVar2 instanceof BaseLayoutHelper) && (layoutViewBindListener = this.mLayoutViewBindListener) != null) {
                    ((BaseLayoutHelper) aVar2).setLayoutViewBindListener(layoutViewBindListener);
                }
                if (aVar2.getItemCount() > 0) {
                    aVar2.setRange(i, (aVar2.getItemCount() + i) - 1);
                } else {
                    aVar2.setRange(-1, -1);
                }
                i += aVar2.getItemCount();
            }
        }
        this.mHelperFinder.d(list);
        for (a aVar3 : this.mHelperFinder.b()) {
            this.newHelpersSet.put(Integer.valueOf(System.identityHashCode(aVar3)), aVar3);
        }
        Iterator<Map.Entry<Integer, a>> it = this.oldHelpersSet.entrySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next().getKey();
            if (this.newHelpersSet.containsKey(key)) {
                this.newHelpersSet.remove(key);
                it.remove();
            }
        }
        for (a aVar4 : this.oldHelpersSet.values()) {
            aVar4.clear(this);
        }
        if (!this.oldHelpersSet.isEmpty() || !this.newHelpersSet.isEmpty()) {
            this.mSpaceMeasured = false;
        }
        this.oldHelpersSet.clear();
        this.newHelpersSet.clear();
        requestLayout();
    }

    public void setLayoutManagerCanScrollListener(LayoutManagerCanScrollListener layoutManagerCanScrollListener2) {
        this.layoutManagerCanScrollListener = layoutManagerCanScrollListener2;
    }

    public void setLayoutViewFactory(@NonNull LayoutViewFactory layoutViewFactory) {
        if (layoutViewFactory != null) {
            this.mLayoutViewFatory = layoutViewFactory;
            return;
        }
        throw new IllegalArgumentException("factory should not be null");
    }

    public void setNestedScrolling(boolean z) {
        setNestedScrolling(z, -1);
    }

    public void setNoScrolling(boolean z) {
        this.mNoScrolling = z;
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i) {
        this.mOrientationHelper = c.b(this, i);
        super.setOrientation(i);
    }

    public void setPerformanceMonitor(PerformanceMonitor performanceMonitor) {
        this.mPerformanceMonitor = performanceMonitor;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public /* bridge */ /* synthetic */ void setRecycleOffset(int i) {
        super.setRecycleOffset(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setReverseLayout(boolean z) {
        if (!z) {
            super.setReverseLayout(false);
            return;
        }
        throw new UnsupportedOperationException("VirtualLayoutManager does not support reverse layout in current version.");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("VirtualLayoutManager does not support stack from end.");
    }

    public void setViewLifeCycleListener(@NonNull ViewLifeCycleListener viewLifeCycleListener) {
        if (viewLifeCycleListener != null) {
            this.mViewLifeCycleHelper = new ViewLifeCycleHelper(this, viewLifeCycleListener);
            return;
        }
        throw new IllegalArgumentException("ViewLifeCycleListener should not be null!");
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void showView(View view) {
        super.showView(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        super.smoothScrollToPosition(recyclerView, state, i);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mCurrentPendingSavedState == null;
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALIDE_SIZE = Integer.MIN_VALUE;
        public float a = Float.NaN;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public VirtualLayoutManager(@NonNull Context context, int i) {
        this(context, i, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(d dVar, View view) {
        addChildView(dVar, view, dVar.e() == 1 ? -1 : 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int computeAlignOffset(int i, boolean z, boolean z2) {
        a a2;
        if (i == -1 || (a2 = this.mHelperFinder.a(i)) == null) {
            return 0;
        }
        return a2.computeAlignOffset(i - a2.getRange().d().intValue(), z, z2, this);
    }

    public int obtainExtraMargin(View view, boolean z, boolean z2) {
        if (view != null) {
            return computeAlignOffset(view, z, z2);
        }
        return 0;
    }

    public void setNestedScrolling(boolean z, int i) {
        this.mNestedScrolling = z;
        this.mSpaceMeasured = false;
        this.mSpaceMeasuring = false;
        this.mMeasuredFullSpace = 0;
    }

    public VirtualLayoutManager(@NonNull Context context, int i, boolean z) {
        super(context, i, z);
        int i2 = 0;
        this.mNoScrolling = false;
        this.mNestedScrolling = false;
        this.mEnableMarginOverlapping = false;
        this.mMaxMeasureSize = -1;
        this.mRangeComparator = new a(this);
        this.mFixAreaAdjustor = zi0.mDefaultAdjuster;
        this.newHelpersSet = new HashMap<>();
        this.oldHelpersSet = new HashMap<>();
        this.mTempAnchorInfoWrapper = new c();
        this.mNested = 0;
        this.mTempLayoutStateWrapper = new d();
        this.mRangeLengths = new ArrayList();
        this.mDefaultLayoutHelper = DEFAULT_LAYOUT_HELPER;
        this.mLayoutViewFatory = new b(this);
        this.mDecorInsets = new Rect();
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
        this.mOrientationHelper = c.b(this, i);
        this.mSecondaryOrientationHelper = c.b(this, i != 1 ? 1 : i2);
        this.mCanScrollVertically = super.canScrollVertically();
        this.mCanScrollHorizontally = super.canScrollHorizontally();
        setHelperFinder(new d());
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(d dVar, View view, int i) {
        showView(view);
        if (!dVar.i()) {
            addView(view, i);
        } else {
            addDisappearingView(view, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new InflateLayoutParams(context, attributeSet);
    }
}
