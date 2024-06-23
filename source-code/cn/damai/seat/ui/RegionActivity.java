package cn.damai.seat.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.contract.RegionContract;
import cn.damai.seat.helper.SeatPriceListPanel;
import cn.damai.seat.model.RegionModel;
import cn.damai.seat.presenter.RegionPresenter;
import cn.damai.seat.view.RegionView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.g72;
import tb.r72;
import tb.s72;
import tb.sa;

/* compiled from: Taobao */
public class RegionActivity extends BaseSeatActivity<RegionPresenter, RegionModel> implements RegionContract.RegionView {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup mFgContainer;
    private ViewGroup mMainView;
    private TbParams mParams;
    private RegionView mRegionView;
    private FrameLayout mRegionViewLayout;

    /* compiled from: Taobao */
    public class a implements RegionView.OnRegionClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.seat.view.RegionView.OnRegionClickListener
        public void onRegion(Region region) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1859617951")) {
                ipChange.ipc$dispatch("-1859617951", new Object[]{this, region});
            } else if (!s72.c()) {
                ((RegionPresenter) RegionActivity.this.mPresenter).onRegionClick(region);
            }
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getFragmentContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1652894724")) {
            return this.mFgContainer;
        }
        return (ViewGroup) ipChange.ipc$dispatch("1652894724", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1662467990")) {
            return R$layout.activity_region;
        }
        return ((Integer) ipChange.ipc$dispatch("1662467990", new Object[]{this})).intValue();
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "778134507")) {
            return this.mMainView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("778134507", new Object[]{this});
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612620250")) {
            ipChange.ipc$dispatch("-612620250", new Object[]{this});
            return;
        }
        ((RegionPresenter) this.mPresenter).setVM(this, (RegionContract.RegionModel) this.mModel);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.seat.ui.BaseSeatActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471933257")) {
            ipChange.ipc$dispatch("-471933257", new Object[]{this});
            return;
        }
        super.initView();
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mFgContainer = (ViewGroup) findViewById(R$id.region_fg_container);
        this.mRegionViewLayout = (FrameLayout) findViewById(R$id.region_view_layout);
        this.mFgContainer.setOnClickListener(this);
        TbParams tbParams = (TbParams) obtainExtra();
        this.mParams = tbParams;
        if (tbParams != null) {
            ((RegionPresenter) this.mPresenter).start(tbParams);
            setDamaiUTKeyBuilder(r72.f(this.mParams.itemId));
        }
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255080638")) {
            ipChange.ipc$dispatch("-255080638", new Object[]{this});
        } else if (!dismissFragment(this.mFragment, this.mFgContainer)) {
            super.onBackPressed();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856004387")) {
            ipChange.ipc$dispatch("-856004387", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.header_promotion_desc) {
            ((RegionPresenter) this.mPresenter).onPromotionClick();
        } else if (id == R$id.region_fg_container) {
            dismissFragment(this.mFragment, this.mFgContainer);
        }
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onSeatPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030377935")) {
            ipChange.ipc$dispatch("2030377935", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        ((RegionPresenter) this.mPresenter).onPriceClick(priceLevel, i);
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onUIResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1224625708")) {
            ipChange.ipc$dispatch("1224625708", new Object[]{this});
            return;
        }
        ((RegionPresenter) this.mPresenter).refresh();
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionView
    public void openSeatPage(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127416096")) {
            ipChange.ipc$dispatch("2127416096", new Object[]{this, tbParams});
            return;
        }
        SeatActivity.open(this, tbParams, 2000);
        overridePendingTransition(-1, -1);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionView
    public void reopenSeatPage(TbParams tbParams, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054246887")) {
            ipChange.ipc$dispatch("1054246887", new Object[]{this, tbParams, Boolean.valueOf(z)});
            return;
        }
        sa.b(this, tbParams, z, 2000);
        overridePendingTransition(-1, -1);
        finish();
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionView
    public void showPriceChanged(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773915217")) {
            ipChange.ipc$dispatch("-773915217", new Object[]{this, priceLevel});
            return;
        }
        SeatPriceListPanel seatPriceListPanel = this.mListPanel;
        if (seatPriceListPanel != null) {
            seatPriceListPanel.n(priceLevel);
        }
        if (this.mRegionView != null) {
            this.mRegionView.setPriceId(g72.o(priceLevel));
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionView
    public void showRegionView(Bitmap bitmap, List<Region> list, PriceLevel priceLevel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372374080")) {
            ipChange.ipc$dispatch("372374080", new Object[]{this, bitmap, list, priceLevel, Boolean.valueOf(z)});
            return;
        }
        if (this.mRegionView == null && z) {
            this.mRegionViewLayout.removeAllViews();
            RegionView regionView = new RegionView(this);
            this.mRegionView = regionView;
            regionView.setListener(new a());
            this.mRegionViewLayout.addView(this.mRegionView, new ViewGroup.LayoutParams(-1, -1));
            this.mRegionView.setBitmap(bitmap);
        }
        RegionView regionView2 = this.mRegionView;
        if (regionView2 != null) {
            regionView2.setRegions(list);
            this.mRegionView.setPriceId(g72.o(priceLevel));
        }
        if (z) {
            hideErrorView();
            showLoading(false);
        }
    }
}
