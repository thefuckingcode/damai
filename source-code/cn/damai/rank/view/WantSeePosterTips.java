package cn.damai.rank.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.wannasee.WantSeePosterTipsMarkRequest;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a03;
import tb.dy2;
import tb.eb0;
import tb.ey2;
import tb.fy2;
import tb.k21;
import tb.m40;
import tb.s50;
import tb.ta;

/* compiled from: Taobao */
public final class WantSeePosterTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean wantSeePosterTipsShown;
    @NotNull
    private DMIconFontTextView arrow;
    @NotNull
    private final TranslateAnimation arrowAnimation;
    @Nullable
    private ActionListener listener;
    @Nullable
    private b pageSource;
    @NotNull
    private LinearLayout parentTitle;
    @NotNull
    private RoundImageView poster;
    @Nullable
    private Long projectId;
    private long startTime;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private TextView titleSuffix;
    @NotNull
    private View view;
    @NotNull
    private SeeAnimateView wantSeeView;

    /* compiled from: Taobao */
    public interface ActionListener {
        void click();

        void hide(long j);
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "682175308")) {
                return WantSeePosterTips.wantSeePosterTipsShown;
            }
            return ((Boolean) ipChange.ipc$dispatch("682175308", new Object[]{this})).booleanValue();
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-600070504")) {
                ipChange.ipc$dispatch("-600070504", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            WantSeePosterTips.wantSeePosterTipsShown = z;
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private WantSeeIconUpdate a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private Integer g;

        /* compiled from: Taobao */
        public static final class a extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final a INSTANCE = new a();

            private a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "835714894")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("835714894", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-929552257")) {
                    return (String) ipChange.ipc$dispatch("-929552257", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1177815783")) {
                    return (String) ipChange.ipc$dispatch("1177815783", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public int h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-2061188809")) {
                    return 60;
                }
                return ((Integer) ipChange.ipc$dispatch("-2061188809", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-113794882")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("-113794882", new Object[]{this})).booleanValue();
            }
        }

        /* renamed from: cn.damai.rank.view.WantSeePosterTips$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0037b extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C0037b INSTANCE = new C0037b();

            private C0037b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean a() {
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "340042659")) {
                    return ((Boolean) ipChange.ipc$dispatch("340042659", new Object[]{this})).booleanValue();
                }
                String b = b();
                if (b == null || b.length() == 0) {
                    z = true;
                }
                return !z;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-432127596")) {
                    return (String) ipChange.ipc$dispatch("-432127596", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "80843250")) {
                    return (String) ipChange.ipc$dispatch("80843250", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public int h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1991476034")) {
                    return 30;
                }
                return ((Integer) ipChange.ipc$dispatch("1991476034", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-955158903")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("-955158903", new Object[]{this})).booleanValue();
            }
        }

        /* compiled from: Taobao */
        public static final class c extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1902394276")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("-1902394276", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "86902285")) {
                    return "大麦超懂你，可以点击了解更多哦～";
                }
                return (String) ipChange.ipc$dispatch("86902285", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-272644071")) {
                    return "哇～又发现了相似好演出";
                }
                return (String) ipChange.ipc$dispatch("-272644071", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public int h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "869388393")) {
                    return 12;
                }
                return ((Integer) ipChange.ipc$dispatch("869388393", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "76874352")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("76874352", new Object[]{this})).booleanValue();
            }
        }

        /* compiled from: Taobao */
        public static final class d extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final d INSTANCE = new d();

            private d() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "446822590")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("446822590", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "852010479")) {
                    return (String) ipChange.ipc$dispatch("852010479", new Object[]{this});
                }
                String m = m();
                return m == null ? "" : m;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            @NotNull
            public String g() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "300024695")) {
                    return (String) ipChange.ipc$dispatch("300024695", new Object[]{this});
                }
                String n = n();
                return n == null ? "" : n;
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public int h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1235465785")) {
                    return 30;
                }
                return ((Integer) ipChange.ipc$dispatch("-1235465785", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeePosterTips.b
            public boolean i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "908754254")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("908754254", new Object[]{this})).booleanValue();
            }
        }

        private b() {
            this.a = new WantSeeIconUpdate(false, false, false, null, 8, null);
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        public abstract boolean a();

        @Nullable
        public final String b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1661800978")) {
                return this.f;
            }
            return (String) ipChange.ipc$dispatch("1661800978", new Object[]{this});
        }

        @NotNull
        public String c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-468777981")) {
                return ta.PROJECT_PAGE;
            }
            return (String) ipChange.ipc$dispatch("-468777981", new Object[]{this});
        }

        @NotNull
        public String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-257427068")) {
                return "bottom";
            }
            return (String) ipChange.ipc$dispatch("-257427068", new Object[]{this});
        }

        @NotNull
        public String e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-46076155")) {
                return "wanted_tips";
            }
            return (String) ipChange.ipc$dispatch("-46076155", new Object[]{this});
        }

        @NotNull
        public abstract String f();

        @NotNull
        public abstract String g();

        public abstract int h();

        public abstract boolean i();

        @Nullable
        public final Integer j() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-135651716")) {
                return this.g;
            }
            return (Integer) ipChange.ipc$dispatch("-135651716", new Object[]{this});
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-809434386")) {
                return this.e;
            }
            return (String) ipChange.ipc$dispatch("-809434386", new Object[]{this});
        }

        @NotNull
        public final WantSeeIconUpdate l() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1239164179")) {
                return this.a;
            }
            return (WantSeeIconUpdate) ipChange.ipc$dispatch("1239164179", new Object[]{this});
        }

        @Nullable
        public final String m() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1561829529")) {
                return this.d;
            }
            return (String) ipChange.ipc$dispatch("1561829529", new Object[]{this});
        }

        @Nullable
        public final String n() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-641525491")) {
                return this.b;
            }
            return (String) ipChange.ipc$dispatch("-641525491", new Object[]{this});
        }

        @Nullable
        public final String o() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1842028418")) {
                return this.c;
            }
            return (String) ipChange.ipc$dispatch("-1842028418", new Object[]{this});
        }

        public final void p(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1418869236")) {
                ipChange.ipc$dispatch("-1418869236", new Object[]{this, str});
                return;
            }
            this.f = str;
        }

        public final void q(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417561138")) {
                ipChange.ipc$dispatch("-1417561138", new Object[]{this, num});
                return;
            }
            this.g = num;
        }

        public final void r(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1432545616")) {
                ipChange.ipc$dispatch("-1432545616", new Object[]{this, str});
                return;
            }
            this.e = str;
        }

        public final void s(@NotNull WantSeeIconUpdate wantSeeIconUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1786238905")) {
                ipChange.ipc$dispatch("-1786238905", new Object[]{this, wantSeeIconUpdate});
                return;
            }
            k21.i(wantSeeIconUpdate, "<set-?>");
            this.a = wantSeeIconUpdate;
        }

        public final void t(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1569956197")) {
                ipChange.ipc$dispatch("1569956197", new Object[]{this, str});
                return;
            }
            this.d = str;
        }

        public final void u(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-377658615")) {
                ipChange.ipc$dispatch("-377658615", new Object[]{this, str});
                return;
            }
            this.b = str;
        }

        public final void v(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986492744")) {
                ipChange.ipc$dispatch("-986492744", new Object[]{this, str});
                return;
            }
            this.c = str;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeePosterTips a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(WantSeePosterTips wantSeePosterTips) {
            super(5500, 1000);
            this.a = wantSeePosterTips;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1160359466")) {
                ipChange.ipc$dispatch("1160359466", new Object[]{this});
                return;
            }
            this.a.hideAnim();
            this.a.view.setVisibility(8);
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371270172")) {
                ipChange.ipc$dispatch("-1371270172", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public static final class d extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeePosterTips a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(WantSeePosterTips wantSeePosterTips) {
            super(5500, 1000);
            this.a = wantSeePosterTips;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "332485873")) {
                ipChange.ipc$dispatch("332485873", new Object[]{this});
                return;
            }
            this.a.hideAnim();
            this.a.view.setVisibility(8);
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-566691779")) {
                ipChange.ipc$dispatch("-566691779", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeePosterTips(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m60_init_$lambda0(WantSeePosterTips wantSeePosterTips, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697540584")) {
            ipChange.ipc$dispatch("-1697540584", new Object[]{wantSeePosterTips, view2});
            return;
        }
        k21.i(wantSeePosterTips, "this$0");
        wantSeePosterTips.cancel();
        wantSeePosterTips.view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m61_init_$lambda2(WantSeePosterTips wantSeePosterTips, Context context, View view2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1564161342")) {
            ipChange.ipc$dispatch("-1564161342", new Object[]{wantSeePosterTips, context, view2});
            return;
        }
        k21.i(wantSeePosterTips, "this$0");
        k21.i(context, "$context");
        ActionListener actionListener = wantSeePosterTips.listener;
        if (actionListener != null) {
            actionListener.click();
        }
        b bVar = wantSeePosterTips.pageSource;
        if (!k21.d(bVar, b.c.INSTANCE)) {
            z = k21.d(bVar, b.C0037b.INSTANCE);
        }
        if (z) {
            wantSeePosterTips.cancel();
            b bVar2 = wantSeePosterTips.pageSource;
            if (bVar2 != null) {
                DMNav.from(context).setTransition(0, 0).toUri(bVar2.b());
            }
        }
    }

    private final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415271617")) {
            ipChange.ipc$dispatch("1415271617", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ActionListener actionListener = this.listener;
        if (actionListener != null) {
            actionListener.hide(System.currentTimeMillis() - this.startTime);
        }
        this.arrowAnimation.cancel();
        this.view.postDelayed(new fy2(this), 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: cancel$lambda-7  reason: not valid java name */
    public static final void m62cancel$lambda7(WantSeePosterTips wantSeePosterTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339488765")) {
            ipChange.ipc$dispatch("339488765", new Object[]{wantSeePosterTips});
            return;
        }
        k21.i(wantSeePosterTips, "this$0");
        wantSeePosterTips.view.setVisibility(8);
    }

    public static final boolean getWantSeePosterTipsShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1056147180") ? ((Boolean) ipChange.ipc$dispatch("-1056147180", new Object[0])).booleanValue() : Companion.a();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781334360")) {
            ipChange.ipc$dispatch("-781334360", new Object[]{this});
            return;
        }
        ActionListener actionListener = this.listener;
        if (actionListener != null) {
            actionListener.hide(System.currentTimeMillis() - this.startTime);
        }
        this.arrowAnimation.cancel();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500);
        startAnimation(translateAnimation);
    }

    public static final void setWantSeePosterTipsShown(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346507216")) {
            ipChange.ipc$dispatch("1346507216", new Object[]{Boolean.valueOf(z)});
            return;
        }
        Companion.b(z);
    }

    private final void updateUI(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8565787")) {
            ipChange.ipc$dispatch("8565787", new Object[]{this, bVar});
            return;
        }
        this.title.setText(bVar.g());
        this.subTitle.setText(bVar.f());
        this.arrow.setVisibility(bVar.a() ? 0 : 8);
        TextView textView = this.titleSuffix;
        textView.setVisibility(bVar.i() ? 0 : 8);
        textView.setText(bVar.o());
        ViewGroup.LayoutParams layoutParams = this.parentTitle.getLayoutParams();
        k21.g(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(s50.a(AppInfoProviderProxy.getAppContext(), (float) bVar.h()));
        IImageLoader a2 = cn.damai.uikit.image.a.a();
        String k = bVar.k();
        RoundImageView roundImageView = this.poster;
        int i = R$drawable.uikit_default_image_bg_grey;
        a2.loadinto(k, roundImageView, i, i);
        WantSeeIconUpdate l = bVar.l();
        if (l.getShowWantSeeIcon()) {
            this.wantSeeView.setVisibility(0);
            this.wantSeeView.setOnClickListener(l.getListener());
            if (l.isFollow()) {
                this.wantSeeView.setFollowImage();
            } else {
                this.wantSeeView.setCancelImage();
            }
            if (!l.getPlayAnimate()) {
                return;
            }
            if (l.isFollow()) {
                this.wantSeeView.clickAnimate();
            } else {
                this.wantSeeView.cancelAnimate();
            }
        } else {
            this.wantSeeView.setVisibility(8);
        }
    }

    @Nullable
    public final ActionListener getListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-310075570")) {
            return this.listener;
        }
        return (ActionListener) ipChange.ipc$dispatch("-310075570", new Object[]{this});
    }

    @Nullable
    public final Long getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-644064616")) {
            return this.projectId;
        }
        return (Long) ipChange.ipc$dispatch("-644064616", new Object[]{this});
    }

    public final void hideCloseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092833484")) {
            ipChange.ipc$dispatch("-1092833484", new Object[]{this});
            return;
        }
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_poster_close)).setVisibility(8);
    }

    public final boolean isShowing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1066503832")) {
            return this.view.getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1066503832", new Object[]{this})).booleanValue();
    }

    public final void mark(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691166541")) {
            ipChange.ipc$dispatch("691166541", new Object[]{this, l});
            return;
        }
        WantSeePosterTipsMarkRequest wantSeePosterTipsMarkRequest = new WantSeePosterTipsMarkRequest();
        wantSeePosterTipsMarkRequest.setTargetId(String.valueOf(l));
        eb0.a(wantSeePosterTipsMarkRequest).doOnKTSuccess(WantSeePosterTips$mark$2.INSTANCE).doOnKTFail(WantSeePosterTips$mark$3.INSTANCE);
    }

    public final void resumeTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926573335")) {
            ipChange.ipc$dispatch("926573335", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = new c(this).start();
    }

    public final void setListener(@Nullable ActionListener actionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677542784")) {
            ipChange.ipc$dispatch("-1677542784", new Object[]{this, actionListener});
            return;
        }
        this.listener = actionListener;
    }

    public final void setPageSource(@NotNull b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813055190")) {
            ipChange.ipc$dispatch("1813055190", new Object[]{this, bVar});
            return;
        }
        k21.i(bVar, "pageSource");
        this.pageSource = bVar;
        updateUI(bVar);
    }

    public final void setProjectId(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184852520")) {
            ipChange.ipc$dispatch("1184852520", new Object[]{this, l});
            return;
        }
        this.projectId = l;
    }

    public final void showAnim() {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272764275")) {
            ipChange.ipc$dispatch("-272764275", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.startTime = System.currentTimeMillis();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.arrow.startAnimation(this.arrowAnimation);
        translateAnimation.setDuration(500);
        startAnimation(translateAnimation);
        this.view.setVisibility(0);
        this.timer = new d(this).start();
        if (k21.d(this.pageSource, b.d.INSTANCE)) {
            HashMap<String, String> f = a03.f();
            String str = null;
            if (f != null) {
                f.put("item_id", String.valueOf(this.projectId));
                b bVar = this.pageSource;
                f.put("type", String.valueOf(bVar != null ? bVar.j() : null));
                hashMap = f;
            } else {
                hashMap = null;
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            b bVar2 = this.pageSource;
            String e2 = bVar2 != null ? bVar2.e() : null;
            b bVar3 = this.pageSource;
            String d2 = bVar3 != null ? bVar3.d() : null;
            b bVar4 = this.pageSource;
            if (bVar4 != null) {
                str = bVar4.c();
            }
            e.G(this, e2, d2, str, hashMap);
        }
    }

    public final void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466620820")) {
            ipChange.ipc$dispatch("-1466620820", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeePosterTips(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_want_see_poster_tips, (ViewGroup) this, true);
        k21.h(inflate, "from(context).inflate(R.…_poster_tips, this, true)");
        this.view = inflate;
        View findViewById = inflate.findViewById(R$id.ll_parent_title);
        k21.h(findViewById, "view.findViewById(R.id.ll_parent_title)");
        this.parentTitle = (LinearLayout) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see_poster_title);
        k21.h(findViewById2, "view.findViewById(R.id.want_see_poster_title)");
        this.title = (TextView) findViewById2;
        View findViewById3 = this.view.findViewById(R$id.want_see_poster_title_suffix);
        k21.h(findViewById3, "view.findViewById(R.id.w…_see_poster_title_suffix)");
        this.titleSuffix = (TextView) findViewById3;
        View findViewById4 = this.view.findViewById(R$id.want_see_poster_subtitle);
        k21.h(findViewById4, "view.findViewById(R.id.want_see_poster_subtitle)");
        this.subTitle = (TextView) findViewById4;
        View findViewById5 = this.view.findViewById(R$id.want_see_poster_img);
        k21.h(findViewById5, "view.findViewById(R.id.want_see_poster_img)");
        this.poster = (RoundImageView) findViewById5;
        View findViewById6 = this.view.findViewById(R$id.want_see_poster_arrow);
        k21.h(findViewById6, "view.findViewById(R.id.want_see_poster_arrow)");
        this.arrow = (DMIconFontTextView) findViewById6;
        View findViewById7 = this.view.findViewById(R$id.want_see_animate_icon);
        k21.h(findViewById7, "view.findViewById(R.id.want_see_animate_icon)");
        this.wantSeeView = (SeeAnimateView) findViewById7;
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_poster_close)).setOnClickListener(new dy2(this));
        ((ViewGroup) this.view.findViewById(R$id.want_see_poster_bg)).setOnClickListener(new ey2(this, context));
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -2.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(10);
        translateAnimation.setRepeatMode(2);
        this.arrowAnimation = translateAnimation;
    }
}
