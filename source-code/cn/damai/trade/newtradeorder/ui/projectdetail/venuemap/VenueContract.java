package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;

/* compiled from: Taobao */
public interface VenueContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void retrieveVenueDetailInfo(String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void onRetrieveVenueInfoError(String str, String str2);

        void onRetrieveVenueInfoSuccess(Venue venue);
    }
}
