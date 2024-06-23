package com.ali.user.open.ucc.netease;

import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
public class NeteaseUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "AlipayUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void cleanUp(Context context) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, Site.NETEASE);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    public boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return true;
    }
}
