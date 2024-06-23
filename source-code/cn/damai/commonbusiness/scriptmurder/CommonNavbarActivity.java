package cn.damai.commonbusiness.scriptmurder;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.view.AttentionView;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lk;
import tb.mk;
import tb.ne2;
import tb.nk;
import tb.v50;

/* compiled from: Taobao */
public abstract class CommonNavbarActivity extends SimpleBaseActivity implements INavStatusBarFeature {
    private static transient /* synthetic */ IpChange $ipChange;
    public Action actionAuth;
    public Action actionFollow;
    public Action actionShare;
    private AttentionView attentionView;

    private final void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027146659")) {
            ipChange.ipc$dispatch("1027146659", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5onCreate$lambda0(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648226549")) {
            ipChange.ipc$dispatch("-648226549", new Object[]{commonNavbarActivity, view});
            return;
        }
        k21.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m6onCreate$lambda1(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135152426")) {
            ipChange.ipc$dispatch("135152426", new Object[]{commonNavbarActivity, view});
            return;
        }
        k21.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.share();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m7onCreate$lambda2(CommonNavbarActivity commonNavbarActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918531401")) {
            ipChange.ipc$dispatch("918531401", new Object[]{commonNavbarActivity, view});
            return;
        }
        k21.i(commonNavbarActivity, "this$0");
        commonNavbarActivity.report();
    }

    public abstract void addFragment();

    public abstract void addUtPage();

    @NotNull
    public Action getActionAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268414236")) {
            return (Action) ipChange.ipc$dispatch("268414236", new Object[]{this});
        }
        Action action = this.actionAuth;
        if (action != null) {
            return action;
        }
        k21.A("actionAuth");
        return null;
    }

    @NotNull
    public Action getActionFollow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372167717")) {
            return (Action) ipChange.ipc$dispatch("1372167717", new Object[]{this});
        }
        Action action = this.actionFollow;
        if (action != null) {
            return action;
        }
        k21.A("actionFollow");
        return null;
    }

    @NotNull
    public Action getActionShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279385873")) {
            return (Action) ipChange.ipc$dispatch("-279385873", new Object[]{this});
        }
        Action action = this.actionShare;
        if (action != null) {
            return action;
        }
        k21.A("actionShare");
        return null;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-443915097")) {
            return R$layout.activity_common_nav_bar;
        }
        return ((Integer) ipChange.ipc$dispatch("-443915097", new Object[]{this})).intValue();
    }

    public void initAttentionView(@NotNull String str, int i, @NotNull String str2) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885985881")) {
            ipChange.ipc$dispatch("-885985881", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        k21.i(str, "id");
        k21.i(str2, "type");
        View findViewById = findViewById(R$id.title_navbar_attention);
        k21.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.AttentionView");
        AttentionView attentionView2 = (AttentionView) findViewById;
        this.attentionView = attentionView2;
        AttentionView attentionView3 = null;
        if (attentionView2 == null) {
            k21.A("attentionView");
            attentionView2 = null;
        }
        attentionView2.setInitParams(str, str2);
        AttentionView attentionView4 = this.attentionView;
        if (attentionView4 == null) {
            k21.A("attentionView");
            attentionView4 = null;
        }
        attentionView4.setVisibility(0);
        AttentionView attentionView5 = this.attentionView;
        if (attentionView5 == null) {
            k21.A("attentionView");
            attentionView5 = null;
        }
        attentionView5.setState(i);
        AttentionView attentionView6 = this.attentionView;
        if (attentionView6 == null) {
            k21.A("attentionView");
            attentionView6 = null;
        }
        attentionView6.setPage("venue_new");
        AttentionView attentionView7 = this.attentionView;
        if (attentionView7 == null) {
            k21.A("attentionView");
            attentionView7 = null;
        }
        attentionView7.setModule("top");
        if (this.actionFollow != null && (trackInfo = getActionFollow().getTrackInfo()) != null) {
            k21.h(trackInfo, "trackInfo");
            AttentionView attentionView8 = this.attentionView;
            if (attentionView8 == null) {
                k21.A("attentionView");
                attentionView8 = null;
            }
            attentionView8.setPage(trackInfo.getSpmb());
            AttentionView attentionView9 = this.attentionView;
            if (attentionView9 == null) {
                k21.A("attentionView");
                attentionView9 = null;
            }
            attentionView9.setModule(trackInfo.getSpmc());
            AttentionView attentionView10 = this.attentionView;
            if (attentionView10 == null) {
                k21.A("attentionView");
            } else {
                attentionView3 = attentionView10;
            }
            attentionView3.setArgsMap(trackInfo.getArgs());
        }
    }

    public abstract void initBaseInfo(@NotNull Object obj);

    public void initPageAction(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146492894")) {
            ipChange.ipc$dispatch("-146492894", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        boolean z = obj instanceof HashMap;
        Action action = null;
        HashMap hashMap = z ? (HashMap) obj : null;
        if (!(hashMap == null || (obj4 = hashMap.get("report")) == null)) {
            Action action2 = obj4 instanceof Action ? (Action) obj4 : null;
            if (action2 != null) {
                setActionAuth(action2);
                findViewById(R$id.title_navbar_report).setVisibility(0);
            }
        }
        HashMap hashMap2 = z ? (HashMap) obj : null;
        if (!(hashMap2 == null || (obj3 = hashMap2.get("share")) == null)) {
            Action action3 = obj3 instanceof Action ? (Action) obj3 : null;
            if (action3 != null) {
                setActionShare(action3);
                findViewById(R$id.title_navbar_share).setVisibility(0);
            }
        }
        HashMap hashMap3 = z ? (HashMap) obj : null;
        if (hashMap3 != null && (obj2 = hashMap3.get(StarFragment.KEY_FOLLOW)) != null) {
            if (obj2 instanceof Action) {
                action = (Action) obj2;
            }
            if (action != null) {
                setActionFollow(action);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774095668")) {
            ipChange.ipc$dispatch("774095668", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        addUtPage();
        c.e().K(this);
        View findViewById = findViewById(R$id.common_navbar_back);
        if (findViewById != null) {
            findViewById.setOnClickListener(new nk(this));
        }
        View findViewById2 = findViewById(R$id.title_navbar_share);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new mk(this));
        }
        View findViewById3 = findViewById(R$id.title_navbar_report);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new lk(this));
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void onHeaderInfoUpdate(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870329036")) {
            ipChange.ipc$dispatch("-870329036", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        initPageAction(obj);
        initBaseInfo(obj);
    }

    public abstract void onShareClick();

    public void report() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295322873")) {
            ipChange.ipc$dispatch("-295322873", new Object[]{this});
        } else if (this.actionAuth != null) {
            Action actionAuth2 = getActionAuth();
            DMNav.from(this).toUri(actionAuth2.getActionUrl());
            TrackInfo trackInfo = actionAuth2.getTrackInfo();
            if (trackInfo != null) {
                k21.h(trackInfo, "trackInfo");
                c.e().x(new a.b().i(trackInfo.getSpmb()).f(trackInfo.getSpmc()).l(trackInfo.getSpmd()).g(true).j(trackInfo.getArgs()));
            }
        }
    }

    public void setActionAuth(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935475664")) {
            ipChange.ipc$dispatch("935475664", new Object[]{this, action});
            return;
        }
        k21.i(action, "<set-?>");
        this.actionAuth = action;
    }

    public void setActionFollow(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23715047")) {
            ipChange.ipc$dispatch("23715047", new Object[]{this, action});
            return;
        }
        k21.i(action, "<set-?>");
        this.actionFollow = action;
    }

    public void setActionShare(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438440949")) {
            ipChange.ipc$dispatch("438440949", new Object[]{this, action});
            return;
        }
        k21.i(action, "<set-?>");
        this.actionShare = action;
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setDarkStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664574180")) {
            ipChange.ipc$dispatch("664574180", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(9216);
        View findViewById = findViewById(R$id.common_navbar_back);
        k21.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(ContextCompat.getColor(this, R$color.color_3C3F44));
    }

    public void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873935897")) {
            ipChange.ipc$dispatch("-1873935897", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
        }
        View findViewById2 = findViewById(R$id.nav_bar);
        ViewGroup.LayoutParams layoutParams = findViewById2 != null ? findViewById2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = findViewById.getLayoutParams().height + v50.a(this, 43.0f);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720344876")) {
            ipChange.ipc$dispatch("-720344876", new Object[]{this});
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(1024);
        View findViewById = findViewById(R$id.common_navbar_back);
        k21.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(ContextCompat.getColor(this, R$color.white));
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setNavBarColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497726649")) {
            ipChange.ipc$dispatch("1497726649", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View findViewById = findViewById(R$id.nav_bar);
        if (findViewById != null) {
            findViewById.setBackgroundColor(i);
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature
    public void setNavBarTitle(@NotNull String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1938303231")) {
            ipChange.ipc$dispatch("1938303231", new Object[]{this, str});
            return;
        }
        k21.i(str, "title");
        View findViewById = findViewById(R$id.main_title);
        TextView textView = findViewById instanceof TextView ? (TextView) findViewById : null;
        if (textView != null) {
            if (str.length() != 0) {
                z = false;
            }
            if (z) {
                i = 8;
            }
            textView.setVisibility(i);
            textView.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-262169893")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-262169893", new Object[]{this});
    }

    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890457904")) {
            ipChange.ipc$dispatch("1890457904", new Object[]{this});
            return;
        }
        onShareClick();
        shareUt();
    }

    public final void shareUt() {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2629457")) {
            ipChange.ipc$dispatch("2629457", new Object[]{this});
        } else if (this.actionShare != null && (trackInfo = getActionShare().getTrackInfo()) != null) {
            k21.h(trackInfo, "trackInfo");
            c e = c.e();
            a.b i = new a.b().i(trackInfo.getSpmb());
            String spmc = trackInfo.getSpmc();
            if (spmc == null) {
                spmc = "top";
            } else {
                k21.h(spmc, "info.spmc ?: \"top\"");
            }
            a.b f = i.f(spmc);
            String spmd = trackInfo.getSpmd();
            if (spmd == null) {
                spmd = "share";
            } else {
                k21.h(spmd, "info.spmd ?: \"share\"");
            }
            e.x(f.l(spmd).g(false).j(trackInfo.getArgs()));
        }
    }
}
