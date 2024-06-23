package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public interface TopTipContract {

    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        boolean isSmallScreen();
    }

    /* compiled from: Taobao */
    public interface View extends BaseView<Presenter> {
        void enableTipBg(boolean z);

        void hideTopTip();

        void hideTopTipQuickly();

        void setLayout(boolean z);

        void showTopTip(TopTipInfo topTipInfo);
    }
}
