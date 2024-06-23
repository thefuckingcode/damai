package com.youku.live.livesdk.wkit.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.live.livesdk.wkit.utils.ColorUtil;
import com.youku.live.livesdk.wkit.utils.DpUtil;
import com.youku.live.livesdk.wkit.widget.view.WebWidgetView;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.ISystemEvent;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import java.util.HashMap;
import tb.v;

/* compiled from: Taobao */
public class ModalWidget extends BaseWidget implements View.OnClickListener, ISystemEvent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ANIMATION_DURATION = 300;
    public static final String MODAL_CLOSE = "modalClose";
    public static final String TYPE_H5 = "h5";
    public static final String TYPE_NATIVE = "native";
    public static final String TYPE_WEEX = "weex";
    public static final String UNIT_PERCENT = "%";
    public static final String WIDGET_NAME = "Modal";
    private ContainerView mContainerView;
    private View mContentView;
    private View mMaskView;
    private View mRenderView;
    private boolean mSupportAnimation;
    private boolean mSupportMaskClickClose;
    private WebWidgetView mWebView;
    private WeexWidgetView mWeexView;

    private void directCloseSelfDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181695956")) {
            ipChange.ipc$dispatch("-181695956", new Object[]{this});
            return;
        }
        getEngineInstance().runOnMainThread(new Runnable() {
            /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-162330863")) {
                    ipChange.ipc$dispatch("-162330863", new Object[]{this});
                    return;
                }
                ModalWidget.this.getEngineInstance().closeDialog(ModalWidget.this.id);
            }
        });
    }

    public static GradientDrawable getRoundRectDrawable(int i, boolean z, int i2, boolean z2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503709494")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-503709494", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3)});
        }
        float[] fArr = new float[8];
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = (float) i;
        }
        if (z) {
            for (int i5 = 4; i5 < 8; i5++) {
                fArr[i5] = 0.0f;
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(z2 ? i2 : 0);
        if (z2) {
            i3 = 0;
        }
        gradientDrawable.setStroke(i3, i2);
        return gradientDrawable;
    }

    private void hookWeexRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560119124")) {
            ipChange.ipc$dispatch("-560119124", new Object[]{this});
            return;
        }
        View view = this.mContentView;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            int childCount = frameLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = frameLayout.getChildAt(i);
                if (childAt instanceof IDestroyable) {
                    ((IDestroyable) childAt).destroy();
                }
            }
        }
    }

    private boolean initAnimationValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845372130")) {
            return ((Boolean) ipChange.ipc$dispatch("1845372130", new Object[]{this})).booleanValue();
        }
        String string = getProps().getString(v.TAK_ABILITY_SHOW_POP_ANIMATION, null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            return Boolean.valueOf(string).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    private void initBackgroundAndCorners(View view) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557691364")) {
            ipChange.ipc$dispatch("-1557691364", new Object[]{this, view});
        } else if (view != null) {
            String string = getProps().getString("modalBackgroundColor", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    i = Color.parseColor(string);
                } catch (Exception unused) {
                }
                int dip2px = DpUtil.dip2px(15.0f);
                if (WidgetSDKEngine.getOrientation() != Orientation.ORIENTATION_PORTAIT) {
                    if ("true".equals(getProps().getString("disableBorderRadius", "false"))) {
                        dip2px = 0;
                    }
                    view.setBackground(getRoundRectDrawable(dip2px, true, i, true, 0));
                    return;
                }
                if ("true".equals(getProps().getString("disableLandBorderRadius", "false"))) {
                    dip2px = 0;
                }
                view.setBackground(getRoundRectDrawable(dip2px, false, i, true, 0));
                return;
            }
            i = 0;
            int dip2px2 = DpUtil.dip2px(15.0f);
            if (WidgetSDKEngine.getOrientation() != Orientation.ORIENTATION_PORTAIT) {
            }
        }
    }

    private ContainerView initContainerView(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        int i5 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-330743826")) {
            return (ContainerView) ipChange.ipc$dispatch("-330743826", new Object[]{this, context});
        }
        ContainerView containerView = new ContainerView(context);
        containerView.setStandardWidth(getEngineInstance().getStandardWidth());
        String string = getProps().getString("width", null);
        String string2 = getProps().getString("height", null);
        String string3 = getProps().getString("landWidth", null);
        String string4 = getProps().getString("landHeight", null);
        if (!TextUtils.isEmpty(string)) {
            boolean endsWith = string.endsWith("%");
            if (endsWith) {
                try {
                    i4 = Integer.valueOf(string.substring(0, string.length() - 1)).intValue();
                } catch (Throwable unused) {
                    i4 = 0;
                }
            } else {
                i4 = (int) (Double.valueOf(string).doubleValue() + 0.5d);
            }
            containerView.setPortraitChildWidth(i4, endsWith);
        }
        if (!TextUtils.isEmpty(string2)) {
            boolean endsWith2 = string2.endsWith("%");
            if (endsWith2) {
                try {
                    i3 = Integer.valueOf(string2.substring(0, string2.length() - 1)).intValue();
                } catch (Throwable unused2) {
                    i3 = 0;
                }
            } else {
                i3 = (int) (Double.valueOf(string2).doubleValue() + 0.5d);
            }
            containerView.setPortraitChildHeight(i3, endsWith2);
        }
        if (!TextUtils.isEmpty(string3)) {
            boolean endsWith3 = string3.endsWith("%");
            if (endsWith3) {
                try {
                    i2 = Integer.valueOf(string3.substring(0, string3.length() - 1)).intValue();
                } catch (Throwable unused3) {
                    i2 = 0;
                }
            } else {
                i2 = (int) (Double.valueOf(string3).doubleValue() + 0.5d);
            }
            containerView.setLandscapeChildWidth(i2, endsWith3);
        }
        if (!TextUtils.isEmpty(string4)) {
            boolean endsWith4 = string4.endsWith("%");
            if (endsWith4) {
                try {
                    i = Integer.valueOf(string4.substring(0, string4.length() - 1)).intValue();
                } catch (Throwable unused4) {
                }
            } else {
                i = (int) (Double.valueOf(string4).doubleValue() + 0.5d);
            }
            i5 = i;
            containerView.setLandscapeChildHeight(i5, endsWith4);
        }
        return containerView;
    }

    private View initContentView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991107959")) {
            return (View) ipChange.ipc$dispatch("-991107959", new Object[]{this, context});
        }
        FrameLayout frameLayout = new FrameLayout(context);
        String string = getProps().getString("url", null);
        String string2 = getProps().getString("type", null);
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            if ("weex".compareToIgnoreCase(string2) == 0) {
                WeexWidgetView weexWidgetView = new WeexWidgetView(context);
                weexWidgetView.bindEngineInstance(getEngineInstance());
                weexWidgetView.render(string, new HashMap(), "");
                frameLayout.addView(weexWidgetView, new FrameLayout.LayoutParams(-1, -1));
                this.mRenderView = weexWidgetView;
            } else if ("h5".compareToIgnoreCase(string2) == 0) {
                WebWidgetView webWidgetView = new WebWidgetView(context);
                webWidgetView.bindEngineInstance(getEngineInstance());
                webWidgetView.render(string);
                frameLayout.addView(webWidgetView, new FrameLayout.LayoutParams(-1, -1));
                this.mRenderView = webWidgetView;
            }
        }
        initBackgroundAndCorners(frameLayout);
        return frameLayout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a A[SYNTHETIC, Splitter:B:12:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    private View initMaskView(Context context) {
        boolean z;
        String string;
        boolean z2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-945009072")) {
            return (View) ipChange.ipc$dispatch("-945009072", new Object[]{this, context});
        }
        View view = new View(context);
        String string2 = getProps().getString("mask", null);
        if (!TextUtils.isEmpty(string2)) {
            try {
                z = Boolean.valueOf(string2).booleanValue();
            } catch (Throwable unused) {
            }
            string = getProps().getString("maskClickClose", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    z2 = Boolean.valueOf(string).booleanValue();
                } catch (Throwable unused2) {
                }
                if (z) {
                    view = new View(context);
                    String string3 = getProps().getString("backgroundColor", null);
                    if (!TextUtils.isEmpty(string3)) {
                        try {
                            i = ColorUtil.parseColor(string3);
                        } catch (Throwable unused3) {
                        }
                    }
                    view.setBackgroundColor(i);
                    if (z2) {
                        view.setOnClickListener(this);
                    }
                }
                return view;
            }
            z2 = false;
            if (z) {
            }
            return view;
        }
        z = false;
        string = getProps().getString("maskClickClose", null);
        if (!TextUtils.isEmpty(string)) {
        }
        z2 = false;
        if (z) {
        }
        return view;
    }

    private Animation makeAnimationWithFadeIn(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866096790")) {
            return (Animation) ipChange.ipc$dispatch("1866096790", new Object[]{this, view});
        } else if (view == null) {
            return null;
        } else {
            view.setVisibility(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-181683370")) {
                        ipChange.ipc$dispatch("-181683370", new Object[]{this, animation});
                        return;
                    }
                    View view = view;
                    if (view != null) {
                        view.clearAnimation();
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1383089058")) {
                        ipChange.ipc$dispatch("-1383089058", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-8859345")) {
                        ipChange.ipc$dispatch("-8859345", new Object[]{this, animation});
                        return;
                    }
                    View view = view;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            });
            view.setAnimation(alphaAnimation);
            return alphaAnimation;
        }
    }

    private Animation makeAnimationWithFadeOut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514747151")) {
            return (Animation) ipChange.ipc$dispatch("-1514747151", new Object[]{this});
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        return alphaAnimation;
    }

    private Animation makeAnimationWithTranslateIn(final View view) {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380996296")) {
            return (Animation) ipChange.ipc$dispatch("380996296", new Object[]{this, view});
        } else if (view == null) {
            return null;
        } else {
            view.setVisibility(4);
            if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            }
            translateAnimation.setDuration(300);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass6 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "511709335")) {
                        ipChange.ipc$dispatch("511709335", new Object[]{this, animation});
                        return;
                    }
                    View view = view;
                    if (view != null) {
                        view.clearAnimation();
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "981259133")) {
                        ipChange.ipc$dispatch("981259133", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "621599280")) {
                        ipChange.ipc$dispatch("621599280", new Object[]{this, animation});
                        return;
                    }
                    View view = view;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            });
            view.setAnimation(translateAnimation);
            return translateAnimation;
        }
    }

    private Animation makeAnimationWithTranslateOut() {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293764515")) {
            return (Animation) ipChange.ipc$dispatch("293764515", new Object[]{this});
        }
        if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        }
        translateAnimation.setDuration(300);
        return translateAnimation;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean removeFromParent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465067367")) {
            return ((Boolean) ipChange.ipc$dispatch("465067367", new Object[]{this})).booleanValue();
        }
        IWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        hookWeexRelease();
        return parent.deleteChild(this);
    }

    @Override // com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.impl.BaseWidget
    public boolean closeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45205711")) {
            return ((Boolean) ipChange.ipc$dispatch("45205711", new Object[]{this})).booleanValue();
        }
        if (this.mSupportAnimation) {
            final Animation makeAnimationWithTranslateOut = makeAnimationWithTranslateOut();
            makeAnimationWithTranslateOut.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2033105811")) {
                        ipChange.ipc$dispatch("2033105811", new Object[]{this, animation});
                        return;
                    }
                    View view = ModalWidget.this.mContentView;
                    if (view != null) {
                        view.setVisibility(4);
                        view.clearAnimation();
                    }
                    ModalWidget.this.removeFromParent();
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "113800961")) {
                        ipChange.ipc$dispatch("113800961", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1900235220")) {
                        ipChange.ipc$dispatch("-1900235220", new Object[]{this, animation});
                    }
                }
            });
            final Animation makeAnimationWithFadeOut = makeAnimationWithFadeOut();
            makeAnimationWithFadeOut.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1568468780")) {
                        ipChange.ipc$dispatch("-1568468780", new Object[]{this, animation});
                        return;
                    }
                    View view = ModalWidget.this.mMaskView;
                    if (view != null) {
                        view.setVisibility(4);
                        view.clearAnimation();
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1816818144")) {
                        ipChange.ipc$dispatch("-1816818144", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1269776595")) {
                        ipChange.ipc$dispatch("-1269776595", new Object[]{this, animation});
                    }
                }
            });
            ContainerView containerView = this.mContainerView;
            if (containerView != null) {
                containerView.post(new Runnable() {
                    /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass4 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "427209652")) {
                            ipChange.ipc$dispatch("427209652", new Object[]{this});
                            return;
                        }
                        View view = ModalWidget.this.mContentView;
                        if (view != null) {
                            view.startAnimation(makeAnimationWithTranslateOut);
                        }
                        View view2 = ModalWidget.this.mMaskView;
                        if (view2 != null) {
                            view2.startAnimation(makeAnimationWithFadeOut);
                        }
                    }
                });
            }
        } else {
            removeFromParent();
        }
        getEngineInstance().asyncPutData(MODAL_CLOSE, this.id);
        return true;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1581028876")) {
            return (View) ipChange.ipc$dispatch("1581028876", new Object[]{this, context});
        }
        this.mContainerView = initContainerView(context);
        this.mMaskView = initMaskView(context);
        this.mContentView = initContentView(context);
        this.mSupportAnimation = initAnimationValue();
        ContainerView containerView = this.mContainerView;
        View view = this.mContentView;
        View view2 = this.mMaskView;
        if (view2 != null) {
            containerView.addMaskView(view2);
        }
        if (view != null) {
            containerView.addContentView(view);
        }
        if (this.mSupportAnimation && containerView != null) {
            final Animation animation = null;
            final Animation makeAnimationWithFadeIn = view2 != null ? makeAnimationWithFadeIn(view2) : null;
            if (view != null) {
                animation = makeAnimationWithTranslateIn(view);
            }
            containerView.post(new Runnable() {
                /* class com.youku.live.livesdk.wkit.widget.ModalWidget.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1016750167")) {
                        ipChange.ipc$dispatch("1016750167", new Object[]{this});
                        return;
                    }
                    Animation animation = animation;
                    if (animation != null) {
                        animation.startNow();
                    }
                    Animation animation2 = makeAnimationWithFadeIn;
                    if (animation2 != null) {
                        animation2.startNow();
                    }
                }
            });
        }
        return containerView;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-125667258")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-125667258", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54469471")) {
            ipChange.ipc$dispatch("-54469471", new Object[]{this, configuration});
        }
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887952163")) {
            ipChange.ipc$dispatch("1887952163", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98275384")) {
            ipChange.ipc$dispatch("-98275384", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452171353")) {
            ipChange.ipc$dispatch("-1452171353", new Object[]{this});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResumeStateChangedListener) {
            ((IActivityResumeStateChangedListener) view).onActivityPause();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589044581")) {
            ipChange.ipc$dispatch("589044581", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796541805")) {
            ipChange.ipc$dispatch("1796541805", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResultListener) {
            ((IActivityResultListener) view).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419852480")) {
            ipChange.ipc$dispatch("-419852480", new Object[]{this});
            return;
        }
        View view = this.mRenderView;
        if (view instanceof IActivityResumeStateChangedListener) {
            ((IActivityResumeStateChangedListener) view).onActivityResume();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409066565")) {
            ipChange.ipc$dispatch("-1409066565", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045552971")) {
            ipChange.ipc$dispatch("2045552971", new Object[]{this});
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176933524")) {
            ipChange.ipc$dispatch("-1176933524", new Object[]{this, view});
            return;
        }
        directCloseSelfDialog();
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public boolean systemEventFilter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "56105680")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("56105680", new Object[]{this})).booleanValue();
    }

    /* compiled from: Taobao */
    public static class ContainerView extends FrameLayout {
        private static transient /* synthetic */ IpChange $ipChange;
        private View mContentView;
        private int mLandscapeHeight = 0;
        private boolean mLandscapeHeightPercent = false;
        private int mLandscapeWidth = 0;
        private boolean mLandscapeWidthPercent = false;
        private View mMaskView;
        private int mPortraitHeight = 0;
        private boolean mPortraitHeightPercent = false;
        private int mPortraitWidth = 0;
        private boolean mPortraitWidthPercent = false;
        private int mStandardWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;

        public ContainerView(@NonNull Context context) {
            super(context);
        }

        public void addContentView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1874835026")) {
                ipChange.ipc$dispatch("1874835026", new Object[]{this, view});
                return;
            }
            this.mContentView = view;
            if (view != null) {
                addView(view, new ViewGroup.LayoutParams(-2, -2));
            }
        }

        public void addMaskView(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1369362615")) {
                ipChange.ipc$dispatch("1369362615", new Object[]{this, view});
                return;
            }
            this.mMaskView = view;
            if (view != null) {
                addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (r0 != 3) goto L_0x003b;
         */
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1041282113")) {
                return ((Boolean) ipChange.ipc$dispatch("1041282113", new Object[]{this, motionEvent})).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                return super.dispatchTouchEvent(motionEvent);
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "589086624")) {
                ipChange.ipc$dispatch("589086624", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            }
            int childCount = getChildCount();
            int i10 = i3 - i;
            int i11 = i4 - i2;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.equals(this.mContentView)) {
                    if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                        if (this.mPortraitWidthPercent) {
                            i9 = (this.mPortraitWidth * i10) / 100;
                        } else {
                            i9 = (this.mPortraitWidth * i10) / this.mStandardWidth;
                        }
                        if (this.mPortraitHeightPercent) {
                            i8 = (this.mPortraitHeight * i11) / 100;
                        } else {
                            i8 = (this.mPortraitHeight * i10) / this.mStandardWidth;
                        }
                        i7 = (i10 - i9) / 2;
                        i6 = i7 + i9;
                        i5 = i11 - i8;
                    } else {
                        if (this.mLandscapeWidthPercent) {
                            i9 = (this.mLandscapeWidth * i10) / 100;
                        } else {
                            i9 = (this.mLandscapeWidth * i11) / this.mStandardWidth;
                        }
                        if (this.mLandscapeHeightPercent) {
                            i8 = (this.mLandscapeHeight * i11) / 100;
                        } else {
                            i8 = (this.mLandscapeHeight * i11) / this.mStandardWidth;
                        }
                        i7 = i10 - i9;
                        i6 = i7 + i9;
                        i5 = (i11 - i8) / 2;
                    }
                    int i13 = i8 + i5;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = i9;
                        layoutParams.height = i8;
                        childAt.setLayoutParams(layoutParams);
                    }
                    childAt.layout(i7, i5, i6, i13);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = -1;
                        layoutParams2.height = -1;
                        childAt.setLayoutParams(layoutParams2);
                    }
                    childAt.layout(0, 0, i10, i11);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            int i3;
            int i4;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-694464274")) {
                ipChange.ipc$dispatch("-694464274", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int childCount = getChildCount();
            setMeasuredDimension(size, size2);
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.equals(this.mContentView)) {
                    if (WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_PORTAIT) {
                        if (this.mPortraitWidthPercent) {
                            i4 = (this.mPortraitWidth * size) / 100;
                        } else {
                            i4 = (this.mPortraitWidth * size) / this.mStandardWidth;
                        }
                        if (this.mPortraitHeightPercent) {
                            i3 = (this.mPortraitHeight * size2) / 100;
                        } else {
                            i3 = (this.mPortraitHeight * size) / this.mStandardWidth;
                        }
                        int i6 = (size - i4) / 2;
                    } else {
                        if (this.mLandscapeWidthPercent) {
                            i4 = (this.mLandscapeWidth * size) / 100;
                        } else {
                            i4 = (this.mLandscapeWidth * size2) / this.mStandardWidth;
                        }
                        if (this.mLandscapeHeightPercent) {
                            i3 = (this.mLandscapeHeight * size2) / 100;
                        } else {
                            i3 = (this.mLandscapeHeight * size2) / this.mStandardWidth;
                        }
                        int i7 = (size2 - i3) / 2;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
                } else {
                    childAt.measure(i, i2);
                }
            }
        }

        public void setLandscapeChildHeight(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-230941452")) {
                ipChange.ipc$dispatch("-230941452", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mLandscapeHeight = i;
            this.mLandscapeHeightPercent = z;
        }

        public void setLandscapeChildWidth(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2027317653")) {
                ipChange.ipc$dispatch("-2027317653", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mLandscapeWidth = i;
            this.mLandscapeWidthPercent = z;
        }

        public void setPortraitChildHeight(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1454340952")) {
                ipChange.ipc$dispatch("-1454340952", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mPortraitHeight = i;
            this.mPortraitHeightPercent = z;
        }

        public void setPortraitChildWidth(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2066782153")) {
                ipChange.ipc$dispatch("-2066782153", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            this.mPortraitWidth = i;
            this.mPortraitWidthPercent = z;
        }

        public void setStandardWidth(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1470444051")) {
                ipChange.ipc$dispatch("-1470444051", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.mStandardWidth = i;
        }

        public ContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
