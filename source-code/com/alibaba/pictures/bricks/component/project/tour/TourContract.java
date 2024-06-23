package com.alibaba.pictures.bricks.component.project.tour;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
public class TourContract implements IContract {

    /* compiled from: Taobao */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        long getNativeDiffTime();

        long getServerTime();

        SearchTourBean getTourBean();
    }

    /* compiled from: Taobao */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void dispatchAction();

        void moreUserExpose();

        void projectUserClick();

        void projectUserExpose();

        void tourCityUserClick(String str, int i);

        void tourCityUserExpose(android.view.View view, String str, int i);
    }

    /* compiled from: Taobao */
    interface View extends IContract.View {
        BricksProjectViewHolder getHolder();

        LinearLayout getMoreTourLayout();

        FrameLayout getProjectContainer();

        void handlerData(SearchTourBean searchTourBean);

        void setCountDownServerTime(long j, long j2);

        boolean setExpandState(boolean z);
    }
}
