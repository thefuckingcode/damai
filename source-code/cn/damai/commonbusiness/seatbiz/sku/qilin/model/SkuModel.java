package cn.damai.commonbusiness.seatbiz.sku.qilin.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.common.bean.OrderPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.DengjiRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SuanjiaRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vb2;

/* compiled from: Taobao */
public class SkuModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<FollowDataBean> mFollowDataBean = new MutableLiveData<>();
    private MutableLiveData<OrderPrice> mOrderPrice = new MutableLiveData<>();
    private vb2 mRepository;
    private MutableLiveData<SkuBean> mSkuBean = new MutableLiveData<>();

    public SkuModel(Context context) {
        this.mContext = context;
        this.mRepository = new vb2();
    }

    public void dengjiRequest(DengjiRequest dengjiRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807803938")) {
            ipChange.ipc$dispatch("1807803938", new Object[]{this, dengjiRequest});
            return;
        }
        this.mRepository.a(dengjiRequest, new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "261487166")) {
                    ipChange.ipc$dispatch("261487166", new Object[]{this, str, str2});
                    return;
                }
                SkuModel.this.mFollowDataBean.setValue(null);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "551418850")) {
                    ipChange.ipc$dispatch("551418850", new Object[]{this, followDataBean});
                    return;
                }
                SkuModel.this.mFollowDataBean.setValue(followDataBean);
            }
        });
    }

    public MutableLiveData<FollowDataBean> getFollowDataBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "836589284")) {
            return this.mFollowDataBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("836589284", new Object[]{this});
    }

    public MutableLiveData<OrderPrice> getOrderPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1794720052")) {
            return this.mOrderPrice;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1794720052", new Object[]{this});
    }

    public MutableLiveData<SkuBean> getSkuBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1747326226")) {
            return this.mSkuBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1747326226", new Object[]{this});
    }

    public void skuRequest(final SkuRequest skuRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753665326")) {
            ipChange.ipc$dispatch("-753665326", new Object[]{this, skuRequest});
            return;
        }
        this.mRepository.b(skuRequest, new DMMtopResultRequestListener<SkuBean>(SkuBean.class) {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "269246525")) {
                    ipChange.ipc$dispatch("269246525", new Object[]{this, str, str2});
                    return;
                }
                SkuModel.this.mSkuBean.setValue(SkuBean.error(str, str2, skuRequest));
            }

            public void onSuccess(SkuBean skuBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1240217969")) {
                    ipChange.ipc$dispatch("-1240217969", new Object[]{this, skuBean});
                    return;
                }
                SkuModel.this.mSkuBean.setValue(skuBean);
            }
        });
    }

    public void suanjiaRequest(SuanjiaRequest suanjiaRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282979522")) {
            ipChange.ipc$dispatch("-1282979522", new Object[]{this, suanjiaRequest});
            return;
        }
        this.mRepository.c(suanjiaRequest, new DMMtopRequestListener<OrderPrice>(OrderPrice.class) {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "253727807")) {
                    ipChange.ipc$dispatch("253727807", new Object[]{this, str, str2});
                    return;
                }
                SkuModel.this.mOrderPrice.setValue(null);
            }

            public void onSuccess(OrderPrice orderPrice) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-698088467")) {
                    ipChange.ipc$dispatch("-698088467", new Object[]{this, orderPrice});
                    return;
                }
                SkuModel.this.mOrderPrice.setValue(orderPrice);
            }
        });
    }
}
