package cn.damai.mine.mycollect.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$array;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.login.LoginManager;
import cn.damai.mine.fragment.Wanna2SeeFragment;
import cn.damai.mine.mycollect.ui.adapter.MyCollectTitleAdapter;
import cn.damai.mine.mycollect.ui.fragment.MyCollectFragment;
import cn.damai.mine.mycollect.ui.fragment.MyJoinFragment;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.bk2;
import tb.ig1;
import tb.ne2;

/* compiled from: Taobao */
public class MyCollectActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private MyJoinFragment mJoinFragment;
    private Wanna2SeeFragment mMyLiveFragment;
    private MyCollectTitleAdapter mPagerAdapter;
    private EqualLinearView mTitleScroll;
    private String[] mTitles;
    private ViewPager mViewPager;
    private MyCollectFragment myCollectFragment;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1800619511")) {
                ipChange.ipc$dispatch("1800619511", new Object[]{this, view});
                return;
            }
            MyCollectActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-383057416")) {
                ipChange.ipc$dispatch("-383057416", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && MyCollectActivity.this.mViewPager != null) {
                MyCollectActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    private void initPageHeadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598536075")) {
            ipChange.ipc$dispatch("-598536075", new Object[]{this});
            return;
        }
        this.mTitleScroll = (EqualLinearView) findViewById(R$id.scroll_title);
        this.mTitles = bk2.a(this, R$array.collect_title);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        int length = this.mTitles.length;
        for (int i = 0; i < length; i++) {
            ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
            scrollTitleBean.index = i;
            scrollTitleBean.name = this.mTitles[i];
            arrayList.add(scrollTitleBean);
        }
        this.mTitleScroll.setFontColor(R$color.color_000000, R$color.color_666666).setFontSize(16, 16).setTitle(arrayList).setHeight(44).setOnTitleClickListener(new b()).commit();
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988341276")) {
            ipChange.ipc$dispatch("-988341276", new Object[]{this});
            return;
        }
        findViewById(R$id.icon_left_icon).setOnClickListener(new a());
        ((TextView) findViewById(R$id.tv_header_title)).setText("想看的演出");
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = ne2.a(this);
            findViewById.setVisibility(0);
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608683197")) {
            ipChange.ipc$dispatch("-1608683197", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.title_pager);
        ArrayList arrayList = new ArrayList();
        this.myCollectFragment = new MyCollectFragment();
        this.mMyLiveFragment = new Wanna2SeeFragment();
        this.mJoinFragment = new MyJoinFragment();
        arrayList.add(this.myCollectFragment);
        arrayList.add(this.mMyLiveFragment);
        arrayList.add(this.mJoinFragment);
        MyCollectTitleAdapter myCollectTitleAdapter = new MyCollectTitleAdapter(getSupportFragmentManager(), arrayList);
        this.mPagerAdapter = myCollectTitleAdapter;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(myCollectTitleAdapter);
            this.mTitleScroll.selectTitle(0);
            this.mViewPager.setCurrentItem(0);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class cn.damai.mine.mycollect.ui.MyCollectActivity.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1549044281")) {
                        ipChange.ipc$dispatch("1549044281", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-686727208")) {
                        ipChange.ipc$dispatch("-686727208", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-707253052")) {
                        ipChange.ipc$dispatch("-707253052", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    MyCollectActivity.this.mTitleScroll.selectTitle(i);
                    if (i == 0) {
                        c.e().x(ig1.m().p(0, MyCollectActivity.this.mTitles[0]));
                    } else {
                        c.e().x(ig1.m().p(1, MyCollectActivity.this.mTitles[1]));
                    }
                }
            });
            this.mViewPager.setOffscreenPageLimit(2);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "879451817")) {
            return R$layout.activty_my_collect;
        }
        return ((Integer) ipChange.ipc$dispatch("879451817", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723103612")) {
            ipChange.ipc$dispatch("-723103612", new Object[]{this});
            return;
        }
        super.initView();
        hideBaseLayout();
        initTitleView();
        initPageHeadView();
        initViewPager();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        MyCollectFragment myCollectFragment2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324103829")) {
            ipChange.ipc$dispatch("-1324103829", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            MyJoinFragment myJoinFragment = this.mJoinFragment;
            if (myJoinFragment != null) {
                myJoinFragment.refreshData();
            }
        } else if (i == 1001 && (myCollectFragment2 = this.myCollectFragment) != null) {
            myCollectFragment2.refreshData();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092909366")) {
            ipChange.ipc$dispatch("1092909366", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(ig1.m().j());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52276723")) {
            ipChange.ipc$dispatch("-52276723", new Object[]{this});
            return;
        }
        super.onResume();
        if (!LoginManager.k().q()) {
            ToastUtil.a().j(this, getString(R$string.mine_login_state_error));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1329993379")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1329993379", new Object[]{this});
    }
}
