package com.taobao.weex.ui.component;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.JSONLexer;
import com.taobao.weex.ComponentObserver;
import com.taobao.weex.IWXActivityStateListener;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXAccessibilityRoleAdapter;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.IWXObject;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.WXRenderManager;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.action.GraphicActionAnimation;
import com.taobao.weex.ui.action.GraphicActionUpdateStyle;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.animation.WXAnimationBean;
import com.taobao.weex.ui.animation.WXAnimationModule;
import com.taobao.weex.ui.component.basic.WXBasicComponent;
import com.taobao.weex.ui.component.binding.Statements;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.ui.component.pesudo.OnActivePseudoListner;
import com.taobao.weex.ui.component.pesudo.PesudoStatus;
import com.taobao.weex.ui.component.pesudo.TouchActivePseudoListener;
import com.taobao.weex.ui.flat.FlatComponent;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.flat.widget.AndroidViewWidget;
import com.taobao.weex.ui.flat.widget.Widget;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.taobao.weex.utils.BoxShadowUtil;
import com.taobao.weex.utils.WXDataStructureUtil;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXReflectionUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.CharUtils;
import tb.cx2;
import tb.jl1;
import tb.se2;
import tb.sx2;
import tb.v00;

/* compiled from: Taobao */
public abstract class WXComponent<T extends View> extends WXBasicComponent implements IWXObject, IWXActivityStateListener, OnActivePseudoListner {
    public static final String PROP_FIXED_SIZE = "fixedSize";
    public static final String PROP_FS_MATCH_PARENT = "m";
    public static final String PROP_FS_WRAP_CONTENT = "w";
    public static final String ROOT = "_root";
    public static final int STATE_ALL_FINISH = 2;
    public static final int STATE_DOM_FINISH = 0;
    public static final int STATE_UI_FINISH = 1;
    public static final String TYPE = "type";
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_VIRTUAL = 1;
    @Nullable
    private ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> animations;
    protected ContentBoxMeasurement contentBoxMeasurement;
    public int interactionAbsoluteX;
    public int interactionAbsoluteY;
    public boolean isIgnoreInteraction;
    private boolean isLastLayoutDirectionRTL;
    private boolean isUsing;
    private int mAbsoluteX;
    private int mAbsoluteY;
    private WXAnimationModule.AnimationHolder mAnimationHolder;
    private Set<String> mAppendEvents;
    private BorderDrawable mBackgroundDrawable;
    protected int mChildrensWidth;
    private WXComponent<T>.OnClickListenerImp mClickEventListener;
    private Context mContext;
    public int mDeepInComponentTree;
    private int mFixedProp;
    private List<OnFocusChangeListener> mFocusChangeListeners;
    protected WXGesture mGesture;
    @Nullable
    private Set<String> mGestureType;
    private boolean mHasAddFocusListener;
    private IFComponentHolder mHolder;
    T mHost;
    private List<OnClickListener> mHostClickListeners;
    private WXSDKInstance mInstance;
    public boolean mIsAddElementToTree;
    private boolean mIsDestroyed;
    private boolean mIsDisabled;
    private String mLastBoxShadowId;
    private boolean mLazy;
    private boolean mNeedLayoutOnAnimation;
    private volatile WXVContainer mParent;
    private PesudoStatus mPesudoStatus;
    private int mPreRealHeight;
    private int mPreRealLeft;
    private int mPreRealRight;
    private int mPreRealTop;
    private int mPreRealWidth;
    private GraphicSize mPseudoResetGraphicSize;
    private Drawable mRippleBackground;
    private int mStickyOffset;
    public sx2.b mTraceInfo;
    private WXTransition mTransition;
    private int mType;
    private String mViewTreeKey;
    private boolean waste;

    /* compiled from: Taobao */
    public static class MeasureOutput {
        public int height;
        public int width;
    }

    /* compiled from: Taobao */
    public interface OnClickListener {
        void onHostViewClick();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class OnClickListenerImp implements OnClickListener {
        private OnClickListenerImp() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
        public void onHostViewClick() {
            HashMap newHashMapWithExpectedSize = WXDataStructureUtil.newHashMapWithExpectedSize(1);
            HashMap newHashMapWithExpectedSize2 = WXDataStructureUtil.newHashMapWithExpectedSize(4);
            int[] iArr = new int[2];
            WXComponent.this.mHost.getLocationOnScreen(iArr);
            newHashMapWithExpectedSize2.put(Constants.Name.X, Float.valueOf(WXViewUtils.getWebPxByWidth((float) iArr[0], WXComponent.this.mInstance.getInstanceViewPortWidth())));
            newHashMapWithExpectedSize2.put(Constants.Name.Y, Float.valueOf(WXViewUtils.getWebPxByWidth((float) iArr[1], WXComponent.this.mInstance.getInstanceViewPortWidth())));
            newHashMapWithExpectedSize2.put("width", Float.valueOf(WXViewUtils.getWebPxByWidth(WXComponent.this.getLayoutWidth(), WXComponent.this.mInstance.getInstanceViewPortWidth())));
            newHashMapWithExpectedSize2.put("height", Float.valueOf(WXViewUtils.getWebPxByWidth(WXComponent.this.getLayoutHeight(), WXComponent.this.mInstance.getInstanceViewPortWidth())));
            newHashMapWithExpectedSize.put("position", newHashMapWithExpectedSize2);
            WXComponent.this.fireEvent("click", newHashMapWithExpectedSize);
        }
    }

    /* compiled from: Taobao */
    public interface OnFocusChangeListener {
        void onFocusChange(boolean z);
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface RenderState {
    }

    @Deprecated
    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    private void applyBorder(WXComponent wXComponent) {
        CSSShorthand border = wXComponent.getBorder();
        float f = border.get(CSSShorthand.EDGE.LEFT);
        float f2 = border.get(CSSShorthand.EDGE.TOP);
        float f3 = border.get(CSSShorthand.EDGE.RIGHT);
        float f4 = border.get(CSSShorthand.EDGE.BOTTOM);
        if (this.mHost != null) {
            setBorderWidth(Constants.Name.BORDER_LEFT_WIDTH, f);
            setBorderWidth(Constants.Name.BORDER_TOP_WIDTH, f2);
            setBorderWidth(Constants.Name.BORDER_RIGHT_WIDTH, f3);
            setBorderWidth(Constants.Name.BORDER_BOTTOM_WIDTH, f4);
        }
    }

    private void applyEvents() {
        if (getEvents() != null && !getEvents().isEmpty()) {
            WXEvent events = getEvents();
            int size = events.size();
            int i = 0;
            while (i < size && i < events.size()) {
                addEvent((String) events.get(i));
                i++;
            }
            setActiveTouchListener();
        }
    }

    private WXAnimationBean createAnimationBean(String str, Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get("transform");
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    String str2 = (String) map.get(Constants.Name.TRANSFORM_ORIGIN);
                    WXAnimationBean wXAnimationBean = new WXAnimationBean();
                    int layoutWidth = (int) getLayoutWidth();
                    int layoutHeight = (int) getLayoutHeight();
                    WXAnimationBean.Style style = new WXAnimationBean.Style();
                    wXAnimationBean.styles = style;
                    style.init(str2, (String) obj, layoutWidth, layoutHeight, WXSDKManager.w(getInstanceId()), getInstance());
                    return wXAnimationBean;
                }
            } catch (RuntimeException e) {
                WXLogUtils.e("", e);
            }
        }
        return null;
    }

    private boolean needGestureDetector(String str) {
        if (this.mHost != null) {
            for (WXGestureType.LowLevelGesture lowLevelGesture : WXGestureType.LowLevelGesture.values()) {
                if (str.equals(lowLevelGesture.toString())) {
                    return true;
                }
            }
            for (WXGestureType.HighLevelGesture highLevelGesture : WXGestureType.HighLevelGesture.values()) {
                if (str.equals(highLevelGesture.toString())) {
                    return true;
                }
            }
        }
        return WXGesture.isStopPropagation(str);
    }

    private void parseAnimation() {
        WXAnimationBean createAnimationBean;
        ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> concurrentLinkedQueue = this.animations;
        if (concurrentLinkedQueue != null) {
            Iterator<Pair<String, Map<String, Object>>> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                Pair<String, Map<String, Object>> next = it.next();
                if (!TextUtils.isEmpty((CharSequence) next.first) && (createAnimationBean = createAnimationBean((String) next.first, (Map) next.second)) != null) {
                    new GraphicActionAnimation(getInstance(), getRef(), createAnimationBean).executeAction();
                }
            }
            this.animations.clear();
        }
    }

    private Drawable prepareBackgroundRipple() {
        int i;
        try {
            if (!(getStyles() == null || getStyles().getPesudoResetStyles() == null)) {
                Map<String, Object> pesudoResetStyles = getStyles().getPesudoResetStyles();
                Object obj = pesudoResetStyles.get("backgroundColor");
                if (obj != null) {
                    i = WXResourceUtils.getColor(obj.toString(), 0);
                    if (i == 0) {
                        return null;
                    }
                } else {
                    i = 0;
                }
                Object obj2 = pesudoResetStyles.get("backgroundColor:active");
                if (obj2 == null) {
                    return null;
                }
                int color = WXResourceUtils.getColor(obj2.toString(), i);
                if (Build.VERSION.SDK_INT >= 21) {
                    return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{color}), new ColorDrawable(i), null) {
                        /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass6 */

                        @SuppressLint({"CanvasSize"})
                        public void draw(@NonNull Canvas canvas) {
                            if (WXComponent.this.mBackgroundDrawable != null) {
                                canvas.clipPath(WXComponent.this.mBackgroundDrawable.getContentPath(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())));
                            }
                            super.draw(canvas);
                        }
                    };
                }
            }
        } catch (Throwable th) {
            WXLogUtils.w("Exception on create ripple: ", th);
        }
        return null;
    }

    private void recordInteraction(int i, int i2) {
        if (this.mIsAddElementToTree) {
            boolean z = false;
            this.mIsAddElementToTree = false;
            if (this.mParent == null) {
                this.interactionAbsoluteX = 0;
                this.interactionAbsoluteY = 0;
            } else {
                float cSSLayoutTop = getCSSLayoutTop();
                float cSSLayoutLeft = getCSSLayoutLeft();
                this.interactionAbsoluteX = (int) (isFixed() ? cSSLayoutLeft : ((float) (this.mParent.interactionAbsoluteX + this.mParent.mChildrensWidth)) + cSSLayoutLeft);
                if (!isFixed()) {
                    cSSLayoutTop += (float) this.mParent.interactionAbsoluteY;
                }
                this.interactionAbsoluteY = (int) cSSLayoutTop;
                if (("slider".equalsIgnoreCase(this.mParent.getComponentType()) || WXBasicComponentType.CYCLE_SLIDER.equalsIgnoreCase(this.mParent.getComponentType())) && !WXBasicComponentType.INDICATOR.equalsIgnoreCase(getComponentType())) {
                    this.mParent.mChildrensWidth += (int) (((float) i) + cSSLayoutLeft);
                }
            }
            if (getInstance().getApmForInstance().l == null) {
                getInstance().getApmForInstance().l = new Rect();
            }
            Rect rect = getInstance().getApmForInstance().l;
            rect.set(0, 0, this.mInstance.getWeexWidth(), this.mInstance.getWeexHeight());
            if (rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY + i2) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY + i2)) {
                z = true;
            }
            this.mInstance.onChangeElement(this, !z);
        }
    }

    private void setActiveTouchListener() {
        View realView;
        if (getStyles().getPesudoStyles().containsKey(Constants.PSEUDO.ACTIVE) && (realView = getRealView()) != null) {
            realView.setOnTouchListener(new TouchActivePseudoListener(this, !isConsumeTouch()));
        }
    }

    private void setComponentLayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        Widget widget;
        if (getInstance() != null && !getInstance().isDestroy()) {
            FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
            if (flatUIContext != null && flatUIContext.getFlatComponentAncestor(this) != null) {
                if (this instanceof FlatComponent) {
                    FlatComponent flatComponent = (FlatComponent) this;
                    if (!flatComponent.promoteToView(true)) {
                        widget = flatComponent.getOrCreateFlatWidget();
                        setWidgetParams(widget, flatUIContext, point, i, i2, i3, i5, i4, i6);
                    }
                }
                widget = flatUIContext.getAndroidViewWidget(this);
                setWidgetParams(widget, flatUIContext, point, i, i2, i3, i5, i4, i6);
            } else if (this.mHost != null) {
                clearBoxShadow();
                if (isFixed()) {
                    setFixedHostLayoutParams(this.mHost, i, i2, i3, i5, i4, i6);
                } else {
                    setHostLayoutParams(this.mHost, i, i2, i3, i5, i4, i6);
                }
                recordInteraction(i, i2);
                this.mPreRealWidth = i;
                this.mPreRealHeight = i2;
                this.mPreRealLeft = i3;
                this.mPreRealRight = i5;
                this.mPreRealTop = i4;
                onFinishLayout();
                updateBoxShadow();
            }
        }
    }

    private void setFixedHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = i;
        layoutParams.height = i2;
        setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        t.setLayoutParams(layoutParams);
        this.mInstance.moveFixedView(t);
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("Weex_Fixed_Style", "WXComponent:setLayout :" + i3 + " " + i5 + " " + i + " " + i2);
            StringBuilder sb = new StringBuilder();
            sb.append("WXComponent:setLayout Left:");
            sb.append(getStyles().getLeft());
            sb.append(" ");
            sb.append((int) getStyles().getTop());
            WXLogUtils.d("Weex_Fixed_Style", sb.toString());
        }
    }

    private void setFixedSize(String str) {
        ViewGroup.LayoutParams layoutParams;
        if (PROP_FS_MATCH_PARENT.equals(str)) {
            this.mFixedProp = -1;
        } else if (PROP_FS_WRAP_CONTENT.equals(str)) {
            this.mFixedProp = -2;
        } else {
            this.mFixedProp = 0;
            return;
        }
        T t = this.mHost;
        if (t != null && (layoutParams = t.getLayoutParams()) != null) {
            int i = this.mFixedProp;
            layoutParams.height = i;
            layoutParams.width = i;
            this.mHost.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: com.taobao.weex.ui.component.WXComponent<T extends android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private void setWidgetParams(Widget widget, FlatGUIContext flatGUIContext, Point point, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Point point2 = new Point();
        if (this.mParent != null) {
            if (!(this.mParent instanceof FlatComponent) || flatGUIContext.getFlatComponentAncestor(this.mParent) == null || flatGUIContext.getAndroidViewWidget(this.mParent) != null) {
                i8 = i3;
                i7 = i5;
                point2.set(i8, i7);
            } else {
                point2.set(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                i8 = i3;
                i7 = i5;
            }
            if ((this.mParent instanceof FlatComponent) && flatGUIContext.getFlatComponentAncestor(this.mParent) != null && flatGUIContext.getAndroidViewWidget(this.mParent) == null) {
                Point locInFlatContainer = ((FlatComponent) this.mParent).getOrCreateFlatWidget().getLocInFlatContainer();
                point2.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(locInFlatContainer), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(locInFlatContainer));
            }
            ViewGroup.LayoutParams childLayoutParams = this.mParent.getChildLayoutParams(this, this.mHost, i, i2, i3, i4, i5, i6);
            if (childLayoutParams instanceof ViewGroup.MarginLayoutParams) {
                i11 = childLayoutParams.width;
                i10 = childLayoutParams.height;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childLayoutParams;
                int i13 = marginLayoutParams.leftMargin;
                i9 = marginLayoutParams.rightMargin;
                int i14 = marginLayoutParams.topMargin;
                i12 = marginLayoutParams.bottomMargin;
                i8 = i13;
                i7 = i14;
                widget.setLayout(i11, i10, i8, i9, i7, i12, point2);
                if (!(widget instanceof AndroidViewWidget)) {
                    AndroidViewWidget androidViewWidget = (AndroidViewWidget) widget;
                    if (androidViewWidget.getView() != null) {
                        setHostLayoutParams(androidViewWidget.getView(), i11, i10, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), i9, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2), i12);
                        return;
                    }
                    return;
                }
                return;
            }
        } else {
            i8 = i3;
            i7 = i5;
        }
        i11 = i;
        i10 = i2;
        i9 = i4;
        i12 = i6;
        widget.setLayout(i11, i10, i8, i9, i7, i12, point2);
        if (!(widget instanceof AndroidViewWidget)) {
        }
    }

    private boolean shouldCancelHardwareAccelerate() {
        IWXConfigAdapter J = WXSDKManager.v().J();
        boolean z = true;
        if (J != null) {
            try {
                z = Boolean.parseBoolean(J.getConfig("android_weex_test_gpu", "cancel_hardware_accelerate", "true"));
            } catch (Exception e) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
            }
            WXLogUtils.i("cancel_hardware_accelerate : " + z);
        }
        return z;
    }

    private void updateElevation() {
        float elevation = getAttrs().getElevation(getInstance().getInstanceViewPortWidth());
        if (!Float.isNaN(elevation)) {
            ViewCompat.setElevation(getHostView(), elevation);
        }
    }

    private void updateStyleByPesudo(Map<String, Object> map) {
        new GraphicActionUpdateStyle(getInstance(), getRef(), map, getPadding(), getMargin(), getBorder(), true).executeActionOnRender();
        if (getLayoutWidth() != 0.0f || getLayoutWidth() != 0.0f) {
            WXBridgeManager.getInstance().setStyleWidth(getInstanceId(), getRef(), getLayoutWidth());
            WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), getLayoutHeight());
        }
    }

    public void addAnimationForElement(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (this.animations == null) {
                this.animations = new ConcurrentLinkedQueue<>();
            }
            this.animations.add(new Pair<>(getRef(), map));
        }
    }

    /* access modifiers changed from: protected */
    public final void addClickListener(OnClickListener onClickListener) {
        View realView;
        if (onClickListener != null && (realView = getRealView()) != null) {
            if (this.mHostClickListeners == null) {
                this.mHostClickListeners = new ArrayList();
                realView.setOnClickListener(new View.OnClickListener() {
                    /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass4 */

                    public void onClick(View view) {
                        WXGesture wXGesture = WXComponent.this.mGesture;
                        if (wXGesture == null || !wXGesture.isTouchEventConsumedByAdvancedGesture()) {
                            for (OnClickListener onClickListener : WXComponent.this.mHostClickListeners) {
                                if (onClickListener != null) {
                                    onClickListener.onHostViewClick();
                                }
                            }
                        }
                    }
                });
            }
            this.mHostClickListeners.add(onClickListener);
        }
    }

    public void addEvent(String str) {
        if (this.mAppendEvents == null) {
            this.mAppendEvents = new HashSet();
        }
        if (!TextUtils.isEmpty(str) && !this.mAppendEvents.contains(str)) {
            View realView = getRealView();
            if (str.equals(Constants.Event.LAYEROVERFLOW)) {
                addLayerOverFlowListener(getRef());
            }
            if (str.equals("click")) {
                if (realView != null) {
                    if (this.mClickEventListener == null) {
                        this.mClickEventListener = new OnClickListenerImp();
                    }
                    addClickListener(this.mClickEventListener);
                } else {
                    return;
                }
            } else if (str.equals(Constants.Event.FOCUS) || str.equals("blur")) {
                if (!this.mHasAddFocusListener) {
                    this.mHasAddFocusListener = true;
                    addFocusChangeListener(new OnFocusChangeListener() {
                        /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass1 */

                        @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
                        public void onFocusChange(boolean z) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                            WXComponent.this.fireEvent(z ? Constants.Event.FOCUS : "blur", hashMap);
                        }
                    });
                }
            } else if (!needGestureDetector(str)) {
                Scrollable parentScroller = getParentScroller();
                if (parentScroller != null) {
                    if (str.equals(Constants.Event.APPEAR)) {
                        parentScroller.bindAppearEvent(this);
                    } else if (str.equals(Constants.Event.DISAPPEAR)) {
                        parentScroller.bindDisappearEvent(this);
                    }
                } else {
                    return;
                }
            } else if (realView != null) {
                if (realView instanceof WXGestureObservable) {
                    if (this.mGesture == null) {
                        this.mGesture = new WXGesture(this, this.mContext);
                        this.mGesture.setPreventMoveEvent(WXUtils.getBoolean(getAttrs().get(Constants.Name.PREVENT_MOVE_EVENT), Boolean.FALSE).booleanValue());
                    }
                    if (this.mGestureType == null) {
                        this.mGestureType = new HashSet();
                    }
                    this.mGestureType.add(str);
                    ((WXGestureObservable) realView).registerGestureListener(this.mGesture);
                } else {
                    WXLogUtils.e(realView.getClass().getSimpleName() + " don't implement " + "WXGestureObservable, so no gesture is supported.");
                }
            } else {
                return;
            }
            this.mAppendEvents.add(str);
        }
    }

    /* access modifiers changed from: protected */
    public final void addFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        View realView;
        if (onFocusChangeListener != null && (realView = getRealView()) != null) {
            if (this.mFocusChangeListeners == null) {
                this.mFocusChangeListeners = new ArrayList();
                realView.setFocusable(true);
                realView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass3 */

                    public void onFocusChange(View view, boolean z) {
                        for (OnFocusChangeListener onFocusChangeListener : WXComponent.this.mFocusChangeListeners) {
                            if (onFocusChangeListener != null) {
                                onFocusChangeListener.onFocusChange(z);
                            }
                        }
                    }
                });
            }
            this.mFocusChangeListeners.add(onFocusChangeListener);
        }
    }

    public void addLayerOverFlowListener(String str) {
        if (getInstance() != null) {
            getInstance().addLayerOverFlowListener(str);
        }
    }

    /* access modifiers changed from: protected */
    public void appendEventToDOM(String str) {
    }

    public void applyComponentEvents() {
        applyEvents();
    }

    public void applyLayoutAndEvent(WXComponent wXComponent) {
        if (!isLazy()) {
            if (wXComponent == null) {
                wXComponent = this;
            }
            bindComponent(wXComponent);
            setSafeLayout(wXComponent);
            setPadding(wXComponent.getPadding(), wXComponent.getBorder());
            applyEvents();
        }
    }

    public void applyLayoutOnly() {
        if (!isLazy()) {
            setSafeLayout(this);
            setPadding(getPadding(), getBorder());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.basic.WXBasicComponent
    public final void bindComponent(WXComponent wXComponent) {
        super.bindComponent(wXComponent);
        if (getInstance() != null) {
            setViewPortWidth(getInstance().getInstanceViewPortWidth());
        }
        this.mParent = wXComponent.getParent();
        this.mType = wXComponent.getType();
    }

    public void bindData(WXComponent wXComponent) {
        if (!isLazy()) {
            if (wXComponent == null) {
                wXComponent = this;
            }
            bindComponent(wXComponent);
            updateStyles(wXComponent);
            updateAttrs(wXComponent);
            updateExtra(wXComponent.getExtra());
        }
    }

    public void bindHolder(IFComponentHolder iFComponentHolder) {
        this.mHolder = iFComponentHolder;
    }

    public boolean canRecycled() {
        return (!isFixed() || !isSticky()) && getAttrs().canRecycled();
    }

    /* access modifiers changed from: protected */
    public void clearBoxShadow() {
        ViewOverlay overlay;
        if (BoxShadowUtil.isBoxShadowEnabled()) {
            if (getStyles() == null || getStyles().get(Constants.Name.BOX_SHADOW) != null) {
                View view = this.mHost;
                if (this instanceof WXVContainer) {
                    view = ((WXVContainer) this).getBoxShadowHost(true);
                }
                if (!(view == null || Build.VERSION.SDK_INT < 18 || (overlay = view.getOverlay()) == null)) {
                    overlay.clear();
                }
                this.mLastBoxShadowId = null;
            }
        }
    }

    public void clearPreLayout() {
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
    }

    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        View realView = getRealView();
        pointF.set((float) realView.getScrollX(), (float) realView.getScrollY());
    }

    public boolean containsEvent(String str) {
        Set<String> set;
        return getEvents().contains(str) || ((set = this.mAppendEvents) != null && set.contains(str));
    }

    public boolean containsGesture(WXGestureType wXGestureType) {
        Set<String> set = this.mGestureType;
        return set != null && set.contains(wXGestureType.toString());
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        if (r5.equals(com.taobao.weex.common.Constants.Name.BORDER_RIGHT_COLOR) == false) goto L_0x0010;
     */
    @CheckResult
    public Object convertEmptyProperty(String str, Object obj) {
        str.hashCode();
        char c = 0;
        switch (str.hashCode()) {
            case -1989576717:
                break;
            case -1971292586:
                if (str.equals(Constants.Name.BORDER_RIGHT_WIDTH)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1470826662:
                if (str.equals(Constants.Name.BORDER_TOP_COLOR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1452542531:
                if (str.equals(Constants.Name.BORDER_TOP_WIDTH)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1308858324:
                if (str.equals(Constants.Name.BORDER_BOTTOM_COLOR)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1290574193:
                if (str.equals(Constants.Name.BORDER_BOTTOM_WIDTH)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1228066334:
                if (str.equals(Constants.Name.BORDER_TOP_LEFT_RADIUS)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -242276144:
                if (str.equals(Constants.Name.BORDER_LEFT_COLOR)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -223992013:
                if (str.equals(Constants.Name.BORDER_LEFT_WIDTH)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 333432965:
                if (str.equals(Constants.Name.BORDER_TOP_RIGHT_RADIUS)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 581268560:
                if (str.equals(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 588239831:
                if (str.equals(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 741115130:
                if (str.equals(Constants.Name.BORDER_WIDTH)) {
                    c = CharUtils.CR;
                    break;
                }
                c = 65535;
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1349188574:
                if (str.equals(Constants.Name.BORDER_RADIUS)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 7:
            case '\f':
                return "black";
            case 1:
            case 3:
            case 5:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
            case 15:
                return 0;
            case 14:
                return "transparent";
            default:
                return obj;
        }
    }

    public final void createView() {
        if (!isLazy()) {
            createViewImpl();
        }
    }

    /* access modifiers changed from: protected */
    public void createViewImpl() {
        Context context = this.mContext;
        if (context != null) {
            T initComponentHostView = initComponentHostView(context);
            this.mHost = initComponentHostView;
            if (initComponentHostView == null && !isVirtualComponent()) {
                initView();
            }
            T t = this.mHost;
            if (t != null) {
                if (t.getId() == -1) {
                    this.mHost.setId(WXViewUtils.generateViewId());
                }
                if (TextUtils.isEmpty(this.mHost.getContentDescription()) && WXEnvironment.isApkDebugable()) {
                    this.mHost.setContentDescription(getRef());
                }
                ComponentObserver componentObserver = getInstance().getComponentObserver();
                if (componentObserver != null) {
                    componentObserver.onViewCreated(this, this.mHost);
                }
            }
            onHostViewInitialized(this.mHost);
            return;
        }
        WXLogUtils.e("createViewImpl", "Context is null");
    }

    public void destroy() {
        T hostView;
        ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onPreDestory(this);
        }
        if (!WXEnvironment.isApkDebugable() || WXUtils.isUiThread()) {
            T t = this.mHost;
            if (t != null && t.getLayerType() == 2 && isLayerTypeEnabled()) {
                this.mHost.setLayerType(0, null);
            }
            removeAllEvent();
            removeStickyStyle();
            if (isFixed() && (hostView = getHostView()) != null) {
                getInstance().removeFixedView(hostView);
            }
            ContentBoxMeasurement contentBoxMeasurement2 = this.contentBoxMeasurement;
            if (contentBoxMeasurement2 != null) {
                contentBoxMeasurement2.destroy();
                this.contentBoxMeasurement = null;
            }
            this.mIsDestroyed = true;
            ConcurrentLinkedQueue<Pair<String, Map<String, Object>>> concurrentLinkedQueue = this.animations;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
                return;
            }
            return;
        }
        throw new WXRuntimeException("[WXComponent] destroy can only be called in main thread");
    }

    public View detachViewAndClearPreInfo() {
        T t = this.mHost;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
        return t;
    }

    /* access modifiers changed from: protected */
    public final WXComponent findComponent(String str) {
        if (this.mInstance == null || str == null) {
            return null;
        }
        return WXSDKManager.v().G().getWXComponent(this.mInstance.getInstanceId(), str);
    }

    public Object findTypeParent(WXComponent wXComponent, Class cls) {
        if (wXComponent.getClass() == cls) {
            return wXComponent;
        }
        if (wXComponent.getParent() == null) {
            return null;
        }
        findTypeParent(wXComponent.getParent(), cls);
        return null;
    }

    public final void fireEvent(String str) {
        fireEvent(str, null);
    }

    public final EventResult fireEventWait(String str, Map<String, Object> map) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AnonymousClass2 r1 = new EventResult() {
            /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass2 */

            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            fireEvent(str, map, null, r1);
            countDownLatch.await(50, TimeUnit.MILLISECONDS);
            return r1;
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("fireEventWait", e);
            }
            return r1;
        }
    }

    public int getAbsoluteX() {
        return this.mAbsoluteX;
    }

    public int getAbsoluteY() {
        return this.mAbsoluteY;
    }

    public String getAttrByKey(String str) {
        return "default";
    }

    public Rect getComponentSize() {
        Rect rect = new Rect();
        T t = this.mHost;
        if (t != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            t.getLocationOnScreen(iArr);
            this.mInstance.getContainerView().getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = (iArr[1] - this.mStickyOffset) - iArr2[1];
            rect.set(i, i2, ((int) getLayoutWidth()) + i, ((int) getLayoutHeight()) + i2);
        }
        return rect;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public Scrollable getFirstScroller() {
        if (this instanceof Scrollable) {
            return (Scrollable) this;
        }
        return null;
    }

    public T getHostView() {
        return this.mHost;
    }

    public WXSDKInstance getInstance() {
        return this.mInstance;
    }

    public String getInstanceId() {
        return this.mInstance.getInstanceId();
    }

    public int getLayoutTopOffsetForSibling() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public BorderDrawable getOrCreateBorder() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = new BorderDrawable();
            T t = this.mHost;
            if (t != null) {
                WXViewUtils.setBackGround(t, null, this);
                if (this.mRippleBackground == null) {
                    WXViewUtils.setBackGround(this.mHost, this.mBackgroundDrawable, this);
                } else {
                    WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
                }
            }
        }
        return this.mBackgroundDrawable;
    }

    public WXVContainer getParent() {
        return this.mParent;
    }

    public Scrollable getParentScroller() {
        WXComponent<T> wXComponent = this;
        do {
            wXComponent = wXComponent.getParent();
            if (wXComponent == null) {
                return null;
            }
            if (wXComponent instanceof Scrollable) {
                return (Scrollable) wXComponent;
            }
        } while (!wXComponent.getRef().equals(ROOT));
        return null;
    }

    public View getRealView() {
        return this.mHost;
    }

    public long getRenderObjectPtr() {
        if (getBasicComponentData().isRenderPtrEmpty()) {
            getBasicComponentData().setRenderObjectPr(NativeRenderObjectUtils.nativeGetRenderObject(getInstanceId(), getRef()));
        }
        return getBasicComponentData().getRenderObjectPr();
    }

    public int getStickyOffset() {
        return this.mStickyOffset;
    }

    public WXTransition getTransition() {
        return this.mTransition;
    }

    public int getType() {
        return this.mType;
    }

    @Deprecated
    public View getView() {
        return this.mHost;
    }

    public String getViewTreeKey() {
        if (this.mViewTreeKey == null) {
            if (getParent() == null) {
                this.mViewTreeKey = hashCode() + JSMethod.NOT_SET + getRef();
            } else {
                this.mViewTreeKey = hashCode() + JSMethod.NOT_SET + getRef() + JSMethod.NOT_SET + getParent().indexOf(this);
            }
        }
        return this.mViewTreeKey;
    }

    @Nullable
    public String getVisibility() {
        try {
            return (String) getStyles().get("visibility");
        } catch (Exception unused) {
            return "visible";
        }
    }

    public boolean hasScrollParent(WXComponent wXComponent) {
        if (wXComponent.getParent() == null) {
            return true;
        }
        if (wXComponent.getParent() instanceof WXScroller) {
            return false;
        }
        return hasScrollParent(wXComponent.getParent());
    }

    /* access modifiers changed from: protected */
    public T initComponentHostView(@NonNull Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void initView() {
        Context context = this.mContext;
        if (context != null) {
            this.mHost = initComponentHostView(context);
        }
    }

    public final void invoke(String str, JSONArray jSONArray) {
        Invoker methodInvoker = this.mHolder.getMethodInvoker(str);
        if (methodInvoker != null) {
            try {
                getInstance().getNativeInvokeHelper().invoke(this, methodInvoker, jSONArray);
            } catch (Exception e) {
                WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + methodInvoker.toString() + " function " + WXLogUtils.getStackTrace(e));
            }
        } else {
            onInvokeUnknownMethod(str, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isConsumeTouch() {
        List<OnClickListener> list = this.mHostClickListeners;
        return (list != null && list.size() > 0) || this.mGesture != null;
    }

    public boolean isDestoryed() {
        return this.mIsDestroyed;
    }

    public boolean isDisabled() {
        return this.mIsDisabled;
    }

    public boolean isFixed() {
        return getStyles().isFixed();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isFlatUIEnabled() {
        return this.mParent != null && this.mParent.isFlatUIEnabled();
    }

    public boolean isLayerTypeEnabled() {
        return getInstance().isLayerTypeEnabled();
    }

    public boolean isLazy() {
        if (this.mLazy) {
            return true;
        }
        if (this.mParent == null || !this.mParent.isLazy()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isRippleEnabled() {
        try {
            return WXUtils.getBoolean(getAttrs().get(Constants.Name.RIPPLE_ENABLED), Boolean.FALSE).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isSticky() {
        return getStyles().isSticky();
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public boolean isVirtualComponent() {
        return this.mType == 1;
    }

    public boolean isWaste() {
        return this.waste;
    }

    /* access modifiers changed from: protected */
    public void layoutDirectionDidChanged(boolean z) {
    }

    public void lazy(boolean z) {
        this.mLazy = z;
    }

    /* access modifiers changed from: protected */
    public MeasureOutput measure(int i, int i2) {
        MeasureOutput measureOutput = new MeasureOutput();
        int i3 = this.mFixedProp;
        if (i3 != 0) {
            measureOutput.width = i3;
            measureOutput.height = i3;
        } else {
            measureOutput.width = i;
            measureOutput.height = i2;
        }
        return measureOutput;
    }

    public void nativeUpdateAttrs(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeAttr(entry.getKey(), entry.getValue());
            }
        }
    }

    public void notifyAppearStateChange(String str, String str2) {
        if (containsEvent(Constants.Event.APPEAR) || containsEvent(Constants.Event.DISAPPEAR)) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str2);
            fireEvent(str, hashMap);
        }
    }

    public void notifyNativeSizeChanged(int i, int i2) {
        if (this.mNeedLayoutOnAnimation) {
            WXBridgeManager instance = WXBridgeManager.getInstance();
            instance.setStyleWidth(getInstanceId(), getRef(), (float) i);
            instance.setStyleHeight(getInstanceId(), getRef(), (float) i2);
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        return false;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onFinishLayout() {
        Object obj = getStyles() != null ? getStyles().get(Constants.Name.BACKGROUND_IMAGE) : null;
        if (obj != null) {
            setBackgroundImage(obj.toString());
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onHostViewInitialized(T t) {
        WXAnimationModule.AnimationHolder animationHolder = this.mAnimationHolder;
        if (animationHolder != null) {
            animationHolder.execute(this.mInstance, this);
        }
        setActiveTouchListener();
    }

    /* access modifiers changed from: protected */
    public void onInvokeUnknownMethod(String str, JSONArray jSONArray) {
    }

    @CallSuper
    public void onRenderFinish(int i) {
        if (sx2.b()) {
            double a = se2.a(this.mTraceInfo.e);
            if (i == 2 || i == 0) {
                sx2.a c = sx2.c("DomExecute", getInstanceId(), this.mTraceInfo.a);
                c.c = "X";
                c.e = this.mTraceInfo.c;
                c.b = "DOMThread";
                c.i = getComponentType();
                c.j = getClass().getSimpleName();
                if (getParent() != null) {
                    c.h = getParent().getRef();
                }
                c.a();
            }
            if (i != 2 && i != 1) {
                return;
            }
            if (this.mTraceInfo.d != -1) {
                sx2.a c2 = sx2.c("UIExecute", getInstanceId(), this.mTraceInfo.a);
                c2.c = "X";
                c2.l = a;
                c2.e = this.mTraceInfo.d;
                c2.i = getComponentType();
                c2.j = getClass().getSimpleName();
                if (getParent() != null) {
                    c2.h = getParent().getRef();
                }
                c2.a();
            } else if (WXEnvironment.isApkDebugable()) {
                isLazy();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void postAnimation(WXAnimationModule.AnimationHolder animationHolder) {
        this.mAnimationHolder = animationHolder;
    }

    public void readyToRender() {
        if (this.mParent != null && getInstance().isTrackComponent()) {
            this.mParent.readyToRender();
        }
    }

    public void recycled() {
        if (!isFixed()) {
            clearBoxShadow();
        }
    }

    public void refreshData(WXComponent wXComponent) {
    }

    @Deprecated
    public void registerActivityStateListener() {
    }

    public void removeAllEvent() {
        if (getEvents().size() >= 1) {
            WXEvent events = getEvents();
            int size = events.size();
            int i = 0;
            while (i < size && i < events.size()) {
                String str = (String) events.get(i);
                if (str != null) {
                    removeEventFromView(str);
                }
                i++;
            }
            Set<String> set = this.mAppendEvents;
            if (set != null) {
                set.clear();
            }
            Set<String> set2 = this.mGestureType;
            if (set2 != null) {
                set2.clear();
            }
            this.mGesture = null;
            if (getRealView() != null && (getRealView() instanceof WXGestureObservable)) {
                ((WXGestureObservable) getRealView()).registerGestureListener(null);
            }
            T t = this.mHost;
            if (t != null) {
                t.setOnFocusChangeListener(null);
                List<OnClickListener> list = this.mHostClickListeners;
                if (list != null && list.size() > 0) {
                    this.mHostClickListeners.clear();
                    this.mHost.setOnClickListener(null);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void removeClickListener(OnClickListener onClickListener) {
        this.mHostClickListeners.remove(onClickListener);
    }

    public void removeEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(Constants.Event.LAYEROVERFLOW)) {
                removeLayerOverFlowListener(getRef());
            }
            if (getEvents() != null) {
                getEvents().remove(str);
            }
            Set<String> set = this.mAppendEvents;
            if (set != null) {
                set.remove(str);
            }
            Set<String> set2 = this.mGestureType;
            if (set2 != null) {
                set2.remove(str);
            }
            removeEventFromView(str);
        }
    }

    /* access modifiers changed from: protected */
    public void removeEventFromView(String str) {
        if (!(!str.equals("click") || getRealView() == null || this.mHostClickListeners == null)) {
            if (this.mClickEventListener == null) {
                this.mClickEventListener = new OnClickListenerImp();
            }
            this.mHostClickListeners.remove(this.mClickEventListener);
        }
        Scrollable parentScroller = getParentScroller();
        if (str.equals(Constants.Event.APPEAR) && parentScroller != null) {
            parentScroller.unbindAppearEvent(this);
        }
        if (str.equals(Constants.Event.DISAPPEAR) && parentScroller != null) {
            parentScroller.unbindDisappearEvent(this);
        }
    }

    public void removeLayerOverFlowListener(String str) {
        if (getInstance() != null) {
            getInstance().removeLayerOverFlowListener(str);
        }
    }

    public final void removeStickyStyle() {
        Scrollable parentScroller;
        if (isSticky() && (parentScroller = getParentScroller()) != null) {
            parentScroller.unbindStickStyle(this);
        }
    }

    public void removeVirtualComponent() {
    }

    /* access modifiers changed from: protected */
    @TargetApi(16)
    public void setAriaHidden(boolean z) {
        T hostView = getHostView();
        if (hostView != null && Build.VERSION.SDK_INT >= 16) {
            hostView.setImportantForAccessibility(z ? 2 : 1);
        }
    }

    /* access modifiers changed from: protected */
    public void setAriaLabel(String str) {
        T hostView = getHostView();
        if (hostView != null) {
            hostView.setContentDescription(str);
        }
    }

    public void setBackgroundColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            int color = WXResourceUtils.getColor(str);
            if (isRippleEnabled() && Build.VERSION.SDK_INT >= 21) {
                Drawable prepareBackgroundRipple = prepareBackgroundRipple();
                this.mRippleBackground = prepareBackgroundRipple;
                if (prepareBackgroundRipple != null) {
                    if (this.mBackgroundDrawable == null) {
                        WXViewUtils.setBackGround(this.mHost, prepareBackgroundRipple, this);
                        return;
                    }
                    WXViewUtils.setBackGround(this.mHost, new LayerDrawable(new Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
                    return;
                }
            }
            if (color != 0 || this.mBackgroundDrawable != null) {
                getOrCreateBorder().setColor(color);
            }
        }
    }

    public void setBackgroundImage(@NonNull String str) {
        if ("".equals(str.trim())) {
            getOrCreateBorder().setImage(null);
            return;
        }
        getOrCreateBorder().setImage(WXResourceUtils.getShader(str, getLayoutSize().getWidth(), getLayoutSize().getHeight()));
    }

    public void setBorderColor(String str, String str2) {
        int color;
        if (!TextUtils.isEmpty(str2) && (color = WXResourceUtils.getColor(str2)) != Integer.MIN_VALUE) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals(Constants.Name.BORDER_RIGHT_COLOR)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals(Constants.Name.BORDER_TOP_COLOR)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_COLOR)) {
                        c = 2;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals(Constants.Name.BORDER_LEFT_COLOR)) {
                        c = 3;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.RIGHT, color);
                    return;
                case 1:
                    getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.TOP, color);
                    return;
                case 2:
                    getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.BOTTOM, color);
                    return;
                case 3:
                    getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.LEFT, color);
                    return;
                case 4:
                    getOrCreateBorder().setBorderColor(CSSShorthand.EDGE.ALL, color);
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderRadius(String str, float f) {
        if (f >= 0.0f) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1228066334:
                    if (str.equals(Constants.Name.BORDER_TOP_LEFT_RADIUS)) {
                        c = 0;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals(Constants.Name.BORDER_TOP_RIGHT_RADIUS)) {
                        c = 1;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals(Constants.Name.BORDER_RADIUS)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_TOP_LEFT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidth()));
                    return;
                case 1:
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_TOP_RIGHT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidth()));
                    return;
                case 2:
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidth()));
                    return;
                case 3:
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidth()));
                    return;
                case 4:
                    getOrCreateBorder().setBorderRadius(CSSShorthand.CORNER.ALL, WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidth()));
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderStyle(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1974639039:
                    if (str.equals(Constants.Name.BORDER_RIGHT_STYLE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals(Constants.Name.BORDER_TOP_STYLE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_STYLE)) {
                        c = 2;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals(Constants.Name.BORDER_LEFT_STYLE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals(Constants.Name.BORDER_STYLE)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.RIGHT, str2);
                    return;
                case 1:
                    getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.TOP, str2);
                    return;
                case 2:
                    getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.BOTTOM, str2);
                    return;
                case 3:
                    getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.LEFT, str2);
                    return;
                case 4:
                    getOrCreateBorder().setBorderStyle(CSSShorthand.EDGE.ALL, str2);
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderWidth(String str, float f) {
        if (f >= 0.0f) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1971292586:
                    if (str.equals(Constants.Name.BORDER_RIGHT_WIDTH)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals(Constants.Name.BORDER_TOP_WIDTH)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals(Constants.Name.BORDER_BOTTOM_WIDTH)) {
                        c = 2;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals(Constants.Name.BORDER_LEFT_WIDTH)) {
                        c = 3;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals(Constants.Name.BORDER_WIDTH)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.RIGHT, f);
                    return;
                case 1:
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.TOP, f);
                    return;
                case 2:
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.BOTTOM, f);
                    return;
                case 3:
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.LEFT, f);
                    return;
                case 4:
                    getOrCreateBorder().setBorderWidth(CSSShorthand.EDGE.ALL, f);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setContentBoxMeasurement(ContentBoxMeasurement contentBoxMeasurement2) {
        this.contentBoxMeasurement = contentBoxMeasurement2;
        this.mInstance.addContentBoxMeasurement(getRenderObjectPtr(), contentBoxMeasurement2);
        WXBridgeManager.getInstance().bindMeasurementToRenderObject(getRenderObjectPtr());
    }

    public void setDemission(GraphicSize graphicSize, GraphicPosition graphicPosition) {
        setLayoutPosition(graphicPosition);
        setLayoutSize(graphicSize);
    }

    public void setDisabled(boolean z) {
        this.mIsDisabled = z;
        T t = this.mHost;
        if (t != null) {
            t.setEnabled(!z);
        }
    }

    /* access modifiers changed from: protected */
    public void setHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mParent == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
            setMarginsSupportRTL(layoutParams2, i3, i5, i4, i6);
            layoutParams = layoutParams2;
        } else {
            layoutParams = this.mParent.getChildLayoutParams(this, t, i, i2, i3, i4, i5, i6);
        }
        if (layoutParams != null) {
            t.setLayoutParams(layoutParams);
        }
    }

    public void setLayout(WXComponent wXComponent) {
        int i;
        int i2;
        int i3;
        float f;
        setLayoutSize(wXComponent.getLayoutSize());
        setLayoutPosition(wXComponent.getLayoutPosition());
        setPaddings(wXComponent.getPadding());
        setMargins(wXComponent.getMargin());
        setBorders(wXComponent.getBorder());
        boolean isLayoutRTL = wXComponent.isLayoutRTL();
        setIsLayoutRTL(isLayoutRTL);
        if (isLayoutRTL != wXComponent.isLastLayoutDirectionRTL) {
            wXComponent.isLastLayoutDirectionRTL = isLayoutRTL;
            layoutDirectionDidChanged(isLayoutRTL);
        }
        parseAnimation();
        boolean z = this.mParent == null;
        if (z) {
            i = 0;
        } else {
            i = this.mParent.getChildrenLayoutTopOffset();
        }
        CSSShorthand cSSShorthand = z ? new CSSShorthand() : this.mParent.getPadding();
        CSSShorthand cSSShorthand2 = z ? new CSSShorthand() : this.mParent.getBorder();
        int width = (int) getLayoutSize().getWidth();
        int height = (int) getLayoutSize().getHeight();
        if (isFixed()) {
            int top = ((int) (getLayoutPosition().getTop() - ((float) getInstance().getRenderContainerPaddingTop()))) + i;
            i3 = (int) (getLayoutPosition().getLeft() - ((float) getInstance().getRenderContainerPaddingLeft()));
            i2 = top;
        } else {
            float left = getLayoutPosition().getLeft();
            CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
            float top2 = getLayoutPosition().getTop();
            CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
            i2 = ((int) ((top2 - cSSShorthand.get(edge2)) - cSSShorthand2.get(edge2))) + i;
            i3 = (int) ((left - cSSShorthand.get(edge)) - cSSShorthand2.get(edge));
        }
        int i4 = (int) getMargin().get(CSSShorthand.EDGE.RIGHT);
        int i5 = (int) getMargin().get(CSSShorthand.EDGE.BOTTOM);
        Point point = new Point((int) getLayoutPosition().getLeft(), (int) getLayoutPosition().getTop());
        if (this.mPreRealWidth != width || this.mPreRealHeight != height || this.mPreRealLeft != i3 || this.mPreRealRight != i4 || this.mPreRealTop != i2) {
            if ((this instanceof WXCell) && height >= WXPerformance.VIEW_LIMIT_HEIGHT && width >= WXPerformance.VIEW_LIMIT_WIDTH) {
                this.mInstance.getApmForInstance().B(WXInstanceApm.KEY_PAGE_STATS_CELL_EXCEED_NUM, 1.0d);
                this.mInstance.getWXPerformance().cellExceedNum++;
                if (cx2.a) {
                    cx2.d(getInstanceId(), "details", WXInstanceApm.KEY_PAGE_STATS_CELL_EXCEED_NUM, String.format(Locale.ROOT, "cell:ref:%s,[w:%d,h:%d],attrs:%s,styles:%s", getRef(), Integer.valueOf(width), Integer.valueOf(height), getAttrs(), getStyles()));
                }
            }
            float f2 = 0.0f;
            if (z) {
                f = 0.0f;
            } else {
                f = ((float) this.mParent.getAbsoluteY()) + getCSSLayoutTop();
            }
            this.mAbsoluteY = (int) f;
            if (!z) {
                f2 = getCSSLayoutLeft() + ((float) this.mParent.getAbsoluteX());
            }
            this.mAbsoluteX = (int) f2;
            T t = this.mHost;
            if (t != null) {
                if (!(t instanceof ViewGroup) && this.mAbsoluteY + height > this.mInstance.getWeexHeight() + 1) {
                    WXSDKInstance wXSDKInstance = this.mInstance;
                    if (!wXSDKInstance.mEnd) {
                        wXSDKInstance.onOldFsRenderTimeLogic();
                    }
                    WXSDKInstance wXSDKInstance2 = this.mInstance;
                    if (!wXSDKInstance2.isNewFsEnd) {
                        wXSDKInstance2.isNewFsEnd = true;
                        wXSDKInstance2.getApmForInstance().j();
                    }
                }
                MeasureOutput measure = measure(width, height);
                setComponentLayoutParams(measure.width, measure.height, i3, i2, i4, i5, point);
            }
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public void setMarginsSupportRTL(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
        if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) marginLayoutParams).gravity = 51;
        }
    }

    public void setNeedLayoutOnAnimation(boolean z) {
        this.mNeedLayoutOnAnimation = z;
    }

    public void setOpacity(float f) {
        if (f >= 0.0f && f <= 1.0f && this.mHost.getAlpha() != f) {
            int openGLRenderLimitValue = WXRenderManager.getOpenGLRenderLimitValue();
            if (isLayerTypeEnabled()) {
                this.mHost.setLayerType(2, null);
            }
            if (isLayerTypeEnabled() && shouldCancelHardwareAccelerate() && openGLRenderLimitValue > 0) {
                float f2 = (float) openGLRenderLimitValue;
                if (getLayoutHeight() > f2 || getLayoutWidth() > f2) {
                    this.mHost.setLayerType(0, null);
                }
            }
            this.mHost.setAlpha(f);
        }
    }

    public void setPadding(CSSShorthand cSSShorthand, CSSShorthand cSSShorthand2) {
        CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
        int i = (int) (cSSShorthand.get(edge) + cSSShorthand2.get(edge));
        CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
        int i2 = (int) (cSSShorthand.get(edge2) + cSSShorthand2.get(edge2));
        CSSShorthand.EDGE edge3 = CSSShorthand.EDGE.RIGHT;
        int i3 = (int) (cSSShorthand.get(edge3) + cSSShorthand2.get(edge3));
        CSSShorthand.EDGE edge4 = CSSShorthand.EDGE.BOTTOM;
        int i4 = (int) (cSSShorthand.get(edge4) + cSSShorthand2.get(edge4));
        if (this instanceof FlatComponent) {
            FlatComponent flatComponent = (FlatComponent) this;
            if (!flatComponent.promoteToView(true)) {
                flatComponent.getOrCreateFlatWidget().setContentBox(i, i2, i3, i4);
                return;
            }
        }
        T t = this.mHost;
        if (t != null) {
            t.setPadding(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public boolean setProperty(String str, Object obj) {
        if (str == null) {
            return true;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(Constants.Name.BORDER_RIGHT_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals(Constants.Name.BORDER_RIGHT_STYLE)) {
                    c = 1;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(Constants.Name.BORDER_RIGHT_WIDTH)) {
                    c = 2;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 3;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(Constants.Name.BORDER_TOP_COLOR)) {
                    c = 4;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals(Constants.Name.BORDER_TOP_STYLE)) {
                    c = 5;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(Constants.Name.BORDER_TOP_WIDTH)) {
                    c = 6;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 7;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals(Constants.Name.MIN_WIDTH)) {
                    c = '\b';
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(Constants.Name.BORDER_BOTTOM_COLOR)) {
                    c = '\t';
                    break;
                }
                break;
            case -1293920646:
                if (str.equals(Constants.Name.BORDER_BOTTOM_STYLE)) {
                    c = '\n';
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(Constants.Name.BORDER_BOTTOM_WIDTH)) {
                    c = 11;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c = '\f';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(Constants.Name.BORDER_TOP_LEFT_RADIUS)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 14;
                    break;
                }
                break;
            case -1111969773:
                if (str.equals(Constants.Name.ARIA_HIDDEN)) {
                    c = 15;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals(Constants.Name.MARGIN)) {
                    c = 16;
                    break;
                }
                break;
            case -1063257157:
                if (str.equals(Constants.Name.ALIGN_ITEMS)) {
                    c = 17;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals(Constants.Name.MARGIN_TOP)) {
                    c = 18;
                    break;
                }
                break;
            case -975171706:
                if (str.equals(Constants.Name.FLEX_DIRECTION)) {
                    c = 19;
                    break;
                }
                break;
            case -906066005:
                if (str.equals("maxHeight")) {
                    c = 20;
                    break;
                }
                break;
            case -863700117:
                if (str.equals(Constants.Name.ARIA_LABEL)) {
                    c = 21;
                    break;
                }
                break;
            case -806339567:
                if (str.equals(Constants.Name.PADDING)) {
                    c = 22;
                    break;
                }
                break;
            case -289173127:
                if (str.equals(Constants.Name.MARGIN_BOTTOM)) {
                    c = 23;
                    break;
                }
                break;
            case -242276144:
                if (str.equals(Constants.Name.BORDER_LEFT_COLOR)) {
                    c = 24;
                    break;
                }
                break;
            case -227338466:
                if (str.equals(Constants.Name.BORDER_LEFT_STYLE)) {
                    c = 25;
                    break;
                }
                break;
            case -223992013:
                if (str.equals(Constants.Name.BORDER_LEFT_WIDTH)) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case -133587431:
                if (str.equals(Constants.Name.MIN_HEIGHT)) {
                    c = 27;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 28;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c = 29;
                    break;
                }
                break;
            case 3145721:
                if (str.equals(Constants.Name.FLEX)) {
                    c = 30;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 31;
                    break;
                }
                break;
            case 3506294:
                if (str.equals(Constants.Name.ROLE)) {
                    c = ' ';
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = '!';
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = jl1.QUOTE;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = '#';
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '$';
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c = WXUtils.PERCENT;
                    break;
                }
                break;
            case 333432965:
                if (str.equals(Constants.Name.BORDER_TOP_RIGHT_RADIUS)) {
                    c = '&';
                    break;
                }
                break;
            case 400381634:
                if (str.equals(Constants.Name.MAX_WIDTH)) {
                    c = '\'';
                    break;
                }
                break;
            case 581268560:
                if (str.equals(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c = '(';
                    break;
                }
                break;
            case 588239831:
                if (str.equals(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c = ')';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = '*';
                    break;
                }
                break;
            case 717381201:
                if (str.equals(Constants.Name.PREVENT_MOVE_EVENT)) {
                    c = '+';
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = ',';
                    break;
                }
                break;
            case 737768677:
                if (str.equals(Constants.Name.BORDER_STYLE)) {
                    c = '-';
                    break;
                }
                break;
            case 741115130:
                if (str.equals(Constants.Name.BORDER_WIDTH)) {
                    c = '.';
                    break;
                }
                break;
            case 743055051:
                if (str.equals(Constants.Name.BOX_SHADOW)) {
                    c = v00.DIR;
                    break;
                }
                break;
            case 747463061:
                if (str.equals(PROP_FIXED_SIZE)) {
                    c = YKUpsConvert.CHAR_ZERO;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c = '1';
                    break;
                }
                break;
            case 975087886:
                if (str.equals(Constants.Name.MARGIN_RIGHT)) {
                    c = '2';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = '3';
                    break;
                }
                break;
            case 1292595405:
                if (str.equals(Constants.Name.BACKGROUND_IMAGE)) {
                    c = '4';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(Constants.Name.BORDER_RADIUS)) {
                    c = '5';
                    break;
                }
                break;
            case 1744216035:
                if (str.equals(Constants.Name.FLEX_WRAP)) {
                    c = '6';
                    break;
                }
                break;
            case 1767100401:
                if (str.equals(Constants.Name.ALIGN_SELF)) {
                    c = '7';
                    break;
                }
                break;
            case 1860657097:
                if (str.equals(Constants.Name.JUSTIFY_CONTENT)) {
                    c = '8';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = YKUpsConvert.CHAR_NINE;
                    break;
                }
                break;
            case 1970934485:
                if (str.equals(Constants.Name.MARGIN_LEFT)) {
                    c = jl1.CONDITION_IF_MIDDLE;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 4:
            case '\t':
            case 24:
            case ',':
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setBorderColor(str, string);
                }
                return true;
            case 1:
            case 5:
            case '\n':
            case 25:
            case '-':
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setBorderStyle(str, string2);
                }
                return true;
            case 2:
            case 3:
            case 6:
            case 7:
            case '\b':
            case 11:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 22:
            case 23:
            case 26:
            case 27:
            case 29:
            case 30:
            case 31:
            case '!':
            case '\"':
            case '#':
            case '$':
            case '\'':
            case '*':
            case '.':
            case '2':
            case '6':
            case '7':
            case '8':
            case ':':
                break;
            case '\f':
                Float f = WXUtils.getFloat(obj, null);
                if (f != null) {
                    setOpacity(f.floatValue());
                    break;
                }
                break;
            case '\r':
            case '&':
            case '(':
            case ')':
            case '5':
                Float f2 = WXUtils.getFloat(obj, null);
                if (f2 != null) {
                    setBorderRadius(str, f2.floatValue());
                }
                return true;
            case 15:
                setAriaHidden(WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue());
                return true;
            case 21:
                setAriaLabel(WXUtils.getString(obj, ""));
                return true;
            case 28:
                if (obj != null) {
                    updateElevation();
                }
                return true;
            case ' ':
                setRole(WXUtils.getString(obj, ""));
                return true;
            case '%':
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setDisabled(bool.booleanValue());
                    setPseudoClassStatus(Constants.PSEUDO.DISABLED, bool.booleanValue());
                }
                return true;
            case '+':
                WXGesture wXGesture = this.mGesture;
                if (wXGesture != null) {
                    wXGesture.setPreventMoveEvent(WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue());
                }
                return true;
            case '/':
                try {
                    updateBoxShadow();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return true;
            case '0':
                setFixedSize(WXUtils.getString(obj, PROP_FS_MATCH_PARENT));
                return true;
            case '1':
                String string3 = WXUtils.getString(obj, null);
                if (string3 != null) {
                    setSticky(string3);
                }
                return true;
            case '3':
                String string4 = WXUtils.getString(obj, null);
                if (string4 != null) {
                    setBackgroundColor(string4);
                }
                return true;
            case '4':
                String string5 = WXUtils.getString(obj, null);
                if (!(string5 == null || this.mHost == null)) {
                    setBackgroundImage(string5);
                }
                return true;
            case '9':
                String string6 = WXUtils.getString(obj, null);
                if (string6 != null) {
                    setVisibility(string6);
                }
                return true;
            default:
                return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void setPseudoClassStatus(String str, boolean z) {
        WXStyle styles = getStyles();
        Map<String, Map<String, Object>> pesudoStyles = styles.getPesudoStyles();
        if (pesudoStyles != null && pesudoStyles.size() != 0) {
            if (this.mPesudoStatus == null) {
                this.mPesudoStatus = new PesudoStatus();
            }
            Map<String, Object> updateStatusAndGetUpdateStyles = this.mPesudoStatus.updateStatusAndGetUpdateStyles(str, z, pesudoStyles, styles.getPesudoResetStyles());
            if (updateStatusAndGetUpdateStyles != null) {
                if (z) {
                    this.mPseudoResetGraphicSize = new GraphicSize(getLayoutSize().getWidth(), getLayoutSize().getHeight());
                    if (updateStatusAndGetUpdateStyles.keySet().contains("width")) {
                        getLayoutSize().setWidth(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(styles.getPesudoResetStyles().get("width:active")), getViewPortWidth()));
                    } else if (updateStatusAndGetUpdateStyles.keySet().contains("height")) {
                        getLayoutSize().setHeight(WXViewUtils.getRealPxByWidth(WXUtils.parseFloat(styles.getPesudoResetStyles().get("height:active")), getViewPortWidth()));
                    }
                } else {
                    GraphicSize graphicSize = this.mPseudoResetGraphicSize;
                    if (graphicSize != null) {
                        setLayoutSize(graphicSize);
                    }
                }
            }
            updateStyleByPesudo(updateStatusAndGetUpdateStyles);
        }
    }

    /* access modifiers changed from: protected */
    public void setRole(final String str) {
        T hostView = getHostView();
        if (hostView != null && !TextUtils.isEmpty(str)) {
            IWXAccessibilityRoleAdapter g = WXSDKManager.v().g();
            if (g != null) {
                str = g.getRole(str);
            }
            ViewCompat.setAccessibilityDelegate(hostView, new AccessibilityDelegateCompat() {
                /* class com.taobao.weex.ui.component.WXComponent.AnonymousClass5 */

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    try {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setRoleDescription(str);
                    } catch (Throwable unused) {
                        WXLogUtils.e("SetRole failed!");
                    }
                }
            });
        }
    }

    public void setSafeLayout(WXComponent wXComponent) {
        if (!TextUtils.isEmpty(wXComponent.getComponentType()) && !TextUtils.isEmpty(wXComponent.getRef()) && wXComponent.getLayoutPosition() != null && wXComponent.getLayoutSize() != null) {
            setLayout(wXComponent);
        }
    }

    public void setSticky(String str) {
        Scrollable parentScroller;
        if (!TextUtils.isEmpty(str) && str.equals("sticky") && (parentScroller = getParentScroller()) != null) {
            parentScroller.bindStickStyle(this);
        }
    }

    public void setStickyOffset(int i) {
        this.mStickyOffset = i;
    }

    public void setTransition(WXTransition wXTransition) {
        this.mTransition = wXTransition;
    }

    public void setUsing(boolean z) {
        this.isUsing = z;
    }

    public void setVisibility(String str) {
        View realView = getRealView();
        if (realView == null) {
            return;
        }
        if (TextUtils.equals(str, "visible")) {
            realView.setVisibility(0);
        } else if (TextUtils.equals(str, "hidden")) {
            realView.setVisibility(8);
        }
    }

    public void setWaste(boolean z) {
        if (this.waste != z) {
            this.waste = z;
            if (!WXBasicComponentType.RECYCLE_LIST.equals(getParent().getComponentType())) {
                NativeRenderObjectUtils.nativeRenderObjectChildWaste(getRenderObjectPtr(), z);
            }
            if (z) {
                getStyles().put("visibility", (Object) "hidden");
                if (getHostView() != null) {
                    getHostView().setVisibility(8);
                } else if (!this.mLazy) {
                    lazy(true);
                }
            } else {
                getStyles().put("visibility", (Object) "visible");
                if (getHostView() != null) {
                    getHostView().setVisibility(0);
                } else if (!this.mLazy) {
                } else {
                    if (this.mParent == null || !this.mParent.isLazy()) {
                        Statements.initLazyComponent(this, this.mParent);
                    } else {
                        lazy(false);
                    }
                }
            }
        }
    }

    @Override // com.taobao.weex.ui.component.pesudo.OnActivePseudoListner
    public void updateActivePseudo(boolean z) {
        setPseudoClassStatus(Constants.PSEUDO.ACTIVE, z);
    }

    public void updateAttrs(WXComponent wXComponent) {
        if (wXComponent != null) {
            updateProperties(wXComponent.getAttrs());
        }
    }

    /* access modifiers changed from: protected */
    public void updateBoxShadow() {
        if (BoxShadowUtil.isBoxShadowEnabled()) {
            if (getStyles() != null) {
                Object obj = getStyles().get(Constants.Name.BOX_SHADOW);
                Object obj2 = getAttrs().get(Constants.Name.SHADOW_QUALITY);
                if (obj != null) {
                    View view = this.mHost;
                    if (this instanceof WXVContainer) {
                        view = ((WXVContainer) this).getBoxShadowHost(false);
                    }
                    if (view != null) {
                        float floatValue = WXUtils.getFloat(obj2, Float.valueOf(0.5f)).floatValue();
                        int instanceViewPortWidth = getInstance().getInstanceViewPortWidth();
                        String str = obj.toString() + " / [" + view.getMeasuredWidth() + "," + view.getMeasuredHeight() + "] / " + floatValue;
                        String str2 = this.mLastBoxShadowId;
                        if (str2 == null || !str2.equals(str)) {
                            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                            WXStyle styles = getStyles();
                            if (styles != null) {
                                float floatValue2 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_TOP_LEFT_RADIUS), Float.valueOf(0.0f)).floatValue();
                                fArr[0] = floatValue2;
                                fArr[1] = floatValue2;
                                float floatValue3 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_TOP_RIGHT_RADIUS), Float.valueOf(0.0f)).floatValue();
                                fArr[2] = floatValue3;
                                fArr[3] = floatValue3;
                                float floatValue4 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS), Float.valueOf(0.0f)).floatValue();
                                fArr[4] = floatValue4;
                                fArr[5] = floatValue4;
                                float floatValue5 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_BOTTOM_LEFT_RADIUS), Float.valueOf(0.0f)).floatValue();
                                fArr[6] = floatValue5;
                                fArr[7] = floatValue5;
                                if (styles.containsKey(Constants.Name.BORDER_RADIUS)) {
                                    float floatValue6 = WXUtils.getFloat(styles.get(Constants.Name.BORDER_RADIUS), Float.valueOf(0.0f)).floatValue();
                                    for (int i = 0; i < 8; i++) {
                                        fArr[i] = floatValue6;
                                    }
                                }
                            }
                            BoxShadowUtil.setBoxShadow(view, obj.toString(), fArr, instanceViewPortWidth, floatValue);
                            this.mLastBoxShadowId = str;
                            return;
                        }
                        WXLogUtils.d("BoxShadow", "box-shadow style was not modified. " + str);
                        return;
                    }
                    return;
                }
                return;
            }
            WXLogUtils.w("Can not resolve styles");
        }
    }

    public void updateDemission(float f, float f2, float f3, float f4, float f5, float f6) {
        getLayoutPosition().update(f, f2, f3, f4);
        getLayoutSize().update(f6, f5);
    }

    public void updateNativeAttr(String str, Object obj) {
        if (str != null) {
            if (obj == null) {
                obj = "";
            }
            getBasicComponentData().getAttrs().put(str, obj);
            NativeRenderObjectUtils.nativeUpdateRenderObjectAttr(getRenderObjectPtr(), str, obj.toString());
        }
    }

    public void updateNativeStyle(String str, Object obj) {
        if (str != null) {
            if (obj == null) {
                obj = "";
            }
            getBasicComponentData().getStyles().put(str, obj);
            NativeRenderObjectUtils.nativeUpdateRenderObjectStyle(getRenderObjectPtr(), str, obj.toString());
        }
    }

    public void updateNativeStyles(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeStyle(entry.getKey(), entry.getValue());
            }
        }
    }

    @Deprecated
    public void updateProperties(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (this.mHost != null || isVirtualComponent()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                String string = WXUtils.getString(key, null);
                if (string != null && !(key instanceof String)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, getComponentType());
                    hashMap.put("actual key", string);
                    String instanceId = getInstanceId();
                    WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_COMPONENT_ATTR_KEY;
                    WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "WXComponent.updateProperties", wXErrorCode.getErrorMsg(), hashMap);
                }
                Object value = entry.getValue();
                String string2 = WXUtils.getString(value, null);
                if (string == null) {
                    String instanceId2 = getInstanceId();
                    WXErrorCode wXErrorCode2 = WXErrorCode.WX_RENDER_ERR_NULL_KEY;
                    WXExceptionUtils.commitCriticalExceptionRT(instanceId2, wXErrorCode2, "updateProperties", wXErrorCode2.getErrorMsg(), null);
                } else {
                    if (TextUtils.isEmpty(string2)) {
                        value = convertEmptyProperty(string, string2);
                    }
                    if (setProperty(string, value)) {
                        continue;
                    } else {
                        IFComponentHolder iFComponentHolder = this.mHolder;
                        if (iFComponentHolder != null) {
                            Invoker propertyInvoker = iFComponentHolder.getPropertyInvoker(string);
                            if (propertyInvoker != null) {
                                try {
                                    Type[] parameterTypes = propertyInvoker.getParameterTypes();
                                    if (parameterTypes.length != 1) {
                                        WXLogUtils.e("[WXComponent] setX method only one parameter：" + propertyInvoker);
                                        return;
                                    }
                                    propertyInvoker.invoke(this, WXReflectionUtils.parseArgument(parameterTypes[0], value));
                                } catch (Exception e) {
                                    WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + propertyInvoker.toString() + " function " + WXLogUtils.getStackTrace(e));
                                }
                            } else {
                                continue;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            readyToRender();
            if ((this instanceof FlatComponent) && this.mBackgroundDrawable != null) {
                FlatComponent flatComponent = (FlatComponent) this;
                if (!(flatComponent.promoteToView(true) || (flatComponent.getOrCreateFlatWidget() instanceof AndroidViewWidget))) {
                    flatComponent.getOrCreateFlatWidget().setBackgroundAndBorder(this.mBackgroundDrawable);
                }
            }
        }
    }

    public void updateStyles(WXComponent wXComponent) {
        if (wXComponent != null) {
            updateProperties(wXComponent.getStyles());
            applyBorder(wXComponent);
        }
    }

    @Deprecated
    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public final void fireEvent(String str, Map<String, Object> map) {
        if (WXUtils.getBoolean(getAttrs().get("fireEventSyn"), Boolean.FALSE).booleanValue()) {
            fireEventWait(str, map);
        } else {
            fireEvent(str, map, null, null);
        }
    }

    public void updateAttrs(Map<String, Object> map) {
        if (map != null) {
            updateProperties(map);
        }
    }

    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, 0, basicComponentData);
    }

    public void updateStyles(Map<String, Object> map) {
        if (map != null) {
            updateProperties(map);
            applyBorder(this);
        }
    }

    public WXComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(basicComponentData);
        this.mFixedProp = 0;
        this.mAbsoluteY = 0;
        this.mAbsoluteX = 0;
        this.isLastLayoutDirectionRTL = false;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealTop = 0;
        this.mStickyOffset = 0;
        this.isUsing = false;
        this.mIsDestroyed = false;
        this.mIsDisabled = false;
        this.mType = 0;
        this.mNeedLayoutOnAnimation = false;
        this.mDeepInComponentTree = 0;
        this.mIsAddElementToTree = false;
        this.interactionAbsoluteX = 0;
        this.interactionAbsoluteY = 0;
        this.mChildrensWidth = 0;
        this.mHasAddFocusListener = false;
        this.mTraceInfo = new sx2.b();
        this.waste = false;
        this.isIgnoreInteraction = false;
        this.mLazy = false;
        this.mInstance = wXSDKInstance;
        this.mContext = wXSDKInstance.getContext();
        this.mParent = wXVContainer;
        this.mType = i;
        if (wXSDKInstance != null) {
            setViewPortWidth(wXSDKInstance.getInstanceViewPortWidth());
        }
        onCreate();
        ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onCreate(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void fireEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        fireEvent(str, map, map2, null);
    }

    private final void fireEvent(String str, Map<String, Object> map, Map<String, Object> map2, EventResult eventResult) {
        String componentId;
        if (this.mInstance != null) {
            List<Object> list = null;
            if (!(getEvents() == null || getEvents().getEventBindingArgsValues() == null)) {
                list = getEvents().getEventBindingArgsValues().get(str);
            }
            if (!(map == null || (componentId = Statements.getComponentId(this)) == null)) {
                map.put("componentId", componentId);
            }
            this.mInstance.fireEvent(getRef(), str, map, map2, list, eventResult);
        }
    }
}
