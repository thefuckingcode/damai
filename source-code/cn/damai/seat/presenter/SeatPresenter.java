package cn.damai.seat.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import cn.damai.seat.contract.SeatContract;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnJpgSeatUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.h72;
import tb.r72;
import tb.wk1;

/* compiled from: Taobao */
public class SeatPresenter extends SeatContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnJpgSeatUiListener mUiListener = new a();

    /* compiled from: Taobao */
    public class a implements OnJpgSeatUiListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.seat.presenter.SeatPresenter$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0046a extends wk1 {
            private static transient /* synthetic */ IpChange $ipChange;

            C0046a() {
            }

            @Override // tb.wk1
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1084316454")) {
                    ipChange.ipc$dispatch("1084316454", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                SeatPresenter.this.load(true);
            }
        }

        a() {
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void onFail(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1794600473")) {
                ipChange.ipc$dispatch("-1794600473", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            SeatPresenter.this.mView.showLoading(false);
            SeatPresenter.this.mView.showErrorView(str, str2, str3, new C0046a());
        }

        @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
        public void onSelectSeatChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1745271615")) {
                ipChange.ipc$dispatch("1745271615", new Object[]{this});
                return;
            }
            SeatPresenter.this.mView.invalidateSeatView();
            SeatPresenter.this.updateBottomBar();
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showHeadView(HeadBean headBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-486936564")) {
                ipChange.ipc$dispatch("-486936564", new Object[]{this, headBean});
                return;
            }
            SeatPresenter.this.mView.showHeader(headBean);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, h72 h72) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1324490442")) {
                ipChange.ipc$dispatch("-1324490442", new Object[]{this, list, priceLevel, h72});
                return;
            }
            SeatPresenter.this.mView.showPriceList(list, h72, priceLevel);
        }

        @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
        public void showSeatUi(SeatProfile seatProfile, h72 h72, PriceLevel priceLevel, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1223070372")) {
                ipChange.ipc$dispatch("-1223070372", new Object[]{this, seatProfile, h72, priceLevel, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                SeatPresenter.this.mView.hideErrorView();
            }
            SeatPresenter.this.mView.showSeatView(seatProfile, h72, priceLevel, z);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void toast(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1290217879")) {
                ipChange.ipc$dispatch("1290217879", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            SeatPresenter seatPresenter = SeatPresenter.this;
            Context context = seatPresenter.mContext;
            if (context == null) {
                return;
            }
            if (i == R$string.seat_sold_reselect_tip) {
                seatPresenter.mView.showBottomToast(context.getString(i));
            } else {
                seatPresenter.mView.showErrorTips(context.getString(i));
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements SimpleCallBack<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149895176")) {
                ipChange.ipc$dispatch("-149895176", new Object[]{this, str});
                return;
            }
            SeatPresenter.this.mView.showErrorTips("您已进入" + str);
            SeatPresenter.this.load(true);
        }

        @Override // cn.damai.seat.listener.SimpleCallBack
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1559307377")) {
                ipChange.ipc$dispatch("-1559307377", new Object[]{this, str, str2});
                return;
            }
            SeatPresenter.this.mView.showLoading(false);
            SeatPresenter.this.mView.showErrorView(str, str2, null, null);
        }
    }

    /* compiled from: Taobao */
    public class c implements SeatComputeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void doNetWork(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2047760506")) {
                ipChange.ipc$dispatch("-2047760506", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            SeatPresenter.this.mView.showLoadingLayer(z);
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1255904474")) {
                ipChange.ipc$dispatch("1255904474", new Object[]{this, priceBarInfo, list});
                return;
            }
            SeatPresenter.this.mView.showBottomBar(priceBarInfo);
            SeatPresenter.this.mView.updateSeatListV2Panel(list);
            SeatPresenter.this.mView.updatePromotionTags(priceBarInfo.usedPromotionList, false);
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void onSeatListChanged(@Nullable List<ItemSeatV2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1535193040")) {
                ipChange.ipc$dispatch("1535193040", new Object[]{this, list});
                return;
            }
            SeatPresenter.this.mView.showSeatUiList(SeatPresenter.this.mModel.getIconProvider(), list);
        }
    }

    /* compiled from: Taobao */
    public class d implements Action {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.seat.listener.Action
        public void call() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "405714396")) {
                ipChange.ipc$dispatch("405714396", new Object[]{this});
                return;
            }
            SeatPresenter seatPresenter = SeatPresenter.this;
            seatPresenter.mView.showPriceChanged(seatPresenter.mModel.getSelectPrice(), false);
        }
    }

    /* compiled from: Taobao */
    public class e implements OnSubmitListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void doNetWork(boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1050165172")) {
                ipChange.ipc$dispatch("-1050165172", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (z2) {
                SeatPresenter.this.mView.showLoading(z);
            } else {
                SeatPresenter.this.mView.showLoadingLayer(z);
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onOpenPurchase(@Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1676817885")) {
                ipChange.ipc$dispatch("-1676817885", new Object[]{this, bundle});
                return;
            }
            SeatPresenter.this.mView.onOpenPurchaseActivity(bundle);
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1496144220")) {
                ipChange.ipc$dispatch("1496144220", new Object[]{this, priceBarInfo, list});
                return;
            }
            SeatPresenter.this.mView.showBottomBar(priceBarInfo);
            SeatPresenter.this.mView.updateSeatListV2Panel(list);
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitFailed(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-462552987")) {
                ipChange.ipc$dispatch("-462552987", new Object[]{this, str, str2, str3});
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitSuccess(String str, OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1394833232")) {
                ipChange.ipc$dispatch("1394833232", new Object[]{this, str, orderAfterChooseSeatInfo});
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void seatPreLockFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309696745")) {
                ipChange.ipc$dispatch("309696745", new Object[]{this});
                return;
            }
            SeatPresenter.this.refresh();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateBottomBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388006817")) {
            ipChange.ipc$dispatch("388006817", new Object[]{this});
            return;
        }
        this.mModel.computeSeat(new c());
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74813776")) {
            ipChange.ipc$dispatch("74813776", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mView.showLoading(true);
        this.mModel.load(z, this.mUiListener);
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onConfirmClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020175075")) {
            ipChange.ipc$dispatch("1020175075", new Object[]{this});
            return;
        }
        TbParams params = this.mModel.getParams();
        r72.n().g(params.itemId, params.performId);
        this.mModel.submitSeat(new e());
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-811585492")) {
            ipChange.ipc$dispatch("-811585492", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        if (priceLevel != null) {
            r72.n().i("seatselect", this.mModel.getParams().itemId, i, priceLevel.originalPrice(), priceLevel.getPriceType());
        }
        this.mModel.changePrice(priceLevel, i);
        this.mView.showPriceChanged(this.mModel.getSelectPrice(), true);
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onPromotionClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889318982")) {
            ipChange.ipc$dispatch("1889318982", new Object[]{this});
            return;
        }
        PromotionDataBean promotion = this.mModel.promotion();
        if (promotion != null) {
            TbParams params = this.mModel.getParams();
            r72.n().h("seatselect", params.itemId, params.performId);
            this.mView.showPromotionFragment(promotion);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onSeatChanged(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930169967")) {
            ipChange.ipc$dispatch("1930169967", new Object[]{this, seatNew, Boolean.valueOf(z)});
        } else if (this.mModel.changeSeat(seatNew, z, new d())) {
            if (z) {
                r72.n().l(this.mModel.getParams().itemId, seatNew.sid);
            }
            this.mView.invalidateSeatView();
            this.mView.showDiffRowView(this.mModel.shouldShowDiffRowTip());
            updateBottomBar();
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32756069")) {
            ipChange.ipc$dispatch("32756069", new Object[]{this});
        } else if (this.mModel.isLoadFinish()) {
            this.mView.showLoading(true);
            this.mModel.refresh(this.mUiListener);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void start(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231957872")) {
            ipChange.ipc$dispatch("-1231957872", new Object[]{this, tbParams});
            return;
        }
        this.mModel.prepare(tbParams, new b());
    }
}
