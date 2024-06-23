package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponApplyDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponListDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.VipCardDescWrap;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectCouponContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.CouponListRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.CouponReceiveRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.VipCardDescRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectCouponPresenter extends ProjectCouponContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectCouponContract.Presenter
    public void getProjectCouponList(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906319143")) {
            ipChange.ipc$dispatch("-906319143", new Object[]{this, str, str2});
            return;
        }
        CouponListRequest couponListRequest = new CouponListRequest();
        couponListRequest.itemId = str;
        couponListRequest.userId = str2;
        couponListRequest.request(new DMMtopRequestListener<CouponListDataBean>(CouponListDataBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectCouponPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2065179568")) {
                    ipChange.ipc$dispatch("2065179568", new Object[]{this, str, str2});
                    return;
                }
                ProjectCouponPresenter.this.mView.onReturnCouponListError(str, str2);
            }

            public void onSuccess(CouponListDataBean couponListDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1720306686")) {
                    ipChange.ipc$dispatch("1720306686", new Object[]{this, couponListDataBean});
                } else if (couponListDataBean != null) {
                    ProjectCouponPresenter.this.mView.onReturnCouponListSuccess(couponListDataBean.getCouponActivities());
                } else {
                    ProjectCouponPresenter.this.mView.onReturnCouponListSuccess(null);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectCouponContract.Presenter
    public void getVipCardDesc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999038140")) {
            ipChange.ipc$dispatch("-999038140", new Object[]{this});
            return;
        }
        new VipCardDescRequest().request(new DMMtopRequestListener<VipCardDescWrap>(VipCardDescWrap.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectCouponPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2049660850")) {
                    ipChange.ipc$dispatch("2049660850", new Object[]{this, str, str2});
                    return;
                }
                ProjectCouponPresenter.this.mView.onReturnVipCardError(str, str2);
            }

            public void onSuccess(VipCardDescWrap vipCardDescWrap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1995128490")) {
                    ipChange.ipc$dispatch("1995128490", new Object[]{this, vipCardDescWrap});
                } else if (vipCardDescWrap != null) {
                    ProjectCouponPresenter.this.mView.onReturnVipCardSuccess(vipCardDescWrap);
                } else {
                    ProjectCouponPresenter.this.mView.onReturnVipCardError("", "");
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectCouponContract.Presenter
    public void receiveProjectCoupon(final int i, String str, boolean z, final String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809414453")) {
            ipChange.ipc$dispatch("-1809414453", new Object[]{this, Integer.valueOf(i), str, Boolean.valueOf(z), str2, str3});
            return;
        }
        CouponReceiveRequest couponReceiveRequest = new CouponReceiveRequest();
        couponReceiveRequest.buyerId = str;
        couponReceiveRequest.calcNextApplicable = z ? "true" : "false";
        couponReceiveRequest.couponActSpreadId = str2;
        couponReceiveRequest.asac = str3;
        couponReceiveRequest.useWua();
        couponReceiveRequest.request(new DMMtopRequestListener<CouponApplyDataBean>(CouponApplyDataBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectCouponPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2057420209")) {
                    ipChange.ipc$dispatch("2057420209", new Object[]{this, str, str2});
                    return;
                }
                ProjectCouponPresenter.this.mView.onReturnReceiveCouponError(str, str2);
            }

            public void onSuccess(CouponApplyDataBean couponApplyDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2057570097")) {
                    ipChange.ipc$dispatch("2057570097", new Object[]{this, couponApplyDataBean});
                    return;
                }
                ProjectCouponPresenter.this.mView.onReturnReceiveCouponSuccess(i, str2, couponApplyDataBean);
            }
        });
    }
}
