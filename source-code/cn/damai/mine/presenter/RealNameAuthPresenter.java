package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.request.CertificateTypeRequest;
import cn.damai.mine.bean.RealNameAuthBean;
import cn.damai.mine.bean.RealNameCustomerListBean;
import cn.damai.mine.bean.RealNameVerifyBean;
import cn.damai.mine.contract.RealNameAuthContract;
import cn.damai.mine.net.RealNameAuthRequest;
import cn.damai.mine.net.RealNameCustomerRequest;
import cn.damai.mine.net.RealNameVerifyRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class RealNameAuthPresenter extends RealNameAuthContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void fetchCertificateType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "607840575")) {
            ipChange.ipc$dispatch("607840575", new Object[]{this, str});
            return;
        }
        CertificateTypeRequest certificateTypeRequest = new CertificateTypeRequest();
        certificateTypeRequest.scence = str;
        certificateTypeRequest.request(new DMMtopRequestListener<CertificateTypeBean>(CertificateTypeBean.class) {
            /* class cn.damai.mine.presenter.RealNameAuthPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-754064303")) {
                    ipChange.ipc$dispatch("-754064303", new Object[]{this, str, str2});
                    return;
                }
                RealNameAuthPresenter.this.mView.fetchCertificateTypeFailed(str, str2);
            }

            public void onSuccess(CertificateTypeBean certificateTypeBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-373437501")) {
                    ipChange.ipc$dispatch("-373437501", new Object[]{this, certificateTypeBean});
                    return;
                }
                RealNameAuthPresenter.this.mView.fetchCertificateTypeSuccess(certificateTypeBean);
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void fetchCustomers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372782097")) {
            ipChange.ipc$dispatch("1372782097", new Object[]{this});
            return;
        }
        RealNameCustomerRequest realNameCustomerRequest = new RealNameCustomerRequest();
        realNameCustomerRequest.loginkey = d20.q();
        realNameCustomerRequest.request(new DMMtopRequestListener<RealNameCustomerListBean>(RealNameCustomerListBean.class) {
            /* class cn.damai.mine.presenter.RealNameAuthPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-746304944")) {
                    ipChange.ipc$dispatch("-746304944", new Object[]{this, str, str2});
                    return;
                }
                RealNameAuthPresenter.this.mView.fetchCustomersFailed(str, str2);
            }

            public void onSuccess(RealNameCustomerListBean realNameCustomerListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "341304609")) {
                    ipChange.ipc$dispatch("341304609", new Object[]{this, realNameCustomerListBean});
                    return;
                }
                RealNameAuthPresenter.this.mView.fetchCustomersSuccess(realNameCustomerListBean);
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void getFaceVerifyToken(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017032491")) {
            ipChange.ipc$dispatch("-2017032491", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RealNameVerifyRequest realNameVerifyRequest = new RealNameVerifyRequest();
        realNameVerifyRequest.loginKey = d20.q();
        if (z) {
            realNameVerifyRequest.subBiz = "accountConflict";
        } else {
            realNameVerifyRequest.subBiz = "accountSafe";
        }
        realNameVerifyRequest.request(new DMMtopRequestListener<RealNameVerifyBean>(RealNameVerifyBean.class) {
            /* class cn.damai.mine.presenter.RealNameAuthPresenter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-769583021")) {
                    ipChange.ipc$dispatch("-769583021", new Object[]{this, str, str2});
                    return;
                }
                RealNameAuthPresenter.this.mView.getFaceVerifyTokenFailed(str, str2);
            }

            public void onSuccess(RealNameVerifyBean realNameVerifyBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1810757415")) {
                    ipChange.ipc$dispatch("1810757415", new Object[]{this, realNameVerifyBean});
                    return;
                }
                RealNameAuthPresenter.this.mView.getFaceVerifyTokenSuccess(realNameVerifyBean);
            }
        });
    }

    @Override // cn.damai.mine.contract.RealNameAuthContract.Presenter
    public void submitAuth(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461731114")) {
            ipChange.ipc$dispatch("461731114", new Object[]{this, str, str2, str3});
            return;
        }
        RealNameAuthRequest realNameAuthRequest = new RealNameAuthRequest();
        realNameAuthRequest.loginKey = d20.q();
        realNameAuthRequest.name = str2;
        realNameAuthRequest.idCard = str;
        realNameAuthRequest.idCardType = str3;
        realNameAuthRequest.request(new DMMtopRequestListener<RealNameAuthBean>(RealNameAuthBean.class) {
            /* class cn.damai.mine.presenter.RealNameAuthPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-761823662")) {
                    ipChange.ipc$dispatch("-761823662", new Object[]{this, str, str2});
                    return;
                }
                RealNameAuthPresenter.this.mView.authFailed(str, str2);
            }

            public void onSuccess(RealNameAuthBean realNameAuthBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1863131031")) {
                    ipChange.ipc$dispatch("1863131031", new Object[]{this, realNameAuthBean});
                    return;
                }
                RealNameAuthPresenter.this.mView.authSuccess(realNameAuthBean);
            }
        });
    }
}
