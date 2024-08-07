package cn.damai.category.category.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.ui.adapter.CategoryPagerAdapter;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.gr;
import tb.ig;
import tb.ne2;
import tb.p81;

@Deprecated
/* compiled from: Taobao */
public class CategoryActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_OPTION = "option";
    private static final int VALUE_BRAND = 2;
    private static final int VALUE_SHOW = 0;
    private static final int VALUE_STAR = 1;
    private BrandFragment mBrandFragment;
    private CategoryFragment mCatgoryFragment;
    private DamaiTabbarManager mDamaiTabbarManager;
    private CategoryRepository mData;
    public View mMentcengallView;
    private int mOption = 0;
    private CategoryPagerAdapter mPagerAdapter;
    private View mSearchBtn;
    private ScrollTitleBean mSelectTitle;
    private List<ScrollTitleBean> mTitleList;
    private EqualLinearView mTitleScroll;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    public class a implements TabbarLayout.TabBarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabClicked(TabItem tabItem) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1629870813")) {
                ipChange.ipc$dispatch("1629870813", new Object[]{this, tabItem});
            } else if (tabItem != null && (str = tabItem.tabText) != null && !"全部".equals(str)) {
                CategoryActivity.this.finish();
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabLongClicked(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1327093057")) {
                ipChange.ipc$dispatch("1327093057", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabReselected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2124857082")) {
                ipChange.ipc$dispatch("-2124857082", new Object[]{this, tabItem});
            }
        }

        @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
        public void onTabSelected(TabItem tabItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-407112429")) {
                ipChange.ipc$dispatch("-407112429", new Object[]{this, tabItem});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1370267618")) {
                ipChange.ipc$dispatch("1370267618", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && CategoryActivity.this.mViewPager != null) {
                CategoryActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-813409309")) {
                ipChange.ipc$dispatch("-813409309", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ig.m().q());
            DMNav.from(CategoryActivity.this).toUri(NavUri.b("home_search"));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changePage(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508116396")) {
            ipChange.ipc$dispatch("-508116396", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.mTitleScroll.selectTitle(i);
        CategoryRepository categoryRepository = this.mData;
        if (categoryRepository != null) {
            categoryRepository.tab = i;
            this.mSelectTitle = this.mTitleList.get(i);
            if (i == 0) {
                if (getCategoryFragment() != null && getCategoryFragment().mSelectTitle != null) {
                    getCategoryFragment().changePage(getCategoryFragment().mSelectTitle.index, z);
                }
            } else if (i != 1 && getMVPFragment() != null) {
                getMVPFragment().pageUtBuild();
                this.mData.isSkip = false;
            }
        }
    }

    private CategoryFragment getCategoryFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400538739")) {
            return (CategoryFragment) ipChange.ipc$dispatch("1400538739", new Object[]{this});
        }
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter == null) {
            return null;
        }
        Fragment b2 = categoryPagerAdapter.b();
        if (b2 instanceof CategoryFragment) {
            return (CategoryFragment) b2;
        }
        return null;
    }

    private DamaiBaseMvpFragment getMVPFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167896175")) {
            return (DamaiBaseMvpFragment) ipChange.ipc$dispatch("167896175", new Object[]{this});
        }
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter == null) {
            return null;
        }
        Fragment b2 = categoryPagerAdapter.b();
        if (b2 instanceof DamaiBaseMvpFragment) {
            return (DamaiBaseMvpFragment) b2;
        }
        return null;
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864976048")) {
            ipChange.ipc$dispatch("1864976048", new Object[]{this});
            return;
        }
        this.mData = new CategoryRepository();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            try {
                this.mOption = Integer.valueOf(extras.getString(KEY_OPTION, "0")).intValue();
                this.mData.categoryId = extras.getString("categoryId", "0");
                this.mData.type = Integer.valueOf(extras.getString("type", "3")).intValue();
                CategoryRepository categoryRepository = this.mData;
                if (categoryRepository.type == 0) {
                    categoryRepository.type = 3;
                }
                if (categoryRepository.type == 3) {
                    categoryRepository.isSkip = true;
                }
                categoryRepository.categoryName = extras.getString(ShowFragment.CATEGORYNAME_KEY, "全部");
            } catch (Exception unused) {
            }
            String str = null;
            if (extras.containsKey("topProjectId")) {
                str = extras.getString("topProjectId");
            }
            if (!TextUtils.isEmpty(str)) {
                this.mData.conditionEntity.projectIdList.clear();
                this.mData.conditionEntity.projectIdList.add(str);
            }
        }
        requestLocation();
    }

    private void initTabbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1066926420")) {
            ipChange.ipc$dispatch("1066926420", new Object[]{this});
            return;
        }
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, (TabbarLayout) findViewById(R$id.category_bottom_tab), new a());
        this.mDamaiTabbarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_CATEGORY);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485069440")) {
            ipChange.ipc$dispatch("-1485069440", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        this.mTitleScroll = (EqualLinearView) findViewById(R$id.scroll_title);
        this.mSearchBtn = findViewById(R$id.btn_search);
        this.mTitleList = new ArrayList();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
        scrollTitleBean.index = 0;
        scrollTitleBean.name = ErrControlViewInfo.TYPE_PROJECT;
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean();
        scrollTitleBean2.index = 1;
        scrollTitleBean2.name = "大咖";
        ScrollTitleBean scrollTitleBean3 = new ScrollTitleBean();
        scrollTitleBean3.index = 2;
        scrollTitleBean3.name = "品牌";
        this.mTitleList.add(scrollTitleBean);
        this.mTitleList.add(scrollTitleBean2);
        this.mTitleList.add(scrollTitleBean3);
        this.mTitleScroll.setFontColor(R$color.color_000000, R$color.color_9C9CA5).setFontSize(16, 20).setTitle(this.mTitleList).setHeight(44).setOnTitleClickListener(new b()).commit();
        this.mSearchBtn.setOnClickListener(new c());
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1017322106")) {
            ipChange.ipc$dispatch("1017322106", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.title_pager);
        ArrayList arrayList = new ArrayList();
        this.mCatgoryFragment = new CategoryFragment();
        this.mBrandFragment = new BrandFragment();
        arrayList.add(this.mCatgoryFragment);
        arrayList.add(this.mBrandFragment);
        this.mPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager(), arrayList);
        if (this.mViewPager != null) {
            setViewPaperItem(this.mOption);
            this.mViewPager.setAdapter(this.mPagerAdapter);
            int i = this.mOption;
            if (i == 0) {
                this.mViewPager.setCurrentItem(0);
                this.mTitleScroll.selectTitle(0);
                this.mData.tab = 0;
            } else if (i == 1) {
                this.mViewPager.setCurrentItem(1);
                this.mTitleScroll.selectTitle(1);
                this.mData.tab = 1;
            } else if (i == 2) {
                this.mViewPager.setCurrentItem(2);
                this.mTitleScroll.selectTitle(2);
                this.mData.tab = 2;
            }
            changePage(this.mOption, true);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class cn.damai.category.category.ui.CategoryActivity.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1673709294")) {
                        ipChange.ipc$dispatch("1673709294", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1905385075")) {
                        ipChange.ipc$dispatch("-1905385075", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "91477945")) {
                        ipChange.ipc$dispatch("91477945", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    CategoryActivity.this.changePage(i, true);
                }
            });
            this.mViewPager.setOffscreenPageLimit(3);
        }
    }

    private void requestLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950627716")) {
            ipChange.ipc$dispatch("1950627716", new Object[]{this});
            return;
        }
        double[] b2 = p81.b();
        if (b2 != null) {
            this.mData.conditionEntity.longitude = String.valueOf(b2[0]);
            this.mData.conditionEntity.latitude = String.valueOf(b2[1]);
        }
    }

    private void setViewPaperItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374440519")) {
            ipChange.ipc$dispatch("-1374440519", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            Field declaredField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this.mViewPager, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CategoryRepository getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-782003157")) {
            return this.mData;
        }
        return (CategoryRepository) ipChange.ipc$dispatch("-782003157", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1038608800")) {
            return R$layout.category_activty;
        }
        return ((Integer) ipChange.ipc$dispatch("1038608800", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189497581")) {
            ipChange.ipc$dispatch("189497581", new Object[]{this});
            return;
        }
        super.initView();
        initBundle();
        initTabbar();
        initTitle();
        this.mMentcengallView = findViewById(R$id.layout_mengceng_all);
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.category.category.ui.CategoryActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-426625072")) {
                    ipChange.ipc$dispatch("-426625072", new Object[]{this});
                } else if (!CategoryActivity.this.isFinishing()) {
                    CategoryActivity.this.initViewPager();
                    CategoryActivity.this.mViewPager.requestLayout();
                }
            }
        }, 100);
        cn.damai.common.user.c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        CategoryFragment categoryFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518808172")) {
            ipChange.ipc$dispatch("-518808172", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        CategoryFragment categoryFragment2 = this.mCatgoryFragment;
        if (categoryFragment2 != null && categoryFragment2.onInterceptLocationActivityResult(i, i2, intent)) {
            return;
        }
        if (this.mData == null) {
            DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
        } else if (i == 1005 && (categoryFragment = this.mCatgoryFragment) != null) {
            categoryFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511659212")) {
            ipChange.ipc$dispatch("1511659212", new Object[]{this});
            return;
        }
        DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376235347")) {
            ipChange.ipc$dispatch("-1376235347", new Object[]{this});
            return;
        }
        this.mData.isChediLikai = true;
        super.onDestroy();
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter != null) {
            categoryPagerAdapter.a();
            this.mPagerAdapter = null;
        }
        this.mCatgoryFragment = null;
        this.mCatgoryFragment = null;
        DamaiTabbarManager damaiTabbarManager = this.mDamaiTabbarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.p();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82220351")) {
            ipChange.ipc$dispatch("82220351", new Object[]{this, bundle});
            return;
        }
        super.onRestoreInstanceState(bundle);
        if (this.mCatgoryFragment == null || this.mData == null) {
            DMNav.from(this).setTransition(0, 0).toUri(NavUri.b(gr.n));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860324470")) {
            ipChange.ipc$dispatch("860324470", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.mData.isChediLikai && this.mSelectTitle != null) {
            cn.damai.common.user.c.e().m(this);
            changePage(this.mSelectTitle.index, false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885991425")) {
            ipChange.ipc$dispatch("1885991425", new Object[]{this});
            return;
        }
        super.onStop();
        CategoryRepository categoryRepository = this.mData;
        if (categoryRepository != null) {
            categoryRepository.isChediLikai = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1798338580")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1798338580", new Object[]{this});
    }
}
