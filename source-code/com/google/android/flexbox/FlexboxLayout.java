package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    @Nullable
    private Drawable mDividerDrawableHorizontal;
    @Nullable
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<a> mFlexLines;
    private b.C0153b mFlexLinesResult;
    private int mFlexWrap;
    private b mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private boolean allFlexLinesAreDummyBefore(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mFlexLines.get(i2).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View reorderedChildAt = getReorderedChildAt(i - i3);
            if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                return false;
            }
        }
        return true;
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < aVar.h; i6++) {
                int i7 = aVar.o + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        if (z) {
                            i4 = reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            i4 = (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth;
                        }
                        drawVerticalDivider(canvas, i4, aVar.b, aVar.g);
                    }
                    if (i6 == aVar.h - 1 && (this.mShowDividerVertical & 4) > 0) {
                        if (z) {
                            i3 = (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth;
                        } else {
                            i3 = reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        drawVerticalDivider(canvas, i3, aVar.b, aVar.g);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                if (z2) {
                    i2 = aVar.d;
                } else {
                    i2 = aVar.b - this.mDividerHorizontalHeight;
                }
                drawHorizontalDivider(canvas, paddingLeft, i2, max);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerHorizontal & 4) > 0) {
                if (z2) {
                    i = aVar.b - this.mDividerHorizontalHeight;
                } else {
                    i = aVar.d;
                }
                drawHorizontalDivider(canvas, paddingLeft, i, max);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < aVar.h; i6++) {
                int i7 = aVar.o + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        if (z2) {
                            i4 = reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            i4 = (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight;
                        }
                        drawHorizontalDivider(canvas, aVar.a, i4, aVar.g);
                    }
                    if (i6 == aVar.h - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        if (z2) {
                            i3 = (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight;
                        } else {
                            i3 = reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        drawHorizontalDivider(canvas, aVar.a, i3, aVar.g);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                if (z) {
                    i2 = aVar.c;
                } else {
                    i2 = aVar.a - this.mDividerVerticalWidth;
                }
                drawVerticalDivider(canvas, i2, paddingTop, max);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerVertical & 4) > 0) {
                if (z) {
                    i = aVar.a - this.mDividerVerticalWidth;
                } else {
                    i = aVar.c;
                }
                drawVerticalDivider(canvas, i, paddingTop, max);
            }
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3 + i, this.mDividerHorizontalHeight + i2);
            this.mDividerDrawableHorizontal.draw(canvas);
        }
    }

    private void drawVerticalDivider(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable != null) {
            drawable.setBounds(i, i2, this.mDividerVerticalWidth + i, i3 + i2);
            this.mDividerDrawableVertical.draw(canvas);
        }
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i, int i2) {
        if (allViewsAreGoneBefore(i, i2)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerVertical & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerHorizontal & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerHorizontal & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasDividerBeforeFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        if (allFlexLinesAreDummyBefore(i)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerHorizontal & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerVertical & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasEndDividerAfterFlexLine(int i) {
        if (i < 0 || i >= this.mFlexLines.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.mFlexLines.size(); i2++) {
            if (this.mFlexLines.get(i2).c() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f1  */
    private void layoutHorizontal(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        int i9;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i10 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.mFlexLines.size();
        int i11 = 0;
        while (i11 < size) {
            a aVar = this.mFlexLines.get(i11);
            if (hasDividerBeforeFlexLine(i11)) {
                int i12 = this.mDividerHorizontalHeight;
                paddingBottom -= i12;
                paddingTop += i12;
            }
            int i13 = this.mJustifyContent;
            int i14 = 1;
            if (i13 == 0) {
                f3 = (float) paddingLeft;
                f = (float) (i10 - paddingRight);
            } else if (i13 == 1) {
                int i15 = aVar.e;
                f = (float) (i15 - paddingLeft);
                f3 = (float) ((i10 - i15) + paddingRight);
            } else if (i13 != 2) {
                if (i13 == 3) {
                    f3 = (float) paddingLeft;
                    int c = aVar.c();
                    f2 = ((float) (i10 - aVar.e)) / (c != 1 ? (float) (c - 1) : 1.0f);
                    f = (float) (i10 - paddingRight);
                } else if (i13 == 4) {
                    int c2 = aVar.c();
                    f2 = c2 != 0 ? ((float) (i10 - aVar.e)) / ((float) c2) : 0.0f;
                    float f5 = f2 / 2.0f;
                    f3 = ((float) paddingLeft) + f5;
                    f = ((float) (i10 - paddingRight)) - f5;
                } else if (i13 == 5) {
                    int c3 = aVar.c();
                    f2 = c3 != 0 ? ((float) (i10 - aVar.e)) / ((float) (c3 + 1)) : 0.0f;
                    f3 = ((float) paddingLeft) + f2;
                    f = ((float) (i10 - paddingRight)) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < aVar.h) {
                    int i16 = aVar.o + i5;
                    View reorderedChildAt = getReorderedChildAt(i16);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f6 = f3 + ((float) ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        float f7 = f - ((float) ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                        if (hasDividerBeforeChildAtAlongMainAxis(i16, i5)) {
                            int i17 = this.mDividerVerticalWidth;
                            float f8 = (float) i17;
                            f6 += f8;
                            i8 = i17;
                            f4 = f7 - f8;
                        } else {
                            f4 = f7;
                            i8 = 0;
                        }
                        if (i5 == aVar.h - i14) {
                            if ((this.mShowDividerVertical & 4) > 0) {
                                i9 = this.mDividerVerticalWidth;
                                if (this.mFlexWrap == 2) {
                                    i6 = paddingLeft;
                                    i7 = i5;
                                    layoutParams = layoutParams2;
                                    if (z) {
                                        this.mFlexboxHelper.P(reorderedChildAt, aVar, Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingTop, Math.round(f4), paddingTop + reorderedChildAt.getMeasuredHeight());
                                    } else {
                                        this.mFlexboxHelper.P(reorderedChildAt, aVar, Math.round(f6), paddingTop, Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingTop + reorderedChildAt.getMeasuredHeight());
                                    }
                                } else if (z) {
                                    i7 = i5;
                                    i6 = paddingLeft;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.P(reorderedChildAt, aVar, Math.round(f4) - reorderedChildAt.getMeasuredWidth(), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f4), paddingBottom);
                                } else {
                                    i6 = paddingLeft;
                                    i7 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.P(reorderedChildAt, aVar, Math.round(f6), paddingBottom - reorderedChildAt.getMeasuredHeight(), Math.round(f6) + reorderedChildAt.getMeasuredWidth(), paddingBottom);
                                }
                                f3 = f6 + ((float) reorderedChildAt.getMeasuredWidth()) + max + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                                float measuredWidth = f4 - ((((float) reorderedChildAt.getMeasuredWidth()) + max) + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin));
                                if (!z) {
                                    aVar.d(reorderedChildAt, i9, 0, i8, 0);
                                } else {
                                    aVar.d(reorderedChildAt, i8, 0, i9, 0);
                                }
                                f = measuredWidth;
                            }
                        }
                        i9 = 0;
                        if (this.mFlexWrap == 2) {
                        }
                        f3 = f6 + ((float) reorderedChildAt.getMeasuredWidth()) + max + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                        float measuredWidth2 = f4 - ((((float) reorderedChildAt.getMeasuredWidth()) + max) + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin));
                        if (!z) {
                        }
                        f = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    paddingLeft = i6;
                    i14 = 1;
                }
                int i18 = aVar.g;
                paddingTop += i18;
                paddingBottom -= i18;
                i11++;
                paddingLeft = paddingLeft;
            } else {
                int i19 = aVar.e;
                f3 = ((float) paddingLeft) + (((float) (i10 - i19)) / 2.0f);
                f = ((float) (i10 - paddingRight)) - (((float) (i10 - i19)) / 2.0f);
            }
            f2 = 0.0f;
            float max2 = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < aVar.h) {
            }
            int i182 = aVar.g;
            paddingTop += i182;
            paddingBottom -= i182;
            i11++;
            paddingLeft = paddingLeft;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ed  */
    private void layoutVertical(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        LayoutParams layoutParams;
        int i9;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i10 = i4 - i2;
        int i11 = (i3 - i) - paddingRight;
        int size = this.mFlexLines.size();
        for (int i12 = 0; i12 < size; i12++) {
            a aVar = this.mFlexLines.get(i12);
            if (hasDividerBeforeFlexLine(i12)) {
                int i13 = this.mDividerVerticalWidth;
                paddingLeft += i13;
                i11 -= i13;
            }
            int i14 = this.mJustifyContent;
            if (i14 == 0) {
                f3 = (float) paddingTop;
                i9 = i10 - paddingBottom;
            } else if (i14 == 1) {
                int i15 = aVar.e;
                f3 = (float) ((i10 - i15) + paddingBottom);
                i9 = i15 - paddingTop;
            } else if (i14 != 2) {
                if (i14 == 3) {
                    f3 = (float) paddingTop;
                    int c = aVar.c();
                    f2 = ((float) (i10 - aVar.e)) / (c != 1 ? (float) (c - 1) : 1.0f);
                    f = (float) (i10 - paddingBottom);
                } else if (i14 == 4) {
                    int c2 = aVar.c();
                    f2 = c2 != 0 ? ((float) (i10 - aVar.e)) / ((float) c2) : 0.0f;
                    float f6 = f2 / 2.0f;
                    f3 = ((float) paddingTop) + f6;
                    f = ((float) (i10 - paddingBottom)) - f6;
                } else if (i14 == 5) {
                    int c3 = aVar.c();
                    f2 = c3 != 0 ? ((float) (i10 - aVar.e)) / ((float) (c3 + 1)) : 0.0f;
                    f3 = ((float) paddingTop) + f2;
                    f = ((float) (i10 - paddingBottom)) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < aVar.h) {
                    int i16 = aVar.o + i5;
                    View reorderedChildAt = getReorderedChildAt(i16);
                    if (reorderedChildAt == null || reorderedChildAt.getVisibility() == 8) {
                        i6 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        float f7 = f3 + ((float) ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                        float f8 = f - ((float) ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                        if (hasDividerBeforeChildAtAlongMainAxis(i16, i5)) {
                            int i17 = this.mDividerHorizontalHeight;
                            float f9 = (float) i17;
                            f5 = f7 + f9;
                            i7 = i17;
                            f4 = f8 - f9;
                        } else {
                            f5 = f7;
                            f4 = f8;
                            i7 = 0;
                        }
                        if (i5 == aVar.h - 1) {
                            if ((this.mShowDividerHorizontal & 4) > 0) {
                                i8 = this.mDividerHorizontalHeight;
                                if (z) {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    if (z2) {
                                        this.mFlexboxHelper.Q(reorderedChildAt, aVar, false, paddingLeft, Math.round(f4) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f4));
                                    } else {
                                        this.mFlexboxHelper.Q(reorderedChildAt, aVar, false, paddingLeft, Math.round(f5), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                    }
                                } else if (z2) {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.Q(reorderedChildAt, aVar, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f4) - reorderedChildAt.getMeasuredHeight(), i11, Math.round(f4));
                                } else {
                                    i6 = i5;
                                    layoutParams = layoutParams2;
                                    this.mFlexboxHelper.Q(reorderedChildAt, aVar, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f5), i11, Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                }
                                float measuredHeight = f5 + ((float) reorderedChildAt.getMeasuredHeight()) + max + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                                float measuredHeight2 = f4 - ((((float) reorderedChildAt.getMeasuredHeight()) + max) + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).topMargin));
                                if (!z2) {
                                    aVar.d(reorderedChildAt, 0, i8, 0, i7);
                                } else {
                                    aVar.d(reorderedChildAt, 0, i7, 0, i8);
                                }
                                f3 = measuredHeight;
                                f = measuredHeight2;
                            }
                        }
                        i8 = 0;
                        if (z) {
                        }
                        float measuredHeight3 = f5 + ((float) reorderedChildAt.getMeasuredHeight()) + max + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        float measuredHeight22 = f4 - ((((float) reorderedChildAt.getMeasuredHeight()) + max) + ((float) ((ViewGroup.MarginLayoutParams) layoutParams).topMargin));
                        if (!z2) {
                        }
                        f3 = measuredHeight3;
                        f = measuredHeight22;
                    }
                    i5 = i6 + 1;
                }
                int i18 = aVar.g;
                paddingLeft += i18;
                i11 -= i18;
            } else {
                int i19 = aVar.e;
                f = ((float) (i10 - paddingBottom)) - (((float) (i10 - i19)) / 2.0f);
                f3 = ((float) paddingTop) + (((float) (i10 - i19)) / 2.0f);
                f2 = 0.0f;
                float max2 = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < aVar.h) {
                }
                int i182 = aVar.g;
                paddingLeft += i182;
                i11 -= i182;
            }
            f = (float) i9;
            f2 = 0.0f;
            float max22 = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < aVar.h) {
            }
            int i1822 = aVar.g;
            paddingLeft += i1822;
            i11 -= i1822;
        }
    }

    private void measureHorizontal(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.a();
        this.mFlexboxHelper.c(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.a;
        this.mFlexboxHelper.p(i, i2);
        if (this.mAlignItems == 3) {
            for (a aVar : this.mFlexLines) {
                int i3 = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < aVar.h; i4++) {
                    View reorderedChildAt = getReorderedChildAt(aVar.o + i4);
                    if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        if (this.mFlexWrap != 2) {
                            i3 = Math.max(i3, reorderedChildAt.getMeasuredHeight() + Math.max(aVar.l - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        } else {
                            i3 = Math.max(i3, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((aVar.l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                        }
                    }
                }
                aVar.g = i3;
            }
        }
        this.mFlexboxHelper.o(i, i2, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.W();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.b);
    }

    private void measureVertical(int i, int i2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.a();
        this.mFlexboxHelper.f(this.mFlexLinesResult, i, i2);
        this.mFlexLines = this.mFlexLinesResult.a;
        this.mFlexboxHelper.p(i, i2);
        this.mFlexboxHelper.o(i, i2, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.W();
        setMeasuredDimensionForFlex(this.mFlexDirection, i, i2, this.mFlexLinesResult.b);
    }

    private void setMeasuredDimensionForFlex(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            i5 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            i6 = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            i5 = getLargestMainSize();
            i6 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + i);
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i6) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = i6;
            }
            i7 = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            i7 = View.resolveSizeAndState(i6, i2, i4);
        } else if (mode == 1073741824) {
            if (size < i6) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            i7 = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i5) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = i5;
            }
            i8 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            i8 = View.resolveSizeAndState(i5, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < i5) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            i8 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(i7, i8);
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.n(view, i, layoutParams, this.mOrderCache);
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.mAlignContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int i3;
        int i4 = 0;
        if (isMainAxisDirectionHorizontal()) {
            if (hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
                i4 = 0 + this.mDividerVerticalWidth;
            }
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i4;
            }
            i3 = this.mDividerVerticalWidth;
        } else {
            if (hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
                i4 = 0 + this.mDividerHorizontalHeight;
            }
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i4;
            }
            i3 = this.mDividerHorizontalHeight;
        }
        return i4 + i3;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int i) {
        return getChildAt(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (a aVar : this.mFlexLines) {
            if (aVar.c() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<a> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        for (a aVar : this.mFlexLines) {
            i = Math.max(i, aVar.e);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    public View getReorderedChildAt(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int i) {
        return getReorderedChildAt(i);
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.mFlexLines.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = this.mFlexLines.get(i4);
            if (hasDividerBeforeFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i2 = this.mDividerHorizontalHeight;
                } else {
                    i2 = this.mDividerVerticalWidth;
                }
                i3 += i2;
            }
            if (hasEndDividerAfterFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i = this.mDividerHorizontalHeight;
                } else {
                    i = this.mDividerVerticalWidth;
                }
                i3 += i;
            }
            i3 += aVar.g;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical != null || this.mDividerDrawableHorizontal != null) {
            if (this.mShowDividerHorizontal != 0 || this.mShowDividerVertical != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int i = this.mFlexDirection;
                boolean z = false;
                boolean z2 = true;
                if (i == 0) {
                    boolean z3 = layoutDirection == 1;
                    if (this.mFlexWrap == 2) {
                        z = true;
                    }
                    drawDividersHorizontal(canvas, z3, z);
                } else if (i == 1) {
                    boolean z4 = layoutDirection != 1;
                    if (this.mFlexWrap == 2) {
                        z = true;
                    }
                    drawDividersHorizontal(canvas, z4, z);
                } else if (i == 2) {
                    if (layoutDirection != 1) {
                        z2 = false;
                    }
                    if (this.mFlexWrap == 2) {
                        z2 = !z2;
                    }
                    drawDividersVertical(canvas, z2, false);
                } else if (i == 3) {
                    if (layoutDirection == 1) {
                        z = true;
                    }
                    if (this.mFlexWrap == 2) {
                        z = !z;
                    }
                    drawDividersVertical(canvas, z, true);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i5 = this.mFlexDirection;
        boolean z2 = false;
        if (i5 == 0) {
            layoutHorizontal(layoutDirection == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            layoutHorizontal(layoutDirection != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.N(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.m(this.mOrderCache);
        }
        int i3 = this.mFlexDirection;
        if (i3 == 0 || i3 == 1) {
            measureHorizontal(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            measureVertical(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int i, int i2, a aVar) {
        if (!hasDividerBeforeChildAtAlongMainAxis(i, i2)) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            int i3 = aVar.e;
            int i4 = this.mDividerVerticalWidth;
            aVar.e = i3 + i4;
            aVar.f += i4;
            return;
        }
        int i5 = aVar.e;
        int i6 = this.mDividerHorizontalHeight;
        aVar.e = i5 + i6;
        aVar.f += i6;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(a aVar) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i = aVar.e;
                int i2 = this.mDividerVerticalWidth;
                aVar.e = i + i2;
                aVar.f += i2;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            int i3 = aVar.e;
            int i4 = this.mDividerHorizontalHeight;
            aVar.e = i3 + i4;
            aVar.f += i4;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int i) {
        if (this.mAlignContent != i) {
            this.mAlignContent = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int i) {
        if (this.mAlignItems != i) {
            this.mAlignItems = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable != this.mDividerDrawableHorizontal) {
            this.mDividerDrawableHorizontal = drawable;
            if (drawable != null) {
                this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHorizontalHeight = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable != this.mDividerDrawableVertical) {
            this.mDividerDrawableVertical = drawable;
            if (drawable != null) {
                this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
            } else {
                this.mDividerVerticalWidth = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int i) {
        if (this.mFlexDirection != i) {
            this.mFlexDirection = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<a> list) {
        this.mFlexLines = list;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int i) {
        if (this.mFlexWrap != i) {
            this.mFlexWrap = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int i) {
        if (this.mJustifyContent != i) {
            this.mJustifyContent = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int i) {
        if (this.mMaxLine != i) {
            this.mMaxLine = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.mShowDividerVertical) {
            this.mShowDividerVertical = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new b(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new b.C0153b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i, 0);
        this.mFlexDirection = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 4);
        this.mAlignContent = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 5);
        this.mMaxLine = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.mShowDividerVertical = i2;
            this.mShowDividerHorizontal = i2;
        }
        int i3 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.mShowDividerVertical = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.mShowDividerHorizontal = i4;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* compiled from: Taobao */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder = 1;
        private boolean mWrapBefore;

        /* compiled from: Taobao */
        static class a implements Parcelable.Creator<LayoutParams> {
            a() {
            }

            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* renamed from: b */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i) {
            ((ViewGroup.MarginLayoutParams) this).height = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i) {
            this.mOrder = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i) {
            ((ViewGroup.MarginLayoutParams) this).width = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = false;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0 ? true : z;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
