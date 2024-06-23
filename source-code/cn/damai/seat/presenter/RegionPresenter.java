package cn.damai.seat.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.contract.RegionContract;
import cn.damai.seat.listener.OnPerformListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnJpgRegionUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.h72;
import tb.r72;
import tb.wk1;

/* compiled from: Taobao */
public class RegionPresenter extends RegionContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnJpgRegionUiListener mUiListener = new a();

    /* compiled from: Taobao */
    public class a implements OnJpgRegionUiListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.seat.presenter.RegionPresenter$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0045a extends wk1 {
            private static transient /* synthetic */ IpChange $ipChange;

            C0045a() {
            }

            @Override // tb.wk1
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1027046743")) {
                    ipChange.ipc$dispatch("1027046743", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                RegionPresenter.this.load(true);
            }
        }

        a() {
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void onFail(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "396934166")) {
                ipChange.ipc$dispatch("396934166", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            RegionPresenter.this.mView.showLoading(false);
            RegionPresenter.this.mView.showErrorView(str, str2, str3, new C0045a());
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showHeadView(HeadBean headBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1297860539")) {
                ipChange.ipc$dispatch("1297860539", new Object[]{this, headBean});
                return;
            }
            RegionPresenter.this.mView.showHeader(headBean);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, h72 h72) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1825414171")) {
                ipChange.ipc$dispatch("-1825414171", new Object[]{this, list, priceLevel, h72});
                return;
            }
            RegionPresenter.this.mView.showPriceList(list, h72, priceLevel);
        }

        @Override // cn.damai.seat.listener.seatui.OnJpgRegionUiListener
        public void showRegionUi(Bitmap bitmap, List<Region> list, PriceLevel priceLevel, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "766577965")) {
                ipChange.ipc$dispatch("766577965", new Object[]{this, bitmap, list, priceLevel, Boolean.valueOf(z)});
                return;
            }
            RegionPresenter.this.mView.showRegionView(bitmap, list, priceLevel, z);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void toast(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1694495672")) {
                ipChange.ipc$dispatch("-1694495672", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            RegionPresenter regionPresenter = RegionPresenter.this;
            Context context = regionPresenter.mContext;
            if (context != null) {
                regionPresenter.mView.showErrorTips(context.getString(i));
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements SimpleCallBack<TbParams> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void onSuccess(TbParams tbParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1247498223")) {
                ipChange.ipc$dispatch("1247498223", new Object[]{this, tbParams});
                return;
            }
            RegionPresenter.this.load(true);
        }

        @Override // cn.damai.seat.listener.SimpleCallBack
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2065172032")) {
                ipChange.ipc$dispatch("-2065172032", new Object[]{this, str, str2});
                return;
            }
            RegionPresenter.this.mView.showErrorView(str, str2, null, null);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnPerformListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ClickedPerform a;

        /* compiled from: Taobao */
        public class a extends wk1 {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // tb.wk1
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-561301159")) {
                    ipChange.ipc$dispatch("-561301159", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                c cVar = c.this;
                RegionPresenter.this.doPerformChanged(cVar.a);
            }
        }

        c(ClickedPerform clickedPerform) {
            this.a = clickedPerform;
        }

        @Override // cn.damai.seat.listener.OnPerformListener
        public void doNetWork(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2105030217")) {
                ipChange.ipc$dispatch("-2105030217", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            RegionPresenter.this.mView.showLoading(z);
        }

        @Override // cn.damai.seat.listener.OnPerformListener
        public void onNetFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1774627592")) {
                ipChange.ipc$dispatch("-1774627592", new Object[]{this, str, str2});
                return;
            }
            RegionPresenter.this.mView.showErrorView(str, str2, null, new a());
        }

        @Override // cn.damai.seat.listener.OnPerformListener
        public void onPerformChanged(TbParams tbParams, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-423300950")) {
                ipChange.ipc$dispatch("-423300950", new Object[]{this, tbParams, Boolean.valueOf(z)});
                return;
            }
            RegionPresenter.this.mView.reopenSeatPage(tbParams, z);
        }

        @Override // cn.damai.seat.listener.OnPerformListener
        public void onPriceChangedOnly() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "773247284")) {
                ipChange.ipc$dispatch("773247284", new Object[]{this});
                return;
            }
            RegionPresenter regionPresenter = RegionPresenter.this;
            regionPresenter.mView.showPriceChanged(regionPresenter.mModel.getSelectPrice());
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void doPerformChanged(@NonNull ClickedPerform clickedPerform) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790736265")) {
            ipChange.ipc$dispatch("790736265", new Object[]{this, clickedPerform});
            return;
        }
        this.mModel.changePerform(clickedPerform, new c(clickedPerform));
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442635327")) {
            ipChange.ipc$dispatch("442635327", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mView.showLoading(true);
        this.mModel.load(z, this.mUiListener);
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void onPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703979931")) {
            ipChange.ipc$dispatch("1703979931", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        if (priceLevel != null) {
            r72.n().i(r72.PAGE_AREA, this.mModel.getParams().itemId, i, priceLevel.originalPrice(), priceLevel.getPriceType());
        }
        this.mModel.onPriceSelectChanged(priceLevel);
        this.mView.showPriceChanged(this.mModel.getSelectPrice());
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void onPromotionClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335829495")) {
            ipChange.ipc$dispatch("335829495", new Object[]{this});
            return;
        }
        PromotionDataBean promotion = this.mModel.promotion();
        if (promotion != null) {
            TbParams params = this.mModel.getParams();
            r72.n().h(r72.PAGE_AREA, params.itemId, params.performId);
            this.mView.showPromotionFragment(promotion);
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void onRegionClick(Region region) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173700693")) {
            ipChange.ipc$dispatch("1173700693", new Object[]{this, region});
        } else if (region != null) {
            TbParams createParams2SeatPage = this.mModel.createParams2SeatPage(region);
            r72.n().j(createParams2SeatPage.itemId, region.name, region.id);
            this.mView.openSeatPage(createParams2SeatPage);
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321948308")) {
            ipChange.ipc$dispatch("1321948308", new Object[]{this});
        } else if (this.mModel.isLoadFinish()) {
            this.mView.showLoading(true);
            this.mModel.refresh(this.mUiListener);
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.Presenter
    public void start(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959576767")) {
            ipChange.ipc$dispatch("959576767", new Object[]{this, tbParams});
            return;
        }
        this.mModel.prepare(tbParams, new b());
    }
}
