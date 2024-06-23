package com.alibaba.pictures.bricks.component.empty;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
public class EmptyContract implements IContract {

    /* compiled from: Taobao */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        String getContent();
    }

    /* compiled from: Taobao */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
    }

    /* compiled from: Taobao */
    interface View extends IContract.View {
        void renderContent(String str);
    }
}
