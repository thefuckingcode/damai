package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.ThemeBannerBean;
import cn.damai.commonbusiness.discover.bean.ThemeBannerWrapBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
interface ThemeBannerContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        ThemeBannerWrapBean getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void exposeItem(android.view.View view, ThemeBannerBean themeBannerBean, int i);

        void itemClick(ThemeBannerBean themeBannerBean, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(ThemeBannerWrapBean themeBannerWrapBean, int i);
    }
}
