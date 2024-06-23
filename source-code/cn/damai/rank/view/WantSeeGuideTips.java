package cn.damai.rank.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alient.onearch.adapter.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a03;
import tb.k21;
import tb.m40;
import tb.s50;
import tb.ta;
import tb.yx2;
import tb.zx2;

/* compiled from: Taobao */
public final class WantSeeGuideTips extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean wantSeeGuideTipsShown;
    @Nullable
    private Long projectId;
    @Nullable
    private b scenesSource;
    @NotNull
    private TextView subTitle;
    @Nullable
    private CountDownTimer timer;
    @NotNull
    private TextView title;
    @NotNull
    private View view;

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
            if (!AndroidInstantRuntime.support(ipChange, "-445601134")) {
                return WantSeeGuideTips.wantSeeGuideTipsShown;
            }
            return ((Boolean) ipChange.ipc$dispatch("-445601134", new Object[]{this})).booleanValue();
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309441146")) {
                ipChange.ipc$dispatch("309441146", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            WantSeeGuideTips.wantSeeGuideTipsShown = z;
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String a;
        @Nullable
        private String b;

        /* compiled from: Taobao */
        public static final class a extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final a INSTANCE = new a();

            private a() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1910226816")) {
                    return "标 [想看]，以后更好查找～";
                }
                return (String) ipChange.ipc$dispatch("-1910226816", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "652860038")) {
                    return "还没做好决定？";
                }
                return (String) ipChange.ipc$dispatch("652860038", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            public int k() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-838645963")) {
                    return 1;
                }
                return ((Integer) ipChange.ipc$dispatch("-838645963", new Object[]{this})).intValue();
            }
        }

        /* renamed from: cn.damai.rank.view.WantSeeGuideTips$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0036b extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final C0036b INSTANCE = new C0036b();

            private C0036b() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-2062972732")) {
                    return "标 [想看]，记录心动演出～";
                }
                return (String) ipChange.ipc$dispatch("-2062972732", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-902883134")) {
                    return "感觉有点心动？";
                }
                return (String) ipChange.ipc$dispatch("-902883134", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            public int k() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-867165319")) {
                    return 3;
                }
                return ((Integer) ipChange.ipc$dispatch("-867165319", new Object[]{this})).intValue();
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

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1351088601")) {
                    return "标 [想看]，记录心动演出～";
                }
                return (String) ipChange.ipc$dispatch("-1351088601", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "483479103")) {
                    return "感觉有点心动？";
                }
                return (String) ipChange.ipc$dispatch("483479103", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            public int k() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-414002724")) {
                    return 2;
                }
                return ((Integer) ipChange.ipc$dispatch("-414002724", new Object[]{this})).intValue();
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

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "615345221")) {
                    return "标 [想看]，及时获取优惠信息～";
                }
                return (String) ipChange.ipc$dispatch("615345221", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "189582561")) {
                    return "还没做好决定？";
                }
                return (String) ipChange.ipc$dispatch("189582561", new Object[]{this});
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            public int k() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "100610554")) {
                    return 0;
                }
                return ((Integer) ipChange.ipc$dispatch("100610554", new Object[]{this})).intValue();
            }
        }

        /* compiled from: Taobao */
        public static final class e extends b {
            private static transient /* synthetic */ IpChange $ipChange;
            @NotNull
            public static final e INSTANCE = new e();

            private e() {
                super(null);
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String e() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1646181301")) {
                    return (String) ipChange.ipc$dispatch("-1646181301", new Object[]{this});
                }
                String g = g();
                return g == null ? "" : g;
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            @NotNull
            public String f() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2002165093")) {
                    return (String) ipChange.ipc$dispatch("-2002165093", new Object[]{this});
                }
                String h = h();
                return h == null ? "" : h;
            }

            @Override // cn.damai.rank.view.WantSeeGuideTips.b
            public int k() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1290847232")) {
                    return -1;
                }
                return ((Integer) ipChange.ipc$dispatch("-1290847232", new Object[]{this})).intValue();
            }
        }

        private b() {
            this.a = "";
            this.b = "";
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        public int a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-774350033")) {
                return s50.a(AppInfoProviderProxy.getAppContext(), 0.0f);
            }
            return ((Integer) ipChange.ipc$dispatch("-774350033", new Object[]{this})).intValue();
        }

        @NotNull
        public final String b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2025032762")) {
                return ta.PROJECT_PAGE;
            }
            return (String) ipChange.ipc$dispatch("-2025032762", new Object[]{this});
        }

        @NotNull
        public final String c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1813681849")) {
                return "bottom";
            }
            return (String) ipChange.ipc$dispatch("-1813681849", new Object[]{this});
        }

        @NotNull
        public final String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1602330936")) {
                return "want-tips";
            }
            return (String) ipChange.ipc$dispatch("-1602330936", new Object[]{this});
        }

        @NotNull
        public abstract String e();

        @NotNull
        public abstract String f();

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "261528924")) {
                return this.b;
            }
            return (String) ipChange.ipc$dispatch("261528924", new Object[]{this});
        }

        @Nullable
        public final String h() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1800669994")) {
                return this.a;
            }
            return (String) ipChange.ipc$dispatch("1800669994", new Object[]{this});
        }

        public final void i(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-84656894")) {
                ipChange.ipc$dispatch("-84656894", new Object[]{this, str});
                return;
            }
            this.b = str;
        }

        public final void j(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1979009908")) {
                ipChange.ipc$dispatch("-1979009908", new Object[]{this, str});
                return;
            }
            this.a = str;
        }

        public abstract int k();
    }

    /* compiled from: Taobao */
    public static final class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeGuideTips a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(WantSeeGuideTips wantSeeGuideTips) {
            super(5500, 1000);
            this.a = wantSeeGuideTips;
        }

        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-633660324")) {
                ipChange.ipc$dispatch("-633660324", new Object[]{this});
                return;
            }
            this.a.hideAnim();
            this.a.view.setVisibility(8);
        }

        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290594446")) {
                ipChange.ipc$dispatch("-1290594446", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    public static final class d implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeGuideTips a;

        d(WantSeeGuideTips wantSeeGuideTips) {
            this.a = wantSeeGuideTips;
        }

        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1280385593")) {
                ipChange.ipc$dispatch("1280385593", new Object[]{this, animation});
                return;
            }
            this.a.guideAnim();
        }

        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149961061")) {
                ipChange.ipc$dispatch("-149961061", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "585108306")) {
                ipChange.ipc$dispatch("585108306", new Object[]{this, animation});
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeGuideTips(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_want_see_guide_tips, (ViewGroup) this, true);
        k21.h(inflate, "from(context).inflate(R.…e_guide_tips, this, true)");
        this.view = inflate;
        View findViewById = inflate.findViewById(R$id.want_see_guide_title);
        k21.h(findViewById, "view.findViewById(R.id.want_see_guide_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.view.findViewById(R$id.want_see_guide_subtitle);
        k21.h(findViewById2, "view.findViewById(R.id.want_see_guide_subtitle)");
        this.subTitle = (TextView) findViewById2;
        ((DMIconFontTextView) this.view.findViewById(R$id.want_see_guide_close)).setOnClickListener(new yx2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m58_init_$lambda0(WantSeeGuideTips wantSeeGuideTips, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505283264")) {
            ipChange.ipc$dispatch("-1505283264", new Object[]{wantSeeGuideTips, view2});
            return;
        }
        k21.i(wantSeeGuideTips, "this$0");
        CountDownTimer countDownTimer = wantSeeGuideTips.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        wantSeeGuideTips.view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: cancel$lambda-5  reason: not valid java name */
    public static final void m59cancel$lambda5(WantSeeGuideTips wantSeeGuideTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367770515")) {
            ipChange.ipc$dispatch("-1367770515", new Object[]{wantSeeGuideTips});
            return;
        }
        k21.i(wantSeeGuideTips, "this$0");
        wantSeeGuideTips.view.setVisibility(8);
    }

    public static final boolean getWantSeeGuideTipsShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1274994166") ? ((Boolean) ipChange.ipc$dispatch("-1274994166", new Object[0])).booleanValue() : Companion.a();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void guideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650065229")) {
            ipChange.ipc$dispatch("650065229", new Object[]{this});
            return;
        }
        DisplayUtil displayUtil = DisplayUtil.INSTANCE;
        Context context = getContext();
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
        float dp2px = displayUtil.dp2px(context, 1.5f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", this.view.getTranslationY() - dp2px, this.view.getTranslationY() + dp2px);
        if (ofFloat != null) {
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new CycleInterpolator(1.0f));
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void hideAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323137699")) {
            ipChange.ipc$dispatch("-323137699", new Object[]{this});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500);
        startAnimation(translateAnimation);
    }

    public static final void setWantSeeGuideTipsShown(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368060930")) {
            ipChange.ipc$dispatch("368060930", new Object[]{Boolean.valueOf(z)});
            return;
        }
        Companion.b(z);
    }

    private final void updateUI(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571465263")) {
            ipChange.ipc$dispatch("1571465263", new Object[]{this, bVar});
            return;
        }
        this.title.setText(bVar.f());
        this.subTitle.setText(bVar.e());
        this.view.setPadding(0, 0, 0, bVar.a());
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607926966")) {
            ipChange.ipc$dispatch("1607926966", new Object[]{this});
            return;
        }
        cancel(0);
    }

    @Nullable
    public final Long getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2121292349")) {
            return this.projectId;
        }
        return (Long) ipChange.ipc$dispatch("-2121292349", new Object[]{this});
    }

    public final void setProjectId(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659534243")) {
            ipChange.ipc$dispatch("-1659534243", new Object[]{this, l});
            return;
        }
        this.projectId = l;
    }

    public final void setScenesSource(@NotNull b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666063986")) {
            ipChange.ipc$dispatch("666063986", new Object[]{this, bVar});
            return;
        }
        k21.i(bVar, "scenesSource");
        this.scenesSource = bVar;
        updateUI(bVar);
    }

    public final void showAnim() {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "185432386")) {
            ipChange.ipc$dispatch("185432386", new Object[]{this});
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
        this.timer = new c(this).start();
        translateAnimation.setAnimationListener(new d(this));
        b bVar = this.scenesSource;
        if (!(k21.d(bVar, b.d.INSTANCE) ? true : k21.d(bVar, b.C0036b.INSTANCE) ? true : k21.d(bVar, b.a.INSTANCE))) {
            z = k21.d(bVar, b.c.INSTANCE);
        }
        if (z) {
            HashMap<String, String> f = a03.f();
            String str = null;
            if (f != null) {
                f.put("item_id", String.valueOf(this.projectId));
                b bVar2 = this.scenesSource;
                f.put("type", String.valueOf(bVar2 != null ? Integer.valueOf(bVar2.k()) : null));
                hashMap = f;
            } else {
                hashMap = null;
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            b bVar3 = this.scenesSource;
            String d2 = bVar3 != null ? bVar3.d() : null;
            b bVar4 = this.scenesSource;
            String c2 = bVar4 != null ? bVar4.c() : null;
            b bVar5 = this.scenesSource;
            if (bVar5 != null) {
                str = bVar5.b();
            }
            e.G(this, d2, c2, str, hashMap);
        }
    }

    public final void cancel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693841202")) {
            ipChange.ipc$dispatch("-1693841202", new Object[]{this, Long.valueOf(j)});
            return;
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.view.postDelayed(new zx2(this), j);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WantSeeGuideTips(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
