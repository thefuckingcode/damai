package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.mine.bean.FeedBackList;
import cn.damai.mine.contract.FeedBackContract;
import cn.damai.mine.model.FeedBackListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FeedBackPresenter extends FeedBackContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.FeedBackContract.Presenter
    public void getFeedBackList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578878009")) {
            ipChange.ipc$dispatch("1578878009", new Object[]{this});
            return;
        }
        new FeedBackListRequest().request(new DMMtopResultRequestListener<FeedBackList>(FeedBackList.class) {
            /* class cn.damai.mine.presenter.FeedBackPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "146997948")) {
                    ipChange.ipc$dispatch("146997948", new Object[]{this, str, str2});
                    return;
                }
                FeedBackPresenter.this.mView.onNetError(str, str2, "mtop.damai.wireless.user.feedback.bizIdentifiers");
            }

            public void onSuccess(FeedBackList feedBackList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1907412801")) {
                    ipChange.ipc$dispatch("-1907412801", new Object[]{this, feedBackList});
                    return;
                }
                FeedBackPresenter.this.mView.onNetSuccess();
                FeedBackPresenter.this.mView.returnFeedBackList(feedBackList);
            }
        });
    }
}
