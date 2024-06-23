package com.taobao.accs;

import android.content.Context;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import tb.ss0;

/* compiled from: Taobao */
public class AccsIPCProvider extends ARangerProvider {
    @Override // com.taobao.aranger.core.ipc.provider.ARangerProvider
    public boolean onCreate() {
        Context context = getContext();
        GlobalClientInfo.mContext = context;
        UtilityImpl.debug(context);
        if (OrangeAdapter.isChannelModeEnable()) {
            ss0.k(false);
        }
        return super.onCreate();
    }
}
