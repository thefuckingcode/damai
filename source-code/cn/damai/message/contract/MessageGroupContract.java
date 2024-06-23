package cn.damai.message.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.message.bean.MessageGroupResponse;
import java.util.Map;

/* compiled from: Taobao */
public interface MessageGroupContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getMessageGroupList(Map<String, String> map);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void returnMessageGroupListFailure(String str, String str2);

        void returnMessageGroupListSuccess(MessageGroupResponse messageGroupResponse);
    }
}
