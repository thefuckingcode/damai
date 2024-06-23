package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* compiled from: Taobao */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = iArr;
            iArr[WidgetRun.RunType.START.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getWidth());
        }
        if (!this.dimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (parent2 = this.widget.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (parent = this.widget.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
                addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchorArr[0].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr[0]);
                        if (target != null) {
                            addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr[1].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr[1]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                            addTarget(this.start, this.end, -this.dimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = getTarget(this.widget.mListAnchors[0]);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target4 = getTarget(this.widget.mListAnchors[1]);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.widget;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency2 = parent3.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency3 = this.dimension;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        this.dimension.targets.add(verticalWidgetRun2.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.verticalRun.dimension;
                    dimensionDependency.targets.add(dimensionDependency4);
                    dimensionDependency4.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency5 = this.dimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    this.end.targets.add(this.dimension);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        if (constraintAnchorArr2[0].mTarget == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchorArr2[0].mTarget != null) {
                DependencyNode target5 = getTarget(constraintAnchorArr2[0]);
                if (target5 != null) {
                    addTarget(this.start, target5, this.widget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (constraintAnchorArr2[1].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr2[1]);
                if (target6 != null) {
                    addTarget(this.end, target6, -this.widget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
                addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                addTarget(this.end, this.start, 1, this.dimension);
            }
        } else if (constraintWidget4.isInHorizontalChain()) {
            this.start.margin = this.widget.mListAnchors[0].getMargin();
            this.end.margin = -this.widget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.widget.mListAnchors[1]);
            if (target7 != null) {
                target7.addDependency(this);
            }
            if (target8 != null) {
                target8.addDependency(this);
            }
            this.mRunType = WidgetRun.RunType.CENTER;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setX(dependencyNode.value);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02bb, code lost:
        if (r14 != 1) goto L_0x0323;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        float f;
        float f2;
        float f3;
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i2 == 1) {
            updateRunStart(dependency);
        } else if (i2 == 2) {
            updateRunEnd(dependency);
        } else if (i2 == 3) {
            ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(dependency, constraintWidget.mLeft, constraintWidget.mRight, 0);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.widget;
            int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
            if (i3 == 2) {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    DimensionDependency dimensionDependency = parent.horizontalRun.dimension;
                    if (dimensionDependency.resolved) {
                        this.dimension.resolve((int) ((((float) dimensionDependency.value) * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                int i4 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i4 == 0 || i4 == 3) {
                    VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                    DependencyNode dependencyNode = verticalWidgetRun.start;
                    DependencyNode dependencyNode2 = verticalWidgetRun.end;
                    boolean z = constraintWidget2.mLeft.mTarget != null;
                    boolean z2 = constraintWidget2.mTop.mTarget != null;
                    boolean z3 = constraintWidget2.mRight.mTarget != null;
                    boolean z4 = constraintWidget2.mBottom.mTarget != null;
                    int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                    if (z && z2 && z3 && z4) {
                        float dimensionRatio = this.widget.getDimensionRatio();
                        if (!dependencyNode.resolved || !dependencyNode2.resolved) {
                            DependencyNode dependencyNode3 = this.start;
                            if (dependencyNode3.resolved) {
                                DependencyNode dependencyNode4 = this.end;
                                if (dependencyNode4.resolved) {
                                    if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                        computeInsetRatio(tempDimensions, dependencyNode3.value + dependencyNode3.margin, dependencyNode4.value - dependencyNode4.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                        this.dimension.resolve(tempDimensions[0]);
                                        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            DependencyNode dependencyNode5 = this.start;
                            if (dependencyNode5.readyToSolve && this.end.readyToSolve && dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                computeInsetRatio(tempDimensions, dependencyNode5.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            } else {
                                return;
                            }
                        } else {
                            DependencyNode dependencyNode6 = this.start;
                            if (dependencyNode6.readyToSolve && this.end.readyToSolve) {
                                computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                return;
                            }
                            return;
                        }
                    } else if (!z || !z3) {
                        if (z2 && z4) {
                            if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                float dimensionRatio2 = this.widget.getDimensionRatio();
                                int i5 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                                int i6 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                                if (dimensionRatioSide != -1) {
                                    if (dimensionRatioSide == 0) {
                                        int limitedDimension = getLimitedDimension(i6 - i5, 1);
                                        int i7 = (int) ((((float) limitedDimension) * dimensionRatio2) + 0.5f);
                                        int limitedDimension2 = getLimitedDimension(i7, 0);
                                        if (i7 != limitedDimension2) {
                                            limitedDimension = (int) ((((float) limitedDimension2) / dimensionRatio2) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension2);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension);
                                    }
                                }
                                int limitedDimension3 = getLimitedDimension(i6 - i5, 1);
                                int i8 = (int) ((((float) limitedDimension3) / dimensionRatio2) + 0.5f);
                                int limitedDimension4 = getLimitedDimension(i8, 0);
                                if (i8 != limitedDimension4) {
                                    limitedDimension3 = (int) ((((float) limitedDimension4) * dimensionRatio2) + 0.5f);
                                }
                                this.dimension.resolve(limitedDimension4);
                                this.widget.verticalRun.dimension.resolve(limitedDimension3);
                            } else {
                                return;
                            }
                        }
                    } else if (this.start.readyToSolve && this.end.readyToSolve) {
                        float dimensionRatio3 = this.widget.getDimensionRatio();
                        int i9 = this.start.targets.get(0).value + this.start.margin;
                        int i10 = this.end.targets.get(0).value - this.end.margin;
                        if (dimensionRatioSide == -1 || dimensionRatioSide == 0) {
                            int limitedDimension5 = getLimitedDimension(i10 - i9, 0);
                            int i11 = (int) ((((float) limitedDimension5) * dimensionRatio3) + 0.5f);
                            int limitedDimension6 = getLimitedDimension(i11, 1);
                            if (i11 != limitedDimension6) {
                                limitedDimension5 = (int) ((((float) limitedDimension6) / dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension5);
                            this.widget.verticalRun.dimension.resolve(limitedDimension6);
                        } else if (dimensionRatioSide == 1) {
                            int limitedDimension7 = getLimitedDimension(i10 - i9, 0);
                            int i12 = (int) ((((float) limitedDimension7) / dimensionRatio3) + 0.5f);
                            int limitedDimension8 = getLimitedDimension(i12, 1);
                            if (i12 != limitedDimension8) {
                                limitedDimension7 = (int) ((((float) limitedDimension8) * dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension7);
                            this.widget.verticalRun.dimension.resolve(limitedDimension8);
                        }
                    } else {
                        return;
                    }
                } else {
                    int dimensionRatioSide2 = constraintWidget2.getDimensionRatioSide();
                    if (dimensionRatioSide2 == -1) {
                        ConstraintWidget constraintWidget3 = this.widget;
                        f2 = (float) constraintWidget3.verticalRun.dimension.value;
                        f3 = constraintWidget3.getDimensionRatio();
                    } else if (dimensionRatioSide2 == 0) {
                        ConstraintWidget constraintWidget4 = this.widget;
                        f = ((float) constraintWidget4.verticalRun.dimension.value) / constraintWidget4.getDimensionRatio();
                        i = (int) (f + 0.5f);
                        this.dimension.resolve(i);
                    } else if (dimensionRatioSide2 != 1) {
                        i = 0;
                        this.dimension.resolve(i);
                    } else {
                        ConstraintWidget constraintWidget5 = this.widget;
                        f2 = (float) constraintWidget5.verticalRun.dimension.value;
                        f3 = constraintWidget5.getDimensionRatio();
                    }
                    f = f2 * f3;
                    i = (int) (f + 0.5f);
                    this.dimension.resolve(i);
                }
            }
        }
        DependencyNode dependencyNode7 = this.start;
        if (dependencyNode7.readyToSolve) {
            DependencyNode dependencyNode8 = this.end;
            if (dependencyNode8.readyToSolve) {
                if (!dependencyNode7.resolved || !dependencyNode8.resolved || !this.dimension.resolved) {
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.widget;
                        if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInHorizontalChain()) {
                            int i13 = this.start.targets.get(0).value;
                            DependencyNode dependencyNode9 = this.start;
                            int i14 = i13 + dependencyNode9.margin;
                            int i15 = this.end.targets.get(0).value + this.end.margin;
                            dependencyNode9.resolve(i14);
                            this.end.resolve(i15);
                            this.dimension.resolve(i15 - i14);
                            return;
                        }
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                        ConstraintWidget constraintWidget7 = this.widget;
                        int i16 = constraintWidget7.mMatchConstraintMaxWidth;
                        int max = Math.max(constraintWidget7.mMatchConstraintMinWidth, min);
                        if (i16 > 0) {
                            max = Math.min(i16, max);
                        }
                        this.dimension.resolve(max);
                    }
                    if (this.dimension.resolved) {
                        DependencyNode dependencyNode10 = this.start.targets.get(0);
                        DependencyNode dependencyNode11 = this.end.targets.get(0);
                        int i17 = dependencyNode10.value + this.start.margin;
                        int i18 = dependencyNode11.value + this.end.margin;
                        float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                        if (dependencyNode10 == dependencyNode11) {
                            i17 = dependencyNode10.value;
                            i18 = dependencyNode11.value;
                            horizontalBiasPercent = 0.5f;
                        }
                        this.start.resolve((int) (((float) i17) + 0.5f + (((float) ((i18 - i17) - this.dimension.value)) * horizontalBiasPercent)));
                        this.end.resolve(this.start.value + this.dimension.value);
                    }
                }
            }
        }
    }
}
