package com.taobao.weex;

import android.view.View;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
public interface ComponentObserver {
    void onCreate(WXComponent wXComponent);

    void onPreDestory(WXComponent wXComponent);

    void onViewCreated(WXComponent wXComponent, View view);
}
