package com.youku.alixplugin.view;

import android.view.View;
import com.youku.alixplugin.view.BasePresenter;
import com.youku.kubus.NoProguard;

@NoProguard
/* compiled from: Taobao */
public interface BaseView<P extends BasePresenter> {
    View getView();

    void hide();

    void inflate();

    boolean isInflated();

    void setPresenter(P p);

    void show();
}
