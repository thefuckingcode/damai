package cn.damai.message.presenter;

import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.bean.MessageList;
import cn.damai.message.contract.FollowCommentContract;
import cn.damai.message.observer.Action;
import cn.damai.message.request.MessageListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class FollowCommentPresenter extends FollowCommentContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645545254")) {
                ipChange.ipc$dispatch("-645545254", new Object[]{this, str});
                return;
            }
            FollowCommentPresenter.this.mView.followCommentNotify(str);
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "47556443")) {
                ipChange.ipc$dispatch("47556443", new Object[]{this, str});
                return;
            }
            FollowCommentPresenter.this.mView.followCommentNotify(str);
        }
    }

    @Override // cn.damai.message.contract.FollowCommentContract.Presenter
    public void getMessageItemList(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046201530")) {
            ipChange.ipc$dispatch("-2046201530", new Object[]{this, map});
            return;
        }
        MessageListRequest messageListRequest = new MessageListRequest();
        if (map.containsKey("groupId")) {
            messageListRequest.groupId = map.get("groupId");
        }
        if (map.containsKey("messageId")) {
            messageListRequest.messageId = map.get("messageId");
        }
        if (map.containsKey("size")) {
            messageListRequest.size = map.get("size");
        }
        if (map.containsKey("loginKey")) {
            messageListRequest.loginkey = map.get("loginKey");
        }
        messageListRequest.request(new DMMtopRequestListener<MessageList>(MessageList.class) {
            /* class cn.damai.message.presenter.FollowCommentPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1525367751")) {
                    ipChange.ipc$dispatch("1525367751", new Object[]{this, str, str2});
                    return;
                }
                FollowCommentPresenter.this.mView.returnMessageItemListFailures(str, str2);
            }

            public void onSuccess(MessageList messageList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1455850558")) {
                    ipChange.ipc$dispatch("-1455850558", new Object[]{this, messageList});
                    return;
                }
                FollowCommentPresenter.this.mView.returnMessageItemListSuccess(messageList);
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2006036250")) {
            ipChange.ipc$dispatch("-2006036250", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("comment", new a());
        this.mDMMessage.b(StarFragment.KEY_FOLLOW, new b());
    }
}
