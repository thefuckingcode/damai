package com.taobao.android.dinamicx.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXDarkModeCenter;
import com.taobao.android.dinamicx.DXRenderPipeline;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.h;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.weex.common.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.at;
import tb.ay;
import tb.b10;
import tb.c10;
import tb.d00;
import tb.f00;
import tb.ft;
import tb.j00;
import tb.jl1;
import tb.jy;
import tb.jz;
import tb.ks;
import tb.lx;
import tb.o70;
import tb.py;
import tb.q42;
import tb.rs;
import tb.ry;
import tb.t81;
import tb.tx;
import tb.ux;
import tb.v00;
import tb.vx;

/* compiled from: Taobao */
public class DXWidgetNode implements IDXBuilderWidgetNode {
    public static final int ACCESSIBILITY_AUTO = 3;
    public static final int ACCESSIBILITY_DEF = -1;
    public static final int ACCESSIBILITY_OFF = 0;
    public static final int ACCESSIBILITY_OFF_CHILD = 2;
    public static final int ACCESSIBILITY_ON = 1;
    public static final int BORDER_TYPE_DASH = 1;
    public static final int BORDER_TYPE_NORMAL = 0;
    public static final int DIRECTION_NOT_SET = -1;
    public static final int DXGRAVITY_RLT_DELTA = 6;
    public static final int DXGravityCenter = 4;
    public static final int DXGravityCenterBottom = 5;
    public static final int DXGravityCenterTop = 3;
    public static final int DXGravityLeftBottom = 2;
    public static final int DXGravityLeftCenter = 1;
    public static final int DXGravityLeftTop = 0;
    public static final int DXGravityRightBottom = 8;
    public static final int DXGravityRightCenter = 7;
    public static final int DXGravityRightTop = 6;
    public static final long DXVIEW_ONCREATEVIEW = 188822591186414296L;
    private static final long DXVIEW_TBORDERJSON = -1688385493169466985L;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_ALL = 3;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_CHILD = 2;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_SELF = 1;
    public static final int DX_VIEW_EVENTRESPONSEMODE_NORMAL = 0;
    public static final int DX_WIDGET_NODE_ATTR_PARSED = 2;
    public static final int DX_WIDGET_NODE_BIND_CHILD_CALLED = 4096;
    public static final int DX_WIDGET_NODE_FLATTEND = 128;
    public static final int DX_WIDGET_NODE_FORCE_LAYOUT = 16384;
    public static final int DX_WIDGET_NODE_IS_PRE_RENDERED = 8192;
    public static final int DX_WIDGET_NODE_LAID_OUT = 32;
    public static final int DX_WIDGET_NODE_MEASURED = 8;
    public static final int DX_WIDGET_NODE_NEED_FLATTEN = 64;
    public static final int DX_WIDGET_NODE_NEED_LAYOUT = 16;
    public static final int DX_WIDGET_NODE_NEED_MEASURE = 4;
    public static final int DX_WIDGET_NODE_NEED_PARSE = 1;
    public static final int DX_WIDGET_NODE_NEED_RENDER = 256;
    public static final int DX_WIDGET_NODE_PARSED = 32768;
    public static final int DX_WIDGET_NODE_PARSE_IN_MEASURE = 1024;
    public static final int DX_WIDGET_NODE_RENDERED = 512;
    public static final int DX_WIDGET_NODE_VISIBILITY_PARSED = 2048;
    public static final int GONE = 2;
    public static final int INVISIBLE = 1;
    public static final int IS_ACCESSIBILITY_FALSE = 0;
    public static final int IS_ACCESSIBILITY_TRUE = 1;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int LAYOUT_GRAVITY_INIT_MASK = 1;
    public static final int LISTDATA_INIT_MASK = 2;
    public static final int MATCH_CONTENT = -2;
    public static final int MATCH_PARENT = -1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int NO = 0;
    public static final int TAG_WIDGET_NODE = R$id.dinamicXWidgetNodeTag;
    public static final int VISIBLE = 0;
    public static final int YES = 1;
    private static ThreadLocal<py> attributeThreadLocal = new ThreadLocal<>();
    private static boolean sAlwaysRemeasureExactly = false;
    private int DEFAULT;
    int accessibility;
    String accessibilityText;
    float alpha;
    String animation;
    private ks animationHolder;
    private int autoId;
    int backGroundColor;
    private d backgroundGradient;
    Map<String, rs> bindingXExecutingMap;
    Map<String, rs> bindingXSpecMap;
    int borderColor;
    int borderType;
    int borderWidth;
    int bottom;
    int childGravity;
    List<DXWidgetNode> children;
    private int childrenCount;
    boolean clipChildren;
    int cornerRadius;
    int cornerRadiusLeftBottom;
    int cornerRadiusLeftTop;
    int cornerRadiusRightBottom;
    int cornerRadiusRightTop;
    DXRuntimeContext dXRuntimeContext;
    private HashMap<String, Integer> darkModeColorMap;
    int dashGap;
    int dashWidth;
    private DXLongSparseArray<ay> dataParsersExprNode;
    private int direction;
    private boolean disableDarkMode;
    private tx dxEventChains;
    private byte[] dxExprBytes;
    private DXWidgetNode dxRootWidgetCache;
    int enabled;
    private DXLongSparseArray<Map<String, Integer>> enumMap;
    private DXLongSparseArray<ay> eventHandlersExprNode;
    int eventResponseMode;
    private JSONArray exportMethods;
    private boolean hasHandleDark;
    boolean isFlatten;
    private int lastAutoId;
    int layoutGravity;
    int layoutHeight;
    int layoutWidth;
    int left;
    private DXLongSparseArray<ay> mCodeMap;
    int marginBottom;
    int marginLeft;
    int marginRight;
    int marginTop;
    int measuredHeight;
    int measuredWidth;
    int minHeight;
    int minWidth;
    boolean needSetBackground;
    int oldHeightMeasureSpec;
    int oldWidthMeasureSpec;
    private boolean openNewFastReturnLogic;
    int paddingBottom;
    int paddingLeft;
    int paddingRight;
    int paddingTop;
    private JSONObject paramsInfo;
    DXWidgetNode parentWidget;
    int privateFlags;
    int propertyInitFlag;
    private py realLayoutAttribute;
    String ref;
    private WeakReference<DXWidgetNode> referenceNode;
    int right;
    float rotationX;
    float rotationY;
    float rotationZ;
    float scaleX;
    float scaleY;
    private JSONArray slotInfo;
    private JSONObject slotInfoJObj;
    private boolean softwareRender;
    private WeakReference<DXWidgetNode> sourceWidgetWR;
    private JSONObject tborderJson;
    int top;
    float translateX;
    float translateY;
    String userId;
    int visibility;
    private WeakReference<View> weakView;
    double weight;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXGravity {
    }

    /* compiled from: Taobao */
    public static class DXMeasureSpec {
        public static final int AT_MOST = Integer.MIN_VALUE;
        public static final int EXACTLY = 1073741824;
        public static final int UNSPECIFIED = 0;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: Taobao */
        public @interface MeasureSpecMode {
        }

        @SuppressLint({"WrongConstant"})
        public static int a(int i) {
            return i & -1073741824;
        }

        public static int b(int i) {
            return i & t81.MAX_CAPACITY_MASK;
        }

        public static int c(@IntRange(from = 0, to = 1073741823) int i, int i2) {
            return (i & t81.MAX_CAPACITY_MASK) | (i2 & -1073741824);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXNodePropertyInitMask {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface DXWidgetNodeStatFlag {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            DXWidgetNode.this.onTapEvent();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnLongClickListener {
        b() {
        }

        public boolean onLongClick(View view) {
            DXWidgetNode.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    public static class c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXWidgetNode();
        }
    }

    /* compiled from: Taobao */
    public static class d {
        private int a = -1;
        private GradientDrawable.Orientation b;
        private int[] c;

        public int a() {
            return this.a;
        }

        public int[] b() {
            return this.c;
        }

        public GradientDrawable.Orientation c() {
            return this.b;
        }

        public void d(int i) {
            this.a = i;
        }

        public void e(int[] iArr) {
            this.c = iArr;
        }

        public void f(GradientDrawable.Orientation orientation) {
            this.b = orientation;
        }
    }

    public DXWidgetNode() {
        this.layoutGravity = 0;
        this.childGravity = 0;
        this.alpha = 1.0f;
        this.cornerRadius = 0;
        this.cornerRadiusLeftTop = 0;
        this.cornerRadiusRightTop = 0;
        this.cornerRadiusLeftBottom = 0;
        this.cornerRadiusRightBottom = 0;
        this.borderWidth = -1;
        this.borderColor = 0;
        this.borderType = 0;
        this.dashWidth = -1;
        this.dashGap = -1;
        this.backGroundColor = 0;
        this.openNewFastReturnLogic = false;
        this.clipChildren = true;
        this.eventResponseMode = 0;
        this.softwareRender = false;
        this.DEFAULT = 0;
        this.translateX = (float) 0;
        this.translateY = (float) 0;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.rotationX = (float) 0;
        this.rotationY = (float) 0;
        this.rotationZ = (float) 0;
        this.disableDarkMode = false;
        this.oldWidthMeasureSpec = Integer.MIN_VALUE;
        this.oldHeightMeasureSpec = Integer.MIN_VALUE;
        this.visibility = 0;
        this.layoutGravity = 0;
        this.childGravity = 0;
        this.direction = -1;
        this.alpha = 1.0f;
        this.accessibility = -1;
        this.enabled = 1;
        this.eventResponseMode = 0;
    }

    private void bindChildrenMeasureFlag(DXWidgetRefreshOption dXWidgetRefreshOption) {
        List<DXWidgetNode> list = null;
        if (!isMarkContainerLayout()) {
            list = getChildren();
        } else if (dXWidgetRefreshOption.a() == 0) {
            return;
        } else {
            if (1 == dXWidgetRefreshOption.a()) {
                if (this instanceof DXScrollLayoutBase) {
                    list = ((DXScrollLayoutBase) this).itemWidgetNodes;
                }
                if (this instanceof DXAbsContainerBaseLayout) {
                    list = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
                }
            } else if (2 == dXWidgetRefreshOption.a()) {
                return;
            }
        }
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                DXWidgetNode dXWidgetNode = list.get(i);
                dXWidgetNode.setStatFlag(16384);
                dXWidgetNode.setStatFlag(4);
                dXWidgetNode.unsetStatFlag(8);
                dXWidgetNode.unsetStatFlag(32);
                dXWidgetNode.bindChildrenParseFlag(dXWidgetRefreshOption);
            }
        }
    }

    private void bindChildrenParseFlag(DXWidgetRefreshOption dXWidgetRefreshOption) {
        List<DXWidgetNode> list = null;
        if (isMarkContainerLayout()) {
            if (dXWidgetRefreshOption.a() == 0) {
                return;
            }
            if (1 == dXWidgetRefreshOption.a()) {
                if (this instanceof DXScrollLayoutBase) {
                    list = ((DXScrollLayoutBase) this).itemWidgetNodes;
                }
                if (this instanceof DXAbsContainerBaseLayout) {
                    list = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
                }
            } else if (2 == dXWidgetRefreshOption.a()) {
                unsetStatFlag(4096);
                return;
            }
        } else if (this instanceof DXScrollLayoutBase) {
            list = ((DXScrollLayoutBase) this).itemWidgetNodes;
        } else if (this instanceof DXAbsContainerBaseLayout) {
            list = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
        } else {
            list = getChildren();
        }
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                DXWidgetNode dXWidgetNode = list.get(i);
                if (dXWidgetRefreshOption.a() != 0 || !dXWidgetNode.isMarkContainerLayout()) {
                    dXWidgetNode.setStatFlag(1);
                    dXWidgetNode.unsetStatFlag(2);
                    dXWidgetNode.setStatFlag(16384);
                    dXWidgetNode.setStatFlag(4);
                    dXWidgetNode.unsetStatFlag(8);
                    dXWidgetNode.unsetStatFlag(32);
                    dXWidgetNode.setStatFlag(256);
                    if (!dXWidgetNode.isMarkContainerLayout()) {
                        dXWidgetNode.unsetStatFlag(4096);
                    }
                    dXWidgetNode.bindChildrenParseFlag(dXWidgetRefreshOption);
                }
            }
        }
    }

    private void bindParentMeasureFlag(boolean z, boolean z2) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & -41;
        if (!at.A0() || !(this.parentWidget instanceof DXRecyclerLayout)) {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode != null) {
                dXWidgetNode.bindParentMeasureFlag(z, z2);
            } else if (z) {
                sendPartParserEvent(z2);
            } else {
                sendPartMeasureLayoutEvent(z2);
            }
        } else {
            updateRefreshType(1);
            if (z) {
                setStatFlag(1);
            } else {
                setStatFlag(4);
            }
            ((DXRecyclerLayout) this.parentWidget).refreshCurrentNode(this);
        }
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return (i2 != 0 && i2 == 1) ? (i == 0 || i == 1 || i == 2) ? i + 6 : (i == 6 || i == 7 || i == 8) ? i - 6 : i : i;
    }

    public static int getDefaultSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.getSize(i2) : i;
    }

    private View getRealView() {
        WeakReference<View> weakReference = this.weakView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean isMarkContainerLayout() {
        if ((this instanceof DXAbsContainerBaseLayout) || (this instanceof DXScrollLayoutBase)) {
            return ((f) this).isMarkContainer();
        }
        return false;
    }

    private void parseTreeInfo(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        List<DXWidgetNode> list = this.children;
        if (list != null) {
            for (DXWidgetNode dXWidgetNode : list) {
                dXWidgetNode.parseTreeInfo(jSONObject2);
            }
        }
        jSONObject.put(toSelfWidgetNodeInfo(), (Object) jSONObject2);
    }

    private void prePareBindEvent(long j) {
        lx lxVar = new lx(j);
        lxVar.e(true);
        postEvent(lxVar);
    }

    private DXWidgetNode queryWidgetNodeByUserIdFromMap(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(getUserId())) {
            return this;
        }
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (!(queryRootWidgetNode instanceof f)) {
            return null;
        }
        Map<String, WeakReference<DXWidgetNode>> dxUserIdMap = ((f) queryRootWidgetNode).getDxUserIdMap();
        if (dxUserIdMap == null) {
            return queryWTByUserId(str);
        }
        WeakReference<DXWidgetNode> weakReference = dxUserIdMap.get(str);
        if (weakReference == null) {
            return queryWTByUserId(str);
        }
        DXWidgetNode dXWidgetNode = weakReference.get();
        return dXWidgetNode == null ? queryWTByUserId(str) : dXWidgetNode;
    }

    private void refreshRecyclerLayout() {
        if (this instanceof DXRecyclerLayout) {
            DXRecyclerLayout dXRecyclerLayout = (DXRecyclerLayout) this;
            jy jyVar = new jy();
            jyVar.i(DXRecyclerLayout.MSG_METHOD_REFRESH_DATA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", (Object) dXRecyclerLayout.getDataSource());
            jyVar.j(jSONObject);
            dXRecyclerLayout.postEvent(jyVar);
        }
    }

    public static int resolveSize(int i, int i2) {
        return resolveSizeAndState(i, i2, 0) & 16777215;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        int a2 = DXMeasureSpec.a(i2);
        int b2 = DXMeasureSpec.b(i2);
        if (a2 != Integer.MIN_VALUE) {
            if (a2 == 1073741824) {
                i = b2;
            }
        } else if (b2 < i) {
            i = 16777216 | b2;
        }
        return i | (-16777216 & i3);
    }

    private void sendPartMeasureLayoutEvent(boolean z) {
        DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
        if (dXRuntimeContext2 != null) {
            DXRenderPipeline dxRenderPipeline = dXRuntimeContext2.getDxRenderPipeline();
            ft dxControlEventCenter = dXRuntimeContext2.getDxControlEventCenter();
            if (dxRenderPipeline != null && dxControlEventCenter != null) {
                h j = dxRenderPipeline.j();
                if (j != null) {
                    j.j(dXRuntimeContext2.getCacheIdentify());
                }
                jz jzVar = new jz();
                jzVar.d = 3;
                jzVar.a = this;
                jzVar.e = 1;
                jzVar.f = z;
                if (z) {
                    dxControlEventCenter.a(jzVar);
                } else {
                    dxControlEventCenter.b(jzVar);
                }
            }
        }
    }

    private void sendPartParserEvent(boolean z) {
        DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
        if (dXRuntimeContext2 != null) {
            DXRenderPipeline dxRenderPipeline = dXRuntimeContext2.getDxRenderPipeline();
            ft dxControlEventCenter = dXRuntimeContext2.getDxControlEventCenter();
            if (dxRenderPipeline != null && dxControlEventCenter != null) {
                h j = dxRenderPipeline.j();
                if (j != null) {
                    j.j(dXRuntimeContext2.getCacheIdentify());
                }
                jz jzVar = new jz();
                jzVar.d = 2;
                jzVar.e = 1;
                jzVar.a = this;
                jzVar.f = z;
                if (z) {
                    dxControlEventCenter.a(jzVar);
                } else {
                    dxControlEventCenter.b(jzVar);
                }
            }
        }
    }

    public final void addChild(DXWidgetNode dXWidgetNode) {
        addChild(dXWidgetNode, true);
    }

    public void applyTransform(View view, Object obj) {
        List<Animator> list;
        float f;
        float f2;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("transform");
            String string2 = jSONObject.getString("transition");
            try {
                List<b10.a> b2 = b10.b(string);
                float f3 = 1.0f;
                int i = 0;
                if (b2 != null) {
                    f = 1.0f;
                    for (b10.a aVar : b2) {
                        int i2 = aVar.a;
                        if (i2 == 6) {
                            float[] fArr = aVar.b;
                            f3 *= fArr[0];
                            f2 = fArr[1];
                        } else if (i2 == 7) {
                            f3 *= aVar.b[0];
                        } else if (i2 == 8) {
                            f2 = aVar.b[0];
                        } else {
                            throw new IllegalArgumentException("Invalid Transform method: " + aVar.a);
                        }
                        f *= f2;
                    }
                } else {
                    f = 1.0f;
                }
                view.setScaleX(f3);
                view.setScaleY(f);
                List<c10.e> e = c10.e(string2, null, null, null, null);
                float floatValue = jSONObject.getFloatValue("opacity");
                String string3 = jSONObject.getString("backgroundColor");
                if (!TextUtils.isEmpty(string3)) {
                    i = Color.parseColor(string3);
                }
                list = c10.g(e, view, floatValue, i);
            } catch (Throwable unused) {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                ks ksVar = this.animationHolder;
                if (ksVar != null) {
                    ksVar.d();
                    this.animationHolder = null;
                    return;
                }
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(0);
            animatorSet.playTogether(list);
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorSet);
            ks ksVar2 = new ks(arrayList);
            this.animationHolder = ksVar2;
            ksVar2.c();
        }
    }

    public final void beginParser(boolean z) {
        onBeginParser();
        onBeginParser(z);
    }

    /* access modifiers changed from: package-private */
    public void bindDataEvent() {
        postEvent(new lx(2683803675109176030L));
    }

    public final void bindEvent(Context context) {
        if (this.eventHandlersExprNode != null) {
            View realView = getRealView();
            for (int i = 0; i < this.eventHandlersExprNode.size(); i++) {
                getReferenceNode().onBindEvent(context, realView, this.eventHandlersExprNode.keyAt(i));
            }
        }
    }

    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext2) {
        bindRuntimeContext(dXRuntimeContext2, false);
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXWidgetNode();
    }

    public boolean containsExecutingAnimationSpec(String str) {
        Map<String, rs> map = this.bindingXExecutingMap;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.bindingXExecutingMap.containsKey(str);
    }

    public final View createView(Context context) {
        View realView = getRealView();
        if (realView == null) {
            realView = getReferenceNode().onCreateView(context);
            this.privateFlags |= 256;
            if (realView == null && at.j0(this)) {
                return null;
            }
            realView.setTag(TAG_WIDGET_NODE, this);
            this.weakView = new WeakReference<>(realView);
            if (this.softwareRender) {
                realView.setLayerType(1, null);
            }
            postEvent(new lx(DXVIEW_ONCREATEVIEW));
        }
        return realView;
    }

    public DXWidgetNode deepClone(DXRuntimeContext dXRuntimeContext2) {
        DXWidgetNode dXWidgetNode = (DXWidgetNode) shallowClone(dXRuntimeContext2, true);
        if (this.children != null) {
            dXWidgetNode.children = new ArrayList();
            for (int i = 0; i < this.children.size(); i++) {
                dXWidgetNode.addChild(this.children.get(i).deepClone(dXRuntimeContext2));
            }
        }
        return dXWidgetNode;
    }

    public final void endParser(boolean z) {
        if (at.P0(getDXRuntimeContext())) {
            processUserId();
        }
        onEndParser();
        onEndParser(z);
    }

    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() {
                /* class com.taobao.android.dinamicx.widget.DXWidgetNode.AnonymousClass1 */

                {
                    add("render");
                    add("refresh");
                    add("getBoundingClientRect");
                    add("commit");
                }
            };
        }
        return this.exportMethods;
    }

    /* access modifiers changed from: protected */
    public boolean extraHandleDark() {
        return false;
    }

    public int getAccessibility() {
        return this.accessibility;
    }

    public String getAccessibilityText() {
        return this.accessibilityText;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public String getAnimation() {
        return this.animation;
    }

    public int getAutoId() {
        return this.autoId;
    }

    public int getBackGroundColor() {
        return this.backGroundColor;
    }

    public d getBackgroundGradient() {
        return this.backgroundGradient;
    }

    public Map<String, rs> getBindingXExecutingMap() {
        return this.bindingXExecutingMap;
    }

    public Map<String, rs> getBindingXSpecMap() {
        return this.bindingXSpecMap;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public int getBorderType() {
        return this.borderType;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    public int getBottom() {
        return this.bottom;
    }

    public DXWidgetNode getChildAt(int i) {
        List<DXWidgetNode> list;
        if (i < 0 || i >= this.childrenCount || (list = this.children) == null) {
            return null;
        }
        return list.get(i);
    }

    public int getChildGravity() {
        return this.childGravity;
    }

    public List<DXWidgetNode> getChildren() {
        return this.children;
    }

    public int getChildrenCount() {
        return this.childrenCount;
    }

    public DXLongSparseArray<ay> getCodeMap() {
        return this.mCodeMap;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getCornerRadiusLeftBottom() {
        return this.cornerRadiusLeftBottom;
    }

    public int getCornerRadiusLeftTop() {
        return this.cornerRadiusLeftTop;
    }

    public int getCornerRadiusRightBottom() {
        return this.cornerRadiusRightBottom;
    }

    public int getCornerRadiusRightTop() {
        return this.cornerRadiusRightTop;
    }

    public DXRuntimeContext getDXRuntimeContext() {
        return this.dXRuntimeContext;
    }

    public LongSparseArray<ay> getDataParsersExprNode() {
        return this.dataParsersExprNode;
    }

    public Object getDefaultValueForAttr(long j) {
        return null;
    }

    public double getDefaultValueForDoubleAttr(long j) {
        return 0.0d;
    }

    public int getDefaultValueForIntAttr(long j) {
        if (20052926345925L == j || 9346582897824575L == j || -916628110244908525L == j || -4674119579031497081L == j || -2641581645694792774L == j || 6506044224063169535L == j || -378913133726214547L == j || 3229586316762092001L == j || -2632461973017864940L == j || -4745829179314597287L == j || 4879707785646574221L == j || -3218010051991756042L == j || 7504432960089273802L == j || 5802348655878590802L == j || -8019934667170236535L == j || -8020113231441560440L == j || 1844153004063100714L == j || -6579663421190292502L == j || -5241271604340946425L == j || 3998176004939777025L == j) {
            return 0;
        }
        return (16887479372907L == j || 4804789929613330386L == j) ? 1 : 0;
    }

    public JSONArray getDefaultValueForListAttr(long j) {
        return null;
    }

    public long getDefaultValueForLongAttr(long j) {
        return 0;
    }

    public JSONObject getDefaultValueForMapAttr(long j) {
        return null;
    }

    public Object getDefaultValueForObjectAttr(long j) {
        return null;
    }

    public String getDefaultValueForStringAttr(long j) {
        return "";
    }

    public int getDirection() {
        int i = this.direction;
        if (i != -1) {
            return i;
        }
        DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
        if (dXRuntimeContext2 != null) {
            return dXRuntimeContext2.getParentDirectionSpec();
        }
        return 0;
    }

    public tx getDxEventChains() {
        return this.dxEventChains;
    }

    public byte[] getDxExprBytes() {
        return this.dxExprBytes;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public DXLongSparseArray<Map<String, Integer>> getEnumMap() {
        return this.enumMap;
    }

    public LongSparseArray<ay> getEventHandlersExprNode() {
        return this.eventHandlersExprNode;
    }

    public int getEventResponseMode() {
        return this.eventResponseMode;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getLastAutoId() {
        return this.lastAutoId;
    }

    /* access modifiers changed from: protected */
    public int getLayoutDirection() {
        return getDirection();
    }

    public int getLayoutGravity() {
        return this.layoutGravity;
    }

    public int getLayoutHeight() {
        return this.layoutHeight;
    }

    public int getLayoutWidth() {
        return this.layoutWidth;
    }

    public int getLeft() {
        return this.left;
    }

    public int getLeftMarginWithDirection() {
        if (getDirection() == 1) {
            return this.marginRight;
        }
        return this.marginLeft;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public int getMarginLeft() {
        return this.marginLeft;
    }

    public int getMarginRight() {
        return this.marginRight;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public final int getMeasuredHeight() {
        return this.measuredHeight & 16777215;
    }

    public final int getMeasuredHeightAndState() {
        return this.measuredHeight;
    }

    public final int getMeasuredState() {
        return (this.measuredWidth & -16777216) | ((this.measuredHeight >> 16) & InputDeviceCompat.SOURCE_ANY);
    }

    public final int getMeasuredWidth() {
        return this.measuredWidth & 16777215;
    }

    public final int getMeasuredWidthAndState() {
        return this.measuredWidth;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(DXWidgetNode dXWidgetNode) {
        return 0;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPaddingLeftWithDirection() {
        if (getDirection() == 1) {
            return this.paddingRight;
        }
        return this.paddingLeft;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public int getPaddingRightWithDirection() {
        if (getDirection() == 1) {
            return this.paddingLeft;
        }
        return this.paddingRight;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public JSONObject getParamsInfo() {
        return this.paramsInfo;
    }

    public DXWidgetNode getParentWidget() {
        return this.parentWidget;
    }

    public String getRef() {
        return this.ref;
    }

    public DXWidgetNode getReferenceNode() {
        WeakReference<DXWidgetNode> weakReference = this.referenceNode;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int getRight() {
        return this.right;
    }

    public int getRightMarginWithDirection() {
        if (getDirection() == 1) {
            return this.marginLeft;
        }
        return this.marginRight;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public JSONArray getSlotInfo() {
        return this.slotInfo;
    }

    public JSONObject getSlotInfoJObj() {
        return this.slotInfoJObj;
    }

    public DXWidgetNode getSourceWidget() {
        WeakReference<DXWidgetNode> weakReference = this.sourceWidgetWR;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean getStatInPrivateFlags(int i) {
        return (this.privateFlags & i) == i;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return this.minHeight;
    }

    /* access modifiers changed from: protected */
    public final int getSuggestedMinimumWidth() {
        return this.minWidth;
    }

    public JSONObject getTborderJson() {
        return this.tborderJson;
    }

    public int getTop() {
        return this.top;
    }

    public float getTranslateX() {
        return this.translateX;
    }

    public float getTranslateY() {
        return this.translateY;
    }

    public String getUserId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public final DXWidgetNode getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return this.childrenCount;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public WeakReference<View> getWRView() {
        return this.weakView;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.right - this.left;
    }

    public boolean hasAccessibilityAuto() {
        return this.accessibility == 3;
    }

    public boolean hasAccessibilityOn() {
        return this.accessibility == 1;
    }

    public boolean hasCornerRadius() {
        return this.cornerRadiusLeftTop > 0 || this.cornerRadiusRightBottom > 0 || this.cornerRadiusLeftBottom > 0 || this.cornerRadiusRightTop > 0 || this.cornerRadius > 0;
    }

    public boolean hasExecutingAnimationSpec() {
        Map<String, rs> map = this.bindingXExecutingMap;
        if (map != null && map.size() > 0) {
            return true;
        }
        return false;
    }

    public int indexOf(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return -1;
        }
        for (int i = 0; i < getChildrenCount(); i++) {
            if (getChildAt(i).getAutoId() == dXWidgetNode.getAutoId()) {
                return i;
            }
        }
        return -1;
    }

    public void insertChild(DXWidgetNode dXWidgetNode, int i) {
        insertChild(dXWidgetNode, i, true);
    }

    public final void invalidateLayoutCache() {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & -41;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.invalidateLayoutCache();
        }
    }

    public final void invalidateParseCache() {
        int i = this.privateFlags & -3;
        this.privateFlags = i;
        this.privateFlags = i | 1;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.invalidateParseCache();
        }
    }

    @UiThread
    @Deprecated
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        View nativeView;
        if ("getBoundingClientRect".equals(str)) {
            if (getDXRuntimeContext() == null || (nativeView = getDXRuntimeContext().getNativeView()) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            int measuredWidth2 = nativeView.getMeasuredWidth();
            int measuredHeight2 = nativeView.getMeasuredHeight();
            int[] iArr = new int[2];
            nativeView.getLocationOnScreen(iArr);
            float c2 = ((float) q42.c(getDXRuntimeContext().getContext())) / 375.0f;
            jSONObject.put(Constants.Name.X, (Object) Float.valueOf(((float) iArr[0]) / c2));
            jSONObject.put(Constants.Name.Y, (Object) Float.valueOf(((float) iArr[1]) / c2));
            jSONObject.put("left", (Object) Float.valueOf(((float) iArr[0]) / c2));
            jSONObject.put("top", (Object) Float.valueOf(((float) iArr[1]) / c2));
            jSONObject.put("width", (Object) Float.valueOf(((float) measuredWidth2) / c2));
            jSONObject.put("height", (Object) Float.valueOf(((float) measuredHeight2) / c2));
            jSONObject.put("right", (Object) Float.valueOf(((float) (iArr[0] + measuredWidth2)) / c2));
            jSONObject.put("bottom", (Object) Float.valueOf(((float) (iArr[1] + measuredHeight2)) / c2));
            return jSONObject;
        } else if (!"commit".equals(str) || getDXRuntimeContext() == null || getDXRuntimeContext().getNativeView() == null) {
            return null;
        } else {
            try {
                applyTransform(getDXRuntimeContext().getNativeView(), jSONArray.get(0));
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    public boolean isChildResponseEvent() {
        int i = this.eventResponseMode;
        return i == 0 || i == 1;
    }

    public boolean isChildWidgetNode() {
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        return queryRootWidgetNode != null && (queryRootWidgetNode.getParentWidget() instanceof DXTemplateWidgetNode);
    }

    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public boolean isDisableDarkMode() {
        return this.disableDarkMode;
    }

    public boolean isFlatten() {
        return this.isFlatten;
    }

    public boolean isNeedSetBackground() {
        return this.needSetBackground;
    }

    public boolean isOpenNewFastReturnLogic() {
        return this.openNewFastReturnLogic;
    }

    public boolean isSelfResponseEvent() {
        int i = this.eventResponseMode;
        return i == 0 || i == 2;
    }

    public final void layout(int i, int i2, int i3, int i4) {
        try {
            if ((this.privateFlags & 4) != 0) {
                onMeasure(this.oldWidthMeasureSpec, this.oldHeightMeasureSpec);
                int i5 = this.privateFlags & -5;
                this.privateFlags = i5;
                this.privateFlags = i5 | 8;
            }
            boolean frame = setFrame(i, i2, i3, i4);
            if (frame || (this.privateFlags & 16) == 16) {
                onLayout(frame, i, i2, i3, i4);
                this.privateFlags &= -17;
                DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
                if (dXRuntimeContext2 != null && dXRuntimeContext2.isRefreshPart()) {
                    this.privateFlags |= 256;
                }
            }
            int i6 = this.privateFlags & -16385;
            this.privateFlags = i6;
            this.privateFlags = i6 | 32;
        } catch (Exception e) {
            vx.b(e);
            DXRuntimeContext dXRuntimeContext3 = getDXRuntimeContext();
            if (dXRuntimeContext3 != null && dXRuntimeContext3.getDxError() != null) {
                e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformLayout", e.DXERROR_DETAIL_ON_LAYOUT_ERROR);
                aVar.e = vx.a(e);
                dXRuntimeContext3.getDxError().c.add(aVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0079 A[ADDED_TO_REGION, Catch:{ all -> 0x008f }] */
    public final void measure(int i, int i2) {
        boolean z;
        boolean z2;
        try {
            boolean z3 = true;
            boolean z4 = (this.privateFlags & 16384) == 16384;
            if (i == this.oldWidthMeasureSpec) {
                if (i2 == this.oldHeightMeasureSpec) {
                    z = false;
                    z2 = DXMeasureSpec.a(i) != 1073741824 && DXMeasureSpec.a(i2) == 1073741824;
                    boolean z5 = getMeasuredWidth() != DXMeasureSpec.b(i) && getMeasuredHeight() == DXMeasureSpec.b(i2);
                    DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
                    boolean statInPrivateFlags = (dXRuntimeContext2 != null || !dXRuntimeContext2.isRefreshPart()) ? false : getStatInPrivateFlags(4);
                    this.oldWidthMeasureSpec = i;
                    this.oldHeightMeasureSpec = i2;
                    if (z2 || !getStatInPrivateFlags(1024)) {
                        if (z) {
                            if (!sAlwaysRemeasureExactly && z2) {
                                if (!z5) {
                                }
                            }
                            if (!z4 || z3 || statInPrivateFlags) {
                                onMeasure(i, i2);
                                int i3 = this.privateFlags & -5;
                                this.privateFlags = i3;
                                int i4 = i3 | 16;
                                this.privateFlags = i4;
                                this.privateFlags = i4 | 8;
                            }
                            return;
                        }
                        z3 = false;
                        if (!z4) {
                        }
                        onMeasure(i, i2);
                        int i32 = this.privateFlags & -5;
                        this.privateFlags = i32;
                        int i42 = i32 | 16;
                        this.privateFlags = i42;
                        this.privateFlags = i42 | 8;
                    }
                    setMeasuredDimension(DXMeasureSpec.b(i), DXMeasureSpec.b(i2));
                    return;
                }
            }
            z = true;
            if (DXMeasureSpec.a(i) != 1073741824) {
            }
            if (getMeasuredWidth() != DXMeasureSpec.b(i)) {
            }
            DXRuntimeContext dXRuntimeContext22 = this.dXRuntimeContext;
            if (dXRuntimeContext22 != null) {
            }
            this.oldWidthMeasureSpec = i;
            this.oldHeightMeasureSpec = i2;
            if (z2) {
            }
            if (z) {
            }
            z3 = false;
            if (!z4) {
            }
            onMeasure(i, i2);
            int i322 = this.privateFlags & -5;
            this.privateFlags = i322;
            int i422 = i322 | 16;
            this.privateFlags = i422;
            this.privateFlags = i422 | 8;
        } catch (Throwable th) {
            vx.b(th);
            DXRuntimeContext dXRuntimeContext3 = getDXRuntimeContext();
            if (dXRuntimeContext3 != null && dXRuntimeContext3.getDxError() != null) {
                e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", e.DXERROR_DETAIL_ON_MEASURE_ERROR);
                aVar.e = vx.a(th);
                dXRuntimeContext3.getDxError().c.add(aVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean needHandleDark() {
        return DXDarkModeCenter.d() && DXDarkModeCenter.c() && !isDisableDarkMode();
    }

    public void newDataParsersExprNode(int i) {
        this.dataParsersExprNode = new DXLongSparseArray<>(i);
    }

    public void newEnumMap() {
        this.enumMap = new DXLongSparseArray<>();
    }

    public void newEventHandlersExprNode(int i) {
        this.eventHandlersExprNode = new DXLongSparseArray<>(i);
    }

    public void onBeforeBindChildData() {
    }

    public void onBeginParser() {
    }

    public void onBeginParser(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onBindEvent(Context context, View view, long j) {
        if (this.enabled == 1) {
            if (j == 18903999933159L) {
                view.setOnClickListener(new a());
            } else if (j == -6544685697300501093L) {
                view.setOnLongClickListener(new b());
            }
        }
        if (j == 2683803675109176030L) {
            bindDataEvent();
        }
        prePareBindEvent(j);
    }

    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        this.userId = dXWidgetNode.userId;
        this.autoId = dXWidgetNode.autoId;
        this.eventHandlersExprNode = dXWidgetNode.eventHandlersExprNode;
        this.dataParsersExprNode = dXWidgetNode.dataParsersExprNode;
        this.enumMap = dXWidgetNode.enumMap;
        this.privateFlags = dXWidgetNode.privateFlags;
        this.isFlatten = dXWidgetNode.isFlatten;
        this.needSetBackground = dXWidgetNode.needSetBackground;
        this.animation = dXWidgetNode.animation;
        this.propertyInitFlag = dXWidgetNode.propertyInitFlag;
        this.layoutWidth = dXWidgetNode.layoutWidth;
        this.layoutHeight = dXWidgetNode.layoutHeight;
        this.measuredWidth = dXWidgetNode.measuredWidth;
        this.measuredHeight = dXWidgetNode.measuredHeight;
        this.left = dXWidgetNode.left;
        this.top = dXWidgetNode.top;
        this.right = dXWidgetNode.right;
        this.bottom = dXWidgetNode.bottom;
        this.weight = dXWidgetNode.weight;
        this.marginLeft = dXWidgetNode.marginLeft;
        this.marginTop = dXWidgetNode.marginTop;
        this.marginRight = dXWidgetNode.marginRight;
        this.marginBottom = dXWidgetNode.marginBottom;
        this.paddingLeft = dXWidgetNode.paddingLeft;
        this.paddingTop = dXWidgetNode.paddingTop;
        this.paddingRight = dXWidgetNode.paddingRight;
        this.paddingBottom = dXWidgetNode.paddingBottom;
        this.visibility = dXWidgetNode.visibility;
        this.layoutGravity = dXWidgetNode.layoutGravity;
        this.childGravity = dXWidgetNode.childGravity;
        this.direction = dXWidgetNode.direction;
        this.alpha = dXWidgetNode.alpha;
        this.cornerRadius = dXWidgetNode.cornerRadius;
        this.cornerRadiusLeftTop = dXWidgetNode.cornerRadiusLeftTop;
        this.cornerRadiusRightTop = dXWidgetNode.cornerRadiusRightTop;
        this.cornerRadiusLeftBottom = dXWidgetNode.cornerRadiusLeftBottom;
        this.cornerRadiusRightBottom = dXWidgetNode.cornerRadiusRightBottom;
        this.borderWidth = dXWidgetNode.borderWidth;
        this.borderColor = dXWidgetNode.borderColor;
        this.borderType = dXWidgetNode.borderType;
        this.dashWidth = dXWidgetNode.dashWidth;
        this.dashGap = dXWidgetNode.dashGap;
        this.backGroundColor = dXWidgetNode.backGroundColor;
        this.accessibility = dXWidgetNode.accessibility;
        this.accessibilityText = dXWidgetNode.accessibilityText;
        this.enabled = dXWidgetNode.enabled;
        this.minHeight = dXWidgetNode.minHeight;
        this.minWidth = dXWidgetNode.minWidth;
        this.translateX = dXWidgetNode.translateX;
        this.translateY = dXWidgetNode.translateY;
        this.scaleX = dXWidgetNode.scaleX;
        this.scaleY = dXWidgetNode.scaleY;
        this.rotationX = dXWidgetNode.rotationX;
        this.bindingXSpecMap = dXWidgetNode.bindingXSpecMap;
        this.bindingXExecutingMap = dXWidgetNode.bindingXExecutingMap;
        this.lastAutoId = dXWidgetNode.lastAutoId;
        this.sourceWidgetWR = dXWidgetNode.sourceWidgetWR;
        this.clipChildren = dXWidgetNode.clipChildren;
        this.backgroundGradient = dXWidgetNode.backgroundGradient;
        this.darkModeColorMap = dXWidgetNode.darkModeColorMap;
        this.disableDarkMode = dXWidgetNode.disableDarkMode;
        this.eventResponseMode = dXWidgetNode.eventResponseMode;
        this.tborderJson = dXWidgetNode.tborderJson;
        this.softwareRender = dXWidgetNode.softwareRender;
        this.ref = dXWidgetNode.ref;
        if (!at.k0()) {
            tx txVar = dXWidgetNode.dxEventChains;
            if (txVar != null) {
                if (z) {
                    txVar = txVar.a();
                }
                this.dxEventChains = txVar;
            }
        } else {
            this.dxEventChains = dXWidgetNode.dxEventChains;
        }
        byte[] bArr = dXWidgetNode.dxExprBytes;
        if (bArr != null) {
            this.dxExprBytes = bArr;
        }
        this.openNewFastReturnLogic = dXWidgetNode.openNewFastReturnLogic;
        this.mCodeMap = dXWidgetNode.mCodeMap;
        this.slotInfo = dXWidgetNode.slotInfo;
        this.paramsInfo = dXWidgetNode.paramsInfo;
        this.slotInfoJObj = dXWidgetNode.slotInfoJObj;
    }

    /* access modifiers changed from: protected */
    public View onCreateView(Context context) {
        return new View(context);
    }

    public void onEndParser() {
    }

    public void onEndParser(boolean z) {
    }

    /* access modifiers changed from: protected */
    public boolean onEvent(lx lxVar) {
        DXTemplateItem dXTemplateItem;
        String str;
        ay ayVar;
        try {
            DXLongSparseArray<ay> dXLongSparseArray = this.eventHandlersExprNode;
            if (dXLongSparseArray != null) {
                if (lxVar != null) {
                    ay ayVar2 = dXLongSparseArray.get(lxVar.b());
                    if (ayVar2 == null) {
                        return false;
                    }
                    if (getDXRuntimeContext() == null || !getDXRuntimeContext().isOpenNewFastReturnLogic()) {
                        if (!(ayVar2 instanceof ux) && !(ayVar2 instanceof j00) && !(ayVar2 instanceof f00)) {
                            DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
                            if (!(dXRuntimeContext2 == null || dXRuntimeContext2.getDxError() == null)) {
                                new e.a("Event", "Event_Cast_Exception", e.EVENT_DXEXPRNODE_CAST_ERROR, "eventid" + lxVar.b() + " exprNode id " + ayVar2.b + " exprNode name " + ayVar2.d);
                            }
                            return false;
                        }
                    }
                    ayVar2.b(lxVar, getDXRuntimeContext());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            vx.b(e);
            if (getDXRuntimeContext() != null) {
                str = getDXRuntimeContext().getBizType();
                dXTemplateItem = getDXRuntimeContext().getDxTemplateItem();
            } else {
                dXTemplateItem = null;
                str = v00.DB_NAME;
            }
            String str2 = "";
            if (lxVar != null) {
                str2 = str2 + "eventId : " + lxVar.b();
                DXLongSparseArray<ay> dXLongSparseArray2 = this.eventHandlersExprNode;
                if (!(dXLongSparseArray2 == null || (ayVar = dXLongSparseArray2.get(lxVar.b())) == null)) {
                    str2 = str2 + " exprNode id " + ayVar.b + " exprNode name " + ayVar.d;
                }
            }
            DXAppMonitor.q(str, dXTemplateItem, "Pipeline", "Pipeline_Stage_ON_EVENT", e.ONEVENT_CRASH, str2 + " crash stack: " + vx.a(e));
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: package-private */
    public void onLongTap() {
        postEvent(new lx(-6544685697300501093L));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    /* access modifiers changed from: protected */
    public void onRenderView(Context context, View view) {
    }

    /* access modifiers changed from: protected */
    public void onSetDoubleAttribute(long j, double d2) {
    }

    /* access modifiers changed from: protected */
    public void onSetIntAttribute(long j, int i) {
    }

    /* access modifiers changed from: protected */
    public void onSetListAttribute(long j, JSONArray jSONArray) {
    }

    /* access modifiers changed from: protected */
    public void onSetLongAttribute(long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    public void onSetObjAttribute(long j, Object obj) {
    }

    /* access modifiers changed from: protected */
    public void onSetStringAttribute(long j, String str) {
    }

    /* access modifiers changed from: protected */
    public void onSetUserDefinedListAttribute(long j, List<Object> list) {
    }

    /* access modifiers changed from: package-private */
    public final void onTapEvent() {
        postEvent(new lx(18903999933159L));
    }

    public final boolean postEvent(lx lxVar) {
        if (!isSelfResponseEvent()) {
            return false;
        }
        if (!this.isFlatten) {
            return onEvent(lxVar);
        }
        return getReferenceNode().onEvent(lxVar);
    }

    /* access modifiers changed from: package-private */
    public void processUserId() {
        if (!TextUtils.isEmpty(this.userId)) {
            DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
            if (queryRootWidgetNode instanceof f) {
                Map<String, WeakReference<DXWidgetNode>> dxUserIdMap = ((f) queryRootWidgetNode).getDxUserIdMap();
                WeakReference<DXWidgetNode> weakReference = dxUserIdMap.get(this.userId);
                if (weakReference == null || weakReference.get() == null) {
                    dxUserIdMap.put(this.userId, new WeakReference<>(this));
                }
            }
        }
    }

    public void putBindingXExecutingSpec(rs rsVar) {
        if (rsVar != null && !TextUtils.isEmpty(rsVar.a)) {
            if (this.bindingXExecutingMap == null) {
                this.bindingXExecutingMap = new HashMap();
            }
            this.bindingXExecutingMap.put(rsVar.a, rsVar);
        }
    }

    public DXWidgetNode queryRootWidgetNode() {
        if (this.dxRootWidgetCache != null && at.P0(getDXRuntimeContext())) {
            return this.dxRootWidgetCache;
        }
        DXWidgetNode dXWidgetNode = this;
        while (dXWidgetNode.getParentWidget() != null) {
            DXWidgetNode parentWidget2 = dXWidgetNode.getParentWidget();
            if (parentWidget2 instanceof DXTemplateWidgetNode) {
                return dXWidgetNode;
            }
            dXWidgetNode = parentWidget2;
        }
        this.dxRootWidgetCache = dXWidgetNode;
        return dXWidgetNode;
    }

    public DXWidgetNode queryWTByAutoId(int i) {
        if (this.autoId == i) {
            return this;
        }
        if (getChildrenCount() <= 0) {
            return null;
        }
        for (DXWidgetNode dXWidgetNode : getChildren()) {
            DXWidgetNode queryWTByAutoId = dXWidgetNode.queryWTByAutoId(i);
            if (queryWTByAutoId != null) {
                return queryWTByAutoId;
            }
        }
        return null;
    }

    public DXWidgetNode queryWTByUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(this.userId)) {
            return this;
        }
        if (getChildrenCount() > 0) {
            if (!at.P0(getDXRuntimeContext()) || !(this instanceof DXTemplateWidgetNode)) {
                for (DXWidgetNode dXWidgetNode : getChildren()) {
                    DXWidgetNode queryWTByUserId = dXWidgetNode.queryWTByUserId(str);
                    if (queryWTByUserId != null) {
                        return queryWTByUserId;
                    }
                }
            } else {
                for (DXWidgetNode dXWidgetNode2 : getChildren()) {
                    DXWidgetNode queryWidgetNodeByUserIdFromMap = dXWidgetNode2.queryWidgetNodeByUserIdFromMap(str, false);
                    if (queryWidgetNodeByUserIdFromMap != null) {
                        return queryWidgetNodeByUserIdFromMap;
                    }
                }
            }
        }
        return null;
    }

    public DXWidgetNode queryWidgetNodeByAutoId(int i) {
        return queryRootWidgetNode().queryWTByAutoId(i);
    }

    public DXWidgetNode queryWidgetNodeByUserId(String str) {
        if (!at.P0(getDXRuntimeContext())) {
            return queryRootWidgetNode().queryWTByUserId(str);
        }
        DXWidgetNode queryWidgetNodeByUserIdFromMap = queryWidgetNodeByUserIdFromMap(str, true);
        if (queryWidgetNodeByUserIdFromMap == null && DinamicXEngine.x()) {
            ry.c(str + " queryWidgetNodeByUserId 没有找到");
        }
        return queryWidgetNodeByUserIdFromMap;
    }

    public void removeAllChild() {
        List<DXWidgetNode> list = this.children;
        if (list == null) {
            this.childrenCount = 0;
            return;
        }
        list.clear();
        this.childrenCount = 0;
    }

    public void removeBindingXSpec(rs rsVar) {
        if (this.bindingXExecutingMap != null && rsVar != null && !TextUtils.isEmpty(rsVar.a)) {
            this.bindingXExecutingMap.remove(rsVar.a);
        }
    }

    public void removeChildWithAutoId(int i) {
        if (!(this.children == null || this.childrenCount == 0)) {
            for (int i2 = 0; i2 < this.childrenCount; i2++) {
                if (this.children.get(i2).autoId == i) {
                    this.children.remove(i2);
                    this.childrenCount--;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void renderTransformedProperty(View view) {
        if (this.translateX != view.getTranslationX()) {
            view.setTranslationX(this.translateX);
        }
        if (this.translateY != view.getTranslationY()) {
            view.setTranslationY(this.translateY);
        }
        if (this.rotationX != view.getRotationX()) {
            view.setRotationX(this.rotationX);
        }
        if (this.rotationY != view.getRotationY()) {
            view.setRotationY(this.rotationY);
        }
        if (this.rotationZ != view.getRotation()) {
            view.setRotation(this.rotationZ);
        }
        if (this.scaleX != view.getScaleX()) {
            view.setScaleX(this.scaleX);
        }
        if (this.scaleY != view.getScaleY()) {
            view.setScaleY(this.scaleY);
        }
    }

    public final void renderView(Context context) {
        try {
            View realView = getRealView();
            if (realView != null) {
                boolean z = false;
                if ((this.privateFlags & 256) != 0) {
                    setRealViewVisibility(realView, this.visibility);
                    float alpha2 = realView.getAlpha();
                    float f = this.alpha;
                    if (alpha2 != f) {
                        realView.setAlpha(f);
                    }
                    if (this.enabled == 1) {
                        z = true;
                    }
                    if (realView.isEnabled() != z) {
                        realView.setEnabled(z);
                    }
                    renderTransformedProperty(realView);
                    setAccessibility(realView);
                    DXWidgetNode referenceNode2 = getReferenceNode();
                    referenceNode2.setBackground(realView);
                    referenceNode2.onRenderView(context, realView);
                    if (Build.VERSION.SDK_INT >= 17 && (realView instanceof ViewGroup)) {
                        realView.setLayoutDirection(getDirection());
                    }
                    referenceNode2.setForceDark(realView);
                }
                int i = this.privateFlags & -257;
                this.privateFlags = i;
                this.privateFlags = i | 512;
            }
        } catch (Exception e) {
            vx.b(e);
            DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
            if (dXRuntimeContext2 != null && dXRuntimeContext2.getDxError() != null) {
                e.a aVar = new e.a("Render", "Pipeline_Detail_Render_Detail", 90002);
                aVar.e = vx.a(e);
                dXRuntimeContext2.getDxError().c.add(aVar);
            }
        }
    }

    public int replaceChild(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
        if (!(this instanceof f) || dXWidgetNode2 == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i >= getChildrenCount()) {
                i = -1;
                break;
            } else if (getChildAt(i).getAutoId() == dXWidgetNode2.getAutoId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            removeChildWithAutoId(dXWidgetNode2.getAutoId());
            insertChild(dXWidgetNode, i);
        }
        return i;
    }

    public final void requestLayout() {
        requestLayout(false);
    }

    public void sendBroadcastEvent(lx lxVar) {
        if (lxVar != null) {
            if (getReferenceNode() != null && isSelfResponseEvent()) {
                postEvent(lxVar);
            }
            if (getChildrenCount() > 0) {
                for (DXWidgetNode dXWidgetNode : getChildren()) {
                    if (isChildResponseEvent()) {
                        dXWidgetNode.sendBroadcastEvent(lxVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i = this.accessibility;
            if (i != -1 && i != 3) {
                String str = this.accessibilityText;
                if (str != null) {
                    view.setContentDescription(str);
                }
                int i2 = this.accessibility;
                if (i2 == 1) {
                    view.setImportantForAccessibility(1);
                    view.setFocusable(true);
                } else if (i2 == 2) {
                    view.setImportantForAccessibility(4);
                } else {
                    view.setImportantForAccessibility(2);
                }
            }
        } else {
            view.setContentDescription("");
        }
    }

    public void setAccessibilityText(String str) {
        this.accessibilityText = str;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setAnimation(String str) {
        this.animation = str;
    }

    public void setAutoId(int i) {
        this.autoId = i;
    }

    public void setBackGroundColor(int i) {
        if (i != this.backGroundColor) {
            this.backGroundColor = i;
            this.needSetBackground = true;
        }
    }

    public void setBackground(View view) {
        int i;
        int i2;
        if (this.needSetBackground) {
            int tryFetchDarkModeColor = tryFetchDarkModeColor("backgroundColor", 1, this.backGroundColor);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("borderColor", 2, this.borderColor);
            Drawable background = view.getBackground();
            if (this.borderType == 1) {
                if (this.dashWidth <= -1 && DinamicXEngine.i() != null) {
                    this.dashWidth = d00.b(DinamicXEngine.i(), 6.0f);
                }
                if (this.dashGap <= -1 && DinamicXEngine.i() != null) {
                    this.dashGap = d00.b(DinamicXEngine.i(), 4.0f);
                }
                i2 = this.dashWidth;
                i = this.dashGap;
            } else {
                i2 = 0;
                i = 0;
            }
            if (background != null && (background instanceof GradientDrawable)) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.setColor(tryFetchDarkModeColor);
                int i3 = this.cornerRadius;
                if (i3 > 0) {
                    gradientDrawable.setCornerRadius((float) i3);
                } else {
                    int i4 = this.cornerRadiusLeftTop;
                    int i5 = this.cornerRadiusRightTop;
                    int i6 = this.cornerRadiusRightBottom;
                    int i7 = this.cornerRadiusLeftBottom;
                    gradientDrawable.setCornerRadii(new float[]{(float) i4, (float) i4, (float) i5, (float) i5, (float) i6, (float) i6, (float) i7, (float) i7});
                }
                int i8 = this.borderWidth;
                if (i8 > 0 && tryFetchDarkModeColor2 != 0) {
                    gradientDrawable.setStroke(i8, tryFetchDarkModeColor2, (float) i2, (float) i);
                } else if (i8 > 0 && tryFetchDarkModeColor2 == 0) {
                    gradientDrawable.setStroke(0, 0, 0.0f, 0.0f);
                }
                d dVar = this.backgroundGradient;
                if (dVar != null && dVar.a() == 0) {
                    gradientDrawable.setGradientType(this.backgroundGradient.a());
                    if (Build.VERSION.SDK_INT >= 16) {
                        gradientDrawable.setOrientation(this.backgroundGradient.c());
                        gradientDrawable.setColors(this.backgroundGradient.b());
                    }
                }
            } else if (hasCornerRadius() || tryFetchDarkModeColor2 != 0 || this.borderWidth > 0 || this.backgroundGradient != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                int i9 = this.cornerRadius;
                if (i9 > 0) {
                    gradientDrawable2.setCornerRadius((float) i9);
                } else {
                    int i10 = this.cornerRadiusLeftTop;
                    int i11 = this.cornerRadiusRightTop;
                    int i12 = this.cornerRadiusRightBottom;
                    int i13 = this.cornerRadiusLeftBottom;
                    gradientDrawable2.setCornerRadii(new float[]{(float) i10, (float) i10, (float) i11, (float) i11, (float) i12, (float) i12, (float) i13, (float) i13});
                }
                gradientDrawable2.setShape(0);
                gradientDrawable2.setColor(tryFetchDarkModeColor);
                int i14 = this.borderWidth;
                if (i14 > 0 && tryFetchDarkModeColor2 != 0) {
                    gradientDrawable2.setStroke(i14, tryFetchDarkModeColor2, (float) i2, (float) i);
                } else if (i14 > 0 && tryFetchDarkModeColor2 == 0) {
                    gradientDrawable2.setStroke(0, 0, 0.0f, 0.0f);
                }
                d dVar2 = this.backgroundGradient;
                if (dVar2 != null && dVar2.a() == 0) {
                    gradientDrawable2.setGradientType(this.backgroundGradient.a());
                    if (Build.VERSION.SDK_INT >= 16) {
                        gradientDrawable2.setOrientation(this.backgroundGradient.c());
                        gradientDrawable2.setColors(this.backgroundGradient.b());
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    view.setBackground(gradientDrawable2);
                } else {
                    view.setBackgroundDrawable(gradientDrawable2);
                }
            } else {
                view.setBackgroundColor(tryFetchDarkModeColor);
            }
        }
    }

    public void setBackgroundGradient(d dVar) {
        this.backgroundGradient = dVar;
    }

    public void setBindingXExecutingMap(Map<String, rs> map) {
        this.bindingXExecutingMap = map;
    }

    public void setBindingXSpecMap(Map<String, rs> map) {
        this.bindingXSpecMap = map;
    }

    public void setBorderColor(int i) {
        if (i != this.borderColor) {
            this.borderColor = i;
            this.needSetBackground = true;
        }
    }

    public void setBorderType(int i) {
    }

    public void setBorderWidth(int i) {
        if (this.borderWidth != i) {
            this.borderWidth = i;
            this.needSetBackground = true;
        }
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    public void setChildGravity(int i) {
        this.childGravity = i;
    }

    public void setCodeMap(DXLongSparseArray<ay> dXLongSparseArray) {
        this.mCodeMap = dXLongSparseArray;
    }

    public void setCornerRadius(int i) {
        if (this.cornerRadius != i) {
            this.cornerRadius = i;
            this.needSetBackground = true;
        }
    }

    public void setCornerRadiusLeftBottom(int i) {
        this.cornerRadiusLeftBottom = i;
    }

    public void setCornerRadiusLeftTop(int i) {
        this.cornerRadiusLeftTop = i;
    }

    public void setCornerRadiusRightBottom(int i) {
        this.cornerRadiusRightBottom = i;
    }

    public void setCornerRadiusRightTop(int i) {
        this.cornerRadiusRightTop = i;
    }

    public void setDXRuntimeContext(DXRuntimeContext dXRuntimeContext2) {
        this.dXRuntimeContext = dXRuntimeContext2;
    }

    public void setDataParsersExprNode(DXLongSparseArray<ay> dXLongSparseArray) {
        this.dataParsersExprNode = dXLongSparseArray;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setDisableDarkMode(boolean z) {
        this.disableDarkMode = z;
    }

    public void setDoubleAttribute(long j, double d2) {
        if (10439708918555150L == j) {
            this.weight = d2;
        } else if (16887479372907L == j) {
            this.alpha = (float) d2;
        } else {
            onSetDoubleAttribute(j, d2);
        }
    }

    public void setDxEventChains(tx txVar) {
        this.dxEventChains = txVar;
    }

    public void setDxExprBytes(byte[] bArr) {
        this.dxExprBytes = bArr;
    }

    public void setEnabled(int i) {
        this.enabled = i;
    }

    public void setEnumMap(DXLongSparseArray<Map<String, Integer>> dXLongSparseArray) {
        this.enumMap = dXLongSparseArray;
    }

    public void setEventHandlersExprNode(DXLongSparseArray<ay> dXLongSparseArray) {
        this.eventHandlersExprNode = dXLongSparseArray;
    }

    public void setEventResponseMode(int i) {
        this.eventResponseMode = i;
    }

    public void setFlatten(boolean z) {
        this.isFlatten = z;
    }

    /* access modifiers changed from: protected */
    public void setForceDark(View view) {
        if (DXDarkModeCenter.d() && DXDarkModeCenter.c()) {
            if (this.disableDarkMode) {
                DXDarkModeCenter.a(view);
            } else if (extraHandleDark() || this.hasHandleDark) {
                DXDarkModeCenter.a(view);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        if (this.left == i && this.right == i3 && this.top == i2 && this.bottom == i4) {
            return false;
        }
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        return true;
    }

    public final void setIntAttribute(long j, int i) {
        if (20052926345925L == j) {
            this.layoutWidth = i;
        } else if (9346582897824575L == j) {
            this.layoutHeight = i;
        } else if (-916628110244908525L == j) {
            this.marginLeft = i;
        } else if (-4674119579031497081L == j) {
            this.marginRight = i;
        } else if (-2641581645694792774L == j) {
            this.marginTop = i;
        } else if (6506044224063169535L == j) {
            this.marginBottom = i;
        } else if (-378913133726214547L == j) {
            this.paddingLeft = i;
        } else if (3229586316762092001L == j) {
            this.paddingRight = i;
        } else if (-2632461973017864940L == j) {
            this.paddingTop = i;
        } else if (-4745829179314597287L == j) {
            this.paddingBottom = i;
        } else {
            boolean z = true;
            if (4879707785646574221L == j && i >= 0 && i <= 8) {
                this.layoutGravity = i;
                this.propertyInitFlag |= 1;
            } else if (-3218010051991756042L == j && i >= 0 && i <= 8) {
                this.childGravity = i;
            } else if (7504432960089273802L == j && (i == 0 || i == 1)) {
                setDirection(i);
            } else if (5802348655878590802L == j && (i == 0 || i == 1 || i == 2)) {
                this.visibility = i;
            } else if (6313115730157071869L == j) {
                this.cornerRadius = i;
                this.needSetBackground = true;
            } else if (-7043958449911898942L == j) {
                this.cornerRadiusLeftTop = i;
                this.needSetBackground = true;
            } else if (8679583519247168310L == j) {
                this.cornerRadiusRightTop = i;
                this.needSetBackground = true;
            } else if (-3738348576243028217L == j) {
                this.cornerRadiusLeftBottom = i;
                this.needSetBackground = true;
            } else if (1691221861925381243L == j) {
                this.cornerRadiusRightBottom = i;
                this.needSetBackground = true;
            } else if (-8019934667170236535L == j) {
                this.borderWidth = i;
                this.needSetBackground = true;
            } else if (-8020113231441560440L == j) {
                this.borderColor = i;
                this.needSetBackground = true;
            } else if (1844153004063100714L == j) {
                this.borderType = i;
                this.needSetBackground = true;
            } else if (3657130712798351885L == j) {
                this.dashWidth = i;
            } else if (5384687760714897699L == j) {
                this.dashGap = i;
            } else if (-6716070147120443019L == j) {
                this.accessibility = i;
            } else if (-2819959685970048978L == j) {
                this.backGroundColor = i;
                this.needSetBackground = true;
            } else if (4804789929613330386L == j) {
                this.enabled = i;
            } else if (2051502660558186662L == j) {
                this.minHeight = i;
            } else if (j == 3998176004939777025L) {
                if (i == 0) {
                    z = false;
                }
                this.softwareRender = z;
            } else if (4694181495334893900L == j) {
                this.minWidth = i;
            } else if (j == -8044124925891189930L) {
                if (i != 1) {
                    z = false;
                }
                this.clipChildren = z;
            } else if (j == -6579663421190292502L) {
                if (i == 0) {
                    z = false;
                }
                this.disableDarkMode = z;
            } else if (j == -5241271604340946425L) {
                this.eventResponseMode = i;
            } else if (j == 9037937761546515694L) {
                if (i != 1) {
                    z = false;
                }
                this.openNewFastReturnLogic = z;
            } else {
                onSetIntAttribute(j, i);
            }
        }
    }

    public void setLastAutoId(int i) {
        this.lastAutoId = i;
    }

    public void setLayoutGravity(int i) {
        this.layoutGravity = i;
        this.propertyInitFlag |= 1;
    }

    public void setLayoutHeight(int i) {
        this.layoutHeight = i;
    }

    public void setLayoutWidth(int i) {
        this.layoutWidth = i;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setListAttribute(long j, JSONArray jSONArray) {
        onSetListAttribute(j, jSONArray);
    }

    public void setLongAttribute(long j, long j2) {
        onSetLongAttribute(j, j2);
    }

    public void setMapAttribute(long j, JSONObject jSONObject) {
        onSetMapAttribute(j, jSONObject);
    }

    public void setMarginBottom(int i) {
        this.marginBottom = i;
    }

    public void setMarginLeft(int i) {
        this.marginLeft = i;
    }

    public void setMarginRight(int i) {
        this.marginRight = i;
    }

    public void setMarginTop(int i) {
        this.marginTop = i;
    }

    public final void setMeasuredDimension(int i, int i2) {
        this.measuredWidth = i;
        this.measuredHeight = i2;
    }

    public void setMinHeight(int i) {
        this.minHeight = i;
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
    }

    public void setNeedLayout(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (dXWidgetRefreshOption == null) {
            dXWidgetRefreshOption = new DXWidgetRefreshOption();
        }
        setStatFlag(16384);
        setStatFlag(4);
        unsetStatFlag(8);
        unsetStatFlag(32);
        if (dXWidgetRefreshOption.b()) {
            bindChildrenMeasureFlag(dXWidgetRefreshOption);
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(false, dXWidgetRefreshOption.c());
        } else {
            sendPartMeasureLayoutEvent(dXWidgetRefreshOption.c());
        }
    }

    public final void setNeedParse() {
        int i = this.privateFlags & -3;
        this.privateFlags = i;
        this.privateFlags = i | 1;
        if (at.A0()) {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                ((DXRecyclerLayout) dXWidgetNode).updateCurrent(this);
            }
        } else if (this instanceof DXRecyclerLayout) {
            refreshRecyclerLayout();
            return;
        }
        DXWidgetNode dXWidgetNode2 = this.parentWidget;
        if (dXWidgetNode2 != null) {
            dXWidgetNode2.setNeedParse();
            return;
        }
        DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
        if (dXRuntimeContext2 != null) {
            DXRenderPipeline dxRenderPipeline = dXRuntimeContext2.getDxRenderPipeline();
            ft dxControlEventCenter = dXRuntimeContext2.getDxControlEventCenter();
            if (dxRenderPipeline != null && dxControlEventCenter != null) {
                h j = dxRenderPipeline.j();
                if (j != null) {
                    j.j(dXRuntimeContext2.getCacheIdentify());
                }
                jz jzVar = new jz();
                jzVar.d = 2;
                jzVar.a = this;
                dxControlEventCenter.b(jzVar);
            }
        }
    }

    public final void setNeedRender(Context context) {
        this.privateFlags |= 256;
        renderView(context);
    }

    public void setNeedSetBackground(boolean z) {
        this.needSetBackground = z;
    }

    public final void setObjAttribute(long j, Object obj) {
        if (obj != null) {
            if (j == 3436950829494956384L) {
                this.backgroundGradient = (d) obj;
                this.needSetBackground = true;
            } else if (j == -396946557348092076L) {
                this.darkModeColorMap = (HashMap) obj;
            } else {
                onSetObjAttribute(j, obj);
            }
        }
    }

    public void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setPaddingLeft(int i) {
        this.paddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setParamsInfo(JSONObject jSONObject) {
        this.paramsInfo = jSONObject;
    }

    public void setParentWidget(DXWidgetNode dXWidgetNode) {
        this.parentWidget = dXWidgetNode;
    }

    public void setRealViewLayoutParam(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null) {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode == null || !(dXWidgetNode instanceof f)) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(getMeasuredWidth(), getMeasuredHeight());
                } else {
                    layoutParams2.width = getMeasuredWidth();
                    layoutParams2.height = getMeasuredHeight();
                }
                view.setLayoutParams(layoutParams2);
                return;
            }
            py pyVar = attributeThreadLocal.get();
            this.realLayoutAttribute = pyVar;
            if (pyVar == null) {
                py pyVar2 = new py();
                this.realLayoutAttribute = pyVar2;
                attributeThreadLocal.set(pyVar2);
            }
            this.realLayoutAttribute.a = getMeasuredWidth();
            this.realLayoutAttribute.b = getMeasuredHeight();
            f fVar = (f) this.parentWidget;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams = fVar.generateLayoutParams(this.realLayoutAttribute);
            } else {
                layoutParams = fVar.generateLayoutParams(this.realLayoutAttribute, layoutParams3);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public void setRealViewVisibility(View view, int i) {
        if (view != null) {
            int i2 = 0;
            if (i != 0) {
                if (i == 1) {
                    i2 = 4;
                } else if (i == 2) {
                    i2 = 8;
                }
            }
            if (view.getVisibility() != i2) {
                view.setVisibility(i2);
            }
        }
    }

    public void setReferenceNode(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            this.referenceNode = null;
        } else {
            this.referenceNode = new WeakReference<>(dXWidgetNode);
        }
    }

    public void setRight(int i) {
        this.right = i;
    }

    public void setRotationX(float f) {
        this.rotationX = f;
    }

    public void setRotationY(float f) {
        this.rotationY = f;
    }

    public void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
    }

    public void setSlotInfo(JSONArray jSONArray) {
        this.slotInfo = jSONArray;
    }

    public void setSlotInfoJObj(JSONObject jSONObject) {
        this.slotInfoJObj = jSONObject;
    }

    public void setSourceWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            this.sourceWidgetWR = new WeakReference<>(dXWidgetNode);
        }
    }

    public void setStatFlag(int i) {
        this.privateFlags = i | this.privateFlags;
    }

    public void setStringAttribute(long j, String str) {
        if (10297924263834610L == j) {
            this.userId = str;
        } else if (6301829145275697438L == j) {
            this.accessibilityText = str;
        } else if (j == DXOverlayWidgetNode.DXOVERLAY_ANIMATION) {
            this.animation = str;
        } else if (j == DXVIEW_TBORDERJSON) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.tborderJson = JSON.parseObject(str);
                }
            } catch (Exception e) {
                vx.b(e);
            }
        } else if (j == 526314816) {
            this.ref = str;
        } else {
            onSetStringAttribute(j, str);
        }
    }

    public void setTop(int i) {
        this.top = i;
    }

    public void setTranslateX(float f) {
        this.translateX = f;
    }

    public void setTranslateY(float f) {
        this.translateY = f;
    }

    public final void setUserDefinedListAttribute(long j, List<Object> list) {
        onSetUserDefinedListAttribute(j, list);
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVisibility(int i) {
        this.visibility = i;
    }

    public void setWRView(WeakReference<View> weakReference) {
        this.weakView = weakReference;
    }

    public void setWeight(double d2) {
        this.weight = d2;
    }

    public Object shallowClone(@NonNull DXRuntimeContext dXRuntimeContext2, boolean z) {
        DXWidgetNode build = build(null);
        if (build == null) {
            return null;
        }
        if (dXRuntimeContext2 != null) {
            build.dXRuntimeContext = dXRuntimeContext2.cloneWithWidgetNode(build);
        }
        build.onClone(this, z);
        return build;
    }

    public String toSelfWidgetNodeInfo() {
        return getClass().getName() + o70.DINAMIC_PREFIX_AT + hashCode() + "_[w: " + getMeasuredWidth() + "]_[h: " + getMeasuredHeight() + jl1.ARRAY_END_STR;
    }

    public String toTreeInfo() {
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (queryRootWidgetNode != this) {
            return queryRootWidgetNode.toTreeInfo();
        }
        JSONObject jSONObject = new JSONObject(true);
        parseTreeInfo(jSONObject);
        return jSONObject.toJSONString();
    }

    /* access modifiers changed from: protected */
    public int tryFetchDarkModeColor(String str, int i, @ColorInt int i2) {
        Integer num;
        if (!needHandleDark()) {
            return i2;
        }
        HashMap<String, Integer> hashMap = this.darkModeColorMap;
        if (hashMap != null && (num = hashMap.get(str)) != null) {
            this.hasHandleDark = true;
            return num.intValue();
        } else if (!DXDarkModeCenter.b()) {
            return i2;
        } else {
            this.hasHandleDark = true;
            return DXDarkModeCenter.e(i, i2);
        }
    }

    public void unsetStatFlag(int i) {
        this.privateFlags = (~i) & this.privateFlags;
    }

    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
        if (dXRuntimeContext2 != null) {
            dXRuntimeContext2.setRefreshType(i);
            if (this.childrenCount > 0) {
                for (DXWidgetNode dXWidgetNode : this.children) {
                    dXWidgetNode.updateRefreshType(i);
                }
            }
        }
    }

    public final void addChild(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && dXWidgetNode != this) {
            if (this.children == null) {
                this.children = new ArrayList();
                this.childrenCount = 0;
            }
            this.children.add(dXWidgetNode);
            this.childrenCount++;
            dXWidgetNode.parentWidget = this;
            DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
            if (dXRuntimeContext2 != null && z) {
                dXWidgetNode.dXRuntimeContext = dXRuntimeContext2.cloneWithWidgetNode(dXWidgetNode);
            }
        }
    }

    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext2, boolean z) {
        if (dXRuntimeContext2 != null) {
            Object obj = null;
            int i = 0;
            if (z) {
                obj = this.dXRuntimeContext.getSubData();
                i = this.dXRuntimeContext.getSubdataIndex();
            }
            if (this.dXRuntimeContext != dXRuntimeContext2) {
                DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext2.cloneWithWidgetNode(this);
                this.dXRuntimeContext = cloneWithWidgetNode;
                if (z) {
                    cloneWithWidgetNode.setSubData(obj);
                    this.dXRuntimeContext.setSubdataIndex(i);
                }
            }
            if (this.childrenCount > 0) {
                for (DXWidgetNode dXWidgetNode : this.children) {
                    dXWidgetNode.bindRuntimeContext(dXRuntimeContext2, z);
                }
            }
        }
    }

    public void insertChild(DXWidgetNode dXWidgetNode, int i, boolean z) {
        if (dXWidgetNode != null && dXWidgetNode != this && i <= this.childrenCount) {
            if (this.children == null) {
                this.children = new ArrayList();
                this.childrenCount = 0;
            }
            this.children.add(i, dXWidgetNode);
            this.childrenCount++;
            dXWidgetNode.parentWidget = this;
            DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
            if (dXRuntimeContext2 != null && z) {
                dXWidgetNode.dXRuntimeContext = dXRuntimeContext2.cloneWithWidgetNode(dXWidgetNode);
            }
        }
    }

    public final void requestLayout(boolean z) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & -41;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.requestLayout(z);
            return;
        }
        DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
        if (dXRuntimeContext2 != null) {
            DXRenderPipeline dxRenderPipeline = dXRuntimeContext2.getDxRenderPipeline();
            ft dxControlEventCenter = dXRuntimeContext2.getDxControlEventCenter();
            if (dxRenderPipeline != null && dxControlEventCenter != null) {
                h j = dxRenderPipeline.j();
                if (j != null) {
                    j.j(dXRuntimeContext2.getCacheIdentify());
                }
                jz jzVar = new jz();
                jzVar.d = 3;
                jzVar.a = this;
                if (z) {
                    jzVar.e = 1;
                } else {
                    jzVar.e = 0;
                }
                dxControlEventCenter.a(jzVar);
            }
        }
    }

    public void setCornerRadius(int i, int i2, int i3, int i4) {
        this.cornerRadiusLeftTop = i;
        this.cornerRadiusRightTop = i2;
        this.cornerRadiusLeftBottom = i3;
        this.cornerRadiusRightBottom = i4;
        this.needSetBackground = true;
    }

    public void setAccessibility(int i) {
        this.accessibility = i;
    }

    public final void setNeedLayout() {
        setNeedLayout(false);
    }

    public final void setNeedLayout(boolean z) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & -41;
        if (at.A0()) {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                if (z) {
                    updateRefreshType(1);
                    ((DXRecyclerLayout) this.parentWidget).refreshCurrentNode(this);
                    return;
                }
                ((DXRecyclerLayout) dXWidgetNode).updateCurrent(this);
                return;
            }
        }
        DXWidgetNode dXWidgetNode2 = this.parentWidget;
        if (dXWidgetNode2 != null) {
            dXWidgetNode2.setNeedLayout(z);
            return;
        }
        DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
        if (dXRuntimeContext2 != null) {
            DXRenderPipeline dxRenderPipeline = dXRuntimeContext2.getDxRenderPipeline();
            ft dxControlEventCenter = dXRuntimeContext2.getDxControlEventCenter();
            if (dxRenderPipeline != null && dxControlEventCenter != null) {
                h j = dxRenderPipeline.j();
                if (j != null) {
                    j.j(dXRuntimeContext2.getCacheIdentify());
                }
                jz jzVar = new jz();
                jzVar.d = 3;
                jzVar.a = this;
                if (z) {
                    jzVar.e = 1;
                } else {
                    jzVar.e = 0;
                }
                dxControlEventCenter.b(jzVar);
            }
        }
    }

    public void setNeedParse(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (dXWidgetRefreshOption == null) {
            dXWidgetRefreshOption = new DXWidgetRefreshOption();
        }
        int i = this.privateFlags & -3;
        this.privateFlags = i;
        this.privateFlags = i | 1;
        if (!isMarkContainerLayout()) {
            unsetStatFlag(4096);
        }
        this.privateFlags |= 4;
        if (dXWidgetRefreshOption.b()) {
            bindChildrenParseFlag(dXWidgetRefreshOption);
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(true, dXWidgetRefreshOption.c());
        } else {
            sendPartParserEvent(dXWidgetRefreshOption.c());
        }
    }

    public final void setNeedParse(boolean z) {
        if (!z) {
            setNeedParse();
            return;
        }
        int i = this.privateFlags & -3;
        this.privateFlags = i;
        int i2 = i | 1;
        this.privateFlags = i2;
        this.privateFlags = i2 | 4;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(true, false);
        } else {
            sendPartParserEvent(false);
        }
    }
}
