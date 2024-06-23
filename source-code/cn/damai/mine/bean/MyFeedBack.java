package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class MyFeedBack {
    private static transient /* synthetic */ IpChange $ipChange;
    public MyFeedBackDO feedbackDO;
    public List<MyFeedReplyDO> replyDOs;

    public MyFeedReplyDO getFisrFeedReplyDO() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951805621")) {
            return (MyFeedReplyDO) ipChange.ipc$dispatch("-1951805621", new Object[]{this});
        } else if (xf2.e(this.replyDOs) > 0) {
            return this.replyDOs.get(0);
        } else {
            return null;
        }
    }
}
