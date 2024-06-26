package cn.damai.category.inventory.repository;

import androidx.lifecycle.MutableLiveData;
import cn.damai.category.inventory.bean.DetailedBean;
import cn.damai.category.inventory.bean.DetailedBeanResponse;
import cn.damai.category.inventory.request.DetailedRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DetailedRespository {
    private static transient /* synthetic */ IpChange $ipChange;

    public MutableLiveData<DetailedBeanResponse> a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589698062")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1589698062", new Object[]{this, str});
        }
        final MutableLiveData<DetailedBeanResponse> mutableLiveData = new MutableLiveData<>();
        DetailedRequest detailedRequest = new DetailedRequest();
        detailedRequest.id = str;
        detailedRequest.request(new DMMtopRequestListener<DetailedBean>(DetailedBean.class) {
            /* class cn.damai.category.inventory.repository.DetailedRespository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-275630460")) {
                    ipChange.ipc$dispatch("-275630460", new Object[]{this, str, str2});
                    return;
                }
                DetailedBeanResponse detailedBeanResponse = new DetailedBeanResponse();
                detailedBeanResponse.requestSuccess = false;
                detailedBeanResponse.errorCode = str;
                detailedBeanResponse.errorMsg = str2;
                mutableLiveData.setValue(detailedBeanResponse);
            }

            public void onSuccess(DetailedBean detailedBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2100202962")) {
                    ipChange.ipc$dispatch("2100202962", new Object[]{this, detailedBean});
                    return;
                }
                DetailedBeanResponse detailedBeanResponse = new DetailedBeanResponse();
                detailedBeanResponse.requestSuccess = true;
                detailedBeanResponse.detailedBean = detailedBean;
                mutableLiveData.setValue(detailedBeanResponse);
            }
        });
        return mutableLiveData;
    }

    public void b(DMMtopRequestListener<FollowDataBean> dMMtopRequestListener, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845151544")) {
            ipChange.ipc$dispatch("-1845151544", new Object[]{this, dMMtopRequestListener, str, str2});
        } else if (dMMtopRequestListener != null) {
            FollowRequest followRequest = new FollowRequest();
            followRequest.operateType = str;
            followRequest.targetId = str2;
            followRequest.targetType = "14";
            followRequest.request(dMMtopRequestListener);
        }
    }
}
