package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
import tb.jl1;

/* compiled from: Taobao */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget = this.widget;
        ConstraintWidget previousChainMember = constraintWidget.getPreviousChainMember(this.orientation);
        while (true) {
            constraintWidget = previousChainMember;
            if (constraintWidget == null) {
                break;
            }
            previousChainMember = constraintWidget.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i = this.orientation;
            if (i == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = j + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            sb.append(jl1.L);
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e8  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        boolean z;
        int i7;
        int i8;
        float f2;
        int i9;
        int i10;
        boolean z2;
        float f3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean isRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i18 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i19 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i19 >= size) {
                    i19 = -1;
                    break;
                }
                if (this.widgets.get(i19).widget.getVisibility() != 8) {
                    break;
                }
                i19++;
            }
            int i20 = size - 1;
            int i21 = i20;
            while (true) {
                if (i21 < 0) {
                    break;
                }
                if (this.widgets.get(i21).widget.getVisibility() != 8) {
                    i = i21;
                    break;
                }
                i21--;
            }
            int i22 = 0;
            while (true) {
                if (i22 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i23 = 0;
                i4 = 0;
                i5 = 0;
                i15 = 0;
                f = 0.0f;
                while (i23 < size) {
                    WidgetRun widgetRun = this.widgets.get(i23);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i15++;
                        if (i23 > 0 && i23 >= i19) {
                            i4 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i24 = dimensionDependency.value;
                        boolean z3 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z3) {
                            int i25 = this.orientation;
                            if (i25 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i25 != 1 || widgetRun.widget.verticalRun.dimension.resolved) {
                                i17 = i24;
                            } else {
                                return;
                            }
                        } else {
                            i17 = i24;
                            if (widgetRun.matchConstraintsType == 1 && i22 == 0) {
                                i16 = dimensionDependency.wrapValue;
                                i5++;
                            } else if (dimensionDependency.resolved) {
                                i16 = i17;
                            }
                            z3 = true;
                            if (z3) {
                                i5++;
                                float f4 = widgetRun.widget.mWeight[this.orientation];
                                if (f4 >= 0.0f) {
                                    f += f4;
                                }
                            } else {
                                i4 += i16;
                            }
                            if (i23 < i20 && i23 < i) {
                                i4 += -widgetRun.end.margin;
                            }
                        }
                        i16 = i17;
                        if (z3) {
                        }
                        i4 += -widgetRun.end.margin;
                    }
                    i23++;
                    i2 = 8;
                }
                if (i4 < i18 || i5 == 0) {
                    i3 = i15;
                } else {
                    i22++;
                    i2 = 8;
                }
            }
            i3 = i15;
            int i26 = this.start.value;
            if (isRtl) {
                i26 = this.end.value;
            }
            if (i4 > i18) {
                i26 = isRtl ? i26 + ((int) ((((float) (i4 - i18)) / 2.0f) + 0.5f)) : i26 - ((int) ((((float) (i4 - i18)) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f5 = (float) (i18 - i4);
                int i27 = (int) ((f5 / ((float) i5)) + 0.5f);
                int i28 = 0;
                int i29 = 0;
                while (i28 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i28);
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (!dimensionDependency2.resolved) {
                            if (f > 0.0f) {
                                i11 = i26;
                                i12 = (int) (((widgetRun2.widget.mWeight[this.orientation] * f5) / f) + 0.5f);
                            } else {
                                i11 = i26;
                                i12 = i27;
                            }
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                f3 = f5;
                                i14 = constraintWidget.mMatchConstraintMaxWidth;
                                i13 = constraintWidget.mMatchConstraintMinWidth;
                                z2 = isRtl;
                            } else {
                                f3 = f5;
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i30 = constraintWidget2.mMatchConstraintMaxHeight;
                                z2 = isRtl;
                                i13 = constraintWidget2.mMatchConstraintMinHeight;
                                i14 = i30;
                            }
                            i10 = i3;
                            int max = Math.max(i13, widgetRun2.matchConstraintsType == 1 ? Math.min(i12, dimensionDependency2.wrapValue) : i12);
                            if (i14 > 0) {
                                max = Math.min(i14, max);
                            }
                            if (max != i12) {
                                i29++;
                                i12 = max;
                            }
                            widgetRun2.dimension.resolve(i12);
                            i28++;
                            i27 = i27;
                            i4 = i4;
                            i26 = i11;
                            f5 = f3;
                            isRtl = z2;
                            i3 = i10;
                        }
                    }
                    z2 = isRtl;
                    i10 = i3;
                    i11 = i26;
                    f3 = f5;
                    i28++;
                    i27 = i27;
                    i4 = i4;
                    i26 = i11;
                    f5 = f3;
                    isRtl = z2;
                    i3 = i10;
                }
                z = isRtl;
                i6 = i3;
                i7 = i26;
                if (i29 > 0) {
                    i5 -= i29;
                    int i31 = 0;
                    for (int i32 = 0; i32 < size; i32++) {
                        WidgetRun widgetRun3 = this.widgets.get(i32);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i32 > 0 && i32 >= i19) {
                                i31 += widgetRun3.start.margin;
                            }
                            i31 += widgetRun3.dimension.value;
                            if (i32 < i20 && i32 < i) {
                                i31 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i31;
                } else {
                    i4 = i4;
                }
                i8 = 2;
                if (this.chainStyle == 2 && i29 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                z = isRtl;
                i6 = i3;
                i7 = i26;
                i8 = 2;
            }
            if (i4 > i18) {
                this.chainStyle = i8;
            }
            if (i6 > 0 && i5 == 0 && i19 == i) {
                this.chainStyle = i8;
            }
            int i33 = this.chainStyle;
            if (i33 == 1) {
                if (i6 > 1) {
                    i9 = (i18 - i4) / (i6 - 1);
                } else {
                    i9 = i6 == 1 ? (i18 - i4) / 2 : 0;
                }
                if (i5 > 0) {
                    i9 = 0;
                }
                int i34 = i7;
                for (int i35 = 0; i35 < size; i35++) {
                    WidgetRun widgetRun4 = this.widgets.get(z ? size - (i35 + 1) : i35);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i34);
                        widgetRun4.end.resolve(i34);
                    } else {
                        if (i35 > 0) {
                            i34 = z ? i34 - i9 : i34 + i9;
                        }
                        if (i35 > 0 && i35 >= i19) {
                            if (z) {
                                i34 -= widgetRun4.start.margin;
                            } else {
                                i34 += widgetRun4.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun4.end.resolve(i34);
                        } else {
                            widgetRun4.start.resolve(i34);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i36 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i36 = dimensionDependency3.wrapValue;
                        }
                        i34 = z ? i34 - i36 : i34 + i36;
                        if (z) {
                            widgetRun4.start.resolve(i34);
                        } else {
                            widgetRun4.end.resolve(i34);
                        }
                        widgetRun4.resolved = true;
                        if (i35 < i20 && i35 < i) {
                            i34 = z ? i34 - (-widgetRun4.end.margin) : i34 + (-widgetRun4.end.margin);
                        }
                    }
                }
            } else if (i33 == 0) {
                int i37 = (i18 - i4) / (i6 + 1);
                if (i5 > 0) {
                    i37 = 0;
                }
                int i38 = i7;
                for (int i39 = 0; i39 < size; i39++) {
                    WidgetRun widgetRun5 = this.widgets.get(z ? size - (i39 + 1) : i39);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i38);
                        widgetRun5.end.resolve(i38);
                    } else {
                        int i40 = z ? i38 - i37 : i38 + i37;
                        if (i39 > 0 && i39 >= i19) {
                            i40 = z ? i40 - widgetRun5.start.margin : i40 + widgetRun5.start.margin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i40);
                        } else {
                            widgetRun5.start.resolve(i40);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int i41 = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i41 = Math.min(i41, dimensionDependency4.wrapValue);
                        }
                        i38 = z ? i40 - i41 : i40 + i41;
                        if (z) {
                            widgetRun5.start.resolve(i38);
                        } else {
                            widgetRun5.end.resolve(i38);
                        }
                        if (i39 < i20 && i39 < i) {
                            i38 = z ? i38 - (-widgetRun5.end.margin) : i38 + (-widgetRun5.end.margin);
                        }
                    }
                }
            } else if (i33 == 2) {
                if (this.orientation == 0) {
                    f2 = this.widget.getHorizontalBiasPercent();
                } else {
                    f2 = this.widget.getVerticalBiasPercent();
                }
                if (z) {
                    f2 = 1.0f - f2;
                }
                int i42 = (int) ((((float) (i18 - i4)) * f2) + 0.5f);
                if (i42 < 0 || i5 > 0) {
                    i42 = 0;
                }
                int i43 = z ? i7 - i42 : i7 + i42;
                for (int i44 = 0; i44 < size; i44++) {
                    WidgetRun widgetRun6 = this.widgets.get(z ? size - (i44 + 1) : i44);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i43);
                        widgetRun6.end.resolve(i43);
                    } else {
                        if (i44 > 0 && i44 >= i19) {
                            if (z) {
                                i43 -= widgetRun6.start.margin;
                            } else {
                                i43 += widgetRun6.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun6.end.resolve(i43);
                        } else {
                            widgetRun6.start.resolve(i43);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i45 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            if (widgetRun6.matchConstraintsType == 1) {
                                i45 = dimensionDependency5.wrapValue;
                            }
                        }
                        i43 = z ? i43 - i45 : i43 + i45;
                        if (z) {
                            widgetRun6.start.resolve(i43);
                        } else {
                            widgetRun6.end.resolve(i43);
                        }
                        if (i44 < i20 && i44 < i) {
                            i43 = z ? i43 - (-widgetRun6.end.margin) : i43 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }
}
