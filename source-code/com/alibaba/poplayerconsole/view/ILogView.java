package com.alibaba.poplayerconsole.view;

import android.view.View;
import com.alibaba.poplayerconsole.lib.Window;

/* compiled from: Taobao */
public interface ILogView {
    void destoryView();

    String getTitle();

    View getView();

    void update(Window window) throws Throwable;
}
