package cn.damai.mine.mycollect.net;

import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.mine.mycollect.bean.MyCollectFollowResponse;
import cn.damai.mine.mycollect.bean.MyCollectResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyCollectRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public MutableLiveData<MyCollectFollowResponse> cancelFollowResult(FollowRequest followRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124536748")) {
            return (MutableLiveData) ipChange.ipc$dispatch("2124536748", new Object[]{this, followRequest});
        }
        final MutableLiveData<MyCollectFollowResponse> mutableLiveData = new MutableLiveData<>();
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.mine.mycollect.net.MyCollectRepository.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1415572135")) {
                    ipChange.ipc$dispatch("1415572135", new Object[]{this, str, str2});
                    return;
                }
                MyCollectFollowResponse myCollectFollowResponse = new MyCollectFollowResponse();
                myCollectFollowResponse.requestSuccess = false;
                myCollectFollowResponse.errorCode = str;
                myCollectFollowResponse.errorMsg = str2;
                mutableLiveData.setValue(myCollectFollowResponse);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1741617369")) {
                    ipChange.ipc$dispatch("1741617369", new Object[]{this, followDataBean});
                    return;
                }
                MyCollectFollowResponse myCollectFollowResponse = new MyCollectFollowResponse();
                myCollectFollowResponse.requestSuccess = true;
                myCollectFollowResponse.data = followDataBean;
                mutableLiveData.setValue(myCollectFollowResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<MyCollectResponse> getCollectData(MyCollectRequest myCollectRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672900105")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-672900105", new Object[]{this, myCollectRequest});
        }
        final MutableLiveData<MyCollectResponse> mutableLiveData = new MutableLiveData<>();
        myCollectRequest.request(new DMMtopRequestListener<MyCollectResponse>(MyCollectResponse.class) {
            /* class cn.damai.mine.mycollect.net.MyCollectRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1431090853")) {
                    ipChange.ipc$dispatch("1431090853", new Object[]{this, str, str2});
                    return;
                }
                MyCollectResponse myCollectResponse = new MyCollectResponse();
                myCollectResponse.requestSuccess = false;
                myCollectResponse.errorCode = str;
                myCollectResponse.errorMsg = str2;
                mutableLiveData.setValue(myCollectResponse);
            }

            public void onSuccess(MyCollectResponse myCollectResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-947234027")) {
                    ipChange.ipc$dispatch("-947234027", new Object[]{this, myCollectResponse});
                    return;
                }
                myCollectResponse.requestSuccess = true;
                mutableLiveData.setValue(myCollectResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<MyCollectResponse> getJoinData(MyCollectRequest myCollectRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724145851")) {
            return (MutableLiveData) ipChange.ipc$dispatch("724145851", new Object[]{this, myCollectRequest});
        }
        final MutableLiveData<MyCollectResponse> mutableLiveData = new MutableLiveData<>();
        myCollectRequest.request(new DMMtopRequestListener<MyCollectResponse>(MyCollectResponse.class) {
            /* class cn.damai.mine.mycollect.net.MyCollectRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1423331494")) {
                    ipChange.ipc$dispatch("1423331494", new Object[]{this, str, str2});
                    return;
                }
                MyCollectResponse myCollectResponse = new MyCollectResponse();
                myCollectResponse.requestSuccess = false;
                myCollectResponse.errorCode = str;
                myCollectResponse.errorMsg = str2;
                mutableLiveData.setValue(myCollectResponse);
            }

            public void onSuccess(MyCollectResponse myCollectResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1173053172")) {
                    ipChange.ipc$dispatch("1173053172", new Object[]{this, myCollectResponse});
                    return;
                }
                myCollectResponse.requestSuccess = true;
                mutableLiveData.setValue(myCollectResponse);
            }
        });
        return mutableLiveData;
    }
}
