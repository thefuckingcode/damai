package cn.damai.homepage.v2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.AppConfig;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.TabExtra;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g91;
import tb.k21;
import tb.m40;
import tb.s41;

/* compiled from: Taobao */
public final class ChannelPageActivity extends DamaiBaseActivity<cn.damai.common.app.base.a<Object, Object>, BaseModel> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static final int LOGIN_RESULT = 1008;
    @Nullable
    private ChannelPageTabFragment mChannelTabFragment;
    @Nullable
    private String mCurrentCity;
    @Nullable
    private TabExtra mTabExtra;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void addFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155981608")) {
            ipChange.ipc$dispatch("1155981608", new Object[]{this, fragment});
        } else if (fragment != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            k21.h(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            k21.h(beginTransaction, "fm.beginTransaction()");
            beginTransaction.replace(R$id.channel_fragment_container, fragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private final void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980188311")) {
            ipChange.ipc$dispatch("1980188311", new Object[]{this});
        } else if (getIntent() != null) {
            this.mTabExtra = TabExtra.fromIntent(getIntent());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491577167")) {
            ipChange.ipc$dispatch("-491577167", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "315221657")) {
            return R$layout.channel_page_activity_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("315221657", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680061950")) {
            ipChange.ipc$dispatch("-680061950", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763777129")) {
            ipChange.ipc$dispatch("1763777129", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034309268")) {
            ipChange.ipc$dispatch("1034309268", new Object[]{this});
            return;
        }
        hideBaseLayout();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690675418")) {
            ipChange.ipc$dispatch("-690675418", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        cn.damai.commonbusiness.pageut.a.i(this);
        c.e().K(this);
        initBundle();
        Bundle bundle2 = new Bundle();
        TabExtra tabExtra = this.mTabExtra;
        if (tabExtra != null) {
            k21.f(tabExtra);
            if (tabExtra.isValidExtra()) {
                bundle2.putParcelable("extra_key", this.mTabExtra);
            }
        }
        ChannelPageTabFragment channelPageTabFragment = new ChannelPageTabFragment();
        this.mChannelTabFragment = channelPageTabFragment;
        channelPageTabFragment.setArguments(bundle2);
        addFragment(this.mChannelTabFragment);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956876826")) {
            ipChange.ipc$dispatch("-956876826", new Object[]{this});
            return;
        }
        super.onDestroy();
        cn.damai.commonbusiness.pageut.a.j(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(@Nullable Intent intent) {
        ChannelPageTabFragment channelPageTabFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924533569")) {
            ipChange.ipc$dispatch("1924533569", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            TabExtra fromIntent = TabExtra.fromIntent(intent);
            this.mTabExtra = fromIntent;
            k21.f(fromIntent);
            if (fromIntent.isValidExtra() && (channelPageTabFragment = this.mChannelTabFragment) != null) {
                channelPageTabFragment.setSelectTab(this.mTabExtra);
            }
            if (AppConfig.v()) {
                g91.c("IntentTest", "onNewIntent tabExtra :" + s41.e(this.mTabExtra));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248775978")) {
            ipChange.ipc$dispatch("1248775978", new Object[]{this});
            return;
        }
        super.onPause();
        cn.damai.commonbusiness.pageut.a.a(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705136157")) {
            ipChange.ipc$dispatch("1705136157", new Object[]{this});
            return;
        }
        super.onResume();
        cn.damai.commonbusiness.pageut.a.b(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    @Nullable
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "89378125")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("89378125", new Object[]{this});
    }
}
