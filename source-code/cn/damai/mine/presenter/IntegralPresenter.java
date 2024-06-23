package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.AcquireScoreDto;
import cn.damai.mine.bean.LostScoreDto;
import cn.damai.mine.bean.UserScoreDto;
import cn.damai.mine.contract.IntegralContract;
import cn.damai.mine.net.GetScoreConsumListRequest;
import cn.damai.mine.net.GetScoreInfoRequest;
import cn.damai.mine.net.GetScoreListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ge1;

/* compiled from: Taobao */
public class IntegralPresenter extends IntegralContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestIntegralList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665486912")) {
            ipChange.ipc$dispatch("-665486912", new Object[]{this});
            return;
        }
        new GetScoreInfoRequest().request(new DMMtopRequestListener<UserScoreDto>(UserScoreDto.class) {
            /* class cn.damai.mine.presenter.IntegralPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "21519445")) {
                    ipChange.ipc$dispatch("21519445", new Object[]{this, str, str2});
                    return;
                }
                IntegralPresenter.this.mView.stopLoading();
            }

            public void onSuccess(UserScoreDto userScoreDto) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "302797123")) {
                    ipChange.ipc$dispatch("302797123", new Object[]{this, userScoreDto});
                    return;
                }
                IntegralPresenter.this.mView.stopLoading();
                IntegralPresenter.this.mView.returnIntegralList(userScoreDto);
            }
        });
    }

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestPointsIntegral(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010150875")) {
            ipChange.ipc$dispatch("-2010150875", new Object[]{this, str});
            return;
        }
        GetScoreListRequest getScoreListRequest = new GetScoreListRequest();
        getScoreListRequest.pageIndex = str;
        getScoreListRequest.request(new DMMtopRequestListener<AcquireScoreDto>(AcquireScoreDto.class) {
            /* class cn.damai.mine.presenter.IntegralPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "13760086")) {
                    ipChange.ipc$dispatch("13760086", new Object[]{this, str, str2});
                    return;
                }
                ge1.c("-1000", str2);
            }

            public void onSuccess(AcquireScoreDto acquireScoreDto) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-277828559")) {
                    ipChange.ipc$dispatch("-277828559", new Object[]{this, acquireScoreDto});
                    return;
                }
                IntegralPresenter.this.mView.stopLoading();
                IntegralPresenter.this.mView.returnPointsIntegral(acquireScoreDto);
            }
        });
    }

    @Override // cn.damai.mine.contract.IntegralContract.Presenter
    public void requestSumptionIntegral(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1447650449")) {
            ipChange.ipc$dispatch("-1447650449", new Object[]{this, str});
            return;
        }
        GetScoreConsumListRequest getScoreConsumListRequest = new GetScoreConsumListRequest();
        getScoreConsumListRequest.pageIndex = str;
        getScoreConsumListRequest.request(new DMMtopRequestListener<LostScoreDto>(LostScoreDto.class) {
            /* class cn.damai.mine.presenter.IntegralPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "6000727")) {
                    ipChange.ipc$dispatch("6000727", new Object[]{this, str, str2});
                    return;
                }
                IntegralPresenter.this.mView.stopLoading();
            }

            public void onSuccess(LostScoreDto lostScoreDto) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2071939148")) {
                    ipChange.ipc$dispatch("2071939148", new Object[]{this, lostScoreDto});
                    return;
                }
                IntegralPresenter.this.mView.stopLoading();
                IntegralPresenter.this.mView.returnSumptionIntegral(lostScoreDto);
            }
        });
    }
}
