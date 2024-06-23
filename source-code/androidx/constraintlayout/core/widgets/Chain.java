package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Taobao */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = i4;
            i2 = 2;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r8 == 2) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r8 == 2) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x026d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02c8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04a8  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x04f0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x052d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x03b2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:330:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget3;
        int i4;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        ConstraintWidget constraintWidget7;
        ConstraintWidget constraintWidget8;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor5;
        float f;
        int size;
        int i5;
        ArrayList<ConstraintWidget> arrayList;
        int i6;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget9;
        ConstraintWidget constraintWidget10;
        int i7;
        int i8 = i;
        ConstraintWidget constraintWidget11 = chainHead.mFirst;
        ConstraintWidget constraintWidget12 = chainHead.mLast;
        ConstraintWidget constraintWidget13 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget14 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget15 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i8] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i8 == 0) {
            int i9 = constraintWidget15.mHorizontalChainStyle;
            z2 = i9 == 0;
            z = i9 == 1;
        } else {
            int i10 = constraintWidget15.mVerticalChainStyle;
            z2 = i10 == 0;
            z = i10 == 1;
        }
        boolean z6 = true;
        ConstraintWidget constraintWidget16 = constraintWidget11;
        boolean z7 = false;
        while (true) {
            constraintWidget = null;
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget16.mListAnchors[i2];
            int i11 = z6 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget16.mListDimensionBehaviors[i8];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && constraintWidget16.mResolvedMatchConstraintDefault[i8] == 0) {
                z3 = z2;
                z4 = true;
            } else {
                z3 = z2;
                z4 = false;
            }
            ConstraintAnchor constraintAnchor7 = constraintAnchor6.mTarget;
            if (!(constraintAnchor7 == null || constraintWidget16 == constraintWidget11)) {
                margin += constraintAnchor7.getMargin();
            }
            if (!z6 || constraintWidget16 == constraintWidget11 || constraintWidget16 == constraintWidget13) {
                constraintWidget9 = constraintWidget15;
            } else {
                constraintWidget9 = constraintWidget15;
                i11 = 8;
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor6.mTarget;
            if (constraintAnchor8 != null) {
                if (constraintWidget16 == constraintWidget13) {
                    constraintWidget10 = constraintWidget11;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, margin, 6);
                } else {
                    constraintWidget10 = constraintWidget11;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, margin, 8);
                }
                if (z4 && !z6) {
                    i11 = 5;
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, (constraintWidget16 != constraintWidget13 || !z6 || !constraintWidget16.isInBarrier(i8)) ? i11 : 5);
            } else {
                constraintWidget10 = constraintWidget11;
            }
            if (z5) {
                if (constraintWidget16.getVisibility() == 8 || constraintWidget16.mListDimensionBehaviors[i8] != dimensionBehaviour2) {
                    i7 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget16.mListAnchors;
                    i7 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget16.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i7, 8);
            }
            ConstraintAnchor constraintAnchor9 = constraintWidget16.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor9 != null) {
                ConstraintWidget constraintWidget17 = constraintAnchor9.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget17.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == constraintWidget16) {
                    constraintWidget = constraintWidget17;
                }
            }
            if (constraintWidget != null) {
                constraintWidget16 = constraintWidget;
                z7 = z7;
            } else {
                z7 = true;
            }
            constraintWidget15 = constraintWidget9;
            f2 = f2;
            z2 = z3;
            constraintWidget11 = constraintWidget10;
        }
        if (constraintWidget14 != null) {
            int i12 = i2 + 1;
            if (constraintWidget12.mListAnchors[i12].mTarget != null) {
                ConstraintAnchor constraintAnchor10 = constraintWidget14.mListAnchors[i12];
                if ((constraintWidget14.mListDimensionBehaviors[i8] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget14.mResolvedMatchConstraintDefault[i8] == 0) && !z6) {
                    ConstraintAnchor constraintAnchor11 = constraintAnchor10.mTarget;
                    if (constraintAnchor11.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor10.mSolverVariable, constraintAnchor11.mSolverVariable, -constraintAnchor10.getMargin(), 5);
                        linearSystem.addLowerThan(constraintAnchor10.mSolverVariable, constraintWidget12.mListAnchors[i12].mTarget.mSolverVariable, -constraintAnchor10.getMargin(), 6);
                        if (z5) {
                            int i13 = i2 + 1;
                            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i13].mSolverVariable;
                            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget12.mListAnchors;
                            linearSystem.addGreaterThan(solverVariable5, constraintAnchorArr3[i13].mSolverVariable, constraintAnchorArr3[i13].getMargin(), 8);
                        }
                        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
                        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                            float f3 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f2 : (float) chainHead.mWidgetsMatchCount;
                            float f4 = 0.0f;
                            ConstraintWidget constraintWidget18 = null;
                            i5 = 0;
                            float f5 = 0.0f;
                            while (i5 < size) {
                                ConstraintWidget constraintWidget19 = arrayList2.get(i5);
                                float f6 = constraintWidget19.mWeight[i8];
                                if (f6 < f4) {
                                    if (chainHead.mHasComplexMatchWeights) {
                                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget19.mListAnchors;
                                        linearSystem.addEquality(constraintAnchorArr4[i2 + 1].mSolverVariable, constraintAnchorArr4[i2].mSolverVariable, 0, 4);
                                        arrayList = arrayList2;
                                        i6 = size;
                                        i5++;
                                        size = i6;
                                        arrayList2 = arrayList;
                                        f4 = 0.0f;
                                    } else {
                                        f6 = 1.0f;
                                        f4 = 0.0f;
                                    }
                                }
                                if (f6 == f4) {
                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget19.mListAnchors;
                                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 8);
                                    arrayList = arrayList2;
                                    i6 = size;
                                    i5++;
                                    size = i6;
                                    arrayList2 = arrayList;
                                    f4 = 0.0f;
                                } else {
                                    if (constraintWidget18 != null) {
                                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget18.mListAnchors;
                                        SolverVariable solverVariable6 = constraintAnchorArr6[i2].mSolverVariable;
                                        int i14 = i2 + 1;
                                        SolverVariable solverVariable7 = constraintAnchorArr6[i14].mSolverVariable;
                                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget19.mListAnchors;
                                        arrayList = arrayList2;
                                        SolverVariable solverVariable8 = constraintAnchorArr7[i2].mSolverVariable;
                                        SolverVariable solverVariable9 = constraintAnchorArr7[i14].mSolverVariable;
                                        i6 = size;
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualMatchDimensions(f5, f3, f6, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                                        linearSystem.addConstraint(createRow);
                                    } else {
                                        arrayList = arrayList2;
                                        i6 = size;
                                    }
                                    f5 = f6;
                                    constraintWidget18 = constraintWidget19;
                                    i5++;
                                    size = i6;
                                    arrayList2 = arrayList;
                                    f4 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget13 == null && (constraintWidget13 == constraintWidget14 || z6)) {
                            ConstraintAnchor constraintAnchor12 = constraintWidget11.mListAnchors[i2];
                            int i15 = i2 + 1;
                            ConstraintAnchor constraintAnchor13 = constraintWidget12.mListAnchors[i15];
                            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
                            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
                            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor16 = constraintWidget13.mListAnchors[i2];
                            if (constraintWidget14 != null) {
                                constraintAnchor13 = constraintWidget14.mListAnchors[i15];
                            }
                            if (!(solverVariable10 == null || solverVariable11 == null)) {
                                if (i8 == 0) {
                                    f = constraintWidget15.mHorizontalBiasPercent;
                                } else {
                                    f = constraintWidget15.mVerticalBiasPercent;
                                }
                                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable10, constraintAnchor16.getMargin(), f, solverVariable11, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 7);
                            }
                        } else if (z2 || constraintWidget13 == null) {
                            int i16 = 8;
                            if (z && constraintWidget13 != null) {
                                int i17 = chainHead.mWidgetsMatchCount;
                                boolean z8 = i17 <= 0 && chainHead.mWidgetsCount == i17;
                                ConstraintWidget constraintWidget20 = constraintWidget13;
                                constraintWidget2 = constraintWidget20;
                                while (constraintWidget2 != null) {
                                    ConstraintWidget constraintWidget21 = constraintWidget2.mNextChainWidget[i8];
                                    while (constraintWidget21 != null && constraintWidget21.getVisibility() == i16) {
                                        constraintWidget21 = constraintWidget21.mNextChainWidget[i8];
                                    }
                                    if (constraintWidget2 == constraintWidget13 || constraintWidget2 == constraintWidget14 || constraintWidget21 == null) {
                                        constraintWidget3 = constraintWidget20;
                                        i4 = 8;
                                    } else {
                                        ConstraintWidget constraintWidget22 = constraintWidget21 == constraintWidget14 ? null : constraintWidget21;
                                        ConstraintAnchor constraintAnchor17 = constraintWidget2.mListAnchors[i2];
                                        SolverVariable solverVariable12 = constraintAnchor17.mSolverVariable;
                                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                                        if (constraintAnchor18 != null) {
                                            SolverVariable solverVariable13 = constraintAnchor18.mSolverVariable;
                                        }
                                        int i18 = i2 + 1;
                                        SolverVariable solverVariable14 = constraintWidget20.mListAnchors[i18].mSolverVariable;
                                        int margin2 = constraintAnchor17.getMargin();
                                        int margin3 = constraintWidget2.mListAnchors[i18].getMargin();
                                        if (constraintWidget22 != null) {
                                            constraintAnchor4 = constraintWidget22.mListAnchors[i2];
                                            SolverVariable solverVariable15 = constraintAnchor4.mSolverVariable;
                                            constraintWidget4 = constraintWidget22;
                                            ConstraintAnchor constraintAnchor19 = constraintAnchor4.mTarget;
                                            solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                                            solverVariable3 = solverVariable15;
                                        } else {
                                            constraintWidget4 = constraintWidget22;
                                            constraintAnchor4 = constraintWidget14.mListAnchors[i2];
                                            solverVariable3 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                            solverVariable2 = constraintWidget2.mListAnchors[i18].mSolverVariable;
                                        }
                                        if (constraintAnchor4 != null) {
                                            margin3 += constraintAnchor4.getMargin();
                                        }
                                        int margin4 = constraintWidget20.mListAnchors[i18].getMargin() + margin2;
                                        int i19 = z8 ? 8 : 4;
                                        if (solverVariable12 == null || solverVariable14 == null || solverVariable3 == null || solverVariable2 == null) {
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget3 = constraintWidget20;
                                            i4 = 8;
                                        } else {
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget3 = constraintWidget20;
                                            i4 = 8;
                                            linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable3, solverVariable2, margin3, i19);
                                        }
                                        constraintWidget21 = constraintWidget5;
                                    }
                                    constraintWidget20 = constraintWidget2.getVisibility() != i4 ? constraintWidget2 : constraintWidget3;
                                    i8 = i;
                                    constraintWidget2 = constraintWidget21;
                                    i16 = 8;
                                }
                                ConstraintAnchor constraintAnchor20 = constraintWidget13.mListAnchors[i2];
                                constraintAnchor = constraintWidget11.mListAnchors[i2].mTarget;
                                int i20 = i2 + 1;
                                constraintAnchor2 = constraintWidget14.mListAnchors[i20];
                                constraintAnchor3 = constraintWidget12.mListAnchors[i20].mTarget;
                                if (constraintAnchor == null) {
                                    i3 = 5;
                                } else if (constraintWidget13 != constraintWidget14) {
                                    i3 = 5;
                                    linearSystem.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor20.getMargin(), 5);
                                } else {
                                    i3 = 5;
                                    if (constraintAnchor3 != null) {
                                        linearSystem.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                                    }
                                }
                                if (!(constraintAnchor3 == null || constraintWidget13 == constraintWidget14)) {
                                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                                }
                            }
                        } else {
                            int i21 = chainHead.mWidgetsMatchCount;
                            boolean z9 = i21 > 0 && chainHead.mWidgetsCount == i21;
                            ConstraintWidget constraintWidget23 = constraintWidget13;
                            ConstraintWidget constraintWidget24 = constraintWidget23;
                            while (constraintWidget24 != null) {
                                ConstraintWidget constraintWidget25 = constraintWidget24.mNextChainWidget[i8];
                                while (true) {
                                    if (constraintWidget25 != null) {
                                        if (constraintWidget25.getVisibility() != 8) {
                                            break;
                                        }
                                        constraintWidget25 = constraintWidget25.mNextChainWidget[i8];
                                    } else {
                                        break;
                                    }
                                }
                                if (constraintWidget25 != null || constraintWidget24 == constraintWidget14) {
                                    ConstraintAnchor constraintAnchor21 = constraintWidget24.mListAnchors[i2];
                                    SolverVariable solverVariable16 = constraintAnchor21.mSolverVariable;
                                    ConstraintAnchor constraintAnchor22 = constraintAnchor21.mTarget;
                                    SolverVariable solverVariable17 = constraintAnchor22 != null ? constraintAnchor22.mSolverVariable : null;
                                    if (constraintWidget23 != constraintWidget24) {
                                        solverVariable17 = constraintWidget23.mListAnchors[i2 + 1].mSolverVariable;
                                    } else if (constraintWidget24 == constraintWidget13) {
                                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget11.mListAnchors;
                                        solverVariable17 = constraintAnchorArr8[i2].mTarget != null ? constraintAnchorArr8[i2].mTarget.mSolverVariable : null;
                                    }
                                    int margin5 = constraintAnchor21.getMargin();
                                    int i22 = i2 + 1;
                                    int margin6 = constraintWidget24.mListAnchors[i22].getMargin();
                                    if (constraintWidget25 != null) {
                                        constraintAnchor5 = constraintWidget25.mListAnchors[i2];
                                        solverVariable4 = constraintAnchor5.mSolverVariable;
                                    } else {
                                        constraintAnchor5 = constraintWidget12.mListAnchors[i22].mTarget;
                                        if (constraintAnchor5 != null) {
                                            solverVariable4 = constraintAnchor5.mSolverVariable;
                                        } else {
                                            constraintWidget8 = constraintWidget25;
                                            solverVariable4 = null;
                                            SolverVariable solverVariable18 = constraintWidget24.mListAnchors[i22].mSolverVariable;
                                            if (constraintAnchor5 != null) {
                                                margin6 += constraintAnchor5.getMargin();
                                            }
                                            int margin7 = margin5 + constraintWidget23.mListAnchors[i22].getMargin();
                                            if (solverVariable16 != null || solverVariable17 == null || solverVariable4 == null || solverVariable18 == null) {
                                                constraintWidget6 = constraintWidget8;
                                            } else {
                                                if (constraintWidget24 == constraintWidget13) {
                                                    margin7 = constraintWidget13.mListAnchors[i2].getMargin();
                                                }
                                                constraintWidget6 = constraintWidget8;
                                                constraintWidget7 = constraintWidget23;
                                                linearSystem.addCentering(solverVariable16, solverVariable17, margin7, 0.5f, solverVariable4, solverVariable18, constraintWidget24 == constraintWidget14 ? constraintWidget14.mListAnchors[i22].getMargin() : margin6, z9 ? 8 : 5);
                                                if (constraintWidget24.getVisibility() != 8) {
                                                    constraintWidget24 = constraintWidget7;
                                                }
                                                constraintWidget23 = constraintWidget24;
                                                constraintWidget24 = constraintWidget6;
                                            }
                                        }
                                    }
                                    constraintWidget8 = constraintWidget25;
                                    SolverVariable solverVariable182 = constraintWidget24.mListAnchors[i22].mSolverVariable;
                                    if (constraintAnchor5 != null) {
                                    }
                                    int margin72 = margin5 + constraintWidget23.mListAnchors[i22].getMargin();
                                    if (solverVariable16 != null) {
                                    }
                                    constraintWidget6 = constraintWidget8;
                                } else {
                                    constraintWidget6 = constraintWidget25;
                                }
                                constraintWidget7 = constraintWidget23;
                                if (constraintWidget24.getVisibility() != 8) {
                                }
                                constraintWidget23 = constraintWidget24;
                                constraintWidget24 = constraintWidget6;
                            }
                        }
                        if ((!z2 || z) && constraintWidget13 != null && constraintWidget13 != constraintWidget14) {
                            ConstraintAnchor[] constraintAnchorArr9 = constraintWidget13.mListAnchors;
                            ConstraintAnchor constraintAnchor23 = constraintAnchorArr9[i2];
                            if (constraintWidget14 == null) {
                                constraintWidget14 = constraintWidget13;
                            }
                            int i23 = i2 + 1;
                            ConstraintAnchor constraintAnchor24 = constraintWidget14.mListAnchors[i23];
                            ConstraintAnchor constraintAnchor25 = constraintAnchor23.mTarget;
                            solverVariable = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor26 = constraintAnchor24.mTarget;
                            SolverVariable solverVariable19 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                            if (constraintWidget12 != constraintWidget14) {
                                ConstraintAnchor constraintAnchor27 = constraintWidget12.mListAnchors[i23].mTarget;
                                if (constraintAnchor27 != null) {
                                    constraintWidget = constraintAnchor27.mSolverVariable;
                                }
                                solverVariable19 = constraintWidget;
                            }
                            if (constraintWidget13 == constraintWidget14) {
                                constraintAnchor23 = constraintAnchorArr9[i2];
                                constraintAnchor24 = constraintAnchorArr9[i23];
                            }
                            if (solverVariable == null && solverVariable19 != null) {
                                linearSystem.addCentering(constraintAnchor23.mSolverVariable, solverVariable, constraintAnchor23.getMargin(), 0.5f, solverVariable19, constraintAnchor24.mSolverVariable, constraintWidget14.mListAnchors[i23].getMargin(), 5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (z6) {
                    ConstraintAnchor constraintAnchor28 = constraintAnchor10.mTarget;
                    if (constraintAnchor28.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor10.mSolverVariable, constraintAnchor28.mSolverVariable, -constraintAnchor10.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor10.mSolverVariable, constraintWidget12.mListAnchors[i12].mTarget.mSolverVariable, -constraintAnchor10.getMargin(), 6);
                if (z5) {
                }
                ArrayList<ConstraintWidget> arrayList22 = chainHead.mWeightedMatchConstraintsWidgets;
                if (chainHead.mHasUndefinedWeights) {
                }
                float f42 = 0.0f;
                ConstraintWidget constraintWidget182 = null;
                i5 = 0;
                float f52 = 0.0f;
                while (i5 < size) {
                }
                if (constraintWidget13 == null) {
                }
                if (z2) {
                }
                int i162 = 8;
                int i172 = chainHead.mWidgetsMatchCount;
                if (i172 <= 0) {
                }
                ConstraintWidget constraintWidget202 = constraintWidget13;
                constraintWidget2 = constraintWidget202;
                while (constraintWidget2 != null) {
                }
                ConstraintAnchor constraintAnchor202 = constraintWidget13.mListAnchors[i2];
                constraintAnchor = constraintWidget11.mListAnchors[i2].mTarget;
                int i202 = i2 + 1;
                constraintAnchor2 = constraintWidget14.mListAnchors[i202];
                constraintAnchor3 = constraintWidget12.mListAnchors[i202].mTarget;
                if (constraintAnchor == null) {
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                if (!z2) {
                }
                ConstraintAnchor[] constraintAnchorArr92 = constraintWidget13.mListAnchors;
                ConstraintAnchor constraintAnchor232 = constraintAnchorArr92[i2];
                if (constraintWidget14 == null) {
                }
                int i232 = i2 + 1;
                ConstraintAnchor constraintAnchor242 = constraintWidget14.mListAnchors[i232];
                ConstraintAnchor constraintAnchor252 = constraintAnchor232.mTarget;
                if (constraintAnchor252 != null) {
                }
                ConstraintAnchor constraintAnchor262 = constraintAnchor242.mTarget;
                if (constraintAnchor262 != null) {
                }
                if (constraintWidget12 != constraintWidget14) {
                }
                if (constraintWidget13 == constraintWidget14) {
                }
                if (solverVariable == null) {
                    return;
                }
                return;
            }
        }
        if (z5) {
        }
        ArrayList<ConstraintWidget> arrayList222 = chainHead.mWeightedMatchConstraintsWidgets;
        if (chainHead.mHasUndefinedWeights) {
        }
        float f422 = 0.0f;
        ConstraintWidget constraintWidget1822 = null;
        i5 = 0;
        float f522 = 0.0f;
        while (i5 < size) {
        }
        if (constraintWidget13 == null) {
        }
        if (z2) {
        }
        int i1622 = 8;
        int i1722 = chainHead.mWidgetsMatchCount;
        if (i1722 <= 0) {
        }
        ConstraintWidget constraintWidget2022 = constraintWidget13;
        constraintWidget2 = constraintWidget2022;
        while (constraintWidget2 != null) {
        }
        ConstraintAnchor constraintAnchor2022 = constraintWidget13.mListAnchors[i2];
        constraintAnchor = constraintWidget11.mListAnchors[i2].mTarget;
        int i2022 = i2 + 1;
        constraintAnchor2 = constraintWidget14.mListAnchors[i2022];
        constraintAnchor3 = constraintWidget12.mListAnchors[i2022].mTarget;
        if (constraintAnchor == null) {
        }
        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
        if (!z2) {
        }
        ConstraintAnchor[] constraintAnchorArr922 = constraintWidget13.mListAnchors;
        ConstraintAnchor constraintAnchor2322 = constraintAnchorArr922[i2];
        if (constraintWidget14 == null) {
        }
        int i2322 = i2 + 1;
        ConstraintAnchor constraintAnchor2422 = constraintWidget14.mListAnchors[i2322];
        ConstraintAnchor constraintAnchor2522 = constraintAnchor2322.mTarget;
        if (constraintAnchor2522 != null) {
        }
        ConstraintAnchor constraintAnchor2622 = constraintAnchor2422.mTarget;
        if (constraintAnchor2622 != null) {
        }
        if (constraintWidget12 != constraintWidget14) {
        }
        if (constraintWidget13 == constraintWidget14) {
        }
        if (solverVariable == null) {
        }
    }
}
