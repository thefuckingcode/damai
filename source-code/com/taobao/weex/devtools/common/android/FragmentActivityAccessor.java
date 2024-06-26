package com.taobao.weex.devtools.common.android;

import android.app.Activity;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public interface FragmentActivityAccessor<FRAGMENT_ACTIVITY extends Activity, FRAGMENT_MANAGER> {
    @Nullable
    FRAGMENT_MANAGER getFragmentManager(FRAGMENT_ACTIVITY fragment_activity);
}
