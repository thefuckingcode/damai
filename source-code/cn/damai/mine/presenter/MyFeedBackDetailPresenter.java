package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.mine.bean.MyFeedBackDetail;
import cn.damai.mine.contract.MyFeedBackDetailContract;
import cn.damai.mine.net.MyFeedBackDetailRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyFeedBackDetailPresenter extends MyFeedBackDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.MyFeedBackDetailContract.Presenter
    public void getFeedBackList(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1332273472")) {
            ipChange.ipc$dispatch("1332273472", new Object[]{this, str});
            return;
        }
        MyFeedBackDetailRequest myFeedBackDetailRequest = new MyFeedBackDetailRequest();
        myFeedBackDetailRequest.feedbackId = str;
        myFeedBackDetailRequest.request(new DMMtopResultRequestListener<MyFeedBackDetail>(MyFeedBackDetail.class) {
            /* class cn.damai.mine.presenter.MyFeedBackDetailPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1145294049")) {
                    ipChange.ipc$dispatch("-1145294049", new Object[]{this, str, str2});
                    return;
                }
                MyFeedBackDetailPresenter.this.mView.onNetError(str, str2, "mtop.damai.wireless.user.feedback.replayDetail");
            }

            public void onSuccess(MyFeedBackDetail myFeedBackDetail) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-749787389")) {
                    ipChange.ipc$dispatch("-749787389", new Object[]{this, myFeedBackDetail});
                    return;
                }
                MyFeedBackDetailPresenter.this.mView.onNetSuccess();
                MyFeedBackDetailPresenter.this.mView.returnFeedBack(myFeedBackDetail);
            }
        });
    }
}
