package cn.damai.tetris.component.drama.mvp;

import android.widget.TextView;
import cn.damai.tetris.component.drama.bean.XBannerBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.uikit.banner.sub.BannerItem;
import java.util.List;

/* compiled from: Taobao */
public interface LoopViewPagerBannerContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        List<BannerItem> getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void exposeBanner(android.view.View view, BannerItem bannerItem, int i);

        void itemClick(View view, BannerItem bannerItem, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void clean();

        TextView getTitle();

        void onUserVisibleHint(boolean z);

        void setData(List<XBannerBean> list, int i);
    }
}
