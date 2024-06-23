package cn.damai.search.presenter;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.search.contract.SearchResultContract;
import cn.damai.search.model.SearchListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z52;

/* compiled from: Taobao */
public class SearchResultPresenter extends SearchResultContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.contract.SearchResultContract.Presenter
    public void getSearchList(final String str, String str2, int i, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539982338")) {
            ipChange.ipc$dispatch("539982338", new Object[]{this, str, str2, Integer.valueOf(i), str3, str4});
            return;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.keyword = str;
        searchListRequest.favourableId = str2;
        searchListRequest.pageIndex = i;
        searchListRequest.option = "1073741970";
        searchListRequest.returnItemOption = "3";
        if (!TextUtils.isEmpty(str3)) {
            searchListRequest.longitude = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            searchListRequest.latitude = str4;
        }
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.search.presenter.SearchResultPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-386752815")) {
                    ipChange.ipc$dispatch("-386752815", new Object[]{this, str, str2});
                    return;
                }
                SearchResultPresenter.this.mView.stopLoading();
                SearchResultPresenter.this.mView.error(str, str2, z52.a, str, 1);
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-423351355")) {
                    ipChange.ipc$dispatch("-423351355", new Object[]{this, searchResultBean});
                    return;
                }
                SearchResultPresenter.this.mView.stopLoading();
                SearchResultPresenter.this.mView.returnSearchList(searchResultBean, str);
            }
        });
    }
}
