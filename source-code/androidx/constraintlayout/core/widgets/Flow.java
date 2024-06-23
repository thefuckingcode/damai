package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount = 0;
    private float mFirstHorizontalBias = 0.5f;
    private int mFirstHorizontalStyle = -1;
    private float mFirstVerticalBias = 0.5f;
    private int mFirstVerticalStyle = -1;
    private int mHorizontalAlign = 2;
    private float mHorizontalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mHorizontalStyle = -1;
    private float mLastHorizontalBias = 0.5f;
    private int mLastHorizontalStyle = -1;
    private float mLastVerticalBias = 0.5f;
    private int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private int mVerticalAlign = 2;
    private float mVerticalBias = 0.5f;
    private int mVerticalGap = 0;
    private int mVerticalStyle = -1;
    private int mWrapMode = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class WidgetsList {
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private ConstraintAnchor mBottom;
        private int mCount = 0;
        private int mHeight = 0;
        private ConstraintAnchor mLeft;
        private int mMax = 0;
        private int mNbMatchConstraintsWidgets = 0;
        private int mOrientation = 0;
        private int mPaddingBottom = 0;
        private int mPaddingLeft = 0;
        private int mPaddingRight = 0;
        private int mPaddingTop = 0;
        private ConstraintAnchor mRight;
        private int mStartIndex = 0;
        private ConstraintAnchor mTop;
        private int mWidth = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i2;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i = this.mCount;
            int i2 = 0;
            while (i2 < i && this.mStartIndex + i2 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i3 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i3 = 0;
                    }
                    this.mWidth += width + i3;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i4 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mHeight += widgetHeight2 + i4;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
                i2++;
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                int i2 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = i2;
                }
                this.mWidth += widgetWidth + i;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                int i3 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = i3;
                }
                this.mHeight += widgetHeight2 + i;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
        public void createConstraints(boolean z, int i, boolean z2) {
            ConstraintWidget constraintWidget;
            int i2;
            float f;
            float f2;
            int i3 = this.mCount;
            int i4 = 0;
            while (i4 < i3 && this.mStartIndex + i4 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i4];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
                i4++;
            }
            if (!(i3 == 0 || this.biggest == null)) {
                boolean z3 = z2 && i == 0;
                int i5 = -1;
                int i6 = -1;
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = z ? (i3 - 1) - i7 : i7;
                    if (this.mStartIndex + i8 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    if (Flow.this.mDisplayedWidgets[this.mStartIndex + i8].getVisibility() == 0) {
                        if (i5 == -1) {
                            i5 = i7;
                        }
                        i6 = i7;
                    }
                }
                ConstraintWidget constraintWidget3 = null;
                if (this.mOrientation == 0) {
                    ConstraintWidget constraintWidget4 = this.biggest;
                    constraintWidget4.setVerticalChainStyle(Flow.this.mVerticalStyle);
                    int i9 = this.mPaddingTop;
                    if (i > 0) {
                        i9 += Flow.this.mVerticalGap;
                    }
                    constraintWidget4.mTop.connect(this.mTop, i9);
                    if (z2) {
                        constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                    }
                    if (i > 0) {
                        this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                    }
                    if (Flow.this.mVerticalAlign == 3 && !constraintWidget4.hasBaseline()) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= i3) {
                                break;
                            }
                            int i11 = z ? (i3 - 1) - i10 : i10;
                            if (this.mStartIndex + i11 >= Flow.this.mDisplayedWidgetsCount) {
                                break;
                            }
                            constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i11];
                            if (constraintWidget.hasBaseline()) {
                                break;
                            }
                            i10++;
                        }
                        i2 = 0;
                        while (i2 < i3) {
                            int i12 = z ? (i3 - 1) - i2 : i2;
                            if (this.mStartIndex + i12 < Flow.this.mDisplayedWidgetsCount) {
                                ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i12];
                                if (i2 == 0) {
                                    constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                                }
                                if (i12 == 0) {
                                    int i13 = Flow.this.mHorizontalStyle;
                                    float f3 = Flow.this.mHorizontalBias;
                                    if (z) {
                                        f3 = 1.0f - f3;
                                    }
                                    if (this.mStartIndex != 0 || Flow.this.mFirstHorizontalStyle == -1) {
                                        if (z2 && Flow.this.mLastHorizontalStyle != -1) {
                                            i13 = Flow.this.mLastHorizontalStyle;
                                            if (z) {
                                                f2 = Flow.this.mLastHorizontalBias;
                                            } else {
                                                f = Flow.this.mLastHorizontalBias;
                                                f3 = f;
                                            }
                                        }
                                        constraintWidget5.setHorizontalChainStyle(i13);
                                        constraintWidget5.setHorizontalBiasPercent(f3);
                                    } else {
                                        i13 = Flow.this.mFirstHorizontalStyle;
                                        if (z) {
                                            f2 = Flow.this.mFirstHorizontalBias;
                                        } else {
                                            f = Flow.this.mFirstHorizontalBias;
                                            f3 = f;
                                            constraintWidget5.setHorizontalChainStyle(i13);
                                            constraintWidget5.setHorizontalBiasPercent(f3);
                                        }
                                    }
                                    f = 1.0f - f2;
                                    f3 = f;
                                    constraintWidget5.setHorizontalChainStyle(i13);
                                    constraintWidget5.setHorizontalBiasPercent(f3);
                                }
                                if (i2 == i3 - 1) {
                                    constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                                }
                                if (constraintWidget3 != null) {
                                    constraintWidget5.mLeft.connect(constraintWidget3.mRight, Flow.this.mHorizontalGap);
                                    if (i2 == i5) {
                                        constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                                    }
                                    constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                                    if (i2 == i6 + 1) {
                                        constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                                    }
                                }
                                if (constraintWidget5 != constraintWidget4) {
                                    if (Flow.this.mVerticalAlign != 3 || !constraintWidget.hasBaseline() || constraintWidget5 == constraintWidget || !constraintWidget5.hasBaseline()) {
                                        int i14 = Flow.this.mVerticalAlign;
                                        if (i14 == 0) {
                                            constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                        } else if (i14 == 1) {
                                            constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                        } else if (z3) {
                                            constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                            constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                        } else {
                                            constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                            constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                        }
                                    } else {
                                        constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                                    }
                                }
                                i2++;
                                constraintWidget3 = constraintWidget5;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    constraintWidget = constraintWidget4;
                    i2 = 0;
                    while (i2 < i3) {
                    }
                    return;
                }
                ConstraintWidget constraintWidget6 = this.biggest;
                constraintWidget6.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i15 = this.mPaddingLeft;
                if (i > 0) {
                    i15 += Flow.this.mHorizontalGap;
                }
                if (z) {
                    constraintWidget6.mRight.connect(this.mRight, i15);
                    if (z2) {
                        constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                    }
                } else {
                    constraintWidget6.mLeft.connect(this.mLeft, i15);
                    if (z2) {
                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                    }
                }
                int i16 = 0;
                while (i16 < i3 && this.mStartIndex + i16 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                    if (i16 == 0) {
                        constraintWidget7.connect(constraintWidget7.mTop, this.mTop, this.mPaddingTop);
                        int i17 = Flow.this.mVerticalStyle;
                        float f4 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            i17 = Flow.this.mFirstVerticalStyle;
                            f4 = Flow.this.mFirstVerticalBias;
                        } else if (z2 && Flow.this.mLastVerticalStyle != -1) {
                            i17 = Flow.this.mLastVerticalStyle;
                            f4 = Flow.this.mLastVerticalBias;
                        }
                        constraintWidget7.setVerticalChainStyle(i17);
                        constraintWidget7.setVerticalBiasPercent(f4);
                    }
                    if (i16 == i3 - 1) {
                        constraintWidget7.connect(constraintWidget7.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget7.mTop.connect(constraintWidget3.mBottom, Flow.this.mVerticalGap);
                        if (i16 == i5) {
                            constraintWidget7.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                        if (i16 == i6 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget7 != constraintWidget6) {
                        if (z) {
                            int i18 = Flow.this.mHorizontalAlign;
                            if (i18 == 0) {
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            } else if (i18 == 1) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            } else if (i18 == 2) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            }
                        } else {
                            int i19 = Flow.this.mHorizontalAlign;
                            if (i19 == 0) {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            } else if (i19 == 1) {
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            } else if (i19 == 2) {
                                if (z3) {
                                    constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                }
                            }
                            i16++;
                            constraintWidget3 = constraintWidget7;
                        }
                    }
                    i16++;
                    constraintWidget3 = constraintWidget7;
                }
            }
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            int i2 = this.mNbMatchConstraintsWidgets;
            if (i2 != 0) {
                int i3 = this.mCount;
                int i4 = i / i2;
                int i5 = 0;
                while (i5 < i3 && this.mStartIndex + i5 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i5];
                    if (this.mOrientation == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                    }
                    i5++;
                }
                recomputeDimensions();
            }
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        float f;
        int i;
        if (!(this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null)) {
            for (int i2 = 0; i2 < this.mDisplayedWidgetsCount; i2++) {
                this.mDisplayedWidgets[i2].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i3 = iArr[0];
            int i4 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            float f2 = this.mHorizontalBias;
            int i5 = 0;
            while (i5 < i3) {
                if (z) {
                    i = (i3 - i5) - 1;
                    f = 1.0f - this.mHorizontalBias;
                } else {
                    f = f2;
                    i = i5;
                }
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i];
                if (!(constraintWidget3 == null || constraintWidget3.getVisibility() == 8)) {
                    if (i5 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(f);
                    }
                    if (i5 == i3 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i5 > 0 && constraintWidget2 != null) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i5++;
                f2 = f;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i6];
                if (!(constraintWidget4 == null || constraintWidget4.getVisibility() == 8)) {
                    if (i6 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i6 == i4 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i6 > 0 && constraintWidget2 != null) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i7 = 0; i7 < i3; i7++) {
                for (int i8 = 0; i8 < i4; i8++) {
                    int i9 = (i8 * i3) + i7;
                    if (this.mOrientation == 1) {
                        i9 = (i7 * i4) + i8;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                    if (!(i9 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i9]) == null || constraintWidget.getVisibility() == 8)) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i7];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i8];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i));
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i));
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x012b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        ConstraintAnchor constraintAnchor;
        int i5;
        int i6;
        int i7;
        ConstraintAnchor constraintAnchor2;
        int i8;
        int i9;
        if (i != 0) {
            this.mChainList.clear();
            WidgetsList widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.mChainList.add(widgetsList);
            if (i2 == 0) {
                i4 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i11 < i) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i11];
                    int widgetWidth = getWidgetWidth(constraintWidget, i3);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    boolean z = (i10 == i3 || (this.mHorizontalGap + i10) + widgetWidth > i3) && widgetsList.biggest != null;
                    if (!z && i11 > 0 && (i9 = this.mMaxElementsWrap) > 0 && i11 % i9 == 0) {
                        z = true;
                    }
                    if (z) {
                        widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                        widgetsList.setStartIndex(i11);
                        this.mChainList.add(widgetsList);
                    } else if (i11 > 0) {
                        i10 += this.mHorizontalGap + widgetWidth;
                        widgetsList.add(constraintWidget);
                        i11++;
                        i4 = i4;
                    }
                    i10 = widgetWidth;
                    widgetsList.add(constraintWidget);
                    i11++;
                    i4 = i4;
                }
            } else {
                i4 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i13 < i) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                    int widgetHeight = getWidgetHeight(constraintWidget2, i3);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    boolean z2 = (i12 == i3 || (this.mVerticalGap + i12) + widgetHeight > i3) && widgetsList.biggest != null;
                    if (!z2 && i13 > 0 && (i8 = this.mMaxElementsWrap) > 0 && i13 % i8 == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                        widgetsList.setStartIndex(i13);
                        this.mChainList.add(widgetsList);
                    } else if (i13 > 0) {
                        i12 += this.mVerticalGap + widgetHeight;
                        widgetsList.add(constraintWidget2);
                        i13++;
                        i4 = i4;
                    }
                    i12 = widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i13++;
                    i4 = i4;
                }
            }
            int size = this.mChainList.size();
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            ConstraintAnchor constraintAnchor5 = this.mRight;
            ConstraintAnchor constraintAnchor6 = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
            if (i4 > 0 && z3) {
                for (int i14 = 0; i14 < size; i14++) {
                    WidgetsList widgetsList2 = this.mChainList.get(i14);
                    if (i2 == 0) {
                        widgetsList2.measureMatchConstraints(i3 - widgetsList2.getWidth());
                    } else {
                        widgetsList2.measureMatchConstraints(i3 - widgetsList2.getHeight());
                    }
                }
            }
            int i15 = paddingTop;
            int i16 = paddingRight;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i21 = paddingBottom;
            while (i19 < size) {
                WidgetsList widgetsList3 = this.mChainList.get(i19);
                if (i2 == 0) {
                    if (i19 < size - 1) {
                        constraintAnchor2 = this.mChainList.get(i19 + 1).biggest.mTop;
                        i7 = 0;
                    } else {
                        constraintAnchor2 = this.mBottom;
                        i7 = getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                    i5 = i19;
                    widgetsList3.setup(i2, constraintAnchor8, constraintAnchor7, constraintAnchor5, constraintAnchor2, i20, i15, i16, i7, i3);
                    int max = Math.max(i18, widgetsList3.getWidth());
                    i17 += widgetsList3.getHeight();
                    if (i5 > 0) {
                        i17 += this.mVerticalGap;
                    }
                    constraintAnchor8 = constraintAnchor8;
                    i18 = max;
                    constraintAnchor7 = constraintAnchor9;
                    i15 = 0;
                    constraintAnchor = constraintAnchor5;
                    constraintAnchor6 = constraintAnchor2;
                    i21 = i7;
                } else {
                    i5 = i19;
                    if (i5 < size - 1) {
                        constraintAnchor = this.mChainList.get(i5 + 1).biggest.mLeft;
                        i6 = 0;
                    } else {
                        constraintAnchor = this.mRight;
                        i6 = getPaddingRight();
                    }
                    ConstraintAnchor constraintAnchor10 = widgetsList3.biggest.mRight;
                    widgetsList3.setup(i2, constraintAnchor8, constraintAnchor7, constraintAnchor, constraintAnchor6, i20, i15, i6, i21, i3);
                    i18 += widgetsList3.getWidth();
                    int max2 = Math.max(i17, widgetsList3.getHeight());
                    if (i5 > 0) {
                        i18 += this.mHorizontalGap;
                    }
                    i17 = max2;
                    i16 = i6;
                    constraintAnchor8 = constraintAnchor10;
                    i20 = 0;
                }
                i19 = i5 + 1;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i18;
            iArr[1] = i17;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        if (i != 0) {
            if (this.mChainList.size() == 0) {
                widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                this.mChainList.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = this.mChainList.get(0);
                widgetsList2.clear();
                widgetsList = widgetsList2;
                widgetsList.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
            }
            for (int i4 = 0; i4 < i; i4++) {
                widgetsList.add(constraintWidgetArr[i4]);
            }
            iArr[0] = widgetsList.getWidth();
            iArr[1] = widgetsList.getHeight();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean z2 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(z2, i2, i2 == size + -1);
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(z2);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z2, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.HelperWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0104  */
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        boolean z;
        char c;
        if (this.mWidgetsCount <= 0 || measureChildren()) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int[] iArr2 = new int[2];
            int i7 = (i2 - paddingLeft) - paddingRight;
            int i8 = this.mOrientation;
            if (i8 == 1) {
                i7 = (i4 - paddingTop) - paddingBottom;
            }
            if (i8 == 0) {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            } else {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            }
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                i5 = this.mWidgetsCount;
                if (i9 >= i5) {
                    break;
                }
                if (this.mWidgets[i9].getVisibility() == 8) {
                    i10++;
                }
                i9++;
            }
            if (i10 > 0) {
                constraintWidgetArr = new ConstraintWidget[(i5 - i10)];
                int i11 = 0;
                for (int i12 = 0; i12 < this.mWidgetsCount; i12++) {
                    ConstraintWidget constraintWidget = this.mWidgets[i12];
                    if (constraintWidget.getVisibility() != 8) {
                        constraintWidgetArr[i11] = constraintWidget;
                        i11++;
                    }
                }
                i6 = i11;
            } else {
                i6 = i5;
            }
            this.mDisplayedWidgets = constraintWidgetArr;
            this.mDisplayedWidgetsCount = i6;
            int i13 = this.mWrapMode;
            if (i13 == 0) {
                iArr = iArr2;
                z = true;
                measureNoWrap(constraintWidgetArr, i6, this.mOrientation, i7, iArr2);
            } else if (i13 == 1) {
                iArr = iArr2;
                z = true;
                measureChainWrap(constraintWidgetArr, i6, this.mOrientation, i7, iArr2);
            } else if (i13 != 2) {
                iArr = iArr2;
                c = 0;
                z = true;
                int i14 = iArr[c] + paddingLeft + paddingRight;
                char c2 = z ? 1 : 0;
                char c3 = z ? 1 : 0;
                char c4 = z ? 1 : 0;
                char c5 = z ? 1 : 0;
                char c6 = z ? 1 : 0;
                char c7 = z ? 1 : 0;
                char c8 = z ? 1 : 0;
                int i15 = iArr[c2] + paddingTop + paddingBottom;
                if (i != 1073741824) {
                    i14 = i2;
                } else if (i == Integer.MIN_VALUE) {
                    i14 = Math.min(i14, i2);
                } else if (i != 0) {
                    i14 = 0;
                }
                if (i3 != 1073741824) {
                    i15 = i4;
                } else if (i3 == Integer.MIN_VALUE) {
                    i15 = Math.min(i15, i4);
                } else if (i3 != 0) {
                    i15 = 0;
                }
                setMeasure(i14, i15);
                setWidth(i14);
                setHeight(i15);
                if (this.mWidgetsCount <= 0) {
                    z = false;
                }
                needsCallbackFromSolver(z);
                return;
            } else {
                z = true;
                iArr = iArr2;
                measureAligned(constraintWidgetArr, i6, this.mOrientation, i7, iArr2);
            }
            c = 0;
            int i142 = iArr[c] + paddingLeft + paddingRight;
            char c22 = z ? 1 : 0;
            char c32 = z ? 1 : 0;
            char c42 = z ? 1 : 0;
            char c52 = z ? 1 : 0;
            char c62 = z ? 1 : 0;
            char c72 = z ? 1 : 0;
            char c82 = z ? 1 : 0;
            int i152 = iArr[c22] + paddingTop + paddingBottom;
            if (i != 1073741824) {
            }
            if (i3 != 1073741824) {
            }
            setMeasure(i142, i152);
            setWidth(i142);
            setHeight(i152);
            if (this.mWidgetsCount <= 0) {
            }
            needsCallbackFromSolver(z);
            return;
        }
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
