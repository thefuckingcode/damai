package cn.damai.trade.newtradeorder.ui.orderlist.ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.login.LoginManager;
import cn.damai.pay.DamaiPayConstants;
import cn.damai.trade.R$array;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter.ShowOrderListPageAdapter;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.bk2;
import tb.d20;
import tb.gr;
import tb.ln2;
import tb.pp2;

/* compiled from: Taobao */
public class ShowOrderListFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String mFromWhere = "damai";
    private final int BACK_PAGE = 1;
    private final int TO_HOME_PAGE = 2;
    private final int TO_MINE = 0;
    private int mCurrentPage;
    private int mFromPage = 0;
    private OrderListFragment[] mOrderFragments;
    private ShowOrderListPageAdapter mPageAdapter;
    private BroadcastReceiver mReceiver;
    private String[] mTitles;
    public String mUserCode;
    private ViewPager mViewPager;
    private EqualLinearView tabLayout;

    /* compiled from: Taobao */
    public class OrderListPageChangeListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        OrderListPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-538638110")) {
                ipChange.ipc$dispatch("-538638110", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-275015807")) {
                ipChange.ipc$dispatch("-275015807", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195967661")) {
                ipChange.ipc$dispatch("195967661", new Object[]{this, Integer.valueOf(i)});
            } else if (ShowOrderListFragment.this.mOrderFragments != null && i < ShowOrderListFragment.this.mOrderFragments.length) {
                ShowOrderListFragment.this.mCurrentPage = i;
                ShowOrderListFragment.this.tabLayout.selectTitle(i);
                if (i == 0) {
                    cn.damai.common.user.c.e().x(ln2.r().T(ShowOrderListFragment.this.mUserCode));
                } else if (i == 1) {
                    cn.damai.common.user.c.e().x(ln2.r().U(ShowOrderListFragment.this.mUserCode));
                } else if (i == 2) {
                    cn.damai.common.user.c.e().x(ln2.r().V(ShowOrderListFragment.this.mUserCode));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1848143821")) {
                ipChange.ipc$dispatch("1848143821", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().A(ln2.r().i("paysucc", "1"), "selectsuggestmessage", "message");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + this.a.getPackageName()));
            ShowOrderListFragment.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ShowOrderListFragment showOrderListFragment) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477242452")) {
                ipChange.ipc$dispatch("-1477242452", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().A(ln2.r().i("paysucc", "0"), "selectsuggestmessage", "message");
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "134075493")) {
                ipChange.ipc$dispatch("134075493", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null && ShowOrderListFragment.this.mViewPager != null) {
                ShowOrderListFragment.this.mViewPager.setCurrentItem(scrollTitleBean.index);
            }
        }
    }

    private OrderListFragment getCurrentFragment() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987515490")) {
            return (OrderListFragment) ipChange.ipc$dispatch("-987515490", new Object[]{this});
        }
        OrderListFragment[] orderListFragmentArr = this.mOrderFragments;
        if (orderListFragmentArr != null && (i = this.mCurrentPage) < orderListFragmentArr.length) {
            return orderListFragmentArr[i];
        }
        return null;
    }

    private void handleIntent(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921971372")) {
            ipChange.ipc$dispatch("-1921971372", new Object[]{this, bundle});
        } else if (bundle != null) {
            if (bundle.containsKey("sRemind")) {
                this.mFromPage = 2;
            } else if (bundle.containsKey("backPage")) {
                this.mFromPage = 1;
            }
            if (bundle.containsKey("from_where")) {
                mFromWhere = bundle.getString("from_where");
            }
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing() && bundle.containsKey("from_pay")) {
                String string = bundle.getString("from_pay");
                if (("wxpay".equals(string) || "zhifubao".equals(string)) && !DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW.equals(d20.B(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS)) && !PermissionsHelper.a(activity.getApplicationContext())) {
                    d20.T(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS, DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW);
                    PermissionsHelper.b(activity, getResources().getString(R$string.trade_orderlist_pay_success_push), "去设置", new a(activity), "不再提示", new b(this));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[LOOP:0: B:18:0x0059->B:20:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099 A[LOOP:1: B:22:0x0097->B:23:0x0099, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00df  */
    private void initOrderPage() {
        int i;
        int i2;
        int length;
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1725475577")) {
            ipChange.ipc$dispatch("1725475577", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (!(activity == null || activity.isFinishing())) {
            if (!mFromWhere.equals("damai")) {
                if (mFromWhere.equals("damai_pay")) {
                    i = 1;
                } else if (mFromWhere.equals("damai_send")) {
                    i = 2;
                }
                this.mUserCode = d20.E();
                String[] a2 = bk2.a(activity, R$array.order_title);
                this.mTitles = a2;
                this.mOrderFragments = new OrderListFragment[a2.length];
                for (i2 = 0; i2 < this.mTitles.length; i2++) {
                    this.mOrderFragments[i2] = OrderListFragment.newInstance(i2, this.mUserCode);
                }
                ShowOrderListPageAdapter showOrderListPageAdapter = new ShowOrderListPageAdapter(getChildFragmentManager(), this.mTitles, this.mOrderFragments);
                this.mPageAdapter = showOrderListPageAdapter;
                this.mViewPager.setAdapter(showOrderListPageAdapter);
                this.mViewPager.setOffscreenPageLimit(1);
                this.mViewPager.addOnPageChangeListener(new OrderListPageChangeListener());
                ArrayList arrayList = new ArrayList();
                length = this.mTitles.length;
                for (i3 = 0; i3 < length; i3++) {
                    ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                    scrollTitleBean.index = i3;
                    scrollTitleBean.name = this.mTitles[i3];
                    arrayList.add(scrollTitleBean);
                }
                this.tabLayout.setFontColor(R$color.bricks_EA416B, R$color.color_9C9CA5).setFontSize(14, 14).setTitle(arrayList).setHeight(44).setLineShow(false).setOnTitleClickListener(new c()).commit();
                if (i < this.mPageAdapter.getCount()) {
                    i4 = i;
                }
                this.mViewPager.setCurrentItem(i4);
                this.tabLayout.selectTitle(i4);
                initTab();
            }
            i = 0;
            this.mUserCode = d20.E();
            String[] a22 = bk2.a(activity, R$array.order_title);
            this.mTitles = a22;
            this.mOrderFragments = new OrderListFragment[a22.length];
            while (i2 < this.mTitles.length) {
            }
            ShowOrderListPageAdapter showOrderListPageAdapter2 = new ShowOrderListPageAdapter(getChildFragmentManager(), this.mTitles, this.mOrderFragments);
            this.mPageAdapter = showOrderListPageAdapter2;
            this.mViewPager.setAdapter(showOrderListPageAdapter2);
            this.mViewPager.setOffscreenPageLimit(1);
            this.mViewPager.addOnPageChangeListener(new OrderListPageChangeListener());
            ArrayList arrayList2 = new ArrayList();
            length = this.mTitles.length;
            while (i3 < length) {
            }
            this.tabLayout.setFontColor(R$color.bricks_EA416B, R$color.color_9C9CA5).setFontSize(14, 14).setTitle(arrayList2).setHeight(44).setLineShow(false).setOnTitleClickListener(new c()).commit();
            if (i < this.mPageAdapter.getCount()) {
            }
            this.mViewPager.setCurrentItem(i4);
            this.tabLayout.selectTitle(i4);
            initTab();
        }
    }

    private void initTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42756063")) {
            ipChange.ipc$dispatch("-42756063", new Object[]{this});
        }
    }

    private void registerBroad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024282137")) {
            ipChange.ipc$dispatch("-2024282137", new Object[]{this});
            return;
        }
        this.mReceiver = new BroadcastReceiver() {
            /* class cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onReceive(Context context, Intent intent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1927084466")) {
                    ipChange.ipc$dispatch("1927084466", new Object[]{this, context, intent});
                    return;
                }
                FragmentActivity activity = ShowOrderListFragment.this.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    ShowOrderListFragment.this.getActivity().finish();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_close");
        if (getActivity() != null) {
            getActivity().registerReceiver(this.mReceiver, intentFilter);
        }
    }

    public void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "144053187")) {
            ipChange.ipc$dispatch("144053187", new Object[]{this});
        } else if (LoginManager.k().q()) {
            initOrderPage();
        } else {
            DMNav.from(getActivity()).forResult(1000).toUri(NavUri.b(gr.v));
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-760890293")) {
            return R$layout.order_list_show_fragment;
        }
        return ((Integer) ipChange.ipc$dispatch("-760890293", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354224035")) {
            ipChange.ipc$dispatch("-1354224035", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955378322")) {
            ipChange.ipc$dispatch("-1955378322", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683724399")) {
            ipChange.ipc$dispatch("683724399", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.view_pager);
        this.tabLayout = (EqualLinearView) this.rootView.findViewById(R$id.indicator);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296490280")) {
            ipChange.ipc$dispatch("1296490280", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        checkLogin();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        OrderListFragment currentFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855176554")) {
            ipChange.ipc$dispatch("-855176554", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            initOrderPage();
        } else if (i == 1101 && i2 == -1 && intent.getBooleanExtra("refresh", false) && (currentFragment = getCurrentFragment()) != null) {
            currentFragment.requestOrderList();
        }
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597838710")) {
            ipChange.ipc$dispatch("-1597838710", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            int i = this.mFromPage;
            if (i == 0) {
                pp2.b().q(activity, pp2.SCHEME_MINEPAGE);
                activity.finish();
            } else if (i == 1) {
                activity.finish();
            } else if (i == 2) {
                DMNav.from(activity).toUri(NavUri.b(gr.n));
                activity.finish();
            }
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548087147")) {
            ipChange.ipc$dispatch("-548087147", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111926123")) {
            ipChange.ipc$dispatch("1111926123", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        handleIntent(getArguments());
        registerBroad();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059894123")) {
            ipChange.ipc$dispatch("1059894123", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mReceiver != null && getActivity() != null) {
            getActivity().unregisterReceiver(this.mReceiver);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483753094")) {
            ipChange.ipc$dispatch("483753094", new Object[]{this, intent});
            return;
        }
        handleIntent(intent.getExtras());
        OrderListFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.requestOrderList();
        }
    }
}
