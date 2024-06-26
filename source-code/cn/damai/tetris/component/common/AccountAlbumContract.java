package cn.damai.tetris.component.common;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.common.bean.AccountBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;

/* compiled from: Taobao */
public interface AccountAlbumContract {
    public static final String CID = "dm_brand_ip_artist";

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        List<AccountBean> getAccounts();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        RecyclerView getRecycleView();

        TextView getTitle();
    }
}
