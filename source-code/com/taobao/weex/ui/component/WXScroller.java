package com.taobao.weex.ui.component;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.ICheckBindingScroller;
import com.taobao.weex.common.OnWXScrollListener;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.helper.ScrollStartEndHelper;
import com.taobao.weex.ui.component.helper.WXStickyHelper;
import com.taobao.weex.ui.view.IWXScroller;
import com.taobao.weex.ui.view.WXBaseRefreshLayout;
import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.ui.view.WXScrollView;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXScroller extends WXVContainer<ViewGroup> implements WXScrollView.WXScrollViewListener, Scrollable {
    public static final String DIRECTION = "direction";
    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
    private Handler handler;
    private boolean isScrollable;
    private int mActiveFeature;
    private Map<String, AppearanceHelper> mAppearanceComponents;
    private int mChildrenLayoutOffset;
    private int mContentHeight;
    private boolean mForceLoadmoreNextTime;
    private GestureDetector mGestureDetector;
    private boolean mHasAddScrollEvent;
    private boolean mIsHostAttachedToWindow;
    private Boolean mIslastDirectionRTL;
    private Point mLastReport;
    private int mOffsetAccuracy;
    private View.OnAttachStateChangeListener mOnAttachStateChangeListener;
    protected int mOrientation;
    private FrameLayout mRealView;
    private List<WXComponent> mRefreshs;
    private ScrollStartEndHelper mScrollStartEndHelper;
    private FrameLayout mScrollerView;
    private Map<String, Map<String, WXComponent>> mStickyMap;
    private boolean mlastDirectionRTL;
    private boolean pageEnable;
    private int pageSize;
    private WXStickyHelper stickyHelper;

    /* compiled from: Taobao */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            wXSDKInstance.setUseScroller(true);
            return new WXScroller(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        private final WXHorizontalScrollView scrollView;

        MyGestureDetector(WXHorizontalScrollView wXHorizontalScrollView) {
            this.scrollView = wXHorizontalScrollView;
        }

        public WXHorizontalScrollView getScrollView() {
            return this.scrollView;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int size = WXScroller.this.mChildren.size();
            try {
                if (motionEvent.getX() - motionEvent2.getX() <= 5.0f || Math.abs(f) <= 300.0f) {
                    if (motionEvent2.getX() - motionEvent.getX() > 5.0f && Math.abs(f) > 300.0f) {
                        int i = WXScroller.this.pageSize;
                        WXScroller wXScroller = WXScroller.this;
                        wXScroller.mActiveFeature = wXScroller.mActiveFeature > 0 ? WXScroller.this.mActiveFeature - 1 : 0;
                        this.scrollView.smoothScrollTo(WXScroller.this.mActiveFeature * i, 0);
                        return true;
                    }
                    return false;
                }
                int i2 = WXScroller.this.pageSize;
                WXScroller wXScroller2 = WXScroller.this;
                int i3 = size - 1;
                if (wXScroller2.mActiveFeature < i3) {
                    i3 = WXScroller.this.mActiveFeature + 1;
                }
                wXScroller2.mActiveFeature = i3;
                this.scrollView.smoothScrollTo(WXScroller.this.mActiveFeature * i2, 0);
                return true;
            } catch (Exception e) {
                WXLogUtils.e("There was an error processing the Fling event:" + e.getMessage());
            }
        }
    }

    @Deprecated
    public WXScroller(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r1 < getLayoutWidth()) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (r1 < getLayoutHeight()) goto L_0x0036;
     */
    private boolean checkItemVisibleInScroller(WXComponent wXComponent) {
        boolean z = false;
        while (wXComponent != null && !(wXComponent instanceof WXScroller)) {
            if (wXComponent.getParent() instanceof WXScroller) {
                if (this.mOrientation == 0) {
                    float left = (float) (((int) wXComponent.getLayoutPosition().getLeft()) - getScrollX());
                    if (left > 0.0f - wXComponent.getLayoutWidth()) {
                    }
                    z = false;
                } else {
                    float top = (float) (((int) wXComponent.getLayoutPosition().getTop()) - getScrollY());
                    if (top > 0.0f - wXComponent.getLayoutHeight()) {
                    }
                    z = false;
                }
                z = true;
            }
            wXComponent = wXComponent.getParent();
        }
        return z;
    }

    private boolean checkRefreshOrLoading(final WXComponent wXComponent) {
        boolean z;
        if (!(wXComponent instanceof WXRefresh) || getHostView() == null) {
            z = false;
        } else {
            ((BaseBounceView) getHostView()).setOnRefreshListener((WXRefresh) wXComponent);
            this.handler.postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass3 */

                public void run() {
                    ((BaseBounceView) WXScroller.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100);
            z = true;
        }
        if (!(wXComponent instanceof WXLoading) || getHostView() == null) {
            return z;
        }
        ((BaseBounceView) getHostView()).setOnLoadingListener((WXLoading) wXComponent);
        this.handler.postDelayed(WXThread.secure(new Runnable() {
            /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass4 */

            public void run() {
                ((BaseBounceView) WXScroller.this.getHostView()).setFooterView(wXComponent);
            }
        }), 100);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchDisappearEvent() {
        int appearStatus;
        for (Map.Entry<String, AppearanceHelper> entry : this.mAppearanceComponents.entrySet()) {
            AppearanceHelper value = entry.getValue();
            if (value.isWatch() && (appearStatus = value.setAppearStatus(false)) != 0) {
                value.getAwareChild().notifyAppearStateChange(appearStatus == 1 ? Constants.Event.APPEAR : Constants.Event.DISAPPEAR, "");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireScrollEvent(Rect rect, int i, int i2, int i3, int i4) {
        fireEvent("scroll", getScrollEvent(i, i2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void procAppear(int i, int i2, int i3, int i4) {
        int appearStatus;
        if (this.mIsHostAttachedToWindow) {
            int i5 = i2 - i4;
            int i6 = i - i3;
            String str = i5 > 0 ? "up" : i5 < 0 ? "down" : null;
            if (this.mOrientation == 0 && i6 != 0) {
                str = i6 > 0 ? "right" : "left";
            }
            for (Map.Entry<String, AppearanceHelper> entry : this.mAppearanceComponents.entrySet()) {
                AppearanceHelper value = entry.getValue();
                if (value.isWatch() && (appearStatus = value.setAppearStatus(checkItemVisibleInScroller(value.getAwareChild()))) != 0) {
                    value.getAwareChild().notifyAppearStateChange(appearStatus == 1 ? Constants.Event.APPEAR : Constants.Event.DISAPPEAR, str);
                }
            }
        }
    }

    private void setWatch(int i, WXComponent wXComponent, boolean z) {
        AppearanceHelper appearanceHelper = this.mAppearanceComponents.get(wXComponent.getRef());
        if (appearanceHelper == null) {
            appearanceHelper = new AppearanceHelper(wXComponent);
            this.mAppearanceComponents.put(wXComponent.getRef(), appearanceHelper);
        }
        appearanceHelper.setWatchEvent(i, z);
        procAppear(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldReport(int i, int i2) {
        Point point = this.mLastReport;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        if (xVar == -1 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) == -1) {
            point.x = i;
            point.y = i2;
            return true;
        } else if (this.mOrientation == 0 && Math.abs(i - xVar) >= this.mOffsetAccuracy) {
            Point point2 = this.mLastReport;
            point2.x = i;
            point2.y = i2;
            return true;
        } else if (this.mOrientation != 1 || Math.abs(i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.mLastReport)) < this.mOffsetAccuracy) {
            return false;
        } else {
            Point point3 = this.mLastReport;
            point3.x = i;
            point3.y = i2;
            return true;
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent, int i) {
        if ((wXComponent instanceof WXBaseRefresh) && checkRefreshOrLoading(wXComponent)) {
            this.mRefreshs.add(wXComponent);
        }
        super.addChild(wXComponent, i);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (ScrollStartEndHelper.isScrollEvent(str) && getInnerView() != null && !this.mHasAddScrollEvent) {
            this.mHasAddScrollEvent = true;
            if (getInnerView() instanceof WXScrollView) {
                ((WXScrollView) getInnerView()).addScrollViewListener(new WXScrollView.WXScrollViewListener() {
                    /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass1 */

                    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                    public void onScroll(WXScrollView wXScrollView, int i, int i2) {
                    }

                    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                    public void onScrollChanged(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
                        WXScroller.this.getScrollStartEndHelper().onScrolled(i, i2);
                        if (WXScroller.this.getEvents().contains("scroll") && WXScroller.this.shouldReport(i, i2)) {
                            WXScroller.this.fireScrollEvent(wXScrollView.getContentFrame(), i, i2, i3, i4);
                        }
                    }

                    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                    public void onScrollStopped(WXScrollView wXScrollView, int i, int i2) {
                    }

                    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                    public void onScrollToBottom(WXScrollView wXScrollView, int i, int i2) {
                    }
                });
            } else if (getInnerView() instanceof WXHorizontalScrollView) {
                ((WXHorizontalScrollView) getInnerView()).addScrollViewListener(new WXHorizontalScrollView.ScrollViewListener() {
                    /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass2 */

                    @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
                    public void onScrollChanged(WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4) {
                        WXScroller.this.getScrollStartEndHelper().onScrolled(i, i2);
                        if (WXScroller.this.getEvents().contains("scroll") && WXScroller.this.shouldReport(i, i2)) {
                            WXScroller.this.fireScrollEvent(wXHorizontalScrollView.getContentFrame(), i, i2, i3, i4);
                        }
                    }
                });
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, int i) {
        FrameLayout frameLayout;
        if (view != null && (frameLayout = this.mRealView) != null && !(view instanceof WXBaseRefreshLayout)) {
            if (i >= frameLayout.getChildCount()) {
                i = -1;
            }
            if (i == -1) {
                this.mRealView.addView(view);
            } else {
                this.mRealView.addView(view, i);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(WXComponent wXComponent) {
        setWatch(0, wXComponent, true);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(WXComponent wXComponent) {
        setWatch(1, wXComponent, true);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(WXComponent wXComponent) {
        this.stickyHelper.bindStickStyle(wXComponent, this.mStickyMap);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
        for (int i = 0; i < this.mRefreshs.size(); i++) {
            WXComponent wXComponent = this.mRefreshs.get(i);
            wXComponent.createViewImpl();
            checkRefreshOrLoading(wXComponent);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        Map<String, AppearanceHelper> map = this.mAppearanceComponents;
        if (map != null) {
            map.clear();
        }
        Map<String, Map<String, WXComponent>> map2 = this.mStickyMap;
        if (map2 != null) {
            map2.clear();
        }
        if (!(this.mOnAttachStateChangeListener == null || getInnerView() == null)) {
            getInnerView().removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        }
        if (getInnerView() != null && (getInnerView() instanceof IWXScroller)) {
            ((IWXScroller) getInnerView()).destroy();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXVContainer
    public int getChildrenLayoutTopOffset() {
        int size;
        if (this.mChildrenLayoutOffset == 0 && (size = this.mRefreshs.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mChildrenLayoutOffset += this.mRefreshs.get(i).getLayoutTopOffsetForSibling();
            }
        }
        return this.mChildrenLayoutOffset;
    }

    public ViewGroup getInnerView() {
        if (getHostView() == null) {
            return null;
        }
        if (getHostView() instanceof BounceScrollerView) {
            return (ViewGroup) ((BounceScrollerView) getHostView()).getInnerView();
        }
        return (ViewGroup) getHostView();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return this.mOrientation;
    }

    public Map<String, Object> getScrollEvent(int i, int i2) {
        Rect rect = new Rect();
        if (getInnerView() instanceof WXScrollView) {
            rect = ((WXScrollView) getInnerView()).getContentFrame();
        } else if (getInnerView() instanceof WXHorizontalScrollView) {
            rect = ((WXHorizontalScrollView) getInnerView()).getContentFrame();
        }
        HashMap hashMap = new HashMap(2);
        HashMap hashMap2 = new HashMap(2);
        HashMap hashMap3 = new HashMap(2);
        int instanceViewPortWidth = getInstance().getInstanceViewPortWidth();
        hashMap2.put("width", Float.valueOf(WXViewUtils.getWebPxByWidth((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), instanceViewPortWidth)));
        hashMap2.put("height", Float.valueOf(WXViewUtils.getWebPxByWidth((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect), instanceViewPortWidth)));
        hashMap3.put(Constants.Name.X, Float.valueOf(-WXViewUtils.getWebPxByWidth((float) i, instanceViewPortWidth)));
        hashMap3.put(Constants.Name.Y, Float.valueOf(-WXViewUtils.getWebPxByWidth((float) i2, instanceViewPortWidth)));
        hashMap.put(Constants.Name.CONTENT_SIZE, hashMap2);
        hashMap.put(Constants.Name.CONTENT_OFFSET, hashMap3);
        return hashMap;
    }

    public ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        if (getInnerView() == null) {
            return 0;
        }
        return getInnerView().getScrollX();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        if (getInnerView() == null) {
            return 0;
        }
        return getInnerView().getScrollY();
    }

    public Map<String, Map<String, WXComponent>> getStickMap() {
        return this.mStickyMap;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXComponent.MeasureOutput measure(int i, int i2) {
        WXComponent.MeasureOutput measureOutput = new WXComponent.MeasureOutput();
        if (this.mOrientation == 0) {
            int screenWidth = WXViewUtils.getScreenWidth(WXEnvironment.sApplication);
            int weexWidth = WXViewUtils.getWeexWidth(getInstanceId());
            if (weexWidth < screenWidth) {
                screenWidth = weexWidth;
            }
            if (i > screenWidth) {
                i = -1;
            }
            measureOutput.width = i;
            measureOutput.height = i2;
        } else {
            int screenHeight = WXViewUtils.getScreenHeight(WXEnvironment.sApplication);
            int weexHeight = WXViewUtils.getWeexHeight(getInstanceId());
            if (weexHeight < screenHeight) {
                screenHeight = weexHeight;
            }
            if (i2 > screenHeight) {
                i2 = -1;
            }
            measureOutput.height = i2;
            measureOutput.width = i;
        }
        return measureOutput;
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void notifyAppearStateChange(String str, String str2) {
        if (containsEvent(Constants.Event.APPEAR) || containsEvent(Constants.Event.DISAPPEAR)) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str2);
            fireEvent(str, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onLoadMore(WXScrollView wXScrollView, int i, int i2) {
        int height;
        int height2;
        try {
            String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (!TextUtils.isEmpty(loadMoreOffset) && (height2 = ((height = wXScrollView.getChildAt(0).getHeight()) - i2) - wXScrollView.getHeight()) < ((int) WXViewUtils.getRealPxByWidth(Float.parseFloat(loadMoreOffset), getInstance().getInstanceViewPortWidth()))) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("[WXScroller-onScroll] offScreenY :" + height2);
                }
                if (this.mContentHeight != height || this.mForceLoadmoreNextTime) {
                    fireEvent(Constants.Event.LOADMORE);
                    this.mContentHeight = height;
                    this.mForceLoadmoreNextTime = false;
                }
            }
        } catch (Exception e) {
            WXLogUtils.d("[WXScroller-onScroll] ", e);
        }
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScroll(WXScrollView wXScrollView, int i, int i2) {
        onLoadMore(wXScrollView, i, i2);
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollChanged(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        procAppear(i, i2, i3, i4);
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollStopped(WXScrollView wXScrollView, int i, int i2) {
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollToBottom(WXScrollView wXScrollView, int i, int i2) {
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        super.remove(wXComponent, z);
        if (wXComponent instanceof WXLoading) {
            ((BaseBounceView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof WXRefresh) {
            ((BaseBounceView) getHostView()).removeHeaderView(wXComponent);
        }
    }

    @JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
    }

    public void scrollBy(int i, int i2) {
        scrollBy(i, i2, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void scrollTo(WXComponent wXComponent, Map<String, Object> map) {
        boolean z;
        int i;
        float f = 0.0f;
        if (map != null) {
            String obj = map.get("offset") == null ? "0" : map.get("offset").toString();
            z = WXUtils.getBoolean(map.get(Constants.Name.ANIMATED), Boolean.TRUE).booleanValue();
            if (obj != null) {
                try {
                    f = WXViewUtils.getRealPxByWidth(Float.parseFloat(obj), getInstance().getInstanceViewPortWidth());
                } catch (Exception e) {
                    WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
        } else {
            z = true;
        }
        if (this.pageEnable) {
            this.mActiveFeature = this.mChildren.indexOf(wXComponent);
        }
        int absoluteY = wXComponent.getAbsoluteY() - getAbsoluteY();
        if (isLayoutRTL()) {
            if (wXComponent.getParent() == null || wXComponent.getParent() != this) {
                i = ((wXComponent.getAbsoluteX() - getAbsoluteX()) - getInnerView().getMeasuredWidth()) + ((int) wXComponent.getLayoutWidth());
            } else if (getInnerView().getChildCount() > 0) {
                i = (getInnerView().getChildAt(0).getWidth() - (wXComponent.getAbsoluteX() - getAbsoluteX())) - getInnerView().getMeasuredWidth();
            } else {
                i = wXComponent.getAbsoluteX() - getAbsoluteX();
            }
            f = -f;
        } else {
            i = wXComponent.getAbsoluteX() - getAbsoluteX();
        }
        int i2 = (int) f;
        scrollBy((i - getScrollX()) + i2, (absoluteY - getScrollY()) + i2, z);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setLayout(WXComponent wXComponent) {
        if (!TextUtils.isEmpty(wXComponent.getComponentType()) && !TextUtils.isEmpty(wXComponent.getRef()) && wXComponent.getLayoutPosition() != null && wXComponent.getLayoutSize() != null) {
            if (wXComponent.getHostView() != null) {
                ViewCompat.setLayoutDirection(wXComponent.getHostView(), wXComponent.isLayoutRTL() ? 1 : 0);
            }
            super.setLayout(wXComponent);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @SuppressLint({"RtlHardcoded"})
    public void setMarginsSupportRTL(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMargins(i, i2, i3, i4);
            marginLayoutParams.setMarginStart(i);
            marginLayoutParams.setMarginEnd(i3);
        } else if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) marginLayoutParams;
            if (isLayoutRTL()) {
                layoutParams.gravity = 53;
                marginLayoutParams.setMargins(i3, i2, i, i4);
                return;
            }
            layoutParams.gravity = 51;
            marginLayoutParams.setMargins(i, i2, i3, i4);
        } else {
            marginLayoutParams.setMargins(i, i2, i3, i4);
        }
    }

    @WXComponentProp(name = Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) WXViewUtils.getRealPxByWidth((float) i, getInstance().getInstanceViewPortWidth());
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -223520855:
                if (str.equals(Constants.Name.SHOW_SCROLLBAR)) {
                    c = 0;
                    break;
                }
                break;
            case -5620052:
                if (str.equals(Constants.Name.OFFSET_ACCURACY)) {
                    c = 1;
                    break;
                }
                break;
            case 66669991:
                if (str.equals(Constants.Name.SCROLLABLE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                }
                return true;
            case 1:
                setOffsetAccuracy(WXUtils.getInteger(obj, 10).intValue());
                return true;
            case 2:
                setScrollable(WXUtils.getBoolean(obj, Boolean.TRUE).booleanValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        this.isScrollable = z;
        ViewGroup innerView = getInnerView();
        if (innerView instanceof WXHorizontalScrollView) {
            ((WXHorizontalScrollView) innerView).setScrollable(z);
        } else if (innerView instanceof WXScrollView) {
            ((WXScrollView) innerView).setScrollable(z);
        }
    }

    @WXComponentProp(name = Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getInnerView() != null) {
            if (this.mOrientation == 1) {
                getInnerView().setVerticalScrollBarEnabled(z);
            } else {
                getInnerView().setHorizontalScrollBarEnabled(z);
            }
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(WXComponent wXComponent) {
        setWatch(0, wXComponent, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(WXComponent wXComponent) {
        setWatch(1, wXComponent, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(WXComponent wXComponent) {
        this.stickyHelper.unbindStickStyle(wXComponent, this.mStickyMap);
    }

    public WXScroller(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mOrientation = 1;
        this.mRefreshs = new ArrayList();
        this.mChildrenLayoutOffset = 0;
        this.mForceLoadmoreNextTime = false;
        this.mOffsetAccuracy = 10;
        this.mLastReport = new Point(-1, -1);
        this.mHasAddScrollEvent = false;
        this.mActiveFeature = 0;
        this.pageSize = 0;
        this.pageEnable = false;
        this.mIsHostAttachedToWindow = false;
        this.mlastDirectionRTL = false;
        this.mAppearanceComponents = new HashMap();
        this.mStickyMap = new HashMap();
        this.mContentHeight = 0;
        this.handler = new Handler(Looper.getMainLooper());
        this.isScrollable = true;
        this.stickyHelper = new WXStickyHelper(this);
        wXSDKInstance.getApmForInstance().B(WXInstanceApm.KEY_PAGE_STATS_SCROLLER_NUM, 1.0d);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public ViewGroup getRealView() {
        return this.mScrollerView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.taobao.weex.ui.view.WXHorizontalScrollView */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    @SuppressLint({"ClickableViewAccessibility"})
    public ViewGroup initComponentHostView(@NonNull Context context) {
        String str;
        BounceScrollerView bounceScrollerView;
        if (getAttrs().isEmpty()) {
            str = LiveBundleLayout.TYPE_VERTICAL;
        } else {
            str = getAttrs().getScrollDirection();
            Object obj = getAttrs().get(Constants.Name.PAGE_ENABLED);
            this.pageEnable = obj != null && Boolean.parseBoolean(obj.toString());
            Object obj2 = getAttrs().get(Constants.Name.PAGE_SIZE);
            if (obj2 != null) {
                float realPxByWidth = WXViewUtils.getRealPxByWidth(WXUtils.getFloat(obj2), getInstance().getInstanceViewPortWidth());
                if (realPxByWidth != 0.0f) {
                    this.pageSize = (int) realPxByWidth;
                }
            }
        }
        if (Constants.Value.HORIZONTAL.equals(str)) {
            this.mOrientation = 0;
            final WXHorizontalScrollView wXHorizontalScrollView = new WXHorizontalScrollView(context);
            this.mRealView = new FrameLayout(context);
            wXHorizontalScrollView.setScrollViewListener(new WXHorizontalScrollView.ScrollViewListener() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass5 */

                @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
                public void onScrollChanged(WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4) {
                    WXScroller.this.procAppear(i, i2, i3, i4);
                }
            });
            wXHorizontalScrollView.addView(this.mRealView, new FrameLayout.LayoutParams(-1, -1));
            wXHorizontalScrollView.setHorizontalScrollBarEnabled(false);
            this.mScrollerView = wXHorizontalScrollView;
            final AnonymousClass6 r6 = new View.OnLayoutChangeListener() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass6 */

                public void onLayoutChange(View view, final int i, int i2, final int i3, int i4, final int i5, int i6, final int i7, int i8) {
                    wXHorizontalScrollView.post(new Runnable() {
                        /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass6.AnonymousClass1 */

                        public void run() {
                            int i;
                            if (WXScroller.this.mIslastDirectionRTL != null && WXScroller.this.isLayoutRTL() != WXScroller.this.mIslastDirectionRTL.booleanValue()) {
                                int scrollX = WXScroller.this.getScrollX();
                                int width = WXScroller.this.getInnerView().getChildAt(0).getWidth();
                                int measuredWidth = WXScroller.this.getInnerView().getMeasuredWidth();
                                AnonymousClass6 r3 = AnonymousClass6.this;
                                wXHorizontalScrollView.scrollTo((width - scrollX) - measuredWidth, this.getScrollY());
                            } else if (WXScroller.this.isLayoutRTL() && (i = (i3 - i) - (i7 - i5)) != 0) {
                                AnonymousClass6 r0 = AnonymousClass6.this;
                                wXHorizontalScrollView.scrollBy(i, this.getScrollY());
                            }
                            WXScroller wXScroller = WXScroller.this;
                            wXScroller.mIslastDirectionRTL = Boolean.valueOf(wXScroller.isLayoutRTL());
                        }
                    });
                }
            };
            this.mRealView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass7 */

                public void onViewAttachedToWindow(View view) {
                    view.addOnLayoutChangeListener(r6);
                }

                public void onViewDetachedFromWindow(View view) {
                    view.removeOnLayoutChangeListener(r6);
                }
            });
            bounceScrollerView = wXHorizontalScrollView;
            if (this.pageEnable) {
                this.mGestureDetector = new GestureDetector(new MyGestureDetector(wXHorizontalScrollView));
                wXHorizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass8 */

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (WXScroller.this.pageSize == 0) {
                            WXScroller.this.pageSize = view.getMeasuredWidth();
                        }
                        if (WXScroller.this.mGestureDetector.onTouchEvent(motionEvent)) {
                            return true;
                        }
                        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                            return false;
                        }
                        int scrollX = WXScroller.this.getScrollX();
                        int i = WXScroller.this.pageSize;
                        WXScroller.this.mActiveFeature = (scrollX + (i / 2)) / i;
                        wXHorizontalScrollView.smoothScrollTo(WXScroller.this.mActiveFeature * i, 0);
                        return true;
                    }
                });
                bounceScrollerView = wXHorizontalScrollView;
            }
        } else {
            this.mOrientation = 1;
            BounceScrollerView bounceScrollerView2 = new BounceScrollerView(context, this.mOrientation, this);
            this.mRealView = new FrameLayout(context);
            WXScrollView wXScrollView = (WXScrollView) bounceScrollerView2.getInnerView();
            wXScrollView.addScrollViewListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.mScrollerView = wXScrollView;
            wXScrollView.addView(this.mRealView, layoutParams);
            wXScrollView.setVerticalScrollBarEnabled(true);
            wXScrollView.setNestedScrollingEnabled(WXUtils.getBoolean(getAttrs().get(Constants.Name.NEST_SCROLLING_ENABLED), Boolean.TRUE).booleanValue());
            wXScrollView.addScrollViewListener(new WXScrollView.WXScrollViewListener() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass9 */

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScroll(WXScrollView wXScrollView, int i, int i2) {
                    List<OnWXScrollListener> wXScrollListeners = WXScroller.this.getInstance().getWXScrollListeners();
                    if (wXScrollListeners != null && wXScrollListeners.size() > 0) {
                        for (OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                            if (onWXScrollListener != null) {
                                if (!(onWXScrollListener instanceof ICheckBindingScroller)) {
                                    onWXScrollListener.onScrolled(wXScrollView, i, i2);
                                } else if (((ICheckBindingScroller) onWXScrollListener).isNeedScroller(WXScroller.this.getRef(), null)) {
                                    onWXScrollListener.onScrolled(wXScrollView, i, i2);
                                }
                            }
                        }
                    }
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollChanged(WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollStopped(WXScrollView wXScrollView, int i, int i2) {
                    List<OnWXScrollListener> wXScrollListeners = WXScroller.this.getInstance().getWXScrollListeners();
                    if (wXScrollListeners != null && wXScrollListeners.size() > 0) {
                        for (OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                            if (onWXScrollListener != null) {
                                onWXScrollListener.onScrollStateChanged(wXScrollView, i, i2, 0);
                            }
                        }
                    }
                    WXScroller.this.getScrollStartEndHelper().onScrollStateChanged(0);
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollToBottom(WXScrollView wXScrollView, int i, int i2) {
                }
            });
            bounceScrollerView = bounceScrollerView2;
        }
        bounceScrollerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass10 */

            @TargetApi(16)
            public void onGlobalLayout() {
                WXScroller.this.procAppear(0, 0, 0, 0);
                View hostView = WXScroller.this.getHostView();
                if (hostView != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        hostView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        hostView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
        AnonymousClass11 r62 = new View.OnAttachStateChangeListener() {
            /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass11 */

            public void onViewAttachedToWindow(View view) {
                WXScroller.this.mIsHostAttachedToWindow = true;
                WXScroller wXScroller = WXScroller.this;
                wXScroller.procAppear(wXScroller.getScrollX(), WXScroller.this.getScrollY(), WXScroller.this.getScrollX(), WXScroller.this.getScrollY());
            }

            public void onViewDetachedFromWindow(View view) {
                WXScroller.this.mIsHostAttachedToWindow = false;
                WXScroller.this.dispatchDisappearEvent();
            }
        };
        this.mOnAttachStateChangeListener = r62;
        bounceScrollerView.addOnAttachStateChangeListener(r62);
        return bounceScrollerView;
    }

    public void scrollBy(final int i, final int i2, final boolean z) {
        if (getInnerView() != null) {
            getInnerView().postDelayed(new Runnable() {
                /* class com.taobao.weex.ui.component.WXScroller.AnonymousClass12 */

                public void run() {
                    WXScroller wXScroller = WXScroller.this;
                    if (wXScroller.mOrientation == 1) {
                        if (z) {
                            ((WXScrollView) wXScroller.getInnerView()).smoothScrollBy(0, i2);
                        } else {
                            ((WXScrollView) wXScroller.getInnerView()).scrollBy(0, i2);
                        }
                    } else if (z) {
                        ((WXHorizontalScrollView) wXScroller.getInnerView()).smoothScrollBy(i, 0);
                    } else {
                        ((WXHorizontalScrollView) wXScroller.getInnerView()).scrollBy(i, 0);
                    }
                    WXScroller.this.getInnerView().invalidate();
                }
            }, 16);
        }
    }
}
