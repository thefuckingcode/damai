package cn.damai.trade.newtradeorder.ui.orderlist.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListResultBean;

/* compiled from: Taobao */
public interface OrderListContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getOrderListData(int i, int i2, int i3);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void orderListRefreshNotify();

        void returnOrderListData(OrderListResultBean orderListResultBean);

        void startTimerNotify();
    }
}
