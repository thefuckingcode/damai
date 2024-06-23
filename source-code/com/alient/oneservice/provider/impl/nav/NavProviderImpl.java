package com.alient.oneservice.provider.impl.nav;

import android.content.Context;
import cn.damai.common.nav.DMNav;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProvider;

/* compiled from: Taobao */
public final class NavProviderImpl implements NavProvider {
    @Override // com.alient.oneservice.nav.NavProvider
    public void toUri(Context context, Action action) {
        if (action != null) {
            if (action.getActionType() == 1 || action.getActionType() == 2) {
                DMNav.from(context).withExtras(action.getExtra()).toUri(action.getActionUrl());
            }
        }
    }
}
