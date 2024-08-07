package com.alibaba.pictures.bricks.component.venue;

import com.alibaba.pictures.bricks.bean.VenueBean;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
public class VenueContract implements IContract {

    /* compiled from: Taobao */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        VenueBean getVenue();
    }

    /* compiled from: Taobao */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void gotoDetail();
    }

    /* compiled from: Taobao */
    interface View extends IContract.View {
        void renderDistance(String str);

        void renderLocation(String str);

        void renderName(String str);

        void renderPerformanceContent(String str);

        void renderPerformanceCount(String str);
    }
}
