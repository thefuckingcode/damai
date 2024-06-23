package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.WXMaskView;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;
import tb.v;

/* compiled from: Taobao */
public class WXMask extends WXVContainer {
    private static final int BOTTOM = 3;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int TOP = 2;
    private FrameLayout mFrameLayout;
    private int mHeight;
    private boolean mMaskViewIsAttached = false;
    private WindowManager mWindowManager;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnAttachStateChangeListener {
        a() {
        }

        public void onViewAttachedToWindow(View view) {
            WXMask.this.fireVisibleChangedEvent(true);
            WXMask.this.mMaskViewIsAttached = true;
        }

        public void onViewDetachedFromWindow(View view) {
            WXMask.this.fireVisibleChangedEvent(false);
            WXMask.this.mMaskViewIsAttached = false;
        }
    }

    public WXMask(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private int add(float f, float f2) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        if (Float.isNaN(f2)) {
            f2 = 0.0f;
        }
        return (int) (f + f2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fireVisibleChangedEvent(boolean z) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("visible", Boolean.valueOf(z));
        fireEvent("visiblechanged", hashMap);
    }

    private int get(int i) {
        try {
            CSSShorthand margin = getMargin();
            WXStyle styles = getStyles();
            if (i == 0) {
                return add(styles.getLeft(), margin.get(CSSShorthand.EDGE.LEFT));
            }
            if (i == 1) {
                return add(styles.getRight(), margin.get(CSSShorthand.EDGE.RIGHT));
            }
            if (i == 2) {
                return add(styles.getTop(), margin.get(CSSShorthand.EDGE.TOP));
            }
            if (i != 3) {
                return 0;
            }
            return add(styles.getBottom(), margin.get(CSSShorthand.EDGE.BOTTOM));
        } catch (Throwable unused) {
            return 0;
        }
    }

    private void initWindow(final WXMaskView wXMaskView) {
        this.mWindowManager = (WindowManager) wXMaskView.getContext().getSystemService(v.ATTACH_MODE_WINDOW);
        AnonymousClass1 r0 = new FrameLayout(wXMaskView.getContext()) {
            /* class com.alibaba.aliweex.adapter.component.WXMask.AnonymousClass1 */

            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (WXMask.this.mWindowManager == null || WXMask.this.mFrameLayout == null || !WXMask.this.mMaskViewIsAttached) {
                    return true;
                }
                WXMask.this.mWindowManager.removeViewImmediate(WXMask.this.mFrameLayout);
                return true;
            }
        };
        this.mFrameLayout = r0;
        this.mHeight = 0;
        r0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.alibaba.aliweex.adapter.component.WXMask.AnonymousClass2 */

            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT > 21 && WXMask.this.mFrameLayout != null && WXMask.this.mWindowManager != null && wXMaskView != null) {
                    Rect rect = new Rect();
                    WXMask.this.mFrameLayout.getWindowVisibleDisplayFrame(rect);
                    if (!WXMask.this.isFullScreen()) {
                        WXLogUtils.w("Mask", "Mask is not fullscreen");
                        return;
                    }
                    int i = rect.bottom;
                    if (i != WXMask.this.mHeight) {
                        WXMask.this.mHeight = i;
                        WXBridgeManager.getInstance().post(new Runnable() {
                            /* class com.alibaba.aliweex.adapter.component.WXMask.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                WXBridgeManager.getInstance().setStyleHeight(WXMask.this.getInstanceId(), WXMask.this.getRef(), (float) WXMask.this.mHeight);
                            }
                        });
                    }
                }
            }
        });
        this.mFrameLayout.addOnAttachStateChangeListener(new a());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.type = 1000;
        layoutParams.gravity = 0;
        layoutParams.format = 1;
        layoutParams.softInputMode = 48;
        this.mWindowManager.addView(this.mFrameLayout, layoutParams);
        this.mFrameLayout.postDelayed(new Runnable() {
            /* class com.alibaba.aliweex.adapter.component.WXMask.AnonymousClass4 */

            public void run() {
                WXMask.this.mFrameLayout.addView(wXMaskView, new FrameLayout.LayoutParams(-1, -1));
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isFullScreen() {
        try {
            if (getAttrs() == null || getAttrs().get("fullscreen") == null) {
                return true;
            }
            return WXUtils.getBoolean(getAttrs().get("fullscreen"), Boolean.TRUE).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        WXMaskView wXMaskView = new WXMaskView(context);
        initWindow(wXMaskView);
        fireVisibleChangedEvent(true);
        return wXMaskView;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isVirtualComponent() {
        return true;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void removeVirtualComponent() {
        FrameLayout frameLayout;
        fireVisibleChangedEvent(false);
        WindowManager windowManager = this.mWindowManager;
        if (windowManager != null && (frameLayout = this.mFrameLayout) != null && this.mMaskViewIsAttached) {
            windowManager.removeViewImmediate(frameLayout);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = get(0);
        int i8 = get(1);
        int i9 = get(2);
        int i10 = get(3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.setMargins(i7, i9, i8, i10);
        getHostView().setLayoutParams(layoutParams);
    }
}
