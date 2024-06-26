package cn.damai.tetris.component.ip;

import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.tetris.component.ip.bean.IPInfoBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.uikit.view.ScoreStarViewV2;

/* compiled from: Taobao */
public interface IpInfoContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        IPInfoBean getIpInfo();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        android.view.View getHaveSeen();

        TextView getIpDesc();

        ImageView getIpImg();

        TextView getIpName();

        TextView getIpScore();

        TextView getIpScoreDesc();

        TextView getIpUv();

        ScoreStarViewV2 getRatingBar();

        android.view.View getScoreTip();

        TextView getUserComment();

        ImageView getUserImg();

        android.view.View getWannaSee();
    }
}
