package cn.damai.category.discountticket.model;

import android.text.TextUtils;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.request.SearchListRequest;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.q80;
import tb.xf2;

/* compiled from: Taobao */
public class MoreDiscountModel extends BaseDiscountModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private int curCount = 0;
    private String mCityId;
    private HeaderData mHeaderData;
    private Column3WrapBean mLastItem;
    private ProjectItemBean mShareProject;
    private int pageIndex;

    public MoreDiscountModel(HeaderData headerData, String str) {
        this.mHeaderData = headerData;
        this.mCityId = q80.a(str);
    }

    static /* synthetic */ int access$008(MoreDiscountModel moreDiscountModel) {
        int i = moreDiscountModel.pageIndex;
        moreDiscountModel.pageIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$112(MoreDiscountModel moreDiscountModel, int i) {
        int i2 = moreDiscountModel.curCount + i;
        moreDiscountModel.curCount = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean hasMore(SearchResultBean searchResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664078430")) {
            return ((Boolean) ipChange.ipc$dispatch("-664078430", new Object[]{this, searchResultBean})).booleanValue();
        } else if (searchResultBean == null || q80.b(searchResultBean.projectInfo) || this.curCount >= searchResultBean.total) {
            return false;
        } else {
            return true;
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public boolean changeCityId(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1947141742")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1947141742", new Object[]{this, str})).booleanValue();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public ProjectItemBean firstProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2075368029")) {
            return this.mShareProject;
        }
        return (ProjectItemBean) ipChange.ipc$dispatch("-2075368029", new Object[]{this});
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1727385208")) {
            return this.mCityId;
        }
        return (String) ipChange.ipc$dispatch("-1727385208", new Object[]{this});
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public HeaderData getHeaderData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-376260428")) {
            return this.mHeaderData;
        }
        return (HeaderData) ipChange.ipc$dispatch("-376260428", new Object[]{this});
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void load(final BaseListener<FirstPageData> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524426566")) {
            ipChange.ipc$dispatch("-1524426566", new Object[]{this, baseListener});
            return;
        }
        this.mLastItem = null;
        this.mShareProject = null;
        this.pageIndex = 1;
        this.curCount = 0;
        addBusiness(SearchListRequest.request(this.mCityId, true, 1, new BaseListener<SearchResultBean>() {
            /* class cn.damai.category.discountticket.model.MoreDiscountModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.model.BaseListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-122137094")) {
                    ipChange.ipc$dispatch("-122137094", new Object[]{this, str, str2});
                    return;
                }
                baseListener.onFail(str, str2);
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-135153604")) {
                    ipChange.ipc$dispatch("-135153604", new Object[]{this, searchResultBean});
                } else if (searchResultBean != null) {
                    MoreDiscountModel.access$008(MoreDiscountModel.this);
                    List<ProjectItemBean> list = searchResultBean.projectInfo;
                    MoreDiscountModel.this.curCount = xf2.e(list);
                    boolean hasMore = MoreDiscountModel.this.hasMore(searchResultBean);
                    ArrayList arrayList = new ArrayList();
                    if (MoreDiscountModel.this.mHeaderData != null && !TextUtils.isEmpty(MoreDiscountModel.this.mHeaderData.tempTitle)) {
                        arrayList.add(new DiscountTipBean(MoreDiscountModel.this.mHeaderData.tempTitle, null));
                    }
                    if (!q80.b(list)) {
                        MoreDiscountModel.this.mShareProject = list.get(0);
                        List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
                        if (!q80.b(adapterList)) {
                            MoreDiscountModel.this.mLastItem = adapterList.get(adapterList.size() - 1);
                            arrayList.addAll(adapterList);
                        }
                    }
                    FirstPageData firstPageData = new FirstPageData(true, null, null);
                    firstPageData.data = arrayList;
                    firstPageData.headerData = MoreDiscountModel.this.mHeaderData;
                    firstPageData.hasMore = hasMore;
                    baseListener.onSuccess(firstPageData);
                } else {
                    onFail("", "");
                }
            }
        }));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void loadMore(final OnTListener<MorePageData> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111955")) {
            ipChange.ipc$dispatch("2111955", new Object[]{this, onTListener});
            return;
        }
        addBusiness(SearchListRequest.request(this.mCityId, true, this.pageIndex, new BaseListener<SearchResultBean>() {
            /* class cn.damai.category.discountticket.model.MoreDiscountModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.category.discountticket.model.BaseListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-129896453")) {
                    ipChange.ipc$dispatch("-129896453", new Object[]{this, str, str2});
                    return;
                }
                onTListener.callBack(new MorePageData(false, str, str2));
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "819075291")) {
                    ipChange.ipc$dispatch("819075291", new Object[]{this, searchResultBean});
                    return;
                }
                MoreDiscountModel.access$008(MoreDiscountModel.this);
                List<ProjectItemBean> list = searchResultBean.projectInfo;
                MoreDiscountModel.access$112(MoreDiscountModel.this, xf2.e(list));
                boolean hasMore = MoreDiscountModel.this.hasMore(searchResultBean);
                if (MoreDiscountModel.this.mLastItem != null) {
                    list = MoreDiscountModel.this.mLastItem.supply(list);
                }
                List<Column3WrapBean> adapterList = Column3WrapBean.toAdapterList(list);
                if (!q80.b(adapterList)) {
                    MoreDiscountModel.this.mLastItem = adapterList.get(adapterList.size() - 1);
                }
                MorePageData morePageData = new MorePageData(true, null, null);
                morePageData.data = adapterList;
                morePageData.hasMore = hasMore;
                onTListener.callBack(morePageData);
            }
        }));
    }
}
