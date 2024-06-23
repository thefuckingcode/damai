package com.youku.asyncview;

import android.app.Activity;
import android.view.View;
import com.youku.asyncview.core.IMemoryManager;
import java.util.List;

/* compiled from: Taobao */
public interface IAsyncViewManager extends IMemoryManager {
    View getAsyncView(int i, String str);

    ViewContext getViewContext();

    void preLoadAsyncView(List<AsyncViewSetting> list);

    void refreshCurrentActivity(Activity activity);

    void setAsyncViewSetting(AsyncViewSetting asyncViewSetting);

    void setDebug(boolean z);
}
