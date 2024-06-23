package cn.damai.yymember;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.h5container.DMH5Fragment;
import cn.damai.h5container.UniH5ContainerSwitcher;
import cn.damai.h5container.WebViewFragment;
import cn.damai.h5container.WebViewUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.WebView;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import tb.gr;
import tb.h03;
import tb.ne2;
import tb.ur2;

/* compiled from: Taobao */
public class YYMemberTabActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private Fragment mFragment;
    private DamaiTabbarManager mTabBarManager;
    private boolean useNewContainer = false;

    /* compiled from: Taobao */
    public class a implements Function2<WebView, String, ur2> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public ur2 invoke(WebView webView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "799415105")) {
                return (ur2) ipChange.ipc$dispatch("799415105", new Object[]{this, webView, str});
            }
            YYMemberTabActivity.this.stopProgressDialog();
            return null;
        }
    }

    /* compiled from: Taobao */
    public class b implements WebViewFragment.LoadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.h5container.WebViewFragment.LoadListener
        public void onLoadFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1403613053")) {
                ipChange.ipc$dispatch("-1403613053", new Object[]{this});
                return;
            }
            YYMemberTabActivity.this.stopProgressDialog();
        }
    }

    /* compiled from: Taobao */
    public class c implements TabbarLayout.TabBarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(YYMemberTabActivity yYMemberTabActivity) {
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-621774351")) {
                ipChange.ipc$dispatch("-621774351", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabLongClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1785279915")) {
                ipChange.ipc$dispatch("-1785279915", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabReselected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2086708878")) {
                ipChange.ipc$dispatch("-2086708878", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabSelected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1488635777")) {
                ipChange.ipc$dispatch("-1488635777", new Object[]{this, tabItem});
            }
        }
    }

    private void initStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555999980")) {
            ipChange.ipc$dispatch("1555999980", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        if (Build.VERSION.SDK_INT >= 23) {
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314867189")) {
            ipChange.ipc$dispatch("314867189", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-329494827")) {
            return R$layout.activity_yy_member_tab;
        }
        return ((Integer) ipChange.ipc$dispatch("-329494827", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808563526")) {
            ipChange.ipc$dispatch("808563526", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666526629")) {
            ipChange.ipc$dispatch("666526629", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046504920")) {
            ipChange.ipc$dispatch("2046504920", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        String i = h03.i();
        String stringExtra = getIntent().getStringExtra("scrollToModule");
        if (!TextUtils.isEmpty(stringExtra)) {
            HashMap hashMap = new HashMap();
            hashMap.put("scrollToModule", stringExtra);
            i = WebViewUtil.appendQueryParameter(i, hashMap);
        }
        bundle.putString("url", i);
        this.useNewContainer = UniH5ContainerSwitcher.Companion.getInstance().shouldInterceptUrl(i);
        initStatusBar();
        if (this.useNewContainer) {
            this.mFragment = new DMH5Fragment();
        } else {
            this.mFragment = new WebViewFragment();
        }
        this.mFragment.setArguments(bundle);
        Fragment fragment = this.mFragment;
        if (fragment instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment).setPageLoadFinishListener(new a());
        } else if (fragment instanceof WebViewFragment) {
            ((WebViewFragment) fragment).setListener(new b());
        }
        getSupportFragmentManager().beginTransaction().replace(R$id.yy_member_fragment_container, this.mFragment).commitAllowingStateLoss();
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, (TabbarLayout) findViewById(R$id.yy_member_fragment_tabbar), new c(this));
        this.mTabBarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_HUIYUAN);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622158913")) {
            ipChange.ipc$dispatch("-1622158913", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1024066241")) {
            ipChange.ipc$dispatch("1024066241", new Object[]{this});
            return;
        }
        Fragment fragment = this.mFragment;
        if (fragment instanceof DMH5Fragment) {
            z = ((DMH5Fragment) fragment).onBackPressed();
        } else {
            z = fragment instanceof WebViewFragment ? ((WebViewFragment) fragment).backPressed() : false;
        }
        if (!z) {
            DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356417314")) {
            ipChange.ipc$dispatch("356417314", new Object[]{this});
            return;
        }
        super.onDestroy();
        DamaiTabbarManager damaiTabbarManager = this.mTabBarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.p();
        }
        this.mFragment = null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790462083")) {
            ipChange.ipc$dispatch("-790462083", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        DamaiTabbarManager damaiTabbarManager = this.mTabBarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.l();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577635487")) {
            ipChange.ipc$dispatch("-1577635487", new Object[]{this});
            return;
        }
        super.onResume();
        Fragment fragment = this.mFragment;
        if (fragment != null && (fragment instanceof DMH5Fragment)) {
            ((DMH5Fragment) fragment).hideTitleBar();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-369288055")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-369288055", new Object[]{this});
    }
}
