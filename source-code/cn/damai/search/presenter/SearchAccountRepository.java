package cn.damai.search.presenter;

import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.search.bean.SearchAccountBean;
import cn.damai.search.bean.SearchAccountResponse;
import cn.damai.search.bean.SearchFollowResponse;
import cn.damai.search.model.SearchBAccountRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchAccountRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public MutableLiveData<SearchFollowResponse> a(FollowRequest followRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061066941")) {
            return (MutableLiveData) ipChange.ipc$dispatch("2061066941", new Object[]{this, followRequest});
        }
        final MutableLiveData<SearchFollowResponse> mutableLiveData = new MutableLiveData<>();
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.search.presenter.SearchAccountRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1492893150")) {
                    ipChange.ipc$dispatch("1492893150", new Object[]{this, str, str2});
                    return;
                }
                SearchFollowResponse searchFollowResponse = new SearchFollowResponse();
                searchFollowResponse.requestFail = true;
                searchFollowResponse.errorCode = str;
                searchFollowResponse.errorMsg = str2;
                mutableLiveData.setValue(searchFollowResponse);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-691448766")) {
                    ipChange.ipc$dispatch("-691448766", new Object[]{this, followDataBean});
                    return;
                }
                SearchFollowResponse searchFollowResponse = new SearchFollowResponse();
                searchFollowResponse.data = followDataBean;
                mutableLiveData.setValue(searchFollowResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<SearchAccountResponse> b(SearchBAccountRequest searchBAccountRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914151193")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-914151193", new Object[]{this, searchBAccountRequest});
        }
        final MutableLiveData<SearchAccountResponse> mutableLiveData = new MutableLiveData<>();
        searchBAccountRequest.request(new DMMtopRequestListener<SearchAccountBean>(SearchAccountBean.class) {
            /* class cn.damai.search.presenter.SearchAccountRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1500652509")) {
                    ipChange.ipc$dispatch("1500652509", new Object[]{this, str, str2});
                    return;
                }
                SearchAccountResponse searchAccountResponse = new SearchAccountResponse();
                searchAccountResponse.requestFail = true;
                searchAccountResponse.errorCode = str;
                searchAccountResponse.errorMsg = str2;
                mutableLiveData.setValue(searchAccountResponse);
            }

            public void onSuccess(SearchAccountBean searchAccountBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "460384141")) {
                    ipChange.ipc$dispatch("460384141", new Object[]{this, searchAccountBean});
                    return;
                }
                SearchAccountResponse searchAccountResponse = new SearchAccountResponse();
                searchAccountResponse.requestFail = false;
                searchAccountResponse.data = searchAccountBean;
                mutableLiveData.setValue(searchAccountResponse);
            }
        });
        return mutableLiveData;
    }
}
