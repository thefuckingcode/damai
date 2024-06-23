package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.mine.bean.RealNameVerifyScheduleBean;

/* compiled from: Taobao */
public interface RealNameVerifyScheduleContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void fetchRealNameVerifySchedule();
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void fetchRealNameVerifyScheduleFailed(String str, String str2);

        void fetchRealNameVerifyScheduleSuccess(RealNameVerifyScheduleBean realNameVerifyScheduleBean);
    }
}
