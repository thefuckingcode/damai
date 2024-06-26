package cn.damai.trade.newtradeorder.ui.orderlist.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.trade.R$array;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter.OrderListPagerAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.pictures.bricks.myorder.fragment.MyOrderFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.bk2;
import tb.d20;
import tb.gr;
import tb.ln2;
import tb.ne2;
import tb.pp2;

/* compiled from: Taobao */
public class OrderListActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String mFromWhere = "damai";
    private final int BACK_PAGE = 1;
    private final int TO_HOME_PAGE = 2;
    private final int TO_MINE = 0;
    private int defaultSelectedIndex = 0;
    private int mCurrentPage;
    private int mFromPage = 0;
    private Fragment[] mOrderFragments;
    private OrderListPagerAdapter mPageAdapter;
    private EqualLinearView mTabView;
    private String[] mTitles;
    private DMIconFontTextView mTvBack;
    public String mUserCode;
    private ViewPager mViewPager;
    private MyOrderFragment scriptMurderOrderFragment;
    private ShowOrderListFragment showOrderListFragment;

    /* compiled from: Taobao */
    public class OrderListPageChangeListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        OrderListPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-184552666")) {
                ipChange.ipc$dispatch("-184552666", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1512634939")) {
                ipChange.ipc$dispatch("-1512634939", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1682413071")) {
                ipChange.ipc$dispatch("-1682413071", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            OrderListActivity.this.mTabView.selectTitle(i);
            if (OrderListActivity.this.mOrderFragments != null && i < OrderListActivity.this.mOrderFragments.length) {
                OrderListActivity.this.mCurrentPage = i;
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "526668190")) {
                ipChange.ipc$dispatch("526668190", new Object[]{this, view});
                return;
            }
            OrderListActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1657008737")) {
                ipChange.ipc$dispatch("-1657008737", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && OrderListActivity.this.mViewPager != null) {
                OrderListActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    private Fragment getCurrentFragment() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920208351")) {
            return (Fragment) ipChange.ipc$dispatch("-1920208351", new Object[]{this});
        }
        Fragment[] fragmentArr = this.mOrderFragments;
        if (fragmentArr != null && (i = this.mCurrentPage) < fragmentArr.length) {
            return fragmentArr[i];
        }
        return null;
    }

    private void handleIntent(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552117881")) {
            ipChange.ipc$dispatch("552117881", new Object[]{this, intent});
        } else if (intent != null && intent.getExtras() != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("sRemind")) {
                this.mFromPage = 2;
            } else if (extras.containsKey("backPage")) {
                this.mFromPage = 1;
            }
            this.defaultSelectedIndex = "jubensha".equals(extras.getString("pageType")) ? 1 : 0;
            ShowOrderListFragment showOrderListFragment2 = new ShowOrderListFragment();
            this.showOrderListFragment = showOrderListFragment2;
            showOrderListFragment2.setArguments(extras);
            MyOrderFragment myOrderFragment = new MyOrderFragment();
            this.scriptMurderOrderFragment = myOrderFragment;
            myOrderFragment.setArguments(extras);
        }
    }

    private void initOrderPage() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1430137149")) {
            ipChange.ipc$dispatch("1430137149", new Object[]{this});
            return;
        }
        int i2 = this.defaultSelectedIndex;
        this.mUserCode = d20.E();
        Fragment[] fragmentArr = {this.showOrderListFragment, this.scriptMurderOrderFragment};
        this.mOrderFragments = fragmentArr;
        OrderListPagerAdapter orderListPagerAdapter = new OrderListPagerAdapter(this, this.mTitles, fragmentArr);
        this.mPageAdapter = orderListPagerAdapter;
        this.mViewPager.setAdapter(orderListPagerAdapter);
        this.mViewPager.addOnPageChangeListener(new OrderListPageChangeListener());
        this.mViewPager.setOffscreenPageLimit(1);
        if (i2 < this.mPageAdapter.getCount()) {
            i = i2;
        }
        this.mViewPager.setCurrentItem(i);
        this.mTabView.selectTitle(i);
    }

    private void initTitleStatusBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672074411")) {
            ipChange.ipc$dispatch("1672074411", new Object[]{this, view});
        } else if (view != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                view.getLayoutParams().height = ne2.a(this);
                view.setVisibility(0);
                ne2.f(this, true, R$color.black);
                ne2.d(true, this);
                return;
            }
            ne2.f(this, false, R$color.black);
            view.setVisibility(8);
        }
    }

    private void setupTabsView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133370186")) {
            ipChange.ipc$dispatch("1133370186", new Object[]{this});
            return;
        }
        this.mTitles = bk2.a(this, R$array.order_tab_title);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        int length = this.mTitles.length;
        for (int i = 0; i < length; i++) {
            ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
            scrollTitleBean.index = i;
            scrollTitleBean.name = this.mTitles[i];
            arrayList.add(scrollTitleBean);
        }
        this.mTabView.setFontColor(R$color.color_000000, R$color.color_9C9CA5).setFontSize(16, 16).setTitle(arrayList).setHeight(44).setOnTitleClickListener(new b()).commit();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380597960")) {
            ipChange.ipc$dispatch("1380597960", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1057412130")) {
            return R$layout.order_list_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("1057412130", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853006233")) {
            ipChange.ipc$dispatch("853006233", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044250546")) {
            ipChange.ipc$dispatch("2044250546", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164727381")) {
            ipChange.ipc$dispatch("-164727381", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initTitleStatusBar(findViewById(R$id.title_bar_space));
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.tv_back);
        this.mTvBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new a());
        this.mTabView = (EqualLinearView) findViewById(R$id.indicator);
        setupTabsView();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2132271826")) {
            ipChange.ipc$dispatch("2132271826", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (getCurrentFragment() != null) {
            getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893177138")) {
            ipChange.ipc$dispatch("-1893177138", new Object[]{this});
            return;
        }
        int i = this.mFromPage;
        if (i == 0) {
            pp2.b().q(this, pp2.SCHEME_MINEPAGE);
            finish();
        } else if (i == 1) {
            finish();
        } else if (i == 2) {
            DMNav.from(this).toUri(NavUri.b(gr.n));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021645487")) {
            ipChange.ipc$dispatch("2021645487", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        handleIntent(getIntent());
        initOrderPage();
        setDamaiUTKeyBuilder(ln2.r().Y0());
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527692719")) {
            ipChange.ipc$dispatch("527692719", new Object[]{this});
            return;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538259402")) {
            ipChange.ipc$dispatch("538259402", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment instanceof ShowOrderListFragment) {
            ((ShowOrderListFragment) currentFragment).onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1348065046")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1348065046", new Object[]{this});
    }
}
