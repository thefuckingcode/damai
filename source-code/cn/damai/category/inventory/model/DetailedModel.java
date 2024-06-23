package cn.damai.category.inventory.model;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.inventory.bean.DetailedBeanResponse;
import cn.damai.category.inventory.bean.DetailedFollowResponse;
import cn.damai.category.inventory.repository.DetailedRespository;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class DetailedModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final MutableLiveData<DetailedFollowResponse> followLiveData = new MutableLiveData<>();
    private String mId = "";
    private DetailedRespository mRepository = new DetailedRespository();

    public DetailedModel(@NonNull Application application) {
        super(application);
    }

    public void getAttentionState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169224774")) {
            ipChange.ipc$dispatch("-1169224774", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRepository.b(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.category.inventory.model.DetailedModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1807871477")) {
                    ipChange.ipc$dispatch("-1807871477", new Object[]{this, str, str2});
                    return;
                }
                DetailedFollowResponse detailedFollowResponse = new DetailedFollowResponse();
                detailedFollowResponse.requestSuccess = false;
                detailedFollowResponse.errorCode = str;
                detailedFollowResponse.errorMsg = str2;
                DetailedModel.this.followLiveData.setValue(detailedFollowResponse);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-770625803")) {
                    ipChange.ipc$dispatch("-770625803", new Object[]{this, followDataBean});
                    return;
                }
                DetailedFollowResponse detailedFollowResponse = new DetailedFollowResponse();
                detailedFollowResponse.data = followDataBean;
                detailedFollowResponse.requestSuccess = true;
                DetailedModel.this.followLiveData.setValue(detailedFollowResponse);
            }
        }, z ? "0" : "1", this.mId);
    }

    public String getDetailedId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-56855202")) {
            return this.mId;
        }
        return (String) ipChange.ipc$dispatch("-56855202", new Object[]{this});
    }

    public MutableLiveData<DetailedBeanResponse> getDetailedListData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-354696225")) {
            return this.mRepository.a(this.mId);
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-354696225", new Object[]{this});
    }

    public MutableLiveData<DetailedFollowResponse> getFollowLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1861646830")) {
            return this.followLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1861646830", new Object[]{this});
    }

    public void initParam(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090307261")) {
            ipChange.ipc$dispatch("-1090307261", new Object[]{this, intent});
        } else if (intent != null && (extras = intent.getExtras()) != null) {
            this.mId = extras.getString("id");
        }
    }
}
