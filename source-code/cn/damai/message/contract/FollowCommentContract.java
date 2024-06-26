package cn.damai.message.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.message.bean.MessageList;
import java.util.Map;

/* compiled from: Taobao */
public interface FollowCommentContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getMessageItemList(Map<String, String> map);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void followCommentNotify(String str);

        void returnMessageItemListFailures(String str, String str2);

        void returnMessageItemListSuccess(MessageList messageList);
    }
}
