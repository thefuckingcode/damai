package cn.damai.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.ui.adapter.SearchAccountAdapter;
import cn.damai.search.ui.fragment.SearchAccountFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.indicator.PagerIndicator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.c62;
import tb.xf2;

/* compiled from: Taobao */
public class SearchAccountActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> mBAccountInfoList = new ArrayList();
    private int mCurrentIndex;
    private String mCurrentType;
    private SearchAccountFragment[] mFragments;
    private String mKeyWord = "";
    private PagerIndicator mPagerIndicator;
    private TextView mTitleTv;
    private String[] mTitles;
    private DMIconFontTextView mTvBack;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-308012008")) {
                ipChange.ipc$dispatch("-308012008", new Object[]{this, view});
                return;
            }
            SearchAccountActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements PagerIndicator.TabViewFactory {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.indicator.PagerIndicator.TabViewFactory
        public void addTabs(ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371083647")) {
                ipChange.ipc$dispatch("-1371083647", new Object[]{this, viewGroup, Integer.valueOf(i)});
                return;
            }
            viewGroup.removeAllViews();
            for (int i2 = 0; i2 < SearchAccountActivity.this.mTitles.length; i2++) {
                View inflate = LayoutInflater.from(SearchAccountActivity.this).inflate(R$layout.item_text_tab, viewGroup, false);
                ((TextView) inflate.findViewById(R$id.tabName)).setText(SearchAccountActivity.this.mTitles[i2]);
                viewGroup.addView(inflate);
            }
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316015616")) {
            ipChange.ipc$dispatch("-1316015616", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle bundle = null;
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            this.mCurrentType = bundle.getString("type", "2");
            this.mCurrentIndex = bundle.getInt("index", 0);
            this.mKeyWord = bundle.getString("keyword", "");
            this.mBAccountInfoList.clear();
            if (bundle.containsKey("data")) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("data");
                if (xf2.e(stringArrayList) > 0) {
                    this.mBAccountInfoList.addAll(stringArrayList);
                }
            }
        }
    }

    private void loadPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100620699")) {
            ipChange.ipc$dispatch("-1100620699", new Object[]{this});
            return;
        }
        int e = xf2.e(this.mBAccountInfoList);
        this.mTitles = new String[e];
        this.mFragments = new SearchAccountFragment[e];
        for (int i = 0; i < e; i++) {
            this.mTitles[i] = SearchHelper.n(this.mBAccountInfoList.get(i));
            this.mFragments[i] = SearchAccountFragment.newInstance(this.mBAccountInfoList.get(i), this.mKeyWord);
        }
        if (e <= 1) {
            this.mPagerIndicator.setVisibility(8);
            TextView textView = this.mTitleTv;
            textView.setText("相关" + SearchHelper.n(this.mCurrentType));
        } else {
            this.mPagerIndicator.setVisibility(0);
            this.mTitleTv.setText("相关结果");
        }
        this.mViewPager.setAdapter(new SearchAccountAdapter(this, this.mTitles, this.mFragments));
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setCurrentItem(this.mCurrentIndex);
        this.mPagerIndicator.setViewPager(this.mViewPager);
        this.mPagerIndicator.setTabViewFactory(new b());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "970617410")) {
            ipChange.ipc$dispatch("970617410", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-500687256")) {
            return R$layout.activity_search_baccout;
        }
        return ((Integer) ipChange.ipc$dispatch("-500687256", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203434477")) {
            ipChange.ipc$dispatch("-203434477", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640640392")) {
            ipChange.ipc$dispatch("-640640392", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989984549")) {
            ipChange.ipc$dispatch("1989984549", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        this.mPagerIndicator = (PagerIndicator) findViewById(R$id.indicator);
        this.mTvBack = (DMIconFontTextView) findViewById(R$id.tv_back);
        this.mTitleTv = (TextView) findViewById(R$id.tv_title);
        this.mTvBack.setOnClickListener(new a());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-499131659")) {
            ipChange.ipc$dispatch("-499131659", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initData();
        loadPage();
        setDamaiUTKeyBuilder(c62.C().D(this.mKeyWord));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039116098")) {
            ipChange.ipc$dispatch("1039116098", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578305901")) {
            ipChange.ipc$dispatch("-1578305901", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1685106396")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1685106396", new Object[]{this});
    }
}
