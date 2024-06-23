package cn.damai.category.categorygirl.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.categorygirl.repository.CategoryGirlRepository;
import cn.damai.category.categorygirl.request.SearchListRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CategoryGirlModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private CategoryGirlRepository mRepository;
    private MutableLiveData<SearchResultBean> mSearchResultBean = new MutableLiveData<>();

    public CategoryGirlModel(Context context) {
        this.mContext = context;
        this.mRepository = new CategoryGirlRepository();
    }

    public MutableLiveData<SearchResultBean> getSearchListBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1650509845")) {
            return this.mSearchResultBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1650509845", new Object[]{this});
    }

    public void searchRequest(SearchListRequest searchListRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054311977")) {
            ipChange.ipc$dispatch("1054311977", new Object[]{this, searchListRequest});
            return;
        }
        this.mRepository.getSearch(searchListRequest, new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.category.categorygirl.model.CategoryGirlModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "414782915")) {
                    ipChange.ipc$dispatch("414782915", new Object[]{this, str, str2});
                    return;
                }
                CategoryGirlModel.this.mSearchResultBean.setValue(null);
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1026416659")) {
                    ipChange.ipc$dispatch("1026416659", new Object[]{this, searchResultBean});
                    return;
                }
                CategoryGirlModel.this.mSearchResultBean.setValue(searchResultBean);
            }
        });
    }
}
