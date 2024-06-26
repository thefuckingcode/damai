package cn.damai.category.category.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.StarItemBean;
import cn.damai.category.category.bean.StarListBean;
import cn.damai.category.category.model.CategoryModel;
import cn.damai.category.category.request.StarListRequest;
import cn.damai.category.category.ui.adapter.CategoryStarPagerAdapter;
import cn.damai.category.common.ui.adapter.HorizontalTitleAdapter;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import cn.damai.user.view.SpaceItemDecoration;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ce2;
import tb.f92;
import tb.ig;
import tb.u71;
import tb.v;

/* compiled from: Taobao */
public class StarBaseFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    ViewPager.OnPageChangeListener listener;
    private DamaiBaseActivity mActivity;
    private HorizontalTitleAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private CategoryModel mModel;
    private CategoryStarPagerAdapter mPagerAdapter;
    public int mSelectIndex = 0;
    public String mSelectName = "推荐";
    private HorizontalRecyclerView mStarHrv;
    private List<CategoryNewTitleBean> mTitleList;
    private View mView;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    public class OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private OnPageChangeListener() {
        }

        public ViewPager.OnPageChangeListener a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-968468463")) {
                return new ViewPager.OnPageChangeListener() {
                    /* class cn.damai.category.category.ui.StarBaseFragment.OnPageChangeListener.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1665564564")) {
                            ipChange.ipc$dispatch("1665564564", new Object[]{this, Integer.valueOf(i)});
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i, float f, int i2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-265297869")) {
                            ipChange.ipc$dispatch("-265297869", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1170278367")) {
                            ipChange.ipc$dispatch("1170278367", new Object[]{this, Integer.valueOf(i)});
                            return;
                        }
                        View findViewByPosition = StarBaseFragment.this.mLayoutManager.findViewByPosition(i);
                        if (findViewByPosition != null) {
                            StarBaseFragment.this.moveToCenter(findViewByPosition);
                        }
                        StarBaseFragment starBaseFragment = StarBaseFragment.this;
                        starBaseFragment.mSelectIndex = i;
                        starBaseFragment.mAdapter.i(i);
                        if (i == 0) {
                            if (!(StarBaseFragment.this.getChildFragmentManager().getFragments() == null || StarBaseFragment.this.getChildFragmentManager().getFragments().get(0) == null || !(StarBaseFragment.this.getChildFragmentManager().getFragments().get(0) instanceof StarFragment))) {
                                ((StarFragment) StarBaseFragment.this.getChildFragmentManager().getFragments().get(0)).startTimer();
                            }
                        } else if (i == 1) {
                            StarBaseFragment.this.getRequest();
                            if (StarBaseFragment.this.getFollowFragment() != null) {
                                ((StarFragment) StarBaseFragment.this.getFollowFragment()).startTimer();
                            }
                        }
                        cn.damai.commonbusiness.pageut.a f = cn.damai.commonbusiness.pageut.a.f(StarBaseFragment.this.mActivity);
                        if (f != null && f.g() != null) {
                            String t = f.g().m().t();
                            CategoryNewTitleBean categoryNewTitleBean = (CategoryNewTitleBean) f92.b(StarBaseFragment.this.mTitleList, StarBaseFragment.this.mSelectIndex);
                            ig.f(t, categoryNewTitleBean != null ? categoryNewTitleBean.name : "", StarBaseFragment.this.mSelectIndex);
                        }
                    }
                };
            }
            return (ViewPager.OnPageChangeListener) ipChange.ipc$dispatch("-968468463", new Object[]{this});
        }

        /* synthetic */ OnPageChangeListener(StarBaseFragment starBaseFragment, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1902547994")) {
                ipChange.ipc$dispatch("-1902547994", new Object[]{this, view});
                return;
            }
            CategoryNewTitleBean categoryNewTitleBean = (CategoryNewTitleBean) view.getTag();
            if (categoryNewTitleBean != null) {
                StarBaseFragment starBaseFragment = StarBaseFragment.this;
                starBaseFragment.mSelectName = categoryNewTitleBean.name;
                starBaseFragment.mViewPager.setCurrentItem(categoryNewTitleBean.index);
                StarBaseFragment.this.moveToCenter(view);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements PageUtExecutor.UTKeyBuilderProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        b(StarBaseFragment starBaseFragment) {
        }

        @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.UTKeyBuilderProvider
        public a.b get(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1004334211")) {
                return (a.b) ipChange.ipc$dispatch("-1004334211", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                return ig.m().p(ce2.PAGE_STAR_REC);
            } else {
                if (i == 1) {
                    return ig.m().p(ce2.PAGE_STAR_FOLLOW);
                }
                return new a.b().i("ace_artist");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Fragment getFollowFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138251837")) {
            return (Fragment) ipChange.ipc$dispatch("-138251837", new Object[]{this});
        } else if (getChildFragmentManager().getFragments() == null || getChildFragmentManager().getFragments().size() < 2 || getChildFragmentManager().getFragments().get(1) == null || !(getChildFragmentManager().getFragments().get(1) instanceof StarFragment)) {
            return null;
        } else {
            return getChildFragmentManager().getFragments().get(1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622276049")) {
            ipChange.ipc$dispatch("-622276049", new Object[]{this});
        } else if (getFollowFragment() != null) {
            ((StarFragment) getFollowFragment()).getFollowRequestIfNeed();
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2003039438")) {
            ipChange.ipc$dispatch("2003039438", new Object[]{this});
            return;
        }
        CategoryModel categoryModel = new CategoryModel(this.mActivity);
        this.mModel = categoryModel;
        categoryModel.getStarListRequest(new StarListRequest());
        this.mModel.getStarListBean().observe(this, new Observer<StarListBean>() {
            /* class cn.damai.category.category.ui.StarBaseFragment.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable StarListBean starListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1681311018")) {
                    ipChange.ipc$dispatch("1681311018", new Object[]{this, starListBean});
                } else if (StarBaseFragment.this.mActivity != null && !StarBaseFragment.this.mActivity.isFinishing() && StarBaseFragment.this.isVisible() && StarBaseFragment.this.isResumed()) {
                    StarBaseFragment.this.updateTabAdapter(starListBean);
                    StarBaseFragment.this.updateViewPager(starListBean);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void moveToCenter(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964559947")) {
            ipChange.ipc$dispatch("964559947", new Object[]{this, view});
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) this.mActivity.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        this.mStarHrv.smoothScrollBy((iArr[0] - (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / 2)) + (width / 2), 0);
    }

    private void requestStar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077566719")) {
            ipChange.ipc$dispatch("-2077566719", new Object[]{this});
        } else if (getFollowFragment() != null) {
            ((StarFragment) getFollowFragment()).requestStar();
        }
    }

    private void showNoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138288681")) {
            ipChange.ipc$dispatch("-2138288681", new Object[]{this});
        } else if (getFollowFragment() != null) {
            ((StarFragment) getFollowFragment()).showNoLogin();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTabAdapter(StarListBean starListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928722992")) {
            ipChange.ipc$dispatch("1928722992", new Object[]{this, starListBean});
            return;
        }
        this.mTitleList = new ArrayList();
        CategoryNewTitleBean categoryNewTitleBean = new CategoryNewTitleBean();
        categoryNewTitleBean.index = 0;
        categoryNewTitleBean.name = "推荐";
        CategoryNewTitleBean categoryNewTitleBean2 = new CategoryNewTitleBean();
        categoryNewTitleBean2.index = 1;
        categoryNewTitleBean2.name = "我关注的";
        this.mTitleList.add(categoryNewTitleBean);
        this.mTitleList.add(categoryNewTitleBean2);
        if (starListBean != null && !u71.a(starListBean.artistList)) {
            List<StarItemBean> list = starListBean.artistList;
            for (int i = 0; i < list.size(); i++) {
                StarItemBean starItemBean = list.get(i);
                if (starItemBean != null && !TextUtils.isEmpty(starItemBean.damaiId)) {
                    CategoryNewTitleBean categoryNewTitleBean3 = new CategoryNewTitleBean();
                    categoryNewTitleBean3.id = starItemBean.damaiId;
                    categoryNewTitleBean3.name = starItemBean.name;
                    categoryNewTitleBean3.index = this.mTitleList.size();
                    this.mTitleList.add(categoryNewTitleBean3);
                }
            }
        }
        this.mAdapter.h(this.mTitleList, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateViewPager(StarListBean starListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397181960")) {
            ipChange.ipc$dispatch("-397181960", new Object[]{this, starListBean});
            return;
        }
        CategoryStarPagerAdapter categoryStarPagerAdapter = new CategoryStarPagerAdapter(getChildFragmentManager(), starListBean);
        this.mPagerAdapter = categoryStarPagerAdapter;
        this.mViewPager.setAdapter(categoryStarPagerAdapter);
        ViewPager.OnPageChangeListener a2 = new OnPageChangeListener(this, null).a();
        this.listener = a2;
        this.mViewPager.addOnPageChangeListener(a2);
        PageUtExecutor pageUtExecutor = new PageUtExecutor(this.mActivity, new b(this));
        this.mViewPager.addOnPageChangeListener(pageUtExecutor);
        this.mViewPager.setCurrentItem(0);
        pageUtExecutor.a();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-942736569")) {
            return R$layout.category_star_base_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-942736569", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759150561")) {
            ipChange.ipc$dispatch("1759150561", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69953642")) {
            ipChange.ipc$dispatch("69953642", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014072307")) {
            ipChange.ipc$dispatch("1014072307", new Object[]{this});
            return;
        }
        this.mStarHrv = (HorizontalRecyclerView) this.rootView.findViewById(R$id.hrv_star);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mStarHrv.setLayoutManager(this.mLayoutManager);
        if (this.mStarHrv.getItemDecorationCount() == 0) {
            this.mStarHrv.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.mActivity, 7.5f)));
        }
        HorizontalTitleAdapter horizontalTitleAdapter = new HorizontalTitleAdapter(this.mActivity, new a());
        this.mAdapter = horizontalTitleAdapter;
        this.mStarHrv.setAdapter(horizontalTitleAdapter);
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.star_pager);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007509274")) {
            ipChange.ipc$dispatch("1007509274", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i != 1006) {
            return;
        }
        if (LoginManager.k().q()) {
            requestStar();
        } else {
            showNoLogin();
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369314023")) {
            ipChange.ipc$dispatch("-369314023", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1892120509")) {
            return (View) ipChange.ipc$dispatch("1892120509", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mActivity = (DamaiBaseActivity) getActivity();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584222617")) {
            ipChange.ipc$dispatch("-1584222617", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mModel = null;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.clearOnPageChangeListeners();
        }
    }
}
