package cn.damai.tetris.gaiax;

import android.view.View;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.gaiax.GaiaXPresenter;

/* compiled from: Taobao */
public interface GaiaXView<P extends GaiaXPresenter> extends IView<P> {
    View getContainer();

    View getGaiaXContainer();
}
