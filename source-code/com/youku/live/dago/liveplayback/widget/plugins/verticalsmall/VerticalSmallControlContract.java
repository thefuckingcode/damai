package com.youku.live.dago.liveplayback.widget.plugins.verticalsmall;

import android.view.ViewGroup;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public class VerticalSmallControlContract {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        void addViewGroup(ViewGroup viewGroup);

        AlixPlayerContext getPlayerContext();

        void onControlBtnClicked();

        void onDisplayBtnClicked();

        void onDlnaCtrlBtnClicked();

        void seekTo(int i);
    }

    /* compiled from: Taobao */
    interface View extends BaseView<Presenter> {
        void onDlnaPlayerPause();

        void onDlnaPlayerStart();

        void setCastMode(boolean z);

        void showDisplayButton(boolean z);

        void updateProgress(int i);
    }
}
