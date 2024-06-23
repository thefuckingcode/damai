package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tb.jl1;

/* compiled from: Taobao */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* compiled from: Taobao */
    public @interface DividerMode {
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* compiled from: Taobao */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    i4 = virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else {
                    i4 = (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i4);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    i3 = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i2 = this.mDividerWidth;
                } else {
                    i = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    drawVerticalDivider(canvas, i);
                }
            } else if (isLayoutRtl) {
                i = getPaddingLeft();
                drawVerticalDivider(canvas, i);
            } else {
                i3 = getWidth() - getPaddingRight();
                i2 = this.mDividerWidth;
            }
            i = i3 - i2;
            drawVerticalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int i;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i2))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i = virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin;
            }
            drawHorizontalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i3 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            if ((this.mShowDividers & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i15 = i4 - i2;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i16, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (isLayoutRtl) {
            i7 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i7 + (i6 * i18);
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z) {
                    i10 = virtualChildCount;
                    if (((LinearLayout.LayoutParams) layoutParams).height != -1) {
                        i11 = virtualChildAt.getBaseline();
                        i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i12 < 0) {
                            i12 = i17;
                        }
                        i13 = i12 & 112;
                        i9 = i17;
                        if (i13 != 16) {
                            i14 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        } else if (i13 == 48) {
                            i14 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (i11 != -1) {
                                i14 += iArr[1] - i11;
                            }
                        } else if (i13 != 80) {
                            i14 = paddingTop;
                        } else {
                            i14 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (i11 != -1) {
                                i14 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i11);
                            }
                        }
                        if (hasDividerBeforeChildAt(i19)) {
                            i5 += this.mDividerWidth;
                        }
                        int i20 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + i5;
                        i8 = paddingTop;
                        setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i14, measuredWidth, measuredHeight);
                        i18 += getChildrenSkipCount(virtualChildAt, i19);
                        i5 = i20 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i18++;
                        virtualChildCount = i10;
                        i17 = i9;
                        paddingTop = i8;
                    }
                } else {
                    i10 = virtualChildCount;
                }
                i11 = -1;
                i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i12 < 0) {
                }
                i13 = i12 & 112;
                i9 = i17;
                if (i13 != 16) {
                }
                if (hasDividerBeforeChildAt(i19)) {
                }
                int i202 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + i5;
                i8 = paddingTop;
                setChildFrame(virtualChildAt, i202 + getLocationOffset(virtualChildAt), i14, measuredWidth, measuredHeight);
                i18 += getChildrenSkipCount(virtualChildAt, i19);
                i5 = i202 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i18++;
                virtualChildCount = i10;
                i17 = i9;
                paddingTop = i8;
            }
            i8 = paddingTop;
            i10 = virtualChildCount;
            i9 = i17;
            i18++;
            virtualChildCount = i10;
            i17 = i9;
            paddingTop = i8;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e  */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.mGravity;
        int i11 = i10 & 112;
        int i12 = i10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 16) {
            i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i11 != 80) {
            i5 = getPaddingTop();
        } else {
            i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i14 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i8 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i7 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i6 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    if (hasDividerBeforeChildAt(i13)) {
                        i5 += this.mDividerHeight;
                    }
                    int i15 = i5 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i6, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i13 += getChildrenSkipCount(virtualChildAt, i13);
                    i5 = i15 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                } else {
                    i8 = paddingRight - measuredWidth;
                    i7 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i6 = i8 - i7;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i152 = i5 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i6, i152 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i13 += getChildrenSkipCount(virtualChildAt, i13);
                i5 = i152 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i13++;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d4  */
    public void measureHorizontal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f;
        int i12;
        boolean z;
        int baseline;
        int i13;
        int i14;
        int i15;
        boolean z2;
        boolean z3;
        int i16;
        int i17;
        View view;
        int i18;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int i19;
        int i20;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i21 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f2 = 0.0f;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        boolean z8 = false;
        int i27 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (i22 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i22);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i22);
            } else if (virtualChildAt.getVisibility() == 8) {
                i22 += getChildrenSkipCount(virtualChildAt, i22);
            } else {
                if (hasDividerBeforeChildAt(i22)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f3 = ((LinearLayout.LayoutParams) layoutParams).weight;
                float f4 = f2 + f3;
                if (mode == i21 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f3 > 0.0f) {
                    if (z7) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else {
                        int i28 = this.mTotalLength;
                        this.mTotalLength = Math.max(i28, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i28 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i17 = i22;
                        z3 = z6;
                        z2 = z5;
                        view = virtualChildAt;
                    } else {
                        i17 = i22;
                        z3 = z6;
                        z2 = z5;
                        view = virtualChildAt;
                        i18 = 1073741824;
                        z8 = true;
                        if (mode2 == i18 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i29 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i29;
                        i27 = View.combineMeasuredStates(i27, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i19 < 0) {
                                i19 = this.mGravity;
                            }
                            int i30 = (((i19 & 112) >> 4) & -2) >> 1;
                            iArr[i30] = Math.max(iArr[i30], baseline2);
                            iArr2[i30] = Math.max(iArr2[i30], measuredHeight - baseline2);
                        }
                        i24 = Math.max(i24, measuredHeight);
                        z9 = !z9 && ((LinearLayout.LayoutParams) layoutParams).height == -1;
                        if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                            if (!z4) {
                                i29 = measuredHeight;
                            }
                            i26 = Math.max(i26, i29);
                        } else {
                            if (!z4) {
                                i29 = measuredHeight;
                            }
                            i25 = Math.max(i25, i29);
                            i26 = i26;
                        }
                        i16 = getChildrenSkipCount(view, i17) + i17;
                        f2 = f4;
                        i22 = i16 + 1;
                        iArr2 = iArr2;
                        z6 = z3;
                        z5 = z2;
                        i21 = 1073741824;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f3 <= 0.0f) {
                        i20 = Integer.MIN_VALUE;
                    } else {
                        ((LinearLayout.LayoutParams) layoutParams).width = -2;
                        i20 = 0;
                    }
                    i17 = i22;
                    z3 = z6;
                    z2 = z5;
                    measureChildBeforeLayout(virtualChildAt, i17, i, f4 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i20 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) layoutParams).width = i20;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i31 = this.mTotalLength;
                        this.mTotalLength = Math.max(i31, i31 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z3) {
                        i23 = Math.max(measuredWidth, i23);
                    }
                }
                i18 = 1073741824;
                if (mode2 == i18) {
                }
                z4 = false;
                int i292 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i292;
                i27 = View.combineMeasuredStates(i27, view.getMeasuredState());
                i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i19 < 0) {
                }
                int i302 = (((i19 & 112) >> 4) & -2) >> 1;
                iArr[i302] = Math.max(iArr[i302], baseline2);
                iArr2[i302] = Math.max(iArr2[i302], measuredHeight - baseline2);
                i24 = Math.max(i24, measuredHeight);
                if (!z9) {
                }
                if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                }
                i16 = getChildrenSkipCount(view, i17) + i17;
                f2 = f4;
                i22 = i16 + 1;
                iArr2 = iArr2;
                z6 = z3;
                z5 = z2;
                i21 = 1073741824;
            }
            i16 = i22;
            z3 = z6;
            z2 = z5;
            i22 = i16 + 1;
            iArr2 = iArr2;
            z6 = z3;
            z5 = z2;
            i21 = 1073741824;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i24;
            i3 = i27;
        } else {
            i3 = i27;
            i4 = Math.max(i24, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z6 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i32 = 0;
            while (i32 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i32);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i32);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i32 += getChildrenSkipCount(virtualChildAt2, i32);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams2).leftMargin + i23 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i33 = this.mTotalLength;
                        i15 = i4;
                        this.mTotalLength = Math.max(i33, i33 + i23 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i32++;
                        i4 = i15;
                    }
                }
                i15 = i4;
                i32++;
                i4 = i15;
            }
        }
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i34 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i34 != 0 && f2 > 0.0f)) {
            float f5 = this.mWeightSum;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.mTotalLength = 0;
            int i35 = i25;
            int i36 = i3;
            int i37 = -1;
            int i38 = 0;
            while (i38 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i38);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i11 = i34;
                    i10 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f6 > 0.0f) {
                        int i39 = (int) ((((float) i34) * f6) / f2);
                        float f7 = f2 - f6;
                        int i40 = i34 - i39;
                        i10 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i14 = 1073741824;
                            if (mode == 1073741824) {
                                if (i39 <= 0) {
                                    i39 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i39, 1073741824), childMeasureSpec);
                                i36 = View.combineMeasuredStates(i36, virtualChildAt3.getMeasuredState() & -16777216);
                                f2 = f7;
                                i11 = i40;
                            }
                        } else {
                            i14 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i39;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i14), childMeasureSpec);
                        i36 = View.combineMeasuredStates(i36, virtualChildAt3.getMeasuredState() & -16777216);
                        f2 = f7;
                        i11 = i40;
                    } else {
                        i11 = i34;
                        i10 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f2;
                    } else {
                        int i41 = this.mTotalLength;
                        f = f2;
                        this.mTotalLength = Math.max(i41, virtualChildAt3.getMeasuredWidth() + i41 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z11 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i42 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i42;
                    i37 = Math.max(i37, measuredHeight2);
                    if (!z11) {
                        i42 = measuredHeight2;
                    }
                    int max = Math.max(i35, i42);
                    if (z9) {
                        i12 = -1;
                        if (((LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z = true;
                            if (z5 && (baseline = virtualChildAt3.getBaseline()) != i12) {
                                i13 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                                if (i13 < 0) {
                                    i13 = this.mGravity;
                                }
                                int i43 = (((i13 & 112) >> 4) & -2) >> 1;
                                iArr[i43] = Math.max(iArr[i43], baseline);
                                iArr2[i43] = Math.max(iArr2[i43], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i35 = max;
                            f2 = f;
                        }
                    } else {
                        i12 = -1;
                    }
                    z = false;
                    i13 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                    if (i13 < 0) {
                    }
                    int i432 = (((i13 & 112) >> 4) & -2) >> 1;
                    iArr[i432] = Math.max(iArr[i432], baseline);
                    iArr2[i432] = Math.max(iArr2[i432], measuredHeight2 - baseline);
                    z9 = z;
                    i35 = max;
                    f2 = f;
                }
                i38++;
                i34 = i11;
                virtualChildCount = i10;
            }
            i7 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
                i9 = i37;
            } else {
                i9 = Math.max(i37, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i6 = i9;
            i8 = i35;
            i3 = i36;
        } else {
            i8 = Math.max(i25, i26);
            if (z6 && mode != 1073741824) {
                for (int i44 = 0; i44 < virtualChildCount; i44++) {
                    View virtualChildAt4 = getVirtualChildAt(i44);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i23, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i7 = i2;
            i5 = virtualChildCount;
            i6 = i4;
        }
        if (z9 || mode2 == 1073741824) {
            i8 = i6;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & -16777216), View.resolveSizeAndState(Math.max(i8 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i7, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0322  */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        View view;
        int i18;
        boolean z2;
        int i19;
        int i20;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i21 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f = 0.0f;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i28 = 8;
            if (i27 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i27);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i27);
                    i11 = virtualChildCount;
                    i12 = mode2;
                    i25 = i25;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i27 += getChildrenSkipCount(virtualChildAt, i27);
                    i11 = virtualChildCount;
                    i25 = i25;
                    i22 = i22;
                    i12 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(i27)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f2 = ((LinearLayout.LayoutParams) layoutParams).weight;
                    float f3 = f + f2;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams).height == 0 && f2 > 0.0f) {
                        int i29 = this.mTotalLength;
                        this.mTotalLength = Math.max(i29, ((LinearLayout.LayoutParams) layoutParams).topMargin + i29 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        i18 = i24;
                        view = virtualChildAt;
                        i13 = i26;
                        i17 = i22;
                        i14 = i23;
                        z4 = true;
                        i11 = virtualChildCount;
                        i12 = mode2;
                        i15 = i25;
                        i16 = i27;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams).height != 0 || f2 <= 0.0f) {
                            i20 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams).height = -2;
                            i20 = 0;
                        }
                        i17 = i22;
                        i14 = i23;
                        i11 = virtualChildCount;
                        i12 = mode2;
                        i15 = i25;
                        i13 = i26;
                        i16 = i27;
                        measureChildBeforeLayout(virtualChildAt, i27, i, 0, i2, f3 == 0.0f ? this.mTotalLength : 0);
                        if (i20 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams).height = i20;
                        }
                        int measuredHeight = virtualChildAt.getMeasuredHeight();
                        int i30 = this.mTotalLength;
                        view = virtualChildAt;
                        this.mTotalLength = Math.max(i30, i30 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(view));
                        i18 = z3 ? Math.max(measuredHeight, i24) : i24;
                    }
                    if (i21 >= 0 && i21 == i16 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i16 >= i21 || ((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                        if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams).width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i31 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i31;
                        int max = Math.max(i14, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i17, view.getMeasuredState());
                        z5 = z5 && ((LinearLayout.LayoutParams) layoutParams).width == -1;
                        if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                            if (!z2) {
                                i31 = measuredWidth;
                            }
                            i25 = Math.max(i15, i31);
                            i19 = i13;
                        } else {
                            if (!z2) {
                                i31 = measuredWidth;
                            }
                            i19 = Math.max(i13, i31);
                            i25 = i15;
                        }
                        i24 = i18;
                        f = f3;
                        i26 = i19;
                        i22 = combineMeasuredStates;
                        i27 = getChildrenSkipCount(view, i16) + i16;
                        i23 = max;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i27++;
                mode2 = i12;
                virtualChildCount = i11;
            } else {
                int i32 = i23;
                if (this.mTotalLength > 0) {
                    i3 = virtualChildCount;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = virtualChildCount;
                }
                if (z3 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                    this.mTotalLength = 0;
                    int i33 = 0;
                    while (i33 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i33);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i33);
                        } else if (virtualChildAt2.getVisibility() == i28) {
                            i33 += getChildrenSkipCount(virtualChildAt2, i33);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i34 = this.mTotalLength;
                            this.mTotalLength = Math.max(i34, i34 + i24 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i33++;
                        i28 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i35 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i35 != 0 && f > 0.0f)) {
                    float f4 = this.mWeightSum;
                    if (f4 > 0.0f) {
                        f = f4;
                    }
                    this.mTotalLength = 0;
                    int i36 = i35;
                    int i37 = i26;
                    i5 = i22;
                    int i38 = 0;
                    while (i38 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i38);
                        if (virtualChildAt3.getVisibility() == 8) {
                            i7 = i36;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f5 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                            if (f5 > 0.0f) {
                                int i39 = (int) ((((float) i36) * f5) / f);
                                float f6 = f - f5;
                                i7 = i36 - i39;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin, ((LinearLayout.LayoutParams) layoutParams3).width);
                                if (((LinearLayout.LayoutParams) layoutParams3).height == 0) {
                                    i10 = 1073741824;
                                    if (mode2 == 1073741824) {
                                        if (i39 <= 0) {
                                            i39 = 0;
                                        }
                                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i39, 1073741824));
                                        i5 = View.combineMeasuredStates(i5, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                        f = f6;
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i39;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i10));
                                i5 = View.combineMeasuredStates(i5, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                f = f6;
                            } else {
                                i7 = i36;
                            }
                            int i40 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i40;
                            i32 = Math.max(i32, measuredWidth2);
                            if (mode != 1073741824) {
                                i8 = i5;
                                i9 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams3).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i40 = measuredWidth2;
                                    }
                                    int max2 = Math.max(i37, i40);
                                    boolean z7 = !z5 && ((LinearLayout.LayoutParams) layoutParams3).width == i9;
                                    int i41 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i41, virtualChildAt3.getMeasuredHeight() + i41 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt3));
                                    z5 = z7;
                                    i5 = i8;
                                    i37 = max2;
                                    f = f;
                                }
                            } else {
                                i8 = i5;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max22 = Math.max(i37, i40);
                            if (!z5) {
                            }
                            int i412 = this.mTotalLength;
                            this.mTotalLength = Math.max(i412, virtualChildAt3.getMeasuredHeight() + i412 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z5 = z7;
                            i5 = i8;
                            i37 = max22;
                            f = f;
                        }
                        i38++;
                        i36 = i7;
                    }
                    i4 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i6 = i37;
                } else {
                    i6 = Math.max(i26, i25);
                    if (z3 && mode2 != 1073741824) {
                        for (int i42 = 0; i42 < i3; i42++) {
                            View virtualChildAt4 = getVirtualChildAt(i42);
                            if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight <= 0.0f)) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i24, 1073741824));
                            }
                        }
                    }
                    i4 = i;
                    i5 = i22;
                }
                if (z5 || mode == 1073741824) {
                    i6 = i32;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, i5), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + jl1.BRACKET_END_STR);
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | (-8388616 & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        int[] iArr = R.styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
