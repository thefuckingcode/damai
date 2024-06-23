package com.alibaba.android.vlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import tb.s61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ExposeLinearLayoutManagerEx extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    static final int FLAG_INVALID = 4;
    static final int FLAG_UPDATED = 2;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final String TAG = "ExposeLLManagerEx";
    public static final int VERTICAL = 1;
    private static Field vhField;
    private static Method vhSetFlags;
    private Object[] emptyArgs;
    private s61 layoutChunkResultCache;
    private final a mAnchorInfo;
    private final b mChildHelperWrapper;
    protected Bundle mCurrentPendingSavedState;
    private int mCurrentPendingScrollPosition;
    private final Method mEnsureLayoutStateMethod;
    private boolean mLastStackFromEnd;
    protected c mLayoutState;
    private c mOrientationHelper;
    private int mPendingScrollPositionOffset;
    private RecyclerView mRecyclerView;
    private boolean mShouldReverseLayoutExpose;
    protected int recycleOffset;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class a {
        public int a;
        public int b;
        public boolean c;

        protected a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i;
            if (this.c) {
                i = ExposeLinearLayoutManagerEx.this.mOrientationHelper.i();
            } else {
                i = ExposeLinearLayoutManagerEx.this.mOrientationHelper.k();
            }
            this.b = i;
        }

        public void b(View view) {
            if (this.c) {
                this.b = ExposeLinearLayoutManagerEx.this.mOrientationHelper.d(view) + ExposeLinearLayoutManagerEx.this.computeAlignOffset(view, this.c, true) + ExposeLinearLayoutManagerEx.this.mOrientationHelper.m();
            } else {
                this.b = ExposeLinearLayoutManagerEx.this.mOrientationHelper.g(view) + ExposeLinearLayoutManagerEx.this.computeAlignOffset(view, this.c, true);
            }
            this.a = ExposeLinearLayoutManagerEx.this.getPosition(view);
        }

        public boolean c(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.isItemRemoved() || layoutParams.getViewPosition() < 0 || layoutParams.getViewPosition() >= state.getItemCount()) {
                return false;
            }
            b(view);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        private Object a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;
        private Field f;
        private Object g;
        private Method h;
        private Field i;
        private List j;
        private RecyclerView.LayoutManager k;
        private Object[] l = new Object[1];

        b(RecyclerView.LayoutManager layoutManager) {
            this.k = layoutManager;
            try {
                Field declaredField = RecyclerView.LayoutManager.class.getDeclaredField("mChildHelper");
                this.i = declaredField;
                declaredField.setAccessible(true);
                a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                if (this.a == null) {
                    Object obj = this.i.get(this.k);
                    this.a = obj;
                    if (obj != null) {
                        Class<?> cls = obj.getClass();
                        Method declaredMethod = cls.getDeclaredMethod("hide", View.class);
                        this.b = declaredMethod;
                        declaredMethod.setAccessible(true);
                        try {
                            Class<?> cls2 = Integer.TYPE;
                            Method declaredMethod2 = cls.getDeclaredMethod("findHiddenNonRemovedView", cls2, cls2);
                            this.c = declaredMethod2;
                            declaredMethod2.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                            Method declaredMethod3 = cls.getDeclaredMethod("findHiddenNonRemovedView", Integer.TYPE);
                            this.d = declaredMethod3;
                            declaredMethod3.setAccessible(true);
                        }
                        Method declaredMethod4 = cls.getDeclaredMethod("isHidden", View.class);
                        this.e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                        Field declaredField = cls.getDeclaredField("mBucket");
                        declaredField.setAccessible(true);
                        Object obj2 = declaredField.get(this.a);
                        this.g = obj2;
                        Method declaredMethod5 = obj2.getClass().getDeclaredMethod(Constants.TAG_CLEAR_STRING, Integer.TYPE);
                        this.h = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                        Field declaredField2 = cls.getDeclaredField("mHiddenViews");
                        this.f = declaredField2;
                        declaredField2.setAccessible(true);
                        this.j = (List) this.f.get(this.a);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public View b(int i2, int i3) {
            try {
                a();
                Method method = this.c;
                if (method != null) {
                    return (View) method.invoke(this.a, Integer.valueOf(i2), -1);
                }
                Method method2 = this.d;
                if (method2 == null) {
                    return null;
                }
                return (View) method2.invoke(this.a, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            try {
                a();
                if (this.j.indexOf(view) < 0) {
                    Object[] objArr = this.l;
                    objArr[0] = view;
                    this.b.invoke(this.a, objArr);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view) {
            try {
                a();
                Object[] objArr = this.l;
                objArr[0] = view;
                return ((Boolean) this.e.invoke(this.a, objArr)).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(View view) {
            try {
                a();
                this.l[0] = Integer.valueOf(ExposeLinearLayoutManagerEx.this.mRecyclerView.indexOfChild(view));
                this.h.invoke(this.g, this.l);
                List list = this.j;
                if (list != null) {
                    list.remove(view);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public static class c {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "_ExposeLLayoutManager#LayoutState";
        public int mAvailable;
        public int mCurrentPosition;
        public int mExtra = 0;
        public int mFixOffset = 0;
        public boolean mIsPreLayout = false;
        public int mItemDirection;
        public int mLayoutDirection;
        public int mOffset;
        public boolean mOnRefresLayout = false;
        public boolean mRecycle = true;
        public List<RecyclerView.ViewHolder> mScrapList = null;
        public int mScrollingOffset;
        private Method vhIsRemoved = null;

        public c() {
            try {
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);
                this.vhIsRemoved = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @SuppressLint({"LongLogTag"})
        private View nextFromLimitedList() {
            boolean z;
            int size = this.mScrapList.size();
            int i = Integer.MAX_VALUE;
            RecyclerView.ViewHolder viewHolder = null;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.ViewHolder viewHolder2 = this.mScrapList.get(i2);
                if (!this.mIsPreLayout) {
                    try {
                        z = ((Boolean) this.vhIsRemoved.invoke(viewHolder2, new Object[0])).booleanValue();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                    if (!this.mIsPreLayout && z) {
                    }
                }
                int position = (viewHolder2.getPosition() - this.mCurrentPosition) * this.mItemDirection;
                if (position >= 0 && position < i) {
                    viewHolder = viewHolder2;
                    if (position == 0) {
                        break;
                    }
                    i = position;
                }
            }
            if (viewHolder == null) {
                return null;
            }
            this.mCurrentPosition = viewHolder.getPosition() + this.mItemDirection;
            return viewHolder.itemView;
            z = false;
        }

        public boolean hasMore(RecyclerView.State state) {
            int i = this.mCurrentPosition;
            return i >= 0 && i < state.getItemCount();
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"LongLogTag"})
        public void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextFromLimitedList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d {
        private static Method b;
        private static Method c;
        private static Method d;
        private static Method e;
        private static Method f;
        private RecyclerView.ViewHolder a;

        static {
            try {
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("shouldIgnore", new Class[0]);
                b = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = RecyclerView.ViewHolder.class.getDeclaredMethod("isInvalid", new Class[0]);
                c = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);
                d = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Class cls = Integer.TYPE;
                Method declaredMethod4 = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", cls, cls);
                f = declaredMethod4;
                declaredMethod4.setAccessible(true);
                try {
                    e = RecyclerView.ViewHolder.class.getDeclaredMethod("isChanged", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    e = RecyclerView.ViewHolder.class.getDeclaredMethod("isUpdated", new Class[0]);
                }
                e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        public d(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        public static void e(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            try {
                f.invoke(viewHolder, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            Method method = e;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            Method method = c;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            Method method = d;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        public boolean d() {
            return b() || c() || a();
        }
    }

    public ExposeLinearLayoutManagerEx(Context context) {
        this(context, 1, false);
    }

    protected static void attachViewHolder(RecyclerView.LayoutParams layoutParams, RecyclerView.ViewHolder viewHolder) {
        try {
            if (vhField == null) {
                vhField = RecyclerView.LayoutParams.class.getDeclaredField("mViewHolder");
            }
            vhField.setAccessible(true);
            vhField.set(layoutParams, viewHolder);
            if (vhSetFlags == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", cls, cls);
                vhSetFlags = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            vhSetFlags.invoke(viewHolder, 4, 4);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    private int convertFocusDirectionToLayoutDirectionExpose(int i) {
        int orientation = getOrientation();
        if (i == 1) {
            return -1;
        }
        if (i != 2) {
            return i != 17 ? i != 33 ? i != 66 ? (i == 130 && orientation == 1) ? 1 : Integer.MIN_VALUE : orientation == 0 ? 1 : Integer.MIN_VALUE : orientation == 1 ? -1 : Integer.MIN_VALUE : orientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        return 1;
    }

    private View findReferenceChildInternal(int i, int i2, int i3) {
        ensureLayoutStateExpose();
        int k = this.mOrientationHelper.k();
        int i4 = this.mOrientationHelper.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.g(childAt) < i4 && this.mOrientationHelper.d(childAt) >= k) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    private int fixLayoutEndGapExpose(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int i3 = this.mOrientationHelper.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -scrollInternalBy(-i3, recycler, state);
        int i5 = i + i4;
        if (!z || (i2 = this.mOrientationHelper.i() - i5) <= 0) {
            return i4;
        }
        this.mOrientationHelper.n(i2);
        return i2 + i4;
    }

    private int fixLayoutStartGapExpose(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int k;
        int k2 = i - this.mOrientationHelper.k();
        if (k2 <= 0) {
            return 0;
        }
        int i2 = -scrollInternalBy(k2, recycler, state);
        int i3 = i + i2;
        if (!z || (k = i3 - this.mOrientationHelper.k()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.n(-k);
        return i2 - k;
    }

    private View getChildClosestToEndExpose() {
        return getChildAt(this.mShouldReverseLayoutExpose ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStartExpose() {
        return getChildAt(this.mShouldReverseLayoutExpose ? getChildCount() - 1 : 0);
    }

    protected static boolean isViewHolderUpdated(RecyclerView.ViewHolder viewHolder) {
        return new d(viewHolder).d();
    }

    private void layoutForPredictiveAnimationsExpose(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int i3;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                i3 = -1;
                char c2 = 1;
                if (i4 >= size) {
                    break;
                }
                RecyclerView.ViewHolder viewHolder = scrapList.get(i4);
                if ((viewHolder.getPosition() < position) != this.mShouldReverseLayoutExpose) {
                    c2 = 65535;
                }
                if (c2 == 65535) {
                    i5 += this.mOrientationHelper.e(viewHolder.itemView);
                } else {
                    i6 += this.mOrientationHelper.e(viewHolder.itemView);
                }
                i4++;
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i5 > 0) {
                updateLayoutStateToFillStartExpose(getPosition(getChildClosestToStartExpose()), i);
                c cVar = this.mLayoutState;
                cVar.mExtra = i5;
                cVar.mAvailable = 0;
                cVar.mCurrentPosition += this.mShouldReverseLayoutExpose ? 1 : -1;
                cVar.mOnRefresLayout = true;
                fill(recycler, cVar, state, false);
            }
            if (i6 > 0) {
                updateLayoutStateToFillEndExpose(getPosition(getChildClosestToEndExpose()), i2);
                c cVar2 = this.mLayoutState;
                cVar2.mExtra = i6;
                cVar2.mAvailable = 0;
                int i7 = cVar2.mCurrentPosition;
                if (!this.mShouldReverseLayoutExpose) {
                    i3 = 1;
                }
                cVar2.mCurrentPosition = i7 + i3;
                cVar2.mOnRefresLayout = true;
                fill(recycler, cVar2, state, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private View myFindFirstReferenceChild(int i) {
        return findReferenceChildInternal(0, getChildCount(), i);
    }

    private View myFindLastReferenceChild(int i) {
        return findReferenceChildInternal(getChildCount() - 1, -1, i);
    }

    private View myFindReferenceChildClosestToEnd(RecyclerView.State state) {
        boolean z = this.mShouldReverseLayoutExpose;
        int itemCount = state.getItemCount();
        return z ? myFindFirstReferenceChild(itemCount) : myFindLastReferenceChild(itemCount);
    }

    private View myFindReferenceChildClosestToStart(RecyclerView.State state) {
        boolean z = this.mShouldReverseLayoutExpose;
        int itemCount = state.getItemCount();
        return z ? myFindLastReferenceChild(itemCount) : myFindFirstReferenceChild(itemCount);
    }

    private void myResolveShouldLayoutReverse() {
        if (getOrientation() == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayoutExpose = getReverseLayout();
        } else {
            this.mShouldReverseLayoutExpose = !getReverseLayout();
        }
    }

    private void recycleByLayoutStateExpose(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.mRecycle) {
            if (cVar.mLayoutDirection == -1) {
                recycleViewsFromEndExpose(recycler, cVar.mScrollingOffset);
            } else {
                recycleViewsFromStartExpose(recycler, cVar.mScrollingOffset);
            }
        }
    }

    private void recycleViewsFromEndExpose(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int h = this.mOrientationHelper.h() - i;
            if (this.mShouldReverseLayoutExpose) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (this.mOrientationHelper.g(getChildAt(i2)) - this.recycleOffset < h) {
                        recycleChildren(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = childCount - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                if (this.mOrientationHelper.g(getChildAt(i4)) - this.recycleOffset < h) {
                    recycleChildren(recycler, i3, i4);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStartExpose(RecyclerView.Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.mShouldReverseLayoutExpose) {
                int i2 = childCount - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    if (this.mOrientationHelper.d(getChildAt(i3)) + this.recycleOffset > i) {
                        recycleChildren(recycler, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                if (this.mOrientationHelper.d(getChildAt(i4)) + this.recycleOffset > i) {
                    recycleChildren(recycler, 0, i4);
                    return;
                }
            }
        }
    }

    private boolean updateAnchorFromChildrenExpose(RecyclerView.State state, a aVar) {
        View view;
        int i;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.c(focusedChild, state)) {
            return true;
        }
        if (this.mLastStackFromEnd != getStackFromEnd()) {
            return false;
        }
        if (aVar.c) {
            view = myFindReferenceChildClosestToEnd(state);
        } else {
            view = myFindReferenceChildClosestToStart(state);
        }
        if (view == null) {
            return false;
        }
        aVar.b(view);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.g(view) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(view) < this.mOrientationHelper.k()) {
                z = true;
            }
            if (z) {
                if (aVar.c) {
                    i = this.mOrientationHelper.i();
                } else {
                    i = this.mOrientationHelper.k();
                }
                aVar.b = i;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingDataExpose(RecyclerView.State state, a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (!state.isPreLayout() && (i = this.mCurrentPendingScrollPosition) != -1) {
            if (i < 0 || i >= state.getItemCount()) {
                this.mCurrentPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.a = this.mCurrentPendingScrollPosition;
                Bundle bundle = this.mCurrentPendingSavedState;
                if (bundle != null && bundle.getInt("AnchorPosition") >= 0) {
                    boolean z2 = this.mCurrentPendingSavedState.getBoolean("AnchorLayoutFromEnd");
                    aVar.c = z2;
                    if (z2) {
                        aVar.b = this.mOrientationHelper.i() - this.mCurrentPendingSavedState.getInt("AnchorOffset");
                    } else {
                        aVar.b = this.mOrientationHelper.k() + this.mCurrentPendingSavedState.getInt("AnchorOffset");
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mCurrentPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mCurrentPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayoutExpose) {
                                z = true;
                            }
                            aVar.c = z;
                        }
                        aVar.a();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.l()) {
                        aVar.a();
                        return true;
                    } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.k() < 0) {
                        aVar.b = this.mOrientationHelper.k();
                        aVar.c = false;
                        return true;
                    } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.b = this.mOrientationHelper.i();
                        aVar.c = true;
                        return true;
                    } else {
                        if (aVar.c) {
                            i2 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.m();
                        } else {
                            i2 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        aVar.b = i2;
                    }
                    return true;
                } else {
                    boolean z3 = this.mShouldReverseLayoutExpose;
                    aVar.c = z3;
                    if (z3) {
                        aVar.b = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.b = this.mOrientationHelper.k() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayoutExpose(RecyclerView.State state, a aVar) {
        if (!updateAnchorFromPendingDataExpose(state, aVar) && !updateAnchorFromChildrenExpose(state, aVar)) {
            aVar.a();
            aVar.a = getStackFromEnd() ? state.getItemCount() - 1 : 0;
        }
    }

    private void updateLayoutStateToFillEndExpose(a aVar) {
        updateLayoutStateToFillEndExpose(aVar.a, aVar.b);
    }

    private void updateLayoutStateToFillStartExpose(a aVar) {
        updateLayoutStateToFillStartExpose(aVar.a, aVar.b);
    }

    private void validateChildOrderExpose() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int g = this.mOrientationHelper.g(getChildAt(0));
            if (this.mShouldReverseLayoutExpose) {
                for (int i = 1; i < getChildCount(); i++) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int g2 = this.mOrientationHelper.g(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (g2 >= g) {
                            z = false;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (g2 > g) {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int g3 = this.mOrientationHelper.g(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (g3 >= g) {
                        z = false;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (g3 < g) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addHiddenView(View view, boolean z) {
        addView(view, z ? 0 : -1);
        this.mChildHelperWrapper.c(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mCurrentPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: protected */
    public int computeAlignOffset(int i, boolean z, boolean z2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeAlignOffset(View view, boolean z, boolean z2) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider, androidx.recyclerview.widget.LinearLayoutManager
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayoutExpose) {
            i2 = -1;
        }
        if (getOrientation() == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    /* access modifiers changed from: protected */
    public void ensureLayoutStateExpose() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new c();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = c.b(this, getOrientation());
        }
        try {
            this.mEnsureLayoutStateMethod.invoke(this, this.emptyArgs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public int fill(RecyclerView.Recycler recycler, c cVar, RecyclerView.State state, boolean z) {
        int i = cVar.mAvailable;
        int i2 = cVar.mScrollingOffset;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.mScrollingOffset = i2 + i;
            }
            recycleByLayoutStateExpose(recycler, cVar);
        }
        int i3 = cVar.mAvailable + cVar.mExtra + this.recycleOffset;
        while (i3 > 0 && cVar.hasMore(state)) {
            this.layoutChunkResultCache.a();
            layoutChunk(recycler, state, cVar, this.layoutChunkResultCache);
            s61 s61 = this.layoutChunkResultCache;
            if (!s61.b) {
                cVar.mOffset += s61.a * cVar.mLayoutDirection;
                if (!s61.c || this.mLayoutState.mScrapList != null || !state.isPreLayout()) {
                    int i4 = cVar.mAvailable;
                    int i5 = this.layoutChunkResultCache.a;
                    cVar.mAvailable = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.mScrollingOffset;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + this.layoutChunkResultCache.a;
                    cVar.mScrollingOffset = i7;
                    int i8 = cVar.mAvailable;
                    if (i8 < 0) {
                        cVar.mScrollingOffset = i7 + i8;
                    }
                    recycleByLayoutStateExpose(recycler, cVar);
                }
                if (z && this.layoutChunkResultCache.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.mAvailable;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findFirstVisibleItemPosition() {
        ensureLayoutStateExpose();
        return super.findFirstVisibleItemPosition();
    }

    /* access modifiers changed from: protected */
    public View findHiddenView(int i) {
        return this.mChildHelperWrapper.b(i, -1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastVisibleItemPosition() {
        ensureLayoutStateExpose();
        try {
            return super.findLastVisibleItemPosition();
        } catch (Exception e) {
            Log.d("LastItem", "itemCount: " + getItemCount());
            Log.d("LastItem", "childCount: " + getChildCount());
            Log.d("LastItem", "child: " + getChildAt(getChildCount() + -1));
            Log.d("LastItem", "RV childCount: " + this.mRecyclerView.getChildCount());
            Log.d("LastItem", "RV child: " + this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + -1));
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public void hideView(View view) {
        this.mChildHelperWrapper.c(view);
    }

    public boolean isEnableMarginOverLap() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isHidden(View view) {
        return this.mChildHelperWrapper.d(view);
    }

    /* access modifiers changed from: protected */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar, s61 s61) {
        int i;
        int i2;
        int i3;
        int i4;
        View next = cVar.next(recycler);
        if (next == null) {
            s61.b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (cVar.mScrapList == null) {
            if (this.mShouldReverseLayoutExpose == (cVar.mLayoutDirection == -1)) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            if (this.mShouldReverseLayoutExpose == (cVar.mLayoutDirection == -1)) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        s61.a = this.mOrientationHelper.e(next);
        if (getOrientation() == 1) {
            if (isLayoutRTL()) {
                i4 = getWidth() - getPaddingRight();
                i2 = i4 - this.mOrientationHelper.f(next);
            } else {
                i2 = getPaddingLeft();
                i4 = this.mOrientationHelper.f(next) + i2;
            }
            if (cVar.mLayoutDirection == -1) {
                i = cVar.mOffset;
                i3 = i - s61.a;
            } else {
                i3 = cVar.mOffset;
                i = s61.a + i3;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f = this.mOrientationHelper.f(next) + paddingTop;
            if (cVar.mLayoutDirection == -1) {
                int i5 = cVar.mOffset;
                int i6 = i5 - s61.a;
                i4 = i5;
                i = f;
                i2 = i6;
                i3 = paddingTop;
            } else {
                int i7 = cVar.mOffset;
                int i8 = s61.a + i7;
                i2 = i7;
                i = f;
                i3 = paddingTop;
                i4 = i8;
            }
        }
        layoutDecorated(next, i2 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i3, i4 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            s61.c = true;
        }
        s61.d = next.isFocusable();
    }

    public void onAnchorReady(RecyclerView.State state, a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.mRecyclerView = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirectionExpose;
        View view2;
        View view3;
        myResolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirectionExpose = convertFocusDirectionToLayoutDirectionExpose(i)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirectionExpose == -1) {
            view2 = myFindReferenceChildClosestToStart(state);
        } else {
            view2 = myFindReferenceChildClosestToEnd(state);
        }
        if (view2 == null) {
            return null;
        }
        ensureLayoutStateExpose();
        updateLayoutStateExpose(convertFocusDirectionToLayoutDirectionExpose, (int) (((float) this.mOrientationHelper.l()) * MAX_SCROLL_FACTOR), false, state);
        c cVar = this.mLayoutState;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
        cVar.mRecycle = false;
        cVar.mOnRefresLayout = false;
        fill(recycler, cVar, state, true);
        if (convertFocusDirectionToLayoutDirectionExpose == -1) {
            view3 = getChildClosestToStartExpose();
        } else {
            view3 = getChildClosestToEndExpose();
        }
        if (view3 == view2 || !view3.isFocusable()) {
            return null;
        }
        return view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View findViewByPosition;
        int i8;
        int i9;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null && bundle.getInt("AnchorPosition") >= 0) {
            this.mCurrentPendingScrollPosition = this.mCurrentPendingSavedState.getInt("AnchorPosition");
        }
        ensureLayoutStateExpose();
        this.mLayoutState.mRecycle = false;
        myResolveShouldLayoutReverse();
        this.mAnchorInfo.d();
        this.mAnchorInfo.c = this.mShouldReverseLayoutExpose ^ getStackFromEnd();
        updateAnchorInfoForLayoutExpose(state, this.mAnchorInfo);
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if ((state.getTargetScrollPosition() < this.mAnchorInfo.a) == this.mShouldReverseLayoutExpose) {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i = 0;
        }
        int k = extraLayoutSpace + this.mOrientationHelper.k();
        int j = i + this.mOrientationHelper.j();
        if (!(!state.isPreLayout() || (i7 = this.mCurrentPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i7)) == null)) {
            if (this.mShouldReverseLayoutExpose) {
                i8 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                i9 = this.mPendingScrollPositionOffset;
            } else {
                i9 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.k();
                i8 = this.mPendingScrollPositionOffset;
            }
            int i10 = i8 - i9;
            if (i10 > 0) {
                k += i10;
            } else {
                j -= i10;
            }
        }
        onAnchorReady(state, this.mAnchorInfo);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mOnRefresLayout = true;
        a aVar = this.mAnchorInfo;
        if (aVar.c) {
            updateLayoutStateToFillStartExpose(aVar);
            c cVar = this.mLayoutState;
            cVar.mExtra = k;
            fill(recycler, cVar, state, false);
            c cVar2 = this.mLayoutState;
            i2 = cVar2.mOffset;
            int i11 = cVar2.mAvailable;
            if (i11 > 0) {
                j += i11;
            }
            updateLayoutStateToFillEndExpose(this.mAnchorInfo);
            c cVar3 = this.mLayoutState;
            cVar3.mExtra = j;
            cVar3.mCurrentPosition += cVar3.mItemDirection;
            fill(recycler, cVar3, state, false);
            i3 = this.mLayoutState.mOffset;
        } else {
            updateLayoutStateToFillEndExpose(aVar);
            c cVar4 = this.mLayoutState;
            cVar4.mExtra = j;
            fill(recycler, cVar4, state, false);
            c cVar5 = this.mLayoutState;
            int i12 = cVar5.mOffset;
            int i13 = cVar5.mAvailable;
            if (i13 > 0) {
                k += i13;
            }
            updateLayoutStateToFillStartExpose(this.mAnchorInfo);
            c cVar6 = this.mLayoutState;
            cVar6.mExtra = k;
            cVar6.mCurrentPosition += cVar6.mItemDirection;
            fill(recycler, cVar6, state, false);
            i2 = this.mLayoutState.mOffset;
            i3 = i12;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayoutExpose ^ getStackFromEnd()) {
                int fixLayoutEndGapExpose = fixLayoutEndGapExpose(i3, recycler, state, true);
                i4 = i2 + fixLayoutEndGapExpose;
                i6 = i3 + fixLayoutEndGapExpose;
                i5 = fixLayoutStartGapExpose(i4, recycler, state, false);
            } else {
                int fixLayoutStartGapExpose = fixLayoutStartGapExpose(i2, recycler, state, true);
                i4 = i2 + fixLayoutStartGapExpose;
                i6 = i3 + fixLayoutStartGapExpose;
                i5 = fixLayoutEndGapExpose(i6, recycler, state, false);
            }
            i2 = i4 + i5;
            i3 = i6 + i5;
        }
        layoutForPredictiveAnimationsExpose(recycler, state, i2, i3);
        if (!state.isPreLayout()) {
            this.mCurrentPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mOrientationHelper.o();
        }
        this.mLastStackFromEnd = getStackFromEnd();
        this.mCurrentPendingSavedState = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            this.mCurrentPendingSavedState = (Bundle) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mCurrentPendingSavedState != null) {
            return new Bundle(this.mCurrentPendingSavedState);
        }
        Bundle bundle = new Bundle();
        if (getChildCount() > 0) {
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayoutExpose;
            bundle.putBoolean("AnchorLayoutFromEnd", z);
            if (z) {
                View childClosestToEndExpose = getChildClosestToEndExpose();
                bundle.putInt("AnchorOffset", this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEndExpose));
                bundle.putInt("AnchorPosition", getPosition(childClosestToEndExpose));
            } else {
                View childClosestToStartExpose = getChildClosestToStartExpose();
                bundle.putInt("AnchorPosition", getPosition(childClosestToStartExpose));
                bundle.putInt("AnchorOffset", this.mOrientationHelper.g(childClosestToStartExpose) - this.mOrientationHelper.k());
            }
        } else {
            bundle.putInt("AnchorPosition", -1);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() == 1) {
            return 0;
        }
        return scrollInternalBy(i, recycler, state);
    }

    /* access modifiers changed from: protected */
    public int scrollInternalBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.mLayoutState.mRecycle = true;
        ensureLayoutStateExpose();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutStateExpose(i2, abs, true, state);
        c cVar = this.mLayoutState;
        int i3 = cVar.mScrollingOffset;
        cVar.mOnRefresLayout = false;
        int fill = i3 + fill(recycler, cVar, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.n(-i);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPosition(int i) {
        this.mCurrentPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null) {
            bundle.putInt("AnchorPosition", -1);
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i, int i2) {
        this.mCurrentPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null) {
            bundle.putInt("AnchorPosition", -1);
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() == 0) {
            return 0;
        }
        return scrollInternalBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i) {
        super.setOrientation(i);
        this.mOrientationHelper = null;
    }

    public void setRecycleOffset(int i) {
        this.recycleOffset = i;
    }

    /* access modifiers changed from: protected */
    public void showView(View view) {
        this.mChildHelperWrapper.e(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mCurrentPendingSavedState == null && this.mLastStackFromEnd == getStackFromEnd();
    }

    /* access modifiers changed from: protected */
    public void updateLayoutStateExpose(int i, int i2, boolean z, RecyclerView.State state) {
        int i3;
        this.mLayoutState.mExtra = getExtraLayoutSpace(state);
        c cVar = this.mLayoutState;
        cVar.mLayoutDirection = i;
        int i4 = -1;
        if (i == 1) {
            cVar.mExtra += this.mOrientationHelper.j();
            View childClosestToEndExpose = getChildClosestToEndExpose();
            c cVar2 = this.mLayoutState;
            if (!this.mShouldReverseLayoutExpose) {
                i4 = 1;
            }
            cVar2.mItemDirection = i4;
            int position = getPosition(childClosestToEndExpose);
            c cVar3 = this.mLayoutState;
            cVar2.mCurrentPosition = position + cVar3.mItemDirection;
            cVar3.mOffset = this.mOrientationHelper.d(childClosestToEndExpose) + computeAlignOffset(childClosestToEndExpose, true, false);
            i3 = this.mLayoutState.mOffset - this.mOrientationHelper.i();
        } else {
            View childClosestToStartExpose = getChildClosestToStartExpose();
            this.mLayoutState.mExtra += this.mOrientationHelper.k();
            c cVar4 = this.mLayoutState;
            if (this.mShouldReverseLayoutExpose) {
                i4 = 1;
            }
            cVar4.mItemDirection = i4;
            int position2 = getPosition(childClosestToStartExpose);
            c cVar5 = this.mLayoutState;
            cVar4.mCurrentPosition = position2 + cVar5.mItemDirection;
            cVar5.mOffset = this.mOrientationHelper.g(childClosestToStartExpose) + computeAlignOffset(childClosestToStartExpose, false, false);
            i3 = (-this.mLayoutState.mOffset) + this.mOrientationHelper.k();
        }
        c cVar6 = this.mLayoutState;
        cVar6.mAvailable = i2;
        if (z) {
            cVar6.mAvailable = i2 - i3;
        }
        cVar6.mScrollingOffset = i3;
    }

    public ExposeLinearLayoutManagerEx(Context context, int i, boolean z) {
        super(context, i, z);
        this.mShouldReverseLayoutExpose = false;
        this.mCurrentPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mCurrentPendingSavedState = null;
        this.emptyArgs = new Object[0];
        this.layoutChunkResultCache = new s61();
        this.mAnchorInfo = new a();
        setOrientation(i);
        setReverseLayout(z);
        this.mChildHelperWrapper = new b(this);
        try {
            Method declaredMethod = LinearLayoutManager.class.getDeclaredMethod("ensureLayoutState", new Class[0]);
            this.mEnsureLayoutStateMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            try {
                Method declaredMethod2 = RecyclerView.LayoutManager.class.getDeclaredMethod("setItemPrefetchEnabled", Boolean.TYPE);
                if (declaredMethod2 != null) {
                    declaredMethod2.invoke(this, Boolean.FALSE);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void updateLayoutStateToFillEndExpose(int i, int i2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.i() - i2;
        c cVar = this.mLayoutState;
        cVar.mItemDirection = this.mShouldReverseLayoutExpose ? -1 : 1;
        cVar.mCurrentPosition = i;
        cVar.mLayoutDirection = 1;
        cVar.mOffset = i2;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStartExpose(int i, int i2) {
        this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.k();
        c cVar = this.mLayoutState;
        cVar.mCurrentPosition = i;
        cVar.mItemDirection = this.mShouldReverseLayoutExpose ? 1 : -1;
        cVar.mLayoutDirection = -1;
        cVar.mOffset = i2;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
    }
}
