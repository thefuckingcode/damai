package cn.damai.onearch.component.shoptip;

import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
public class ShopTipContract implements IContract {

    /* compiled from: Taobao */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        String getContent();
    }

    /* compiled from: Taobao */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
    }

    /* compiled from: Taobao */
    interface View extends IContract.View {
        void hideRightArrow();

        void renderContent(String str);

        void showRightArrow();

        void updateBgColor(int i);
    }
}
