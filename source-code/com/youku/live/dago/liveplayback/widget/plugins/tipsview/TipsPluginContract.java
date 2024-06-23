package com.youku.live.dago.liveplayback.widget.plugins.tipsview;

import android.widget.FrameLayout;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public interface TipsPluginContract {

    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        AlixPlayerContext getPlayContext();
    }

    /* compiled from: Taobao */
    public interface TipsPluginView extends BaseView<Presenter> {
        FrameLayout getHolderView();
    }
}
