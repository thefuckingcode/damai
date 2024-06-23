package cn.damai.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.message.observer.Action;
import cn.damai.mine.userinfo.fragment.MineUserCenterFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import tb.gr;
import tb.wd1;

/* compiled from: Taobao */
public class MineMainActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_WANT_SEE_SUB_TAB_INDEX = "key_want_see_sub_tab_index";
    private static final String KEY_WANT_SEE_TIPS = "key_want_see_tips_page_name";
    private DamaiTabbarManager mDamaiTabbarManager;
    private Fragment mMineFragment;
    private ArrayList<SelfOnTouchListener> mOnTouchListeners = new ArrayList<>();

    /* compiled from: Taobao */
    public interface SelfOnTouchListener {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: Taobao */
    public class a implements TabbarLayout.TabBarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(MineMainActivity mineMainActivity) {
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1546885801")) {
                ipChange.ipc$dispatch("1546885801", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabLongClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1972711667")) {
                ipChange.ipc$dispatch("-1972711667", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabReselected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-430187078")) {
                ipChange.ipc$dispatch("-430187078", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabSelected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1315319495")) {
                ipChange.ipc$dispatch("1315319495", new Object[]{this, tabItem});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Integer> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(Integer num) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "307355280")) {
                ipChange.ipc$dispatch("307355280", new Object[]{this, num});
            } else if (num != null && MineMainActivity.this.mDamaiTabbarManager != null) {
                DamaiTabbarManager damaiTabbarManager = MineMainActivity.this.mDamaiTabbarManager;
                if (num.intValue() <= 0) {
                    z = false;
                }
                damaiTabbarManager.u(DamaiConstants.TAB_MINE, z);
            }
        }
    }

    private void gotoHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682573798")) {
            ipChange.ipc$dispatch("1682573798", new Object[]{this});
            return;
        }
        DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
        finish();
    }

    private void initMessageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305363758")) {
            ipChange.ipc$dispatch("-305363758", new Object[]{this});
            return;
        }
        this.mDMMessage.b(wd1.NOTIFY_UPDATE_BADGE_DATA, new b());
    }

    private void initTabbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083764663")) {
            ipChange.ipc$dispatch("-2083764663", new Object[]{this});
            return;
        }
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, (TabbarLayout) findViewById(R$id.mine_activity_bottomsheet_container), new a(this));
        this.mDamaiTabbarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_MINE);
    }

    private void replaceFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416589593")) {
            ipChange.ipc$dispatch("-1416589593", new Object[]{this, fragment});
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.mine_activity_container, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    private void setArguments(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166045504")) {
            ipChange.ipc$dispatch("1166045504", new Object[]{this, intent});
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("pageKey");
        String stringExtra = intent.getStringExtra(KEY_WANT_SEE_TIPS);
        String stringExtra2 = intent.getStringExtra(KEY_WANT_SEE_SUB_TAB_INDEX);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            bundleExtra.putString("pageName", stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            try {
                bundleExtra.putInt(KEY_WANT_SEE_SUB_TAB_INDEX, Integer.parseInt(stringExtra2));
            } catch (NumberFormatException unused) {
                bundleExtra.putInt(KEY_WANT_SEE_SUB_TAB_INDEX, 0);
            }
        }
        Fragment fragment = this.mMineFragment;
        if (fragment != null) {
            fragment.setArguments(bundleExtra);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "974709567")) {
            ipChange.ipc$dispatch("974709567", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77511333")) {
            return ((Boolean) ipChange.ipc$dispatch("-77511333", new Object[]{this, motionEvent})).booleanValue();
        }
        Iterator<SelfOnTouchListener> it = this.mOnTouchListeners.iterator();
        while (it.hasNext()) {
            it.next().onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2143534261")) {
            return R$layout.mine_main_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("-2143534261", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407915920")) {
            ipChange.ipc$dispatch("407915920", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131352731")) {
            ipChange.ipc$dispatch("1131352731", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575045410")) {
            ipChange.ipc$dispatch("575045410", new Object[]{this});
            return;
        }
        hideBaseLayout();
        Intent intent = getIntent();
        this.mMineFragment = new MineUserCenterFragment();
        setArguments(intent);
        replaceFragment(this.mMineFragment);
        initTabbar();
        initMessageData();
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1488892343")) {
            ipChange.ipc$dispatch("1488892343", new Object[]{this});
            return;
        }
        gotoHomePage();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110170072")) {
            ipChange.ipc$dispatch("1110170072", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        wd1.a = wd1.b;
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985812760")) {
            ipChange.ipc$dispatch("1985812760", new Object[]{this});
            return;
        }
        super.onDestroy();
        DamaiTabbarManager damaiTabbarManager = this.mDamaiTabbarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.p();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650466495")) {
            ipChange.ipc$dispatch("1650466495", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073814390")) {
            ipChange.ipc$dispatch("1073814390", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869214707")) {
            ipChange.ipc$dispatch("1869214707", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        DamaiTabbarManager damaiTabbarManager = this.mDamaiTabbarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.l();
        }
        setArguments(intent);
    }

    public void registerMyOnTouchListener(SelfOnTouchListener selfOnTouchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486231883")) {
            ipChange.ipc$dispatch("-486231883", new Object[]{this, selfOnTouchListener});
            return;
        }
        this.mOnTouchListeners.add(selfOnTouchListener);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1476725375")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1476725375", new Object[]{this});
    }

    public void unregisterMyOnTouchListener(SelfOnTouchListener selfOnTouchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119134140")) {
            ipChange.ipc$dispatch("119134140", new Object[]{this, selfOnTouchListener});
            return;
        }
        this.mOnTouchListeners.remove(selfOnTouchListener);
    }
}
