package com.youku.live.dago.liveplayback.widget.plugins.quality;

import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public class ChangeQualityContract {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        void changeQuality(int i);

        void onHide();

        void refreshDefinitionData();

        void showQualityInfo(android.view.View view);
    }

    /* compiled from: Taobao */
    interface View extends BaseView<Presenter> {
    }
}
