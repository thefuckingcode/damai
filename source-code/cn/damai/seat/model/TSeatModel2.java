package cn.damai.seat.model;

import android.graphics.Picture;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.UtDynamic;
import cn.damai.seat.bean.UtExtra;
import cn.damai.seat.bean.UtStatus;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.contract.TbSeatContract;
import cn.damai.seat.helper.b;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.net.ImageListener;
import cn.damai.seat.listener.seatui.ApiType;
import cn.damai.seat.listener.seatui.OnSeatUiListener;
import cn.damai.seat.request.BufferUtil;
import cn.damai.seat.support.combine.OnPicCombineListener;
import cn.damai.seat.support.combine.OnSeatCombineListener;
import cn.damai.tool2.bufferkit.BufferListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.b01;
import tb.cd;
import tb.f72;
import tb.g72;
import tb.i62;
import tb.j62;
import tb.k62;
import tb.kl1;
import tb.kq1;
import tb.l62;
import tb.l72;
import tb.lq1;
import tb.lr;
import tb.m72;
import tb.mv1;
import tb.o62;
import tb.p72;
import tb.q72;
import tb.r62;
import tb.s72;
import tb.t72;
import tb.v72;
import tb.vz0;
import tb.x62;
import tb.zz0;

/* compiled from: Taobao */
public class TSeatModel2 extends SeatModelImpl implements TbSeatContract.TbSeatModel, OnPicCombineListener, OnSeatCombineListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDynamic mDynamic;
    private b01[] mImgOptions;
    private TbParams mParams;
    private kq1 mPicCombiner;
    private PriceLevel mPrice;
    private Picture mPriceFilterPicture;
    private List<Price> mPriceList;
    private String mPrivilegeSkuIds;
    private RegionData mRegionData;
    private List<Region> mRegions;
    private r62 mSeat3DVrOption;
    private b mSeatBasket;
    private x62 mSeatCombiner;
    private m72 mSeatOption;
    private t72 mSeatViewData = new t72();
    private q72 mUiListener = new q72();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadSeatVrInfo(boolean z) {
        RegionSeatData regionSeatData;
        RegionSeatExtInfo regionSeatExtInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661421153")) {
            ipChange.ipc$dispatch("-1661421153", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RegionData regionData = this.mRegionData;
        if (regionData != null && (regionSeatData = regionData.regionSeatData) != null && regionSeatData.has3dvrImg && (regionSeatExtInfo = regionSeatData.seatExtInfo) != null) {
            this.mSeat3DVrOption = r62.g(regionSeatExtInfo.seat3dvrInfo, z, this.mParams.xorPerformId);
            i62.r().h(this.mSeat3DVrOption, new RequestListener<SeatBox, j62>() {
                /* class cn.damai.seat.model.TSeatModel2.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
                public void onFail(kl1<j62> kl1, String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-402865169")) {
                        ipChange.ipc$dispatch("-402865169", new Object[]{this, kl1, str, str2});
                        return;
                    }
                    s72.f("Seat VR Loader fail code" + str + " msg" + str2);
                }

                public void onSuccess(kl1<j62> kl1, SeatBox seatBox) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1058284888")) {
                        ipChange.ipc$dispatch("1058284888", new Object[]{this, kl1, seatBox});
                        return;
                    }
                    TSeatModel2.this.update3DVrData(seatBox);
                }
            });
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean changePrice(PriceLevel priceLevel, int i) {
        PriceLevel priceLevel2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612445579")) {
            return ((Boolean) ipChange.ipc$dispatch("-1612445579", new Object[]{this, priceLevel, Integer.valueOf(i)})).booleanValue();
        }
        if (this.mPrice == priceLevel) {
            this.mPrice = null;
        } else {
            this.mPrice = priceLevel;
        }
        if (this.mRegionData.isSmallVenue() || (priceLevel2 = this.mPrice) == null) {
            this.mPriceFilterPicture = null;
        } else {
            this.mPriceFilterPicture = this.mPicCombiner.b(priceLevel2);
        }
        return true;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean changeSeat(SeatNew seatNew, boolean z, Action action) {
        PriceLevel priceLevel;
        boolean z2;
        IpChange ipChange = $ipChange;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "825392143")) {
            return ((Boolean) ipChange.ipc$dispatch("825392143", new Object[]{this, seatNew, Boolean.valueOf(z), action})).booleanValue();
        }
        boolean j = this.mSeatBasket.j(seatNew, z);
        if (z && j && (priceLevel = this.mPrice) != null) {
            long j2 = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            if (priceLevel.isFreeCombineTiaoPiao()) {
                z2 = !this.mPrice.getSubPriceIds().contains(Long.valueOf(j2));
            } else {
                if (j2 != this.mPrice.getPriceId()) {
                    z3 = true;
                }
                z2 = z3;
            }
            if (z2) {
                this.mPrice = null;
                this.mPriceFilterPicture = null;
                action.call();
            }
        }
        return j;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void computeSeat(SeatComputeListener seatComputeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372986279")) {
            ipChange.ipc$dispatch("-1372986279", new Object[]{this, seatComputeListener});
            return;
        }
        this.mSeatBasket.l(seatComputeListener);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public SeatNew getLastedSelectSeat() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-7122439")) {
            return this.mSeatBasket.v();
        }
        return (SeatNew) ipChange.ipc$dispatch("-7122439", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public TbParams getParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "268998852")) {
            return this.mParams;
        }
        return (TbParams) ipChange.ipc$dispatch("268998852", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public Picture getPriceFilterPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2055899658")) {
            return this.mPriceFilterPicture;
        }
        return (Picture) ipChange.ipc$dispatch("2055899658", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public List<? extends PriceLevel> getPriceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-987590930")) {
            return this.mPriceList;
        }
        return (List) ipChange.ipc$dispatch("-987590930", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public PriceLevel getSelectPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1445520302")) {
            return this.mPrice;
        }
        return (PriceLevel) ipChange.ipc$dispatch("1445520302", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public t72 getViewData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "318494743")) {
            return this.mSeatViewData;
        }
        return (t72) ipChange.ipc$dispatch("318494743", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean isLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529758229")) {
            return ((Boolean) ipChange.ipc$dispatch("-1529758229", new Object[]{this})).booleanValue();
        }
        x62 x62 = this.mSeatCombiner;
        if (x62 == null || this.mPicCombiner == null || !x62.isPrepared() || !this.mPicCombiner.isPrepared()) {
            return false;
        }
        return true;
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void load(final boolean z, OnSeatUiListener onSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524771735")) {
            ipChange.ipc$dispatch("-524771735", new Object[]{this, Boolean.valueOf(z), onSeatUiListener});
            return;
        }
        this.mUiListener.a(onSeatUiListener);
        TbParams tbParams = this.mParams;
        this.mSeatOption = m72.g(tbParams.itemId, tbParams.performId, this.mRegionData, z, tbParams.xorPerformId);
        b01[] f = b01.f(this.mRegionData, z, this.mParams.xorPerformId);
        this.mImgOptions = f;
        if (this.mSeatOption != null && f != null) {
            l72.r().h(this.mSeatOption, new RequestListener<SeatBox, f72>() {
                /* class cn.damai.seat.model.TSeatModel2.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
                public void onFail(kl1<f72> kl1, String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1258210926")) {
                        ipChange.ipc$dispatch("-1258210926", new Object[]{this, kl1, str, str2});
                        return;
                    }
                    s72.f("SeatLoader fail code" + str + " msg" + str2);
                    TSeatModel2 tSeatModel2 = TSeatModel2.this;
                    tSeatModel2.pageAlarm(tSeatModel2.mSeatOption.d(), "SVG选座页", str, str2, "seatselect", null);
                    TSeatModel2.this.mUiListener.onFail(222, str, str2, null);
                    p72.l().w(UtExtra.fail(TSeatModel2.this.mParams, kl1, str, str2));
                }

                public void onSuccess(kl1<f72> kl1, SeatBox seatBox) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2114626043")) {
                        ipChange.ipc$dispatch("2114626043", new Object[]{this, kl1, seatBox});
                        return;
                    }
                    s72.f("SeatLoader success " + seatBox.getTotalSeatCount());
                    TSeatModel2.this.mSeatBasket.g(seatBox.mPackageSeatMap);
                    TSeatModel2.this.mSeatCombiner.e(seatBox);
                    p72.l().w(UtExtra.success(TSeatModel2.this.mParams, kl1));
                    TSeatModel2.this.loadSeatVrInfo(z);
                }
            });
            zz0 t = zz0.t();
            TbParams tbParams2 = this.mParams;
            t.r(new ImageListener(tbParams2.itemId, tbParams2.performId) {
                /* class cn.damai.seat.model.TSeatModel2.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.seat.listener.net.ImageListener
                public void onNetFail(kl1<vz0> kl1, String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1084613174")) {
                        ipChange.ipc$dispatch("1084613174", new Object[]{this, kl1, str, str2});
                        return;
                    }
                    s72.f("ImageLoader fail code" + str + " msg" + str2);
                    if (!(TSeatModel2.this.mRegionData == null || TSeatModel2.this.mRegionData.ri == null)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("rainbowSvgImg", TSeatModel2.this.mRegionData.ri.rainbowSvgImg);
                        TSeatModel2 tSeatModel2 = TSeatModel2.this;
                        tSeatModel2.pageAlarm(tSeatModel2.mRegionData.ri.seatSvgImg, "SVG选座页", str, str2, "seatselect", hashMap);
                    }
                    TSeatModel2.this.mUiListener.onFail(111, str, str2, kl1.d());
                    p72.l().v(UtExtra.fail(TSeatModel2.this.mParams, kl1, str, str2));
                }

                @Override // cn.damai.seat.listener.net.ImageListener
                public void onNetSuccess(kl1<vz0> kl1, ImageData imageData) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1756301088")) {
                        ipChange.ipc$dispatch("-1756301088", new Object[]{this, kl1, imageData});
                        return;
                    }
                    s72.f("ImageLoader success");
                    TSeatModel2.this.mPicCombiner.c(imageData);
                    p72.l().v(UtExtra.success(TSeatModel2.this.mParams, kl1));
                }
            }, this.mImgOptions);
            refresh(onSeatUiListener);
        }
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void load3DVrImageData(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872284007")) {
            ipChange.ipc$dispatch("1872284007", new Object[]{this, seatNew});
        } else if (seatNew != null && seatNew.vr3DImg != null) {
            t72 viewData = getViewData();
            RegionData regionData = viewData.i;
            o62 g = o62.g(true, regionData.xorPerformId, regionData.cityId, seatNew.sid, seatNew.kanTaiId, seatNew.vr3DImg.getImg(), seatNew.vr3DImg.getImgHash(), viewData.i.regionSeatData.seatExtInfo.seat3dvrInfo, v72.b().d());
            if (g != null) {
                l62.r().h(g, new RequestListener<ImageData, k62>() {
                    /* class cn.damai.seat.model.TSeatModel2.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
                    public void onFail(kl1<k62> kl1, String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "743675344")) {
                            ipChange.ipc$dispatch("743675344", new Object[]{this, kl1, str, str2});
                        }
                    }

                    public void onSuccess(kl1<k62> kl1, ImageData imageData) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1043922938")) {
                            ipChange.ipc$dispatch("1043922938", new Object[]{this, kl1, imageData});
                        }
                    }
                });
            }
        }
    }

    @Override // cn.damai.seat.model.SeatModelImpl, cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114191717")) {
            ipChange.ipc$dispatch("114191717", new Object[]{this});
            return;
        }
        super.onDestroy();
        try {
            q72 q72 = this.mUiListener;
            if (q72 != null) {
                q72.a(null);
            }
            x62 x62 = this.mSeatCombiner;
            if (x62 != null) {
                x62.h();
            }
            b bVar = this.mSeatBasket;
            if (bVar != null) {
                bVar.x();
            }
            l72 r = l72.r();
            i62 r2 = i62.r();
            zz0 t = zz0.t();
            m72 m72 = this.mSeatOption;
            if (m72 != null) {
                r.b(m72);
                r.q(this.mSeatOption);
            }
            r62 r62 = this.mSeat3DVrOption;
            if (r62 != null) {
                r2.b(r62);
                r2.q(this.mSeat3DVrOption);
            }
            b01[] b01Arr = this.mImgOptions;
            if (b01Arr != null) {
                t.c(b01Arr);
                t.s(this.mImgOptions);
            }
            TbParams tbParams = this.mParams;
            if (tbParams != null && tbParams.firstPayChooseSeat) {
                r.p();
                t.p();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.seat.support.combine.OnPicCombineListener
    public void onPicCombineFinish(lq1 lq1) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-919235913")) {
            ipChange.ipc$dispatch("-919235913", new Object[]{this, lq1});
            return;
        }
        s72.f("onPicCombineFinish");
        if (this.mPrice != null && !this.mRegionData.isSmallVenue()) {
            this.mPriceFilterPicture = this.mPicCombiner.b(this.mPrice);
        }
        this.mSeatViewData.b(lq1);
        this.mUiListener.showPriceList(this.mPriceList, this.mPrice, getIconProvider());
        q72 q72 = this.mUiListener;
        t72 t72 = this.mSeatViewData;
        if (!this.mPicCombiner.isPrepared() || !this.mSeatCombiner.isPrepared()) {
            z = false;
        }
        q72.showSeatUi(t72, z);
    }

    @Override // cn.damai.seat.support.combine.OnSeatCombineListener
    public void onSeatCombineFinish(RegionSeatRequestChecker regionSeatRequestChecker, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2133565984")) {
            ipChange.ipc$dispatch("-2133565984", new Object[]{this, regionSeatRequestChecker, seatBox});
            return;
        }
        s72.f("onSeatCombineFinish");
        if (this.mSeatBasket.A() != 51) {
            this.mUiListener.toast(R$string.seat_sold_reselect_tip);
        }
        this.mSeatViewData.a(regionSeatRequestChecker, seatBox);
        q72 q72 = this.mUiListener;
        t72 t72 = this.mSeatViewData;
        if (!this.mPicCombiner.isPrepared() || !this.mSeatCombiner.isPrepared()) {
            z = false;
        }
        q72.showSeatUi(t72, z);
        this.mUiListener.onSelectSeatChanged();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void prepare(@NonNull TbParams tbParams, SimpleCallBack<RegionData> simpleCallBack) {
        RegionSeatExtInfo regionSeatExtInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278749011")) {
            ipChange.ipc$dispatch("278749011", new Object[]{this, tbParams, simpleCallBack});
            return;
        }
        this.mParams = tbParams;
        initPageAlarmExt(tbParams);
        RegionData a = new lr().a(tbParams.xorPerformId);
        this.mRegionData = a;
        if (a == null || !a.checkBaseValid()) {
            pageAlarm("", "SVG选座页", "", "数据异常，请退出重试![预加载]", "seatselect", null);
            simpleCallBack.onFail("", "麦麦开小差了，请稍后重试哦");
            return;
        }
        newIconProvider(this.mRegionData.ri.seatStyle);
        this.mRegions = g72.g(this.mRegionData.ri.regionList);
        TbParams tbParams2 = this.mParams;
        this.mSeatCombiner = new x62(this, tbParams2.itemId, tbParams2.performId, this.mRegionData.ri.vesion);
        this.mPicCombiner = new kq1(this.mRegionData, this);
        this.mSeatViewData.c(getIconProvider(), this.mRegionData, this.mRegions);
        b bVar = new b(tbParams);
        this.mSeatBasket = bVar;
        bVar.f(this.mRegions, this.mParams.limitCount, this.mRegionData.isNeedPreCheck);
        TbParams tbParams3 = this.mParams;
        if (!tbParams3.firstPayChooseSeat) {
            this.mPrice = g72.D(tbParams3.itemId);
        }
        TbParams tbParams4 = this.mParams;
        this.mPrivilegeSkuIds = g72.p(tbParams4.privilegeId, tbParams4.itemId, tbParams4.firstPayChooseSeat);
        RegionSeatData regionSeatData = this.mRegionData.regionSeatData;
        if (!(regionSeatData == null || (regionSeatExtInfo = regionSeatData.seatExtInfo) == null || regionSeatExtInfo.seat3dvrInfo == null)) {
            v72.b().c(this.mRegionData.regionSeatData.seatExtInfo.seat3dvrInfo.imgDecrypt);
        }
        simpleCallBack.onSuccess(this.mRegionData);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public PromotionDataBean promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534246924")) {
            return (PromotionDataBean) ipChange.ipc$dispatch("-534246924", new Object[]{this});
        }
        SeatDynamic seatDynamic = this.mDynamic;
        if (seatDynamic == null || !seatDynamic.showPromotion()) {
            return null;
        }
        long j = this.mParams.itemId;
        PromotionBean promotionBean = this.mDynamic.promotionDetail;
        return new PromotionDataBean("preferentialexplain", j, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void refresh(OnSeatUiListener onSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020280958")) {
            ipChange.ipc$dispatch("1020280958", new Object[]{this, onSeatUiListener});
            return;
        }
        this.mUiListener.a(onSeatUiListener);
        this.mPicCombiner.removeDynamic();
        this.mSeatCombiner.removeDynamic();
        String str = null;
        TbParams tbParams = this.mParams;
        if (tbParams.firstPayChooseSeat) {
            str = tbParams.payFirstPriceIds;
        }
        addCancelable(new mv1(BufferUtil.loadDynamic(tbParams.projectId, tbParams.itemId, tbParams.performId, str, tbParams.privilegeId, this.mPrivilegeSkuIds, tbParams.hasPromotion, new BufferListener<SeatDynamic>() {
            /* class cn.damai.seat.model.TSeatModel2.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void doRequestAsync() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1381699869")) {
                    ipChange.ipc$dispatch("-1381699869", new Object[]{this});
                }
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1780922514")) {
                    ipChange.ipc$dispatch("1780922514", new Object[]{this, str, str2});
                    return;
                }
                s72.f("SeatDynamicApi fail code" + str + " msg" + str2);
                TSeatModel2.this.mUiListener.onFail(ApiType.API_DYNAMIC, str, str2, null);
                p72.l().u(new UtDynamic(false, TSeatModel2.this.mParams, str, str2));
            }

            public void onSuccess(SeatDynamic seatDynamic) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "4081580")) {
                    ipChange.ipc$dispatch("4081580", new Object[]{this, seatDynamic});
                    return;
                }
                s72.f("SeatDynamicApi success");
                TSeatModel2.this.mDynamic = seatDynamic;
                TSeatModel2.this.mSeatBasket.h(seatDynamic.needCalc(), seatDynamic.calcFailSafe(), seatDynamic.calculateTag(), seatDynamic.getPriceManager());
                TSeatModel2.this.mPriceList = seatDynamic.priceList;
                TSeatModel2 tSeatModel2 = TSeatModel2.this;
                tSeatModel2.mPrice = g72.B(tSeatModel2.mPriceList, TSeatModel2.this.mPrice);
                seatDynamic.updateRegions(TSeatModel2.this.mRegions);
                PriceInfo priceInfo = new PriceInfo(seatDynamic.getSummaryMap());
                TSeatModel2.this.mPicCombiner.d(priceInfo);
                TSeatModel2.this.mSeatCombiner.f(seatDynamic.getPriceManager());
                TSeatModel2.this.mUiListener.showHeadView(new HeadBean(seatDynamic, !TSeatModel2.this.mParams.firstPayChooseSeat));
                if (!priceInfo.hasSeat()) {
                    TSeatModel2.this.mUiListener.toast(R$string.seat_sold_out_tip);
                }
                p72.l().u(new UtDynamic(true, TSeatModel2.this.mParams, null, null));
                TSeatModel2 tSeatModel22 = TSeatModel2.this;
                tSeatModel22.utExposureDiscountInfo("seatselect", tSeatModel22.mParams.itemId, seatDynamic.getSkuPromotionRelations());
            }
        }, new cd() {
            /* class cn.damai.seat.model.TSeatModel2.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // tb.cd
            public boolean is4Preload() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1207987839")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("-1207987839", new Object[]{this})).booleanValue();
            }
        })));
        TbParams tbParams2 = this.mParams;
        addCancelable(new mv1(BufferUtil.loadStatus(tbParams2.itemId, tbParams2.projectId, tbParams2.performId, this.mRegionData.ri.vesion, null, this.mSeatBasket.p(), new BufferListener<CompressSeatStatus>() {
            /* class cn.damai.seat.model.TSeatModel2.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void doRequestAsync() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-958998043")) {
                    ipChange.ipc$dispatch("-958998043", new Object[]{this});
                }
            }

            @Override // cn.damai.tool2.bufferkit.BufferListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1765403796")) {
                    ipChange.ipc$dispatch("1765403796", new Object[]{this, str, str2});
                    return;
                }
                s72.f("CompressStatusApi fail code" + str + " msg" + str2);
                TSeatModel2.this.pageAlarm("mtop.damai.wireless.seat.dynamicInfo", "SVG选座页", str, str2, "seatselect", null);
                TSeatModel2.this.mUiListener.onFail(333, str, str2, null);
                p72.l().x(new UtStatus(false, TSeatModel2.this.mParams, str, str2));
            }

            public void onSuccess(CompressSeatStatus compressSeatStatus) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-829357325")) {
                    ipChange.ipc$dispatch("-829357325", new Object[]{this, compressSeatStatus});
                    return;
                }
                s72.f("CompressStatusApi success");
                TSeatModel2.this.mSeatCombiner.g(compressSeatStatus);
                p72.l().x(new UtStatus(true, TSeatModel2.this.mParams, null, null));
            }
        }, new cd() {
            /* class cn.damai.seat.model.TSeatModel2.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // tb.cd
            public boolean is4Preload() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1498631555")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("1498631555", new Object[]{this})).booleanValue();
            }
        })));
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void removeAllSeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784078466")) {
            ipChange.ipc$dispatch("-784078466", new Object[]{this});
            return;
        }
        this.mSeatBasket.y();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public boolean shouldShowDiffRowTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37139896")) {
            return ((Boolean) ipChange.ipc$dispatch("37139896", new Object[]{this})).booleanValue();
        }
        RegionData regionData = this.mRegionData;
        return regionData != null && regionData.sameRowNotify && this.mSeatBasket.u();
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void submitSeat(OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649463773")) {
            ipChange.ipc$dispatch("649463773", new Object[]{this, onSubmitListener});
            return;
        }
        this.mSeatBasket.z(onSubmitListener);
    }

    @Override // cn.damai.seat.contract.TbSeatContract.TbSeatModel
    public void update3DVrData(SeatBox seatBox) {
        SeatBox d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691193446")) {
            ipChange.ipc$dispatch("-1691193446", new Object[]{this, seatBox});
        } else if (seatBox != null && (d = this.mSeatCombiner.d()) != null) {
            d.seat3DVrInfoMap = seatBox.seat3DVrInfoMap;
            d.bindVrData();
        }
    }
}
