package cn.damai.commonbusiness.faceverify.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean;
import cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract;
import cn.damai.commonbusiness.faceverify.request.CertificateTypeRequest;
import cn.damai.commonbusiness.faceverify.request.IdentityInfoQueryRequest;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class IdentityInfoQueryPresenter extends IdentityInfoQueryContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-822314901")) {
                ipChange.ipc$dispatch("-822314901", new Object[]{this, obj});
            } else if (obj != null) {
                IdentityInfoQueryPresenter.this.mView.closeSelf();
            }
        }
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.Presenter
    public void fetchCertificateType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061725773")) {
            ipChange.ipc$dispatch("-2061725773", new Object[]{this, str});
            return;
        }
        CertificateTypeRequest certificateTypeRequest = new CertificateTypeRequest();
        certificateTypeRequest.scence = str;
        certificateTypeRequest.request(new DMMtopRequestListener<CertificateTypeBean>(CertificateTypeBean.class) {
            /* class cn.damai.commonbusiness.faceverify.presenter.IdentityInfoQueryPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1980898363")) {
                    ipChange.ipc$dispatch("-1980898363", new Object[]{this, str, str2});
                    return;
                }
                IdentityInfoQueryPresenter.this.mView.fetchCertificateTypeFailed(str, str2);
            }

            public void onSuccess(CertificateTypeBean certificateTypeBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-118696649")) {
                    ipChange.ipc$dispatch("-118696649", new Object[]{this, certificateTypeBean});
                    return;
                }
                IdentityInfoQueryPresenter.this.mView.fetchCertificateTypeSuccess(certificateTypeBean);
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258444679")) {
            ipChange.ipc$dispatch("1258444679", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("faceVerify", new a());
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.Presenter
    public void queryIdentityInfo(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170974036")) {
            ipChange.ipc$dispatch("170974036", new Object[]{this, str, str2, str3});
            return;
        }
        IdentityInfoQueryRequest identityInfoQueryRequest = new IdentityInfoQueryRequest();
        identityInfoQueryRequest.idCard = str;
        identityInfoQueryRequest.name = str2;
        identityInfoQueryRequest.idCardType = str3;
        identityInfoQueryRequest.loginKey = d20.q();
        identityInfoQueryRequest.request(new DMMtopRequestListener<IdentityInfoQueryBean>(IdentityInfoQueryBean.class) {
            /* class cn.damai.commonbusiness.faceverify.presenter.IdentityInfoQueryPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1988657722")) {
                    ipChange.ipc$dispatch("-1988657722", new Object[]{this, str, str2});
                    return;
                }
                IdentityInfoQueryPresenter.this.mView.queryIdentityInfoFailed(str, str2);
            }

            public void onSuccess(IdentityInfoQueryBean identityInfoQueryBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1502099219")) {
                    ipChange.ipc$dispatch("-1502099219", new Object[]{this, identityInfoQueryBean});
                    return;
                }
                IdentityInfoQueryPresenter.this.mView.queryIdentityInfoSuccess(identityInfoQueryBean);
            }
        });
    }
}
