package cn.damai.seat.model;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.contract.RegionContract;
import cn.damai.seat.helper.b;
import cn.damai.seat.listener.OnPerformListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.net.ImageListener;
import cn.damai.seat.listener.net.MtopSeatDynamicListener;
import cn.damai.seat.listener.seatui.ApiType;
import cn.damai.seat.listener.seatui.OnJpgRegionUiListener;
import cn.damai.seat.request.MtopSeatDynamicRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.b01;
import tb.cb;
import tb.ep1;
import tb.ez0;
import tb.g72;
import tb.gq;
import tb.kl1;
import tb.lr;
import tb.m41;
import tb.r72;
import tb.vz0;
import tb.zz0;

/* compiled from: Taobao */
public class RegionModel extends SeatModelImpl implements RegionContract.RegionModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDynamic mDynamic;
    private b01 mJpgOption;
    private TbParams mParams;
    private List<Price> mPriceList;
    private String mPrivilegeSkuIds;
    private RegionData mRegionData;
    private List<Region> mRegions;
    private b mSeatBasket;
    private PriceLevel mSelected;
    private m41 mUiListener = new m41();
    private Map<String, String> pageAlarmExt = new HashMap();
    private Bitmap venueImage;

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void changePerform(@NonNull final ClickedPerform clickedPerform, final OnPerformListener onPerformListener) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1189075699")) {
            ipChange.ipc$dispatch("-1189075699", new Object[]{this, clickedPerform, onPerformListener});
        } else if (clickedPerform.isHasPerform() && onPerformListener != null) {
            long j = clickedPerform.perform.performId;
            if (j == this.mParams.performId) {
                z = true;
            }
            if (!z || !isLoadFinish()) {
                onPerformListener.doNetWork(true);
                loadRegionData(j, new SimpleCallBack<RegionData>() {
                    /* class cn.damai.seat.model.RegionModel.AnonymousClass4 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.seat.listener.SimpleCallBack
                    public void onFail(String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "2017456196")) {
                            ipChange.ipc$dispatch("2017456196", new Object[]{this, str, str2});
                            return;
                        }
                        onPerformListener.doNetWork(false);
                        onPerformListener.onNetFail(str, str2);
                    }

                    public void onSuccess(RegionData regionData) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-81710454")) {
                            ipChange.ipc$dispatch("-81710454", new Object[]{this, regionData});
                            return;
                        }
                        onPerformListener.doNetWork(false);
                        ClickedPerform clickedPerform = clickedPerform;
                        long c = g72.c(clickedPerform.basic.itemId, clickedPerform.perform.performId);
                        TbParams tbParams = RegionModel.this.mParams;
                        ClickedPerform clickedPerform2 = clickedPerform;
                        TbParams tbParams2 = new TbParams(tbParams, clickedPerform2.basic, clickedPerform2.perform, clickedPerform2.appNewUlTron(), clickedPerform.h5NewUlTron());
                        tbParams2.skuId = c;
                        onPerformListener.onPerformChanged(tbParams2, regionData.isSmallVenue());
                    }
                });
                return;
            }
            PriceLevel n = g72.n(clickedPerform.price, this.mPriceList);
            if (n != null && n.isSalable() && n != this.mSelected) {
                this.mSelected = n;
                onPerformListener.onPriceChangedOnly();
            }
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public TbParams createParams2SeatPage(Region region) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178455292")) {
            return (TbParams) ipChange.ipc$dispatch("-178455292", new Object[]{this, region});
        }
        TbParams tbParams = new TbParams(this.mParams);
        tbParams.basketNo = this.mSeatBasket.b;
        tbParams.openRegionId = region.id + "";
        return tbParams;
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public TbParams getParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1225338313")) {
            return this.mParams;
        }
        return (TbParams) ipChange.ipc$dispatch("-1225338313", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public List<? extends PriceLevel> getPriceList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2021870373")) {
            return this.mPriceList;
        }
        return (List) ipChange.ipc$dispatch("-2021870373", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public List<Region> getRegions() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2138473939")) {
            return this.mRegions;
        }
        return (List) ipChange.ipc$dispatch("2138473939", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public PriceLevel getSelectPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1956623067")) {
            return this.mSelected;
        }
        return (PriceLevel) ipChange.ipc$dispatch("1956623067", new Object[]{this});
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public boolean isLoadFinish() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-850388066")) {
            return (this.venueImage == null || this.mDynamic == null) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-850388066", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void load(boolean z, OnJpgRegionUiListener onJpgRegionUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157344080")) {
            ipChange.ipc$dispatch("157344080", new Object[]{this, Boolean.valueOf(z), onJpgRegionUiListener});
            return;
        }
        this.mUiListener.a(onJpgRegionUiListener);
        this.mJpgOption = b01.h(z, this.mRegionData.ri.seatImg, this.mParams.xorPerformId);
        zz0 t = zz0.t();
        TbParams tbParams = this.mParams;
        t.r(new ImageListener(tbParams.itemId, tbParams.performId) {
            /* class cn.damai.seat.model.RegionModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetFail(kl1<vz0> kl1, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1563860760")) {
                    ipChange.ipc$dispatch("-1563860760", new Object[]{this, kl1, str, str2});
                    return;
                }
                RegionModel.this.pageAlarm("", "JPG选区页", str, str2, r72.PAGE_AREA, null);
                RegionModel.this.mUiListener.onFail(111, str, str2, null);
            }

            @Override // cn.damai.seat.listener.net.ImageListener
            public void onNetSuccess(kl1<vz0> kl1, ImageData imageData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2075091694")) {
                    ipChange.ipc$dispatch("-2075091694", new Object[]{this, kl1, imageData});
                    return;
                }
                RegionModel.this.venueImage = imageData.getJPG();
                RegionModel.this.mUiListener.showRegionUi(RegionModel.this.venueImage, RegionModel.this.mRegions, RegionModel.this.mSelected, RegionModel.this.isLoadFinish());
            }
        }, this.mJpgOption);
        refresh(onJpgRegionUiListener);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void loadRegionData(long j, final SimpleCallBack<RegionData> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "687253331")) {
            ipChange.ipc$dispatch("687253331", new Object[]{this, Long.valueOf(j), simpleCallBack});
            return;
        }
        ez0.c(this.mParams.itemId, j, false);
        String str = this.mParams.cityId;
        long a = ep1.a(j);
        addBusiness(new MtopBBCAreaInfoRequest(str, a, (String) null, gq.c()).request(new MtopRegionDataListener(this.mParams.itemId, str, j, a) {
            /* class cn.damai.seat.model.RegionModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onBizFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1370273280")) {
                    ipChange.ipc$dispatch("-1370273280", new Object[]{this, str, str2});
                    return;
                }
                RegionModel.this.pageAlarm("mtop.damai.wireless.project.getB2B2CAreaInfo", "JPG选区页", str, str2, r72.PAGE_AREA, null);
                simpleCallBack.onFail(str, str2);
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onRegionData(@NonNull RegionData regionData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2133375552")) {
                    ipChange.ipc$dispatch("2133375552", new Object[]{this, regionData});
                    return;
                }
                simpleCallBack.onSuccess(regionData);
            }
        }));
    }

    @Override // cn.damai.seat.model.SeatModelImpl, cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875223918")) {
            ipChange.ipc$dispatch("-875223918", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mJpgOption != null) {
            zz0 t = zz0.t();
            t.q(this.mJpgOption);
            t.b(this.mJpgOption);
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void onPriceSelectChanged(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829154982")) {
            ipChange.ipc$dispatch("-1829154982", new Object[]{this, priceLevel});
        } else if (priceLevel == this.mSelected) {
            this.mSelected = null;
        } else {
            this.mSelected = priceLevel;
        }
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void prepare(TbParams tbParams, SimpleCallBack<TbParams> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752700282")) {
            ipChange.ipc$dispatch("-1752700282", new Object[]{this, tbParams, simpleCallBack});
            return;
        }
        this.mParams = tbParams;
        initPageAlarmExt(tbParams);
        this.mRegionData = new lr().a(tbParams.xorPerformId);
        this.mSeatBasket = cb.b(tbParams);
        RegionData regionData = this.mRegionData;
        if (regionData == null || !regionData.checkBaseValid()) {
            pageAlarm("", "JPG选区页", "", "数据异常，请退出重试![预加载]", r72.PAGE_AREA, null);
            simpleCallBack.onFail("", "麦麦开小差了，请稍后重试哦");
            return;
        }
        newIconProvider(3);
        this.mRegions = new ArrayList(this.mRegionData.ri.regionList);
        this.mSelected = g72.D(this.mParams.itemId);
        TbParams tbParams2 = this.mParams;
        this.mPrivilegeSkuIds = g72.p(tbParams2.privilegeId, tbParams2.itemId, tbParams2.firstPayChooseSeat);
        simpleCallBack.onSuccess(this.mParams);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public PromotionDataBean promotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869930393")) {
            return (PromotionDataBean) ipChange.ipc$dispatch("-1869930393", new Object[]{this});
        }
        SeatDynamic seatDynamic = this.mDynamic;
        if (seatDynamic == null || !seatDynamic.showPromotion()) {
            return null;
        }
        long j = this.mParams.itemId;
        PromotionBean promotionBean = this.mDynamic.promotionDetail;
        return new PromotionDataBean("preferentialexplain", j, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null);
    }

    @Override // cn.damai.seat.contract.RegionContract.RegionModel
    public void refresh(OnJpgRegionUiListener onJpgRegionUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458500507")) {
            ipChange.ipc$dispatch("1458500507", new Object[]{this, onJpgRegionUiListener});
            return;
        }
        this.mUiListener.a(onJpgRegionUiListener);
        this.mDynamic = null;
        TbParams tbParams = this.mParams;
        MtopSeatDynamicRequest mtopSeatDynamicRequest = new MtopSeatDynamicRequest(tbParams.projectId, tbParams.itemId, tbParams.performId, null, tbParams.privilegeId, this.mPrivilegeSkuIds, tbParams.hasPromotion);
        TbParams tbParams2 = this.mParams;
        addBusiness(mtopSeatDynamicRequest.request(new MtopSeatDynamicListener(tbParams2.itemId, tbParams2.performId) {
            /* class cn.damai.seat.model.RegionModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "906481879")) {
                    ipChange.ipc$dispatch("906481879", new Object[]{this, str, str2});
                    return;
                }
                RegionModel.this.pageAlarm("mtop.damai.wireless.seat.dynamicInfo", "JPG选区页", str, str2, r72.PAGE_AREA, null);
                RegionModel.this.mUiListener.onFail(ApiType.API_DYNAMIC, str, str2, null);
            }

            public void onNetSuccess(@NonNull SeatDynamic seatDynamic) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1480225465")) {
                    ipChange.ipc$dispatch("-1480225465", new Object[]{this, seatDynamic});
                    return;
                }
                RegionModel.this.mDynamic = seatDynamic;
                RegionModel regionModel = RegionModel.this;
                regionModel.mPriceList = regionModel.mDynamic.priceList;
                RegionModel regionModel2 = RegionModel.this;
                regionModel2.mSelected = g72.B(regionModel2.mPriceList, RegionModel.this.mSelected);
                RegionModel.this.mDynamic.updateRegions(RegionModel.this.mRegions);
                RegionModel.this.mUiListener.showPriceList(RegionModel.this.mPriceList, RegionModel.this.mSelected, RegionModel.this.getIconProvider());
                RegionModel.this.mUiListener.showHeadView(new HeadBean(RegionModel.this.mDynamic, true));
                RegionModel.this.mUiListener.showRegionUi(RegionModel.this.venueImage, RegionModel.this.mRegions, RegionModel.this.mSelected, RegionModel.this.isLoadFinish());
                if (g72.A(RegionModel.this.mPriceList)) {
                    RegionModel.this.mUiListener.toast(R$string.seat_sold_out_tip);
                }
                RegionModel regionModel3 = RegionModel.this;
                regionModel3.utExposureDiscountInfo(r72.PAGE_AREA, regionModel3.mParams.itemId, RegionModel.this.mDynamic.getSkuPromotionRelations());
            }
        }));
    }
}
