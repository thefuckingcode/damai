package com.youku.arch.v3.recyclerview.layouthelper;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.c;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Arrays;
import tb.s61;

/* compiled from: Taobao */
public class GridFixAutoStatLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean DEBUG = false;
    private static final int MAIN_DIR_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
    private static final String TAG = "GridLayoutHelper";
    float mAspectRatio;
    private int mHGap;
    private boolean mHGapDirty;
    private boolean mIgnoreExtra;
    private boolean mIsAutoExpand;
    private boolean mLayoutWithAnchor;
    private int mOrigHGap;
    private int mRawSpanCount;
    private View[] mSet;
    private int mSizePerSpan;
    private int[] mSpanCols;
    private int mSpanCount;
    private int[] mSpanIndices;
    @NonNull
    private SpanSizeLookup mSpanSizeLookup;
    private int mTotalSize;
    private int mVGap;
    private float[] mWeights;
    private int mWidthForHGap;

    /* compiled from: Taobao */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        private static transient /* synthetic */ IpChange $ipChange;

        DefaultSpanSizeLookup() {
        }

        @Override // com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1294789681")) {
                return (i - this.mStartPosition) % i2;
            }
            return ((Integer) ipChange.ipc$dispatch("1294789681", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }

        @Override // com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.SpanSizeLookup
        public int getSpanSize(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-467714147")) {
                return 1;
            }
            return ((Integer) ipChange.ipc$dispatch("-467714147", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static abstract class SpanSizeLookup {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        int mStartPosition = 0;

        /* access modifiers changed from: package-private */
        public int findReferenceIndexFromCache(int i) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-747274063")) {
                return ((Integer) ipChange.ipc$dispatch("-747274063", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int size = this.mSpanIndexCache.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.mSpanIndexCache.size()) {
                return -1;
            }
            return this.mSpanIndexCache.keyAt(i4);
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1926208816")) {
                return ((Integer) ipChange.ipc$dispatch("1926208816", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            } else if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            } else {
                int i3 = this.mSpanIndexCache.get(i, -1);
                if (i3 != -1) {
                    return i3;
                }
                int spanIndex = getSpanIndex(i, i2);
                this.mSpanIndexCache.put(i, spanIndex);
                return spanIndex;
            }
        }

        public int getSpanGroupIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-79536419")) {
                return ((Integer) ipChange.ipc$dispatch("-79536419", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            }
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = spanSize2;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }

        public int getSpanIndex(int i, int i2) {
            int i3;
            int findReferenceIndexFromCache;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1618048494")) {
                return ((Integer) ipChange.ipc$dispatch("1618048494", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            }
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            int i4 = this.mStartPosition;
            if (!this.mCacheSpanIndices || this.mSpanIndexCache.size() <= 0 || (findReferenceIndexFromCache = findReferenceIndexFromCache(i)) < 0) {
                i3 = 0;
            } else {
                int i5 = findReferenceIndexFromCache + 1;
                i3 = this.mSpanIndexCache.get(findReferenceIndexFromCache) + getSpanSize(findReferenceIndexFromCache);
                i4 = i5;
            }
            while (i4 < i) {
                int spanSize2 = getSpanSize(i4);
                i3 += spanSize2;
                if (i3 == i2) {
                    i3 = 0;
                } else if (i3 > i2) {
                    i3 = spanSize2;
                }
                i4++;
            }
            if (spanSize + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        public abstract int getSpanSize(int i);

        public int getStartPosition() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1968088683")) {
                return this.mStartPosition;
            }
            return ((Integer) ipChange.ipc$dispatch("1968088683", new Object[]{this})).intValue();
        }

        public void invalidateSpanIndexCache() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-387884136")) {
                ipChange.ipc$dispatch("-387884136", new Object[]{this});
                return;
            }
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1015012828")) {
                return this.mCacheSpanIndices;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1015012828", new Object[]{this})).booleanValue();
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "145740")) {
                ipChange.ipc$dispatch("145740", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.mCacheSpanIndices = z;
        }

        public void setStartPosition(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "270313471")) {
                ipChange.ipc$dispatch("270313471", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.mStartPosition = i;
        }
    }

    public GridFixAutoStatLayoutHelper() {
        this(1, -1, -1);
    }

    private void adjustHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348503122")) {
            ipChange.ipc$dispatch("348503122", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mHGapDirty || this.mWidthForHGap != i) {
            this.mWidthForHGap = i;
            int i2 = this.mSpanCount;
            if (i2 == 2) {
                int i3 = this.mOrigHGap;
                if (((i - i3) & 1) != 0) {
                    this.mHGap = i3 - 1;
                } else {
                    this.mHGap = i3;
                }
            } else if (i2 != 3) {
                this.mHGap = this.mOrigHGap;
            } else {
                int i4 = this.mOrigHGap;
                int i5 = (i - (i4 << 1)) % 3;
                if (i5 == 1) {
                    this.mHGap = i4 - 1;
                } else if (i5 == 2) {
                    this.mHGap = i4 + 1;
                } else {
                    this.mHGap = i4;
                }
            }
            this.mHGapDirty = false;
        }
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        int i7 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1804600450")) {
            ipChange.ipc$dispatch("-1804600450", new Object[]{this, recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), layoutManagerHelper});
            return;
        }
        if (z) {
            i3 = i;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
            i5 = -1;
        }
        if (layoutManagerHelper.getOrientation() != 1 || !layoutManagerHelper.isDoLayoutRTL()) {
            i6 = 1;
        } else {
            i7 = i2 - 1;
            i6 = -1;
        }
        while (i4 != i3) {
            int spanSize = getSpanSize(recycler, state, layoutManagerHelper.getPosition(this.mSet[i4]));
            if (i6 != -1 || spanSize <= 1) {
                this.mSpanIndices[i4] = i7;
            } else {
                this.mSpanIndices[i4] = i7 - (spanSize - 1);
            }
            i7 += spanSize * i6;
            i4 += i5;
        }
    }

    private void ensureSpanCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711546997")) {
            ipChange.ipc$dispatch("711546997", new Object[]{this});
            return;
        }
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
        int[] iArr = this.mSpanIndices;
        if (iArr == null || iArr.length != this.mSpanCount) {
            this.mSpanIndices = new int[this.mSpanCount];
        }
        int[] iArr2 = this.mSpanCols;
        if (iArr2 == null || iArr2.length != this.mSpanCount) {
            this.mSpanCols = new int[this.mSpanCount];
        }
    }

    private int getMainDirSpec(int i, int i2, int i3, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137986427")) {
            return ((Integer) ipChange.ipc$dispatch("-137986427", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})).intValue();
        } else if (!Float.isNaN(f) && f > 0.0f && i3 > 0) {
            return View.MeasureSpec.makeMeasureSpec((int) ((((float) i3) / f) + 0.5f), 1073741824);
        } else {
            if (!Float.isNaN(this.mAspectRatio)) {
                float f2 = this.mAspectRatio;
                if (f2 > 0.0f) {
                    return View.MeasureSpec.makeMeasureSpec((int) ((((float) i2) / f2) + 0.5f), 1073741824);
                }
            }
            if (i < 0) {
                return MAIN_DIR_SPEC;
            }
            return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764836350")) {
            return ((Integer) ipChange.ipc$dispatch("1764836350", new Object[]{this, recycler, state, Integer.valueOf(i)})).intValue();
        } else if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        } else {
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                return 0;
            }
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976811299")) {
            return ((Integer) ipChange.ipc$dispatch("-1976811299", new Object[]{this, recycler, state, Integer.valueOf(i)})).intValue();
        } else if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        } else {
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                return 0;
            }
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
    }

    private int updateCellWidth(int i, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786955988")) {
            return ((Integer) ipChange.ipc$dispatch("786955988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})).intValue();
        } else if ((i4 + 1) % i6 != 0) {
            return i;
        } else {
            int i7 = this.mHGap;
            float[] fArr = this.mWeights;
            if (fArr == null || fArr.length <= 0) {
                int i8 = i6 - 1;
                int i9 = i7 * i8;
                return (i5 * i) + i9 != i2 ? (i2 - (i8 * i)) - i9 : i;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                i10 += this.mSpanCols[i11];
            }
            int i12 = (((i6 - 1) * i7) + i10) - i2;
            return i12 > 0 ? i - i12 : i;
        }
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125682324")) {
            ipChange.ipc$dispatch("-125682324", new Object[]{this, state, cVar, layoutManagerHelper});
        } else if (state.getItemCount() > 0 && !state.isPreLayout()) {
            int cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(cVar.a, this.mSpanCount);
            if (!cVar.c) {
                while (cachedSpanIndex > 0) {
                    int i = cVar.a;
                    if (i <= 0) {
                        break;
                    }
                    int i2 = i - 1;
                    cVar.a = i2;
                    cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(i2, this.mSpanCount);
                }
            } else {
                while (cachedSpanIndex < this.mSpanCount - 1 && cVar.a < getRange().e().intValue()) {
                    int i3 = cVar.a + 1;
                    cVar.a = i3;
                    cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(i3, this.mSpanCount);
                }
            }
            this.mLayoutWithAnchor = true;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        int i4;
        int i5;
        IpChange ipChange = $ipChange;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "1947111933")) {
            return ((Integer) ipChange.ipc$dispatch("1947111933", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
        }
        if (layoutManagerHelper.getOrientation() == 1) {
            z3 = true;
        }
        if (z) {
            if (i == getItemCount() - 1) {
                if (z3) {
                    i5 = this.mMarginBottom;
                    i4 = this.mPaddingBottom;
                } else {
                    i5 = this.mMarginRight;
                    i4 = this.mPaddingRight;
                }
                return i5 + i4;
            }
        } else if (i == 0) {
            if (z3) {
                i3 = -this.mMarginTop;
                i2 = this.mPaddingTop;
            } else {
                i3 = -this.mMarginLeft;
                i2 = this.mPaddingLeft;
            }
            return i3 - i2;
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public float getAspectRatio() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "366526561")) {
            return this.mAspectRatio;
        }
        return ((Float) ipChange.ipc$dispatch("366526561", new Object[]{this})).floatValue();
    }

    public int getHGap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-523481653")) {
            return this.mHGap;
        }
        return ((Integer) ipChange.ipc$dispatch("-523481653", new Object[]{this})).intValue();
    }

    public int getRawSpanCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1000519452")) {
            return this.mRawSpanCount;
        }
        return ((Integer) ipChange.ipc$dispatch("1000519452", new Object[]{this})).intValue();
    }

    public int getSpanCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1074401682")) {
            return this.mSpanCount;
        }
        return ((Integer) ipChange.ipc$dispatch("1074401682", new Object[]{this})).intValue();
    }

    public int getVGap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-983332007")) {
            return this.mVGap;
        }
        return ((Integer) ipChange.ipc$dispatch("-983332007", new Object[]{this})).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02d7, code lost:
        r22 = com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.TAG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x025b, code lost:
        if (r0 == getRange().e().intValue()) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x026e, code lost:
        if (r0 == getRange().d().intValue()) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0272, code lost:
        r1 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0208 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x022d  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, s61 s61, LayoutManagerHelper layoutManagerHelper) {
        c cVar;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        int i3;
        String str;
        boolean z4;
        String str2;
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        String str3;
        String str4;
        int i11;
        int i12;
        int i13;
        int i14;
        View view;
        int i15;
        int i16;
        View view2;
        int i17;
        int i18;
        int i19;
        int c;
        int spanSize;
        View l;
        int i20;
        boolean z7;
        boolean z8;
        boolean z9;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.d dVar2 = dVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787227807")) {
            ipChange.ipc$dispatch("787227807", new Object[]{this, recycler2, state2, dVar2, s61, layoutManagerHelper});
        } else if (!isOutOfRange(dVar.c())) {
            dVar.c();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            int e = dVar.e();
            boolean z10 = e == 1;
            c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            boolean z11 = layoutManagerHelper.getOrientation() == 1;
            int contentWidth = (((layoutManagerHelper.getContentWidth() - this.mPaddingLeft) - this.mPaddingRight) - this.mMarginLeft) - this.mMarginRight;
            adjustHGap(contentWidth);
            if (z11) {
                int contentWidth2 = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - layoutManagerHelper.getPaddingLeft()) - getHorizontalMargin()) - getHorizontalPadding();
                this.mTotalSize = contentWidth2;
                int i21 = this.mSpanCount;
                this.mSizePerSpan = (int) (((((float) (contentWidth2 - ((i21 - 1) * this.mHGap))) * 1.0f) / ((float) i21)) + 0.5f);
            } else {
                int contentHeight = (((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - layoutManagerHelper.getPaddingTop()) - getVerticalMargin()) - getVerticalPadding();
                this.mTotalSize = contentHeight;
                int i22 = this.mSpanCount;
                this.mSizePerSpan = (int) (((((float) (contentHeight - ((i22 - 1) * this.mVGap))) * 1.0f) / ((float) i22)) + 0.5f);
            }
            int i23 = this.mSpanCount;
            ensureSpanCount();
            if (!z10) {
                int spanIndex = getSpanIndex(recycler2, state2, dVar.c());
                i = contentWidth;
                int spanSize2 = getSpanSize(recycler2, state2, dVar.c()) + spanIndex;
                z3 = z11;
                if (spanIndex != this.mSpanCount - 1) {
                    int c2 = dVar.c();
                    int i24 = this.mSpanCount - spanSize2;
                    cVar = mainOrientationHelper;
                    int i25 = 0;
                    z2 = false;
                    int i26 = 0;
                    z = false;
                    while (i25 < this.mSpanCount && i24 > 0) {
                        c2 -= e;
                        if (isOutOfRange(c2)) {
                            break;
                        }
                        int spanSize3 = getSpanSize(recycler2, state2, c2);
                        if (spanSize3 <= this.mSpanCount) {
                            View m = dVar2.m(recycler2, c2);
                            if (m == null) {
                                break;
                            }
                            if (!z2) {
                                if (layoutManagerHelper.getReverseLayout()) {
                                    z9 = false;
                                    z2 = z9;
                                } else {
                                    z9 = false;
                                    z2 = z9;
                                }
                                z9 = true;
                                z2 = z9;
                            }
                            if (!z) {
                                if (layoutManagerHelper.getReverseLayout()) {
                                    z8 = false;
                                    z = z8;
                                } else {
                                    z8 = false;
                                    z = z8;
                                }
                                z8 = true;
                                z = z8;
                            }
                            i24 -= spanSize3;
                            if (i24 < 0) {
                                break;
                            }
                            i26 += spanSize3;
                            this.mSet[i25] = m;
                            i25++;
                            e = e;
                        } else {
                            throw new IllegalArgumentException("Item at position " + c2 + " requires " + spanSize3 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
                        }
                    }
                    if (i25 > 0) {
                        int i27 = 0;
                        for (int i28 = i25 - 1; i27 < i28; i28--) {
                            View[] viewArr = this.mSet;
                            View view3 = viewArr[i27];
                            viewArr[i27] = viewArr[i28];
                            viewArr[i28] = view3;
                            i27++;
                        }
                    }
                    i2 = i25;
                    i23 = spanSize2;
                    i3 = i26;
                    while (true) {
                        if (i2 >= this.mSpanCount || !dVar2.h(state2) || i23 <= 0) {
                            break;
                        }
                        c = dVar.c();
                        if (isOutOfRange(c)) {
                            spanSize = getSpanSize(recycler2, state2, c);
                            str = TAG;
                            if (spanSize <= this.mSpanCount) {
                                i23 -= spanSize;
                                if (i23 < 0 || (l = dVar2.l(recycler2)) == null) {
                                    break;
                                }
                                if (!z2) {
                                    if (layoutManagerHelper.getReverseLayout()) {
                                        i20 = i23;
                                    } else {
                                        i20 = i23;
                                    }
                                    boolean z12 = true;
                                    z2 = z12;
                                } else {
                                    i20 = i23;
                                }
                                if (!z) {
                                    if (layoutManagerHelper.getReverseLayout()) {
                                        z7 = false;
                                        z = z7;
                                    } else {
                                        z7 = false;
                                        z = z7;
                                    }
                                    z7 = true;
                                    z = z7;
                                }
                                i3 += spanSize;
                                this.mSet[i2] = l;
                                i2++;
                                i23 = i20;
                            } else {
                                throw new IllegalArgumentException("Item at position " + c + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
                            }
                        } else if (DEBUG) {
                            LogUtil.d(TAG, "pos [" + c + "] is out of range");
                        }
                    }
                    if (i2 == 0) {
                        c cVar2 = cVar;
                        assignSpans(recycler, state, i2, i3, z10, layoutManagerHelper);
                        if (i23 <= 0 || i2 != i3 || !this.mIsAutoExpand) {
                            if (!z10 && i23 == 0 && i2 == i3 && this.mIsAutoExpand) {
                                if (z3) {
                                    this.mSizePerSpan = (this.mTotalSize - ((i2 - 1) * this.mHGap)) / i2;
                                } else {
                                    this.mSizePerSpan = (this.mTotalSize - ((i2 - 1) * this.mVGap)) / i2;
                                }
                            }
                        } else if (z3) {
                            this.mSizePerSpan = (this.mTotalSize - ((i2 - 1) * this.mHGap)) / i2;
                        } else {
                            this.mSizePerSpan = (this.mTotalSize - ((i2 - 1) * this.mVGap)) / i2;
                        }
                        float[] fArr = this.mWeights;
                        if (fArr == null || fArr.length <= 0) {
                            z4 = false;
                        } else {
                            if (z3) {
                                i19 = this.mTotalSize;
                                i18 = i2 - 1;
                                i17 = this.mHGap;
                            } else {
                                i19 = this.mTotalSize;
                                i18 = i2 - 1;
                                i17 = this.mVGap;
                            }
                            int i29 = i19 - (i18 * i17);
                            int i30 = (i23 <= 0 || !this.mIsAutoExpand) ? this.mSpanCount : i2;
                            int i31 = i29;
                            int i32 = 0;
                            for (int i33 = 0; i33 < i30; i33++) {
                                float[] fArr2 = this.mWeights;
                                if (i33 < fArr2.length && !Float.isNaN(fArr2[i33])) {
                                    float[] fArr3 = this.mWeights;
                                    if (fArr3[i33] >= 0.0f) {
                                        float f = fArr3[i33];
                                        int[] iArr = this.mSpanCols;
                                        iArr[i33] = (int) ((((f * 1.0f) / 100.0f) * ((float) i29)) + 0.5f);
                                        i31 -= iArr[i33];
                                    }
                                }
                                i32++;
                                this.mSpanCols[i33] = -1;
                            }
                            if (i32 > 0) {
                                int i34 = i31 / i32;
                                for (int i35 = 0; i35 < i30; i35++) {
                                    int[] iArr2 = this.mSpanCols;
                                    if (iArr2[i35] < 0) {
                                        iArr2[i35] = i34;
                                    }
                                }
                            }
                            z4 = true;
                        }
                        int i36 = 0;
                        int i37 = 0;
                        while (i37 < i2) {
                            View view4 = this.mSet[i37];
                            layoutManagerHelper.addChildView(dVar2, view4, z10 ? -1 : 0);
                            int spanSize4 = getSpanSize(recycler2, state2, layoutManagerHelper.getPosition(view4));
                            if (z4) {
                                int i38 = this.mSpanIndices[i37];
                                int i39 = 0;
                                for (int i40 = 0; i40 < spanSize4; i40++) {
                                    i39 += this.mSpanCols[i40 + i38];
                                }
                                i16 = Math.max(0, i39);
                            } else {
                                i16 = (this.mSizePerSpan * spanSize4) + (Math.max(0, spanSize4 - 1) * (z3 ? this.mHGap : this.mVGap));
                            }
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(updateCellWidth(i16, i, spanSize4, i37, i2, this.mSpanCount), 1073741824);
                            VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
                            if (layoutManagerHelper.getOrientation() == 1) {
                                view2 = view4;
                                layoutManagerHelper.measureChildWithMargins(view2, makeMeasureSpec, getMainDirSpec(((ViewGroup.MarginLayoutParams) layoutParams).height, this.mTotalSize, View.MeasureSpec.getSize(makeMeasureSpec), layoutParams.a));
                            } else {
                                view2 = view4;
                                layoutManagerHelper.measureChildWithMargins(view2, getMainDirSpec(((ViewGroup.MarginLayoutParams) layoutParams).width, this.mTotalSize, View.MeasureSpec.getSize(makeMeasureSpec), layoutParams.a), View.MeasureSpec.getSize(makeMeasureSpec));
                            }
                            int e2 = cVar2.e(view2);
                            i36 = e2 > i36 ? e2 : i36;
                            i37++;
                            dVar2 = dVar;
                            cVar2 = cVar2;
                        }
                        int i41 = i36;
                        if (AppInfoProviderProxy.isDebuggable()) {
                            i4 = 0;
                            str2 = str;
                            LogUtil.d(str2, "---------------------");
                        } else {
                            str2 = str;
                            i4 = 0;
                        }
                        int mainDirSpec = getMainDirSpec(i41, this.mTotalSize, i4, Float.NaN);
                        int i42 = 0;
                        while (i42 < i2) {
                            View view5 = this.mSet[i42];
                            if (cVar2.e(view5) != i41) {
                                int spanSize5 = getSpanSize(recycler2, state2, layoutManagerHelper.getPosition(view5));
                                if (z4) {
                                    int i43 = this.mSpanIndices[i42];
                                    view = view5;
                                    int i44 = 0;
                                    int i45 = 0;
                                    while (i45 < spanSize5) {
                                        i44 += this.mSpanCols[i45 + i43];
                                        i45++;
                                        i42 = i42;
                                    }
                                    i14 = i42;
                                    i15 = Math.max(0, i44);
                                } else {
                                    view = view5;
                                    i14 = i42;
                                    i15 = (this.mSizePerSpan * spanSize5) + (Math.max(0, spanSize5 - 1) * (z3 ? this.mHGap : this.mVGap));
                                }
                                i12 = i14;
                                i13 = mainDirSpec;
                                str4 = str2;
                                i11 = i41;
                                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(updateCellWidth(i15, i, spanSize5, i12, i2, this.mSpanCount), 1073741824);
                                if (layoutManagerHelper.getOrientation() == 1) {
                                    layoutManagerHelper.measureChildWithMargins(view, makeMeasureSpec2, i13);
                                } else {
                                    layoutManagerHelper.measureChildWithMargins(view, i13, makeMeasureSpec2);
                                }
                            } else {
                                i12 = i42;
                                i13 = mainDirSpec;
                                str4 = str2;
                                i11 = i41;
                            }
                            i42 = i12 + 1;
                            recycler2 = recycler;
                            mainDirSpec = i13;
                            i41 = i11;
                            str2 = str4;
                            state2 = state;
                        }
                        String str5 = str2;
                        if (z2) {
                            z6 = true;
                            z5 = isEnableMarginOverLap;
                            i5 = computeStartSpace(layoutManagerHelper, z3, !layoutManagerHelper.getReverseLayout(), z5);
                        } else {
                            z5 = isEnableMarginOverLap;
                            z6 = true;
                            i5 = 0;
                        }
                        int computeEndSpace = z ? computeEndSpace(layoutManagerHelper, z3, layoutManagerHelper.getReverseLayout() ^ z6, z5) : 0;
                        s61.a = i41 + i5 + computeEndSpace;
                        boolean z13 = dVar.f() == -1;
                        if (!this.mLayoutWithAnchor && ((!z || !z13) && (!z2 || z13))) {
                            s61.a += z3 ? this.mVGap : this.mHGap;
                        }
                        if (z3) {
                            if (dVar.f() == -1) {
                                int g = (dVar.g() - computeEndSpace) - ((this.mLayoutWithAnchor || z) ? 0 : this.mVGap);
                                i6 = g;
                                i7 = g - i41;
                            } else {
                                int g2 = ((this.mLayoutWithAnchor || z2) ? 0 : this.mVGap) + dVar.g() + i5;
                                i7 = g2;
                                i6 = g2 + i41;
                            }
                            i9 = 0;
                            i8 = 0;
                        } else if (dVar.f() == -1) {
                            int g3 = (dVar.g() - computeEndSpace) - ((this.mLayoutWithAnchor || z) ? 0 : this.mHGap);
                            i7 = 0;
                            i6 = 0;
                            i8 = g3;
                            i9 = g3 - i41;
                        } else {
                            i9 = ((this.mLayoutWithAnchor || z2) ? 0 : this.mHGap) + dVar.g() + i5;
                            i8 = i9 + i41;
                            i7 = 0;
                            i6 = 0;
                        }
                        int i46 = 0;
                        while (i46 < i2) {
                            View view6 = this.mSet[i46];
                            int i47 = this.mSpanIndices[i46];
                            VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
                            if (z3) {
                                if (z4) {
                                    i9 = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft;
                                    for (int i48 = 0; i48 < i47; i48++) {
                                        i9 += this.mSpanCols[i48] + this.mHGap;
                                    }
                                } else {
                                    i9 = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft + (this.mSizePerSpan * i47) + (this.mHGap * i47);
                                }
                                i8 = cVar2.f(view6) + i9;
                            } else {
                                if (z4) {
                                    i7 = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop;
                                    for (int i49 = 0; i49 < i47; i49++) {
                                        i7 += this.mSpanCols[i49] + this.mVGap;
                                    }
                                } else {
                                    i7 = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop + (this.mSizePerSpan * i47) + (this.mVGap * i47);
                                }
                                i6 = cVar2.f(view6) + i7;
                            }
                            if (!DEBUG || !AppInfoProviderProxy.isDebuggable()) {
                                i10 = i2;
                                str3 = str5;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                i10 = i2;
                                sb.append("layout item in position: ");
                                sb.append(layoutParams2.getViewPosition());
                                sb.append(" with text ");
                                sb.append((Object) ((TextView) view6).getText());
                                sb.append(" with SpanIndex: ");
                                sb.append(i47);
                                sb.append(" into (");
                                sb.append(i9);
                                sb.append(AVFSCacheConstants.COMMA_SEP);
                                sb.append(i7);
                                sb.append(AVFSCacheConstants.COMMA_SEP);
                                sb.append(i8);
                                sb.append(AVFSCacheConstants.COMMA_SEP);
                                sb.append(i6);
                                sb.append(" )");
                                str3 = str5;
                                LogUtil.d(str3, sb.toString());
                            }
                            layoutChildWithMargin(view6, i9, i7, i8, i6, layoutManagerHelper);
                            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                                s61.c = true;
                            }
                            s61.d |= view6.isFocusable();
                            i46++;
                            str5 = str3;
                            i2 = i10;
                            i6 = i6;
                            i7 = i7;
                            i8 = i8;
                            i9 = i9;
                        }
                        this.mLayoutWithAnchor = false;
                        Arrays.fill(this.mSet, (Object) null);
                        Arrays.fill(this.mSpanIndices, 0);
                        Arrays.fill(this.mSpanCols, 0);
                        return;
                    }
                    return;
                }
                cVar = mainOrientationHelper;
                i23 = spanSize2;
            } else {
                i = contentWidth;
                z3 = z11;
                cVar = mainOrientationHelper;
            }
            i3 = 0;
            i2 = 0;
            z2 = false;
            z = false;
            while (true) {
                c = dVar.c();
                if (isOutOfRange(c)) {
                }
                i3 += spanSize;
                this.mSet[i2] = l;
                i2++;
                i23 = i20;
            }
            if (i2 == 0) {
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465248626")) {
            ipChange.ipc$dispatch("1465248626", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143808261")) {
            ipChange.ipc$dispatch("2143808261", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onItemsChanged(layoutManagerHelper);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173454606")) {
            ipChange.ipc$dispatch("1173454606", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mSpanSizeLookup.setStartPosition(i);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setAspectRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602517789")) {
            ipChange.ipc$dispatch("-602517789", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mAspectRatio = f;
    }

    public void setAutoExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2093051683")) {
            ipChange.ipc$dispatch("2093051683", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsAutoExpand = z;
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281917417")) {
            ipChange.ipc$dispatch("1281917417", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setVGap(i);
        setHGap(i);
    }

    public void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863387959")) {
            ipChange.ipc$dispatch("863387959", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.mOrigHGap = i;
        this.mHGap = i;
        this.mHGapDirty = true;
    }

    public void setIgnoreExtra(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907578558")) {
            ipChange.ipc$dispatch("-907578558", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIgnoreExtra = z;
    }

    public void setRawSpanCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592366074")) {
            ipChange.ipc$dispatch("-592366074", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRawSpanCount = i;
        setSpanCount(i);
    }

    public void setSpanCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410268088")) {
            ipChange.ipc$dispatch("1410268088", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mSpanCount) {
            if (i >= 1) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                ensureSpanCount();
                this.mHGapDirty = true;
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714565996")) {
            ipChange.ipc$dispatch("714565996", new Object[]{this, spanSizeLookup});
        } else if (spanSizeLookup != null) {
            spanSizeLookup.setStartPosition(this.mSpanSizeLookup.getStartPosition());
            this.mSpanSizeLookup = spanSizeLookup;
        }
    }

    public void setVGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507071127")) {
            ipChange.ipc$dispatch("-507071127", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.mVGap = i;
    }

    public void setWeights(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932311776")) {
            ipChange.ipc$dispatch("-932311776", new Object[]{this, fArr});
        } else if (fArr != null) {
            this.mWeights = Arrays.copyOf(fArr, fArr.length);
        } else {
            this.mWeights = new float[0];
        }
    }

    public GridFixAutoStatLayoutHelper(int i) {
        this(i, -1, -1);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2) {
        this(i, i2, 0);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2, int i3) {
        this(i, i2, i3, i3);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2, int i3, int i4) {
        this.mSpanCount = 4;
        this.mSizePerSpan = 0;
        this.mTotalSize = 0;
        this.mIsAutoExpand = false;
        this.mIgnoreExtra = false;
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mVGap = 0;
        this.mOrigHGap = 0;
        this.mHGapDirty = false;
        this.mWidthForHGap = 0;
        this.mHGap = 0;
        this.mWeights = new float[0];
        this.mAspectRatio = Float.NaN;
        this.mLayoutWithAnchor = false;
        setRawSpanCount(i);
        this.mSpanSizeLookup.setSpanIndexCacheEnabled(true);
        setItemCount(i2);
        setVGap(i3);
        setHGap(i4);
    }
}
