package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.FeedBackList;

/* compiled from: Taobao */
public interface FeedBackContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getFeedBackList();
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        @Override // cn.damai.commonbusiness.base.BaseDamaiView
        void onNetError(String str, String str2, String str3);

        @Override // cn.damai.commonbusiness.base.BaseDamaiView
        void onNetSuccess();

        void returnFeedBackList(FeedBackList feedBackList);
    }
}
