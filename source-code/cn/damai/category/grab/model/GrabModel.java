package cn.damai.category.grab.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.grab.bean.GrabBean;
import cn.damai.category.grab.request.GrabRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ys0;

/* compiled from: Taobao */
public class GrabModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<GrabBean> mGrabBean = new MutableLiveData<>();
    private ys0 mRepository;

    public GrabModel(Context context) {
        this.mContext = context;
        this.mRepository = new ys0();
    }

    public MutableLiveData<GrabBean> getGrabBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-859805477")) {
            return this.mGrabBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-859805477", new Object[]{this});
    }

    public void grabRequest(GrabRequest grabRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117254175")) {
            ipChange.ipc$dispatch("-2117254175", new Object[]{this, grabRequest});
            return;
        }
        this.mRepository.a(grabRequest, new DMMtopRequestListener<GrabBean>(GrabBean.class) {
            /* class cn.damai.category.grab.model.GrabModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-626535901")) {
                    ipChange.ipc$dispatch("-626535901", new Object[]{this, str, str2});
                    return;
                }
                GrabModel.this.mGrabBean.setValue(null);
            }

            public void onSuccess(GrabBean grabBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1977518171")) {
                    ipChange.ipc$dispatch("1977518171", new Object[]{this, grabBean});
                    return;
                }
                GrabModel.this.mGrabBean.setValue(grabBean);
            }
        });
    }
}
