package com.youku.live.dago.liveplayback.widget.plugins.verticalfull;

import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.alixplugin.view.BaseView;

/* compiled from: Taobao */
public class VerticalFullControlContract {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class LayoutParams {
        public int mBtnBottom;
        public int mBtnHeight;
        public int mBtnLeft;
        public int mBtnWidth;
        public int mSeekbarBottom;
        public int mSeekbarLeft;
        public int mSeekbarWidth;

        LayoutParams() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Presenter extends BasePresenter {
        AlixPlayerContext getPlayerContext();

        void onControlBtnClicked();

        void seekTo(int i);
    }

    /* compiled from: Taobao */
    interface View extends BaseView<Presenter> {
        void updateLayoutParams(LayoutParams layoutParams);

        void updateProgress(int i);
    }
}
