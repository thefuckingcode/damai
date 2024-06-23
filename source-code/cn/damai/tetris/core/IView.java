package cn.damai.tetris.core;

import android.view.View;
import cn.damai.tetris.core.IPresenter;
import java.io.Serializable;
import tb.gg2;

/* compiled from: Taobao */
public interface IView<P extends IPresenter> extends Serializable {
    View getRootView();

    void setPresenter(P p);

    void setStyle(gg2 gg2);
}
