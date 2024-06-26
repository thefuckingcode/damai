package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$array;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.CouponApplyResultBean;
import cn.damai.mine.contract.UserCouponsContract;
import cn.damai.mine.fragment.CouponFragment;
import cn.damai.mine.presenter.UserCouponsPresenter;
import cn.damai.uikit.indicator.PagerIndicator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bk2;
import tb.d20;
import tb.n42;
import tb.ne2;
import tb.pp2;
import tb.xf2;
import tb.yd1;

/* compiled from: Taobao */
public class UserCouponsActivity extends DamaiBaseActivity<UserCouponsPresenter, UserCouponsContract.Model> implements UserCouponsContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean finishToMain;
    private boolean isApplyingCoupon;
    private DMDialog mCouponDialog;
    private EditText mCouponEdit;
    private CouponFragment[] mCouponFragments;
    private CouponPageAdapter mPageAdapter;
    private PagerIndicator mPagerIndicator;
    private String[] mTitles;
    private TextView mTvError;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    public static class CouponPageAdapter extends FragmentPagerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        private String[] a;
        private CouponFragment[] b;

        public CouponPageAdapter(FragmentActivity fragmentActivity, String[] strArr, CouponFragment[] couponFragmentArr) {
            super(fragmentActivity.getSupportFragmentManager());
            this.a = strArr;
            this.b = couponFragmentArr;
        }

        public CouponFragment a(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1050749273")) {
                return this.b[i];
            }
            return (CouponFragment) ipChange.ipc$dispatch("1050749273", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "345138775")) {
                return this.a.length;
            }
            return ((Integer) ipChange.ipc$dispatch("345138775", new Object[]{this})).intValue();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1932964879")) {
                return this.b[i];
            }
            return (Fragment) ipChange.ipc$dispatch("1932964879", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1752772737")) {
                return this.a[i];
            }
            return (CharSequence) ipChange.ipc$dispatch("1752772737", new Object[]{this, Integer.valueOf(i)});
        }
    }

    /* compiled from: Taobao */
    public class a implements PagerIndicator.TabViewFactory {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.indicator.PagerIndicator.TabViewFactory
        public void addTabs(ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1589882445")) {
                ipChange.ipc$dispatch("1589882445", new Object[]{this, viewGroup, Integer.valueOf(i)});
                return;
            }
            viewGroup.removeAllViews();
            for (int i2 = 0; i2 < UserCouponsActivity.this.mTitles.length; i2++) {
                View inflate = LayoutInflater.from(UserCouponsActivity.this).inflate(R$layout.item_text_tab, viewGroup, false);
                ((TextView) inflate.findViewById(R$id.tabName)).setText(UserCouponsActivity.this.mTitles[i2]);
                viewGroup.addView(inflate);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "974198985")) {
                ipChange.ipc$dispatch("974198985", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            String trim = UserCouponsActivity.this.mCouponEdit.getText().toString().trim();
            if (xf2.j(trim)) {
                UserCouponsActivity.this.mTvError.setVisibility(0);
                UserCouponsActivity.this.mTvError.setText(bk2.b(UserCouponsActivity.this.mContext, R$string.data_string_031));
            } else if (!UserCouponsActivity.this.isApplyingCoupon) {
                UserCouponsActivity.this.isApplyingCoupon = true;
                UserCouponsActivity.this.addCouponWork(trim);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1409300048")) {
                ipChange.ipc$dispatch("1409300048", new Object[]{this, editable});
            } else if (editable.length() <= 0) {
                UserCouponsActivity.this.mTvError.setText("");
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1224017933")) {
                ipChange.ipc$dispatch("-1224017933", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1773968915")) {
                ipChange.ipc$dispatch("1773968915", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addCouponWork(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150950389")) {
            ipChange.ipc$dispatch("1150950389", new Object[]{this, str});
            return;
        }
        ((UserCouponsPresenter) this.mPresenter).addCoupon(d20.E(), str);
    }

    private void initTabsAndFragments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528108723")) {
            ipChange.ipc$dispatch("-528108723", new Object[]{this});
            return;
        }
        this.mTitles = bk2.a(this, R$array.coupons_title);
        this.finishToMain = getIntent().getBooleanExtra("fromPush", false);
        int length = this.mTitles.length;
        this.mCouponFragments = new CouponFragment[length];
        for (int i = 0; i < length; i++) {
            this.mCouponFragments[i] = CouponFragment.newInstance(i);
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609414341")) {
            ipChange.ipc$dispatch("609414341", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        CouponPageAdapter couponPageAdapter = new CouponPageAdapter(this, this.mTitles, this.mCouponFragments);
        this.mPageAdapter = couponPageAdapter;
        this.mViewPager.setAdapter(couponPageAdapter);
        PagerIndicator pagerIndicator = (PagerIndicator) findViewById(R$id.indicator);
        this.mPagerIndicator = pagerIndicator;
        pagerIndicator.setViewPager(this.mViewPager);
        this.mPagerIndicator.setTabViewFactory(new a());
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58078576")) {
            ipChange.ipc$dispatch("-58078576", new Object[]{this});
            return;
        }
        findViewById(R$id.ll_header_left).setOnClickListener(this);
        findViewById(R$id.btn_header_right).setOnClickListener(this);
    }

    private void setTitleImmersiveStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880932101")) {
            ipChange.ipc$dispatch("-1880932101", new Object[]{this});
            return;
        }
        int a2 = ne2.a(this);
        View findViewById = findViewById(R$id.title_bar_space);
        if (findViewById == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, a2));
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
        ne2.f(this, false, R$color.black);
    }

    private void startCouponDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208368179")) {
            ipChange.ipc$dispatch("208368179", new Object[]{this});
            return;
        }
        DMDialog dMDialog = new DMDialog(this);
        this.mCouponDialog = dMDialog;
        dMDialog.v(getString(R$string.mine_coupon_exchange_coupon));
        View inflate = LayoutInflater.from(this).inflate(R$layout.mine_exchange_coupon_dialog, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R$id.mine_edit_coupon);
        this.mCouponEdit = editText;
        editText.setPadding(n42.a(this, 5.0f), 0, 0, n42.a(this, 10.0f));
        this.mTvError = (TextView) inflate.findViewById(R$id.mine_error_tv);
        this.mCouponDialog.u(inflate);
        this.mCouponDialog.i("取消", null);
        this.mCouponDialog.n("确定", new b());
        this.mCouponDialog.show();
        this.mCouponEdit.addTextChangedListener(new c());
    }

    private void submitCouponUT(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028799505")) {
            ipChange.ipc$dispatch("-2028799505", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        cn.damai.common.user.c.e().x(yd1.x().D(str, i));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630635377")) {
            ipChange.ipc$dispatch("-630635377", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1310175237")) {
            return R$layout.activity_user_coupon;
        }
        return ((Integer) ipChange.ipc$dispatch("-1310175237", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472241888")) {
            ipChange.ipc$dispatch("472241888", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169509557")) {
            ipChange.ipc$dispatch("-1169509557", new Object[]{this});
            return;
        }
        ((UserCouponsPresenter) this.mPresenter).setVM(this, (UserCouponsContract.Model) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712323186")) {
            ipChange.ipc$dispatch("712323186", new Object[]{this});
            return;
        }
        hideBaseLayout();
        setTitleImmersiveStyle();
        initTabsAndFragments();
        initViews();
        registerListener();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        CouponPageAdapter couponPageAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884476455")) {
            ipChange.ipc$dispatch("-1884476455", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1000 && i2 == -1 && intent != null && intent.getBooleanExtra("unbind", false) && this.mViewPager != null && (couponPageAdapter = this.mPageAdapter) != null && couponPageAdapter.a(0) != null) {
            this.mPageAdapter.a(0).refreshRequestCouponsList();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25959976")) {
            ipChange.ipc$dispatch("-25959976", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.ll_header_left) {
            if (this.finishToMain) {
                pp2.b().q(this, pp2.SCHEME_HOMEPAGE);
            }
            finish();
        } else if (id == R$id.btn_header_right) {
            cn.damai.common.user.c.e().x(yd1.x().C());
            startCouponDialog();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117999240")) {
            ipChange.ipc$dispatch("117999240", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(yd1.x().p());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714792463")) {
            ipChange.ipc$dispatch("1714792463", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907173414")) {
            ipChange.ipc$dispatch("1907173414", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048106587")) {
            ipChange.ipc$dispatch("2048106587", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190815330")) {
            ipChange.ipc$dispatch("1190815330", new Object[]{this});
        }
    }

    @Override // cn.damai.mine.contract.UserCouponsContract.View
    public void onReturnExchangeCouponError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197610983")) {
            ipChange.ipc$dispatch("1197610983", new Object[]{this, str, str2});
            return;
        }
        stopLoading();
        ToastUtil.a().j(this, str2);
        this.isApplyingCoupon = false;
        cn.damai.common.user.c.e().x(yd1.x().D("", 0));
    }

    @Override // cn.damai.mine.contract.UserCouponsContract.View
    public void returnAddCoupon(CouponApplyResultBean.CouponApplyDataBean couponApplyDataBean) {
        CouponPageAdapter couponPageAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680337574")) {
            ipChange.ipc$dispatch("680337574", new Object[]{this, couponApplyDataBean});
            return;
        }
        stopLoading();
        this.mCouponDialog.dismiss();
        this.isApplyingCoupon = false;
        if (couponApplyDataBean != null) {
            ToastUtil.a().j(this, "兑换成功");
            if (!(this.mViewPager == null || (couponPageAdapter = this.mPageAdapter) == null || couponPageAdapter.a(0) == null)) {
                this.mViewPager.setCurrentItem(0);
                this.mPageAdapter.a(0).refreshRequestCouponsList();
            }
            if (xf2.e(couponApplyDataBean.getSuccessCoupons()) > 0) {
                CouponApplyResultBean.CouponAppliedBean couponAppliedBean = couponApplyDataBean.getSuccessCoupons().get(0);
                if (couponAppliedBean != null) {
                    submitCouponUT(couponAppliedBean.getId(), 1);
                } else {
                    submitCouponUT("", 1);
                }
            } else {
                submitCouponUT("", 1);
            }
        } else {
            submitCouponUT("", 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1015358255")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1015358255", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898334862")) {
            ipChange.ipc$dispatch("1898334862", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495200714")) {
            ipChange.ipc$dispatch("495200714", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1574514222")) {
            ipChange.ipc$dispatch("1574514222", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190545879")) {
            ipChange.ipc$dispatch("-190545879", new Object[]{this});
        }
    }
}
