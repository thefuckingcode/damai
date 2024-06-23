package com.youku.middlewareservice.provider;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
public interface AppUpdateProvider {
    void checkUpdate(Context context);

    void startUpdateActivity(Map<String, String> map, Activity activity);
}
