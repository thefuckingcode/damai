package cn.damai.ultron.payresult.net;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class PaySuccessViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private MutableLiveData<PayAdvertBean> mBannerLiveData = new MutableLiveData<>();
    private String mOrderId;
    private MutableLiveData<DmPaySuccessBean> mPayResultLiveData = new MutableLiveData<>();
    private PaySuccessRepository mRepository = new PaySuccessRepository();
    private MutableLiveData<RecommendListMo> recommendLiveData = new MutableLiveData<>();

    public PaySuccessViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<PayAdvertBean> getBannerLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-35211604")) {
            return this.mBannerLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-35211604", new Object[]{this});
    }

    public String getOrderId(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433523500")) {
            return (String) ipChange.ipc$dispatch("1433523500", new Object[]{this, intent});
        }
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            this.mOrderId = extras.getString("orderId", "");
        }
        return this.mOrderId;
    }

    public MutableLiveData<RecommendListMo> getRecommendLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-541644538")) {
            return this.recommendLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-541644538", new Object[]{this});
    }

    public MutableLiveData<DmPaySuccessBean> getResultLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "506397149")) {
            return this.mPayResultLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("506397149", new Object[]{this});
    }

    public void queryBanner(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262523690")) {
            ipChange.ipc$dispatch("-262523690", new Object[]{this, str});
            return;
        }
        this.mRepository.queryBanner(str, this.mOrderId, new DMMtopRequestListener<PayAdvertBean>(PayAdvertBean.class) {
            /* class cn.damai.ultron.payresult.net.PaySuccessViewModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1580025969")) {
                    ipChange.ipc$dispatch("-1580025969", new Object[]{this, str, str2});
                    return;
                }
                Log.e("PaySuccessViewModel", "PaySuccessViewModel: " + str + " , " + str2);
                PaySuccessViewModel.this.mBannerLiveData.setValue(new PayAdvertBean());
            }

            public void onSuccess(PayAdvertBean payAdvertBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-446067316")) {
                    ipChange.ipc$dispatch("-446067316", new Object[]{this, payAdvertBean});
                } else if (payAdvertBean != null) {
                    PaySuccessViewModel.this.mBannerLiveData.setValue(payAdvertBean);
                }
            }
        });
    }

    public void queryPaySuccessInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541680015")) {
            ipChange.ipc$dispatch("1541680015", new Object[]{this});
            return;
        }
        this.mRepository.queryPaySuccessInfo(this.mOrderId, new DMMtopRequestListener<DmPaySuccessBean>(DmPaySuccessBean.class) {
            /* class cn.damai.ultron.payresult.net.PaySuccessViewModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1572266610")) {
                    ipChange.ipc$dispatch("-1572266610", new Object[]{this, str, str2});
                    return;
                }
                DmPaySuccessBean dmPaySuccessBean = new DmPaySuccessBean();
                dmPaySuccessBean.isPaid = "false";
                dmPaySuccessBean.requestSuccess = false;
                dmPaySuccessBean.resultDesc = "支付结果处理中";
                PaySuccessViewModel.this.mPayResultLiveData.setValue(dmPaySuccessBean);
            }

            public void onSuccess(DmPaySuccessBean dmPaySuccessBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-329263191")) {
                    ipChange.ipc$dispatch("-329263191", new Object[]{this, dmPaySuccessBean});
                    return;
                }
                if (dmPaySuccessBean == null) {
                    DmPaySuccessBean dmPaySuccessBean2 = new DmPaySuccessBean();
                    dmPaySuccessBean2.isPaid = "false";
                    dmPaySuccessBean2.requestSuccess = false;
                    dmPaySuccessBean2.resultDesc = "支付结果处理中";
                } else {
                    dmPaySuccessBean.requestSuccess = true;
                }
                PaySuccessViewModel.this.mPayResultLiveData.setValue(dmPaySuccessBean);
            }
        });
    }

    public void queryRecommendList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215127784")) {
            ipChange.ipc$dispatch("-1215127784", new Object[]{this});
            return;
        }
        this.mRepository.queryRecommendList(new DMMtopRequestListener<RecommendListMo>(RecommendListMo.class) {
            /* class cn.damai.ultron.payresult.net.PaySuccessViewModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1587785328")) {
                    ipChange.ipc$dispatch("-1587785328", new Object[]{this, str, str2});
                    return;
                }
                PaySuccessViewModel.this.recommendLiveData.setValue(new RecommendListMo());
            }

            public void onSuccess(RecommendListMo recommendListMo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1002187559")) {
                    ipChange.ipc$dispatch("1002187559", new Object[]{this, recommendListMo});
                    return;
                }
                PaySuccessViewModel.this.recommendLiveData.setValue(recommendListMo);
            }
        });
    }

    public String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1185592905")) {
            return this.mOrderId;
        }
        return (String) ipChange.ipc$dispatch("1185592905", new Object[]{this});
    }
}
