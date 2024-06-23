package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public class HBRContract {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        void doClickHdrInstructionClose();

        void hideQualityView();

        void openHBR();

        void setOrientation(String str);

        void showHBRChangedTips();
    }

    /* compiled from: Taobao */
    interface View extends BaseView<Presenter> {
    }
}
