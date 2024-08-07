package com.alient.onearch.adapter.component.footer;

import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alient.oneservice.ut.TrackInfo;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
public class GenericFooterContract implements IContract {

    /* compiled from: Taobao */
    interface Model extends IContract.Model<GenericItem<ItemValue>> {
        String getComponentId();

        JSONArray getResult();

        int getTotal();

        TrackInfo getTrackInfo();
    }

    /* compiled from: Taobao */
    interface Presenter extends IContract.Presenter<GenericItem<ItemValue>, GenericFooterModel> {
    }

    /* compiled from: Taobao */
    interface View extends IContract.View {
        TextView getContentView();

        void hideArrowIndicator();

        void renderContent(String str);

        void showArrowIndicator();
    }
}
