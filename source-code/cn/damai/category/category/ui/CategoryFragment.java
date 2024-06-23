package cn.damai.category.category.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.category.bean.ConditionEntity;
import cn.damai.category.category.model.CategoryModel;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.ui.adapter.CategoryPagerAdapter;
import cn.damai.category.category.ui.view.CityView;
import cn.damai.category.categorygirl.ui.GirlFragment;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.ui.adapter.HorizontalTitleAdapter;
import cn.damai.category.common.utils.CalendarPopUtil;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.ui.DiscountTicketFragment;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import cn.damai.uikit.view.Option;
import cn.damai.user.view.SpaceItemDecoration;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.br;
import tb.d20;
import tb.hi;
import tb.ig;
import tb.jg;
import tb.p81;
import tb.r42;
import tb.u71;
import tb.v;
import tb.ze;

@Deprecated
/* compiled from: Taobao */
public class CategoryFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CODE = 1005;
    private CategoryActivity mActivity;
    private CalendarPopUtil mCalendarPopUtil;
    private CityView mCityView;
    private int mCurIndex;
    private CategoryRepository mData;
    private boolean mHasCanledarData = false;
    private boolean mHasCityData = false;
    private boolean mHasTitleData = false;
    private HorizontalTitleAdapter mHeadAdapter;
    private HorizontalRecyclerView mHeadRlv;
    private boolean mIsInitData;
    private LinearLayoutManager mLayoutManager;
    private List<Fragment> mListFragment = new ArrayList();
    private View mMengcengView;
    private CategoryModel mModel;
    private CategoryPagerAdapter mPagerAdapter;
    private r42 mScreenView;
    public CategoryNewTitleBean mSelectTitle;
    private List<CategoryNewTitleBean> mTitleList;
    private View mView;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1229405470")) {
                ipChange.ipc$dispatch("-1229405470", new Object[]{this, view});
                return;
            }
            CategoryNewTitleBean categoryNewTitleBean = (CategoryNewTitleBean) view.getTag();
            if (categoryNewTitleBean == null) {
                return;
            }
            if (categoryNewTitleBean.type != 3 || categoryNewTitleBean.categoryId == null || categoryNewTitleBean.index != CategoryFragment.this.mCurIndex) {
                CategoryFragment categoryFragment = CategoryFragment.this;
                categoryFragment.mSelectTitle = categoryNewTitleBean;
                categoryFragment.mCurIndex = categoryNewTitleBean.index;
                CategoryRepository categoryRepository = CategoryFragment.this.mData;
                CategoryFragment categoryFragment2 = CategoryFragment.this;
                categoryRepository.categoryId = categoryFragment2.mSelectTitle.categoryId;
                CategoryRepository categoryRepository2 = categoryFragment2.mData;
                CategoryFragment categoryFragment3 = CategoryFragment.this;
                categoryRepository2.type = categoryFragment3.mSelectTitle.type;
                CategoryRepository categoryRepository3 = categoryFragment3.mData;
                CategoryFragment categoryFragment4 = CategoryFragment.this;
                categoryRepository3.categoryName = categoryFragment4.mSelectTitle.name;
                categoryFragment4.mViewPager.setCurrentItem(categoryNewTitleBean.index);
                CategoryFragment.this.moveToCenter(view);
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends r42 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(View view) {
            super(view);
        }

        @Override // tb.r42
        public void a(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "620148353")) {
                ipChange.ipc$dispatch("620148353", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            super.a(i2);
            if (!(CategoryFragment.this.getCurrentShowFragment() == null || CategoryFragment.this.getCurrentShowFragment().mRecyclerView == null)) {
                CategoryFragment.this.getCurrentShowFragment().mRecyclerView.scrollToPosition(0);
            }
            CategoryFragment.this.hidePop(i2);
        }

        @Override // tb.r42
        public void b(Option option) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1381702789")) {
                ipChange.ipc$dispatch("-1381702789", new Object[]{this, option});
            } else if (option != null) {
                if (option.index == 1) {
                    CategoryFragment.this.mData.isShowJuli = true;
                    p81.c();
                } else {
                    CategoryFragment.this.mData.isShowJuli = false;
                }
                CategoryFragment.this.hidePop(0);
                CategoryFragment.this.mData.conditionEntity.sortType = option.id;
                CategoryFragment.this.getDoubleReuqest(false, true);
                if (CategoryFragment.this.mSelectTitle != null) {
                    cn.damai.common.user.c e = cn.damai.common.user.c.e();
                    ig m = ig.m();
                    int i2 = option.index;
                    String str = CategoryFragment.this.mSelectTitle.name;
                    String str2 = option.title;
                    e.x(m.o(i2, str, str2, option.id + ""));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c extends CityView {
        private static transient /* synthetic */ IpChange $ipChange;

        c(Activity activity, int i, View view, View view2, View view3) {
            super(activity, i, view, view2, view3);
        }

        @Override // cn.damai.category.category.ui.view.CityView
        public void x(int i, int i2, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1822954603")) {
                ipChange.ipc$dispatch("-1822954603", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
                return;
            }
            super.x(i, i2, str, str2);
            CategoryFragment.this.hidePop(0);
            if (!TextUtils.isEmpty(str)) {
                br.c(hi.CATEGORY_CITY_CHANGED_EVENT, str);
                CategoryFragment.this.mData.conditionEntity.currentCityId = str;
                CategoryFragment.this.getDoubleReuqest(true, true);
                CategoryFragment.this.mModel.calendarRequest(CategoryFragment.this.mData.conditionEntity.currentCityId, ze.o(), ze.a());
                CategoryFragment.this.mScreenView.g();
                if (CategoryFragment.this.mSelectTitle != null) {
                    cn.damai.common.user.c.e().x(ig.m().j(i, i2, CategoryFragment.this.mSelectTitle.name, str2));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809498341")) {
                ipChange.ipc$dispatch("809498341", new Object[]{this, view});
            } else if (CategoryFragment.this.getCurrentShowFragment() != null && CategoryFragment.this.getCurrentShowFragment().mRefreshView != null) {
                CategoryFragment.this.getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1374178586")) {
                ipChange.ipc$dispatch("-1374178586", new Object[]{this, view});
            } else if (view.getTag() != null) {
                CategoryFragment.this.mScreenView.g();
                CategoryFragment.this.hidePop(0);
                Day day = (Day) view.getTag();
                if (day != null && day.showType != 0) {
                    if (!TextUtils.isEmpty(day.project)) {
                        CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
                        CategoryFragment.this.mData.conditionEntity.projectIdList.add(day.project);
                    } else {
                        CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
                    }
                    String c = ze.c(day);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(day);
                    CategoryFragment.this.mCalendarPopUtil.o(arrayList);
                    CategoryFragment.this.mData.conditionEntity.dateType = 5;
                    CategoryFragment.this.mData.conditionEntity.startDate = c;
                    CategoryFragment.this.mData.conditionEntity.endDate = c;
                    CategoryFragment.this.getDoubleReuqest(true, false);
                    if (CategoryFragment.this.mSelectTitle != null) {
                        cn.damai.common.user.c.e().x(ig.m().l(4, CategoryFragment.this.mSelectTitle.name, "calendar", ze.c(day)));
                    }
                    CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class f extends CalendarPopUtil {
        private static transient /* synthetic */ IpChange $ipChange;

        f(Context context, View view, View view2, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, int i, View.OnClickListener onClickListener) {
            super(context, view, view2, viewGroup, z, z2, z3, i, onClickListener);
        }

        @Override // cn.damai.category.common.utils.CalendarPopUtil
        public void k(int i, int i2, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "490144872")) {
                ipChange.ipc$dispatch("490144872", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str});
                return;
            }
            super.k(i, i2, str);
            CategoryFragment.this.mScreenView.g();
            CategoryFragment.this.hidePop(0);
            if (i != -1) {
                if (i == 6) {
                    CategoryFragment.this.mData.conditionEntity.dateType = 5;
                    CategoryFragment.this.mData.conditionEntity.startDate = ze.o();
                    CategoryFragment.this.mData.conditionEntity.endDate = ze.j();
                } else {
                    CategoryFragment.this.mData.conditionEntity.dateType = i;
                }
                CategoryFragment.this.getDoubleReuqest(true, true);
                if (CategoryFragment.this.mSelectTitle != null) {
                    cn.damai.common.user.c.e().x(ig.m().l(i2, CategoryFragment.this.mSelectTitle.name, "timerange", str));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1446565144")) {
                ipChange.ipc$dispatch("-1446565144", new Object[]{this, view});
                return;
            }
            CategoryFragment.this.hidePop(0);
        }
    }

    private Fragment getCurrentFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998388926")) {
            return (Fragment) ipChange.ipc$dispatch("998388926", new Object[]{this});
        }
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter != null) {
            return categoryPagerAdapter.b();
        }
        return null;
    }

    private GirlFragment getCurrentGirlFragment() {
        CategoryPagerAdapter categoryPagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161626729")) {
            return (GirlFragment) ipChange.ipc$dispatch("161626729", new Object[]{this});
        }
        if (this.mSelectTitle == null || (categoryPagerAdapter = this.mPagerAdapter) == null) {
            return null;
        }
        Fragment b2 = categoryPagerAdapter.b();
        if (b2 instanceof GirlFragment) {
            return (GirlFragment) b2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ShowFragment getCurrentShowFragment() {
        CategoryPagerAdapter categoryPagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483238171")) {
            return (ShowFragment) ipChange.ipc$dispatch("-1483238171", new Object[]{this});
        }
        if (this.mSelectTitle == null || (categoryPagerAdapter = this.mPagerAdapter) == null) {
            return null;
        }
        Fragment b2 = categoryPagerAdapter.b();
        if (b2 instanceof ShowFragment) {
            return (ShowFragment) b2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getDoubleReuqest(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955685331")) {
            ipChange.ipc$dispatch("955685331", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mData.isChangeCondition = true;
        if (!this.mHasTitleData) {
            this.mModel.categoryNewTitleRequest();
        }
        if (!this.mHasCityData) {
            this.mModel.getCityRequest();
        }
        if (!this.mHasCanledarData) {
            this.mModel.calendarRequest(this.mData.conditionEntity.currentCityId, ze.o(), ze.a());
        }
        if (getCurrentShowFragment() != null) {
            getCurrentShowFragment().request(true, z2);
        }
    }

    private boolean getIsAizhe(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-806727336")) {
            return Math.abs(i - i2) <= 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-806727336", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
    }

    private DamaiBaseMvpFragment getMVPFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135995152")) {
            return (DamaiBaseMvpFragment) ipChange.ipc$dispatch("-1135995152", new Object[]{this});
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

    private void getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15844842")) {
            ipChange.ipc$dispatch("15844842", new Object[]{this});
            return;
        }
        this.mActivity.startProgressDialog();
        this.mModel.categoryNewTitleRequest();
        this.mModel.getCityRequest();
        this.mModel.calendarRequest(this.mData.conditionEntity.currentCityId, ze.o(), ze.a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hidePop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578962613")) {
            ipChange.ipc$dispatch("-578962613", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.mCityView.q();
            this.mCalendarPopUtil.i();
            if (getCurrentShowFragment() != null && getCurrentShowFragment().mRefreshView != null) {
                getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(true);
            }
        } else if (i == 1) {
            this.mCalendarPopUtil.i();
            if (!this.mCityView.p() && this.mSelectTitle != null) {
                cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
                ig m = ig.m();
                String str = this.mSelectTitle.name;
                e2.x(m.i(str, ((Object) ((TextView) this.rootView.findViewById(R$id.tv_tab1)).getText()) + ""));
            }
            this.mCityView.z((DMIconFontTextView) this.rootView.findViewById(R$id.icon_tab1));
            if (getCurrentShowFragment() != null && getCurrentShowFragment().mRefreshView != null) {
                getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(false);
            }
        } else if (i == 2) {
            this.mCityView.q();
            if (!this.mCalendarPopUtil.h() && this.mSelectTitle != null) {
                cn.damai.common.user.c e3 = cn.damai.common.user.c.e();
                ig m2 = ig.m();
                String str2 = this.mSelectTitle.name;
                e3.x(m2.k(str2, ((Object) ((TextView) this.rootView.findViewById(R$id.tv_tab2)).getText()) + ""));
            }
            this.mCalendarPopUtil.q((DMIconFontTextView) this.rootView.findViewById(R$id.icon_tab2), true);
            if (getCurrentShowFragment() != null && getCurrentShowFragment().mRefreshView != null) {
                getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(false);
            }
        }
    }

    private void initCalendar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809192907")) {
            ipChange.ipc$dispatch("-1809192907", new Object[]{this});
            return;
        }
        f fVar = new f(this.mActivity, this.rootView.findViewById(R$id.tv_tab2), this.mMengcengView, (ViewGroup) this.rootView.findViewById(R$id.layout_calendar), false, true, true, getRealHeight(), new e());
        this.mCalendarPopUtil = fVar;
        fVar.n(new g());
    }

    private void initCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2043153896")) {
            ipChange.ipc$dispatch("2043153896", new Object[]{this});
            return;
        }
        c cVar = new c(this.mActivity, getRealHeight(), this.rootView.findViewById(R$id.tv_tab1), this.rootView.findViewById(R$id.layout_city), this.mMengcengView);
        this.mCityView = cVar;
        cVar.y(new d());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594057911")) {
            ipChange.ipc$dispatch("-1594057911", new Object[]{this});
            return;
        }
        this.mModel = new CategoryModel(getContext());
        ConditionEntity conditionEntity = this.mData.conditionEntity;
        conditionEntity.dateType = 0;
        conditionEntity.startDate = null;
        conditionEntity.endDate = null;
        getRequest();
        this.mModel.getCategoryTitleBean().observe(this, new Observer<CategoryNewTitleListBean>() {
            /* class cn.damai.category.category.ui.CategoryFragment.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable CategoryNewTitleListBean categoryNewTitleListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1872679548")) {
                    ipChange.ipc$dispatch("-1872679548", new Object[]{this, categoryNewTitleListBean});
                    return;
                }
                CategoryFragment.this.updateTitle(categoryNewTitleListBean);
            }
        });
        this.mModel.getCalendarBean().observe(this, new Observer<CalendarBean>() {
            /* class cn.damai.category.category.ui.CategoryFragment.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable CalendarBean calendarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2096391629")) {
                    ipChange.ipc$dispatch("-2096391629", new Object[]{this, calendarBean});
                } else if (calendarBean != null) {
                    CategoryFragment.this.mHasCanledarData = true;
                    CategoryFragment.this.mCalendarPopUtil.l(calendarBean);
                }
            }
        });
        this.mModel.getCityBeanBean().observe(this, new Observer<CityListResponse>() {
            /* class cn.damai.category.category.ui.CategoryFragment.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable CityListResponse cityListResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-93982552")) {
                    ipChange.ipc$dispatch("-93982552", new Object[]{this, cityListResponse});
                } else if (cityListResponse != null) {
                    CategoryFragment.this.mHasCityData = true;
                    CategoryFragment.this.mScreenView.f(0);
                    CategoryFragment.this.mScreenView.c(0);
                    CategoryFragment.this.mCityView.r(cityListResponse);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void moveToCenter(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599112848")) {
            ipChange.ipc$dispatch("-599112848", new Object[]{this, view});
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) this.mActivity.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        this.mHeadRlv.smoothScrollBy((iArr[0] - (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / 2)) + (width / 2), 0);
    }

    private void setHidden123() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "234494877")) {
            ipChange.ipc$dispatch("234494877", new Object[]{this});
            return;
        }
        this.mScreenView.f(8);
    }

    private void setHidden23() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978338490")) {
            ipChange.ipc$dispatch("978338490", new Object[]{this});
            return;
        }
        this.mScreenView.e(8);
        this.mScreenView.d(8);
    }

    private void setViewPaperItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499460952")) {
            ipChange.ipc$dispatch("499460952", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            Field declaredField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this.mViewPager, i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void show123() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502116718")) {
            ipChange.ipc$dispatch("-1502116718", new Object[]{this});
            return;
        }
        this.mScreenView.f(0);
        this.mScreenView.e(0);
        this.mScreenView.d(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    private void updateTitle(CategoryNewTitleListBean categoryNewTitleListBean) {
        List<CategoryNewTitleBean> b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168353665")) {
            ipChange.ipc$dispatch("-1168353665", new Object[]{this, categoryNewTitleListBean});
            return;
        }
        if (categoryNewTitleListBean != null) {
            try {
                if (!u71.a(categoryNewTitleListBean.data)) {
                    this.mHasTitleData = true;
                    d20.T("categoryTitleList", JSON.toJSONString(categoryNewTitleListBean));
                    b2 = jg.b(categoryNewTitleListBean);
                    if (u71.a(b2)) {
                        CategoryRepository categoryRepository = this.mData;
                        int a2 = jg.a(categoryRepository.categoryId, categoryRepository.type);
                        this.mCurIndex = a2;
                        this.mHeadAdapter.h(b2, a2);
                        int i = this.mCurIndex;
                        if (i == 0 || i == 1 || i == 2) {
                            this.mHeadRlv.scrollToPosition(0);
                        } else {
                            this.mHeadRlv.scrollToPosition(i - 2);
                        }
                        this.mTitleList = b2;
                        this.mHeadAdapter.i(this.mCurIndex);
                        this.mSelectTitle = this.mTitleList.get(this.mCurIndex);
                        updateViewPager(b2, this.mCurIndex);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
            }
        }
        String B = d20.B("categoryTitleList");
        if (!TextUtils.isEmpty(B)) {
            categoryNewTitleListBean = (CategoryNewTitleListBean) JSON.parseObject(B, CategoryNewTitleListBean.class);
        }
        b2 = jg.b(categoryNewTitleListBean);
        if (u71.a(b2)) {
        }
    }

    private void updateViewPager(List<CategoryNewTitleBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194508512")) {
            ipChange.ipc$dispatch("-1194508512", new Object[]{this, list, Integer.valueOf(i)});
        } else if (!u71.a(list)) {
            this.mListFragment.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                CategoryNewTitleBean categoryNewTitleBean = list.get(i2);
                if (categoryNewTitleBean != null) {
                    Fragment fragment = null;
                    int i3 = categoryNewTitleBean.type;
                    if (i3 == 1) {
                        fragment = GirlFragment.newInstance(categoryNewTitleBean.name);
                    } else if (i3 == 2) {
                        fragment = DiscountTicketFragment.instance(new DtParams(8, "discount"));
                    } else if (i3 == 3) {
                        fragment = new ShowFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("titlebean", categoryNewTitleBean);
                        fragment.setArguments(bundle);
                    }
                    this.mListFragment.add(fragment);
                }
            }
            setViewPaperItem(i);
            CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(getChildFragmentManager(), this.mListFragment);
            this.mPagerAdapter = categoryPagerAdapter;
            this.mViewPager.setAdapter(categoryPagerAdapter);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                /* class cn.damai.category.category.ui.CategoryFragment.AnonymousClass12 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1669777139")) {
                        ipChange.ipc$dispatch("-1669777139", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1819026092")) {
                        ipChange.ipc$dispatch("1819026092", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1525519512")) {
                        ipChange.ipc$dispatch("1525519512", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    CategoryFragment.this.changePage(i, true);
                }
            });
            this.mCurIndex = i;
            this.mViewPager.setCurrentItem(i);
            String str = this.mSelectTitle.patternName;
            ig.c = str;
            ig.d = str;
            changePage(i, true);
        }
    }

    public void changePage(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34784085")) {
            ipChange.ipc$dispatch("34784085", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.mData.isAizhe = getIsAizhe(this.mCurIndex, i);
        hidePop(0);
        CategoryNewTitleBean categoryNewTitleBean = this.mTitleList.get(i);
        this.mSelectTitle = categoryNewTitleBean;
        if (categoryNewTitleBean != null) {
            this.mData.showTitleBean = categoryNewTitleBean;
            int i2 = categoryNewTitleBean.type;
            if (i2 == 1) {
                setHidden123();
            } else if (i2 == 2) {
                setHidden123();
            } else if (i2 == 3) {
                if (categoryNewTitleBean.isShowFilter == 1) {
                    show123();
                } else {
                    setHidden123();
                }
            }
            CategoryRepository categoryRepository = this.mData;
            CategoryNewTitleBean categoryNewTitleBean2 = this.mSelectTitle;
            categoryRepository.categoryId = categoryNewTitleBean2.categoryId;
            categoryRepository.type = categoryNewTitleBean2.type;
            categoryRepository.categoryName = categoryNewTitleBean2.name;
            View findViewByPosition = this.mLayoutManager.findViewByPosition(i);
            if (findViewByPosition != null) {
                moveToCenter(findViewByPosition);
            } else {
                this.mHeadRlv.scrollToPosition(i);
            }
            this.mHeadAdapter.i(i);
            CategoryRepository categoryRepository2 = this.mData;
            categoryRepository2.isNeedShowClickUt = true;
            int i3 = this.mSelectTitle.type;
            if (i3 == 1) {
                String str = categoryRepository2.mXiannvBdian;
                ig.c = str;
                ig.d = str;
            } else if (i3 == 2) {
                ig.c = "zhekou";
                ig.d = "zhekou";
            } else if (i3 == 3) {
                String str2 = categoryRepository2.showTitleBean.patternName;
                ig.c = str2;
                ig.d = str2;
            }
            if (getMVPFragment() != null) {
                getMVPFragment().pageUtBuild();
            }
            if (getCurrentGirlFragment() != null) {
                getCurrentGirlFragment().pageUtBuild();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-405115092")) {
            return R$layout.category_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-405115092", new Object[]{this})).intValue();
    }

    public int getRealHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315432705")) {
            return ((Integer) ipChange.ipc$dispatch("-1315432705", new Object[]{this})).intValue();
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 17) {
            return i;
        }
        android.view.Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        Display.getSize(defaultDisplay, point);
        Display.getRealSize(defaultDisplay, point2);
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813003484")) {
            ipChange.ipc$dispatch("813003484", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804165327")) {
            ipChange.ipc$dispatch("804165327", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1711942254")) {
            ipChange.ipc$dispatch("1711942254", new Object[]{this});
            return;
        }
        this.mMengcengView = this.rootView.findViewById(R$id.view_mengceng);
        this.mHeadRlv = (HorizontalRecyclerView) this.rootView.findViewById(R$id.rlv_head);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mHeadRlv.setLayoutManager(this.mLayoutManager);
        this.mHeadRlv.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.mActivity, 9.0f)));
        HorizontalTitleAdapter horizontalTitleAdapter = new HorizontalTitleAdapter(this.mActivity, new a());
        this.mHeadAdapter = horizontalTitleAdapter;
        this.mHeadRlv.setAdapter(horizontalTitleAdapter);
        this.mScreenView = new b(this.rootView.findViewById(R$id.layout_screen));
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.category_pager);
        initCity();
        initCalendar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165632299")) {
            ipChange.ipc$dispatch("-165632299", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701813972")) {
            ipChange.ipc$dispatch("701813972", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406160136")) {
            return (View) ipChange.ipc$dispatch("-406160136", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        this.mActivity = categoryActivity;
        this.mData = categoryActivity.getData();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425090740")) {
            ipChange.ipc$dispatch("-1425090740", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mListFragment.clear();
        this.mListFragment = null;
    }

    public boolean onInterceptLocationActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164932732")) {
            return ((Boolean) ipChange.ipc$dispatch("-164932732", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        }
        CityView cityView = this.mCityView;
        if (cityView != null) {
            return cityView.w(i, i2, intent);
        }
        return false;
    }

    @Override // cn.damai.common.app.base.BaseFragment, cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758733091")) {
            ipChange.ipc$dispatch("-1758733091", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z && !this.mIsInitData) {
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.category.category.ui.CategoryFragment.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1106961903")) {
                        ipChange.ipc$dispatch("1106961903", new Object[]{this});
                    } else if (CategoryFragment.this.isVisible()) {
                        CategoryFragment.this.initData();
                        CategoryFragment.this.mIsInitData = true;
                    }
                }
            }, 200);
        }
    }

    public void startTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672881152")) {
            ipChange.ipc$dispatch("-1672881152", new Object[]{this});
        } else if (getCurrentShowFragment() != null) {
            getCurrentShowFragment().startTimer();
        }
    }
}
