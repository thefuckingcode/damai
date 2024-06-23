package com.youku.live.widgets.protocol;

import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener;
import com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener;

@Deprecated
/* compiled from: Taobao */
public interface ISystemEvent extends IActivityBackPressedListener, IActivityConfigurationChangedListener, IActivityLowMemoryListener, IActivityRequestPermissionsResultListener, IActivityResultListener, IActivityResumeStateChangedListener, IActivityStartStateChangedListener {
    void onActivityDestroy();

    @Deprecated
    boolean systemEventFilter();
}
