package com.taobao.weex.appfram.navigator;

import android.app.Activity;

/* compiled from: Taobao */
public interface INavigator {
    boolean pop(Activity activity, String str);

    boolean push(Activity activity, String str);
}
