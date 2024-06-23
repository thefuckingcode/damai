package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.mine.bean.MyFeedBackList;
import cn.damai.mine.contract.MyFeedBackListContract;
import cn.damai.mine.net.MyFeedBackListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyFeedBackListPresenter extends MyFeedBackListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.MyFeedBackListContract.Presenter
    public void getFeedBackList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335568835")) {
            ipChange.ipc$dispatch("1335568835", new Object[]{this});
            return;
        }
        new MyFeedBackListRequest().request(new DMMtopResultRequestListener<MyFeedBackList>(MyFeedBackList.class) {
            /* class cn.damai.mine.presenter.MyFeedBackListPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1483620722")) {
                    ipChange.ipc$dispatch("1483620722", new Object[]{this, str, str2});
                    return;
                }
                MyFeedBackListPresenter.this.mView.onNetError(str, str2, "mtop.damai.wireless.user.feedback.replayList");
            }

            public void onSuccess(MyFeedBackList myFeedBackList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "392097833")) {
                    ipChange.ipc$dispatch("392097833", new Object[]{this, myFeedBackList});
                    return;
                }
                MyFeedBackListPresenter.this.mView.onNetSuccess();
                MyFeedBackListPresenter.this.mView.returnFeedBackList(myFeedBackList);
            }
        });
    }
}
