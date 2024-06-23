package cn.damai.search.v2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.a;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$raw;
import cn.damai.onearch.errpage.ErrorControlView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.bean.SearchExtra;
import cn.damai.search.v2.bean.SearchResultTabBean;
import cn.damai.search.v2.fragment.SearchHistoryFragment;
import cn.damai.search.v2.listener.ISearchUIController;
import cn.damai.search.v2.listener.OnEggListener;
import cn.damai.search.v2.listener.OnHisWordClickListener;
import cn.damai.search.v2.listener.OnSearchInputListener;
import cn.damai.search.v2.listener.SearchInputObserver;
import cn.damai.search.v2.tool.SearchEggManager;
import cn.damai.search.v2.tool.SearchInputManager;
import cn.damai.search.v2.view.DownFocusViewFlipper;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.tabs.TabLayout;
import com.taobao.weex.ui.component.helper.SoftKeyboardDetector;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.BaseViewPagerAdapter;
import com.youku.arch.v3.page.GenericActivity;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.d62;
import tb.ee0;
import tb.g91;
import tb.in0;
import tb.ol1;
import tb.u52;

/* compiled from: Taobao */
public final class SearchActivity extends GenericActivity implements ErrorControlView, ISearchUIController, TabLayout.OnTabSelectedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAGE_SEARCH_EGG_INDEX = 3;
    public static final int PAGE_SEARCH_HISTORY_INDEX = 0;
    public static final int PAGE_SEARCH_RESULT_INDEX = 2;
    public static final int PAGE_SUGGEST_WORD_INDEX = 1;
    private volatile boolean isSearchResultPageInitiated = false;
    private SearchEggManager mEggManager;
    private ee0 mErrControlImpl;
    private SearchInputObserver mHistoryObserver;
    private SearchInputManager mInputManager;
    private ViewGroup mTabUi;
    public a.b mUTBuilder;
    private DownFocusViewFlipper pageContainer;
    private TabLayout searchResultTabLayout;

    /* compiled from: Taobao */
    public final class SearchResultTabRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        private SearchResultTabRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        public IRequest build(Map<String, ?> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606973387")) {
                return (IRequest) ipChange.ipc$dispatch("1606973387", new Object[]{this, map});
            }
            Uri parse = Uri.parse("android.resource://" + SearchActivity.this.getPackageName() + "/" + R$raw.damai_search_result_tab_list);
            Bundle bundle = new Bundle();
            bundle.putParcelable("uri", parse);
            Request build = new Request.Builder().setStrategy(Constants.RequestStrategy.LOCAL_FILE).setRequestId(IdGenerator.getId()).setDataParams(new HashMap()).build();
            build.setBundle(bundle);
            return build;
        }

        /* synthetic */ SearchResultTabRequestBuilder(SearchActivity searchActivity, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class a implements DownFocusViewFlipper.OnDispatchDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.search.v2.view.DownFocusViewFlipper.OnDispatchDownListener
        public void onDispatchDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "380818637")) {
                ipChange.ipc$dispatch("380818637", new Object[]{this});
            } else if (SoftKeyboardDetector.isKeyboardVisible(SearchActivity.this)) {
                SoftInputUtils.a(SearchActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnSearchInputListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements OnEggListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ InputInfo a;

            a(InputInfo inputInfo) {
                this.a = inputInfo;
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void onEggFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1305911271")) {
                    ipChange.ipc$dispatch("-1305911271", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                SearchActivity.this.mHistoryObserver.dispatchInputWord(this.a);
                if (!z) {
                    SearchActivity.this.confirmSearchWordForSearchResult(this.a);
                }
                d62.s(this.a);
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void showLoading(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "488402623")) {
                    ipChange.ipc$dispatch("488402623", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                SearchActivity.this.showDialogLoading(z);
                if (!z) {
                    SearchActivity.this.pageContainer.setVisibility(0);
                }
            }
        }

        b() {
        }

        @Override // cn.damai.search.v2.listener.OnSearchInputListener
        public void onSearchInputClick(InputInfo inputInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1493590813")) {
                ipChange.ipc$dispatch("1493590813", new Object[]{this, inputInfo});
            } else if (SearchActivity.this.mEggManager != null) {
                SearchActivity.this.mEggManager.i(inputInfo.inputText, new a(inputInfo));
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements OnHisWordClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements OnEggListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void onEggFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1094560358")) {
                    ipChange.ipc$dispatch("-1094560358", new Object[]{this, Boolean.valueOf(z)});
                } else if (!z) {
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.confirmSearchWordForSearchResult(searchActivity.mInputManager.getCurrentInputInfo());
                }
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void showLoading(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "699753536")) {
                    ipChange.ipc$dispatch("699753536", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                SearchActivity.this.showDialogLoading(z);
            }
        }

        c() {
        }

        @Override // cn.damai.search.v2.listener.OnHisWordClickListener
        public void onHistoryWordClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "217093368")) {
                ipChange.ipc$dispatch("217093368", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            SearchActivity.this.mInputManager.m(str);
            SearchActivity.this.mEggManager.i(str, new a());
        }
    }

    private void addSearchResultTabView(CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478783432")) {
            ipChange.ipc$dispatch("-1478783432", new Object[]{this, charSequence, Integer.valueOf(i)});
            return;
        }
        TabLayout.Tab tabAt = this.searchResultTabLayout.getTabAt(i);
        TextView textView = new TextView(this);
        textView.setText(charSequence);
        textView.setGravity(17);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(getResources().getColor(R$color.color_999999));
        if (tabAt != null) {
            tabAt.setCustomView(textView);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void confirmSearchWordForSearchResult(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338330306")) {
            ipChange.ipc$dispatch("338330306", new Object[]{this, inputInfo});
            return;
        }
        this.pageContainer.setDisplayedChild(2);
        if (!this.isSearchResultPageInitiated) {
            load(new HashMap());
            return;
        }
        int tabCount = this.searchResultTabLayout.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                View customView = this.searchResultTabLayout.getTabAt(i).getCustomView();
                if (customView instanceof TextView) {
                    d62.i(customView, i, ((TextView) customView).getText().toString(), this.mInputManager.getCurrentInputInfo());
                }
            }
        }
        SearchResultViewPagerAdapter searchResultViewPagerAdapter = (SearchResultViewPagerAdapter) getViewPagerAdapter();
        for (int i2 = 0; i2 < getViewPagerAdapter().getFragments().size(); i2++) {
            WeakReference<Fragment> valueAt = searchResultViewPagerAdapter.getFragments().valueAt(i2);
            if (valueAt.get() != null && (valueAt.get() instanceof SearchInputObserver)) {
                ((SearchInputObserver) valueAt.get()).dispatchInputWord(inputInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$onTabDataLoaded$0(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929184710")) {
            return ipChange.ipc$dispatch("-1929184710", new Object[]{this, list});
        }
        this.searchResultTabLayout.setupWithViewPager(getViewPager());
        this.searchResultTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        getViewPager().setOffscreenPageLimit(list.size());
        ((SearchResultViewPagerAdapter) getViewPagerAdapter()).setDataset(list);
        ((SearchResultViewPagerAdapter) getViewPagerAdapter()).notifyDataSetChanged();
        for (int i = 0; i < list.size(); i++) {
            addSearchResultTabView(((SearchResultTabBean) list.get(i)).title, i);
        }
        if (this.searchResultTabLayout.getTabCount() <= 0) {
            return null;
        }
        this.isSearchResultPageInitiated = true;
        confirmSearchWordForSearchResult(this.mInputManager.getCurrentInputInfo());
        TabLayout.Tab tabAt = this.searchResultTabLayout.getTabAt(0);
        if (tabAt == null) {
            return null;
        }
        onTabSelected(tabAt);
        return null;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    @Nullable
    public ViewGroup getErrContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-142855944")) {
            return this.mTabUi;
        }
        return (ViewGroup) ipChange.ipc$dispatch("-142855944", new Object[]{this});
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    @Nullable
    public Activity getErrContainerActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "901599354")) {
            return this;
        }
        return (Activity) ipChange.ipc$dispatch("901599354", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1945287341")) {
            return R$layout.activity_search_v2;
        }
        return ((Integer) ipChange.ipc$dispatch("-1945287341", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1771187743")) {
            return "search_home";
        }
        return (String) ipChange.ipc$dispatch("-1771187743", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1007257046")) {
            return new SearchResultTabRequestBuilder(this, null);
        }
        return (RequestBuilder) ipChange.ipc$dispatch("1007257046", new Object[]{this});
    }

    public SearchInputManager getSearchInputManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1844877180")) {
            return this.mInputManager;
        }
        return (SearchInputManager) ipChange.ipc$dispatch("1844877180", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity
    public int getViewPagerResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "776801295")) {
            return R$id.search_v2_search_result;
        }
        return ((Integer) ipChange.ipc$dispatch("776801295", new Object[]{this})).intValue();
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void hideErrView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917244615")) {
            ipChange.ipc$dispatch("917244615", new Object[]{this});
            return;
        }
        ee0 ee0 = this.mErrControlImpl;
        if (ee0 != null) {
            ee0.hideErrView();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity
    public BaseViewPagerAdapter initViewPageAdapter(FragmentManager fragmentManager) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1606621923")) {
            return new SearchResultViewPagerAdapter(this, fragmentManager);
        }
        return (BaseViewPagerAdapter) ipChange.ipc$dispatch("1606621923", new Object[]{this, fragmentManager});
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public boolean isErrViewShown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368370542")) {
            return ((Boolean) ipChange.ipc$dispatch("1368370542", new Object[]{this})).booleanValue();
        }
        ee0 ee0 = this.mErrControlImpl;
        if (ee0 != null) {
            return ee0.isErrViewShown();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488886036")) {
            ipChange.ipc$dispatch("488886036", new Object[]{this, bundle});
            return;
        }
        supportRequestWindowFeature(1);
        setRequestedOrientation(1);
        super.onCreate(bundle);
        in0 in0 = in0.INSTANCE;
        in0.b(this, bundle);
        if (getIntent() != null) {
            in0.b(this, getIntent().getExtras());
        }
        SearchExtra obtainExtra = SearchExtra.obtainExtra(this);
        boolean a2 = ol1.a();
        g91.c("SearchOSwitch", "isDowngrade2OldPage " + a2);
        if (a2) {
            DMNav.from(this).withExtras(SearchExtra.makeBundle2OldSearch(obtainExtra)).toHost("home_search_bak");
            finish();
            return;
        }
        this.pageContainer = (DownFocusViewFlipper) findViewById(R$id.page_container);
        this.searchResultTabLayout = (TabLayout) findViewById(R$id.search_result_tab_layout);
        this.mTabUi = (ViewGroup) findViewById(R$id.search_v2_word_tab_ui);
        if (!TextUtils.isEmpty(obtainExtra.autowords)) {
            this.pageContainer.setVisibility(4);
        }
        this.pageContainer.setListener(new a());
        SearchInputManager searchInputManager = new SearchInputManager(this, this, findViewById(R$id.header_search_v2_ui), this.pageContainer.getChildAt(1), obtainExtra, new b());
        this.mInputManager = searchInputManager;
        searchInputManager.p();
        this.mEggManager = new SearchEggManager(this, this.pageContainer.getChildAt(3), this, this.mInputManager);
        SearchHistoryFragment instance = SearchHistoryFragment.getInstance(new c());
        this.mHistoryObserver = instance;
        getSupportFragmentManager().beginTransaction().add(R$id.search_v2_search_history_layout, instance).commitAllowingStateLoss();
        this.pageContainer.setDisplayedChild(0);
        this.mErrControlImpl = new ee0(this);
        this.mUTBuilder = d62.f(obtainExtra.keywords);
        cn.damai.common.user.c.e().m(this);
        cn.damai.common.user.c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781455532")) {
            ipChange.ipc$dispatch("-1781455532", new Object[]{this});
            return;
        }
        super.onDestroy();
        ee0 ee0 = this.mErrControlImpl;
        if (ee0 != null) {
            ee0.showDialogLoading(false);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138671592")) {
            ipChange.ipc$dispatch("-1138671592", new Object[]{this});
            return;
        }
        super.onPause();
        cn.damai.common.user.c.e().q(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708705519")) {
            ipChange.ipc$dispatch("708705519", new Object[]{this});
            return;
        }
        super.onResume();
        cn.damai.common.user.c.e().n(this, this.mUTBuilder);
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    public void onTabDataLoaded(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379023782")) {
            ipChange.ipc$dispatch("1379023782", new Object[]{this, jSONObject});
            return;
        }
        getActivityContext().runOnUIThreadLocked(new u52(this, parseTabData(jSONObject)));
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7352645")) {
            ipChange.ipc$dispatch("-7352645", new Object[]{this, tab});
            return;
        }
        Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
        if (fragment instanceof ISearchTabSwitch) {
            ((ISearchTabSwitch) fragment).onPageEnter();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656131634")) {
            ipChange.ipc$dispatch("-656131634", new Object[]{this, tab});
            return;
        }
        TextView textView = (TextView) tab.getCustomView();
        if (textView != null) {
            textView.setTextSize(1, 18.0f);
            textView.setTextColor(-16777216);
            Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
            if (fragment instanceof ISearchTabSwitch) {
                ((ISearchTabSwitch) fragment).onPageEnter();
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695733397")) {
            ipChange.ipc$dispatch("1695733397", new Object[]{this, tab});
            return;
        }
        TextView textView = (TextView) tab.getCustomView();
        if (textView != null) {
            textView.setTextSize(1, 15.0f);
            textView.setTextColor(getResources().getColor(R$color.color_999999));
            Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
            if (fragment instanceof ISearchTabSwitch) {
                ((ISearchTabSwitch) fragment).onPageExit();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity
    public List<SearchResultTabBean> parseTabData(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-253046394")) {
            return jSONObject.getJSONArray("data").toJavaList(SearchResultTabBean.class);
        }
        return (List) ipChange.ipc$dispatch("-253046394", new Object[]{this, jSONObject});
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showDialogLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "795534780")) {
            ipChange.ipc$dispatch("795534780", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ee0 ee0 = this.mErrControlImpl;
        if (ee0 != null) {
            ee0.showDialogLoading(z);
        }
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showErrView(ErrControlViewInfo errControlViewInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120115376")) {
            ipChange.ipc$dispatch("-2120115376", new Object[]{this, errControlViewInfo});
            return;
        }
        ee0 ee0 = this.mErrControlImpl;
        if (ee0 != null) {
            try {
                ee0.showErrView(errControlViewInfo);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // cn.damai.search.v2.listener.ISearchUIController
    public void showUi(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59329671")) {
            ipChange.ipc$dispatch("-59329671", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        cn.damai.common.user.c.e().v("hotsearch_list", "search");
        cn.damai.common.user.c.e().v("searchhistory", "search");
        this.pageContainer.setDisplayedChild(i);
    }

    public void switchSearchResultTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476527920")) {
            ipChange.ipc$dispatch("476527920", new Object[]{this, Integer.valueOf(i)});
        } else if (getViewPager().getAdapter() != null && getViewPager().getAdapter().getCount() > i && i > 0) {
            getViewPager().setCurrentItem(i, true);
        }
    }
}
