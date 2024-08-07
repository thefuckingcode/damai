package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.AcquireScoreDto;
import cn.damai.mine.bean.LostScoreDto;
import cn.damai.mine.bean.UserScoreDto;

/* compiled from: Taobao */
public interface IntegralContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void requestIntegralList();

        public abstract void requestPointsIntegral(String str);

        public abstract void requestSumptionIntegral(String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void returnIntegralList(UserScoreDto userScoreDto);

        void returnPointsIntegral(AcquireScoreDto acquireScoreDto);

        void returnSumptionIntegral(LostScoreDto lostScoreDto);
    }
}
