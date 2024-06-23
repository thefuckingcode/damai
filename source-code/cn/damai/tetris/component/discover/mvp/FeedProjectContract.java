package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface FeedProjectContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        ProjectItemBean getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void exposeItem(android.view.View view, ProjectItemBean projectItemBean, int i);

        void itemClick(View view, ProjectItemBean projectItemBean, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(ProjectItemBean projectItemBean, int i);
    }
}
