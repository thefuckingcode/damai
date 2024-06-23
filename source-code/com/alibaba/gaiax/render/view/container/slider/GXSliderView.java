package com.alibaba.gaiax.render.view.container.slider;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXIViewVisibleChange;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iq0;
import tb.k21;
import tb.m40;
import tb.oq0;
import tb.pq0;
import tb.ur2;
import tb.wq0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002EFB\u0011\b\u0016\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@B\u001b\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\b?\u0010CJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006G"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderView;", "Landroid/widget/FrameLayout;", "Lcom/alibaba/gaiax/render/view/GXIContainer;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/gaiax/render/view/GXIRelease;", "Lcom/alibaba/gaiax/render/view/GXIViewVisibleChange;", "Ltb/ur2;", "initView", "initViewPager", "initIndicator", "Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", "createIndicatorView", "startTimer", "stopTimer", "Ltb/oq0;", Constants.CONFIG, "setConfig", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "", "size", "setPageSize", "Ltb/wq0;", "gxContext", "setTemplateContext", "getTemplateContext", "getConfig", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "release", "", "visible", "onVisibleChanged", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "indicatorView", "Lcom/alibaba/gaiax/render/view/container/slider/GXSliderBaseIndicatorView;", Constants.Name.PAGE_SIZE, "I", "Ljava/util/Timer;", "timer", "Ljava/util/Timer;", "Ljava/util/TimerTask;", "timerTask", "Ljava/util/TimerTask;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "IndicatorPosition", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXSliderView extends FrameLayout implements GXIContainer, GXIRelease, GXIRootView, GXIRoundCorner, GXIViewBindData, GXIViewVisibleChange {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String TAG = "[GaiaX] [GXSliderView]";
    @Nullable
    private oq0 config;
    @Nullable
    private wq0 gxTemplateContext;
    @Nullable
    private GXSliderBaseIndicatorView indicatorView;
    @NotNull
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private int pageSize;
    @Nullable
    private Timer timer;
    @Nullable
    private TimerTask timerTask;
    @Nullable
    private ViewPager viewPager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/slider/GXSliderView$IndicatorPosition;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "TOP_LEFT", "TOP_CENTER", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_CENTER", "BOTTOM_RIGHT", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum IndicatorPosition {
        TOP_LEFT("top-left"),
        TOP_CENTER("top-center"),
        TOP_RIGHT("top-right"),
        BOTTOM_LEFT("bottom-left"),
        BOTTOM_CENTER("bottom-center"),
        BOTTOM_RIGHT("bottom-right");
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        private final String value;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @NotNull
            public final IndicatorPosition a(@Nullable String str) {
                IndicatorPosition indicatorPosition = IndicatorPosition.TOP_LEFT;
                if (k21.d(str, indicatorPosition.getValue())) {
                    return indicatorPosition;
                }
                IndicatorPosition indicatorPosition2 = IndicatorPosition.TOP_CENTER;
                if (k21.d(str, indicatorPosition2.getValue())) {
                    return indicatorPosition2;
                }
                IndicatorPosition indicatorPosition3 = IndicatorPosition.TOP_RIGHT;
                if (k21.d(str, indicatorPosition3.getValue())) {
                    return indicatorPosition3;
                }
                IndicatorPosition indicatorPosition4 = IndicatorPosition.BOTTOM_LEFT;
                if (k21.d(str, indicatorPosition4.getValue())) {
                    return indicatorPosition4;
                }
                IndicatorPosition indicatorPosition5 = IndicatorPosition.BOTTOM_CENTER;
                return k21.d(str, indicatorPosition5.getValue()) ? indicatorPosition5 : IndicatorPosition.BOTTOM_RIGHT;
            }
        }

        private IndicatorPosition(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndicatorPosition.values().length];
            iArr[IndicatorPosition.TOP_LEFT.ordinal()] = 1;
            iArr[IndicatorPosition.TOP_CENTER.ordinal()] = 2;
            iArr[IndicatorPosition.TOP_RIGHT.ordinal()] = 3;
            iArr[IndicatorPosition.BOTTOM_LEFT.ordinal()] = 4;
            iArr[IndicatorPosition.BOTTOM_CENTER.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends ViewOutlineProvider {
        final /* synthetic */ GXSliderView a;
        final /* synthetic */ float b;

        c(GXSliderView gXSliderView, float f) {
            this.a = gXSliderView;
            this.b = f;
        }

        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            k21.i(view, "view");
            k21.i(outline, com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE);
            if (this.a.getAlpha() >= 0.0f) {
                outline.setAlpha(this.a.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXSliderView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }

    private final GXSliderBaseIndicatorView createIndicatorView() {
        String b2;
        oq0 oq0 = this.config;
        if (!(oq0 == null || (b2 = oq0.b()) == null)) {
            try {
                Object newInstance = Class.forName(b2).getConstructor(Context.class).newInstance(getContext());
                GXSliderBaseIndicatorView gXSliderBaseIndicatorView = newInstance instanceof GXSliderBaseIndicatorView ? (GXSliderBaseIndicatorView) newInstance : null;
                if (gXSliderBaseIndicatorView != null) {
                    return gXSliderBaseIndicatorView;
                }
            } catch (Exception e) {
                e.printStackTrace();
                ur2 ur2 = ur2.INSTANCE;
            }
        }
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        return new GXSliderDefaultIndicatorView(context);
    }

    private final void initIndicator() {
        Rect c2;
        View view = this.indicatorView;
        if (view != null) {
            removeView(view);
        }
        this.indicatorView = createIndicatorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        oq0 oq0 = this.config;
        if (!(oq0 == null || (c2 = oq0.c()) == null)) {
            layoutParams.leftMargin = c2.left;
            layoutParams.topMargin = c2.top;
            layoutParams.rightMargin = c2.right;
            layoutParams.bottomMargin = c2.bottom;
        }
        oq0 oq02 = this.config;
        IndicatorPosition d = oq02 == null ? null : oq02.d();
        int i = d == null ? -1 : b.$EnumSwitchMapping$0[d.ordinal()];
        if (i == 1) {
            layoutParams.gravity = 51;
        } else if (i == 2) {
            layoutParams.gravity = 49;
        } else if (i == 3) {
            layoutParams.gravity = 53;
        } else if (i == 4) {
            layoutParams.gravity = 83;
        } else if (i != 5) {
            layoutParams.gravity = 85;
        } else {
            layoutParams.gravity = 81;
        }
        addView(this.indicatorView, layoutParams);
    }

    private final void initView() {
        initViewPager();
    }

    private final void initViewPager() {
        ViewPager viewPager2 = new ViewPager(getContext());
        this.viewPager = viewPager2;
        viewPager2.addOnPageChangeListener(new GXSliderView$initViewPager$1(this));
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.setOnTouchListener(new pq0(this));
        }
        addView(this.viewPager, new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewPager$lambda-0  reason: not valid java name */
    public static final boolean m96initViewPager$lambda0(GXSliderView gXSliderView, View view, MotionEvent motionEvent) {
        k21.i(gXSliderView, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            gXSliderView.stopTimer();
            return false;
        } else if (action == 1) {
            gXSliderView.startTimer();
            return false;
        } else if (action != 2) {
            return false;
        } else {
            gXSliderView.stopTimer();
            return false;
        }
    }

    private final void startTimer() {
        stopTimer();
        oq0 oq0 = this.config;
        if (oq0 != null) {
            long h = oq0.h();
            if (h > 0) {
                this.timer = new Timer();
                GXSliderView$startTimer$1$1 gXSliderView$startTimer$1$1 = new GXSliderView$startTimer$1$1(this);
                this.timerTask = gXSliderView$startTimer$1$1;
                Timer timer2 = this.timer;
                if (timer2 != null) {
                    timer2.schedule(gXSliderView$startTimer$1$1, h, h);
                }
            }
        }
    }

    private final void stopTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        TimerTask timerTask2 = this.timerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        this.timer = null;
        this.timerTask = null;
    }

    @Nullable
    public final oq0 getConfig() {
        return this.config;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public wq0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    @Nullable
    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        PagerAdapter adapter;
        PagerAdapter adapter2;
        stopTimer();
        ViewPager viewPager2 = this.viewPager;
        if (!(viewPager2 == null || (adapter2 = viewPager2.getAdapter()) == null)) {
            adapter2.notifyDataSetChanged();
        }
        oq0 oq0 = this.config;
        if (oq0 != null) {
            int i = oq0.i();
            ViewPager viewPager3 = getViewPager();
            if (!(viewPager3 == null || (adapter = viewPager3.getAdapter()) == null)) {
                if (i >= 0 && i < adapter.getCount()) {
                    ViewPager viewPager4 = getViewPager();
                    if (viewPager4 != null) {
                        viewPager4.setCurrentItem(i, false);
                    }
                    GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
                    if (gXSliderBaseIndicatorView != null) {
                        gXSliderBaseIndicatorView.updateSelectedIndex(i);
                    }
                }
            }
        }
        startTimer();
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewVisibleChange
    public void onVisibleChanged(boolean z) {
        if (z) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        this.indicatorView = null;
        stopTimer();
    }

    public final void setConfig(@Nullable oq0 oq0) {
        this.config = oq0;
        boolean z = false;
        if (oq0 != null && oq0.a()) {
            z = true;
        }
        if (z) {
            initIndicator();
            GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
            if (gXSliderBaseIndicatorView != null) {
                gXSliderBaseIndicatorView.setIndicatorColor(Integer.valueOf(oq0.e().b(getContext())), Integer.valueOf(oq0.f().b(getContext())));
            }
        }
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
        GXSliderBaseIndicatorView gXSliderBaseIndicatorView = this.indicatorView;
        if (gXSliderBaseIndicatorView != null) {
            gXSliderBaseIndicatorView.setIndicatorCount(i);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            iq0 iq0 = new iq0();
            iq0.setShape(0);
            iq0.setCornerRadii(fArr);
            iq0.setStroke((int) f, i);
            if (Build.VERSION.SDK_INT >= 23) {
                setForeground(iq0);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        k21.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (fArr.length == 8) {
            float f = fArr[0];
            float f2 = fArr[2];
            float f3 = fArr[4];
            float f4 = fArr[6];
            if (Build.VERSION.SDK_INT >= 21) {
                if (f == f2) {
                    if (f2 == f3) {
                        if ((f3 == f4) && f > 0.0f) {
                            setClipToOutline(true);
                            setOutlineProvider(new c(this, f));
                            return;
                        }
                    }
                }
                setClipToOutline(false);
                setOutlineProvider(null);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(@Nullable wq0 wq0) {
        this.gxTemplateContext = wq0;
    }

    public final void setViewPager(@Nullable ViewPager viewPager2) {
        this.viewPager = viewPager2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GXSliderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }
}
