package com.ali.user.open.ucc.icbu;

import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
public class IcbuUccServiceProviderImpl extends BaseUccServiceProvider {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    public boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return false;
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider, com.ali.user.open.ucc.base.BaseUccServiceProvider
    public void refreshWhenLogin(String str, String str2, boolean z) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).refreshWhenLogin(Site.ICBU, str2, z);
    }
}
