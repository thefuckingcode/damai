package cn.damai.seat.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.R$color;
import cn.damai.seat.R$id;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.contract.BaseSeatView;
import cn.damai.seat.helper.SeatPriceListPanel;
import cn.damai.seat.presenter.BaseSeatPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.h72;
import tb.ne2;
import tb.wk1;
import tb.xs0;

/* compiled from: Taobao */
public abstract class BaseSeatActivity<T extends BaseSeatPresenter, M extends BaseModel> extends DamaiBaseActivity<T, M> implements BaseSeatView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EXTRA = "EXTRA_DATA";
    private List<View> exposureViewList = new ArrayList();
    private boolean isFirstLoad = true;
    protected View mBackBtn;
    protected Fragment mFragment;
    protected SeatPriceListPanel mListPanel;
    protected TextView mPerformNameTv;
    protected View mPromotionDesc;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1595788204")) {
                ipChange.ipc$dispatch("1595788204", new Object[]{this, view});
                return;
            }
            BaseSeatActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements SeatPriceListPanel.OnPriceClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.seat.helper.SeatPriceListPanel.OnPriceClickListener
        public void onPriceClick(PriceLevel priceLevel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-108955878")) {
                ipChange.ipc$dispatch("-108955878", new Object[]{this, priceLevel, Integer.valueOf(i)});
                return;
            }
            BaseSeatActivity.this.onSeatPriceClick(priceLevel, i);
        }
    }

    /* compiled from: Taobao */
    public class c implements NcovPromotionFragment.OnConfirmClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ViewGroup a;

        c(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.OnConfirmClickListener
        public void onCloseClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-681784402")) {
                ipChange.ipc$dispatch("-681784402", new Object[]{this});
                return;
            }
            BaseSeatActivity baseSeatActivity = BaseSeatActivity.this;
            baseSeatActivity.dismissFragment(baseSeatActivity.mFragment, this.a);
        }
    }

    private void hideStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217346525")) {
            ipChange.ipc$dispatch("1217346525", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (findViewById != null) {
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
    }

    private void novBackUtHandle(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339792657")) {
            ipChange.ipc$dispatch("1339792657", new Object[]{this, fragment});
        } else if (fragment != null && fragment.getActivity() != null && !fragment.getActivity().isFinishing() && (fragment instanceof NcovPromotionFragment)) {
            viewIgnoreTagForExposure(fragment.getView());
            cn.damai.common.user.c.e().n(this, this.mBuilder);
            cn.damai.common.user.c.e().b(this.exposureViewList);
            this.exposureViewList.clear();
        }
    }

    private List<View> viewIgnoreTagForExposure(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169903402")) {
            return (List) ipChange.ipc$dispatch("-169903402", new Object[]{this, view});
        }
        new ArrayList();
        return cn.damai.common.user.c.e().I(cn.damai.common.user.c.e().d(view));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public void addContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531822961")) {
            ipChange.ipc$dispatch("1531822961", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058362922")) {
            ipChange.ipc$dispatch("-2058362922", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public boolean dismissFragment(Fragment fragment, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857899491")) {
            return ((Boolean) ipChange.ipc$dispatch("-1857899491", new Object[]{this, fragment, viewGroup})).booleanValue();
        } else if (fragment == null || !fragment.isAdded()) {
            return false;
        } else {
            getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
            viewGroup.setVisibility(8);
            novBackUtHandle(fragment);
            return true;
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246623655")) {
            ipChange.ipc$dispatch("246623655", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329812561")) {
            ipChange.ipc$dispatch("329812561", new Object[]{this});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            onResponseSuccess(mainView);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068301639")) {
            ipChange.ipc$dispatch("-1068301639", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().K(this);
        hideStatusBar();
        this.mBackBtn = findViewById(R$id.header_btn_back);
        this.mPerformNameTv = (TextView) findViewById(R$id.header_perform_name);
        this.mPromotionDesc = findViewById(R$id.header_promotion_desc);
        this.mBackBtn.setOnClickListener(new a());
        this.mListPanel = new SeatPriceListPanel(this, findViewById(R$id.price_scroll_view), new b());
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public boolean isErrorPageShown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665580750")) {
            return ((Boolean) ipChange.ipc$dispatch("665580750", new Object[]{this})).booleanValue();
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            return responseErrorPage.isShown() || this.mErrorPage.getParent() != null;
        }
        return false;
    }

    public <P extends Parcelable> P obtainExtra() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1105201260")) {
            return (P) getIntent().getParcelableExtra("EXTRA_DATA");
        }
        return (P) ((Parcelable) ipChange.ipc$dispatch("-1105201260", new Object[]{this}));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1045189536")) {
            ipChange.ipc$dispatch("-1045189536", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == 1000) {
            setResult(1000);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397474750")) {
            ipChange.ipc$dispatch("-397474750", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.isFirstLoad && !isErrorPageShown()) {
            onUIResume();
        }
        this.isFirstLoad = false;
    }

    public abstract void onSeatPriceClick(PriceLevel priceLevel, int i);

    public abstract void onUIResume();

    @Override // androidx.activity.ComponentActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1249165265")) {
            ipChange.ipc$dispatch("1249165265", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setContentView(getLayoutId());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1405401144")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1405401144", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showBottomToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850957511")) {
            ipChange.ipc$dispatch("1850957511", new Object[]{this, str});
        } else if (!isFinishing() && !TextUtils.isEmpty(str)) {
            cn.damai.common.util.toastutil.a.j(xs0.a().getApplicationContext(), cn.damai.common.util.toastutil.a.b(this, null, str), 0, 80, 0, 300);
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789441955")) {
            ipChange.ipc$dispatch("1789441955", new Object[]{this, str});
        } else if (!isFinishing() && !TextUtils.isEmpty(str)) {
            ToastUtil.a().e(this, str);
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showErrorView(String str, String str2, String str3, wk1 wk1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349579787")) {
            ipChange.ipc$dispatch("-349579787", new Object[]{this, str, str2, str3, wk1});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            onResponseError(str2, str, str3, mainView, true);
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setRefreshListener(wk1);
            }
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showFragment(Fragment fragment, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855058648")) {
            ipChange.ipc$dispatch("855058648", new Object[]{this, fragment, viewGroup});
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(viewGroup.getId(), fragment).commitAllowingStateLoss();
        viewGroup.setVisibility(0);
        if (fragment instanceof NcovPromotionFragment) {
            cn.damai.common.user.c.e().q(this);
            this.exposureViewList = viewIgnoreTagForExposure(getWindow().getDecorView());
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showHeader(@NonNull HeadBean headBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-241081635")) {
            ipChange.ipc$dispatch("-241081635", new Object[]{this, headBean});
            return;
        }
        this.mPerformNameTv.setText(headBean.performName);
        View view = this.mPromotionDesc;
        if (!headBean.isShowPromotion) {
            i = 8;
        }
        view.setVisibility(i);
        this.mPromotionDesc.setOnClickListener(headBean.isShowPromotion ? this : null);
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837787831")) {
            ipChange.ipc$dispatch("837787831", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            startProgressDialog();
        } else {
            stopProgressDialog();
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showPriceList(List<? extends PriceLevel> list, h72 h72, PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "709388703")) {
            ipChange.ipc$dispatch("709388703", new Object[]{this, list, h72, priceLevel});
            return;
        }
        this.mListPanel.o(list, h72, priceLevel);
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public void showPromotionFragment(PromotionDataBean promotionDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125178145")) {
            ipChange.ipc$dispatch("1125178145", new Object[]{this, promotionDataBean});
            return;
        }
        ViewGroup fragmentContainer = getFragmentContainer();
        if (promotionDataBean != null && fragmentContainer != null) {
            NcovPromotionFragment instance = NcovPromotionFragment.instance(promotionDataBean, new c(fragmentContainer));
            this.mFragment = instance;
            showFragment(instance, fragmentContainer);
        }
    }
}
