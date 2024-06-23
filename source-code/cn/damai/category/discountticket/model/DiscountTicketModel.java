package cn.damai.category.discountticket.model;

import android.text.TextUtils;
import cn.damai.category.discountticket.bean.CommonDiscountData;
import cn.damai.category.discountticket.bean.CouponListRes;
import cn.damai.category.discountticket.bean.DiscountResData;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.NearDiscountData;
import cn.damai.category.discountticket.bean.biz.BannerBean;
import cn.damai.category.discountticket.bean.biz.BannerWrap;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.bean.biz.ViewMoreBean;
import cn.damai.category.discountticket.request.DiscountTicketWrapRequest;
import cn.damai.category.discountticket.request.SearchListRequest;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.d20;
import tb.q80;
import tb.xf2;

/* compiled from: Taobao */
public class DiscountTicketModel extends BaseDiscountModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private int curCount = 0;
    private String mCityId;
    private CouponListRes mCouponListRes;
    private HeaderData mHeaderData;
    private DiscountResData mResData;
    private ProjectItemBean mShareProject;
    private int pageIndex = 1;

    public DiscountTicketModel(String str) {
        this.mCityId = TextUtils.isEmpty(str) ? d20.c() : str;
    }

    static /* synthetic */ int access$008(DiscountTicketModel discountTicketModel) {
        int i = discountTicketModel.pageIndex;
        discountTicketModel.pageIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$512(DiscountTicketModel discountTicketModel, int i) {
        int i2 = discountTicketModel.curCount + i;
        discountTicketModel.curCount = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private FirstPageData formatFirstPageData(DiscountResData discountResData, CouponListRes couponListRes) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757761213")) {
            return (FirstPageData) ipChange.ipc$dispatch("757761213", new Object[]{this, discountResData, couponListRes});
        }
        String str3 = null;
        FirstPageData firstPageData = new FirstPageData(true, null, null);
        ArrayList arrayList = new ArrayList();
        firstPageData.headerData = discountResData.headerData;
        boolean hasCoupons = couponListRes.hasCoupons();
        NearDiscountData nearDiscountData = discountResData.nearDiscountData;
        if (hasCoupons) {
            if (nearDiscountData != null) {
                str3 = nearDiscountData.title;
                str2 = nearDiscountData.shortDesc;
                str = nearDiscountData.ruleUrl;
            } else {
                str2 = null;
                str = null;
            }
            arrayList.add(new HeaderCouponBean(str3, str2, str, couponListRes.couponActivities));
        }
        if (nearDiscountData != null) {
            List<ProjectItemBean> list = nearDiscountData.nearDiscountItems;
            q80.c(0, list);
            List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
            if (xf2.e(adapterList) > 0) {
                arrayList.addAll(adapterList);
            }
            if (nearDiscountData.hasMore) {
                arrayList.add(new ViewMoreBean());
            }
        }
        List<BannerBean> list2 = discountResData.bannerData;
        if (!q80.b(list2)) {
            arrayList.add(new BannerWrap(list2));
        }
        CommonDiscountData commonDiscountData = discountResData.commonDiscountData;
        if (commonDiscountData != null) {
            List<ProjectItemBean> list3 = commonDiscountData.commonDiscountItems;
            q80.c(0, list3);
            if (xf2.e(list3) > 0) {
                if (arrayList.size() > 0) {
                    arrayList.add(new DiscountTipBean(commonDiscountData.title, commonDiscountData.desc));
                }
                arrayList.addAll(list3);
            }
            firstPageData.hasMore = commonDiscountData.hasMore;
        }
        firstPageData.data = arrayList;
        return firstPageData;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isHasMore(SearchResultBean searchResultBean) {
        List<ProjectItemBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906238179")) {
            return ((Boolean) ipChange.ipc$dispatch("1906238179", new Object[]{this, searchResultBean})).booleanValue();
        }
        if (searchResultBean == null || (list = searchResultBean.projectInfo) == null || list.size() == 0 || this.curCount >= searchResultBean.total) {
            return false;
        }
        return true;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public boolean changeCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644953641")) {
            return ((Boolean) ipChange.ipc$dispatch("-644953641", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.equals(str, this.mCityId)) {
            return false;
        } else {
            this.mCityId = str;
            return true;
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public ProjectItemBean firstProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "318901964")) {
            return this.mShareProject;
        }
        return (ProjectItemBean) ipChange.ipc$dispatch("318901964", new Object[]{this});
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1128394383")) {
            return this.mCityId;
        }
        return (String) ipChange.ipc$dispatch("-1128394383", new Object[]{this});
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public HeaderData getHeaderData() {
        DiscountResData discountResData;
        NearDiscountData nearDiscountData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067621859")) {
            return (HeaderData) ipChange.ipc$dispatch("-2067621859", new Object[]{this});
        }
        HeaderData headerData = this.mHeaderData;
        if (!(headerData == null || (discountResData = this.mResData) == null || (nearDiscountData = discountResData.nearDiscountData) == null)) {
            headerData.tempTitle = nearDiscountData.title;
        }
        return headerData;
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void load(final BaseListener<FirstPageData> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962757711")) {
            ipChange.ipc$dispatch("-962757711", new Object[]{this, baseListener});
            return;
        }
        this.pageIndex = 1;
        this.curCount = 0;
        addBusiness(new DiscountTicketWrapRequest(this.mCityId, new DiscountTicketWrapRequest.OnWrapListener() {
            /* class cn.damai.category.discountticket.model.DiscountTicketModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.request.DiscountTicketWrapRequest.OnWrapListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1357213091")) {
                    ipChange.ipc$dispatch("1357213091", new Object[]{this, str, str2});
                    return;
                }
                baseListener.onFail(str, str2);
            }

            @Override // cn.damai.category.discountticket.request.DiscountTicketWrapRequest.OnWrapListener
            public void onRes(DiscountResData discountResData, CouponListRes couponListRes) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "88829610")) {
                    ipChange.ipc$dispatch("88829610", new Object[]{this, discountResData, couponListRes});
                    return;
                }
                DiscountTicketModel.access$008(DiscountTicketModel.this);
                DiscountTicketModel.this.mResData = discountResData;
                DiscountTicketModel.this.mCouponListRes = couponListRes;
                DiscountTicketModel.this.mHeaderData = discountResData.headerData;
                DiscountTicketModel.this.mShareProject = discountResData.getFirstProject();
                DiscountTicketModel.this.curCount = discountResData.getUnNearProjectCount();
                DiscountTicketModel discountTicketModel = DiscountTicketModel.this;
                baseListener.onSuccess(discountTicketModel.formatFirstPageData(discountTicketModel.mResData, DiscountTicketModel.this.mCouponListRes));
            }
        }).g());
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void loadMore(final OnTListener<MorePageData> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513613956")) {
            ipChange.ipc$dispatch("-513613956", new Object[]{this, onTListener});
            return;
        }
        addBusiness(SearchListRequest.request(this.mCityId, false, this.pageIndex, new BaseListener<SearchResultBean>() {
            /* class cn.damai.category.discountticket.model.DiscountTicketModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.model.BaseListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1349453732")) {
                    ipChange.ipc$dispatch("1349453732", new Object[]{this, str, str2});
                    return;
                }
                onTListener.callBack(new MorePageData(false, str, str));
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2027001042")) {
                    ipChange.ipc$dispatch("2027001042", new Object[]{this, searchResultBean});
                    return;
                }
                DiscountTicketModel.access$008(DiscountTicketModel.this);
                List<ProjectItemBean> list = searchResultBean.projectInfo;
                q80.c(DiscountTicketModel.this.curCount, list);
                MorePageData morePageData = new MorePageData(true, null, null);
                morePageData.data = list;
                DiscountTicketModel.access$512(DiscountTicketModel.this, xf2.e(list));
                morePageData.hasMore = DiscountTicketModel.this.isHasMore(searchResultBean);
                onTListener.callBack(morePageData);
            }
        }));
    }
}
