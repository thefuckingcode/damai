package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import tb.jl1;

/* compiled from: Taobao */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public WidgetFrame frame;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr2;
            iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x040e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0433 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x044c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0509 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:371:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:375:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb  */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i9;
        boolean z12;
        int i10;
        int i11;
        SolverVariable solverVariable3;
        int i12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i15;
        SolverVariable solverVariable7;
        int i16;
        int i17;
        SolverVariable solverVariable8;
        int i18;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        boolean z15;
        ConstraintAnchor constraintAnchor3;
        DimensionBehaviour[] dimensionBehaviourArr;
        DimensionBehaviour dimensionBehaviour2;
        boolean z16;
        int i19;
        SolverVariable solverVariable11;
        int i20;
        SolverVariable solverVariable12;
        ConstraintWidget constraintWidget;
        boolean z17;
        boolean z18;
        boolean z19;
        int i21;
        SolverVariable solverVariable13;
        int i22;
        int i23;
        boolean z20;
        int i24;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable14;
        SolverVariable solverVariable15;
        ConstraintWidget constraintWidget3;
        int i25;
        ConstraintWidget constraintWidget4;
        boolean z21;
        int i26;
        int i27;
        int i28;
        SolverVariable solverVariable16;
        int i29;
        int i30;
        boolean z22;
        boolean z23;
        int i31;
        ConstraintWidget constraintWidget5;
        int i32;
        SolverVariable solverVariable17;
        SolverVariable solverVariable18;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        if (isConnected2) {
            i9 = (isConnected ? 1 : 0) + 1;
        } else {
            i9 = isConnected ? 1 : 0;
        }
        if (isConnected3) {
            i9++;
        }
        int i33 = z6 ? 3 : i5;
        int i34 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i34 == 1 || i34 == 2 || i34 == 3 || i34 != 4) {
            i10 = i33;
        } else {
            i10 = i33;
            if (i10 != 4) {
                z12 = true;
                i11 = this.mWidthOverride;
                if (i11 != -1 || !z) {
                    i11 = i2;
                    solverVariable3 = createObjectVariable4;
                } else {
                    this.mWidthOverride = -1;
                    solverVariable3 = createObjectVariable4;
                    z12 = false;
                }
                i12 = this.mHeightOverride;
                if (i12 != -1 && !z) {
                    this.mHeightOverride = -1;
                    i11 = i12;
                    z12 = false;
                }
                if (this.mVisibility == 8) {
                    i11 = 0;
                    z12 = false;
                }
                if (z11) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable, i);
                    } else if (isConnected && !isConnected2) {
                        linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 8);
                    }
                }
                if (z12) {
                    if (z5) {
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                        if (i3 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i3, 8);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i4, 8);
                        }
                    } else {
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 8);
                    }
                    i15 = i8;
                    i13 = i9;
                    solverVariable6 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    z13 = z12;
                    solverVariable5 = solverVariable3;
                    z14 = z4;
                } else if (i9 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                    int i35 = i7 == -2 ? i11 : i7;
                    i15 = i8 == -2 ? i11 : i8;
                    if (i11 > 0 && i10 != 1) {
                        i11 = 0;
                    }
                    if (i35 > 0) {
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i35, 8);
                        i11 = Math.max(i11, i35);
                    }
                    if (i15 > 0) {
                        if (!z2 || i10 != 1) {
                            i32 = 8;
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i15, 8);
                        } else {
                            i32 = 8;
                        }
                        i11 = Math.min(i11, i15);
                    } else {
                        i32 = 8;
                    }
                    if (i10 == 1) {
                        if (z2) {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, i32);
                        } else if (z8) {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i32);
                        } else {
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i32);
                        }
                        i13 = i9;
                        solverVariable6 = createObjectVariable3;
                        solverVariable4 = createObjectVariable2;
                        z13 = z12;
                        solverVariable5 = solverVariable3;
                        z14 = z4;
                        i14 = i35;
                    } else if (i10 == 2) {
                        ConstraintAnchor.Type type = constraintAnchor.getType();
                        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                        if (type == type2 || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                            solverVariable18 = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                            solverVariable17 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                        } else {
                            solverVariable18 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                            solverVariable17 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                        }
                        i13 = i9;
                        solverVariable5 = solverVariable3;
                        i14 = i35;
                        solverVariable6 = createObjectVariable3;
                        solverVariable4 = createObjectVariable2;
                        linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable17, solverVariable18, f2));
                        if (z2) {
                            z12 = false;
                        }
                        z13 = z12;
                        z14 = z4;
                    } else {
                        i13 = i9;
                        solverVariable6 = createObjectVariable3;
                        solverVariable4 = createObjectVariable2;
                        solverVariable5 = solverVariable3;
                        i14 = i35;
                        z13 = z12;
                        z14 = true;
                    }
                    if (!z11) {
                        solverVariable10 = solverVariable;
                        solverVariable8 = solverVariable2;
                        solverVariable9 = solverVariable4;
                        i18 = 0;
                        solverVariable7 = createObjectVariable;
                        i17 = i13;
                        i16 = 2;
                    } else if (z8) {
                        solverVariable10 = solverVariable;
                        solverVariable8 = solverVariable2;
                        i17 = i13;
                        solverVariable9 = solverVariable4;
                        i18 = 0;
                        i16 = 2;
                        solverVariable7 = createObjectVariable;
                    } else {
                        if (isConnected || isConnected2 || isConnected3) {
                            if (isConnected && !isConnected2) {
                                z16 = z2;
                                i19 = (!z2 || !(constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 5 : 8;
                                solverVariable11 = solverVariable4;
                                if (z16) {
                                }
                            } else if (!isConnected && isConnected2) {
                                linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                if (z2) {
                                    if (!this.OPTIMIZE_WRAP || !createObjectVariable.isFinalValue || (constraintWidget5 = this.mParent) == null) {
                                        linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 5);
                                        solverVariable11 = solverVariable4;
                                        z16 = z2;
                                        i19 = 5;
                                        if (z16) {
                                        }
                                    } else {
                                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                                        if (z) {
                                            constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                        } else {
                                            constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                        }
                                    }
                                }
                            } else if (isConnected && isConnected2) {
                                ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                                ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                                ConstraintWidget parent = getParent();
                                if (z13) {
                                    if (i10 == 0) {
                                        if (i15 != 0 || i14 != 0) {
                                            i30 = 5;
                                            i31 = 5;
                                            z23 = true;
                                            z22 = false;
                                            z18 = true;
                                        } else if (!solverVariable6.isFinalValue || !solverVariable5.isFinalValue) {
                                            i30 = 8;
                                            i31 = 8;
                                            z23 = false;
                                            z22 = true;
                                            z18 = false;
                                        } else {
                                            linearSystem.addEquality(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), 8);
                                            linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                            return;
                                        }
                                        if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                            solverVariable13 = solverVariable2;
                                            i22 = i30;
                                            z17 = z22;
                                            i23 = 6;
                                            z19 = z23;
                                            i21 = 4;
                                            if (z18 || solverVariable6 != solverVariable5 || constraintWidget6 == parent) {
                                                z20 = true;
                                            } else {
                                                z18 = false;
                                                z20 = false;
                                            }
                                            if (z19) {
                                                if (z13 || z7 || z9 || solverVariable6 != solverVariable || solverVariable5 != solverVariable13) {
                                                    z16 = z2;
                                                    i26 = i23;
                                                    z21 = z20;
                                                    i27 = i22;
                                                } else {
                                                    z16 = false;
                                                    i27 = 8;
                                                    i26 = 8;
                                                    z21 = false;
                                                }
                                                i24 = i10;
                                                constraintWidget2 = parent;
                                                constraintWidget3 = constraintWidget7;
                                                solverVariable14 = solverVariable4;
                                                solverVariable15 = createObjectVariable;
                                                linearSystem.addCentering(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), f, solverVariable5, solverVariable4, constraintAnchor2.getMargin(), i26);
                                                i22 = i27;
                                                z20 = z21;
                                            } else {
                                                i24 = i10;
                                                constraintWidget2 = parent;
                                                constraintWidget3 = constraintWidget7;
                                                solverVariable14 = solverVariable4;
                                                solverVariable15 = createObjectVariable;
                                                z16 = z2;
                                            }
                                            if (this.mVisibility == 8 || constraintAnchor2.hasDependents()) {
                                                if (z18) {
                                                    if (z16 && solverVariable6 != solverVariable5 && !z13 && ((constraintWidget6 instanceof Barrier) || (constraintWidget3 instanceof Barrier))) {
                                                        i22 = 6;
                                                    }
                                                    linearSystem.addGreaterThan(solverVariable15, solverVariable6, constraintAnchor.getMargin(), i22);
                                                    solverVariable11 = solverVariable14;
                                                    linearSystem.addLowerThan(solverVariable11, solverVariable5, -constraintAnchor2.getMargin(), i22);
                                                } else {
                                                    solverVariable11 = solverVariable14;
                                                }
                                                if (z16 || !z10 || (constraintWidget6 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                    constraintWidget4 = constraintWidget2;
                                                } else {
                                                    constraintWidget4 = constraintWidget2;
                                                    if (constraintWidget3 != constraintWidget4) {
                                                        i22 = 6;
                                                        i25 = 6;
                                                        z20 = true;
                                                        if (z20) {
                                                            if (z17 && (!z9 || z3)) {
                                                                int i36 = (constraintWidget6 == constraintWidget4 || constraintWidget3 == constraintWidget4) ? 6 : i25;
                                                                if ((constraintWidget6 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) {
                                                                    i36 = 5;
                                                                }
                                                                if ((constraintWidget6 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                                    i36 = 5;
                                                                }
                                                                if (z9) {
                                                                    i36 = 5;
                                                                }
                                                                i25 = Math.max(i36, i25);
                                                            }
                                                            if (z16) {
                                                                i25 = (!z6 || z9 || !(constraintWidget6 == constraintWidget4 || constraintWidget3 == constraintWidget4)) ? Math.min(i22, i25) : 4;
                                                            }
                                                            linearSystem.addEquality(solverVariable15, solverVariable6, constraintAnchor.getMargin(), i25);
                                                            linearSystem.addEquality(solverVariable11, solverVariable5, -constraintAnchor2.getMargin(), i25);
                                                        }
                                                        if (z16) {
                                                            int margin = solverVariable == solverVariable6 ? constraintAnchor.getMargin() : 0;
                                                            if (solverVariable6 != solverVariable) {
                                                                linearSystem.addGreaterThan(solverVariable15, solverVariable, margin, 5);
                                                            }
                                                        }
                                                        if (z16 || !z13 || i3 != 0 || i14 != 0) {
                                                            i19 = 5;
                                                            if (z16 && z14) {
                                                                if (constraintAnchor2.mTarget != null) {
                                                                    i20 = constraintAnchor2.getMargin();
                                                                    solverVariable12 = solverVariable2;
                                                                } else {
                                                                    solverVariable12 = solverVariable2;
                                                                    i20 = 0;
                                                                }
                                                                if (solverVariable5 == solverVariable12) {
                                                                    return;
                                                                }
                                                                if (!this.OPTIMIZE_WRAP || !solverVariable11.isFinalValue || (constraintWidget = this.mParent) == null) {
                                                                    linearSystem.addGreaterThan(solverVariable12, solverVariable11, i20, i19);
                                                                    return;
                                                                }
                                                                ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                                                                if (z) {
                                                                    constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                                                                    return;
                                                                } else {
                                                                    constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                                                                    return;
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            if (!z13 || i24 != 3) {
                                                                linearSystem.addGreaterThan(solverVariable11, solverVariable15, 0, 5);
                                                            } else {
                                                                linearSystem.addGreaterThan(solverVariable11, solverVariable15, 0, 8);
                                                            }
                                                            i19 = 5;
                                                            if (z16) {
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                }
                                                i25 = i21;
                                                if (z20) {
                                                }
                                                if (z16) {
                                                }
                                                if (z16) {
                                                }
                                                i19 = 5;
                                                if (z16) {
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            solverVariable13 = solverVariable2;
                                            z17 = z22;
                                            z19 = z23;
                                            i21 = i31;
                                        }
                                    } else if (i10 == 2) {
                                        if (!(constraintWidget6 instanceof Barrier) && !(constraintWidget7 instanceof Barrier)) {
                                            solverVariable13 = solverVariable2;
                                            i23 = 6;
                                            i22 = 5;
                                            i21 = 5;
                                            z19 = true;
                                            z18 = true;
                                            z17 = false;
                                            if (z18) {
                                            }
                                            z20 = true;
                                            if (z19) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                            if (z18) {
                                            }
                                            if (z16) {
                                            }
                                            constraintWidget4 = constraintWidget2;
                                            i25 = i21;
                                            if (z20) {
                                            }
                                            if (z16) {
                                            }
                                            if (z16) {
                                            }
                                            i19 = 5;
                                            if (z16) {
                                            }
                                        }
                                    } else if (i10 == 1) {
                                        solverVariable13 = solverVariable2;
                                        i23 = 6;
                                        i22 = 8;
                                        i21 = 4;
                                        z19 = true;
                                        z18 = true;
                                        z17 = false;
                                        if (z18) {
                                        }
                                        z20 = true;
                                        if (z19) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (z18) {
                                        }
                                        if (z16) {
                                        }
                                        constraintWidget4 = constraintWidget2;
                                        i25 = i21;
                                        if (z20) {
                                        }
                                        if (z16) {
                                        }
                                        if (z16) {
                                        }
                                        i19 = 5;
                                        if (z16) {
                                        }
                                    } else if (i10 == 3) {
                                        if (this.mResolvedDimensionRatioSide == -1) {
                                            if (z9) {
                                                solverVariable13 = solverVariable2;
                                                i23 = z2 ? 5 : 4;
                                            } else {
                                                solverVariable13 = solverVariable2;
                                                i23 = 8;
                                            }
                                            i22 = 8;
                                        } else if (z6) {
                                            if (!(i6 == 2 || i6 == 1)) {
                                                i30 = 8;
                                                i29 = 5;
                                            } else {
                                                i30 = 5;
                                                i29 = 4;
                                            }
                                            solverVariable13 = solverVariable2;
                                            i21 = i29;
                                            z19 = true;
                                            z18 = true;
                                            z17 = true;
                                        } else if (i15 > 0) {
                                            solverVariable13 = solverVariable2;
                                            i23 = 6;
                                            i22 = 5;
                                        } else {
                                            if (i15 != 0 || i14 != 0) {
                                                solverVariable13 = solverVariable2;
                                                i23 = 6;
                                                i22 = 5;
                                            } else if (!z9) {
                                                solverVariable13 = solverVariable2;
                                                i23 = 6;
                                                i22 = 5;
                                                i21 = 8;
                                                z19 = true;
                                                z18 = true;
                                                z17 = true;
                                                if (z18) {
                                                }
                                                z20 = true;
                                                if (z19) {
                                                }
                                                if (this.mVisibility == 8) {
                                                }
                                                if (z18) {
                                                }
                                                if (z16) {
                                                }
                                                constraintWidget4 = constraintWidget2;
                                                i25 = i21;
                                                if (z20) {
                                                }
                                                if (z16) {
                                                }
                                                if (z16) {
                                                }
                                                i19 = 5;
                                                if (z16) {
                                                }
                                            } else {
                                                solverVariable13 = solverVariable2;
                                                i22 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                                i23 = 6;
                                            }
                                            i21 = 4;
                                            z19 = true;
                                            z18 = true;
                                            z17 = true;
                                            if (z18) {
                                            }
                                            z20 = true;
                                            if (z19) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                            if (z18) {
                                            }
                                            if (z16) {
                                            }
                                            constraintWidget4 = constraintWidget2;
                                            i25 = i21;
                                            if (z20) {
                                            }
                                            if (z16) {
                                            }
                                            if (z16) {
                                            }
                                            i19 = 5;
                                            if (z16) {
                                            }
                                        }
                                        i21 = 5;
                                        z19 = true;
                                        z18 = true;
                                        z17 = true;
                                        if (z18) {
                                        }
                                        z20 = true;
                                        if (z19) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (z18) {
                                        }
                                        if (z16) {
                                        }
                                        constraintWidget4 = constraintWidget2;
                                        i25 = i21;
                                        if (z20) {
                                        }
                                        if (z16) {
                                        }
                                        if (z16) {
                                        }
                                        i19 = 5;
                                        if (z16) {
                                        }
                                    } else {
                                        solverVariable13 = solverVariable2;
                                        i23 = 6;
                                        i22 = 5;
                                        i21 = 4;
                                        z19 = false;
                                        z18 = false;
                                        z17 = false;
                                        if (z18) {
                                        }
                                        z20 = true;
                                        if (z19) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (z18) {
                                        }
                                        if (z16) {
                                        }
                                        constraintWidget4 = constraintWidget2;
                                        i25 = i21;
                                        if (z20) {
                                        }
                                        if (z16) {
                                        }
                                        if (z16) {
                                        }
                                        i19 = 5;
                                        if (z16) {
                                        }
                                    }
                                    i22 = i30;
                                    i23 = 6;
                                    if (z18) {
                                    }
                                    z20 = true;
                                    if (z19) {
                                    }
                                    if (this.mVisibility == 8) {
                                    }
                                    if (z18) {
                                    }
                                    if (z16) {
                                    }
                                    constraintWidget4 = constraintWidget2;
                                    i25 = i21;
                                    if (z20) {
                                    }
                                    if (z16) {
                                    }
                                    if (z16) {
                                    }
                                    i19 = 5;
                                    if (z16) {
                                    }
                                } else if (solverVariable6.isFinalValue && solverVariable5.isFinalValue) {
                                    linearSystem.addCentering(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), f, solverVariable5, solverVariable4, constraintAnchor2.getMargin(), 8);
                                    if (z2 && z14) {
                                        if (constraintAnchor2.mTarget != null) {
                                            i28 = constraintAnchor2.getMargin();
                                            solverVariable16 = solverVariable2;
                                        } else {
                                            solverVariable16 = solverVariable2;
                                            i28 = 0;
                                        }
                                        if (solverVariable5 != solverVariable16) {
                                            linearSystem.addGreaterThan(solverVariable16, solverVariable4, i28, 5);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                solverVariable13 = solverVariable2;
                                i23 = 6;
                                i22 = 5;
                                i21 = 4;
                                z19 = true;
                                z18 = true;
                                z17 = false;
                                if (z18) {
                                }
                                z20 = true;
                                if (z19) {
                                }
                                if (this.mVisibility == 8) {
                                }
                                if (z18) {
                                }
                                if (z16) {
                                }
                                constraintWidget4 = constraintWidget2;
                                i25 = i21;
                                if (z20) {
                                }
                                if (z16) {
                                }
                                if (z16) {
                                }
                                i19 = 5;
                                if (z16) {
                                }
                            }
                        }
                        solverVariable11 = solverVariable4;
                        z16 = z2;
                        i19 = 5;
                        if (z16) {
                        }
                    }
                    if (i17 >= i16 && z2 && z14) {
                        linearSystem.addGreaterThan(solverVariable7, solverVariable10, i18, 8);
                        boolean z24 = z || this.mBaseline.mTarget == null;
                        if (z || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                            z15 = z24;
                        } else {
                            ConstraintWidget constraintWidget8 = constraintAnchor3.mOwner;
                            z15 = constraintWidget8.mDimensionRatio != 0.0f && (dimensionBehaviourArr = constraintWidget8.mListDimensionBehaviors)[i18] == (dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT) && dimensionBehaviourArr[1] == dimensionBehaviour2;
                        }
                        if (z15) {
                            linearSystem.addGreaterThan(solverVariable8, solverVariable9, i18, 8);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    int max = Math.max(i7, i11);
                    if (i8 > 0) {
                        max = Math.min(i8, max);
                    }
                    linearSystem.addEquality(createObjectVariable2, createObjectVariable, max, 8);
                    z14 = z4;
                    i15 = i8;
                    i13 = i9;
                    solverVariable6 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    solverVariable5 = solverVariable3;
                    z13 = false;
                }
                i14 = i7;
                if (!z11) {
                }
                if (i17 >= i16) {
                    return;
                }
                return;
            }
        }
        z12 = false;
        i11 = this.mWidthOverride;
        if (i11 != -1) {
        }
        i11 = i2;
        solverVariable3 = createObjectVariable4;
        i12 = this.mHeightOverride;
        this.mHeightOverride = -1;
        i11 = i12;
        z12 = false;
        if (this.mVisibility == 8) {
        }
        if (z11) {
        }
        if (z12) {
        }
        i14 = i7;
        if (!z11) {
        }
        if (i17 >= i16) {
        }
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (!(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i2].mTarget.mTarget == constraintAnchorArr[i2])) {
            int i3 = i2 + 1;
            return constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget == constraintAnchorArr[i3];
        }
    }

    private void serializeAnchor(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("',");
            sb.append(constraintAnchor.mMargin);
            sb.append(",");
            sb.append(constraintAnchor.mGoneMargin);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void serializeAttribute(StringBuilder sb, String str, float f, float f2) {
        if (f != f2) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f2);
            sb.append(",\n");
        }
    }

    private void serializeCircle(StringBuilder sb, ConstraintAnchor constraintAnchor, float f) {
        if (constraintAnchor.mTarget != null) {
            sb.append("circle : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("',");
            sb.append(constraintAnchor.mMargin);
            sb.append(",");
            sb.append(f);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void serializeDimensionRatio(StringBuilder sb, String str, float f, int i) {
        if (f != 0.0f) {
            sb.append(str);
            sb.append(" :  [");
            sb.append(f);
            sb.append(",");
            sb.append(i);
            sb.append("");
            sb.append("],\n");
        }
    }

    private void serializeSize(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "size", (float) i, -2.14748365E9f);
        serializeAttribute(sb, "min", (float) i2, 0.0f);
        serializeAttribute(sb, "max", (float) i3, 2.14748365E9f);
        serializeAttribute(sb, "matchMin", (float) i5, 0.0f);
        float f3 = (float) i6;
        serializeAttribute(sb, "matchDef", f3, 0.0f);
        serializeAttribute(sb, "matchPercent", f3, 1.0f);
        sb.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (hashSet.contains(this)) {
                Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:188:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0577  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x057a  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x05f5  */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        SolverVariable solverVariable;
        boolean z6;
        int i4;
        char c;
        boolean z7;
        int i5;
        DimensionBehaviour dimensionBehaviour;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        DimensionBehaviour dimensionBehaviour2;
        boolean z8;
        boolean z9;
        boolean z10;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        LinearSystem linearSystem2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        char c2;
        int i6;
        boolean z11;
        int i7;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget2;
        boolean z12;
        HorizontalWidgetRun horizontalWidgetRun;
        int i8;
        int i9;
        boolean z13;
        boolean z14;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 != null) {
            boolean z15 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z16 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            int i10 = this.mWrapBehaviorInParent;
            if (i10 != 1) {
                if (i10 == 2) {
                    z2 = z16;
                    z3 = false;
                } else if (i10 != 3) {
                    z2 = z16;
                    z3 = z15;
                }
                if (this.mVisibility == 8 && !hasDependencies()) {
                    boolean[] zArr = this.mIsInBarrier;
                    if (!zArr[0] && !zArr[1]) {
                    }
                }
                boolean z17 = this.resolvedHorizontal;
                if (z17 || this.resolvedVertical) {
                    if (z17) {
                        linearSystem.addEquality(createObjectVariable, this.mX);
                        linearSystem.addEquality(createObjectVariable2, this.mX + this.mWidth);
                        if (z3 && (constraintWidget4 = this.mParent) != null) {
                            if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget4;
                                constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                                constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                            } else {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget4.mRight), createObjectVariable2, 0, 5);
                            }
                        }
                    }
                    if (this.resolvedVertical) {
                        linearSystem.addEquality(createObjectVariable3, this.mY);
                        linearSystem.addEquality(createObjectVariable4, this.mY + this.mHeight);
                        if (this.mBaseline.hasDependents()) {
                            linearSystem.addEquality(createObjectVariable5, this.mY + this.mBaselineDistance);
                        }
                        if (z2 && (constraintWidget3 = this.mParent) != null) {
                            if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                                ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget3;
                                constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                                constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                            } else {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget3.mBottom), createObjectVariable4, 0, 5);
                            }
                        }
                    }
                    if (this.resolvedHorizontal && this.resolvedVertical) {
                        this.resolvedHorizontal = false;
                        this.resolvedVertical = false;
                        return;
                    }
                }
                Metrics metrics = LinearSystem.sMetrics;
                if (metrics != null) {
                    metrics.widgets++;
                }
                if (!(!z || (horizontalWidgetRun2 = this.horizontalRun) == null || (verticalWidgetRun = this.verticalRun) == null)) {
                    DependencyNode dependencyNode = horizontalWidgetRun2.start;
                    if (dependencyNode.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                        if (metrics != null) {
                            metrics.graphSolved++;
                        }
                        linearSystem.addEquality(createObjectVariable, dependencyNode.value);
                        linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                        linearSystem.addEquality(createObjectVariable3, this.verticalRun.start.value);
                        linearSystem.addEquality(createObjectVariable4, this.verticalRun.end.value);
                        linearSystem.addEquality(createObjectVariable5, this.verticalRun.baseline.value);
                        if (this.mParent != null) {
                            if (z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                            }
                            if (z2 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                            }
                        }
                        this.resolvedHorizontal = false;
                        this.resolvedVertical = false;
                        return;
                    }
                }
                if (metrics != null) {
                    metrics.linearSolved++;
                }
                if (this.mParent != null) {
                    if (isChainHead(0)) {
                        ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                        z13 = true;
                    } else {
                        z13 = isInHorizontalChain();
                    }
                    if (isChainHead(1)) {
                        ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                        z14 = true;
                    } else {
                        z14 = isInVerticalChain();
                    }
                    if (!z13 && z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
                    }
                    if (!z14 && z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
                    }
                    z4 = z13;
                    z5 = z14;
                } else {
                    z5 = false;
                    z4 = false;
                }
                int i11 = this.mWidth;
                int i12 = this.mMinWidth;
                if (i11 >= i12) {
                    i12 = i11;
                }
                int i13 = this.mHeight;
                int i14 = this.mMinHeight;
                if (i13 >= i14) {
                    i14 = i13;
                }
                DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
                DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
                DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z18 = dimensionBehaviour3 != dimensionBehaviour4;
                boolean z19 = dimensionBehaviourArr[1] != dimensionBehaviour4;
                int i15 = this.mDimensionRatioSide;
                this.mResolvedDimensionRatioSide = i15;
                float f = this.mDimensionRatio;
                this.mResolvedDimensionRatio = f;
                int i16 = this.mMatchConstraintDefaultWidth;
                int i17 = this.mMatchConstraintDefaultHeight;
                if (f > 0.0f) {
                    solverVariable = createObjectVariable;
                    if (this.mVisibility != 8) {
                        if (dimensionBehaviourArr[0] == dimensionBehaviour4 && i16 == 0) {
                            i16 = 3;
                        }
                        if (dimensionBehaviourArr[1] == dimensionBehaviour4 && i17 == 0) {
                            i17 = 3;
                        }
                        if (dimensionBehaviourArr[0] == dimensionBehaviour4 && dimensionBehaviourArr[1] == dimensionBehaviour4) {
                            i9 = 3;
                            if (i16 == 3 && i17 == 3) {
                                setupDimensionRatio(z3, z2, z18, z19);
                                c = 0;
                                i = i16;
                                i2 = i17;
                                i4 = i12;
                                i3 = i14;
                                z6 = true;
                                int[] iArr = this.mResolvedMatchConstraintDefault;
                                iArr[c] = i;
                                iArr[1] = i2;
                                this.mResolvedHasRatio = z6;
                                if (z6) {
                                    int i18 = this.mResolvedDimensionRatioSide;
                                    i5 = -1;
                                    if (i18 == 0 || i18 == -1) {
                                        z7 = true;
                                        boolean z20 = !z6 && ((i8 = this.mResolvedDimensionRatioSide) == 1 || i8 == i5);
                                        DimensionBehaviour dimensionBehaviour5 = this.mListDimensionBehaviors[0];
                                        DimensionBehaviour dimensionBehaviour6 = DimensionBehaviour.WRAP_CONTENT;
                                        boolean z21 = dimensionBehaviour5 != dimensionBehaviour6 && (this instanceof ConstraintWidgetContainer);
                                        int i19 = !z21 ? 0 : i4;
                                        boolean z22 = !this.mCenter.isConnected();
                                        boolean[] zArr2 = this.mIsInBarrier;
                                        boolean z23 = zArr2[0];
                                        boolean z24 = zArr2[1];
                                        if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                                            if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                                                DependencyNode dependencyNode2 = horizontalWidgetRun.start;
                                                if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                                    if (!z) {
                                                        linearSystem.addEquality(solverVariable, dependencyNode2.value);
                                                        linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                                                        if (this.mParent != null && z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                                                        }
                                                        z9 = z3;
                                                        z8 = z2;
                                                        dimensionBehaviour2 = dimensionBehaviour4;
                                                        dimensionBehaviour = dimensionBehaviour6;
                                                        z10 = z6;
                                                        solverVariable4 = createObjectVariable5;
                                                        solverVariable3 = createObjectVariable4;
                                                        solverVariable2 = createObjectVariable3;
                                                        solverVariable6 = createObjectVariable2;
                                                        solverVariable5 = solverVariable;
                                                        if (z) {
                                                            constraintWidget = this;
                                                            VerticalWidgetRun verticalWidgetRun2 = constraintWidget.verticalRun;
                                                            if (verticalWidgetRun2 != null) {
                                                                DependencyNode dependencyNode3 = verticalWidgetRun2.start;
                                                                if (dependencyNode3.resolved && verticalWidgetRun2.end.resolved) {
                                                                    linearSystem2 = linearSystem;
                                                                    solverVariable7 = solverVariable2;
                                                                    linearSystem2.addEquality(solverVariable7, dependencyNode3.value);
                                                                    solverVariable8 = solverVariable3;
                                                                    linearSystem2.addEquality(solverVariable8, constraintWidget.verticalRun.end.value);
                                                                    solverVariable9 = solverVariable4;
                                                                    linearSystem2.addEquality(solverVariable9, constraintWidget.verticalRun.baseline.value);
                                                                    ConstraintWidget constraintWidget6 = constraintWidget.mParent;
                                                                    if (constraintWidget6 == null || z5 || !z8) {
                                                                        i7 = 8;
                                                                        i6 = 0;
                                                                        c2 = 1;
                                                                    } else {
                                                                        c2 = 1;
                                                                        if (constraintWidget.isTerminalWidget[1]) {
                                                                            i7 = 8;
                                                                            i6 = 0;
                                                                            linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget6.mBottom), solverVariable8, 0, 8);
                                                                        } else {
                                                                            i7 = 8;
                                                                            i6 = 0;
                                                                        }
                                                                    }
                                                                    z11 = false;
                                                                    if ((constraintWidget.mVerticalResolution != 2 ? false : z11) || constraintWidget.resolvedVertical) {
                                                                        solverVariable11 = solverVariable8;
                                                                        solverVariable10 = solverVariable7;
                                                                    } else {
                                                                        boolean z25 = constraintWidget.mListDimensionBehaviors[c2] == dimensionBehaviour && (constraintWidget instanceof ConstraintWidgetContainer);
                                                                        if (z25) {
                                                                            i3 = 0;
                                                                        }
                                                                        ConstraintWidget constraintWidget7 = constraintWidget.mParent;
                                                                        SolverVariable createObjectVariable6 = constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mBottom) : null;
                                                                        ConstraintWidget constraintWidget8 = constraintWidget.mParent;
                                                                        SolverVariable createObjectVariable7 = constraintWidget8 != null ? linearSystem2.createObjectVariable(constraintWidget8.mTop) : null;
                                                                        if (constraintWidget.mBaselineDistance > 0 || constraintWidget.mVisibility == i7) {
                                                                            ConstraintAnchor constraintAnchor = constraintWidget.mBaseline;
                                                                            if (constraintAnchor.mTarget != null) {
                                                                                linearSystem2.addEquality(solverVariable9, solverVariable7, getBaselineDistance(), i7);
                                                                                linearSystem2.addEquality(solverVariable9, linearSystem2.createObjectVariable(constraintWidget.mBaseline.mTarget), constraintWidget.mBaseline.getMargin(), i7);
                                                                                if (z8) {
                                                                                    linearSystem2.addGreaterThan(createObjectVariable6, linearSystem2.createObjectVariable(constraintWidget.mBottom), i6, 5);
                                                                                }
                                                                                z12 = false;
                                                                                boolean z26 = constraintWidget.isTerminalWidget[c2];
                                                                                DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget.mListDimensionBehaviors;
                                                                                solverVariable11 = solverVariable8;
                                                                                solverVariable10 = solverVariable7;
                                                                                applyConstraints(linearSystem, false, z8, z9, z26, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr2[c2], z25, constraintWidget.mTop, constraintWidget.mBottom, constraintWidget.mY, i3, constraintWidget.mMinHeight, constraintWidget.mMaxDimension[c2], constraintWidget.mVerticalBiasPercent, z20, dimensionBehaviourArr2[0] != dimensionBehaviour2, z5, z4, z24, i2, i, constraintWidget.mMatchConstraintMinHeight, constraintWidget.mMatchConstraintMaxHeight, constraintWidget.mMatchConstraintPercentHeight, z12);
                                                                            } else if (constraintWidget.mVisibility == i7) {
                                                                                linearSystem2.addEquality(solverVariable9, solverVariable7, constraintAnchor.getMargin(), i7);
                                                                            } else {
                                                                                linearSystem2.addEquality(solverVariable9, solverVariable7, getBaselineDistance(), i7);
                                                                            }
                                                                        }
                                                                        z12 = z22;
                                                                        boolean z262 = constraintWidget.isTerminalWidget[c2];
                                                                        DimensionBehaviour[] dimensionBehaviourArr22 = constraintWidget.mListDimensionBehaviors;
                                                                        solverVariable11 = solverVariable8;
                                                                        solverVariable10 = solverVariable7;
                                                                        applyConstraints(linearSystem, false, z8, z9, z262, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr22[c2], z25, constraintWidget.mTop, constraintWidget.mBottom, constraintWidget.mY, i3, constraintWidget.mMinHeight, constraintWidget.mMaxDimension[c2], constraintWidget.mVerticalBiasPercent, z20, dimensionBehaviourArr22[0] != dimensionBehaviour2, z5, z4, z24, i2, i, constraintWidget.mMatchConstraintMinHeight, constraintWidget.mMatchConstraintMaxHeight, constraintWidget.mMatchConstraintPercentHeight, z12);
                                                                    }
                                                                    if (!z10) {
                                                                        constraintWidget2 = this;
                                                                        if (constraintWidget2.mResolvedDimensionRatioSide == 1) {
                                                                            linearSystem.addRatio(solverVariable11, solverVariable10, solverVariable6, solverVariable5, constraintWidget2.mResolvedDimensionRatio, 8);
                                                                        } else {
                                                                            linearSystem.addRatio(solverVariable6, solverVariable5, solverVariable11, solverVariable10, constraintWidget2.mResolvedDimensionRatio, 8);
                                                                        }
                                                                    } else {
                                                                        constraintWidget2 = this;
                                                                    }
                                                                    if (constraintWidget2.mCenter.isConnected()) {
                                                                        linearSystem.addCenterPoint(constraintWidget2, constraintWidget2.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (constraintWidget2.mCircleConstraintAngle + 90.0f)), constraintWidget2.mCenter.getMargin());
                                                                    }
                                                                    constraintWidget2.resolvedHorizontal = false;
                                                                    constraintWidget2.resolvedVertical = false;
                                                                    return;
                                                                }
                                                            }
                                                            linearSystem2 = linearSystem;
                                                            solverVariable9 = solverVariable4;
                                                            solverVariable8 = solverVariable3;
                                                            solverVariable7 = solverVariable2;
                                                            i7 = 8;
                                                            i6 = 0;
                                                            c2 = 1;
                                                        } else {
                                                            i7 = 8;
                                                            i6 = 0;
                                                            c2 = 1;
                                                            constraintWidget = this;
                                                            linearSystem2 = linearSystem;
                                                            solverVariable9 = solverVariable4;
                                                            solverVariable8 = solverVariable3;
                                                            solverVariable7 = solverVariable2;
                                                        }
                                                        z11 = true;
                                                        if (constraintWidget.mVerticalResolution != 2 ? false : z11) {
                                                        }
                                                        solverVariable11 = solverVariable8;
                                                        solverVariable10 = solverVariable7;
                                                        if (!z10) {
                                                        }
                                                        if (constraintWidget2.mCenter.isConnected()) {
                                                        }
                                                        constraintWidget2.resolvedHorizontal = false;
                                                        constraintWidget2.resolvedVertical = false;
                                                        return;
                                                    }
                                                }
                                            }
                                            ConstraintWidget constraintWidget9 = this.mParent;
                                            SolverVariable createObjectVariable8 = constraintWidget9 != null ? linearSystem.createObjectVariable(constraintWidget9.mRight) : null;
                                            ConstraintWidget constraintWidget10 = this.mParent;
                                            SolverVariable createObjectVariable9 = constraintWidget10 != null ? linearSystem.createObjectVariable(constraintWidget10.mLeft) : null;
                                            boolean z27 = this.isTerminalWidget[0];
                                            DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                                            z9 = z3;
                                            z8 = z2;
                                            dimensionBehaviour2 = dimensionBehaviour4;
                                            solverVariable4 = createObjectVariable5;
                                            solverVariable3 = createObjectVariable4;
                                            solverVariable2 = createObjectVariable3;
                                            solverVariable6 = createObjectVariable2;
                                            dimensionBehaviour = dimensionBehaviour6;
                                            solverVariable5 = solverVariable;
                                            z10 = z6;
                                            applyConstraints(linearSystem, true, z3, z2, z27, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr3[0], z21, this.mLeft, this.mRight, this.mX, i19, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr3[1] == dimensionBehaviour4, z4, z5, z23, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z22);
                                            if (z) {
                                            }
                                            z11 = true;
                                            if (constraintWidget.mVerticalResolution != 2 ? false : z11) {
                                            }
                                            solverVariable11 = solverVariable8;
                                            solverVariable10 = solverVariable7;
                                            if (!z10) {
                                            }
                                            if (constraintWidget2.mCenter.isConnected()) {
                                            }
                                            constraintWidget2.resolvedHorizontal = false;
                                            constraintWidget2.resolvedVertical = false;
                                            return;
                                        }
                                        z9 = z3;
                                        z8 = z2;
                                        dimensionBehaviour2 = dimensionBehaviour4;
                                        dimensionBehaviour = dimensionBehaviour6;
                                        solverVariable4 = createObjectVariable5;
                                        solverVariable3 = createObjectVariable4;
                                        solverVariable2 = createObjectVariable3;
                                        solverVariable6 = createObjectVariable2;
                                        solverVariable5 = solverVariable;
                                        z10 = z6;
                                        if (z) {
                                        }
                                        z11 = true;
                                        if (constraintWidget.mVerticalResolution != 2 ? false : z11) {
                                        }
                                        solverVariable11 = solverVariable8;
                                        solverVariable10 = solverVariable7;
                                        if (!z10) {
                                        }
                                        if (constraintWidget2.mCenter.isConnected()) {
                                        }
                                        constraintWidget2.resolvedHorizontal = false;
                                        constraintWidget2.resolvedVertical = false;
                                        return;
                                    }
                                } else {
                                    i5 = -1;
                                }
                                z7 = false;
                                if (!z6) {
                                }
                                DimensionBehaviour dimensionBehaviour52 = this.mListDimensionBehaviors[0];
                                DimensionBehaviour dimensionBehaviour62 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour52 != dimensionBehaviour62) {
                                }
                                if (!z21) {
                                }
                                boolean z222 = !this.mCenter.isConnected();
                                boolean[] zArr22 = this.mIsInBarrier;
                                boolean z232 = zArr22[0];
                                boolean z242 = zArr22[1];
                                DependencyNode dependencyNode22 = horizontalWidgetRun.start;
                                if (!z) {
                                }
                            }
                        } else {
                            i9 = 3;
                        }
                        if (dimensionBehaviourArr[0] == dimensionBehaviour4 && i16 == i9) {
                            this.mResolvedDimensionRatioSide = 0;
                            i4 = (int) (f * ((float) i13));
                            if (dimensionBehaviourArr[1] != dimensionBehaviour4) {
                                i2 = i17;
                                i3 = i14;
                                c = 0;
                                z6 = false;
                                i = 4;
                                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                                iArr2[c] = i;
                                iArr2[1] = i2;
                                this.mResolvedHasRatio = z6;
                                if (z6) {
                                }
                                z7 = false;
                                if (!z6) {
                                }
                                DimensionBehaviour dimensionBehaviour522 = this.mListDimensionBehaviors[0];
                                DimensionBehaviour dimensionBehaviour622 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour522 != dimensionBehaviour622) {
                                }
                                if (!z21) {
                                }
                                boolean z2222 = !this.mCenter.isConnected();
                                boolean[] zArr222 = this.mIsInBarrier;
                                boolean z2322 = zArr222[0];
                                boolean z2422 = zArr222[1];
                                DependencyNode dependencyNode222 = horizontalWidgetRun.start;
                                if (!z) {
                                }
                            } else {
                                i = i16;
                                i2 = i17;
                                i3 = i14;
                                c = 0;
                                z6 = true;
                                int[] iArr22 = this.mResolvedMatchConstraintDefault;
                                iArr22[c] = i;
                                iArr22[1] = i2;
                                this.mResolvedHasRatio = z6;
                                if (z6) {
                                }
                                z7 = false;
                                if (!z6) {
                                }
                                DimensionBehaviour dimensionBehaviour5222 = this.mListDimensionBehaviors[0];
                                DimensionBehaviour dimensionBehaviour6222 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour5222 != dimensionBehaviour6222) {
                                }
                                if (!z21) {
                                }
                                boolean z22222 = !this.mCenter.isConnected();
                                boolean[] zArr2222 = this.mIsInBarrier;
                                boolean z23222 = zArr2222[0];
                                boolean z24222 = zArr2222[1];
                                DependencyNode dependencyNode2222 = horizontalWidgetRun.start;
                                if (!z) {
                                }
                            }
                        } else {
                            if (dimensionBehaviourArr[1] == dimensionBehaviour4 && i17 == 3) {
                                this.mResolvedDimensionRatioSide = 1;
                                if (i15 == -1) {
                                    this.mResolvedDimensionRatio = 1.0f / f;
                                }
                                int i20 = (int) (this.mResolvedDimensionRatio * ((float) i11));
                                c = 0;
                                i3 = i20;
                                i = i16;
                                if (dimensionBehaviourArr[0] != dimensionBehaviour4) {
                                    i4 = i12;
                                    z6 = false;
                                    i2 = 4;
                                    int[] iArr222 = this.mResolvedMatchConstraintDefault;
                                    iArr222[c] = i;
                                    iArr222[1] = i2;
                                    this.mResolvedHasRatio = z6;
                                    if (z6) {
                                    }
                                    z7 = false;
                                    if (!z6) {
                                    }
                                    DimensionBehaviour dimensionBehaviour52222 = this.mListDimensionBehaviors[0];
                                    DimensionBehaviour dimensionBehaviour62222 = DimensionBehaviour.WRAP_CONTENT;
                                    if (dimensionBehaviour52222 != dimensionBehaviour62222) {
                                    }
                                    if (!z21) {
                                    }
                                    boolean z222222 = !this.mCenter.isConnected();
                                    boolean[] zArr22222 = this.mIsInBarrier;
                                    boolean z232222 = zArr22222[0];
                                    boolean z242222 = zArr22222[1];
                                    DependencyNode dependencyNode22222 = horizontalWidgetRun.start;
                                    if (!z) {
                                    }
                                } else {
                                    i2 = i17;
                                    i4 = i12;
                                    z6 = true;
                                    int[] iArr2222 = this.mResolvedMatchConstraintDefault;
                                    iArr2222[c] = i;
                                    iArr2222[1] = i2;
                                    this.mResolvedHasRatio = z6;
                                    if (z6) {
                                    }
                                    z7 = false;
                                    if (!z6) {
                                    }
                                    DimensionBehaviour dimensionBehaviour522222 = this.mListDimensionBehaviors[0];
                                    DimensionBehaviour dimensionBehaviour622222 = DimensionBehaviour.WRAP_CONTENT;
                                    if (dimensionBehaviour522222 != dimensionBehaviour622222) {
                                    }
                                    if (!z21) {
                                    }
                                    boolean z2222222 = !this.mCenter.isConnected();
                                    boolean[] zArr222222 = this.mIsInBarrier;
                                    boolean z2322222 = zArr222222[0];
                                    boolean z2422222 = zArr222222[1];
                                    DependencyNode dependencyNode222222 = horizontalWidgetRun.start;
                                    if (!z) {
                                    }
                                }
                            }
                            c = 0;
                            i = i16;
                            i2 = i17;
                            i4 = i12;
                            i3 = i14;
                            z6 = true;
                            int[] iArr22222 = this.mResolvedMatchConstraintDefault;
                            iArr22222[c] = i;
                            iArr22222[1] = i2;
                            this.mResolvedHasRatio = z6;
                            if (z6) {
                            }
                            z7 = false;
                            if (!z6) {
                            }
                            DimensionBehaviour dimensionBehaviour5222222 = this.mListDimensionBehaviors[0];
                            DimensionBehaviour dimensionBehaviour6222222 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour5222222 != dimensionBehaviour6222222) {
                            }
                            if (!z21) {
                            }
                            boolean z22222222 = !this.mCenter.isConnected();
                            boolean[] zArr2222222 = this.mIsInBarrier;
                            boolean z23222222 = zArr2222222[0];
                            boolean z24222222 = zArr2222222[1];
                            DependencyNode dependencyNode2222222 = horizontalWidgetRun.start;
                            if (!z) {
                            }
                        }
                    }
                } else {
                    solverVariable = createObjectVariable;
                }
                c = 0;
                i = i16;
                i2 = i17;
                i4 = i12;
                i3 = i14;
                z6 = false;
                int[] iArr222222 = this.mResolvedMatchConstraintDefault;
                iArr222222[c] = i;
                iArr222222[1] = i2;
                this.mResolvedHasRatio = z6;
                if (z6) {
                }
                z7 = false;
                if (!z6) {
                }
                DimensionBehaviour dimensionBehaviour52222222 = this.mListDimensionBehaviors[0];
                DimensionBehaviour dimensionBehaviour62222222 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour52222222 != dimensionBehaviour62222222) {
                }
                if (!z21) {
                }
                boolean z222222222 = !this.mCenter.isConnected();
                boolean[] zArr22222222 = this.mIsInBarrier;
                boolean z232222222 = zArr22222222[0];
                boolean z242222222 = zArr22222222[1];
                DependencyNode dependencyNode22222222 = horizontalWidgetRun.start;
                if (!z) {
                }
            } else {
                z3 = z15;
                z2 = false;
                boolean[] zArr3 = this.mIsInBarrier;
            }
        }
        z3 = false;
        z2 = false;
        boolean[] zArr32 = this.mIsInBarrier;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        if ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0) + (this.mBaseline.mTarget != null ? 1 : 0) < 2) {
            return true;
        }
        return false;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 == null || !constraintAnchor3.hasFinalValue() || (constraintAnchor2 = this.mRight.mTarget) == null || !constraintAnchor2.hasFinalValue() || (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin()) < i2) {
                return false;
            }
            return true;
        }
        ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
        if (constraintAnchor4 == null || !constraintAnchor4.hasFinalValue() || (constraintAnchor = this.mBottom.mTarget) == null || !constraintAnchor.hasFinalValue() || (this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin()) < i2) {
            return false;
        }
        return true;
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int i) {
        return this.mIsInBarrier[i];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c = i == 0 ? (char) 1 : 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
            return true;
        }
        return false;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        serializeAnchor(sb, "left", this.mLeft);
        serializeAnchor(sb, "top", this.mTop);
        serializeAnchor(sb, "right", this.mRight);
        serializeAnchor(sb, "bottom", this.mBottom);
        serializeAnchor(sb, "baseline", this.mBaseline);
        serializeAnchor(sb, "centerX", this.mCenterX);
        serializeAnchor(sb, "centerY", this.mCenterY);
        serializeCircle(sb, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(sb, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        createObjectVariable5.setName(str + ".baseline");
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public void setDimensionRatio(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
                if (f > 0.0f) {
                    this.mDimensionRatio = f;
                    this.mDimensionRatioSide = i;
                    return;
                }
                return;
            }
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f = 0.0f;
        if (f > 0.0f) {
        }
    }

    public void setFinalBaseline(int i) {
        if (this.hasBaseline) {
            int i2 = i - this.mBaselineDistance;
            int i3 = this.mHeight + i2;
            this.mY = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3);
            this.mBaseline.setFinalValue(i);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i6 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i6 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        if (!this.resolvedHorizontal) {
            this.mLeft.setFinalValue(i);
            this.mRight.setFinalValue(i2);
            this.mX = i;
            this.mWidth = i2 - i;
            this.resolvedHorizontal = true;
        }
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.mY = i;
    }

    public void setFinalVertical(int i, int i2) {
        if (!this.resolvedVertical) {
            this.mTop.setFinalValue(i);
            this.mBottom.setFinalValue(i2);
            this.mY = i;
            this.mHeight = i2 - i;
            if (this.hasBaseline) {
                this.mBaseline.setFinalValue(i + this.mBaselineDistance);
            }
            this.resolvedVertical = true;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
        int i11 = this.mMatchConstraintMaxWidth;
        if (i11 > 0 && dimensionBehaviourArr[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i11);
        }
        int i12 = this.mMatchConstraintMaxHeight;
        if (i12 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i12);
        }
        int i13 = this.mWidth;
        if (i7 != i13) {
            this.mWidthOverride = i13;
        }
        int i14 = this.mHeight;
        if (i8 != i14) {
            this.mHeightOverride = i14;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        } else if (i2 == 5) {
            this.mBaseline.mGoneMargin = i;
        }
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtualLayout = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapBehaviorInParent(int i) {
        if (i >= 0 && i <= 3) {
            this.mWrapBehaviorInParent = i;
        }
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append(jl1.BRACKET_START_STR);
        sb.append(this.mX);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.mX = i3;
        }
        if (isResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor = getAnchor(type4);
                ConstraintAnchor anchor2 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor.connect(anchor2, 0);
                anchor3.connect(anchor2, 0);
                getAnchor(type6).connect(anchor2, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor4 = constraintWidget.getAnchor(type2);
                getAnchor(type3).connect(anchor4, 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor4, 0);
                getAnchor(type7).connect(anchor4, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
                getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                getAnchor(type7).connect(constraintWidget.getAnchor(type2), 0);
            } else {
                ConstraintAnchor anchor5 = getAnchor(type);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                if (anchor5.isValidConnection(anchor6)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor7 != null) {
                            anchor7.reset();
                        }
                        if (anchor8 != null) {
                            anchor8.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor9 = getAnchor(type12);
                        if (anchor9 != null) {
                            anchor9.reset();
                        }
                        ConstraintAnchor anchor10 = getAnchor(type5);
                        if (anchor10.getTarget() != anchor6) {
                            anchor10.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor11 = getAnchor(type7);
                        if (anchor11.isConnected()) {
                            opposite.reset();
                            anchor11.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor12 = getAnchor(type5);
                        if (anchor12.getTarget() != anchor6) {
                            anchor12.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor13 = getAnchor(type6);
                        if (anchor13.isConnected()) {
                            opposite2.reset();
                            anchor13.reset();
                        }
                    }
                    anchor5.connect(anchor6, i);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor anchor14 = getAnchor(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor anchor15 = getAnchor(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor anchor16 = getAnchor(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor anchor17 = getAnchor(type16);
            boolean z2 = true;
            if ((anchor14 == null || !anchor14.isConnected()) && (anchor15 == null || !anchor15.isConnected())) {
                connect(type13, constraintWidget, type13, 0);
                connect(type14, constraintWidget, type14, 0);
                z = true;
            } else {
                z = false;
            }
            if ((anchor16 == null || !anchor16.isConnected()) && (anchor17 == null || !anchor17.isConnected())) {
                connect(type15, constraintWidget, type15, 0);
                connect(type16, constraintWidget, type16, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
            } else if (z) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            } else if (z2) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(type19, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(type20, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            }
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }
}
