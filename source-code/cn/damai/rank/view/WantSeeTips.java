package cn.damai.rank.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.mine.activity.MineMainActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.br;
import tb.gr;
import tb.k21;
import tb.ky2;
import tb.ly2;
import tb.m40;
import tb.my2;
import tb.s50;

/* compiled from: Taobao */
public final class WantSeeTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private DMIconFontTextView arrow;
    @NotNull
    private FrameLayout container;
    @NotNull
    private LottieAnimationView lottieView;
    @NotNull
    private TextView openBtn;
    @Nullable
    private a pageSource;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private View view;

    /* compiled from: Taobao */
    public static abstract class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;

        /* renamed from: cn.damai.rank.view.WantSeeTips$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0038a extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C0038a INSTANCE = new C0038a();

            private C0038a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1386215595")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("1386215595", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1671521436")) {
                    return "种草成功，可以去 [我的] 页面找到哦～";
                }
                return (String) ipChange.ipc$dispatch("1671521436", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1615891434")) {
                    return "已加入 [我的-想看想玩-现场]";
                }
                return (String) ipChange.ipc$dispatch("1615891434", new Object[]{this});
            }
        }

        /* compiled from: Taobao */
        public static final class b extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final b INSTANCE = new b();

            private b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1491534073")) {
                    return s50.a(AppInfoProviderProxy.getAppContext(), 9.0f);
                }
                return ((Integer) ipChange.ipc$dispatch("1491534073", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "746930737")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("746930737", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @Nullable
            public String d() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "287386349")) {
                    return g();
                }
                return (String) ipChange.ipc$dispatch("287386349", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @Nullable
            public String e() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1628561783")) {
                    return f();
                }
                return (String) ipChange.ipc$dispatch("-1628561783", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1420453726")) {
                    return (String) ipChange.ipc$dispatch("-1420453726", new Object[]{this});
                }
                String j = j();
                if (j == null) {
                    return c.INSTANCE.q() ? "没有开启提醒，容易错过重要信息哦～" : "已加入想看想玩，开售时提醒你～";
                }
                return j;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1972746844")) {
                    return (String) ipChange.ipc$dispatch("-1972746844", new Object[]{this});
                }
                String k = k();
                return k == null ? "已加入 [我的-想看想玩]" : k;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean q() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "512544304")) {
                    return !PermissionsHelper.a(AppInfoProviderProxy.getAppContext());
                }
                return ((Boolean) ipChange.ipc$dispatch("512544304", new Object[]{this})).booleanValue();
            }
        }

        /* compiled from: Taobao */
        public static final class c extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final c INSTANCE = new c();

            private c() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "49303685")) {
                    return s50.a(AppInfoProviderProxy.getAppContext(), 9.0f);
                }
                return ((Integer) ipChange.ipc$dispatch("49303685", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-963838427")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("-963838427", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-311836778")) {
                    return q() ? "没有开启提醒，容易错过重要信息哦～" : "已加入想看想玩，开售时提醒你～";
                }
                return (String) ipChange.ipc$dispatch("-311836778", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1302111024")) {
                    return "已加入 [我的-想看想玩]";
                }
                return (String) ipChange.ipc$dispatch("1302111024", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean q() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "341911844")) {
                    return !PermissionsHelper.a(AppInfoProviderProxy.getAppContext());
                }
                return ((Boolean) ipChange.ipc$dispatch("341911844", new Object[]{this})).booleanValue();
            }
        }

        /* compiled from: Taobao */
        public static final class d extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final d INSTANCE = new d();

            private d() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-927232063")) {
                    return c().length() > 0;
                }
                return ((Boolean) ipChange.ipc$dispatch("-927232063", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "-716594638")) {
                    return (String) ipChange.ipc$dispatch("-716594638", new Object[]{this});
                }
                if (c().length() > 0) {
                    z = true;
                }
                if (!z) {
                    return "暂无演出计划，再去逛逛吧～";
                }
                return c() + "，快去看看吧～";
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-46324204")) {
                    return "赞～已收到你的想看";
                }
                return (String) ipChange.ipc$dispatch("-46324204", new Object[]{this});
            }
        }

        /* compiled from: Taobao */
        public static final class e extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final e INSTANCE = new e();

            private e() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public int a() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1379951201")) {
                    return s50.a(AppInfoProviderProxy.getAppContext(), 9.0f);
                }
                return ((Integer) ipChange.ipc$dispatch("-1379951201", new Object[]{this})).intValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1864083637")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("-1864083637", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "860314428")) {
                    return (String) ipChange.ipc$dispatch("860314428", new Object[]{this});
                }
                String j = j();
                return j == null ? "" : j;
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-600893110")) {
                    return (String) ipChange.ipc$dispatch("-600893110", new Object[]{this});
                }
                String k = k();
                return k == null ? "" : k;
            }
        }

        /* compiled from: Taobao */
        public static final class f extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final f INSTANCE = new f();

            private f() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "563608833")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("563608833", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "626868082")) {
                    return "上榜演出非常抢手，记得及时购票哦～";
                }
                return (String) ipChange.ipc$dispatch("626868082", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-791637804")) {
                    return "已加入 [我的-想看想玩]";
                }
                return (String) ipChange.ipc$dispatch("-791637804", new Object[]{this});
            }
        }

        /* compiled from: Taobao */
        public static final class g extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final g INSTANCE = new g();

            private g() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "591158248")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("591158248", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1432071527")) {
                    return "上榜演出非常抢手，记得及时购票哦～";
                }
                return (String) ipChange.ipc$dispatch("-1432071527", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-322722035")) {
                    return "已加入 [我的-想看想玩-合辑]";
                }
                return (String) ipChange.ipc$dispatch("-322722035", new Object[]{this});
            }
        }

        /* compiled from: Taobao */
        public static final class h extends a {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final h INSTANCE = new h();

            private h() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            public boolean b() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-880918080")) {
                    return true;
                }
                return ((Boolean) ipChange.ipc$dispatch("-880918080", new Object[]{this})).booleanValue();
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String h() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "366572145")) {
                    return "上榜演出非常抢手，记得及时购票哦～";
                }
                return (String) ipChange.ipc$dispatch("366572145", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeTips.a
            @NotNull
            public String i() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1760450101")) {
                    return "已加入 [我的-想看想玩]";
                }
                return (String) ipChange.ipc$dispatch("1760450101", new Object[]{this});
            }
        }

        private a() {
            this.a = "";
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public int a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "89441957")) {
                return s50.a(AppInfoProviderProxy.getAppContext(), 20.0f);
            }
            return ((Integer) ipChange.ipc$dispatch("89441957", new Object[]{this})).intValue();
        }

        public abstract boolean b();

        @NotNull
        public final String c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "57413318")) {
                return this.a;
            }
            return (String) ipChange.ipc$dispatch("57413318", new Object[]{this});
        }

        @Nullable
        public String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "855479193")) {
                return "";
            }
            return (String) ipChange.ipc$dispatch("855479193", new Object[]{this});
        }

        @Nullable
        public String e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1194594211")) {
                return "";
            }
            return (String) ipChange.ipc$dispatch("-1194594211", new Object[]{this});
        }

        @Nullable
        public final String f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2097963464")) {
                return this.d;
            }
            return (String) ipChange.ipc$dispatch("2097963464", new Object[]{this});
        }

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1379008863")) {
                return this.e;
            }
            return (String) ipChange.ipc$dispatch("1379008863", new Object[]{this});
        }

        @NotNull
        public abstract String h();

        @NotNull
        public abstract String i();

        @Nullable
        public final String j() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1003299366")) {
                return this.c;
            }
            return (String) ipChange.ipc$dispatch("1003299366", new Object[]{this});
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1424411296")) {
                return this.b;
            }
            return (String) ipChange.ipc$dispatch("1424411296", new Object[]{this});
        }

        public final void l(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-520138384")) {
                ipChange.ipc$dispatch("-520138384", new Object[]{this, str});
                return;
            }
            k21.i(str, "<set-?>");
            this.a = str;
        }

        public final void m(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1352846930")) {
                ipChange.ipc$dispatch("-1352846930", new Object[]{this, str});
                return;
            }
            this.d = str;
        }

        public final void n(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595490209")) {
                ipChange.ipc$dispatch("-1595490209", new Object[]{this, str});
                return;
            }
            this.e = str;
        }

        public final void o(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435390328")) {
                ipChange.ipc$dispatch("1435390328", new Object[]{this, str});
                return;
            }
            this.c = str;
        }

        public final void p(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-758127658")) {
                ipChange.ipc$dispatch("-758127658", new Object[]{this, str});
                return;
            }
            this.b = str;
        }

        public boolean q() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "542215940")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("542215940", new Object[]{this})).booleanValue();
        }
    }

    /* compiled from: Taobao */
    public static final class b extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeTips a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(WantSeeTips wantSeeTips) {
            super(5500, 1000);
            this.a = wantSeeTips;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1766882878")) {
                ipChange.ipc$dispatch("1766882878", new Object[]{this});
                return;
            }
            this.a.hideAnim();
            this.a.view.setVisibility(8);
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-658968240")) {
                ipChange.ipc$dispatch("-658968240", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeTips(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_rank_want_see_tip, (ViewGroup) this, true);
        k21.h(inflate, "from(context).inflate(R.…want_see_tip, this, true)");
        this.view = inflate;
        ((RelativeLayout) inflate.findViewById(R$id.want_see_bottombar_tip_bg)).setOnClickListener(new ly2(this, context));
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_bottombar_tip_close)).setOnClickListener(new ky2(this));
        View findViewById = this.view.findViewById(R$id.fl_want_see_tips_container);
        k21.h(findViewById, "view.findViewById(R.id.fl_want_see_tips_container)");
        this.container = (FrameLayout) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see__bottombar_tip_texttop);
        k21.h(findViewById2, "view.findViewById(R.id.w…e__bottombar_tip_texttop)");
        this.title = (TextView) findViewById2;
        View findViewById3 = this.view.findViewById(R$id.want_see__bottombar_tip_subtitle);
        k21.h(findViewById3, "view.findViewById(R.id.w…__bottombar_tip_subtitle)");
        this.subTitle = (TextView) findViewById3;
        View findViewById4 = this.view.findViewById(R$id.want_see_bottombar_tip_arrow);
        k21.h(findViewById4, "view.findViewById(R.id.w…_see_bottombar_tip_arrow)");
        this.arrow = (DMIconFontTextView) findViewById4;
        View findViewById5 = this.view.findViewById(R$id.tv_open_notification);
        k21.h(findViewById5, "view.findViewById(R.id.tv_open_notification)");
        this.openBtn = (TextView) findViewById5;
        View findViewById6 = this.view.findViewById(R$id.live_icon);
        k21.h(findViewById6, "view.findViewById(R.id.live_icon)");
        this.lottieView = (LottieAnimationView) findViewById6;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m63_init_$lambda0(WantSeeTips wantSeeTips, Context context, View view2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "420586718")) {
            ipChange.ipc$dispatch("420586718", new Object[]{wantSeeTips, context, view2});
            return;
        }
        k21.i(wantSeeTips, "this$0");
        k21.i(context, "$context");
        a aVar = wantSeeTips.pageSource;
        if (k21.d(aVar, a.h.INSTANCE) ? true : k21.d(aVar, a.f.INSTANCE)) {
            wantSeeTips.cancel();
            DMNav.from(context).setTransition(0, 0).toUri(gr.m().d("key_want_see_tips_page_name", "WantedPage").c(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX, 1));
        } else if (k21.d(aVar, a.c.INSTANCE)) {
            wantSeeTips.cancel();
            a aVar2 = wantSeeTips.pageSource;
            if (aVar2 == null || !aVar2.q()) {
                z = false;
            }
            if (z) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
                return;
            }
            DMNav.from(context).setTransition(0, 0).toUri(gr.m().d("key_want_see_tips_page_name", "WantedPage"));
        } else {
            String str = null;
            if (k21.d(aVar, a.b.INSTANCE)) {
                wantSeeTips.cancel();
                a aVar3 = wantSeeTips.pageSource;
                if (aVar3 != null && aVar3.q()) {
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.parse("package:" + context.getPackageName()));
                    context.startActivity(intent2);
                    return;
                }
                a aVar4 = wantSeeTips.pageSource;
                String g = aVar4 != null ? aVar4.g() : null;
                if (g != null && !g.y(g)) {
                    z = false;
                }
                if (!z) {
                    DMNav transition = DMNav.from(context).setTransition(0, 0);
                    a aVar5 = wantSeeTips.pageSource;
                    if (aVar5 != null) {
                        str = aVar5.d();
                    }
                    transition.toUri(str);
                    return;
                }
                DMNav.from(context).setTransition(0, 0).toUri(gr.m().d("key_want_see_tips_page_name", "WantedPage"));
            } else if (k21.d(aVar, a.g.INSTANCE)) {
                wantSeeTips.cancel();
                DMNav.from(context).setTransition(0, 0).toUri(gr.m().d("key_want_see_tips_page_name", "WantedPage").c(MineMainActivity.KEY_WANT_SEE_SUB_TAB_INDEX, 4));
            } else if (k21.d(aVar, a.d.INSTANCE)) {
                a aVar6 = wantSeeTips.pageSource;
                if (aVar6 == null || !aVar6.b()) {
                    z = false;
                }
                if (z) {
                    wantSeeTips.cancel();
                    a aVar7 = wantSeeTips.pageSource;
                    if (aVar7 != null) {
                        str = aVar7.c();
                    }
                    br.c("ip_drama_want_see_tips_click", str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m64_init_$lambda1(WantSeeTips wantSeeTips, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187941055")) {
            ipChange.ipc$dispatch("1187941055", new Object[]{wantSeeTips, view2});
            return;
        }
        k21.i(wantSeeTips, "this$0");
        CountDownTimer countDownTimer = wantSeeTips.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        wantSeeTips.view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: cancel$lambda-4  reason: not valid java name */
    public static final void m65cancel$lambda4(WantSeeTips wantSeeTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208937850")) {
            ipChange.ipc$dispatch("208937850", new Object[]{wantSeeTips});
            return;
        }
        k21.i(wantSeeTips, "this$0");
        wantSeeTips.view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467961403")) {
            ipChange.ipc$dispatch("467961403", new Object[]{this});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500);
        startAnimation(translateAnimation);
    }

    private final void updateUI(a aVar) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1686289029")) {
            ipChange.ipc$dispatch("-1686289029", new Object[]{this, aVar});
            return;
        }
        this.title.setText(aVar.i());
        this.subTitle.setText(aVar.h());
        int i = 8;
        this.arrow.setVisibility(aVar.b() ? 0 : 8);
        this.container.setPadding(0, 0, 0, aVar.a());
        TextView textView = this.openBtn;
        if (aVar.q()) {
            i = 0;
        }
        textView.setVisibility(i);
        String e = aVar.e();
        if (e != null && !g.y(e)) {
            z = false;
        }
        if (!z) {
            this.lottieView.setAnimationFromUrl(aVar.e());
        }
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434821868")) {
            ipChange.ipc$dispatch("-1434821868", new Object[]{this});
            return;
        }
        cancel(100);
    }

    public final void setPageSource(@NotNull a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277589636")) {
            ipChange.ipc$dispatch("-1277589636", new Object[]{this, aVar});
            return;
        }
        k21.i(aVar, "pageSource");
        this.pageSource = aVar;
        updateUI(aVar);
    }

    public final void showAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "976531488")) {
            ipChange.ipc$dispatch("976531488", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(500);
        startAnimation(translateAnimation);
        this.view.setVisibility(0);
        this.timer = new b(this).start();
    }

    public final void updateSubTitle(@NotNull a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339044351")) {
            ipChange.ipc$dispatch("339044351", new Object[]{this, aVar});
            return;
        }
        k21.i(aVar, "pageSource");
        this.subTitle.setText(aVar.h());
    }

    public final void cancel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529774544")) {
            ipChange.ipc$dispatch("-1529774544", new Object[]{this, Long.valueOf(j)});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.view.postDelayed(new my2(this), j);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeeTips(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
