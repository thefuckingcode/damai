package cn.damai.seat.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.message.observer.Action;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import cn.damai.seat.contract.TbSeatContract;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnSeatUiListener;
import cn.damai.seat.ui.VRImageActivity;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import cn.damai.solid.bean.VRAlarmBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.h72;
import tb.p72;
import tb.r72;
import tb.s72;
import tb.t72;
import tb.wk1;

/* compiled from: Taobao */
public class TSeatPresenter extends TbSeatContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnSeatUiListener mSeatUiListener = new b();

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290901787")) {
                ipChange.ipc$dispatch("-1290901787", new Object[]{this, obj});
            } else if (obj instanceof SeatBox) {
                TSeatPresenter.this.mModel.update3DVrData((SeatBox) obj);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnSeatUiListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a extends wk1 {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // tb.wk1
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1721822935")) {
                    ipChange.ipc$dispatch("1721822935", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TSeatPresenter.this.load(true);
            }
        }

        b() {
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void onFail(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "672193174")) {
                ipChange.ipc$dispatch("672193174", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            s72.f("api" + i + " code:" + str + " msg:" + str2);
            TSeatPresenter.this.mView.showLoading(false);
            if (i == 111) {
                str2 = "麦麦开小差了，请稍后重试哦";
                TSeatPresenter.this.mView.showErrorTips(str2);
            }
            TSeatPresenter.this.mView.showErrorView(str, str2, str3, new a());
        }

        @Override // cn.damai.seat.listener.seatui.OnSeatUiListener
        public void onSelectSeatChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1549549906")) {
                ipChange.ipc$dispatch("-1549549906", new Object[]{this});
                return;
            }
            TSeatPresenter.this.mView.invalidateSeatView();
            TSeatPresenter tSeatPresenter = TSeatPresenter.this;
            tSeatPresenter.mView.showDiffRowView(tSeatPresenter.mModel.shouldShowDiffRowTip());
            TSeatPresenter.this.updateBottomBar();
            if (TSeatPresenter.this.hasVRImage()) {
                TSeatPresenter.this.updateVRInfoOnSeatChanged();
            }
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showHeadView(HeadBean headBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1692129733")) {
                ipChange.ipc$dispatch("-1692129733", new Object[]{this, headBean});
                return;
            }
            TSeatPresenter.this.mView.showHeader(headBean);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, h72 h72) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "657670757")) {
                ipChange.ipc$dispatch("657670757", new Object[]{this, list, priceLevel, h72});
                return;
            }
            TSeatPresenter.this.mView.showPriceList(list, h72, priceLevel);
        }

        @Override // cn.damai.seat.listener.seatui.OnSeatUiListener
        public void showSeatUi(t72 t72, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1010945478")) {
                ipChange.ipc$dispatch("1010945478", new Object[]{this, t72, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                TSeatPresenter.this.mView.hideErrorView();
            }
            TSeatPresenter.this.showSeatView();
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void toast(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1445052984")) {
                ipChange.ipc$dispatch("-1445052984", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            TSeatPresenter tSeatPresenter = TSeatPresenter.this;
            Context context = tSeatPresenter.mContext;
            if (context == null) {
                return;
            }
            if (i == R$string.seat_sold_reselect_tip) {
                tSeatPresenter.mView.showBottomToast(context.getString(i));
            } else {
                tSeatPresenter.mView.showErrorTips(context.getString(i));
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements SimpleCallBack<RegionData> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void onSuccess(RegionData regionData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1919874574")) {
                ipChange.ipc$dispatch("1919874574", new Object[]{this, regionData});
                return;
            }
            TSeatPresenter.this.updateBottomBar();
            TSeatPresenter.this.load(true);
        }

        @Override // cn.damai.seat.listener.SimpleCallBack
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-265589952")) {
                ipChange.ipc$dispatch("-265589952", new Object[]{this, str, str2});
                return;
            }
            TSeatPresenter.this.mView.showErrorView(str, str2, null, null);
        }
    }

    /* compiled from: Taobao */
    public class d implements SeatComputeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void doNetWork(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1410254025")) {
                ipChange.ipc$dispatch("-1410254025", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            TSeatPresenter.this.mView.showLoadingLayer(z);
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1002854603")) {
                ipChange.ipc$dispatch("1002854603", new Object[]{this, priceBarInfo, list});
                return;
            }
            TSeatPresenter.this.mView.showBottomBar(priceBarInfo);
            TSeatPresenter.this.mView.updateSeatListV2Panel(list);
            TSeatPresenter.this.mView.updatePromotionTags(priceBarInfo.usedPromotionList, false);
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void onSeatListChanged(@Nullable List<ItemSeatV2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "146801919")) {
                ipChange.ipc$dispatch("146801919", new Object[]{this, list});
                return;
            }
            TSeatPresenter.this.mView.showSeatUiList(TSeatPresenter.this.mModel.getIconProvider(), list);
        }
    }

    /* compiled from: Taobao */
    public class e implements cn.damai.seat.listener.Action {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.seat.listener.Action
        public void call() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-879812019")) {
                ipChange.ipc$dispatch("-879812019", new Object[]{this});
                return;
            }
            TSeatPresenter.this.showPriceList();
            TSeatPresenter.this.showSeatView();
        }
    }

    /* compiled from: Taobao */
    public class f implements OnSubmitListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void doNetWork(boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1532666555")) {
                ipChange.ipc$dispatch("1532666555", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (z2) {
                TSeatPresenter.this.mView.showLoading(z);
            } else {
                TSeatPresenter.this.mView.showLoadingLayer(z);
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onOpenPurchase(@Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1229758290")) {
                ipChange.ipc$dispatch("1229758290", new Object[]{this, bundle});
                return;
            }
            TSeatPresenter.this.mView.onOpenPurchaseActivity(bundle);
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1243094349")) {
                ipChange.ipc$dispatch("1243094349", new Object[]{this, priceBarInfo, list});
                return;
            }
            TSeatPresenter.this.mView.showBottomBar(priceBarInfo);
            TSeatPresenter.this.mView.updateSeatListV2Panel(list);
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitFailed(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1343068970")) {
                ipChange.ipc$dispatch("-1343068970", new Object[]{this, str, str2, str3});
            } else if (TextUtils.isEmpty(str3)) {
            } else {
                if ("1".equals(str2)) {
                    TSeatPresenter.this.mView.showErrorTips(str3);
                } else if ("2".equals(str2)) {
                    TSeatPresenter.this.mView.showErrorTips(str3);
                    TSeatPresenter.this.mModel.removeAllSeat();
                    TSeatPresenter.this.mView.invalidateSeatView();
                    TSeatPresenter.this.updateBottomBar();
                    if (TSeatPresenter.this.hasVRImage()) {
                        TSeatPresenter.this.updateVRInfoOnSeatChanged();
                    }
                    TSeatPresenter tSeatPresenter = TSeatPresenter.this;
                    tSeatPresenter.mModel.refresh(tSeatPresenter.mSeatUiListener);
                } else if ("3".equals(str2)) {
                    TSeatPresenter.this.mView.showTipDialog(str3);
                } else {
                    TSeatPresenter.this.mView.showErrorTips(str3);
                }
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitSuccess(String str, OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "117621249")) {
                ipChange.ipc$dispatch("117621249", new Object[]{this, str, orderAfterChooseSeatInfo});
                return;
            }
            if (orderAfterChooseSeatInfo != null && !TextUtils.isEmpty(orderAfterChooseSeatInfo.toast)) {
                TSeatPresenter.this.mView.showErrorTips(orderAfterChooseSeatInfo.toast);
            }
            TSeatPresenter.this.mView.openOrderDetailActivity(str);
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void seatPreLockFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "520793112")) {
                ipChange.ipc$dispatch("520793112", new Object[]{this});
                return;
            }
            TSeatPresenter.this.refresh();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPriceList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646298394")) {
            ipChange.ipc$dispatch("-1646298394", new Object[]{this});
            return;
        }
        this.mView.showPriceList(this.mModel.getPriceList(), this.mModel.getIconProvider(), this.mModel.getSelectPrice());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSeatView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418344339")) {
            ipChange.ipc$dispatch("1418344339", new Object[]{this});
            return;
        }
        this.mView.showSeatView(this.mModel.getViewData(), this.mModel.getSelectPrice(), this.mModel.getPriceFilterPic(), this.mModel.isLoadFinish());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateBottomBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407023601")) {
            ipChange.ipc$dispatch("407023601", new Object[]{this});
            return;
        }
        this.mModel.computeSeat(new d());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateVRInfoOnSeatChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1539115987")) {
            ipChange.ipc$dispatch("1539115987", new Object[]{this});
            return;
        }
        SeatNew lastedSelectSeat = this.mModel.getLastedSelectSeat();
        if (lastedSelectSeat == null) {
            this.mView.dismissVRInfo();
            return;
        }
        this.mModel.load3DVrImageData(lastedSelectSeat);
        this.mView.updateVRInfo(lastedSelectSeat);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public boolean hasVRImage() {
        t72 viewData;
        RegionData regionData;
        RegionSeatData regionSeatData;
        RegionSeatExtInfo regionSeatExtInfo;
        SeatBox seatBox;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629314983")) {
            return ((Boolean) ipChange.ipc$dispatch("-1629314983", new Object[]{this})).booleanValue();
        }
        return (Build.VERSION.SDK_INT < 19 || (viewData = this.mModel.getViewData()) == null || (regionData = viewData.i) == null || (regionSeatData = regionData.regionSeatData) == null || !regionSeatData.has3dvrImg || (regionSeatExtInfo = regionSeatData.seatExtInfo) == null || regionSeatExtInfo.seat3dvrInfo == null || (seatBox = viewData.b) == null || seatBox.seat3DVrInfoMap == null) ? false : true;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1338237344")) {
            ipChange.ipc$dispatch("1338237344", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mView.showLoading(true);
        this.mModel.load(z, this.mSeatUiListener);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void onConfirmClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328051859")) {
            ipChange.ipc$dispatch("328051859", new Object[]{this});
            return;
        }
        TbParams params = this.mModel.getParams();
        cn.damai.common.user.c.e().x(p72.l().q(params.itemId + "", params.performId + ""));
        this.mModel.submitSeat(new f());
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void onPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977492092")) {
            ipChange.ipc$dispatch("977492092", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        if (priceLevel != null) {
            long j = this.mModel.getParams().itemId;
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            p72 l = p72.l();
            String valueOf = String.valueOf(priceLevel.originalPrice());
            e2.x(l.p(j, i, valueOf, priceLevel.getPriceType() + ""));
        }
        this.mModel.changePrice(priceLevel, i);
        this.mView.showPriceChanged(this.mModel.getSelectPrice(), this.mModel.getPriceFilterPic());
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void onPromotionClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816128010")) {
            ipChange.ipc$dispatch("-1816128010", new Object[]{this});
            return;
        }
        PromotionDataBean promotion = this.mModel.promotion();
        if (promotion != null) {
            TbParams params = this.mModel.getParams();
            r72.n().h(r72.PAGE_AREA, params.itemId, params.performId);
            this.mView.showPromotionFragment(promotion);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void onSeatChanged(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205688511")) {
            ipChange.ipc$dispatch("205688511", new Object[]{this, seatNew, Boolean.valueOf(z)});
            return;
        }
        if (this.mModel.changeSeat(seatNew, z, new e())) {
            this.mView.showDiffRowView(this.mModel.shouldShowDiffRowTip());
            updateBottomBar();
            this.mView.invalidateSeatView();
            if (hasVRImage()) {
                updateVRInfoOnSeatChanged();
            }
        }
        if (seatNew != null) {
            TbParams params = this.mModel.getParams();
            if (z) {
                cn.damai.common.user.c.e().x(p72.l().r(params.itemId, seatNew.sid + ""));
                return;
            }
            cn.damai.common.user.c.e().x(p72.l().o(params.itemId + "", params.performId + "", seatNew.sid + ""));
        }
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179320883")) {
            ipChange.ipc$dispatch("-1179320883", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("seat_vr_data_bind", new a());
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void onVRInfoClick() {
        StaticSeat3DVrInfo staticSeat3DVrInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134763249")) {
            ipChange.ipc$dispatch("134763249", new Object[]{this});
        } else if (hasVRImage()) {
            t72 viewData = this.mModel.getViewData();
            Intent intent = new Intent(this.mContext, VRImageActivity.class);
            SeatNew lastedSelectSeat = this.mModel.getLastedSelectSeat();
            if (lastedSelectSeat != null && (staticSeat3DVrInfo = lastedSelectSeat.vr3DImg) != null) {
                String img = staticSeat3DVrInfo.getImg();
                if (TextUtils.isEmpty(img)) {
                    cn.damai.common.util.toastutil.a.i(this.mContext, "VR 参数异常");
                    return;
                }
                TbParams params = this.mModel.getParams();
                intent.putExtra(VRAlarmBean.VR_ALARM_KEY, new VRAlarmBean(params.itemId + "", params.performId + ""));
                intent.putExtra(VRImageActivity.VR_Img_Url, img);
                intent.putExtra(VRImageActivity.VR_Thumb_Img_Url, lastedSelectSeat.vr3DImg.getThumb());
                intent.putExtra(VRImageActivity.VR_SEAT_ID, lastedSelectSeat.sid);
                intent.putExtra(VRImageActivity.VR_FLOORID_ID, lastedSelectSeat.kanTaiId);
                intent.putExtra(VRImageActivity.VR_XOR_PERFORM_ID, viewData.i.xorPerformId);
                intent.putExtra(VRImageActivity.VR_CITY_ID, viewData.i.cityId);
                intent.putExtra(VRImageActivity.VR_REGION_3DVR_INFO, viewData.i.regionSeatData.seatExtInfo.seat3dvrInfo);
                DMNav.from(this.mContext).withExtras(intent.getExtras()).toHost("vr_seat_activity");
            }
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292939851")) {
            ipChange.ipc$dispatch("-1292939851", new Object[]{this});
        } else if (this.mModel.isLoadFinish()) {
            this.mView.showLoading(true);
            this.mModel.refresh(this.mSeatUiListener);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.Presenter
    public void start(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1389617952")) {
            ipChange.ipc$dispatch("-1389617952", new Object[]{this, tbParams});
            return;
        }
        this.mModel.prepare(tbParams, new c());
    }
}
