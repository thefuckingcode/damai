package cn.damai.ultron.payresult.net;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.commonbusiness.banner.request.PaySuccessBannerRequest;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.RecommendRequest;
import com.alibaba.pictures.dolores.business.FailAction;
import com.alibaba.pictures.dolores.business.SuccessAction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.c20;
import tb.d20;
import tb.fb0;
import tb.ta0;

/* compiled from: Taobao */
public class PaySuccessRepository extends c20 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void queryBanner(String str, String str2, DMMtopRequestListener<PayAdvertBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394760842")) {
            ipChange.ipc$dispatch("394760842", new Object[]{this, str, str2, dMMtopRequestListener});
            return;
        }
        PaySuccessBannerRequest paySuccessBannerRequest = new PaySuccessBannerRequest();
        paySuccessBannerRequest.projectId = str;
        paySuccessBannerRequest.orderId = str2;
        paySuccessBannerRequest.request(dMMtopRequestListener);
    }

    public void queryPaySuccessInfo(String str, DMMtopRequestListener<DmPaySuccessBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628968207")) {
            ipChange.ipc$dispatch("-1628968207", new Object[]{this, str, dMMtopRequestListener});
            return;
        }
        PaySuccessRequest paySuccessRequest = new PaySuccessRequest();
        paySuccessRequest.orderId = str;
        paySuccessRequest.request(dMMtopRequestListener);
    }

    public void queryRecommendList(final DMMtopRequestListener<RecommendListMo> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494660166")) {
            ipChange.ipc$dispatch("-494660166", new Object[]{this, dMMtopRequestListener});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.setCityId(d20.c());
        ta0.h(recommendRequest).a().doOnSuccess(new SuccessAction<RecommendListMo>() {
            /* class cn.damai.ultron.payresult.net.PaySuccessRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onSuccess(RecommendListMo recommendListMo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1357346340")) {
                    ipChange.ipc$dispatch("-1357346340", new Object[]{this, recommendListMo});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener = dMMtopRequestListener;
                if (dMMtopRequestListener != null) {
                    dMMtopRequestListener.onSuccess(recommendListMo);
                }
            }
        }).doOnFail(new FailAction<RecommendListMo>() {
            /* class cn.damai.ultron.payresult.net.PaySuccessRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.dolores.business.FailAction
            public void onFail(@Nullable fb0<RecommendListMo> fb0) {
                String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "528819776")) {
                    ipChange.ipc$dispatch("528819776", new Object[]{this, fb0});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener = dMMtopRequestListener;
                if (dMMtopRequestListener != null) {
                    String str2 = "error";
                    if (fb0 == null) {
                        str = str2;
                    } else {
                        str = fb0.e();
                    }
                    if (fb0 != null) {
                        str2 = fb0.f();
                    }
                    dMMtopRequestListener.onFail(str, str2);
                }
            }
        });
    }
}
