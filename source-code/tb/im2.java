package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class im2 {
    @NotNull
    public static final a Companion = new a(null);
    private final TitleBar a;
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f = 1;
    private float g;
    private int h;
    private boolean i;
    private int j = -1;
    private boolean k;
    private boolean l;
    @NotNull
    private final H5ToolBar m;
    @NotNull
    private final WebView n;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        @TargetApi(21)
        public final void a(@Nullable Activity activity, int i) {
            if (activity != null && !activity.isFinishing()) {
                Window window = activity.getWindow();
                window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                window.addFlags(Integer.MIN_VALUE);
                k21.h(window, v.ATTACH_MODE_WINDOW);
                View decorView = window.getDecorView();
                k21.h(decorView, "window.decorView");
                decorView.setSystemUiVisibility(1280);
                window.setStatusBarColor(i);
            }
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements View.OnScrollChangeListener {
        final /* synthetic */ im2 a;

        b(im2 im2) {
            this.a = im2;
        }

        public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
            this.a.h += i2 - i4;
            im2 im2 = this.a;
            im2.k(im2.d, this.a.f, true);
            j91.a("Kian", "delayDy " + this.a.h + "   alpha:" + this.a.g);
            TitleBar titleBar = this.a.a;
            k21.h(titleBar, "titleBar");
            im2 im22 = this.a;
            im22.q(titleBar.getSolidColor() | -16777216, im22.e, true);
        }
    }

    public im2(@NotNull H5ToolBar h5ToolBar, @NotNull WebView webView) {
        k21.i(h5ToolBar, "toolBar");
        k21.i(webView, "webView");
        this.m = h5ToolBar;
        this.n = webView;
        this.a = h5ToolBar.getTitleBar();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void k(int i2, int i3, boolean z) {
        float f2;
        int scrollY = z ? this.h : this.n.getScrollY();
        if (Math.abs(scrollY) >= i2) {
            f2 = scrollY <= 0 ? 0.0f : 1.0f;
        } else {
            f2 = ((float) Math.abs(scrollY / i3)) / 255.0f;
        }
        this.g = f2;
    }

    private final void l() {
        this.a.setBackgroundColor(0);
        Drawable background = this.m.getBackground();
        k21.h(background, "toolBar.background");
        background.setAlpha((int) (this.g * 255.0f));
        if (((double) this.g) <= 0.2d) {
            this.a.setLineVisable(false);
        } else {
            this.a.setLineVisable(true);
        }
        if (this.i) {
            TitleBar titleBar = this.a;
            k21.h(titleBar, "titleBar");
            titleBar.getTitleTextView().setTextColor(ColorUtils.setAlphaComponent(0, (int) (((float) 255) * this.g)));
        }
    }

    private final void m() {
        ViewParent parent = this.n.getParent();
        ViewGroup viewGroup = null;
        ViewParent parent2 = parent != null ? parent.getParent() : null;
        if (!(parent2 instanceof ViewGroup)) {
            parent2 = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent2;
        ViewGroup.LayoutParams layoutParams = viewGroup2 != null ? viewGroup2.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        }
        if (this.c) {
            layoutParams2.removeRule(3);
            layoutParams2.addRule(6);
        } else {
            layoutParams2.addRule(3, this.m.getId());
        }
        ViewParent parent3 = this.n.getParent();
        ViewParent parent4 = parent3 != null ? parent3.getParent() : null;
        if (parent4 instanceof ViewGroup) {
            viewGroup = parent4;
        }
        ViewGroup viewGroup3 = viewGroup;
        if (viewGroup3 != null) {
            viewGroup3.setLayoutParams(layoutParams2);
        }
    }

    private final void o() {
        TitleBar titleBar = this.a;
        k21.h(titleBar, "titleBar");
        titleBar.getLeftButtonView().setTextColor(-16777216);
        TitleBar titleBar2 = this.a;
        k21.h(titleBar2, "titleBar");
        titleBar2.getRightButtonView().setTextColor(-16777216);
        TitleBar titleBar3 = this.a;
        k21.h(titleBar3, "titleBar");
        titleBar3.getRight2ButtonView().setTextColor(-16777216);
    }

    private final void p() {
        TitleBar titleBar = this.a;
        k21.h(titleBar, "titleBar");
        titleBar.getLeftButtonView().setTextColor(-1);
        TitleBar titleBar2 = this.a;
        k21.h(titleBar2, "titleBar");
        titleBar2.getRightButtonView().setTextColor(-1);
        TitleBar titleBar3 = this.a;
        k21.h(titleBar3, "titleBar");
        titleBar3.getRight2ButtonView().setTextColor(-1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void q(int i2, int i3, boolean z) {
        if (Math.abs(z ? this.h : this.n.getScrollY()) >= i3) {
            if (this.j == -1) {
                t("default");
            } else {
                t("light");
            }
            if (!this.l) {
                s("default");
            }
        } else {
            r();
        }
        l();
    }

    private final void r() {
        if (!this.l || this.j != -1) {
            t("light");
        } else {
            t("default");
        }
        if (!this.l) {
            s("light");
        }
    }

    private final void s(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 102970646) {
            if (hashCode == 1544803905 && str.equals("default")) {
                this.a.setTitleColor(TitleBar.DEFAULT_COLOR_MAIN_TITLE_TEXT);
            }
        } else if (str.equals("light")) {
            this.a.setTitleColor(TitleBar.DEFAULT_COLOR_OVERLAY_TITLE_TEXT);
        }
    }

    private final void t(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 102970646) {
            if (hashCode == 1544803905 && str.equals("default")) {
                o();
            }
        } else if (str.equals("light")) {
            p();
        }
    }

    private final void u(String str) {
        if (!TextUtils.isEmpty(str)) {
            l();
            if (TextUtils.equals(str, "auto") && Build.VERSION.SDK_INT >= 23) {
                this.n.setOnScrollChangeListener(new b(this));
            }
        }
    }

    public final void j(@Nullable String str) {
        if (this.m.getVisibility() == 0) {
            H5ToolBar h5ToolBar = this.m;
            pt0 pt0 = pt0.INSTANCE;
            h5ToolBar.setPreventTouch(!k21.d(pt0.b(this.n.getUrl(), "titlePenetrate"), "YES"));
            this.c = false;
            if (str == null) {
                str = pt0.b(this.n.getUrl(), "transparentTitle");
            }
            this.b = str;
            if (!(str == null || str.length() == 0)) {
                this.c = k21.d("always", this.b) || k21.d("auto", this.b);
            }
            if (this.c) {
                if (k21.d(this.b, "auto")) {
                    String b2 = pt0.b(this.n.getUrl(), "scrollDistance");
                    int parseInt = b2 != null ? Integer.parseInt(b2) : 255;
                    this.d = parseInt;
                    int i2 = parseInt / 255;
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    this.f = i2;
                    this.e = (parseInt * 3) / 4;
                    k(parseInt, i2, false);
                    q(-1, this.e, false);
                    this.h = this.n.getScrollY();
                    this.i = o.w("YES", pt0.b(this.n.getUrl(), "transparentTitleTextAuto"), true);
                } else {
                    this.g = 0.0f;
                    this.i = false;
                    if (!this.k) {
                        t("default");
                        s("default");
                    }
                }
                u(this.b);
            } else {
                this.g = 1.0f;
                l();
                this.i = false;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.n.setOnScrollChangeListener(null);
                }
                t("default");
                s("default");
            }
            m();
        }
    }

    public final void n(@Nullable String str) {
        this.k = true;
        j(str);
    }
}
